# 5주차 실습 · arrays2

[🏠 5주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [CopyArray.java](#1-반복문으로-배열-복사) | 1. 💡 반복문으로 배열 복사 |
| [CopyStringArray.java](#2-문자열-배열-복사) | 2. 💡 문자열 배열 복사 |
| [SecondLargest.java](#3-두-번째로-큰-요소) | 3. 💡 두 번째로 큰 요소 |
| [SpiralArray.java](#4-n--n-나선형-배열) | 4. 💡 n × n 나선형 배열 |
| [Box2D.java](#6-box53에-입력받아-출력) | 6. `box[5][3]`에 입력받아 출력 |
| [TicTacToe.java](#7-틱택토) | 7. 틱택토 (📝 코드 흐름 설명, ⚠ 개선점) |
| [SeatReservation.java](#8-극장-좌석-예약-10행-8열) | 8. 극장 좌석 예약 (10행 8열) |

---

## 1. 반복문으로 배열 복사

`5강 실습` · 📄 [`CopyArray.java`](CopyArray.java)

#### 문제

> 반복문을 이용하여 배열을 다른 배열로 복사하는 프로그램을 작성하시오.<br>배열 : \[25, 14, 56, 15, 36, 56, 77, 18, 29, 49]
>
> (예시 출력)<br>New Array: \[25, 14, 56, 15, 36, 56, 77, 18, 29, 49]

#### 💻 코드

<!-- code: CopyArray.java -->
```java
import java.util.Arrays;

public class CopyArray {
    public static void main(String[] args) {
        int[] my_arr = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int[] new_arr = new int[my_arr.length];       // 같은 크기의 새 배열

        for (int i = 0; i < my_arr.length; i++) {
            new_arr[i] = my_arr[i];                    // 하나씩 복사
        }

        System.out.println("Original Array: " + Arrays.toString(my_arr));
        System.out.println("New Array: " + Arrays.toString(new_arr));

        my_arr[0] = 0;                                 // 원본을 바꿔도
        System.out.println("원본 my_arr[0] = 0 으로 바꾼 뒤 New Array: " + Arrays.toString(new_arr));
    }
}
```
<!-- /code -->

#### 실행 예

```text
Original Array: [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]
New Array: [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]
원본 my_arr[0] = 0 으로 바꾼 뒤 New Array: [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]
```

#### 📒 해설

- 💡 수업에서 직접 작성한 코드가 없는 문제라 참고용 풀이를 작성했다.

**포인트**

- 같은 크기의 새 배열을 new 로 만든 뒤, 원소를 하나씩 옮긴다. → clone() 이 해 주는 일을 직접 하는 것.
- new\_arr = my\_arr; 로 쓰면 복사가 아니라 "같은 배열 공유" 다. (5-3 강의, 퀴즈 4 · 5번)<br>확인용으로 복사 후 원본을 바꿔도 복사본은 그대로인지 출력했다.

**💡 같은 일을 하는 다른 방법**

```java
int[] b = my_arr.clone();
int[] b = Arrays.copyOf(my_arr, my_arr.length);
System.arraycopy(my_arr, 0, b, 0, my_arr.length);
```

## 2. 문자열 배열 복사

`5강 실습` · 📄 [`CopyStringArray.java`](CopyStringArray.java)

#### 문제

> 문자열 배열을 다른 배열로 복사하는 프로그램을 작성하시오.<br>배열 : \["aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj"]
>
> (예시 출력)<br>복사 배열 : \[aa, bb, cc, dd, ee, ff, gg, hh, ii, jj]

#### 💻 코드

<!-- code: CopyStringArray.java -->
```java
import java.util.Arrays;

public class CopyStringArray {
    public static void main(String[] args) {
        String[] my_arr = {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj"};
        String[] copy = new String[my_arr.length];    // 처음에는 모두 null

        for (int i = 0; i < my_arr.length; i++) {
            copy[i] = my_arr[i];
        }

        System.out.println("원본 배열 : " + Arrays.toString(my_arr));
        System.out.println("복사 배열 : " + Arrays.toString(copy));

        my_arr[0] = "zz";
        System.out.println("원본 my_arr[0] = \"zz\" 로 바꾼 뒤 복사 배열 : " + Arrays.toString(copy));
    }
}
```
<!-- /code -->

#### 실행 예

```text
원본 배열 : [aa, bb, cc, dd, ee, ff, gg, hh, ii, jj]
복사 배열 : [aa, bb, cc, dd, ee, ff, gg, hh, ii, jj]
원본 my_arr[0] = "zz" 로 바꾼 뒤 복사 배열 : [aa, bb, cc, dd, ee, ff, gg, hh, ii, jj]
```

#### 📒 해설

- 💡 수업에서 직접 작성한 코드가 없는 문제라 참고용 풀이를 작성했다.

**포인트**

- 1번(int 배열)과 같은 방법. 타입만 String\[] 이다.
- 문자열 배열은 레퍼런스형 배열이다. 복사되는 것은 각 문자열 객체의 "레퍼런스" 다.<br>(5-1 강의 "레퍼런스형 배열") → 원본과 복사본이 같은 문자열 객체를 가리킨다.
- 그래도 문제가 없는 이유 : String 은 내용을 바꿀 수 없는 객체(immutable)다.<br>my\_arr\[0] = "zz"; 는 "aa" 객체를 고치는 것이 아니라 0번 칸이 새 객체 "zz" 를 가리키게 하는 것.<br>→ 복사본의 0번 칸은 여전히 "aa".

## 3. 두 번째로 큰 요소

`5강 실습` · 📄 [`SecondLargest.java`](SecondLargest.java)

#### 문제

> 배열에서 두 번째로 큰 요소를 찾는 프로그램을 작성하시오.<br>배열 : \[10789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456]
>
> (예시 출력)<br>두 번째 큰 값 : 2458

#### 💻 코드

<!-- code: SecondLargest.java -->
```java
import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] my_arr = {10789, 2035, 1899, 1456, 2013, 1458, 2458,
                        1254, 1472, 2365, 1456, 2165, 1457, 2456};

        // 방법 1) 한 번 훑기
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int e : my_arr) {
            if (e > first) {
                second = first;      // 원래 1등이 2등으로
                first = e;
            } else if (e > second && e != first) {
                second = e;
            }
        }
        System.out.println("두 번째 큰 값 : " + second);

        // 방법 2) 정렬 후 뒤에서 두 번째
        int[] sorted = my_arr.clone();   // 원본을 지키려고 복사본을 정렬
        Arrays.sort(sorted);
        System.out.println("(정렬 방법) 두 번째 큰 값 : " + sorted[sorted.length - 2]);
    }
}
```
<!-- /code -->

#### 실행 예

```text
두 번째 큰 값 : 2458
(정렬 방법) 두 번째 큰 값 : 2458
```

#### 📒 해설

- 💡 수업에서 직접 작성한 코드가 없는 문제라 참고용 풀이를 작성했다.

방법 1) 한 번 훑기 : 1등(first)과 2등(second)을 동시에 기억

  - 새 값이 1등보다 크면 : 원래 1등이 2등으로 밀려나고, 새 값이 1등.  (순서 중요! second = first 먼저)
  - 1등보다는 작고 2등보다 크면 : 2등만 교체.
  - e != first 조건 : 최대값이 두 번 있을 때 그 값이 2등으로 들어가지 않게. ("서로 다른 값 중 두 번째")
  - 시작값은 Integer.MIN\_VALUE (int 의 가장 작은 값) → 어떤 값이 와도 처음에 교체된다.

```text
  e      first   second
10789    10789   MIN
 2035    10789   2035
 1899      (변화 없음)
 ...
 2458    10789   2458
 2365      (변화 없음)  ...
```

방법 2) 정렬 후 뒤에서 두 번째 : 코드는 짧지만 원본 순서가 바뀌고(복사본을 정렬), 최대값이 중복이면 틀린다.

## 4. n × n 나선형 배열

`5강 실습` · 📄 [`SpiralArray.java`](SpiralArray.java)

#### 문제

> n \* n 크기의 나선형(spiral) 배열을 만들어 출력하는 프로그램을 작성하시오.
>
> (예시 출력)<br>Input a number: 5<br>Spiral array becomes:<br>1  2  3  4  5<br>16 17 18 19  6<br>15 24 25 20  7<br>14 23 22 21  8<br>13 12 11 10  9

#### 💻 코드

<!-- code: SpiralArray.java -->
```java
import java.util.Scanner;

public class SpiralArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a number: ");
        int n = sc.nextInt();
        int[][] spiral = new int[n][n];

        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;
        while (num <= n * n) {
            for (int c = left; c <= right; c++) spiral[top][c] = num++;        // ① 위쪽 행 →
            top++;
            for (int r = top; r <= bottom; r++) spiral[r][right] = num++;      // ② 오른쪽 열 ↓
            right--;
            if (top <= bottom) {
                for (int c = right; c >= left; c--) spiral[bottom][c] = num++; // ③ 아래쪽 행 ←
                bottom--;
            }
            if (left <= right) {
                for (int r = bottom; r >= top; r--) spiral[r][left] = num++;   // ④ 왼쪽 열 ↑
                left++;
            }
        }

        System.out.println("Spiral array becomes:");
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.printf("%3d", spiral[r][c]);
            }
            System.out.println();
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
Input a number: 5
Spiral array becomes:
  1  2  3  4  5
 16 17 18 19  6
 15 24 25 20  7
 14 23 22 21  8
 13 12 11 10  9
```

#### 📒 해설

- 💡 수업에서 직접 작성한 코드가 없는 문제라 참고용 풀이를 작성했다.

포인트 : 경계 네 개(top, bottom, left, right)를 좁혀 가며 바깥 테두리부터 한 바퀴씩 채운다.

```text
→ → → → ↓      한 바퀴 =
↑ → → ↓ ↓        ① 위쪽 행     : top 행,    left  → right  채우고 top++
↑ ↑ ⊙ ↓ ↓        ② 오른쪽 열   : right 열,  top   → bottom 채우고 right--
↑ ↑ ← ← ↓        ③ 아래쪽 행   : bottom 행, right → left   채우고 bottom--
↑ ← ← ← ←        ④ 왼쪽 열     : left 열,   bottom → top   채우고 left++
```

- 채울 때마다 num++ (1 부터 n\*n 까지)
- 바깥 while 조건 num &lt;= n \* n : 칸을 다 채우면 끝.
- ③, ④ 앞의 if 검사 : n 이 홀수일 때 마지막 가운데 한 칸에서 같은 칸을 두 번 채우지 않게.
- 출력은 printf("%3d") 로 폭을 맞췄다. (10 이상이 섞이면 자리 맞춤이 필요)

## 6. `box[5][3]`에 입력받아 출력

`5강 실습` · 📄 [`Box2D.java`](Box2D.java)

#### 문제

> ```java
> int box[5][3] 배열에 사용자로부터 값을 입력받아 저장하고 출력하는 프로그램을 작성하시오.
> ```

#### 💻 코드

<!-- code: Box2D.java -->
```java
import java.util.Scanner;

public class Box2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] box = new int[5][3];

        // 5개의 행에 값 입력
        for (int i = 0; i < 5; i++) {
            System.out.print(i + "번째 행의 값 (예: 1 2 3) : ");
            for (int j = 0; j < 3; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        // 배열 출력
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
0번째 행의 값 (예: 1 2 3) : 5 4 5
1번째 행의 값 (예: 1 2 3) : 3 2 1
2번째 행의 값 (예: 1 2 3) : 5 6 9
3번째 행의 값 (예: 1 2 3) : 5 4 3
4번째 행의 값 (예: 1 2 3) : 4 5 2
5 4 5
3 2 1
5 6 9
5 4 3
4 5 2
```

**📝 필기**

이것은 5행 3열의 2차원 배열입니다.

열 0  열 1  열 2

```text
행 0   1     2     3
행 1   4     5     6
행 2   1     2     3
행 3   4     5     6
행 4   7     8     9
```

첫 번째 행의 1 2 3 은

```java
box[0][0] = 1;  box[0][1] = 2;  box[0][2] = 3;
```

으로 저장됩니다. 여기서 중요한 것은 for 문을 두 개 사용하는 것입니다.<br>바깥쪽 i 는 행(row)을 담당하고, 안쪽 j 는 열(column)을 담당합니다.

입력 순서<br>i = 0 → box\[0]\[0], box\[0]\[1], box\[0]\[2]<br>i = 1 → box\[1]\[0], box\[1]\[1], box\[1]\[2]

```text
...
```

i = 4 → box\[4]\[0], box\[4]\[1], box\[4]\[2]

- 💡 한 줄에 "1 2 3" 처럼 공백으로 띄워 입력하면 nextInt() 가 하나씩 차례로 읽는다.<br>(Scanner 는 공백 · 줄바꿈을 구분자로 쓴다. 한 개씩 엔터를 쳐도 같다.)
- 💡 숫자 5, 3 대신 box.length, box\[i].length 를 쓰면 크기를 바꿔도 반복문을 고칠 필요가 없다.

## 7. 틱택토

`5강 실습` · 📄 [`TicTacToe.java`](TicTacToe.java)

#### 문제

> 2차원 배열을 이용하여 틱택토(3목) 게임을 작성하시오.<br>백과 흑이 번갈아 가며 행 번호와 열 번호를 입력해 돌을 놓고, 놓을 때마다 판을 출력한다.

#### 💻 코드

<!-- code: TicTacToe.java -->
```java
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[][] {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        int r, c, row, col, winner;
        char cont = 'y', order = '백';

        do {
            System.out.print(order + "차례입니다. 놓을 위치의 행 번호와 열 번호를 입력하세요. (예 : 0 1) : ");
            r = sc.nextInt();
            c = sc.nextInt();

            // 백돌은 1, 흑돌은 0
            if (order == '백') {
                board[r][c] = 1;
            } else {
                board[r][c] = 0;
            }

            // 바둑판 출력
            for (row = 0; row < board.length; row++) {
                for (col = 0; col < board[row].length; col++) {
                    if (board[row][col] == 0) {
                        System.out.print("■\t");
                    } else if (board[row][col] == 1) {
                        System.out.print("○\t");
                    } else {
                        System.out.print("x\t");
                    }
                }
                System.out.println();
            }

            winner = -1;

            // 가로 검사
            for (row = 0; row < 3; row++) {
                if (board[row][0] != 2 && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                    winner = board[row][0];
                }
            }

            // 세로 검사
            for (col = 0; col < 3; col++) {
                if (board[0][col] != 2 && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                    winner = board[0][col];
                }
            }

            // 왼쪽 위 → 오른쪽 아래 대각선
            if (board[0][0] != 2 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                winner = board[0][0];
            }

            // 오른쪽 위 → 왼쪽 아래 대각선
            if (board[0][2] != 2 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                winner = board[0][2];
            }

            // 승리 여부 확인
            if (winner == 1) {
                System.out.println("백 승리!");
                break;
            } else if (winner == 0) {
                System.out.println("흑 승리!");
                break;
            }

            // 다음 차례로 변경
            if (order == '백') {
                order = '흑';
            } else {
                order = '백';
            }

            System.out.print("계속 하시겠습니까? ('y' or 'n') : ");
            cont = sc.next().charAt(0);
        } while (cont == 'y');

        System.out.println("프로그램 종료.");
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
백차례입니다. 놓을 위치의 행 번호와 열 번호를 입력하세요. (예 : 0 1) : 2 1
x	x	x
x	x	x
x	○	x
계속 하시겠습니까? ('y' or 'n') : y
흑차례입니다. 놓을 위치의 행 번호와 열 번호를 입력하세요. (예 : 0 1) : 2 2
x	x	x
x	x	x
x	○	■
계속 하시겠습니까? ('y' or 'n') : n
프로그램 종료.
```

**판의 값**

2 = 빈칸 (x),  1 = 백돌 (○),  0 = 흑돌 (■)<br>→ 처음에 모든 칸을 2 로 채워 둔다. (new int\[3]\[3] 의 기본값 0 은 흑돌과 겹치기 때문)

**📝 필기**

엄밀한 틱택토는 가로 · 세로 · 대각선으로 3 개가 연속인지 검사해야 합니다.<br>3 × 3 에서 대각선은 딱 2 개뿐입니다.<br>왼쪽 위 → 오른쪽 아래 : board\[0]\[0], board\[1]\[1], board\[2]\[2]<br>오른쪽 위 → 왼쪽 아래 : board\[0]\[2], board\[1]\[1], board\[2]\[0]

여기서 != 2 가 중요합니다. 0 = 흑, 1 = 백, 2 = 빈칸 이므로<br>빈칸도 2 == 2 == 2 가 되어 승리로 판정되는 것을 막아야 합니다.

행 / 열까지 합치면

```java
// 가로 검사
for (row = 0; row < 3; row++)
    if (board[row][0] != 2 && board[row][0] == board[row][1] && board[row][1] == board[row][2])
        winner = board[row][0];
// 세로 검사
for (col = 0; col < 3; col++)
    if (board[0][col] != 2 && board[0][col] == board[1][col] && board[1][col] == board[2][col])
        winner = board[0][col];
// 대각선 두 개는 직접 적기
```

특히 대각선은 일반적인 for 문으로 처리하려고 하기보다, 지금 단계에서는 위처럼 두 경우를 직접 적는 게 이해하기 쉽습니다. 나중에 익숙해지면 대각선도<br>board\[i]\[i], board\[i]\[2-i] 형태로 for 문 하나씩 처리할 수 있습니다.

**포인트**

- a == b && b == c : 세 개가 같다. (a == b == c 는 자바에서 안 된다. a == b 의 결과가 boolean 이라서)
- winner = -1 로 시작 : 아무도 이기지 않았다는 표시. (0 과 1 은 돌 값이라 쓸 수 없음)
- 승부가 나면 break 로 do-while 을 빠져나온다.
- 차례 바꾸기 : order 가 '백' 이면 '흑', 아니면 '백'.  (char 에 한글 한 글자도 들어간다)

- ⚠ 보완하면 좋을 점 (원래 코드 그대로 두었다)
  - 이미 돌이 있는 칸에 놓으면 그대로 덮어쓴다. → if (board\[r]\[c] != 2) { "이미 놓인 자리" ; continue; }
  - 0 \~ 2 밖의 번호를 넣으면 ArrayIndexOutOfBoundsException 으로 프로그램이 끝난다.
  - 9 칸이 다 차도 승부가 안 나면(무승부) 판정이 없다. 놓은 횟수를 세서 9 가 되면 "무승부".
  - 승부가 날 때까지 매 턴 "계속 하시겠습니까?" 를 묻는다. 게임으로는 어색하지만 문제의 형식을 따른 것.

## 8. 극장 좌석 예약 (10행 8열)

`5강 실습` · 📄 [`SeatReservation.java`](SeatReservation.java)

#### 문제

> 극장 좌석 예약 프로그램을 작성하시오.
>
> - 좌석은 10 행 8 열의 2차원 배열로 표현하고 0 으로 초기화한다.
> - 예약된 좌석은 1 로 바꾼다.
> - 좌석이 모두 예약되면 만석이라는 메시지를 출력한다.
> - (문제의 안내 문구) 예약할 좌석의 번호를 입력하시오((1\~10) (1\~8))(종료 -1)

#### 💻 코드

<!-- code: SeatReservation.java -->
```java
import java.util.Scanner;

public class SeatReservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] seats = new int[10][8];
        int r, c, row, col;

        // 초기화
        for (r = 0; r < seats.length; r++) {
            for (c = 0; c < seats[r].length; c++) {
                seats[r][c] = 0;
            }
        }

        do {
            // 현황 출력
            int cut = 0;
            for (r = 0; r < seats.length; r++) {
                for (c = 0; c < seats[r].length; c++) {
                    System.out.print(seats[r][c] + " ");
                    if (seats[r][c] == 1) {
                        cut++;
                    }
                }
                System.out.println();
            }

            // 만석 확인
            if (cut == seats.length * seats[0].length) {
                System.out.println("만석입니다.");
                break;
            }

            // 좌석 번호 입력 받기
            System.out.print("좌석 번호를 입력하세요 (-1 종료) : ");
            row = sc.nextInt();
            col = sc.nextInt();
            if (row == -1 || col == -1) {
                break;
            }

            row = row - 1;
            col = col - 1;

            if (seats[row][col] == 1) {
                System.out.println("이미 예약된 좌석입니다.");
            } else {
                seats[row][col] = 1;
                System.out.println("예약되었습니다.");
            }
        } while (true);
    }
}
```
<!-- /code -->

#### 실행 예  (중간 좌석 출력은 일부 생략)

```text
0 0 0 0 0 0 0 0
... (10 줄)
좌석 번호를 입력하세요 (-1 종료) : 2 1
예약되었습니다.
0 0 0 0 0 0 0 0
1 0 0 0 0 0 0 0
...
좌석 번호를 입력하세요 (-1 종료) : 1 6
예약되었습니다.
0 0 0 0 0 1 0 0
1 0 0 0 0 0 0 0
...
좌석 번호를 입력하세요 (-1 종료) : -1 -1
```

**포인트**

- 매 반복마다 : 현황 출력 (+ 예약된 좌석 수 세기) → 만석 확인 → 입력 → 예약
- 만석 판정 : 예약된 좌석 수 == 전체 좌석 수 (seats.length \* seats\[0].length = 10 \* 8 = 80)<br>→ 현황을 출력하는 이중 for 안에서 1 을 같이 세면 반복문을 한 번 더 돌 필요가 없다.
- 사람은 1 번부터 세고 배열은 0 번부터 → row - 1, col - 1 로 바꿔서 접근.
- 이미 1 인 자리는 "이미 예약된 좌석입니다." (덮어쓰지 않음)
- while (true) + break : 끝나는 조건(만석, -1)이 반복문 중간에 있어서.

- ⚠ 보완하면 좋을 점 (원래 코드 그대로 두었다)
  - 종료하려고 -1 하나만 입력하면, 두 번째 nextInt() 가 숫자를 하나 더 기다린다.<br>(-1 -1 처럼 두 개를 넣어야 바로 끝난다) → row 를 읽자마자 -1 인지 먼저 검사하면 된다.
  - 1 \~ 10, 1 \~ 8 밖의 번호를 넣으면 ArrayIndexOutOfBoundsException.
  - 변수 이름 cut 은 count(개수)의 오타로 보인다.
  - new int\[10]\[8] 은 이미 0 으로 채워져 있어서 초기화 반복문은 없어도 된다.<br>(문제가 "0 으로 초기화" 를 요구해서 넣은 것)
  - sc.close() 가 없다.
  - 입력 안내 문구는 문제와 다르게 "좌석 번호를 입력하세요 (-1 종료) : " 로 줄였다.

---

[🏠 5주차 학습 가이드](../../README.md)
