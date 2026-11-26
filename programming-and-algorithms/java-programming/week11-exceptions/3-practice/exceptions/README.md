# 11주차 실습 · exceptions

[🏠 11주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [Exception_Example.java](#1-0으로-나누기를-throw하고-try-catch로-잡기-getmessage-vs-e-vs-printstacktrace) | 1. 0으로 나누기를 `throw`하고 `try-catch`로 잡기 (📝 `getMessage()` vs `e` vs `printStackTrace()`) |
| [Exception_OddNumber.java](#2-홀수이면-illegalargumentexception) | 2. 홀수이면 `IllegalArgumentException` (📝 `n % 2 != 0`이 안전한 이유) |
| [DuplicateNumberTest.java](#3-중복-숫자이면-duplicate_number_exception) | 3. 중복 숫자이면 `Duplicate_Number_Exception` (📝 checked라서 `throws` 필수, 💡 `HashSet`) |
| [Vowel_Check.java](#4-모음이-없으면-novowelsexception) | 4. 모음이 없으면 `NoVowelsException` (📝 Exception vs RuntimeException, 헷갈리는 개념 5가지, 풀이 6가지) |

---

## 1. 0으로 나누기를 `throw`하고 `try-catch`로 잡기 (`getMessage()` vs `e` vs `printStackTrace()`)

`11강 실습` · 📄 [`Exception_Example.java`](Exception_Example.java)

#### 문제

> 예외를 발생시키고 try-catch 블록을 사용하여 이를 포착하도록 아래 프로그램을 수정하시오.
>
> ```java
> public class Exception_Example {
>     public static void main(String[] args) {
>         int result = divideNumbers(5, 0);
>         System.out.println("Result: " + result);
>     }
> ```
>
> 실행 결과 :<br>Error: Cannot divide the given number by zero!

#### 💻 코드

<!-- code: Exception_Example.java -->
```java
public class Exception_Example {
    public static void main(String[] args) {
        try {
            int result = divideNumbers(5, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("---- 비교 ----");   // 💡 확인용
        try {
            divideNumbers(5, 0);
        } catch (ArithmeticException e) {
            System.out.println("e.getMessage() → " + e.getMessage());
            System.out.println("e              → " + e);
        }
        try {
            int zero = 0;
            System.out.println(5 / zero);
        } catch (ArithmeticException e) {
            System.out.println("5 / 0 의 기본 메시지 → " + e.getMessage());
        }
    }

    public static int divideNumbers(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide the given number by zero!");
        }
        return dividend / divisor;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Error: Cannot divide the given number by zero!
---- 비교 ----
e.getMessage() → Cannot divide the given number by zero!
e              → java.lang.ArithmeticException: Cannot divide the given number by zero!
5 / 0 의 기본 메시지 → / by zero
```

#### 📒 해설

- 📝 필기 : 이 문제는 자바의 예외 처리(Exception Handling) 기본 원리인 예외 직접 발생시키기(throw)와 예외 포착하기(try-catch)를 이해하고 있는지 확인하는 문제다.

- 📝 필기 : 1. 문제 분석 (무엇이 빠져 있고, 무엇을 해야 할까?) - 주어진 코드와 실행 결과를 살펴보면 다음 3가지를 해결해야 한다.
  1. 메서드 미구현 : main 메서드 안에서 divideNumbers(5, 0) 을 호출하고 있지만, 실제로 divideNumbers 메서드가 작성되어 있지 않다.<br>(또한 클래스의 닫는 중괄호 } 도 빠져 있다)
  2. 예외 발생 조건 : 두 번째 인자로 0 을 전달하여 나눗셈을 시도하고 있다. 수학적으로 숫자를 0 으로 나눌 수 없으므로, 나누는 수가 0 일 때 예외를 발생시켜야 한다.
  3. 실행 결과 맞추기 : 프로그램이 강제 종료되는 대신, 아래의 문구가 출력되도록 예외를 잡아서 처리해야 한다.<br>Error: Cannot divide the given number by zero!

- 📝 필기 : 2. 핵심 개념 정리

**① 예외(Exception)와 ArithmeticException**

    - 예외 (Exception) : 프로그램 실행 중 발생하는 예상치 못한 오류 상황이다. 이를 처리하지 않으면 프로그램이 에러 메시지를 띄우고 즉시 비정상 종료된다.
    - ArithmeticException : 자바에서 기본 제공하는 예외 클래스로, 정수를 0 으로 나누는 등 산술 연산 오류가 발생했을 때 사용한다.

**② 예외 직접 발생시키기 (throw 키워드)**

    - 문법 : throw new 예외클래스("에러 메시지");
    - 중요 포인트! 왜 굳이 if 문과 throw 를 직접 쓸까요?<br>자바에서 단순히 5 / 0 을 계산해도 자바가 자동으로 ArithmeticException 을 발생시킨다. 하지만 이때 자동으로 생성되는 기본 메시지는 "/ by zero" 이다. 문제의 실행 결과처럼 "Cannot divide the given number by zero!" 라는 원하는 메시지를 출력하려면, 개발자가 직접 조건(divisor == 0)을 검사하고 throw 키워드로 원하는 메시지를 담아 예외를 생성해 던져 주어야 한다.

**③ 예외 포착 및 처리 (try-catch 블록)**

    - try { ... } : 예외가 발생할 가능성이 있는 코드를 감싸는 영역이다.
    - catch (예외타입 변수명) { ... } : try 블록 안에서 예외가 발생했을 때, 프로그램이 죽지 않고 실행 흐름을 넘겨받아 오류를 처리하는 영역이다.
    - e.getMessage() : catch 로 잡은 예외 객체(e) 안에 들어 있는 에러 메시지 문자열을 꺼내는 메서드다.

**④ static 메서드**

    - main 메서드가 static 으로 선언되어 있으므로, 객체를 따로 생성(new Exception\_Example())하지 않고 divideNumbers(5, 0)<br>처럼 바로 호출하려면 divideNumbers 메서드도 반드시 static 으로 선언해야 한다.

- 📝 필기 : 4. 코드 실행 흐름 단계별 추적 - 위 코드가 실행될 때 컴퓨터 내부에서 어떤 순서로 동작하는지
  1. main 시작 → try 블록 진입 : divideNumbers(5, 0) 메서드를 호출한다.
  2. divideNumbers 메서드 실행 : 매개변수로 dividend = 5, divisor = 0 이 전달된다. if (divisor == 0) 조건이 참(true)이 된다.
  3. 예외 발생 (throw) : throw new ArithmeticException("Cannot divide the given number by zero!"); 가 실행된다.<br>예외 객체가 생성되어 던져지며, 아래의 return dividend / divisor; 는 실행되지 않고 메서드가 즉시 종료된다.
  4. try 블록 중단 → catch 블록으로 이동 : 호출한 곳(main 의 try 블록)으로 예외가 넘어온다. 예외가 발생했기 때문에 바로 다음 줄인
    ```java
    System.out.println("Result: " + result); 는 실행되지 않고 건너뛴다. 발생한 예외 타입(ArithmeticException)과 일치하는
    ``` catch (ArithmeticException e) 블록으로 점프한다.
  5. 예외 메시지 출력 및 정상 종료 : e.getMessage() 가 "Cannot divide the given number by zero!" 를 반환한다.<br>"Error: " 와 합쳐져 최종적으로 Error: Cannot divide the given number by zero! 가 출력되고 프로그램이 안전하게 종료된다.

- 📝 필기 : 💡 추가 팁 : throw vs throws 헷갈리지 마세요!
  - throw (메서드 내부에서 사용) : 예외를 실제로 발생시킬 때 사용한다. (예 : throw new ArithmeticException(...);)
  - throws (메서드 선언부에서 사용) : "이 메서드에서는 이런 예외가 발생할 수 있으니, 호출한 쪽에서 처리하세요" 라고 예외 처리를 떠넘길 때 사용한다.<br>(참고 : ArithmeticException 은 실행 시 예외(Unchecked Exception)이므로 메서드 선언부에 throws ArithmeticException 을 굳이 적지 않아도 컴파일 오류가 나지 않는다)

- 📝 필기 : e.getMessage() 를 빼고 e 만 출력하면 예외의 클래스 이름까지 함께 출력된다.
  1. 출력 결과 비교 - catch 블록에서 두 코드를 각각 실행했을 때
    - ① e.getMessage() 를 사용했을 때 (정답)
      ```java
      System.out.println("Error: " + e.getMessage());
      ```
        - 실행 결과 : Error: Cannot divide the given number by zero!
        - 특징 : 예외 객체 안에 들어 있는 순수한 에러 메시지 문자열만 깔끔하게 꺼낸다.
    - ② e 만 그대로 출력했을 때
      ```java
      System.out.println("Error: " + e);
      ```
        - 실행 결과 : Error: java.lang.ArithmeticException: Cannot divide the given number by zero!
        - 특징 : 메시지 앞에 java.lang.ArithmeticException: 이라는 예외 클래스의 전체 경로(패키지명 + 클래스명)가 함께 붙어서 출력된다. 따라서 문제에서 요구하는 실행 결과와 달라지게 된다.
  2. 왜 e 만 출력하면 클래스 이름까지 나올까요? (원리)<br>자바에서 객체를 문자열과 더하거나("Error: " + e) System.out.println(e) 에 넣으면, 자바가 자동으로 그 객체의 toString()<br>메서드를 호출한다. 즉, 아래 두 코드는 내부적으로 완전히 똑같이 동작한다.
    ```java
    System.out.println(e);
    System.out.println(e.toString());   // 자동 호출됨
    ``` 모든 예외 클래스의 조상인 Throwable 클래스에는 toString() 이 다음과 같은 형태로 미리 정의(오버라이딩)되어 있다.<br>"패키지명.예외클래스명: " + 예외메시지<br>(참고 : 만약 예외를 생성할 때 메시지를 안 넣고 new ArithmeticException() 처럼 비워 뒀다면, e.getMessage() 는 null 을 반환하고, e 는 java.lang.ArithmeticException 만 출력한다)
  3. 한눈에 보는 예외 정보 출력 방법 3가지 - 실무나 학습에서 예외를 출력하는 방법은 크게 3가지가 있으며, 목적에 따라 골라 쓴다.
    ```text
    코드                    출력 내용                                         주로 사용하는 상황
    e.getMessage()          Cannot divide the given number by zero!           사용자에게 깔끔한 안내 문구만 보여 줄 때 (이번 문제!)
                            (메시지만 출력)
    e (또는 e.toString())   java.lang.ArithmeticException: Cannot divide...   어떤 종류의 예외가 발생했는지 간단히 로그로 남길 때
                            (예외 종류 + 메시지)
    e.printStackTrace()     예외 종류 + 메시지 + 오류가 발생한 정확한 코드      개발자가 디버깅할 때 에러가 정확히 몇 번째 줄에서
                            줄 번호 (스택 트레이스)                            터졌는지 추적할 때
    ```<br>따라서 이번 문제에서는 사용자에게 Error: Cannot divide the given number by zero! 처럼 에러 메시지만 깔끔하게 보여 주는 것이 목적이므로, e 가 아닌 e.getMessage() 를 반드시 사용해야 한다.

- 💡 아래 main 의 "---- 비교 ----" 부분은 📝 필기의 세 가지 출력 방법과, throw 없이 5 / 0 을 했을 때의 기본 메시지를 확인용으로 덧붙인 것이다.<br>printStackTrace() 는 System.err 로 출력되므로 콘솔에서 빨간 글씨로 보이고, 실행 결과의 줄 번호는 환경마다 다를 수 있다.

## 2. 홀수이면 `IllegalArgumentException`

`11강 실습` · 📄 [`Exception_OddNumber.java`](Exception_OddNumber.java)

#### 문제

> 정수를 매개변수로 취하고 숫자가 홀수인 경우 예외(IllegalArgumentException)를 발생시키는 trynumber() 메소드를 작성하시오.
>
> ```java
> public class Exception_OddNumber {
>     public static void main(String[] args) {
>         int n = 18;
>         trynumber(n);
>         n = 7;
>         trynumber(n);
>     }
> }
> ```
>
> 실행 결과 :<br>18 is even.<br>Error: 7 is odd.

#### 💻 코드

<!-- code: Exception_OddNumber.java -->
```java
public class Exception_OddNumber {
    public static void main(String[] args) {
        int n = 18;
        trynumber(n);
        n = 7;
        trynumber(n);

        System.out.println("---- 방법 2 ----");      // 💡 확인용
        trynumber2(18);
        trynumber2(7);

        System.out.println("---- 음수 홀수 ----");
        int m = -7;
        System.out.println(m + " % 2 = " + (m % 2) + " → n % 2 == 1 이면 " + (m % 2 == 1) + ", n % 2 != 0 이면 " + (m % 2 != 0));
    }

    // 방법 1 : trynumber() 메서드 하나로 구현
    public static void trynumber(int n) {
        try {
            if (n % 2 != 0) {
                throw new IllegalArgumentException(n + " is odd.");
            }
            System.out.println(n + " is even.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 방법 2 : 예외를 포착하고 결과를 출력하는 역할 (문제에서는 이름이 trynumber)
    public static void trynumber2(int n) {
        try {
            checkEvenNumber(n);
            System.out.println(n + " is even.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 방법 2 : 숫자가 홀수인지 검사하고 예외를 발생시키는 역할
    public static void checkEvenNumber(int number) {
        if (number % 2 != 0) {
            throw new IllegalArgumentException(number + " is odd.");
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
18 is even.
Error: 7 is odd.
---- 방법 2 ----
18 is even.
Error: 7 is odd.
---- 음수 홀수 ----
-7 % 2 = -1 → n % 2 == 1 이면 false, n % 2 != 0 이면 true
```

#### 📒 해설

- 📝 필기 : 이번 2번 문제는 1번 문제에서 배운 예외 처리 개념을 한 단계 응용하여, IllegalArgumentException 을 사용하고 메서드 내부에서 예외를 발생시키고 처리하는 흐름을 익히는 문제다.

- 📝 필기 : 1. 문제 분석 (1번 문제와 달라진 점)
  - 1번 문제와의 차이점 : main 메서드 안에 try-catch 가 없고, 단순히 trynumber(n) 만 호출하고 있다.
  - 따라서 main 을 수정하지 않고 주어진 실행 결과를 만들려면, trynumber(int n) 메서드 안에서 예외를 발생(throw)시키고 try-catch 로 직접 잡아서 처리까지 해야 한다.
  - 출력 규칙 : 짝수(18)일 때 : 18 is even. 출력<br>홀수(7)일 때 : IllegalArgumentException 발생 → catch 에서 잡아서 Error: 7 is odd. 출력

- 📝 필기 : 2. 핵심 개념 정리

**① IllegalArgumentException 이란?**

    - 이름 그대로 메서드에 부적절하거나(Illegal) 잘못된 인자(Argument)가 전달되었을 때 발생시키는 자바 표준 예외 클래스다.
    - 1번 문제의 ArithmeticException 은 "수학 계산 오류(0 으로 나누기)" 일 때 썼다면, 이번 문제는 "짝수가 와야 하는데 홀수라는 잘못된 값이 들어왔다" 는 논리적 오류를 표현하기 위해 IllegalArgumentException 을 사용한다.
    - RuntimeException 의 자식 클래스(Unchecked Exception)이므로, 메서드 선언부에 throws 를 따로 적지 않아도 된다.
  - ② 홀수 판별 팁 : n % 2 != 0 vs n % 2 == 1
    - 나머지 연산자(%)를 이용해 2 로 나눈 나머지로 홀수 / 짝수를 판별한다.
    - 이때 n % 2 == 1 보다 n % 2 != 0 을 사용하는 것이 훨씬 안전하다.
      - 이유 : 자바에서 음수 홀수(예 : -7)를 2 로 나누면 나머지가 1 이 아니라 -1 이 나온다. n % 2 != 0 으로 작성하면 양수 홀수와 음수 홀수를 모두 정확하게 잡아낼 수 있다.

**③ try 블록 안에서의 흐름 제어 (else 가 필요 없는 이유)**

    - if 문 안에서 throw 가 실행되는 순간, try 블록의 나머지 코드는 즉시 중단되고 catch 블록으로 점프한다.
    - 따라서 홀수일 때 예외를 던지면, 그 아래에 있는 System.out.println(n + " is even."); 코드는 자동으로 건너뛰게 되므로 else 를 굳이 쓰지 않아도 된다.

- 📝 필기 : 3. 정답 코드 (2가지 방식) - 문제의 조건에 맞는 코드는 크게 두 가지 방식으로 작성할 수 있다.<br>방법 1 : trynumber() 메서드 하나로 구현하기 (가장 직관적) - 문제에서 요구한 trynumber() 메서드 안에 예외 발생과 처리를 모두 넣은 형태<br>→ 아래 trynumber()<br>방법 2 : 검사 메서드를 분리하여 구현하기 (더 좋은 설계 / 정석 스타일) - 실제 프로그래밍에서는 같은 메서드 안에서 예외를 던지고 바로 자기가 받는 것보다, 예외를 발생시키는 메서드와 예외를 처리하는 메서드를 분리하는 경우가 많다.
  ```java
  // 예외를 포착하고 결과를 출력하는 역할
  public static void trynumber(int n) {
      try {
          checkEvenNumber(n);
          System.out.println(n + " is even.");
      } catch (IllegalArgumentException e) {
          System.out.println("Error: " + e.getMessage());
      }
  }
  // 숫자가 홀수인지 검사하고 예외를 발생시키는 역할
  public static void checkEvenNumber(int number) {
      if (number % 2 != 0) {
          throw new IllegalArgumentException(number + " is odd.");
      }
  }
  ```<br>→ 아래 trynumber2(), checkEvenNumber()<br>두 코드 모두 실행 결과는 완전히 동일하다! 시험이나 과제에서 "반드시 trynumber() 메소드만 작성하라" 는 제약이 없다면 방법 2 가 역할 분리가 깔끔하고, 메소드 하나만 추가하는 것이 목적이라면 방법 1 이 간결하고 좋다.

- 📝 필기 : 4. 실행 흐름 단계별 추적<br>첫 번째 호출 : n = 18 → trynumber(18)
    1. try 블록 진입.
    2. 18 % 2 != 0 검사 → 나머지가 0 이므로 거짓(false).
    3. if 문을 지나쳐 System.out.println(18 + " is even."); 실행 → 18 is even. 출력.
    4. 예외가 발생하지 않았으므로 catch 블록은 실행하지 않고 종료.

두 번째 호출 : n = 7 → trynumber(7)

    1. try 블록 진입.
    2. 7 % 2 != 0 검사 → 나머지가 1 이므로 참(true).
    3. throw new IllegalArgumentException("7 is odd."); 실행 → 예외 발생!
    4. 아래의 System.out.println(7 + " is even."); 은 건너뛰고 즉시 catch (IllegalArgumentException e) 블록으로 이동.
    5. e.getMessage() 가 "7 is odd." 를 반환하여 Error: 7 is odd. 출력 후 정상 종료.

- 📝 필기 : 💡 체크 포인트
  - 실행 결과의 마침표(.)와 대소문자를 놓치기 쉽다!
    ```text
    18 is even.         (끝에 마침표)
    Error: 7 is odd.    (Error: 뒤에 공백, 끝에 마침표)
    ```
  - 1번 문제에서 확인했듯이, e 만 출력하면 Error: java.lang.IllegalArgumentException: 7 is odd. 가 나오므로 반드시 e.getMessage() 를 사용해야 한다.

- 💡 방법 2 도 확인하려고 main 에 "---- 방법 2 ----" 를 덧붙이고, n % 2 == 1 로 쓰면 음수 홀수(-7)를 놓치는 것도 확인했다.

## 3. 중복 숫자이면 `Duplicate_Number_Exception`

`11강 실습` · 📄 [`DuplicateNumberTest.java`](DuplicateNumberTest.java)

#### 문제

> 사용자로부터 정수 목록을 읽고 숫자가 중복되면 예외 (Exception 을 상속받는 Duplicate\_Number\_Exception 사용자 정의 예외)를 발생시키도록 아래의 프로그램을 완성하시오. main 메서드에 예외 처리를 하는 코드도 추가하시오.
>
> ```java
> public class Main {
>     public static void main(String[] args) {
>         int[] numbers = readNumbersFromUser();
>         checkDuplicates(numbers);
>         System.out.println("No duplicate numbers!");
>         System.out.println("Error: " + e.getMessage());
>     }
> ```
>
> 실행 결과 :<br>How many numbers do you want to input? 5<br>Input the integers:<br>1<br>2<br>3<br>4<br>5<br>No duplicate numbers!
>
> How many numbers do you want to input? 6<br>Input the integers:<br>1<br>2<br>3<br>3<br>4<br>5<br>Error: Duplicate number found: 3
>
> - 💡 문제의 main 은 try-catch 를 "추가하라" 는 뜻으로 일부러 빈 형태다. 그대로는 e 가 선언되지 않아 컴파일되지 않는다.

#### 💻 코드

<!-- code: DuplicateNumberTest.java -->
```java
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateNumberTest {
    public static void main(String[] args) {
        int[] numbers = null;
        try {
            numbers = readNumbersFromUser();
            checkDuplicates(numbers);
            System.out.println("No duplicate numbers!");
        } catch (Duplicate_Number_Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {                                   // 💡 HashSet 방식 확인용
            checkDuplicatesHashSet(numbers);
            System.out.println("HashSet 방식 → No duplicate numbers!");
        } catch (Duplicate_Number_Exception e) {
            System.out.println("HashSet 방식 → Error: " + e.getMessage());
        }
    }

    public static int[] readNumbersFromUser() {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many numbers do you want to input? ");
        int count = sc.nextInt();

        int[] numbers = new int[count];
        System.out.println("Input the integers:");
        for (int i = 0; i < count; i++) {
            numbers[i] = sc.nextInt();
        }

        sc.close();
        return numbers;
    }

    public static void checkDuplicates(int[] numbers) throws Duplicate_Number_Exception {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    throw new Duplicate_Number_Exception("Duplicate number found: " + numbers[i]);
                }
            }
        }
    }

    // 심화 : HashSet 을 이용한 중복 검사
    public static void checkDuplicatesHashSet(int[] numbers) throws Duplicate_Number_Exception {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : numbers) {
            if (uniqueNumbers.contains(num)) {
                throw new Duplicate_Number_Exception("Duplicate number found: " + num);
            }
            uniqueNumbers.add(num);
        }
    }
}

class Duplicate_Number_Exception extends Exception {
    public Duplicate_Number_Exception(String message) {
        super(message);
    }
}
```
<!-- /code -->

#### 실행 결과 (입력 : 6, 1 2 3 3 4 5)

```text
How many numbers do you want to input? 6
Input the integers:
1 2 3 3 4 5
Error: Duplicate number found: 3
HashSet 방식 → Error: Duplicate number found: 3
```

#### 📒 해설

- 📝 필기 : ★) RuntimeException 과 Exception 차이에 대해 주의할 것

- 📝 필기 : 이번 3번 문제는 1, 2번 문제에서 한 단계 더 나아가 자바 예외 처리의 꽃인 ① 사용자 정의 예외(Custom Exception) 만들기와
        - ② Checked Exception 에서의 throws 키워드 사용법을 배우는 아주 중요한 문제다.

- 📝 필기 : 1. 문제 분석 (무엇을 구현해야 할까?) - 주어진 코드와 요구사항을 정리하면 총 4가지를 완성해야 한다.
  1. 사용자 정의 예외 클래스 생성 : Exception 을 상속받는 Duplicate\_Number\_Exception 클래스 작성
  2. 입력 메서드 작성 (readNumbersFromUser()) : Scanner 로 정수의 개수와 정수들을 입력받아 int\[] 배열로 반환
  3. 중복 검사 메서드 작성 (checkDuplicates) : 배열에 중복된 숫자가 있으면 Duplicate\_Number\_Exception 발생
  4. main 메서드에 try-catch 추가 : 정상일 때는 "No duplicate numbers!", 예외 발생 시 "Error: " + e.getMessage() 출력

- 📝 필기 : 2. 핵심 개념 정리

**① 사용자 정의 예외 (Custom Exception) 와 super(message)**

자바가 기본으로 제공하는 예외(ArithmeticException, IllegalArgumentException 등) 외에, 개발자가 프로그램 상황에 맞게 직접 예외 클래스를 만들 수 있다.

```java
class Duplicate_Number_Exception extends Exception {
    public Duplicate_Number_Exception(String message) {
        super(message);   // 부모 클래스(Exception)의 생성자로 메시지 전달!
    }
}
```


    - super(message) 를 꼭 써야 하는 이유 : 나중에 catch 블록에서 e.getMessage() 를 호출하면, 부모 클래스(Exception → Throwable)<br>안에 저장된 메시지를 꺼낸다. 만약 super(message) 를 호출하지 않으면 메시지가 저장되지 않아 e.getMessage() 가 null 을 반환하게 된다.
  - ② 왜 여기서는 throws 를 반드시 써야 할까? (1, 2번 문제와의 핵심 차이!)<br>1번(ArithmeticException)과 2번(IllegalArgumentException)에서는 메서드 옆에 throws 를 안 써도 컴파일이 잘 되었다.<br>그런데 3번에서는 checkDuplicates 메서드 선언부에 throws Duplicate\_Number\_Exception 을 안 쓰면 컴파일 에러가 발생한다!
    - Unchecked Exception (RuntimeException 상속) : 1, 2번의 예외들. 컴파일러가 예외 처리 여부를 강제하지 않으므로 throws 생략 가능.
    - Checked Exception (Exception 직접 상속) : 이번 문제의 Duplicate\_Number\_Exception! 컴파일러가 "이 예외는 반드시 처리해야 해!"<br>라고 엄격하게 검사한다.
    - 따라서 checkDuplicates() 안에서 예외를 던지고(throw) 직접 잡지 않는다면, 메서드 선언부에 throws Duplicate\_Number\_Exception 을 반드시 적어서 호출한 곳(main)으로 예외 처리를 넘겨야 한다. 그리고 호출한 main 에서는 반드시 try-catch 로 잡아 주어야 한다.<br>(throws 를 빼면) error: unreported exception Duplicate\_Number\_Exception; must be caught or declared to be thrown
  - ③ int\[] 배열에서 중복 숫자 찾는 원리 (이중 for 문) - 배열의 모든 숫자 쌍을 한 번씩 비교한다.
    - 바깥 반복문 i : 기준 숫자 선택 (0 부터 끝까지)
    - 안쪽 반복문 j : i 다음 칸(i + 1)부터 끝까지 비교
      - 주의 : j 를 0 부터 시작하면 자기 자신(numbers\[i] == numbers\[i])과 비교해서 무조건 중복으로 판정되므로, 반드시 j = i + 1 부터 시작해야 한다!

- 📝 필기 : 4. 코드 실행 흐름 비교<br>경우 ① : 5개 입력 (1, 2, 3, 4, 5) - 중복이 없을 때
    1. readNumbersFromUser() 가 배열 \[1, 2, 3, 4, 5] 를 반환한다.
    2. checkDuplicates(numbers) 가 모든 쌍을 비교하지만 같은 숫자가 없어 예외 없이 정상 종료된다.
    3. try 블록의 다음 줄인 System.out.println("No duplicate numbers!"); 가 실행된다.
    4. catch 블록은 건너뛰고 프로그램이 종료된다.

경우 ② : 6개 입력 (1, 2, 3, 3, 4, 5) - 중복이 있을 때

    1. readNumbersFromUser() 가 배열 \[1, 2, 3, 3, 4, 5] 를 반환한다.
    2. checkDuplicates(numbers) 에서 i = 2, j = 3 일 때 numbers\[2] == numbers\[3] (3 == 3) 이 참이 된다.
    3. throw new Duplicate\_Number\_Exception("Duplicate number found: 3"); 실행 → 메서드가 즉시 중단되고 throws 를 통해 main 의 try 블록으로 예외가 전달된다.
    4. System.out.println("No duplicate numbers!"); 는 실행되지 않고 건너뛴다.
    5. catch (Duplicate\_Number\_Exception e) 블록으로 이동해 Error: Duplicate number found: 3 이 출력된다.

- 📝 필기 : 💡 실수하기 쉬운 포인트 & 심화 팁
  1. 한 파일에 클래스 2개를 쓸 때 public 주의!<br>Main.java 파일 하나에 Duplicate\_Number\_Exception 클래스를 같이 작성할 때는 class Duplicate\_Number\_Exception 처럼 public 을 빼야 한다. (자바는 하나의 .java 파일에 파일명과 같은 public class 를 딱 1개만 허용하기 때문이다. 별도의 Duplicate\_Number\_Exception.java 파일로 분리할 때만 public 을 붙인다)
  2. print vs println 디테일<br>실행 결과를 보면 How many numbers do you want to input? 5 처럼 질문 옆에 바로 입력을 받으므로 System.out.print(...) 를, Input the integers: 다음은 줄을 바꿔 입력받으므로 System.out.println(...) 을 사용했다.
  3. 심화 : HashSet 을 이용한 더 빠른 중복 검사 방법<br>만약 배열의 크기가 아주 크다면(예 : 10만 개), 이중 for 문(O(N²)) 대신 중복을 허용하지 않는 자료구조인 HashSet(O(N))을 사용할 수도 있다. → 아래 checkDuplicatesHashSet() (컬렉션은 12강)

처음 작성한 코드의 실행 예 (한 줄에 띄어 써서 입력해도 nextInt() 는 공백으로 나눠 읽는다)<br>How many numbers do you want to input? 5<br>Input the integers:<br>1 1 2 3 6<br>Error: Duplicate number found: 1

- 💡 이클립스는 Duplicate\_Number\_Exception 줄에 "serialVersionUID 가 없다" 는 노란 경고를 표시한다. 예외 클래스는 Serializable 을 구현하기 때문인데, 직렬화(14강)를 쓰지 않으면 무시해도 된다. (private static final long serialVersionUID = 1L; 을 넣으면 사라진다)
- 💡 클래스 이름에 \_ 를 넣는 것(Duplicate\_Number\_Exception)은 문법상 문제없지만, 자바 관례는 DuplicateNumberException 처럼 붙여 쓴다.<br>문제에 주어진 이름 그대로 썼다.
- 💡 sc.close() 를 try 안에서 하면 그 윗줄에서 예외가 났을 때 건너뛰므로, 원래는 finally 에서 닫는 것이 안전하다. (Vowel\_Check.java 📝 필기 ④)
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 DuplicateNumberTest 로 이름을 바꿨다.

## 4. 모음이 없으면 `NoVowelsException`

`11강 실습` · 📄 [`Vowel_Check.java`](Vowel_Check.java)

#### 문제

> 문자열을 입력으로 사용하고 문자열에 모음이 포함되어 있지 않으면 예외 (Exception 을 상속받은 NoVowelsException 사용자 정의 예외)를 발생시키는 checkVowels 메서드를 작성하고, 이에 맞추어 main 메서드에 예외 처리를 하는 코드도 추가하시오.
>
> ```java
> public class Vowel_Check {
>     public static void main(String[] args) {
>         String text = "Java handling and managing exceptions ";
>         // String text = "Typy gyps fly.";
>         System.out.println("Original string: " + text);
>         checkVowels(text);
>         System.out.println("String contains vowels.");
>     }
> ```
>
> 실행 결과 :<br>Original string: Java handling and managing exceptions
>
> ```java
> String contains vowels.
> ```
>
> Original string: Typy gyps fly.<br>Error: String does not contain any vowels

#### 💻 코드

<!-- code: Vowel_Check.java -->
```java
public class Vowel_Check {
    public static void main(String[] args) {
        String[] texts = {"Java handling and managing exceptions ", "Typy gyps fly."};

        for (String text : texts) {
            try {
                System.out.println("Original string: " + text);
                checkVowels(text);
                System.out.println("String contains vowels.");
            } catch (NoVowelsException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }

        System.out.println("---- 방법 ① ~ ⑥ (\"Typy gyps fly.\" / \"APPLE\") ----");   // 💡 확인용
        for (int way = 1; way <= 6; way++) {
            System.out.println(circled(way) + " " + result(way, "Typy gyps fly.") + " / " + result(way, "APPLE"));
        }
    }

    // 처음 작성한 코드 (방법 ④ : contains())
    public static void checkVowels(String text) throws NoVowelsException {
        boolean containsVowels = false;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (vowels.contains(String.valueOf(ch))) {
                containsVowels = true;
                break;
            }
        }

        if (!containsVowels) {
            throw new NoVowelsException("String does not contain any vowels");
        }
    }

    // 방법 ① : || 연산자로 10개 직접 비교하기
    public static void checkVowels1(String text) throws NoVowelsException {
        boolean containsVowels = false;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                containsVowels = true;
                break;
            }
        }

        if (!containsVowels) {
            throw new NoVowelsException("String does not contain any vowels");
        }
    }

    // 방법 ② : toLowerCase() + || 5개 비교하기
    public static void checkVowels2(String text) throws NoVowelsException {
        boolean containsVowels = false;
        String lowerText = text.toLowerCase();   // 문자열 전체를 소문자로 통일

        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                containsVowels = true;
                break;
            }
        }

        if (!containsVowels) {
            throw new NoVowelsException("String does not contain any vowels");
        }
    }

    // 방법 ③ : indexOf() 사용하기
    public static void checkVowels3(String text) throws NoVowelsException {
        boolean containsVowels = false;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // vowels 안에 ch 가 있으면 위치(0~9), 없으면 -1 을 반환
            if (vowels.indexOf(ch) != -1) {
                containsVowels = true;
                break;
            }
        }

        if (!containsVowels) {
            throw new NoVowelsException("String does not contain any vowels");
        }
    }

    // 방법 ⑤ : switch 문 사용하기 (return; 활용)
    public static void checkVowels5(String text) throws NoVowelsException {
        String lowerText = text.toLowerCase();

        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    return;   // 모음을 찾으면 메서드 자체를 즉시 종료!
            }
        }

        // 반복문이 끝날 때까지 return 이 안 됐다면 모음이 하나도 없다는 뜻!
        throw new NoVowelsException("String does not contain any vowels");
    }

    // 방법 ⑥ : 정규표현식(Regex)으로 1줄 끝내기
    public static void checkVowels6(String text) throws NoVowelsException {
        // ".*[aeiouAEIOU].*" : 문자열 어딘가에 모음이 하나라도 들어 있는지 검사
        if (!text.matches(".*[aeiouAEIOU].*")) {
            throw new NoVowelsException("String does not contain any vowels");
        }
    }

    // 💡 확인용 : way 번 방법으로 검사한 결과
    static String result(int way, String text) {
        try {
            switch (way) {
                case 1 -> checkVowels1(text);
                case 2 -> checkVowels2(text);
                case 3 -> checkVowels3(text);
                case 4 -> checkVowels(text);
                case 5 -> checkVowels5(text);
                default -> checkVowels6(text);
            }
            return "통과";
        } catch (NoVowelsException e) {
            return "예외";
        }
    }

    static String circled(int n) {
        return String.valueOf((char) ('①' + n - 1));
    }
}

class NoVowelsException extends Exception {
    public NoVowelsException(String message) {
        super(message);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Original string: Java handling and managing exceptions
String contains vowels.

Original string: Typy gyps fly.
Error: String does not contain any vowels

---- 방법 ① ~ ⑥ ("Typy gyps fly." / "APPLE") ----
① 예외 / 통과
② 예외 / 통과
③ 예외 / 통과
④ 예외 / 통과
⑤ 예외 / 통과
⑥ 예외 / 통과
```

#### 📒 해설

- 📝 필기 : 1. 문제 분석 - 주어진 코드와 요구사항을 살펴보면 3번 문제와 구조가 거의 같다.
  1. 사용자 정의 예외 작성 : Exception 을 상속받는 NoVowelsException 클래스 생성
  2. checkVowels(String text) 메서드 작성
    - 문자열에 영어 모음(a, e, i, o, u 및 대문자 A, E, I, O, U)이 하나라도 없으면 NoVowelsException 발생
    - 예외 메시지 : "String does not contain any vowels"
  3. main 메서드 수정 : try-catch 블록으로 예외 처리 추가
    - (참고) main 안에 주석 처리된 // String text = "Typy gyps fly."; 는 두 번째 실행 결과를 확인하고 싶을 때 위 줄을 주석 처리하고 이 줄의 주석을 풀어서 테스트해 보라는 의미다.

- 📝 필기 : 2. 핵심 개념 정리

**① 사용자 정의 예외와 throws (3번 문제 복습)**

    - NoVowelsException 은 Exception 을 직접 상속받으므로 Checked Exception 이다.
    - 따라서 checkVowels 메서드 선언부에 반드시 throws NoVowelsException 을 붙여야 하며, 이를 호출하는 main 메서드에서는 try-catch 로 잡아 주어야 한다.
    - super(message); 를 호출해야 e.getMessage() 가 정상적으로 메시지를 반환한다.
  - ② 문자열에서 모음 포함 여부 검사하기 (핵심 알고리즘) - 문자열에서 모음을 찾을 때는 다음 3가지 포인트를 꼭 기억하자.
    1. 대소문자 모두 고려하기 : "aeiouAEIOU"<br>만약 "APPLE" 처럼 대문자 모음만 있는 문자열이 들어와도 모음이 있다고 판정해야 하므로 대소문자 10글자를 모두 포함시킨다.
    2. 플래그(Flag) 변수 패턴 (boolean containsVowels = false;)
        - 처음에는 "아직 모음을 못 찾았다(false)" 고 가정하고 출발한다.
        - for 문으로 문자열의 첫 글자(0)부터 마지막 글자(text.length() - 1)까지 text.charAt(i) 로 한 글자씩 꺼내 검사한다.
        - 모음을 하나라도 찾으면 containsVowels = true; 로 바꾸고 break; 로 반복문을 즉시 종료한다.<br>(이미 모음이 있다는 게 확정됐으니 뒤의 글자를 더 볼 필요가 없기 때문!)
    3. ⚠ 초보자가 가장 많이 하는 실수 (반복문 안에서 예외 던지기)
        - 만약 for 문 안에 else { throw new NoVowelsException(...); } 를 써 버리면, "Java..." 의 첫 글자 'J' 가 모음이 아니라는 이유만으로 바로 예외가 터져 버린다!
        - 반드시 반복문이 끝난 뒤(문자열 전체를 다 확인한 뒤)에도 containsVowels 가 false 일 때(if (!containsVowels))만 예외를 발생시켜야 한다.
  - ③ 문자가 "aeiouAEIOU" 에 들어 있는지 확인하는 2가지 방법
    - 방법 A : vowels.contains(String.valueOf(ch))<br>contains() 메서드는 char 타입이 아니라 문자열(String)만 받을 수 있기 때문에 String.valueOf(ch) 로 char 를 String 으로 변환해서 비교한다.
    - 방법 B : vowels.indexOf(ch) != -1<br>indexOf(ch) 는 문자열에서 해당 문자 ch 의 위치(인덱스)를 알려 주고, 없으면 -1 을 반환한다. char 를 그대로 넣을 수 있어서 코드가 더 간결하다.

- 📝 필기 : 4. 실행 흐름 단계별 추적<br>경우 ① : text = "Java handling and managing exceptions "
    1. Original string: Java handling and managing exceptions 출력.
    2. checkVowels(text) 호출 :
      - i = 0 : ch = 'J' → 모음 아님.
      - i = 1 : ch = 'a' → 모음 발견! containsVowels = true; 설정 후 break; 로 반복문 즉시 탈출.
      - if (!containsVowels) 는 !true(즉, false)이므로 예외를 발생시키지 않고 메서드 정상 종료.
    3. try 블록의 다음 줄인 String contains vowels. 출력 후 catch 를 건너뛰고 종료.

경우 ② : text = "Typy gyps fly." (주석 바꿔서 실행 시)

    1. Original string: Typy gyps fly. 출력.
    2. checkVowels(text) 호출 :
      - 'T', 'y', 'p', 'y', ' ', 'g', ... 끝까지 모든 글자를 검사해도 "aeiouAEIOU" 에 해당하는 문자가 없음.
      - 반복문이 끝나도 containsVowels 는 여전히 false.
      - if (!containsVowels) 가 !false(즉, true)가 되어 throw new NoVowelsException("String does not contain any vowels"); 실행!
    3. String contains vowels. 는 건너뛰고 catch (NoVowelsException e) 블록으로 이동.
    4. Error: String does not contain any vowels 출력 후 정상 종료.

- 📝 필기 : 💡 체크 포인트
  - 마침표 주의 : 실행 결과를 자세히 보면
    ```java
    String contains vowels.                → 끝에 마침표(.) 있음
    ```<br>Error: String does not contain any vowels → 끝에 마침표(.) 없음
  - 파일명 주의 : public class Vowel\_Check 이므로 파일 이름은 반드시 Vowel\_Check.java 로 저장해야 하며, 같은 파일 안에 작성한 NoVowelsException 앞에는 public 을 붙이지 않아야 한다!

- 📝 필기 : ① Exception vs RuntimeException 의 차이, ② 왜 이 문제에서는 Exception 을 상속받았는지, 그리고 ③ 시험과 실무에서 자주 헷갈리는 보충 개념 5가지
  1. 자바 예외의 계층 구조 (큰 그림부터 보기) - 자바의 모든 오류와 예외는 Throwable 이라는 최상위 클래스 아래에 다음과 같은 족보를 가지고 있다.<br>Throwable
    ```text
    ├── Error (시스템의 치명적 오류 - 개발자가 코드로 해결 불가)
    │    └── OutOfMemoryError, StackOverflowError 등
    └── Exception (개발자가 코드로 처리 가능한 예외)
         ├── [Checked Exception] Exception 을 직접 상속
         │    └── IOException, SQLException, NoVowelsException(4번), Duplicate_Number_Exception(3번)
         └── RuntimeException [Unchecked Exception]
              └── ArithmeticException(1번), IllegalArgumentException(2번), NullPointerException 등
    ```
  2. Exception 상속 vs RuntimeException 상속 차이점 - 가장 큰 차이는 "컴파일러가 예외 처리를 강제하느냐, 안 하느냐" 다.
    ```text
    구분                 extends Exception                                extends RuntimeException
                         (Checked Exception / 검사 예외)                  (Unchecked Exception / 비검사 예외)
    검사 시점            컴파일 시점에 컴파일러가 강제 검사                실행 시점(Runtime)에 발생 (컴파일러가 관여 안 함)
    try-catch / throws   반드시 작성해야 함! (안 쓰면 컴파일 에러 ❌)      선택 사항 (안 써도 컴파일 성공 ⭕)
    주된 사용 목적       복구 가능하거나, 호출하는 쪽에서 반드시 인지하고  주로 개발자의 코딩 실수(버그)
                         대처해야 하는 상황 (파일 없음, 네트워크 끊김,     (0 으로 나누기, 배열 범위 초과, null 참조 등)
                         특정 입력 규칙 위반 등)
    예시 (우리 문제들)   3번(Duplicate_Number_Exception), 4번(NoVowelsException)  1번(ArithmeticException), 2번(IllegalArgumentException)
    ```
    - 💡 그럼 왜 3번 - 4번 문제에서는 Exception 을 상속받게 했을까요? 크게 2가지 이유가 있다.
      1. 설계적 이유 (안전장치 역할) : checkVowels(text) 를 만든 개발자 입장에서 "이 메서드는 모음이 없으면 실패할 수 있으니, 이 메서드를 가져다 쓰는 사람(main)이 절대 깜빡하지 말고 반드시 try-catch 로 에러 메시지를 처리하게 강제하고 싶다!" 는 의도가 담겨 있다. 만약 RuntimeException 을 상속받았다면, main 에서 try-catch 를 깜빡하고 안 써도 컴파일이 통과되어 버리고, 실행 중에 프로그램이 뚝 끊기며 비정상 종료된다.
      2. 교육적 이유 (단계별 학습) : 1번(ArithmeticException)과 2번(IllegalArgumentException)은 모두 RuntimeException 의 자식<br>(Unchecked)이기 때문에 throws 를 안 써도 됐다. 그래서 3번 - 4번에서는 일부러 Exception 을 직접 상속(Checked)하게 만들어 throws 로 예외를 떠넘기고, main 에서 try-catch 로 받아 내는 자바의 정석 예외 처리 흐름을 연습시키려는 출제 의도다.
    - ✨ 실무 보너스 상식 : 교과서나 자바의 원래 철학에서는 복구 가능한 예외에 extends Exception 을 권장하지만, 실제 현대 자바 실무<br>(Spring 등)에서는 throws 를 메서드마다 계속 적어야 하는 번거로움 때문에 사용자 정의 예외를 extends RuntimeException 으로 만드는 경우도 매우 많다! 두 방식의 장단점을 알고 상황에 맞게 선택하는 것이 중요하다.
  3. 그 외에 헷갈리기 쉬운 핵심 개념 5가지
    - ① Error vs Exception
        - Error : 컴퓨터 메모리가 부족하거나(OutOfMemoryError), 재귀 호출이 무한히 반복돼 스택이 터지는(StackOverflowError) 등 JVM 차원의 심각한 문제다. try-catch 로 잡아서 수습할 수 없으므로 잡지 않는 것이 원칙이다.
        - Exception : 잘못된 입력, 파일 부재 등 프로그램 로직으로 예측하고 수습할 수 있는 문제다.
    - ② throw vs throws 완벽 구분 - 비슷하게 생겨서 가장 많이 틀리는 키워드다.
      ```text
      키워드   위치                  역할                                                    개수
      throw    메서드 내부           예외 객체를 생성해서 직접 터뜨림 (발생)                   한 번에 1개만 (throw new 예외();)
      throws   메서드 선언부 (헤더)  "여기서 이런 예외가 나갈 수 있으니 호출한 쪽이 처리해!"   쉼표로 여러 개 가능 (throws A, B)
                                     라고 경고
      ```
        - 주의 : main 메서드에도 public static void main(String\[] args) throws NoVowelsException 처럼 쓸 수는 있지만, 이러면 예외를 JVM 으로 떠넘겨 버려서 예외 발생 시 프로그램이 에러 로그(빨간 글씨)를 뱉고 강제 종료된다. 따라서 Error: ... 처럼 깔끔하게 처리하려면 반드시 try-catch 를 써야 한다.
    - ③ catch 블록을 여러 개 쓸 때의 순서 규칙 (시험 단골!)<br>하나의 try 블록 뒤에 catch 를 여러 개 붙일 수 있는데, 반드시 자식(구체적인) 예외를 위에, 부모(포괄적인) 예외를 아래에 써야 한다.
      ```java
      // ❌ 컴파일 에러! (잘못된 순서)
      try {
          checkVowels(text);
      } catch (Exception e) {              // 부모가 모든 예외를 다 잡아먹어 버림!
          System.out.println("일반 오류");
      } catch (NoVowelsException e) {      // 여기까지 절대 도달할 수 없음 (Unreachable code 에러)
          System.out.println("모음 없음");
      }
      // ⭕ 올바른 순서
      try {
          checkVowels(text);
      } catch (NoVowelsException e) {      // 자식 예외 먼저 검사
          System.out.println("Error: " + e.getMessage());
      } catch (Exception e) {              // 그 외 예상치 못한 모든 예외 처리
          System.out.println("기타 오류: " + e.getMessage());
      }
      ```
    - ④ finally 블록 - "무조건 실행되는 마지막 정리 구역"
        - try-catch 뒤에 선택적으로 finally { ... } 를 붙일 수 있다.
        - try 가 정상 종료되든, 예외가 터져서 catch 로 가든, 심지어 중간에 return 을 만나든 finally 안의 코드는 무조건 실행된다.
        - 주로 자원 해제(3번 문제의 sc.close(), 파일 닫기, DB 연결 종료 등)를 할 때 사용한다.
        - 만약 try 안에서 sc.close() 를 썼는데 그 윗줄에서 예외가 터지면 sc.close() 가 건너뛰어지므로, 원래는 finally 블록 안에서 닫아 주는 것이 가장 안전하다.
    - ⑤ 사용자 정의 예외와 super(message) / 기본 생성자
      ```java
      class NoVowelsException extends Exception {
          // 1. 메시지 없이 던지고 싶을 때를 위한 기본 생성자 (선택)
          public NoVowelsException() {
              super();
          }
          // 2. 메시지를 담아 던지기 위한 생성자 (필수급)
          public NoVowelsException(String message) {
              super(message);   // 부모(Exception)에게 전달해야 e.getMessage() 가 동작함!
          }
      }
      ```
        - 자바에서는 매개변수가 있는 생성자(NoVowelsException(String message))를 하나라도 직접 만들면, 기본 생성자<br>(NoVowelsException())를 자동으로 만들어 주지 않는다.
        - 만약 throw new NoVowelsException(); 처럼 메시지 없이 쓰고 싶다면 위처럼 기본 생성자도 함께 적어 주어야 한다.
        - 그리고 생성자 안에서 super(message); 를 빼먹으면 e.getMessage() 호출 시 null 이 출력되므로 반드시 부모 생성자에게 메시지를 넘겨주어야 한다!

- 📝 필기 : checkVowels 를 작성하는 여러 가지 방법 (아래 checkVowels1 \~ checkVowels6)<br>방법 ① : || 연산자로 10개 직접 비교하기 (가장 직관적)<br>방법 ② : toLowerCase() + || 5개 비교하기 (실수 방지 & 깔끔!) - 문자열 전체를 소문자로 통일한 뒤 비교 방법 ③ : indexOf() 사용하기 (짧고 세련된 방식) - vowels 안에 ch 가 있으면 위치(0\~9), 없으면 -1 을 반환 방법 ④ : contains() 사용하기 (원문 모범 답안 스타일) - contains() 는 String 만 받으므로 char 를 String 으로 변환<br>→ 처음 작성한 코드가 이 방식이다 (아래 checkVowels)<br>방법 ⑤ : switch 문 사용하기 (return; 활용!)
    - ⚠ switch 문 주의 포인트! for 문 안에 switch 가 있을 때 break; 를 쓰면 for 문이 아니라 switch 만 탈출한다! 그래서 위처럼 return; 을 써서 모음을 찾자마자 메서드 자체를 끝내 버리면 boolean 변수도 필요 없고 훨씬 깔끔해진다!<br>(사실 방법 ① \~ ④ 에서도 containsVowels = true; break; 대신 그냥 return; 을 써도 똑같이 동작한다!)

보너스 (방법 ⑥) : 정규표현식(Regex)으로 1줄 끝내기 - 나중에 자바에 익숙해지면 for 문조차 없이 정규표현식으로 딱 한 줄에 끝낼 수도 있다.<br>".\*\[aeiouAEIOU].\*" : 문자열 어딘가에 모음이 하나라도 들어 있는지 검사 (6강 정규 표현식)

- 💡 두 실행 결과를 한 번에 확인하려고, 주석을 바꾸는 대신 두 문자열을 차례로 검사하도록 main 을 반복문으로 바꿨다.<br>아래 "---- 방법 ① \~ ⑥ ----" 는 여섯 가지 방법이 모두 같은 결과를 내는지 확인용으로 덧붙인 것이다.
- 💡 첫 번째 문자열은 끝에 공백이 하나 있다("exceptions "). 그래서 출력도 공백으로 끝나지만 눈에는 보이지 않는다.

---

[🏠 11주차 학습 가이드](../../README.md)
