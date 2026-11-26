# 9주차 강의 예제 코드

[🏠 9주차 학습 가이드](../../README.md)

강의 노트([`1-lecture/`](../))에 나온 코드를 실행할 수 있는 파일로 정리했습니다. 노트를 먼저 읽고, 여기서 코드를 실행하며 결과를 확인하세요.

| 파일 | 내용 |
|---|---|
| [OldDateProblem.java](#기존-date--calendar-클래스의-문제점) | `Date` / `Calendar`의 문제점: `MONTH`에 8을 넣으면 9월 |
| [InstantTest.java](#기계-시간---instant) | `Instant`(UTC, `Z`), `getEpochSecond` / `getNano`, `atZone`으로 서울 · LA 시각 |
| [LocalDateTimeTest.java](#휴먼-시간---localdatetime-예제) | `now` / `of`, `format`, `plusDays` / `minusDays`. 💡 `isBefore`, `with~`, 결과를 버리는 실수(불변) |
| [ZonedDateTimeTest.java](#휴먼-시간---zoneddatetime) | 콜카타 · 뉴욕 시각. 💡 `Locale.ENGLISH`로 `Nov` / `AM` 고정 |
| [ElapsedTimeTest.java](#프로그램-실행-시간-측정하기---세-가지-방법-비교) | 실행 시간 측정 세 가지 방법 비교 |
| [SuitEnumTest.java](#상수int-방식의-문제점과-열거형enum으로-해결하기) | 상수 방식 vs `enum Suit`, `values()`, `==`, `switch` fall-through. ⚠ `value()` → `values()` |
| [ConstructorExample.java](#생성자-기본) | 생성자 기본. 💡 기본 생성자가 자동으로 생기지 않는 경우 |
| [StudentScoreTest.java](#실습-학생-성적-클래스-정의하기--전체-과목별-평균) | [실습] 학생 성적 클래스를 생성자로. ⚠ `class` 누락 수정 |
| [CatOverloading.java](#생성자-중복-정의--this--this필드) | 생성자 중복 정의, `this("영순이", 50)`, `name = name` 버그 vs `this.name = name` (⚠ JDK 25) |
| [MyRectangleTest.java](#실습-생성자-중복) | [실습] 생성자 중복 (`MyPoint` 2개, `MyRectangle` 3개) |
| [MyRectangleThisTest.java](#실습-다른-생성자-호출하기--이전-실습-부분-수정) | [실습] 다른 생성자 호출하기: 위 예제를 `this(...)`로 수정 |
| [FieldInitTest.java](#상수-필드-및-정적-필드-초기화) | `final` 필드(선언 · 생성자), `static` 필드(선언 · static 블록). ⚠ 생성자에서 `static` 필드 대입 |
| [FinalizeTest.java](#소멸자와-finalize) | 소멸자 `finalize`, `null` 대입과 `System.gc()`. ⚠ `finalize` deprecated |

---

## 기존 Date / Calendar 클래스의 문제점

`9-1 DateTime` · 📄 [`OldDateProblem.java`](OldDateProblem.java)

#### 💻 코드

<!-- code: OldDateProblem.java -->
```java
import java.util.Calendar;
import java.util.Date;

public class OldDateProblem {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);               // Thu May 30 09:54:50 KST 2024
        long time = date.getTime();
        System.out.println(time);               // 1717030490129

        Calendar birthDay = Calendar.getInstance();
        birthDay.set(Calendar.YEAR, 1964);
        birthDay.set(Calendar.MONTH, 8);        // 💡 8 → 9월 (0부터 셈)
        birthDay.set(Calendar.DATE, 24);
        birthDay.getTime();                     // 💡 강의 코드에 있는 줄. 결과를 쓰지 않으므로 의미 없음
        System.out.println(birthDay.getTime()); // Thu Sep 24 10:00:45 KST 1964

        // 💡 월 상수 값 확인
        System.out.println("Calendar.SEPTEMBER = " + Calendar.SEPTEMBER);
    }
}
```
<!-- /code -->

#### 실행 결과 (실행 시각에 따라 다름 - 실행 예)

```text
Thu May 30 09:54:50 KST 2024
1717030490129
Thu Sep 24 10:00:45 KST 1964
Calendar.SEPTEMBER = 8
```

**포인트**

- java.util.Date 는 JDK 1.0, Calendar 는 JDK 1.1 부터 있던 클래스다.
- 문제점 : 월(MONTH)이 0 부터 시작, 객체 값이 바뀜(가변 → thread safe 하지 않음), 시간대 처리가 불편.<br>→ Java 8 부터 java.time 패키지(Instant, LocalDateTime, ZonedDateTime ...)를 쓴다.

- 💡 Calendar.MONTH 에 8 을 넣었는데 출력은 Sep(9월)이다. Calendar 는 월을 0 부터 센다(0 = 1월).<br>9월을 원하면 8 또는 Calendar.SEPTEMBER 를 넣어야 한다.
- 💡 date.getTime() 은 1970-01-01 00:00:00 UTC(epoch)부터 지난 시간을 밀리초(long)로 돌려준다.
- 💡 시각은 set 으로 바꾸지 않았으므로 getInstance() 를 호출한 현재 시각이 그대로 남는다.
- 💡 Calendar 는 set(...) 으로 "자기 자신의 값"이 바뀐다(가변). 다른 곳에서 같은 객체를 쓰고 있으면 값이 함께 바뀐다.<br>java.time 의 LocalDate 는 plusDays(...) 가 새 객체를 돌려줄 뿐 원래 객체는 그대로다(불변).

## 기계 시간 - Instant

`9-1 DateTime` · 📄 [`InstantTest.java`](InstantTest.java)

#### 💻 코드

<!-- code: InstantTest.java -->
```java
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class InstantTest {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);                    // 2024-05-30T01:42:13.804485700Z
        System.out.println(instant.getEpochSecond());   // 1717033693
        System.out.println(instant.getNano());          // 804485700

        ZoneId zone = ZoneId.systemDefault();           // 한국 PC 라면 Asia/Seoul
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);              // 2024-05-30T10:42:13.804485700+09:00[Asia/Seoul]

        zone = ZoneId.of("America/Los_Angeles");
        zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);              // 2024-05-29T18:42:13.804485700-07:00[America/Los_Angeles]
    }
}
```
<!-- /code -->

#### 실행 결과 (실행 시각에 따라 다름 - 실행 예)

```text
2024-05-30T01:42:13.804485700Z
1717033693
804485700
2024-05-30T10:42:13.804485700+09:00[Asia/Seoul]
2024-05-29T18:42:13.804485700-07:00[America/Los_Angeles]
```

**포인트**

- Instant : 1970-01-01T00:00:00Z(epoch)부터 흐른 시간을 초 + 나노초로 표현하는 "기계용 시간".
- getEpochSecond() : epoch 부터 지난 초,  getNano() : 그 초 안의 나노초(0 \~ 999,999,999)
- atZone(zone) : 같은 순간을 원하는 시간대의 날짜 · 시각(ZonedDateTime)으로 바꿔 본다.

- 💡 Instant 를 그냥 출력하면 끝에 Z 가 붙는다. Z 는 UTC(+00:00) 라는 뜻이다.<br>그래서 한국 시각 10:42 가 01:42Z 로 찍힌다(한국은 UTC+9).
- 💡 강의 예시의 getNano() 값(98150300)은 instant(…804485700)와 다른 실행에서 나온 값이라 숫자가 맞지 않는다.<br>같은 실행이라면 804485700 이 나온다.
- 💡 7강 과제 클래스1 4번 Stopwatch 에서 Instant 와 Duration 을 이미 사용했다.

## 휴먼 시간 - LocalDateTime 예제

`9-1 DateTime` · 📄 [`LocalDateTimeTest.java`](LocalDateTimeTest.java)

#### 💻 코드

<!-- code: LocalDateTimeTest.java -->
```java
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {
    public static void main(String[] args) {
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

        System.out.println("now       : " + formatDateTime);
        System.out.println("datetime1 : " + datetime1);   // 💡 초가 0 이면 출력에서 생략됨
        System.out.println("dateTime2 : " + dateTime2);
        System.out.println("datetime3 : " + datetime3);   // 1/14 + 120일 = 5/14
        System.out.println("datetime4 : " + datetime4);   // 1/14 - 100일 = 2016/10/06

        // 💡 isX(..)
        System.out.println("datetime4.isBefore(datetime1) : " + datetime4.isBefore(datetime1));

        // 💡 with(..) : 특정 항목만 바꾼 새 객체
        System.out.println("datetime1.withDayOfMonth(1) : " + datetime1.withDayOfMonth(1));
        System.out.println("datetime1.withHour(23) : " + datetime1.withHour(23));

        // 💡 불변 객체 : 결과를 받지 않으면 아무 변화 없음
        LocalDateTime d = datetime1;
        d.plusDays(1);              // ❌ 결과를 버림 → d 는 그대로
        System.out.println("plusDays 결과를 버리면 : " + d);
        d = d.plusDays(1);          // ✅ 이렇게 받아야 함

        // 💡 getter
        System.out.println(datetime1.getYear() + "년 " + datetime1.getMonthValue() + "월("
                + datetime1.getMonth() + ") " + datetime1.getDayOfMonth() + "일 "
                + datetime1.getDayOfWeek());
    }
}
```
<!-- /code -->

#### 실행 결과 (첫 줄은 실행 시각에 따라 다름)

```text
now       : 2026-11-10 14:20:31
datetime1 : 2017-01-14T10:34
dateTime2 : 2019-03-28T14:33:48
datetime3 : 2017-05-14T10:34
datetime4 : 2016-10-06T10:34
datetime4.isBefore(datetime1) : true
datetime1.withDayOfMonth(1) : 2017-01-01T10:34
datetime1.withHour(23) : 2017-01-14T23:34
plusDays 결과를 버리면 : 2017-01-14T10:34
2017년 1월(JANUARY) 14일 SATURDAY
```

**포인트**

- 객체 생성은 new 가 아니라 팩토리 메소드 now(), of(...) 로 한다.<br>(LocalDateTime 의 생성자는 private → 9-3 "private 생성자면 같은 클래스 안에서만 생성 가능")
- of(...) 가 여러 개 = 메소드 오버로딩 (퀴즈 📝 필기 : 파라미터의 개수나 타입이 다르게)
- plus\~ / minus\~ / with\~ 는 원래 객체를 바꾸지 않고 "새 객체"를 돌려준다(불변).

- 💡 LocalDateTime.of(2017, 1, ...) 의 1 은 1월이다. (Calendar 와 달리 1부터 셈)<br>월을 Month.MARCH 처럼 열거형(9-2)으로 넘길 수도 있다.
- 💡 마지막 인수 000000 은 나노초. 0 으로 시작하는 정수는 8진수지만 값이 0 이라 문제없다.<br>(010 을 쓰면 10 이 아니라 8 이 되니 주의)
- 💡 강의에 없는 isBefore, with\~, getter 와 "결과를 버리는 실수"를 추가했다.

## 휴먼 시간 - ZonedDateTime

`9-1 DateTime` · 📄 [`ZonedDateTimeTest.java`](ZonedDateTimeTest.java)

#### 💻 코드

<!-- code: ZonedDateTimeTest.java -->
```java
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ZonedDateTimeTest {
    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("Asia/Seoul");  // 한국 내에서 ZoneId.systemDefault() 와 동일
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zone);
        System.out.println("Seoul time : " + zonedDateTime);

        DateTimeFormatter globalFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a z");
        ZoneId istZoneId = ZoneId.of("Asia/Calcutta");
        ZoneId estZoneId = ZoneId.of("America/New_York");

        Instant instant = Instant.now();
        ZonedDateTime currentISTime = instant.atZone(istZoneId);
        System.out.println("Calcutta time : " + globalFormat.format(currentISTime));
        ZonedDateTime zdt2 = instant.atZone(estZoneId);
        System.out.println("New_York time : " + globalFormat.format(zdt2));

        // 💡 로케일을 영어로 고정
        DateTimeFormatter englishFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a z", Locale.ENGLISH);
        System.out.println("Calcutta time (ENGLISH) : " + englishFormat.format(currentISTime));
        System.out.println("New_York time (ENGLISH) : " + englishFormat.format(zdt2));
    }
}
```
<!-- /code -->

**포인트**

- ZonedDateTime = 날짜 + 시각 + 시간대(ZoneId). 같은 순간(Instant)을 나라별 시각으로 표현할 수 있다.
- ZoneId.of("Asia/Seoul") 은 한국 PC 에서 ZoneId.systemDefault() 와 같다.

- 💡 IST 는 인도 표준시(UTC+5:30), EST 는 미국 동부 표준시(UTC-5).<br>서머타임 기간(3월\~11월 초)에는 뉴욕이 EDT(UTC-4)가 된다. ZonedDateTime 이 자동으로 처리한다.
- 💡 Asia/Calcutta 는 옛 이름이고 지금 정식 이름은 Asia/Kolkata. 둘 다 동작한다.
- 💡 MMM, a, z 는 로케일에 따라 글자가 달라진다. 한국어 Windows 에서는 "05-11월-2026 11:42 오전 IST" 처럼 나온다.<br>영어로 고정하려면 ofPattern(..., Locale.ENGLISH) 처럼 로케일을 넘긴다. (아래 💡 줄)

실행 결과 (실행 예: 2026-11-05 15:12 KST, 한국어 Windows)<br>Seoul time : 2026-11-05T15:12:44.123456700+09:00\[Asia/Seoul]<br>Calcutta time : 05-11월-2026 11:42 오전 IST<br>New\_York time : 05-11월-2026 01:12 오전 EST<br>Calcutta time (ENGLISH) : 05-Nov-2026 11:42 AM IST<br>New\_York time (ENGLISH) : 05-Nov-2026 01:12 AM EST

## 프로그램 실행 시간 측정하기 - 세 가지 방법 비교

`9-1 DateTime` · 📄 [`ElapsedTimeTest.java`](ElapsedTimeTest.java)

#### 💻 코드

<!-- code: ElapsedTimeTest.java -->
```java
import java.time.Duration;
import java.time.Instant;

public class ElapsedTimeTest {
    static long work() {
        long sum = 0;
        for (int i = 1; i <= 100_000_000; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        // ① currentTimeMillis()
        long start = System.currentTimeMillis();
        work();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("① currentTimeMillis : " + timeElapsed + " ms");

        // ② nanoTime()
        long nStart = System.nanoTime();
        work();
        long nFinish = System.nanoTime();
        long nElapsed = nFinish - nStart;
        System.out.println("② nanoTime          : " + nElapsed + " ns (" + nElapsed / 1_000_000 + " ms)");

        // ③ Instant + Duration
        Instant iStart = Instant.now();
        work(); // CODE HERE
        Instant iFinish = Instant.now();
        long iElapsed = Duration.between(iStart, iFinish).toMillis();
        System.out.println("③ Instant/Duration  : " + iElapsed + " ms");
    }
}
```
<!-- /code -->

#### 실행 결과 (컴퓨터에 따라 다름)

```text
① currentTimeMillis : 35 ms
② nanoTime          : 31254300 ns (31 ms)
③ Instant/Duration  : 31 ms
```

**포인트**

- ① System.currentTimeMillis() : 밀리초(1/1,000초)
- ② System.nanoTime()          : 나노초(1/1,000,000,000초)

**③ Instant.now() + Duration.between(start, finish)**

- 💡 System. nanoTime() 처럼 점 뒤에 공백이 있어도 컴파일은 되지만 보통 붙여 쓴다.
- 💡 currentTimeMillis() 는 "지금이 몇 시인지"(벽시계)라서 컴퓨터 시계가 바뀌면 측정값이 틀어질 수 있다.<br>nanoTime() 은 경과 시간 측정 전용이라 영향이 없다. 단, 값 자체는 날짜와 관계없어 차이만 의미가 있다.
- 💡 Duration 은 toMillis() 외에도 toNanos(), toSeconds(), toMinutes() 로 원하는 단위를 꺼낼 수 있다.
- 💡 측정 대상으로 1 \~ 1억 합계 계산(work 메소드)을 넣었다. 강의 코드는 "// ..." / "// CODE HERE" 로 비워 둠.

## 상수(int) 방식의 문제점과 열거형(enum)으로 해결하기

`9-2 Enumeration` · 📄 [`SuitEnumTest.java`](SuitEnumTest.java)

#### 💻 코드

<!-- code: SuitEnumTest.java -->
```java
public class SuitEnumTest {
    // ----- 기존 방식 : 상수 -----
    public static final int SUIT_CLUBS = 0;
    public static final int SUIT_DIAMONDS = 1;
    public static final int SUIT_HEARTS = 2;
    public static final int SUIT_SPADES = 3;

    // ----- 열거형 -----
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

    // 문제점 2 : 아무 int 나 들어올 수 있음
    public static void drawSuitOnCard(int suit) {
        System.out.println("drawSuitOnCard(int) : " + suit + " ← 이상한 값도 그냥 들어감");
    }

    // 해결 : Suit 에 나열된 값만 가능 (오버로딩)
    public static void drawSuitOnCard(Suit suit) {
        System.out.println("drawSuitOnCard(Suit) : " + suit);
    }

    public static void main(String[] args) {
        System.out.println("===== 상수(int) 방식 =====");
        System.out.println("Card is a Queen of " + SUIT_HEARTS);  // 문제점 4 : 숫자만 출력
        drawSuitOnCard(9452435);                                    // 문제점 2 : 막을 수 없음

        System.out.println("===== enum 방식 =====");
        System.out.println("Card is a Queen of " + Suit.HEARTS);  // Prints "Card is a Queen of HEARTS"
        drawSuitOnCard(Suit.HEARTS);
        // 💡 int 버전이 없다면 drawSuitOnCard(9452435) 는 컴파일 오류 :
        //    The method drawSuitOnCard(Test.Suit) in the type Test is not applicable for the arguments (int)

        System.out.println("===== values() =====");
        Suit[] suits = Suit.values();
        for (Suit s : suits) {
            System.out.println(s);
        }

        System.out.println("===== == 비교, switch =====");
        for (Suit suit : Suit.values()) {
            System.out.print(suit + " : ");
            if (suit == Suit.CLUBS) {            // == 로 비교
                System.out.print("클럽입니다 / ");
            }
            switch (suit) {
                case CLUBS:                      // break 가 없으므로 SPADES 와 같은 코드 실행 (fall-through)
                case SPADES:
                    System.out.println("검은색");
                    break;
                case HEARTS:
                case DIAMONDS:
                    System.out.println("빨간색");
                    break;
                default:
                    System.out.println("?");
                    break;
            }
        }

        System.out.println("===== 💡 자주 쓰는 메소드 =====");
        System.out.println("valueOf(\"HEARTS\") = " + Suit.valueOf("HEARTS"));
        System.out.println("HEARTS.name() = " + Suit.HEARTS.name());
        System.out.println("HEARTS.ordinal() = " + Suit.HEARTS.ordinal());
    }
}
```
<!-- /code -->

#### 실행 결과

```text
===== 상수(int) 방식 =====
Card is a Queen of 2
drawSuitOnCard(int) : 9452435 ← 이상한 값도 그냥 들어감
===== enum 방식 =====
Card is a Queen of HEARTS
drawSuitOnCard(Suit) : HEARTS
===== values() =====
CLUBS
DIAMONDS
HEARTS
SPADES
===== == 비교, switch =====
CLUBS : 클럽입니다 / 검은색
DIAMONDS : 빨간색
HEARTS : 빨간색
SPADES : 검은색
===== 💡 자주 쓰는 메소드 =====
valueOf("HEARTS") = HEARTS
HEARTS.name() = HEARTS
HEARTS.ordinal() = 2
```

**포인트**

- 상수 방식(public static final int SUIT\_CLUBS = 0 ...)의 문제점 4가지
  1. 허용되는 값이 명확하지 않음   2. 유형 안전성 없음
  3. 이름 공간 없음(SUIT\_ 접두사)  4. 출력하면 숫자만 나옴
- enum : 가능한 값을 쉼표로 나열한 "자료형". Java 5 부터.
- 기타 이점 : values() 로 모든 값 꺼내기, == 비교, switch 문에서 사용

- 💡 이클립스 화면에 Test.Suit 라고 나오는 것은 Suit 가 Test 클래스 "안에" 선언되었기 때문이다.<br>여기서도 SuitEnumTest 안에 선언했다. (public enum 을 따로 두려면 Suit.java 파일이 필요)
- ⚠ 자주 틀리는 부분 : 모든 상수를 꺼내는 메소드 이름은 value() 가 아니라 values() 다.
- 💡 enum 상수는 프로그램 안에 딱 하나의 객체만 존재 → 문자열과 달리 == 로 비교해도 안전.
- 💡 switch 의 case 에는 Suit.CLUBS 가 아니라 CLUBS 처럼 상수 이름만 쓴다.

## 생성자 기본

`9-3 생성자와 소멸자` · 📄 [`ConstructorExample.java`](ConstructorExample.java)

#### 💻 코드

<!-- code: ConstructorExample.java -->
```java
public class ConstructorExample {
    public static void main(String[] args) {
        Cat c = new Cat("이쁜이", 45);
        System.out.println(c.toString() + "의 몸무게는 " + c.getSize());
        System.out.println(c + "의 몸무게는 " + c.getSize());   // 💡 toString() 자동 호출

        // Cat c2 = new Cat();   // ❌ 기본 생성자가 없으므로 컴파일 오류
    }
}

class Cat {
    int size;
    String name;

    public Cat(String n, int s) {   // 생성자 : 클래스 이름과 같고 반환형 없음
        name = n;
        size = s;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        return name;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
이쁜이의 몸무게는 45
이쁜이의 몸무게는 45
```

**포인트**

- 생성자 : 객체가 생성되면서 자동으로 호출되는 메소드. 주로 필드 초기화에 쓴다.
- 클래스 이름과 같은 이름, 반환형 없음(void 도 안 씀).
- 보통 public. private(같은 클래스 안에서만 생성 가능), protected(주로 추상 클래스)도 가능.

- 📝 필기 (퀴즈) : 객체가 생성될 때 → 생성자 / 객체가 소멸될 때 → 소멸자.<br>자바에서는 (소멸 시점을) 가비지 컬렉터가 결정함 → 파이널라이즈(finalize). (FinalizeTest.java)

- 💡 new Cat("이쁜이", 45) 의 실행 순서
  1. Heap 에 Cat 객체를 만들고 필드를 기본값(size = 0, name = null)으로 채운다.
  2. 인수 개수 · 자료형이 맞는 생성자 Cat(String, int) 를 호출해 필드를 초기화한다.
  3. 만들어진 객체의 레퍼런스를 c 에 대입한다.
- 💡 생성자를 하나도 안 만들면 컴파일러가 기본 생성자 Cat() {} 를 자동으로 넣어 준다.<br>하지만 Cat(String, int) 를 하나라도 만들면 기본 생성자는 생기지 않는다 → new Cat() 은 컴파일 오류.
  ```java
  error: constructor Cat in class Cat cannot be applied to given types;
    required: String,int
    found:    no arguments
  ```
- 💡 toString() 을 만들어 두면 c.toString() 대신 System.out.println(c) 만 써도 자동으로 호출된다.

## \[실습] 학생 성적 클래스 정의하기 – 전체, 과목별 평균

`9-3 생성자와 소멸자` · 📄 [`StudentScoreTest.java`](StudentScoreTest.java)

#### 💻 코드

<!-- code: StudentScoreTest.java -->
```java
public class StudentScoreTest {
    public static void main(String[] args) {
        int korSum = 0, engSum = 0, mathSum = 0;
        double totalSum = 0.0, korAvg, engAvg, mathAvg, totalAvg;
        StudentScore[] students = new StudentScore[3];   // 💡 레퍼런스 배열만 생김 (객체는 아직 없음)
        students[0] = new StudentScore("bmkim1", 2016001, 70, 80, 90);
        students[1] = new StudentScore("bmkim2", 2016002, 60, 70, 80);
        students[2] = new StudentScore("bmkim3", 2016003, 50, 60, 70);

        for (int i = 0; i < 3; i++) {
            System.out.println(students[i].getInfo());
            korSum += students[i].kor;
            engSum += students[i].eng;
            mathSum += students[i].math;
            totalSum += students[i].getAverage();
        }
        korAvg = korSum / 3.0;
        engAvg = engSum / 3.0;
        mathAvg = mathSum / 3.0;
        totalAvg = totalSum / 3.0;
        System.out.println("국어 평균 : " + korAvg);
        System.out.println("영어 평균 : " + engAvg);
        System.out.println("수학 평균 : " + mathAvg);
        System.out.println("전체 평균 : " + totalAvg);
    }
}

class StudentScore {
    String sname;
    int sid, kor, eng, math;

    public StudentScore(String name, int id, int k, int e, int m) {   // 생성자
        sname = name;
        sid = id;
        kor = k;
        eng = e;
        math = m;
    }

    double getAverage() {
        return (kor + eng + math) / 3.0;   // 💡 3 이 아니라 3.0 → 실수 나눗셈
    }

    String getInfo() {
        return sname + ", " + sid + ", " + kor + ", " + eng + ", " + math;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
bmkim1, 2016001, 70, 80, 90
bmkim2, 2016002, 60, 70, 80
bmkim3, 2016003, 50, 60, 70
국어 평균 : 60.0
영어 평균 : 70.0
수학 평균 : 80.0
전체 평균 : 70.0
```

**포인트**

- 7-1, 7-2에서 setInfo(...) 로 값을 넣던 학생 성적 예제를 "생성자"로 바꿨다.<br>7강 : students\[0] = new Student();  students\[0].setInfo("bmkim1", 2016001, 70, 80, 90);  (2단계)
  ```text
  9강 : students[0] = new StudentScore("bmkim1", 2016001, 70, 80, 90);                   (1단계)
  ```
- 생성자를 쓰면 "값이 비어 있는 객체"가 생기는 순간이 없고, setInfo 를 깜빡하는 실수도 막을 수 있다.

- ⚠ 자주 틀리는 부분 : 클래스 선언에서 class 키워드를 빠뜨리기 쉽다.
  - ❌ public StudentScoreTest {
  - ✅ public class StudentScoreTest {

## 생성자 중복 정의 · this() · this.필드

`9-3 생성자와 소멸자` · 📄 [`CatOverloading.java`](CatOverloading.java)

#### 💻 코드

<!-- code: CatOverloading.java -->
```java
public class CatOverloading {
    public static void main(String[] args) {
        CatOverload c1 = new CatOverload();               // CatOverload() 호출 → this("영순이", 50)
        CatOverload c2 = new CatOverload("이쁜이", 45);   // CatOverload(String, int) 호출
        System.out.println(c1 + "의 몸무게는 " + c1.getSize());
        System.out.println(c2 + "의 몸무게는 " + c2.getSize());

        BadCat bad = new BadCat("나비", 3);
        System.out.println("BadCat : " + bad.name + "의 몸무게는 " + bad.size);
        GoodCat good = new GoodCat("나비", 3);
        System.out.println("GoodCat : " + good.name + "의 몸무게는 " + good.size);
    }
}

class CatOverload {
    int size;
    String name;

    // 💡 처음 배운 형태 : public CatOverload() { name = "영순이"; size = 50; }
    public CatOverload() {
        //System.out.println("test"); 이 줄이 주석이 아니면 오류 (⚠ JDK 25 부터는 허용)
        this("영순이", 50);  // this 사용, 첫 줄이 아니면 오류
    }

    public CatOverload(String n, int s) {
        name = n;  // this.name = n; 과 동일
        size = s;  // this.size = s; 와 동일
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        return name;
    }
}

/** ❌ 틀린 예 : 매개변수 이름과 필드 이름이 같은데 this 를 안 쓴 경우 */
class BadCat {
    int size;
    String name;

    public BadCat(String name, int size) {
        name = name;   // ❌ 매개변수 name 에 자기 자신을 대입 → 필드는 그대로 null
        size = size;   // ❌ 필드는 그대로 0
    }
}

/** ✅ 고친 예 : this 키워드 사용 */
class GoodCat {
    int size;
    String name;

    public GoodCat(String name, int size) {
        this.name = name;  // this 키워드 사용
        this.size = size;  // this 키워드 사용
    }
}
```
<!-- /code -->

#### 실행 결과

```text
영순이의 몸무게는 50
이쁜이의 몸무게는 45
BadCat : null의 몸무게는 0
GoodCat : 나비의 몸무게는 3
```

**포인트**

- ❶ 생성자 중복 정의(오버로딩) : CatOverload() 과 CatOverload(String, int)
- ❷ 생성자 안에서 다른 생성자 호출 : this("영순이", 50)  → 생성자의 첫 문장이어야 함
- ❸ 매개변수 이름 = 필드 이름일 때 : this.name = name

- 📝 필기 (퀴즈) 오버로딩 : 메소드를 여러 형태로 제공해주는 것. 파라미터의 개수나 타입이 다르게.<br>중복정의(overloading) 라고 함.

**📝 필기 (퀴즈) 오버로딩 핵심 규칙**

  - 메소드 이름이 완전히 같아야 한다.
  - 파라미터의 개수, 타입(자료형), 순서 중 하나 이상이 반드시 달라야 한다.
  - 반환(return) 타입만 다르게 설정하는 것은 오버로딩으로 인정되지 않는다.
  - 도입 장점 : System.out.println() 이 대표적. 오버로딩이 없다면 printlnInt(), printlnString() 처럼 이름을 다 외워야 하지만, println() 하나만 기억하면 컴파일러가 알맞은 메소드를 찾아 실행해 준다.
- 📝 필기 (퀴즈 1번) : 다른 생성자를 호출할 때는 반드시 1번째 줄에 와야 함.

- ⚠ JDK 25 (JEP 513 Flexible Constructor Bodies) 부터는 this(...) 앞에 System.out.println("test"); 처럼 this(아직 만들어지지 않은 객체)를 건드리지 않는 문장을 쓸 수 있다. (JDK 21 : 컴파일 오류)<br>필드 대입처럼 this 를 쓰는 문장은 여전히 오류. 시험은 수업 기준 "this() 는 첫 문장" 으로 답한다.
- 💡 ❸ 의 name = name; 은 컴파일은 되지만 매개변수에 자기 자신을 대입할 뿐이라 필드는 null / 0 그대로다.<br>(BadCat 클래스로 확인)

- 💡 같은 모듈의 다른 예제에도 같은 이름의 클래스가 있어서 IntelliJ 에서 함께 빌드하면 중복 오류가 난다.<br>그래서 클래스 이름을 바꿨다. (Cat → CatOverload, 강의 코드에서는 바꾸기 전 이름)

## \[실습] 생성자 중복

`9-3 생성자와 소멸자` · 📄 [`MyRectangleTest.java`](MyRectangleTest.java)

#### 💻 코드

<!-- code: MyRectangleTest.java -->
```java
public class MyRectangleTest {
    public static void main(String[] args) {
        MyRectangle r1 = new MyRectangle();
        MyRectangle r2 = new MyRectangle(new MyPoint(3, 3), 5, 6);
        MyRectangle r3 = new MyRectangle(3, 3, 6, 6);
        System.out.println("r1 면적은 " + r1.getArea() + "입니다.");
        System.out.println("r2 면적은 " + r2.getArea() + "입니다.");
        System.out.println("r3 면적은 " + r3.getArea() + "입니다.");
    }
}

class MyPoint {
    private int x, y;

    public MyPoint() {
        x = 0;
        y = 0;
    }

    public MyPoint(int a, int b) {
        x = a;
        y = b;
    }

    public int getX() { return x; }
    public void setX(int newX) { x = newX; }
    public int getY() { return y; }
    public void setY(int newY) { y = newY; }
}

class MyRectangle {
    private MyPoint corner;
    private int width, height;

    public MyRectangle() {                            // 생성자 중복 정의
        corner = new MyPoint(0, 0);
        width = 0;
        height = 0;
    }

    public MyRectangle(MyPoint p, int w, int h) {     // 생성자 중복 정의
        corner = p;
        width = w;
        height = h;
    }

    public MyRectangle(int x, int y, int w, int h) {  // 생성자 중복 정의
        corner = new MyPoint(x, y);
        width = w;
        height = h;
    }

    public MyPoint getPoint() { return corner; }
    public void setPoint(MyPoint newP) { corner = newP; }
    public int getWidth() { return width; }
    public void setWidth(int newW) { width = newW; }
    public int getHeight() { return height; }
    public void setHeight(int newY) { height = newY; }   // 💡 강의 코드 그대로 (newH 가 더 자연스러움)

    public void resize(int newW, int newH) {
        width = newW;
        height = newH;
    }

    public int getArea() {
        return width * height;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
r1 면적은 0입니다.
r2 면적은 30입니다.
r3 면적은 36입니다.
```

**포인트**

- MyPoint : 생성자 2개 (기본 / 좌표 지정)
- MyRectangle : 생성자 3개
  ```text
  MyRectangle()                       → (0, 0) 위치, 크기 0
  ```<br>MyRectangle(MyPoint p, int w, int h) → 밖에서 만든 MyPoint 를 그대로 받음<br>MyRectangle(int x, int y, int w, int h) → 좌표(정수)만 받아 생성자 안에서 MyPoint 를 만듦<br>→ 사용하는 쪽이 편한 방법을 고를 수 있는 것이 생성자 오버로딩의 장점.

- 💡 7-5 의 MyRectangle 은 필드 선언에서 corner = new MyPoint() 를 하고 값은 setter 로 넣었다.<br>여기서는 생성자 세 개 중 어떤 것으로 만들어도 corner 가 반드시 채워진다.
- 💡 this(...) 를 써서 같은 코드를 줄인 버전은 MyRectangleThisTest.java

## \[실습] 다른 생성자 호출하기 – 이전 실습 부분 수정

`9-3 생성자와 소멸자` · 📄 [`MyRectangleThisTest.java`](MyRectangleThisTest.java)

#### 💻 코드

<!-- code: MyRectangleThisTest.java -->
```java
public class MyRectangleThisTest {
    public static void main(String[] args) {
        MyRectangleThis r1 = new MyRectangleThis();
        MyRectangleThis r2 = new MyRectangleThis(new MyPointThis(3, 3), 5, 6);
        MyRectangleThis r3 = new MyRectangleThis(3, 3, 6, 6);
        System.out.println("r1 면적은 " + r1.getArea() + "입니다.");
        System.out.println("r2 면적은 " + r2.getArea() + "입니다.");
        System.out.println("r3 면적은 " + r3.getArea() + "입니다.");
    }
}

class MyPointThis {
    private int x, y;

    public MyPointThis() {
        this(0, 0);
    }

    public MyPointThis(int x, int y) {  // this 키워드
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public void setX(int newX) { x = newX; }
    public int getY() { return y; }
    public void setY(int newY) { y = newY; }
}

class MyRectangleThis {
    private MyPointThis corner;
    private int width, height;

    public MyRectangleThis() {
        this(new MyPointThis(0, 0), 0, 0);  // this 키워드
    }

    public MyRectangleThis(MyPointThis p, int w, int h) {   // ← 실제 초기화는 여기서만
        corner = p;
        width = w;
        height = h;
    }

    public MyRectangleThis(int x, int y, int w, int h) {
        this(new MyPointThis(x, y), w, h);  // 💡 강의 코드에서 "…" 로 생략된 부분
    }

    public MyPointThis getPoint() { return corner; }
    public void setPoint(MyPointThis newP) { corner = newP; }
    public int getWidth() { return width; }
    public void setWidth(int newW) { width = newW; }
    public int getHeight() { return height; }
    public void setHeight(int newH) { height = newH; }

    public void resize(int newW, int newH) {
        width = newW;
        height = newH;
    }

    public int getArea() {
        return width * height;
    }
}
```
<!-- /code -->

#### 실행 결과 (MyRectangleTest.java 와 같음)

```text
r1 면적은 0입니다.
r2 면적은 30입니다.
r3 면적은 36입니다.
```

**포인트**

- MyRectangleTest.java 의 생성자들을 this(...) 로 바꿨다.
- MyPointThis()       → this(0, 0)
- MyPointThis(int x, int y) → 매개변수 이름을 필드와 같게 하고 this.x = x
- MyRectangleThis()   → this(new MyPointThis(0, 0), 0, 0)

- 📝 필기 (실습 1번) : 생성자 체이닝 this() 기법.<br>매개변수가 가장 많은 생성자 하나에만 실제 대입 코드를 두고, 나머지는 this(...) 로 그 생성자를 호출한다.<br>→ 초기화 코드가 한 곳에 모여 중복이 없고, 고칠 때도 한 곳만 고치면 된다.

- 💡 강의 코드는 MyRectangleThis() 까지만 보여 준다("…"). 나머지 MyRectangleThis(int x, int y, int w, int h) 도 this(new MyPointThis(x, y), w, h) 로 바꿨다.

**💡 this 의 두 가지 쓰임**

```text
this.필드, this.메소드() : 현재 객체의 필드 · 메소드        (일반 메소드, 생성자)
this(인수...)           : 같은 클래스의 다른 생성자 호출     (생성자 안에서만, 첫 문장)
```

- 💡 같은 모듈의 다른 예제에도 같은 이름의 클래스가 있어서 IntelliJ 에서 함께 빌드하면 중복 오류가 난다.<br>그래서 클래스 이름을 바꿨다. (MyPoint → MyPointThis, MyRectangle → MyRectangleThis, 강의 코드에서는 바꾸기 전 이름)

## 상수 필드 및 정적 필드 초기화

`9-3 생성자와 소멸자` · 📄 [`FieldInitTest.java`](FieldInitTest.java)

#### 💻 코드

<!-- code: FieldInitTest.java -->
```java
public class FieldInitTest {
    public static void main(String[] args) {
        System.out.println("① final 선언과 함께 : " + new CatFinal().getMax());
        System.out.println("② final 생성자에서 : " + new CatFinalCtor().getMax() + ", " + new CatFinalCtor(200).getMax());
        System.out.println("③ static 선언과 함께 : " + CatStatic.getMax());
        System.out.println("④ static 블록 : " + CatStaticBlock.getMax());   // 이때 CatStaticBlock 이 로드되며 static 블록 실행

        System.out.println("⑤ 객체 생성 전 CatStaticInCtor.MAX_SIZE = " + CatStaticInCtor.MAX_SIZE);
        new CatStaticInCtor();
        System.out.println("   객체 생성 후 CatStaticInCtor.MAX_SIZE = " + CatStaticInCtor.MAX_SIZE);
        CatStaticInCtor.MAX_SIZE = 999;
        System.out.println("   값을 바꾼 뒤 CatStaticInCtor.MAX_SIZE = " + CatStaticInCtor.MAX_SIZE);
        new CatStaticInCtor();
        System.out.println("   객체 하나 더 생성 후 CatStaticInCtor.MAX_SIZE = " + CatStaticInCtor.MAX_SIZE + "  ← 덮어써짐");

        System.out.print("💡 static 블록 활용 :");
        for (int s : Squares.squares) System.out.print(" " + s);
        System.out.println();
    }
}

/** ① 상수 필드 : 선언과 함께 초기화 */
class CatFinal {
    private final int MAX_SIZE = 100;
    private String name;

    int getMax() { return MAX_SIZE; }
}

/** ② 상수 필드 : 생성자에서 초기화 (blank final) */
class CatFinalCtor {
    private final int MAX_SIZE;
    private String name;

    public CatFinalCtor() {
        MAX_SIZE = 100;
        // MAX_SIZE = 200;   // ❌ cannot assign a value to final variable MAX_SIZE (한 번만 가능)
    }

    public CatFinalCtor(int max) {   // 💡 객체마다 다른 상수 값
        MAX_SIZE = max;
    }

    int getMax() { return MAX_SIZE; }
}

/** ③ 정적 필드 : 선언과 함께 초기화 */
class CatStatic {
    private static int MAX_SIZE = 100;
    private String name;

    static int getMax() { return MAX_SIZE; }
}

/** ④ 정적 필드 : static 블록에서 초기화 */
class CatStaticBlock {
    private static int MAX_SIZE;
    private String name;

    static {
        MAX_SIZE = 100;
        System.out.println("static 블록 실행 (클래스 로드 시 한 번)");
    }

    static int getMax() { return MAX_SIZE; }
}

/** ⑤ ⚠ static 필드를 생성자에서 대입 : 컴파일은 되지만 "초기화"가 아님 */
class CatStaticInCtor {
    static int MAX_SIZE;
    // private static final int LIMIT;   // ❌ static final 은 생성자에서 대입 불가 (컴파일 오류)

    public CatStaticInCtor() {
        MAX_SIZE = 100;     // 객체를 만들 때마다 다시 100 으로 덮어씀
    }
}

/** 💡 static 블록은 계산이 필요한 초기화에 유용 */
class Squares {
    static int[] squares = new int[10];

    static {
        for (int i = 0; i < 10; i++) {
            squares[i] = i * i;
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
① final 선언과 함께 : 100
② final 생성자에서 : 100, 200
③ static 선언과 함께 : 100
static 블록 실행 (클래스 로드 시 한 번)      ← 💡 CatStaticBlock 을 처음 쓰는 순간 실행
④ static 블록 : 100
⑤ 객체 생성 전 CatStaticInCtor.MAX_SIZE = 0
   객체 생성 후 CatStaticInCtor.MAX_SIZE = 100
   값을 바꾼 뒤 CatStaticInCtor.MAX_SIZE = 999
   객체 하나 더 생성 후 CatStaticInCtor.MAX_SIZE = 100  ← 덮어써짐
💡 static 블록 활용 : 0 1 4 9 16 25 36 49 64 81
```

**포인트**

- 상수 필드(final) : ① 선언과 함께 초기화  ② 생성자에서 초기화 (blank final)
- 정적 필드(static) : ① 선언과 함께 초기화  ② static 블록 static { ... } 에서 초기화 수업 정리 : "정적 필드는 생성자에서 초기화 할 수 없음" → static 블록을 쓴다.

- 💡 final 필드는 딱 한 번만 값을 넣을 수 있다. 다시 대입하면
  ```text
  error: cannot assign a value to final variable MAX_SIZE
  ```
- 💡 blank final 은 모든 생성자에서 반드시 값을 넣어야 한다. 빠뜨리면
  ```text
  error: variable MAX_SIZE might not have been initialized
  ```
- 💡 blank final 의 장점 : 객체마다 다른 상수 값을 줄 수 있다. (CatFinalCtor(int max))
- 💡 정적 필드는 객체가 아니라 클래스가 처음 로드될 때 한 번 만들어진다.<br>생성자는 객체를 만들 때마다 실행되므로 정적 필드 초기화에 맞지 않다 → static 블록은 클래스 로드 시 한 번만 실행.
- ⚠ "생성자에서 초기화할 수 없음" 을 정확히 말하면
  - static final 필드 : 생성자에서 대입하면 컴파일 오류.
  - 그냥 static 필드  : 생성자에서 대입하는 것 자체는 문법상 가능. 하지만 객체를 만들 때마다 값이 덮어써지고, 객체를 하나도 안 만들면 아예 초기화되지 않는다. (CatStaticInCtor 로 확인)<br>퀴즈 1번 Cat() { this("영순이", 50); MAX\_WEIGHT = 100; } 가 이 경우다.

```text
필드 종류      | 선언과 함께 | 생성자에서          | static 블록
일반 필드      |     O       |      O              |     X
final 필드     |     O       |      O (한 번만)    |     X
static 필드    |     O       |      △ (매번 덮어씀)|     O
static final   |     O       |      X 컴파일 오류  |     O
```

## 소멸자와 finalize

`9-3 생성자와 소멸자` · 📄 [`FinalizeTest.java`](FinalizeTest.java)

#### 💻 코드

<!-- code: FinalizeTest.java -->
```java
public class FinalizeTest {
    public static void main(String[] args) throws Throwable {
        // ① 강의 코드 (강의에서는 클래스 이름이 ConstructorExample)
        CatFinalize c = new CatFinalize("이쁜이", 45);
        CatFinalize c2 = new CatFinalize();
        System.out.println(c.toString() + "의 몸무게는 " + c.getSize());
        System.out.println(c2.toString() + "의 몸무게는 " + c2.getSize());
        c = null;     // 강의 코드에서는 주석 처리됨
        c2 = null;

        // ② 💡 GC 요청 후 잠깐 기다리기
        System.out.println("----- System.gc() 요청 -----");
        System.gc();
        Thread.sleep(500);
        System.out.println("----- main 끝 -----");
    }
}

class CatFinalize {
    int size;
    String name;

    public CatFinalize() {
        this("영순이", 50);
    }

    public CatFinalize(String n, int s) {
        name = n;
        size = s;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        return name;
    }

    @SuppressWarnings("removal")   // 💡 위 ⚠ 경고를 숨김 (강의 코드에는 없음)
    public void finalize() {
        System.out.println(name + " 고양이가 소멸됨");
    }
}
```
<!-- /code -->

#### 실행 결과 (② 의 출력 순서 · 여부는 GC 에 따라 다를 수 있음)

```text
이쁜이의 몸무게는 45
영순이의 몸무게는 50
----- System.gc() 요청 -----
이쁜이 고양이가 소멸됨
영순이 고양이가 소멸됨
----- main 끝 -----
```

**포인트**

- 소멸자 : 객체가 소멸될 때 자동으로 호출되는 메소드. C++ 은 \~클래스명() 형태.
- Java 에는 그런 소멸자가 없고 finalize 메소드를 제공한다.
- 객체 소멸 = 객체 변수를 null 로 지정 → 가비지 컬렉터(GC)가 적당한 시점에 제거하면서 finalize 호출.
- GC 가 시점을 정하므로 객체의 소멸 시기를 정확히 알 수 없다.

- 📝 필기 (퀴즈) : 객체가 소멸될 때 소멸자. 자바에서는 가비지 컬렉터가 결정함. → 파이널라이즈(finalize)

- 💡 강의 코드(① 부분)만 실행하면 "고양이가 소멸됨" 은 출력되지 않는다. c = null; 주석을 풀어도 마찬가지.<br>프로그램이 너무 빨리 끝나 GC 가 돌 기회가 없고, 종료 시에는 finalize 를 호출해 주지 않기 때문이다.<br>그래서 ② 에서 System.gc() 로 GC 를 "요청"하고 잠깐 기다렸다. 보통은 호출되지만 이것도 보장은 아니다.
- 💡 null 대입 외에도 다른 객체를 대입하거나(c = new CatFinalize()) 지역 변수의 블록이 끝나면 GC 대상이 된다.
- 💡 throws Throwable 은 Object 의 finalize() 가 throws Throwable 로 선언되어 있어서 붙인 것. (예외 처리는 11강)
- 💡 Object 의 finalize() 는 protected 인데 public 으로 재정의했다. 접근 범위를 넓히는 재정의는 허용(10강 상속).
- ⚠ finalize() 는 Java 9 부터 deprecated, Java 18 부터 삭제 예정(for removal, JEP 421).<br>JDK 25 로 컴파일하면 경고가 나온다.
  ```text
  warning: [removal] finalize() in Object has been deprecated and marked for removal
  ```<br>실무에서는 close() + try-with-resources(AutoCloseable) 로 자원을 정리한다(13강 파일 입출력).<br>수업에서는 "자바의 소멸자 = finalize" 로 개념만 이해하면 된다.

- 💡 같은 모듈의 다른 예제에도 같은 이름의 클래스가 있어서 IntelliJ 에서 함께 빌드하면 중복 오류가 난다.<br>그래서 클래스 이름을 바꿨다. (Cat → CatFinalize, 강의 코드에서는 바꾸기 전 이름)

---

[🏠 9주차 학습 가이드](../../README.md)
