# Week 02: 자바 기초 (변수와 자료형 · 수식)

자바프로그래밍(GA1001) 2주차 정리입니다.
교재는 『자바만 잡아도』입니다.

- 강의 자료(.pptx)는 Markdown으로 정리했습니다.
- 실습, 퀴즈, 과제는 `.java` 코드로 정리했습니다.
- 수업 중 필기는 **📝 필기** 표시로 주석과 노트에 넣었습니다.
- 💡 표시는 과제를 풀면서 덧붙인 설명입니다.
- ⚠ 표시는 원본 자료의 오타나 컴파일 오류를 바로잡은 부분입니다.

## 📁 구조

```
week02-basics/
├── lecture-notes/          강의 자료 (.pptx → .md)
├── examples/               강의 슬라이드 속 예제 코드
├── practice/               실습
│   ├── variables/          ├ 변수와 자료형
│   └── expressions/        └ 수식
├── quiz/                   퀴즈
└── assignment/             과제
    ├── variables/          ├ 변수와 자료형
    └── expressions/        └ 수식
```

## 📖 강의 노트

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 2-1 | [프로그램 구성 · 콘솔 입출력 · import](lecture-notes/2-1_프로그램구성_콘솔입출력_import.md) | main 메소드, `System.out`/`System.in`, Scanner, import, Python import와의 차이 |
| 2-2 | [변수와 자료형](lecture-notes/2-2_변수와자료형.md) | 변수 선언, 기본 자료형 8가지, 참조 자료형, 식별자 규칙, 예약어 |
| 2-3 | [리터럴 · 기호 상수 · 대입문](lecture-notes/2-3_리터럴_기호상수_대입문.md) | 정수/실수/문자 리터럴, 이스케이프 시퀀스, `final`, 대입 연산자 |
| 2-4 | [대입문 실습 · 형변환 · 사용자 정의 자료형](lecture-notes/2-4_대입문실습_형변환_사용자정의자료형.md) | SayHello 실습, 자동/강제 형변환, 클래스와 `new` |
| 2-5 | [수식 · 산술 연산자](lecture-notes/2-5_수식_산술연산자.md) | 연산자 우선순위와 결합 법칙, 정수 나눗셈 주의, 오버플로우 |
| 2-6 | [비트 · 관계 연산자](lecture-notes/2-6_비트연산자_관계연산자.md) | `& \| ^ ~`, 시프트 `>> >>> <<`, 관계 연산자 |
| 2-7 | [논리 · 축약 대입 · 조건 연산자](lecture-notes/2-7_논리_축약대입_조건연산자.md) | `&& \|\| ^ !`, `+=` 등, 증감 연산자, `?:` |

## 💻 코드

### 강의 예제 (`examples/`)

| 파일 | 차시 | 내용 |
|---|---|---|
| [ProgramBasic.java](examples/ProgramBasic.java) | 2-1 | main 메소드와 명령행 인수 |
| [VariablesTest.java](examples/VariablesTest.java) | 2-2 | 기본 자료형 8가지, String 생성 |
| [SayHello.java](examples/SayHello.java) | 2-4 | 이름을 입력받아 인사말 출력 |
| [Assignment.java](examples/Assignment.java) | 2-4 | char ↔ int 형변환 |
| [IntegerToTime.java](examples/IntegerToTime.java) | 2-5 | 초 → 시·분·초 |
| [SumNAvg.java](examples/SumNAvg.java) | 2-5 | 성적 3개의 합계와 평균 |
| [Overflow.java](examples/Overflow.java) | 2-5 | 오버플로우와 언더플로우 |
| [BitOperation.java](examples/BitOperation.java) | 2-6 | 비트 논리 연산 |
| [ShiftOperation.java](examples/ShiftOperation.java) | 2-6 | 시프트 연산 |
| [RelationOperation.java](examples/RelationOperation.java) | 2-6 | 관계 연산 |
| [LogicOperation.java](examples/LogicOperation.java) | 2-7 | 논리 연산 |
| [IncDecOperation.java](examples/IncDecOperation.java) | 2-7 | 증감 연산 |
| [ConditionOperation.java](examples/ConditionOperation.java) | 2-7 | 조건 연산 (절대값, 최대값) |

### 실습 (`practice/`)

| 파일 | 문제 |
|---|---|
| [variables/Literal.java](practice/variables/Literal.java) | 리터럴, 지역 변수 초기화, Scanner. 필기가 가장 많은 파일 |
| [variables/PersonInfo.java](practice/variables/PersonInfo.java) | 이름, 나이, 키, 몸무게 입력 및 출력 (`printf` 필기) |
| [expressions/BoxVolume.java](practice/expressions/BoxVolume.java) | 1. 상자의 체적 |
| [expressions/PyungToSquareMeter.java](practice/expressions/PyungToSquareMeter.java) | 2. 평 → ㎡ (기호 상수) |
| [expressions/TimeToSeconds.java](practice/expressions/TimeToSeconds.java) | 3. 시·분·초 → 초 |
| [expressions/Savings.java](practice/expressions/Savings.java) | 4. 2년 후 예금액 (복리) |
| [expressions/QuadraticEquation.java](practice/expressions/QuadraticEquation.java) | 5. 2차 방정식의 근 |

### 퀴즈 (`quiz/`)

| 파일 | 내용 |
|---|---|
| [VariableQuiz.java](quiz/VariableQuiz.java) | 변수와 자료형 1~6번: 자료형 선택, 식별자, 지수 표기, 선언문, 오류 찾기, 이스케이프 |
| [ExpressionQuiz.java](quiz/ExpressionQuiz.java) | 수식 1~5번: 연산 결과, 논리식 해석, 계산 순서, 조건식 작성 (우선순위 참고표 포함) |

### 과제 (`assignment/`)

| 파일 | 문제 |
|---|---|
| [variables/Test1.java](assignment/variables/Test1.java) | 1. 오류 7개 찾아 고치기 |
| [variables/StudentInfo.java](assignment/variables/StudentInfo.java) | 2. 학생 정보 입력 및 출력 |
| [expressions/Polynomial.java](assignment/expressions/Polynomial.java) | 1. 다항식 5x³ + 6x² − 8x + 2 |
| [expressions/AverageScore.java](assignment/expressions/AverageScore.java) | 2. 4과목 평균 점수 |
| [expressions/FuelEfficiency.java](assignment/expressions/FuelEfficiency.java) | 3. 자동차 연비 |
| [expressions/Quadrant.java](assignment/expressions/Quadrant.java) | 4. 사분면 판별 (`?:`만 사용) |
| [expressions/DigitSplit.java](assignment/expressions/DigitSplit.java) | 5. 네 자리 정수의 자릿수 분리 |

## ▶ 실행 방법

모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java examples/IntegerToTime.java
java practice/expressions/QuadraticEquation.java
```

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다.
