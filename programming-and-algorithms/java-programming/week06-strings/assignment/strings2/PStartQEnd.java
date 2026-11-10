/**
 * [6강 과제] 문자열(2) - 2번 문제
 *
 * 'p' 로 시작하고 'q' 로 끝나는 문자열을 찾으시오. (가운데는 아무 문자나 0개 이상)
 *      "phkuyrt"     → Not matched!
 *      "pq"          → Found a match!
 *      "pccddbbjjjq" → Found a match!
 *      "Jar"         → Not matched!
 *      "pjhut"       → Not matched!
 *
 * 포인트
 *  - ^p.*q$
 *      ^p    p 로 시작
 *      .*    아무 문자(.) 가 0개 이상(*)  → "pq" 처럼 가운데가 비어 있어도 OK
 *      q$    q 로 끝
 *
 * 💡 .* 대신 .+ 를 쓰면 가운데에 1글자 이상 있어야 해서 "pq" 가 Not matched! 가 된다.
 * 💡 정규식 없이 : s.startsWith("p") && s.endsWith("q")  (단, "p" 한 글자는 따로 생각해야 함)
 *
 * 실행 결과
 *  Not matched!
 *  Found a match!
 *  Found a match!
 *  Not matched!
 *  Not matched!
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
