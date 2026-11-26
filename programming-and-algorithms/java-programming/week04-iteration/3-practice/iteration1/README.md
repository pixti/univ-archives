# 4주차 실습 · iteration1

[🏠 4주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [ArithmeticMean.java](#1-음수가-입력될-때까지-산술-평균-while-0으로-나누기-방지) | 1. 음수가 입력될 때까지 산술 평균 (while, 0으로 나누기 방지) |
| [FuelEfficiency.java](#2-연비-계산-반복-do-while이-어울리는-이유) | 2. 연비 계산 반복 (do-while이 어울리는 이유) |
| [Permutation.java](#3-순열-npr-while) | 3. 순열 nPr (while) |
| [Pyramid.java](#4-피라미드-출력-중첩-while-안쪽-변수-초기화) | 4. 피라미드 출력 (중첩 while, 안쪽 변수 초기화) |

---

## 1. 음수가 입력될 때까지 산술 평균 (while, 0으로 나누기 방지)

`4강 실습` · 📄 [`ArithmeticMean.java`](ArithmeticMean.java)

#### 문제

> ※ 반복 시 while 이나 do while 문만 사용하시오.
>
> 사용자로부터 일련의 데이터를 입력받아서 산술 평균을 구하는 프로그램을 작성하여 보자.<br>음수가 입력되면 데이터의 끝이라고 간주한다.
>
> 산술 평균 : (x1 + x2 + ... + xn) / n

#### 💻 코드

<!-- code: ArithmeticMean.java -->
```java
import java.util.Scanner;

public class ArithmeticMean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sum = 0;     // 누적합
        int count = 0;      // 카운트

        System.out.print("값 ? ");  // 음수면 종료
        int x = sc.nextInt();       // 첫 값 x 읽기

        while (x >= 0) {            // 음수가 아니면 계속
            sum += x;
            count++;
            x = sc.nextInt();       // 다음 값 읽기 (음수 입력 받을 수 있어서 무한 루프가 아님)
        }

        if (count != 0) {           // ⚠ 추가 : 첫 입력이 음수일 때 NaN 방지
            double avg = sum / (double) count;
            System.out.println("산술 평균 : " + avg);
        }
        else {
            System.out.println("입력된 데이터가 없습니다.");
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 문제의 실행 예

```text
(없음 - 수식만 주어짐)
```

#### 실행 예

```text
값 ? 2
3
4
-1
산술 평균 : 3.0
```

**📝 필기 (코드 주석)**

- double sum = 0;  // 누적합
- int count = 0;   // 카운트
- print("값 ? ");  // 음수면 종료
- int x = sc.nextInt();  // 첫 값 x 읽기
- while (x >= 0) {       // 음수가 아니면 계속
- x = sc.nextInt();      // 다음 값 읽기 (음수 입력 받을 수 있어서 무한 루프가 아님)

**포인트**

- 입력 → 검사 → 처리 → 다시 입력 (4-1 성적 처리와 같은 구조)<br>첫 값은 반복문 밖에서 읽고, 블록 마지막에서 다음 값을 읽는다.<br>→ 종료 신호인 음수가 합계에 섞이지 않는다.
- 반복 횟수가 정해지지 않았다 (음수가 언제 들어올지 모름) → while.
- sum / (double) count : 실수 나눗셈. (sum 이 이미 double 이라 사실 형변환 없이도 실수 결과)

- ⚠ 처음부터 음수를 넣으면 count = 0 → 0.0 / 0.0 = NaN 이 출력된다.<br>4-1 성적 처리처럼 if (count != 0) 으로 막았다.
- 💡 Scanner 는 공백이나 줄바꿈으로 값을 나누므로 "2 3 4 -1" 처럼 한 줄에 넣어도 된다.

## 2. 연비 계산 반복 (do-while이 어울리는 이유)

`4강 실습` · 📄 [`FuelEfficiency.java`](FuelEfficiency.java)

#### 문제

> ※ 반복 시 while 이나 do while 문만 사용하시오.
>
> 자동차의 연비를 반복적으로 계산해주는 프로그램을 작성하여 보자.

#### 💻 코드

<!-- code: FuelEfficiency.java -->
```java
import java.util.Scanner;

public class FuelEfficiency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fuel, distance; double ratio; char cont;
        do {
            System.out.print("연료의 양 ? ");
            fuel = sc.nextInt();
            System.out.print("주행한 거리 ? ");
            distance = sc.nextInt();
            ratio = distance / (double) fuel;
            System.out.println("연비는 " + ratio + " 입니다.");

            System.out.print("계속 진행 ? (Y/N) : ");
            cont = sc.next().charAt(0);
        } while (cont == 'Y' || cont == 'y');   // True이면 반복 False이면 do-while문 빠져나옴.
        System.out.println("프로그램 종료");
        sc.close();
    }
}
```
<!-- /code -->

#### 문제의 실행 예

```text
연료의 양을 입력하시오(l) : 10
주행한 거리를 입력하세요(km) : 100
연비는  10km/l 입니다.
다시 계산하겠습니까?(Y/N) : N
```

#### 실행 예

```text
연료의 양 ? 10
주행한 거리 ? 5000
연비는 500.0 입니다.
계속 진행 ? (Y/N) : n
프로그램 종료
```

**📝 필기**

- 반복 횟수가 일정하지 않으므로 for 보단 while 이 적절하고.<br>무조건 1번은 실행되므로 do while 이 적절하다.
- } while (cont == 'Y' || cont == 'y');  // True 이면 반복 False 이면 do-while 문 빠져나옴.

**포인트**

- 연비 = 주행 거리 / 연료의 양 (km/l)
- distance / (double) fuel : 둘 다 int 라서 형변환하지 않으면 정수 나눗셈이 된다.<br>(예 : 100 / 30 = 3, 소수점 버림)
- 대문자 'Y' 와 소문자 'y' 를 모두 받기 위해 || 로 묶었다.
- 💡 do-while 이라 cont 를 미리 초기화할 필요가 없다 (4-2 강의 내용).

- 💡 fuel 에 0 을 넣으면 distance / 0.0 = Infinity 가 출력된다. (실수 나눗셈은 예외 대신 Infinity)

## 3. 순열 nPr (while)

`4강 실습` · 📄 [`Permutation.java`](Permutation.java)

#### 문제

> ※ 반복 시 while 이나 do while 문만 사용하시오.
>
> 서로 다른 n 개에서 r 개를 택하여 일렬로 나열할 수 있는 경우의 수를 순열(permutation)이라 하고, nPr 로 표시한다. 순열은 아래의 수식에 의해 구할 수 있는데, 이를 프로그램으로 작성하라.<br>n 과 r 은 사용자로부터 입력 받도록 한다.
>
> nPr = n(n-1) ... (n-(r-1))

#### 💻 코드

<!-- code: Permutation.java -->
```java
import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n ? ");
        int n = sc.nextInt();
        System.out.print("r ? ");
        int r = sc.nextInt();
        sc.close();

        int prod = 1, i = 0;
        while (i < r) {             // ( i <= r-1 ) 과 동일한 의미.
            prod *= (n - i);        // prod = prod * (n - i); 과 동일한 의미.
            i++;
        }
        System.out.println(n + "P" + r + " : " + prod);
    }
}
```
<!-- /code -->

#### 문제의 실행 예

```text
순열의 n값과 r값을 입력하시오 : 3 2
3P2순열의 값은 6입니다.
```

#### 실행 예

```text
n ? 5
r ? 3
5P3 : 60
```

**📝 필기 (코드 주석)**

- while (i &lt; r)          // ( i &lt;= r-1 ) 과 동일한 의미.
- prod \*= (n - i);       // prod = prod \* (n - i); 과 동일한 의미.

**포인트**

- 곱하는 항은 n - 0, n - 1, ..., n - (r-1) → 총 r 개.<br>i 를 0 \~ r-1 로 돌리면서 (n - i) 를 곱한다.
- 곱이므로 prod 는 1 로 초기화 (퀴즈 3번 Π → prod = 1).

- 💡 r = 0 이면 반복을 한 번도 안 돌아 prod = 1 (nP0 = 1, 수학적으로도 맞다).
- 💡 n, r 이 크면 int 오버플로 (4-3 팩토리얼 참고). 예 : 20P15 는 int 범위를 넘는다.

## 4. 피라미드 출력 (중첩 while, 안쪽 변수 초기화)

`4강 실습` · 📄 [`Pyramid.java`](Pyramid.java)

#### 문제

> ※ 반복 시 while 이나 do while 문만 사용하시오.
>
> 아래와 같은 모양을 출력하는 프로그램을 작성하시오. 중첩 반복문을 사용토록 한다.<br>한 개의 공백과 한 개의 '\*' 를 출력하는 문을 반복 사용하여 작성하여야 한다.
>
> \*<br>\*\*\*<br>\*\*\*\*\*<br>\*\*\*\*\*\*\*

#### 💻 코드

<!-- code: Pyramid.java -->
```java
public class Pyramid {
    public static void main(String[] args) {
        int start = 3, end = 3, row = 0, col = 0;
        while (row < 4) {           // row : 0~3까지 반복
            col = 0;                // col 6까지 순회 -> 다음 행 시작시 col 0으로 초기화

            while (col < 7) {       // col : 0~6까지 열 반복하여 한 행 처리
                if (start <= col && col <= end) {
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
                col++;
            }
            start--;
            end++;
            System.out.println();
            row++;
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
   *
  ***
 *****
*******
```

**📝 필기**

- start 위치와 end 위치가 달라지는 것.
- 3,3 -> 2,4 -> 1,5 -> 0,6 의 발상.
- (코드 주석) while (row &lt; 4)  // row : 0\~3까지 반복
- (코드 주석) col = 0;         // col 6까지 순회 -> 다음 행 시작시 col 0으로 초기화
- (코드 주석) while (col &lt; 7)  // col : 0\~6까지 열 반복하여 한 행 처리

**💡 발상 정리**

폭이 7칸(열 0 \~ 6)인 판에 4줄(행 0 \~ 3)을 찍는다. 각 행에서 '\*' 가 찍히는 열의 구간은

```text
열 :  0 1 2 3 4 5 6       start, end
0행         *              3, 3
1행       * * *            2, 4
2행     * * * * *          1, 5
3행   * * * * * * *        0, 6
```

→ 행이 하나 내려갈 때마다 start 는 1 감소, end 는 1 증가.<br>→ 각 칸(col)이 start &lt;= col &lt;= end 이면 '\*', 아니면 ' ' 를 찍는다.

- 💡 col = 0; 을 바깥 while 안에서 해 주는 것이 핵심.<br>while 은 for 와 달리 초기식이 따로 없어서, 이걸 빼먹으면 두 번째 행부터<br>col 이 이미 7 이라 안쪽 while 이 한 번도 돌지 않는다. (빈 줄만 3개 나옴)<br>→ NumberGuessingRepeat 의 cont = true; , 퀴즈 3번 안쪽 sum = 0; 과 같은 이야기.
- 💡 오른쪽 공백(end 뒤)도 찍히지만 화면에서는 보이지 않는다.

---

[🏠 4주차 학습 가이드](../../README.md)
