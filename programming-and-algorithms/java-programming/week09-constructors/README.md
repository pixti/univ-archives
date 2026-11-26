# Week 09: DateTime · 열거형 · 생성자와 소멸자

자바프로그래밍(GA1001) 9주차 정리입니다.

- 강의 내용은 `1-lecture/`에 정리했습니다.
- 퀴즈 · 실습 · 과제는 폴더마다 `README.md`에 **문제 → 풀이 코드 → 실행 결과 → 📝 필기 · 해설** 순서로 정리했습니다. 같은 폴더의 `.java` 파일은 바로 실행해 볼 수 있는 코드입니다.
- 모든 코드는 **JDK 25**로 실행을 확인했습니다. 수업 기준(JDK 21 이하)과 동작이 다른 부분(`this()` 앞에 문장 허용, `finalize()` 경고)은 ⚠로 표시했습니다.

| 표시 | 의미 |
|---|---|
| 📝 **필기** | 수업 중 필기한 내용, 질문하며 정리한 설명 |
| 💡 **보충** | 정리하면서 덧붙인 설명, 참고 답안 |
| ⚠ **주의** | 자주 틀리는 부분, 헷갈리기 쉬운 부분 |
| ❌ / ✅ | 틀린 코드 / 고친 코드 |

## 📚 학습 순서

수업 흐름(교안 → 퀴즈 → 실습 → 과제)대로 읽도록 폴더 이름에 번호를 붙였습니다.

| 단계 | 이렇게 공부하세요 | 바로가기 |
|---|---|---|
| 1️⃣ 강의 | 강의 노트로 개념을 익히고, 예제 코드를 직접 실행해 결과를 확인합니다. | 노트 [9-1](1-lecture/9-1_날짜와시간_DateTime.md) · [9-2](1-lecture/9-2_열거형_Enumeration.md) · [9-3](1-lecture/9-3_생성자와소멸자.md) · [예제 코드](1-lecture/code/README.md) |
| 2️⃣ 퀴즈 | 문제만 보고 답을 먼저 떠올린 뒤, 정답과 📝 필기로 확인합니다. | [퀴즈](2-quiz/README.md) |
| 3️⃣ 실습 | 문제를 직접 풀어 본 뒤, 풀이 코드 · 실행 결과 · 해설과 비교합니다. | [constructors](3-practice/constructors/README.md) · [datetime-enum](3-practice/datetime-enum/README.md) |
| 4️⃣ 과제 | 실습에서 익힌 내용을 응용합니다. ⚠ 자주 틀리는 부분을 다시 확인하세요. | [전체](4-assignment/README.md) |

## 1️⃣ 강의 노트 (`1-lecture/`)

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 9-1 | [날짜와 시간 (DateTime)](1-lecture/9-1_날짜와시간_DateTime.md) | 기존 `Date` / `Calendar`의 문제점(월이 0부터), 기계 시간 `Instant` vs 휴먼 시간, `LocalDateTime`(불변 객체, 팩토리 메소드, `plus` / `minus` / `with`, `DateTimeFormatter`), `ZonedDateTime`과 시간대, 실행 시간 측정(`currentTimeMillis` · `nanoTime` · `Duration`) |
| 9-2 | [열거형 (Enumeration)](1-lecture/9-2_열거형_Enumeration.md) | `static final int` 상수의 문제점 4가지, `enum` 선언, 타입 안전성과 이름 공간, `values()`, `==` 비교, `switch`, 💡 `valueOf` · `ordinal` · `Month` / `DayOfWeek` |
| 9-3 | [생성자와 소멸자](1-lecture/9-3_생성자와소멸자.md) | 생성자(반환형 없음, 기본 생성자), 생성자 중복 정의(📝 오버로딩 규칙), `this(...)`로 다른 생성자 호출(⚠ JDK 25 JEP 513), `this.필드`, `final` · `static` 필드 초기화와 static 블록, 소멸자와 `finalize`(⚠ deprecated), 가비지 컬렉터 |

### 강의 예제 코드 ([`1-lecture/code/`](1-lecture/code/README.md))

| 파일 | 차시 | 내용 |
|---|---|---|
| [OldDateProblem.java](1-lecture/code/README.md#기존-date--calendar-클래스의-문제점) | 9-1 | `Date` / `Calendar`의 문제점: `MONTH`에 8을 넣으면 9월 |
| [InstantTest.java](1-lecture/code/README.md#기계-시간---instant) | 9-1 | `Instant`(UTC, `Z`), `getEpochSecond` / `getNano`, `atZone`으로 서울 · LA 시각 |
| [LocalDateTimeTest.java](1-lecture/code/README.md#휴먼-시간---localdatetime-예제) | 9-1 | `now` / `of`, `format`, `plusDays` / `minusDays`. 💡 `isBefore`, `with~`, 결과를 버리는 실수(불변) |
| [ZonedDateTimeTest.java](1-lecture/code/README.md#휴먼-시간---zoneddatetime) | 9-1 | 콜카타 · 뉴욕 시각. 💡 `Locale.ENGLISH`로 `Nov` / `AM` 고정 |
| [ElapsedTimeTest.java](1-lecture/code/README.md#프로그램-실행-시간-측정하기---세-가지-방법-비교) | 9-1 | 실행 시간 측정 세 가지 방법 비교 |
| [SuitEnumTest.java](1-lecture/code/README.md#상수int-방식의-문제점과-열거형enum으로-해결하기) | 9-2 | 상수 방식 vs `enum Suit`, `values()`, `==`, `switch` fall-through. ⚠ `value()` → `values()` |
| [ConstructorExample.java](1-lecture/code/README.md#생성자-기본) | 9-3 | 생성자 기본. 💡 기본 생성자가 자동으로 생기지 않는 경우 |
| [StudentScoreTest.java](1-lecture/code/README.md#실습-학생-성적-클래스-정의하기--전체-과목별-평균) | 9-3 | [실습] 학생 성적 클래스를 생성자로. ⚠ `class` 누락 수정 |
| [CatOverloading.java](1-lecture/code/README.md#생성자-중복-정의--this--this필드) | 9-3 | 생성자 중복 정의, `this("영순이", 50)`, `name = name` 버그 vs `this.name = name` (⚠ JDK 25) |
| [MyRectangleTest.java](1-lecture/code/README.md#실습-생성자-중복) | 9-3 | [실습] 생성자 중복 (`MyPoint` 2개, `MyRectangle` 3개) |
| [MyRectangleThisTest.java](1-lecture/code/README.md#실습-다른-생성자-호출하기--이전-실습-부분-수정) | 9-3 | [실습] 다른 생성자 호출하기: 위 예제를 `this(...)`로 수정 |
| [FieldInitTest.java](1-lecture/code/README.md#상수-필드-및-정적-필드-초기화) | 9-3 | `final` 필드(선언 · 생성자), `static` 필드(선언 · static 블록). ⚠ 생성자에서 `static` 필드 대입 |
| [FinalizeTest.java](1-lecture/code/README.md#소멸자와-finalize) | 9-3 | 소멸자 `finalize`, `null` 대입과 `System.gc()`. ⚠ `finalize` deprecated |

## 2️⃣ 퀴즈 ([`2-quiz/`](2-quiz/README.md))

| 파일 | 내용 |
|---|---|
| [ConstructorQuiz.java](2-quiz/README.md#생성자와-소멸자-생성자--소멸자--오버로딩--this--복사-생성자) | 생성자와 소멸자 개념, 📝 오버로딩 규칙, 1번 Cat 코드의 오류 4가지 고치기(⚠ `void Cat()`은 일반 메소드, JDK 25), 📝 생성자와 getter / setter의 차이(추가 질문), 2번 Dog(⚠ `String`은 대문자), 3번 Cube 복사 생성자(⚠ 부피는 side³) |

## 3️⃣ 실습 (`3-practice/`)

| 파일 | 문제 |
|---|---|
| [constructors/PlaneTest.java](3-practice/constructors/README.md#1-plane-생성자-4개-생성자-체이닝-this-기법) | 1. Plane: 생성자 4개 (📝 생성자 체이닝 `this()` 기법) |
| [constructors/BoxTest.java](3-practice/constructors/README.md#2-box-부피가-가장-큰-상자-참고-답안-실수-오차-반올림) | 2. 💡 Box: 부피가 가장 큰 상자 (참고 답안, 실수 오차 반올림) |
| [constructors/MovieTest.java](3-practice/constructors/README.md#3-movie-평점이-가장-좋은-영화-참고-답안) | 3. 💡 Movie: 평점이 가장 좋은 영화 (참고 답안) |
| [constructors/NationTest.java](3-practice/constructors/README.md#4-nation-인구--국민소득이-가장-큰-나라) | 4. 💡 Nation: 인구 · 국민소득이 가장 큰 나라 (참고 답안. ⚠ C++식 지수 표기) |
| [constructors/MatrixTest.java](3-practice/constructors/README.md#5-matrix-생성자로-크기-지정-합--차--전치--곱-tostring) | 5. Matrix: 생성자로 크기 지정, 합 · 차 · 전치 · 곱, `toString` (📝 깊은 복사, 곱셈 조건) |
| [datetime-enum/DaysOfWeekTest.java](3-practice/datetime-enum/README.md#1-요일-열거형) | 1. 요일 열거형 |
| [datetime-enum/ShapeTest.java](3-practice/datetime-enum/README.md#2-도형-열거형) | 2. 도형 열거형 (⚠ 출력 형식을 문제에 맞게 수정) |
| [datetime-enum/MonthsTest.java](3-practice/datetime-enum/README.md#3-월-열거형-참고-답안-valueof로-실제-이번-달) | 3. 💡 월 열거형 (참고 답안, `valueOf`로 실제 이번 달) |
| [datetime-enum/NowInfo.java](3-practice/datetime-enum/README.md#4-현재-연--월--일--시--분-getmonthvalue) | 4. 현재 연 · 월 · 일 · 시 · 분 (`getMonthValue`) |
| [datetime-enum/NewYorkTime.java](3-practice/datetime-enum/README.md#5-뉴욕의-현재-시각) | 5. 뉴욕의 현재 시각 (💡 `%02d`로 두 자리) |
| [datetime-enum/LastDayOfMonth.java](3-practice/datetime-enum/README.md#6-이번-달의-마지막-날) | 6. 이번 달의 마지막 날 (📝 "2026년 November 30"으로 문제 변경. ⚠ `getDisplayName`) |
| [datetime-enum/HundredDaysLater.java](3-practice/datetime-enum/README.md#7-추가-문제-100일-뒤의-날짜-plusdays) | 7. 추가 문제: 100일 뒤의 날짜 (`plusDays`) |

## 4️⃣ 과제 (`4-assignment/`)

| 파일 | 문제 |
|---|---|
| [EmployeeTest.java](4-assignment/README.md#1-employee-생성자-3개-7강-과제에-생성자-추가) | 1. Employee: 생성자 3개 (7강 과제에 생성자 추가) |
| [CellPhoneTest.java](4-assignment/README.md#2-cellphone-생성자-3개-is-getter) | 2. CellPhone: 생성자 3개, `is~` getter |
| [TriangleTest.java](4-assignment/README.md#3-triangle-생성자와-넓이-int-형변환-출력) | 3. Triangle: 생성자와 넓이 (💡 `(int)` 형변환 출력) |
| [RectangleTest.java](4-assignment/README.md#4-rectangle--point-정적-필드로-객체-수-세기) | 4. Rectangle + Point: 정적 필드로 객체 수 세기 (💡 체이닝으로 `rectCount++`는 한 곳에만, 이클립스 미사용 필드 경고) |
| [SMSTest.java](4-assignment/README.md#5-sms-생성자-2개-나중에-setter로-값-넣기) | 5. SMS: 생성자 2개, 나중에 setter로 값 넣기 (💡 `setText` / `setMsgtext`) |
| [MyWorldTest.java](4-assignment/README.md#6-myworld-같은-클래스-객체를-필드로-가지는-일촌-관계-인기도) | 6. MyWorld: 같은 클래스 객체를 필드로 가지는 일촌 관계, 인기도 (💡 `null` 검사) |

## 📁 구조

```
week09-constructors/
├── README.md              학습 가이드 (이 문서)
├── 1-lecture/             1️⃣ 강의 노트
│   └── code/              　  강의 예제 코드 (README + .java)
├── 2-quiz/                2️⃣ 퀴즈 (README + .java)
├──  3-practice/          3️⃣ 실습
│   ├── constructors/     생성자
│   └── datetime-enum/    DateTime · Enum
└──  4-assignment/        4️⃣ 과제
```

## ▶ 실행 방법

모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java 1-lecture/code/CatOverloading.java
java 3-practice/constructors/MatrixTest.java
java 2-quiz/ConstructorQuiz.java
java 4-assignment/MyWorldTest.java
```

Windows 콘솔에서 한글이 깨지면 다음과 같이 인코딩을 지정합니다.

```bash
java -Dstdout.encoding=UTF-8 -Dstdin.encoding=UTF-8 -Dfile.encoding=UTF-8 4-assignment/MyWorldTest.java
```

> ⚠ **파일마다 독립된 프로그램입니다.**
> 각 파일에는 `public class` 하나와 그 파일에서 쓰는 보조 클래스(`Cat`, `MyPoint`, `MyRectangle`, `Point` 등)가 함께 들어 있습니다. IntelliJ 모듈(`examples`+`quiz`+`assignment`, `practice`) 안에서는 보조 클래스 이름이 겹치지 않도록 바꿔 두었기 때문에 모듈 단위로 빌드해도 오류가 나지 않습니다. 이름을 바꾼 파일은 머리말에 강의 코드의 원래 이름을 적어 두었습니다.
> 단, `3-practice/`와 `1-lecture/code/`처럼 **서로 다른 모듈**에는 같은 이름의 보조 클래스가 있을 수 있습니다. 주차 폴더 전체를 `javac`로 한 번에 컴파일하면 `duplicate class` 오류가 날 수 있으니, 위처럼 `java 파일이름.java`로 **한 파일씩** 실행하세요.

> 💡 **실행할 때마다 결과가 다른 파일**
> DateTime 예제와 실습(`InstantTest`, `LocalDateTimeTest`, `NowInfo`, `LastDayOfMonth` 등)은 현재 날짜와 시각을 쓰므로 실행할 때마다 결과가 다릅니다. 파일 머리말의 실행 결과는 실행 예시입니다.
> `FinalizeTest`의 "고양이가 소멸됨"은 가비지 컬렉터가 결정하므로 순서가 바뀌거나 출력되지 않을 수도 있습니다.

> ⚠ **JDK 버전에 따른 차이**
> - `this(...)` 앞에 문장 쓰기: JDK 25부터 허용됩니다(JEP 513). JDK 21 이하에서는 컴파일 오류입니다. 시험은 수업 기준인 "**`this()`는 생성자의 첫 문장**"으로 답합니다.
> - `finalize()`: JDK 18부터 삭제 예정(for removal)이라 컴파일 경고가 나옵니다. `FinalizeTest.java`는 `@SuppressWarnings("removal")`로 경고를 숨겼습니다.

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다. 단, 서로 다른 폴더(예: 실습과 과제)의 파일은 보조 클래스 이름이 겹칠 수 있으니 같은 프로젝트(패키지)에 함께 넣지 말고 하나씩 넣어서 실행합니다.
실습·과제는 원래 이클립스에서 `Main.java` 등으로 작성했던 코드입니다. 여기서는 문제 내용에 맞게 클래스 이름을 바꿨습니다.
