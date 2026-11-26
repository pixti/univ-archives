# 3주차 과제 · conditionals1

[🏠 3주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [MinOfThree.java](#1-3개의-정수-중-최솟값) | 1. 3개의 정수 중 최솟값 |
| [DiscountPrice.java](#2-10개-이상-구매-시-10-할인-기호-상수) | 2. 10개 이상 구매 시 10% 할인 (기호 상수) |
| [ShapeArea.java](#3-도형의-면적-charactertouppercase-mathpi) | 3. 도형의 면적 (`Character.toUpperCase`, `Math.PI`) |

---

## 1. 3개의 정수 중 최솟값

`3강 과제` · 📄 [`MinOfThree.java`](MinOfThree.java)

#### 문제

> 사용자로부터 3개의 정수를 읽어 들인 후에 if-else 문을 사용하여 가장 작은 값을 결정하는 프로그램을 작성하라.

#### 💻 코드

<!-- code: MinOfThree.java -->
```java
import java.util.Scanner;

public class MinOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("3개의 정수를 입력하세요. : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // a가 가장 작은 값인지 확인합니다.
        if (a <= b && a <= c) {
            System.out.print("가장 작은 값 : " + a);
        }
        // a가 가장 작은 값이 아니라면, b가 가장 작은 값인지 확인합니다.
        else if (b <= a && b <= c) {
            System.out.print("가장 작은 값 : " + b);
        }
        // a와 b가 모두 최소값이 아니라면 c가 최소값입니다.
        else {
            System.out.print("가장 작은 값 : " + c);
        }

        sc.close();
    }
}
```
<!-- /code -->

#### 문제의 실행 예

```text
3개의 정수를 입력하세요 (3 4 5) : 7 1 2
가장 작은 값 : 1
```

#### 이 코드 실행 예

```text
3개의 정수를 입력하세요. : 3 2 4
가장 작은 값 : 2
```

**포인트**

- "a 가 b 보다도, c 보다도 작거나 같다" → a &lt;= b && a &lt;= c
- &lt; 가 아니라 &lt;= 를 써야 같은 값이 있을 때 (예: 2 2 5) 도 올바르게 처리된다.
- a 도 b 도 최소가 아니면 남은 c 가 최소 → 마지막은 조건 없이 else.

- 💡 다른 방법 : 최솟값 변수를 하나 두고 차례로 갱신
  ```java
  int min = a;
  if (b < min) min = b;
  if (c < min) min = c;
  ```<br>→ 비교할 수가 늘어나도 if 한 줄씩만 추가하면 된다. (나중에 배열 + 반복문으로 일반화)
- 💡 Math.min(a, Math.min(b, c)) 로도 구할 수 있다.

## 2. 10개 이상 구매 시 10% 할인 (기호 상수)

`3강 과제` · 📄 [`DiscountPrice.java`](DiscountPrice.java)

#### 문제

> 상점에서 하나에 100원인 물건을 판매하고 있다고 가정하자.<br>물건을 10개 이상 구입하는 고객에게는 10%를 할인해준다고 하자.<br>물건의 개수를 입력하면 총액을 계산해 주는 프로그램을 작성하라.

#### 💻 코드

<!-- code: DiscountPrice.java -->
```java
import java.util.Scanner;

public class DiscountPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문제에서 주어진 물건 한 개의 가격
        final int UNIT_PRICE = 100;

        // 10개 이상 구매하면 10% 할인 → 실제 지불 비율은 90%
        final int DISCOUNTED_PERCENT = 90;

        System.out.print("물건의 개수를 입력하세요. : ");
        int count = sc.nextInt();

        int totalPrice;

        // 물건을 10개 이상 구매한 경우 10% 할인합니다.
        if (count >= 10) {
            totalPrice = UNIT_PRICE * count * DISCOUNTED_PERCENT / 100;
        }
        // 10개 미만이면 할인 없이 정가를 적용합니다.
        else {
            totalPrice = UNIT_PRICE * count;
        }

        System.out.print("물건의 전체 가격은 : " + totalPrice + "원 입니다.");
        sc.close();
    }
}
```
<!-- /code -->

#### 문제의 실행 예  (입력 : 10)

```text
물건의 전체 가격은 : 900원입니다.
```

#### 이 코드 실행 예

```text
물건의 개수를 입력하세요. : 12
물건의 전체 가격은 : 1080원 입니다.
```

**포인트**

- final 로 선언한 "기호 상수" (2주차 2-3 참고) 를 사용해 100, 90 같은 숫자에 이름을 붙였다.<br>→ 가격이나 할인율이 바뀌면 상수 한 곳만 고치면 된다.
- 할인율을 0.9 (double) 대신 정수 90 (%) 으로 두고 마지막에 / 100 해서 int 로만 계산했다.

**💡 계산 순서가 중요하다!**

```text
UNIT_PRICE * count * DISCOUNTED_PERCENT / 100   → 왼쪽부터 계산: 100 * 10 * 90 / 100 = 900  (O)
UNIT_PRICE * count * (DISCOUNTED_PERCENT / 100) → 90 / 100 이 정수 나눗셈이라 0 → 결과 0     (X)
```

곱셈을 모두 끝낸 뒤 마지막에 나눠야 정수 나눗셈으로 값이 사라지지 않는다.

## 3. 도형의 면적 (`Character.toUpperCase`, `Math.PI`)

`3강 과제` · 📄 [`ShapeArea.java`](ShapeArea.java)

#### 문제

> 사용자로부터 하나의 문자를 입력받아서 문자가 'R' 이면 사각형의 면적을 계산하고 'T' 이면 삼각형의 면적을, 'C' 이면 원의 면적을 계산한다.<br>면적을 계산하는데 필요한 숫자들은 사용자로부터 입력받는다.<br>→ 실습 조건문2 4번 (3-practice/conditionals2/AreaCalculator.java) 과 같은 문제. 실습 버전과 비교해 보기.

#### 💻 코드

<!-- code: ShapeArea.java -->
```java
import java.util.Scanner;

public class ShapeArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자를 입력하세요 (R, T, C) : ");

        // 입력받은 문자를 대문자로 통일하여 R, T, C 중 하나로 처리합니다.
        char shape = Character.toUpperCase(sc.next().charAt(0));

        switch (shape) {
            case 'R':
                // 사각형의 밑변과 높이를 입력받습니다.
                System.out.print("밑변 길이, 높이를 입력하세요 : ");
                int rectangleBase = sc.nextInt();
                int rectangleHeight = sc.nextInt();

                // 사각형의 면적 = 밑변 × 높이
                double rectangleArea = rectangleBase * rectangleHeight;
                System.out.println("사각형의 면적은 : " + rectangleArea + " 입니다.");
                break;

            case 'T':
                // 삼각형의 밑변과 높이를 입력받습니다.
                System.out.print("밑변 길이, 높이를 입력하세요 : ");
                int triangleBase = sc.nextInt();
                int triangleHeight = sc.nextInt();

                // 삼각형의 면적 = 밑변 × 높이 ÷ 2
                double triangleArea = triangleBase * triangleHeight / 2.0;
                System.out.println("삼각형의 면적은 : " + triangleArea + " 입니다.");
                break;

            case 'C':
                // 원의 반지름을 입력받습니다.
                System.out.print("반지름을 입력하세요 : ");
                int radius = sc.nextInt();

                // 원의 면적 = π × 반지름²
                double circleArea = Math.PI * radius * radius;
                System.out.println("원의 면적은 : " + circleArea + " 입니다.");
                break;

            default:
                // R, T, C 이외의 문자가 입력된 경우입니다.
                System.out.println("잘못된 입력입니다.");
        }

        sc.close();
    }
}
```
<!-- /code -->

#### 문제의 실행 예  (입력 : R, 30 20)

```text
사각형의 면적은 : 600
```

#### 이 코드 실행 예

```text
문자를 입력하세요 (R, T, C) : t
밑변 길이, 높이를 입력하세요 : 20 30
삼각형의 면적은 : 300.0 입니다.
```

**실습 버전에서 달라진 점**

- Character.toUpperCase(...) 로 입력을 대문자로 통일<br>→ case 'R': case 'r': 처럼 대소문자를 둘 다 나열할 필요가 없다.
- 원주율로 3.14 대신 Math.PI 사용 → 더 정확하다.
- 변수 이름을 rectangleBase, triangleBase 처럼 의미가 드러나게 지었다.<br>(switch 전체가 한 블록이라 case 마다 이름이 달라야 하는 것은 실습 때와 같다)

- 💡 sc.next().charAt(0) 의 결과(char)를 바로 Character.toUpperCase() 에 넘겼다.<br>메소드 호출 결과를 다른 메소드의 인수로 바로 쓸 수 있다.
- 💡 rectangleBase \* rectangleHeight 는 int 지만 double 변수에 넣으면서 자동 형변환되어 600.0 으로 출력된다.
- 💡 default 는 마지막이라 break 를 생략했다.

---

[🏠 3주차 학습 가이드](../../README.md)
