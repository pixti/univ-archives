# 6-2. 문자열 2: 문자열 분리 (split) · 문자열 포맷 · String 실습

> 원본: `6-2 문자열2.pptx`
> 관련 코드: [`examples/SplitTest.java`](../examples/SplitTest.java), [`examples/FormatTest.java`](../examples/FormatTest.java), [`examples/IDPassword.java`](../examples/IDPassword.java), [`examples/SearchReplace.java`](../examples/SearchReplace.java), [`examples/VariableSum.java`](../examples/VariableSum.java), [`quiz/StringQuiz.java`](../quiz/StringQuiz.java)

---

## 1. 문자열 분리: split

**split**: 분리 문자를 기준으로 문자열을 나눈다.

```java
String delimStr = " ";                  // 분리 문자
String words = "minus one two,three:four.five";
String [] split = null;

split = words.split(delimStr);          // 분리 후 문자열 배열에 담음
for (String s : split) System.out.println("-"+s+"-");
```

```
-minus-
-one-
-two,three:four.five-
```

> 참고:
> - 💡 분리 문자가 공백 `" "` 하나뿐이라 쉼표·콜론·점에서는 나뉘지 않는다. 그래서 `two,three:four.five`가 한 덩어리로 남는다. (퀴즈 6번)
> - 📝 **필기 (퀴즈 6번, AI 설명):** split의 인자는 **정규식**이다. `.`, `+`, `|` 같은 특수문자로 나누려면 `\\.`처럼 이스케이프해야 한다.
>
>   | 코드 | 결과 |
>   |---|---|
>   | `words.split(" \|,\|:\|\\.")` | `minus`, `one`, `two`, `three`, `four`, `five` |
>   | `"a.b.c".split(".")` | 길이 **0**: `.`은 "모든 문자"라서 전부 구분자가 된다. |
>   | `"a.b.c".split("\\.")` | `a`, `b`, `c` |
> - 💡 split의 두 가지 성질은 실습과 과제에서 계속 나온다.
>   - 문자열 **맨 뒤**에 생기는 빈 문자열은 자동으로 지워진다.
>   - **맨 앞**에 구분자가 있으면 결과 배열의 첫 원소가 빈 문자열 `""`이 된다. (실습 문자열1 1번 "2로 나오는 문제", 과제 문자열1 1번 trim)
> - 💡 구분자가 여러 개 이어질 수 있으면 `+`를 붙인다. 예: `"\\s+"`, `"( |,|\\.)+"`

---

## 2. 문자열 포맷하기: printf · String.format

- `java.io.PrintStream` 클래스의 `printf`와 `format`으로 결과를 포맷해 출력할 수 있다.
- **String 클래스의 `format`** 은 결과로 **String 객체를 반환**한다. 바로 출력하지 않고 문자열로 저장해 둘 수 있다.

```java
// PrintStream 의 printf 메소드 사용
String formatStr = "학과 %s - 최대값 : %d, 최소값 : %d, 평균 : %.1f";
System.out.printf(formatStr, depart, max, min, avg);

// String 클래스의 format 메소드로 재작성
String formatStr2 = "학과 %s - 최대값 : %d, 최소값 : %d, 평균 : %f";
String fs = String.format(formatStr2, depart, max, min, avg);
System.out.println(fs);
```

```
학과 컴퓨터공학 - 최대값 : 98, 최소값 : 72, 평균 : 85.3
학과 컴퓨터공학 - 최대값 : 98, 최소값 : 72, 평균 : 85.333333
```

> 참고:
> - 💡 **서식 지정자:**
>
>   | 지정자 | 의미 |
>   |---|---|
>   | `%s` | 문자열 |
>   | `%d` | 정수 |
>   | `%f` | 실수. 기본은 소수점 아래 6자리 |
>   | `%.1f` | 소수점 아래 1자리까지 (반올림) |
>   | `%5d` | 5칸 폭으로 오른쪽 정렬 |
>   | `%n` | 줄바꿈 |
> - 💡 `printf`는 줄을 바꾸지 않는다. 줄을 바꾸려면 서식 끝에 `%n`이나 `\n`을 붙인다.
> - 💡 실행 결과의 값(depart, max, min, avg)은 슬라이드에 없어서 예제 코드에서 정했다.
> - ⚠ 슬라이드는 `String formatStr`을 두 번 선언해서 그대로는 컴파일되지 않는다. 따옴표도 스마트 따옴표(`“ ”`)다.

---

## 3. [실습] 아이디와 패스워드 검사

```java
import java.util.Scanner;
public class IDPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("아이디 : ");
        String login = sc.next();
        System.out.println("패스워드 : ");
        String password = sc.next();

        login = login.trim();                  // 앞뒤 공백 제거
        password = password.trim();

        login = login.toLowerCase();           // 소문자로 변환
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
    }
}
```

> 참고:
> - 💡 `trim()`, `toLowerCase()`는 새 문자열을 돌려주므로 `login = login.trim();`처럼 **다시 대입**한다. (String 불변)
> - 💡 `sc.next()`는 공백 앞까지만 읽기 때문에 이미 앞뒤 공백이 없다. 여기서 `trim()`은 사실상 필요 없다. `nextLine()`으로 읽을 때 의미가 있다.
> - 💡 실제 서비스에서는 비밀번호를 소문자로 바꾸면 안 된다. `Koala`와 `koala`가 같은 비밀번호가 되어 버린다. 아이디만 대소문자를 무시하려면 `equalsIgnoreCase`를 쓰는 방법도 있다.

---

## 4. [실습] 부분 문자열 검색 및 치환하기

```java
import java.util.Scanner;
public class SearchReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문장 입력 : ");
        String statement = sc.nextLine();      // 공백 고려 nextLine

        System.out.println("찾고자 하는 단어 : ");
        String sword = sc.next();

        System.out.println("바꾸고자 하는 단어 : ");
        String rword = sc.next();

        statement = statement.replaceFirst(sword, rword);
        System.out.println(statement);
    }
}
```

```
문장 입력 :
I love you. You love me.
찾고자 하는 단어 :
love
바꾸고자 하는 단어 :
like
I like you. You love me.
```

> 참고:
> - 💡 `replaceFirst`는 **첫 번째로** 일치하는 부분만 바꾼다. 모두 바꾸려면 `replaceAll`이나 `replace`를 쓴다.
> - 💡 `replaceFirst`/`replaceAll`의 첫 번째 인자는 **정규식**이다. 사용자가 `.`이나 `+`가 들어간 단어를 입력하면 의도와 다르게 동작한다. 글자 그대로 찾으려면 `Pattern.quote(sword)`로 감싸거나 `replace`를 쓴다.
> - 💡 같은 프로그램을 StringBuilder로 다시 만든 버전이 6-3에 있다. → [`examples/SearchReplaceBuilder.java`](../examples/SearchReplaceBuilder.java)

---

## 5. [실습] 가변 개수의 숫자 더하기

```java
import java.util.Scanner;
public class ConditionOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자들을 공백으로 구분하여 입력 : ");
        String statement = sc.nextLine();

        String [] split = null;
        split = statement.split(" ");
        int sum = 0;
        for (String s : split) sum += Integer.parseInt(s);
        System.out.println(sum);
    }
}
```

```
숫자들을 공백으로 구분하여 입력 :
1 2 3 4
10
```

> 참고:
> - 💡 `Integer.parseInt(s)`는 문자열 `"12"`를 정수 `12`로 바꾼다. 숫자가 아닌 문자열이면 `NumberFormatException`이 발생한다.
> - ⚠ 클래스 이름 `ConditionOperation`은 이전 슬라이드에서 그대로 복사한 것으로 보인다. 예제 파일은 내용에 맞게 `VariableSum`으로 이름을 바꿨다.
> - ⚠ `split(" ")`은 공백이 **두 칸 이상**이거나 맨 앞에 공백이 있으면 빈 문자열 `""`이 생긴다. 그러면 `Integer.parseInt("")`에서 `NumberFormatException`이 발생한다. `statement.trim().split("\\s+")`로 쓰면 안전하다.
