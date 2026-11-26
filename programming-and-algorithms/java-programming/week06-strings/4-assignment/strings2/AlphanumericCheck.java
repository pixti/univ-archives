/**
 * [6강 과제] 문자열(2) - 1번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class AlphanumericCheck {
    public static void main(String[] args) {
        String[] strs = { "ABCDEFabcdef123450", "SQL", "Java", "*&%@#!}{", "w3resource.com" };
        String regex = "[a-zA-Z0-9]+";

        for (String s : strs) {
            System.out.println(s + " : " + s.matches(regex));
        }
    }
}
