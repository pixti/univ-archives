# Week 11: 예외 처리 (try-catch-finally · checked / unchecked · 사용자 정의 예외) + 상속 추가 실습

자바프로그래밍(GA1001) 11주차 정리입니다.

- 강의 내용은 `lecture-notes/`에 Markdown으로 정리했습니다.
- 강의 예제, 실습, 퀴즈, 과제는 `.java` 코드로 정리했습니다.
- 11주차 실습·과제에는 10주차 상속의 추가 문제(인터페이스, 컴포지션, 다중 상속)가 함께 있어서 `inheritance3/` 폴더로 따로 묶었습니다.
- 모든 코드는 **JDK 25**로 실행을 확인했습니다.

| 표시 | 의미 |
|---|---|
| 📝 **필기** | 수업 중 필기한 내용, 질문하며 정리한 설명 |
| 💡 **보충** | 정리하면서 덧붙인 설명, 참고 답안 |
| ⚠ **주의** | 자주 틀리는 부분, 헷갈리기 쉬운 부분 |
| ❌ / ✅ | 틀린 코드 / 고친 코드 |

## 📁 구조

```
week11-exceptions/
├── lecture-notes/          강의 노트
├── examples/               강의 예제 코드
├── practice/               실습
│   ├── inheritance3/       ├ 상속 추가 실습 (인터페이스, 컴포지션, 다중 상속)
│   └── exceptions/         └ 예외 처리
├── quiz/                   퀴즈
└── assignment/             과제
    ├── inheritance3/       ├ 상속 (인터페이스, 다중 상속)
    └── exceptions/         └ 예외 처리
```

## 📖 강의 노트

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 11-1 | [기본 예외 처리 · 예외 처리 순서](lecture-notes/11-1_기본예외처리_예외처리순서.md) | `try-catch`(⚠ `try` 안에서 선언한 변수), `finally`의 세 가지 경우(⚠ `int num = 3.14`), 다중 `catch`와 순서(⚠ `Exception`은 맨 아래), rethrow, 중첩 `try-catch`, 📝 `Throwable` · `Error` · `Exception` · `RuntimeException` 계층 |
| 11-2 | [checked · unchecked · 사용자 정의 예외](lecture-notes/11-2_checked_unchecked_사용자정의예외.md) | checked 예외(파일 입출력), unchecked 예외 4가지(⚠ `String str;`는 NPE가 아니라 컴파일 오류), 📝 checked vs unchecked 표, 사용자 정의 예외(`toString` 재정의, `super(message)`, ⚠ `string`), 예외 출력 방법 3가지, `throw` vs `throws` |

## 💻 코드

### 강의 예제 (`examples/`)

| 파일 | 차시 | 내용 |
|---|---|---|
| [DivideExample.java](examples/DivideExample.java) | 11-1 | 입력받은 두 수 나누기, `ArithmeticException`. ⚠ 변수를 `try` 밖에서 선언 |
| [FinallyTest.java](examples/FinallyTest.java) | 11-1 | [실습] `finally` 세 가지 경우: 예외 없음 / 예외 발생 / `catch`와 불일치 |
| [MultipleCatchTest.java](examples/MultipleCatchTest.java) | 11-1 | [실습] 다중 `catch`: `ArithmeticException` / `ArrayIndexOutOfBoundsException` |
| [RethrowTest.java](examples/RethrowTest.java) | 11-1 | 💡 `throw (e)`로 다시 던지기, 중첩 `try-catch` |
| [CheckedExceptionDemo.java](examples/CheckedExceptionDemo.java) | 11-2 | `FileInputStream`의 `FileNotFoundException`, `IOException` 처리 |
| [UncheckedExceptionTest.java](examples/UncheckedExceptionTest.java) | 11-2 | `ArithmeticException`, `ArrayIndexOutOfBoundsException`, `NumberFormatException`, `NullPointerException` |
| [UserDefinedExceptionTest.java](examples/UserDefinedExceptionTest.java) | 11-2 | `NullNameException`(`toString` 재정의), `CountZeroException`(`super(message)`) |
| [UserExceptionTest.java](examples/UserExceptionTest.java) | 11-2 | [실습] `throw`와 `throws`, `main`에서 떠넘기면 비정상 종료 |

### 실습 (`practice/`)

| 파일 | 문제 |
|---|---|
| [inheritance3/ShapeInterfaceTest.java](practice/inheritance3/ShapeInterfaceTest.java) | 1. `Shape` 인터페이스와 `Rectangle` · `Circle` · `Triangle` (📝 일반 · 추상 클래스 · 인터페이스 비교) |
| [inheritance3/SearchableTest.java](practice/inheritance3/SearchableTest.java) | 2. `Searchable` 인터페이스와 `Document` · `WebPage` (📝 `contains()`) |
| [inheritance3/TestPerson.java](practice/inheritance3/TestPerson.java) | 3. `Person` has-a `Job` 컴포지션 (📝 객체 생성 메커니즘, 상속 vs 포함의 메모리 구조) |
| [inheritance3/MultipleInheritanceABC.java](practice/inheritance3/MultipleInheritanceABC.java) | 4. `A`, `B`를 모두 상속받는 `C`: 다중 상속(불가) / 컴포지션 / 인터페이스 + 컴포지션 (📝 다이아몬드 문제) |
| [exceptions/Exception_Example.java](practice/exceptions/Exception_Example.java) | 1. 0으로 나누기를 `throw`하고 `try-catch`로 잡기 (📝 `getMessage()` vs `e` vs `printStackTrace()`) |
| [exceptions/Exception_OddNumber.java](practice/exceptions/Exception_OddNumber.java) | 2. 홀수이면 `IllegalArgumentException` (📝 `n % 2 != 0`이 안전한 이유) |
| [exceptions/DuplicateNumberTest.java](practice/exceptions/DuplicateNumberTest.java) | 3. 중복 숫자이면 `Duplicate_Number_Exception` (📝 checked라서 `throws` 필수, 💡 `HashSet`) |
| [exceptions/Vowel_Check.java](practice/exceptions/Vowel_Check.java) | 4. 모음이 없으면 `NoVowelsException` (📝 Exception vs RuntimeException, 헷갈리는 개념 5가지, 풀이 6가지) |

### 퀴즈 (`quiz/`)

| 파일 | 내용 |
|---|---|
| [ExceptionQuiz.java](quiz/ExceptionQuiz.java) | 1번 문자열을 `throw`할 수 없는 이유(📝 `Throwable` 계층), 2번 `throws` · `throw` 빈칸(📝 직접 처리 vs 떠넘기기, checked vs unchecked), 3번 사용자 정의 예외 `NegativeSalary`(📝 `toString` 재정의, `super(msg)`로 메시지 전달), 4번 `catch` 순서 오류 |

### 과제 (`assignment/`)

| 파일 | 문제 |
|---|---|
| [inheritance3/PlayableTest.java](assignment/inheritance3/PlayableTest.java) | 1. `Playable` 인터페이스와 `Football` · `Volleyball` · `Basketball` |
| [inheritance3/BankSystemTest.java](assignment/inheritance3/BankSystemTest.java) | 2. `Bank`, `Account` 인터페이스, `SavingsAccount`(이자) · `CurrentAccount`(마이너스 한도) |
| [inheritance3/TATest.java](assignment/inheritance3/TATest.java) | 3. `Faculty`와 `Student`의 특성을 모두 갖는 `TA`: (a) 컴포지션 / (b) 컴포지션 + 인터페이스 |
| [exceptions/SafeArrayTest.java](assignment/exceptions/SafeArrayTest.java) | 1. 잘못된 인덱스이면 `IndexException` |
| [exceptions/BankAccountTest.java](assignment/exceptions/BankAccountTest.java) | 2. 잔액보다 많이 인출하면 `NegativeBalance` (⚠ 문제의 `NotEnoughBalance`와 이름 불일치) |
| [exceptions/StackTest.java](assignment/exceptions/StackTest.java) | 3. `Stack Underflow` / `Stack Overflow`를 `Exception`으로 (⚠ 스택은 LIFO) |
| [exceptions/SearchArrayTest.java](assignment/exceptions/SearchArrayTest.java) | 4. 찾는 숫자가 없으면 `NotFound` |

## ▶ 실행 방법

모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java examples/FinallyTest.java
java practice/exceptions/Vowel_Check.java
java quiz/ExceptionQuiz.java
java assignment/exceptions/StackTest.java
```

키보드 입력을 받는 파일(`DivideExample`, `DuplicateNumberTest`, `SearchArrayTest`)은 실행한 뒤 값을 입력하거나, 입력을 넘겨서 실행합니다.

```bash
echo 6 1 2 3 3 4 5 | java practice/exceptions/DuplicateNumberTest.java
```

Windows 콘솔에서 한글이 깨지면 다음과 같이 인코딩을 지정합니다. 스택 트레이스(`printStackTrace()`)는 `System.err`로 출력되므로 `stderr.encoding`도 함께 지정합니다.

```bash
java -Dstdout.encoding=UTF-8 -Dstderr.encoding=UTF-8 -Dstdin.encoding=UTF-8 assignment/exceptions/BankAccountTest.java
```

> ⚠ **파일마다 독립된 프로그램입니다.**
> - 각 파일에는 `public class` 하나와 그 파일에서 쓰는 보조 클래스(예외 클래스, `Shape`, `Person` 등)가 함께 들어 있습니다. IntelliJ 모듈(`examples`+`quiz`, 실습 2개, 과제 2개) 안에서는 보조 클래스 이름이 겹치지 않도록 정리해서, 모듈 단위로 빌드해도 오류가 나지 않습니다.
> - 서로 다른 모듈(예: 실습 `inheritance3`와 과제 `inheritance3`)에는 같은 이름의 클래스가 있을 수 있습니다. 주차 폴더 전체를 `javac`로 한 번에 컴파일하지 말고, 위처럼 `java 파일이름.java`로 **한 파일씩** 실행하세요.

> 💡 **일부러 예외로 끝나는 파일**
> - `examples/UserExceptionTest.java`는 강의 코드 그대로 `main`에서 `throws`로 예외를 떠넘기므로, 실행하면 스택 트레이스를 출력하고 종료 코드 1로 끝납니다.
> - 과제의 예외 처리 문제는 `catch`에서 `e.printStackTrace()`를 부르므로 빨간 글씨의 스택 트레이스가 정상 출력입니다. 줄 번호는 파일 구성에 따라 문제의 실행 결과와 다릅니다. `java 파일이름.java`로 실행하면 맨 아래에 `SourceLauncher` 줄이 몇 줄 더 붙습니다.

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다. 단, 서로 다른 폴더(예: 실습과 과제)의 파일은 보조 클래스 이름이 겹칠 수 있으니 같은 프로젝트(패키지)에 함께 넣지 말고 하나씩 넣어서 실행합니다.
실습·과제는 원래 이클립스에서 `Main.java`, `Test2.java` 등으로 작성했던 코드입니다. 여기서는 문제 내용에 맞게 클래스 이름을 바꿨습니다(문제에 이름이 정해진 `Exception_Example`, `Exception_OddNumber`, `Vowel_Check`, `TestPerson`은 그대로 두었습니다).
