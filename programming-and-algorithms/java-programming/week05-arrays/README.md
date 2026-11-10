# Week 05: 배열

자바프로그래밍(GA1001) 5주차 정리입니다.
교재는 『자바만 잡아도』입니다.

- 강의 자료(.pptx)는 Markdown으로 정리했습니다.
- 실습, 퀴즈, 과제는 `.java` 코드로 정리했습니다.
- 수업 중 필기와 AI에게 받은 설명은 **📝 필기** 표시로 주석과 노트에 넣었습니다.
- 💡 표시는 정리하면서 덧붙인 설명입니다. 직접 풀지 않은 문제는 💡 참고 답안으로 채웠습니다.
- ⚠ 표시는 원본 자료의 오타나 버그, 내 답안의 틀린 부분, AI 리팩터링 코드의 문제점을 바로잡은 곳입니다.

## 📁 구조

```
week05-arrays/
├── lecture-notes/          강의 자료 (.pptx → .md)
├── examples/               강의 슬라이드 속 예제 코드
├── practice/               실습
│   ├── arrays1/            ├ 배열(1)
│   └── arrays2/            └ 배열(2)
├── quiz/                   퀴즈
└── assignment/             과제
    ├── arrays1/            ├ 배열(1)
    └── arrays2/            └ 배열(2)
```

## 📖 강의 노트

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 5-1 | [배열 선언 · 생성 · 사용](lecture-notes/5-1_배열선언_생성_사용.md) | 배열이란, 선언과 생성, 첨자, 선언과 동시에 초기화, 레퍼런스형 배열, 출력·합·최대·최소, 값 읽어들이기, 성적 처리 |
| 5-2 | [배열 정렬 · 탐색](lecture-notes/5-2_배열정렬_탐색.md) | `Arrays.sort`, 내림차순 정렬(int 배열 / 객체 배열), 성적 정렬, `Arrays.binarySearch`, 성적 정렬 및 검색 |
| 5-3 | [배열 복사 · 다차원 배열](lecture-notes/5-3_배열복사_다차원배열.md) | 레퍼런스 복사 vs `clone()`, 다차원 배열과 그 구조, 다차원 배열의 `clone()`, Jagged 배열, `length`, 행렬 덧셈 |

## 💻 코드

### 강의 예제 (`examples/`)

| 파일 | 차시 | 내용 |
|---|---|---|
| [ArrayBasics.java](examples/ArrayBasics.java) | 5-1 | 배열 선언 · 생성 · 접근 · 선언과 동시에 초기화 |
| [ReferenceArray.java](examples/ReferenceArray.java) | 5-1 | 레퍼런스형(객체) 배열 |
| [ArrayTypicalUsage.java](examples/ArrayTypicalUsage.java) | 5-1 | 배열의 전형적인 사용 예 (출력 · 합 · 최대값 · 최소값) |
| [ReadIntoArray.java](examples/ReadIntoArray.java) | 5-1 | 값을 배열에 읽어들이기 |
| [ScoreStatistics.java](examples/ScoreStatistics.java) | 5-1 | [실습] 학생 성적 처리 (평균, 최대·최소). ⚠ 슬라이드의 합계 버그 수정 |
| [ArraySort.java](examples/ArraySort.java) | 5-2 | `Arrays.sort` |
| [DescendingSort.java](examples/DescendingSort.java) | 5-2 | 내림차순 정렬 + 두 변수 교환(swap) |
| [ScoreSort.java](examples/ScoreSort.java) | 5-2 | [실습] 학생 성적 정렬. ⚠ `sort(array, 0, cnt-1)` → `cnt` |
| [BinarySearchTest.java](examples/BinarySearchTest.java) | 5-2 | `Arrays.binarySearch` |
| [ScoreSortSearch.java](examples/ScoreSortSearch.java) | 5-2 | [실습] 학생 성적 정렬 및 검색 |
| [ArrayCopy.java](examples/ArrayCopy.java) | 5-3 | 레퍼런스 복사(공유) vs `clone()`, 2차원 배열의 `clone()` |
| [MultiDimensionArray.java](examples/MultiDimensionArray.java) | 5-3 | 다차원 배열 선언 · 생성 · 접근, 자바의 다차원 배열 구조 |
| [JaggedArray.java](examples/JaggedArray.java) | 5-3 | Jagged 배열 (행마다 길이가 다른 배열) |
| [MultiDimensionTest.java](examples/MultiDimensionTest.java) | 5-3 | `array.length`와 `array[i].length` |
| [MatrixAdd.java](examples/MatrixAdd.java) | 5-3 | [실습] 행렬 덧셈 |

### 실습 (`practice/`)

| 파일 | 문제 |
|---|---|
| [arrays1/ContainsValue.java](practice/arrays1/ContainsValue.java) | 1. 배열이 특정 값을 포함하는지 (인덱스 for) |
| [arrays1/ContainsValueForEach.java](practice/arrays1/ContainsValueForEach.java) | 1. 같은 문제를 for each + flag로 (📝 시험 출제 예상) |
| [arrays1/ContainsValueRepeat.java](practice/arrays1/ContainsValueRepeat.java) | 1. 같은 문제를 do-while로 반복 |
| [arrays1/FindIndex.java](practice/arrays1/FindIndex.java) | 2. 💡 배열 요소의 인덱스 찾기 (인덱스 for + `OptionalInt`) |
| [arrays1/RemoveElement.java](practice/arrays1/RemoveElement.java) | 3. 배열에서 특정 요소 제거 (인덱스 for) |
| [arrays1/RemoveElementForEach.java](practice/arrays1/RemoveElementForEach.java) | 3. 같은 문제를 for each로 |
| [arrays1/ReverseArray.java](practice/arrays1/ReverseArray.java) | 4. 배열 요소 순서 반전 |
| [arrays1/CommonElements.java](practice/arrays1/CommonElements.java) | 5. 💡 두 배열의 공통 요소 |
| [arrays1/DuplicateElements.java](practice/arrays1/DuplicateElements.java) | 6. 💡 중복 값 찾기 (int 배열 + String 배열은 `equals`) |
| [arrays1/MoveZerosToEnd.java](practice/arrays1/MoveZerosToEnd.java) | 7. 💡 0을 배열 끝으로 옮기기 (상대 순서 유지) |
| [arrays1/Leaders.java](practice/arrays1/Leaders.java) | 8. 배열의 리더 찾기 |
| [arrays2/CopyArray.java](practice/arrays2/CopyArray.java) | 1. 💡 반복문으로 배열 복사 |
| [arrays2/CopyStringArray.java](practice/arrays2/CopyStringArray.java) | 2. 💡 문자열 배열 복사 |
| [arrays2/SecondLargest.java](practice/arrays2/SecondLargest.java) | 3. 💡 두 번째로 큰 요소 |
| [arrays2/SpiralArray.java](practice/arrays2/SpiralArray.java) | 4. 💡 n × n 나선형 배열 |
| [assignment/arrays2/InventoryArray1D.java](assignment/arrays2/InventoryArray1D.java) | 5. 재고 관리 (1차원). 과제 배열(2) 1번의 출발점이라 과제 폴더에 있음 |
| [arrays2/Box2D.java](practice/arrays2/Box2D.java) | 6. `box[5][3]`에 입력받아 출력 |
| [arrays2/TicTacToe.java](practice/arrays2/TicTacToe.java) | 7. 틱택토 (📝 AI 설명, ⚠ 개선점) |
| [arrays2/SeatReservation.java](practice/arrays2/SeatReservation.java) | 8. 극장 좌석 예약 (10행 8열) |

### 퀴즈 (`quiz/`)

| 파일 | 내용 |
|---|---|
| [ArrayQuiz.java](quiz/ArrayQuiz.java) | 배열 1~8번: 선언·초기화 오류 수정, 범위를 벗어난 인덱스, `clone()` vs 대입(⚠ 4·5번 오답 정리), 2차원 배열·Jagged 배열 생성, 행마다 원소 개수 |

### 과제 (`assignment/`)

각 문제마다 내가 작성한 코드와, 그 코드를 AI로 리팩터링한 코드(`...Refactored.java`)가 있습니다.
리팩터링 코드는 원본 그대로 옮겼고, 머리 주석에 바뀐 점과 남은 문제(⚠)를 정리했습니다.

| 파일 | 문제 |
|---|---|
| [arrays1/ReverseInput.java](assignment/arrays1/ReverseInput.java) · [Refactored](assignment/arrays1/ReverseInputRefactored.java) | 1. 정수 10개를 입력받아 역순 출력 |
| [arrays1/DaysInMonth.java](assignment/arrays1/DaysInMonth.java) · [Refactored](assignment/arrays1/DaysInMonthRefactored.java) | 2. 입력한 달의 날짜 수 (배열을 표로 쓰기, ⚠ 범위 검사) |
| [arrays1/DecimalToBinary.java](assignment/arrays1/DecimalToBinary.java) · [Refactored](assignment/arrays1/DecimalToBinaryRefactored.java) | 3. 10진수 → 2진수 (📝 역순 저장과 index, ⚠ 0·음수 입력) |
| [arrays1/MeanStdDev.java](assignment/arrays1/MeanStdDev.java) | 4. 실수 30개 이하의 평균과 표준편차 (📝 배열이 필요한 이유) |
| [arrays1/RandomFrequency.java](assignment/arrays1/RandomFrequency.java) · [Refactored](assignment/arrays1/RandomFrequencyRefactored.java) | 5. 0 ~ 19 난수 1000개 중 가장 많이 나온 수 (📝 count 배열, ⚠ 숫자 대신 횟수 출력) |
| [arrays2/InventoryArray1D.java](assignment/arrays2/InventoryArray1D.java) · [Refactored](assignment/arrays2/InventoryArray1DRefactored.java) · [💡 2D](assignment/arrays2/InventoryArray2D.java) | 1. 재고 관리를 2차원 배열로 확장 (내가 작성한 것은 1차원 버전, 2차원은 💡 참고 답안) |
| [arrays2/RowColumnSum.java](assignment/arrays2/RowColumnSum.java) · [Refactored](assignment/arrays2/RowColumnSumRefactored.java) | 2. 2차원 배열의 행 합계 · 열 합계 |
| [arrays2/Transpose.java](assignment/arrays2/Transpose.java) · [Refactored](assignment/arrays2/TransposeRefactored.java) | 3. 전치 행렬 (📝 `transpose[col][row] = arr[row][col]`, ⚠ 입력 대신 코드에 직접 작성) |
| [arrays2/MatrixMultiply.java](assignment/arrays2/MatrixMultiply.java) · [Refactored](assignment/arrays2/MatrixMultiplyRefactored.java) | 4. 임의 크기 행렬의 곱셈 (0 ~ 99 난수, 곱할 수 없는 크기 검사) |

## ▶ 실행 방법

모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java examples/ArrayTypicalUsage.java
java practice/arrays1/ContainsValue.java
java quiz/ArrayQuiz.java
java assignment/arrays2/MatrixMultiply.java
```

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다.
실습·과제는 원래 이클립스에서 `Problem.java`, `Main.java`로 작성했던 코드입니다. 여기서는 문제 내용에 맞게 클래스 이름을 바꿨습니다.
