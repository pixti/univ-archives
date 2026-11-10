# 6-3. 문자열 3: StringBuilder 클래스

> 원본: `6-3 문자열3.pptx`
> 관련 코드: [`examples/StringBuilderCapacity.java`](../examples/StringBuilderCapacity.java), [`examples/StringBuilderMethods.java`](../examples/StringBuilderMethods.java), [`examples/SearchReplaceBuilder.java`](../examples/SearchReplaceBuilder.java), [`quiz/StringQuiz.java`](../quiz/StringQuiz.java) (8, 9, 11번)

---

## 1. String 객체 vs StringBuilder 객체

- String 클래스는 **읽기 전용**의 문자열 객체다.
- `replace` 메소드로 다른 글자로 바꿀 수는 있지만, **새로운 객체를 생성하여 전달된다**는 점에 주의한다.
- **변경 가능한** 문자열 객체를 만들려면 **StringBuilder**를 쓴다.

```
String s = "hello";
s = s.replace("llo", "love");

  s ──X──▶ [ "hello" ]        ← 원래 객체는 그대로 (버려짐)
    └────▶ [ "helove" ]       ← 새 객체가 만들어지고 s 가 새 객체를 가리킴

StringBuilder sb = new StringBuilder("hello");
sb.replace(2, 5, "love");

  sb ────▶ [ h e l o v e ]    ← 같은 객체의 내용이 직접 바뀜
```

> 참고:
> - 📝 **필기 (퀴즈 8번):** `str1.replace("llo", "love");`만 쓰면 "재대입하지 않아서 그대로" `hello`가 나온다. StringBuilder의 `replace(2, 5, "love")`는 원본이 바뀌어 `helove`가 나온다.
> - 📝 **필기 (퀴즈 8번, AI 설명) 비교표:**
>
>   | 구분 | `String.replace("llo", "love")` | `StringBuilder.replace(2, 5, "love")` |
>   |---|---|---|
>   | 바꿀 대상 지정 | 찾을 **문자열** | **인덱스 범위** (시작, 끝) |
>   | 원본 | 그대로 (새 String 반환) | 직접 바뀜 |
>   | 재대입 | 필요 (`str = str.replace(...)`) | 필요 없음 |
>
>   예: `s = s.replace("World", "Java")`는 `"Hello Java"`, `sb.replace(0, 5, "Hi")`는 `"Hi World"`
> - 💡 반복문에서 `str = str + "a"`를 여러 번 하면 그때마다 새 String 객체가 생긴다. 문자열을 조금씩 붙여 만들 때는 StringBuilder의 `append`가 훨씬 효율적이다. (과제 문자열1 4번 암호화)
> - 💡 **StringBuffer**도 사용법은 같다. 여러 스레드에서 동시에 써도 안전한 대신 조금 느리다. 일반적인 경우에는 StringBuilder를 쓴다.
> - ⚠ 슬라이드의 "Stirng 클래스"는 String의 오타다.

---

## 2. StringBuilder 생성과 용량

- 기본으로 **16개의 문자**를 저장할 수 있고, 용량을 넘으면 용량이 자동으로 확장된다.

```java
StringBuilder str1, str2, str3;
str1 = new StringBuilder();          // 용량이 16문자인 빈 객체 생성
str2 = new StringBuilder(10);        // 용량이 10문자인 객체 생성
str3 = new StringBuilder("hello");   // 기본 용량 + "hello" 문자열의 크기만큼의 용량 → 16 + 5 = 21
```

- **length**: StringBuilder 객체의 문자열 길이
- **capacity**: StringBuilder 객체의 현재 저장 용량
- **ensureCapacity**: "현 용량 × 2 + 2"와 요구한 용량 중 **큰 용량**으로 재할당한다.

```java
StringBuilder str1 = new StringBuilder("hello");    // 21 크기의 용량
System.out.println("Old Capacity = " + str1.capacity());
str1.ensureCapacity(28);                            // 44 크기의 용량으로 확장됨
System.out.println("New Capacity = " + str1.capacity());
str1.ensureCapacity(33);                            // 44 크기의 용량 유지
System.out.println("New Capacity = " + str1.capacity());

StringBuilder str2 = new StringBuilder();           // 16 크기의 용량
System.out.println("Old Capacity = " + str2.capacity());
str2.ensureCapacity(40);                            // 40 크기의 용량으로 확장됨
System.out.println("New Capacity = " + str2.capacity());
```

```
Old Capacity = 21
New Capacity = 44
New Capacity = 44
Old Capacity = 16
New Capacity = 40
```

> 참고:
> - 📝 **필기 (퀴즈 9번, AI 설명):** length는 "물이 담긴 양", capacity는 "컵의 크기"다.
> - 📝 **내부 계산식:** `newCapacity = (value.length << 1) + 2`, 즉 현재 용량 × 2 + 2다. 이 값이 요구한 용량(minCapacity)보다 작으면 요구한 용량을 쓴다.
>
>   | 현재 | 요청 | 판단 | 결과 |
>   |---|---|---|---|
>   | 21 | `ensureCapacity(28)` | 28 > 21 → max(21×2+2 = **44**, 28) | 44 |
>   | 44 | `ensureCapacity(33)` | 33 ≤ 44 → 아무것도 안 함 | 44 |
>   | 16 | `ensureCapacity(40)` | 40 > 16 → max(16×2+2 = 34, **40**) | 40 |
> - 💡 `<< 1`은 비트를 왼쪽으로 한 칸 미는 연산으로, × 2와 같다.
> - 💡 용량은 **성능**에만 영향을 준다. 용량이 부족해도 append는 자동으로 확장되므로 결과는 같다. 들어갈 글자 수를 대략 알면 처음부터 `new StringBuilder(100)`처럼 넉넉하게 잡아 재할당 횟수를 줄일 수 있다.

---

## 3. append · insert

- **append**: 현재 문자열 뒤에 새 문자열을 붙인다. **원본 문자열이 바뀐다는 점에 주의한다.**
- **insert**: 특정 위치에 문자열이나 수치형 값을 넣는다.

```java
StringBuilder sb = new StringBuilder();
sb.append("hello");
sb.append(123);
sb.append(33.333);              // hello12333.333

StringBuilder str = new StringBuilder("Tutorial");
str.insert(8, 's');             // Tutorials
```

> 참고:
> - 💡 `append`와 `insert`는 int, double, char, boolean 등 무엇이든 받아 **문자열로 바꿔** 붙인다.
> - 💡 `insert(8, 's')`에서 8은 "Tutorial"의 길이다. 길이와 같은 위치에 넣으면 맨 뒤에 붙는다. 길이보다 크면 `StringIndexOutOfBoundsException`이 발생한다.
> - 💡 `append`는 자기 자신(StringBuilder)을 돌려준다. 그래서 `sb.append("a").append(1).append('b');`처럼 이어 쓸 수 있다. (메소드 체이닝)

---

## 4. delete · replace

- **delete**: 문자열에서 특정 문자를 제거한다.
- **replace**: 문자열에서 특정 문자를 치환한다.

```java
// sb 문자열에서 인덱스 4번부터 6번까지 제거
sb.delete(4, 7);
// sb 문자열에서 인덱스 2번부터 6번까지를 "Love"로 치환
sb.replace(2, 7, "Love");
```

```
"Tutorials".delete(4, 7)
 인덱스  0 1 2 3 4 5 6 7 8
 문자    T u t o r i a l s
                 └─┬─┘           인덱스 4, 5, 6 제거  → "Tutols"

"Tutols".replace(2, 7, "Love")   인덱스 2 ~ 끝을 "Love"로  → "TuLove"
```

> 참고:
> - 💡 `(시작, 끝)` 범위에서 **끝은 포함하지 않는다.** substring과 같은 규칙이다.
> - 💡 `replace`의 끝 인덱스가 길이보다 크면 문자열 끝까지로 처리된다. 위 예에서 "Tutols"의 길이는 6인데 7을 줘도 동작한다.
> - ⚠ 슬라이드의 `“Love”`는 스마트 따옴표다.

---

## 5. reverse · substring

- **reverse**: 문자열의 순서를 거꾸로 바꾼다.
- **substring**: 부분 문자열을 얻는다.

```java
sb.reverse();
String s1 = sb.substring(3);      // 인덱스 3번부터 끝까지의 문자들로 구성된 부분 문자열
String s2 = sb.substring(3, 5);   // 인덱스 3번부터 4번까지의 문자들로 구성된 부분 문자열
```

> 참고:
> - 💡 `reverse()`는 원본을 바꾸지만, `substring()`은 **String을 새로 돌려줄 뿐** sb는 그대로다.
> - 💡 회문 검사에 `new StringBuilder(str).reverse().toString()`을 쓸 수 있다. (실습 문자열1 2번 💡)
> - ⚠ 슬라이드는 `String s`를 두 번 선언해서 그대로는 컴파일되지 않는다. 예제 코드에서는 s1, s2로 나눴다.

---

## 6. indexOf · charAt · setCharAt · deleteCharAt · toString

| 메소드 | 설명 |
|---|---|
| `indexOf(str)` | 특정 문자(열)의 위치를 찾는다. 없으면 -1 |
| `charAt(i)` | 특정 위치의 문자를 읽는다. |
| `setCharAt(i, c)` | 특정 위치의 문자를 수정한다. |
| `deleteCharAt(i)` | 특정 위치의 문자를 삭제한다. |
| `toString()` | String 객체로 변환한다. |

```java
StringBuilder sb = new StringBuilder("I Leve You.!");
char c = sb.charAt(3);       // 인덱스 3번째 위치의 문자 반환       → 'e'
sb.setCharAt(3, 'o');        // 인덱스 3번째 위치의 문자를 'o'로 변경 → "I Love You.!"
sb.deleteCharAt(11);         // 인덱스 11번째 위치의 문자를 제거      → "I Love You."
String result = sb.toString();
```

> 참고:
> - 💡 `String`에는 `setCharAt`이 없다. 한 글자를 고치려면 6-1처럼 `toCharArray()`로 배열을 만들어 고친 뒤 `new String(t)`를 하거나, StringBuilder를 쓴다.
> - 💡 StringBuilder끼리는 `equals`가 **내용을 비교하지 않는다.** (Object의 equals 그대로라 `==`와 같다.) 내용을 비교하려면 `sb1.toString().equals(sb2.toString())`처럼 String으로 바꿔서 비교한다.
> - 📝 **필기 (퀴즈 11번):** 메소드를 연속으로 호출한 결과
>
>   | 호출 | sb의 상태 |
>   |---|---|
>   | `append("hello")`, `append(33.333)` | `hello33.333` |
>   | `insert(8, 's')` | `hello33.s333` |
>   | `delete(4, 7)` | `hell.s333` |
>   | `reverse()` | `333s.lleh` |
>   | `substring(3, 5)` | `s.` (반환값, sb는 그대로) |
>   | `charAt(3)` | `s` |
>   | `setCharAt(3, 'o')` | `333o.lleh` |
>   | `deleteCharAt(3)` | `333.lleh` |
>
>   AI 설명의 번호 매기기에서는 charAt 단계(6번)가 빠져 있었다.

---

## 7. [실습] 부분 문자열 바꾸기: 이전 프로그램 수정

6-2의 SearchReplace(String의 `replaceFirst` 사용)를 StringBuilder로 다시 만든다.

```java
Scanner sc = new Scanner(System.in);
System.out.println("문장 입력 : ");
StringBuilder statement = new StringBuilder(sc.nextLine());

System.out.println("찾고자 하는 단어 : ");
String sword = sc.next();

System.out.println("바꾸고자 하는 단어 : ");
String rword = sc.next();

int start = statement.indexOf(sword);
int end = start + sword.length();
statement.replace(start, end, rword);   // 원본 문자열이 변경됨
System.out.println(statement);
```

> 참고:
> - 💡 `start + sword.length()`는 찾은 단어 **바로 다음** 인덱스다. replace의 끝 인덱스는 포함하지 않으므로 단어만 정확히 바뀐다.
> - 💡 String 버전과 달리 정규식이 아니라 **글자 그대로** 찾는다. 그래서 `.`이나 `+`가 들어간 단어도 문제없다.
> - ⚠ 찾는 단어가 없으면 `indexOf`가 **-1**을 돌려준다. 그러면 `replace(-1, ...)`에서 `StringIndexOutOfBoundsException`이 발생한다. 예제 코드에는 `if (start != -1)` 검사를 추가했다.
