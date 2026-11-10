# 9-1. 날짜와 시간 다루기 (DateTime)

> 원본: `9-1 DateTime.pptx`
> 관련 코드: [`examples/OldDateProblem.java`](../examples/OldDateProblem.java), [`examples/InstantTest.java`](../examples/InstantTest.java), [`examples/LocalDateTimeTest.java`](../examples/LocalDateTimeTest.java), [`examples/ZonedDateTimeTest.java`](../examples/ZonedDateTimeTest.java), [`examples/ElapsedTimeTest.java`](../examples/ElapsedTimeTest.java), [`practice/datetime-enum/`](../practice/datetime-enum/) (4~7번)

---

## 1. 기존 Date 클래스의 문제점

- 자바 8 이전의 `java.util.Date` 클래스는 **thread safe하지 않았다**.
- 클래스 이름이 명확하지 않다. 이름은 `Date`(날짜)인데 시간까지 다룬다.
- 월이 0부터 시작하는 등 불편한 점이 많다.

```java
Date date = new Date();
System.out.println(date); // Thu May 30 09:54:50 KST 2024
long time = date.getTime();
System.out.println(time); // 1717030490129

Calendar birthDay = Calendar.getInstance();
birthDay.set(Calendar.YEAR, 1964);
birthDay.set(Calendar.MONTH, 8);
birthDay.set(Calendar.DATE, 24);
birthDay.getTime();
System.out.println(birthDay.getTime()); // Thu Sep 24 10:00:45 KST 1964
```

> 참고:
> - 💡 `Calendar.MONTH`에 `8`을 넣었는데 출력은 `Sep`(9월)이다. `Calendar`는 월을 **0부터** 센다(0 = 1월). 그래서 9월을 원하면 `8` 또는 `Calendar.SEPTEMBER`를 넣어야 한다. 슬라이드가 말하는 "월이 0부터 시작하는 불편함"이 바로 이것이다.
> - 💡 `date.getTime()`은 1970-01-01 00:00:00 UTC(epoch)부터 지난 시간을 **밀리초**(long)로 돌려준다.
> - 💡 시각(`10:00:45`)은 `set`으로 바꾸지 않았으므로 `getInstance()`를 호출한 현재 시각이 그대로 남는다.
> - 💡 "thread safe하지 않다"는 것은 여러 스레드가 같은 `Date`/`Calendar` 객체를 동시에 바꾸면 값이 꼬일 수 있다는 뜻이다. `java.time`의 클래스들은 **불변(immutable)** 객체라 이런 문제가 없다. (값을 바꾸는 메소드가 새 객체를 돌려준다. 4절 참고)

---

## 2. 기계용 시간 vs 인류용 시간

- 시간은 크게 **기계용 시간(machine time)** 과 **인류용 시간(human time)** 으로 나눈다.
- 기계용 시간: epoch(1970년 1월 1일 0시 0분 0초)부터 현재까지의 타임스탬프로 표현한다.
  - 기계가 다루는 시간으로, `Instant` 클래스를 제공한다.
- 인류용 시간: 우리가 흔히 쓰는 연, 월, 일, 시, 분, 초 등으로 표현한다.
  - `LocalDate`, `LocalDateTime`, `ZonedDateTime`, `LocalTime`, `MonthDay`, `Year`, `YearMonth`, `Month`, `OffsetDateTime`, `OffsetTime`, `Duration`, `Period` 등 다양한 클래스를 제공한다.

| 구분 | 표현 방식 | 대표 클래스 |
|---|---|---|
| 기계용 시간 | epoch부터의 초 + 나노초 | `Instant` |
| 인류용 시간 (시간대 X) | 연·월·일·시·분·초 | `LocalDate`, `LocalTime`, `LocalDateTime` |
| 인류용 시간 (시간대 O) | 연·월·일·시·분·초 + 시간대 | `ZonedDateTime`, `OffsetDateTime` |
| 기간 | 두 시점 사이의 길이 | `Duration`(시·분·초), `Period`(연·월·일) |

---

## 3. 기계 시간 - Instant

- EPOCH(1970년 1월 1일 0시 0분 0초)부터 현재까지의 타임스탬프를 제공한다.
- epoch-seconds를 나타내는 **long** 값과 나노초를 나타내는 **int** 값을 저장한다.

```java
Instant instant = Instant.now();
System.out.println(instant); // 2024-05-30T01:42:13.804485700Z
System.out.println(instant.getEpochSecond()); // 1717033693
System.out.println(instant.getNano()); // 98150300

ZoneId zone = ZoneId.systemDefault();
ZonedDateTime zonedDateTime = instant.atZone(zone);
System.out.println(zonedDateTime); // 2024-05-30T10:42:13.804485700+09:00[Asia/Seoul]

zone = ZoneId.of("America/Los_Angeles");
zonedDateTime = instant.atZone(zone);
System.out.println(zonedDateTime); // 2024-05-29T18:42:13.804485700-07:00[America/Los_Angeles]
```

> 참고:
> - 💡 `Instant`를 그냥 출력하면 끝에 `Z`가 붙는다. `Z`는 UTC(협정 세계시, +00:00)라는 뜻이다. 그래서 한국 시각 10:42가 `01:42Z`로 찍힌다(한국은 UTC+9).
> - 💡 `atZone(zone)`으로 **같은 순간**을 원하는 시간대의 날짜·시각으로 바꿔 볼 수 있다. 서울 10:42와 LA 전날 18:42는 같은 순간이다.
> - 💡 슬라이드의 `getNano()` 값(98150300)은 위 `instant`(…804485700)와 다른 실행에서 나온 값이라 숫자가 맞지 않는다. 같은 실행이라면 `804485700`이 나온다.
> - 💡 7강 과제 클래스1 4번 Stopwatch에서 `Instant`와 `Duration`을 이미 사용했다.

---

## 4. 휴먼 시간

- **특정 시간대를 고려한 표현**과 **시간대를 고려하지 않는 표현**으로 나눌 수 있다.
- 시간대 고려 표현: 타임존에 따라 표시 시간이 변하는 `ZonedDateTime`, `OffsetDateTime` 객체로 표현한다.
- 시간대를 고려하지 않는 표현: `Local`이라는 접두사로 구분한다. (예: `LocalDateTime`)

| 클래스 | 예 | 설명 |
|---|---|---|
| `LocalDateTime` | "오후 3시에 만나요." | 약속 시간만 정했다. (서울의 3시와 뉴욕의 3시는 다르다.) |
| `ZonedDateTime` | "서울 시간으로 오후 3시에 만나요." | 약속 시간과 장소(시간대)를 모두 정했다. 누가 어디에 있든 이 시간은 고유하다. |

---

## 5. 휴먼 시간 - LocalDateTime

- 자바 8 이후부터는 특정 날짜, 시간, 일시를 `java.time` 패키지의 `LocalDate`, `LocalTime`, `LocalDateTime` 객체로 다룬다.

```java
public final class LocalDate implements ... {
    private final int year;
    private final short month;
    private final short day;
    // ...
}

public final class LocalTime implements ... {
    private final byte hour;
    private final byte minute;
    private final byte second;
    private final int nano;
    // ...
}

public final class LocalDateTime implements ... {
    private final LocalDate date;
    private final LocalTime time;
    // ...
}
```

> 참고:
> - 💡 모든 필드가 `private final`이다. 한 번 만들어진 객체의 값은 **바꿀 수 없다(불변)**. 9-3에서 배우는 상수 필드(`final`)가 여기서 쓰인다.
> - 💡 클래스도 `final`이라 상속할 수 없다. (상속은 10강)
> - 💡 `LocalDateTime`은 `LocalDate`와 `LocalTime`을 **필드로 가진다**(포함 관계). 7강의 `MyRectangle`이 `MyPoint`를 필드로 가진 것과 같은 구조다.

### 5-1. 객체 생성: 팩토리 메소드

- `LocalDateTime`을 생성하는 팩토리 메소드는 아래와 같이 정의되어 있다. `LocalDate`, `LocalTime`도 비슷하다.

```java
public static LocalDateTime now()
public static LocalDateTime now(ZoneId zone)
public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute [, /* ... */])
public static LocalDateTime of(LocalDate date, LocalTime time)
public static LocalDateTime ofInstant(Instant instant, ZoneId zone)
…
```

> 참고:
> - 💡 **팩토리 메소드**: `new LocalDateTime(...)` 대신 객체를 만들어 돌려주는 **static 메소드**다. `LocalDateTime`의 생성자는 `private`이라서 밖에서 `new`를 쓸 수 없다. 9-3의 "생성자가 `private`이면 같은 클래스 안에서만 생성 가능"이 실제로 쓰이는 예다.
> - 💡 `of(...)`가 여러 개인 것은 **메소드 오버로딩**이다. (7강 8-3, 퀴즈 📝 필기 참고)

### 5-2. 주요 메소드

```java
// isX(..)
public boolean isBefore(ChronoLocalDateTime<?> other)
public boolean isAfter(ChronoLocalDateTime<?> other)

// format(..)
public String format(DateTimeFormatter formatter)

// 타입 변환
public LocalTime toLocalTime()
public ZonedDateTime atZone(ZoneId zone)
public OffsetDateTime atOffset(ZoneOffset offset)
```

```java
// plus(..)
public LocalDateTime plusYears(long years)
public LocalDateTime plusMonths(long months)
public LocalDateTime plusWeeks(long weeks)
public LocalDateTime plusDays(long days)
public LocalDateTime plusHours(long hours)
public LocalDateTime plusMinutes(long minutes)
public LocalDateTime plusSeconds(long seconds)
public LocalDateTime plusNanos(long nanos)

// minus(..)
public LocalDateTime minusYears(long years)
public LocalDateTime minusMonths(long months)
public LocalDateTime minusWeeks(long weeks)
public LocalDateTime minusDays(long days)
public LocalDateTime minusHours(long hours)
public LocalDateTime minusMinutes(long minutes)
public LocalDateTime minusSeconds(long seconds)
public LocalDateTime minusNanos(long nanos)

// with(..)
public LocalDateTime withYear(int year)
public LocalDateTime withMonth(int month)
public LocalDateTime withDayOfMonth(int dayOfMonth)
public LocalDateTime withDayOfYear(int dayOfYear)
public LocalDateTime withHour(int hour)
public LocalDateTime withMinute(int minute)
public LocalDateTime withSecond(int second)
public LocalDateTime withNano(int nanoOfSecond)
```

> 참고:
> - 💡 `plus~`, `minus~`, `with~`는 원래 객체를 바꾸지 않고 **새 객체를 돌려준다**(불변). 그래서 반드시 결과를 받아야 한다.
>   ```java
>   LocalDateTime d = LocalDateTime.now();
>   d.plusDays(1);          // ❌ 결과를 버림 → d 는 그대로
>   d = d.plusDays(1);      // ✅
>   ```
> - 💡 `with~`는 특정 항목만 **지정한 값으로 바꾼** 새 객체를 만든다. (예: `withDayOfMonth(1)` → 그 달의 1일)
> - 💡 값을 꺼내는 getter도 많이 쓴다: `getYear()`, `getMonth()`(→ `Month` 열거형), `getMonthValue()`(→ 1~12), `getDayOfMonth()`, `getDayOfWeek()`, `getHour()`, `getMinute()`, `getSecond()`. 실습 DateTime 4번에서 사용했다.

### 5-3. 예제

```java
// factory
LocalDateTime now = LocalDateTime.now();
LocalDateTime datetime1 = LocalDateTime.of(2017, 1, 14, 10, 34);
LocalDateTime dateTime2 = LocalDateTime.of(2019, Month.MARCH, 28, 14, 33, 48, 000000);

// format
DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
String formatDateTime = now.format(format);

// plus & minus
LocalDateTime datetime3 = datetime1.plusDays(120);
LocalDateTime datetime4 = datetime1.minusDays(100);
```

```
datetime1 = 2017-01-14T10:34
dateTime2 = 2019-03-28T14:33:48
datetime3 = 2017-05-14T10:34      (120일 후)
datetime4 = 2016-10-06T10:34      (100일 전)
```

> 참고:
> - 💡 `java.util.Calendar`와 달리 `LocalDateTime.of(2017, 1, ...)`의 `1`은 **1월**이다. 월을 숫자 대신 `Month.MARCH`처럼 열거형(9-2)으로 넘길 수도 있다.
> - 💡 마지막 인수 `000000`은 나노초다. 0으로 시작하는 정수 리터럴은 8진수로 해석되지만 값이 0이라 문제는 없다. (`010`을 쓰면 10이 아니라 8이 되니 주의)
> - 💡 `DateTimeFormatter` 패턴 문자:
>
>   | 문자 | 의미 | 예 |
>   |---|---|---|
>   | `yyyy` | 연도 | 2026 |
>   | `MM` / `MMM` | 월(숫자) / 월(약어) | 11 / Nov (한국어 로케일이면 11월) |
>   | `dd` | 일 | 05 |
>   | `HH` / `hh` | 시(0~23) / 시(1~12) | 15 / 03 |
>   | `mm` | **분** (대문자 `MM`은 월!) | 07 |
>   | `ss` | 초 | 09 |
>   | `a` | 오전/오후 | PM (한국어 로케일이면 오후) |
>   | `z` | 시간대 이름 | KST |
> - 💡 실행해 볼 수 있도록 [`examples/LocalDateTimeTest.java`](../examples/LocalDateTimeTest.java)에 `isBefore`, `with~`까지 넣었다.

---

## 6. 휴먼 시간 - ZonedDateTime

- 시간대를 고려한 시간을 표현한다.
- 특정 날짜를 한 시간대에서 다른 시간대로 변환하는 내장된(Built-in) 방법을 제공한다.
- Daylight Saving Time(일광 절약 시간, 서머타임)을 내부에서 완전히 처리한다.

```java
ZoneId zone = ZoneId.of("Asia/Seoul");  // 한국 내에서 ZoneId.systemDefault() 와 동일
ZonedDateTime zonedDateTime = ZonedDateTime.now(zone);

DateTimeFormatter globalFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a z");
ZoneId istZoneId = ZoneId.of("Asia/Calcutta");
ZoneId estZoneId = ZoneId.of("America/New_York");

Instant instant = Instant.now();
ZonedDateTime currentISTime = instant.atZone(istZoneId);
System.out.println("Calcutta time : " + globalFormat.format(currentISTime));
ZonedDateTime zdt2 = instant.atZone(estZoneId);
System.out.println("New_York time : " + globalFormat.format(zdt2));
```

```
(실행 예: 2026-11-05 15:12 KST에 영어 로케일로 실행)
Calcutta time : 05-Nov-2026 11:42 AM IST
New_York time : 05-Nov-2026 01:12 AM EST
```

> 참고:
> - 💡 `IST`는 인도 표준시(UTC+5:30), `EST`는 미국 동부 표준시(UTC-5)다. 서머타임 기간(3월~11월 초)에는 뉴욕이 `EDT`(UTC-4)가 된다. `ZonedDateTime`이 이것을 자동으로 처리한다.
> - 💡 `Asia/Calcutta`는 옛 이름이고 지금 정식 이름은 `Asia/Kolkata`다. 둘 다 동작한다.
> - 💡 `MMM`, `a`, `z`는 **로케일**에 따라 글자가 달라진다. 한국어 Windows에서 실행하면 `05-11월-2026 11:42 오전 IST`처럼 나온다. 영어로 고정하려면 `DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a z", Locale.ENGLISH)`처럼 로케일을 넘긴다.
> - 💡 실습 DateTime 5번(뉴욕의 현재 시간)은 `ZonedDateTime.now(ZoneId.of("America/New_York"))`로 풀었다.

---

## 7. 프로그램 실행 시간 측정하기

### 7-1. `currentTimeMillis()` / `nanoTime()` 이용

```java
long start = System.currentTimeMillis();
// ...
long finish = System.currentTimeMillis();
long timeElapsed = finish - start;
```

- 밀리초 단위 (1000ms = 1s)

```java
long start = System.nanoTime();
// ...
long finish = System.nanoTime();
long timeElapsed = finish - start;
```

- 나노초 단위 (1,000,000,000ns = 1s)

### 7-2. Instant 클래스 이용

```java
Instant start = Instant.now();
// CODE HERE
Instant finish = Instant.now();
long timeElapsed = Duration.between(start, finish).toMillis();
```

> 참고:
> - 💡 슬라이드에는 `System. nanoTime()`처럼 점 뒤에 공백이 있다. 자바는 `.` 앞뒤의 공백을 허용하므로 컴파일은 되지만 보통 붙여 쓴다.
> - 💡 `currentTimeMillis()`는 "지금이 몇 시인지"(벽시계)를 알려 준다. 그래서 컴퓨터 시계가 바뀌면 측정값이 틀어질 수 있다. `nanoTime()`은 **경과 시간 측정 전용**이라 이런 영향이 없어 더 정확하다. 단, `nanoTime()` 값 자체는 날짜와 관계없는 숫자라 차이(`finish - start`)만 의미가 있다.
> - 💡 `Duration.between(start, finish)`는 `toMillis()` 외에도 `toNanos()`, `toSeconds()`, `toMinutes()` 등으로 원하는 단위를 꺼낼 수 있다.
> - 💡 세 방법을 한 번에 비교하는 코드는 [`examples/ElapsedTimeTest.java`](../examples/ElapsedTimeTest.java)에 있다.
