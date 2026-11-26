# Week 05: 배열

자바프로그래밍(GA1001) 5주차 정리입니다.

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
| 1️⃣ 강의 | 강의 노트로 개념을 익히고, 예제 코드를 직접 실행해 결과를 확인합니다. | 노트 [5-1](1-lecture/5-1_배열선언_생성_사용.md) · [5-2](1-lecture/5-2_배열정렬_탐색.md) · [5-3](1-lecture/5-3_배열복사_다차원배열.md) · [예제 코드](1-lecture/code/README.md) |
| 2️⃣ 퀴즈 | 문제만 보고 답을 먼저 떠올린 뒤, 정답과 📝 필기로 확인합니다. | [퀴즈](2-quiz/README.md) |
| 3️⃣ 실습 | 문제를 직접 풀어 본 뒤, 풀이 코드 · 실행 결과 · 해설과 비교합니다. | [arrays1](3-practice/arrays1/README.md) · [arrays2](3-practice/arrays2/README.md) |
| 4️⃣ 과제 | 실습에서 익힌 내용을 응용합니다. ⚠ 자주 틀리는 부분을 다시 확인하세요. | [arrays1](4-assignment/arrays1/README.md) · [arrays2](4-assignment/arrays2/README.md) |

## 1️⃣ 강의 노트 (`1-lecture/`)

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 5-1 | [배열 선언 · 생성 · 사용](1-lecture/5-1_배열선언_생성_사용.md) | 배열이란, 선언과 생성, 첨자, 선언과 동시에 초기화, 레퍼런스형 배열, 출력·합·최대·최소, 값 읽어들이기, 성적 처리 |
| 5-2 | [배열 정렬 · 탐색](1-lecture/5-2_배열정렬_탐색.md) | `Arrays.sort`, 내림차순 정렬(int 배열 / 객체 배열), 성적 정렬, `Arrays.binarySearch`, 성적 정렬 및 검색 |
| 5-3 | [배열 복사 · 다차원 배열](1-lecture/5-3_배열복사_다차원배열.md) | 레퍼런스 복사 vs `clone()`, 다차원 배열과 그 구조, 다차원 배열의 `clone()`, Jagged 배열, `length`, 행렬 덧셈 |

### 강의 예제 코드 ([`1-lecture/code/`](1-lecture/code/README.md))

| 파일 | 차시 | 내용 |
|---|---|---|
| [ArrayBasics.java](1-lecture/code/README.md#배열-선언--생성--접근--선언과-동시에-초기화) | 5-1 | 배열 선언 · 생성 · 접근 · 선언과 동시에 초기화 |
| [ReferenceArray.java](1-lecture/code/README.md#레퍼런스형객체-배열) | 5-1 | 레퍼런스형(객체) 배열 |
| [ArrayTypicalUsage.java](1-lecture/code/README.md#배열의-전형적인-사용-예-출력--합--최대값--최소값) | 5-1 | 배열의 전형적인 사용 예 (출력 · 합 · 최대값 · 최소값) |
| [ReadIntoArray.java](1-lecture/code/README.md#5-값-배열에-읽어들이기) | 5-1 | 값을 배열에 읽어들이기 |
| [ScoreStatistics.java](1-lecture/code/README.md#실습-학생-성적-데이터-처리하기--평균-최대소값) | 5-1 | [실습] 학생 성적 처리 (평균, 최대·최소). ⚠ 합계에서 `array[0]`이 빠지는 실수 |
| [ArraySort.java](1-lecture/code/README.md#배열-정렬--javautilarrays-의-정적-메소드-sort) | 5-2 | `Arrays.sort` |
| [DescendingSort.java](1-lecture/code/README.md#내림차순-정렬--두-변수-교환swap) | 5-2 | 내림차순 정렬 + 두 변수 교환(swap) |
| [ScoreSort.java](1-lecture/code/README.md#실습-학생-성적-정렬) | 5-2 | [실습] 학생 성적 정렬. ⚠ `sort(array, 0, cnt-1)` → `cnt` |
| [BinarySearchTest.java](1-lecture/code/README.md#배열-탐색--javautilarrays-의-정적-메소드-binarysearch) | 5-2 | `Arrays.binarySearch` |
| [ScoreSortSearch.java](1-lecture/code/README.md#실습-학생-성적-정렬-및-검색하기) | 5-2 | [실습] 학생 성적 정렬 및 검색 |
| [ArrayCopy.java](1-lecture/code/README.md#배열-복사--레퍼런스-복사공유-vs-clone-복사--2차원-배열의-clone) | 5-3 | 레퍼런스 복사(공유) vs `clone()`, 2차원 배열의 `clone()` |
| [MultiDimensionArray.java](1-lecture/code/README.md#다차원-배열-선언--생성--접근--자바의-다차원-배열-구조) | 5-3 | 다차원 배열 선언 · 생성 · 접근, 자바의 다차원 배열 구조 |
| [JaggedArray.java](1-lecture/code/README.md#jagged-배열-행마다-길이가-다른-배열) | 5-3 | Jagged 배열 (행마다 길이가 다른 배열) |
| [MultiDimensionTest.java](1-lecture/code/README.md#다차원-배열-출력--arraylength-와-arrayilength) | 5-3 | `array.length`와 `array[i].length` |
| [MatrixAdd.java](1-lecture/code/README.md#실습-행렬-덧셈) | 5-3 | [실습] 행렬 덧셈 |

## 2️⃣ 퀴즈 ([`2-quiz/`](2-quiz/README.md))

| 파일 | 내용 |
|---|---|
| [ArrayQuiz.java](2-quiz/README.md#배열) | 배열 1~8번: 선언·초기화 오류 수정, 범위를 벗어난 인덱스, `clone()` vs 대입(⚠ 4·5번 자주 틀리는 부분), 2차원 배열·Jagged 배열 생성, 행마다 원소 개수 |

## 3️⃣ 실습 (`3-practice/`)

| 파일 | 문제 |
|---|---|
| [arrays1/ContainsValue.java](3-practice/arrays1/README.md#1-배열이-특정-값을-포함하는지-인덱스-for) | 1. 배열이 특정 값을 포함하는지 (인덱스 for) |
| [arrays1/ContainsValueForEach.java](3-practice/arrays1/README.md#1-같은-문제를-for-each--flag로) | 1. 같은 문제를 for each + flag로 (📝 시험 출제 예상) |
| [arrays1/ContainsValueRepeat.java](3-practice/arrays1/README.md#1-같은-문제를-do-while로-반복) | 1. 같은 문제를 do-while로 반복 |
| [arrays1/FindIndex.java](3-practice/arrays1/README.md#2-배열-요소의-인덱스-찾기-인덱스-for--optionalint) | 2. 💡 배열 요소의 인덱스 찾기 (인덱스 for + `OptionalInt`) |
| [arrays1/RemoveElement.java](3-practice/arrays1/README.md#3-배열에서-특정-요소-제거-인덱스-for) | 3. 배열에서 특정 요소 제거 (인덱스 for) |
| [arrays1/RemoveElementForEach.java](3-practice/arrays1/README.md#3-같은-문제를-for-each로) | 3. 같은 문제를 for each로 |
| [arrays1/ReverseArray.java](3-practice/arrays1/README.md#4-배열-요소-순서-반전) | 4. 배열 요소 순서 반전 |
| [arrays1/CommonElements.java](3-practice/arrays1/README.md#5-두-배열의-공통-요소) | 5. 💡 두 배열의 공통 요소 |
| [arrays1/DuplicateElements.java](3-practice/arrays1/README.md#6-중복-값-찾기-int-배열--string-배열은-equals) | 6. 💡 중복 값 찾기 (int 배열 + String 배열은 `equals`) |
| [arrays1/MoveZerosToEnd.java](3-practice/arrays1/README.md#7-0을-배열-끝으로-옮기기-상대-순서-유지) | 7. 💡 0을 배열 끝으로 옮기기 (상대 순서 유지) |
| [arrays1/Leaders.java](3-practice/arrays1/README.md#8-배열의-리더-찾기) | 8. 배열의 리더 찾기 |
| [arrays2/CopyArray.java](3-practice/arrays2/README.md#1-반복문으로-배열-복사) | 1. 💡 반복문으로 배열 복사 |
| [arrays2/CopyStringArray.java](3-practice/arrays2/README.md#2-문자열-배열-복사) | 2. 💡 문자열 배열 복사 |
| [arrays2/SecondLargest.java](3-practice/arrays2/README.md#3-두-번째로-큰-요소) | 3. 💡 두 번째로 큰 요소 |
| [arrays2/SpiralArray.java](3-practice/arrays2/README.md#4-n--n-나선형-배열) | 4. 💡 n × n 나선형 배열 |
| [4-assignment/arrays2/InventoryArray1D.java](4-assignment/arrays2/README.md#5-재고-관리-1차원-과제-배열2-1번의-출발점이라-과제-폴더에-있음) | 5. 재고 관리 (1차원). 과제 배열(2) 1번의 출발점이라 과제 폴더에 있음 |
| [arrays2/Box2D.java](3-practice/arrays2/README.md#6-box53에-입력받아-출력) | 6. `box[5][3]`에 입력받아 출력 |
| [arrays2/TicTacToe.java](3-practice/arrays2/README.md#7-틱택토) | 7. 틱택토 (📝 코드 흐름 설명, ⚠ 개선점) |
| [arrays2/SeatReservation.java](3-practice/arrays2/README.md#8-극장-좌석-예약-10행-8열) | 8. 극장 좌석 예약 (10행 8열) |

## 4️⃣ 과제 (`4-assignment/`)

각 문제마다 직접 작성한 코드와, 그 코드를 리팩터링한 버전(`...Refactored.java`)이 있습니다.
리팩터링 버전의 머리 주석에 바뀐 점과 남은 문제(⚠)를 정리했습니다.

| 파일 | 문제 |
|---|---|
| [arrays1/ReverseInput.java](4-assignment/arrays1/README.md#배열1---1번-문제) · [Refactored](4-assignment/arrays1/README.md#배열1---1번-문제-리팩터링-버전) | 1. 정수 10개를 입력받아 역순 출력 |
| [arrays1/DaysInMonth.java](4-assignment/arrays1/README.md#배열1---2번-문제) · [Refactored](4-assignment/arrays1/README.md#배열1---2번-문제-리팩터링-버전) | 2. 입력한 달의 날짜 수 (배열을 표로 쓰기, ⚠ 범위 검사) |
| [arrays1/DecimalToBinary.java](4-assignment/arrays1/README.md#배열1---3번-문제) · [Refactored](4-assignment/arrays1/README.md#배열1---3번-문제-리팩터링-버전) | 3. 10진수 → 2진수 (📝 역순 저장과 index, ⚠ 0·음수 입력) |
| [arrays1/MeanStdDev.java](4-assignment/arrays1/README.md#4-실수-30개-이하의-평균과-표준편차) | 4. 실수 30개 이하의 평균과 표준편차 (📝 배열이 필요한 이유) |
| [arrays1/RandomFrequency.java](4-assignment/arrays1/README.md#배열1---5번-문제) · [Refactored](4-assignment/arrays1/README.md#배열1---5번-문제-리팩터링-버전) | 5. 0 ~ 19 난수 1000개 중 가장 많이 나온 수 (📝 count 배열, ⚠ 숫자 대신 횟수 출력) |
| [arrays2/InventoryArray1D.java](4-assignment/arrays2/README.md#5-재고-관리-1차원-과제-배열2-1번의-출발점이라-과제-폴더에-있음) · [Refactored](4-assignment/arrays2/README.md#배열2---1번-문제-실습-5번-1차원-버전의-리팩터링-버전) · [💡 2D](4-assignment/arrays2/README.md#배열2---1번-문제---참고-답안-직접-작성하지-않은-부분) | 1. 재고 관리를 2차원 배열로 확장 (직접 작성한 것은 1차원 버전, 2차원은 💡 참고 답안) |
| [arrays2/RowColumnSum.java](4-assignment/arrays2/README.md#배열2---2번-문제) · [Refactored](4-assignment/arrays2/README.md#배열2---2번-문제-리팩터링-버전) | 2. 2차원 배열의 행 합계 · 열 합계 |
| [arrays2/Transpose.java](4-assignment/arrays2/README.md#배열2---3번-문제) · [Refactored](4-assignment/arrays2/README.md#배열2---3번-문제-리팩터링-버전) | 3. 전치 행렬 (📝 `transpose[col][row] = arr[row][col]`, ⚠ 입력 대신 코드에 직접 작성) |
| [arrays2/MatrixMultiply.java](4-assignment/arrays2/README.md#배열2---4번-문제) · [Refactored](4-assignment/arrays2/README.md#배열2---4번-문제-리팩터링-버전) | 4. 임의 크기 행렬의 곱셈 (0 ~ 99 난수, 곱할 수 없는 크기 검사) |

## 📁 구조

```
week05-arrays/
├── README.md              학습 가이드 (이 문서)
├── 1-lecture/             1️⃣ 강의 노트
│   └── code/              　  강의 예제 코드 (README + .java)
├── 2-quiz/                2️⃣ 퀴즈 (README + .java)
├──  3-practice/          3️⃣ 실습
│   ├── arrays1/          배열(1)
│   └── arrays2/          배열(2)
└──  4-assignment/        4️⃣ 과제
    ├── arrays1/          배열(1)
    └── arrays2/          배열(2)
```

## ▶ 실행 방법

모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java 1-lecture/code/ArrayTypicalUsage.java
java 3-practice/arrays1/ContainsValue.java
java 2-quiz/ArrayQuiz.java
java 4-assignment/arrays2/MatrixMultiply.java
```

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다.
실습·과제는 원래 이클립스에서 `Problem.java`, `Main.java`로 작성했던 코드입니다. 여기서는 문제 내용에 맞게 클래스 이름을 바꿨습니다.
