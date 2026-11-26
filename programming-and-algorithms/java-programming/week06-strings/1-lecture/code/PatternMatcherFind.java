import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [6-4] 정규식 관련 클래스 - Pattern, Matcher 클래스
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class PatternMatcherFind {
    public static void main(String[] args) {
        // ---- Pattern, Matcher 생성 ----
        System.out.println("---- \"I have a cat, but I like my dog better.\" / (cat|dog) ----");
        String input = "I have a cat, but I like my dog better.";
        Pattern p = Pattern.compile("(cat|dog)");
        Matcher m = p.matcher(input);

        System.out.println("matches   : " + m.matches());     // 전체가 cat 또는 dog 인가? → false
        System.out.println("lookingAt : " + m.lookingAt());   // 앞부분이 cat 또는 dog 인가? → false
        m.reset();                                            // 💡 matches / lookingAt 후 처음부터 다시 찾기
        while (m.find()) {
            System.out.println(m.group() + " (" + m.start() + " ~ " + (m.end() - 1) + ")");
        }

        // ---- "꽃" or "고향" or "산골" 찾아서 위치와 내용 출력 예 ----
        System.out.println("---- 꽃 · 고향 · 산골 ----");
        String input2 = "나의 살던 고향은 꽃 피는 산골 봉숭아 꽃 살구 꽃";
        Pattern p2 = Pattern.compile("(꽃|고향|산골)");
        Matcher m2 = p2.matcher(input2);
        while (m2.find()) {
            System.out.println(m2.start() + "에서 부터" + (m2.end() - 1) +
                    "까지 " + m2.group() + " 발견");
        }
    }
}
