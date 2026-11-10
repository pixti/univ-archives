/**
 * [6강 과제] 문자열(2) - 3번 문제
 *
 * 숫자 5 로 시작하는 문자열인지 검사하시오.
 *      "5-2345861" → Found a match!
 *      "6-2345861" → Not matched!
 *      "6-5555861" → Not matched!   (5 가 들어 있지만 "시작" 이 아님)
 *
 * 포인트
 *  - ^5.*
 *      ^5   5 로 시작
 *      .*   그 뒤에는 아무 문자나 0개 이상 → String.matches 는 "전체 일치" 이므로 뒷부분을 .* 로 받아 줘야 한다.
 *    (".*" 없이 "^5" 만 쓰면 "5" 한 글자짜리 문자열만 true)
 *
 * 📝 필기 (AI 설명)
 *  - 정규식이 꼭 필요 없다면 s.startsWith("5") 가 더 간단하고 빠르다.
 *  - Pattern / Matcher 의 lookingAt() 을 쓰면 "앞부분만" 검사하므로 Pattern.compile("5") 로도 된다.
 *
 * 실행 결과
 *  Found a match!
 *  Not matched!
 *  Not matched!
 *  ---- startsWith("5") ----
 *  true
 *  false
 *  false
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
