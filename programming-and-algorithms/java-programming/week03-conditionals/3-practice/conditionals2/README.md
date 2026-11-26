# 3주차 실습 · conditionals2

[🏠 3주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [StandardWeight.java](#1-표준-체중-비교) | 1. 표준 체중 비교 |
| [AgeCalculator.java](#2-만-나이-계산-중첩-if) | 2. 만 나이 계산 (중첩 if) |
| [IncomeTax.java](#3-소득세-계산-강제-형변환-필기) | 3. 소득세 계산 (강제 형변환 필기) |
| [AreaCalculator.java](#4-도형의-면적-switch-변수-범위) | 4. 도형의 면적 (switch, 변수 범위) |

---

## 1. 표준 체중 비교

`3강 실습` · 📄 [`StandardWeight.java`](StandardWeight.java)

#### 문제

> if 문을 사용하여 사용자로부터 키를 입력받아서 표준 체중을 계산한 후에<br>사용자의 체중과 비교하여 저체중인지, 표준인지, 과체중인지를 판단하는 프로그램을 작성하라.
>
> - 표준 체중 계산식 : 표준 체중 = (키 - 100) \* 0.9
> - 표준 체중의 105% 초과이면 과체중
> - 표준 체중의 95% 미만이면 저체중
> - 95% 이상 105% 이하이면 표준 체중

#### 💻 코드

<!-- code: StandardWeight.java -->
```java
import java.util.Scanner;

public class StandardWeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("키 ? : ");
        int height = sc.nextInt();
        System.out.print("몸무게 ? : ");
        int weight = sc.nextInt();
        sc.close();

        double stdWeight = (height - 100) * 0.9;     // 표준 체중

        if (weight > stdWeight * 1.05) {             // 105% 초과
            System.out.println("과체중 입니다.");
        }
        else if (weight < stdWeight * 0.95) {        // 95% 미만
            System.out.println("저체중 입니다.");
        }
        else {                                       // 95% 이상 105% 이하
            System.out.println("표준체중 입니다.");
        }
    }
}
```
<!-- /code -->

#### 문제의 실행 예  (입력 : 키 180, 몸무게 90)

```text
알림>과체중입니다.
```

#### 이 코드 실행 예

```text
키 ? : 180
몸무게 ? : 80
과체중 입니다.          (표준 체중 72kg, 105% = 75.6kg 초과)
```

**포인트**

- 105% → \* 1.05, 95% → \* 0.95 로 바꿔서 비교한다.
- 과체중(초과), 저체중(미만) 을 먼저 거르면, 나머지(else)는 자동으로 "95% 이상 105% 이하" 가 된다.<br>→ 표준 체중 조건 (weight >= std \* 0.95 && weight &lt;= std \* 1.05) 을 따로 쓸 필요가 없다.

- 💡 (height - 100) \* 0.9 : int \* double 이므로 결과는 double (자동 형변환).

## 2. 만 나이 계산 (중첩 if)

`3강 실습` · 📄 [`AgeCalculator.java`](AgeCalculator.java)

#### 문제

> 사용자가 생일과 현재 날짜를 입력하면 만으로 몇 살인지를 계산해주는 프로그램을 작성하여 보자.

#### 💻 코드

<!-- code: AgeCalculator.java -->
```java
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("생년월일 입력 : ");
        int b_year = sc.nextInt();
        int b_month = sc.nextInt();
        int b_day = sc.nextInt();

        System.out.print("현재 날짜 입력 : ");
        int c_year = sc.nextInt();
        int c_month = sc.nextInt();
        int c_day = sc.nextInt();
        sc.close();

        int age;
        if (b_month > c_month) {                 // 생일이 있는 달이 아직 안 옴
            age = c_year - b_year - 1;
        }
        else if (b_month < c_month) {            // 생일이 있는 달이 지남
            age = c_year - b_year;
        }
        else {                                   // 생일이 있는 달 → 일까지 비교
            if (b_day > c_day) {
                age = c_year - b_year - 1;
            }
            else {
                age = c_year - b_year;
            }
        }

        System.out.print("당신의 나이는 만 " + age + "세 입니다.");
    }
}
```
<!-- /code -->

#### 이 코드 실행 예

```text
생년월일 입력 : 2002 03 01
현재 날짜 입력 : 2026 09 17
당신의 나이는 만 24세 입니다.
```

**풀이 (중첩 if)**

- 기본 나이 = 현재 연도 - 태어난 연도
- 올해 생일이 아직 안 지났으면 1 을 뺀다.
  ```text
  태어난 달 > 현재 달                 → 생일 안 지남 → -1
  태어난 달 < 현재 달                 → 생일 지남
  ```<br>같은 달이면 일(day)까지 비교
  ```text
  태어난 날 > 현재 날               → 생일 안 지남 → -1
  그 외 (생일 당일 포함)             → 생일 지남
  ```

- ⚠ 문제의 실행 예는 "당신의 나이는 : 20" 이지만,<br>1990\.10.12 생은 2010.9.17 에 아직 생일(10월)이 지나지 않았으므로 만 나이는 19세가 맞다.<br>(2010 - 1990 - 1 = 19)

- 💡 age 를 선언만 하고 초기화하지 않았지만 컴파일 에러가 나지 않는다.<br>if - else if - else 의 모든 갈래에서 age 에 값을 대입하기 때문이다. (확정 대입)
- 💡 조건을 하나로 합쳐 쓸 수도 있다.
  ```java
  int age = c_year - b_year;
  if (b_month > c_month || (b_month == c_month && b_day > c_day)) age--;
  ```

문제의 실행 예  (입력 : 생일 1990 10 12, 현재 날짜 2010 9 17)

```text
당신의 나이는 : 20       ⚠ 위에서 설명한 대로 19 가 맞다
```

## 3. 소득세 계산 (강제 형변환 필기)

`3강 실습` · 📄 [`IncomeTax.java`](IncomeTax.java)

#### 문제

> 월급에 붙는 소득세를 계산하여 보자.
>
> - 1000만원 이하                 : 8%
> - 1000만원 초과 4000만원 이하   : 17%
> - 4000만원 초과 8000만원 이하   : 26%
> - 8000만원 초과                 : 35%

#### 💻 코드

<!-- code: IncomeTax.java -->
```java
import java.util.Scanner;

public class IncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("연봉 입력 : ? 만원 ");
        int income = sc.nextInt();
        sc.close();

        int tax = 0;
        if (income > 8000) {
            tax = (int) (income * 0.35);     // 📝 0.35 는 double → 강제 형변환
        }
        else if (income > 4000) {
            tax = (int) (income * 0.26);
        }
        else if (income > 1000) {
            tax = (int) (income * 0.17);
        }
        else {
            tax = (int) (income * 0.08);
        }

        System.out.print("소득세는 " + tax + "만원 입니다.");
    }
}
```
<!-- /code -->

#### 문제의 실행 예  (입력 : 7600)

```text
1976
```

#### 이 코드 실행 예

```text
연봉 입력 : ? 만원 7000
소득세는 1820만원 입니다.
```

**📝 필기**

- 강제 형변환 필요함. 0.35 는 double 임, tax 는 int 임.<br>→ income \* 0.35 는 int \* double = double 이라서 int 변수에 그냥 넣으면 컴파일 에러.<br>(int) (income \* 0.35) 로 강제 형변환해야 한다. (소수점 아래는 버려진다)

**포인트**

- 큰 구간부터 검사한다 (> 8000 → > 4000 → > 1000 → 나머지).<br>위에서 이미 걸러졌으므로 "4000만원 초과 8000만원 이하" 를 income > 4000 하나로 쓸 수 있다.<br>(퀴즈 3-② 와 같은 이야기 : else if 는 조건의 순서가 중요하다)

- 💡 문제의 예(7600 → 1976 = 7600 \* 0.26)처럼 "전체 금액에 한 세율" 을 적용했다.<br>실제 소득세는 구간별로 나눠 계산하는 누진세라 결과가 다르다.
- 💡 문제는 "월급" 이라고 했지만 금액 단위상 연봉으로 보고 안내문을 "연봉 입력" 으로 썼다.
- 💡 (int) income \* 0.35 처럼 괄호 없이 쓰면 income 만 int 로 바뀌고 결과는 여전히 double 이라 에러.<br>곱셈 전체를 괄호로 감싸야 한다.

## 4. 도형의 면적 (switch, 변수 범위)

`3강 실습` · 📄 [`AreaCalculator.java`](AreaCalculator.java)

#### 문제

> 사용자로부터 하나의 문자를 입력받아서 문자가 'R' 이면 사각형의 면적을 계산하고 'T' 이면 삼각형의 면적을, 'C' 이면 원의 면적을 계산한다.<br>면적을 계산하는데 필요한 숫자들은 사용자로부터 입력받는다. switch 문을 사용하도록 한다.

#### 💻 코드

<!-- code: AreaCalculator.java -->
```java
import java.util.Scanner;

public class AreaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("원하는 메뉴 (R, T, C) ? ");
        char c = sc.next().charAt(0);

        switch (c) {
            case 'R':
            case 'r':
                System.out.print("밑변, 높이 ? ");
                int r_width = sc.nextInt();
                int r_height = sc.nextInt();
                System.out.println("사각형의 면적은 : " + (r_width * r_height) + " 입니다.");
                break;
            case 'T':
            case 't':
                System.out.print("밑변, 높이 ? ");
                int t_width = sc.nextInt();
                int t_height = sc.nextInt();
                System.out.println("삼각형의 면적은 : " + (t_width * t_height / 2.0) + " 입니다.");
                break;
            case 'C':
            case 'c':
                System.out.print("반지름 ? ");
                int radius = sc.nextInt();
                System.out.println("원의 면적은 : " + (3.14 * (radius * radius)) + " 입니다.");
                break;
            default:
                System.out.println("잘못된 입력.");
                break;
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
원하는 메뉴 (R, T, C) ? c
반지름 ? 5
원의 면적은 : 78.5 입니다.
```

**포인트**

- case 'R': case 'r': 처럼 break 없이 나열해서 대문자와 소문자를 같이 처리했다. (fall-through)
- 삼각형 : 밑변 \* 높이 / 2.0<br>→ / 2 로 쓰면 int 끼리의 나눗셈이라 소수점이 버려진다. (3 \* 5 / 2 = 7)

- 💡 case 마다 변수 이름을 r\_width, t\_width 처럼 다르게 지은 이유<br>switch 문 전체가 하나의 블록 { } 이라서, case 아래에서 선언한 변수의 범위는 switch 전체이다.<br>다른 case 에서 같은 이름(width)으로 또 선언하면 "이미 정의된 변수" 컴파일 에러가 난다.<br>case 'R': { int width = ...; ... break; } 처럼 case 마다 { } 로 감싸면 같은 이름을 써도 된다.
- 💡 3.14 대신 Math.PI (3.141592653589793) 를 쓰면 더 정확하다. (과제 ShapeArea.java 에서 사용)
- 💡 radius \* radius 는 int 지만 3.14 \* (int) 는 double 이 되어 78.5 처럼 소수점까지 출력된다.

---

[🏠 3주차 학습 가이드](../../README.md)
