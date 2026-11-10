# 6-1. 문자열 1: String 클래스 (생성 · 비교 · 검색 · 조작)

> 원본: `6-1 문자열1.pptx`
> 관련 코드: [`examples/StringCreate.java`](../examples/StringCreate.java), [`examples/StringCompare.java`](../examples/StringCompare.java), [`examples/StringSearch.java`](../examples/StringSearch.java), [`examples/StringManipulation.java`](../examples/StringManipulation.java), [`quiz/StringQuiz.java`](../quiz/StringQuiz.java)

---

## 1. 문자열 저장하기

- String은 **레퍼런스형**이지만, `new`로 객체를 만들지 않고 문자열을 직접 지정해서 쓸 수 있다.
- String 객체는 **생성된 뒤에 변경할 수 없다.** 변경 가능한 문자열이 필요하면 `StringBuffer`, `StringBuilder` 클래스를 쓴다. (→ 6-3)

```java
String str1, str2, str3, str4, str5;
char [] charArray = {'I', ' ', 'L', 'o', 'v', 'e', ' ', 'Y', 'o', 'u'};
str1 = "Hi, Byeong Man";                // new 없이 객체 생성
str2 = new String(str1);                // new를 이용한 객체 생성
// str2 = new String("Hi, Byeong Man");
str3 = new String(charArray);           // 캐릭터 배열을 인자로 초기화
str4 = new String(charArray, 2, 4);     // 2번 첨자부터 4의 길이만큼

System.out.println(str1 + str2 + str3 + str4);
// Hi, Byeong ManHi, Byeong ManI Love YouLove
```

```
인덱스  0   1   2   3   4   5   6   7   8   9
문자    I  ' '  L   o   v   e  ' '  Y   o   u
                └─── 4개 ───┘     → new String(charArray, 2, 4) = "Love"
```

> 참고:
> - 📝 **필기 (퀴즈 1번):** "String str1 에 초기에는 쓰레기값이 들어있고 str1 = "" 로 지정하면 ""의 레퍼런스값이 String str1에 쓰레기값 대신 들어가게 됨. 변수에는 지칭하는 레퍼런스 값이 들어가게 되고 객체는 별도로 있다. str1 -> [Hi, Byeong Man], str2 -> [Hi, Byeong Man]"
> - 📝 **AI 정정:** 자바에는 "쓰레기값"이 없다. 값을 넣지 않은 **지역 변수**를 쓰면 **컴파일 에러**가 나고, **필드**는 자동으로 `null`이 된다. `str1 = ""`을 하면 String Constant Pool에 있는 빈 문자열의 **참조값**이 저장된다. 변수에는 참조값만 있고, 객체는 힙에 따로 있다. 이 부분은 필기 내용이 맞다.
> - 📝 **필기:** `char [] charArray = {...}`는 `new char[] {...}`에서 `new char[]`가 문법적으로 생략된 것이다. (AI 설명) 이 생략형은 **선언과 동시에** 초기화할 때만 쓸 수 있다. 따로 대입할 때는 `charArray = new char[] {...}`처럼 써야 한다.
> - 💡 `new String(배열, 시작, 개수)`의 세 번째 인자는 끝 인덱스가 아니라 **개수**다. `substring(시작, 끝)`과 헷갈리기 쉽다.
> - 💡 `"Hi, Byeong Man"`처럼 리터럴로 만든 문자열은 상수 풀에 하나만 만들어져 공유된다. `new String(...)`은 매번 새 객체를 만든다. 이 차이 때문에 3절의 `==` 결과가 달라진다.
> - ⚠ 슬라이드 주석의 `"Hi, Byeong Man“`은 닫는 따옴표가 스마트 따옴표(`“`)라 그대로 붙여 넣으면 컴파일되지 않는다.

---

## 2. 문자열에서 문자 다루기

**toCharArray**: 문자열 안의 문자들에 접근할 때 쓴다.

```java
String str1 = "Hi, Byeong Man";
char[] t = str1.toCharArray();        // String을 문자배열로 변환
for (int i = 0; i < t.length; i++)
    System.out.print(t[i]);
```

**문자열 안의 문자 변경**: String 객체는 직접 변경할 수 없다는 점에 주의한다.

```java
String str = "I lobe You";
char[] t = str.toCharArray();   // 문자 배열로 변경
t[4] = 'v';                     // 특정 문자 변경
str = new String(t);            // "I love You" 문자열로 변경됨
```

> 참고:
> - 📝 **필기 (퀴즈 2번):** 위 코드 3줄이 답이다. (AI 설명) 문자는 작은따옴표(`'v'`)로 쓴다. b는 인덱스 4다. String은 불변이라 `str.charAt(4) = 'v'`처럼 직접 고칠 수 없다.
> - 💡 `charAt(i)`를 쓰면 배열로 바꾸지 않고도 i번째 문자를 **읽을** 수 있다. 하지만 바꿀 수는 없다.
> - 💡 다른 방법으로 `str.replace('b', 'v')`나 StringBuilder의 `setCharAt(4, 'v')`가 있다. (6-3)
> - ⚠ 슬라이드의 `“I lobe You”`, `‘v’`는 스마트 따옴표라 일반 따옴표로 바꿔야 컴파일된다.

---

## 3. 문자열 비교: equals vs ==

**equals**는 두 문자열의 구성 문자들이 같은지 검사한다.

```java
String Str1 = new String("I Love You!!");
String Str2 = Str1;
String Str3 = new String("I Love You!!");

boolean retVal;
retVal = Str1.equals( Str2 );   // true
retVal = Str1.equals( Str3 );   // true
```

**주의!!! `==` 연산자는 같은 객체를 가리키는지 검사한다.**

```java
if (Str1 == Str2) System.out.println("true");   // true
if (Str1 == Str3) System.out.println("true");   // false
// 문자의 구성은 같지만, 다른 객체이기 때문
```

```
Str1 ──┐
       ├──▶ [ "I Love You!!" ]     Str1 == Str2  → true
Str2 ──┘
Str3 ─────▶ [ "I Love You!!" ]     Str1 == Str3  → false (equals 는 true)
```

> 참고:
> - 📝 **필기 (퀴즈 3번):** "equals() 실제 문자열 내용이 같은가? / == 동일한 메모리 위치의 객체인가?"
> - 💡 문자열 내용을 비교할 때는 **항상 `equals`** 를 쓴다. 리터럴끼리는 상수 풀 덕분에 `==`가 우연히 true일 때가 있지만 믿으면 안 된다.
> - ⚠ 슬라이드는 `String Str1`로 선언하고 `if(str1 == str2)`처럼 **소문자**로 비교한다. 자바는 대소문자를 구분하므로 컴파일 에러가 난다. `“true”`도 스마트 따옴표다.

---

## 4. 문자열 비교: compareTo

**compareTo**는 사전 순서를 비교한다. 크면 양수, 같으면 0, 작으면 음수를 반환한다.

```java
String Str1 = new String("I Love You!!");
String Str2 = Str1;
String Str3 = new String("I Hate You!!");
// Str1, Str2 같은 문자열인지 검사
if (Str1.compareTo(Str2) == 0) System.out.println("Equal");
else                           System.out.println("Not Equal");

// Str1이 사전 순서상 Str3보다 큰지 작은지 검사
if (Str1.compareTo(Str3) > 0)      System.out.println("Greater");
else if (Str1.compareTo(Str3) < 0) System.out.println("Less");
else                               System.out.println("Equal");
// Equal
// Greater
```

> 참고:
> - 📝 **필기 (퀴즈 4번, AI 설명):** 처음으로 **다른 글자**를 찾아 두 글자의 유니코드 값 차이를 돌려준다.
>
>   | 비교 | 결과 | 이유 |
>   |---|---|---|
>   | `"I Love..."` vs `"I Hate..."` | `4` | 인덱스 2: `'L'`(76) − `'H'`(72) |
>   | `"Apple"` vs `"Banana"` | `-1` | `'A'`(65) − `'B'`(66) |
>   | `"Java"` vs `"JavaScript"` | `-6` | 앞부분이 같으면 **길이 차이** 4 − 10 |
>   | `"apple"` vs `"APPLE"` | `32` | `'a'`(97) − `'A'`(65) |
>   | `"apple".compareToIgnoreCase("APPLE")` | `0` | 대소문자 무시 |
> - ⚠ AI 설명에는 "3번째 인덱스에서 차이"라고 되어 있지만, 인덱스로는 **2번**(세 번째 글자)이다.

---

## 5. 문자열 검색: startsWith · endsWith · indexOf · lastIndexOf

- **startsWith**: 특정 문자열로 시작하는지 검사한다.
- **endsWith**: 특정 문자열로 끝나는지 검사한다. 둘 다 true/false를 반환한다.

```java
if (string1.startsWith("st")) ...
if (string1.endsWith("ed")) ...
```

- **indexOf**: 특정 문자열이 처음 나오는 위치
- **lastIndexOf**: 특정 문자열이 마지막으로 나오는 위치

```java
String str1 = "abcisabcisabc";
System.out.println(str1.indexOf("abc"));       // 0
System.out.println(str1.indexOf('i'));         // 3
System.out.println(str1.indexOf('i', 4));      // 8   ← 인덱스 4부터 찾기
System.out.println(str1.lastIndexOf("abc"));   // 10
System.out.println(str1.lastIndexOf('z'));     // -1 , 문자열 X
```

```
인덱스  0 1 2 3 4 5 6 7 8 9 10 11 12
문자    a b c i s a b c i s a  b  c
        ↑     ↑         ↑   ↑
     indexOf  indexOf  ('i',4)  lastIndexOf("abc")
     ("abc")  ('i')     = 8     = 10
```

> 참고:
> - 💡 못 찾으면 **-1**을 돌려준다. 찾은 위치를 `substring`이나 StringBuilder의 `replace`에 넘길 때는 먼저 -1인지 검사해야 한다. (6-3 SearchReplaceBuilder ⚠ 참고)
> - 💡 `contains("abc")`는 포함 여부만 true/false로 알려 준다.
> - ⚠ 슬라이드의 `If`는 대문자라서 오타다. 자바 키워드는 소문자 `if`다. 따옴표도 스마트 따옴표(`＂st“`)가 섞여 있다.

---

## 6. 문자열 조작: substring · concat

- **substring**: 부분 문자열을 만든다.

```java
str.substring(20);     // str 문자열의 인덱스 20부터 끝까지 해당하는 문자열
str.substring(0, 6);   // str 문자열의 인덱스 0부터 5까지의 부분문자열
```

- **concat**: 두 문자열을 하나로 합친다.

```java
str.concat("abcd");    // str 에 "abcd" 추가
str + "abcd";          // concat 대신 + 연산자 사용 가능
```

> 참고:
> - 💡 `substring(a, b)`에서 **끝 인덱스 b는 포함하지 않는다.** 길이는 `b - a`다.
> - 💡 시작 인덱스가 문자열 길이보다 크면 `StringIndexOutOfBoundsException`이 발생한다. `substring(길이)`는 빈 문자열 `""`을 돌려준다. (퀴즈 5번 ⚠ 참고)
> - 💡 `concat`도 원본을 바꾸지 않고 **새 문자열**을 돌려준다. 결과를 쓰려면 `str = str.concat("abcd");`처럼 다시 대입한다.

---

## 7. 문자열 조작: replace · replaceAll · replaceFirst

- **replace**는 문자열의 일부를 치환한다. **주의!!! 치환된 결과는 새로운 문자열로 만들어진다.**

```java
str.replace('e', 'E');   // 모든 소문자 e를 대문자 E로 치환
```

- `replaceAll`과 `replaceFirst`는 replace보다 강력하다.
  - 바꿀 부분 문자열을 **문자열 패턴(정규식)** 으로 적을 수 있다.
  - `replaceAll`은 패턴과 일치하는 모든 부분을, `replaceFirst`는 첫 번째 부분만 바꾼다.

```java
String regExp = " |,|:|\\.";
String words = "one two,three:four.five";
String newStr = words.replaceAll(regExp, "-");
System.out.println(newStr);   // one-two-three-four-five
```

> 참고:
> - 💡 정규식 `" |,|:|\\."`는 공백 **또는** 쉼표 **또는** 콜론 **또는** 점이라는 뜻이다. `|`는 OR이다. 정규식에서 `.`은 "아무 문자"라서 진짜 점은 `\\.`으로 쓴다. (→ 6-4)
> - 💡 `replace`도 일치하는 **모든** 부분을 바꾼다. 차이는 정규식을 쓰느냐다. 글자 그대로 바꿀 때는 `replace`가 안전하다. (실습 문자열2 3번 📝)
> - 📝 **필기 (퀴즈 5번):** "★) String 객체는 한번 생성하면 변경 불가능 하다." `str1.replace('a', 'A');`만 쓰고 다시 대입하지 않으면 str1은 그대로다.

---

## 8. 문자열 조작: toLowerCase · toUpperCase · trim

- **toLowerCase**는 소문자로, **toUpperCase**는 대문자로 바꾼다. **두 메소드 모두 원본 문자열을 바꾸지 않는다.**

```java
String upperStr = str.toUpperCase();
String lowerStr = str.toLowerCase();
```

- **trim**: 문자열 **앞뒤의** 공백 문자를 제거한다.

```java
String str0 = " this is a test *** ";
String str1 = str0.trim();
System.out.println(str1);                    // "this is a test ***"
String str3 = str0.replaceAll("^\\s+", "");  // ltrim 예제 → "this is a test *** "
String str4 = str0.replaceAll("\\s+$", "");  // rtrim 예제 → " this is a test ***"
```

> 참고:
> - ⚠ 슬라이드 주석에는 `// thisisatest***`라고 되어 있어 가운데 공백까지 지우는 것처럼 보인다. **교수님 정정** (실습 자료): "강의 내용 중 잘못 된 부분... trim 메서드... 중간에 있는 공백도 제거한다고 했는데, 그렇지 않습니다. 앞과 뒤에 있는 공백만 제거합니다. 즉, " abc def ".trim()을 실행하면 "abc def"문자열이 반환됩니다."
> - ⚠ 슬라이드의 ltrim/rtrim 예제는 정의되지 않은 변수 `s`를 쓴다. `str0`으로 바꿔야 한다. (퀴즈 5번에도 같은 오타)
> - 💡 `^\\s+`는 맨 앞(`^`)의 공백(`\s`) 1개 이상(`+`)이고, `\\s+$`는 맨 뒤(`$`)의 공백 1개 이상이다.
> - 💡 가운데 공백까지 모두 지우려면 `replaceAll("\\s", "")` 또는 `replace(" ", "")`를 쓴다. (실습 문자열1 2번 회문)
> - 💡 Java 11부터는 `strip()`, `stripLeading()`(ltrim), `stripTrailing()`(rtrim)도 있다.
