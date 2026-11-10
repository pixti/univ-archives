# Week 09: DateTime · 열거형 · 생성자와 소멸자

자바프로그래밍(GA1001) 9주차 정리입니다.
교재는 『자바만 잡아도』입니다.

- 강의 자료(.pptx)는 Markdown으로 정리했습니다. 강의 자료 파일 이름은 `9-1 ~ 9-3`입니다.
- 실습, 퀴즈, 과제는 `.java` 코드로 정리했습니다. 실습은 **생성자**와 **DateTime · Enum** 두 묶음입니다.
- 수업 중 필기와 AI에게 받은 설명은 **📝 필기** 표시로 주석과 노트에 넣었습니다.
- 💡 표시는 정리하면서 덧붙인 설명입니다. 직접 풀지 않은 문제는 💡 참고 답안으로 채웠습니다.
- ⚠ 표시는 원본 자료의 오타나 버그, 내 답안의 틀린 부분, AI가 알려 준 코드의 문제점을 바로잡은 곳입니다. 바로잡은 코드는 ❌ 원본 / ✅ 수정으로 나란히 두었습니다.
- 이 저장소는 **JDK 25**로 실행을 확인했습니다. 교재(Java 24 이하)와 동작이 다른 부분(`this()` 앞에 문장 허용, `finalize()` 경고)은 ⚠로 표시했습니다.

## 📁 구조

```
week09-constructors/
├── lecture-notes/          강의 자료 (.pptx → .md)
├── examples/               강의 슬라이드 속 예제 코드
├── practice/               실습
│   ├── constructors/       ├ 생성자
│   └── datetime-enum/      └ DateTime · Enum
├── quiz/                   퀴즈
└── assignment/             과제
```

## 📖 강의 노트

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 9-1 | [날짜와 시간 (DateTime)](lecture-notes/9-1_날짜와시간_DateTime.md) | 기존 `Date` / `Calendar`의 문제점(월이 0부터), 기계 시간 `Instant` vs 휴먼 시간, `LocalDateTime`(불변 객체, 팩토리 메소드, `plus` / `minus` / `with`, `DateTimeFormatter`), `ZonedDateTime`과 시간대, 실행 시간 측정(`currentTimeMillis` · `nanoTime` · `Duration`) |
| 9-2 | [열거형 (Enumeration)](lecture-notes/9-2_열거형_Enumeration.md) | `static final int` 상수의 문제점 4가지, `enum` 선언, 타입 안전성과 이름 공간, `values()`, `==` 비교, `switch`, 💡 `valueOf` · `ordinal` · `Month` / `DayOfWeek` |
| 9-3 | [생성자와 소멸자](lecture-notes/9-3_생성자와소멸자.md) | 생성자(반환형 없음, 기본 생성자), 생성자 중복 정의(📝 오버로딩 규칙), `this(...)`로 다른 생성자 호출(⚠ JDK 25 JEP 513), `this.필드`, `final` · `static` 필드 초기화와 static 블록, 소멸자와 `finalize`(⚠ deprecated), 가비지 컬렉터 |

## 💻 코드

### 강의 예제 (`examples/`)

| 파일 | 차시 | 내용 |
|---|---|---|
| [OldDateProblem.java](examples/OldDateProblem.java) | 9-1 | `Date` / `Calendar`의 문제점: `MONTH`에 8을 넣으면 9월 |
| [InstantTest.java](examples/InstantTest.java) | 9-1 | `Instant`(UTC, `Z`), `getEpochSecond` / `getNano`, `atZone`으로 서울 · LA 시각 |
| [LocalDateTimeTest.java](examples/LocalDateTimeTest.java) | 9-1 | `now` / `of`, `format`, `plusDays` / `minusDays`. 💡 `isBefore`, `with~`, 결과를 버리는 실수(불변) |
| [ZonedDateTimeTest.java](examples/ZonedDateTimeTest.java) | 9-1 | 콜카타 · 뉴욕 시각. 💡 `Locale.ENGLISH`로 `Nov` / `AM` 고정 |
| [ElapsedTimeTest.java](examples/ElapsedTimeTest.java) | 9-1 | 실행 시간 측정 세 가지 방법 비교 |
| [SuitEnumTest.java](examples/SuitEnumTest.java) | 9-2 | 상수 방식 vs `enum Suit`, `values()`, `==`, `switch` fall-through. ⚠ `value()` → `values()` |
| [ConstructorExample.java](examples/ConstructorExample.java) | 9-3 | 생성자 기본. 💡 기본 생성자가 자동으로 생기지 않는 경우 |
| [StudentScoreTest.java](examples/StudentScoreTest.java) | 9-3 | [실습] 학생 성적 클래스를 생성자로. ⚠ `class` 누락 수정 |
| [CatOverloading.java](examples/CatOverloading.java) | 9-3 | 생성자 중복 정의, `this("영순이", 50)`, `name = name` 버그 vs `this.name = name` (⚠ JDK 25) |
| [MyRectangleTest.java](examples/MyRectangleTest.java) | 9-3 | [실습] 생성자 중복 (`MyPoint` 2개, `MyRectangle` 3개). ⚠ 스마트 따옴표 수정 |
| [MyRectangleThisTest.java](examples/MyRectangleThisTest.java) | 9-3 | [실습] 다른 생성자 호출하기: 위 예제를 `this(...)`로 수정 |
| [FieldInitTest.java](examples/FieldInitTest.java) | 9-3 | `final` 필드(선언 · 생성자), `static` 필드(선언 · static 블록). ⚠ 생성자에서 `static` 필드 대입 |
| [FinalizeTest.java](examples/FinalizeTest.java) | 9-3 | 소멸자 `finalize`, `null` 대입과 `System.gc()`. ⚠ `finalize` deprecated |

### 실습 (`practice/`)

| 파일 | 문제 |
|---|---|
| [constructors/PlaneTest.java](practice/constructors/PlaneTest.java) | 1. Plane: 생성자 4개 (📝 생성자 체이닝 `this()` 기법) |
| [constructors/BoxTest.java](practice/constructors/BoxTest.java) | 2. 💡 Box: 부피가 가장 큰 상자 (참고 답안, 실수 오차 반올림) |
| [constructors/MovieTest.java](practice/constructors/MovieTest.java) | 3. 💡 Movie: 평점이 가장 좋은 영화 (참고 답안) |
| [constructors/NationTest.java](practice/constructors/NationTest.java) | 4. 💡 Nation: 인구 · 국민소득이 가장 큰 나라 (참고 답안. ⚠ C++식 지수 표기) |
| [constructors/MatrixTest.java](practice/constructors/MatrixTest.java) | 5. Matrix: 생성자로 크기 지정, 합 · 차 · 전치 · 곱, `toString` (📝 깊은 복사, 곱셈 조건) |
| [datetime-enum/DaysOfWeekTest.java](practice/datetime-enum/DaysOfWeekTest.java) | 1. 요일 열거형 |
| [datetime-enum/ShapeTest.java](practice/datetime-enum/ShapeTest.java) | 2. 도형 열거형 (⚠ 출력 형식을 문제에 맞게 수정) |
| [datetime-enum/MonthsTest.java](practice/datetime-enum/MonthsTest.java) | 3. 💡 월 열거형 (참고 답안, `valueOf`로 실제 이번 달) |
| [datetime-enum/NowInfo.java](practice/datetime-enum/NowInfo.java) | 4. 현재 연 · 월 · 일 · 시 · 분 (`getMonthValue`) |
| [datetime-enum/NewYorkTime.java](practice/datetime-enum/NewYorkTime.java) | 5. 뉴욕의 현재 시각 (💡 `%02d`로 두 자리) |
| [datetime-enum/LastDayOfMonth.java](practice/datetime-enum/LastDayOfMonth.java) | 6. 이번 달의 마지막 날 (📝 "2026년 November 30"으로 문제 변경. ⚠ `getDisplayName`) |
| [datetime-enum/HundredDaysLater.java](practice/datetime-enum/HundredDaysLater.java) | 7. 추가 문제: 100일 뒤의 날짜 (`plusDays`) |

### 퀴즈 (`quiz/`)

| 파일 | 내용 |
|---|---|
| [ConstructorQuiz.java](quiz/ConstructorQuiz.java) | 생성자와 소멸자 개념, 📝 오버로딩 규칙, 1번 Cat 코드의 오류 4가지 고치기(⚠ `void Cat()`은 일반 메소드, JDK 25), 📝 생성자와 getter / setter의 차이(AI 질문), 2번 Dog(⚠ `string` 오타), 3번 Cube 복사 생성자(⚠ 부피는 side³) |

### 과제 (`assignment/`)

| 파일 | 문제 |
|---|---|
| [EmployeeTest.java](assignment/EmployeeTest.java) | 1. Employee: 생성자 3개 (7강 과제에 생성자 추가) |
| [CellPhoneTest.java](assignment/CellPhoneTest.java) | 2. CellPhone: 생성자 3개, `is~` getter |
| [TriangleTest.java](assignment/TriangleTest.java) | 3. Triangle: 생성자와 넓이 (💡 `(int)` 형변환 출력) |
| [RectangleTest.java](assignment/RectangleTest.java) | 4. Rectangle + Point: 정적 필드로 객체 수 세기 (💡 체이닝으로 `rectCount++`는 한 곳에만, 이클립스 미사용 필드 경고) |
| [SMSTest.java](assignment/SMSTest.java) | 5. SMS: 생성자 2개, 나중에 setter로 값 넣기 (💡 `setText` / `setMsgtext`) |
| [MyWorldTest.java](assignment/MyWorldTest.java) | 6. MyWorld: 같은 클래스 객체를 필드로 가지는 일촌 관계, 인기도 (💡 `null` 검사) |

## ▶ 실행 방법

모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java examples/CatOverloading.java
java practice/constructors/MatrixTest.java
java quiz/ConstructorQuiz.java
java assignment/MyWorldTest.java
```

Windows 콘솔에서 한글이 깨지면 다음과 같이 인코딩을 지정합니다.

```bash
java -Dstdout.encoding=UTF-8 -Dstdin.encoding=UTF-8 -Dfile.encoding=UTF-8 assignment/MyWorldTest.java
```

> ⚠ **파일마다 독립된 프로그램입니다.**
> 각 파일에는 `public class` 하나와 그 파일에서 쓰는 보조 클래스(`Cat`, `MyPoint`, `MyRectangle`, `Point` 등)가 함께 들어 있습니다. 같은 폴더의 여러 파일에 이름이 같은 보조 클래스가 있습니다. 예를 들어 `examples/`의 `ConstructorExample.java`, `CatOverloading.java`, `FinalizeTest.java`에는 모두 `Cat`이 있습니다.
> 그래서 `javac *.java`로 폴더 전체를 한 번에 컴파일하면 `duplicate class` 오류가 납니다. 위처럼 `java 파일이름.java`로 **한 파일씩** 실행하세요.

> 💡 **실행할 때마다 결과가 다른 파일**
> DateTime 예제와 실습(`InstantTest`, `LocalDateTimeTest`, `NowInfo`, `LastDayOfMonth` 등)은 현재 날짜와 시각을 쓰므로 실행할 때마다 결과가 다릅니다. 파일 머리말의 실행 결과는 실행 예시입니다.
> `FinalizeTest`의 "고양이가 소멸됨"은 가비지 컬렉터가 결정하므로 순서가 바뀌거나 출력되지 않을 수도 있습니다.

> ⚠ **JDK 버전에 따른 차이**
> - `this(...)` 앞에 문장 쓰기: JDK 25부터 허용됩니다(JEP 513). JDK 21 이하에서는 컴파일 오류입니다. 시험은 교재 기준인 "**`this()`는 생성자의 첫 문장**"으로 답합니다.
> - `finalize()`: JDK 18부터 삭제 예정(for removal)이라 컴파일 경고가 나옵니다. `FinalizeTest.java`는 `@SuppressWarnings("removal")`로 경고를 숨겼습니다.

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다. 단, 보조 클래스 이름이 겹치는 파일은 같은 프로젝트(패키지)에 함께 넣지 말고 하나씩 넣어서 실행합니다.
실습·과제는 원래 이클립스에서 `Main.java` 등으로 작성했던 코드입니다. 여기서는 문제 내용에 맞게 클래스 이름을 바꿨습니다.
