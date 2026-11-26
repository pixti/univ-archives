/**
 * [6강 과제] 문자열(2) - 3번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class StartsWithFive {
    public static void main(String[] args) {
        String[] strs = { "5-2345861", "6-2345861", "6-5555861" };
        String regex = "^5.*";

        for (String s : strs) {
            if (s.matches(regex)) {
                System.out.println("Found a match!");
            } else {
                System.out.println("Not matched!");
            }
        }

        // 📝 정규식 없이
        System.out.println("---- startsWith(\"5\") ----");
        for (String s : strs) {
            System.out.println(s.startsWith("5"));
        }
    }
}
