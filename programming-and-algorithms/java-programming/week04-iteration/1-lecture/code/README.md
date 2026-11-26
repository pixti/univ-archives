# 4주차 강의 예제 코드

[🏠 4주차 학습 가이드](../../README.md)

강의 노트([`1-lecture/`](../))에 나온 코드를 실행할 수 있는 파일로 정리했습니다. 노트를 먼저 읽고, 여기서 코드를 실행하며 결과를 확인하세요.

| 파일 | 내용 |
|---|---|
| [WhileTable.java](#while-문---1--10--100-표-출력) | 1 / 10 / 100 표 출력 |
| [WhileSum.java](#while-문---1--5까지의-합) | 1 ~ 5까지의 합 |
| [WhileProduct.java](#while-문---1--5까지의-곱) | 1 ~ 5까지의 곱 |
| [MultiplicationTableWhile.java](#실습-특정-구구단-출력하기-while-버전) | 특정 구구단 출력 (while) |
| [ContinueQuestion.java](#반복-횟수가-정해지지-않은-경우---계속-하시겠습니까) | "계속 하시겠습니까?" (반복 횟수가 정해지지 않은 경우) |
| [ScoreProcessing.java](#실습-성적-처리) | 성적 처리 |
| [MenuCalculatorWhile.java](#실습-메뉴-반복-처리하기---조건문-실습에서-반복처리-추가-while-버전) | 메뉴 반복 처리 (while) |
| [NumberGuessing.java](#실습-숫자-맞히기-게임) | 숫자 맞히기 게임 |
| [MenuCalculatorDoWhile.java](#실습-메뉴-반복-처리하기-do-while-버전) | 메뉴 반복 처리 (do-while) |
| [NumberGuessingRepeat.java](#실습-숫자-맞히기-게임-반복하기) | 숫자 맞히기 게임 반복 |
| [ForSum.java](#for-문---파이썬-for-문을-자바-for-문으로--증감식의-여러-형태) | 파이썬 for → 자바 for, 증감식의 여러 형태 |
| [ForScope.java](#for-문---반복-변수의-범위--무한-반복) | 반복 변수의 범위, 무한 반복 |
| [MultiplicationTableFor.java](#실습-특정-구구단-출력하기-for-버전) | 특정 구구단 출력 (for) |
| [Factorial.java](#실습-팩토리얼-구하기) | 팩토리얼 |
| [MultipleSum.java](#실습-1에서-n까지-3의-배수의-합-구하기) | 1에서 n까지 3의 배수의 합 |
| [MenuCalculatorFor.java](#실습-메뉴-반복-처리하기-for-버전) | 메뉴 반복 처리 (for) |
| [BreakExample.java](#break-문) | break |
| [PrimeCheck.java](#실습-소수-판별하기-break) | 소수 판별 (break) |
| [ContinueOddSum.java](#continue-문---1--100-홀수의-합) | continue로 1 ~ 100 홀수의 합 |
| [StarPattern.java](#이중-for-문---별-찍기-사각형-삼각형) | 이중 for로 별 찍기 (사각형, 삼각형) |
| [MultiplicationTableAll.java](#실습-구구단-전체-출력하기-이중-for-문) | 구구단 전체 출력 (이중 for) |
| [PrimesBelowN.java](#실습-n보다-작은-소수-찾기-이중-for-문--break) | n보다 작은 소수 (이중 for + break) |
| [ForEach.java](#foreach-문--실습-학생-성적-처리하기) | foreach, 학생 성적 처리 |

---

## while 문 - 1 / 10 / 100 표 출력

`4-1 반복문1` · 📄 [`WhileTable.java`](WhileTable.java)

#### 💻 코드

<!-- code: WhileTable.java -->
```java
public class WhileTable {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 5) {
            System.out.println(i + " " + i * 10 + " " + i * 100);
            i++;
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
1 10 100
2 20 200
3 30 300
4 40 400
5 50 500
```

**while 문**

- while 문과 for 문은 표현력이 동일하다.
- 조건식을 검사하여 true 이면 블록 내 문장을 실행하고, 다시 조건식을 검사한다.

```java
while (조건식) {          (Python)  while 조건식 :
    ...                                 ...
}

while (true) {   // 의도적인 무한루프
    ...
}
```

반복할 때마다 i 가 1 → 5 로 바뀌면서 "같은 문장" 이 실행된다.

```text
(i : 1)   i   i*10   i*100
(i : 2)   i   i*10   i*100
...
(i : 5)   i   i*10   i*100
(i : 6)   조건 6 <= 5 거짓 → 종료
```

- 💡 i++ 를 빼먹으면 i 가 계속 1 이라 조건이 항상 참 → 실수로 무한루프가 된다.

## while 문 - 1 \~ 5까지의 합

`4-1 반복문1` · 📄 [`WhileSum.java`](WhileSum.java)

#### 💻 코드

<!-- code: WhileSum.java -->
```java
public class WhileSum {
    public static void main(String[] args) {
        int i = 1, sum = 0;
        while (i <= 5) {        // while (i < 6) { 와 같은 의미
            sum = sum + i;
            i++;
        }
        System.out.println("합 : " + sum);
    }
}
```
<!-- /code -->

#### 실행 예

```text
합 : 15
```

**반복문 없이 쓰면**

```java
int sum = 0;
sum = sum + 1;  // 1까지 합
sum = sum + 2;  // 2까지 합
sum = sum + 3;  // 3까지 합
sum = sum + 4;  // 4까지 합
sum = sum + 5;  // 5까지 합
```

→ 바뀌는 부분(1 \~ 5)을 변수 i 로 바꾸면 매번 sum = sum + i; 라는 같은 문장이 된다.

```text
(i : 1)  sum = sum + i;   → sum = 1
(i : 2)  sum = sum + i;   → sum = 3
(i : 3)  sum = sum + i;   → sum = 6
(i : 4)  sum = sum + i;   → sum = 10
(i : 5)  sum = sum + i;   → sum = 15
```

- 💡 합을 구할 때는 sum 을 0 (덧셈의 항등원)에서 시작한다.<br>곱은 1 에서 시작해야 한다 → WhileProduct.java

## while 문 - 1 \~ 5까지의 곱

`4-1 반복문1` · 📄 [`WhileProduct.java`](WhileProduct.java)

```text
(i : 1)  sum = sum * i;   → 1
(i : 2)  sum = sum * i;   → 2
(i : 3)  sum = sum * i;   → 6
(i : 4)  sum = sum * i;   → 24
(i : 5)  sum = sum * i;   → 120
```

#### 💻 코드

<!-- code: WhileProduct.java -->
```java
public class WhileProduct {
    public static void main(String[] args) {
        int i = 1, sum = 1;     // 곱이므로 1 로 초기화
        while (i <= 5) {        // while (i < 6) {
            sum = sum * i;
            i++;
        }
        System.out.println("곱 : " + sum);
    }
}
```
<!-- /code -->

#### 실행 예

```text
곱 : 120
```

#### 📒 해설

- 💡 곱을 구할 때는 1 (곱셈의 항등원)로 초기화한다. 0 으로 시작하면 무엇을 곱해도 0.<br>→ 퀴즈 3번 (Σ → sum = 0, Π → prod = 1)

- ⚠ 자주 틀리는 부분: 자바는 대소문자를 구분한다.<br>While( I &lt;= 5) 처럼 쓰면 While (키워드 아님), I (선언 안 된 변수) 때문에 컴파일 에러.
- 💡 변수 이름은 sum 이지만 실제로는 곱을 담는다. 직접 짤 때는 prod 처럼 의미에 맞는 이름이 좋다.<br>출력도 "합 : " 이 아니라 "곱 : " 이어야 한다.

## \[실습] 특정 구구단 출력하기 (while 버전)

`4-1 반복문1` · 📄 [`MultiplicationTableWhile.java`](MultiplicationTableWhile.java)

원하는 단을 입력받아 dan \* 1 \~ dan \* 9 를 출력한다.

- index 를 1 로 초기화 → index &lt;= 9 인 동안 반복 → 매번 index++

#### 💻 코드

<!-- code: MultiplicationTableWhile.java -->
```java
import java.util.Scanner;

public class MultiplicationTableWhile {
    public static void main(String[] args) {
        int dan;

        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 단 ? ");
        dan = sc.nextInt();
        sc.close();

        int index = 1;
        while (index <= 9) {
            System.out.println(dan + " * " + index + " = " + dan * index);
            index++;
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
원하는 단 ? 7
7 * 1 = 7
7 * 2 = 14
...
7 * 9 = 63
```

**같은 문제를**

- 4-3 에서 for 문으로      → MultiplicationTableFor.java
- 4-4 에서 이중 for 문으로 → MultiplicationTableAll.java (2 \~ 9단 전체)

## 반복 횟수가 정해지지 않은 경우 - "계속 하시겠습니까?"

`4-1 반복문1 / 4-2 반복문2` · 📄 [`ContinueQuestion.java`](ContinueQuestion.java)

while 문은 반복 횟수가 미리 정해지지 않은 경우 편리하게 사용한다.<br>같은 일을 while (4-1) 과 do-while (4-2) 로 각각 작성해 비교한다.

```java
                    while (4-1)                do-while (4-2)
선언               char cont = 'y';            char cont;
조건 검사 시점      블록 실행 "전"               블록 실행 "후"
최소 실행 횟수      0 번                         1 번
```

```java
4-1 : char cont = 'y';  // y로 초기화 하지 않으면 while문 접근 X
```


- 💡 지역 변수는 초기화 없이 쓸 수 없다. char cont; 만 쓰고 while (cont == 'y') 를 쓰면 "variable cont might not have been initialized" 컴파일 에러.

4-2 : 반복 조건을 나중에 검사하기 때문에 cont 를 'y' 로 초기화 할 필요 X

- 💡 do 블록 안에서 cont = sc.next().charAt(0); 이 반드시 먼저 실행되므로 컴파일러도 OK.

#### 💻 코드

<!-- code: ContinueQuestion.java -->
```java
import java.util.Scanner;

public class ContinueQuestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== 4-1 : while =====
        char cont = 'y';    // y로 초기화 하지 않으면 while문 접근 X
        int count = 0;
        while (cont == 'y') {
            // 반복작업 내용
            count++;
            System.out.println("[while] " + count + "번째 작업");

            System.out.println("계속 하시겠습니까 ? ('y' or 'n') ");
            cont = sc.next().charAt(0);
        }

        // ===== 4-2 : do-while =====
        char cont2;         // 초기화 필요 X
        count = 0;
        do {
            // 반복작업 내용
            count++;
            System.out.println("[do-while] " + count + "번째 작업");

            System.out.println("계속 하시겠습니까 ? ('y' or 'n') ");
            cont2 = sc.next().charAt(0);
        } while (cont2 == 'y');     // 세미콜론 필수

        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
[while] 1번째 작업
계속 하시겠습니까 ? ('y' or 'n')
y
[while] 2번째 작업
계속 하시겠습니까 ? ('y' or 'n')
n
[do-while] 1번째 작업
계속 하시겠습니까 ? ('y' or 'n')
n
```

#### 📒 해설

- 💡 "반복 작업 내용" 자리에는 몇 번째 반복인지 출력하도록 했다.

## \[실습] 성적 처리

`4-1 반복문1` · 📄 [`ScoreProcessing.java`](ScoreProcessing.java)

0 \~ 100 사이의 점수를 계속 입력받고, 범위 밖의 값이 들어오면 입력을 끝낸다.<br>그 후 평균, 최대값, 최소값을 출력한다.

#### 💻 코드

<!-- code: ScoreProcessing.java -->
```java
import java.util.Scanner;

public class ScoreProcessing {
    public static void main(String[] args) {
        int val, cnt = 0, sum = 0, max = -1, min = 101;
        Scanner sc = new Scanner(System.in);
        System.out.println("0과 100 사이의 값을 입력 (그외 값은 종료) : ");
        val = sc.nextInt();
        while (val >= 0 && val <= 100) {
            cnt = cnt + 1;              // 입력 정수의 개수 세기
            sum = sum + val;            // 합 구하기
            if (val > max) max = val;   // 최대값 구하기
            if (val < min) min = val;   // 최소값 구하기
            System.out.println("0과 100 사이의 값을 입력 (그외 값은 종료) : ");
            val = sc.nextInt();
        }
        if (cnt != 0) {
            System.out.println("평균 : " + (double) sum / cnt);
            System.out.println("최대값 : " + max);
            System.out.println("최소값 : " + min);
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
0과 100 사이의 값을 입력 (그외 값은 종료) :
30
0과 100 사이의 값을 입력 (그외 값은 종료) :
40
0과 100 사이의 값을 입력 (그외 값은 종료) :
50
0과 100 사이의 값을 입력 (그외 값은 종료) :
-1
평균 : 40.0
최대값 : 50
최소값 : 30
```

**포인트**

- 입력 → 검사 → 처리 → 다시 입력<br>첫 값은 반복문 "밖에서" 읽고, 블록의 "마지막" 에서 다음 값을 읽는다.<br>→ 종료 값(-1 등)이 합계/개수에 섞이지 않는다. (실습 1번 산술 평균과 같은 구조)
- max 는 나올 수 있는 값보다 작은 -1, min 은 큰 101 로 시작<br>→ 첫 입력이 무조건 max, min 이 된다.
- (double) sum / cnt : 형변환이 나눗셈보다 먼저 → 실수 나눗셈.<br>(double) (sum / cnt) 로 쓰면 정수 나눗셈 결과를 바꾸는 것이라 소수점이 사라진다.
- if (cnt != 0) : 처음부터 범위 밖 값을 넣으면 cnt 가 0 → 0 으로 나누는 것을 막는다.

## \[실습] 메뉴 반복 처리하기 - 조건문 실습에서 반복처리 추가 (while 버전)

`4-1 반복문1` · 📄 [`MenuCalculatorWhile.java`](MenuCalculatorWhile.java)

3주차 "메뉴 방식의 사칙 연산" 을 q 를 누를 때까지 반복하도록 바꾼다.

#### 💻 코드

<!-- code: MenuCalculatorWhile.java -->
```java
import java.util.Scanner;

public class MenuCalculatorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean cont = true; char c;
        while (cont) {  // cont가 false 될때 까지 무한 루프
            System.out.println("a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료");
            c = sc.next().charAt(0);

            if (c == 'q') {
                System.out.println("프로그램을 종료하였습니다.");
                cont = false;
            }
            else if (!(c == 'a' || c == 's' || c == 'm' || c == 'd')) {
                System.out.println("유효하지 않는 메뉴입니다.");
            }
            else {
                // ----- 강의 코드에서 생략된 부분 -----
                System.out.println("첫 번째 숫자 (음수도 가능) >> ");
                int a = sc.nextInt();
                System.out.println("두 번째 숫자 (음수도 가능) >> ");
                int b = sc.nextInt();

                double result;
                if (c == 'a') result = a + b;
                else if (c == 's') result = a - b;
                else if (c == 'm') result = a * b;
                else result = (double) a / b;   // 💡 형변환하지 않으면 정수 나눗셈 (7 / 2 = 3)

                System.out.println("결과는 " + result + "입니다.");
            }
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료
a
첫 번째 숫자 (음수도 가능) >>
3
두 번째 숫자 (음수도 가능) >>
7
결과는 10.0입니다.
a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료
x
유효하지 않는 메뉴입니다.
a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료
q
프로그램을 종료하였습니다.
```

**포인트**

- boolean 플래그(cont)로 반복을 제어한다.<br>cont 가 true 인 동안 돌다가 q 가 들어오면 false 로 바꾼다 → 다음 조건 검사에서 빠져나옴.
- !(c == 'a' || c == 's' || c == 'm' || c == 'd') : 네 메뉴 중 어느 것도 아니면<br>(= c != 'a' && c != 's' && c != 'm' && c != 'd', 드모르간 법칙)

- 💡 강의 코드에서 "… // 생략" 된 부분(숫자 두 개 입력 → 계산 → 출력)은 3주차 코드로 채웠다.<br>실행 화면의 "결과는 10.0입니다." 처럼 결과는 double 로 출력한다.
- 💡 다른 풀이: while(true) + break(q 일 때) + continue(잘못된 메뉴일 때) 로 써도 된다.<br>(break / continue 는 4-4 에서 배운다.) 플래그 방식과 결과는 같다.

## \[실습] 숫자 맞히기 게임

`4-1 반복문1` · 📄 [`NumberGuessing.java`](NumberGuessing.java)

1 \~ 100 사이의 무작위 숫자를 맞힐 때까지 반복한다.

#### 💻 코드

<!-- code: NumberGuessing.java -->
```java
import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        int answer = (new Random()).nextInt(100) + 1;   // 1~100 무작위 숫자
        int guess;
        Scanner sc = new Scanner(System.in);
        boolean cont = true;
        while (cont) {  // 정답이 될 때 까지 무한 루프
            System.out.println("예측값 ? ");
            guess = sc.nextInt();
            if (guess > answer) System.out.println("정답보다 크다");
            else if (guess < answer) System.out.println("정답보다 작다");
            else {
                System.out.println("정답!!!");
                cont = false;
            }
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
예측값 ?
50
정답보다 크다
예측값 ?
25
정답보다 작다
예측값 ?
37
정답!!!
```

**포인트**

- (new Random()).nextInt(100) 은 0 \~ 99 → + 1 해서 1 \~ 100.<br>(3주차 홀짝 맞히기에서 배운 방법)
- 몇 번 만에 맞힐지 모름 = 반복 횟수가 정해지지 않은 경우 → while 이 어울린다.
- 정답이면 cont = false → 다음 조건 검사에서 빠져나온다.

- 💡 4-2 에서 "게임을 계속할지" 를 묻는 바깥 반복문(do-while)을 추가한다<br>→ NumberGuessingRepeat.java

## \[실습] 메뉴 반복 처리하기 (do-while 버전)

`4-2 반복문2` · 📄 [`MenuCalculatorDoWhile.java`](MenuCalculatorDoWhile.java)

4-1 에서 while 로 작성한 "메뉴 방식의 사칙연산" 을 do-while 로 변경한다.

#### 💻 코드

<!-- code: MenuCalculatorDoWhile.java -->
```java
import java.util.Scanner;

public class MenuCalculatorDoWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean cont = true;
        do {
            System.out.println("a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료 ");
            char c = sc.next().charAt(0);

            if (c == 'q') {
                System.out.println("프로그램을 종료하였습니다.");
                cont = false;
            }
            else if (!(c == 'a' || c == 's' || c == 'm' || c == 'd'))
                System.out.println("유효하지 않는 메뉴입니다.");
            else {
                System.out.println("첫 번째 숫자 (음수도 가능) >> ");
                int a = sc.nextInt();
                System.out.println("두 번째 숫자 (음수도 가능) >> ");
                int b = sc.nextInt();

                double result;
                if (c == 'a') result = a + b;
                else if (c == 's') result = a - b;
                else if (c == 'm') result = a * b;
                else result = (double) a / b;

                System.out.println("결과는 " + result + "입니다.");
            }
        } while (cont);
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료
m
첫 번째 숫자 (음수도 가능) >>
-4
두 번째 숫자 (음수도 가능) >>
5
결과는 -20.0입니다.
a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료
q
프로그램을 종료하였습니다.
```

**do-while 문 (Python 에서는 제공하지 않음)**

- while 의 변형. 반복문을 한 번 실행한 후 조건을 검사 → 최소 한 번은 실행된다.

```java
do {                         aaa;
    반복 내용들       ≒       while (조건식) {
} while (조건식);                 aaa;
                             }
```

**포인트**

- 메뉴는 적어도 한 번은 보여 줘야 하므로 do-while 이 자연스럽다.
- char c 를 블록 "안에서" 선언 → 반복마다 새로 읽는 값이고 밖에서 쓸 일이 없으므로 범위를 좁혔다.
- 💡 do-while 은 조건을 나중에 검사하므로 cont 를 꼭 초기화할 필요는 없다.<br>단 그러면 if / else if / else 모든 경로에서 cont 에 값을 넣어야 컴파일된다.<br>그래서 그냥 true 로 초기화해 두는 편이 간단하다.

## \[실습] 숫자 맞히기 게임 반복하기

`4-2 반복문2` · 📄 [`NumberGuessingRepeat.java`](NumberGuessingRepeat.java)

앞서 실습한 숫자 맞히기 게임(NumberGuessing.java)에서 더 게임을 진행할지 물어보는 기능 추가.

#### 💻 코드

<!-- code: NumberGuessingRepeat.java -->
```java
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingRepeat {
    public static void main(String[] args) {
        Random rnd = new Random();
        int answer, guess;
        boolean cont;
        char programCont;
        Scanner sc = new Scanner(System.in);

        do {    // 바깥 반복문 추가, 제어하기 위해 programCont 변수 선언하여 사용
            answer = rnd.nextInt(100) + 1;  // ⚠ 수정 : 판마다 새 정답
            cont = true;                    // 판마다 다시 초기화
            System.out.println("게임을 시작합니다.");
            while (cont) {
                System.out.println("예측값 ? ");
                guess = sc.nextInt();
                if (guess > answer) System.out.println("정답보다 큽니다.");
                else if (guess < answer) System.out.println("정답보다 작습니다.");
                else {
                    System.out.println("정답입니다!!!");
                    cont = false;
                }
            }
            System.out.println("계속 하시겠습니까 ? ('y' or 'n') ");
            programCont = sc.next().charAt(0);
        } while (programCont == 'y');
        System.out.println("게임을 종료합니다.");
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
게임을 시작합니다.
예측값 ?
7
정답보다 작습니다.
예측값 ?
9
정답입니다!!!
계속 하시겠습니까 ? ('y' or 'n')
y
게임을 시작합니다.
예측값 ?
...
계속 하시겠습니까 ? ('y' or 'n')
n
게임을 종료합니다.
```

**구조 : 반복문 안의 반복문**

- 바깥 do-while : "게임 한 판" 을 반복   (programCont 로 제어)
- 안쪽 while    : "한 판 안에서 예측" 을 반복 (cont 로 제어)

**포인트**

- 새 판을 시작할 때마다 cont = true; 로 "다시 초기화" 해야 한다.<br>안 하면 직전 판에서 false 가 된 cont 때문에 안쪽 while 에 들어가지 못한다.<br>(퀴즈 3번 Σ·Π 에서 안쪽 누적 변수를 매번 초기화하는 것과 같은 이야기)
- 게임은 최소 한 판은 하므로 바깥은 do-while.

- ⚠ 자주 틀리는 부분: answer 를 바깥 do 앞에서 "한 번만" 만들면 두 번째 판부터 정답이 계속 같다.<br>새 판마다 새 숫자가 나오도록 answer 생성을 do 블록 안에 두었다.

## for 문 - 파이썬 for 문을 자바 for 문으로 / 증감식의 여러 형태

`4-3 반복문3` · 📄 [`ForSum.java`](ForSum.java)

#### 💻 코드

<!-- code: ForSum.java -->
```java
public class ForSum {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 10; i > 0; i--) {  // 한줄인 경우 중괄호 생략 가능
            sum += i;
        }
        System.out.println("합 : " + sum);

        // ===== 증감식의 여러 형태 =====
        int i;

        sum = 0;
        for (i = 1; i <= 10; i++) {         // 하나씩 증가
            sum = sum + i;
        }
        System.out.println("하나씩 증가 : " + sum);

        sum = 0;
        for (i = 10; i >= 1; i--) {         // 하나씩 감소
            sum = sum + i;
        }
        System.out.println("하나씩 감소 : " + sum);

        sum = 0;
        for (i = 1; i < 10; i = i + 3) {    // 세개씩 증가 (1 + 4 + 7)
            sum = sum + i;
        }
        System.out.println("세개씩 증가 : " + sum);
    }
}
```
<!-- /code -->

#### 실행 예

```text
합 : 55
하나씩 증가 : 55
하나씩 감소 : 55
세개씩 증가 : 12
```

**for 문**

- while 문과 함께 널리 쓰이는 반복문. 반복 횟수가 정해져 있을 때 주로 사용.
- 초기식 : 반복문이 실행되기 전에 초기화해야 할 내용. 반복문이 실행되기 전 딱 한 번 실행.
- 조건을 만족하면 반복 내용을 실행 후 증감식을 실행.

```java
for (초기식; 반복 조건; 증감식) {        (Python)  for 반복변수 in 시퀀스 :
    반복 내용                                         반복문장들
}
```

실행 순서 : ① 초기식(한 번) → ② 조건 검사 → ③ 반복 내용 → ④ 증감식 → ②로 ...

**파이썬으로 작성한 for 문**

sum = 0<br>for i in range(10, 0, -1):<br>sum += i<br>print("합 : " + str(sum))

초기식에서 누적 변수까지 선언하는 형태 : for (int sum = 0, i = 10; i > 0; i--)

- 💡 이렇게 sum 을 초기식에서 선언하면 sum 도 for 안에서만 쓰는 지역 변수가 되어 for 가 끝난 뒤 println("합 : " + sum) 을 쓰면 에러. → 결과를 밖에서 쓰려면 for 앞에서 선언.
- 💡 초기식에는 쉼표로 "같은 자료형 변수 여러 개 선언" 또는 "식 여러 개" 를 쓸 수 있다.<br>하지만 선언과 식을 섞을 수는 없다. (실습 반복문2-1번 참고)

**증감식의 여러 형태 (Python range 와 비교)**

```java
for (i = 1; i <= 10; i++)        ↔ range(1, 11)       1, 2, ..., 10   하나씩 증가
for (i = 10; i >= 1; i--)        ↔ range(10, 0, -1)   10, 9, ..., 1   하나씩 감소
for (i = 1; i < 10; i = i + 3)   ↔ range(1, 11, 3)    세개씩 증가
```


- ⚠ 세 번째 짝은 정확히 같지 않다. 자바 i &lt; 10 은 1, 4, 7 (10 제외),<br>파이썬 range(1, 11, 3) 은 1, 4, 7, 10. 같게 하려면 i &lt;= 10 으로 써야 한다.

## for 문 - 반복 변수의 범위 / 무한 반복

`4-3 반복문3` · 📄 [`ForScope.java`](ForScope.java)

for 문의 초기화 부분에서 선언한 반복 변수는 지역변수이기 때문에 for 문 내에서만 사용 가능.

```java
for (int cnt = 1; cnt <= 5; cnt++) {
    System.out.println("사랑합니다.");
}
System.out.println(cnt);   // 오류 (cannot find symbol)
```

→ 반복이 끝난 뒤에도 쓰려면 for 문 "앞에서" 선언한다. 아래 코드.<br>반복이 끝났을 때 cnt 는 마지막으로 조건 검사에 실패한 값인 6 이다.

- 💡 4-4 소수 판별의 if (i == n) 이 이 성질을 이용한다.

#### 💻 코드

<!-- code: ForScope.java -->
```java
public class ForScope {
    public static void main(String[] args) {
        int cnt;                            // for 앞에서 선언
        for (cnt = 1; cnt <= 5; cnt++) {
            System.out.println("사랑합니다.");
        }
        System.out.println("반복이 끝난 뒤 cnt = " + cnt);

        // for (int k = 1; k <= 5; k++) { }
        // System.out.println(k);           // 오류 : k 는 for 안에서만 사용 가능

        // ===== 무한 반복 =====
        int n = 0;
        for (;;) {
            n++;
            if (n == 3) break;
        }
        System.out.println("for(;;) " + n + "번 반복 후 break");
    }
}
```
<!-- /code -->

#### 실행 예

```text
사랑합니다.
사랑합니다.
사랑합니다.
사랑합니다.
사랑합니다.
반복이 끝난 뒤 cnt = 6
for(;;) 3번 반복 후 break
```

#### 📒 해설

- 📝 필기 (퀴즈 3번 - 선언을 반복문 밖에서 vs 안에서 하는 경우)
- 교수님 코드처럼 int prod; 를 반복문 밖에서 선언하고 안에서 prod = 1; 로 초기화하면 반복문이 끝나고도 변수 사용이 가능함.
- 반복문 안에서 선언하면 그 블록이 변수의 범위 → 블록 밖에서 쓰면 에러.
- 💡 선언(변수를 만드는 것)과 초기화(값을 넣는 것)는 별개다.<br>선언 위치 = 어디까지 쓸 것인가(범위), 초기화 위치 = 언제 값을 리셋할 것인가.
- 💡 안에서 선언한다고 느려지지 않는다 (성능 차이는 사실상 없음). 필요한 범위만큼 좁게 선언하는 게 권장.

무한 반복 : 반복 조건이 생략되면 항상 참이 되어 무한반복

```java
for (;;) {
    반복 내용들
}
```


- 초기식, 조건, 증감식 모두 생략 가능. 단 세미콜론 두 개는 남겨야 한다.
- for (;;) == while (true). 보통 안에서 break 로 빠져나온다. (퀴즈 1-④)

## \[실습] 특정 구구단 출력하기 (for 버전)

`4-3 반복문3` · 📄 [`MultiplicationTableFor.java`](MultiplicationTableFor.java)

구구단 프로그램(MultiplicationTableWhile.java)을 for 문으로 작성.

```java
while 버전                       for 버전
 int index = 1;          (초기식)
 while (index <= 9) {    (조건)    →   for (int index = 1; index <= 9; index++) {
     ...                                   ...
     index++;            (증감식)       }
 }
```

→ 세 줄에 흩어져 있던 반복 제어가 for 한 줄로 모였다.<br>반복 횟수(9번)가 정해져 있으므로 for 가 더 읽기 쉽다.

#### 💻 코드

<!-- code: MultiplicationTableFor.java -->
```java
import java.util.Scanner;

public class MultiplicationTableFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 단 ? ");
        int dan = sc.nextInt();
        sc.close();
        for (int index = 1; index <= 9; index++) {
            System.out.println(dan + " * " + index + " = " + dan * index);
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
원하는 단 ? 3
3 * 1 = 3
3 * 2 = 6
...
3 * 9 = 27
```

## \[실습] 팩토리얼 구하기

`4-3 반복문3` · 📄 [`Factorial.java`](Factorial.java)

1 \~ n 까지의 곱(n!)을 구한다.

#### 💻 코드

<!-- code: Factorial.java -->
```java
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("n의 값을 입력하시오. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int i, factorial;   // 큰숫자는 double형 선언해야 오버플로 발생 x
        for (i = 1, factorial = 1; i <= n; i++) {   // i=n, factorial=1; i >= 1; i--
            factorial = factorial * i;              // 위의 조건식은 감소 방법
        }
        System.out.println("1 ~ " + n + "까지의 곱은 " + factorial + "입니다.");
    }
}
```
<!-- /code -->

#### 실행 예

```text
n의 값을 입력하시오.
5
1 ~ 5까지의 곱은 120입니다.
```

**포인트**

- 초기식 i = 1, factorial = 1 : 식 두 개를 쉼표로 이어 썼다. 두 변수는 for 앞에서 선언.
- 주석의 i = n, factorial = 1; i >= 1; i-- 는 n 부터 1 까지 "감소" 하며 곱하는 방법.<br>곱셈은 순서와 상관없으므로 결과가 같다.

- 💡 오버플로 (코드 주석 : "큰숫자는 double형 선언해야 오버플로 발생 x")
- int 는 약 21억(2,147,483,647)까지만 담는다.<br>12! = 479,001,600 은 괜찮지만 13! = 6,227,020,800 은 범위를 넘어 1932053504 같은 엉뚱한 값이 나온다.
- double 은 아주 큰 수까지 "근사값" 으로 담는다.<br>정확한 정수가 필요하면 long (20! 까지 정확), 더 크면 java.math.BigInteger.

## \[실습] 1에서 n까지 3의 배수의 합 구하기

`4-3 반복문3` · 📄 [`MultipleSum.java`](MultipleSum.java)

#### 💻 코드

<!-- code: MultipleSum.java -->
```java
import java.util.Scanner;

public class MultipleSum {
    public static void main(String[] args) {
        System.out.println("n의 값을 입력하시오. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int i, sum = 0;
        for (i = 3; i <= n; i += 3) {
            sum = sum + i;
        }
        System.out.println(n + "까지의 3의 배수의 합은 " + sum + "입니다.");
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
n의 값을 입력하시오.
10
10까지의 3의 배수의 합은 18입니다.
```

**포인트**

- i 를 3 부터 "3씩 증가" (i += 3) → 3의 배수만 돈다.
- 💡 1 부터 하나씩 올리며 if (i % 3 == 0) 으로 검사해도 되지만,<br>3씩 건너뛰면 검사가 필요 없고 반복 횟수도 1/3 로 줄어든다.<br>과제 1번(3의 배수 출력)도 같은 방법이다.

## \[실습] 메뉴 반복 처리하기 (for 버전)

`4-3 반복문3` · 📄 [`MenuCalculatorFor.java`](MenuCalculatorFor.java)

앞서 실습한 while 문을 사용한 "메뉴 방식의 사칙 연산" 을 for 문으로 변경.

#### 💻 코드

<!-- code: MenuCalculatorFor.java -->
```java
import java.util.Scanner;

public class MenuCalculatorFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (boolean cont = true; cont == true; ) {     // 증감문은 생략
            System.out.println("a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료");
            char c = sc.next().charAt(0);

            if (c == 'q') {
                System.out.println("프로그램을 종료하였습니다.");
                cont = false;   // 무한루프를 종료
            }
            else if (!(c == 'a' || c == 's' || c == 'm' || c == 'd')) {
                System.out.println("유효하지 않는 메뉴입니다.");
            }
            else {
                System.out.println("첫 번째 숫자 (음수도 가능) >> ");
                int a = sc.nextInt();
                // ----- 강의 코드에서 생략(…)된 부분 -----
                System.out.println("두 번째 숫자 (음수도 가능) >> ");
                int b = sc.nextInt();

                double result;
                if (c == 'a') result = a + b;
                else if (c == 's') result = a - b;
                else if (c == 'm') result = a * b;
                else result = (double) a / b;
                // -----------------------------------
                System.out.println("결과는 " + result + "입니다.");
            }
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료
d
첫 번째 숫자 (음수도 가능) >>
7
두 번째 숫자 (음수도 가능) >>
2
결과는 3.5입니다.
a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료
q
프로그램을 종료하였습니다.
```

**포인트**

- 초기식에서 boolean 변수를 선언하고, 증감식은 비웠다. cont 값은 블록 안에서 바뀐다.
- cont == true 는 그냥 cont 와 같다 (boolean 변수는 그대로 조건식에 쓸 수 있다).
- 💡 반복 횟수가 정해지지 않은 문제라 while / do-while 이 더 자연스럽다.<br>"for 로도 쓸 수 있다 (표현력이 같다)" 를 보여 주는 예제.

## break 문

`4-4 반복문4` · 📄 [`BreakExample.java`](BreakExample.java)

반복문 사용시 특정 조건을 만족하여 더 이상 반복하지 않을 때 사용.

#### 💻 코드

<!-- code: BreakExample.java -->
```java
public class BreakExample {
    public static void main(String[] args) {
        int r;
        for (r = 0; r < 10; r++) {
            if (r == 3)
                break;
            System.out.print(r + " ");
        }
        System.out.println();
        System.out.println("break 후 r = " + r);
    }
}
```
<!-- /code -->

#### 실행 예

```text
0 1 2
break 후 r = 3
```

**포인트**

- break 는 가장 가까운(자신을 감싼) 반복문 "하나" 만 빠져나온다.<br>이중 반복문 안쪽에서 break 하면 바깥 반복은 계속된다 → PrimesBelowN.java
- break 로 빠져나오면 증감식(r++)도 실행되지 않는다 → r 은 4 가 아니라 3.
- 3주차 switch 의 break 와 같은 키워드. switch 안에서는 switch 를, 반복문 안에서는 반복문을 빠져나온다.

**📝 필기 (퀴즈 1-④)**

```java
x = 0; for (;;) { if (x > 10) break; System.out.print(x + " "); x++; }
```

정답은 0 1 2 3 4 5 6 7 8 9 10 .

  - 💡 break 검사가 출력보다 "앞에" 있다. x 가 11 이 되는 순간 출력 전에 빠져나오므로 10 까지 출력.

## \[실습] 소수 판별하기 (break)

`4-4 반복문4` · 📄 [`PrimeCheck.java`](PrimeCheck.java)

n 보다 작은 수 중 n 을 나누어 떨어지게 하는 수가 있으면 더 이상 반복 필요 X → break

i == n 으로 소수를 판단하는 이유

- 2 \~ n-1 중 나누어 떨어지는 수가 "없으면" 끝까지 돌고, 조건 i &lt; n 이 깨질 때 i 는 n.
- 나누어 떨어지는 수가 "있으면" break 로 중간에 나오므로 i 는 n 보다 작다.
- 반복이 끝난 뒤 i 를 써야 하므로 int i; 를 for 문 "밖에서" 선언했다. (4-3 반복 변수의 범위)

#### 💻 코드

<!-- code: PrimeCheck.java -->
```java
import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        System.out.println("n의 값을 입력하시오. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;
        for (i = 2; i < n; i++) {
            if ((n % i) == 0) break;
        }
        if (i == n) System.out.println("소수입니다.");
        else System.out.println("소수가 아닙니다.");
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
n의 값을 입력하시오.
17
소수입니다.
```

#### 📒 해설

- 💡 n = 1 이면 반복을 안 돌고 i = 2 ≠ 1 → "소수가 아닙니다" (1 은 소수가 아니므로 맞음)<br>n = 2 이면 i = 2 = n → "소수입니다" (맞음)
- 💡 실제로는 √n 까지만 검사해도 충분하다 (i \* i &lt;= n). 수업에서는 단순한 형태로 배웠다.

## continue 문 - 1 \~ 100 홀수의 합

`4-4 반복문4` · 📄 [`ContinueOddSum.java`](ContinueOddSum.java)

반복문 사용시 특정 조건을 만족하면 continue 이하 문장들은 실행 X → 바로 다음 반복으로.

#### 💻 코드

<!-- code: ContinueOddSum.java -->
```java
public class ContinueOddSum {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if ((i % 2) == 0) continue;
            sum += i;   // 짝수일때 실행되지 않음
        }
        System.out.println("홀수의 합 : " + sum);
    }
}
```
<!-- /code -->

#### 실행 예

```text
홀수의 합 : 2500
```

**포인트**

- for 에서 continue 를 만나면 증감식(i++)으로 이동한 뒤 조건을 검사한다.
- 💡 while 에서 continue 를 쓸 때는 조심. 증감 문장이 continue "아래" 에 있으면 건너뛰어져서 i 가 바뀌지 않아 무한루프가 될 수 있다.
- break 는 반복을 "끝내고", continue 는 이번 회차만 "건너뛴다".

- 💡 출력 "홀수의 합" + sum 은 "홀수의 합2500" 처럼 붙어서 나온다. " : " 을 넣었다.

## 이중 for 문 - 별 찍기 (사각형, 삼각형)

`4-4 반복문4` · 📄 [`StarPattern.java`](StarPattern.java)

이중 for 문 : for 문 안에 또 다른 for 문이 중첩되어 있는 형태

#### 💻 코드

<!-- code: StarPattern.java -->
```java
public class StarPattern {
    public static void main(String[] args) {
        int r, c;

        System.out.println("=== 결과 ===");
        for (r = 0; r < 5; r++) {
            for (c = 0; c < 5; c++)
                System.out.print("*");
            System.out.println("");
        }

        System.out.println("=== 결과 ===");
        for (r = 0; r < 5; r++) {
            for (c = 0; c < (r + 1); c++)   // ⚠ 수정 : c < (r+1)) → c < (r + 1)
                System.out.print("*");
            System.out.println("");
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
=== 결과 ===
*****
*****
*****
*****
*****
=== 결과 ===
*
**
***
****
*****
```

**이중 반복문 읽는 법**

- 바깥 반복 = 행(row), 안쪽 반복 = 열(column)
- 바깥이 한 번 돌 때 안쪽은 처음부터 끝까지 다 돈다. 5×5 면 print("\*") 가 25번.
- 안쪽 for 가 끝난 뒤 println 으로 줄을 바꾼다.
- 삼각형 : 안쪽 조건이 바깥 변수(r)에 따라 달라진다. r행에는 r+1 개의 별.

**📝 필기 (퀴즈 1-③)**

```java
for (x = 0; x < 3; x++) { for (y = 0; y <= 2; y++) System.out.println(x); System.out.println(); }
```

바깥 x는 0 → 1 → 2  안쪽 y는 매번 0 → 1 → 2.<br>정답은 000(줄바꿈)111(줄바꿈)222(줄바꿈).

  - ⚠ 주의 : 정확히는 안쪽이 println(x) 라서 숫자마다 줄이 바뀐다 → 퀴즈 파일(IterationQuiz.q1\_3) 참고.

## \[실습] 구구단 전체 출력하기 (이중 for 문)

`4-4 반복문4` · 📄 [`MultiplicationTableAll.java`](MultiplicationTableAll.java)

4-1, 4-3 의 "특정 구구단 출력하기" 는 단(dan)을 입력받았다.<br>이번에는 단을 바깥 for 로 2 \~ 9 까지 돌리면서, 안쪽에 그 코드를 그대로 넣었다.

```text
바깥 for (dan)   : 2 → 3 → ... → 9
```

안쪽 for (index) : 매번 1 → 9<br>→ println 은 8 × 9 = 72 번 실행된다.

#### 💻 코드

<!-- code: MultiplicationTableAll.java -->
```java
public class MultiplicationTableAll {
    public static void main(String[] args) {
        int dan, index;
        for (dan = 2; dan <= 9; dan++) {
            System.out.println(dan + "단");
            for (index = 1; index <= 9; index++) {
                System.out.println(dan + " * " + index + " = " + dan * index);
            }
            System.out.println("");
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
2단
2 * 1 = 2
2 * 2 = 4
...
2 * 9 = 18

3단
3 * 1 = 3
...
9 * 9 = 81
```

## \[실습] n보다 작은 소수 찾기 (이중 for 문 + break)

`4-4 반복문4` · 📄 [`PrimesBelowN.java`](PrimesBelowN.java)

"소수 판별하기"(PrimeCheck.java)를 바깥 for 로 감싸서 2 \~ n-1 의 모든 수(p)를 검사한다.

#### 💻 코드

<!-- code: PrimesBelowN.java -->
```java
import java.util.Scanner;

public class PrimesBelowN {
    public static void main(String[] args) {
        System.out.println("n의 값을 입력하시오. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String result = "";
        int i, p;
        for (p = 2; p < n; p++) {
            for (i = 2; i < p; i++) {
                if ((p % i) == 0) break;    // 안쪽 for 만 빠져나옴
            }
            if (i == p) result = result + " " + p;
        }
        System.out.println(n + " 보다 작은 소수 : " + result);
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
n의 값을 입력하시오.
100
100 보다 작은 소수 :  2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
```

**포인트**

- 안쪽 for 의 break 는 "안쪽 for 만" 빠져나온다. 바깥 for(p)는 계속 돈다.
- result = result + " " + p : 문자열에 소수를 이어 붙여 두었다가 마지막에 한 번에 출력.<br>첫 소수 앞에도 공백이 붙어서 ":" 뒤에 공백이 두 칸 나온다.

- ⚠ 자주 틀리는 부분: String result = "1"; / for (p = 3; ...) 처럼 시작하면 결과가 "1 3 5 7 11 ..." 로 나온다.<br>→ 1 은 소수가 아니고, 2 (유일한 짝수 소수)가 빠진다. result = "", p = 2 에서 시작해야 한다.

## foreach 문 / \[실습] 학생 성적 처리하기

`4-4 반복문4` · 📄 [`ForEach.java`](ForEach.java)

#### 💻 코드

<!-- code: ForEach.java -->
```java
public class ForEach {
    public static void main(String[] args) {
        // ===== foreach 문 =====
        int[] array = {88, 67, 56, 77, 99, 90, 44};
        int total = 0;
        for (int number : array)    // foreach : for(자료형 변수 : 배열 또는 컬렉션)
            total += number;
        System.out.println(total);

        // foreach를 for문으로
        total = 0;                  // ⚠ 추가
        for (int counter = 0; counter < array.length; counter++)
            total += array[counter];
        System.out.println(total);

        // ===== [실습] 학생 성적 처리하기 =====
        double avg;
        int max = 0, min = 100, sum = 0;

        for (int number : array) {
            sum += number;
            if (number > max) max = number;
            if (number < min) min = number;
        }
        avg = ((double) sum) / array.length;
        System.out.println("평균 : " + avg);
        System.out.println("최고 : " + max);
        System.out.println("최저 : " + min);
    }
}
```
<!-- /code -->

#### 실행 예

```text
521
521
평균 : 74.42857142857143
최고 : 99
최저 : 44
```

**foreach 문**

- 배열이나 컬렉션에 있는 모든 요소에 대해 반복하는 문장
- 인덱스를 사용하여 직접 접근 X
- 배열 요소의 개수에 딱 맞게 루프를 돌리는 작업

```java
 for (자료형 변수 : 배열 또는 컬렉션)        (Python)  for number in array :

              foreach                       일반 for
형식          for (int number : array)      for (int i = 0; i < array.length; i++)
요소 접근     number                        array[i]
인덱스        없음                          i
값 바꾸기     불가 (복사본)                 가능 (array[i] = 0)
```

- array.length : 배열의 요소 개수 (여기서는 7). 인덱스는 0 \~ length-1. (배열은 5주차)
- 인덱스가 필요하거나, 값을 바꾸거나, 거꾸로 돌 때는 일반 for 를 쓴다.

- ⚠ 자주 틀리는 부분: 두 번째 반복(foreach 를 for 문으로) 전에 total = 0; 으로 되돌려야 한다.<br>빠뜨리면 첫 번째 합에 이어서 더해져 두 번째 출력이 521 이 아니라 1042 가 된다.

**\[실습] 학생 성적 처리하기**

- 4-1 "성적 처리"(while) 와 같은 문제. 이번엔 입력 대신 배열의 값을 foreach 로 돈다.
- max 는 0, min 은 100 으로 시작 → 첫 요소가 무조건 max, min 을 갱신.<br>(4-1 에서는 -1, 101. 둘 다 "나올 수 있는 값의 바깥" 이라 결과는 같다)
- ((double) sum) / array.length : sum 을 double 로 바꾼 뒤 나눠서 실수 결과.

---

[🏠 4주차 학습 가이드](../../README.md)
