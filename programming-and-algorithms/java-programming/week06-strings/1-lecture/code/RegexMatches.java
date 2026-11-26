/**
 * [6-4] 정규식 관련 클래스 - String 클래스의 matches
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class RegexMatches {
    public static void main(String[] args) {
        String regExp = "01[078]-\\d{4}-\\d{4}";
        String str = new String("010-5182-0173");
        System.out.println(str.matches(regExp));   // 부합

        str = new String("013-5182-0173");
        System.out.println(str.matches(regExp));   // 부합 X

        str = new String("010-518-0173");
        System.out.println(str.matches(regExp));   // 부합 X
    }
}
