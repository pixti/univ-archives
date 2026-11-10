/**
 * [6-3] StringBuilder 클래스 - 주요 메소드
 *       (append · insert · delete · replace · reverse · substring · indexOf · charAt · setCharAt · deleteCharAt · toString)
 *
 * 포인트
 *  - append(x)          : 끝에 붙이기 (문자열, 정수, 실수 등 무엇이든). 원본 문자열이 변경됨을 주의!
 *  - insert(위치, x)    : 특정 위치에 끼워 넣기
 *  - delete(a, b)       : 인덱스 a ~ b-1 제거
 *  - replace(a, b, s)   : 인덱스 a ~ b-1 을 s 로 치환   ← String.replace(찾을문자열, 바꿀문자열) 과 사용법이 다르다!
 *  - reverse()          : 순서 뒤집기
 *  - substring(a[, b])  : 부분 문자열을 "String" 으로 반환 (sb 자체는 그대로)
 *  - indexOf(s)         : 위치 찾기
 *  - charAt(i) / setCharAt(i, c) / deleteCharAt(i) : 한 문자 읽기 / 수정 / 삭제
 *  - toString()         : String 객체로 변환
 *
 * 📝 필기 (퀴즈 8번, AI 설명) String.replace vs StringBuilder.replace
 *      구분            String.replace("llo", "love")       StringBuilder.replace(2, 5, "love")
 *      바꿀 대상 지정  찾을 "문자열"                        "인덱스 범위" (시작, 끝)
 *      원본            그대로 (새 String 반환)              원본이 직접 바뀜
 *      재대입          필요 (str = str.replace(...))         필요 없음
 *    예) String s = "Hello World";  s = s.replace("World", "Java");   → "Hello Java"
 *        StringBuilder sb = new StringBuilder("Hello World"); sb.replace(0, 5, "Hi");  → "Hi World"
 *
 * 💡 sb.delete(4, 7) 의 그림
 *      Tutorials →  T u t o [r i a] l s   인덱스 4,5,6 제거  →  Tutols
 *
 * ⚠ 슬라이드의 “Love”, “I Leve You.!”, ‘o’ 는 스마트 따옴표라 일반 따옴표로 수정.
 *    또 슬라이드는 String s 를 두 번 선언해서 그대로는 컴파일되지 않는다. s1, s2 로 나눴다.
 *
 * 실행 결과
 *  hello12333.333
 *  Tutorials
 *  Tutols
 *  TuLove
 *  evoLuT
 *  LuT
 *  Lu
 *  indexOf("Leve") = 2
 *  charAt(3) = e
 *  I Love You.!
 *  I Love You.
 *  toString : I Love You. (String)
 */
public class StringBuilderMethods {
    public static void main(String[] args) {
        // ---- append : 현 문자열에 새로운 문자열을 붙임, 원본 문자열이 변경됨을 주의 ----
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append(123);
        sb.append(33.333);
        System.out.println(sb);                     // hello12333.333

        // ---- insert : 특정 위치에 문자열이나 수치형 값을 추가 ----
        StringBuilder str = new StringBuilder("Tutorial");
        str.insert(8, 's');
        System.out.println(str);                    // Tutorials

        // ---- delete / replace ----
        str.delete(4, 7);                           // 인덱스 4번부터 6번까지 제거
        System.out.println(str);                    // Tutols
        str.replace(2, 7, "Love");                  // 인덱스 2번부터 6번까지를 "Love"로 치환 (💡 끝이 길이를 넘으면 끝까지)
        System.out.println(str);                    // TuLove

        // ---- reverse / substring ----
        str.reverse();
        System.out.println(str);                    // evoLuT
        String s1 = str.substring(3);               // 인덱스 3번부터 끝까지의 문자들로 구성된 부분 문자열
        System.out.println(s1);
        String s2 = str.substring(3, 5);            // 인덱스 3번부터 4번까지의 문자들로 구성된 부분 문자열
        System.out.println(s2);

        // ---- indexOf / charAt / setCharAt / deleteCharAt ----
        StringBuilder sb2 = new StringBuilder("I Leve You.!");
        System.out.println("indexOf(\"Leve\") = " + sb2.indexOf("Leve"));
        char c = sb2.charAt(3);                     // 인덱스 3번째 위치의 문자 반환
        System.out.println("charAt(3) = " + c);
        sb2.setCharAt(3, 'o');                      // 인덱스 3번째 위치의 문자를 'o'로 변경
        System.out.println(sb2);                    // I Love You.!
        sb2.deleteCharAt(11);                       // 인덱스 11번째 위치의 문자를 제거
        System.out.println(sb2);                    // I Love You.

        // ---- toString : String 객체로 변환 ----
        String result = sb2.toString();
        System.out.println("toString : " + result + " (" + result.getClass().getSimpleName() + ")");
    }
}
