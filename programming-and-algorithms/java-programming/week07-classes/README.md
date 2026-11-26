# Week 07: 클래스

자바프로그래밍(GA1001) 7주차 정리입니다.

- 강의 내용은 `1-lecture/`에 정리했습니다.
- 퀴즈 · 실습 · 과제는 폴더마다 `README.md`에 **문제 → 풀이 코드 → 실행 결과 → 📝 필기 · 해설** 순서로 정리했습니다. 같은 폴더의 `.java` 파일은 바로 실행해 볼 수 있는 코드입니다.

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
| 1️⃣ 강의 | 강의 노트로 개념을 익히고, 예제 코드를 직접 실행해 결과를 확인합니다. | 노트 [7-1](1-lecture/7-1_클래스정의_필드_메소드.md) · [7-2](1-lecture/7-2_this_정적필드_정적메소드.md) · [7-3](1-lecture/7-3_필드접근자_유효범위_오버로딩.md) · [7-4](1-lecture/7-4_메소드인수전달_명령행인수.md) · [7-5](1-lecture/7-5_내부클래스.md) · [7-6](1-lecture/7-6_패키지.md) · [예제 코드](1-lecture/code/README.md) |
| 2️⃣ 퀴즈 | 문제만 보고 답을 먼저 떠올린 뒤, 정답과 📝 필기로 확인합니다. | [퀴즈](2-quiz/README.md) |
| 3️⃣ 실습 | 문제를 직접 풀어 본 뒤, 풀이 코드 · 실행 결과 · 해설과 비교합니다. | [classes1](3-practice/classes1/README.md) · [classes2](3-practice/classes2/README.md) |
| 4️⃣ 과제 | 실습에서 익힌 내용을 응용합니다. ⚠ 자주 틀리는 부분을 다시 확인하세요. | [classes1](4-assignment/classes1/README.md) · [classes2](4-assignment/classes2/README.md) |

## 1️⃣ 강의 노트 (`1-lecture/`)

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 7-1 | [클래스 정의 · 필드 · 메소드](1-lecture/7-1_클래스정의_필드_메소드.md) | 클래스와 객체, `new`와 레퍼런스, 필드 선언(객체마다 따로 존재), 레퍼런스 타입 필드, 메소드 정의와 호출, [실습] 학생 성적 클래스 |
| 7-2 | [this · 정적 필드 · 정적 메소드](1-lecture/7-2_this_정적필드_정적메소드.md) | `this`(현재 객체의 레퍼런스), 정적 필드(클래스당 하나, 객체끼리 공유), 정적 메소드(객체 없이 `클래스명.메소드()`), `static final` 상수, [실습] 수학 라이브러리 |
| 7-3 | [필드 접근자 · 유효 범위 · 오버로딩](1-lecture/7-3_필드접근자_유효범위_오버로딩.md) | `public` · `private` · default, getter / setter와 캡슐화, 변수의 유효 범위(필드 · 지역 변수 · 블록), 메소드 중복정의(오버로딩), [실습] 사각형 · 정수 클래스 |
| 7-4 | [메소드 인수 전달 · 명령행 인수](1-lecture/7-4_메소드인수전달_명령행인수.md) | 값에 의한 전달(기본 자료형) vs 레퍼런스 전달(배열 · 객체), swap 예제, 배열 인수, `String[] args`와 명령행 인수 |
| 7-5 | [내부 클래스](1-lecture/7-5_내부클래스.md) | 내부 클래스, `외부객체.new 내부클래스()`, 메소드 내부 클래스, [실습] 내부 클래스 vs 일반 클래스 비교 |
| 7-6 | [패키지](1-lecture/7-6_패키지.md) | 패키지와 폴더 구조, 이클립스에서 패키지 만들기, 콘솔에서 `javac -d .`로 컴파일하고 `java 패키지.클래스`로 실행 (⚠ `wrong name` 오류) |

### 강의 예제 코드 ([`1-lecture/code/`](1-lecture/code/README.md))

| 파일 | 차시 | 내용 |
|---|---|---|
| [FieldDeclaration.java](1-lecture/code/README.md#필드-선언---객체마다-고유의-필드가-따로-존재한다) | 7-1 | 필드 선언: 객체마다 필드가 따로 있음, 레퍼런스 타입 필드(MyPoint). ⚠ 한 파일에 public class 는 하나 |
| [StudentScore.java](1-lecture/code/README.md#학생-성적-클래스-정의하기) | 7-1 | [실습] 학생 성적 클래스 정의하기 (과목별 · 전체 평균) |
| [MyIntegerThis.java](1-lecture/code/README.md#this-키워드---현재-메소드를-실행하고-있는-객체의-레퍼런스) | 7-2 | `this` 키워드. ⚠ 빼기 기호 대신 en dash(`–`)를 쓰는 실수 |
| [StaticFieldTest.java](1-lecture/code/README.md#정적-필드-static-field---같은-클래스의-객체들끼리-값을-공유) | 7-2 | 정적 필드: 객체끼리 값을 공유, `클래스명.필드`로 접근 |
| [StudentScoreStatic.java](1-lecture/code/README.md#앞-예제studentscorejava를-this-키워드와-정적-변수를-사용하여-재구현하기) | 7-2 | [실습] 학생 성적 예제를 `this`와 정적 변수(학생 수)로 재구현 |
| [MyMathDemo.java](1-lecture/code/README.md#수학-라이브러리-작성---원주와-원-면적-마일을-킬로미터로) | 7-2 | [실습] 정적 메소드로 수학 라이브러리 작성 (원주, 원 면적, 마일 ↔ 킬로미터) |
| [StudentScorePrivate.java](1-lecture/code/README.md#접근자에-따른-변수-접근성-확인하기---필드를-private-으로-getter-로-읽기) | 7-3 | [실습] 접근자에 따른 변수 접근성 확인 (`private` 필드 + getter) |
| [MyRectangleTest.java](1-lecture/code/README.md#사각형-클래스---private-필드--getter--setter) | 7-3 | [실습] 사각형 클래스 (`private` 필드 + getter / setter) |
| [VariableScopeTest.java](1-lecture/code/README.md#변수의-유효범위-테스트) | 7-3 | [실습] 변수의 유효 범위. ⚠ 범위 밖 변수를 쓰는 오류 줄은 ❌ 주석으로 표시 |
| [MyIntegerTest.java](1-lecture/code/README.md#정수-클래스의-기능-중복-정의하기---메소드-중복정의오버로딩-overloading) | 7-3 | [실습] 메소드 중복정의(오버로딩). ⚠ 대소문자(`I` ≠ `i`) |
| [SwapTest.java](1-lecture/code/README.md#메소드-인수-전달---기본-자료형-vs-배열레퍼런스) | 7-4 | 기본 자료형 swap(실패) vs 배열 swap(성공). ⚠ static main 에서 non-static 메소드 호출 |
| [ModifyArrayTest.java](1-lecture/code/README.md#배열-인수---메소드에서-배열을-인수로-받아들이는-예) | 7-4 | 배열을 인수로 받아 메소드 안에서 바꾸기 |
| [ArrayArgument.java](1-lecture/code/README.md#배열-데이터-메소드에서-변경하기) | 7-4 | [실습] 배열 데이터를 메소드에서 변경하기 (난수 배열 1씩 증가) |
| [CommandLineTest.java](1-lecture/code/README.md#명령행-인수-command-line-arguments) | 7-4 | 명령행 인수 `args`. 💡 인수 개수 검사 추가 |
| [InnerTest.java](1-lecture/code/README.md#내부-클래스-inner-class) | 7-5 | 내부 클래스, 다른 클래스에서 내부 클래스 객체 만들기 (`private` → `public`) |
| [MethodLocalInnerTest.java](1-lecture/code/README.md#메소드-내부-클래스-method-local-inner-class) | 7-5 | 메소드 내부 클래스. ⚠ 메소드 안에서는 `private class` 불가 |
| [MyRectangleInnerPoint.java](1-lecture/code/README.md#내부-클래스와-일반-클래스로-선언할-경우의-차이) | 7-5 | [실습] MyPoint를 **내부 클래스**로 (📝 내부 vs 일반 클래스 비교표) |
| [MyRectangleOuterPoint.java](1-lecture/code/README.md#내부-클래스와-일반-클래스로-선언할-경우의-차이-1) | 7-5 | [실습] MyPoint를 **일반 클래스**로 (getter / setter를 거쳐야 함) |

7-6(패키지)은 콘솔과 이클립스에서 직접 해 보는 실습이라 예제 파일 대신 [강의 노트](1-lecture/7-6_패키지.md)에 과정을 정리했습니다.

## 2️⃣ 퀴즈 ([`2-quiz/`](2-quiz/README.md))

| 파일 | 내용 |
|---|---|
| [ClassQuiz.java](2-quiz/README.md#클래스-클래스와-객체--gettersetter--static--내부-클래스) | 클래스 1~9번: 클래스와 객체, getter / setter를 쓰는 이유, Audio 클래스 오류 찾기(⚠ main이 클래스 안에 있어 `bose.volume`은 오류 아님), Point 캡슐화와 PointTest 분리, static 필드 · 메서드, ★ 7번 static 필드 출력 결과(기말고사 출제 유력), 8번 static 메서드 오류 고치기, 9번 내부 클래스로 바꾸기 |

## 3️⃣ 실습 (`3-practice/`)

| 파일 | 문제 |
|---|---|
| [classes1/BookDirectAccess.java](3-practice/classes1/README.md#1-❶-book-클래스-필드에-직접-접근) | 1-❶. Book 클래스: 필드에 직접 접근 |
| [classes1/BookGetterSetter.java](3-practice/classes1/README.md#1-❷-book-클래스-private-필드--getter--setter) | 1-❷. Book 클래스: `private` 필드 + getter / setter (📝 `this` 설명) |
| [classes1/EmployeeSalary.java](3-practice/classes1/README.md#2-employee-클래스-setter에서-연봉-범위-검사) | 2. Employee 클래스: setter에서 연봉 범위 검사 |
| [classes1/ComplexTest.java](3-practice/classes1/README.md#3-복소수-덧셈--뺄셈) | 3. 복소수 덧셈 · 뺄셈 (📝 `private`은 클래스 기준이라 다른 객체의 필드에도 직접 접근 가능) |
| [classes1/DynamicArrayTest.java](3-practice/classes1/README.md#4-동적-배열) | 4. 동적 배열 (📝 논리적 삭제 vs 물리적 삭제, 교수님의 나눗셈 최적화 팁) |
| [classes2/CircleTest.java](3-practice/classes2/README.md#1-❶-circle--point-포함-관계-resizedouble로-변경-메서드-체이닝) | 1-❶. Circle + Point 포함 관계 (📝 `resize(double)`로 변경, 메서드 체이닝) |
| [classes2/CircleInnerPointTest.java](3-practice/classes2/README.md#1-❷-point를-circle의-내부-클래스로-c1new-point) | 1-❷. Point를 Circle의 내부 클래스로 (`c1.new Point()`) |
| [classes2/MatrixTest.java](3-practice/classes2/README.md#2-3x3-행렬의-합--차--전치--곱-참고-답안) | 2. 💡 3x3 행렬의 합 · 차 · 전치 · 곱 (참고 답안) |
| [classes2/TheaterTest.java](3-practice/classes2/README.md#3-영화관-좌석-예약-실행-클래스--좌석-관리-클래스) | 3. 영화관 좌석 예약: 실행 클래스 + 좌석 관리 클래스 (📝 개념 정리 1~5: 클래스와 객체, 필드와 메서드, `private`, `static`, 생성자) |
| [classes2/TheaterSeatsSystem.java](3-practice/classes2/README.md#4-영화관-좌석-예약-하나의-클래스로-통합) | 4. 영화관 좌석 예약: 하나의 클래스로 통합 (📝 개념 정리 6~10: 2차원 배열, `this`, 단축 평가, do-while · switch, 3번 vs 4번 설계 비교, ★ 시험 포인트) |

## 4️⃣ 과제 (`4-assignment/`)

| 파일 | 문제 |
|---|---|
| [classes1/EmployeeTest.java](4-assignment/classes1/README.md#1-employee-private-필드--getter--setter) | 1. Employee: `private` 필드 + getter / setter |
| [classes1/BankAccountTest.java](4-assignment/classes1/README.md#2-uml을-보고-bankaccount-작성-입금--출금) | 2. UML을 보고 BankAccount 작성 (입금 · 출금) |
| [classes1/TelevisionTest.java](4-assignment/classes1/README.md#3-television-전원--채널--볼륨-tostring) | 3. Television: 전원 · 채널 · 볼륨, `toString` (📝 `@Override`를 붙이는 이유) |
| [classes1/StopwatchTest.java](4-assignment/classes1/README.md#4-stopwatch-instant--duration-getelapsedtime-오버로딩) | 4. Stopwatch: `Instant` · `Duration`, `getElapsedTime` 오버로딩 |
| [classes2/DiceTest.java](4-assignment/classes2/README.md#1-주사위-굴리기-mathrandom으로-16-만들기) | 1. 주사위 굴리기 (📝 `Math.random()`으로 1~6 만들기) |
| [classes2/CellPhoneTest.java](4-assignment/classes2/README.md#2-cellphone-boolean-필드와-is-getter) | 2. CellPhone: boolean 필드와 `is~` getter (📝 핵심 개념 표) |
| [classes2/TriangleTest.java](4-assignment/classes2/README.md#3-삼각형의-넓이) | 3. 삼각형의 넓이 (📝 int vs double, 💡 정수 나눗셈) |
| [classes2/RectangleTest.java](4-assignment/classes2/README.md#4-사각형-면적-비교와-겹치는-영역-intersect) | 4. 사각형 면적 비교와 겹치는 영역 `intersect` (📝 포함 관계, `Math.max` / `Math.min`. 💡 겹치는 예시 추가) |

## 📁 구조

```
week07-classes/
├── README.md              학습 가이드 (이 문서)
├── 1-lecture/             1️⃣ 강의 노트
│   └── code/              　  강의 예제 코드 (README + .java)
├── 2-quiz/                2️⃣ 퀴즈 (README + .java)
├──  3-practice/          3️⃣ 실습
│   ├── classes1/         클래스(1)
│   └── classes2/         클래스(2)
└──  4-assignment/        4️⃣ 과제
    ├── classes1/         클래스(1)
    └── classes2/         클래스(2)
```

## ▶ 실행 방법

모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java 1-lecture/code/SwapTest.java
java 3-practice/classes2/TheaterTest.java
java 2-quiz/ClassQuiz.java
java 4-assignment/classes2/RectangleTest.java
```

Windows 콘솔에서 한글이 깨지면 다음과 같이 인코딩을 지정합니다.

```bash
java -Dstdout.encoding=UTF-8 -Dstdin.encoding=UTF-8 -Dfile.encoding=UTF-8 3-practice/classes2/TheaterTest.java
```

명령행 인수 예제는 파일 이름 뒤에 인수를 적습니다.

```bash
java 1-lecture/code/CommandLineTest.java aaa bbb
```

> ⚠ **파일마다 독립된 프로그램입니다.**
> 각 파일에는 `public class` 하나와 그 파일에서 쓰는 보조 클래스(`Point`, `Circle`, `Book`, `MyRectangle`, `MyInteger` 등)가 함께 들어 있습니다. IntelliJ 모듈(`examples`+`quiz`, `practice`, `assignment`) 안에서는 보조 클래스 이름이 겹치지 않도록 바꿔 두었기 때문에 모듈 단위로 빌드해도 오류가 나지 않습니다. 이름을 바꾼 파일은 머리말에 강의 코드의 원래 이름을 적어 두었습니다.
> 단, `3-practice/`와 `4-assignment/`처럼 **서로 다른 모듈**에는 같은 이름의 보조 클래스가 있을 수 있습니다. 주차 폴더 전체를 `javac`로 한 번에 컴파일하면 `duplicate class` 오류가 날 수 있으니, 위처럼 `java 파일이름.java`로 **한 파일씩** 실행하세요.

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다. 단, 서로 다른 폴더(예: 실습과 과제)의 파일은 보조 클래스 이름이 겹칠 수 있으니 같은 프로젝트(패키지)에 함께 넣지 말고 하나씩 넣어서 실행합니다.
실습·과제는 원래 이클립스에서 `Main.java` 등으로 작성했던 코드입니다. 여기서는 문제 내용에 맞게 클래스 이름을 바꿨습니다.
