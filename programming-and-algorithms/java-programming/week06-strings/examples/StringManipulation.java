/**
 * [6-1] String 클래스 - 문자열 조작하기
 *       (substring · concat · replace · replaceAll · replaceFirst · toUpperCase · toLowerCase · trim)
 *
 * 포인트
 *  - substring(a)    : 인덱스 a 부터 끝까지
 *    substring(a, b) : 인덱스 a 부터 b-1 까지 (b 는 포함 X)
 *  - concat("abcd") 와 + "abcd" 는 같은 결과
 *  - replace : 치환된 결과가 "새로운 문자열" 로 만들어진다. 원본은 그대로! (주의!!!)
 *  - replaceAll / replaceFirst : 바꿀 부분을 "정규식" 으로 쓸 수 있다. (6-4)
 *      replaceAll   → 패턴과 일치하는 모든 부분
 *      replaceFirst → 처음 일치하는 부분 하나만
 *  - toUpperCase / toLowerCase : 원본 문자열이 바뀌는 것은 아니다. 반환값을 받아야 한다.
 *  - trim : 앞뒤 공백 제거
 *
 * 📝 필기 (퀴즈 5번) ★) String 객체는 한번 생성하면 변경 불가능 하다.
 *    str.replace(...), str.toUpperCase() 만 호출하고 str = ... 로 다시 대입하지 않으면 str 은 그대로다.
 *
 * ⚠ 슬라이드의 trim 예제 주석 // thisisatest*** 는 틀렸다. (교수님 정정 공지)
 *    "trim 메서드가 중간에 있는 공백도 제거한다고 했는데, 그렇지 않습니다. 앞과 뒤에 있는 공백만 제거합니다.
 *     즉, " abc def ".trim()을 실행하면 "abc def" 문자열이 반환됩니다."
 *    → " this is a test *** ".trim() 의 결과는 "this is a test ***"
 *
 * ⚠ 슬라이드의 ltrim / rtrim 예제는 s.replaceAll(...) 인데 s 라는 변수가 없다. 여기서는 str0 으로 고쳤다.
 *
 * 💡 정규식 " |,|:|\\." : 공백 또는 , 또는 : 또는 .
 *    . 은 정규식에서 "아무 문자 1개" 라는 뜻이라 진짜 마침표는 \. 로 써야 하고,
 *    자바 문자열 안에서 \ 는 \\ 로 써야 하므로 "\\." 이 된다.
 * 💡 "^\\s+" : 문자열 맨 앞(^)의 공백(\s) 1개 이상(+) → 왼쪽 공백만 제거 (ltrim)
 *    "\\s+$" : 문자열 맨 끝($)의 공백 1개 이상 → 오른쪽 공백만 제거 (rtrim)
 *    공백 자체를 보이게 하려고 [ ] 로 감싸서 출력했다.
 *
 * 실행 결과
 *  str = I love Java Programming. Have a nice day.
 *  substring(20)   : [ing. Have a nice day.]
 *  substring(0, 6) : [I love]
 *  concat          : [I love Java Programming. Have a nice day.abcd]
 *  +               : [I love Java Programming. Have a nice day.abcd]
 *  replace 후 str  : [I love Java Programming. Have a nice day.]
 *  replace 반환값  : [I lovE Java Programming. HavE a nicE day.]
 *  one-two-three-four-five
 *  one-two,three:four.five
 *  upper : I LOVE JAVA PROGRAMMING. HAVE A NICE DAY.
 *  lower : i love java programming. have a nice day.
 *  trim  : [this is a test ***]
 *  ltrim : [this is a test *** ]
 *  rtrim : [ this is a test ***]
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
        System.out.println("trim  : [" + str1 + "]");   // this is a test ***  (⚠ 슬라이드 주석 thisisatest*** 는 오류)
        String str3 = str0.replaceAll("^\\s+", "");     // ltrim 예제
        String str4 = str0.replaceAll("\\s+$", "");     // rtrim 예제
        System.out.println("ltrim : [" + str3 + "]");
        System.out.println("rtrim : [" + str4 + "]");
    }
}
