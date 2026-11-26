# 11주차 강의 예제 코드

[🏠 11주차 학습 가이드](../../README.md)

강의 노트([`1-lecture/`](../))에 나온 코드를 실행할 수 있는 파일로 정리했습니다. 노트를 먼저 읽고, 여기서 코드를 실행하며 결과를 확인하세요.

| 파일 | 내용 |
|---|---|
| [DivideExample.java](#기본-예외-처리-exception-handling---try-catch) | 입력받은 두 수 나누기, `ArithmeticException`. ⚠ 변수를 `try` 밖에서 선언 |
| [FinallyTest.java](#실습-finally-블록---세-가지-경우) | [실습] `finally` 세 가지 경우: 예외 없음 / 예외 발생 / `catch`와 불일치 |
| [MultipleCatchTest.java](#실습-다중-catch-문---예외-처리-순서) | [실습] 다중 `catch`: `ArithmeticException` / `ArrayIndexOutOfBoundsException` |
| [RethrowTest.java](#예외-처리-순서---다시-던지기rethrow와-중첩-try-catch) | 💡 `throw (e)`로 다시 던지기, 중첩 `try-catch` |
| [CheckedExceptionDemo.java](#checked-예외) | `FileInputStream`의 `FileNotFoundException`, `IOException` 처리 |
| [UncheckedExceptionTest.java](#unchecked-예외) | `ArithmeticException`, `ArrayIndexOutOfBoundsException`, `NumberFormatException`, `NullPointerException` |
| [UserDefinedExceptionTest.java](#사용자-정의-예외) | `NullNameException`(`toString` 재정의), `CountZeroException`(`super(message)`) |
| [UserExceptionTest.java](#실습-사용자-정의-예외---throw-와-throws) | [실습] `throw`와 `throws`, `main`에서 떠넘기면 비정상 종료 |

---

## 기본 예외 처리 (Exception Handling) - try-catch

`11-1 예외처리1` · 📄 [`DivideExample.java`](DivideExample.java)

#### 💻 코드

<!-- code: DivideExample.java -->
```java
import java.util.Scanner;

public class DivideExample {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("두 정수를 입력하세요 : ");   // 💡 강의 코드에는 없는 안내 문구
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        int c;                     // ✅ try 바깥에서 선언
        try {
            c = a / b;             // divide-by-zero 예외 발생 가능
        } catch (ArithmeticException e) {
            c = -1;
        }
        System.out.println("결과는 " + c + "입니다.");

        System.out.println("5.0 / 0 = " + (5.0 / 0));   // 💡 실수 나눗셈은 예외가 나지 않는다
    }
}
```
<!-- /code -->

#### 실행 결과 (입력 : 10 0)

```text
두 정수를 입력하세요 : 10 0
결과는 -1입니다.
5.0 / 0 = Infinity
```

#### 실행 결과 (입력 : 10 3)

```text
두 정수를 입력하세요 : 10 3
결과는 3입니다.
5.0 / 0 = Infinity
```

**포인트**

- 예외 처리 : 프로그램의 정상적인 흐름을 방해하는 예외들을 조치하여 계속 프로그램이 진행될 수 있게 하는 목적
- try-catch 문을 사용한다.
  ```text
  try 블록   : 예외 발생 가능한 코드를 포함
  ```<br>catch 블록 : try 블록에서 발생한 exception 을 처리
- 아래 코드는 b 에 0 을 입력하면 a / b 에서 divide-by-zero 예외(ArithmeticException)가 발생한다.<br>예외가 나면 catch 블록으로 넘어가 c = -1 로 정하고, 프로그램은 멈추지 않고 다음 줄을 계속 실행한다.

- ⚠ 자주 틀리는 부분 : 강의 코드는 int c 를 try 블록 "안에서" 선언한다.
  ```java
  try {
      int c = a / b;          // c 는 이 블록 안에서만 쓸 수 있다
  }
  catch (ArithmeticException e) {
      c = -1;                 // ❌ error: cannot find symbol (c)
  }
  System.out.println("결과는 " + c + "입니다.");   // ❌ 여기서도 c 를 찾을 수 없다
  ```<br>변수의 유효 범위는 선언한 블록 { } 안이다. (7강 변수의 유효 범위) try, catch, 그 아래에서 모두 쓰려면 try 앞에서 선언한다.
  ```java
  int c;
  try { c = a / b; } catch (ArithmeticException e) { c = -1; }
  ```
- 💡 0 으로 나누기 예외는 "정수" 나눗셈에서만 난다. 실수(double)를 0 으로 나누면 예외 없이 Infinity 나 NaN 이 된다.
  ```text
  5.0 / 0 → Infinity,   0.0 / 0 → NaN
  ```
- 💡 try-catch 가 없으면 예외가 난 순간 프로그램이 멈추고, 아래와 같은 메시지가 출력된다.
  ```text
  Exception in thread "main" java.lang.ArithmeticException: / by zero
  ```
- 💡 강의 코드의 public class 이름은 Example. 같은 폴더의 다른 예제와 겹치지 않도록 DivideExample 로 바꿨다.

## \[실습] finally 블록 - 세 가지 경우

`11-1 예외처리1` · 📄 [`FinallyTest.java`](FinallyTest.java)

#### 💻 코드

<!-- code: FinallyTest.java -->
```java
public class FinallyTest {
    public static void main(String args[]) {
        System.out.println("---- (1) 예외가 발생하지 않은 경우 ----");
        case1();
        System.out.println("---- (2) 예외가 발생한 경우 ----");
        case2();
        System.out.println("---- (3) catch 문과 일치하지 않는 예외 ----");
        try {
            case3();
        } catch (ArrayIndexOutOfBoundsException e) {   // 💡 확인용 : case3 밖으로 나온 예외를 잡음
            System.out.println("(main 까지 전달됨 : " + e + ")");
        }
    }

    // (1) 예외가 발생하지 않은 경우
    static void case1() {
        try {
            System.out.println("First statement of try block");
            int num = 3;                         // 강의 코드 : int num = 3.14; (⚠ 컴파일 오류)
            System.out.println(num);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        } finally {                              // 예외 발생 없이도 실행됨
            System.out.println("finally 블록 내 ...");
        }
        System.out.println("try-catch 블락 밖 ...");
    }

    // (2) 예외가 발생한 경우
    static void case2() {
        try {
            System.out.println("First statement of try block");
            int num = 5 / 0;                     // 예외 발생
            System.out.println(num);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        } finally {
            System.out.println("finally 블록 내 ...");
        }
        System.out.println("try-catch 블락 밖 ...");
    }

    // (3) catch 문과 일치하지 않는 예외
    static void case3() {
        try {
            System.out.println("First statement of try block");
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArithmeticException e) {        // ArrayIndexOutOfBoundsException 은 여기서 잡히지 않는다
            System.out.println("ArithmeticException");
        } finally {
            System.out.println("finally 블록 내 ...");
        }
        System.out.println("try-catch 블락 밖 ...");   // 💡 예외가 catch 에서 잡히지 않았으므로 실행되지 않는다
    }
}
```
<!-- /code -->

#### 실행 결과

```text
---- (1) 예외가 발생하지 않은 경우 ----
First statement of try block
3
finally 블록 내 ...
try-catch 블락 밖 ...
---- (2) 예외가 발생한 경우 ----
First statement of try block
ArithmeticException
finally 블록 내 ...
try-catch 블락 밖 ...
---- (3) catch 문과 일치하지 않는 예외 ----
First statement of try block
finally 블록 내 ...
(main 까지 전달됨 : java.lang.ArrayIndexOutOfBoundsException)
```

**포인트**

- finally 블록이 추가로 올 수 있다.
- try 블록에서 할당된 리소스를 정리하고, 예외 발생 여부에 관계없이 항상 실행해야 하는 코드를 기술한다.
  ```java
  try {
      // try block
  }
  catch (Exception arg) {
      // catch block
  }
  finally {
      // finally block
  }
  ```

- (1) 예외가 발생하지 않은 경우       : try 끝까지 → (catch 건너뜀) → finally → try-catch 밖
- (2) 예외가 발생한 경우              : try 중단 → catch → finally → try-catch 밖
- (3) catch 문과 일치하지 않는 예외   : try 중단 → (맞는 catch 없음) → finally → 예외가 메소드 밖으로 전달됨<br>→ "try-catch 블락 밖 ..." 은 출력되지 않는다. main 에서 이렇게 되면 프로그램이 비정상 종료된다.

- ⚠ 자주 틀리는 부분 : 강의의 (1) 번 코드는 int num = 3.14; 다. 이 줄은 컴파일 오류다. (double 을 int 에 그냥 넣을 수 없다, 2강)
  ```text
  error: incompatible types: possible lossy conversion from double to int
  ``` "예외가 나지 않는 코드" 의 예로 쓰려면 int num = 3; 처럼 정수를 쓰거나 (int) 3.14 로 형변환해야 한다. 아래에서는 int num = 3; 으로 썼다.<br>컴파일 오류는 실행하기 전에 잡히는 문법 오류이고, 예외는 실행 중에 생기는 오류다. try-catch 로는 컴파일 오류를 처리할 수 없다.
- 💡 (3) 에서 throw new ArrayIndexOutOfBoundsException(); 은 실제 배열 없이 예외를 "직접" 발생시킨 것이다. (throw 는 11-2)
- 💡 (3) 을 main 에서 그대로 실행하면 finally 출력 뒤에 프로그램이 멈춘다. 여기서는 세 경우를 한 번에 보려고 각 경우를 메소드로 만들고,
  - (3) 을 부르는 main 쪽에서 한 번 더 잡아서 "어디까지 전달됐는지" 를 출력했다.
- 💡 finally 는 try 나 catch 안에서 return 을 만나도 실행된다. (실습 Vowel\_Check.java 📝 필기 ④)
- 💡 강의 코드의 클래스 이름은 세 경우 모두 FinallyTest. 한 파일에 넣으려고 각 경우를 case1 \~ case3 메소드로 나눴다.

## \[실습] 다중 catch 문 - 예외 처리 순서

`11-1 예외처리1` · 📄 [`MultipleCatchTest.java`](MultipleCatchTest.java)

#### 💻 코드

<!-- code: MultipleCatchTest.java -->
```java
public class MultipleCatchTest {
    public static void main(String args[]) {
        System.out.println("---- (1) ArithmeticException ----");
        case1();
        System.out.println("---- (2) ArrayIndexOutOfBoundsException ----");
        case2();
    }

    // (1) 다중 catch 문 - ArithmeticException
    static void case1() {
        try {
            int arr[] = new int[5];
            arr[4] = 20 / 0;                    // 예외 발생
            System.out.println("First print statement in try block");
        } catch (ArithmeticException e) {      // 여기서 받음
            System.out.println("Warning: ArithmeticException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Warning: ArrayIndexOutOfBoundsException");
        } catch (Exception e) {
            System.out.println("Warning: Some Other exception");
        }
        System.out.println("try-catch 블락 밖...");
    }

    // (2) 다중 catch 문 - ArrayIndexOutOfBoundsException
    static void case2() {
        try {
            int arr[] = new int[5];
            arr[6] = 20 / 5;                    // 예외 발생
            System.out.println("First print statement in try block");
        } catch (ArithmeticException e) {
            System.out.println("Warning: ArithmeticException");
        } catch (ArrayIndexOutOfBoundsException e) {   // 여기서 받음
            System.out.println("Warning: ArrayIndexOutOfBoundsException");
        } catch (Exception e) {
            System.out.println("Warning: Some Other exception");
        }
        System.out.println("try-catch 블락 밖...");
    }
}
```
<!-- /code -->

#### 실행 결과

```text
---- (1) ArithmeticException ----
Warning: ArithmeticException
try-catch 블락 밖...
---- (2) ArrayIndexOutOfBoundsException ----
Warning: ArrayIndexOutOfBoundsException
try-catch 블락 밖...
```

**포인트**

- try-catch 문에서 여러 catch 문을 사용할 수 있다.
- catch 문은 위에서부터 순서대로 검사한다. 처음으로 타입이 맞는 catch 하나만 실행되고 나머지는 건너뛴다.
- (1) arr\[4] = 20 / 0;  → 오른쪽 20 / 0 을 먼저 계산하다가 ArithmeticException → 첫 번째 catch 에서 받음
- (2) arr\[6] = 20 / 5;  → 20 / 5 = 4 는 문제없고, 인덱스 6 에 저장하다가 ArrayIndexOutOfBoundsException → 두 번째 catch 에서 받음
- 두 경우 모두 예외가 난 다음 줄인 "First print statement in try block" 은 출력되지 않는다.
- catch (Exception e) 는 위의 두 catch 에서 잡지 못한 나머지 모든 예외를 처리한다. 그래서 맨 마지막에 둔다.

- ⚠ 자주 틀리는 부분 : catch (Exception e) 를 맨 위에 두면 아래 catch 는 절대 실행될 수 없어서 컴파일 오류가 난다.
  ```text
  error: exception ArithmeticException has already been caught
  ``` 구체적인 하위(자식) 예외를 위에, 포괄적인 상위(부모) 예외를 아래에 쓴다. (퀴즈 4번)
- 💡 arr\[4] = 20/0; 처럼 대입문은 오른쪽 식을 먼저 계산한다. 그래서 (1) 에서는 인덱스 4 가 올바른지와 상관없이 나눗셈 예외가 먼저 난다.
- 💡 강의 자료의 제목은 "ArichmeticException" 으로 적혀 있지만 정확한 클래스 이름은 ArithmeticException 이다.
- 💡 강의 코드의 클래스 이름은 두 경우 모두 MultipleCatchTest. 한 파일에 넣으려고 case1, case2 메소드로 나눴다.

## 예외 처리 순서 - 다시 던지기(rethrow)와 중첩 try-catch

`11-1 예외처리1` · 📄 [`RethrowTest.java`](RethrowTest.java)

#### 💻 코드

<!-- code: RethrowTest.java -->
```java
public class RethrowTest {
    public static void main(String[] args) {
        System.out.println("---- 다시 던지기 ----");
        try {
            calculate();
        } catch (ArithmeticException e) {
            System.out.println("main 에서 최종 처리 : " + e);
        }

        System.out.println("---- 중첩 try-catch ----");
        try {
            try {
                int[] arr = new int[3];
                arr[5] = 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("안쪽 try-catch : 배열 인덱스 오류");
            }
            System.out.println("바깥 try 계속 실행");
            int zero = 0;
            System.out.println(10 / zero);
        } catch (ArithmeticException e) {
            System.out.println("바깥 try-catch : 0 으로 나누기");
        }
    }

    static void calculate() {
        try {
            int zero = 0;
            System.out.println(10 / zero);
        } catch (ArithmeticException e) {
            System.out.println("calculate 에서 일부 처리 : " + e.getMessage());
            throw (e);                         // 예외 e 를 다시 발생 → 호출한 main 으로
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
---- 다시 던지기 ----
calculate 에서 일부 처리 : / by zero
main 에서 최종 처리 : java.lang.ArithmeticException: / by zero
---- 중첩 try-catch ----
안쪽 try-catch : 배열 인덱스 오류
바깥 try 계속 실행
바깥 try-catch : 0 으로 나누기
```

**포인트**

- try-catch 문에서 여러 catch 문을 사용할 수 있고, catch 문은 순서대로 검사한다. (MultipleCatchTest.java)
- 바깥쪽에 정의된 메소드에서 처리하고자 하는 경우, throw 문을 사용하여 rethrow 하면 된다.
  ```java
  catch (ArithmeticException e)
  {
      throw (e);   // 예외 e 를 다시 발생
  }
  ```
- 중첩하여 try-catch 문을 사용할 수 있다.

아래 코드의 흐름<br>main → calculate() 호출<br>calculate 안 : 10 / 0 → ArithmeticException → calculate 의 catch 가 받음<br>→ "calculate 에서 일부 처리" 를 출력하고 throw (e) 로 다시 던짐 → calculate 종료 main 의 catch 가 다시 받아서 "main 에서 최종 처리" 를 출력

- 💡 강의는 문법만 보여 주고 전체 예제는 없어서, 다시 던지기와 중첩 try-catch 를 확인하는 코드를 만들었다.
- 💡 다시 던지는 이유 : 예외가 난 곳에서 할 수 있는 일(기록 남기기, 일부 정리)만 하고, 최종 판단은 호출한 쪽에 맡기기 위해서다.
- 💡 throw (e); 의 괄호는 없어도 된다. 보통 throw e; 로 쓴다.
- 💡 ArithmeticException 은 Unchecked 라서 calculate() 에 throws 를 쓰지 않아도 다시 던질 수 있다.<br>Checked 예외를 다시 던지려면 메소드 선언부에 throws 를 적어야 한다. (11-2)

## checked 예외

`11-2 예외처리2` · 📄 [`CheckedExceptionDemo.java`](CheckedExceptionDemo.java)

#### 💻 코드

<!-- code: CheckedExceptionDemo.java -->
```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckedExceptionDemo {
    public static void main(String[] args) {
        try {
            FileInputStream fis = null;
            fis = new FileInputStream("C:/test.txt");
            int c;
            while ((c = fis.read()) != -1)
                System.out.print((char) c);

            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("The specified file is not present at the given path");
        } catch (IOException e) {
            System.out.println("I/O error occurred: " + e);
        }
    }
}
```
<!-- /code -->

#### 실행 결과 (C:/test.txt 가 없을 때)

```text
The specified file is not present at the given path
```

**포인트**

- checked 예외와 unchecked 예외가 있다.
- checked 는 컴파일 시 검사하고, unchecked 는 검사하지 않는다는 차이점이 있다.
- 파일 입출력 코드는 checked 예외를 던진다. 처리하지 않으면 컴파일 시 다음과 같은 에러가 발생한다.
  ```java
  import java.io.FileInputStream;
  public class ExceptionDemo {    // 컴파일 시 다음과 같은 에러가 발생
      public static void main(String[] args) {
          FileInputStream fis = null;
          fis = new FileInputStream("C:/test.txt");    // FileNotFoundException
          int c;
          while ((c = fis.read()) != -1)                // IOException
          {
              System.out.print((char) c);
          }
          fis.close();                                  // IOException
      }
  }
    error: unreported exception FileNotFoundException; must be caught or declared to be thrown
    error: unreported exception IOException; must be caught or declared to be thrown
  ```
- 위의 코드를 아래 main 처럼 try-catch 로 처리한다.

- 💡 FileInputStream : 파일을 1 바이트씩 읽는 클래스 (13강 파일 입출력). read() 는 읽은 바이트를 int 로 돌려주고, 파일 끝이면 -1 을 돌려준다. 그래서 while ((c = fis.read()) != -1) 로 끝까지 읽는다.
- ⚠ 자주 틀리는 부분 : FileNotFoundException 은 IOException 의 자식 클래스다. 그래서 catch 순서를 바꿔 catch (IOException e) 를 먼저 쓰면 FileNotFoundException catch 에 도달할 수 없어 컴파일 오류가 난다.
  ```text
  error: exception FileNotFoundException has already been caught
  ```
- 💡 C:/test.txt 가 없으면 "The specified file is not present at the given path" 가 출력된다. 파일을 만들어 두면 내용이 출력된다.<br>(윈도우에서도 경로 구분자로 / 를 쓸 수 있다. \\ 를 쓰려면 "C:\\\\test.txt" 처럼 두 번 써야 한다)
- 💡 강의 코드는 fis.close() 를 try 안에 두었다. 읽다가 예외가 나면 close() 가 건너뛰어지므로, 원래는 finally 에서 닫거나 Java 7 의 try-with-resources 를 쓰는 것이 안전하다.
  ```java
  try (FileInputStream fis2 = new FileInputStream("C:/test.txt")) { ... }   // 블록이 끝나면 자동으로 close()
  ```
- 💡 강의 코드의 public class 이름은 ExceptionDemo. 같은 폴더의 다른 예제와 겹치지 않도록 CheckedExceptionDemo 로 바꿨다.

## unchecked 예외

`11-2 예외처리2` · 📄 [`UncheckedExceptionTest.java`](UncheckedExceptionTest.java)

#### 💻 코드

<!-- code: UncheckedExceptionTest.java -->
```java
public class UncheckedExceptionTest {
    public static void main(String args[]) {
        System.out.println("---- (1) ArithmeticException ----");
        try {
            case1();
        } catch (ArithmeticException e) {           // 💡 확인용
            System.out.println("(처리하지 않으면 프로그램 종료) " + e);
        }
        System.out.println("---- (2) ArrayIndexOutOfBoundsException ----");
        case2();
        System.out.println("---- (3) NumberFormatException ----");
        case3();
        System.out.println("---- (4) NullPointerException ----");
        case4();
    }

    static void case1() {
        int n1 = 3;
        int n2 = 0;

        int r = n1 / n2;     // 예외가 발생하지만 컴파일 오류 없이 컴파일됨
        System.out.println(r);
    }

    static void case2() {
        try {
            String arr[] = {"a", "b", "c", "d", "e"};
            System.out.println(arr[6]);   // 예외 발생
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱스 범위를 벗어나 접근했습니다");
        }
    }

    static void case3() {
        try {
            int n = Integer.parseInt("XYZ");   // 예외 발생
            System.out.println(n);
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환 불가능 문자열 사용");
        }
    }

    static void case4() {
        try {
            String str = null;                 // 강의 코드 : String str; (⚠ 컴파일 오류)
            System.out.println(str.length());  // 예외 발생
        } catch (NullPointerException e) {
            System.out.println("NullPointerException..");
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
---- (1) ArithmeticException ----
(처리하지 않으면 프로그램 종료) java.lang.ArithmeticException: / by zero
---- (2) ArrayIndexOutOfBoundsException ----
배열 인덱스 범위를 벗어나 접근했습니다
---- (3) NumberFormatException ----
숫자로 변환 불가능 문자열 사용
---- (4) NullPointerException ----
NullPointerException..
```

**포인트**

- unchecked 예외 : 예외가 발생할 수 있지만, 별도의 예외 처리를 하지 않은 경우에도 컴파일 오류를 유발하지 않는 예외
- 모든 unchecked 예외는 RuntimeException 클래스를 상속한다.
- divide-by-zero 에 의해 발생하는 ArithmeticException 이 대표적이다.
- unchecked 예외 처리는 전적으로 프로그래머에게 달려 있다. (처리해도 되고 안 해도 컴파일은 된다)

- (1) ArithmeticException            : int r = n1 / n2;   (n2 == 0) → 예외가 발생하지만 컴파일 오류 없이 컴파일된다
- (2) ArrayIndexOutOfBoundsException : 길이 5 인 배열의 arr\[6] 에 접근
- (3) NumberFormatException          : Integer.parseInt("XYZ") → 숫자로 변환할 수 없는 문자열
- (4) NullPointerException           : null 인 참조 변수로 메소드를 호출 (str.length())

- ⚠ 자주 틀리는 부분 : 강의의 (4) 번 코드는 String str; 만 선언하고 str.length() 를 부른다. 이것은 NullPointerException 이 아니라 컴파일 오류다. 지역 변수는 값을 넣기 전에 쓸 수 없기 때문이다. (7강 변수의 유효 범위 - 지역 변수는 자동으로 초기화되지 않음)
  ```text
  error: variable str might not have been initialized
  ``` NullPointerException 을 보려면 String str = null; 처럼 null 을 명시적으로 넣어야 한다. 아래 코드는 그렇게 고쳤다.<br>(필드(멤버 변수)는 자동으로 null 로 초기화되므로, 필드라면 강의 코드처럼 써도 NullPointerException 이 난다)
- 💡 (1) 을 try-catch 없이 실행하면 프로그램이 멈추고 다음 메시지가 나온다. 아래에서는 확인용으로 잡아서 메시지만 출력했다.
  ```text
  Exception in thread "main" java.lang.ArithmeticException: / by zero
  ```
- 💡 NullPointerException 의 메시지는 JDK 14 부터 "어떤 변수가 null 이었는지" 까지 알려 준다. (Helpful NullPointerExceptions)
- 💡 강의 코드의 public class 이름은 모두 Example. 한 파일에 넣으려고 case1 \~ case4 메소드로 나눴다.

## 사용자 정의 예외

`11-2 예외처리2` · 📄 [`UserDefinedExceptionTest.java`](UserDefinedExceptionTest.java)

#### 💻 코드

<!-- code: UserDefinedExceptionTest.java -->
```java
public class UserDefinedExceptionTest {
    public static void main(String args[]) {
        try {
            throw new NullNameException();
        } catch (NullNameException e) {
            System.out.println("사용자 정의 예외 발생");
            System.out.println(e);
        }

        try {
            throw new CountZeroException("hoho");
        } catch (CountZeroException e) {
            System.out.println(e);
            System.out.println("getMessage() → " + e.getMessage());   // 💡 확인용
        }
    }
}

class NullNameException extends Exception {   // 사용자 정의 예외 클래스
    public String toString() {
        return ("이름 미지정");
    }
}

class CountZeroException extends Exception {
    public CountZeroException() { }

    public CountZeroException(String message) {   // 강의 코드 : string (⚠ 소문자)
        super(message);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
사용자 정의 예외 발생
이름 미지정
CountZeroException: hoho
getMessage() → hoho
```

**포인트**

- 프로그램을 작성하다 보면 프로그램에 맞는 예외를 정의하고, 이를 필요한 순간에 발생시키고 싶은 경우에 사용한다.
- 사용자 정의 예외 클래스는 Exception 또는 RuntimeException 을 상속받는 형태로 정의해야 한다.
- Exception 클래스를 상속할 경우 사용자 정의 예외는 checked 예외, RuntimeException 클래스를 상속하면 unchecked 예외가 된다.

- (1) toString() 을 재정의한 예외 : NullNameException
    - System.out.println(e) 를 하면 e.toString() 이 자동으로 불린다. 재정의했으므로 "이름 미지정" 이 출력된다.
- (2) 인수가 있는 예외 : CountZeroException
    - 인수가 있는 예외 클래스를 정의할 경우, 예외 메시지를 별도의 필드에 저장해도 되지만 상위 예외 클래스의 필드를 활용할 수 있다.<br>→ super(message) 로 부모(Exception → Throwable)에게 메시지를 넘긴다.
    - toString() 을 재정의하지 않았으므로 Throwable 의 toString() 형식 "클래스이름: 메시지" 로 출력된다. → CountZeroException: hoho

- ⚠ 자주 틀리는 부분 : 강의 코드의 public CountZeroException(string message) 는 소문자 string 이라 컴파일 오류다. String 으로 고쳤다.
  ```text
  error: cannot find symbol  symbol: class string
  ```
- 💡 CountZeroException 처럼 매개변수 있는 생성자를 만들면 기본 생성자가 자동으로 생기지 않는다. 그래서 강의 코드는
  ```java
  public CountZeroException() {} 도 함께 만들었다. (throw new CountZeroException(); 도 쓸 수 있게)
  ```
- 💡 사용자 정의 예외를 왜 만드나? ArithmeticException 같은 표준 예외는 "무엇이 잘못됐는지" 를 프로그램의 용어로 말해 주지 못한다.<br>NullNameException 처럼 이름만 봐도 상황을 알 수 있는 예외를 만들면, catch 에서 상황별로 나눠 처리하기 쉽다.
- 💡 강의 코드의 public class 이름은 Example, ExceptionDemo. 한 파일에 넣으려고 하나의 main 으로 합쳤다.

## \[실습] 사용자 정의 예외 - throw 와 throws

`11-2 예외처리2` · 📄 [`UserExceptionTest.java`](UserExceptionTest.java)

#### 💻 코드

<!-- code: UserExceptionTest.java -->
```java
class MyException extends Exception {
    public MyException(String mymsg) {
        super(mymsg);
    }
}

public class UserExceptionTest {
    public static void main(String[] args) throws MyException {
        UserExceptionTest es = new UserExceptionTest();
        es.displayMymsg();
    }

    public void displayMymsg() throws MyException {
        for (int i = 8; i > 0; i--) {
            System.out.println("i= " + i);
            if (i == 3)
                throw new MyException("사용자 정의 예외");
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
i= 8
i= 7
i= 6
i= 5
i= 4
i= 3
Exception in thread "main" MyException: 사용자 정의 예외
    at UserExceptionTest.displayMymsg(UserExceptionTest.java:46)
    at UserExceptionTest.main(UserExceptionTest.java:39)
```

**포인트**

- throw 와 throws
  ```java
  throw  : 예외를 강제로 발생시킬 경우 사용한다. 메소드 몸체 안에서 사용한다.      throw new MyException("...");
  ```<br>throws : 예외가 발생함을 선언할 때 사용한다. 메소드 선언의 일부분으로 사용한다.  void displayMymsg() throws MyException
- displayMymsg() : i 를 8 부터 1 까지 줄이면서 출력하다가 i == 3 이 되면 MyException 을 던진다.<br>MyException 은 Exception 을 상속한 checked 예외라서 displayMymsg() 에 throws MyException 이 필요하다.
- main 도 throws MyException 으로 선언했다. main 에서 잡지 않고 다시 떠넘겼으므로, 예외는 JVM 까지 전달되어 프로그램이 스택 트레이스를 출력하고 비정상 종료된다. ("i= 2", "i= 1" 은 출력되지 않는다)

- ⚠ 자주 틀리는 부분 : main 에 throws 를 붙이면 컴파일은 되지만 예외를 "처리" 한 것이 아니다. JVM 이 받아서 프로그램을 멈출 뿐이다.<br>깔끔하게 처리하려면 main 안에서 try-catch 로 잡아야 한다. (실습 Vowel\_Check.java 📝 필기 ②)
  ```java
  try { es.displayMymsg(); } catch (MyException e) { System.out.println("예외 처리 : " + e.getMessage()); }
  ```
- 💡 이 파일은 강의 코드 그대로라서 실행하면 마지막에 예외로 종료된다(종료 코드 1). 스택 트레이스는 System.err 로 출력된다.
- 💡 displayMymsg() 는 static 이 아니라서 main 에서 객체(es)를 만든 뒤 호출한다.

---

[🏠 11주차 학습 가이드](../../README.md)
