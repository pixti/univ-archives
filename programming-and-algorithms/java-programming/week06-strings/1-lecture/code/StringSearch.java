/**
 * [6-1] String 클래스 - 문자열 검색 (startsWith · endsWith · indexOf · lastIndexOf)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
