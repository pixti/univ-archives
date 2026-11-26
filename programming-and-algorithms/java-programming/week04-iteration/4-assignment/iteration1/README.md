# 4주차 과제 · iteration1

[🏠 4주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [Fibonacci.java](#반복문1---3번-문제) | 반복문1 - 3번 문제 |
| [FibonacciRefactored.java](#반복문1---3번-문제-리팩터링-버전) | 반복문1 - 3번 문제 (리팩터링 버전) |
| [MultiplesOfThree.java](#반복문1---1번-문제) | 반복문1 - 1번 문제 |
| [MultiplesOfThreeRefactored.java](#반복문1---1번-문제-리팩터링-버전) | 반복문1 - 1번 문제 (리팩터링 버전) |
| [PythagoreanTriple.java](#반복문1---2번-문제) | 반복문1 - 2번 문제 |
| [PythagoreanTripleRefactored.java](#반복문1---2번-문제-리팩터링-버전) | 반복문1 - 2번 문제 (리팩터링 버전) |
| [RockPaperScissorsRepeat.java](#반복문1---4번-문제) | 반복문1 - 4번 문제 |
| [RockPaperScissorsRepeatRefactored.java](#반복문1---4번-문제-리팩터링-버전) | 반복문1 - 4번 문제 (리팩터링 버전) |

---

## 반복문1 - 3번 문제

`4강 과제` · 📄 [`Fibonacci.java`](Fibonacci.java)

#### 문제

> ※ 반복 시 while 이나 do while 문만 사용하시오.
>
> 피보나치 수열은 앞의 2 개의 원소를 합하여 다음 원소를 만드는 방식으로 만든 수열이다.<br>피보나치 수열의 처음 두 수는 0 과 1 이다. 5000 보다 작은 피보나치 수를 생성하여 출력하는 프로그램을 작성하라.

#### 💻 코드

<!-- code: Fibonacci.java -->
```java
public class Fibonacci {
    public static void main(String[] args) {

        int a = 0, b = 1, c;
        while (a < 5000) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181
```

**포인트**

- 변수 세 개로 "한 칸씩 밀기"<br>a : 지금 출력할 수, b : 그다음 수, c : 임시 (a + b)

```text
a   b   c=a+b     →  a=b, b=c
0   1   1            1   1
1   1   2            1   2
1   2   3            2   3
2   3   5            3   5   ...
```

- c 에 먼저 담아 두는 이유 : a = b; 를 먼저 하면 원래 a 값이 사라져서 a + b 를 계산할 수 없다.
- 출력이 계산보다 먼저 → 조건 a &lt; 5000 을 통과한 a 만 출력된다.
- 몇 번 반복할지 미리 알 수 없다 (값이 5000 을 넘을 때까지) → while 이 자연스럽다.

- 💡 for 버전과 for 로 옮기다 생긴 버그 → iteration2/FibonacciFor.java

## 반복문1 - 3번 문제 (리팩터링 버전)

`4강 과제` · 📄 [`FibonacciRefactored.java`](FibonacciRefactored.java)

#### 문제

> ※ 반복 시 while 이나 do while 문만 사용하시오.
>
> Fibonacci.java 를 리팩터링한 코드.

#### 💻 코드

<!-- code: FibonacciRefactored.java -->
```java
public class FibonacciRefactored {

    // 피보나치 수열의 상한을 상수로 분리해 의도를 명확히 합니다.
    private static final int MAX_TERMINATION = 5000;

    public static void main(String[] args) {
        // 피보나치 수열의 초기 두 항
        long previous = 0;
        long current = 1;

        // 피보나치 수열의 각 항을 출력하고, MAX_TERMINATION 미만일 때만 진행
        while (shouldContinue(previous, current)) {
            // 현재 항 출력: 공백으로 구분된 한 줄 출력 형식 유지
            System.out.print(previous + " ");

            // 다음 항 계산: next = previous + current
            long next = previous + current;

            // 시퀀스 업데이트: (previous, current) = (current, next)
            previous = current;
            current = next;
        }

        // 출력 종료를 위한 줄바꿈
        System.out.println();
    }

    // 루프의 다음 반복을 계속할지 결정합니다.
    private static boolean shouldContinue(long prev, long curr) {   // ⚠ curr 미사용
        return prev < MAX_TERMINATION;
    }
}
```
<!-- /code -->

#### 실행 예

```text
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181
```

**바뀐 점**

- 상한 5000 → 상수 MAX\_TERMINATION
- 변수 이름 a, b, c → previous, current, next (역할이 이름에 드러난다)
- int → long : 상한을 크게 바꿔도 오버플로가 늦게 일어나도록. (int 는 약 21 억, long 은 약 922 경)
- 반복 조건을 메소드로 분리 : shouldContinue(previous, current)
- next 를 반복문 안에서 선언 → 반복마다 새로 만들어지는 임시 변수임이 드러난다.
- 마지막에 줄바꿈 추가.

- ⚠ shouldContinue(long prev, long curr) 의 curr 매개변수는 쓰이지 않는다. (prev 만 비교)<br>Eclipse 의 노란 밑줄이 그 표시. 조건이 이렇게 단순하면 while (previous &lt; MAX\_TERMINATION) 이 더 읽기 쉽다.

#### 📎 `shouldContinue` 설명

루프의 다음 반복을 계속할지 결정합니다.<br>이 구현은 출력하는 현재 항(previous)이 MAX\_TERMINATION 미만인 경우에만 true를 반환합니다.<br>즉, 0, 1, 1, 2, 3, 5, 8, ... 이 값들이 MAX\_TERMINATION 미만일 때만 출력합니다.

## 반복문1 - 1번 문제

`4강 과제` · 📄 [`MultiplesOfThree.java`](MultiplesOfThree.java)

#### 문제

> ※ 반복 시 while 이나 do while 문만 사용하시오.
>
> 특정한 정수를 읽어 들여서 0 과 이 정수 사이에 있는 모든 3 의 배수를 출력하는 프로그램을 작성하라.<br>만약 입력 정수의 값이 0 보다 작으면 오류 메시지를 출력하라.

#### 💻 코드

<!-- code: MultiplesOfThree.java -->
```java
import java.util.Scanner;

public class MultiplesOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num, i;
        System.out.print("정수를 입력하세요 : ");
        num = sc.nextInt();

        if (num < 0) {
            System.out.println("오류");
        } else {
            i = 3;

            while (i <= num) {
                System.out.println("[" + i + "]");
                i += 3;
            }
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 문제의 실행 예

```text
정수를 입력하세요 : 40
[3]
[6]
...
[36]
[39]
```

#### 실행 예

```text
정수를 입력하세요 : 16
[3]
[6]
[9]
[12]
[15]
```

**포인트**

- i 를 3 부터 시작해서 3 씩 증가 → 3 의 배수만 돈다.<br>(1 부터 1 씩 증가하며 if (i % 3 == 0) 으로 거르는 방법도 있지만 반복 횟수가 3 배)
- 0 은 3 의 배수이지만 문제의 출력 예가 \[3] 부터 시작하므로 i = 3 에서 시작했다.
- 입력이 0 \~ 2 이면 조건 i &lt;= num 이 처음부터 거짓 → 아무것도 출력하지 않는다.
- i 는 else 블록 안에서만 쓰지만, 선언은 블록 밖에서 했다. (int num, i;)<br>블록 안에서 int i = 3; 으로 선언해도 된다. (퀴즈 "선언 위치" 참고)

- 💡 리팩터링 버전 → MultiplesOfThreeRefactored.java

## 반복문1 - 1번 문제 (리팩터링 버전)

`4강 과제` · 📄 [`MultiplesOfThreeRefactored.java`](MultiplesOfThreeRefactored.java)

#### 문제

> ※ 반복 시 while 이나 do while 문만 사용하시오.
>
> MultiplesOfThree.java 를 리팩터링한 코드.

#### 💻 코드

<!-- code: MultiplesOfThreeRefactored.java -->
```java
import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiplesOfThreeRefactored {

    // 3의 배수를 출력하는 한정된 범위 로직의 상수
    private static final int MULTIPLE = 3;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer inputNumber = readPositiveInteger(sc);
            if (inputNumber == null) {          // ⚠ dead code : null 이 반환되는 경로가 없다
                // 사용자가 입력을 포기했거나 비정상 입력으로 종료
                System.out.println("프로그램을 종료합니다.");
                return;
            }

            // 0은 3의 배수가 아니므로 출력 대상이 아닙니다(의도 명확화)
            //   (💡 수학적으로 0 은 3 의 배수다. "출력 대상이 아니다" 만 맞는 말)
            printMultiplesOfThreeUpTo(inputNumber);
        } // try-with-resources 구문으로 Scanner 자동 닫힘
    }

    // 사용자가 입력한 양의 정수 하나를 반환합니다.
    private static Integer readPositiveInteger(Scanner sc) {
        while (true) {
            System.out.print("정수를 입력하세요 : ");

            try {
                int value = sc.nextInt();
                if (value > 0) {
                    return value;               // int → Integer 자동 변환 (오토박싱)
                } else {
                    // 0 또는 음수인 경우
                    System.out.println("오류: 양의 정수를 입력해야 합니다.");
                    // 계속해서 재입력 받음
                }
            } catch (InputMismatchException e) {
                // 정수가 아닌 입력이 들어온 경우 버퍼를 비우고 재입력 요청
                System.out.println("오류: 정수를 입력해야 합니다.");
                sc.next(); // 입력 버퍼 정리
            }
        }
    }

    // 3의 배수들 중 입력값 이하까지 출력합니다.
    private static void printMultiplesOfThreeUpTo(int limit) {
        for (int i = MULTIPLE; i <= limit; i += MULTIPLE) {
            System.out.println("[" + i + "]");
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
정수를 입력하세요 : 19
[3]
[6]
[9]
[12]
[15]
[18]
```

**바뀐 점**

- 매직 넘버 3 → 상수 MULTIPLE (private static final)
- 입력 / 출력을 메소드로 분리 : readPositiveInteger(), printMultiplesOfThreeUpTo()
- try-with-resources : try (Scanner sc = ...) { } 가 끝나면 sc.close() 가 자동 호출된다.
- 잘못된 입력 처리
    - 정수가 아닌 입력 (예 : abc) → nextInt() 가 InputMismatchException 을 던진다.<br>catch 에서 메시지를 출력하고 sc.next() 로 잘못된 토큰을 버린 뒤 다시 입력받는다.<br>(sc.next() 를 빼면 같은 "abc" 를 계속 읽어서 무한 반복)
    - 0 이하 → 오류 메시지 출력 후 다시 입력받는다.
- Integer (참조형) 를 반환 → null 로 "값 없음" 을 표현할 수 있다.

- ⚠ 과제 조건 위반 : printMultiplesOfThreeUpTo() 가 for 문을 사용한다.<br>(반복문1 과제는 while / do-while 만 허용) 아래 주석에 while 버전을 함께 적었다.
- ⚠ readPositiveInteger() 는 양수를 받을 때까지 while (true) 로 반복하므로 null 을 반환하는 경우가 없다.<br>→ main 의 if (inputNumber == null) 은 실행될 일이 없는 코드(dead code).<br>Javadoc 의 "음수이거나 0인 경우에는 null을 반환" 도 실제 동작(재입력 요청)과 다르다.
- ⚠ 문제는 "0 보다 작으면 오류" 인데, 이 버전은 0 도 오류로 처리한다. (MultiplesOfThree.java 는 0 이면 아무것도 출력 안 함)<br>0 은 출력할 3 의 배수가 없으니 결과 차이는 오류 메시지뿐.

#### 📎 `readPositiveInteger` 설명

사용자가 입력한 양의 정수 하나를 반환합니다.

```text
입력이 음수이거나 0인 경우에는 null을 반환하여 호출부에서 명확히 처리합니다.   ← ⚠ 실제로는 재입력
 입력이 정수가 아닐 경우 재입력을 요청하는 루프를 통해 안정적으로 입력받습니다.
```

#### 📎 `printMultiplesOfThreeUpTo` 설명

3의 배수들 중 입력값 이하까지 출력합니다.<br>예: 입력이 12면 \[3], \[6], \[9], \[12] 출력

- ⚠ 반복문1 과제 조건(while / do-while 만)에 맞추려면 :
  ```java
  int i = MULTIPLE;
  while (i <= limit) {
      System.out.println("[" + i + "]");
      i += MULTIPLE;
  }
  ```

## 반복문1 - 2번 문제

`4강 과제` · 📄 [`PythagoreanTriple.java`](PythagoreanTriple.java)

#### 문제

> ※ 반복 시 while 이나 do while 문만 사용하시오.
>
> 피타고라스의 정리는 직각 삼각형에서 직각을 낀 두 변의 길이를 a, b 라고 하고, 빗변의 길이를 c 라고 하면 a^2 + b^2 = c^2 의 수식이 성립한다는 것이다. 각 변의 길이가 100 보다 작은 삼각형 중에서 피타고라스 정리가 성립하는 직각 삼각형은 몇 개나 있을까? 3 중 반복문을 이용하여 피타고라스 정리를 만족하는 3 개의 정수 각각을 출력하도록 한다.

#### 💻 코드

<!-- code: PythagoreanTriple.java -->
```java
public class PythagoreanTriple {
    public static void main(String[] args) {

        int a, b, c = 1, count = 0;
        while (c <= 100) {          // c가 1~100 까지 반복
            a = 1;
            while (a < c) {         // a가 1~c-1까지 반복
                b = 1;
                while (b < c) {     // b가 1~c-1까지 반복
                    if (a * a + b * b == c * c) { System.out.println(c + " : " + a + " : " + b); count++; }
                    b++;
                }
                a++;
            }
            c++;
        }
        System.out.println("총 " + count + "개");
    }
}
```
<!-- /code -->

#### 문제의 실행 예 (끝부분)

```text
85 : 36 : 77
...
100 : 96 : 28
총 104개
```

#### 실행 예 (끝부분)

```text
91 : 84 : 35
95 : 57 : 76
95 : 76 : 57
97 : 65 : 72
97 : 72 : 65
100 : 28 : 96
100 : 60 : 80
100 : 80 : 60
100 : 96 : 28
총 104개
```

**📝 필기 (코드 주석)**

- while (c &lt;= 100) {  // c가 1\~100 까지 반복
- while (a &lt; c) {     // a가 1\~c-1까지 반복
- while (b &lt; c) {     // b가 1\~c-1까지 반복

**포인트**

- 빗변 c 가 가장 긴 변이므로 a, b 는 c 보다 작은 값만 보면 된다. (a &lt; c, b &lt; c)
- while 로 3 중 반복을 만들 때는 안쪽 변수를 바깥 반복 안에서 다시 1 로 초기화해야 한다.
  ```text
  a = 1;  ← c 가 바뀔 때마다     b = 1;  ← a 가 바뀔 때마다
  ```<br>(빼먹으면 두 번째 c 부터 안쪽 반복이 돌지 않는다. 실습 Pyramid 의 col = 0; 과 같은 이야기)
- 제곱은 a \* a 로 계산. (Math.pow 는 double 을 돌려줘서 == 비교에 부적합)

- 💡 (a, b) 와 (b, a) 를 모두 센다. 예 : 5 : 3 : 4 와 5 : 4 : 3 → 그래서 총 104 개.<br>순서를 무시한 서로 다른 삼각형은 52 개. (리팩터링 버전 PythagoreanTripleRefactored 참고)<br>문제의 출력 예도 104 개라 이 방식이 의도된 답.
- 💡 문제는 "100 보다 작은" 이지만 출력 예에 100 : 28 : 96 이 있으므로 c &lt;= 100 으로 맞췄다.
- 💡 반복 횟수 : c 마다 (c-1)² 번 → 약 100 × 100 × 100 / 3 ≈ 33 만 번. 컴퓨터에게는 순식간.

## 반복문1 - 2번 문제 (리팩터링 버전)

`4강 과제` · 📄 [`PythagoreanTripleRefactored.java`](PythagoreanTripleRefactored.java)

#### 문제

> ※ 반복 시 while 이나 do while 문만 사용하시오.
>
> PythagoreanTriple.java 를 리팩터링한 코드.

#### 💻 코드

<!-- code: PythagoreanTripleRefactored.java -->
```java
public class PythagoreanTripleRefactored {

    // 탐색에 사용할 상수: 피타고라스 관계를 만족하는 세 변수 중 두 다리는 a, b고, 빗변은 c로 표현합니다.
    private static final int MAX_C = 100;
    private static final int PERYIM = 3; // 3의 배수 검증에 사용되는 기본 증가량   ← ⚠ 사용되지 않음

    public static void main(String[] args) {
        int count = 0;

        // c는 빗변으로 가정하며, 1부터 MAX_C까지 확인
        for (int c = 1; c <= MAX_C; c++) {
            // a와 b는 각각 루프를 통해 피타고라스 비교를 수행
            // a는 1부터 c-1까지, b는 a+1부터 c-1까지로 순서를 고정해 중복 탐색 제거
            for (int a = 1; a < c; a++) {
                for (int b = a + 1; b < c; b++) {
                    if (isPythagoreanTriple(a, b, c)) {
                        System.out.println("c = " + c + ", a = " + a + ", b = " + b);
                        count++;
                    }
                }
            }
        }

        System.out.println("총 " + count + "개");
    }

    /**
     * 피타고라스 삼각식 a^2 + b^2 = c^2를 만족하는지 검사합니다.
     * 주어진 입력이 양의 정수라고 가정하고, 필요 시 호출부에서 사전 조건을 확인합니다.
     */
    private static boolean isPythagoreanTriple(int a, int b, int c) {
        // (a^2 + b^2)와 (c^2)의 값을 비교
        int lhs = a * a + b * b;    // lhs : left-hand side (좌변)
        int rhs = c * c;            // rhs : right-hand side (우변)
        return lhs == rhs;
    }
}
```
<!-- /code -->

#### 실행 예 (끝부분)

```text
c = 95, a = 57, b = 76
c = 97, a = 65, b = 72
c = 100, a = 28, b = 96
c = 100, a = 60, b = 80
총 52개
```

**바뀐 점**

- 상한 100 → 상수 MAX\_C
- 판정 로직을 메소드로 분리 : isPythagoreanTriple(a, b, c)  → if 문이 "읽히는" 코드가 된다.
- b 를 a + 1 부터 시작 → 항상 a &lt; b 인 조합만 검사.<br>(3, 4) 와 (4, 3) 중 하나만 세므로 순서만 다른 중복이 사라진다.<br>→ 총 104 개 → 52 개. 출력 형식도 "c = 5, a = 3, b = 4" 로 바뀌었다.
- 💡 a = b 인 경우(2a² = c²)는 정수해가 없으므로(√2 는 무리수) b 를 a+1 부터 시작해도 빠지는 답이 없다.

- ⚠ 과제 조건 위반 : 3 중 반복을 for 로 작성했다. (반복문1 과제는 while / do-while 만 허용)
- ⚠ PERYIM 상수는 선언만 하고 쓰지 않는다. (Eclipse 노란 경고 : "The value of the field is not used")<br>주석도 "3의 배수 검증에 사용되는 기본 증가량" 이라 1 번 문제(3 의 배수)에서 잘못 섞여 들어온 것으로 보인다.
- ⚠ 문제의 출력 예(104 개, "c : a : b" 형식)와 결과가 달라졌다. 원래 답과 맞추려면 b = 1 부터.

## 반복문1 - 4번 문제

`4강 과제` · 📄 [`RockPaperScissorsRepeat.java`](RockPaperScissorsRepeat.java)

#### 문제

> ※ 반복 시 while 이나 do while 문만 사용하시오.
>
> 조건문 과제에서 가위 바위 보 게임을 반복 수행하는 프로그램을 작성하시오.<br>한 번 끝나면 사용자에게 "계속 하시겠습니까? ('y' or 'n')" 라는 안내문을 내주고, 'y' 이면 새 게임을 진행하고, 'n' 이면 프로그램을 종료토록 한다.

#### 💻 코드

<!-- code: RockPaperScissorsRepeat.java -->
```java
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int user, com;
        String answer = "y";

        while (answer.equals("y")) {
            System.out.print("가위(1), 바위(2), 보(3) : ");
            user = sc.nextInt();
            com = random.nextInt(3) + 1;

            System.out.print("컴퓨터 : ");

            if (com == 1) {
                System.out.println("가위");
            } else if (com == 2) {
                System.out.println("바위");
            } else {
                System.out.println("보");
            }

            if (user == com) {
                System.out.println("비겼습니다.");
            } else if ((user == 1 && com == 3) || (user == 2 && com == 1) || (user == 3 && com == 2)) {
                System.out.println("이겼습니다.");
            } else {
                System.out.println("졌습니다.");
            }
            System.out.print("계속 하시겠습니까? (y or n) : ");
            answer = sc.next();
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
가위(1), 바위(2), 보(3) : 3
컴퓨터 : 보
비겼습니다.
계속 하시겠습니까? (y or n) : n
```

**포인트**

- 3주차 조건문 과제(week03-conditionals/4-assignment/conditionals2/RockPaperScissors.java) 를 while 로 감싼 것.
- answer 를 "y" 로 초기화 → 첫 판은 무조건 실행된다.<br>(while 은 조건을 먼저 검사하므로 초기값이 없으면 컴파일 에러, "n" 이면 한 판도 안 함)
  - 💡 "무조건 1번 실행" 이니 do-while 이 더 어울리는 문제. (4-2 cont 초기화 비교 표)
- 문자열 비교는 == 가 아니라 equals(). (== 는 같은 객체인지 비교)
- random.nextInt(3) 은 0, 1, 2 중 하나 → + 1 해서 1, 2, 3.
- 승리 조건 : 가위(1) > 보(3), 바위(2) > 가위(1), 보(3) > 바위(2)

- 💡 "Y" (대문자) 를 넣으면 equals("y") 가 거짓이라 종료된다.<br>대소문자를 모두 받으려면 answer.equalsIgnoreCase("y").
- 💡 1 \~ 3 이 아닌 수를 넣어도 검사하지 않는다. (예 : 5 → 비기지도 이기지도 않으니 "졌습니다.")<br>리팩터링 버전에서 isValidMove() 로 검사한다.

- 💡 리팩터링 버전 → RockPaperScissorsRepeatRefactored.java

## 반복문1 - 4번 문제 (리팩터링 버전)

`4강 과제` · 📄 [`RockPaperScissorsRepeatRefactored.java`](RockPaperScissorsRepeatRefactored.java)

#### 문제

> ※ 반복 시 while 이나 do while 문만 사용하시오.
>
> RockPaperScissorsRepeat.java 를 리팩터링한 코드.

#### 💻 코드

<!-- code: RockPaperScissorsRepeatRefactored.java -->
```java
import java.util.InputMismatchException;
import java.util.Scanner;

public class RockPaperScissorsRepeatRefactored {

    // 가위/바위/보를 나타내는 상수
    private static final int SCISSOR = 1;
    private static final int ROCK    = 2;
    private static final int PAPER   = 3;

    // 게임 종료 여부의 공통 상수
    private static final String CONTINUE_YES = "y";
    private static final String CONTINUE_NO  = "n";

    // 컴퓨팅 엔트로피를 위한 난수 생성기
    // (필요 시 Random 대신 SecureRandom으로 바꿀 수 있음)       ← ⚠ 해당 필드 없음 (Math.random() 사용)
    // 의도: 사용자의 재시작 여부에 따라 게임 루프를 반복
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean continuePlaying = true;

            while (continuePlaying) {
                int userChoice = promptUserChoice(sc);
                int computerChoice = generateComputerChoice();

                System.out.print("컴퓨터 : ");
                printMove(computerChoice);

                printResult(userChoice, computerChoice);

                continuePlaying = shouldContinue(sc);
            }
        }
    }

    /**
     * 사용자 입력을 받아 가위(1)/바위(2)/보(3) 중 하나를 반환합니다.
     * 입력이 잘못되면 재입력을 요청합니다.
     */
    private static int promptUserChoice(Scanner sc) {
        while (true) {
            System.out.print("가위(1), 바위(2), 보(3) : ");
            try {
                int choice = sc.nextInt();
                if (isValidMove(choice)) {
                    return choice;
                } else {
                    System.out.println("오류: 1, 2, 또는 3 중 하나를 입력해야 합니다.");
                }
            } catch (InputMismatchException e) {
                // 잘못된 타입의 입력 처리
                System.out.println("오류: 정수를 입력해야 합니다.");
                sc.next(); // 입력 버퍼 정리
            }
        }
    }

    /**
     * 컴퓨터의 가위/바위/보 선택을 1~3 사이의 난수로 생성합니다.
     */
    private static int generateComputerChoice() {
        // 1~3 중 임의의 정수 반환
        return (int) (Math.random() * 3) + 1;
    }

    /**
     * 입력된 값이 가위/바위/보(1/2/3) 중 하나인지 검사합니다.
     */
    private static boolean isValidMove(int move) {
        return move == SCISSOR || move == ROCK || move == PAPER;
    }

    /**
     * 플레이어의 선택에 따라 컴퓨터의 선택을 출력합니다.
     */
    private static void printMove(int move) {
        switch (move) {
            case SCISSOR:
                System.out.println("가위");
                break;
            case ROCK:
                System.out.println("바위");
                break;
            case PAPER:
                System.out.println("보");
                break;
            default:
                // 이 경로는 이론상 호출되지 않지만 안전하게 처리
                System.out.println("알 수 없음");
        }
    }

    /**
     * 가위바위보의 승패를 판단하고 결과를 출력합니다.
     */
    private static void printResult(int user, int computer) {
        if (user == computer) {
            System.out.println("비겼습니다.");
        } else if ((user == SCISSOR && computer == PAPER) ||
                   (user == ROCK && computer == SCISSOR) ||
                   (user == PAPER && computer == ROCK)) {
            System.out.println("이겼습니다.");
        } else {
            System.out.println("졌습니다.");
        }
    }

    /**
     * 사용자의 의사에 따라 게임을 계속할지 결정합니다.
     * 입력이 아닌 다른 문자나 공백이 들어오면 재입력을 요청합니다.
     */
    private static boolean shouldContinue(Scanner sc) {
        while (true) {
            System.out.print("계속 하시겠습니까? (y or n) : ");
            String answer = sc.next().trim().toLowerCase();
            if (CONTINUE_YES.equals(answer)) {
                return true;
            } else if (CONTINUE_NO.equals(answer)) {
                return false;
            } else {
                System.out.println("오류: 'y' 또는 'n'으로 답해 주세요.");
            }
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
가위(1), 바위(2), 보(3) : 2
컴퓨터 : 보
졌습니다.
계속 하시겠습니까? (y or n) : n
```

**바뀐 점**

- 1, 2, 3 → 상수 SCISSOR, ROCK, PAPER  /  "y", "n" → CONTINUE\_YES, CONTINUE\_NO
- 역할별 메소드 분리
  ```text
  promptUserChoice()        : 사용자 입력 (잘못된 값이면 재입력)
  ```<br>generateComputerChoice()  : 컴퓨터 선택 (난수)
  ```text
  printMove()               : 숫자 → 가위/바위/보 출력 (switch)
  printResult()             : 승패 판정
  shouldContinue()          : 계속 여부 (y/n 이 아니면 재입력)
  ```
- main 의 반복 조건이 boolean 변수 continuePlaying → "계속할지" 가 이름에 드러난다.
- sc.next().trim().toLowerCase() : 앞뒤 공백 제거 + 소문자 변환 → "Y" 도 계속으로 처리.
- "y" 를 상수 쪽에 두고 CONTINUE\_YES.equals(answer) 로 비교<br>→ answer 가 null 이어도 NullPointerException 이 나지 않는 습관적인 작성법.
- Random 대신 Math.random() 사용 : 0.0 이상 1.0 미만 실수 → × 3 → 0.0 \~ 2.999… → (int) 로 0 \~ 2 → + 1.

- 💡 isValidMove() 는 반복문2 리팩터링 버전과 같은 코드다.
- ⚠ "컴퓨팅 엔트로피를 위한 난수 생성기" 주석은 남아 있지만 Random 필드가 없다.<br>(Math.random() 으로 바꾸면서 주석만 남은 것. 반복문2 버전에는 RANDOM 필드가 있다)
- 💡 반복은 모두 while → 반복문1 과제 조건은 지켰다.

---

[🏠 4주차 학습 가이드](../../README.md)
