# Week 07: 클래스

자바프로그래밍(GA1001) 7주차 정리입니다.
교재는 『자바만 잡아도』입니다.

- 강의 자료(.pptx)는 Markdown으로 정리했습니다. 강의 자료 파일 이름은 `8-1 ~ 8-6`(교재 8장)이지만 수업은 7주차입니다.
- 실습, 퀴즈, 과제는 `.java` 코드로 정리했습니다.
- 수업 중 필기와 AI에게 받은 설명은 **📝 필기** 표시로 주석과 노트에 넣었습니다.
- 💡 표시는 정리하면서 덧붙인 설명입니다. 직접 풀지 않은 문제는 💡 참고 답안으로 채웠습니다.
- ⚠ 표시는 원본 자료의 오타나 버그, 내 답안의 틀린 부분, AI가 알려 준 코드의 문제점을 바로잡은 곳입니다. 바로잡은 코드는 ❌ 원본 / ✅ 수정으로 나란히 두었습니다.

## 📁 구조

```
week07-classes/
├── lecture-notes/          강의 자료 (.pptx → .md)
├── examples/               강의 슬라이드 속 예제 코드
├── practice/               실습
│   ├── classes1/           ├ 클래스(1)
│   └── classes2/           └ 클래스(2)
├── quiz/                   퀴즈
└── assignment/             과제
    ├── classes1/           ├ 클래스(1)
    └── classes2/           └ 클래스(2)
```

## 📖 강의 노트

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 8-1 | [클래스 정의 · 필드 · 메소드](lecture-notes/8-1_클래스정의_필드_메소드.md) | 클래스와 객체, `new`와 레퍼런스, 필드 선언(객체마다 따로 존재), 레퍼런스 타입 필드, 메소드 정의와 호출, [실습] 학생 성적 클래스 |
| 8-2 | [this · 정적 필드 · 정적 메소드](lecture-notes/8-2_this_정적필드_정적메소드.md) | `this`(현재 객체의 레퍼런스), 정적 필드(클래스당 하나, 객체끼리 공유), 정적 메소드(객체 없이 `클래스명.메소드()`), `static final` 상수, [실습] 수학 라이브러리 |
| 8-3 | [필드 접근자 · 유효 범위 · 오버로딩](lecture-notes/8-3_필드접근자_유효범위_오버로딩.md) | `public` · `private` · default, getter / setter와 캡슐화, 변수의 유효 범위(필드 · 지역 변수 · 블록), 메소드 중복정의(오버로딩), [실습] 사각형 · 정수 클래스 |
| 8-4 | [메소드 인수 전달 · 명령행 인수](lecture-notes/8-4_메소드인수전달_명령행인수.md) | 값에 의한 전달(기본 자료형) vs 레퍼런스 전달(배열 · 객체), swap 예제, 배열 인수, `String[] args`와 명령행 인수 |
| 8-5 | [내부 클래스](lecture-notes/8-5_내부클래스.md) | 내부 클래스, `외부객체.new 내부클래스()`, 메소드 내부 클래스, [실습] 내부 클래스 vs 일반 클래스 비교 |
| 8-6 | [패키지](lecture-notes/8-6_패키지.md) | 패키지와 폴더 구조, 이클립스에서 패키지 만들기, 콘솔에서 `javac -d .`로 컴파일하고 `java 패키지.클래스`로 실행 (⚠ `wrong name` 오류) |

## 💻 코드

### 강의 예제 (`examples/`)

| 파일 | 차시 | 내용 |
|---|---|---|
| [FieldDeclaration.java](examples/FieldDeclaration.java) | 8-1 | 필드 선언: 객체마다 필드가 따로 있음, 레퍼런스 타입 필드(MyPoint). ⚠ 스마트 따옴표 수정 |
| [StudentScore.java](examples/StudentScore.java) | 8-1 | [실습] 학생 성적 클래스 정의하기 (과목별 · 전체 평균) |
| [MyIntegerThis.java](examples/MyIntegerThis.java) | 8-2 | `this` 키워드. ⚠ 슬라이드의 en dash(`–`)와 `Int` 오타 수정 |
| [StaticFieldTest.java](examples/StaticFieldTest.java) | 8-2 | 정적 필드: 객체끼리 값을 공유, `클래스명.필드`로 접근 |
| [StudentScoreStatic.java](examples/StudentScoreStatic.java) | 8-2 | [실습] 학생 성적 예제를 `this`와 정적 변수(학생 수)로 재구현 |
| [MyMathDemo.java](examples/MyMathDemo.java) | 8-2 | [실습] 정적 메소드로 수학 라이브러리 작성 (원주, 원 면적, 마일 ↔ 킬로미터) |
| [StudentScorePrivate.java](examples/StudentScorePrivate.java) | 8-3 | [실습] 접근자에 따른 변수 접근성 확인 (`private` 필드 + getter) |
| [MyRectangleTest.java](examples/MyRectangleTest.java) | 8-3 | [실습] 사각형 클래스 (`private` 필드 + getter / setter) |
| [VariableScopeTest.java](examples/VariableScopeTest.java) | 8-3 | [실습] 변수의 유효 범위. 슬라이드의 오류 줄은 ❌ 주석으로 표시 |
| [MyIntegerTest.java](examples/MyIntegerTest.java) | 8-3 | [실습] 메소드 중복정의(오버로딩). ⚠ `I` → `i` 수정 |
| [SwapTest.java](examples/SwapTest.java) | 8-4 | 기본 자료형 swap(실패) vs 배열 swap(성공). ⚠ `static` 누락 수정 |
| [ModifyArrayTest.java](examples/ModifyArrayTest.java) | 8-4 | 배열을 인수로 받아 메소드 안에서 바꾸기 |
| [ArrayArgument.java](examples/ArrayArgument.java) | 8-4 | [실습] 배열 데이터를 메소드에서 변경하기 (난수 배열 1씩 증가) |
| [CommandLineTest.java](examples/CommandLineTest.java) | 8-4 | 명령행 인수 `args`. 💡 인수 개수 검사 추가 |
| [InnerTest.java](examples/InnerTest.java) | 8-5 | 내부 클래스, 다른 클래스에서 내부 클래스 객체 만들기 (`private` → `public`) |
| [MethodLocalInnerTest.java](examples/MethodLocalInnerTest.java) | 8-5 | 메소드 내부 클래스. ⚠ 메소드 안의 `private class` 컴파일 오류 수정 |
| [MyRectangleInnerPoint.java](examples/MyRectangleInnerPoint.java) | 8-5 | [실습] MyPoint를 **내부 클래스**로 (📝 내부 vs 일반 클래스 비교표) |
| [MyRectangleOuterPoint.java](examples/MyRectangleOuterPoint.java) | 8-5 | [실습] MyPoint를 **일반 클래스**로 (getter / setter를 거쳐야 함) |

8-6(패키지)은 콘솔과 이클립스에서 직접 해 보는 실습이라 예제 파일 대신 [강의 노트](lecture-notes/8-6_패키지.md)에 과정을 정리했습니다.

### 실습 (`practice/`)

| 파일 | 문제 |
|---|---|
| [classes1/BookDirectAccess.java](practice/classes1/BookDirectAccess.java) | 1-❶. Book 클래스: 필드에 직접 접근 |
| [classes1/BookGetterSetter.java](practice/classes1/BookGetterSetter.java) | 1-❷. Book 클래스: `private` 필드 + getter / setter (📝 `this` 설명) |
| [classes1/EmployeeSalary.java](practice/classes1/EmployeeSalary.java) | 2. Employee 클래스: setter에서 연봉 범위 검사 |
| [classes1/ComplexTest.java](practice/classes1/ComplexTest.java) | 3. 복소수 덧셈 · 뺄셈 (📝 `private`은 클래스 기준이라 다른 객체의 필드에도 직접 접근 가능) |
| [classes1/DynamicArrayTest.java](practice/classes1/DynamicArrayTest.java) | 4. 동적 배열 (📝 논리적 삭제 vs 물리적 삭제, 교수님의 나눗셈 최적화 팁. ⚠ `new MyArray()` 수정) |
| [classes2/CircleTest.java](practice/classes2/CircleTest.java) | 1-❶. Circle + Point 포함 관계 (📝 `resize(double)`로 변경, 메서드 체이닝) |
| [classes2/CircleInnerPointTest.java](practice/classes2/CircleInnerPointTest.java) | 1-❷. Point를 Circle의 내부 클래스로 (`c1.new Point()`) |
| [classes2/MatrixTest.java](practice/classes2/MatrixTest.java) | 2. 💡 3x3 행렬의 합 · 차 · 전치 · 곱 (참고 답안) |
| [classes2/TheaterTest.java](practice/classes2/TheaterTest.java) | 3. 영화관 좌석 예약: 실행 클래스 + 좌석 관리 클래스 (📝 AI 개념 정리 1~5: 클래스와 객체, 필드와 메서드, `private`, `static`, 생성자) |
| [classes2/TheaterSeatsSystem.java](practice/classes2/TheaterSeatsSystem.java) | 4. 영화관 좌석 예약: 하나의 클래스로 통합 (📝 AI 개념 정리 6~10: 2차원 배열, `this`, 단축 평가, do-while · switch, 3번 vs 4번 설계 비교, ★ 시험 포인트) |

### 퀴즈 (`quiz/`)

| 파일 | 내용 |
|---|---|
| [ClassQuiz.java](quiz/ClassQuiz.java) | 클래스 1~9번: 클래스와 객체, getter / setter를 쓰는 이유, Audio 클래스 오류 찾기(⚠ main이 클래스 안에 있어 `bose.volume`은 오류 아님), Point 캡슐화와 PointTest 분리, static 필드 · 메서드, ★ 7번 static 필드 출력 결과(기말고사 출제 유력), 8번 static 메서드 오류 고치기, 9번 내부 클래스로 바꾸기 |

### 과제 (`assignment/`)

| 파일 | 문제 |
|---|---|
| [classes1/EmployeeTest.java](assignment/classes1/EmployeeTest.java) | 1. Employee: `private` 필드 + getter / setter |
| [classes1/BankAccountTest.java](assignment/classes1/BankAccountTest.java) | 2. UML을 보고 BankAccount 작성 (입금 · 출금). ⚠ 문제의 스마트 따옴표 수정 |
| [classes1/TelevisionTest.java](assignment/classes1/TelevisionTest.java) | 3. Television: 전원 · 채널 · 볼륨, `toString` (📝 `@Override`를 붙이는 이유) |
| [classes1/StopwatchTest.java](assignment/classes1/StopwatchTest.java) | 4. Stopwatch: `Instant` · `Duration`, `getElapsedTime` 오버로딩 |
| [classes2/DiceTest.java](assignment/classes2/DiceTest.java) | 1. 주사위 굴리기 (📝 `Math.random()`으로 1~6 만들기) |
| [classes2/CellPhoneTest.java](assignment/classes2/CellPhoneTest.java) | 2. CellPhone: boolean 필드와 `is~` getter (📝 핵심 개념 표) |
| [classes2/TriangleTest.java](assignment/classes2/TriangleTest.java) | 3. 삼각형의 넓이 (📝 int vs double, 💡 정수 나눗셈) |
| [classes2/RectangleTest.java](assignment/classes2/RectangleTest.java) | 4. 사각형 면적 비교와 겹치는 영역 `intersect` (📝 포함 관계, `Math.max` / `Math.min`. 💡 겹치는 예시 추가) |

## ▶ 실행 방법

모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java examples/SwapTest.java
java practice/classes2/TheaterTest.java
java quiz/ClassQuiz.java
java assignment/classes2/RectangleTest.java
```

Windows 콘솔에서 한글이 깨지면 다음과 같이 인코딩을 지정합니다.

```bash
java -Dstdout.encoding=UTF-8 -Dstdin.encoding=UTF-8 -Dfile.encoding=UTF-8 practice/classes2/TheaterTest.java
```

명령행 인수 예제는 파일 이름 뒤에 인수를 적습니다.

```bash
java examples/CommandLineTest.java aaa bbb
```

> ⚠ **파일마다 독립된 프로그램입니다.**
> 각 파일에는 `public class` 하나와 그 파일에서 쓰는 보조 클래스(`Point`, `Circle`, `Book`, `MyRectangle`, `MyInteger` 등)가 함께 들어 있습니다. 같은 폴더의 여러 파일에 이름이 같은 보조 클래스가 있습니다. 예를 들어 `CircleTest.java`와 `CircleInnerPointTest.java`에는 둘 다 `Circle`이 있습니다.
> 그래서 `javac *.java`로 폴더 전체를 한 번에 컴파일하면 `duplicate class` 오류가 납니다. 위처럼 `java 파일이름.java`로 **한 파일씩** 실행하세요.

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다. 단, 보조 클래스 이름이 겹치는 파일은 같은 프로젝트(패키지)에 함께 넣지 말고 하나씩 넣어서 실행합니다.
실습·과제는 원래 이클립스에서 `Main.java` 등으로 작성했던 코드입니다. 여기서는 문제 내용에 맞게 클래스 이름을 바꿨습니다.
