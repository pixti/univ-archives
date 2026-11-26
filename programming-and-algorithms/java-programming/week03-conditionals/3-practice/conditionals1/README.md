# 3주차 실습 · conditionals1

[🏠 3주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [Triangle.java](#1-세-점으로-삼각형을-만들-수-있는지-기울기-비교) | 1. 세 점으로 삼각형을 만들 수 있는지 (기울기 비교) |
| [SimpleCalculator.java](#2-간단한-계산기-if-버전) | 2. 간단한 계산기 (if 버전) |
| [SimpleCalculatorSwitch.java](#2-간단한-계산기-switch-버전) | 2. 간단한 계산기 (switch 버전) |
| [UpperToLower.java](#3-대문자--소문자-아스키코드-필기가-가장-많은-파일) | 3. 대문자 → 소문자. 아스키코드 필기가 가장 많은 파일 |
| [VowelCheck.java](#4-모음비모음-구분-if-switch-버전과-팁-필기) | 4. 모음/비모음 구분 (if, switch 버전과 팁 필기) |

---

## 1. 세 점으로 삼각형을 만들 수 있는지 (기울기 비교)

`3강 실습` · 📄 [`Triangle.java`](Triangle.java)

#### 문제

> 0이 아닌 3개의 좌표값 (x1, y1), (x2, y2), (x3, y3) 를 입력받아서<br>삼각형을 만들 수 있는지를 검사하는 프로그램을 작성하라.
>
> 힌트 : 한 점 (x1, y1) 에서 (x2, y2) 가는 직선의 기울기와<br>(x1, y1) 에서 (x3, y3) 가는 직선의 기울기가 같지 않으면 삼각형을 만들 수 있음.

#### 💻 코드

<!-- code: Triangle.java -->
```java
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("1번째 점의 위치 입력 (x1, y1) : ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        System.out.print("2번째 점의 위치 입력 (x2, y2) : ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        System.out.print("3번째 점의 위치 입력 (x3, y3) : ");
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        if ((x1 == x2 && x2 == x3) || (y1 == y2 && y2 == y3)) {
            System.out.println("삼각형을 만들 수 없습니다. (일직선)");
        }
        else if ((x1 == x2 && y1 == y2) || (x2 == x3 && y2 == y3) || (x1 == x3 && y1 == y3)) {
            System.out.println("삼각형을 만들 수 없습니다. (중복된 점)");
        }
        else if (x1 == x2 || x2 == x3 || x1 == x3) {
            // 세로선이 하나 있지만 세 점이 모두 같은 세로선 위에 있지는 않음
            System.out.println("삼각형을 만들수 있습니다.");
        }
        else {
            double slope1 = (double) (y2 - y1) / (x2 - x1);
            double slope2 = (y3 - y1) / (double) (x3 - x1);

            if (slope1 == slope2) {
                System.out.println("삼각형을 만들 수 없습니다.");
            }
            else {
                System.out.println("삼각형을 만들수 있습니다.");
            }
        }

        // 💡 곱셈 비교 버전 (위의 if-else if 전체를 이것으로 대신할 수 있다)
        // if ((y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1))
        //     System.out.println("삼각형을 만들 수 없습니다.");
        // else
        //     System.out.println("삼각형을 만들수 있습니다.");

        sc.close();
    }
}
```
<!-- /code -->

#### 문제의 실행 예

```text
1번째점을입력하세요(x1,y1) : 2 2
2번째점을입력하세요(x2,y2) : 1 3
3번째점을입력하세요(x3,y3) : 2 3
알림>삼각형 만들수 있습니다.
```

#### 이 코드 실행 예

```text
1번째 점의 위치 입력 (x1, y1) : 8 9
2번째 점의 위치 입력 (x2, y2) : 3 9
3번째 점의 위치 입력 (x3, y3) : 4 4
삼각형을 만들수 있습니다.
```

**📝 필기**

- 기울기 공식 :  (y2 - y1) / (x2 - x1)
- 세 점 중 두 직선의 기울기가 같다면 세 점이 한 일직선상에 놓이므로 삼각형을 만들 수 없습니다.

**내 풀이의 흐름**

1. x 좌표가 모두 같거나 y 좌표가 모두 같으면 → 일직선 (세로선 / 가로선)
2. 두 점이 완전히 같으면 → 중복된 점 (선분 하나뿐)
3. 위 경우가 아닌데 x 좌표가 같은 쌍이 있으면 → 그 직선은 세로선이라 기울기를 구할 수 없다 (0 으로 나누기).<br>세 점이 모두 같은 세로선 위에 있는 경우는 1 에서 이미 걸렀으므로 → 삼각형 가능
4. 나머지는 기울기 두 개를 구해서 비교

- 💡 기울기를 구할 때 (double) 로 형변환하지 않으면 정수 나눗셈이 되어 1/2 와 1/3 이 둘 다 0 이 된다.<br>(slope1 은 앞쪽을, slope2 는 뒤쪽을 형변환했는데 둘 다 double 나눗셈이 되므로 결과는 같다)
- 💡 double 을 == 로 비교하는 것은 원래 위험하다(오차). 여기서는 입력이 정수라서 "같은 분수 값" 이면 같은 double 로 반올림되므로 문제없이 동작한다.
- 💡 더 안전한 방법 - 나눗셈을 곱셈으로 바꾸기 (나눗셈이 없으니 x 가 같은 경우의 예외 처리도 필요 없다)<br>(y2 - y1) / (x2 - x1) == (y3 - y1) / (x3 - x1)<br>⇔ (y2 - y1) \* (x3 - x1) == (y3 - y1) \* (x2 - x1)<br>이 식이 참이면 일직선이다. (중복된 점도 여기에 포함된다)

## 2. 간단한 계산기 (if 버전)

`3강 실습` · 📄 [`SimpleCalculator.java`](SimpleCalculator.java)

#### 문제

> 간단한 계산기 프로그램을 작성하여 보자.<br>먼저 사용자로부터 하나의 연산 문자 (+, -, \*, /, Q) 를 입력받는다.<br>이어서 사용자로부터 2개의 숫자를 입력 받는다.<br>연산 문자에 맞는 계산을 한 후 그 결과를 출력한다. 연산 문자 중 Q 는 프로그램 종료를 의미한다.<br>→ switch 버전 : SimpleCalculatorSwitch.java (이쪽을 먼저 작성했음)

#### 💻 코드

<!-- code: SimpleCalculator.java -->
```java
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("**************");
        System.out.println("+ --------- 덧셈");
        System.out.println("- ---------- 뺄셈");
        System.out.println("* ---------- 곱셈");
        System.out.println("/ -------- 나눗셈");
        System.out.println("Q -------- Quit");
        System.out.println("**************");

        System.out.print("연산 선택 : ");
        char op = sc.next().charAt(0);

        if (op == 'Q' || op == 'q') {
            System.out.println("프로그램을 종료합니다.");
            sc.close();
            return;
        }

        System.out.print("두 수를 공백으로 분리하여 입력하시오 : ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        if (op == '+') {
            System.out.println(x + y);
        }
        else if (op == '-') {
            System.out.println(x - y);
        }
        else if (op == '*') {
            System.out.println(x * y);
        }
        else if (op == '/') {
            if (y != 0) {
                System.out.println(x / y);
            }
            else {
                System.out.println("0으로 나눌 수 없습니다.");
            }
        }
        else {
            System.out.println("잘못된 연산자입니다.");
        }

        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
**************
+ --------- 덧셈
- ---------- 뺄셈
* ---------- 곱셈
/ -------- 나눗셈
Q -------- Quit
**************
연산 선택 : +
두 수를 공백으로 분리하여 입력하시오 : 10 3
13
```

**포인트**

- op == '+' 처럼 "같은 변수를 == 로 여러 번 비교" 하는 if-else if 는 switch 로 바꾸기 좋다.
- switch 의 default ↔ if 의 마지막 else
- 나눗셈 안의 if-else 는 "중첩 if" 이다.

- 💡 강의 예제(1-lecture/code/Calculator.java)는 0 으로 나누는 경우를 처리하지 않았지만 여기서는 if (y != 0) 으로 막았다.

## 2. 간단한 계산기 (switch 버전)

`3강 실습` · 📄 [`SimpleCalculatorSwitch.java`](SimpleCalculatorSwitch.java)

#### 문제

> 간단한 계산기 프로그램을 작성하여 보자.<br>먼저 사용자로부터 하나의 연산 문자 (+, -, \*, /, Q) 를 입력받는다.<br>이어서 사용자로부터 2개의 숫자를 입력 받는다.<br>연산 문자에 맞는 계산을 한 후 그 결과를 출력한다. 연산 문자 중 Q 는 프로그램 종료를 의미한다.

#### 💻 코드

<!-- code: SimpleCalculatorSwitch.java -->
```java
import java.util.Scanner;

public class SimpleCalculatorSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("**************");
        System.out.println("+ --------- 덧셈");
        System.out.println("- ---------- 뺄셈");
        System.out.println("* ---------- 곱셈");
        System.out.println("/ -------- 나눗셈");
        System.out.println("Q -------- Quit");
        System.out.println("**************");

        System.out.print("연산 선택 : ");
        char op = sc.next().charAt(0);

        if (op == 'Q' || op == 'q') {
            System.out.println("프로그램을 종료합니다.");
            sc.close();
            return;
        }

        System.out.print("두 수를 공백으로 분리하여 입력하시오 : ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        switch (op) {
            case '+' :
                System.out.println((int) (x + y));
                break;
            case '-' :
                System.out.println((int) (x - y));
                break;
            case '*' :
                System.out.println((int) (x * y));
                break;
            case '/' :
                if (y != 0) {
                    System.out.println(x / y);
                }
                else {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                break;
            default :
                System.out.println("잘못된 연산자입니다.");
                break;
        }

        sc.close();
    }
}
```
<!-- /code -->

#### 문제의 실행 예

```text
*****
+---Add
----Subtract
*---Multiply
/---Divide
Q---Quit
*****
연산을선택하시요: +
두 수를 공백으로 분리하여 입력하시요 : 10 20
30
```

#### 이 코드 실행 예

```text
연산 선택 : +
두 수를 공백으로 분리하여 입력하시오 : 3 10
13
```

#### 📒 해설

- 💡 switch 로 먼저 풀고, if 버전을 따로 작성했다.<br>→ if 버전 : SimpleCalculator.java

**포인트**

- sc.next().charAt(0) : Scanner 에는 한 글자를 읽는 메소드가 없어서 문자열을 읽고 첫 글자를 꺼낸다.
- Q 를 먼저 검사해서 return; 으로 main 을 끝낸다. → 종료할 때는 숫자를 입력받지 않아도 된다.
- 나눗셈은 y 가 0 이면 ArithmeticException 이 나므로 if (y != 0) 으로 막았다.

- 💡 (int) (x + y) 처럼 형변환을 붙였는데, int + int 는 이미 int 라서 필요 없다.
- 💡 x / y 는 정수 나눗셈이라 10 / 3 = 3 이 된다. 소수점까지 원하면 (double) x / y.

## 3. 대문자 → 소문자. 아스키코드 필기가 가장 많은 파일

`3강 실습` · 📄 [`UpperToLower.java`](UpperToLower.java)

#### 문제

> 사용자로부터 하나의 문자를 입력받는다. 만약 입력받은 문자가 대문자이면 소문자로 변환한다.<br>만약 소문자를 입력하면 대문자로 입력하라는 안내문을 출력한다.

#### 💻 코드

<!-- code: UpperToLower.java -->
```java
import java.util.Scanner;

public class UpperToLower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자 ? ");
        char c = sc.next().charAt(0);

        if ('A' <= c && c <= 'Z') {            // 대문자인 경우 ('A' ~ 'Z')
            int lower = 'a' + (c - 'A');
            System.out.println((char) lower);
            // 📝 팁: System.out.println((char) ('a' + (c - 'A')));
        }
        else if (c >= 'a' && c <= 'z') {       // 소문자인 경우 ('a' ~ 'z')
            System.out.println("대문자를 입력하세요.");
        }
        else {                                 // 영문자가 아닌 경우
            System.out.println("영문자를 입력하세요.");
        }

        sc.close();
    }
}
```
<!-- /code -->

#### 문제의 실행 예

```text
하나의 문자를 입력하세요 : A
a
```

#### 이 코드 실행 예

```text
문자 ? G
g
```

**📝 필기 - 아스키코드**

- 아스키코드상 A 는 65, ..... , Z 는 90, \[ 는 91, .... , a 는 97, ..... , z 는 122.
- char 타입은 내부적으로 아스키 코드(int) 값으로 저장된다.<br>따라서 두 문자를 빼서 연산하면 알파벳 순서상 떨어져 있는 "거리(알파벳 위치 차이)" 를 구할 수 있다.
- 문자들 간의 거리는 어떻게 구할까?  x = 'B' 라고 하자.<br>x - 'A' 를 하면 실제로는 66 - 65 라서 1 이 나온다.
  ```text
  'B' - 'A' → 66 - 65 = 1   (A 로부터 1번째 뒤에 위치)
  ```<br>'Z' - 'A' → 90 - 65 = 25  (A 로부터 25번째 뒤에 위치)
- 대문자를 소문자로 바꾸는 식 : 'a' + (x - 'A')
    1. x - 'A'   → 'B' - 'A' = 1   (거리 계산)
    2. 'a' + 1   → 97 + 1    = 98
    3. (char) 98 → 'b'

**📝 필기 - 더 간결하게 쓰는 소소한 팁**

int 변수를 따로 만들지 않고 바로 형변환해서 출력할 수 있다.

```java
System.out.println((char) ('a' + (c - 'A')));
```

- 💡 (char) 를 빼고 println('a' + (c - 'A')) 로 쓰면 결과가 int 라서 98 같은 숫자가 출력된다.
- 💡 Character.toLowerCase(c) 를 쓰면 한 번에 바꿀 수 있다. (과제 ShapeArea, VowelSwitch 에서 사용)

## 4. 모음/비모음 구분 (if, switch 버전과 팁 필기)

`3강 실습` · 📄 [`VowelCheck.java`](VowelCheck.java)

#### 문제

> 키보드에서 문자 하나를 읽어서 모음과 비모음을 구분하는 프로그램을 작성하여 보자.
>
> 내 풀이 : if 문에 모음 10가지 (a, e, i, o, u 와 대문자 A, E, I, O, U) 를 || 로 모두 나열<br>→ 그 외 영문자는 비모음, 영문자가 아니면 안내문

#### 💻 코드

<!-- code: VowelCheck.java -->
```java
import java.util.Scanner;

public class VowelCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자 ? ");
        char c = sc.next().charAt(0);

        if (c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I' || c == 'i'
                || c == 'O' || c == 'o' || c == 'U' || c == 'u') {
            System.out.println("모음 입니다.");
        }
        else if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
            System.out.println("비모음 입니다.");
        }
        else {
            System.out.println("영문자를 입력하세요.");
        }

        sc.close();
    }
}
```
<!-- /code -->

#### 문제의 실행 예  (입력 : I)

```text
입력하신 문자는 모음입니다.!!^^
```

#### 이 코드 실행 예

```text
문자 ? f
비모음 입니다.
```

#### 📒 해설

- 📝 필기 - switch 문으로 바꾼 버전 (class VowelChecker)
  ```java
  switch (c) {
      case 'A': case 'a':
      case 'E': case 'e':
      case 'I': case 'i':
      case 'O': case 'o':
      case 'U': case 'u':
          System.out.println("입력하신 문자는 모음입니다.!!^^");
          break;
      default:
          System.out.println("입력하신 문자는 자음(비모음)입니다.");
  }
  ```

**📝 필기 - 코드 주요 포인트**

- 대소문자 처리 : 모음은 a, e, i, o, u 및 대문자 A, E, I, O, U 총 10가지.
- switch 조건 통합 : break 없이 case 를 나열하면 여러 값을 하나의 동작으로 묶을 수 있다 (fall-through).

**📝 필기 - 팁**

- Character.toLowerCase(c) 로 먼저 소문자로 바꾸면 비교할 문자가 5개로 절반이 된다.
  ```java
  c = Character.toLowerCase(c);
  if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ...
  ```<br>→ 과제 VowelSwitch.java 에서 이 방법을 썼다.
- String 의 메소드를 이용하는 방법
  ```java
  if ("aeiouAEIOU".indexOf(c) != -1) ...
  ```
  - 💡 indexOf(c) 는 문자열에서 c 의 위치를 돌려주고, 없으면 -1 을 돌려준다.<br>contains 는 문자열(String)만 받으므로 char 로 쓰려면 contains(String.valueOf(c)) 처럼 바꿔야 한다.

- 💡 위 switch 필기 버전은 default 에서 숫자나 기호도 "자음" 이라고 출력한다.<br>내 if 버전은 영문자인지 한 번 더 확인해서 이 경우를 따로 처리했다.

---

[🏠 3주차 학습 가이드](../../README.md)
