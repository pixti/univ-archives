# 2주차 실습 · expressions

[🏠 2주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [BoxVolume.java](#1-상자의-체적) | 1. 상자의 체적 |
| [PyungToSquareMeter.java](#2-평---기호-상수) | 2. 평 → ㎡ (기호 상수) |
| [TimeToSeconds.java](#3-시분초--초) | 3. 시·분·초 → 초 |
| [Savings.java](#4-2년-후-예금액-복리) | 4. 2년 후 예금액 (복리) |
| [QuadraticEquation.java](#5-2차-방정식의-근) | 5. 2차 방정식의 근 |

---

## 1. 상자의 체적

`2강 실습` · 📄 [`BoxVolume.java`](BoxVolume.java)

#### 문제

> 상자의 높이, 너비, 길이를 입력받아 체적(부피)을 구하는 프로그램

#### 💻 코드

<!-- code: BoxVolume.java -->
```java
import java.util.Scanner;

public class BoxVolume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("높이 ? ");
        int height = sc.nextInt();
        System.out.print("너비 ? ");
        int width = sc.nextInt();
        System.out.print("길이 ? ");
        int length = sc.nextInt();
        sc.close();

        int volume = height * width * length;
        System.out.println("상자의 체적은 " + volume + " 입니다.");
    }
}
```
<!-- /code -->

#### 실행 예

```text
높이 ? 5
너비 ? 4
길이 ? 8
상자의 체적은 160 입니다.
```

**📝 필기**

- import 없이 Scanner 를 쓰면 빨간 줄이 생긴다.<br>마우스를 올려서 나오는 빠른 수정 목록 중 맨 위의 "'Scanner' (java.util) 가져오기" 를 선택하면 맨 위에 import java.util.Scanner; 가 자동으로 추가된다.

## 2. 평 → ㎡ (기호 상수)

`2강 실습` · 📄 [`PyungToSquareMeter.java`](PyungToSquareMeter.java)

#### 문제

> 평수를 입력받아 제곱미터(㎡)로 변환하는 프로그램 (1평 = 3.3058㎡)

#### 💻 코드

<!-- code: PyungToSquareMeter.java -->
```java
import java.util.Scanner;

public class PyungToSquareMeter {
    public static void main(String[] args) {
        final float PYUNG = 3.3058f; // final 은 상수 선언. float 이므로 f 필수
        Scanner sc = new Scanner(System.in);

        System.out.print("평수 ? ");
        int pyung = sc.nextInt();
        sc.close();

        float area = PYUNG * pyung; // float * int → float (int 가 float 로 자동 형변환)
        System.out.println(pyung + "평은 " + area + "평방미터 입니다.");
    }
}
```
<!-- /code -->

#### 실행 예

```text
평수 ? 12
12평은 39.6696평방미터 입니다.
```

**📝 필기**

- final 은 상수 선언. 한 번 값을 정하면 바꿀 수 없다.
- ★ 기호 상수가 왜 좋은가?<br>→ 같은 값이 여러 군데 쓰일 때, 여러 군데를 찾아가며 수정하기보다 한 곳(상수 선언부)에서만 수정하면 된다.
- 상수 선언은 앞줄에 하는 것이 관례 (변수나 기호 상수 선언들은 위쪽에 모아 둔다).
- 상수 이름은 보통 대문자로 쓴다. (PYUNG)

## 3. 시·분·초 → 초

`2강 실습` · 📄 [`TimeToSeconds.java`](TimeToSeconds.java)

#### 문제

> 시, 분, 초를 입력받아 전체 몇 초인지 계산하는 프로그램
>
> 전체 초 = 시 \* 3600 + 분 \* 60 + 초<br>(강의 예제 IntegerToTime 의 반대 방향 변환)

#### 💻 코드

<!-- code: TimeToSeconds.java -->
```java
import java.util.Scanner;

public class TimeToSeconds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("몇 시 ? ");
        int hour = sc.nextInt();
        System.out.print("몇 분 ? ");
        int min = sc.nextInt();
        System.out.print("몇 초 ? ");
        int sec = sc.nextInt();
        sc.close();

        // 💡 final int TIME = hour*3600 + min*60 + sec; 처럼 써도 컴파일은 된다.
        //    final 을 붙이면 이후 값을 바꿀 수 없는 지역 상수가 된다.
        // 다만 입력에 따라 매번 달라지는 "계산 결과"이므로 일반 변수(소문자 이름)로 두는 편이 관례에 더 맞다.
        // 1시간 = 3600초, 1분 = 60초 처럼 고정된 값을 기호 상수로 만드는 것이 기호 상수의 원래 용도.
        final int SEC_PER_HOUR = 3600;
        final int SEC_PER_MIN = 60;
        int total = hour * SEC_PER_HOUR + min * SEC_PER_MIN + sec;

        System.out.println(hour + "시간 " + min + "분 " + sec + "초는 " + total + "초입니다.");
    }
}
```
<!-- /code -->

#### 실행 예

```text
몇 시 ? 12
몇 분 ? 23
몇 초 ? 56
12시간 23분 56초는 44636초입니다.
```

## 4. 2년 후 예금액 (복리)

`2강 실습` · 📄 [`Savings.java`](Savings.java)

#### 문제

> 원금과 이율을 입력받아 2년 후의 예금액(복리)을 계산하는 프로그램

#### 💻 코드

<!-- code: Savings.java -->
```java
import java.util.Scanner;

public class Savings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("원금 ? ");
        int saving = sc.nextInt();
        System.out.print("이율 (0~1)? ");
        // ⚠ 자주 틀리는 부분: Double rate (대문자 D) 는 기본 자료형이 아니라 래퍼 클래스다.
        //    오토 언박싱 덕분에 동작은 하지만, 계산용 변수는 기본 자료형 double 을 쓴다.
        double rate = sc.nextDouble();
        sc.close();

        double tmp = saving + (saving * rate); // 1년 후
        tmp = tmp + (tmp * rate);              // 2년 후
        System.out.println("2년 후의 예금액은 " + tmp + "입니다.");

        // 같은 결과: Math.pow(밑, 지수) 사용
        // double result = saving * Math.pow(1 + rate, 2);
    }
}
```
<!-- /code -->

#### 실행 예

```text
원금 ? 100000
이율 (0~1)? 0.9
2년 후의 예금액은 361000.0입니다.      (100000 * 1.9 * 1.9)
```

**📝 필기 - 복리 계산 과정**

원금 (x) --- 1년 뒤 ---> 원금 (x) + 이자 (x\*r)

```java
--- 2년 뒤 ---> 원금 { x + x*r } + 이자 { (x + x*r) * r }
```

즉, 1년 후 금액을 다시 원금으로 삼아 이자를 붙인다.  →  x \* (1 + r)^2 와 같다.

## 5. 2차 방정식의 근

`2강 실습` · 📄 [`QuadraticEquation.java`](QuadraticEquation.java)

#### 문제

> 계수 a, b, c 를 입력받아 2차 방정식 ax² + bx + c = 0 의 두 근을 구하는 프로그램

#### 💻 코드

<!-- code: QuadraticEquation.java -->
```java
import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("a ? ");
        int a = sc.nextInt();
        System.out.print("b ? ");
        int b = sc.nextInt();
        System.out.print("c ? ");
        int c = sc.nextInt();
        sc.close();

        // import java.lang.Math; 하지 않아도 java.lang 은 기본적으로 import 되는 클래스 패키지이다.
        double tmp = Math.sqrt(b * b - 4 * a * c);
        double result1 = (-b + tmp) / (2 * a);
        double result2 = (-b - tmp) / (2 * a);
        System.out.println("2차 방정식의 근은  " + result1 + " 또는 " + result2 + "입니다.");
    }
}
```
<!-- /code -->

#### 실행 예

```text
a ? 4
b ? 5
c ? -1
2차 방정식의 근은  0.17539052967910607 또는 -1.425390529679106입니다.
```

**📝 필기**

- 2차 방정식의 근은 ( -b ± √(b² - 4ac) ) / 2a 이므로 이를 그대로 수식으로 옮긴다.
- 제곱근은 Math.sqrt() 사용.
- import java.lang.Math; 를 하지 않아도 된다.<br>java.lang 은 기본적으로 import 되는 클래스 패키지이다.
- 주의: 자바에서 ^ 는 거듭제곱이 아니라 비트 XOR 연산자! b^2 가 아니라 b\*b 로 써야 한다.
- 주의: (-b + tmp) / 2\*a 처럼 쓰면 "/2 한 다음 \*a" 가 되므로 반드시 (2\*a) 로 괄호를 쳐야 한다.

참고) 판별식 b² - 4ac 가 음수이면 실근이 없어서 Math.sqrt() 결과가 NaN(Not a Number)이 된다.<br>(조건문을 배운 뒤에는 if 로 판별식을 먼저 검사하면 된다.)

---

[🏠 2주차 학습 가이드](../../README.md)
