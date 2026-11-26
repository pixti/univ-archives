# Week 02: 자바 기초 (변수와 자료형 · 수식)

자바프로그래밍(GA1001) 2주차 정리입니다.

- 강의 내용은 `1-lecture/`에 정리했습니다.
- 퀴즈 · 실습 · 과제는 폴더마다 `README.md`에 **문제 → 풀이 코드 → 실행 결과 → 📝 필기 · 해설** 순서로 정리했습니다. 같은 폴더의 `.java` 파일은 바로 실행해 볼 수 있는 코드입니다.

| 표시 | 의미 |
|---|---|
| 📝 **필기** | 수업 중 필기한 내용, 질문하며 정리한 설명 |
| 💡 **보충** | 정리하면서 덧붙인 설명, 참고 답안 |
| ⚠ **주의** | 자주 틀리는 부분, 헷갈리기 쉬운 부분 |

## 📚 학습 순서

수업 흐름(교안 → 퀴즈 → 실습 → 과제)대로 읽도록 폴더 이름에 번호를 붙였습니다.

| 단계 | 이렇게 공부하세요 | 바로가기 |
|---|---|---|
| 1️⃣ 강의 | 강의 노트로 개념을 익히고, 예제 코드를 직접 실행해 결과를 확인합니다. | 노트 [2-1](1-lecture/2-1_프로그램구성_콘솔입출력_import.md) · [2-2](1-lecture/2-2_변수와자료형.md) · [2-3](1-lecture/2-3_리터럴_기호상수_대입문.md) · [2-4](1-lecture/2-4_대입문실습_형변환_사용자정의자료형.md) · [2-5](1-lecture/2-5_수식_산술연산자.md) · [2-6](1-lecture/2-6_비트연산자_관계연산자.md) · [2-7](1-lecture/2-7_논리_축약대입_조건연산자.md) · [예제 코드](1-lecture/code/README.md) |
| 2️⃣ 퀴즈 | 문제만 보고 답을 먼저 떠올린 뒤, 정답과 📝 필기로 확인합니다. | [퀴즈](2-quiz/README.md) |
| 3️⃣ 실습 | 문제를 직접 풀어 본 뒤, 풀이 코드 · 실행 결과 · 해설과 비교합니다. | [expressions](3-practice/expressions/README.md) · [variables](3-practice/variables/README.md) |
| 4️⃣ 과제 | 실습에서 익힌 내용을 응용합니다. ⚠ 자주 틀리는 부분을 다시 확인하세요. | [expressions](4-assignment/expressions/README.md) · [variables](4-assignment/variables/README.md) |

## 1️⃣ 강의 노트 (`1-lecture/`)

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 2-1 | [프로그램 구성 · 콘솔 입출력 · import](1-lecture/2-1_프로그램구성_콘솔입출력_import.md) | main 메소드, `System.out`/`System.in`, Scanner, import, Python import와의 차이 |
| 2-2 | [변수와 자료형](1-lecture/2-2_변수와자료형.md) | 변수 선언, 기본 자료형 8가지, 참조 자료형, 식별자 규칙, 예약어 |
| 2-3 | [리터럴 · 기호 상수 · 대입문](1-lecture/2-3_리터럴_기호상수_대입문.md) | 정수/실수/문자 리터럴, 이스케이프 시퀀스, `final`, 대입 연산자 |
| 2-4 | [대입문 실습 · 형변환 · 사용자 정의 자료형](1-lecture/2-4_대입문실습_형변환_사용자정의자료형.md) | SayHello 실습, 자동/강제 형변환, 클래스와 `new` |
| 2-5 | [수식 · 산술 연산자](1-lecture/2-5_수식_산술연산자.md) | 연산자 우선순위와 결합 법칙, 정수 나눗셈 주의, 오버플로우 |
| 2-6 | [비트 · 관계 연산자](1-lecture/2-6_비트연산자_관계연산자.md) | `& \| ^ ~`, 시프트 `>> >>> <<`, 관계 연산자 |
| 2-7 | [논리 · 축약 대입 · 조건 연산자](1-lecture/2-7_논리_축약대입_조건연산자.md) | `&& \|\| ^ !`, `+=` 등, 증감 연산자, `?:` |

### 강의 예제 코드 ([`1-lecture/code/`](1-lecture/code/README.md))

| 파일 | 차시 | 내용 |
|---|---|---|
| [ProgramBasic.java](1-lecture/code/README.md#프로그램-및-클래스-구성---메인-메소드) | 2-1 | main 메소드와 명령행 인수 |
| [VariablesTest.java](1-lecture/code/README.md#변수와-자료형---변수-저장-예제) | 2-2 | 기본 자료형 8가지, String 생성 |
| [SayHello.java](1-lecture/code/README.md#실습-사용자-이름을-입력-받아-인사말-출력하기) | 2-4 | 이름을 입력받아 인사말 출력 |
| [Assignment.java](1-lecture/code/README.md#자료형-변환---자동-형변환-예제) | 2-4 | char ↔ int 형변환 |
| [IntegerToTime.java](1-lecture/code/README.md#실습-임의의-양의-정수값을-시분초로-변환하기) | 2-5 | 초 → 시·분·초 |
| [SumNAvg.java](1-lecture/code/README.md#실습-3명의-학생의-성적을-입력-받아-총점-및-평균-구하기) | 2-5 | 성적 3개의 합계와 평균 |
| [Overflow.java](1-lecture/code/README.md#오버플로우와-언더플로우---예제) | 2-5 | 오버플로우와 언더플로우 |
| [BitOperation.java](1-lecture/code/README.md#실습-비트-연산자-실습하기) | 2-6 | 비트 논리 연산 |
| [ShiftOperation.java](1-lecture/code/README.md#실습-시프트-연산자-실습하기) | 2-6 | 시프트 연산 |
| [RelationOperation.java](1-lecture/code/README.md#실습-관계-연산자-실습하기) | 2-6 | 관계 연산 |
| [LogicOperation.java](1-lecture/code/README.md#실습-논리-연산자-실습하기) | 2-7 | 논리 연산 |
| [IncDecOperation.java](1-lecture/code/README.md#실습-증감-연산자-실습하기) | 2-7 | 증감 연산 |
| [ConditionOperation.java](1-lecture/code/README.md#실습-조건-연산자-실습하기) | 2-7 | 조건 연산 (절대값, 최대값) |

## 2️⃣ 퀴즈 ([`2-quiz/`](2-quiz/README.md))

| 파일 | 내용 |
|---|---|
| [VariableQuiz.java](2-quiz/README.md#변수와-자료형-퀴즈-1--6번) | 변수와 자료형 1~6번: 자료형 선택, 식별자, 지수 표기, 선언문, 오류 찾기, 이스케이프 |
| [ExpressionQuiz.java](2-quiz/README.md#수식-연습문제-1--5번) | 수식 1~5번: 연산 결과, 논리식 해석, 계산 순서, 조건식 작성 (우선순위 참고표 포함) |

## 3️⃣ 실습 (`3-practice/`)

| 파일 | 문제 |
|---|---|
| [variables/Literal.java](3-practice/variables/README.md#리터럴-지역-변수-초기화-scanner-필기가-가장-많은-파일) | 리터럴, 지역 변수 초기화, Scanner. 필기가 가장 많은 파일 |
| [variables/PersonInfo.java](3-practice/variables/README.md#이름-나이-키-몸무게-입력-및-출력-printf-필기) | 이름, 나이, 키, 몸무게 입력 및 출력 (`printf` 필기) |
| [expressions/BoxVolume.java](3-practice/expressions/README.md#1-상자의-체적) | 1. 상자의 체적 |
| [expressions/PyungToSquareMeter.java](3-practice/expressions/README.md#2-평---기호-상수) | 2. 평 → ㎡ (기호 상수) |
| [expressions/TimeToSeconds.java](3-practice/expressions/README.md#3-시분초--초) | 3. 시·분·초 → 초 |
| [expressions/Savings.java](3-practice/expressions/README.md#4-2년-후-예금액-복리) | 4. 2년 후 예금액 (복리) |
| [expressions/QuadraticEquation.java](3-practice/expressions/README.md#5-2차-방정식의-근) | 5. 2차 방정식의 근 |

## 4️⃣ 과제 (`4-assignment/`)

| 파일 | 문제 |
|---|---|
| [variables/Test1.java](4-assignment/variables/README.md#1-오류-7개-찾아-고치기) | 1. 오류 7개 찾아 고치기 |
| [variables/StudentInfo.java](4-assignment/variables/README.md#2-학생-정보-입력-및-출력) | 2. 학생 정보 입력 및 출력 |
| [expressions/Polynomial.java](4-assignment/expressions/README.md#1-다항식-5x³--6x²--8x--2) | 1. 다항식 5x³ + 6x² − 8x + 2 |
| [expressions/AverageScore.java](4-assignment/expressions/README.md#2-4과목-평균-점수) | 2. 4과목 평균 점수 |
| [expressions/FuelEfficiency.java](4-assignment/expressions/README.md#3-자동차-연비) | 3. 자동차 연비 |
| [expressions/Quadrant.java](4-assignment/expressions/README.md#4-사분면-판별-만-사용) | 4. 사분면 판별 (`?:`만 사용) |
| [expressions/DigitSplit.java](4-assignment/expressions/README.md#5-네-자리-정수의-자릿수-분리) | 5. 네 자리 정수의 자릿수 분리 |

## 📁 구조

```
week02-basics/
├── README.md              학습 가이드 (이 문서)
├── 1-lecture/             1️⃣ 강의 노트
│   └── code/              　  강의 예제 코드 (README + .java)
├── 2-quiz/                2️⃣ 퀴즈 (README + .java)
├──  3-practice/          3️⃣ 실습
│   ├── expressions/      수식
│   └── variables/        변수와 자료형
└──  4-assignment/        4️⃣ 과제
    ├── expressions/      수식
    └── variables/        변수와 자료형
```

## ▶ 실행 방법

모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java 1-lecture/code/IntegerToTime.java
java 3-practice/expressions/QuadraticEquation.java
```

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다.
