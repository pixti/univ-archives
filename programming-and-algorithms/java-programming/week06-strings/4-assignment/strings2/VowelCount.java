import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [6강 과제] 문자열(2) - 4번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class VowelCount {
    public static void main(String[] args) {
        String[] strs = { "C++", "Java", "MID-CENTRALIZED", "LOWERED" };
        Pattern p = Pattern.compile("[aeiouAEIOU]");

        for (String s : strs) {
            Matcher m = p.matcher(s);
            int count = 0;
            while (m.find()) {
                count++;
            }
            System.out.println("Original string: " + s);
            System.out.println("New string: " + count);
        }

        // 💡 모음이 아닌 문자를 지우고 길이 재기
        System.out.println("---- replaceAll 로 세기 (import 없이) ----");
        for (String s : strs) {
            System.out.println(s + " : " + s.replaceAll("[^aeiouAEIOU]", "").length());
        }
    }
}
