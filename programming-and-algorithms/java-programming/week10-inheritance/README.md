# Week 10: 상속 (접근 제어 · 재정의 · 추상 클래스 · 인터페이스 · 바인딩 · Wrapper)

자바프로그래밍(GA1001) 10주차 정리입니다.

- 강의 내용은 `lecture-notes/`에 Markdown으로 정리했습니다.
- 강의 예제, 실습, 퀴즈, 과제는 `.java` 코드로 정리했습니다.
- 모든 코드는 **JDK 25**로 실행을 확인했습니다. 수업 기준과 동작이 다른 부분(`finalize()` 경고, `new Integer()` deprecated, 인터페이스의 `default` 메소드)은 ⚠ 또는 💡로 표시했습니다.

| 표시 | 의미 |
|---|---|
| 📝 **필기** | 수업 중 필기한 내용, 질문하며 정리한 설명 |
| 💡 **보충** | 정리하면서 덧붙인 설명, 참고 답안 |
| ⚠ **주의** | 자주 틀리는 부분, 헷갈리기 쉬운 부분 |
| ❌ / ✅ | 틀린 코드 / 고친 코드 |

## 📁 구조

```
week10-inheritance/
├── lecture-notes/          강의 노트
├── examples/               강의 예제 코드
│   └── otherpkg/           └ 다른 패키지 접근 예제용 부모 클래스
├── practice/               실습
│   ├── inheritance1/       ├ 상속
│   └── inheritance2/       └ 상속 (추상 클래스)
├── quiz/                   퀴즈
└── assignment/             과제
    ├── inheritance1/       ├ 상속
    └── inheritance2/       └ 상속 (추상 클래스)
```

## 📖 강의 노트

| 차시 | 노트 | 주요 내용 |
|---|---|---|
| 10-1 | [상속 및 접근 제어 · 메소드 재정의](lecture-notes/10-1_상속_접근제어_메소드재정의.md) | `extends`, 접근자별 접근 범위 표(같은 클래스 / 같은 패키지 / 다른 패키지 × 하위 · 비하위), 메소드 재정의와 `super.메소드()`(⚠ 무한 재귀), 📝 오버로딩 vs 오버라이딩, `final` 메소드 · 클래스, 상위 클래스 생성자 호출 순서(⚠ `finalize`는 부모 것이 자동 호출되지 않음), `this(...)` · `super(...)` |
| 10-2 | [추상 클래스 · 인터페이스](lecture-notes/10-2_추상클래스_인터페이스.md) | 추상 메소드와 추상 클래스, 인터페이스(`implements`, `static final` 필드, `static` 메소드, 💡 `default` 메소드), 추상 클래스 vs 인터페이스, 인터페이스를 이용한 다중 상속(위임), [실습] `Pickup` |
| 10-3 | [바인딩 · 익명 클래스 · 형변환 · Wrapper](lecture-notes/10-3_바인딩_익명클래스_형변환_래퍼클래스.md) | 필드는 정적 바인딩, 메소드는 동적 바인딩(📝 자바는 정적 타입 언어), static 바인딩, 익명 내부 클래스, 업캐스팅 · 다운캐스팅(⚠ `ClassCastException`), 인터페이스 형변환, `instanceof`, Wrapper 클래스와 (auto)boxing · unboxing |

## 💻 코드

### 강의 예제 (`examples/`)

| 파일 | 차시 | 내용 |
|---|---|---|
| [AccessControlTest.java](examples/AccessControlTest.java) | 10-1 | 같은 패키지 안에서의 접근: 동일 클래스, 하위 클래스, 비하위 클래스 |
| [OtherPackageAccessTest.java](examples/OtherPackageAccessTest.java) | 10-1 | 다른 패키지(`otherpkg.A`)의 하위 · 비하위 클래스에서의 접근 (`protected`) |
| [SportsCarTest.java](examples/SportsCarTest.java) | 10-1 | `Car`를 상속한 `SportsCar` (강의 그림을 코드로) |
| [MethodOverridingTest.java](examples/MethodOverridingTest.java) | 10-1 | 재정의 vs 상속 관계의 중복 정의, `super.f1()`. ⚠ `super` 없이 부르면 `StackOverflowError` |
| [FinalMethodTest.java](examples/FinalMethodTest.java) | 10-1 | `final` 메소드는 재정의 불가, `final` 클래스는 상속 불가 |
| [ConstructorOrderTest.java](examples/ConstructorOrderTest.java) | 10-1 | 부모 → 자식 생성자 순서, 소멸자(`finalize`). ⚠ `super.finalize()`를 안 부르면 부모 소멸자는 안 불림 |
| [ConstructorChainTest.java](examples/ConstructorChainTest.java) | 10-1 | `this(0, 0, 0, 0)` → `super(x, y)` 호출 순서. ⚠ `Shape()`는 불리지 않음 |
| [AbstractShapeTest.java](examples/AbstractShapeTest.java) | 10-2 | `abstract String getName()`을 추가하면 생기는 오류와 해결 |
| [InterfaceTest.java](examples/InterfaceTest.java) | 10-2 | `IShape` / `MyShape`, `static final` 필드, `static` 메소드, 💡 `default` 메소드 |
| [InterfaceMultipleInheritance.java](examples/InterfaceMultipleInheritance.java) | 10-2 | `class C extends A implements IB` + `B` 객체에게 맡기기(위임) |
| [MultipleInheritanceTest.java](examples/MultipleInheritanceTest.java) | 10-2 | [실습] 다중 상속 구현하기: `PassengerCar`, `Truck`, `Pickup` |
| [BindingTest.java](examples/BindingTest.java) | 10-3 | 필드는 정적 바인딩, 메소드는 동적 바인딩 (📝 정적 타입 언어 vs 동적 바인딩) |
| [StaticBindingTest.java](examples/StaticBindingTest.java) | 10-3 | static 필드 · 메소드는 모두 정적 바인딩 (⚠ 재정의가 아니라 숨김) |
| [AnonymousTest.java](examples/AnonymousTest.java) | 10-3 | 익명 클래스 vs 이름 있는 클래스, 💡 람다식 |
| [AnonymousArgumentTest.java](examples/AnonymousArgumentTest.java) | 10-3 | 익명 클래스 객체를 생성과 동시에 인수로 사용 |
| [TypeCastingTest.java](examples/TypeCastingTest.java) | 10-3 | [실습] 업캐스팅 · 다운캐스팅. ⚠ `(Square) new Poly()`는 실행 오류 |
| [InterfaceCastingTest.java](examples/InterfaceCastingTest.java) | 10-3 | 인터페이스 타입 변수는 인터페이스에 선언된 것만 접근 |
| [IsTest.java](examples/IsTest.java) | 10-3 | [실습] `instanceof`로 검사한 뒤 형변환 |
| [WrapperTest.java](examples/WrapperTest.java) | 10-3 | Wrapper 클래스, `MAX_VALUE` · `MIN_VALUE` · `SIZE`, boxing · autoboxing (⚠ `new Integer()` deprecated) |
| [BoxingUnBoxingTest.java](examples/BoxingUnBoxingTest.java) | 10-3 | [실습] boxing과 unboxing |

### 실습 (`practice/`)

| 파일 | 문제 |
|---|---|
| [inheritance1/AnimalSoundTest.java](practice/inheritance1/AnimalSoundTest.java) | 1. 💡 Animal / Cat: `makeSound()` 재정의 (참고 답안) |
| [inheritance1/ShapeAreaTest.java](practice/inheritance1/ShapeAreaTest.java) | 2. Shape / Rectangle: `getArea()` 재정의 (📝 Main을 단서로 단계별 설계) |
| [inheritance1/SavingsAccountTest.java](practice/inheritance1/SavingsAccountTest.java) | 3. BankAccount / SavingsAccount: 최소 잔액 100 (📝 `super`의 두 가지 역할) |
| [inheritance1/EmployeeNameTest.java](practice/inheritance1/EmployeeNameTest.java) | 4. Person / Employee: `getLastName()`에 직함 붙이기 |
| [inheritance1/VehicleTest.java](practice/inheritance1/VehicleTest.java) | 5. 💡 Vehicle / Truck / Car / Motorcycle: 연비 · 최대 속도 (참고 답안) |
| [inheritance2/AnimalAbstractTest.java](practice/inheritance2/AnimalAbstractTest.java) | 1. 추상 Animal / Lion / Tiger (📝 추상화 · 상속 · 오버라이딩 · 다형성) |
| [inheritance2/EmployeeSalaryTest.java](practice/inheritance2/EmployeeSalaryTest.java) | 2. 추상 Employee / Manager / Programmer: 급여 계산 (📝 추상 클래스의 필드와 생성자) |
| [inheritance2/VehicleEngineTest.java](practice/inheritance2/VehicleEngineTest.java) | 3. 추상 Vehicle / Car / Motorcycle: 추상 메소드 2개 (📝 추상 메소드에 `private`를 못 쓰는 이유) |
| [inheritance2/BirdTest.java](practice/inheritance2/BirdTest.java) | 4. 추상 Bird / Eagle / Hawk (📝 접근 제어자 정리) |

### 퀴즈 (`quiz/`)

| 파일 | 내용 |
|---|---|
| [InheritanceQuiz.java](quiz/InheritanceQuiz.java) | 1번 `super.메서드()`, 오버로딩 vs 오버라이딩, 시그니처, 재정의의 용도, package private. 2번 O/X 9문항(📝 생성자 순서, 소멸자 중복 정답, 추상 클래스, 인터페이스 필드 · 정적 메소드). 3번 Human / Student(📝 `super()` · `super.print()`). 📝 getter / setter 해부, 객체 배열과 반복문, 자바는 동적 바인딩인가, 업캐스팅 |

### 과제 (`assignment/`)

| 파일 | 문제 |
|---|---|
| [inheritance1/VehicleRepairTest.java](assignment/inheritance1/VehicleRepairTest.java) | 1. Vehicle / Car: `drive()` 재정의 |
| [inheritance1/HRManagerTest.java](assignment/inheritance1/HRManagerTest.java) | 2. Employee / HRManager: `work()` 재정의 + `addEmployee()` 추가 (💡 `Employee2`로 이름 변경) |
| [inheritance1/CheetahTest.java](assignment/inheritance1/CheetahTest.java) | 3. Animal / Cheetah: `move()` 재정의 |
| [inheritance1/CircleShapeTest.java](assignment/inheritance1/CircleShapeTest.java) | 4. Shape / Circle: 둘레와 넓이 (`Math.PI`) |
| [inheritance1/EmployeeHierarchyTest.java](assignment/inheritance1/EmployeeHierarchyTest.java) | 5. Employee / Manager / Developer / Programmer: 보너스, 성과 보고서 |
| [inheritance2/PersonAbstractTest.java](assignment/inheritance2/PersonAbstractTest.java) | 1. 추상 Person / Athlete / LazyPerson |
| [inheritance2/GeometricShapeTest.java](assignment/inheritance2/GeometricShapeTest.java) | 2. 추상 GeometricShape / Triangle / Square (📝 헤론의 공식) |

## ▶ 실행 방법

`examples/otherpkg/A.java`를 빼면 모든 파일에 `package` 선언이 없습니다. 그래서 JDK 11 이상에서는 컴파일 없이 바로 실행할 수 있습니다.

```bash
java examples/BindingTest.java
java practice/inheritance2/BirdTest.java
java quiz/InheritanceQuiz.java
java assignment/inheritance1/EmployeeHierarchyTest.java
```

`OtherPackageAccessTest.java`는 다른 파일(`otherpkg/A.java`)을 함께 써야 합니다. JDK 22 이상에서는 위처럼 실행하면 자동으로 찾아서 컴파일합니다. 그보다 낮은 버전에서는 함께 컴파일한 뒤 실행합니다.

```bash
javac -d out examples/OtherPackageAccessTest.java examples/otherpkg/A.java
java -cp out OtherPackageAccessTest
```

Windows 콘솔에서 한글이 깨지면 다음과 같이 인코딩을 지정합니다.

```bash
java -Dstdout.encoding=UTF-8 -Dstdin.encoding=UTF-8 -Dfile.encoding=UTF-8 quiz/InheritanceQuiz.java
```

> ⚠ **파일마다 독립된 프로그램입니다.**
> - **강의 예제:** 강의 코드에는 `A`, `B`, `Shape`, `Rectangle` 같은 같은 이름의 클래스가 여러 번 나옵니다. 그래서 `AccessControlTest.java`를 빼고는 보조 클래스를 `public class` 안에 **static 중첩 클래스**로 넣었습니다. 강의 코드처럼 파일 맨 아래에 따로 써도 동작은 같습니다.
>   `AccessControlTest.java`는 `private` 접근 규칙을 그대로 보여 주려고 `A`, `B`, `C`를 최상위 클래스로 두었습니다. (중첩 클래스끼리는 서로의 `private` 멤버를 볼 수 있기 때문)
> - **실습 · 과제:** 원래 이클립스에서 `Main.java`로 작성했던 코드입니다. 문제 내용에 맞게 `public class` 이름을 바꿨고, 보조 클래스는 문제의 이름 그대로 최상위 클래스로 두었습니다.
>   `inheritance1`과 `inheritance2`에는 같은 이름의 클래스(`Animal`, `Employee`, `Vehicle` 등)가 있어서 IntelliJ 모듈을 폴더별로 나눴습니다. 과제 `inheritance1`의 2번과 5번에는 둘 다 `Employee`가 있어서 2번 쪽을 `Employee2`로 바꿨습니다.
> - 주차 폴더 전체를 `javac`로 한 번에 컴파일하면 `duplicate class` 오류가 날 수 있으니, 위처럼 `java 파일이름.java`로 **한 파일씩** 실행하세요.

> 💡 **실행할 때마다 결과가 다를 수 있는 파일**
> `ConstructorOrderTest`의 소멸자(`finalize`) 출력은 가비지 컬렉터가 결정하므로 순서가 바뀌거나 출력되지 않을 수도 있습니다.

> ⚠ **JDK 버전에 따른 차이**
> - `finalize()`: JDK 18부터 삭제 예정(for removal)이라 컴파일 경고가 나옵니다. `ConstructorOrderTest.java`는 `@SuppressWarnings("removal")`로 경고를 숨겼습니다.
> - `new Integer(...)`: JDK 9부터 deprecated입니다. 예제는 `Integer.valueOf(...)`로 바꿨습니다.
> - 인터페이스의 `default` · `static` 메소드는 Java 8부터 가능합니다. 수업의 "인터페이스에는 일반 메소드가 없다"는 그 이전 기준의 설명입니다.

이클립스에서는 `src`의 default package에 파일을 넣고 실행하면 됩니다. 단, 서로 다른 폴더(예: 실습 `inheritance1`과 `inheritance2`)의 파일은 보조 클래스 이름이 겹칠 수 있으니 같은 프로젝트(패키지)에 함께 넣지 말고 하나씩 넣어서 실행합니다.
