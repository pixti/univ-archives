/**
 * [6-1] String 클래스 - 문자열 조작하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class StringManipulation {
    public static void main(String[] args) {
        String str = "I love Java Programming. Have a nice day.";
        System.out.println("str = " + str);

        // ---- substring : 부분 문자열을 만드는 경우 ----
        System.out.println("substring(20)   : [" + str.substring(20) + "]");    // 인덱스 20부터 끝까지
        System.out.println("substring(0, 6) : [" + str.substring(0, 6) + "]");  // 인덱스 0부터 5까지

        // ---- concat : 두 문자열을 하나로 합치는 경우 ----
        System.out.println("concat          : [" + str.concat("abcd") + "]");   // str 에 "abcd" 추가
        System.out.println("+               : [" + (str + "abcd") + "]");       // concat 대신 + 연산자 사용 가능

        // ---- replace : 치환된 결과가 새로운 문자열로 만들어진다 ----
        String replaced = str.replace('e', 'E');   // 모든 소문자 e를 대문자 E로 치환
        System.out.println("replace 후 str  : [" + str + "]");        // 원본은 그대로
        System.out.println("replace 반환값  : [" + replaced + "]");

        // ---- replaceAll, replaceFirst : 대치할 부분을 문자열 패턴(정규식)으로 기술 ----
        String regExp = " |,|:|\\.";
        String words = "one two,three:four.five";
        String newStr = words.replaceAll(regExp, "-");
        System.out.println(newStr);
        System.out.println(words.replaceFirst(regExp, "-"));   // 💡 첫 번째(공백) 하나만 바뀜

        // ---- toUpperCase / toLowerCase : 원본 문자열이 바뀌는 것은 아니다 ----
        String upperStr = str.toUpperCase();
        String lowerStr = str.toLowerCase();
        System.out.println("upper : " + upperStr);
        System.out.println("lower : " + lowerStr);

        // ---- trim : 문자열 "앞뒤" 의 공백 문자들을 제거 ----
        String str0 = " this is a test *** ";
        String str1 = str0.trim();
        System.out.println("trim  : [" + str1 + "]");   // this is a test ***  (⚠ thisisatest*** 가 아니다)
        String str3 = str0.replaceAll("^\\s+", "");     // ltrim 예제
        String str4 = str0.replaceAll("\\s+$", "");     // rtrim 예제
        System.out.println("ltrim : [" + str3 + "]");
        System.out.println("rtrim : [" + str4 + "]");
    }
}
