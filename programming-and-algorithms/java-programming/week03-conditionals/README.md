# Week 03: 조건문 (if · switch)

자바프로그래밍(GA1001) 3주차 정리입니다.
교재는 『자바만 잡아도』입니다.

- 강의 자료(.pptx)는 Markdown으로 정리했습니다.
- 실습, 퀴즈, 과제는 `.java` 코드로 정리했습니다.
- 수업 중 필기는 **📝 필기** 표시로 주석과 노트에 넣었습니다.
- 💡 표시는 과제를 풀면서 덧붙인 설명입니다.
- ⚠ 표시는 원본 자료의 오타나 컴파일 오류, 내 답안의 틀린 부분을 바로잡은 곳입니다.

## 📁 구조

```
week03-conditionals/
├── lecture-notes/          강의 자료 (.pptx → .md)
├── examples/               강의 슬라이드 속 예제 코드
├── practice/               실습
│   ├── conditionals1/      ├ 조건문1
│   └── conditionals2/      └ 조건문2
├── quiz/                   퀴즈
└── assignment/             과제
    ├── conditionals1/      ├ 조건문1
    └── conditionals2/      └ 조건문2
```

## 📖 강의 노트

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 3-1 | [if 문](lecture-notes/3-1_if문.md) | if, if-else, 복합 조건식 vs 중첩 if, else if와 조건 순서, 중간값 실습 |
| 3-2 | [if 문 실습](lecture-notes/3-2_if문실습.md) | 분면 결정, 메뉴 방식 사칙 연산(`charAt`), 대소문자 변환(아스키코드), `return;` |
| 3-3 | [if 문 실습 · switch 문](lecture-notes/3-3_if문실습_switch문.md) | 홀짝 맞히기(Random), switch, break와 fall-through, String switch, 월의 일수 |

## 💻 코드

### 강의 예제 (`examples/`)

| 파일 | 차시 | 내용 |
|---|---|---|
| [Qualification.java](examples/Qualification.java) | 3-1 | 복합 조건식(`&&`)과 중첩 if 비교 |
| [Grade.java](examples/Grade.java) | 3-1 | 점수에 따른 학점 (else if) |
| [Median.java](examples/Median.java) | 3-1 | 3개의 정수 중 중간값 |
| [Quadrant.java](examples/Quadrant.java) | 3-2 | 좌표값의 분면 결정 |
| [Calculator.java](examples/Calculator.java) | 3-2 | 메뉴 방식의 사칙 연산 (if) |
| [CaseConversion.java](examples/CaseConversion.java) | 3-2 | 대문자 ↔ 소문자 변환 |
| [OddEven.java](examples/OddEven.java) | 3-3 | 홀짝 맞히기 (Random) |
| [FruitType.java](examples/FruitType.java) | 3-3 | String switch |
| [CalculatorSwitch.java](examples/CalculatorSwitch.java) | 3-3 | 메뉴 방식의 사칙 연산 (switch) |
| [Month.java](examples/Month.java) | 3-3 | 월의 일수 (case 묶기) |

### 실습 (`practice/`)

| 파일 | 문제 |
|---|---|
| [conditionals1/Triangle.java](practice/conditionals1/Triangle.java) | 1. 세 점으로 삼각형을 만들 수 있는지 (기울기 비교) |
| [conditionals1/SimpleCalculator.java](practice/conditionals1/SimpleCalculator.java) | 2. 간단한 계산기 (if 버전) |
| [conditionals1/SimpleCalculatorSwitch.java](practice/conditionals1/SimpleCalculatorSwitch.java) | 2. 간단한 계산기 (switch 버전) |
| [conditionals1/UpperToLower.java](practice/conditionals1/UpperToLower.java) | 3. 대문자 → 소문자. 아스키코드 필기가 가장 많은 파일 |
| [conditionals1/VowelCheck.java](practice/conditionals1/VowelCheck.java) | 4. 모음/비모음 구분 (if, switch 버전과 팁 필기) |
| [conditionals2/StandardWeight.java](practice/conditionals2/StandardWeight.java) | 1. 표준 체중 비교 |
| [conditionals2/AgeCalculator.java](practice/conditionals2/AgeCalculator.java) | 2. 만 나이 계산 (중첩 if) |
| [conditionals2/IncomeTax.java](practice/conditionals2/IncomeTax.java) | 3. 소득세 계산 (강제 형변환 필기) |
| [conditionals2/AreaCalculator.java](practice/conditionals2/AreaCalculator.java) | 4. 도형의 면적 (switch, 변수 범위) |

### 퀴즈 (`quiz/`)

| 파일 | 내용 |
|---|---|
| [ConditionalQuiz.java](quiz/ConditionalQuiz.java) | 조건문 1~5번: 조건문 작성, boolean 조건식, 오류 찾기(문법·논리), if → switch, fall-through |

### 과제 (`assignment/`)

| 파일 | 문제 |
|---|---|
| [conditionals1/MinOfThree.java](assignment/conditionals1/MinOfThree.java) | 1. 3개의 정수 중 최솟값 |
| [conditionals1/DiscountPrice.java](assignment/conditionals1/DiscountPrice.java) | 2. 10개 이상 구매 시 10% 할인 (기호 상수) |
| [conditionals1/ShapeArea.java](assignment/conditionals1/ShapeArea.java) | 3. 도형의 면적 (`Character.toUpperCase`, `Math.PI`) |
| [conditionals2/RockPaperScissors.java](assignment/conditionals2/RockPaperScissors.java) | 1. 가위바위보 (`Math.random`) |
| [conditionals2/MenuCalculator.java](assignment/conditionals2/MenuCalculator.java) | 2. 메뉴 방식 계산기 (switch) |
| [conditionals2/VowelSwitch.java](assignment/conditionals2/VowelSwitch.java) | 3. 모음/자음 구분 (switch) |
| [conditionals2/Weekday.java](assignment/conditionals2/Weekday.java) | 4. 숫자 → 요일 (switch) |
| [conditionals2/DayToEnglish.java](assignment/conditionals2/DayToEnglish.java) | 5. 한글 요일 → 영어 요일 (String switch) |

## ▶ 실행 방법

모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java examples/Median.java
java practice/conditionals1/Triangle.java
java quiz/ConditionalQuiz.java
```

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다.
실습·과제는 원래 이클립스에서 `Problem.java`, `Main.java`로 작성했던 코드입니다. 여기서는 문제 내용에 맞게 클래스 이름을 바꿨습니다.
