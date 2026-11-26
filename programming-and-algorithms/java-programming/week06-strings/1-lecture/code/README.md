# 6주차 강의 예제 코드

[🏠 6주차 학습 가이드](../../README.md)

강의 노트([`1-lecture/`](../))에 나온 코드를 실행할 수 있는 파일로 정리했습니다. 노트를 먼저 읽고, 여기서 코드를 실행하며 결과를 확인하세요.

| 파일 | 내용 |
|---|---|
| [StringCreate.java](#string-클래스---문자열-저장하기--문자열에서-문자-다루기) | 문자열 생성 (리터럴, `new String`, char 배열로 생성) |
| [StringCompare.java](#string-클래스---문자열-비교-equals----compareto) | `equals` vs `==`, `compareTo` |
| [StringSearch.java](#string-클래스---문자열-검색-startswith--endswith--indexof--lastindexof) | `indexOf` · `lastIndexOf` · `startsWith` · `endsWith` · `contains` |
| [StringManipulation.java](#string-클래스---문자열-조작하기) | `substring` · `concat` · `replace` 계열 · `toLowerCase` · `trim` |
| [SplitTest.java](#string-클래스---문자열-분리-split) | `split` |
| [FormatTest.java](#string-클래스---문자열-포맷하기-printf--stringformat) | `printf`와 `String.format`. ⚠ 같은 변수를 두 번 선언하는 실수 |
| [IDPassword.java](#아이디와-패스워드-검사) | [실습] 아이디와 패스워드 검사 |
| [SearchReplace.java](#부분-문자열-검색-및-치환하기-string-이용----6-3-에서-같은-코드를-다시-보여준-뒤-stringbuilder-로-수정) | [실습] 부분 문자열 검색 및 치환 (`replaceFirst`) |
| [VariableSum.java](#가변-개수의-숫자-더하기) | [실습] 가변 개수의 숫자 더하기 (`split` + `Integer.parseInt`) |
| [StringBuilderCapacity.java](#stringbuilder-클래스---생성--용량-length--capacity--ensurecapacity) | `capacity` · `ensureCapacity` (용량이 늘어나는 규칙) |
| [StringBuilderMethods.java](#stringbuilder-클래스---주요-메소드) | `append` · `insert` · `delete` · `replace` · `reverse` · `substring` · `setCharAt` 등 |
| [SearchReplaceBuilder.java](#부분-문자열-바꾸기---이전-프로그램searchreplacejava-을-stringbuilder-로-수정) | [실습] StringBuilder로 검색 및 치환. 💡 찾지 못했을 때(-1) 처리 추가 |
| [RegexMatches.java](#정규식-관련-클래스---string-클래스의-matches) | `String.matches`로 전화번호 형식 검사 |
| [PatternMatcherFind.java](#정규식-관련-클래스---pattern-matcher-클래스) | `Pattern` · `Matcher`, `matches` · `lookingAt` · `find`, 꽃 · 고향 · 산골 찾기 |
| [RegularExpression.java](#정규식을-이용한-사용자-입력-값-검사) | [실습] 정규식으로 사용자 입력 값 검사. ⚠ 긴 정규식은 `+`로 이어 쓴다 |

---

## String 클래스 - 문자열 저장하기 · 문자열에서 문자 다루기

`6-1` · 📄 [`StringCreate.java`](StringCreate.java)

#### 💻 코드

<!-- code: StringCreate.java -->
```java
public class StringCreate {
    public static void main(String[] args) {
        // ---- 문자열 저장하기 ----
        String str1, str2, str3, str4;
        char [] charArray = {'I', ' ', 'L', 'o', 'v', 'e', ' ', 'Y', 'o', 'u'};
        str1 = "Hi, Byeong Man";                  // new 없이 객체 생성
        str2 = new String(str1);                  // new를 이용한 객체 생성
        // str2 = new String("Hi, Byeong Man");
        str3 = new String(charArray);             // 캐릭터 배열을 인자로 초기화
        str4 = new String(charArray, 2, 4);       // 2번 첨자부터 4의 길이만큼

        System.out.println(str1 + str2 + str3 + str4);

        // ---- toCharArray : 문자열 내의 문자들 접근 ----
        char[] t = str1.toCharArray();            // String을 문자배열로 변환
        for (int i = 0; i < t.length; i++)
            System.out.print(t[i]);
        System.out.println();

        // ---- 문자열 내의 문자 변경 : String 객체를 직접 변경할 수 없음을 주의 ----
        String str = "I lobe You";
        char[] t2 = str.toCharArray();            // 문자 배열로 변경
        t2[4] = 'v';                              // 특정 문자 변경 (인덱스 4 = 'b')
        str = new String(t2);                     // "I love You" 문자열로 변경됨 (새 객체를 str 에 다시 대입)
        System.out.println(str);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Hi, Byeong ManHi, Byeong ManI Love YouLove
Hi, Byeong Man
I love You
```

**포인트**

- String 은 레퍼런스형이지만 new 없이 "..." 로 바로 만들 수 있다.
- String 객체는 한 번 만들어지면 내용을 바꿀 수 없다 (불변, immutable).<br>내용을 바꾸고 싶으면 StringBuffer / StringBuilder 를 쓴다. (6-3)
- new String(char\[]) / new String(char\[], 시작첨자, 개수) 로 문자 배열에서 문자열을 만든다.
- toCharArray() : 문자열 → 문자 배열. 배열은 바꿀 수 있으니 바꾼 뒤 new String(t) 로 다시 문자열로.

**📝 필기 (퀴즈 1번)**

- 변수에는 객체를 지칭하는 "레퍼런스 값" 이 들어가고, 객체는 별도로 있다.
  ```text
  str1 ──▶ [Hi, Byeong Man]
  str2 ──▶ [Hi, Byeong Man]   (new String(str1) 이므로 내용만 같은 "다른 객체")
  ```
- char \[] charArray = {...}; 는 char \[] charArray = new char\[] {...}; 에서 new char\[] 가 문법적으로 생략된 것.<br>(생략은 선언과 동시에 초기화할 때만 된다. 따로 대입할 때는 new char\[] 를 써야 한다.)

- 💡 str4 = new String(charArray, 2, 4)
  ```text
    인덱스  0   1   2   3   4   5   6   7   8   9
    문자    I  ' '  L   o   v   e  ' '  Y   o   u
  2번 첨자(L)부터 "4개" → "Love"   (세 번째 인자는 끝 인덱스가 아니라 개수!)
  ```

## String 클래스 - 문자열 비교 (equals · == · compareTo)

`6-1` · 📄 [`StringCompare.java`](StringCompare.java)

#### 💻 코드

<!-- code: StringCompare.java -->
```java
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

        // 💡 실제 반환값 확인 (📝 필기의 예)
        System.out.println("Str1.compareTo(Str3) = " + Str1.compareTo(Str3));
        System.out.println("\"Apple\".compareTo(\"Banana\") = " + "Apple".compareTo("Banana"));
        System.out.println("\"Java\".compareTo(\"JavaScript\") = " + "Java".compareTo("JavaScript"));
        System.out.println("\"apple\".compareTo(\"APPLE\") = " + "apple".compareTo("APPLE"));
        System.out.println("\"apple\".compareToIgnoreCase(\"APPLE\") = " + "apple".compareToIgnoreCase("APPLE"));
    }
}
```
<!-- /code -->

#### 실행 결과

```text
---- equals ----
Returned Value = true
Returned Value = true
---- == ----
Str1 == Str2 : true
Str1 == Str3 : false
---- compareTo ----
Equal
Greater
Str1.compareTo(Str3) = 4
"Apple".compareTo("Banana") = -1
"Java".compareTo("JavaScript") = -6
"apple".compareTo("APPLE") = 32
"apple".compareToIgnoreCase("APPLE") = 0
```

**포인트**

- equals    : 두 문자열의 "구성 문자들" 이 같은지 검사 → 내용 비교
- ==        : 두 변수가 "동일한 객체" 를 가리키는지 검사 → 레퍼런스(주소) 비교   ← 주의!!!
- compareTo : 사전 순서 비교. 크면 양수, 같으면 0, 작으면 음수

**📝 필기 (퀴즈 3번)**

- equals() : 실제 문자열 내용이 같은가?
- ==       : 동일한 메모리 위치의 객체인가?

```text
Str1 ──┬──▶ ["I Love You!!"]      Str2 = Str1 → 같은 객체를 공유
Str2 ──┘
Str3 ─────▶ ["I Love You!!"]      new String(...) → 내용만 같은 다른 객체
```

- 📝 필기 (퀴즈 4번) compareTo 의 반환값
- 처음으로 다른 문자가 나온 위치에서 두 문자의 코드값(유니코드/ASCII) 차이를 돌려준다.
  ```text
  "Apple".compareTo("Banana")      → 'A'(65) - 'B'(66) = -1
  ```
- 한쪽이 다른 쪽의 앞부분(접두사)이면 길이 차이를 돌려준다.
  ```text
  "Java".compareTo("JavaScript")   → 4 - 10 = -6
  ```
- compareToIgnoreCase : 대소문자를 무시하고 비교
  ```text
  "apple".compareTo("APPLE")             → 'a'(97) - 'A'(65) = 32
  "apple".compareToIgnoreCase("APPLE")   → 0
  ```
- "I Love You!!" vs "I Hate You!!" : 인덱스 2 에서 처음 다름. 'L'(76) - 'H'(72) = 4 > 0 → Greater
  - ⚠ 자주 틀리는 부분 : "3번째 인덱스" 라고 세기 쉽지만, 0 부터 세면 인덱스 2 (세 번째 문자) 이다.

- ⚠ 자주 틀리는 부분 : 변수를 Str1 (대문자 S) 로 선언하고 if (str1 == str2) (소문자 s) 로 쓰면 컴파일되지 않는다.<br>자바는 대소문자를 구분한다. 여기서는 Str1 · Str2 · Str3 로 통일했다.

- 💡 왜 == 가 가끔 true 처럼 "보이는" 경우가 있을까?
  ```java
  String a = "hi"; String b = "hi"; 처럼 리터럴로 만들면 String Constant Pool 의 같은 객체를 공유해서 a == b 가 true.
  ```<br>하지만 new String("hi") 는 항상 새 객체다. 문자열 내용 비교는 무조건 equals 를 쓰자.

## String 클래스 - 문자열 검색 (startsWith · endsWith · indexOf · lastIndexOf)

`6-1` · 📄 [`StringSearch.java`](StringSearch.java)

#### 💻 코드

<!-- code: StringSearch.java -->
```java
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
```
<!-- /code -->

#### 실행 결과

```text
string1 = started
st 로 시작한다
ed 로 끝난다
0
3
8
10
-1
```

**포인트**

- startsWith / endsWith : 특정 문자열로 시작 / 끝나는지 → true, false 반환
- indexOf(x)            : x 가 처음 나오는 위치 (없으면 -1)
- indexOf(x, from)      : from 위치부터 찾기 시작
- lastIndexOf(x)        : x 가 마지막으로 나오는 위치 (없으면 -1)

**💡 "abcisabcisabc"**

인덱스  0 1 2 3 4 5 6 7 8 9 10 11 12

```text
문자    a b c i s a b c i s a  b  c
```

indexOf("abc") = 0, indexOf('i') = 3, indexOf('i', 4) = 8 (4번부터 찾으니 3번 i 는 건너뜀), lastIndexOf("abc") = 10, lastIndexOf('z') = -1

- ⚠ 자주 틀리는 부분 : 자바 키워드는 소문자다. If (string1.startsWith("st")) 처럼 쓰면 컴파일되지 않는다.

## String 클래스 - 문자열 조작하기

`6-1` · 📄 [`StringManipulation.java`](StringManipulation.java)

(substring · concat · replace · replaceAll · replaceFirst · toUpperCase · toLowerCase · trim)

#### 💻 코드

<!-- code: StringManipulation.java -->
```java
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
```
<!-- /code -->

#### 실행 결과

```text
str = I love Java Programming. Have a nice day.
substring(20)   : [ing. Have a nice day.]
substring(0, 6) : [I love]
concat          : [I love Java Programming. Have a nice day.abcd]
+               : [I love Java Programming. Have a nice day.abcd]
replace 후 str  : [I love Java Programming. Have a nice day.]
replace 반환값  : [I lovE Java Programming. HavE a nicE day.]
one-two-three-four-five
one-two,three:four.five
upper : I LOVE JAVA PROGRAMMING. HAVE A NICE DAY.
lower : i love java programming. have a nice day.
trim  : [this is a test ***]
ltrim : [this is a test *** ]
rtrim : [ this is a test ***]
```

**포인트**

- substring(a)    : 인덱스 a 부터 끝까지<br>substring(a, b) : 인덱스 a 부터 b-1 까지 (b 는 포함 X)
- concat("abcd") 와 + "abcd" 는 같은 결과
- replace : 치환된 결과가 "새로운 문자열" 로 만들어진다. 원본은 그대로! (주의!!!)
- replaceAll / replaceFirst : 바꿀 부분을 "정규식" 으로 쓸 수 있다. (6-4)
  ```text
  replaceAll   → 패턴과 일치하는 모든 부분
  ``` replaceFirst → 처음 일치하는 부분 하나만
- toUpperCase / toLowerCase : 원본 문자열이 바뀌는 것은 아니다. 반환값을 받아야 한다.
- trim : 앞뒤 공백 제거

- 📝 필기 (퀴즈 5번) ★) String 객체는 한번 생성하면 변경 불가능 하다.<br>str.replace(...), str.toUpperCase() 만 호출하고 str = ... 로 다시 대입하지 않으면 str 은 그대로다.

- ⚠ 자주 틀리는 부분 : trim 은 가운데 공백까지 지우지 않는다. (결과가 thisisatest\*\*\* 가 아니다, 교수님 정정 공지)<br>"trim 메서드가 중간에 있는 공백도 제거한다고 했는데, 그렇지 않습니다. 앞과 뒤에 있는 공백만 제거합니다.<br>즉, " abc def ".trim()을 실행하면 "abc def" 문자열이 반환됩니다."<br>→ " this is a test \*\*\* ".trim() 의 결과는 "this is a test \*\*\*"

- 💡 정규식 " |,|:|\\\\." : 공백 또는 , 또는 : 또는 .<br>. 은 정규식에서 "아무 문자 1개" 라는 뜻이라 진짜 마침표는 \\. 로 써야 하고, 자바 문자열 안에서 \\ 는 \\\\ 로 써야 하므로 "\\\\." 이 된다.
- 💡 "^\\\\s+" : 문자열 맨 앞(^)의 공백(\\s) 1개 이상(+) → 왼쪽 공백만 제거 (ltrim)<br>"\\\\s+$" : 문자열 맨 끝($)의 공백 1개 이상 → 오른쪽 공백만 제거 (rtrim)<br>공백 자체를 보이게 하려고 \[ ] 로 감싸서 출력했다.

## String 클래스 - 문자열 분리 (split)

`6-2` · 📄 [`SplitTest.java`](SplitTest.java)

#### 💻 코드

<!-- code: SplitTest.java -->
```java
public class SplitTest {
    public static void main(String[] args) {
        String delimStr = " ";   // 분리 문자
        String words = "minus one two,three:four.five";
        String [] split = null;

        split = words.split(delimStr);   // 분리 후 문자열 배열에 담음
        for (String s : split) System.out.println("-" + s + "-");

        // 💡 정규식으로 여러 구분자 한 번에
        System.out.println("---- \" |,|:|\\\\.\" 로 분리 ----");
        for (String s : words.split(" |,|:|\\.")) System.out.println("-" + s + "-");

        // 💡 📝 split 의 인자는 정규식
        System.out.println("---- \".\" vs \"\\\\.\" ----");
        System.out.println("\"a.b.c\".split(\".\").length   = " + "a.b.c".split(".").length);
        System.out.println("\"a.b.c\".split(\"\\\\.\").length = " + "a.b.c".split("\\.").length);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
-minus-
-one-
-two,three:four.five-
---- " |,|:|\\." 로 분리 ----
-minus-
-one-
-two-
-three-
-four-
-five-
---- "." vs "\\." ----
"a.b.c".split(".").length   = 0
"a.b.c".split("\\.").length = 3
```

**포인트**

- split(분리문자) : 분리 문자를 기준으로 문자열을 잘라 String 배열로 돌려준다.
- 분리 문자가 " " (공백 하나) 이므로 , : . 는 분리 기준이 아니다.<br>→ "two,three:four.five" 는 한 덩어리로 남는다.

**📝 필기 (퀴즈 6번)**

- split 의 인자는 일반 문자열이 아니라 "정규식" 이다.<br>. + \* ? | ( ) \[ ] { } ^ $ \\ 같은 특수문자로 자르려면 "\\\\." "\\\\+" 처럼 이스케이프해야 한다.
  ```text
  예) "a.b.c".split(".")   → 길이 0 인 배열 (. 이 "아무 문자" 라 전부 구분자가 됨)
      "a.b.c".split("\\.") → [a, b, c]
  ```

- 💡 6-1 의 replaceAll 예제처럼 " |,|:|\\\\." 를 쓰면 모두 잘린다. (아래 두 번째 출력)
- 💡 "-" + s + "-" 로 감싼 이유 : 잘린 조각에 공백이 붙어 있는지, 빈 문자열인지 눈으로 확인하려고.

## String 클래스 - 문자열 포맷하기 (printf · String.format)

`6-2` · 📄 [`FormatTest.java`](FormatTest.java)

#### 💻 코드

<!-- code: FormatTest.java -->
```java
public class FormatTest {
    public static void main(String[] args) {
        String depart = "컴퓨터공학";
        int max = 98, min = 72;
        double avg = 256 / 3.0;   // 85.333...

        // PrintStream 의 printf 메소드 사용
        String formatStr = "학과 %s - 최대값 : %d, 최소값 : %d, 평균 : %.1f";
        System.out.printf(formatStr, depart, max, min, avg);
        System.out.println();   // 💡 printf 는 줄바꿈을 하지 않는다 (formatStr 끝에 %n 을 붙여도 됨)

        // String 클래스의 format 메소드로 재작성
        formatStr = "학과 %s - 최대값 : %d, 최소값 : %d, 평균 : %f";
        String fs = String.format(formatStr, depart, max, min, avg);
        System.out.println(fs);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
학과 컴퓨터공학 - 최대값 : 98, 최소값 : 72, 평균 : 85.3
학과 컴퓨터공학 - 최대값 : 98, 최소값 : 72, 평균 : 85.333333
```

**포인트**

- java.io.PrintStream 클래스(System.out 의 타입)의 printf, format 으로 결과를 포맷해서 "출력" 한다.
- String 클래스의 format 은 출력하지 않고 결과를 String 객체로 "반환" 한다.<br>→ 나중에 다시 쓰거나, 파일에 저장하거나, 다른 문자열과 합칠 때 유용.

**💡 자주 쓰는 서식 지정자**

```text
%s  문자열        %d  정수        %f  실수 (기본 소수점 6자리)
%.1f 소수점 1자리  %5d 폭 5칸 오른쪽 정렬   %-5d 왼쪽 정렬   %n 줄바꿈
```

- 💡 depart, max, min, avg 의 값은 실행해 보려고 임의로 넣었다.

- ⚠ 자주 틀리는 부분 : 같은 메소드 안에서 String formatStr 을 두 번 선언하면 컴파일 에러(variable already defined)가 난다.<br>→ 두 번째는 선언 없이 formatStr = ... 로 다시 대입한다.
- ⚠ 두 번째 formatStr 은 %f 라서 평균이 소수점 6자리(85.333333)로 나온다. 첫 번째와 같게 하려면 %.1f.

## 아이디와 패스워드 검사

`6-2 실습` · 📄 [`IDPassword.java`](IDPassword.java)

아이디와 패스워드를 입력받아 등록된 값("bmkim" / "koala")과 같은지 검사한다.

#### 💻 코드

<!-- code: IDPassword.java -->
```java
import java.util.Scanner;

public class IDPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디 : ");
        String login = sc.next();
        System.out.println("패스워드 : ");
        String password = sc.next();

        login = login.trim();                 // 앞뒤 공백 제거
        password = password.trim();

        login = login.toLowerCase();          // 소문자로 변환
        password = password.toLowerCase();

        if (login.equals("bmkim")) {
            if (password.equals("koala")) {
                System.out.println("아이디 패스워드 모두 일치");
            }
            else {
                System.out.println("패스워드 불일치");
            }
        }
        else {
            System.out.println("아이디 불일치");
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
아이디 :
BmKim
패스워드 :
koala
아이디 패스워드 모두 일치
```

**포인트**

- trim()        : 앞뒤 공백 제거
- toLowerCase() : 소문자로 변환 → 대소문자를 구분하지 않고 비교 (BMKIM 도 통과)
- 문자열 내용 비교는 == 가 아니라 equals !
- 반환값을 login = login.trim(); 처럼 다시 대입해야 바뀐다. (String 은 불변)

- 💡 sc.next() 는 원래 공백을 구분자로 쓰고 앞뒤 공백을 건너뛰기 때문에 여기서 trim() 은 사실 효과가 없다.<br>nextLine() 으로 한 줄 전체를 받을 때 trim() 이 의미가 있다. (그래도 습관처럼 해 두면 안전)
- 💡 실제 서비스에서 비밀번호까지 소문자로 바꾸는 것은 좋지 않다. 비밀번호는 보통 대소문자를 구분한다.

## 부분 문자열 검색 및 치환하기 (String 이용)   ※ 6-3 에서 같은 코드를 다시 보여준 뒤 StringBuilder 로 수정

`6-2 실습` · 📄 [`SearchReplace.java`](SearchReplace.java)

문장, 찾고자 하는 단어, 바꾸고자 하는 단어를 입력받아 문장에서 처음 나오는 단어 하나를 바꾼다.

#### 💻 코드

<!-- code: SearchReplace.java -->
```java
import java.util.Scanner;

public class SearchReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문장 입력 : ");
        String statement = sc.nextLine();   // 공백 고려 nextLine

        System.out.println("찾고자 하는 단어 : ");
        String sword = sc.next();

        System.out.println("바꾸고자 하는 단어 : ");
        String rword = sc.next();

        statement = statement.replaceFirst(sword, rword);
        System.out.println(statement);
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
문장 입력 :
I love you. You love me.
찾고자 하는 단어 :
love
바꾸고자 하는 단어 :
like
I like you. You love me.
```

**포인트**

- 문장은 공백이 들어가므로 nextLine(), 단어는 next()
- replaceFirst(sword, rword) : 처음 일치하는 부분 하나만 치환 → 새 문자열을 돌려주므로 statement 에 다시 대입

- 💡 replaceFirst / replaceAll 의 첫 인자는 "정규식" 이다.<br>찾는 단어에 . ( ) + \* ? 같은 문자가 있으면 의도와 다르게 동작할 수 있다.<br>예) 문장 "1+1=2" 에서 "1+1" 을 찾으면 정규식 1+1 은 "1이 1개 이상 + 1" 이라 일치하지 않는다.<br>정규식이 아닌 "글자 그대로" 바꾸려면 replace(sword, rword) (모두 치환) 를 쓰거나 Pattern.quote(sword) 로 감싼다.

## 가변 개수의 숫자 더하기

`6-2 실습` · 📄 [`VariableSum.java`](VariableSum.java)

공백으로 구분된 숫자들을 한 줄로 입력받아 합을 구한다. 숫자 개수는 정해져 있지 않다.

#### 💻 코드

<!-- code: VariableSum.java -->
```java
import java.util.Scanner;

public class VariableSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자들을 공백으로 구분하여 입력 : ");
        String statement = sc.nextLine();

        String [] split = null;
        split = statement.split(" ");       // 💡 더 안전하게 : statement.trim().split("\\s+")
        int sum = 0;
        for (String s : split) sum += Integer.parseInt(s);
        System.out.println(sum);
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
숫자들을 공백으로 구분하여 입력 :
10 20 30 40
100
```

**포인트**

- nextLine() 으로 한 줄 전체 → split(" ") 로 숫자 문자열 배열 → Integer.parseInt 로 정수 변환 후 합산
- 개수를 몰라도 split 결과 배열의 길이만큼 for each 로 돌면 된다.

- ⚠ split(" ") 는 공백 "한 칸" 만 구분자로 쓴다. "1  2" 처럼 공백이 두 칸이면 빈 문자열 "" 이 생기고 Integer.parseInt("") 에서 NumberFormatException 이 난다. 앞에 공백이 있어도 마찬가지.<br>→ trim().split("\\\\s+") 를 쓰면 안전하다. (실습 문자열1 1번 · 과제 문자열1 1번 필기 참고)

## StringBuilder 클래스 - 생성 · 용량 (length · capacity · ensureCapacity)

`6-3` · 📄 [`StringBuilderCapacity.java`](StringBuilderCapacity.java)

#### 💻 코드

<!-- code: StringBuilderCapacity.java -->
```java
public class StringBuilderCapacity {
    public static void main(String[] args) {
        StringBuilder str1, str2, str3;
        str1 = new StringBuilder();          // 용량이 16문자인 빈 객체 생성
        str2 = new StringBuilder(10);        // 용량이 10문자인 객체 생성
        str3 = new StringBuilder("hello");   // 기본 용량 + "hello" 문자열의 크기만큼의 용량
        System.out.println("str1 capacity = " + str1.capacity()
                + ", str2 capacity = " + str2.capacity()
                + ", str3 capacity = " + str3.capacity());
        System.out.println("str3 length = " + str3.length());

        // ---- ensureCapacity : 현 용량 x2 +2 와 요구한 용량 중 큰 용량으로 재할당 ----
        StringBuilder s1 = new StringBuilder("hello");   // 21 크기의 용량
        System.out.println("Old Capacity = " + s1.capacity());
        s1.ensureCapacity(28);                           // 44 크기의 용량으로 확장됨
        System.out.println("New Capacity = " + s1.capacity());
        s1.ensureCapacity(33);                           // 44 크기의 용량 유지
        System.out.println("New Capacity = " + s1.capacity());

        StringBuilder s2 = new StringBuilder();          // 16 크기의 용량
        System.out.println("Old Capacity = " + s2.capacity());
        s2.ensureCapacity(40);                           // 40 크기의 용량으로 확장됨
        System.out.println("New Capacity = " + s2.capacity());
    }
}
```
<!-- /code -->

#### 실행 결과

```text
str1 capacity = 16, str2 capacity = 10, str3 capacity = 21
str3 length = 5
Old Capacity = 21
New Capacity = 44
New Capacity = 44
Old Capacity = 16
New Capacity = 40
```

**포인트**

- String 은 읽기 전용. replace 를 해도 "새 객체" 가 만들어져 전달된다.<br>변경 가능한 문자열 객체가 필요하면 StringBuilder 를 쓴다.
- 기본으로 16개의 문자를 저장할 수 있고, 용량을 넘으면 자동으로 확장된다.
  ```text
  new StringBuilder()        → 용량 16 인 빈 객체
  new StringBuilder(10)      → 용량 10
  new StringBuilder("hello") → 기본 용량 16 + "hello" 길이 5 = 21
  ```
- length()   : 실제로 들어 있는 문자열의 길이<br>capacity() : 현재 확보된 저장 공간의 크기
- ensureCapacity(n) : "현 용량 x 2 + 2" 와 "요구한 용량 n" 중 큰 용량으로 재할당

**📝 필기 (퀴즈 9번)**

- length 는 "물이 담긴 양", capacity 는 "컵의 크기" 로 생각하면 쉽다.
- 내부 계산식 : newCapacity = (value.length &lt;&lt; 1) + 2  (= 현재 용량 x 2 + 2)<br>이 값이 minCapacity(요구한 용량)보다 작으면 minCapacity 를 쓴다.
- 규칙 정리<br>요구 용량 &lt;= 현재 용량 → 아무것도 안 함 (그대로 유지)<br>요구 용량 >  현재 용량 → max(현재 x 2 + 2, 요구 용량)
- 21 → ensureCapacity(28) : 28 > 21 이므로 max(21x2+2 = 44, 28) = 44<br>44 → ensureCapacity(33) : 33 &lt;= 44 이므로 그대로 44<br>16 → ensureCapacity(40) : 40 > 16 이므로 max(16x2+2 = 34, 40) = 40

- 💡 &lt;&lt; 1 은 비트를 왼쪽으로 1칸 밀기 = x 2.

## StringBuilder 클래스 - 주요 메소드

`6-3` · 📄 [`StringBuilderMethods.java`](StringBuilderMethods.java)

(append · insert · delete · replace · reverse · substring · indexOf · charAt · setCharAt · deleteCharAt · toString)

#### 💻 코드

<!-- code: StringBuilderMethods.java -->
```java
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
```
<!-- /code -->

#### 실행 결과

```text
hello12333.333
Tutorials
Tutols
TuLove
evoLuT
LuT
Lu
indexOf("Leve") = 2
charAt(3) = e
I Love You.!
I Love You.
toString : I Love You. (String)
```

**포인트**

- append(x)          : 끝에 붙이기 (문자열, 정수, 실수 등 무엇이든). 원본 문자열이 변경됨을 주의!
- insert(위치, x)    : 특정 위치에 끼워 넣기
- delete(a, b)       : 인덱스 a \~ b-1 제거
- replace(a, b, s)   : 인덱스 a \~ b-1 을 s 로 치환   ← String.replace(찾을문자열, 바꿀문자열) 과 사용법이 다르다!
- reverse()          : 순서 뒤집기
- substring(a\[, b])  : 부분 문자열을 "String" 으로 반환 (sb 자체는 그대로)
- indexOf(s)         : 위치 찾기
- charAt(i) / setCharAt(i, c) / deleteCharAt(i) : 한 문자 읽기 / 수정 / 삭제
- toString()         : String 객체로 변환

- 📝 필기 (퀴즈 8번) String.replace vs StringBuilder.replace
  ```text
    구분            String.replace("llo", "love")       StringBuilder.replace(2, 5, "love")
    바꿀 대상 지정  찾을 "문자열"                        "인덱스 범위" (시작, 끝)
    원본            그대로 (새 String 반환)              원본이 직접 바뀜
    재대입          필요 (str = str.replace(...))         필요 없음
  예) String s = "Hello World";  s = s.replace("World", "Java");   → "Hello Java"
      StringBuilder sb = new StringBuilder("Hello World"); sb.replace(0, 5, "Hi");  → "Hi World"
  ```

**💡 sb.delete(4, 7) 의 그림**

```text
Tutorials →  T u t o [r i a] l s   인덱스 4,5,6 제거  →  Tutols
```

- ⚠ 자주 틀리는 부분 : 한 메소드 안에서 String s 를 두 번 선언하면 컴파일되지 않는다. 그래서 s1, s2 로 나눴다.

## 부분 문자열 바꾸기 - 이전 프로그램(SearchReplace.java) 을 StringBuilder 로 수정

`6-3 실습` · 📄 [`SearchReplaceBuilder.java`](SearchReplaceBuilder.java)

#### 💻 코드

<!-- code: SearchReplaceBuilder.java -->
```java
import java.util.Scanner;

public class SearchReplaceBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문장 입력 : ");
        StringBuilder statement = new StringBuilder(sc.nextLine());

        System.out.println("찾고자 하는 단어 : ");
        String sword = sc.next();

        System.out.println("바꾸고자 하는 단어 : ");
        String rword = sc.next();

        int start = statement.indexOf(sword);
        if (start != -1) {                               // ⚠ 추가 : 못 찾은 경우 처리
            int end = start + sword.length();
            statement.replace(start, end, rword);        // 원본 문자열이 변경됨
            System.out.println(statement);
        } else {
            System.out.println("\"" + sword + "\" 를 찾을 수 없습니다.");
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
문장 입력 :
I love you. You love me.
찾고자 하는 단어 :
love
바꾸고자 하는 단어 :
like
I like you. You love me.

(없는 단어를 입력하면)
찾고자 하는 단어 :
hate
...
"hate" 를 찾을 수 없습니다.
```

**포인트**

- new StringBuilder(sc.nextLine()) : 입력받은 문장으로 StringBuilder 생성
- indexOf(sword)            → 찾는 단어의 시작 위치
  ```text
  start + sword.length()    → 끝 위치 (끝 인덱스는 포함 X 이므로 딱 맞다)
  ```
- statement.replace(start, end, rword) : 원본 문자열이 직접 변경됨 → 재대입 필요 없음<br>(String 버전은 statement = statement.replaceFirst(...) 로 다시 대입해야 했다)

- 💡 String 버전과 달리 정규식이 아니라 "글자 그대로" 찾는다. "1+1" 같은 단어도 문제없다.

- ⚠ 자주 틀리는 부분 : 찾는 단어가 문장에 없을 때를 처리하지 않으면 예외가 난다.<br>indexOf 가 -1 을 돌려주면 replace(-1, ...) 에서 StringIndexOutOfBoundsException 이 난다.<br>아래처럼 if (start != -1) 로 검사를 추가했다.

## 정규식 관련 클래스 - String 클래스의 matches

`6-4` · 📄 [`RegexMatches.java`](RegexMatches.java)

#### 💻 코드

<!-- code: RegexMatches.java -->
```java
public class RegexMatches {
    public static void main(String[] args) {
        String regExp = "01[078]-\\d{4}-\\d{4}";
        String str = new String("010-5182-0173");
        System.out.println(str.matches(regExp));   // 부합

        str = new String("013-5182-0173");
        System.out.println(str.matches(regExp));   // 부합 X

        str = new String("010-518-0173");
        System.out.println(str.matches(regExp));   // 부합 X
    }
}
```
<!-- /code -->

#### 실행 결과

```text
true
false
false
```

**포인트**

- str.matches(정규식) : 문자열 "전체" 가 정규식과 부합되는지 → true / false
- "01\[078]-\\\\d{4}-\\\\d{4}"
  ```text
  01       글자 그대로 "01"
  [078]    0, 7, 8 중 하나        → 010, 017, 018 중 하나
  ```
    -        하이픈 그대로

```text
\\d{4}   숫자(\d) 정확히 4개
```

- 📝 필기 (퀴즈 7번) 01\[078] → 010, 017, 018 중 하나

**📝 필기 (퀴즈 7번)**

- 정규식의 \\d 를 자바 문자열 안에 쓰려면 \\ 를 한 번 더 써서 "\\\\d" 로 적어야 한다.<br>(자바 문자열에서 \\ 는 이스케이프 문자이므로)
- "013-5182-0173" : 세 번째 자리 3 이 \[078] 에 없음 → false<br>"010-518-0173"  : 가운데가 3자리라 \\d{4} 에 맞지 않음 → false

- 💡 matches 는 자동으로 전체 일치를 검사하므로 ^ 와 $ 를 붙이지 않아도 된다.<br>(Pattern / Matcher 의 find 처럼 "부분 검색" 을 할 때는 ^ $ 가 의미 있다)

## 정규식 관련 클래스 - Pattern, Matcher 클래스

`6-4` · 📄 [`PatternMatcherFind.java`](PatternMatcherFind.java)

#### 💻 코드

<!-- code: PatternMatcherFind.java -->
```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherFind {
    public static void main(String[] args) {
        // ---- Pattern, Matcher 생성 ----
        System.out.println("---- \"I have a cat, but I like my dog better.\" / (cat|dog) ----");
        String input = "I have a cat, but I like my dog better.";
        Pattern p = Pattern.compile("(cat|dog)");
        Matcher m = p.matcher(input);

        System.out.println("matches   : " + m.matches());     // 전체가 cat 또는 dog 인가? → false
        System.out.println("lookingAt : " + m.lookingAt());   // 앞부분이 cat 또는 dog 인가? → false
        m.reset();                                            // 💡 matches / lookingAt 후 처음부터 다시 찾기
        while (m.find()) {
            System.out.println(m.group() + " (" + m.start() + " ~ " + (m.end() - 1) + ")");
        }

        // ---- "꽃" or "고향" or "산골" 찾아서 위치와 내용 출력 예 ----
        System.out.println("---- 꽃 · 고향 · 산골 ----");
        String input2 = "나의 살던 고향은 꽃 피는 산골 봉숭아 꽃 살구 꽃";
        Pattern p2 = Pattern.compile("(꽃|고향|산골)");
        Matcher m2 = p2.matcher(input2);
        while (m2.find()) {
            System.out.println(m2.start() + "에서 부터" + (m2.end() - 1) +
                    "까지 " + m2.group() + " 발견");
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
---- "I have a cat, but I like my dog better." / (cat|dog) ----
matches   : false
lookingAt : false
cat (9 ~ 11)
dog (28 ~ 30)
---- 꽃 · 고향 · 산골 ----
6에서 부터7까지 고향 발견
10에서 부터10까지 꽃 발견
15에서 부터16까지 산골 발견
22에서 부터22까지 꽃 발견
27에서 부터27까지 꽃 발견
```

**포인트**

- Pattern.compile(정규식) 으로 Pattern 객체를 만든 뒤, p.matcher(입력) 으로 Matcher 객체를 만든다.
- Matcher 의 검사 메소드 (반환값은 모두 boolean)
  ```text
  matches()   : 입력 "전체" 가 패턴과 일치하는지
  ```<br>lookingAt() : 입력의 "앞부분(prefix)" 이 패턴과 일치하는지
  ```text
  find()      : 패턴과 부합되는 부분을 "계속" 찾음 (호출할 때마다 다음 것)
  ```
- 일치한 위치와 내용 : start() (시작 인덱스), end() (끝 인덱스 + 1), group() (일치한 문자열)
- (cat|dog) : cat 또는 dog.  | 는 OR

- 💡 end() 는 일치한 부분 "다음" 인덱스를 돌려준다. 그래서 마지막 글자 위치를 보여주려고 m.end()-1 로 출력한다.
- 💡 Pattern / Matcher 는 java.lang 이 아니라 java.util.regex 패키지에 있어서 import 가 필요하다.<br>(과제 문자열2 4번 📝 필기 참고)

## 정규식을 이용한 사용자 입력 값 검사

`6-4 실습` · 📄 [`RegularExpression.java`](RegularExpression.java)

사용자로부터 이름, 주소, 우편번호, 핸드폰 번호를 입력받아 유효성을 검증한다.

- 이름은 한글문자 2\~4개                  ^\[가-힣]{2,4}$
- 주소는 "…도 …시 …로 000" 형태          ^\[가-힣]{2,4}도\\s+\[가-힣]{2,4}시\\s+\[가-힣]{2,6}로\\s+\\d{2,4}$
- 우편번호는 5자리 숫자                  ^\\d\\d\\d\\d\\d$ 또는 ^\\d{5}$
- 핸드폰은 "010-xxxx-xxxx" or "011-xxxx-xxxx"   ^01\[01]-\\d{4}-\\d{4}$

#### 💻 코드

<!-- code: RegularExpression.java -->
```java
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        Pattern pattern;
        Matcher m;

        System.out.println("이름 : ");
        input = sc.next();
        pattern = Pattern.compile("^[가-힣]{2,4}$");
        m = pattern.matcher(input);
        if (!m.matches()) {
            System.out.println("이름 형식에 맞지 않습니다.");
            return;
        }

        input = sc.nextLine();   // 💡 next() 가 남긴 줄바꿈 비우기
        System.out.println("주소 : ");
        input = sc.nextLine();
        pattern = Pattern.compile("^[가-힣]{2,4}도\\s+"
                + "[가-힣]{2,4}시\\s+[가-힣]{2,6}로\\s+\\d{2,4}$");
        m = pattern.matcher(input);
        if (!m.matches()) {
            System.out.println("주소 형식에 맞지 않습니다.");
            return;
        }

        System.out.println("우편번호 : ");
        input = sc.next();
        pattern = Pattern.compile("^\\d{5}$");
        m = pattern.matcher(input);
        if (!m.matches()) {
            System.out.println("우편번호 형식에 맞지 않습니다.");
            return;
        }

        System.out.println("핸드폰 번호 : ");
        input = sc.next();
        pattern = Pattern.compile("^01[01]-\\d{4}-\\d{4}$");
        m = pattern.matcher(input);
        if (!m.matches()) {
            System.out.println("핸드폰 번호 형식에 맞지 않습니다.");
            return;
        }
        System.out.println("모든 자료를 형식에 맞게 입력하셨습니다.");
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
이름 :
김병만
주소 :
경기도 수원시 월드컵로 206
우편번호 :
16499
핸드폰 번호 :
010-1234-5678
모든 자료를 형식에 맞게 입력하셨습니다.

(주소를 "수원시 월드컵로 206" 으로 입력하면)
주소 형식에 맞지 않습니다.
```

**포인트**

- \[가-힣] : 한글 완성형 글자 '가' 부터 '힣' 까지 = 한글 한 글자
- \\s+     : 공백 1개 이상 (도 / 시 / 로 사이에 띄어쓰기)
- 형식이 틀리면 메시지를 출력하고 return 으로 main 을 바로 끝낸다.
- 📝 (퀴즈 10번) matches() 는 문자열 "전체" 가 패턴과 맞아야 true.<br>compile 은 정규식을 미리 해석(컴파일)해 두는 것이라 같은 패턴을 여러 번 쓸 때 효율적이다.

- 💡 sc.next() 뒤에 sc.nextLine() 을 한 번 호출하는 이유<br>next() 는 단어만 읽고 엔터(줄바꿈)를 버퍼에 남긴다. 바로 nextLine() 을 부르면 그 남은 줄바꿈만 읽고 끝나 버린다.<br>그래서 "input = sc.nextLine();" 으로 남은 줄바꿈을 한 번 비운 뒤, 공백이 있는 주소를 nextLine() 으로 읽는다.

- 💡 설명은 "도명·시명은 한글 3\~5개, 도로명은 3\~7개 (끝자리 포함)" 인데<br>정규식은 \[가-힣]{2,4}도 = "도" 를 빼고 2\~4개 + 도 → 합쳐서 3\~5개, \[가-힣]{2,6}로 → 3\~7개 이므로 서로 맞다.<br>(끝자리 '도' '시' '로' 를 포함해서 센 것)
- ⚠ 자주 틀리는 부분 : 정규식이 길다고 문자열 리터럴 중간에서 줄을 바꾸면 컴파일되지 않는다.<br>자바 문자열 리터럴은 줄을 넘길 수 없으므로 "..." + "..." 처럼 + 로 잇는다.

---

[🏠 6주차 학습 가이드](../../README.md)
