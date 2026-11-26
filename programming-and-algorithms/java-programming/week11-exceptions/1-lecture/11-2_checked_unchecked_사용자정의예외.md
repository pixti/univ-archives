# 11-2. 예외처리 2: checked 예외 · unchecked 예외 · 사용자 정의 예외

[🏠 11주차 학습 가이드](../README.md)

> 관련 코드: [`code/CheckedExceptionDemo.java`](code/CheckedExceptionDemo.java), [`code/UncheckedExceptionTest.java`](code/UncheckedExceptionTest.java), [`code/UserDefinedExceptionTest.java`](code/UserDefinedExceptionTest.java), [`code/UserExceptionTest.java`](code/UserExceptionTest.java), [`quiz/ExceptionQuiz.java`](../2-quiz/ExceptionQuiz.java), [`practice/exceptions/`](../3-practice/exceptions), [`assignment/exceptions/`](../4-assignment/exceptions)

**목차**

1. checked 예외
2. unchecked 예외
3. 📝 checked vs unchecked 정리
4. 사용자 정의 예외
5. throw와 throws
6. [실습] 사용자 정의 예외

---

## 1. checked 예외

- checked 예외와 unchecked 예외가 있다.
- **checked는 컴파일 시 검사**하고, unchecked는 검사하지 않는다는 차이점이 있다.

```java
import java.io.FileInputStream;
public class ExceptionDemo {   // 컴파일시 다음과 같은 에러가 발생
    public static void main(String[] args) {
        FileInputStream fis = null;                  // FileNotFoundException
        fis = new FileInputStream("C:/test.txt");

        int c;
        while ((c = fis.read()) != -1)              // IOException
        {
            System.out.print((char) c);
        }
        fis.close();                                // IOException
    }
}
```

```
error: unreported exception FileNotFoundException; must be caught or declared to be thrown
error: unreported exception IOException; must be caught or declared to be thrown
```

위의 코드를 다음과 같이 처리한다.

```java
import java.io.*;
public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            FileInputStream fis = null;
            fis = new FileInputStream("C:/test.txt");
            int c;
            while ((c = fis.read()) != -1)
                System.out.print((char) c);

            fis.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("The specified file is not present at the given path");
        }
        catch (IOException e) {
            System.out.println("I/O error occurred: " + e);
        }
    }
}
```

```
The specified file is not present at the given path        ← C:/test.txt 가 없을 때
```

→ [`code/CheckedExceptionDemo.java`](code/CheckedExceptionDemo.java)

> 💡 **보충:**
> - `FileInputStream`은 파일을 1바이트씩 읽는 클래스다(13강 파일 입출력). `read()`는 읽은 바이트를 `int`로 돌려주고, 파일 끝이면 `-1`을 돌려준다.
> - ⚠ **자주 틀리는 부분:** `FileNotFoundException`은 `IOException`의 **자식**이다. 그래서 `catch (IOException e)`를 먼저 쓰면 `FileNotFoundException`의 `catch`에 도달할 수 없어 컴파일 오류가 난다(`exception FileNotFoundException has already been caught`).
> - 강의 코드는 `fis.close()`를 `try` 안에 두었다. 읽다가 예외가 나면 `close()`가 건너뛰어지므로, 원래는 `finally`에서 닫거나 Java 7의 **try-with-resources**를 쓰는 것이 안전하다.
>   ```java
>   try (FileInputStream fis = new FileInputStream("C:/test.txt")) { ... }   // 블록이 끝나면 자동으로 close()
>   ```

---

## 2. unchecked 예외

- 예외를 발생할 수 있지만, 별도의 예외 처리를 하지 않은 경우에도 **컴파일 오류를 유발하지 않는** 예외다.
- 모든 unchecked 예외는 **`RuntimeException` 클래스를 상속**한다.
- divide-by-zero에 의해 발생하는 `ArithmeticException`이 대표적이다.

```java
public class Example {
    public static void main(String args[])
    {
        int n1 = 3;
        int n2 = 0;

        int r = n1 / n2;   // 예외가 발생하지만 컴파일 오류없이 컴파일 됨
        System.out.println(r);
    }
}
```

```
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

- unchecked 예외 처리는 **전적으로 프로그래머에게 달려 있다.**

```java
public class Example {
    public static void main(String args[])
    {
        try {
            String arr[] = {"a", "b", "c", "d", "e"};
            System.out.println(arr[6]);   // 예외발생
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱스 범위를 벗어나 접근했습니다");
        }
    }
}
```

```java
public class Example {
    public static void main(String args[]) {
        try {
            int n = Integer.parseInt("XYZ");   // 예외발생
            System.out.println(n);
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환 불가능 문자열 사용");
        }
    }
}
```

```java
public class Example {
    public static void main(String args[]) {
        try {
            String str = null;                 // 예외발생
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException..");
        }
    }
}
```

→ 네 경우를 한 파일로: [`code/UncheckedExceptionTest.java`](code/UncheckedExceptionTest.java)

```
---- (1) ArithmeticException ----
(처리하지 않으면 프로그램 종료) java.lang.ArithmeticException: / by zero
---- (2) ArrayIndexOutOfBoundsException ----
배열 인덱스 범위를 벗어나 접근했습니다
---- (3) NumberFormatException ----
숫자로 변환 불가능 문자열 사용
---- (4) NullPointerException ----
NullPointerException..
```

> ⚠ **자주 틀리는 부분:** 강의의 마지막 코드는 `String str;`만 선언하고 `str.length()`를 부른다. 이것은 `NullPointerException`이 아니라 **컴파일 오류**다. 지역 변수는 값을 넣기 전에 쓸 수 없기 때문이다(`error: variable str might not have been initialized`). `NullPointerException`을 보려면 위 코드처럼 `String str = null;`로 `null`을 명시적으로 넣어야 한다. (필드는 자동으로 `null`로 초기화되므로, 필드라면 NPE가 난다)

| 예외 | 언제 나나 |
|---|---|
| `ArithmeticException` | 정수를 0으로 나눌 때 |
| `ArrayIndexOutOfBoundsException` | 배열의 범위(0 ~ 길이-1)를 벗어난 인덱스로 접근할 때 |
| `NumberFormatException` | `Integer.parseInt("XYZ")`처럼 숫자로 바꿀 수 없는 문자열을 변환할 때 |
| `NullPointerException` | `null`인 참조 변수로 필드나 메소드에 접근할 때 |
| `IllegalArgumentException` | 메소드에 부적절한 인자가 전달됐을 때 (실습 2번) |

---

## 3. 📝 checked vs unchecked 정리 (퀴즈 2번, 실습 3·4번)

> 📝 **필기 (실습 3번):** ★) `RuntimeException`과 `Exception` 차이에 대해 주의할 것

```
Throwable
├── Error (시스템의 치명적 오류 - 개발자가 코드로 해결 불가)
│    └── OutOfMemoryError, StackOverflowError 등
└── Exception (개발자가 코드로 처리 가능한 예외)
     ├── [Checked Exception] Exception 을 직접 상속
     │    └── IOException, FileNotFoundException, 사용자 정의 예외(extends Exception)
     └── RuntimeException [Unchecked Exception]
          └── ArithmeticException, IllegalArgumentException, NullPointerException 등
```

| 구분 | `extends Exception` (Checked / 검사 예외) | `extends RuntimeException` (Unchecked / 비검사 예외) |
|---|---|---|
| 검사 시점 | **컴파일 시점**에 컴파일러가 강제 검사 | **실행 시점**에 발생 (컴파일러가 관여 안 함) |
| `try-catch` / `throws` | **반드시** 작성 (안 쓰면 컴파일 에러 ❌) | 선택 사항 (안 써도 컴파일 성공 ⭕) |
| 주된 사용 목적 | 복구 가능하거나, 호출하는 쪽이 반드시 인지하고 대처해야 하는 상황 (파일 없음, 네트워크 끊김, 입력 규칙 위반) | 주로 개발자의 코딩 실수(버그) (0으로 나누기, 배열 범위 초과, null 참조) |

> 📝 **필기 (퀴즈 2번):** `try ~ catch`로 하지 않는 경우 `throws`로 어떤 예외가 발생할 수 있다고 명시해야 한다. `throws FileNotFoundException, ArithmeticException`에서 `ArithmeticException`은 `RuntimeException`이라 명시하지 않아도 된다.
> - 예외가 발생할 수 있는 코드를 쓰면 **둘 중 하나**를 골라야 한다.
>   1. **직접 처리(`try ~ catch`):** 예외가 발생한 그 메서드 안에서 바로 처리한다. → `throws` 불필요
>   2. **예외 떠넘기기(`throws`):** 직접 처리하지 않고 이 메서드를 호출한 곳(상위 메서드)으로 예외 처리를 위임한다. → 호출한 쪽이 `try-catch`로 처리
> - **왜 `RuntimeException`은 명시를 강제하지 않나?** 나눗셈이나 배열 접근처럼 코드 전반에서 언제든 발생할 수 있는 예외라서, 강제하면 코드 한 줄마다 `try-catch`나 `throws`를 써야 하는 비효율이 생긴다. 그래서 자바는 이를 코드를 올바르게 작성해 **예방**할 문제로 본다.
> → [`quiz/ExceptionQuiz.java`](../2-quiz/ExceptionQuiz.java) 2번

> 💡 **실무 보너스 상식:** 자바의 원래 철학에서는 복구 가능한 예외에 `extends Exception`을 권장하지만, 현대 자바 실무(Spring 등)에서는 `throws`를 메서드마다 적어야 하는 번거로움 때문에 사용자 정의 예외를 `extends RuntimeException`으로 만드는 경우도 많다.

---

## 4. 사용자 정의 예외

- 프로그램을 작성하다 보면 프로그램에 맞는 예외를 정의하고, 이를 필요한 순간에 발생시키고 싶은 경우에 사용한다.
- 사용자 정의 예외 클래스는 **`Exception` 또는 `RuntimeException`을 상속**받는 형태로 정의해야 한다.
- `Exception` 클래스를 상속할 경우 사용자 정의 예외는 **checked 예외**, `RuntimeException` 클래스를 상속하면 **unchecked 예외**가 된다.

```java
class NullNameException extends Exception {   // 사용자 정의 예외 클래스
    public String toString() {
        return ("이름 미지정");
    }
}
public class Example {
    public static void main(String args[]) {
        try {
            throw new NullNameException();
        }
        catch (NullNameException e) {
            System.out.println("사용자 정의 예외 발생");
            System.out.println(e);
        }
    }
}
```

```
사용자 정의 예외 발생
이름 미지정
```

- 인수가 있는 예외 클래스를 정의할 경우, 예외 메시지를 별도의 필드에 저장해도 되지만 **상위 예외 클래스의 필드를 활용**할 수 있다.

```java
class CountZeroException extends Exception
{
    public CountZeroException() {}
    public CountZeroException(String message) {
        super(message);
    }
}
public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            throw new CountZeroException("hoho");
        } catch (CountZeroException e) {
            System.out.println(e);
        }
    }
}
```

```
CountZeroException: hoho
```

→ 두 경우를 한 파일로: [`code/UserDefinedExceptionTest.java`](code/UserDefinedExceptionTest.java)

> ⚠ **자주 틀리는 부분:** 강의 코드의 `public CountZeroException(string message)`는 소문자 `string`이라 컴파일 오류다(`cannot find symbol  symbol: class string`). 위 코드는 `String`으로 고쳤다.

> 📝 **필기 (퀴즈 3번):**
> - 일반 클래스로는 예외를 발생시킬 수 없고 `Throwable` 타입이어야만 한다. 따라서 `extends Exception` 또는 `extends RuntimeException`으로 상속을 받아야 한다.
> - 모든 객체에 대해서 `toString`이 정의되어 있다. 예외 객체에 대해서도 재정의할 수 있다. → `NullNameException`처럼 `toString()`을 재정의하면 `System.out.println(e)`가 그 문자열을 출력한다.
> - `NegativeSalary("임금이 음수입니다!");`처럼 에러 메시지를 넘겨줄 수도 있는데, 하위 클래스에서 직접 부모 클래스에 대한 세팅이 안 된다(메시지는 부모의 **private 필드**를 물려받은 것이기 때문). 세팅하려면 부모 생성자를 이용해야 해서 **`super(e)`로 에러 메시지를 넘겨줘야** 한다.
>   ```java
>   // Java 내부의 Throwable 클래스 구조 (개념도)
>   public class Throwable {
>       private String detailMessage;          // private → 자식도 직접 접근 불가
>       public Throwable(String message) {     // 부모의 생성자
>           this.detailMessage = message;      // 자기 자신의 생성자에서는 세팅 가능
>       }
>       public String getMessage() {
>           return this.detailMessage;
>       }
>   }
>   ```
>   그래서 `super(msg)`로 부모 생성자를 불러 메시지를 저장하고, 나중에 `e.getMessage()`로 꺼낸다. `super(message)`를 빼먹으면 `getMessage()`가 `null`을 반환한다.
> → [`quiz/ExceptionQuiz.java`](../2-quiz/ExceptionQuiz.java) 3번

> 💡 **보충: 예외 정보를 출력하는 세 가지 방법 (실습 1번 📝 필기)**
>
> | 코드 | 출력 내용 | 주로 쓰는 상황 |
> |---|---|---|
> | `e.getMessage()` | `Cannot divide the given number by zero!` (메시지만) | 사용자에게 깔끔한 안내 문구만 보여 줄 때 |
> | `e` (또는 `e.toString()`) | `java.lang.ArithmeticException: Cannot divide...` (예외 종류 + 메시지) | 어떤 예외인지 간단히 로그로 남길 때 |
> | `e.printStackTrace()` | 예외 종류 + 메시지 + 발생한 코드 줄 번호(스택 트레이스) | 개발자가 디버깅할 때 |
>
> `println(e)`는 자동으로 `e.toString()`을 부르고, `Throwable`의 `toString()`은 `"패키지명.예외클래스명: " + 메시지` 형태다. 메시지 없이 `new ArithmeticException()`으로 만들면 `getMessage()`는 `null`이다.

---

## 5. throw와 throws

- **`throw`**는 예외를 **강제로 발생**시킬 경우 사용하고, **`throws`**는 예외가 **발생함을 선언**할 때 사용한다.
- `throw`는 **메소드 몸체 안**에서 사용하고, `throws`는 **메소드 선언의 일부분**으로 사용한다.

| 키워드 | 위치 | 역할 | 개수 |
|---|---|---|---|
| `throw` | 메소드 내부 | 예외 객체를 생성해서 직접 발생시킴 | 한 번에 1개 (`throw new 예외();`) |
| `throws` | 메소드 선언부(헤더) | "여기서 이런 예외가 나갈 수 있으니 호출한 쪽이 처리하라"고 선언 | 쉼표로 여러 개 (`throws A, B`) |

> ⚠ **자주 틀리는 부분:**
> - `else new NegativeSalary();`처럼 객체를 만들기만 하면 예외가 발생하지 않는다. 반드시 **`throw new ...`**로 던진다. (퀴즈 3번)
> - `main`에 `throws`를 붙이면 컴파일은 되지만 예외를 JVM으로 떠넘기는 것이라, 예외가 나면 프로그램이 스택 트레이스를 출력하고 비정상 종료된다. 깔끔하게 처리하려면 `main` 안에서 `try-catch`를 쓴다.

---

## 6. [실습] 사용자 정의 예외

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

```
i= 8
i= 7
i= 6
i= 5
i= 4
i= 3
Exception in thread "main" MyException: 사용자 정의 예외
	at UserExceptionTest.displayMymsg(UserExceptionTest.java:15)
	at UserExceptionTest.main(UserExceptionTest.java:9)
```

→ [`code/UserExceptionTest.java`](code/UserExceptionTest.java)

> 💡 **보충:**
> - `i == 3`에서 예외가 던져지면 반복문이 바로 끝나서 `i= 2`, `i= 1`은 출력되지 않는다.
> - `MyException`은 `Exception`을 상속한 checked 예외라서 `displayMymsg()`에 `throws MyException`이 필요하다. `main`도 잡지 않고 `throws`로 다시 떠넘겼으므로 JVM이 받아서 프로그램을 멈춘다.
> - `main`에서 잡으려면:
>   ```java
>   try { es.displayMymsg(); }
>   catch (MyException e) { System.out.println("예외 처리 : " + e.getMessage()); }
>   ```
> - 사용자 정의 예외 클래스에 매개변수 있는 생성자를 만들면 **기본 생성자는 자동으로 생기지 않는다.** `throw new MyException();`도 쓰려면 기본 생성자를 따로 적는다(실습 4번 📝 필기).
> - 이클립스는 사용자 정의 예외 클래스 줄에 `serialVersionUID` 노란 경고를 표시한다. 예외 클래스가 `Serializable`을 구현하기 때문인데, 직렬화(14강)를 쓰지 않으면 무시해도 된다.
