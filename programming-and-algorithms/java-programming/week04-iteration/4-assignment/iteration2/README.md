# 4주차 과제 · iteration2

[🏠 4주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [FibonacciFor.java](#반복문2---3번-문제) | 반복문2 - 3번 문제 |
| [FibonacciForRefactored.java](#반복문2---3번-문제-리팩터링-버전) | 반복문2 - 3번 문제 (리팩터링 버전) |
| [MultiplesOfThreeFor.java](#반복문2---1번-문제) | 반복문2 - 1번 문제 |
| [MultiplesOfThreeForRefactored.java](#반복문2---1번-문제-리팩터링-버전) | 반복문2 - 1번 문제 (리팩터링 버전) |
| [PythagoreanTripleFor.java](#반복문2---2번-문제) | 반복문2 - 2번 문제 |
| [PythagoreanTripleForRefactored.java](#반복문2---2번-문제-리팩터링-버전) | 반복문2 - 2번 문제 (리팩터링 버전) |
| [RockPaperScissorsFor.java](#반복문2---4번-문제) | 반복문2 - 4번 문제 |
| [RockPaperScissorsForRefactored.java](#반복문2---4번-문제-리팩터링-버전) | 반복문2 - 4번 문제 (리팩터링 버전) |

---

## 반복문2 - 3번 문제

`4강 과제` · 📄 [`FibonacciFor.java`](FibonacciFor.java)

#### 💻 코드

<!-- code: FibonacciFor.java -->
```java
public class FibonacciFor {
    public static void main(String[] args) {
        System.out.print("version1 : ");
        version1();
        System.out.println();

        System.out.print("version2 : ");
        version2();
        System.out.println();
    }

    // ✔ 정답 : 조건식만 쓴 for → while (a < 5000) 과 같다
    static void version1() {
        int a = 0, b = 1, c;
        for (; a < 5000; ) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
    }

    // ✘ 버그 : c = a + b 가 본문 "뒤" 에 실행되어 b = c 가 옛날 c 를 사용한다
    static void version2() {
        int a = 0, b = 1;
        for (int c = 0; a < 5000; c = a + b) {
            System.out.print(a + " ");
            a = b;
            b = c;
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
version1 : 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181
version2 : 0 1 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181
```

#### 📒 해설

- 📝 반복문2 과제는 for문으로 작성.

피보나치 수열은 앞의 2 개의 원소를 합하여 다음 원소를 만드는 방식으로 만든 수열이다.<br>피보나치 수열의 처음 두 수는 0 과 1 이다. 5000 보다 작은 피보나치 수를 생성하여 출력하는 프로그램을 작성하라.

두 가지로 작성해 봤다.

- version1() : for ( ; a &lt; 5000; ) → while (a &lt; 5000) 과 똑같다.  ✔ 정답
- version2() : 증감식 자리에 c = a + b 를 넣어 본 버전.           ✘ 출력이 틀림

- ⚠ version2 가 틀리는 이유 : for 의 증감식은 "본문이 끝난 뒤" 실행된다.

```java
for (int c = 0; a < 5000; c = a + b) {
    print(a);  a = b;  b = c;     ← 여기서 쓰는 c 는 "지난번" a + b
}
```

while 버전은 c = a + b → a = b → b = c 순서였는데,<br>version2 는 a = b → b = c → (그 다음에) c = a + b 순서가 된다.<br>b = c 를 할 때 c 가 아직 새로 계산되지 않은 옛날 값이다.

```text
출력  │ 본문 후 (a, b) │ 증감식 c = a + b
──────┼────────────────┼──────────────────
 0    │ (1, 0)  ← c=0  │ 1
 1    │ (0, 1)         │ 1
 0    │ (1, 1)         │ 2      ← 0 이 또 나온다
 1    │ (1, 2)         │ 3
 1    │ (2, 3)         │ 5
 2    │ (3, 5)         │ 8      → 여기부터는 정상 수열을 따라간다
```

→ 0 1 0 1 1 2 3 5 8 ...  (앞에 "0 1" 이 한 번 더 붙는다)

  - 💡 고치려면 c 를 증감식이 아니라 본문 맨 앞에서 계산 (= version1).<br>또는 증감식에 쉼표로 여러 식을 넣는 방법 : for ( ; a &lt; 5000; c = a + b, a = b, b = c)<br>(for 의 초기식 / 증감식에는 쉼표로 여러 식을 쓸 수 있다 - 실습 ArithmeticMeanFor 참고)

## 반복문2 - 3번 문제 (리팩터링 버전)

`4강 과제` · 📄 [`FibonacciForRefactored.java`](FibonacciForRefactored.java)

#### 💻 코드

<!-- code: FibonacciForRefactored.java -->
```java
public class FibonacciForRefactored {

    // 출력 종료 임계값: prev가 이 값을 넘으면 루프 종료
    private static final long MAX_TERMINAL = 5000L;
    // 출력 포맷 상수
    private static final String OUTPUT_FORMAT = "%d ";

    public static void main(String[] args) {
        printSequenceUpToMax();
    }

    // 피보나치 계열의 수열을 출력합니다.
    private static void printSequenceUpToMax() {
        long prev = 0;
        long curr = 1;

        // prev가 MAX_TERMINAL 미만인 동안 반복
        while (prev < MAX_TERMINAL) {           // ⚠ 반복문2 조건 위반 (for 로 작성해야 함)
            System.out.print(String.format(OUTPUT_FORMAT, prev));
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        // 마지막 출력 뒤 줄바꿈 추가
        System.out.println();
    }
}
```
<!-- /code -->

#### 실행 예

```text
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181
```

#### 📒 해설

- 📝 반복문2 과제는 for문으로 작성.

FibonacciFor.java 를 리팩터링한 코드.

**바뀐 점**

- 상한 5000 → 상수 MAX\_TERMINAL (5000L : 끝의 L 은 long 리터럴)
- 출력 형식 → 상수 OUTPUT\_FORMAT ("%d ")
- 출력 로직을 메소드로 분리 : printSequenceUpToMax()  → main 은 한 줄.
- 변수 이름 a, b, c → prev, curr, next  /  int → long

- ⚠ 반복을 while 로 작성했다. (반복문2 과제는 for 문으로 작성)
  ```java
  for 로 바꾸면 :  for ( ; prev < MAX_TERMINAL; ) { ... }
  또는 변수 선언까지 넣어서 :  for (long prev = 0, curr = 1; prev < MAX_TERMINAL; ) { ... }
  ```<br>(초기식에는 "같은 타입" 변수 여러 개를 한 번에 선언할 수 있다)
- 💡 Javadoc 의 "MAX\_TERMINAL을 넘지 않는 구간" 은 정확히는 "미만". (조건이 prev &lt; MAX\_TERMINAL)

#### 📎 `printSequenceUpToMax` 설명

피보나치 계열의 수열을 출력합니다.<br>시작 값은 prev = 0, curr = 1인 전형적인 피보나치 순서를 따릅니다.<br>각 항은 공백으로 구분되어 한 줄에 출력됩니다.<br>MAX\_TERMINAL을 넘지 않는 구간만 출력합니다.

## 반복문2 - 1번 문제

`4강 과제` · 📄 [`MultiplesOfThreeFor.java`](MultiplesOfThreeFor.java)

#### 💻 코드

<!-- code: MultiplesOfThreeFor.java -->
```java
import java.util.Scanner;

public class MultiplesOfThreeFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        System.out.print("정수를 입력하세요 : ");
        num = sc.nextInt();

        if (num < 0) {
            System.out.println("오류");
        } else {
            for (int i = 3; i <= num; i += 3) {
                System.out.println("[" + i + "]");
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
[39]
```

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

#### 📒 해설

- 📝 반복문2 과제는 for문으로 작성.

특정한 정수를 읽어 들여서 0 과 이 정수 사이에 있는 모든 3 의 배수를 출력하는 프로그램을 작성하라.<br>만약 입력 정수의 값이 0 보다 작으면 오류 메시지를 출력하라.

**포인트**

- 반복문1(iteration1/MultiplesOfThree.java) 의 while 을 for 로 옮긴 것.

```java
i = 3;                         for (int i = 3; i <= num; i += 3) {
while (i <= num) {        →        System.out.println("[" + i + "]");
    System.out.println(...);   }
    i += 3;
}
```

초기식 / 조건식 / 증감식이 한 줄에 모여서 "3 부터 num 까지 3 씩" 이 한눈에 보인다.

- i 를 for 의 초기식에서 선언 → i 는 for 문 안에서만 쓸 수 있다. (반복문1 에서는 바깥에 선언)

- 💡 리팩터링 버전 → MultiplesOfThreeForRefactored.java

## 반복문2 - 1번 문제 (리팩터링 버전)

`4강 과제` · 📄 [`MultiplesOfThreeForRefactored.java`](MultiplesOfThreeForRefactored.java)

#### 💻 코드

<!-- code: MultiplesOfThreeForRefactored.java -->
```java
import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiplesOfThreeForRefactored {

    // 3의 배수 출력의 공통 상수
    private static final int MULTIPLE_OF = 3;
    private static final String PROMPT_INPUT = "정수를 입력하세요 : ";
    private static final String ERROR_NON_INTEGER = "오류: 정수를 입력해야 합니다.";
    private static final String ERROR_NEGATIVE = "오류: 음수는 허용되지 않습니다.";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer limit = readPositiveInteger(sc);
            if (limit != null) {                // ⚠ 항상 참 (null 이 반환되지 않음)
                printMultiplesOfThreeUpTo(limit);
            }
        }
    }

    // 양의 정수 하나를 입력받아 반환합니다.
    private static Integer readPositiveInteger(Scanner sc) {
        while (true) {                          // ⚠ 반복문2 조건 : for ( ; ; ) 로 쓰면 for 문
            System.out.print(PROMPT_INPUT);
            try {
                int value = sc.nextInt();
                if (value > 0) {
                    return value;
                } else {
                    System.out.println(ERROR_NEGATIVE);   // ⚠ 0 일 때도 이 메시지
                }
            } catch (InputMismatchException e) {
                System.out.println(ERROR_NON_INTEGER);
                sc.next(); // 버퍼 정리
            }
        }
    }

    /**
     * 3의 배수들 중 입력값 이하까지 출력합니다.
     * 출력 형식은 "[" + i + "]"를 유지합니다.
     */
    private static void printMultiplesOfThreeUpTo(int limit) {
        for (int i = MULTIPLE_OF; i <= limit; i += MULTIPLE_OF) {
            System.out.println("[" + i + "]");
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
정수를 입력하세요 : 20
[3]
[6]
[9]
[12]
[15]
[18]
```

#### 📒 해설

- 📝 반복문2 과제는 for문으로 작성.

MultiplesOfThreeFor.java 를 리팩터링한 코드.

**바뀐 점 (반복문1 리팩터링 버전과 비교)**

- 숫자뿐 아니라 안내 / 오류 문자열까지 상수로 분리 : PROMPT\_INPUT, ERROR\_NON\_INTEGER, ERROR\_NEGATIVE<br>→ 문구를 고칠 때 한 곳만 바꾸면 된다.
- main 이 if (limit != null) 한 줄로 짧아졌다.
- 입력 검사 방식은 같다 : 정수가 아니면 InputMismatchException → sc.next() 로 버퍼 정리 후 재입력.

- ⚠ readPositiveInteger() 가 while (true) 를 사용한다. (반복문2 과제는 for 문으로 작성)<br>for 로 바꾸려면 for ( ; ; ) { ... } 로 쓰면 된다. (퀴즈 2번 "while 과 for 는 표현력이 같다")
- ⚠ while (true) 를 벗어나는 길은 return value; 뿐 → null 을 반환하는 경우가 없다.<br>Javadoc 의 "입력이 포기되면 null을 반환" 과 main 의 null 검사는 실제로 쓰이지 않는다.
- ⚠ 0 을 넣어도 "오류: 음수는 허용되지 않습니다." 가 출력된다. (0 은 음수가 아니므로 메시지가 부정확)

#### 📎 `readPositiveInteger` 설명

양의 정수 하나를 입력받아 반환합니다.<br>입력이 잘못되면 오류 메시지를 출력하고 재입력합니다.<br>사용자가 정상 입력을 할 때까지 루프합니다.

```text
입력이 포기되면 null을 반환합니다.        ← ⚠ null 을 반환하는 코드가 없다
```

## 반복문2 - 2번 문제

`4강 과제` · 📄 [`PythagoreanTripleFor.java`](PythagoreanTripleFor.java)

#### 💻 코드

<!-- code: PythagoreanTripleFor.java -->
```java
public class PythagoreanTripleFor {
    public static void main(String[] args) {

        int a, b, c, count = 0;
        for (c = 1; c <= 100; c++) {            // c가 1~100까지 반복
            for (a = 1; a < c; a++) {           // a가 1~c-1까지 반복
                for (b = 1; b < c; b++) {       // b가 1~c-1까지 반복
                    if (a * a + b * b == c * c) {
                        System.out.println(c + " : " + a + " : " + b);
                        count++;
                    }
                }
            }
        }
        System.out.println("총 " + count + "개");
    }
}
```
<!-- /code -->

#### 실행 예 (끝부분)

```text
97 : 65 : 72
97 : 72 : 65
100 : 28 : 96
100 : 60 : 80
100 : 80 : 60
100 : 96 : 28
총 104개
```

#### 📒 해설

- 📝 반복문2 과제는 for문으로 작성.

피타고라스의 정리는 직각 삼각형에서 직각을 낀 두 변의 길이를 a, b 라고 하고, 빗변의 길이를 c 라고 하면 a^2 + b^2 = c^2 의 수식이 성립한다는 것이다. 각 변의 길이가 100 보다 작은 삼각형 중에서 피타고라스 정리가 성립하는 직각 삼각형은 몇 개나 있을까? 3 중 반복문을 이용하여 피타고라스 정리를 만족하는 3 개의 정수 각각을 출력하도록 한다.

**📝 필기 (코드 주석)**

- for (c = 1; c &lt;= 100; c++) {  // c가 1\~100까지 반복
- for (a = 1; a &lt; c; a++) {     // a가 1\~c-1까지 반복
- for (b = 1; b &lt; c; b++) {     // b가 1\~c-1까지 반복

**포인트**

- 반복문1(iteration1/PythagoreanTriple.java) 의 while 3 중 반복을 for 로 옮긴 것.
- for 는 초기식(a = 1, b = 1) 이 반복문 머리에 있어서<br>"안쪽 변수를 매번 다시 초기화" 하는 것을 빼먹을 수가 없다.<br>(while 버전에서는 a = 1; b = 1; 을 직접 적어야 했다)
- a, b, c 를 for 바깥에서 선언했다. for (int c = 1; ...) 처럼 초기식에서 선언해도 된다.

- 💡 (a, b) 와 (b, a) 를 모두 세므로 총 104 개. (문제의 출력 예와 같다)
- 💡 문제는 "100 보다 작은" 이지만 출력 예에 100 : 28 : 96 이 있으므로 c &lt;= 100 으로 맞췄다.

## 반복문2 - 2번 문제 (리팩터링 버전)

`4강 과제` · 📄 [`PythagoreanTripleForRefactored.java`](PythagoreanTripleForRefactored.java)

#### 💻 코드

<!-- code: PythagoreanTripleForRefactored.java -->
```java
public class PythagoreanTripleForRefactored {

    // 탐색 상한을 상수로 분리
    private static final int MAX_C = 100;
    // 피타고라스 삼중항에서 a, b, c의 관계를 위한 배수(여기서는 1,2,3의 비교를 위한 고정 값으로 사용 가능)
    // d는 독립 상수로 필요 시 확장 가능                                  ← ⚠ 해당 상수 없음
    private static final String OUTPUT_FORMAT = "%d : %d : %d";

    public static void main(String[] args) {
        int count = 0;

        // c를 빗변으로 가정하여 1..MAX_C 범위에서 피타고라스 삼중항 탐색
        for (int c = 1; c <= MAX_C; c++) {
            // a는 1..c-1
            for (int a = 1; a < c; a++) {
                // b는 a+1 .. c-1 로 설정하여 중복 탐색을 줄임
                for (int b = a + 1; b < c; b++) {
                    if (isPythagoreanTriple(a, b, c)) {
                        // 결과 출력 형식 유지
                        System.out.println(String.format(OUTPUT_FORMAT, c, a, b));
                        count++;
                    }
                }
            }
        }

        System.out.println("총 " + count + "개");
    }

    // 피타고라스 삼중항 여부를 판단합니다.
    private static boolean isPythagoreanTriple(int a, int b, int c) {
        return a * a + b * b == c * c;
    }
}
```
<!-- /code -->

#### 실행 예 (끝부분)

```text
95 : 57 : 76
97 : 65 : 72
100 : 28 : 96
100 : 60 : 80
총 52개
```

#### 📒 해설

- 📝 반복문2 과제는 for문으로 작성.

PythagoreanTripleFor.java 를 리팩터링한 코드.

**바뀐 점**

- 상한 100 → 상수 MAX\_C,  출력 형식 → 상수 OUTPUT\_FORMAT ("%d : %d : %d")
- String.format(OUTPUT\_FORMAT, c, a, b) : %d 자리에 c, a, b 가 순서대로 들어간다.<br>→ 출력 형식 "c : a : b" 는 PythagoreanTripleFor.java 와 같다.
- 판정 로직을 메소드로 분리 : isPythagoreanTriple(a, b, c)
- b 를 a + 1 부터 시작 → (3, 4) 와 (4, 3) 중 하나만 센다 → 총 104 개 → 52 개.

- 💡 반복은 모두 for → 반복문2 과제 조건은 지켰다.
- ⚠ 상수 위의 주석 "피타고라스 삼중항에서 a, b, c의 관계를 위한 배수 ... d는 독립 상수로 필요 시 확장 가능" 은 코드에 해당하는 상수(배수, d)가 없다. 의미 없는 주석이므로 지워도 된다.
- ⚠ 문제의 출력 예(총 104 개)와 개수가 다르다. 원래 답과 맞추려면 b = 1 부터.

#### 📎 `isPythagoreanTriple` 설명

피타고라스 삼중항 여부를 판단합니다.<br>a^2 + b^2 == c^2 이면 true를 반환합니다.<br>입력이 양의 정수라고 가정합니다.

## 반복문2 - 4번 문제

`4강 과제` · 📄 [`RockPaperScissorsFor.java`](RockPaperScissorsFor.java)

#### 💻 코드

<!-- code: RockPaperScissorsFor.java -->
```java
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int user, com;
        String answer = "y";

        for (; answer.equals("y"); ) {
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
가위(1), 바위(2), 보(3) : 1
컴퓨터 : 가위
비겼습니다.
계속 하시겠습니까? (y or n) : y
가위(1), 바위(2), 보(3) : 3
컴퓨터 : 바위
이겼습니다.
계속 하시겠습니까? (y or n) : n
```

#### 📒 해설

- 📝 반복문2 과제는 for문으로 작성.

조건문 과제에서 가위 바위 보 게임을 반복 수행하는 프로그램을 작성하시오.<br>한 번 끝나면 사용자에게 "계속 하시겠습니까? ('y' or 'n')" 라는 안내문을 내주고, 'y' 이면 새 게임을 진행하고, 'n' 이면 프로그램을 종료토록 한다.

**포인트**

- 반복문1(iteration1/RockPaperScissorsRepeat.java) 의 while (answer.equals("y")) 를 for ( ; answer.equals("y"); ) 로 바꾼 것. 나머지는 같다.
- 몇 판 할지 미리 정해져 있지 않으므로 초기식 / 증감식은 비워 두고 조건식만 쓴다.<br>(퀴즈 2번 : "while문과 for문은 표현력이 같다. for ( ; n>=0 ; ) {} 로 써야한다")
- 게임 횟수를 세고 싶다면 증감식을 활용할 수 있다.
  ```java
  for (int round = 1; answer.equals("y"); round++) { System.out.println(round + "번째 게임"); ... }
  ```

- 💡 "Y" (대문자) 는 종료로 처리된다. 대소문자를 모두 받으려면 equalsIgnoreCase("y").

- 💡 리팩터링 버전 → RockPaperScissorsForRefactored.java

## 반복문2 - 4번 문제 (리팩터링 버전)

`4강 과제` · 📄 [`RockPaperScissorsForRefactored.java`](RockPaperScissorsForRefactored.java)

#### 💻 코드

<!-- code: RockPaperScissorsForRefactored.java -->
```java
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsForRefactored {

    // 손 모양 상수
    private static final int SHAPE_SCISSOR = 1;
    private static final int SHAPE_ROCK    = 2;
    private static final int SHAPE_PAPER   = 3;

    // 출력 포맷 상수
    private static final String OUTPUT_FORMAT = "%d : %d : %d";    // ⚠ 사용되지 않음

    // 게임 종료 여부 상수
    private static final String CONTINUE_YES = "y";
    private static final String CONTINUE_NO  = "n";

    // 난수 생성기
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean keepPlaying = true;

            // 규칙상 for 루프를 사용하되, 종료 제어 변수를 루프 내부에서 갱신
            for (; keepPlaying; ) {
                int userChoice = promptUserChoice(sc);
                int computerChoice = generateComputerChoice();

                System.out.println("컴퓨터 : " + moveToString(computerChoice));
                printResult(userChoice, computerChoice);

                keepPlaying = shouldContinue(sc);
            }
        }
    }

    // 사용자의 입력이 1/2/3 중 하나인지 검사하고 반환
    private static int promptUserChoice(Scanner sc) {
        while (true) {                          // ⚠ 반복문2 조건 : for ( ; ; )
            System.out.print("가위(1), 바위(2), 보(3) : ");
            try {
                int value = sc.nextInt();
                if (isValidMove(value)) {
                    return value;
                } else {
                    System.out.println("오류: 1, 2, 또는 3 중 하나를 입력해야 합니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("오류: 정수를 입력해야 합니다.");
                sc.next(); // 입력 버퍼 정리
            }
        }
    }

    // 컴퓨터의 선택: 1~3 사이의 난수
    private static int generateComputerChoice() {
        return RANDOM.nextInt(3) + 1;
    }

    // 손 모양을 문자열로 변환
    private static String moveToString(int move) {
        switch (move) {
            case SHAPE_SCISSOR: return "가위";
            case SHAPE_ROCK:    return "바위";
            case SHAPE_PAPER:   return "보";
            default:            return "알 수 없음";
        }
    }

    // 승패 판단 및 출력
    private static void printResult(int user, int computer) {
        if (user == computer) {
            System.out.println("비겼습니다.");
        } else if ((user == SHAPE_SCISSOR && computer == SHAPE_PAPER) ||
                   (user == SHAPE_ROCK && computer == SHAPE_SCISSOR) ||
                   (user == SHAPE_PAPER && computer == SHAPE_ROCK)) {
            System.out.println("이겼습니다.");
        } else {
            System.out.println("졌습니다.");
        }
    }

    // 입력된 포맷이 1/2/3인지 검사
    private static boolean isValidMove(int move) {
        return move == SHAPE_SCISSOR || move == SHAPE_ROCK || move == SHAPE_PAPER;
    }

    // 계속할지 여부를 묻고, 'y' 또는 'n'으로 응답받아 true/false 반환
    private static boolean shouldContinue(Scanner sc) {
        while (true) {                          // ⚠ 반복문2 조건 : for ( ; ; )
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
컴퓨터 : 가위
이겼습니다.
계속 하시겠습니까? (y or n) : n
```

#### 📒 해설

- 📝 반복문2 과제는 for문으로 작성.

RockPaperScissorsFor.java 를 리팩터링한 코드.

**바뀐 점 (반복문1 리팩터링 버전과 비교)**

- 상수 이름 SHAPE\_SCISSOR / SHAPE\_ROCK / SHAPE\_PAPER
- Random 을 static final 필드 RANDOM 으로 한 번만 생성해 재사용.
- printMove() (직접 출력) → moveToString() (문자열 반환)
  ```java
  → 출력은 호출부가 담당 : System.out.println("컴퓨터 : " + moveToString(...));
    값을 돌려주는 메소드가 다른 곳에서도 쓰기 쉽다.
  ```
- main 의 반복을 for ( ; keepPlaying; ) 로 작성.

- ⚠ promptUserChoice() 와 shouldContinue() 의 재입력 반복은 while (true) 다. (반복문2 과제는 for 문)<br>for ( ; ; ) 로 바꾸면 조건을 지킨다.
- ⚠ OUTPUT\_FORMAT ("%d : %d : %d") 은 사용되지 않는다. (Eclipse 노란 경고)<br>피타고라스 문제의 상수가 잘못 섞여 들어온 것으로 보인다.

---

[🏠 4주차 학습 가이드](../../README.md)
