# 6주차 실습 · strings2

[🏠 6주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [LowercaseUnderscore.java](#1-밑줄로-연결된-소문자-문자열-찾기) | 1. 밑줄로 연결된 소문자 문자열 찾기 (⚠ 첫 시도 ❌ / ✅) |
| [MiddleG.java](#2-단어-가운데에-g가-있는지-b--b) | 2. 단어 가운데에 g가 있는지 (`\B` · `\b`) |
| [ReplaceWords.java](#3-python--java-code--coding-바꾸기) | 3. Python → Java, code → coding 바꾸기 |
| [PinValidation.java](#4-pin-번호-검사-숫자-4--6--8자리) | 4. PIN 번호 검사 (숫자 4 · 6 · 8자리) |

---

## 1. 밑줄로 연결된 소문자 문자열 찾기

`6강 실습` · 📄 [`LowercaseUnderscore.java`](LowercaseUnderscore.java)

#### 문제

> 밑줄(\_)로 연결된 "소문자 문자열" 을 찾는 프로그램을 작성하시오.<br>"java\_exercises"  → Found a match!<br>"Java\_exercises"  → Not matched!<br>"java\_Exercises"  → Not matched!<br>"Java\_Exercises"  → Not matched!

#### 💻 코드

<!-- code: LowercaseUnderscore.java -->
```java
public class LowercaseUnderscore {
    public static void main(String[] args) {
        String[] strs = { "java_exercises", "Java_exercises", "java_Exercises", "Java_Exercises" };

        // ❌ 처음 코드 : 밑줄(_)이 정규식에 없어서 모두 실패
        System.out.println("---- [a-z]+[a-z]+ (처음 코드) ----");
        for (String s : strs) {
            System.out.println(s + " : " + (s.matches("[a-z]+[a-z]+") ? "Yes" : "No"));
        }

        // ✅ 고친 코드 : 소문자 + _ + 소문자
        System.out.println("---- ^[a-z]+_[a-z]+$ (고친 코드) ----");
        String regex = "^[a-z]+_[a-z]+$";
        for (String s : strs) {
            if (s.matches(regex)) {
                System.out.println("Found a match!");   // 처음 출력 : Yes
            } else {
                System.out.println("Not matched!");     // 처음 출력 : No
            }
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
---- [a-z]+[a-z]+ (처음 코드) ----
java_exercises : No
Java_exercises : No
java_Exercises : No
Java_Exercises : No
---- ^[a-z]+_[a-z]+$ (고친 코드) ----
Found a match!
Not matched!
Not matched!
Not matched!
```

**포인트**

- ^\[a-z]+\_\[a-z]+$
  ```text
  ^        문자열의 시작
  [a-z]+   소문자 1개 이상
  _        밑줄 그대로
  [a-z]+   소문자 1개 이상
  $        문자열의 끝
  ```

- 📝 필기 처음 작성한 정규식 "\[a-z]+\[a-z]+" → No No No No (전부 실패)
- 이 정규식에는 밑줄(\_) 이 들어 있지 않다.<br>matches() 는 문자열 "전체" 가 정규식과 일치해야 true 인데,<br>"java\_exercises" 의 가운데 \_ 를 \[a-z] 가 받아 줄 수 없으므로 정답이어야 할 첫 번째 문자열까지 실패한다.<br>→ 정규식에 \_ 를 넣어 "^\[a-z]+\_\[a-z]+$" 로 수정 → Yes No No No

- 💡 문제의 기대 출력은 "Found a match!" / "Not matched!" 인데, 처음에는 Yes / No 로 출력했다.<br>아래 코드는 문제의 출력 형식에 맞췄다. (처음 출력은 주석으로 남김)
- 💡 String.matches 는 자동으로 전체 일치를 검사하므로 ^ $ 는 생략해도 결과가 같다.

## 2. 단어 가운데에 g가 있는지 (`\B` · `\b`)

`6강 실습` · 📄 [`MiddleG.java`](MiddleG.java)

#### 문제

> 단어의 시작이나 끝이 아닌 곳(단어 가운데)에 'g' 가 들어 있는 단어가 있는지 찾으시오.<br>"The quick brown fox jumps over the lazy dog."  → Not matched!
>
> ```text
> "Java Exercises."                               → Not matched!
> "Programming Language"                          → Found a match!
> "Do humans eat gizzards?"                       → Not matched!
> "PostgreSQL"                                    → Found a match!
> ```

#### 💻 코드

<!-- code: MiddleG.java -->
```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiddleG {
    public static void main(String[] args) {
        String[] strs = {
                "The quick brown fox jumps over the lazy dog.",
                "Java Exercises.",
                "Programming Language",
                "Do humans eat gizzards?",
                "PostgreSQL"
        };

        System.out.println("---- \\Bg\\B (가운데 g) ----");
        Pattern p = Pattern.compile("\\Bg\\B");
        for (String s : strs) {
            Matcher m = p.matcher(s);
            if (m.find()) {
                System.out.println("Found a match!");   // 처음 출력 : Yes
            } else {
                System.out.println("Not matched!");     // 처음 출력 : No
            }
        }

        // 📝 시험 삼아 바꿔 본 패턴 : 단어 끝의 g
        System.out.println("---- \\Bg\\b (끝 g) ----");
        Pattern p2 = Pattern.compile("\\Bg\\b");
        for (String s : strs) {
            System.out.println(p2.matcher(s).find() ? "Yes" : "No");
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
---- \Bg\B (가운데 g) ----
Not matched!
Not matched!
Found a match!
Not matched!
Found a match!
---- \Bg\b (끝 g) ----
Yes
No
Yes
No
No
```

**포인트 (실습 자료의 정규식 설명 - 위치 앵커)**

- \\b : 단어 경계 (word boundary). 단어 문자(\\w)와 단어가 아닌 문자 사이의 "위치"
- \\B : 단어 경계가 "아닌" 위치 = 단어 안쪽
- \\Bg\\B : g 의 앞도 단어 안쪽, 뒤도 단어 안쪽 → 단어 "가운데" 의 g

- 📝 필기 : 문장별 결과
  ```text
  문장                          g 의 위치                       \Bg\B   \Bg\b
  ... lazy dog.                 dog 의 끝                        No      Yes
  Java Exercises.               g 없음                           No      No
  Programming Language          가운데 + Programming 의 끝       Yes     Yes
  Do humans eat gizzards?       gizzards 의 시작                 No      No
  PostgreSQL                    가운데                           Yes     No
  ```

패턴 정리

```text
\Bg\B  가운데의 g   (PostgreSQL, Language)
\Bg\b  끝의 g       (dog, Programming)
\bg\B  시작의 g     (gizzards)
```

- Matcher 의 find() 는 "부분" 을 찾기 때문에 String.matches 처럼 앞뒤에 .\* 를 붙일 필요가 없다.<br>(String.matches 로 하려면 ".\*\\\\Bg\\\\B.\*")

- 📝 필기 "\\\\Bg\\\\b" 로도 실행해 봄 → Yes No Yes No No  (단어 끝의 g 를 찾는 패턴이 됨)

- 💡 "Programming Language" 에는 가운데 g 가 여러 개(Pro\[g]ramming, Lan\[g]ua\[g]e) 있지만, find() 는 하나라도 찾으면 true 이므로 if (m.find()) 한 번으로 판정하면 된다.

## 3. Python → Java, code → coding 바꾸기

`6강 실습` · 📄 [`ReplaceWords.java`](ReplaceWords.java)

#### 문제

> 다음 문장에서 "Python" 을 "Java" 로, "code" 를 "coding" 으로 바꾸시오.
>
> Python is an interpreted high-level general-purpose programming language. Its design philosophy emphasizes code readability with its use of significant indentation. Its language constructs as well as its object-oriented approach aim to help programmers writeclear, logical code for small and large-scale projects.

#### 💻 코드

<!-- code: ReplaceWords.java -->
```java
public class ReplaceWords {
    public static void main(String[] args) {
        String str = "Python is an interpreted high-level general-purpose programming language. "
                + "Its design philosophy emphasizes code readability with its use of significant indentation. "
                + "Its language constructs as well as its object-oriented approach aim to help programmers "
                + "writeclear, logical code for small and large-scale projects.";

        String result = str.replace("Python", "Java").replace("code", "coding"); // Python -> Java, code -> coding
        System.out.println(result);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Java is an interpreted high-level general-purpose programming language. Its design philosophy emphasizes coding readability with its use of significant indentation. Its language constructs as well as its object-oriented approach aim to help programmers writeclear, logical coding for small and large-scale projects.
```

**포인트**

- str.replace("Python", "Java").replace("code", "coding")<br>→ replace 가 "새 String" 을 돌려주므로 그 결과에 다시 .replace 를 이어 붙일 수 있다. (메소드 체이닝)

**📝 필기**

- 정규식이 필요 없는 단순 치환은 replaceAll 보다 replace 가 간단하고 안전하다.<br>(replaceAll 은 첫 번째 인자를 정규식으로 해석하므로 . + ( 같은 문자가 들어 있으면 의도와 다르게 동작)
- replace 도 일치하는 "모든" 부분을 바꾼다. (이름 때문에 하나만 바꾼다고 착각하기 쉬움)
- 메소드 체이닝 : A.replace(...) 의 결과(String) 에 바로 .replace(...) 를 호출

- 💡 "code" 를 단순 치환하면 "codes", "decode" 같은 단어 속의 code 도 바뀐다.<br>단어 단위로만 바꾸려면 정규식 단어 경계를 쓴다 : replaceAll("\\\\bcode\\\\b", "coding")<br>(이 문장에는 code 가 단독 단어로만 2번 나와서 결과는 같다)
- 💡 원문의 "writeclear" 는 문제 원문의 띄어쓰기 그대로 둔 것.

## 4. PIN 번호 검사 (숫자 4 · 6 · 8자리)

`6강 실습` · 📄 [`PinValidation.java`](PinValidation.java)

#### 문제

> PIN 번호가 유효한지 검사하시오. 유효한 PIN 은 숫자로만 이루어진 4자리, 6자리, 8자리이다.

#### 💻 코드

<!-- code: PinValidation.java -->
```java
public class PinValidation {
    public static void main(String[] args) {
        String[] pins = { "123", "1234", "12345", "123456", "1234567", "12345678", "123456789" };
        String regex = "^(\\d{4}|\\d{6}|\\d{8})$";

        for (String pin : pins) {
            boolean isValid = pin.matches(regex);
            System.out.println("Original PIN Number: " + pin);
            System.out.println("Is the said PIN number is valid? " + isValid);
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Original PIN Number: 123
Is the said PIN number is valid? false
Original PIN Number: 1234
Is the said PIN number is valid? true
Original PIN Number: 12345
Is the said PIN number is valid? false
Original PIN Number: 123456
Is the said PIN number is valid? true
Original PIN Number: 1234567
Is the said PIN number is valid? false
Original PIN Number: 12345678
Is the said PIN number is valid? true
Original PIN Number: 123456789
Is the said PIN number is valid? false
```

**포인트**

- ^(\\d{4}|\\d{6}|\\d{8})$
  ```text
  \d{4}       숫자 정확히 4개
  ( A|B|C )   A 또는 B 또는 C   (| 는 OR, 괄호로 묶어 ^ $ 가 전체에 적용되도록)
  ^ ... $     처음부터 끝까지 → 중간에 숫자가 아닌 문자나 길이가 다른 경우 실패
  ```

- 📝 필기 : 요구사항 분석
1. 숫자로만 구성          → \\d
2. 길이가 4, 6, 8 중 하나 → {4} | {6} | {8}
3. 위 둘을 동시에         → ^(\\d{4}|\\d{6}|\\d{8})$

- 💡 괄호 없이 "^\\\\d{4}|\\\\d{6}|\\\\d{8}$" 로 쓰면 ^ 는 첫 번째에만, $ 는 마지막에만 붙어 의미가 달라진다.<br>(String.matches 는 어차피 전체 일치라 결과는 같지만, find 를 쓸 때는 큰 차이가 난다)
- 💡 "\\\\d{4}|\\\\d{6}|\\\\d{8}" 대신 "(\\\\d{2}){2,4}" 로도 쓸 수 있다. (2자리 묶음이 2\~4번 → 4, 6, 8자리)

---

[🏠 6주차 학습 가이드](../../README.md)
