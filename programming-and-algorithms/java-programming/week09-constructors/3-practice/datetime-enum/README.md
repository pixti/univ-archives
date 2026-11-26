# 9주차 실습 · datetime-enum

[🏠 9주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [DaysOfWeekTest.java](#1-요일-열거형) | 1. 요일 열거형 |
| [ShapeTest.java](#2-도형-열거형) | 2. 도형 열거형 (⚠ 출력 형식을 문제에 맞게 수정) |
| [MonthsTest.java](#3-월-열거형-참고-답안-valueof로-실제-이번-달) | 3. 💡 월 열거형 (참고 답안, `valueOf`로 실제 이번 달) |
| [NowInfo.java](#4-현재-연--월--일--시--분-getmonthvalue) | 4. 현재 연 · 월 · 일 · 시 · 분 (`getMonthValue`) |
| [NewYorkTime.java](#5-뉴욕의-현재-시각) | 5. 뉴욕의 현재 시각 (💡 `%02d`로 두 자리) |
| [LastDayOfMonth.java](#6-이번-달의-마지막-날) | 6. 이번 달의 마지막 날 (📝 "2026년 November 30"으로 문제 변경. ⚠ `getDisplayName`) |
| [HundredDaysLater.java](#7-추가-문제-100일-뒤의-날짜-plusdays) | 7. 추가 문제: 100일 뒤의 날짜 (`plusDays`) |

---

## 1. 요일 열거형

`9강 실습` · 📄 [`DaysOfWeekTest.java`](DaysOfWeekTest.java)

#### 문제

> 일요일부터 토요일까지를 나타내는 열거형 DaysOfWeek 를 정의하고,<br>오늘(today)을 MONDAY 로 지정해 출력하시오.

#### 💻 코드

<!-- code: DaysOfWeekTest.java -->
```java
public class DaysOfWeekTest {
    enum DaysOfWeek {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        DaysOfWeek today = DaysOfWeek.MONDAY;
        System.out.println("Today is " + today);
        System.out.println("💡 MONDAY.ordinal() = " + today.ordinal());
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Today is MONDAY
💡 MONDAY.ordinal() = 1
```

**포인트**

- enum 선언 : 가능한 값을 쉼표로 나열 (9-2)
- 열거 값은 "열거형이름.상수" 로 쓰고, 출력하면 이름이 그대로 나온다. (숫자가 아님)

- 💡 자바에는 이미 java.time.DayOfWeek 열거형(MONDAY \~ SUNDAY)이 있다. 이름이 겹치지 않게 DaysOfWeek 로 지었다.
- 💡 ordinal() 은 선언 순서(0부터)다. SUNDAY 를 먼저 선언했으므로 MONDAY 는 1.

## 2. 도형 열거형

`9강 실습` · 📄 [`ShapeTest.java`](ShapeTest.java)

#### 문제

> CIRCLE, SQUARE, TRIANGLE, RECTANGLE 을 값으로 가지는 열거형 Shape 를 정의하고, 두 도형 변수(firstShape, secondShape)에 값을 넣어 출력하시오.

#### 💻 코드

<!-- code: ShapeTest.java -->
```java
public class ShapeTest {
    enum Shape {
        CIRCLE, SQUARE, TRIANGLE, RECTANGLE
    }

    public static void main(String[] args) {
        Shape firstShape = Shape.CIRCLE;
        Shape secondShape = Shape.SQUARE;

        System.out.println("First shape: " + firstShape);
        System.out.println("Second shape: " + secondShape);

        // 💡 원래 작성했던 비교 코드
        if (firstShape == secondShape) {
            System.out.println("💡 같은 도형인가? Yes");
        } else {
            System.out.println("💡 같은 도형인가? No");
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
First shape: CIRCLE
Second shape: SQUARE
💡 같은 도형인가? No
```

**포인트**

- 열거형 변수 선언과 대입, == 비교 (9-2 "열거형 값 비교 가능")

- ⚠ 처음 답은 firstShape == secondShape 를 비교해 "No" 만 출력해서 문제의 실행 결과<br>(First shape: CIRCLE / Second shape: SQUARE)와 달랐다. 두 도형을 출력하는 줄을 추가하고 비교는 💡 로 남겼다.
  - ❌ 틀린 코드
    ```java
    if (firstShape == secondShape) System.out.println("Yes");
    else System.out.println("No");
    ```
  - ✅ 고친 코드
    ```java
    System.out.println("First shape: " + firstShape);
    System.out.println("Second shape: " + secondShape);
    ```
- 💡 enum 상수는 프로그램 안에 딱 하나의 객체만 존재하므로 equals() 대신 == 로 비교해도 안전하다.

## 3. 월 열거형 (참고 답안, `valueOf`로 실제 이번 달)

`9강 실습` · 📄 [`MonthsTest.java`](MonthsTest.java)

#### 문제

> 1월부터 12월까지(JANUARY \~ DECEMBER)를 나타내는 열거형 Months 를 정의하고, 이번 달을 SEPTEMBER 로 지정해 출력하시오.

#### 💻 코드

<!-- code: MonthsTest.java -->
```java
import java.time.LocalDate;

public class MonthsTest {
    enum Months {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
        JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    public static void main(String[] args) {
        Months thisMonth = Months.SEPTEMBER;
        System.out.println("이번 달 : " + thisMonth);
        System.out.println("💡 " + thisMonth + " 는 " + (thisMonth.ordinal() + 1) + "월");

        Months now = Months.valueOf(LocalDate.now().getMonth().name());
        System.out.println("💡 실제 이번 달 : " + now + " (" + (now.ordinal() + 1) + "월)");
    }
}
```
<!-- /code -->

#### 실행 결과 (마지막 두 줄은 실행 날짜에 따라 다름)

```text
이번 달 : SEPTEMBER
💡 SEPTEMBER 는 9월
💡 실제 이번 달 : NOVEMBER (11월)
```

#### 📒 해설

- 💡 직접 풀지 않은 문제라 참고 답안으로 채웠다.
- 💡 덤으로 "실제 이번 달"을 구해 봤다. LocalDate.now().getMonth() 는 java.time.Month 열거형을 돌려주고, .name() 으로 이름 문자열을 꺼낸 뒤 Months.valueOf(...) 로 우리 열거형 값으로 바꿨다.<br>(두 열거형의 상수 이름이 같아서 가능)
- 💡 values() 로 모든 상수를 꺼내 반복할 수 있다. ordinal() + 1 이 몇 월인지가 된다.

## 4. 현재 연 · 월 · 일 · 시 · 분 (`getMonthValue`)

`9강 실습` · 📄 [`NowInfo.java`](NowInfo.java)

#### 문제

> LocalDateTime 을 이용해 현재의 연, 월, 일, 시, 분을 각각 출력하시오.

#### 💻 코드

<!-- code: NowInfo.java -->
```java
import java.time.LocalDateTime;

public class NowInfo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Year: " + now.getYear());
        System.out.println("Month: " + now.getMonthValue());
        System.out.println("Day: " + now.getDayOfMonth());
        System.out.println("Hour: " + now.getHour());
        System.out.println("Minute: " + now.getMinute());
    }
}
```
<!-- /code -->

#### 실행 결과 (실행 시각에 따라 다름 - 실행 예)

```text
Year: 2026
Month: 11
Day: 5
Hour: 15
Minute: 10
```

**포인트**

- LocalDateTime.now() : 팩토리 메소드로 현재 날짜 · 시각 객체를 얻는다.
- getter : getYear(), getMonthValue(), getDayOfMonth(), getHour(), getMinute()

- 💡 getMonth() 는 Month 열거형(NOVEMBER)을, getMonthValue() 는 숫자(11)를 돌려준다.<br>"Month: 11" 처럼 숫자가 필요하므로 getMonthValue() 를 썼다.
- 💡 getDay() 가 아니라 getDayOfMonth() 다. (getDayOfYear() : 1월 1일부터 며칠째, getDayOfWeek() : 요일)
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. NowInfo 로 이름을 바꿨다.

## 5. 뉴욕의 현재 시각

`9강 실습` · 📄 [`NewYorkTime.java`](NewYorkTime.java)

#### 문제

> ZonedDateTime 을 이용해 뉴욕(America/New\_York)의 현재 시각을 "시:분:초" 로 출력하시오.

#### 💻 코드

<!-- code: NewYorkTime.java -->
```java
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class NewYorkTime {
    public static void main(String[] args) {
        ZonedDateTime nyTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Time in New York: "
                + nyTime.getHour() + ":" + nyTime.getMinute() + ":" + nyTime.getSecond());

        // 💡 두 자리로 맞추기
        System.out.println(String.format("💡 Time in New York: %02d:%02d:%02d",
                nyTime.getHour(), nyTime.getMinute(), nyTime.getSecond()));
    }
}
```
<!-- /code -->

#### 실행 결과 (실행 시각에 따라 다름 - 실행 예)

```text
Time in New York: 1:12:44
💡 Time in New York: 01:12:44
```

**포인트**

- ZonedDateTime.now(ZoneId.of("America/New\_York")) : 지정한 시간대의 현재 날짜 · 시각
- getHour(), getMinute(), getSecond() 로 항목을 꺼낸다.

- 💡 문제의 실행 결과(5:10:1)처럼 숫자를 그대로 이어 붙이면 한 자리 수 앞에 0 이 붙지 않는다.<br>05:10:01 처럼 두 자리로 맞추려면 String.format("%02d:%02d:%02d", ...) 를 쓴다. (💡 줄)
- 💡 뉴욕은 11월 첫째 일요일부터 EST(UTC-5), 3월 둘째 일요일부터 EDT(UTC-4, 서머타임).<br>ZonedDateTime 이 자동으로 처리하므로 직접 계산할 필요가 없다.
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. NewYorkTime 으로 이름을 바꿨다.

## 6. 이번 달의 마지막 날

`9강 실습` · 📄 [`LastDayOfMonth.java`](LastDayOfMonth.java)

#### 문제

> 이번 달의 마지막 날짜를 구해 "AUGUST : 31" 처럼 출력하시오.

#### 💻 코드

<!-- code: LastDayOfMonth.java -->
```java
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class LastDayOfMonth {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        Month month = today.getMonth();
        int lastDay = today.lengthOfMonth();

        System.out.println(year + "년 " + month + " " + lastDay);       // ❌ 대문자로 나온다

        String monthName = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        System.out.println(year + "년 " + monthName + " " + lastDay);   // ✅ November 로 나온다

        System.out.println("💡 원래 문제 형식 : " + month + " : " + lastDay);
        System.out.println("💡 마지막 날 : " + today.withDayOfMonth(today.lengthOfMonth()));
        System.out.println("💡 2028년 2월의 마지막 날 : " + LocalDate.of(2028, 2, 1).lengthOfMonth());
    }
}
```
<!-- /code -->

#### 실행 결과 (실행 날짜에 따라 다름 - 2026년 11월에 실행)

```text
2026년 NOVEMBER 30
2026년 November 30
💡 원래 문제 형식 : NOVEMBER : 30
💡 마지막 날 : 2026-11-30
💡 2028년 2월의 마지막 날 : 29
```

#### 📒 해설

- 📝 필기 : 2026년 November 30 으로 출력되도록 문제 변경.

**포인트**

- LocalDate.now() 로 오늘 날짜, getMonth() 로 Month 열거형, lengthOfMonth() 로 그 달의 일 수(= 마지막 날)

- ⚠ getMonth() 를 그대로 출력하면 열거형 이름(대문자) NOVEMBER 가 나온다. 필기처럼 "November" 로 쓰려면 month.getDisplayName(TextStyle.FULL, Locale.ENGLISH) 를 쓴다.
  - ❌ 틀린 코드 : System.out.println(year + "년 " + month + " " + lastDay);        → 2026년 NOVEMBER 30
  - ✅ 고친 코드 : System.out.println(year + "년 " + monthName + " " + lastDay);    → 2026년 November 30
- 💡 TextStyle.SHORT 는 "Nov", Locale.KOREAN 이면 "11월" 이 된다.
- 💡 다른 방법 : today.withDayOfMonth(today.lengthOfMonth()) 는 마지막 날의 LocalDate 를 만든다. (9-1 with\~)<br>윤년도 자동으로 처리된다. (2028년 2월 → 29)
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. LastDayOfMonth 로 이름을 바꿨다.

## 7. 추가 문제: 100일 뒤의 날짜 (`plusDays`)

`9강 실습` · 📄 [`HundredDaysLater.java`](HundredDaysLater.java)

#### 문제

> - 💡 문제 본문은 자료에 없고 풀이 코드(Problem.java)만 남아 있다. 코드로 보아 "오늘로부터 100일 뒤의 연, 월, 일을 출력하라" 는 문제다.

#### 💻 코드

<!-- code: HundredDaysLater.java -->
```java
import java.time.LocalDateTime;

public class HundredDaysLater {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tmpDay = now.plusDays(100);
        System.out.println(tmpDay.getYear() + " " + tmpDay.getMonth() + " " + tmpDay.getDayOfMonth());
    }
}
```
<!-- /code -->

#### 실행 결과 (실행 날짜에 따라 다름 - 2026-11-05 에 실행)

```text
2027 FEBRUARY 13
```

**포인트**

- plusDays(100) : 100일 뒤의 "새" LocalDateTime 객체를 돌려준다. now 자체는 바뀌지 않는다(불변).

- 💡 월 · 연이 바뀌는 계산(11월 → 다음 해 2월)도 plusDays 가 알아서 해 준다.
- 💡 getMonth() 는 Month 열거형이라 FEBRUARY 처럼 대문자 이름이 나온다. 숫자가 필요하면 getMonthValue().
- 💡 원래 클래스 이름은 Problem. HundredDaysLater 로 이름을 바꿨다.

---

[🏠 9주차 학습 가이드](../../README.md)
