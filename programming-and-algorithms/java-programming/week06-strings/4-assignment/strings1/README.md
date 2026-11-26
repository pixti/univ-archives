# 6주차 과제 · strings1

[🏠 6주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [ReverseWords.java](#1-단어-순서를-거꾸로-출력-trim--splits) | 1. 단어 순서를 거꾸로 출력 (`trim` + `split("\\s+")`) |
| [ReverseWordsRegexSplit.java](#1-다른-풀이-1-split-정규식만으로) | 1. 다른 풀이 1: split 정규식만으로 (⚠ 앞에 공백이 있으면 단어 사이 공백이 사라지는 실수와 고친 코드) |
| [ReverseWordsMatcher.java](#1-다른-풀이-2-matcherfind--arraylist--collectionsreverse) | 1. 다른 풀이 2: `Matcher.find` + `ArrayList` + `Collections.reverse` |
| [SwapName.java](#2-성-이름--소문자-이름-성) | 2. "성 이름" → 소문자 "이름 성" |
| [FindReplace.java](#3-찾을-문자열을-모두-바꾸기) | 3. 찾을 문자열을 모두 바꾸기 |
| [CaesarCipher.java](#4-암호화--복호화-4-시저-암호) | 4. 암호화 / 복호화 (+4 시저 암호) |

---

## 1. 단어 순서를 거꾸로 출력 (`trim` + `split("\\s+")`)

`6강 과제` · 📄 [`ReverseWords.java`](ReverseWords.java)

#### 문제

> 영문 문자열을 입력받아 단어의 순서를 거꾸로 출력하시오.<br>영문 문자열을 입력하세요 : programming in c<br>c in programming

#### 💻 코드

<!-- code: ReverseWords.java -->
```java
import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("영문 문자열을 입력하세요 : ");
        String input = sc.nextLine();

        String[] words = input.trim().split("\\s+");

        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i]);
            if (i > 0) System.out.print(" ");
        }
        System.out.println();
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
영문 문자열을 입력하세요 : pr sdf sgd
sgd sdf pr

영문 문자열을 입력하세요 : programming in c
c in programming
```

**포인트**

- input.trim().split("\\\\s+")
  ```text
  trim()       앞뒤 공백 제거
  \\s+         공백 문자(스페이스, 탭 등) 가 1개 이상 → 단어 사이 공백이 여러 칸이어도 한 번에 자름
  ```
- 배열을 뒤에서부터(words.length - 1 → 0) 출력
- if (i > 0) 일 때만 공백 출력 → 마지막 단어 뒤에 공백이 붙지 않게

- 📝 필기 : trim() 을 하는 이유
- 입력 앞에 공백이 있으면 (" programming in c") split 결과의 맨 앞에 빈 문자열이 생긴다.<br>" programming in c".split("\\\\s+")  →  \["", "programming", "in", "c"]<br>→ 거꾸로 출력하면 마지막에 공백 + 빈 문자열이 붙어 "c in programming " 처럼 된다.
- (맨 뒤의 공백은 split 이 끝의 빈 문자열을 자동으로 지워 주지만, 맨 앞은 남는다 → 실습 1번과 같은 원리)

- 📝 필기 : trim() 없이 해결하는 방법
- 방법 A : 반복문에서 빈 문자열을 건너뛴다.  if (words\[i].isEmpty()) continue;
- 방법 B : Scanner 의 next() 로 단어를 하나씩 읽는다. next() 는 공백을 자동으로 건너뛴다.

- 📝 필기 : 정규식으로 하는 방법은 없을까?<br>→ 다른 풀이 1 : ReverseWordsRegexSplit.java  (split 정규식에 앞/뒤 공백까지 넣는 방법)
  ```text
  → 다른 풀이 2 : ReverseWordsMatcher.java     (Pattern / Matcher 로 단어만 찾는 방법, 가장 표준적)
  ```

## 1. 다른 풀이 1: split 정규식만으로

`6강 과제` · 📄 [`ReverseWordsRegexSplit.java`](ReverseWordsRegexSplit.java)

#### 💻 코드

<!-- code: ReverseWordsRegexSplit.java -->
```java
import java.util.Scanner;

public class ReverseWordsRegexSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("영문 문자열을 입력하세요 : ");
        String input = sc.nextLine();

        // 정규식 해설: ^\\s+ (맨 앞 공백들) OR \\s+$ (맨 뒤 공백들) OR \\s+ (단어 사이 공백)
        String[] words = input.split("^\\s+|\\s+$|\\s+");

        // ---- ⚠ 틀린 코드 : 맨 앞 공백이 있으면 단어 사이 공백이 사라짐 ----
        System.out.print("틀린 코드 : ");
        // 맨 앞 공백 제거로 인해 words[0]에 빈 문자열이 생성된 경우를 대비해 역순 출력
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {                      // 맨 앞 공백 분할로 생긴 빈 값 제외
                System.out.print(words[i]);
                if (i > 0 && !words[0].isEmpty()) System.out.print(" ");
            }
        }
        System.out.println();

        // ---- ✅ 고친 코드 ----
        System.out.print("고친 코드 : ");
        boolean first = true;
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].isEmpty()) continue;               // 빈 값 제외
            if (!first) System.out.print(" ");              // 두 번째 단어부터 앞에 공백
            System.out.print(words[i]);
            first = false;
        }
        System.out.println();
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
영문 문자열을 입력하세요 :   programming in c
틀린 코드 : cinprogramming
고친 코드 : c in programming
```

#### 📒 해설

- 📝 필기 : "정규식으로 하는 방법은 없을까?" 를 찾아본 풀이

정규식 해설 : "^\\\\s+|\\\\s+$|\\\\s+"

```text
^\\s+    맨 앞 공백들     OR
\\s+$    맨 뒤 공백들     OR
\\s+     단어 사이 공백
```


- 맨 앞 공백 제거로 인해 words\[0] 에 빈 문자열이 생성된 경우를 대비해 역순 출력할 때 빈 값을 건너뛴다.

- 💡 사실 split 은 "앞쪽 구분자 → 맨 앞에 빈 문자열" 을 만드는 성질이 있어서, 정규식에 ^\\\\s+ 를 넣어도 words\[0] 의 빈 문자열은 사라지지 않는다. 결국 \\\\s+ 하나만 쓴 것과 결과 배열이 같다.<br>→ 정규식만으로 앞 공백 문제를 없앨 수는 없고, 빈 문자열을 건너뛰는 isEmpty 검사가 핵심이다.

- ⚠ 자주 틀리는 부분 : 공백 출력 조건을 if (i > 0 && !words\[0].isEmpty()) 로 쓰면 틀린다.<br>입력 앞에 공백이 있으면 words\[0] 이 "" 이므로 !words\[0].isEmpty() 가 항상 false<br>→ 단어 사이 공백이 하나도 출력되지 않는다.
  ```text
  입력 "  a b"  →  words = ["", "a", "b"]  →  출력 "ba"   (기대값 "b a")
  ```<br>(앞 공백이 없으면 정상 출력된다. "공백을 찍을지" 를 words\[0] 이 비었는지에 묶어 버린 것이 원인)
  - ✅ 고친 방법 : 빈 문자열을 뺀 단어만 모아서 "처음 출력하는 단어가 아니면 앞에 공백" 을 찍는다. (first 변수)

## 1. 다른 풀이 2: `Matcher.find` + `ArrayList` + `Collections.reverse`

`6강 과제` · 📄 [`ReverseWordsMatcher.java`](ReverseWordsMatcher.java)

#### 💻 코드

<!-- code: ReverseWordsMatcher.java -->
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReverseWordsMatcher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("영문 문자열을 입력하세요 : ");
        String input = sc.nextLine();

        // \\S+ : 공백이 아닌 문자가 1개 이상 이어지는 단어 패턴
        Pattern pattern = Pattern.compile("\\S+");
        Matcher matcher = pattern.matcher(input);

        ArrayList<String> words = new ArrayList<>();
        // 매칭되는 단어만 하나씩 찾아 리스트에 추가 (앞뒤/중간 공백 자동 무시됨)
        while (matcher.find()) {
            words.add(matcher.group());
        }

        // 역순으로 뒤집기
        Collections.reverse(words);

        // 결과 출력
        System.out.println(String.join(" ", words));
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
영문 문자열을 입력하세요 :   programming   in c
c in programming
```

**📝 필기**

- "자르는(split)" 대신 "단어를 찾는(find)" 발상<br>\\\\S+ : 공백이 아닌 문자(\\S) 가 1개 이상 이어지는 단어 패턴
- while (matcher.find()) 로 매칭되는 단어만 하나씩 찾아 리스트에 추가<br>→ 앞뒤 / 중간 공백이 몇 개든 자동으로 무시된다. (빈 문자열이 생길 일이 없음)
- Collections.reverse(words) : 리스트를 역순으로 뒤집기
- String.join(" ", words)    : 리스트의 원소 사이사이에 " " 를 넣어 하나의 문자열로 → 마지막 공백 걱정도 없음

- 💡 ArrayList 는 크기가 자동으로 늘어나는 배열 (나중에 컬렉션 단원에서 배움).<br>단어 개수를 미리 알 수 없어서 배열 대신 사용했다.<br>add(값) : 뒤에 추가,  size() : 개수,  get(i) : i 번째 값

## 2. "성 이름" → 소문자 "이름 성"

`6강 과제` · 📄 [`SwapName.java`](SwapName.java)

#### 문제

> "성 이름" 형식으로 대문자 이름을 입력받아, 소문자로 바꾸고 "이름 성" 순서로 출력하시오.
>
> ```text
> HONG GIL DONG         → gil dong hong
> KIM BYEONGMAN         → byeongman kim
> ```
>
> LEE MAXIM GOLDEN BAR  → maxim golden bar lee

#### 💻 코드

<!-- code: SwapName.java -->
```java
import java.util.Scanner;

public class SwapName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요(성 이름)(ex : HONG GIL DONG) : ");
        String input = sc.nextLine();

        String[] parts = input.trim().toLowerCase().split("\\s+");

        if (parts.length > 0) {
            // 이름(FirstName)은 두 번째 단어부터 마지막 단어까지 (parts[1] ~ parts[length-1])
            for (int i = 1; i < parts.length; i++) {
                System.out.print(parts[i] + " ");
            }
            // 성(LastName)은 첫 번째 단어 (parts[0])
            System.out.println(parts[0]);
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
이름을 입력하세요(성 이름)(ex : HONG GIL DONG) : PARK JAE HYEONG
jae hyeong park

이름을 입력하세요(성 이름)(ex : HONG GIL DONG) : LEE MAXIM GOLDEN BAR
maxim golden bar lee
```

**포인트**

- input.trim().toLowerCase().split("\\\\s+") : 앞뒤 공백 제거 → 소문자 → 공백 덩어리로 자르기
- 성(LastName) 은 첫 번째 단어 (parts\[0])<br>이름(FirstName) 은 두 번째 단어부터 마지막 단어까지 (parts\[1] \~ parts\[length-1])
- 이름을 먼저 공백과 함께 출력하고, 마지막에 성을 println

- 💡 parts.length > 0 검사는 사실 항상 참이다. ("".split(...) 도 길이 1 짜리 \[""] 를 반환)<br>입력이 비었는지 검사하려면 input.trim().isEmpty() 로 확인하는 편이 정확하다.
- 💡 이름이 한 단어뿐이면 (예: "KIM") 반복문이 돌지 않고 "kim" 만 출력된다.

## 3. 찾을 문자열을 모두 바꾸기

`6강 과제` · 📄 [`FindReplace.java`](FindReplace.java)

#### 문제

> 문장, 찾을 문자열, 바꿀 문자열을 입력받아 문장 속의 문자열을 모두 바꾸어 출력하시오.<br>문장을 입력하세요 : A fool and his mony are soon parted.<br>찾을 문자열: mony<br>바꿀 문자열: money<br>A fool and his money are soon parted.

#### 💻 코드

<!-- code: FindReplace.java -->
```java
import java.util.Scanner;

public class FindReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문장을 입력하세요 : ");
        String text = sc.nextLine();
        System.out.print("찾을 문자열: ");
        String target = sc.nextLine();
        System.out.print("바꿀 문자열: ");
        String replacement = sc.nextLine();

        String result = text.replace(target, replacement);
        System.out.println(result);
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
문장을 입력하세요 : dkssuddkssud world
찾을 문자열: dkssud
바꿀 문자열: hi
hihi world
```

**포인트**

- 세 입력 모두 nextLine() → 공백이 들어간 문자열도 찾고 바꿀 수 있다.
- text.replace(target, replacement) : 일치하는 "모든" 부분을 글자 그대로 치환 (정규식 X)

- 💡 replaceAll 을 쓰면 찾을 문자열을 정규식으로 해석한다.<br>예) 찾을 문자열 "." → 모든 문자가 바뀌어 버림. 사용자가 입력한 문자열을 찾을 때는 replace 가 안전하다.<br>(6-2 SearchReplace 의 replaceFirst 도 같은 문제 → 1-lecture/code/SearchReplace.java 참고)

## 4. 암호화 / 복호화 (+4 시저 암호)

`6강 과제` · 📄 [`CaesarCipher.java`](CaesarCipher.java)

#### 문제

> 아래 변환표를 이용해 영문 평문을 암호화하고, 암호문을 복호화하는 메뉴 프로그램을 작성하시오.
>
> ```text
> 평문    a b c d e f g h i j k l m n o p q r s t u v w x y z
> ```
>
> 암호문  e f g h i j k l m n o p q r s t u v w x y z a b c d
>
>     1. 암호화
>     2. 복호화
>     3. 종료
>
> 메뉴를 선택하시오: 1<br>평문을 입력하시오: meet at midnight<br>암호화된 문자열: qiix ex qmhrmklx

#### 💻 코드

<!-- code: CaesarCipher.java -->
```java
import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 암호화");
            System.out.println("2. 복호화");
            System.out.println("3. 종료");
            System.out.print("메뉴를 선택하시오: ");
            int menu = sc.nextInt();
            sc.nextLine();                                   // 남은 줄바꿈 제거

            if (menu == 1) {
                System.out.print("평문을 입력하시오: ");
                String plain = sc.nextLine().toLowerCase();
                System.out.println("암호화된 문자열: " + encrypt(plain));
            } else if (menu == 2) {
                System.out.print("암호문을 입력하시오: ");
                String cipher = sc.nextLine().toLowerCase();
                System.out.println("복호화된 문자열: " + decrypt(cipher));
            } else if (menu == 3) {
                break;
            }
        }
        sc.close();
    }

    // 암호화 : 4칸 뒤로
    static String encrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c - 'a' + 4) % 26 + 'a'));
            } else {
                sb.append(c);                                // 공백 등은 그대로
            }
        }
        return sb.toString();
    }

    // 복호화 : 4칸 앞으로 (+26 으로 음수 방지)
    static String decrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c - 'a' - 4 + 26) % 26 + 'a'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```
<!-- /code -->

#### 실행 예

```text
1. 암호화
2. 복호화
3. 종료
메뉴를 선택하시오: 1
평문을 입력하시오: meet at midnight
암호화된 문자열: qiix ex qmhrmklx
1. 암호화
2. 복호화
3. 종료
메뉴를 선택하시오: 2
암호문을 입력하시오: qiix ex qmhrmklx
복호화된 문자열: meet at midnight
1. 암호화
2. 복호화
3. 종료
메뉴를 선택하시오: 3
```

**📝 필기**

- 변환표를 보면 모든 글자가 알파벳 순서로 "4칸씩 뒤로" 밀려 있다. → 시저 암호 (Caesar cipher, +4)
- 암호화 : (c - 'a' + 4) % 26 + 'a'
  ```text
  c - 'a'     : 'a'=0, 'b'=1, ..., 'z'=25 로 바꿈
  + 4         : 4칸 이동
  % 26        : 25 를 넘으면 다시 0 부터 (w→a, x→b, y→c, z→d)
  + 'a'       : 다시 문자 코드로 → (char) 로 형변환
  ```
- 복호화 : (c - 'a' - 4 + 26) % 26 + 'a'
    - 4 를 하면 a\~d 에서 음수가 나오므로 + 26 을 먼저 더해 0\~25 범위로 맞춘다.

(자바의 % 는 음수에 대해 음수를 돌려준다 : -4 % 26 = -4)

- 공백 · 숫자 · 문장부호처럼 a\~z 가 아닌 문자는 그대로 붙인다.
- StringBuilder 의 append 로 한 글자씩 결과를 만든다. (String + 를 반복하는 것보다 효율적)

- 💡 nextInt() 뒤에 nextLine() 을 한 번 호출 → 숫자 뒤에 남은 줄바꿈 제거 (안 하면 평문 입력이 빈 줄로 넘어감)
- 💡 1\~3 이외의 숫자를 입력하면 아무 메시지 없이 메뉴가 다시 나온다.<br>숫자가 아닌 값을 입력하면 nextInt() 에서 InputMismatchException 이 발생한다.
- 💡 평문을 toLowerCase() 로 바꾸므로 대문자로 입력해도 소문자로 암호화된다.

---

[🏠 6주차 학습 가이드](../../README.md)
