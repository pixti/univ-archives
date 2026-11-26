# 6주차 실습 · strings1

[🏠 6주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [WordCount.java](#1-단어-개수-세기-split-없이-characterisletter로) | 1. 💡 단어 개수 세기 (split 없이 `Character.isLetter`로) |
| [WordCountSplit.java](#1-변형-split-정규식으로-단어-나누기) | 1. 변형: split 정규식으로 단어 나누기 (⚠ null 검사 → `isEmpty`) |
| [Palindrome.java](#2-회문-검사-공백-제거--양-끝-비교) | 2. 회문 검사 (공백 제거 + 양 끝 비교) |
| [PalindromeRegex.java](#2-같은-문제를-정규식으로-특수문자까지-제거) | 2. 같은 문제를 정규식으로 특수문자까지 제거 (📝 두 방법 비교표, ⚠ 한글도 지워짐) |
| [SpellCorrection.java](#3-철자-교정-문장-첫-글자-대문자-등) | 3. 💡 철자 교정 (문장 첫 글자 대문자 등) |
| [RegexCatDog.java](#3-풀이-중-해-본-정규식-실험-matches--replaceall--find) | 3. 풀이 중 해 본 정규식 실험 (`matches` · `replaceAll` · `find`) |
| [WordFrequency.java](#4-단어-빈도수) | 4. 단어 빈도수 |

---

## 1. 단어 개수 세기 (split 없이 `Character.isLetter`로)

`6강 실습` · 📄 [`WordCount.java`](WordCount.java)

#### 문제

> 영문 문자열을 입력받아 영단어의 개수를 출력하는 프로그램을 작성하시오.
>
> - split 메소드를 사용하지 않고, 문자 배열(char\[]) 과 Character.isLetter() 를 이용한다.
> - 영문자가 아닌 문자(공백, 숫자, 문장부호)는 단어의 구분자로 본다.

#### 💻 코드

<!-- code: WordCount.java -->
```java
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("영문 문자열을 입력하세요 : ");
        String input = sc.nextLine();       // 띄어쓰기가 들어간 문장 전체를 읽어온다.

        char[] chars = input.toCharArray(); // 문자열 → 문자 배열
        int count = 0;
        boolean inWord = false;             // 현재 단어 안에 있는지

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (!inWord) {              // 구분자 다음에 처음 나온 문자 = 새 단어의 시작
                    count++;
                    inWord = true;
                }
            } else {
                inWord = false;             // 공백 · 숫자 · 문장부호 → 단어 끝
            }
        }
        System.out.println("영단어의 개수는 : " + count);
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
영문 문자열을 입력하세요 : This is a book.
영단어의 개수는 : 4

영문 문자열을 입력하세요 : abc         → 영단어의 개수는 : 1
영문 문자열을 입력하세요 : 123         → 영단어의 개수는 : 0
영문 문자열을 입력하세요 : 123abc456   → 영단어의 개수는 : 1
```

#### 📒 해설

- 💡 참고 답안 (필기에는 split 버전만 있어서, 문제 조건대로 작성한 답안을 추가함)
- 아이디어 : "영문자가 아닌 문자 → 영문자" 로 바뀌는 순간 = 새 단어가 시작되는 순간.<br>inWord(지금 단어 안에 있는가?) 변수 하나로 상태를 기억하면서 한 글자씩 본다.

T h i s \_ i s \_ a \_ b o o k .

```text
↑       ↑   ↑   ↑                 ← 단어 시작 4번 → 4개
```

- Character.isLetter(c) : c 가 문자(알파벳 등)면 true.  숫자·공백·문장부호는 false.
  - 💡 isLetter 는 한글도 문자로 본다. "영문자만" 엄격하게 보려면<br>(c >= 'a' && c &lt;= 'z') || (c >= 'A' && c &lt;= 'Z') 로 검사한다.

## 1. 변형: split 정규식으로 단어 나누기

`6강 실습` · 📄 [`WordCountSplit.java`](WordCountSplit.java)

#### 문제

> 영문 문자열을 입력받아 영단어의 개수를 출력하시오. 이번에는 split 을 사용한다.
>
> - 공백, 콜론(:), 콤마(,), 점(.), 숫자를 구분자로 본다.

#### 💻 코드

<!-- code: WordCountSplit.java -->
```java
import java.util.Scanner;

public class WordCountSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문장 ? ");
        String sentence = sc.nextLine();
        sentence = sentence.toLowerCase();

        // 공백, 콜론, 콤마, 점, 숫자(\d)가 1번 이상 연속되면 구분자로 분리
        String[] subs = sentence.split("( |:|,|\\.|\\d)+");
        // String[] subs = sentence.split("[ :,.0-9]+");   // 💡 같은 의미, 더 짧게

        int cnt = 0;
        for (int i = 0; i < subs.length; i++) {
            // ❌ 처음 코드 : "" 는 null 이 아니라서 맨 앞의 빈 문자열까지 세어 버림 → 2
            // System.out.println(subs[i]);
            // if (subs[i] != null) { cnt++; }

            // ✅ 빈 문자열("")이 아닌 경우만 카운트하고 출력
            if (!subs[i].isEmpty()) {
                System.out.println(subs[i]);
                cnt++;
            }
        }
        System.out.println("영단어의 개수는 : " + cnt);
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
문장 ? 123abc456
abc
영단어의 개수는 : 1

문장 ? This is a book.
this
is
a
book
영단어의 개수는 : 4
```

**포인트**

- split("( |:|,|\\\\.|\\\\d)+") : 공백, 콜론, 콤마, 점, 숫자(\\d) 가 1번 이상 연속되면 구분자로 분리<br>( A | B | C )+ : A 또는 B 또는 C 가 1번 이상 반복
  ```text
  \\.           : 정규식에서 . 은 "아무 문자 1개" 라서 진짜 점은 \\. 로 써야 한다.
  \\d           : 숫자 1개 (0~9)
  ```
- + 를 붙이지 않으면 "a,  b" 처럼 구분자가 연달아 있을 때 사이사이 빈 문자열("") 이 생긴다.

**📝 필기 "2로 나오는 문제 주의"**

- 처음 코드는 if (subs\[i] != null) 로 개수를 셌는데, "123abc456" 을 넣으면 1 이 아니라 2 가 나왔다.
  ```text
  출력 :            ← 빈 줄 (subs[0] = "")
         abc
         영단어의 개수는 : 2
  ```
- 문자열이 구분자(숫자 123)로 "시작" 하면 split 결과의 맨 앞에 빈 문자열 "" 이 생긴다.
  ```text
  "123abc456".split("( |:|,|\\.|\\d)+")  →  ["", "abc"]   (길이 2)
  ```<br>(맨 뒤에 생기는 빈 문자열은 split 이 자동으로 지워 주지만, 맨 앞은 남는다)<br>"" 은 길이 0 인 "진짜 String 객체" 이므로 null 이 아니다. → null 검사로는 걸러지지 않는다.

**📝 필기 ".isEmpty()"**

- 그래서 !subs\[i].isEmpty() 로 "빈 문자열("")이 아닌 경우만" 카운트하고 출력하도록 수정 → 1

- 📝 필기 : 더 짧게 쓰는 방법 → 문자 클래스 \[ ]
- "\[ :,.0-9]+" : 대괄호 안에 넣으면 "이 중 아무거나 1개" 라는 뜻. | 로 일일이 나열하지 않아도 된다.<br>대괄호 안에서는 . 이 특수문자가 아니라 진짜 점이라 \\\\ 도 필요 없다.
- 단, 교수님은 \\\\d 를 사용하셨다. 0-9 같은 "범위" 는 대괄호 안에서만 범위로 해석되고, 대괄호 밖에서 0-9 라고 쓰면 문자 '0', '-', '9' 가 순서대로 나오는 것으로 읽혀 버린다.

- 💡 split 결과 맨 앞의 "" 를 아예 없애려면, 먼저 앞쪽 구분자를 지우고 자르는 방법도 있다.<br>sentence.replaceAll("^\[ :,.0-9]+", "").split("\[ :,.0-9]+")

## 2. 회문 검사 (공백 제거 + 양 끝 비교)

`6강 실습` · 📄 [`Palindrome.java`](Palindrome.java)

#### 문제

> 문자열을 입력받아 회문(palindrome, 앞에서 읽으나 뒤에서 읽으나 같은 문장)인지 판별하시오.
>
> - 대소문자와 공백은 무시한다.<br>"Able was I ere I saw Elba" → 회문입니다
>   ```text
>   "I love you"                → 회문이 아닙니다
>   "소주 주소"                  → 회문입니다
>   "국제 경제국"                → 회문입니다
>   ```
> - 문제의 입력 안내 : "문자열을 입력하세요 : "  (이 코드는 "문장 ? " 으로 작성)

#### 💻 코드

<!-- code: Palindrome.java -->
```java
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문장 ? ");
        String sentence = sc.nextLine();             // 띄어쓰기가 들어간 문장 전체를 읽어온다.
        sentence = sentence.toLowerCase();           // 소문자로 변환
        sentence = sentence.replaceAll(" ", "");     // 띄어쓰기(공백) 제거

        char[] chars = sentence.toCharArray();
        boolean isPalindrome = true;

        // 회문 검사 (양 끝에서 중앙으로 비교)
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }

        // 결과 출력
        if (isPalindrome) {
            System.out.println("회문 !");
        } else {
            System.out.println("회문 아님!");
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
문장 ? 기러기
회문 !
문장 ? Able was I ere I saw Elba
회문 !
문장 ? I love you
회문 아님!
문장 ? 국제 경제국
회문 !
```

**포인트**

1. nextLine()            : 띄어쓰기가 들어간 문장 전체를 읽는다. (next() 는 첫 단어만)
2. toLowerCase()         : "Able" 과 "elbA" 의 A / a 를 같게 만든다.
3. replaceAll(" ", "")   : 띄어쓰기(공백) 제거
4. 양 끝에서 중앙으로 비교 : chars\[i] 와 chars\[길이-1-i] 를 길이/2 번만 비교하면 된다.<br>하나라도 다르면 바로 false 로 바꾸고 break.

a b l e w a s i e r e i s a w e l b a

```text
↑ ─────────────────────────────────── ↑   i = 0
  ↑ ─────────────────────────────── ↑     i = 1 ...
```

- 💡 StringBuilder 로 뒤집어서 비교하는 방법도 있다. (6-3 reverse)
  ```text
  new StringBuilder(sentence).reverse().toString().equals(sentence)
  ```

## 2. 같은 문제를 정규식으로 특수문자까지 제거

`6강 실습` · 📄 [`PalindromeRegex.java`](PalindromeRegex.java)

#### 문제

> Palindrome.java 에서 replaceAll(" ", "") 한 줄만 replaceAll("\[^a-z0-9]", "") 로 바꾼 버전.
>
> - \[^a-z0-9] : 대괄호 안의 ^ 는 "제외(NOT)". 알파벳 소문자 및 숫자가 "아닌" 문자 1개<br>→ 공백뿐 아니라 쉼표, 콜론, 느낌표 같은 특수문자까지 모두 제거
> - 먼저 toLowerCase() 를 했기 때문에 대문자는 이미 없다. (순서가 바뀌면 대문자가 다 지워진다!)

#### 💻 코드

<!-- code: PalindromeRegex.java -->
```java
import java.util.Scanner;

public class PalindromeRegex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문장 ? ");
        String sentence = sc.nextLine();                    // 1. 띄어쓰기가 들어간 문장 전체를 읽어온다.
        sentence = sentence.toLowerCase();                  // 2. 소문자로 변환
        sentence = sentence.replaceAll("[^a-z0-9]", "");    // 3. 알파벳 소문자 및 숫자가 아닌 특수문자/공백 제거
        // sentence = sentence.replaceAll("[^a-z0-9가-힣]", "");   // 💡 한글도 남기려면

        char[] chars = sentence.toCharArray();
        boolean isPalindrome = true;

        // 회문 검사 (양 끝에서 중앙으로 비교)
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }

        // 4. 결과 출력
        if (isPalindrome) {
            System.out.println("회문 !");
        } else {
            System.out.println("회문 아님!");
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
문장 ? A man, a plan, a canal: Panama!
회문 !
문장 ? No, on!
회문 !
문장 ? 가나다
회문 !          ← ⚠ 한글이 모두 지워져서 생기는 잘못된 결과 ([^a-z0-9가-힣] 이면 회문 아님!)
```

#### 📒 해설

- 📝 필기 : 두 방법 비교
  ```text
  입력                                방법 1 : replaceAll(" ", "")    방법 2 : replaceAll("[^a-z0-9]", "")
  A man, a plan, a canal: Panama!     "aman,aplan,acanal:panama!"     "amanaplanacanalpanama"
                                      → 회문 아님!                    → 회문 !
  race car                            "racecar" → 회문 !              "racecar" → 회문 !
  No, on!                             "no,on!"  → 회문 아님!          "noon"    → 회문 !
  ```
- 시험이나 간단한 과제에서는 보통 방법 1 (공백만 제거) 을 기대하고,<br>코딩 테스트에서는 특수문자까지 무시하는 방법 2 를 많이 쓴다.

- ⚠ \[^a-z0-9] 는 한글도 "알파벳 소문자·숫자가 아닌 문자" 로 보고 전부 지워 버린다.<br>"소주 주소" → "" (빈 문자열) → 반복문을 한 번도 안 돌아서 isPalindrome = true → 회문 !<br>결과는 맞아 보이지만 "검사를 하지 않고" 통과한 것이고, "가나다" 처럼 회문이 아닌 한글도 회문 ! 이 된다.<br>한글까지 다루려면 \[^a-z0-9가-힣] 처럼 한글을 남기도록 해야 한다. (아래 주석 참고)

## 3. 철자 교정 (문장 첫 글자 대문자 등)

`6강 실습` · 📄 [`SpellCorrection.java`](SpellCorrection.java)

#### 문제

> 영문 문장을 입력받아 다음과 같이 교정하여 출력하시오.
>
> - 문장의 첫 글자와 마침표(.) 다음에 오는 첫 영문자를 대문자로 바꾼다.
> - 문장의 끝에 마침표가 없으면 마침표를 붙인다.
>
> 예) i love you. you love me. we love them<br>→  I love you. You love me. We love them.

#### 💻 코드

<!-- code: SpellCorrection.java -->
```java
import java.util.Scanner;

public class SpellCorrection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("영문 문장을 입력하세요 : ");
        StringBuilder sb = new StringBuilder(sc.nextLine().trim());

        boolean capitalize = true;                         // 문장 첫 글자는 대문자
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '.') {
                capitalize = true;                         // 마침표 다음 첫 영문자를 대문자로
            } else if (capitalize && Character.isLetter(c)) {
                sb.setCharAt(i, Character.toUpperCase(c));
                capitalize = false;
            }
        }

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '.') {
            sb.append('.');                                // 끝에 마침표가 없으면 붙이기
        }
        System.out.println(sb);
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
영문 문장을 입력하세요 : i love you. you love me. we love them
I love you. You love me. We love them.
```

#### 📒 해설

- 💡 참고 답안 (필기에는 이 문제의 풀이 대신 정규식 실험 코드만 있어서 → RegexCatDog.java, 답안을 추가함)
- StringBuilder 로 바꾸면 setCharAt 으로 한 글자씩 고칠 수 있다. (String 은 변경 불가!)
- capitalize 변수 : "다음에 나오는 영문자를 대문자로 바꿔야 하는가?"<br>처음엔 true (문장 첫 글자) → 영문자를 만나면 대문자로 바꾸고 false<br>마침표를 만나면 다시 true  → 그 사이의 공백은 그냥 지나감
- Character.toUpperCase(c) : 한 문자를 대문자로 (String 의 toUpperCase 와 구분)
- 끝에 마침표 검사 : endsWith(".")  (뒤에 공백이 있을 수 있으니 trim 후 검사)

- 💡 정규식 + Matcher 로 푸는 방법도 있다. (6-4 Pattern / Matcher 응용)
  ```java
  Matcher m = Pattern.compile("(^|\\.\\s*)([a-z])").matcher(str);
  ```<br>→ 문장 시작 또는 "마침표+공백" 뒤의 소문자를 찾아 m.appendReplacement 로 대문자로 바꿈

## 3. 풀이 중 해 본 정규식 실험 (`matches` · `replaceAll` · `find`)

`6강 실습` · 📄 [`RegexCatDog.java`](RegexCatDog.java)

#### 💻 코드

<!-- code: RegexCatDog.java -->
```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCatDog {
    public static void main(String[] args) {
        String str = "one cat two cat three cat";

        System.out.println(str.matches("c.t"));            // false : 전체가 c.t 가 아님
        System.out.println(str.matches(".*c.t.*"));        // true  : 💡 앞뒤에 .* → "포함" 검사
        System.out.println(str.replaceAll("c.t", "dog"));  // one dog two dog three dog

        Pattern p = Pattern.compile("c.t");

        // ---- 첫 번째 버전 : find() 를 직접 세 번 호출 ----
        System.out.println("---- find() 세 번 직접 호출 ----");
        Matcher m = p.matcher(str);
        m.find();
        System.out.println(m.start() + "~" + (m.end() - 1));
        m.find();
        System.out.println(m.start() + "~" + (m.end() - 1));
        m.find();
        System.out.println(m.start() + "~" + (m.end() - 1));

        // ---- 두 번째 버전 : while 반복문 ----
        System.out.println("---- while (m.find()) ----");
        m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.start() + "~" + (m.end() - 1));
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
false
true
one dog two dog three dog
---- find() 세 번 직접 호출 ----
4~6
12~14
22~24
---- while (m.find()) ----
4~6
12~14
22~24
```

**📝 필기 (직접 실험해 본 코드)**

- 처음에는 m.find() 를 세 번 직접 호출해서 위치를 출력했고,<br>두 번째로 while (m.find()) 반복문으로 바꿨다. → 몇 개가 있든 끝까지 찾을 수 있다.

**📝 필기**

- str.matches("c.t") 가 false 인 이유<br>matches 는 문자열 "전체" 가 패턴과 100% 일치해야 true.<br>"c.t" 는 c + (아무 문자 1개) + t, 즉 딱 세 글자짜리 문자열만 통과한다.<br>"one cat two cat three cat" 는 그 안에 cat 이 "포함" 되어 있을 뿐 전체가 c.t 는 아니다.<br>→ 포함 여부를 matches 로 보고 싶으면 앞뒤에 .\* 를 붙인다 : str.matches(".\*c.t.\*")  → true
- replaceAll("c.t", "dog") : 일치하는 "모든" 부분을 바꾼다. → one dog two dog three dog<br>(처음 하나만 바꾸려면 replaceFirst)
- Matcher 의 find() : 호출할 때마다 "다음" 일치 부분을 찾고, 찾으면 true / 더 없으면 false.<br>start() : 일치 시작 인덱스, end() : 일치 끝 인덱스 + 1  → 그래서 m.end()-1 로 출력

o n e \_ c a t \_ t w o \_  c  a  t  \_ ...<br>0 1 2 3 4 5 6 7 8 9 10 11 12 13 14

```text
~~~~~               ~~~~~~~~
4~6                 12~14            (세 번째 cat 은 22~24)
```

## 4. 단어 빈도수

`6강 실습` · 📄 [`WordFrequency.java`](WordFrequency.java)

#### 문제

> 문장을 입력받아 각 단어가 몇 번 나왔는지 출력하시오. (대소문자는 구분하지 않는다)<br>예) Easy come, easy go.<br>easy	2<br>come	1<br>go	1

#### 💻 코드

<!-- code: WordFrequency.java -->
```java
import java.util.Scanner;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문장을 입력하세요 : ");
        String sentence = sc.nextLine();                 // 띄어쓰기가 들어간 문장 전체를 읽어온다.

        sentence = sentence.toLowerCase();               // 소문자로 변환
        String[] subs = sentence.split("( |,|\\.)+");    // 공백을 기준으로 단어를 나눈다. (쉼표, 마침표 포함)

        for (int i = 0; i < subs.length; i++) {
            if (subs[i] != null) {                       // 이미 처리되어 null이 된 단어는 건너뜀
                int cnt = 0;
                for (int j = i + 1; j < subs.length; j++) {
                    if (subs[j] != null && subs[i].equals(subs[j])) {
                        cnt++;
                        subs[j] = null;                  // 중복 단어는 null로 변경하여 제외
                    }
                }
                // (cnt + 1) 형태로 괄호를 묶어주어야 숫자 덧셈이 정상 처리됨
                System.out.println(subs[i] + "\t" + (cnt + 1));
            }
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
문장을 입력하세요 : Easy come, easy go.
easy	2
come	1
go	1
```

**포인트**

- toLowerCase() 로 소문자 통일 → "Easy" 와 "easy" 를 같은 단어로
- split("( |,|\\\\.)+") : 공백 · 쉼표 · 마침표가 1개 이상 이어진 덩어리로 자르기 "easy come, easy go."  →  \["easy", "come", "easy", "go"]<br>(맨 끝의 마침표 뒤 빈 문자열은 split 이 자동으로 없애 준다)
- 이중 for 문 : i 번째 단어를 뒤쪽(j = i+1 \~) 단어들과 비교해 같은 것을 센다.<br>센 단어는 null 로 바꿔서 나중에 다시 세지 않게 한다.

**📝 필기 (코드 주석 정리)**

- 이미 처리되어 null 이 된 단어는 건너뜀
- 중복 단어는 null 로 변경하여 제외
- (cnt + 1) 형태로 괄호를 묶어주어야 숫자 덧셈이 정상 처리됨
  ```text
  subs[i] + "\t" + cnt + 1   → "easy\t1" 뒤에 "1" 이 이어 붙어 "easy\t11"  (문자열 연결이 왼쪽부터 진행)
  ```<br>subs\[i] + "\\t" + (cnt + 1) → 괄호 안을 먼저 계산 → "easy\\t2"

- 📝 필기 : 중복 단어를 지울 때 null 과 "" 중 무엇을 쓸까?
- "" (빈 문자열) : 길이가 0 인 "진짜 String 객체". 이후 비교 때 equals 를 또 호출하게 되어 비효율적이고, 입력에 원래 빈 단어가 있었는지와 헷갈릴 수 있다.
- null           : "여기엔 더 이상 단어가 없다" 는 의미가 분명하고, subs\[i] != null 로 간단히 건너뛸 수 있다.<br>→ null 로 표시하는 방법을 사용. 단, null 에 equals 를 호출하면 NullPointerException 이므로 subs\[j] != null && subs\[i].equals(subs\[j]) 처럼 null 검사를 "먼저" 해야 한다. (&& 의 단축 평가)

- 💡 나중에 배울 HashMap&lt;String, Integer> 을 쓰면 이중 for 문 없이 단어별 개수를 셀 수 있다.

---

[🏠 6주차 학습 가이드](../../README.md)
