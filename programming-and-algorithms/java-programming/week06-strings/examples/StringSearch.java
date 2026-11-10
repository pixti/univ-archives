/**
 * [6-1] String 클래스 - 문자열 검색 (startsWith · endsWith · indexOf · lastIndexOf)
 *
 * 포인트
 *  - startsWith / endsWith : 특정 문자열로 시작 / 끝나는지 → true, false 반환
 *  - indexOf(x)            : x 가 처음 나오는 위치 (없으면 -1)
 *  - indexOf(x, from)      : from 위치부터 찾기 시작
 *  - lastIndexOf(x)        : x 가 마지막으로 나오는 위치 (없으면 -1)
 *
 * 💡 "abcisabcisabc"
 *      인덱스  0 1 2 3 4 5 6 7 8 9 10 11 12
 *      문자    a b c i s a b c i s a  b  c
 *    indexOf("abc") = 0, indexOf('i') = 3, indexOf('i', 4) = 8 (4번부터 찾으니 3번 i 는 건너뜀),
 *    lastIndexOf("abc") = 10, lastIndexOf('z') = -1
 *
 * ⚠ 슬라이드의 If (string1.startsWith(＂st“)) 는 If 가 대문자(자바 키워드는 소문자 if)이고
 *    따옴표가 전각/스마트 따옴표(＂ “)라 컴파일되지 않는다. 여기서는 실행 가능하게 고쳤다.
 *    ‘i’, ‘z’ 도 일반 작은따옴표로 수정.
 *
 * 실행 결과
 *  string1 = started
 *  st 로 시작한다
 *  ed 로 끝난다
 *  0
 *  3
 *  8
 *  10
 *  -1
 */
public class StringSearch {
    public static void main(String[] args) {
        // 특정 문자열 시작, 끝나는지 검사, 반환은 true false
        String string1 = "started";
        System.out.println("string1 = " + string1);
        if (string1.startsWith("st")) System.out.println("st 로 시작한다");
        if (string1.endsWith("ed"))   System.out.println("ed 로 끝난다");

        // 특정 문자열 위치 검사
        String str1 = "abcisabcisabc";
        System.out.println(str1.indexOf("abc"));      // 0
        System.out.println(str1.indexOf('i'));        // 3
        System.out.println(str1.indexOf('i', 4));     // 8
        System.out.println(str1.lastIndexOf("abc"));  // 10
        System.out.println(str1.lastIndexOf('z'));    // -1 , 문자열 X
    }
}
