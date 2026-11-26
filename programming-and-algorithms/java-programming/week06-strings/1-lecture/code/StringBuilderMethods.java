/**
 * [6-3] StringBuilder 클래스 - 주요 메소드
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
