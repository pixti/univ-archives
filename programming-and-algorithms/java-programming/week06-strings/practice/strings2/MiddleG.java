import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [6강 실습] 문자열(2) - 2번 문제
 *
 * 단어의 시작이나 끝이 아닌 곳(단어 가운데)에 'g' 가 들어 있는 단어가 있는지 찾으시오.
 *      "The quick brown fox jumps over the lazy dog."  → Not matched!
 *      "Java Exercises."                               → Not matched!
 *      "Programming Language"                          → Found a match!
 *      "Do humans eat gizzards?"                       → Not matched!
 *      "PostgreSQL"                                    → Found a match!
 *
 * 포인트 (실습 자료의 정규식 설명 - 위치 앵커)
 *  - \b : 단어 경계 (word boundary). 단어 문자(\w)와 단어가 아닌 문자 사이의 "위치"
 *  - \B : 단어 경계가 "아닌" 위치 = 단어 안쪽
 *  - \Bg\B : g 의 앞도 단어 안쪽, 뒤도 단어 안쪽 → 단어 "가운데" 의 g
 *
 * 📝 필기 (AI 설명) 문장별 결과
 *      문장                          g 의 위치                       \Bg\B   \Bg\b
 *      ... lazy dog.                 dog 의 끝                        No      Yes
 *      Java Exercises.               g 없음                           No      No
 *      Programming Language          가운데 + Programming 의 끝       Yes     Yes
 *      Do humans eat gizzards?       gizzards 의 시작                 No      No
 *      PostgreSQL                    가운데                           Yes     No
 *
 *    패턴 정리
 *      \Bg\B  가운데의 g   (PostgreSQL, Language)
 *      \Bg\b  끝의 g       (dog, Programming)
 *      \bg\B  시작의 g     (gizzards)
 *
 *  - Matcher 의 find() 는 "부분" 을 찾기 때문에 String.matches 처럼 앞뒤에 .* 를 붙일 필요가 없다.
 *    (String.matches 로 하려면 ".*\\Bg\\B.*")
 *
 * 📝 필기 "\\Bg\\b" 로도 실행해 봄 → Yes No Yes No No  (단어 끝의 g 를 찾는 패턴이 됨)
 *
 * 💡 "Programming Language" 에는 가운데 g 가 여러 개(Pro[g]ramming, Lan[g]ua[g]e) 있지만,
 *    find() 는 하나라도 찾으면 true 이므로 if (m.find()) 한 번으로 판정하면 된다.
 *
 * 실행 결과
 *  ---- \Bg\B (가운데 g) ----
 *  Not matched!
 *  Not matched!
 *  Found a match!
 *  Not matched!
 *  Found a match!
 *  ---- \Bg\b (끝 g) ----
 *  Yes
 *  No
 *  Yes
 *  No
 *  No
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
                System.out.println("Found a match!");   // 내 코드 : Yes
            } else {
                System.out.println("Not matched!");     // 내 코드 : No
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
