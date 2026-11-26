# Week 03: 조건문 (if · switch)

자바프로그래밍(GA1001) 3주차 정리입니다.

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
| 1️⃣ 강의 | 강의 노트로 개념을 익히고, 예제 코드를 직접 실행해 결과를 확인합니다. | 노트 [3-1](1-lecture/3-1_if문.md) · [3-2](1-lecture/3-2_if문실습.md) · [3-3](1-lecture/3-3_if문실습_switch문.md) · [예제 코드](1-lecture/code/README.md) |
| 2️⃣ 퀴즈 | 문제만 보고 답을 먼저 떠올린 뒤, 정답과 📝 필기로 확인합니다. | [퀴즈](2-quiz/README.md) |
| 3️⃣ 실습 | 문제를 직접 풀어 본 뒤, 풀이 코드 · 실행 결과 · 해설과 비교합니다. | [conditionals1](3-practice/conditionals1/README.md) · [conditionals2](3-practice/conditionals2/README.md) |
| 4️⃣ 과제 | 실습에서 익힌 내용을 응용합니다. ⚠ 자주 틀리는 부분을 다시 확인하세요. | [conditionals1](4-assignment/conditionals1/README.md) · [conditionals2](4-assignment/conditionals2/README.md) |

## 1️⃣ 강의 노트 (`1-lecture/`)

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 3-1 | [if 문](1-lecture/3-1_if문.md) | if, if-else, 복합 조건식 vs 중첩 if, else if와 조건 순서, 중간값 실습 |
| 3-2 | [if 문 실습](1-lecture/3-2_if문실습.md) | 분면 결정, 메뉴 방식 사칙 연산(`charAt`), 대소문자 변환(아스키코드), `return;` |
| 3-3 | [if 문 실습 · switch 문](1-lecture/3-3_if문실습_switch문.md) | 홀짝 맞히기(Random), switch, break와 fall-through, String switch, 월의 일수 |

### 강의 예제 코드 ([`1-lecture/code/`](1-lecture/code/README.md))

| 파일 | 차시 | 내용 |
|---|---|---|
| [Qualification.java](1-lecture/code/README.md#if-문---복합-조건식-vs-중첩-if-문) | 3-1 | 복합 조건식(`&&`)과 중첩 if 비교 |
| [Grade.java](1-lecture/code/README.md#else-if-문---점수에-따른-학점-판단) | 3-1 | 점수에 따른 학점 (else if) |
| [Median.java](1-lecture/code/README.md#실습-3개의-정수-중-중간-값-찾기) | 3-1 | 3개의 정수 중 중간값 |
| [Quadrant.java](1-lecture/code/README.md#실습-좌표값의-분면-결정하기) | 3-2 | 좌표값의 분면 결정 |
| [Calculator.java](1-lecture/code/README.md#실습-메뉴-방식의-사칙-연산-if---else-if-버전) | 3-2 | 메뉴 방식의 사칙 연산 (if) |
| [CaseConversion.java](1-lecture/code/README.md#실습-문자-변환-소문자--대문자-대문자--소문자) | 3-2 | 대문자 ↔ 소문자 변환 |
| [OddEven.java](1-lecture/code/README.md#실습-홀짝-맞히기) | 3-3 | 홀짝 맞히기 (Random) |
| [FruitType.java](1-lecture/code/README.md#switch-문---식에-문자열string-변수-사용) | 3-3 | String switch |
| [CalculatorSwitch.java](1-lecture/code/README.md#실습-메뉴-방식의-사칙-연산-switch-버전) | 3-3 | 메뉴 방식의 사칙 연산 (switch) |
| [Month.java](1-lecture/code/README.md#실습-월의-일수-맞히기) | 3-3 | 월의 일수 (case 묶기) |

## 2️⃣ 퀴즈 ([`2-quiz/`](2-quiz/README.md))

| 파일 | 내용 |
|---|---|
| [ConditionalQuiz.java](2-quiz/README.md#조건문-연습문제-1--5번) | 조건문 1~5번: 조건문 작성, boolean 조건식, 오류 찾기(문법·논리), if → switch, fall-through |

## 3️⃣ 실습 (`3-practice/`)

| 파일 | 문제 |
|---|---|
| [conditionals1/Triangle.java](3-practice/conditionals1/README.md#1-세-점으로-삼각형을-만들-수-있는지-기울기-비교) | 1. 세 점으로 삼각형을 만들 수 있는지 (기울기 비교) |
| [conditionals1/SimpleCalculator.java](3-practice/conditionals1/README.md#2-간단한-계산기-if-버전) | 2. 간단한 계산기 (if 버전) |
| [conditionals1/SimpleCalculatorSwitch.java](3-practice/conditionals1/README.md#2-간단한-계산기-switch-버전) | 2. 간단한 계산기 (switch 버전) |
| [conditionals1/UpperToLower.java](3-practice/conditionals1/README.md#3-대문자--소문자-아스키코드-필기가-가장-많은-파일) | 3. 대문자 → 소문자. 아스키코드 필기가 가장 많은 파일 |
| [conditionals1/VowelCheck.java](3-practice/conditionals1/README.md#4-모음비모음-구분-if-switch-버전과-팁-필기) | 4. 모음/비모음 구분 (if, switch 버전과 팁 필기) |
| [conditionals2/StandardWeight.java](3-practice/conditionals2/README.md#1-표준-체중-비교) | 1. 표준 체중 비교 |
| [conditionals2/AgeCalculator.java](3-practice/conditionals2/README.md#2-만-나이-계산-중첩-if) | 2. 만 나이 계산 (중첩 if) |
| [conditionals2/IncomeTax.java](3-practice/conditionals2/README.md#3-소득세-계산-강제-형변환-필기) | 3. 소득세 계산 (강제 형변환 필기) |
| [conditionals2/AreaCalculator.java](3-practice/conditionals2/README.md#4-도형의-면적-switch-변수-범위) | 4. 도형의 면적 (switch, 변수 범위) |

## 4️⃣ 과제 (`4-assignment/`)

| 파일 | 문제 |
|---|---|
| [conditionals1/MinOfThree.java](4-assignment/conditionals1/README.md#1-3개의-정수-중-최솟값) | 1. 3개의 정수 중 최솟값 |
| [conditionals1/DiscountPrice.java](4-assignment/conditionals1/README.md#2-10개-이상-구매-시-10-할인-기호-상수) | 2. 10개 이상 구매 시 10% 할인 (기호 상수) |
| [conditionals1/ShapeArea.java](4-assignment/conditionals1/README.md#3-도형의-면적-charactertouppercase-mathpi) | 3. 도형의 면적 (`Character.toUpperCase`, `Math.PI`) |
| [conditionals2/RockPaperScissors.java](4-assignment/conditionals2/README.md#1-가위바위보-mathrandom) | 1. 가위바위보 (`Math.random`) |
| [conditionals2/MenuCalculator.java](4-assignment/conditionals2/README.md#2-메뉴-방식-계산기-switch) | 2. 메뉴 방식 계산기 (switch) |
| [conditionals2/VowelSwitch.java](4-assignment/conditionals2/README.md#3-모음자음-구분-switch) | 3. 모음/자음 구분 (switch) |
| [conditionals2/Weekday.java](4-assignment/conditionals2/README.md#4-숫자--요일-switch) | 4. 숫자 → 요일 (switch) |
| [conditionals2/DayToEnglish.java](4-assignment/conditionals2/README.md#5-한글-요일--영어-요일-string-switch) | 5. 한글 요일 → 영어 요일 (String switch) |

## 📁 구조

```
week03-conditionals/
├── README.md              학습 가이드 (이 문서)
├── 1-lecture/             1️⃣ 강의 노트
│   └── code/              　  강의 예제 코드 (README + .java)
├── 2-quiz/                2️⃣ 퀴즈 (README + .java)
├──  3-practice/          3️⃣ 실습
│   ├── conditionals1/    조건문1
│   └── conditionals2/    조건문2
└──  4-assignment/        4️⃣ 과제
    ├── conditionals1/    조건문1
    └── conditionals2/    조건문2
```

## ▶ 실행 방법

모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java 1-lecture/code/Median.java
java 3-practice/conditionals1/Triangle.java
java 2-quiz/ConditionalQuiz.java
```

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다.
실습·과제는 원래 이클립스에서 `Problem.java`, `Main.java`로 작성했던 코드입니다. 여기서는 문제 내용에 맞게 클래스 이름을 바꿨습니다.
