# 6주차 과제 · strings2

[🏠 6주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [AlphanumericCheck.java](#1-영문자와-숫자로만-이루어졌는지) | 1. 영문자와 숫자로만 이루어졌는지 |
| [PStartQEnd.java](#2-p로-시작하고-q로-끝나는-문자열) | 2. p로 시작하고 q로 끝나는 문자열 |
| [StartsWithFive.java](#3-숫자-5로-시작하는지) | 3. 숫자 5로 시작하는지 |
| [VowelCount.java](#4-모음-개수-세기) | 4. 모음 개수 세기 (📝 import가 필요한 이유, `replaceAll`로 세는 방법) |

---

## 1. 영문자와 숫자로만 이루어졌는지

`6강 과제` · 📄 [`AlphanumericCheck.java`](AlphanumericCheck.java)

#### 문제

> 문자열이 영문자(a-z, A-Z)와 숫자(0-9)로만 이루어져 있는지 검사하시오.<br>"ABCDEFabcdef123450" → true
>
> ```text
> "SQL"                → true
> "Java"               → true
> "*&%@#!}{"           → false
> "w3resource.com"     → false
> ```

#### 💻 코드

<!-- code: AlphanumericCheck.java -->
```java
public class AlphanumericCheck {
    public static void main(String[] args) {
        String[] strs = { "ABCDEFabcdef123450", "SQL", "Java", "*&%@#!}{", "w3resource.com" };
        String regex = "[a-zA-Z0-9]+";

        for (String s : strs) {
            System.out.println(s + " : " + s.matches(regex));
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
ABCDEFabcdef123450 : true
SQL : true
Java : true
*&%@#!}{ : false
w3resource.com : false
```

**포인트**

- \[a-zA-Z0-9]+ : 대괄호 안에 범위를 여러 개 이어 쓸 수 있다. (소문자 OR 대문자 OR 숫자) 가 1개 이상
- String.matches 는 문자열 "전체" 가 일치해야 true

**📝 필기**

- 정규식의 의미를 명확히 하려면 ^\[a-zA-Z0-9]+$ 처럼 시작(^) 과 끝($) 을 표시해도 된다.<br>(matches 는 원래 전체 일치라 결과는 같음)
- "\*&%@#!}{" 는 특수문자만 있어서 false,<br>"w3resource.com" 은 영문자·숫자 사이에 점(.) 이 하나 섞여 있어서 false.

- 💡 \[a-zA-Z0-9] 는 \\\\p{Alnum} 으로도 쓸 수 있다.  \\\\w 는 밑줄(\_) 까지 포함하므로 이 문제에는 맞지 않다.

## 2. p로 시작하고 q로 끝나는 문자열

`6강 과제` · 📄 [`PStartQEnd.java`](PStartQEnd.java)

#### 문제

> 'p' 로 시작하고 'q' 로 끝나는 문자열을 찾으시오. (가운데는 아무 문자나 0개 이상)
>
> ```text
> "phkuyrt"     → Not matched!
> "pq"          → Found a match!
> ```
>
> "pccddbbjjjq" → Found a match!
>
> ```text
> "Jar"         → Not matched!
> "pjhut"       → Not matched!
> ```

#### 💻 코드

<!-- code: PStartQEnd.java -->
```java
public class PStartQEnd {
    public static void main(String[] args) {
        String[] strs = { "phkuyrt", "pq", "pccddbbjjjq", "Jar", "pjhut" };
        String regex = "^p.*q$";

        for (String s : strs) {
            if (s.matches(regex)) {
                System.out.println("Found a match!");
            } else {
                System.out.println("Not matched!");
            }
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Not matched!
Found a match!
Found a match!
Not matched!
Not matched!
```

**포인트**

- ^p.\*q$
  ```text
  ^p    p 로 시작
  .*    아무 문자(.) 가 0개 이상(*)  → "pq" 처럼 가운데가 비어 있어도 OK
  q$    q 로 끝
  ```

- 💡 .\* 대신 .+ 를 쓰면 가운데에 1글자 이상 있어야 해서 "pq" 가 Not matched! 가 된다.
- 💡 정규식 없이 : s.startsWith("p") && s.endsWith("q")  (단, "p" 한 글자는 따로 생각해야 함)

## 3. 숫자 5로 시작하는지

`6강 과제` · 📄 [`StartsWithFive.java`](StartsWithFive.java)

#### 문제

> 숫자 5 로 시작하는 문자열인지 검사하시오.<br>"5-2345861" → Found a match!<br>"6-2345861" → Not matched!
>
> ```text
> "6-5555861" → Not matched!   (5 가 들어 있지만 "시작" 이 아님)
> ```

#### 💻 코드

<!-- code: StartsWithFive.java -->
```java
public class StartsWithFive {
    public static void main(String[] args) {
        String[] strs = { "5-2345861", "6-2345861", "6-5555861" };
        String regex = "^5.*";

        for (String s : strs) {
            if (s.matches(regex)) {
                System.out.println("Found a match!");
            } else {
                System.out.println("Not matched!");
            }
        }

        // 📝 정규식 없이
        System.out.println("---- startsWith(\"5\") ----");
        for (String s : strs) {
            System.out.println(s.startsWith("5"));
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Found a match!
Not matched!
Not matched!
---- startsWith("5") ----
true
false
false
```

**포인트**

- ^5.\*
  ```text
  ^5   5 로 시작
  .*   그 뒤에는 아무 문자나 0개 이상 → String.matches 는 "전체 일치" 이므로 뒷부분을 .* 로 받아 줘야 한다.
  ```<br>(".\*" 없이 "^5" 만 쓰면 "5" 한 글자짜리 문자열만 true)

**📝 필기**

- 정규식이 꼭 필요 없다면 s.startsWith("5") 가 더 간단하고 빠르다.
- Pattern / Matcher 의 lookingAt() 을 쓰면 "앞부분만" 검사하므로 Pattern.compile("5") 로도 된다.

## 4. 모음 개수 세기

`6강 과제` · 📄 [`VowelCount.java`](VowelCount.java)

#### 문제

> 문자열에 들어 있는 모음(a, e, i, o, u - 대소문자 모두) 의 개수를 세시오.
>
> ```text
> "C++"             → 0
> "Java"            → 2
> ```
>
> "MID-CENTRALIZED" → 5
>
> ```text
> "LOWERED"         → 3
> ```

#### 💻 코드

<!-- code: VowelCount.java -->
```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelCount {
    public static void main(String[] args) {
        String[] strs = { "C++", "Java", "MID-CENTRALIZED", "LOWERED" };
        Pattern p = Pattern.compile("[aeiouAEIOU]");

        for (String s : strs) {
            Matcher m = p.matcher(s);
            int count = 0;
            while (m.find()) {
                count++;
            }
            System.out.println("Original string: " + s);
            System.out.println("New string: " + count);
        }

        // 💡 모음이 아닌 문자를 지우고 길이 재기
        System.out.println("---- replaceAll 로 세기 (import 없이) ----");
        for (String s : strs) {
            System.out.println(s + " : " + s.replaceAll("[^aeiouAEIOU]", "").length());
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Original string: C++
New string: 0
Original string: Java
New string: 2
Original string: MID-CENTRALIZED
New string: 5
Original string: LOWERED
New string: 3
---- replaceAll 로 세기 (import 없이) ----
C++ : 0
Java : 2
MID-CENTRALIZED : 5
LOWERED : 3
```

**포인트**

- Pattern.compile("\[aeiouAEIOU]") : 모음 한 글자
- while (m.find()) count++;        : 찾을 때마다 1 증가 → 일치한 개수

- 📝 필기 : 왜 이 문제에서만 import 가 필요한가?
- String 클래스에는 "정규식에 일치하는 개수를 세는" 메소드가 없다.<br>→ find() 를 반복할 수 있는 Pattern / Matcher 가 필요한데, 이 클래스들은 java.lang 이 아니라 java.util.regex 패키지에 있어서 import 해야 한다.
- 1\~3번은 String 의 matches / split / replaceAll 만 썼는데, String 은 java.lang 패키지라 자동으로 import 되므로 import 문이 필요 없었다.

```java
구분        String 메소드 (matches, split, replaceAll)   Pattern / Matcher
import      필요 없음 (java.lang)                         필요 (java.util.regex)
용도        전체 일치 검사, 자르기, 치환                  find / group 반복 → 개수 · 위치 찾기
성능        호출할 때마다 정규식을 새로 컴파일            한 번 compile 한 패턴을 재사용 → 반복 검사에 유리
```

- 💡 보충 : import 없이 세는 방법
- 모음이 "아닌" 문자를 모두 지운 뒤 남은 길이를 재면 된다.<br>str.replaceAll("\[^aeiouAEIOU]", "").length()<br>"MID-CENTRALIZED" → "IEAIE" → 5

---

[🏠 6주차 학습 가이드](../../README.md)
