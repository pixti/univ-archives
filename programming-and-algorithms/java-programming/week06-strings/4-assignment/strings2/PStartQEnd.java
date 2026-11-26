/**
 * [6강 과제] 문자열(2) - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class PStartQEnd {
    public static void main(String[] args) {
        String[] strs = { "phkuyrt", "pq", "pccddbbjjjq", "Jar", "pjhut" };
        String regex = "^p.*q$";

        for (String s : strs) {
            if (s.matches(regex)) {
                System.out.println("Found a match!");
            } else {
                System.out.println("Not matched!");
            }
        }
    }
}
