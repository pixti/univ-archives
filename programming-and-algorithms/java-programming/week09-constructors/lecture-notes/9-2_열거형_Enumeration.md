# 9-2. 열거형 (Enumerations)

> 원본: `9-2 Enumeration.pptx`
> 관련 코드: [`examples/SuitEnumTest.java`](../examples/SuitEnumTest.java), [`practice/datetime-enum/`](../practice/datetime-enum/) (1~3번)

---

## 1. 열거된 값

- 열거된 값들은 **이름이 붙은 값**들을 나타내는 데 쓴다.
- 역사적으로 Java(및 다른 언어)에서는 이런 값들을 흔히 **상수**로 처리했다.
- 예를 들어 Java에서는 카드 무늬(suit)를 이렇게 표현했다.

```java
public static final int SUIT_CLUBS = 0;
public static final int SUIT_DIAMONDS = 1;
public static final int SUIT_HEARTS = 2;
public static final int SUIT_SPADES = 3;
```

> 참고:
> - 💡 `static final`은 "클래스당 하나 + 값 변경 불가", 즉 **상수**다. (7강 8-2 `static final double PI`, 9-3 상수 필드 참고)

---

## 2. 이런 방법의 문제점

1. 허용되는 값이 명확하지 않음
2. 유형 안전성 없음 (No Type Safety)
3. 이름 공간 없음 (No Name-Spacing)
4. 의미 있는 이름으로 인쇄할 수 없음 (Not Printable)

### 2-1. 허용되는 값이 명확하지 않음

- Swing의 `JLabel` 클래스에서 제공하는 아래 메소드를 보자.

```java
public void setHorizontalAlignment(int alignment) {
    /* ... */
}
```

- 인수가 그냥 정수이기 때문에 가능한 값이 무엇인지 알아보기 힘들다.
- 유효한 값이 무엇인지에 대한 단서가 있는가? → 관련 문서를 읽어야만 알 수 있다.

### 2-2. 유형 안전성 없음 (No Type Safety)

- 값이 그냥 정수이므로 컴파일러는 **아무 정수나** 유효하다고 판단한다.
- 예를 들어 다음 메소드에 `1`, `-3`, `438523423`을 전달하는 것을 막을 수 없다.
- "suit" 정수(0~3)로만 제한할 방법이 없다.

```java
public void drawSuitOnCard(int suit) {
    /* ... */
}
```

### 2-3. 이름 공간 없음 (No Name-Spacing)

- 카드 예시에서는 각 무늬에 `SUIT_` 접두사를 붙였다.
- 같은 클래스의 **다른 열거 값과 구분하기 위해** 모든 상수 앞에 접두사를 붙인 것이다.
- 예를 들어 카드 면(Jack, Queen 등)도 상수로 정의한다면, 그 값이 카드 면이라는 것을 분명히 하려고 `FACE_ACE`처럼 접두사를 붙이게 된다.

### 2-4. 의미 있는 이름으로 인쇄할 수 없음 (Not Printable)

- 그냥 정수이기 때문에 값을 출력하면 숫자만 나온다. (`SUIT_HEARTS`를 출력하면 `2`)
- 메소드 매개변수를 읽을 때와 비슷한 문제가 생긴다. 값을 해독하려면 문서를 찾아봐야 한다.

---

## 3. 열거형 (enum)

- 위 문제의 해결책으로 **Java 5부터** 열거형 유형을 추가했다.
- `class` 대신 **`enum`** 키워드로 선언한다.
- 가장 간단한 형태는 가능한 옵션을 **쉼표로 구분한 이름 목록**이다.

```java
public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
```

> 참고:
> - 💡 열거형도 클래스처럼 **하나의 자료형**이다. `Suit`형 변수에는 `Suit.CLUBS`, `Suit.DIAMONDS`, `Suit.HEARTS`, `Suit.SPADES`(와 `null`)만 들어갈 수 있다.
> - 💡 열거 상수 이름은 상수처럼 대문자로 짓는 것이 관례다.
> - 💡 `public enum`은 `public class`처럼 파일 이름과 같아야 한다(`Suit.java`). 한 파일에 같이 넣으려면 `public`을 빼거나 클래스 **안에** 선언한다. 슬라이드의 이클립스 화면에 `Test.Suit`라고 나오는 것은 `Suit`가 `Test` 클래스 안에 선언되었기 때문이다.

---

## 4. 열거형으로 기존 문제점 해결하기

### 4-1. 명확하지 않은 허용 값 → 반드시 열거형에 나열된 값 중 하나만 선택

```java
public void drawSuitOnCard(Suit suit) {
    /* ... */
}
```

- 이클립스에서 `drawSuitOnCard(Suit.`까지 입력하면 자동 완성 목록에 `CLUBS`, `DIAMONDS`, `HEARTS`, `SPADES`가 나온다. 문서를 찾아보지 않아도 허용 값을 바로 알 수 있다.

### 4-2. No safety → 컴파일러가 가능한 값 중 하나만 허용

```java
drawSuitOnCard(9452435);   // ❌ 컴파일 오류
```

```
The method drawSuitOnCard(Test.Suit) in the type Test is not applicable for the arguments (int)
```

### 4-3. No Name-Spacing → 열거형 자체가 이름 공간 역할

- `SUIT_HEARTS` 대신 `Suit.HEARTS`로 쓴다. 열거형 이름(`Suit`)이 접두사 역할을 하므로 다른 열거형(예: `Face.ACE`)과 이름이 겹쳐도 상관없다.

### 4-4. Not printable → 열거 값이 숫자가 아니라 이름으로 출력

```java
System.out.print("Card is a Queen of " + Suit.HEARTS);
// Prints "Card is a Queen of HEARTS"
```

---

## 5. 기타 이점

### 5-1. 모든 가능한 열거 값을 검색 가능

- 모든 열거형에는 그 유형에 열거된 모든 값의 **배열을 돌려주는 `values()` 메소드**가 자동으로 제공된다.

```java
Suit[] suits = Suit.values();
for (Suit s : suits) {
    System.out.println(s);
}
```

```
CLUBS
DIAMONDS
HEARTS
SPADES
```

> 참고:
> - ⚠ 슬라이드 본문에는 `value()`라고 적혀 있지만 실제 메소드 이름은 **`values()`**(끝에 s)다. 슬라이드의 코드는 `values()`로 맞게 되어 있다.

### 5-2. 열거형 값 비교 가능

- `==` 연산자로 열거형 값을 비교할 수 있다.

```java
if (suit == Suit.CLUBS) {
    // do something
}
```

> 참고:
> - 💡 각 열거 상수는 프로그램 안에 **딱 하나의 객체**만 존재한다. 그래서 문자열(6강)과 달리 `equals()` 대신 `==`로 비교해도 안전하다.
> - 💡 실습 Enum 2번(Shape)에서 `firstShape == secondShape`로 비교했다.

### 5-3. 열거형을 switch 문에서 사용 가능

```java
Suit suit = /* ... */;

switch (suit) {
    case CLUBS:
    case SPADES:
        // do something
        break;
    case HEARTS:
    case DIAMONDS:
        // do something else
        break;
    default:
        // yet another thing
        break;
}
```

> 참고:
> - 💡 `case`에는 `Suit.CLUBS`가 아니라 `CLUBS`처럼 **상수 이름만** 쓴다. (switch의 자료형이 이미 `Suit`라서)
> - 💡 `case CLUBS:` 다음에 `break`가 없으므로 `CLUBS`와 `SPADES`는 같은 코드를 실행한다(검은색 무늬). `HEARTS`와 `DIAMONDS`도 마찬가지(빨간색 무늬). 3강 switch의 fall-through와 같다.

---

## 6. 💡 정리: 열거형에서 자주 쓰는 메소드

슬라이드에는 없지만 실습에서 쓰거나 알아 두면 좋은 메소드다.

| 메소드 | 설명 | 예 (`Suit.HEARTS`) |
|---|---|---|
| `values()` | 모든 상수를 배열로 (static) | `Suit.values()` → `[CLUBS, DIAMONDS, HEARTS, SPADES]` |
| `valueOf(String)` | 이름(문자열) → 상수 (static) | `Suit.valueOf("HEARTS")` → `HEARTS` |
| `name()` / `toString()` | 상수 → 이름(문자열) | `"HEARTS"` |
| `ordinal()` | 선언된 순서 (0부터) | `2` |

- 자바가 미리 만들어 둔 열거형도 있다. 9-1의 `java.time.Month`(`JANUARY` ~ `DECEMBER`)와 `java.time.DayOfWeek`(`MONDAY` ~ `SUNDAY`)가 열거형이다. 그래서 `LocalDate.now().getMonth()`를 출력하면 `NOVEMBER`처럼 대문자 이름이 나온다. (실습 DateTime 6번)
- 열거형도 클래스처럼 필드, 생성자, 메소드를 가질 수 있다. 이때 열거형의 생성자는 항상 `private`이다(밖에서 `new`로 새 값을 만들 수 없음).
  ```java
  enum Planet {
      MERCURY(3.303e+23), EARTH(5.976e+24);
      private final double mass;
      Planet(double mass) { this.mass = mass; }   // 생성자 (9-3)
      double getMass() { return mass; }
  }
  ```
