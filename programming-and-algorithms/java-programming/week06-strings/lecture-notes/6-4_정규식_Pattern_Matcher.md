# 6-4. 문자열 4: 정규식 관련 클래스 (String.matches · Pattern · Matcher)

> 원본: `6-4 문자열4.pptx` (+ 실습 자료의 "정규식 설명")
> 관련 코드: [`examples/RegexMatches.java`](../examples/RegexMatches.java), [`examples/PatternMatcherFind.java`](../examples/PatternMatcherFind.java), [`examples/RegularExpression.java`](../examples/RegularExpression.java), [`practice/strings1/RegexCatDog.java`](../practice/strings1/RegexCatDog.java), [`quiz/StringQuiz.java`](../quiz/StringQuiz.java) (5, 7, 10번)

---

## 1. 정규식이란?

- 정규식(Regular Expression)은 텍스트를 표현하는 간결하고 융통성 있는 표기법이다. 즉 **텍스트 패턴을 기술하는 표기법**이다.
- 정규식을 쓰면 많은 양의 텍스트를 빠르게 분석하고 처리할 수 있다.
- `java.util.regex` 패키지의 **Pattern 클래스**와 **Matcher 클래스**가 정규식 기능을 제공한다.

> 참고:
> - 💡 지금까지 나온 String 메소드 중 `split`, `replaceAll`, `replaceFirst`, `matches`는 인자를 **정규식**으로 해석한다. `replace`, `indexOf`, `contains`, `startsWith`는 글자 그대로 찾는다.
> - 📝 **필기 (과제 문자열2 4번, AI 설명):** String은 `java.lang` 패키지라 자동으로 import되므로 `matches`/`split`/`replaceAll`은 import 없이 쓸 수 있다. 반면 Pattern과 Matcher는 `java.util.regex` 패키지에 있어서 **import가 필요하다.**

---

## 2. 문자 클래스

| 문자 클래스 | 의미 |
|---|---|
| `.` | `\n`을 제외한 모든 문자 |
| `[aeiou]` | 지정된 문자 집합 (a, e, i, o, u 중 하나) |
| `[^aeiou]` | 지정되지 않은 문자 집합 (a, e, i, o, u를 **제외**한 하나) |
| `[0-9a-fA-F]` | 하이픈으로 연속된 범위의 문자를 지정 |
| `\d` | 임의의 숫자 문자 = `[0-9]` |
| `\D` | 임의의 숫자가 아닌 문자 = `[^0-9]` |
| `\w` | 임의의 단어 문자 (알파벳, 숫자, 언더바) = `[A-Za-z0-9_]` |
| `\W` | 임의의 단어가 아닌 문자 = `[^A-Za-z0-9_]` |
| `\s` | 임의의 공백 문자 (스페이스, 탭, 줄바꿈) = `[ \t\n]` |
| `\S` | 임의의 공백이 아닌 문자 = `[^ \t\n]` |
| `^` | 문자열의 시작 |
| `$` | 문자열의 끝 |

> 참고:
> - ⚠ 슬라이드의 `\S` 행은 "= = [^ \t\n]"처럼 `=`가 두 번 들어간 오타다.
> - 💡 `[가-힣]`은 한글 완성형 한 글자다. 실습(RegularExpression)의 이름과 주소 검사에 쓰인다.
> - 💡 대괄호 `[ ]` 안에서는 `.`, `+`, `|`가 **특수문자가 아니라 글자 그대로**다. 예: `[ :,.0-9]`
> - 💡 `^`의 의미는 위치에 따라 달라진다. 대괄호 **안 맨 앞**이면 "제외"(`[^abc]`), 대괄호 **밖**이면 "문자열의 시작"(`^abc`)이다.
> - 📝 **필기 (실습 문자열1 1번):** `0-9` 같은 범위는 대괄호 **안에서만** 범위로 해석된다. 대괄호 밖에서는 `\\d`를 쓴다.

---

## 3. 수량자

| 수량자 | 설명 |
|---|---|
| `*` | 0개 이상 일치 (예: `\w*`, `(abc)*`). `{0,}`에 해당 |
| `+` | 1개 이상 일치 (예: `\w+`, `(abc)+`). `{1,}`에 해당 |
| `?` | 0개 또는 1개 일치 (예: `\w?`, `(abc)?`). `{0,1}`에 해당 |
| `{n}` | 정확하게 n개 일치 (예: `(pizza){2}`) |
| `{n,}` | n개 이상 일치 (예: `(abc){2,}`) |
| `{n,m}` | n개 이상, m개 이하 일치 |

> 참고:
> - 💡 수량자는 **바로 앞의 한 덩어리**에만 붙는다. `ab+`는 a 뒤에 b가 1개 이상이고, `(ab)+`는 "ab"가 1번 이상이다.
> - 📝 **필기 (퀴즈 7번, AI 설명):** `\-?`는 "하이픈이 있어도 되고 없어도 된다"는 뜻이다.
> - 💡 예: `01[01]\-?\d{4}\-?\d{4}`는 `010-1234-5678`과 `01012345678`을 모두 허용한다.

---

## 4. 실습 자료의 정규식 설명 (요약)

| 구분 | 표기 | 의미 / 예 |
|---|---|---|
| OR | `\|` | `four\|4`는 "four" 또는 "4" |
| 대괄호 목록 | `[...]`, `[.-.]`, `[^...]` | 목록 중 하나 / 범위 / 제외. 대괄호 안에서 이스케이프가 필요한 문자는 `^ - ] \` 정도 |
| 반복 | `+ * ? {m,n} {m} {m,}` | 3절 수량자 표와 같음 |
| 메타 문자 | `. \d \D \w \W \s \S` | 공백 `\s` = `[ \n\r\t\f]` |
| 위치 앵커 | `^ $` | 줄(문자열)의 시작 / 끝 |
| 단어 경계 | `\b`, `\B` | `\b`는 단어 경계, `\B`는 단어 경계가 아닌 곳. 예: `\bcat\b`는 단어 "cat" 전체, `\bcat\B.*`는 "cat"으로 시작하는 더 긴 단어(cats, category 등) |

> 참고:
> - 📝 **필기 (실습 문자열2 2번, AI 설명):** `\Bg\B`는 단어 **가운데**의 g(PostgreSQL), `\Bg\b`는 단어 **끝**의 g(dog), `\bg\B`는 단어 **시작**의 g(gizzards)를 찾는다. → [`practice/strings2/MiddleG.java`](../practice/strings2/MiddleG.java)
> - 📝 **필기 (퀴즈 5번, AI 설명) 자바에서 정규식 쓰기:** 자바 문자열 안에서 `\`는 이스케이프 문자라서 정규식의 `\`는 `\\`로 두 번 쓴다. 정규식 `^\d{5}$`는 `Pattern.compile("^\\d{5}$")`로 쓴다.

---

## 5. String 클래스의 matches

**matches**: 문자열이 정규식으로 주어진 패턴과 부합하는지 확인한다.

```java
String regExp = "01[078]-\\d{4}-\\d{4}";
String str = new String("010-5182-0173");
System.out.println(str.matches(regExp));   // 부합    → true

str = new String("013-5182-0173");
System.out.println(str.matches(regExp));   // 부합 X  → false (세 번째 자리 3)

str = new String("010-518-0173");
System.out.println(str.matches(regExp));   // 부합 X  → false (가운데 3자리)
```

> 참고:
> - 📝 **필기 (퀴즈 7번):** "01[078] 010, 017, 018 중 하나"
> - 📝 **필기 (AI 설명):** 정규식을 부분별로 나누면 다음과 같다.
>
>   | 부분 | 의미 |
>   |---|---|
>   | `01` | "01" 그대로 |
>   | `[078]` | 0, 7, 8 중 한 글자 |
>   | `-` | 하이픈 그대로 |
>   | `\\d{4}` | 숫자 4개 |
> - 💡 `matches`는 문자열 **전체**가 패턴과 일치해야 true다. `^`, `$`를 붙이지 않아도 전체 일치로 검사한다. 문자열 안에 패턴이 **포함**되어 있는지 보려면 앞뒤에 `.*`를 붙이거나(`".*c.t.*"`) Matcher의 `find()`를 쓴다. (실습 문자열1 RegexCatDog 📝)
> - ⚠ 슬라이드의 `“010-5182-0173"`은 여는 따옴표가 스마트 따옴표다.

---

## 6. Pattern, Matcher 클래스

1. Pattern 클래스의 `compile` 메소드로 Pattern 객체를 만든다.
2. 주어진 문자열이 정규식과 부합하는지 검사하려면 **Matcher 객체**를 만들어야 한다.

```java
String input = "I have a cat, but I like my dog better.";
Pattern p = Pattern.compile("(cat|dog)");
Matcher m = p.matcher(input);
```

Matcher 객체를 만든 뒤 `matches`, `lookingAt`, `find`로 검사한다. 세 메소드의 반환값은 모두 **boolean**이다.

| 메소드 | 의미 |
|---|---|
| `matches()` | 주어진 입력 **전체**가 패턴과 일치하는지 검사 |
| `lookingAt()` | 주어진 입력의 **앞부분(prefix)** 이 패턴과 일치하는지 검사 |
| `find()` | 패턴과 부합하는 문자열을 **계속해서** 찾음 (호출할 때마다 다음 것) |

일치한 위치나 정보는 `start`, `end`, `group` 메소드로 얻는다.

| 메소드 | 의미 |
|---|---|
| `start()` | 일치한 부분의 시작 인덱스 |
| `end()` | 일치한 부분의 **끝 인덱스 + 1** |
| `group()` | 일치한 문자열 |

> 참고:
> - 💡 위 예에서 `m.matches()`와 `m.lookingAt()`은 모두 false다. 전체도 앞부분도 cat/dog가 아니기 때문이다. `find()`로는 `cat`(9~11)과 `dog`(28~30)를 차례로 찾는다.
> - 📝 **필기 (퀴즈 10번, AI 설명):** `compile`은 정규식을 **미리 해석(컴파일)** 해 두는 것이다. 같은 패턴으로 여러 번 검사할 때 효율적이다. 앞에서 변수를 선언하지 않았다면 `Pattern pattern = Pattern.compile(...)`처럼 타입을 함께 써야 한다.
> - 📝 **필기 (과제 문자열2 4번, AI 설명) String 메소드 vs Pattern/Matcher:**
>
>   | 구분 | String 메소드 (`matches`, `split`, `replaceAll`) | Pattern / Matcher |
>   |---|---|---|
>   | import | 필요 없음 (`java.lang`) | 필요 (`java.util.regex`) |
>   | 용도 | 전체 일치 검사, 자르기, 치환 | `find`/`group` 반복 → 개수나 위치 찾기 |
>   | 성능 | 호출할 때마다 정규식을 새로 컴파일 | 한 번 compile한 패턴을 재사용 |

---

## 7. "꽃" or "고향" or "산골" 찾아서 위치와 내용 출력

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ProgramBasic {
    public static void main(String[] args) {
        String input = "나의 살던 고향은 꽃 피는 산골 봉숭아 꽃 살구 꽃";
        Pattern p = Pattern.compile("(꽃|고향|산골)");
        Matcher m = p.matcher(input);
        while (m.find()) {
            System.out.println(m.start() + "에서 부터" + (m.end()-1) +
                "까지 " + m.group() + " 발견");
        }
    }
}
```

```
6에서 부터7까지 고향 발견
10에서 부터10까지 꽃 발견
15에서 부터16까지 산골 발견
22에서 부터22까지 꽃 발견
27에서 부터27까지 꽃 발견
```

> 참고:
> - 💡 `end()`는 마지막 글자 **다음** 인덱스라서 마지막 글자 위치를 보여 주려고 `m.end()-1`로 출력한다.
> - 💡 `while (m.find())`는 더 이상 찾을 것이 없을 때(false)까지 반복한다. `find()`를 직접 여러 번 부르는 것보다 몇 개가 있든 처리할 수 있다. (실습 문자열1 RegexCatDog 📝: 처음에는 find()를 세 번 직접 호출했다가 while로 바꿨다.)
> - 💡 개수를 세려면 `while (m.find()) count++;`처럼 쓴다. (과제 문자열2 4번 모음 개수)
> - ⚠ 슬라이드 제목의 `“고향＂`은 전각 따옴표가 섞여 있다.

---

## 8. [실습] 정규식을 이용한 사용자 입력 값 검사

사용자에게 이름, 주소, 우편번호, 핸드폰 번호를 입력받아 유효성을 검증한다.

- 이름은 한글 2~4글자
- 주소는 "…도 …시 …로 000" 형태
  - 도명은 한글 3~5글자이고 끝자리는 '도'
  - 시명은 한글 3~5글자이고 끝자리는 '시'
  - 도로명은 한글 3~7글자이고 끝자리는 '로'
  - 지번은 2~4자리 숫자
- 우편번호는 5자리 숫자
- 핸드폰 번호는 "010-xxxx-xxxx" 또는 "011-xxxx-xxxx" 형태

| 항목 | 정규식 |
|---|---|
| 이름 | `^[가-힣]{2,4}$` |
| 주소 | `^[가-힣]{2,4}도\s+[가-힣]{2,4}시\s+[가-힣]{2,6}로\s+\d{2,4}$` |
| 우편번호 | `^\d\d\d\d\d$` 또는 `^\d{5}$` |
| 핸드폰 | `^01[01]-\d{4}-\d{4}$` |

```java
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

input = sc.nextLine();
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
```

```
이름 :
김병만
주소 :
경기도 수원시 월드컵로 206
우편번호 :
16499
핸드폰 번호 :
010-1234-5678
모든 자료를 형식에 맞게 입력하셨습니다.
```

> 참고:
> - 💡 **`input = sc.nextLine();`을 한 번 더 부르는 이유:** `next()`는 단어만 읽고 엔터(줄바꿈)를 버퍼에 남긴다. 바로 `nextLine()`을 부르면 남은 줄바꿈만 읽고 끝나 버린다. 그래서 줄바꿈을 한 번 비운 뒤, 공백이 들어간 주소를 `nextLine()`으로 읽는다.
> - 💡 **슬라이드 설명과 정규식의 글자 수:** 언뜻 다르게 보이지만 끝자리를 포함해서 세면 맞는다. `[가-힣]{2,4}도`는 "도" 앞 2~4글자 + "도"라서 합쳐 **3~5글자**다. `[가-힣]{2,6}로`도 마찬가지로 3~7글자다.
> - 💡 `return`은 main 메소드를 바로 끝낸다. 형식이 틀리면 뒤의 항목은 입력받지 않는다.
> - 📝 **필기 (퀴즈 10번):** 핸드폰 번호 부분이 빈칸 채우기로 나왔다. 정답은 `"^01[01]-\\d{4}-\\d{4}$"`, `pattern.matcher(input)`, `!m.matches()`다.
> - ⚠ 슬라이드 12쪽의 `Pattern.compiles(“...` 는 오타다. `compile`이 맞고, 여는 따옴표도 스마트 따옴표다. 또 정규식 문자열이 중간에서 줄바꿈되어 있는데, 자바 문자열 리터럴은 줄을 넘길 수 없으므로 `+`로 이어야 한다.
> - ⚠ 슬라이드 10쪽의 정규식 표는 자바 코드가 아니라 정규식 그대로의 표기(`\s`, `\d`)다. 코드에서는 `\\s`, `\\d`로 쓴다.
