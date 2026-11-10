import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [6강 과제] 문자열(2) - 4번 문제
 *
 * 문자열에 들어 있는 모음(a, e, i, o, u - 대소문자 모두) 의 개수를 세시오.
 *      "C++"             → 0
 *      "Java"            → 2
 *      "MID-CENTRALIZED" → 5
 *      "LOWERED"         → 3
 *
 * 포인트
 *  - Pattern.compile("[aeiouAEIOU]") : 모음 한 글자
 *  - while (m.find()) count++;        : 찾을 때마다 1 증가 → 일치한 개수
 *
 * 📝 필기 (AI 설명) 왜 이 문제에서만 import 가 필요한가?
 *  - String 클래스에는 "정규식에 일치하는 개수를 세는" 메소드가 없다.
 *    → find() 를 반복할 수 있는 Pattern / Matcher 가 필요한데, 이 클래스들은 java.lang 이 아니라
 *      java.util.regex 패키지에 있어서 import 해야 한다.
 *  - 1~3번은 String 의 matches / split / replaceAll 만 썼는데, String 은 java.lang 패키지라
 *    자동으로 import 되므로 import 문이 필요 없었다.
 *
 *      구분        String 메소드 (matches, split, replaceAll)   Pattern / Matcher
 *      import      필요 없음 (java.lang)                         필요 (java.util.regex)
 *      용도        전체 일치 검사, 자르기, 치환                  find / group 반복 → 개수 · 위치 찾기
 *      성능        호출할 때마다 정규식을 새로 컴파일            한 번 compile 한 패턴을 재사용 → 반복 검사에 유리
 *
 * 📝 필기 (AI 팁) import 없이 세는 방법
 *  - 모음이 "아닌" 문자를 모두 지운 뒤 남은 길이를 재면 된다.
 *      str.replaceAll("[^aeiouAEIOU]", "").length()
 *      "MID-CENTRALIZED" → "IEAIE" → 5
 *
 * 실행 결과
 *  Original string: C++
 *  New string: 0
 *  Original string: Java
 *  New string: 2
 *  Original string: MID-CENTRALIZED
 *  New string: 5
 *  Original string: LOWERED
 *  New string: 3
 *  ---- replaceAll 로 세기 (import 없이) ----
 *  C++ : 0
 *  Java : 2
 *  MID-CENTRALIZED : 5
 *  LOWERED : 3
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

        // 📝 AI 팁 : 모음이 아닌 문자를 지우고 길이 재기
        System.out.println("---- replaceAll 로 세기 (import 없이) ----");
        for (String s : strs) {
            System.out.println(s + " : " + s.replaceAll("[^aeiouAEIOU]", "").length());
        }
    }
}
