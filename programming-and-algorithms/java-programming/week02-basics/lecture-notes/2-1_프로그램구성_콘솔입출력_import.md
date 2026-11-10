# 2-1. 변수와 자료형 1: 프로그램 구성 · 콘솔 입출력 · import

> 원본: `2-1 변수와 자료형1.pptx`
> 관련 코드: [`examples/ProgramBasic.java`](../examples/ProgramBasic.java), [`practice/variables/Literal.java`](../practice/variables/Literal.java)

---

## 1. 프로그램 및 클래스 구성: 메인 메소드

이클립스에서 `ProgramBasic` 클래스를 만들면 아래 코드가 자동으로 생성된다.

```java
public class ProgramBasic {
    public static void main(String[] args) {
        // 이 부분은 한 줄짜리 주석
        /* 이 부분은
           여러 줄짜리
           주석 */
    }
}
```

- 프로그램을 이루는 클래스 중 **적어도 하나**는 `main` 메소드를 제공해야 한다.

```java
public static void main(String[] args)
```

> ⚠ 슬라이드에는 `public static int main(...)`으로 적혀 있지만 오타다. 자바의 main 메소드는 반드시 **`void`** 를 반환한다.

| 키워드 | 의미 |
|---|---|
| `public` | 외부에서 호출할 수 있다 |
| `static` | 객체를 만들지 않고 호출할 수 있다 |
| `String[] args` | 실행 파일명과 함께 주어지는 인라인 인수(명령행 인수)를 받아서 쓸 수 있게 한다 |

```bash
java Hello2030 aaa bbb    # args[0] = "aaa", args[1] = "bbb"
```

> 📝 **필기: 자바와 파이썬의 구조 차이 (블록과 들여쓰기)**
> - **파이썬**은 들여쓰기로 명령어의 레벨(Scope)을 구분하며, 들여쓰기 규칙이 매우 엄격하다.
> - **자바**는 중괄호 `{ }`로 명령어의 레벨을 구분한다. 들여쓰기는 문법적으로 강제되지 않고 개발자 사이의 **가독성**을 위해서만 쓴다.

---

## 2. 콘솔 출력

- 콘솔 출력은 `System.out` 필드에 저장된 객체가 담당한다.
- `java.lang.System`의 `out` 필드는 `java.io.PrintStream` 클래스로 만든 객체다.
- `out.필드명` 또는 `out.메소드명` 형태로 사용한다.

| 메소드 | 동작 | C++ 비유 |
|---|---|---|
| `print` | 문자열을 출력하고 줄을 바꾸지 않음 | `cout << ...` |
| `println` | 문자열을 출력하고 줄을 바꿈 | `cout << ... << endl` |

두 메소드 모두 출력할 내용을 인수로 받는다.

```java
// "자바만 잡아도" 출력 후 줄바꿈
java.lang.System.out.println("자바만 잡아도");
```

> 📝 **필기:** `System.out`은 `PrintStream` 객체이고, 여기에 저장된 것을 출력하는 형태다.
> 📝 **필기: 교수님이 언급하신 서식 지정자 `printf`**
> ```java
> System.out.printf("%s, %d, %.1f, %.2f\n", name, age, height, weight);
> ```
> - `%s`는 문자열, `%d`는 10진 정수, `%f`는 실수다. `%f`는 기본 소수점 6자리이고, `%.1f`는 1자리, `%.2f`는 2자리로 출력한다.
> - `printf`는 `println`과 달리 자동으로 줄을 바꾸지 않는다. `\n`(또는 `%n`)을 직접 넣는다.
> - 한글 윈도우 폰트에서는 `\`가 `₩`로 보이지만 같은 문자다.
> → [`practice/variables/PersonInfo.java`](../practice/variables/PersonInfo.java)

---

## 3. 콘솔 입력

- 콘솔 입력은 `System.in` 필드에 저장된 객체가 담당한다.
- 하지만 이 객체는 기본 자료형 단위로 입력받는 기능을 제공하지 않는다.
- 그래서 `System.in`을 이용해 더 편한 입력 기능을 제공하는 **`java.util.Scanner`** 클래스를 사용한다.

```java
// Scanner를 이용한 콘솔 입력
Scanner sc = new Scanner(System.in);
int i = sc.nextInt();   // int형 읽기
```

| 메소드 | 읽는 값 |
|---|---|
| `next()` | String (공백 전까지 한 단어) |
| `nextInt()` | int |
| `nextBoolean()` | boolean |
| `nextByte()` | byte |
| `nextDouble()` | double |
| `nextFloat()` | float |
| `nextLine()` | 한 줄 전체 |

> 📝 **필기: 입력의 2단계 구조**
> 1. **로우 레벨(Low-level): `System.in`**
>    - 타입은 `java.io.InputStream`이다.
>    - 콘솔 입력을 가장 원초적인 형태인 **1바이트씩**만 읽을 수 있어서 직접 쓰기에는 매우 불편하다.
> 2. **하이 레벨(High-level): `Scanner`**
>    - 로우 레벨 객체 `System.in`을 매개변수로 넘겨받는다.
>    - 넘겨받은 입력을 문자열, 실수 등 개발자가 다루기 쉬운 형태로 변환해 준다.
>    - 그래서 스캐너를 만들 때 `System.in`을 꼭 넘겨야 한다. `new Scanner()`처럼 비워 두면 에러가 난다.
>    - Scanner의 메소드를 호출해도 최종적으로는 `System.in`을 통해 로우 레벨에서 읽는다.
>
> 📝 **필기:** 입력받을 값의 타입에 맞는 메소드를 써야 한다. 예를 들어 `double db = sc.next();`는 에러다. `next()`는 String을 반환하므로 `sc.nextDouble()`을 써야 한다.

### Scanner 닫기

Scanner 객체는 시스템 리소스(자원)를 잡고 있다. 그러니 다 쓴 뒤에는 `close()`를 호출해 자원을 돌려주는 습관을 들인다.

```java
Scanner sc = new Scanner(System.in);
int i = sc.nextInt();
// ...
sc.close();   // 사용 후 꼭 닫아 자원을 환원!
```

> 📝 **필기: 자원 관리 규칙**
> - 스캐너는 프로그램 안에서 **한 번만 생성**하고 재사용하는 것이 좋다. 같은 이름으로 다시 선언하면 중복 선언 에러도 난다.
> - 메모리와 자원 낭비를 막기 위해 다 쓴 뒤 `sc.close();`로 닫는다.
>
> 💡 닫은 뒤에는 그 스캐너를 다시 쓸 수 없다. `close()`를 먼저 호출한 다음 `nextInt()`를 부르면 `IllegalStateException`이 발생한다(과제 Test1의 오류 중 하나). → [`assignment/variables/Test1.java`](../assignment/variables/Test1.java)

---

## 4. import 문의 필요성

`import`를 쓰면 클래스의 풀네임을 한 번만 쓰면 된다.

```java
import java.lang.System;
// ...
System.out.println("자바만 잡아도");
// ...
System.out.println("자바만 Java도");
```

- **`java.lang` 패키지에 있는 모든 클래스는 자동으로 import된다.** 그래서 위 예제의 `import java.lang.System;`은 생략할 수 있다.
  `String`, `Math`, `Integer`, `System` 등이 여기에 속한다.
- 다른 패키지의 클래스를 쓸 때는 import를 반드시 적어야 한다.

```java
import java.util.Random;
import java.util.Date;
// ...
import java.util.*;
/* 같은 패키지에서 쓰는 클래스가 한두 개가 아니면
   위처럼 .* 를 사용해 패키지 전체를 import 하는 것이 좋다 */
```

> 📝 **필기: import 문의 역할**
> - 자바 컴파일러는 기본 패키지(`java.lang`) 밖에 있는 클래스나 유틸리티의 위치를 스스로 알지 못한다.
> - 이미 정의된 클래스라도 `import java.util.Scanner;`처럼 명시해야 한다. 그래야 컴파일러가 "이 클래스를 가져와서 쓰는구나" 하고 해석할 수 있다.
> - import하지 않으면 자바는 Scanner 클래스 정의를 알 수 없어 사용할 수 없다. 이클립스에서는 `Scanner cannot be resolved to a type` 에러가 난다.

---

## 5. Python import 문과의 차이점

- Python의 `import`는 객체를 프로그램 **네임스페이스로 가져온다**.
- Java의 `import`는 전체 이름을 쓰지 않고도 참조할 수 있게 해서 **타이핑을 줄여줄 뿐**이다.
- 자바는 import 문 없이도 클래스를 쓸 수 있다(풀네임 사용). Python은 그렇지 않다.

```java
// In Java
java.util.ArrayList ob = new java.util.ArrayList();     // import 없이 풀네임 사용

import java.util.ArrayList;
ArrayList ob = new ArrayList();                          // import 후 짧은 이름 사용
```

```python
# In Python
import os.path        # 사용 시 os.path 로 사용
from os import path   # 사용 시 path 로 사용
```
