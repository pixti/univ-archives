# 10주차 강의 예제 코드

[🏠 10주차 학습 가이드](../../README.md)

강의 노트([`1-lecture/`](../))에 나온 코드를 실행할 수 있는 파일로 정리했습니다. 노트를 먼저 읽고, 여기서 코드를 실행하며 결과를 확인하세요.

| 파일 | 내용 |
|---|---|
| [AccessControlTest.java](#상속-및-접근-제어---같은-패키지-안에서의-접근) | 같은 패키지 안에서의 접근: 동일 클래스, 하위 클래스, 비하위 클래스 |
| [OtherPackageAccessTest.java](#상속-및-접근-제어---다른-패키지에서의-접근) | 다른 패키지(`otherpkg.A`)의 하위 · 비하위 클래스에서의 접근 (`protected`) |
| [SportsCarTest.java](#상속의-구조---부모-클래스-car-를-상속한-sportscar) | `Car`를 상속한 `SportsCar` (강의 그림을 코드로) |
| [MethodOverridingTest.java](#메소드-재정의-method-overriding) | 재정의 vs 상속 관계의 중복 정의, `super.f1()`. ⚠ `super` 없이 부르면 `StackOverflowError` |
| [FinalMethodTest.java](#final-메소드와-final-클래스) | `final` 메소드는 재정의 불가, `final` 클래스는 상속 불가 |
| [ConstructorOrderTest.java](#상위-클래스-생성자-호출-순서) | 부모 → 자식 생성자 순서, 소멸자(`finalize`). ⚠ `super.finalize()`를 안 부르면 부모 소멸자는 안 불림 |
| [ConstructorChainTest.java](#상위-클래스-생성자-및-동일-클래스의-다른-생성자-호출) | `this(0, 0, 0, 0)` → `super(x, y)` 호출 순서. ⚠ `Shape()`는 불리지 않음 |
| [AbstractShapeTest.java](#추상-클래스와-추상-메소드) | `abstract String getName()`을 추가하면 생기는 오류와 해결 |
| [InterfaceTest.java](#인터페이스) | `IShape` / `MyShape`, `static final` 필드, `static` 메소드, 💡 `default` 메소드 |
| [InterfaceMultipleInheritance.java](#인터페이스를-이용한-다중-상속) | `class C extends A implements IB` + `B` 객체에게 맡기기(위임) |
| [MultipleInheritanceTest.java](#실습-자바를-이용하여-다중-상속-구현하기) | [실습] 다중 상속 구현하기: `PassengerCar`, `Truck`, `Pickup` |
| [BindingTest.java](#상속과-바인딩) | 필드는 정적 바인딩, 메소드는 동적 바인딩 (📝 정적 타입 언어 vs 동적 바인딩) |
| [StaticBindingTest.java](#상속과-바인딩---static) | static 필드 · 메소드는 모두 정적 바인딩 (⚠ 재정의가 아니라 숨김) |
| [AnonymousTest.java](#익명-내부-클래스) | 익명 클래스 vs 이름 있는 클래스, 💡 람다식 |
| [AnonymousArgumentTest.java](#익명-내부-클래스---생성과-동시에-인수로-사용) | 익명 클래스 객체를 생성과 동시에 인수로 사용 |
| [TypeCastingTest.java](#클래스-형변환-type-casting) | [실습] 업캐스팅 · 다운캐스팅. ⚠ `(Square) new Poly()`는 실행 오류 |
| [InterfaceCastingTest.java](#인터페이스의-형변환) | 인터페이스 타입 변수는 인터페이스에 선언된 것만 접근 |
| [IsTest.java](#실습-instanceof-연산자-사용하기) | [실습] `instanceof`로 검사한 뒤 형변환 |
| [WrapperTest.java](#wrapper포장-클래스) | Wrapper 클래스, `MAX_VALUE` · `MIN_VALUE` · `SIZE`, boxing · autoboxing (⚠ `new Integer()` deprecated) |
| [BoxingUnBoxingTest.java](#실습-boxing-과-unboxing) | [실습] boxing과 unboxing |
| [otherpkg/A.java](#다른-패키지에-있는-부모-클래스-otherpackageaccesstestjava-에서-사용) | 다른 패키지에 있는 부모 클래스 (OtherPackageAccessTest.java 에서 사용) |

---

## 상속 및 접근 제어 - 같은 패키지 안에서의 접근

`10-1 상속1` · 📄 [`AccessControlTest.java`](AccessControlTest.java)

#### 💻 코드

<!-- code: AccessControlTest.java -->
```java
public class AccessControlTest {
    public static void main(String[] args) {
        System.out.println("---- (1) A 안에서 ----");
        new A().test();
        System.out.println("---- (2) 하위 클래스 B 안에서 ----");
        new B().test();
        System.out.println("---- (3) 비하위 클래스 C 안에서 ----");
        new C().test();
    }
}

class A {
    private int a = 1;
    int b = 5;          // default (접근자를 안 씀) : 같은 패키지에서만
    protected int c = 10;
    public int d = 15;

    void test() {       // (1) 동일 클래스 : 모두 접근 가능
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    public int getA() { return a; }   // 💡 private 필드를 밖에서 읽기 위한 getter (강의 코드에는 없음)
}

class B extends A {     // (2) 동일 패키지 내 하위 클래스
    void test() {
        // System.out.println(a);   // ❌ 접근 오류 : error: a has private access in A
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println("a 는 getA() 로 : " + getA());   // 💡 물려받은 public 메소드로는 읽을 수 있다
    }
}

class C {               // (3) 동일 패키지 내 비하위 클래스 (강의 코드에서는 이름이 B)
    void test() {
        A ob = new A();
        // System.out.println(ob.a);   // ❌ 접근 오류 : error: a has private access in A
        System.out.println(ob.b);
        System.out.println(ob.c);
        System.out.println(ob.d);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
---- (1) A 안에서 ----
1
5
10
15
---- (2) 하위 클래스 B 안에서 ----
5
10
15
a 는 getA() 로 : 1
---- (3) 비하위 클래스 C 안에서 ----
5
10
15
```

**포인트**

- 상속 : 부모 클래스에 정의된 필드와 메소드를 물려받는 것. extends 키워드로 부모 클래스를 지정한다.
  ```java
  class Subclass extends Superclass { … }
  ```
- 접근자에 따라 하위 클래스에서 쓸 수 있는 부모 클래스의 기능이 제한된다.

```java
                        private   default   protected   public
동일 클래스                O         O          O          O
동일 패키지 하위 클래스      X         O          O          O
동일 패키지 비하위 클래스    X         O          O          O
다른 패키지 하위 클래스      X         X          O          O
다른 패키지 비하위 클래스    X         X          X          O
```

- (1) 동일 클래스 : 접근자의 종류와 상관없이 모든 필드와 메소드에 접근할 수 있다.        → A.test()
- (2) 동일 패키지 하위 클래스 : private 를 뺀 나머지에 접근할 수 있다.                   → B.test()
- (3) 동일 패키지 비하위 클래스 : 하위 클래스와 똑같이 private 를 뺀 나머지에 접근할 수 있다. → C.test()
- (4) (5) 다른 패키지 → OtherPackageAccessTest.java

- ⚠ 자주 틀리는 부분 : private 필드도 "물려받기는" 한다. B 객체 안에는 a 가 들어 있다.<br>다만 B 의 코드에서 a 라는 이름으로 직접 쓸 수 없을 뿐이다. 부모의 public 메소드(getter 등)를 거치면 쓸 수 있다.<br>(퀴즈 2번 (2) 📝 필기 : 상속을 받으면 부모 클래스 private 데이터도 물려받는데 임의로 건드릴 수 없음)
- 💡 같은 패키지 안에서는 default 와 protected 의 차이가 없다. 차이는 "다른 패키지의 하위 클래스"에서 생긴다.
- 💡 강의 코드에서는 (2) 의 하위 클래스와 (3) 의 비하위 클래스가 둘 다 이름이 B 다. 한 파일에 넣으려고 (3) 을 C 로 바꿨다.
- 💡 이 파일의 A, B, C 는 private 접근 규칙을 그대로 보여 주려고 최상위 클래스로 두었다.<br>(한 클래스 안에 중첩 클래스로 넣으면 바깥 클래스와 private 멤버를 서로 볼 수 있어서 결과가 달라진다)

## 상속 및 접근 제어 - 다른 패키지에서의 접근

`10-1 상속1` · 📄 [`OtherPackageAccessTest.java`](OtherPackageAccessTest.java)

#### 💻 코드

<!-- code: OtherPackageAccessTest.java -->
```java
import otherpkg.A;

public class OtherPackageAccessTest {

    static class B extends A {     // (4) 다른 패키지 내의 하위 클래스
        void test() {
            // System.out.println(a);   // ❌ 접근 오류 : a has private access in A
            // System.out.println(b);   // ❌ 접근 오류 : b is not public in A; cannot be accessed from outside package
            System.out.println(c);
            System.out.println(d);
        }
    }

    static class C {               // (5) 다른 패키지 내의 비하위 클래스
        void test() {
            A ob = new A();
            // System.out.println(ob.a);   // ❌ 접근 오류
            // System.out.println(ob.b);   // ❌ 접근 오류
            // System.out.println(ob.c);   // ❌ 접근 오류 : c has protected access in A
            System.out.println(ob.d);
        }
    }

    public static void main(String[] args) {
        System.out.println("---- (4) 다른 패키지의 하위 클래스 ----");
        new B().test();
        System.out.println("---- (5) 다른 패키지의 비하위 클래스 ----");
        new C().test();
    }
}
```
<!-- /code -->

#### 실행 결과

```text
---- (4) 다른 패키지의 하위 클래스 ----
10
15
---- (5) 다른 패키지의 비하위 클래스 ----
15
```

**포인트**

- (4) 다른 패키지 내의 하위 클래스 : protected 와 public 만 접근 가능  → B.test()
- (5) 다른 패키지 내의 비하위 클래스 : public 만 접근 가능             → C.test()
- 부모 클래스 A 는 otherpkg 패키지에 있다. (1-lecture/code/otherpkg/A.java)
  ```java
  package otherpkg;
  public class A { private int a = 1; int b = 5; protected int c = 10; public int d = 15; }
  ```

- 💡 protected = default(같은 패키지) + 다른 패키지의 하위 클래스.<br>부모가 자식에게만 물려주고 바깥에는 숨기고 싶은 멤버에 쓴다.
- ⚠ 자주 틀리는 부분 : 다른 패키지의 하위 클래스라도 "부모 타입 객체를 새로 만들어서" protected 멤버에 접근할 수는 없다.
  ```text
  A ob = new A();  ob.c   → ❌ error: c has protected access in A
  ``` 자기 자신(this)이 물려받은 c 로만 접근할 수 있다.
- 💡 이 파일의 B, C 는 같은 폴더의 다른 예제(AccessControlTest.java)의 B, C 와 이름이 겹치지 않도록 OtherPackageAccessTest 안에 static 중첩 클래스로 넣었다. 부모 A 가 다른 패키지에 있으므로 접근 규칙은 그대로다.<br>(강의 코드에서는 (4), (5) 의 클래스 이름이 둘 다 B)
- 💡 JDK 22 이상에서는 java 1-lecture/code/OtherPackageAccessTest.java 로 실행하면 otherpkg/A.java 도 자동으로 찾아 컴파일한다.

## 상속의 구조 - 부모 클래스 Car 를 상속한 SportsCar

`10-1 상속1` · 📄 [`SportsCarTest.java`](SportsCarTest.java)

#### 💻 코드

<!-- code: SportsCarTest.java -->
```java
public class SportsCarTest {

    static class Car {
        public int speed;
        public int gear;
        public String color;

        public void setGear(int newGear) {
            gear = newGear;
        }

        public void speedUp(int increment) {
            speed += increment;
        }

        public void speedDown(int decrement) {
            speed -= decrement;
        }
    }

    static class SportsCar extends Car {     // Car 를 상속
        private boolean turbo;                // 추가한 필드

        public void setTurbo(boolean newValue) {   // 추가한 메소드
            turbo = newValue;
        }

        public void print() {
            System.out.println("기어 : " + gear + ", 속도 : " + speed + ", 색 : " + color + ", 터보 : " + turbo);
        }
    }

    public static void main(String[] args) {
        SportsCar c = new SportsCar();
        c.color = "red";        // 부모에게서 물려받은 필드
        c.setGear(2);           // 부모에게서 물려받은 메소드
        c.speedUp(30);
        c.speedDown(10);
        c.print();

        c.setTurbo(true);       // 자식에서 추가한 메소드
        c.speedUp(50);
        c.print();
    }
}
```
<!-- /code -->

#### 실행 결과

```text
기어 : 2, 속도 : 20, 색 : red, 터보 : false
기어 : 2, 속도 : 70, 색 : red, 터보 : true
```

**포인트 (강의 그림을 코드로 옮긴 것)**

SportsCar

```text
┌──────────────────┐
│ +speed           │
│ +gear            │
│ +color           │  ← 부모 클래스 Car 에서 상속받은 부분
│ +setGear()       │
│ +speedUp()       │
│ +speedDown()     │
├──────────────────┤
│ -turbo : bool    │  ← 추가한 부분
│ +setTurbo()      │
└──────────────────┘
```

(+ 는 public, - 는 private 를 뜻하는 UML 표기)

- 자식 클래스 SportsCar 에는 turbo, setTurbo() 만 새로 쓰면 된다.<br>나머지는 부모 Car 에서 물려받으므로 다시 쓸 필요가 없다. → 소프트웨어 재사용성 증가
- 부모 : 기능을 물려주는 클래스 (부모, 상위, 슈퍼 클래스)<br>자식 : 기능을 받는 클래스 (자식, 하위, 파생 클래스)

- 💡 자바에는 bool 이 없다. 그림의 bool 은 boolean 으로 썼다.
- 💡 그림에는 필드의 자료형과 메소드의 내용이 없어서 간단히 채웠다. (speed 는 int, color 는 String 등)
- 💡 자식 객체는 부모의 필드와 자기 필드를 "모두" 가진다. 하지만 부모 객체(new Car())에는 turbo 가 없다.
- 💡 같은 폴더의 다른 예제와 클래스 이름이 겹치지 않도록 SportsCarTest 안에 static 중첩 클래스로 넣었다.

## 메소드 재정의 (method overriding)

`10-1 상속1` · 📄 [`MethodOverridingTest.java`](MethodOverridingTest.java)

#### 💻 코드

<!-- code: MethodOverridingTest.java -->
```java
public class MethodOverridingTest {

    static class A {
        void f1() {
            System.out.println("A.f1()");
        }

        void f1(int x) {
            System.out.println("A.f1(int) : x = " + x);
        }
    }

    static class B extends A {
        // A 의 f1() 도 사용 가능 (재정의하지 않았으므로 물려받은 그대로)

        @Override
        void f1(int x) {                      // A 의 인수 한 개 f1 을 재정의
            System.out.println("B.f1(int) : x = " + x);
            super.f1(5);                      // ✅ 올바른 기존 메소드 호출
        }

        void f1(int x, int y) {               // B 에 새로 추가된 인수 두 개 f1 (중복 정의)
            System.out.println("B.f1(int, int) : x = " + x + ", y = " + y);
        }
    }

    static class BadB extends A {
        @Override
        void f1(int x) {
            f1(5);                            // ❌ super 를 빼먹으면 BadB 의 f1 을 다시 호출 → 무한 재귀
        }
    }

    public static void main(String[] args) {
        System.out.println("---- B 객체 ----");
        B b = new B();
        b.f1();          // 물려받은 A 의 f1()
        b.f1(1);         // 재정의한 B 의 f1(int)
        b.f1(2, 3);      // B 에서 추가한 f1(int, int)

        System.out.println("---- A 타입 변수에 B 객체 ----");
        A a = new B();
        a.f1(7);         // 💡 변수 타입이 A 여도 실제 객체가 B 이므로 B 의 f1(int) 가 실행된다 (동적 바인딩, 10-3)

        System.out.println("---- super 없이 f1(5) 를 부르면 ----");
        try {
            new BadB().f1(1);
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError : 자기 자신을 끝없이 호출했다");
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
---- B 객체 ----
A.f1()
B.f1(int) : x = 1
A.f1(int) : x = 5
B.f1(int, int) : x = 2, y = 3
---- A 타입 변수에 B 객체 ----
B.f1(int) : x = 7
A.f1(int) : x = 5
---- super 없이 f1(5) 를 부르면 ----
StackOverflowError : 자기 자신을 끝없이 호출했다
```

**포인트**

- 메소드 재정의 : 상위 클래스의 메소드를 "똑같은 형태"로 다시 정의하는 것<br>(이름이 같고, 인수의 개수와 타입도 같다)
  ```java
  class A {                  class B extends A {
      void f1() {...}            // A 의 f1() 도 사용 가능
      void f1(int x) {...}       void f1(int x) {...}         // A 의 인수 한 개 f1 을 재정의
  }                              void f1(int x, int y) {...}  // B 에 새로 추가된 인수 두 개 f1
                             }
  ```
- 재정의되는 메소드 안에서 기존 메소드를 그냥 부르면 "자기 자신"을 다시 부르게 되어 재귀에 빠질 위험이 있다.
  ```java
  void f1(int x) { f1(5); ... }         // ❌ 재귀 호출로 인한 무한 반복
  void f1(int x) { super.f1(5); ... }   // ✅ 올바른 기존 메소드 호출
  ```

- 📝 필기 (퀴즈 1번 (1)) : 자식 클래스에서 재정의된 부모 클래스의 메소드를 호출하려면 super.메소드이름() 으로 호출한다.<br>자식이 재정의하면 부모의 메소드는 가려진다. 그래서 그냥 메소드이름() 으로 부르면 자식의 메소드가 실행된다.
- 📝 필기 (퀴즈 1번 (2)) : 중복 정의(overloading) vs 재정의(overriding)
  ```text
                중복 정의 (Overloading)               재정의 (Overriding)
  관계          주로 같은 클래스 안 (상속 관계도 가능)  반드시 부모 - 자식 상속 관계
  메소드 이름   같음                                   같음
  매개변수      반드시 달라야 함 (개수, 타입)           반드시 같아야 함
  반환형        상관없음                               같아야 함 (또는 하위 타입)
  접근 지정자   상관없음                               부모보다 좁은 범위로 변경 불가
  목적          같은 기능에 여러 입력을 처리 (편의성)   부모의 기능을 자식에 맞게 변경 (다형성)
  ```
- 📝 필기 (퀴즈 1번 (3)) : 자식 클래스에 부모 클래스의 멤버 함수와 시그니처(이름 + 매개변수 목록)가 같은 함수가 있으면 → 재정의.<br>시그니처(매개변수)가 다르면 중복 정의다. 그래서 위 B 의 f1(int, int) 는 "상속 관계에서의 중복 정의"다.
- 📝 필기 (퀴즈 1번 (4)) : 재정의는 부모로부터 물려받은 기본 기능을 자식 클래스의 특성에 맞게 바꾸거나 확장할 때 쓴다.<br>→ 특수화(예 : Animal 의 소리내기() 를 Dog 는 "멍멍", Cat 은 "야옹"으로), 다형성과 동적 바인딩(10-3)

- 💡 @Override 를 붙이면 컴파일러가 "정말 부모에 같은 메소드가 있는지" 검사해 준다.<br>f1(int x) 를 f1(long x) 처럼 잘못 쓰면 재정의가 아니라 새 메소드(중복 정의)가 되는데, @Override 가 있으면 오류로 알려 준다.
  ```text
  error: method does not override or implement a method from a supertype
  ```
- 💡 아래 BadB 의 무한 재귀는 실제로 실행하면 StackOverflowError 로 끝난다. 확인용으로 try-catch 로 잡았다. (예외 처리는 11강)
- 💡 같은 폴더의 다른 예제와 클래스 이름(A, B)이 겹치지 않도록 MethodOverridingTest 안에 static 중첩 클래스로 넣었다.<br>강의 코드처럼 파일 맨 아래에 따로 써도 동작은 같다.

## final 메소드와 final 클래스

`10-1 상속1` · 📄 [`FinalMethodTest.java`](FinalMethodTest.java)

#### 💻 코드

<!-- code: FinalMethodTest.java -->
```java
public class FinalMethodTest {

    static class Parent {
        final void show() {
            System.out.println("Parent.show() : final 이라 재정의할 수 없음");
        }

        void hello() {
            System.out.println("Parent.hello()");
        }
    }

    static class Child extends Parent {
        // void show() { }      // ❌ 컴파일 오류 : overridden method is final

        @Override
        void hello() {          // final 이 아닌 메소드는 재정의할 수 있다
            System.out.println("Child.hello() : 재정의함");
        }
    }

    static final class Last {
        void info() {
            System.out.println("Last 는 final 클래스라 상속할 수 없음");
        }
    }

    // static class Next extends Last { }   // ❌ 컴파일 오류 : cannot inherit from final Last

    public static void main(String[] args) {
        Child c = new Child();
        c.show();       // 물려받은 final 메소드 호출은 가능
        c.hello();
        new Last().info();
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Parent.show() : final 이라 재정의할 수 없음
Child.hello() : 재정의함
Last 는 final 클래스라 상속할 수 없음
```

**포인트**

- final 키워드가 붙은 메소드는 하위 클래스에서 재정의할 수 없다.
- 클래스 앞에 final 키워드가 붙으면 상속할 수 없다.

```java
class Parent { final void show() {...} }
class Child extends Parent {
    void show() {...}          // ❌ error: show() in Child cannot override show() in Parent
}                              //          overridden method is final

final class Last {...}
class Next extends Last {...}  // ❌ error: cannot inherit from final Last
```

**💡 final 의 세 가지 쓰임**

```text
final 변수   : 값을 한 번만 정할 수 있다 (상수, 2강 · 9강)
```

final 메소드 : 재정의할 수 없다<br>final 클래스 : 상속할 수 없다. 예) String, Integer, Math 는 final 클래스라서 extends String 은 오류

- 💡 final 메소드도 "물려받아서 호출하는 것"은 된다. 바꿀 수만 없다.
- 💡 같은 폴더의 다른 예제와 클래스 이름이 겹치지 않도록 FinalMethodTest 안에 static 중첩 클래스로 넣었다.

## 상위 클래스 생성자 호출 순서

`10-1 상속1` · 📄 [`ConstructorOrderTest.java`](ConstructorOrderTest.java)

#### 💻 코드

<!-- code: ConstructorOrderTest.java -->
```java
@SuppressWarnings("removal")   // 💡 finalize() deprecated 경고를 숨김 (강의 코드에는 없음)
public class ConstructorOrderTest {

    static class Shape {
        private int x, y;

        public Shape() {
            System.out.println("Shape 생성자");
        }

        @Override
        public void finalize() {
            System.out.println("Shape 소멸자");
        }
    }

    static class Rectangle extends Shape {
        private int width, height;

        public Rectangle() {
            // 💡 여기에 super(); 가 자동으로 들어가 있다 → Shape() 가 먼저 실행된다
            System.out.println("Rectangle 생성자");
        }

        @Override
        public void finalize() {
            System.out.println("Rectangle 소멸자");     // ⚠ super.finalize() 가 없어서 Shape 소멸자는 안 불린다
        }
    }

    static class RectangleSuper extends Shape {      // 💡 비교용 (강의 코드에는 없음)
        public RectangleSuper() {
            System.out.println("RectangleSuper 생성자");
        }

        @Override
        public void finalize() {
            System.out.println("RectangleSuper 소멸자");
            super.finalize();                           // 부모 쪽 정리를 직접 호출 → 자식 → 부모 순서
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("---- 강의 코드 ----");
        Rectangle r;
        r = new Rectangle();

        System.out.println("---- super.finalize() 를 부르는 버전 ----");
        RectangleSuper r2 = new RectangleSuper();

        System.out.println("---- GC 요청 ----");
        r = null;               // 💡 더 이상 참조하지 않으면 가비지 컬렉션 대상
        r2 = null;
        System.gc();            // 💡 가비지 컬렉터 실행을 "요청" (보장은 아님)
        Thread.sleep(500);      // 💡 finalize 를 실행하는 스레드가 돌 시간을 줌
    }
}
```
<!-- /code -->

#### 실행 결과 (아래 두 줄씩의 소멸자 출력은 실행마다 다를 수 있음)

```text
---- 강의 코드 ----
Shape 생성자
Rectangle 생성자
---- super.finalize() 를 부르는 버전 ----
Shape 생성자
RectangleSuper 생성자
---- GC 요청 ----
Rectangle 소멸자
RectangleSuper 소멸자
Shape 소멸자
```

**포인트**

- 자식 클래스는 부모 클래스로부터 상속받은 멤버들이 있다. 그것을 초기화하기 위해 부모 클래스의 생성자도 자동으로 호출된다.
- 자식 클래스의 객체가 생성될 때 당연히 자식 클래스의 생성자가 호출된다. 이때 부모 클래스 생성자도 호출될까? → 호출된다.

```text
객체의 생성   [부모 클래스 생성자] → [자식 클래스 생성자]
                                          │
객체의 사용                                …
                                          │
객체의 소멸   [부모 클래스 소멸자] ← [자식 클래스 소멸자]
```

\* 위의 순서는 일반적인 얘기다. 소멸자의 실행 순서는 보장할 수 없다. 가비지 컬렉터에 따른다.

- C++ 에서 소멸자는 (생성자의) 역순으로 호출되지만, Java 의 경우 가비지 컬렉터에 따라 달라질 수 있다.

- 📝 필기 (퀴즈 2번 (1)) : 자식 클래스의 생성자가 부모 클래스의 생성자를 명시적으로 호출하지 않아도 컴파일러가 자동으로 부모의 기본 생성자 super() 를 (자식 생성자의 첫 줄에) 넣어 호출한다.<br>→ "호출되지 않는다" 는 X
- 📝 필기 (퀴즈 2번 (3)) : 부모가 (먼저) 호출이 되고 자식이 호출이 됨. → "자식 생성자가 먼저" 는 X 자식이 부모의 멤버를 쓰려면 부모 쪽 멤버가 먼저 초기화되어 있어야 하기 때문이다.
- 📝 필기 (퀴즈 2번 (4)) : 소멸자는 자식 → 부모 순서(생성자의 역순)라는 문제는 O.<br>자바에서는 소멸자가 없는 형태로 가고 있어서 (수업에서는) 중복 정답 처리하겠다고 했다. C++ 등에서는 이러하니 알아둘 것.

- ⚠ 자주 틀리는 부분 : 강의 코드의 main 은 static void main(string args\[]) 이다.<br>자바의 문자열 클래스는 대문자 String 이고, main 에는 public 이 있어야 시작점이 된다. (C# 은 소문자 string 을 쓴다)
    - ✅ public static void main(String\[] args)   (String args\[] 처럼 써도 된다)
- ⚠ 자주 틀리는 부분 : 자바의 finalize() 는 C++ 소멸자와 달리 부모 것이 자동으로 호출되지 않는다.<br>Rectangle 처럼 finalize() 를 재정의하고 super.finalize() 를 부르지 않으면 "Shape 소멸자" 는 출력되지 않는다.<br>부모 쪽 정리도 하려면 RectangleSuper 처럼 마지막에 super.finalize() 를 직접 호출해야 한다.
- ⚠ finalize() 는 JDK 9 부터 deprecated, JDK 18 부터 삭제 예정(for removal)이다. 컴파일하면 경고가 나온다.<br>호출 시점도, 호출 여부도 보장되지 않는다. (9-3 소멸자, week09 FinalizeTest.java)<br>그래서 System.gc() 로 가비지 컬렉션을 "요청"하고 잠깐 기다렸다. 보통은 출력되지만 순서와 출력 여부는 실행마다 다를 수 있다.
- 💡 강의 코드의 public class 이름은 Program. 같은 폴더의 다른 예제와 겹치지 않도록 Shape, Rectangle 을 ConstructorOrderTest 안에 static 중첩 클래스로 넣었다.

## 상위 클래스 생성자 및 동일 클래스의 다른 생성자 호출

`10-1 상속1` · 📄 [`ConstructorChainTest.java`](ConstructorChainTest.java)

#### 💻 코드

<!-- code: ConstructorChainTest.java -->
```java
public class ConstructorChainTest {

    static class Shape {
        private int x, y;

        public Shape() {
            this(0, 0);                         // 같은 클래스의 다른 생성자 호출
            System.out.println("Shape 생성자");
        }

        public Shape(int xloc, int yloc) {
            x = xloc;
            y = yloc;
            System.out.println("Shape 유인 생성자");   // 유인 생성자 : 인수가 있는 생성자
        }
    }

    static class Rectangle extends Shape {
        private int width, height;

        public Rectangle() {
            this(0, 0, 0, 0);                   // 같은 클래스의 다른 생성자 호출
            System.out.println("Rectangle 생성자");
        }

        public Rectangle(int x, int y, int w, int h) {
            super(x, y);                        // 부모 클래스의 특정 생성자 호출 (첫 문장)
            width = w;
            height = h;
            System.out.println("Rectangle 유인 생성자");
        }
    }

    public static void main(String[] args) {
        Rectangle r;
        r = new Rectangle();

        System.out.println("---- new Shape() ----");   // 💡 비교용 : Shape() 를 직접 부르면 this(0, 0) 이 먼저 실행된다
        new Shape();
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Shape 유인 생성자
Rectangle 유인 생성자
Rectangle 생성자
---- new Shape() ----
Shape 유인 생성자
Shape 생성자
```

**포인트**

- 자식 클래스에서 부모 클래스의 "특정" 생성자를 호출할 때는 super 키워드를 사용한다.  → super(x, y);
- 같은 클래스의 다른 생성자를 호출할 때는 this 키워드를 사용한다.                    → this(0, 0, 0, 0);
- 부모 생성자 호출은 코드 제일 앞에 위치시켜야 한다. (this(...) 도 마찬가지)

```text
new Rectangle() 의 실행 순서
  Rectangle()
    └ this(0, 0, 0, 0)                 → Rectangle(int, int, int, int)
        └ super(x, y)                  → Shape(int, int)            : "Shape 유인 생성자" 출력
        └ width = w; height = h;         "Rectangle 유인 생성자" 출력
    └ "Rectangle 생성자" 출력
```

- 📝 필기 (퀴즈 2번 (2)) : 공개된 메소드를 사용하든지, 부모 생성자에서 호출하는 방향으로 초기화해야 한다.<br>→ 자식은 부모의 private 필드(x, y)를 직접 대입할 수 없으므로 super(x, y) 로 부모 생성자에게 맡긴다.
- 📝 필기 (퀴즈 3번 (7)) : super() 로 부모 클래스 생성자를 호출해 초기화.

- ⚠ 자주 틀리는 부분 : 강의 코드의 Shape() 는 this(0, 0) 을 부르는데, 결과에는 "Shape 생성자" 가 나오지 않는다.<br>Rectangle(int, int, int, int) 가 super(x, y) 로 Shape(int, int) 를 "직접" 고르기 때문에 Shape() 는 한 번도 불리지 않는다.<br>(super(...) 를 안 썼다면 컴파일러가 super() 를 넣어서 Shape() → this(0, 0) 순서로 불렸을 것)
- ⚠ 자주 틀리는 부분 : 한 생성자 안에서 this(...) 와 super(...) 를 함께 쓸 수 없다. 둘 다 "첫 문장"이어야 하기 때문이다.<br>그래서 Rectangle() 은 this(...) 로 다른 생성자에게 넘기고, 그 생성자가 super(...) 를 부른다.
- ⚠ 자주 틀리는 부분 : 부모에 매개변수 없는 생성자가 없으면, 자식 생성자에서 super(...) 를 꼭 써야 한다.<br>(컴파일러가 넣는 super() 가 부를 생성자가 없어서 error: constructor Shape in class Shape cannot be applied to given types)
- 💡 JDK 25 (JEP 513) 부터는 super(...) / this(...) 앞에 this 를 쓰지 않는 문장(인수 검사 등)을 쓸 수 있다.<br>시험은 수업 기준 "생성자 호출은 첫 문장" 으로 답한다. (9-3)
- 💡 강의 코드의 main 은 static void main(string\[] args) 이다. 자바에서는 public static void main(String\[] args).
- 💡 같은 폴더의 다른 예제와 겹치지 않도록 Shape, Rectangle 을 ConstructorChainTest 안에 static 중첩 클래스로 넣었다.<br>(강의 코드의 public class 이름은 Program)

## 추상 클래스와 추상 메소드

`10-2 상속2` · 📄 [`AbstractShapeTest.java`](AbstractShapeTest.java)

#### 💻 코드

<!-- code: AbstractShapeTest.java -->
```java
public class AbstractShapeTest {

    static abstract class Shape {           // 추상 메소드가 있으므로 abstract class
        private int x, y;

        public Shape() {
            System.out.println("Shape 생성자");
        }

        abstract String getName();           // 추상 메소드 : 선언만 있고 구현이 없다
    }

    static class Rectangle extends Shape {
        private int width, height;

        public Rectangle() {
            System.out.println("Rectangle 생성자");
        }

        @Override
        String getName() {                   // 추상 메소드를 구현(재정의) → 일반 클래스
            return "사각형";
        }
    }

    static class Circle extends Shape {      // 💡 비교용 (강의 코드에는 없음)
        public Circle() {
            System.out.println("Circle 생성자");
        }

        @Override
        String getName() {
            return "원";
        }
    }

    public static void main(String[] args) {
        // Shape s0 = new Shape();     // ❌ error: Shape is abstract; cannot be instantiated

        Shape s1 = new Rectangle();    // 추상 클래스 타입의 변수에 자식 객체는 저장할 수 있다
        System.out.println("이름 : " + s1.getName());

        Shape s2 = new Circle();
        System.out.println("이름 : " + s2.getName());
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Shape 생성자
Rectangle 생성자
이름 : 사각형
Shape 생성자
Circle 생성자
이름 : 원
```

**포인트**

- 추상 메소드 : 메소드 선언만 있고 구현(몸체 { })이 없는 메소드. abstract 키워드를 쓴다.
  ```text
  abstract String getName();      ← 끝에 { } 대신 ; 를 쓴다
  ```
- 상속받는 클래스에서 내부를 구현하여 사용한다.
- 추상 메소드가 하나라도 있는 클래스는 클래스 앞에 abstract 키워드를 붙여야 한다. (추상 클래스)
- 추상 클래스로부터 객체를 생성할 수 없다.  new Shape()  → ❌
- 추상 메소드를 모두 구현해야 일반 클래스가 된다.

\[생각해 보기] 앞의 예제(ConstructorOrderTest.java)의 Shape 클래스 안에 abstract String getName(); 을 추가하면?

1. Shape 클래스 오류. 추가한 메소드가 추상 메소드이므로 당연히 Shape 도 추상 클래스다. → 클래스명 앞에 abstract 를 추가
  ```text
  error: Shape is not abstract and does not override abstract method getName() in Shape
  ```
2. Rectangle 클래스도 오류. 추상 클래스를 상속받았으므로 Rectangle 도 추상 클래스다.<br>→ 추상 메소드인 getName 메소드를 재정의하든지, 아니면 클래스명 앞에 abstract 키워드를 붙여야 한다.
  ```text
  error: Rectangle is not abstract and does not override abstract method getName() in Shape
  ```
3. 추상 메소드 구현 팁 (이클립스) : 클래스명 밑에 빨간 줄이 생기는데, 마우스를 갖다 대면 팝업창이 뜬다.<br>그중에 "Add unimplemented methods" 를 선택하면 구현해야 할 메소드의 골격이 자동으로 추가된다.<br>(IntelliJ 에서는 Alt + Enter → Implement methods)

- 📝 필기 (퀴즈 2번 (5)) : 추상 메소드는 abstract 가 붙고, 이게 하나라도 존재하면 그 클래스도 추상 클래스 abstract class 로 선언되어야 한다. → O (abstract 를 안 붙이면 컴파일 오류)
- 📝 필기 (퀴즈 2번 (6)) : 추상 클래스를 상속할 경우, 자식 클래스도 추상 클래스로 선언하든지 아니면 부모 클래스의 추상 메소드를 (모두) 재정의해 주면 된다. → O

- 💡 추상 클래스도 일반 필드, 일반 메소드, 생성자를 가질 수 있다. (아래 Shape 의 x, y 와 생성자)<br>생성자는 new Shape() 로 직접 부를 수는 없지만, 자식 객체를 만들 때 super() 로 불린다.
- 💡 추상 클래스 타입의 "변수"는 만들 수 있다.  Shape s = new Rectangle();  → 실제 객체의 getName() 이 실행된다.
- 💡 같은 폴더의 다른 예제와 겹치지 않도록 Shape, Rectangle 을 AbstractShapeTest 안에 static 중첩 클래스로 넣었다.

## 인터페이스

`10-2 상속2` · 📄 [`InterfaceTest.java`](InterfaceTest.java)

#### 💻 코드

<!-- code: InterfaceTest.java -->
```java
public class InterfaceTest {

    public interface IShape {
        static final int x = 3;                     // int x = 3; 으로 써도 똑같다

        public double area();                       // 추상 메소드 (abstract 생략)
        public double volume();
        public String getName();

        public static void print() {                // static 메소드는 허용
            System.out.println("hoho");
        }

        default void hello() {                      // 💡 Java 8 default 메소드 (강의 코드에는 없음)
            System.out.println("기본 구현 : " + getName());
        }
    }

    static class MyShape implements IShape {        // 상속과 다르게 implements 키워드 사용
        private double side;

        MyShape(double side) {
            this.side = side;
        }

        public double area() {                      // 인터페이스의 메소드는 public 으로 구현해야 한다
            return 6 * side * side;
        }

        public double volume() {
            return side * side * side;
        }

        public String getName() {
            return "정육면체 (한 변 " + side + ")";
        }
    }

    public static void main(String[] args) {
        // IShape s0 = new IShape();      // ❌ error: IShape is abstract; cannot be instantiated
        IShape s = new MyShape(2.0);       // 인터페이스 타입 변수에 구현 클래스 객체 저장
        System.out.println("이름 : " + s.getName());
        System.out.println("겉넓이 : " + s.area());
        System.out.println("부피 : " + s.volume());

        System.out.println("IShape.x = " + IShape.x);   // static final 필드
        IShape.print();                                 // static 메소드 : 인터페이스이름.메소드()
        s.hello();                                      // default 메소드
    }
}
```
<!-- /code -->

#### 실행 결과

```text
이름 : 정육면체 (한 변 2.0)
겉넓이 : 24.0
부피 : 8.0
IShape.x = 3
hoho
기본 구현 : 정육면체 (한 변 2.0)
```

**포인트**

- 인터페이스 : 모든 메소드가 다 추상 메소드인 클래스. 객체가 가져야 할 기능만을 명시한 것
- 추상 클래스와 같이 인터페이스로 객체를 생성할 수 없다.
- 상속(extends)과 다르게 implements 키워드를 사용한다.
  ```java
  public interface IShape {               class MyShape implements IShape {
      public double area();                   public double area() {...}
      public double volume();                 public double volume() {...}
      public String getName();                public String getName() {...}
  }                                       }
  ```
- 일반 필드는 불가, static final 필드는 허용한다. (선언과 동시에 초기화)
  ```java
  int x = 3;      // ⇒ static final int x = 3 으로 바뀐다
  ```
- 일반 메소드는 불가, static 메소드는 허용한다.
  ```java
  public void print() { System.out.println("hoho"); }          // ❌ 불가 (몸체가 있는 일반 메소드)
  public static void print() { System.out.println("hoho"); }   // ✅ static 메소드는 가능
  ```

**추상 클래스와 인터페이스의 공통점과 차이점**

- 추상 클래스와 인터페이스는 객체를 생성할 수 없다.
- 파생 클래스에서 추상 메소드를 모두 구현해 주어야만 일반 클래스가 된다.
- 추상 클래스의 모든 메소드가 추상 메소드이면 인터페이스로 바꿀 수 있다.
- 추상 클래스에는 일반 메소드가 있을 수 있다. (인터페이스는 없음 → 💡 아래 default 메소드 참고)
- 인터페이스는 다중 상속을 지원한다. (추상 클래스는 불가)
- 추상 클래스 하나와 인터페이스 여러 개를 함께 상속할 수 있다.
  ```java
  class B extends A implements IShape { ... }
  ```

- 📝 필기 (퀴즈 2번 (7)) : 인터페이스는 모든 메소드들이 추상 메소드 abstract 인 형태라고 보면 된다.<br>메소드만 선언하는 게 아니라 필드도 올 수 있지만, 일반 필드가 아니라 static 필드만 올 수 있다.<br>→ "필드는 올 수 없고 추상 메소드만 올 수 있다" 는 X (상수 필드 public static final 이 올 수 있다)
- 📝 필기 (퀴즈 2번 (8)) : 인터페이스에는 정적 메소드가 올 수 있다. → O (Java 8 부터. 인터페이스이름.정적메소드() 로 호출)
- 📝 필기 (퀴즈 2번 (9)) : 인터페이스에는 일반 필드는 허용되지 않지만 final 필드는 허용된다.<br>일반 필드처럼 선언해도 내부적으로 (public static) final 로 취급되며, 그래서 필드 선언 시 초기화해야 한다. → O
  ```java
  int MAX = 10;  →  public static final int MAX = 10;
  ```

- 💡 인터페이스 안에서는 public, abstract, static final 을 안 써도 자동으로 붙는다.
  ```java
  double area();          ⇒  public abstract double area();
  int x = 3;              ⇒  public static final int x = 3;
  ```<br>그래서 구현하는 클래스의 메소드는 반드시 public 이어야 한다. (부모보다 좁은 접근 범위로 재정의 불가)
  ```text
  double area() {...}     ← public 을 빼면 error: attempting to assign weaker access privileges; was public
  ```
- 💡 Java 8 부터 인터페이스에도 몸체가 있는 메소드를 넣을 수 있다. 단, default 나 static 을 붙여야 한다.
  ```java
  default void hello() { System.out.println("기본 구현"); }   // 구현 클래스가 그대로 쓰거나 재정의
  ```<br>그래서 수업의 "인터페이스는 일반 메소드가 없다" 는 Java 7 까지의 설명이다. 시험은 수업 기준으로 답한다.
- 💡 x 는 static final 이므로 IShape.x 로 쓰고, 값을 바꿀 수 없다.  IShape.x = 5;  → ❌ cannot assign a value to final variable x
- 💡 같은 폴더의 다른 예제와 겹치지 않도록 IShape, MyShape 를 InterfaceTest 안에 중첩해서 넣었다.<br>(중첩된 interface 는 자동으로 static 이다)

## 인터페이스를 이용한 다중 상속

`10-2 상속2` · 📄 [`InterfaceMultipleInheritance.java`](InterfaceMultipleInheritance.java)

#### 💻 코드

<!-- code: InterfaceMultipleInheritance.java -->
```java
public class InterfaceMultipleInheritance {

    static class A {
        public void f1() { System.out.println("A.f1()"); }
        public void f2() { System.out.println("A.f2()"); }
    }

    interface IB {
        public void g1();
        public void g2();
    }

    static class B implements IB {
        public void g1() { System.out.println("B.g1()"); }
        public void g2() { System.out.println("B.g2()"); }
    }

    static class C extends A implements IB {     // 다중 상속의 예
        private B ob = new B();

        public void g1() { ob.g1(); }            // IB 의 메소드는 B 객체에게 맡긴다
        public void g2() { ob.g2(); }
        public void h1() { System.out.println("C.h1()"); }
        public void h2() { System.out.println("C.h2()"); }
    }

    public static void main(String[] args) {
        C c = new C();
        c.f1();          // A 에게서 상속
        c.f2();
        c.g1();          // IB 구현 (B 에게 맡김)
        c.g2();
        c.h1();          // C 에서 추가
        c.h2();

        System.out.println("---- IB 타입으로 ----");
        IB ib = c;       // C 는 IB 타입으로도 쓸 수 있다
        ib.g1();
    }
}
```
<!-- /code -->

#### 실행 결과

```text
A.f1()
A.f2()
B.g1()
B.g2()
C.h1()
C.h2()
---- IB 타입으로 ----
B.g1()
```

**포인트**

- 자바는 클래스를 두 개 이상 extends 할 수 없다.  class C extends A, B  → ❌
- 대신 클래스 하나를 상속하고(extends A), 인터페이스(IB)를 구현한다.<br>인터페이스의 메소드는 그 인터페이스를 이미 구현한 클래스 B 의 객체를 필드로 두고 "일을 맡긴다".

```text
class A { f1(), f2() }          interface IB { g1(), g2() }
      ▲                                ▲              ▲
      │ extends                        │ implements   │ implements
      │                                │              │
class C extends A implements IB ───────┘        class B implements IB
```


      - ob = new B()  ───────────────────────────────▶ (B 객체를 필드로 가짐)
      - g1() { ob.g1(); }   g2() { ob.g2(); }   → B 에게 맡김
      - h1(), h2()          → C 에 새로 추가

→ C 는 A 의 기능(f1, f2)은 상속으로, B 의 기능(g1, g2)은 포함(B 객체에게 맡기기)으로 가진다.<br>C 는 A 타입으로도, IB 타입으로도 쓸 수 있다.

- 💡 강의 코드는 public class A, B, C 를 한 화면에 보여 준다. 실제로는 public class 는 파일마다 하나라서 파일을 나눠야 한다.<br>여기서는 InterfaceMultipleInheritance 안에 static 중첩 클래스로 넣었다.
- 💡 이렇게 다른 객체에게 일을 맡기는 것을 위임(delegation)이라고 한다. MultipleInheritanceTest.java 의 Pickup 도 같은 방식이다.

## \[실습] 자바를 이용하여 다중 상속 구현하기

`10-2 상속2` · 📄 [`MultipleInheritanceTest.java`](MultipleInheritanceTest.java)

#### 💻 코드

<!-- code: MultipleInheritanceTest.java -->
```java
public class MultipleInheritanceTest {

    interface Car {
        public void showInfo();
    }

    static class PassengerCar implements Car {
        private int seats;     // 정원

        public PassengerCar() { seats = 2; }
        public PassengerCar(int n) { seats = n; }
        public int getSeats() { return seats; }
        public void setSeats(int n) { seats = n; }
        public void showInfo() { System.out.println("좌석 수 : " + seats); }
    }

    interface ITruck extends Car {
        public int getPayload();
        public void setPayload(int w);
    }

    static class Truck implements ITruck {
        private int payload;   // 적재 하중

        public Truck() { payload = 100; }
        public Truck(int w) { payload = w; }
        public int getPayload() { return payload; }
        public void setPayload(int w) { payload = w; }
        public void showInfo() { System.out.println("적재 하중 : " + payload); }
    }

    static class Pickup extends PassengerCar implements ITruck {
        private int tow_capacity;   // 견인 능력
        Truck truck;

        public Pickup() { super(4); truck = new Truck(1000); tow_capacity = 10000; }
        public Pickup(int s, int w, int c) { super(s); truck = new Truck(w); tow_capacity = c; }

        public void setCapacity(int c) { tow_capacity = c; }
        public int getCapacity() { return tow_capacity; }

        public void showInfo() {
            System.out.println("좌석 수 : " + getSeats() + ", 적재 하중 : " + getPayload() + ", 견인 능력 : " + tow_capacity);
        }

        @Override
        public int getPayload() { return truck.getPayload(); }

        @Override
        public void setPayload(int w) { truck.setPayload(w); }
    }

    public static void main(String[] args) {
        Car[] cars = new Car[3];
        cars[0] = new PassengerCar();
        cars[1] = new Truck(500);
        cars[2] = new Pickup(4, 2000, 10000);
        for (int i = 0; i < 3; i++) {
            cars[i].showInfo();
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
좌석 수 : 2
적재 하중 : 500
좌석 수 : 4, 적재 하중 : 2000, 견인 능력 : 10000
```

**포인트**

- 픽업트럭(Pickup)은 승용차(PassengerCar)이면서 트럭(Truck)이기도 하다.<br>하지만 자바는 클래스를 두 개 상속할 수 없으므로
  ```java
  class Pickup extends PassengerCar implements ITruck
  ```<br>처럼 승용차는 상속(extends), 트럭 기능은 인터페이스(ITruck)로 구현한다.
- ITruck 의 메소드(getPayload, setPayload)는 필드로 가진 Truck 객체에게 맡긴다.  → truck.getPayload()

```text
interface Car { showInfo() }
    ▲ implements                    ▲ extends
class PassengerCar               interface ITruck { getPayload(), setPayload() }
    ▲ extends                        ▲ implements          ▲ implements
class Pickup ────────────────────────┘                  class Truck
  └ Truck truck (필드) ─────────────────────────────────────▶ 일을 맡김
```

- main 에서는 세 종류의 차를 모두 Car 타입 배열에 넣고 showInfo() 를 부른다.<br>→ 실제 객체의 showInfo() 가 실행된다. (동적 바인딩, 10-3)

- 💡 interface ITruck extends Car : 인터페이스끼리는 extends 로 상속한다. (여러 개도 가능 : extends Car, Other)<br>그래서 Truck 과 Pickup 은 ITruck 의 메소드와 Car 의 showInfo() 를 모두 구현해야 한다.
- 💡 강의 코드는 interface ITruck { … }; 처럼 닫는 중괄호 뒤에 ; 가 있다. 클래스 / 인터페이스 선언 뒤의 ; 는 무시되므로 오류는 아니지만 쓰지 않는 것이 보통이다.
- 💡 Pickup 의 showInfo() 는 getSeats()(PassengerCar 에게서 상속)와 getPayload()(truck 에게 맡김)를 함께 쓴다.<br>seats 는 PassengerCar 의 private 필드라서 Pickup 에서 직접 쓸 수 없다. → getSeats()
- 💡 @Override 는 인터페이스의 메소드를 구현할 때도 붙일 수 있다.
- 💡 같은 폴더의 다른 예제와 겹치지 않도록 모든 클래스를 MultipleInheritanceTest 안에 중첩해서 넣었다.<br>강의 코드에서 "…" 로 생략된 부분은 앞뒤 강의 코드를 모아 채웠다.

## 상속과 바인딩

`10-3 상속3` · 📄 [`BindingTest.java`](BindingTest.java)

#### 💻 코드

<!-- code: BindingTest.java -->
```java
public class BindingTest {

    static class A {
        public int X = 2;
        public void f() { System.out.println("kkk"); }
    }

    static class B extends A {
        public int X = 0;
        public void f() { System.out.println("hhh"); }
    }

    public static void main(String[] args) {
        A c = new B();
        System.out.println(c.X);   // A 에서 상속받은 X → (정적 바인딩)
        c.f();                     // B 의 f() → (동적 바인딩)

        System.out.println("---- 변수 타입을 B 로 ----");   // 💡 비교용
        B d = (B) c;
        System.out.println(d.X);   // B 의 X
        d.f();                     // 메소드는 여전히 B 의 f()
    }
}
```
<!-- /code -->

#### 실행 결과

```text
2
hhh
---- 변수 타입을 B 로 ----
0
hhh
```

**포인트**

- 바인딩 : 이름(필드, 메소드)을 실제로 어느 것과 연결할지 정하는 것
- 필드는 정적 바인딩 : 컴파일할 때 "변수의 타입"을 보고 결정한다.
- 메소드는 동적 바인딩 : 실행할 때 "객체의 타입"에 따라 결정한다.

```java
A c = new B();
c.X     → A 에서 상속받은 X  (변수 c 의 타입이 A → 정적 바인딩)   = 2
c.f()   → B 의 f()           (실제 객체가 B → 동적 바인딩)       = hhh
```

- static(정적) 필드, static 메소드는 모두 정적 바인딩이다. (컴파일 시 결정) → StaticBindingTest.java

- 📝 필기 (퀴즈) : 자바는 동적 바인딩<br>질문 : 자바는 동적 바인딩이면 동적 타입 언어인가? → 아니다. 자바는 대표적인 "정적 타입 언어"다.<br>두 개념이 비슷해 보여 헷갈리기 쉽다.
  1. 정적 타입 언어 (Static Typing)
      - 변수를 선언할 때 자료형(int, String, Human 등)을 명시해야 하고, 컴파일 시점에 변수의 타입이 정해지고 검사된다.
      - 한 번 선언된 변수의 타입은 실행 중에 바뀔 수 없고, 맞지 않는 타입의 값을 넣으면 컴파일 에러가 난다.
        ```java
        int age = 10;
        age = "열살";     // 컴파일 에러 (정적 타입 검사)
        ```
      - (참고) 파이썬, 자바스크립트처럼 변수에 타입을 적지 않고 실행 시점에 타입이 정해지는 언어가 "동적 타입 언어"다.
  2. 동적 바인딩 (Dynamic Binding)
      - 자바는 정적 타입 언어이지만, 상속 관계에서 메소드를 호출할 때는 동적 바인딩을 쓴다.
        ```java
        Human h = new Student("철수", 20, "컴퓨터");
        h.print();
        ```
      - 컴파일 시점 : 컴파일러는 h 의 타입을 Human 으로 보고, Human 클래스에 print() 가 있는지만 검사한다.
      - 실행 시점 : JVM 이 h 가 가리키는 실제 객체가 Student 임을 확인하고, Student 가 재정의한 print() 를 실행한다.

요약 : 언어의 타입 시스템 → 정적 타입 / 오버라이딩된 메소드 호출 방식 → 동적 바인딩

- 📝 필기 (퀴즈) : 실제 돌아갈 때는 상위 타입의 변수에 대해서 상위 타입 메소드를 호출하는 게 아니라 객체가 뭐냐에 따라서 결정.

- ⚠ 자주 틀리는 부분 : 필드는 재정의되지 않는다. B 에 같은 이름의 X 를 만들면 A 의 X 를 "가릴(hide)" 뿐이고, B 객체 안에는 A 의 X(2) 와 B 의 X(0) 가 둘 다 들어 있다. 어느 X 를 쓸지는 변수의 타입이 정한다.
  ```text
  ((B) c).X  → 0   (변수 타입을 B 로 바꾸면 B 의 X)
  ```<br>그래서 부모와 자식에 같은 이름의 필드를 만들지 않는 것이 좋다. (보통 private 필드 + getter 로 쓴다)
- 💡 같은 폴더의 다른 예제와 겹치지 않도록 A, B 를 BindingTest 안에 static 중첩 클래스로 넣었다. (강의 코드의 public class 이름은 Test)

## 상속과 바인딩 - static

`10-3 상속3` · 📄 [`StaticBindingTest.java`](StaticBindingTest.java)

#### 💻 코드

<!-- code: StaticBindingTest.java -->
```java
public class StaticBindingTest {

    static class A {
        public static int X = 2;
        public static void f() { System.out.println("kkk"); }
    }

    static class B extends A {
        public static int X = 0;
        public static void f() { System.out.println("hhh"); }
    }

    @SuppressWarnings({"static", "static-access"})   // 💡 객체 변수로 static 멤버를 쓰는 경고를 숨김 (javac, 이클립스)
    public static void main(String[] args) {
        A c = new B();
        System.out.println(c.X);   // A 의 X
        c.f();                     // A 의 f()

        System.out.println("---- 클래스 이름으로 ----");   // 💡 비교용
        System.out.println(B.X);
        B.f();
    }
}
```
<!-- /code -->

#### 실행 결과

```text
2
kkk
---- 클래스 이름으로 ----
0
hhh
```

**포인트**

- 정적(static) 필드, 정적 메소드는 모두 정적 바인딩이다. (컴파일 시 결정)
  ```java
  A c = new B();
  c.X     → A 의 X
  c.f()   → A 의 f()      ← 실제 객체가 B 인데도 A 의 f() 가 불린다 (BindingTest.java 와 비교)
  ```

- 💡 static 메소드는 객체가 아니라 "클래스"에 속한다. 그래서 변수 c 가 가리키는 객체는 보지 않고 변수의 타입(A)만 본다.<br>c.f() 라고 써도 컴파일러는 A.f() 로 바꿔서 호출한다.
- 💡 그래서 static 멤버는 객체 변수 대신 클래스 이름으로 쓰는 것이 좋다.  A.X, A.f(), B.f()<br>(객체 변수로 쓰면 이클립스는 "The static method f() from the type A should be accessed in a static way" 경고를 준다)
- ⚠ 자주 틀리는 부분 : B 의 static f() 는 A 의 f() 를 재정의(override)한 것이 아니라 "숨긴(hide)" 것이다.<br>static 메소드에 @Override 를 붙이면 컴파일 오류가 난다.
  ```text
  error: method does not override or implement a method from a supertype
  ```<br>반대로 static 메소드를 인스턴스 메소드로(또는 그 반대로) 바꿔 쓰는 것도 오류다.
- 💡 같은 폴더의 다른 예제와 겹치지 않도록 A, B 를 StaticBindingTest 안에 static 중첩 클래스로 넣었다. (강의 코드의 public class 이름은 Test)

## 익명 내부 클래스

`10-3 상속3` · 📄 [`AnonymousTest.java`](AnonymousTest.java)

#### 💻 코드

<!-- code: AnonymousTest.java -->
```java
public class AnonymousTest {

    interface MyInterface {
        public void test();
    }

    // (2) 익명 클래스를 사용하지 않았을 경우
    static class MyClass implements MyInterface {
        public void test() {
            System.out.println("테스트입니다.");
        }
    }

    public static void main(String[] args) {
        // (1) 인터페이스를 구현하는 익명 클래스를 정의함과 동시에 객체를 생성
        MyInterface inner = new MyInterface() {
            public void test() {
                System.out.println("테스트입니다.");
            }
        };
        inner.test();

        // (2) 이름이 있는 클래스 MyClass 로 객체 생성
        MyClass inner2 = new MyClass();
        inner2.test();

        // 💡 람다식 (강의 코드에는 없음)
        MyInterface inner3 = () -> System.out.println("람다식 테스트입니다.");
        inner3.test();
    }
}
```
<!-- /code -->

#### 실행 결과

```text
테스트입니다.
테스트입니다.
람다식 테스트입니다.
```

**포인트**

- 익명 내부 클래스 : 클래스 이름이 없는 클래스
- 선언과 함께 객체 생성이 동시에 된다.
- 보통 기존 클래스의 메소드를 재정의할 경우, 또는 인터페이스를 구현할 경우에 쓴다.
  ```java
  MyInterface an_inner = new MyInterface() {    ← 인터페이스를 구현하는 이름 없는 클래스를 정의하면서
      public void test() {                         동시에 그 객체를 만든다
          ........
      }
  };                                            ← 대입문이므로 끝에 ; 가 필요
  ```

- (1) 익명 클래스 사용 : 인터페이스를 구현하는 익명 클래스를 정의함과 동시에 객체를 생성
- (2) 익명 클래스를 사용하지 않았을 경우 : class MyClass implements MyInterface 를 따로 만들고 new MyClass()<br>→ 결과는 같다. 한 번만 쓰고 말 클래스라면 (1) 처럼 이름을 붙이지 않고 바로 만들면 코드가 짧아진다.

- ⚠ 자주 틀리는 부분 : 강의 코드의 Interface MyInterface 처럼 대문자로 쓰면 컴파일 오류다. 자바의 키워드는 모두 소문자 interface.
- ⚠ 자주 틀리는 부분 : 익명 클래스는 마지막에 }; 로 끝난다. 클래스 몸체를 닫는 } 와 대입문을 끝내는 ; 를 둘 다 써야 한다.
- 💡 익명 클래스도 컴파일하면 AnonymousTest$1.class 처럼 번호가 붙은 클래스 파일이 따로 생긴다. "이름이 없다" 는 것은 코드에서 부를 이름이 없다는 뜻이다.
- 💡 인터페이스의 메소드는 public 이므로 익명 클래스 안의 test() 도 public 이어야 한다.
- 💡 메소드가 하나뿐인 인터페이스는 Java 8 의 람다식으로 더 짧게 쓸 수 있다.  MyInterface in3 = () -> System.out.println("...");
- 💡 같은 폴더의 다른 예제와 겹치지 않도록 MyInterface, MyClass 를 AnonymousTest 안에 중첩해서 넣었다.

## 익명 내부 클래스 - 생성과 동시에 인수로 사용

`10-3 상속3` · 📄 [`AnonymousArgumentTest.java`](AnonymousArgumentTest.java)

#### 💻 코드

<!-- code: AnonymousArgumentTest.java -->
```java
public class AnonymousArgumentTest {

    interface Greeting {
        String message();
    }

    public void display(Greeting g) {
        System.out.println(g.message());
    }

    public static void main(String args[]) {
        AnonymousArgumentTest ob = new AnonymousArgumentTest();

        ob.display(new Greeting() {      // 생성과 동시에 인수로 사용
            public String message() {
                return "안녕하세요";
            }
        });

        ob.display(() -> "반갑습니다");   // 💡 같은 일을 람다식으로 (강의 코드에는 없음)
    }
}
```
<!-- /code -->

#### 실행 결과

```text
안녕하세요
반갑습니다
```

**포인트**

- 익명 클래스 객체는 변수에 담지 않고, 만들자마자 메소드의 인수로 넘길 수 있다.
  ```java
  ob.display(new Greeting() {          // 생성과 동시에 인수로 사용
      public String message() {
          return "안녕하세요";
      }
  });                                  ← } 는 익명 클래스 몸체, ) 는 display( 의 닫는 괄호, ; 는 문장 끝
  ```
- display(Greeting g) 는 Greeting 인터페이스를 구현한 객체라면 무엇이든 받을 수 있다.<br>호출하는 쪽에서 message() 의 내용을 마음대로 정해서 넘긴다.

- 💡 display 는 static 이 아닌 일반(인스턴스) 메소드다. 그래서 static main 에서 부르려면 먼저 객체 ob 를 만든다.
  ```java
  AnonymousTest ob = new AnonymousTest();   ob.display(...);
  ```<br>(static 메소드에서 인스턴스 메소드를 바로 부르면 error: non-static method display(Greeting) cannot be referenced from a static context)
- 💡 main(String args\[]) 처럼 배열 괄호를 변수 이름 뒤에 써도 된다. (C 스타일)
- 💡 강의 코드의 public class 이름은 AnonymousTest. 앞의 예제(AnonymousTest.java)와 겹쳐서 AnonymousArgumentTest 로 바꿨다.

## 클래스 형변환 (Type Casting)

`10-3 상속3` · 📄 [`TypeCastingTest.java`](TypeCastingTest.java)

#### 💻 코드

<!-- code: TypeCastingTest.java -->
```java
public class TypeCastingTest {

    static class Poly { }

    static class Square extends Poly { }

    static class A {
        public int x = 53;

        public void print() {
            System.out.println("Parent method :" + x);
        }
    }

    static class B extends A {
        public int x = 17;
        public String y = "abc";

        public void print() {
            System.out.println("Child method :" + x);
            System.out.println("Child method :" + y);
        }
    }

    public static void main(String arg[]) {
        System.out.println("---- Poly / Square ----");
        Poly y = new Square();                      // 묵시적
        System.out.println("Poly y = new Square() : 묵시적 형변환 OK");
        try {
            Square x = (Square) new Poly();         // 명시적 : 컴파일은 되지만 실행 오류
        } catch (ClassCastException e) {
            System.out.println("(Square) new Poly() → " + e.getClass().getName());
        }

        System.out.println("---- (1) 하위 타입의 객체를 상위 타입의 변수에 ----");
        A p = new B();
        p.print();                                  // B 의 메소드 호출
        System.out.println("Parent value : " + p.x); // A 의 필드 접근

        System.out.println("---- (2) 상위 타입의 객체를 하위 타입의 변수에 ----");
        try {
            B p2 = (B) new A();                     // 컴파일 오류 아님. 실행 오류
            p2.print();
            System.out.println("Child value : " + p2.x);
        } catch (ClassCastException e) {
            System.out.println("B p = (B) new A() → " + e.getClass().getName());
        }

        // 아래의 형태는 허용
        A p3 = new B();
        B c = (B) p3;
        c.print();
        System.out.println("Child value : " + c.x);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
---- Poly / Square ----
Poly y = new Square() : 묵시적 형변환 OK
(Square) new Poly() → java.lang.ClassCastException
---- (1) 하위 타입의 객체를 상위 타입의 변수에 ----
Child method :17
Child method :abc
Parent value : 53
---- (2) 상위 타입의 객체를 하위 타입의 변수에 ----
B p = (B) new A() → java.lang.ClassCastException
Child method :17
Child method :abc
Child value : 17
```

**포인트**

- 하위 클래스 → 상위 클래스로의 변환은 묵시적(자동)이다.   Poly y = new Square();          (업캐스팅)
- 상위 클래스 → 하위 클래스로의 변환은 명시적(강제적)이다. Square x = (Square) p;          (다운캐스팅)
- 필드에 대한 접근은 객체 변수의 타입에 의해 결정된다.        (정적 바인딩)
- 메소드 호출은 실제 저장된 인스턴스의 타입에 의해 결정된다.  (동적 바인딩)

- (1) \[실습] 하위 타입의 객체를 상위 타입의 변수에 저장하기
  ```java
  A p = new B();
  p.print();     → B 의 메소드 호출 (Child method :17, Child method :abc)
  p.x            → A 의 필드 접근 (53)
  ```
- (2) \[실습] 상위 타입의 객체를 하위 타입의 변수에 저장하기
  ```text
  B p = (B) new A();    → 컴파일 오류는 아니지만 실행 오류 (ClassCastException)
  A p = new B();  B c = (B) p;   → 아래 형태는 허용 (p 가 실제로 B 객체를 가리키므로)
  ```

- ⚠ 자주 틀리는 부분 : 강의의 Square x = (Square) new Poly(); // 명시적  은 "명시적 형변환을 쓰는 문법" 의 예일 뿐, 실제로 실행하면 ClassCastException 이 난다. new Poly() 로 만든 객체는 Square 가 아니기 때문이다.
  - (2) 의 B p = (B) new A(); 와 같은 경우다. 다운캐스팅은 "원래 하위 타입이었던 객체"를 되돌릴 때만 성공한다.

→ 안전하게 하려면 instanceof 로 먼저 검사한다. (IsTest.java)

- 💡 업캐스팅한 변수로는 부모에 있는 것만 쓸 수 있다. A p = new B(); 에서 p.y 는 컴파일 오류 (A 에는 y 가 없다)
  ```text
  error: cannot find symbol  symbol: variable y  location: variable p of type A
  ```
- 💡 왜 업캐스팅을 쓰나? 서로 다른 자식 객체들을 부모 타입 하나로 묶어서(배열, 매개변수) 똑같이 다룰 수 있기 때문이다.<br>(MultipleInheritanceTest.java 의 Car\[] cars, 퀴즈 3번의 Human\[] arr)
- 💡 강의 코드의 public class 이름은 Program, Example. 같은 폴더의 다른 예제와 겹치지 않도록 Poly, Square, A, B 를 TypeCastingTest 안에 static 중첩 클래스로 넣었다. 강의 코드의 main(String arg\[]) 도 그대로 썼다.

## 인터페이스의 형변환

`10-3 상속3` · 📄 [`InterfaceCastingTest.java`](InterfaceCastingTest.java)

#### 💻 코드

<!-- code: InterfaceCastingTest.java -->
```java
public class InterfaceCastingTest {

    interface IA {
        public void print();
    }

    static class A implements IA {
        public int x = 17;
        public String y = "abc";

        public void print() {
            System.out.println("print method :" + x);
            System.out.println("print method :" + y);
        }
    }

    public static void main(String[] args) {
        IA p = new A();
        p.print();
        // System.out.println("x : " + p.x);      // ❌ 접근 불가능
        System.out.println("x : " + ((A) p).x);   // 💡 A 로 형변환하면 접근 가능
    }
}
```
<!-- /code -->

#### 실행 결과

```text
print method :17
print method :abc
x : 17
```

**포인트**

- 인터페이스로 객체를 생성하지는 못하지만, 인터페이스 유형의 객체 참조 변수에 그 인터페이스를 구현하고 있는
  ```java
  클래스 객체를 할당할 수 있다.        IA p = new A();
  ```
- 클래스 형변환과 마찬가지로, 인터페이스 유형의 객체 참조 변수는 인터페이스에 선언된 요소에만 접근할 수 있다.
  ```text
  p.print();    → ✅ IA 에 선언된 메소드. 실제로는 A 의 print() 가 실행된다
  p.x           → ❌ 접근 불가능 (IA 에는 x 가 없다)
    error: cannot find symbol  symbol: variable x  location: variable p of type IA
  ```

- 💡 A 의 필드를 쓰고 싶으면 다시 A 타입으로 형변환한다.  ((A) p).x  또는  A a = (A) p;
- 💡 같은 폴더의 다른 예제와 겹치지 않도록 IA, A 를 InterfaceCastingTest 안에 중첩해서 넣었다. (강의 코드의 public class 이름은 Example)

## \[실습] instanceof 연산자 사용하기

`10-3 상속3` · 📄 [`IsTest.java`](IsTest.java)

#### 💻 코드

<!-- code: IsTest.java -->
```java
public class IsTest {

    static class Class1 { }

    static class Class2 { }

    static void test(Object o) {
        Class1 ob1;
        Class2 ob2;
        if (o instanceof Class1) {
            System.out.println("o is Class1");
            ob1 = (Class1) o;
        } else if (o instanceof Class2) {
            System.out.println("o is Class2");
            ob2 = (Class2) o;
        } else {
            System.out.println("o is neither Class1 nor Class2.");
        }
    }

    public static void main(String[] args) {
        Class1 c1 = new Class1();
        Class2 c2 = new Class2();
        test(c1);           // if 문
        test(c2);           // else if 문
        test("a string");   // else 문

        System.out.println("---- 조상 타입 검사 ----");   // 💡 비교용
        Object nothing = null;
        System.out.println("c1 instanceof Object : " + (c1 instanceof Object));
        System.out.println("null instanceof Class1 : " + (nothing instanceof Class1));
    }
}
```
<!-- /code -->

#### 실행 결과

```text
o is Class1
o is Class2
o is neither Class1 nor Class2.
---- 조상 타입 검사 ----
c1 instanceof Object : true
null instanceof Class1 : false
```

**포인트**

- instanceof : 레퍼런스 변수가 가리키는 객체가 어떤 타입인지 검사하는 연산자. 주로 조건문에 쓴다.
  ```text
  o instanceof Class1     ← 왼쪽에는 레퍼런스 변수, 오른쪽에는 타입(클래스명)
  ```
- 연산 결과로 boolean 값인 true, false 중 하나를 반환한다.
- 실제 인스턴스와 같은 타입뿐만 아니라 조상 타입에 대해서도 true 를 반환한다.<br>따라서 instanceof 연산의 결과가 true 라는 것은 검사한 타입으로 형변환이 가능하다는 뜻이다.
  ```java
  if (o instanceof Class1) { ob1 = (Class1) o; }   ← 검사한 뒤 안전하게 다운캐스팅
  ```

- test(Object o) : Object 는 모든 클래스의 조상이므로 어떤 객체든(Class1, Class2, String) 받을 수 있다.

- 💡 실행 결과의 마지막 줄은 코드대로 "o is neither Class1 nor Class2." 처럼 마침표까지 출력된다.<br>(강의 자료의 실행 결과에는 마침표가 빠져 있다)
- 💡 "조상 타입에 대해서도 true" 확인 : 모든 객체는 Object 의 자손이므로 c1 instanceof Object 는 true 다.
- 💡 null instanceof 아무타입 은 항상 false 다. 그래서 instanceof 검사를 통과하면 null 이 아님도 보장된다.
- 💡 Java 16 부터는 검사와 형변환을 한 번에 쓸 수 있다. (패턴 매칭)
  ```java
  if (o instanceof Class1 ob1) { ... ob1 을 바로 사용 ... }
  ```
- 💡 같은 폴더의 다른 예제와 겹치지 않도록 Class1, Class2 를 IsTest 안에 static 중첩 클래스로 넣었다.

## Wrapper(포장) 클래스

`10-3 상속3` · 📄 [`WrapperTest.java`](WrapperTest.java)

#### 💻 코드

<!-- code: WrapperTest.java -->
```java
public class WrapperTest {
    public static void main(String[] args) {
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Integer.SIZE = " + Integer.SIZE);

        Integer iObj = Integer.valueOf(30);   // boxing 과정 (강의 코드 : new Integer(30), ⚠ deprecated)
        int age2 = iObj.intValue();           // unboxing 과정
        System.out.println("boxing " + iObj + " → unboxing " + age2);

        int i = 123;
        Integer o = i;                        // autoboxing
        int j = o;                            // autounboxing
        System.out.println("autoboxing " + o + " → autounboxing " + j);

        Double dObj = 1.23;                   // autoboxing (double → Double)
        // int n2 = dObj;                     // ❌ 오류 발생 : Double 은 int 와 상응하지 않는다
        int n = dObj.intValue();
        System.out.println("dObj.intValue() = " + n);

        System.out.println("Integer.parseInt(\"123\") + 1 = " + (Integer.parseInt("123") + 1));   // 💡

        Integer a = 1000, b = 1000;           // 💡 비교는 equals
        System.out.println("equals : " + a.equals(b));
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Integer.MAX_VALUE = 2147483647
Integer.MIN_VALUE = -2147483648
Integer.SIZE = 32
boxing 30 → unboxing 30
autoboxing 123 → autounboxing 123
dObj.intValue() = 1
Integer.parseInt("123") + 1 = 124
equals : true
```

**포인트**

- 기본형 타입을 객체로 사용해야 하는 경우에 쓴다. Wrapper 클래스는 기본형 자료에 대한 메소드를 제공한다.
  ```java
  int → Integer,   double → Double,   byte → Byte
  short → Short,   long → Long,       float → Float
  char → Character, boolean → Boolean, void → Void
  ```
- Void 클래스는 실체화(객체 생성)될 수 없으며 단지 "공 참조(null)" 개념이다.
- Void 를 제외한 포장 클래스의 생성자는 저장할 기본형 타입 값을 인수로 받는다.
- 포장 클래스는 다양한 메소드 및 상수를 제공한다.<br>Integer.MAX\_VALUE : int 형 변수가 가질 수 있는 최대값<br>Integer.MIN\_VALUE : int 형 변수가 가질 수 있는 최소값
  ```text
  Integer.SIZE      : int 형 변수의 비트 크기
  ```
- boxing : 기본 자료형을 포장 클래스로 변환     Integer iObj = new Integer(30);
  ```java
  unboxing : 포장 클래스를 기본 자료형으로 변환  int age2 = iObj.intValue();
  ```
- JDK 1.5 이후는 자동으로 boxing, unboxing 이 처리되는 autoboxing, autounboxing 을 제공한다.
  ```text
  int i = 123;
  Integer o = i;   // autoboxing      i [123]     o [ ●─]──▶ [int : 123]   (o 는 객체를 가리킨다)
  int j = o;       // autounboxing    j [123]
  ```
- autoboxing 과 autounboxing 은 기본형 타입과 그에 상응하는 포장 클래스 사이에서만 일어난다. 다른 경우 컴파일 에러가 난다.
  ```java
  Double dObj = 1.23;
  int n2 = dObj;              // ❌ 오류 발생 : error: incompatible types: Double cannot be converted to int
  int n = dObj.intValue();    // ✅ 메소드로 직접 변환 (소수점 이하 버림 → 1)
  ```

- ⚠ 자주 틀리는 부분 : new Integer(30) 처럼 포장 클래스의 생성자를 쓰는 방법은 JDK 9 부터 deprecated(사용 자제)라서 컴파일하면 "uses or overrides a deprecated API" 안내가 나온다. Integer.valueOf(30) 또는 autoboxing 을 쓴다.<br>(-Xlint 로 컴파일하면) warning: \[deprecation] Integer(int) in Integer has been deprecated
- 💡 포장 객체끼리 값을 비교할 때는 == 가 아니라 equals() 를 쓴다. (String 과 같은 이유 : == 는 참조 비교)<br>Integer.valueOf 는 -128 \~ 127 은 미리 만든 객체를 재사용해서 == 가 우연히 true 가 될 수 있어 더 헷갈린다.
- 💡 포장 클래스가 필요한 대표적인 곳 : ArrayList&lt;Integer> 처럼 객체만 담을 수 있는 컬렉션, null 이 필요한 값
- 💡 Integer.parseInt("123") 처럼 문자열을 기본형으로 바꾸는 static 메소드도 포장 클래스에 있다.

## \[실습] boxing 과 unboxing

`10-3 상속3` · 📄 [`BoxingUnBoxingTest.java`](BoxingUnBoxingTest.java)

#### 💻 코드

<!-- code: BoxingUnBoxingTest.java -->
```java
public class BoxingUnBoxingTest {
    public static void main(String[] args) {
        int val = 30;
        Integer iOb = Integer.valueOf(val);   // boxing
        Integer jOb = val;                    // autoboxing

        System.out.println(val + " " + iOb + " " + jOb);

        Integer ob = Integer.valueOf(5);      // 강의 코드 : new Integer(5) (⚠ deprecated)
        int i = ob.intValue();                // unboxing
        int j = ob;                           // autounboxing

        System.out.println(ob + " " + i + " " + j);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
30 30 30
5 5 5
```

**포인트**

- boxing      : Integer iOb = Integer.valueOf(val);   기본형 → 포장 객체 (메소드로 직접)
- autoboxing  : Integer jOb = val;                    컴파일러가 Integer.valueOf(val) 로 바꿔 준다
- unboxing    : int i = ob.intValue();                포장 객체 → 기본형 (메소드로 직접)
- autounboxing: int j = ob;                           컴파일러가 ob.intValue() 로 바꿔 준다
- println 에 포장 객체를 넣으면 toString() 이 불려 안의 값이 출력된다.

- ⚠ 자주 틀리는 부분 : 강의 코드의 Integer ob = new Integer(5); 는 JDK 9 부터 deprecated(사용 자제)다.<br>JDK 25 에서도 컴파일은 되지만 "uses or overrides a deprecated API" 안내가 나온다.<br>(-Xlint 로 컴파일하면) warning: \[deprecation] Integer(int) in Integer has been deprecated Integer.valueOf(5) 로 바꿔 썼다. 결과는 같다.
- ⚠ 자주 틀리는 부분 : null 인 포장 객체를 autounboxing 하면 NullPointerException 이 난다.
  ```text
  Integer none = null;  int k = none;   → 실행 오류 (none.intValue() 를 부르는 것과 같기 때문)
  ```

## 다른 패키지에 있는 부모 클래스 (OtherPackageAccessTest.java 에서 사용)

`10-1 상속1` · 📄 [`otherpkg/A.java`](otherpkg/A.java)

#### 💻 코드

<!-- code: otherpkg/A.java -->
```java
package otherpkg;

public class A {
    private int a = 1;
    int b = 5;
    protected int c = 10;
    public int d = 15;
}
```
<!-- /code -->

#### 📒 해설

- 💡 다른 패키지에서 쓰려면 클래스 자체가 public 이어야 한다.<br>class A 처럼 public 을 빼면 다른 패키지에서는 import 도 할 수 없다.<br>(error: A is not public in otherpkg; cannot be accessed from outside package)
- 💡 강의 코드의 패키지 이름은 다르지만 내용은 같다.

---

[🏠 10주차 학습 가이드](../../README.md)
