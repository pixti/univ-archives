import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [6강 실습] 문자열(1) - 3번 문제를 풀면서 해 본 정규식 실험 (matches · replaceAll · Pattern/Matcher find)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class RegexCatDog {
    public static void main(String[] args) {
        String str = "one cat two cat three cat";

        System.out.println(str.matches("c.t"));            // false : 전체가 c.t 가 아님
        System.out.println(str.matches(".*c.t.*"));        // true  : 💡 앞뒤에 .* → "포함" 검사
        System.out.println(str.replaceAll("c.t", "dog"));  // one dog two dog three dog

        Pattern p = Pattern.compile("c.t");

        // ---- 첫 번째 버전 : find() 를 직접 세 번 호출 ----
        System.out.println("---- find() 세 번 직접 호출 ----");
        Matcher m = p.matcher(str);
        m.find();
        System.out.println(m.start() + "~" + (m.end() - 1));
        m.find();
        System.out.println(m.start() + "~" + (m.end() - 1));
        m.find();
        System.out.println(m.start() + "~" + (m.end() - 1));

        // ---- 두 번째 버전 : while 반복문 ----
        System.out.println("---- while (m.find()) ----");
        m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.start() + "~" + (m.end() - 1));
        }
    }
}
