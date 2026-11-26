# Week 04: 반복문 (while · do-while · for)

자바프로그래밍(GA1001) 4주차 정리입니다.

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
| 1️⃣ 강의 | 강의 노트로 개념을 익히고, 예제 코드를 직접 실행해 결과를 확인합니다. | 노트 [4-1](1-lecture/4-1_while문.md) · [4-2](1-lecture/4-2_do-while문.md) · [4-3](1-lecture/4-3_for문.md) · [4-4](1-lecture/4-4_break_continue_이중for_foreach.md) · [예제 코드](1-lecture/code/README.md) |
| 2️⃣ 퀴즈 | 문제만 보고 답을 먼저 떠올린 뒤, 정답과 📝 필기로 확인합니다. | [퀴즈](2-quiz/README.md) |
| 3️⃣ 실습 | 문제를 직접 풀어 본 뒤, 풀이 코드 · 실행 결과 · 해설과 비교합니다. | [iteration1](3-practice/iteration1/README.md) · [iteration2](3-practice/iteration2/README.md) |
| 4️⃣ 과제 | 실습에서 익힌 내용을 응용합니다. ⚠ 자주 틀리는 부분을 다시 확인하세요. | [iteration1](4-assignment/iteration1/README.md) · [iteration2](4-assignment/iteration2/README.md) |

## 1️⃣ 강의 노트 (`1-lecture/`)

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 4-1 | [while 문](1-lecture/4-1_while문.md) | while, 합·곱 누적(0과 1로 초기화), 특정 구구단, 반복 횟수가 정해지지 않은 경우, 성적 처리, 메뉴 반복, 숫자 맞히기 |
| 4-2 | [do-while 문](1-lecture/4-2_do-while문.md) | do-while(최소 1번 실행), 반복 여부 묻기, 메뉴 반복, 숫자 맞히기 게임 반복 |
| 4-3 | [for 문](1-lecture/4-3_for문.md) | for, 파이썬 for → 자바 for, 반복 변수의 범위, 증감식의 여러 형태, 무한 반복, 팩토리얼, 3의 배수의 합 |
| 4-4 | [break · continue · 이중 for · foreach](1-lecture/4-4_break_continue_이중for_foreach.md) | break, 소수 판별, continue, 이중 for(별 찍기·구구단), n보다 작은 소수, foreach, 학생 성적 처리 |

### 강의 예제 코드 ([`1-lecture/code/`](1-lecture/code/README.md))

| 파일 | 차시 | 내용 |
|---|---|---|
| [WhileTable.java](1-lecture/code/README.md#while-문---1--10--100-표-출력) | 4-1 | 1 / 10 / 100 표 출력 |
| [WhileSum.java](1-lecture/code/README.md#while-문---1--5까지의-합) | 4-1 | 1 ~ 5까지의 합 |
| [WhileProduct.java](1-lecture/code/README.md#while-문---1--5까지의-곱) | 4-1 | 1 ~ 5까지의 곱 |
| [MultiplicationTableWhile.java](1-lecture/code/README.md#실습-특정-구구단-출력하기-while-버전) | 4-1 | 특정 구구단 출력 (while) |
| [ContinueQuestion.java](1-lecture/code/README.md#반복-횟수가-정해지지-않은-경우---계속-하시겠습니까) | 4-1 · 4-2 | "계속 하시겠습니까?" (반복 횟수가 정해지지 않은 경우) |
| [ScoreProcessing.java](1-lecture/code/README.md#실습-성적-처리) | 4-1 | 성적 처리 |
| [MenuCalculatorWhile.java](1-lecture/code/README.md#실습-메뉴-반복-처리하기---조건문-실습에서-반복처리-추가-while-버전) | 4-1 | 메뉴 반복 처리 (while) |
| [NumberGuessing.java](1-lecture/code/README.md#실습-숫자-맞히기-게임) | 4-1 | 숫자 맞히기 게임 |
| [MenuCalculatorDoWhile.java](1-lecture/code/README.md#실습-메뉴-반복-처리하기-do-while-버전) | 4-2 | 메뉴 반복 처리 (do-while) |
| [NumberGuessingRepeat.java](1-lecture/code/README.md#실습-숫자-맞히기-게임-반복하기) | 4-2 | 숫자 맞히기 게임 반복 |
| [ForSum.java](1-lecture/code/README.md#for-문---파이썬-for-문을-자바-for-문으로--증감식의-여러-형태) | 4-3 | 파이썬 for → 자바 for, 증감식의 여러 형태 |
| [ForScope.java](1-lecture/code/README.md#for-문---반복-변수의-범위--무한-반복) | 4-3 | 반복 변수의 범위, 무한 반복 |
| [MultiplicationTableFor.java](1-lecture/code/README.md#실습-특정-구구단-출력하기-for-버전) | 4-3 | 특정 구구단 출력 (for) |
| [Factorial.java](1-lecture/code/README.md#실습-팩토리얼-구하기) | 4-3 | 팩토리얼 |
| [MultipleSum.java](1-lecture/code/README.md#실습-1에서-n까지-3의-배수의-합-구하기) | 4-3 | 1에서 n까지 3의 배수의 합 |
| [MenuCalculatorFor.java](1-lecture/code/README.md#실습-메뉴-반복-처리하기-for-버전) | 4-3 | 메뉴 반복 처리 (for) |
| [BreakExample.java](1-lecture/code/README.md#break-문) | 4-4 | break |
| [PrimeCheck.java](1-lecture/code/README.md#실습-소수-판별하기-break) | 4-4 | 소수 판별 (break) |
| [ContinueOddSum.java](1-lecture/code/README.md#continue-문---1--100-홀수의-합) | 4-4 | continue로 1 ~ 100 홀수의 합 |
| [StarPattern.java](1-lecture/code/README.md#이중-for-문---별-찍기-사각형-삼각형) | 4-4 | 이중 for로 별 찍기 (사각형, 삼각형) |
| [MultiplicationTableAll.java](1-lecture/code/README.md#실습-구구단-전체-출력하기-이중-for-문) | 4-4 | 구구단 전체 출력 (이중 for) |
| [PrimesBelowN.java](1-lecture/code/README.md#실습-n보다-작은-소수-찾기-이중-for-문--break) | 4-4 | n보다 작은 소수 (이중 for + break) |
| [ForEach.java](1-lecture/code/README.md#foreach-문--실습-학생-성적-처리하기) | 4-4 | foreach, 학생 성적 처리 |

## 2️⃣ 퀴즈 ([`2-quiz/`](2-quiz/README.md))

| 파일 | 내용 |
|---|---|
| [IterationQuiz.java](2-quiz/README.md#반복문) | 반복문 1~3번: 출력 결과 예측, while → for 변환(표현력이 같다), Σ·Π 계산, 변수 선언 위치(범위) |

## 3️⃣ 실습 (`3-practice/`)

| 파일 | 문제 |
|---|---|
| [iteration1/ArithmeticMean.java](3-practice/iteration1/README.md#1-음수가-입력될-때까지-산술-평균-while-0으로-나누기-방지) | 1. 음수가 입력될 때까지 산술 평균 (while, 0으로 나누기 방지) |
| [iteration1/FuelEfficiency.java](3-practice/iteration1/README.md#2-연비-계산-반복-do-while이-어울리는-이유) | 2. 연비 계산 반복 (do-while이 어울리는 이유) |
| [iteration1/Permutation.java](3-practice/iteration1/README.md#3-순열-npr-while) | 3. 순열 nPr (while) |
| [iteration1/Pyramid.java](3-practice/iteration1/README.md#4-피라미드-출력-중첩-while-안쪽-변수-초기화) | 4. 피라미드 출력 (중첩 while, 안쪽 변수 초기화) |
| [iteration2/ArithmeticMeanFor.java](3-practice/iteration2/README.md#1-산술-평균-for-초기식에-선언과-식을-섞은-컴파일-오류-분석) | 1. 산술 평균 (for). 초기식에 선언과 식을 섞은 컴파일 오류 분석 |
| [iteration2/FuelEfficiencyFor.java](3-practice/iteration2/README.md#2-연비-계산-반복-for---조건--) | 2. 연비 계산 반복 (`for ( ; 조건 ; )`) |
| [iteration2/PermutationFor.java](3-practice/iteration2/README.md#3-순열-npr-for) | 3. 순열 nPr (for) |
| [iteration2/PyramidFor.java](3-practice/iteration2/README.md#4-피라미드-출력-for--필기한-쌍둥이-피라미드) | 4. 피라미드 출력 (for) + 필기한 쌍둥이 피라미드 |

## 4️⃣ 과제 (`4-assignment/`)

각 문제마다 직접 작성한 코드와, 그 코드를 리팩터링한 버전(`...Refactored.java`)이 있습니다.
리팩터링 버전에서 과제 조건과 다른 부분, 쓰이지 않는 상수, 실제 동작과 다른 주석은 ⚠로 표시했습니다.

| 파일 | 문제 |
|---|---|
| [iteration1/MultiplesOfThree.java](4-assignment/iteration1/README.md#반복문1---1번-문제) · [Refactored](4-assignment/iteration1/README.md#반복문1---1번-문제-리팩터링-버전) | 1. 0 ~ 입력값 사이의 3의 배수 (while, 입력 검증) |
| [iteration1/PythagoreanTriple.java](4-assignment/iteration1/README.md#반복문1---2번-문제) · [Refactored](4-assignment/iteration1/README.md#반복문1---2번-문제-리팩터링-버전) | 2. 피타고라스 삼중항 (3중 while, 104개 / 중복 제거 시 52개) |
| [iteration1/Fibonacci.java](4-assignment/iteration1/README.md#반복문1---3번-문제) · [Refactored](4-assignment/iteration1/README.md#반복문1---3번-문제-리팩터링-버전) | 3. 5000보다 작은 피보나치 수 |
| [iteration1/RockPaperScissorsRepeat.java](4-assignment/iteration1/README.md#반복문1---4번-문제) · [Refactored](4-assignment/iteration1/README.md#반복문1---4번-문제-리팩터링-버전) | 4. 가위바위보 반복 (`equals`, 메소드 분리) |
| [iteration2/MultiplesOfThreeFor.java](4-assignment/iteration2/README.md#반복문2---1번-문제) · [Refactored](4-assignment/iteration2/README.md#반복문2---1번-문제-리팩터링-버전) | 1. 3의 배수 (for) |
| [iteration2/PythagoreanTripleFor.java](4-assignment/iteration2/README.md#반복문2---2번-문제) · [Refactored](4-assignment/iteration2/README.md#반복문2---2번-문제-리팩터링-버전) | 2. 피타고라스 삼중항 (3중 for, `String.format`) |
| [iteration2/FibonacciFor.java](4-assignment/iteration2/README.md#반복문2---3번-문제) · [Refactored](4-assignment/iteration2/README.md#반복문2---3번-문제-리팩터링-버전) | 3. 피보나치 (for). 증감식 실행 시점 때문에 생긴 버그 분석 |
| [iteration2/RockPaperScissorsFor.java](4-assignment/iteration2/README.md#반복문2---4번-문제) · [Refactored](4-assignment/iteration2/README.md#반복문2---4번-문제-리팩터링-버전) | 4. 가위바위보 반복 (`for ( ; 조건 ; )`) |

## 📁 구조

```
week04-iteration/
├── README.md              학습 가이드 (이 문서)
├── 1-lecture/             1️⃣ 강의 노트
│   └── code/              　  강의 예제 코드 (README + .java)
├── 2-quiz/                2️⃣ 퀴즈 (README + .java)
├──  3-practice/          3️⃣ 실습
│   ├── iteration1/       반복문1 (while / do-while 만 사용)
│   └── iteration2/       반복문2 (for 로 작성)
└──  4-assignment/        4️⃣ 과제
    ├── iteration1/       반복문1 (while / do-while 만 사용)
    └── iteration2/       반복문2 (for 로 작성)
```

## ▶ 실행 방법

모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java 1-lecture/code/WhileSum.java
java 3-practice/iteration1/Pyramid.java
java 2-quiz/IterationQuiz.java
java 4-assignment/iteration2/FibonacciFor.java
```

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다.
실습·과제는 원래 이클립스에서 `Problem.java`, `Main.java`로 작성했던 코드입니다. 여기서는 문제 내용에 맞게 클래스 이름을 바꿨습니다.
