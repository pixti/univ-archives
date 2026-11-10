# Week 04: 반복문 (while · do-while · for)

자바프로그래밍(GA1001) 4주차 정리입니다.
교재는 『자바만 잡아도』입니다.

- 강의 자료(.pptx)는 Markdown으로 정리했습니다.
- 실습, 퀴즈, 과제는 `.java` 코드로 정리했습니다.
- 수업 중 필기는 **📝 필기** 표시로 주석과 노트에 넣었습니다.
- 💡 표시는 과제를 풀면서 덧붙인 설명입니다.
- ⚠ 표시는 원본 자료의 오타나 컴파일 오류, 내 답안의 틀린 부분, AI 리팩터링 코드의 문제점을 바로잡은 곳입니다.

## 📁 구조

```
week04-iteration/
├── lecture-notes/          강의 자료 (.pptx → .md)
├── examples/               강의 슬라이드 속 예제 코드
├── practice/               실습
│   ├── iteration1/         ├ 반복문1 (while / do-while)
│   └── iteration2/         └ 반복문2 (for)
├── quiz/                   퀴즈
└── assignment/             과제
    ├── iteration1/         ├ 반복문1 (while / do-while 만 사용)
    └── iteration2/         └ 반복문2 (for 로 작성)
```

## 📖 강의 노트

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 4-1 | [while 문](lecture-notes/4-1_while문.md) | while, 합·곱 누적(0과 1로 초기화), 특정 구구단, 반복 횟수가 정해지지 않은 경우, 성적 처리, 메뉴 반복, 숫자 맞히기 |
| 4-2 | [do-while 문](lecture-notes/4-2_do-while문.md) | do-while(최소 1번 실행), 반복 여부 묻기, 메뉴 반복, 숫자 맞히기 게임 반복 |
| 4-3 | [for 문](lecture-notes/4-3_for문.md) | for, 파이썬 for → 자바 for, 반복 변수의 범위, 증감식의 여러 형태, 무한 반복, 팩토리얼, 3의 배수의 합 |
| 4-4 | [break · continue · 이중 for · foreach](lecture-notes/4-4_break_continue_이중for_foreach.md) | break, 소수 판별, continue, 이중 for(별 찍기·구구단), n보다 작은 소수, foreach, 학생 성적 처리 |

## 💻 코드

### 강의 예제 (`examples/`)

| 파일 | 차시 | 내용 |
|---|---|---|
| [WhileTable.java](examples/WhileTable.java) | 4-1 | 1 / 10 / 100 표 출력 |
| [WhileSum.java](examples/WhileSum.java) | 4-1 | 1 ~ 5까지의 합 |
| [WhileProduct.java](examples/WhileProduct.java) | 4-1 | 1 ~ 5까지의 곱 |
| [MultiplicationTableWhile.java](examples/MultiplicationTableWhile.java) | 4-1 | 특정 구구단 출력 (while) |
| [ContinueQuestion.java](examples/ContinueQuestion.java) | 4-1 · 4-2 | "계속 하시겠습니까?" (반복 횟수가 정해지지 않은 경우) |
| [ScoreProcessing.java](examples/ScoreProcessing.java) | 4-1 | 성적 처리 |
| [MenuCalculatorWhile.java](examples/MenuCalculatorWhile.java) | 4-1 | 메뉴 반복 처리 (while) |
| [NumberGuessing.java](examples/NumberGuessing.java) | 4-1 | 숫자 맞히기 게임 |
| [MenuCalculatorDoWhile.java](examples/MenuCalculatorDoWhile.java) | 4-2 | 메뉴 반복 처리 (do-while) |
| [NumberGuessingRepeat.java](examples/NumberGuessingRepeat.java) | 4-2 | 숫자 맞히기 게임 반복 |
| [ForSum.java](examples/ForSum.java) | 4-3 | 파이썬 for → 자바 for, 증감식의 여러 형태 |
| [ForScope.java](examples/ForScope.java) | 4-3 | 반복 변수의 범위, 무한 반복 |
| [MultiplicationTableFor.java](examples/MultiplicationTableFor.java) | 4-3 | 특정 구구단 출력 (for) |
| [Factorial.java](examples/Factorial.java) | 4-3 | 팩토리얼 |
| [MultipleSum.java](examples/MultipleSum.java) | 4-3 | 1에서 n까지 3의 배수의 합 |
| [MenuCalculatorFor.java](examples/MenuCalculatorFor.java) | 4-3 | 메뉴 반복 처리 (for) |
| [BreakExample.java](examples/BreakExample.java) | 4-4 | break |
| [PrimeCheck.java](examples/PrimeCheck.java) | 4-4 | 소수 판별 (break) |
| [ContinueOddSum.java](examples/ContinueOddSum.java) | 4-4 | continue로 1 ~ 100 홀수의 합 |
| [StarPattern.java](examples/StarPattern.java) | 4-4 | 이중 for로 별 찍기 (사각형, 삼각형) |
| [MultiplicationTableAll.java](examples/MultiplicationTableAll.java) | 4-4 | 구구단 전체 출력 (이중 for) |
| [PrimesBelowN.java](examples/PrimesBelowN.java) | 4-4 | n보다 작은 소수 (이중 for + break) |
| [ForEach.java](examples/ForEach.java) | 4-4 | foreach, 학생 성적 처리 |

### 실습 (`practice/`)

| 파일 | 문제 |
|---|---|
| [iteration1/ArithmeticMean.java](practice/iteration1/ArithmeticMean.java) | 1. 음수가 입력될 때까지 산술 평균 (while, 0으로 나누기 방지) |
| [iteration1/FuelEfficiency.java](practice/iteration1/FuelEfficiency.java) | 2. 연비 계산 반복 (do-while이 어울리는 이유) |
| [iteration1/Permutation.java](practice/iteration1/Permutation.java) | 3. 순열 nPr (while) |
| [iteration1/Pyramid.java](practice/iteration1/Pyramid.java) | 4. 피라미드 출력 (중첩 while, 안쪽 변수 초기화) |
| [iteration2/ArithmeticMeanFor.java](practice/iteration2/ArithmeticMeanFor.java) | 1. 산술 평균 (for). 초기식에 선언과 식을 섞은 컴파일 오류 분석 |
| [iteration2/FuelEfficiencyFor.java](practice/iteration2/FuelEfficiencyFor.java) | 2. 연비 계산 반복 (`for ( ; 조건 ; )`) |
| [iteration2/PermutationFor.java](practice/iteration2/PermutationFor.java) | 3. 순열 nPr (for) |
| [iteration2/PyramidFor.java](practice/iteration2/PyramidFor.java) | 4. 피라미드 출력 (for) + 필기한 쌍둥이 피라미드 |

### 퀴즈 (`quiz/`)

| 파일 | 내용 |
|---|---|
| [IterationQuiz.java](quiz/IterationQuiz.java) | 반복문 1~3번: 출력 결과 예측, while → for 변환(표현력이 같다), Σ·Π 계산, 변수 선언 위치(범위) |

### 과제 (`assignment/`)

각 문제마다 내가 작성한 코드와, 그 코드를 AI로 리팩터링한 코드(`...Refactored.java`)가 있습니다.
리팩터링 코드는 원본 그대로 옮겼습니다. 과제 조건 위반, 쓰이지 않는 상수, 실제 동작과 다른 주석은 ⚠로 표시했습니다.

| 파일 | 문제 |
|---|---|
| [iteration1/MultiplesOfThree.java](assignment/iteration1/MultiplesOfThree.java) · [Refactored](assignment/iteration1/MultiplesOfThreeRefactored.java) | 1. 0 ~ 입력값 사이의 3의 배수 (while, 입력 검증) |
| [iteration1/PythagoreanTriple.java](assignment/iteration1/PythagoreanTriple.java) · [Refactored](assignment/iteration1/PythagoreanTripleRefactored.java) | 2. 피타고라스 삼중항 (3중 while, 104개 / 중복 제거 시 52개) |
| [iteration1/Fibonacci.java](assignment/iteration1/Fibonacci.java) · [Refactored](assignment/iteration1/FibonacciRefactored.java) | 3. 5000보다 작은 피보나치 수 |
| [iteration1/RockPaperScissorsRepeat.java](assignment/iteration1/RockPaperScissorsRepeat.java) · [Refactored](assignment/iteration1/RockPaperScissorsRepeatRefactored.java) | 4. 가위바위보 반복 (`equals`, 메소드 분리) |
| [iteration2/MultiplesOfThreeFor.java](assignment/iteration2/MultiplesOfThreeFor.java) · [Refactored](assignment/iteration2/MultiplesOfThreeForRefactored.java) | 1. 3의 배수 (for) |
| [iteration2/PythagoreanTripleFor.java](assignment/iteration2/PythagoreanTripleFor.java) · [Refactored](assignment/iteration2/PythagoreanTripleForRefactored.java) | 2. 피타고라스 삼중항 (3중 for, `String.format`) |
| [iteration2/FibonacciFor.java](assignment/iteration2/FibonacciFor.java) · [Refactored](assignment/iteration2/FibonacciForRefactored.java) | 3. 피보나치 (for). 증감식 실행 시점 때문에 생긴 버그 분석 |
| [iteration2/RockPaperScissorsFor.java](assignment/iteration2/RockPaperScissorsFor.java) · [Refactored](assignment/iteration2/RockPaperScissorsForRefactored.java) | 4. 가위바위보 반복 (`for ( ; 조건 ; )`) |

## ▶ 실행 방법

모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java examples/WhileSum.java
java practice/iteration1/Pyramid.java
java quiz/IterationQuiz.java
java assignment/iteration2/FibonacciFor.java
```

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다.
실습·과제는 원래 이클립스에서 `Problem.java`, `Main.java`로 작성했던 코드입니다. 여기서는 문제 내용에 맞게 클래스 이름을 바꿨습니다.
