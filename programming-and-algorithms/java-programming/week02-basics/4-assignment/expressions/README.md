# 2주차 과제 · expressions

[🏠 2주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [Polynomial.java](#1-다항식-5x³--6x²--8x--2) | 1. 다항식 5x³ + 6x² − 8x + 2 |
| [AverageScore.java](#2-4과목-평균-점수) | 2. 4과목 평균 점수 |
| [FuelEfficiency.java](#3-자동차-연비) | 3. 자동차 연비 |
| [Quadrant.java](#4-사분면-판별-만-사용) | 4. 사분면 판별 (`?:`만 사용) |
| [DigitSplit.java](#5-네-자리-정수의-자릿수-분리) | 5. 네 자리 정수의 자릿수 분리 |

---

## 1. 다항식 5x³ + 6x² − 8x + 2

`2강 과제` · 📄 [`Polynomial.java`](Polynomial.java)

#### 문제

> 사용자로부터 x 의 값을 실수로 입력받아서 다음과 같은 다항식의 값을 구하는 프로그램을 작성하라.
>
> 5x³ + 6x² - 8x + 2

#### 💻 코드

<!-- code: Polynomial.java -->
```java
import java.util.Scanner;

public class Polynomial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("x의 값을 입력하시오:");
        double x = sc.nextDouble();
        sc.close();

        double result = 5 * x * x * x + 6 * x * x - 8 * x + 2;
        // double result = 5 * Math.pow(x, 3) + 6 * Math.pow(x, 2) - 8 * x + 2; // 같은 결과

        System.out.println("값은 " + result + " 입니다.");
    }
}
```
<!-- /code -->

#### 실행 예

```text
x의 값을 입력하시오:3
값은 167.0 입니다.
```

**포인트**

- 자바에는 거듭제곱 연산자가 없다. (파이썬의 \*\* 없음, ^ 는 비트 XOR!)
- x \* x \* x 처럼 곱셈으로 쓰거나 Math.pow(x, 3) 사용

검산 (x = 3)<br>5·3³ + 6·3² - 8·3 + 2 = 5·27 + 6·9 - 24 + 2 = 135 + 54 - 24 + 2 = 167

## 2. 4과목 평균 점수

`2강 과제` · 📄 [`AverageScore.java`](AverageScore.java)

#### 문제

> 어떤 학생이 이번 학기에 컴퓨터 개론, C언어 프로그래밍, 영어, 일반 수학을 수강 신청하였다고 하자.<br>각 과목의 점수를 입력하면 그 학생의 이번 학기 평균 점수를 계산하는 프로그램을 작성하라.

#### 💻 코드

<!-- code: AverageScore.java -->
```java
import java.util.Scanner;

public class AverageScore {
    public static void main(String[] args) {
        final int SUBJECT_COUNT = 4;
        Scanner sc = new Scanner(System.in);

        System.out.print("컴퓨터 개론 과목의 점수를 입력하시오.:");
        int computer = sc.nextInt();
        System.out.print("C언어 프로그래밍 과목의 점수를 입력하시오.:");
        int cLang = sc.nextInt();
        System.out.print("영어 과목의 점수를 입력하시오.:");
        int english = sc.nextInt();
        System.out.print("일반 수학 과목의 점수를 입력하시오.:");
        int math = sc.nextInt();
        sc.close();

        int sum = computer + cLang + english + math;
        double avg = (double) sum / SUBJECT_COUNT;
        System.out.println("평균점수는 " + avg + "점입니다.");
    }
}
```
<!-- /code -->

#### 실행 예

```text
컴퓨터 개론 과목의 점수를 입력하시오.:80
C언어 프로그래밍 과목의 점수를 입력하시오.:90
영어 과목의 점수를 입력하시오.:70
일반 수학 과목의 점수를 입력하시오.:80
평균점수는 80.0점입니다.
```

**포인트**

- sum / 4   → 정수 나눗셈이라 소수점이 버려짐 (예: 합이 321 이면 80.25 가 아니라 80)
- sum / 4.0 → 실수 나눗셈 (321 / 4.0 = 80.25)
- (double) sum / 4 도 가능. 단 (double) (sum / 4) 는 이미 버려진 정수를 실수로 바꿀 뿐이라 틀림!
- 과목 수 4 는 기호 상수로 두면 과목이 늘어날 때 한 곳만 고치면 된다.

## 3. 자동차 연비

`2강 과제` · 📄 [`FuelEfficiency.java`](FuelEfficiency.java)

#### 문제

> 자동차의 연비를 계산하는 프로그램을 작성하여 보자.<br>사용자로부터 출발한 지점의 주행거리계 값과 도착한 지점의 주행거리계 값,<br>그리고 사용한 연료량을 입력 받아 연비를 계산해 주는 프로그램을 작성하시오.
>
> 연비(km/l) = (도착 지점 주행거리계 - 출발 지점 주행거리계) / 사용한 연료량

#### 💻 코드

<!-- code: FuelEfficiency.java -->
```java
import java.util.Scanner;

public class FuelEfficiency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("출발한 지점의 주행거리계.:");
        double start = sc.nextDouble();
        System.out.print("도착한 지점의 주행거리계.:");
        double end = sc.nextDouble();
        System.out.print("사용한 연료: ");
        double fuel = sc.nextDouble();
        sc.close();

        double distance = end - start;       // 실제 주행 거리
        double efficiency = distance / fuel; // 괄호/변수 분리 없이 end - start / fuel 로 쓰면 / 가 먼저 계산되어 틀림!
        System.out.println("연비는 " + efficiency + "km/l입니다.");
    }
}
```
<!-- /code -->

#### 실행 예

```text
출발한 지점의 주행거리계.:1000
도착한 지점의 주행거리계.:1040
사용한 연료: 10
연비는 4.0km/l입니다.
```

## 4. 사분면 판별 (`?:`만 사용)

`2강 과제` · 📄 [`Quadrant.java`](Quadrant.java)

#### 문제

> 조건 연산자 ?: 만을 이용하여 2차원 공간의 x좌표와 y좌표를 입력받아서<br>그 좌표가 속하는 사분면을 출력하는 프로그램을 작성하라.
>
> ```text
> | 좌표의 부호     | 사분면 |
> ```
>
> |-----------------|--------|
>
> ```text
> | x > 0, y > 0    | 1      |
> | x < 0, y > 0    | 2      |
> | x < 0, y < 0    | 3      |
> | x > 0, y < 0    | 4      |
> ```

#### 💻 코드

<!-- code: Quadrant.java -->
```java
import java.util.Scanner;

public class Quadrant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("x좌표를 입력하시오: ");
        int x = sc.nextInt();
        System.out.print("y좌표를 입력하시오: ");
        int y = sc.nextInt();
        sc.close();

        int quadrant = (x > 0) ? ((y > 0) ? 1 : 4)
                               : ((y > 0) ? 2 : 3);

        System.out.println("좌표는 " + quadrant + "사분면입니다.");
    }
}
```
<!-- /code -->

#### 실행 예

```text
x좌표를 입력하시오: 2
y좌표를 입력하시오: 4
좌표는 1사분면입니다.
```

**풀이: 조건 연산자를 중첩해서 사용**

- 먼저 x 의 부호로 (1, 4) 그룹과 (2, 3) 그룹을 나누고
- 각 그룹 안에서 y 의 부호로 사분면을 결정한다.
- 조건 연산자는 오른쪽 → 왼쪽으로 결합하므로 괄호 없이도 동작하지만, 가독성을 위해 괄호를 친다.

참고) x 나 y 가 0 이면 축 위의 점이라 어느 사분면에도 속하지 않는다.<br>문제에서 요구하지 않았으므로 이 풀이에서는 0 을 음수 쪽으로 처리한다.<br>(조건문을 배운 뒤에는 축 위의 점을 따로 처리할 수 있다.)

## 5. 네 자리 정수의 자릿수 분리

`2강 과제` · 📄 [`DigitSplit.java`](DigitSplit.java)

#### 문제

> 10000 보다 작은 정수를 입력받아서 이것을 천의 자리, 백의 자리, 십의 자리, 일의 자리로 분리하여 출력하는 프로그램을 작성하라. 조건문이나 반복문은 사용하지 마시오.

#### 💻 코드

<!-- code: DigitSplit.java -->
```java
import java.util.Scanner;

public class DigitSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하시오.:");
        int n = sc.nextInt();
        sc.close();

        int thousand = n / 1000;
        int hundred = n / 100 % 10;
        int ten = n / 10 % 10;
        int one = n % 10;

        System.out.println("천의 자리: " + thousand);
        System.out.println("백의 자리: " + hundred);
        System.out.println("십의 자리: " + ten);
        System.out.println("일의 자리: " + one);
    }
}
```
<!-- /code -->

#### 실행 예

```text
정수를 입력하시오.:5623
천의 자리: 5
백의 자리: 6
십의 자리: 2
일의 자리: 3
```

#### 📒 해설

풀이: 정수 나눗셈(/)으로 자릿수를 오른쪽으로 밀고, % 10 으로 마지막 한 자리만 꺼낸다.

```text
5623 / 1000      = 5
```

5623 / 100 % 10  = 56 % 10  = 6<br>5623 / 10  % 10  = 562 % 10 = 2

```text
5623 % 10        = 3
```

(/ 와 % 는 우선순위가 같으므로 왼쪽부터 계산 → (n / 100) % 10)

다른 방법: 강의 예제 IntegerToTime 처럼 나머지를 계속 넘겨주는 방식<br>thousand = n / 1000;  n = n % 1000;  hundred = n / 100;  n = n % 100; ...

---

[🏠 2주차 학습 가이드](../../README.md)
