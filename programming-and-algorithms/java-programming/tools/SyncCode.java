import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * README.md 안의 코드 블록을 실제 .java 파일 내용으로 다시 채운다.
 *
 * README 에는 다음과 같이 표시해 둔다.
 *
 *   <!-- code: SecondLargest.java -->          파일 전체 (맨 위의 머리말 주석은 뺌)
 *   <!-- code: ExceptionQuiz.java#q2,process --> 메소드나 클래스 (이름으로 찾음, 쉼표로 여러 개)
 *   ```java
 *   (이 사이가 자동으로 바뀐다)
 *   ```
 *   <!-- /code -->
 *
 * 사용법 (java-programming 폴더에서)
 *   java tools/SyncCode.java            → 모든 README 의 코드 블록을 갱신
 *   java tools/SyncCode.java --check    → 바뀔 곳이 있으면 목록만 출력 (파일은 그대로)
 *
 * .java 를 고친 뒤 이 도구를 실행하면 README 의 코드도 똑같이 바뀐다.
 */
public class SyncCode {

    private static final Pattern BLOCK = Pattern.compile(
            "<!-- code: ([^#\\s]+)(?:#([\\w,]+))? -->\\R```java\\R(.*?)```\\R<!-- /code -->",
            Pattern.DOTALL);

    public static void main(String[] args) throws IOException {
        boolean checkOnly = args.length > 0 && args[0].equals("--check");
        Path root = Path.of(".");
        List<Path> mds;
        try (Stream<Path> s = Files.walk(root)) {
            mds = s.filter(p -> p.toString().endsWith(".md")).sorted().toList();
        }
        int changedFiles = 0;
        int errors = 0;
        for (Path md : mds) {
            String text = Files.readString(md, StandardCharsets.UTF_8);
            Matcher m = BLOCK.matcher(text);
            StringBuilder out = new StringBuilder();
            boolean found = false;
            while (m.find()) {
                found = true;
                Path src = md.getParent().resolve(m.group(1));
                String code;
                try {
                    code = extract(Files.readString(src, StandardCharsets.UTF_8), m.group(2));
                } catch (IOException | IllegalArgumentException e) {
                    System.out.println("오류 : " + md + " → " + m.group(1) + (m.group(2) == null ? "" : "#" + m.group(2)) + " : " + e.getMessage());
                    errors++;
                    code = m.group(3).stripTrailing();
                }
                String marker = "<!-- code: " + m.group(1) + (m.group(2) == null ? "" : "#" + m.group(2)) + " -->";
                String replacement = marker + "\n```java\n" + code + "\n```\n<!-- /code -->";
                m.appendReplacement(out, Matcher.quoteReplacement(replacement));
            }
            if (!found) continue;
            m.appendTail(out);
            String result = out.toString();
            if (!result.equals(text)) {
                changedFiles++;
                System.out.println((checkOnly ? "바뀔 파일 : " : "갱신 : ") + md);
                if (!checkOnly) Files.writeString(md, result, StandardCharsets.UTF_8);
            }
        }
        System.out.println("README " + changedFiles + "개 " + (checkOnly ? "갱신 필요" : "갱신") + ", 오류 " + errors + "개");
        if (errors > 0 || (checkOnly && changedFiles > 0)) System.exit(1);
    }

    /** names 가 없으면 파일 전체(머리말 주석 제외), 있으면 그 이름(쉼표로 여러 개)의 메소드나 클래스만 꺼낸다. */
    static String extract(String src, String names) {
        src = src.replace("\r\n", "\n");
        if (names == null) {
            return stripHeader(src).strip();
        }
        StringBuilder sb = new StringBuilder();
        for (String name : names.split(",")) {
            if (sb.length() > 0) sb.append("\n\n");
            sb.append(extractOne(src, name));
        }
        return sb.toString();
    }

    static String extractOne(String src, String name) {
        String[] lines = src.split("\n", -1);
        Pattern decl = Pattern.compile(
                "^\\s*(?:@\\w+\\s+)*(?:(?:public|private|protected|static|final|abstract|default)\\s+)*"
                + "(?:(?:class|interface|enum|record)\\s+" + name + "\\b"
                + "|[\\w<>\\[\\],.? ]+\\s+" + name + "\\s*\\()");
        for (int i = 0; i < lines.length; i++) {
            if (!decl.matcher(lines[i]).find() || lines[i].trim().endsWith(";")) continue;
            int start = i;
            while (start > 0) {                       // 바로 위의 한 줄 주석, 어노테이션도 함께
                String prev = lines[start - 1].trim();
                if (prev.startsWith("//") || prev.startsWith("@") || prev.startsWith("/**") && prev.endsWith("*/")) start--;
                else break;
            }
            int end = matchBraces(lines, i);
            List<String> body = new ArrayList<>();
            for (int k = start; k <= end; k++) body.add(lines[k]);
            return dedent(body);
        }
        throw new IllegalArgumentException("'" + name + "' 을(를) 찾을 수 없음");
    }

    /** 맨 앞의 머리말 주석(첫 번째 / ** ... * /)을 뺀다. import 문은 남긴다. */
    static String stripHeader(String src) {
        int start = src.indexOf("/**");
        int firstDecl = indexOfDeclaration(src);
        if (start < 0 || (firstDecl >= 0 && start > firstDecl)) return src;
        int end = src.indexOf("*/", start);
        if (end < 0) return src;
        String before = src.substring(0, start);
        String after = src.substring(end + 2).replaceFirst("^[ \\t]*\\n", "");
        return before + after;
    }

    static int indexOfDeclaration(String src) {
        Matcher m = Pattern.compile("(?m)^(?:public\\s+|abstract\\s+|final\\s+)*(?:class|interface|enum|record)\\s").matcher(src);
        return m.find() ? m.start() : -1;
    }

    /** 선언 줄 i 에서 시작하는 { } 블록이 끝나는 줄 번호. 문자열 · 문자 · 주석 안의 괄호는 무시한다. */
    static int matchBraces(String[] lines, int i) {
        int depth = 0;
        boolean started = false;
        boolean inBlockComment = false;
        for (int k = i; k < lines.length; k++) {
            String l = lines[k];
            for (int c = 0; c < l.length(); c++) {
                char ch = l.charAt(c);
                if (inBlockComment) {
                    if (ch == '*' && c + 1 < l.length() && l.charAt(c + 1) == '/') { inBlockComment = false; c++; }
                    continue;
                }
                if (ch == '/' && c + 1 < l.length() && l.charAt(c + 1) == '/') break;
                if (ch == '/' && c + 1 < l.length() && l.charAt(c + 1) == '*') { inBlockComment = true; c++; continue; }
                if (ch == '"' || ch == '\'') {
                    char q = ch;
                    for (c++; c < l.length() && l.charAt(c) != q; c++) if (l.charAt(c) == '\\') c++;
                    continue;
                }
                if (ch == '{') { depth++; started = true; }
                if (ch == '}') { depth--; if (started && depth == 0) return k; }
            }
        }
        throw new IllegalArgumentException("괄호 짝이 맞지 않음");
    }

    static String dedent(List<String> body) {
        int min = Integer.MAX_VALUE;
        for (String l : body) {
            if (l.isBlank()) continue;
            int n = 0;
            while (n < l.length() && l.charAt(n) == ' ') n++;
            min = Math.min(min, n);
        }
        StringBuilder sb = new StringBuilder();
        for (String l : body) sb.append(l.isBlank() ? "" : l.substring(min)).append('\n');
        return sb.toString().stripTrailing();
    }
}
