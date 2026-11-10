import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [6강 퀴즈] 문자열 (String · StringBuilder · 정규식)
 *
 *  1. 다음 코드의 str1 ~ str4 출력 결과를 쓰시오.                                    → q1()
 *       char[] charArray = {'I',' ','L','o','v','e',' ','Y','o','u'};
 *       str1 = "Hi, Byeong Man";  str2 = new String(str1);
 *       str3 = new String(charArray);  str4 = new String(charArray, 2, 4);
 *  2. String str = "I lobe You"; 의 b 를 v 로 바꾸는 코드를 작성하시오.               → q2()
 *  3. equals 와 == 를 사용한 두 코드의 출력 결과를 쓰시오.                            → q3()
 *  4. compareTo 를 사용한 코드의 출력 결과를 쓰시오.                                  → q4()
 *  5. 다음 코드의 출력 결과를 쓰시오. (startsWith · indexOf · substring · replace ·
 *     toUpperCase · trim · replaceAll("^\\s+", ""))                                   → q5()
 *  6. split 을 사용한 코드의 출력 결과를 쓰시오.                                      → q6()
 *  7. matches 와 정규식 "01[078]-\\d{4}-\\d{4}" 를 사용한 코드의 출력 결과를 쓰시오.  → q7()
 *  8. StringBuilder.replace 와 String.replace 코드의 출력 결과를 쓰시오.              → q8()
 *  9. StringBuilder 의 capacity / ensureCapacity 출력 결과를 쓰시오.                  → q9()
 * 10. 핸드폰 번호 형식 검사 코드의 빈칸을 채우시오.                                   → q10()
 * 11. StringBuilder 메소드를 차례로 호출한 코드의 출력 결과를 쓰시오.                 → q11()
 *
 * ⚠ 퀴즈 문제의 코드에는 스마트 따옴표(“ ”)와 오타(startWith, 정의되지 않은 변수 s, Str1/str1 대소문자)가
 *    섞여 있어 그대로는 컴파일되지 않는다. 각 메소드에 ❌ 원문 / ✅ 수정 으로 표시했다.
 *
 * 실행 결과
 *  ===== 1 =====
 *  Hi, Byeong Man
 *  Hi, Byeong Man
 *  I Love You
 *  Love
 *  ===== 2 =====
 *  I love You
 *  ===== 3 =====
 *  Returned Value = true
 *  Returned Value = true
 *  true
 *  ===== 4 =====
 *  Equal
 *  Greater
 *  ===== 5 =====
 *  false
 *  5
 *  substring(20) → java.lang.StringIndexOutOfBoundsException: Range [20, 17) out of bounds for length 17
 *  substring(2)  → [abcisabc isabc ]
 *  [  abcisabc isabc ]
 *  [  ABCISABC ISABC ]
 *  [abcisabc isabc]
 *  [abcisabc isabc ]
 *  ===== 6 =====
 *  -minus-
 *  -one-
 *  -two,three:four.five-
 *  ===== 7 =====
 *  true
 *  false
 *  false
 *  ===== 8 =====
 *  helove
 *  hello
 *  ===== 9 =====
 *  Old Capacity = 21
 *  New Capacity = 44
 *  New Capacity = 44
 *  Old Capacity = 16
 *  New Capacity = 40
 *  ===== 10 =====
 *  핸드폰 번호 ? (010-1234-5678 입력 가정)
 *  형식에 맞게 입력하셨습니다.
 *  (011-12-5678 입력 가정)
 *  핸드폰 번호 형식에 맞지 않습니다.
 *  ===== 11 =====
 *  hello33.333
 *  hello33.s333
 *  hell.s333
 *  333s.lleh
 *  s.
 *  s
 *  333o.lleh
 *  333.lleh
 */
public class StringQuiz {

    public static void main(String[] args) {
        System.out.println("===== 1 =====");  q1();
        System.out.println("===== 2 =====");  q2();
        System.out.println("===== 3 =====");  q3();
        System.out.println("===== 4 =====");  q4();
        System.out.println("===== 5 =====");  q5();
        System.out.println("===== 6 =====");  q6();
        System.out.println("===== 7 =====");  q7();
        System.out.println("===== 8 =====");  q8();
        System.out.println("===== 9 =====");  q9();
        System.out.println("===== 10 ====="); q10();
        System.out.println("===== 11 ====="); q11();
    }

    /**
     * 1. String 생성
     *
     * 📝 필기
     *  - "String str1 에 초기에는 쓰레기값이 들어있고 str1 = "" 로 지정하면 "" 의 레퍼런스값이
     *     String str1 에 쓰레기값 대신 들어가게 됨. 변수에는 지칭하는 레퍼런스 값이 들어가게 되고 객체는 별도로 있다.
     *       str1 -> [Hi, Byeong Man]
     *       str2 -> [Hi, Byeong Man]"
     *  - (AI 정정) 자바에는 C 언어 같은 "쓰레기값" 이 없다.
     *      · 지역 변수를 선언만 하고 값을 넣지 않은 채 사용하면 → 컴파일 에러 (variable might not have been initialized)
     *      · 클래스의 필드(멤버 변수) 는 → 자동으로 null 로 초기화
     *    str1 = "" 을 하면 String Constant Pool 에 있는 빈 문자열 객체의 "참조값" 이 str1 에 저장된다.
     *    변수(str1) 에는 참조값만 들어 있고, 실제 객체는 힙(Heap) 메모리에 따로 있다. ← 필기의 핵심은 맞음
     *
     *       str1 ──→ [ "Hi, Byeong Man" ]   (상수 풀)
     *       str2 ──→ [ "Hi, Byeong Man" ]   (new 로 만든 별도의 객체)
     *
     *  - 📝 char [] charArray = new char[] {'I', ' ', 'L', ...}; 에서 문법적으로 new char[] 가 생략된 것.
     *    (AI 설명) 이 생략형은 "선언과 동시에" 초기화할 때만 쓸 수 있다.
     *      char[] a = {'a', 'b'};          // ✅
     *      char[] b;  b = {'a', 'b'};      // ❌ 컴파일 에러
     *      char[] c;  c = new char[] {'a', 'b'};   // ✅ 따로 대입할 때는 new char[] 필요
     *
     *  - str4 = new String(charArray, 2, 4) : 인덱스 2 부터 "4개"  (끝 인덱스가 아니라 개수!)
     *      인덱스  0   1   2   3   4   5   6   7   8   9
     *      문자    I  ' '  L   o   v   e  ' '  Y   o   u
     *                      └─── 4개 ───┘   → "Love"
     */
    static void q1() {
        String str1, str2, str3, str4;
        char[] charArray = { 'I', ' ', 'L', 'o', 'v', 'e', ' ', 'Y', 'o', 'u' };

        str1 = "Hi, Byeong Man";
        str2 = new String(str1);
        str3 = new String(charArray);
        str4 = new String(charArray, 2, 4);

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
    }

    /**
     * 2. "I lobe You" 의 b 를 v 로 바꾸기
     *
     * 📝 필기 (내 답안)
     *      char[] t = str.toCharArray();
     *      t[4] = 'v';
     *      str = new String(t);
     *
     * 📝 필기 (AI 설명)
     *  - 문자(char) 는 작은따옴표 'v'. 큰따옴표 "v" 는 String 이라 char 배열 원소에 넣을 수 없다.
     *  - 인덱스 :  I(0) ' '(1) l(2) o(3) b(4) e(5)  → b 는 4번
     *  - String 은 불변(immutable) 이라 str.charAt(4) = 'v' 같은 직접 수정이 불가능하다.
     *    → char 배열로 꺼내서 고친 뒤, new String(t) 로 "새 문자열" 을 만들어 다시 대입한다.
     *
     * 💡 다른 방법 : str = str.replace('b', 'v');   또는   StringBuilder 의 setCharAt(4, 'v')
     */
    static void q2() {
        String str = "I lobe You";
        char[] t = str.toCharArray();
        t[4] = 'v';
        str = new String(t);
        System.out.println(str);
    }

    /**
     * 3. equals 와 ==
     *
     * 📝 필기
     *  - equals() : 실제 문자열 내용이 같은가?
     *  - ==       : 동일한 메모리 위치의 객체인가?
     *
     *  (왼쪽) equals : Str1.equals(Str2) → true,  Str1.equals(Str3) → true   (내용이 같으므로 둘 다 true)
     *  (오른쪽) ==   : Str1 == Str2 → true (같은 객체를 가리킴),  Str1 == Str3 → false (new 로 만든 다른 객체)
     *                  → if 문이 참인 첫 번째만 "true" 출력, 두 번째는 아무것도 출력하지 않음
     *
     *        Str1 ──┐
     *               ├──→ [ "I Love You!!" ]     ← Str1 == Str2 : true
     *        Str2 ──┘
     *        Str3 ─────→ [ "I Love You!!" ]     ← 내용은 같지만 다른 객체 : Str1 == Str3 false
     *
     * ⚠ 문제 코드는 String Str1 으로 선언하고 if(str1 == str2) 처럼 소문자로 비교해서 컴파일 에러.
     *    (자바는 대소문자를 구분한다) 또한 “true” 는 스마트 따옴표. 아래는 Str1 로 통일했다.
     */
    static void q3() {
        String Str1 = new String("I Love You!!");
        String Str2 = Str1;
        String Str3 = new String("I Love You!!");

        // (왼쪽) equals
        boolean retVal;
        retVal = Str1.equals(Str2);        // true
        System.out.println("Returned Value = " + retVal);
        retVal = Str1.equals(Str3);        // true
        System.out.println("Returned Value = " + retVal);

        // (오른쪽) ==
        // ❌ if(str1 == str2) System.out.println(“true”);
        // ✅
        if (Str1 == Str2) System.out.println("true");   // true
        if (Str1 == Str3) System.out.println("true");   // false → 출력 없음
        // 문자의 구성은 같지만, 다른 객체이기 때문
    }

    /**
     * 4. compareTo
     *
     * 📝 필기 (AI 설명)
     *  - a.compareTo(b) : 같으면 0, a 가 사전 순서상 뒤면 양수, 앞이면 음수
     *    → 처음으로 "다른 글자" 를 찾아 그 두 글자의 유니코드(ASCII) 값의 차이를 돌려준다.
     *      "Apple".compareTo("Banana")      → 'A'(65) - 'B'(66) = -1
     *      "Java".compareTo("JavaScript")   → 앞부분이 모두 같으면 "길이의 차이" : 4 - 10 = -6
     *      "apple".compareTo("APPLE")       → 'a'(97) - 'A'(65) = 32
     *      "apple".compareToIgnoreCase("APPLE") → 대소문자 무시 → 0
     *  - "I Love You!!" vs "I Hate You!!"
     *      인덱스  0  1  2
     *              I ' ' L     ← L(76)
     *              I ' ' H     ← H(72)     76 - 72 = 4 > 0 → Greater
     *    ⚠ AI 설명에는 "3번째 인덱스에서 차이" 라고 되어 있으나, 인덱스로는 2번 (세 번째 글자) 이다.
     */
    static void q4() {
        String Str1 = new String("I Love You!!");
        String Str2 = Str1;
        String Str3 = new String("I Hate You!!");

        if (Str1.compareTo(Str2) == 0) System.out.println("Equal");
        else                           System.out.println("Not Equal");

        if (Str1.compareTo(Str3) > 0)      System.out.println("Greater");
        else if (Str1.compareTo(Str3) < 0) System.out.println("Less");
        else                               System.out.println("Equal");
    }

    /**
     * 5. 문자열 검색 · 조작
     *
     *  ❌ 문제 코드 (그대로는 컴파일 X)
     *      String str1 = “  abcisabc isabc ”;
     *      System.out.println(str1.startWith("abc"));      ← startsWith 의 오타
     *      ...
     *      String str3 = s.replaceAll("^\\s+", "");         ← s 는 선언되지 않은 변수 → str1
     *
     *  풀이 (앞에 공백 2개, 뒤에 공백 1개)
     *      인덱스  0   1   2 3 4 5 6 7 8 9  10  11 12 13 14 15  16
     *      문자   ' ' ' '  a b c i s a b c ' '  i  s  a  b  c  ' '      길이 17
     *  - startsWith("abc")   → 맨 앞이 공백이므로 false
     *  - indexOf('i', 4)     → 인덱스 4 부터 찾음 → 5
     *  - substring(20)       → 길이(17) 보다 큰 시작 인덱스 → StringIndexOutOfBoundsException
     *      ⚠ AI 설명은 "문자열 길이가 20 이고 인덱스 19 가 공백이므로 빈 문자열" 이라고 했는데,
     *        문제의 문자열은 17글자라 실제로는 예외가 발생한다. (길이 20 이라면 "" 출력)
     *        substring(길이) 는 "" 로 허용되고, 길이보다 크면 예외.
     *    📝 필기 : 그래서 substring(2) 로 바꿔서 확인 → "abcisabc isabc "
     *  - str1.replace('a', 'A');  → 결과를 재대입하지 않았으므로 str1 은 그대로!
     *  - toUpperCase()       → "  ABCISABC ISABC "  (공백은 그대로)
     *  - trim()              → 앞뒤 공백만 제거 "abcisabc isabc"  (가운데 공백은 남는다)
     *  - replaceAll("^\\s+", "") → 맨 앞(^)의 공백(\s) 1개 이상(+) 만 제거 = ltrim → "abcisabc isabc "
     *
     * 📝 필기 ★) String 객체는 한번 생성하면 변경 불가능 하다.
     *    → replace, toUpperCase, trim 등은 모두 "새 String" 을 반환할 뿐, str1 자체는 바뀌지 않는다.
     *      바꾼 결과를 쓰려면 str1 = str1.replace('a', 'A'); 처럼 재대입해야 한다.
     *
     * 📝 필기 (AI 설명) 정규식 기호 정리
     *      .      아무 문자 1개              ^      문자열의 시작
     *      $      문자열의 끝                \d     숫자 [0-9]
     *      \D     숫자가 아닌 것             \w     영문자·숫자·_  [a-zA-Z0-9_]
     *      \s     공백 문자 (스페이스, 탭, 줄바꿈)
     *      [...]  괄호 안의 문자 중 하나     [^...] 괄호 안의 문자를 제외한 하나
     *    수량자
     *      *  0번 이상     +  1번 이상     ?  0 또는 1번
     *      {n} 정확히 n번  {n,} n번 이상   {n,m} n ~ m번
     *    자바에서 쓸 때 : 정규식 ^\d{5}$  →  Pattern.compile("^\\d{5}$")   (\ 를 두 번)
     *
     * 💡 실행 결과에서 공백이 보이도록 [ ] 로 감싸서 출력했다.
     */
    static void q5() {
        String str1 = "  abcisabc isabc ";
        // ❌ System.out.println(str1.startWith("abc"));
        System.out.println(str1.startsWith("abc"));     // ✅ false
        System.out.println(str1.indexOf('i', 4));       // 5

        try {
            System.out.println(str1.substring(20));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("substring(20) → " + e);
        }
        System.out.println("substring(2)  → [" + str1.substring(2) + "]");   // 📝 필기 : 2 로 바꿔서 확인

        str1.replace('a', 'A');                         // 재대입하지 않음 → 변화 없음
        System.out.println("[" + str1 + "]");

        String upperStr = str1.toUpperCase();
        System.out.println("[" + upperStr + "]");

        String str2 = str1.trim();
        System.out.println("[" + str2 + "]");

        // ❌ String str3 = s.replaceAll("^\\s+", "");
        String str3 = str1.replaceAll("^\\s+", "");    // ✅
        System.out.println("[" + str3 + "]");
    }

    /**
     * 6. split
     *
     *  - delimStr = " " (공백 하나) 로만 자르므로 쉼표 · 콜론 · 점은 구분자가 아니다.
     *    → "two,three:four.five" 는 한 덩어리로 남는다.
     *
     * 📝 필기 (AI 설명)
     *  - split 의 인자는 "정규식" 이다. 그래서 . + * ? | 같은 특수문자로 자르려면 \\. 처럼 이스케이프해야 한다.
     *      "a.b.c".split(".")    → 길이 0  (. 은 "모든 문자" 라서 전부 구분자가 되어 빈 문자열만 남고, 끝의 빈 문자열은 제거됨)
     *      "a.b.c".split("\\.")  → [a, b, c]
     *  - 여러 구분자로 자르려면 " |,|:|\\." 또는 "[ ,:.]"
     */
    static void q6() {
        String delimStr = " ";
        String words = "minus one two,three:four.five";
        String[] subs = words.split(delimStr);
        for (String s : subs) {
            System.out.println("-" + s + "-");
        }
    }

    /**
     * 7. matches 와 정규식
     *
     * 📝 필기  01[078] → 010, 017, 018 중 하나
     *
     * 📝 필기 (AI 설명)
     *  - "01[078]-\\d{4}-\\d{4}"
     *      01       "01" 그대로
     *      [078]    0, 7, 8 중 한 글자
     *      -        하이픈 그대로
     *      \\d{4}   숫자 4개   (자바 문자열 안에서는 \d 를 \\d 로 써야 한다)
     *  - "010-5182-0173" → true
     *    "013-5182-0173" → [078] 자리에 3 → false
     *    "010-518-0173"  → 가운데가 3자리 → false
     *  - 정규식 기초 표
     *      문자 종류  [abc] a,b,c 중 하나   [a-z] 소문자   [가-힣] 한글 한 글자   \d 숫자   \s 공백
     *      수량자     {4} 정확히 4번   +  1번 이상   *  0번 이상   \-? 하이픈이 있어도 되고 없어도 됨
     *      위치       ^01 "01" 로 시작   cat$ "cat" 으로 끝
     */
    static void q7() {
        String regExp = "01[078]-\\d{4}-\\d{4}";
        String str = new String("010-5182-0173");
        System.out.println(str.matches(regExp));
        str = new String("013-5182-0173");
        System.out.println(str.matches(regExp));
        str = new String("010-518-0173");
        System.out.println(str.matches(regExp));
    }

    /**
     * 8. StringBuilder.replace vs String.replace
     *
     *  - StringBuilder 의 replace(2, 5, "love") : 인덱스 2 ~ 4 ("llo") 를 "love" 로 → 원본이 바뀜 → helove
     *  - String 의 replace("llo", "love")       : 새 String 을 반환하지만 받지 않았음 → hello
     *
     * 📝 필기 : 재대입하지 않아서 그대로
     *
     * 📝 필기 (AI 설명) 비교표
     *      구분          String.replace            StringBuilder.replace
     *      대상 지정     찾을 문자열 ("llo")        인덱스 범위 (2, 5)
     *      원본          변하지 않음 (새 객체 반환) 직접 변경
     *      재대입        필요                       불필요
     *    예) String s = "Hello World";  s = s.replace("World", "Java");      → Hello Java
     *        StringBuilder sb = new StringBuilder("Hello World");  sb.replace(0, 5, "Hi");   → Hi World
     */
    static void q8() {
        StringBuilder str = new StringBuilder("hello");
        str.replace(2, 5, "love");
        System.out.println(str);       // helove

        String str1 = new String("hello");
        str1.replace("llo", "love");   // 재대입하지 않아서 그대로
        System.out.println(str1);      // hello
    }

    /**
     * 9. capacity / ensureCapacity
     *
     * 📝 필기 (AI 설명)
     *  - length() 는 실제 들어 있는 글자 수, capacity() 는 확보된 공간의 크기
     *  - new StringBuilder("hello") → 16 + 5 = 21
     *  - ensureCapacity(min) 의 내부 계산 : newCapacity = (value.length << 1) + 2  (현재 x 2 + 2)
     *                                       newCapacity < min 이면 min 을 사용
     *      21 → ensureCapacity(28) : 28 > 21 → max(44, 28) = 44
     *      44 → ensureCapacity(33) : 33 <= 44 → 그대로 44
     *      16 → ensureCapacity(40) : 40 > 16 → max(34, 40) = 40
     */
    static void q9() {
        StringBuilder s1 = new StringBuilder("hello");
        System.out.println("Old Capacity = " + s1.capacity());
        s1.ensureCapacity(28);
        System.out.println("New Capacity = " + s1.capacity());
        s1.ensureCapacity(33);
        System.out.println("New Capacity = " + s1.capacity());

        StringBuilder s2 = new StringBuilder();
        System.out.println("Old Capacity = " + s2.capacity());
        s2.ensureCapacity(40);
        System.out.println("New Capacity = " + s2.capacity());
    }

    /**
     * 10. 빈칸 채우기 (핸드폰 번호 형식 검사)
     *
     *      System.out.print("핸드폰 번호 ? ");
     *      input = sc.next();
     *      pattern = Pattern.compile(  ①  );        → "^01[01]-\\d{4}-\\d{4}$"
     *      Matcher m =  ②  ;                        → pattern.matcher(input)
     *      if (  ③  ) {                             → !m.matches()
     *          System.out.println("핸드폰 번호 형식에 맞지 않습니다.");
     *          return;
     *      }
     *      System.out.println("형식에 맞게 입력하셨습니다.");
     *
     * 📝 필기 (AI 설명)
     *  - 앞에서 변수를 선언하지 않았다면 Pattern pattern = Pattern.compile(...) 처럼 타입을 써야 한다.
     *  - Pattern.compile : 정규식을 미리 해석(컴파일)해 두어 같은 패턴을 여러 번 검사할 때 효율적
     *  - m.matches()     : 문자열 "전체" 가 패턴과 일치해야 true → 형식에 맞지 않을 때 !m.matches()
     *
     * 💡 퀴즈 실행 결과를 자동으로 보여주려고 Scanner 대신 두 입력을 차례로 넣어 검사했다. (check 메소드)
     */
    static void q10() {
        System.out.println("핸드폰 번호 ? (010-1234-5678 입력 가정)");
        check("010-1234-5678");
        System.out.println("(011-12-5678 입력 가정)");
        check("011-12-5678");
    }

    static void check(String input) {
        Pattern pattern = Pattern.compile("^01[01]-\\d{4}-\\d{4}$");   // ①
        Matcher m = pattern.matcher(input);                              // ②
        if (!m.matches()) {                                              // ③
            System.out.println("핸드폰 번호 형식에 맞지 않습니다.");
            return;
        }
        System.out.println("형식에 맞게 입력하셨습니다.");
    }

    /** 💡 실제로 키보드 입력을 받는 원래 형태 (main 에서는 호출하지 않음) */
    static void q10Scanner() {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.print("핸드폰 번호 ? ");
        input = sc.next();
        Pattern pattern = Pattern.compile("^01[01]-\\d{4}-\\d{4}$");
        Matcher m = pattern.matcher(input);
        if (!m.matches()) {
            System.out.println("핸드폰 번호 형식에 맞지 않습니다.");
            return;
        }
        System.out.println("형식에 맞게 입력하셨습니다.");
    }

    /**
     * 11. StringBuilder 메소드 연속 호출
     *
     *  단계별 상태 (인덱스 표시)
     *   ① append("hello"), append(33.333) → h e l l o 3 3 . 3 3 3          "hello33.333"
     *   ② insert(8, 's')                  → 인덱스 8 (세 번째 '3' 앞) 에 s → "hello33.s333"
     *          0 1 2 3 4 5 6 7 8 9 ...
     *          h e l l o 3 3 . s 3 3 3
     *   ③ delete(4, 7)                    → 인덱스 4,5,6 ("o33") 제거      → "hell.s333"
     *   ④ reverse()                       →                                  "333s.lleh"
     *   ⑤ substring(3, 5)                 → 인덱스 3,4 → "s."  (sb 는 그대로)
     *   ⑥ charAt(3)                       → 's'
     *   ⑦ setCharAt(3, 'o')               →                                  "333o.lleh"
     *   ⑧ deleteCharAt(3)                 →                                  "333.lleh"
     *
     * 📝 필기 (AI 설명) 의 번호 매기기에서 6번(charAt) 이 빠져 있었다. 위에 ⑥ 으로 보충.
     */
    static void q11() {
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append(33.333);
        System.out.println(sb);
        sb.insert(8, 's');
        System.out.println(sb);
        sb.delete(4, 7);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        String s = sb.substring(3, 5);
        System.out.println(s);
        char c = sb.charAt(3);
        System.out.println(c);
        sb.setCharAt(3, 'o');
        System.out.println(sb);
        sb.deleteCharAt(3);
        System.out.println(sb);
    }
}
