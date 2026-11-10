import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [6강 실습] 문자열(1) - 3번 문제를 풀면서 해 본 정규식 실험 (matches · replaceAll · Pattern/Matcher find)
 *
 * 📝 필기 (내가 작성한 실험 코드)
 *  - 처음에는 m.find() 를 세 번 직접 호출해서 위치를 출력했고,
 *    두 번째로 while (m.find()) 반복문으로 바꿨다. → 몇 개가 있든 끝까지 찾을 수 있다.
 *
 * 📝 필기 (AI 설명)
 *  - str.matches("c.t") 가 false 인 이유
 *      matches 는 문자열 "전체" 가 패턴과 100% 일치해야 true.
 *      "c.t" 는 c + (아무 문자 1개) + t, 즉 딱 세 글자짜리 문자열만 통과한다.
 *      "one cat two cat three cat" 는 그 안에 cat 이 "포함" 되어 있을 뿐 전체가 c.t 는 아니다.
 *    → 포함 여부를 matches 로 보고 싶으면 앞뒤에 .* 를 붙인다 : str.matches(".*c.t.*")  → true
 *  - replaceAll("c.t", "dog") : 일치하는 "모든" 부분을 바꾼다. → one dog two dog three dog
 *    (처음 하나만 바꾸려면 replaceFirst)
 *  - Matcher 의 find() : 호출할 때마다 "다음" 일치 부분을 찾고, 찾으면 true / 더 없으면 false.
 *      start() : 일치 시작 인덱스, end() : 일치 끝 인덱스 + 1  → 그래서 m.end()-1 로 출력
 *
 *      o n e _ c a t _ t w o _  c  a  t  _ ...
 *      0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 *              ~~~~~               ~~~~~~~~
 *              4~6                 12~14            (세 번째 cat 은 22~24)
 *
 * 실행 결과
 *  false
 *  true
 *  one dog two dog three dog
 *  ---- find() 세 번 직접 호출 ----
 *  4~6
 *  12~14
 *  22~24
 *  ---- while (m.find()) ----
 *  4~6
 *  12~14
 *  22~24
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
