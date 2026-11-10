/**
 * [6-1] String 클래스 - 문자열 비교 (equals · == · compareTo)
 *
 * 포인트
 *  - equals    : 두 문자열의 "구성 문자들" 이 같은지 검사 → 내용 비교
 *  - ==        : 두 변수가 "동일한 객체" 를 가리키는지 검사 → 레퍼런스(주소) 비교   ← 주의!!!
 *  - compareTo : 사전 순서 비교. 크면 양수, 같으면 0, 작으면 음수
 *
 * 📝 필기 (퀴즈 3번)
 *  - equals() : 실제 문자열 내용이 같은가?
 *  - ==       : 동일한 메모리 위치의 객체인가?
 *
 *      Str1 ──┬──▶ ["I Love You!!"]      Str2 = Str1 → 같은 객체를 공유
 *      Str2 ──┘
 *      Str3 ─────▶ ["I Love You!!"]      new String(...) → 내용만 같은 다른 객체
 *
 * 📝 필기 (퀴즈 4번, AI 설명) compareTo 의 반환값
 *  - 처음으로 다른 문자가 나온 위치에서 두 문자의 코드값(유니코드/ASCII) 차이를 돌려준다.
 *      "Apple".compareTo("Banana")      → 'A'(65) - 'B'(66) = -1
 *  - 한쪽이 다른 쪽의 앞부분(접두사)이면 길이 차이를 돌려준다.
 *      "Java".compareTo("JavaScript")   → 4 - 10 = -6
 *  - compareToIgnoreCase : 대소문자를 무시하고 비교
 *      "apple".compareTo("APPLE")             → 'a'(97) - 'A'(65) = 32
 *      "apple".compareToIgnoreCase("APPLE")   → 0
 *  - "I Love You!!" vs "I Hate You!!" : 인덱스 2 에서 처음 다름. 'L'(76) - 'H'(72) = 4 > 0 → Greater
 *    ⚠ AI 설명에는 "3번째 인덱스" 라고 되어 있었는데, 0 부터 세면 인덱스 2 (세 번째 문자) 이다.
 *
 * ⚠ 슬라이드의 == 예제는 변수를 Str1 (대문자 S) 로 선언하고 if (str1 == str2) (소문자 s) 로 써서 컴파일되지 않는다.
 *    자바는 대소문자를 구분한다. 여기서는 Str1 · Str2 · Str3 로 통일했다. (“true” 스마트 따옴표도 수정)
 *
 * 💡 왜 == 가 가끔 true 처럼 "보이는" 경우가 있을까?
 *    String a = "hi"; String b = "hi"; 처럼 리터럴로 만들면 String Constant Pool 의 같은 객체를 공유해서 a == b 가 true.
 *    하지만 new String("hi") 는 항상 새 객체다. 문자열 내용 비교는 무조건 equals 를 쓰자.
 *
 * 실행 결과
 *  ---- equals ----
 *  Returned Value = true
 *  Returned Value = true
 *  ---- == ----
 *  Str1 == Str2 : true
 *  Str1 == Str3 : false
 *  ---- compareTo ----
 *  Equal
 *  Greater
 *  Str1.compareTo(Str3) = 4
 *  "Apple".compareTo("Banana") = -1
 *  "Java".compareTo("JavaScript") = -6
 *  "apple".compareTo("APPLE") = 32
 *  "apple".compareToIgnoreCase("APPLE") = 0
 */
public class StringCompare {
    public static void main(String[] args) {
        String Str1 = new String("I Love You!!");
        String Str2 = Str1;
        String Str3 = new String("I Love You!!");

        // ---- equals : 두 문자열의 구성 문자들이 동일한지 검사 ----
        System.out.println("---- equals ----");
        boolean retVal;
        retVal = Str1.equals( Str2 );   // true
        System.out.println("Returned Value = " + retVal );

        retVal = Str1.equals( Str3 );   // true
        System.out.println("Returned Value = " + retVal );

        // ---- 주의!!! == 연산자는 동일한 객체를 지칭하는지 검사 ----
        System.out.println("---- == ----");
        System.out.println("Str1 == Str2 : " + (Str1 == Str2));   // true
        System.out.println("Str1 == Str3 : " + (Str1 == Str3));   // false
        // 문자의 구성은 같지만, 다른 객체이기 때문

        // ---- compareTo : 사전 순서상 크면 양수, 같으면 0, 작으면 음의 값 반환 ----
        System.out.println("---- compareTo ----");
        Str3 = new String("I Hate You!!");
        // Str1, Str2 같은 문자열인지 검사
        if (Str1.compareTo(Str2) == 0) System.out.println("Equal");
        else                           System.out.println("Not Equal");

        // Str1이 사전 순서상 Str3보다 큰지 작은지 검사
        if (Str1.compareTo(Str3) > 0)      System.out.println("Greater");
        else if (Str1.compareTo(Str3) < 0) System.out.println("Less");
        else                               System.out.println("Equal");

        // 💡 실제 반환값 확인 (📝 AI 설명의 예)
        System.out.println("Str1.compareTo(Str3) = " + Str1.compareTo(Str3));
        System.out.println("\"Apple\".compareTo(\"Banana\") = " + "Apple".compareTo("Banana"));
        System.out.println("\"Java\".compareTo(\"JavaScript\") = " + "Java".compareTo("JavaScript"));
        System.out.println("\"apple\".compareTo(\"APPLE\") = " + "apple".compareTo("APPLE"));
        System.out.println("\"apple\".compareToIgnoreCase(\"APPLE\") = " + "apple".compareToIgnoreCase("APPLE"));
    }
}
