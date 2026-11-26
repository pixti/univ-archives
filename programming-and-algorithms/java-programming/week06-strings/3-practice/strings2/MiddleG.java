import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [6강 실습] 문자열(2) - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MiddleG {
    public static void main(String[] args) {
        String[] strs = {
                "The quick brown fox jumps over the lazy dog.",
                "Java Exercises.",
                "Programming Language",
                "Do humans eat gizzards?",
                "PostgreSQL"
        };

        System.out.println("---- \\Bg\\B (가운데 g) ----");
        Pattern p = Pattern.compile("\\Bg\\B");
        for (String s : strs) {
            Matcher m = p.matcher(s);
            if (m.find()) {
                System.out.println("Found a match!");   // 처음 출력 : Yes
            } else {
                System.out.println("Not matched!");     // 처음 출력 : No
            }
        }

        // 📝 시험 삼아 바꿔 본 패턴 : 단어 끝의 g
        System.out.println("---- \\Bg\\b (끝 g) ----");
        Pattern p2 = Pattern.compile("\\Bg\\b");
        for (String s : strs) {
            System.out.println(p2.matcher(s).find() ? "Yes" : "No");
        }
    }
}
