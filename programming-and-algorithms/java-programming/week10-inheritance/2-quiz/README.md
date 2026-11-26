# 10주차 퀴즈

[🏠 10주차 학습 가이드](../README.md)

| 파일 | 내용 |
|---|---|
| [InheritanceQuiz.java](#상속-재정의--접근-제어--생성자-호출-순서--추상-클래스--인터페이스--human--student) | 1번 `super.메서드()`, 오버로딩 vs 오버라이딩, 시그니처, 재정의의 용도, package private. 2번 O/X 9문항(📝 생성자 순서, 소멸자 중복 정답, 추상 클래스, 인터페이스 필드 · 정적 메소드). 3번 Human / Student(📝 `super()` · `super.print()`). 📝 getter / setter 해부, 객체 배열과 반복문, 자바는 동적 바인딩인가, 업캐스팅 |

---

## 상속 (재정의 · 접근 제어 · 생성자 호출 순서 · 추상 클래스 · 인터페이스 · Human / Student)

`10강 퀴즈` · 📄 [`InheritanceQuiz.java`](InheritanceQuiz.java)

1. 다음 질문에 간단히 답하라. (5문항)                                          → q1()
2. 아래의 질문에 O, X 를 하시오. (9문항)                                       → q2()
3. Human 클래스와 Human 을 상속한 Student 클래스 작성하기 (10문항)              → q3()<br>+ 📝 추가 정리 : getter / setter 해부, 객체 배열과 반복문 2가지,
  ```text
  자바는 동적 바인딩인가?, 업캐스팅으로 (10)번 다시 쓰기         → q3Extra()
  ```

- 💡 한 파일 안에서 실행하려고 문제의 클래스(Parent, Child, Human, Student)를 아래쪽에 public 없이 넣었다.

**표시**

  - 📝 필기 : 채점 후 정리한 내용 / ⚠ 자주 틀리는 부분 : 헷갈리기 쉬운 오답과 그 이유 / 💡 보충 설명

**실행 결과**

===== 1 =====<br>부모 메서드<br>자식 메서드<br>===== 2 =====

- (1) X  (2) X  (3) X  (4) O  (5) O  (6) O  (7) X  (8) O  (9) O

===== 3 =====<br>---- (5) ----<br>이름: 개똥, 나이: 10<br>이름: 소똥, 나이: 20<br>이름: 말똥, 나이: 21<br>---- (10) ----<br>이름: 순이, 나이: 10<br>전공: 식품<br>이름: 철수, 나이: 20<br>전공: 컴퓨터<br>이름: 바둑이, 나이: 21<br>전공: 철학<br>===== 3 (추가) =====<br>25<br>---- Human 배열 (향상된 for 문) ----<br>이름: 개똥, 나이: 10<br>이름: 소똥, 나이: 20<br>이름: 말똥, 나이: 21<br>---- Human 배열에 Student 저장 (업캐스팅) ----<br>이름: 순이, 나이: 10<br>전공: 식품<br>이름: 철수, 나이: 20<br>전공: 컴퓨터<br>이름: 바둑이, 나이: 21<br>전공: 철학

## 1. 다음 질문에 간단히 답하라.

- (1) 자식 클래스에서 재정의된 부모 클래스의 메서드를 호출하려면 어떻게 해야 하나?<br>정답 : super 키워드를 사용하여 super.메서드이름() 형태로 호출한다.
  - 자식 클래스에서 부모 클래스의 메서드를 재정의(오버라이딩)하면 부모의 메서드는 가려진다(은닉).<br>그래서 자식 클래스 안에서 그냥 메서드이름() 으로 호출하면 자식 클래스에서 재정의한 메서드가 실행된다.
  - 가려진 부모의 원래 메서드를 호출하려면, 부모 클래스의 참조값을 가지고 있는 예약어 super 와 도트 연산자(.)를 사용해 명시적으로 호출한다.
    ```java
    class Parent {
        void display() { System.out.println("부모 메서드"); }
    }
    class Child extends Parent {
        @Override
        void display() {
            super.display();   // 부모 클래스의 display() 호출
            System.out.println("자식 메서드");
        }
    }
    ```

- (2) 메서드 중복 정의(overloading)와 재정의(overriding)의 차이점은?<br>정답
  - 중복 정의(Overloading) : 같은 클래스 내(또는 상속 관계)에서 메서드의 이름은 같지만, 매개변수의 개수나 타입(시그니처)을 다르게 하여 새로운 메서드를 여러 개 정의하는 것
  - 재정의(Overriding) : 상속 관계에서 부모 클래스에 정의된 메서드를 자식 클래스에서 동일한 시그니처(이름, 매개변수, 반환형)로 내용을 다시 작성(덮어쓰기)하는 것

두 개념은 이름은 비슷하지만 목적과 성립 조건이 완전히 다르다.

```text
구분              중복 정의 (Overloading)               재정의 (Overriding)
관계              주로 같은 클래스 내부 (상속 관계도 가능) 반드시 부모 - 자식 간의 상속 관계
메서드 이름       동일함                                 동일함
매개변수(개수, 타입) 반드시 달라야 함                     반드시 같아야 함
반환형            상관없음                               같아야 함 (또는 하위 타입)
접근 지정자       상관없음                               부모보다 좁은 범위로 변경 불가
목적              같은 기능에 대해 다양한 입력을 처리 (편의성)  부모의 기능을 자식의 특성에 맞게 변경 (다형성)
```

- (3) 만약 자식 클래스에 부모 클래스의 멤버 함수와 동일한 시그니처를 가진 멤버 함수가 있다면 이것은 재정의인가 아니면 중복 정의인가?<br>정답 : 재정의(Overriding)
  - 메서드 시그니처(Method Signature)란 "메서드의 이름" 과 "매개변수 리스트(개수, 데이터 타입, 순서)" 를 뜻한다.
  - 상속 관계에서 시그니처가 완전히 동일한 멤버 함수를 자식 클래스가 다시 정의하는 것은 부모의 메서드를 덮어쓰는 것이므로 재정의다. 만약 시그니처(매개변수)가 달랐다면 중복 정의다.

- (4) 메서드 재정의는 어떤 용도로 사용하는가?<br>정답 : 부모 클래스로부터 상속받은 기본 기능을 자식 클래스의 상황과 특성에 맞게 변경(수정)하거나 확장하기 위해 사용한다. 이를 통해 객체지향의 핵심인 다형성(Polymorphism)을 구현한다.
  1. 특수화(Specialization) : 부모 클래스가 제공하는 일반적인 기능이 자식 클래스에는 맞지 않을 때, 자식 클래스에 알맞은 동작으로 교체하기 위해 사용한다.<br>(예 : 동물 클래스의 소리내기() 메서드를 강아지 클래스에서는 "멍멍", 고양이 클래스에서는 "야옹" 이 출력되도록 재정의)
  2. 다형성(Polymorphism) 및 동적 바인딩 구현 : 부모 타입의 참조 변수로 여러 자식 객체를 다룰 때, 동일한 메서드를 호출하더라도 실행 시점(Runtime)에 실제 자식 객체의 재정의된 메서드가 알아서 실행되도록 만든다.<br>이를 통해 코드의 유지보수성과 확장성을 크게 높일 수 있다.

- (5) 어떤 필드가 package private 으로 선언되었다면 어떤 클래스에서 이 필드를 직접 접근할 수 있는가?<br>정답 : 해당 필드가 선언된 자기 자신의 클래스와 동일한 패키지(같은 디렉터리) 내에 속해 있는 클래스들에서만 직접 접근할 수 있다.
  - 자바에서 필드나 메서드 앞에 public, protected, private 같은 접근 지정자를 아무것도 적지 않으면 기본적으로 package-private (또는 default 접근 지정자)로 설정된다.
  - 같은 패키지 내부 : 상속 여부와 상관없이 어떤 클래스에서든 직접 접근이 가능하다.
  - 다른 패키지 외부 : 절대 직접 접근할 수 없다. 심지어 해당 클래스를 상속받은 자식 클래스라 할지라도 다른 패키지에 있다면 접근할 수 없다. (다른 패키지의 자식 클래스까지 허용하려면 protected 를 사용해야 한다)

\[참고] Java 의 4가지 접근 지정자 범위 비교

```java
접근 지정자                 같은 클래스   같은 패키지   다른 패키지의 자식 클래스   전체 (어디서나)
private                       O             X              X                        X
package-private (default)     O             O              X                        X
protected                     O             O              O                        X
public                        O             O              O                        O
```

- 💡 (1) \~ (4) 의 코드 예제 : 1-lecture/code/MethodOverridingTest.java, (5) : 1-lecture/code/AccessControlTest.java, OtherPackageAccessTest.java

#### 💻 확인 코드

<!-- code: InheritanceQuiz.java#q1 -->
```java
// 1. 다음 질문에 간단히 답하라.
static void q1() {
    Child c = new Child();
    c.display();
}
```
<!-- /code -->

## 2. 아래의 질문에 O, X 를 하시오.

- (1) 자식 클래스의 생성자가 부모 클래스의 생성자를 명시적으로 호출하지 않으면 부모 클래스의 생성자는 호출되지 않는다. → X 이유 : 자식 클래스의 객체가 생성될 때는 반드시 부모 클래스의 생성자도 함께 호출된다.<br>개발자가 자식 생성자 첫 줄에 super() 를 이용해 부모 생성자를 명시적으로 호출하지 않았더라도, 컴파일러가 자동으로 부모의 기본 생성자(super())를 호출하는 코드를 첫 줄에 삽입해 준다.
  - 📝 필기 : 컴파일러가 자동으로 부모의 기본생성자 super() 을 호출.

- (2) 부모 클래스에서 자식 클래스의 private 필드도 직접 접근 가능하다. → X 이유 : 두 가지 이유에서 완전히 틀린 설명이다.
    1. private 의 특성 : private 으로 선언된 필드는 오직 그 필드가 선언된 클래스 내부에서만 접근할 수 있다.<br>(자식도 부모의 private 에 접근할 수 없고, 부모도 자식의 private 에 접근할 수 없다)
    2. 상속의 방향성 : 자식 클래스는 부모 클래스를 알고 물려받지만, 부모 클래스는 자신을 상속받는 자식 클래스에 어떤 필드나 메서드가 추가되었는지 전혀 알지 못하므로 자식 클래스의 멤버에 접근할 수 없다.
  - 📝 필기 : 상속을 받게 되면 부모 클래스 private 데이터도 물려받는데 임의로 건드릴 수 없음.
  - 📝 필기 : 공개된 메서드를 사용하든지, 부모 생성자에서 호출하는 방향으로 초기화해야 한다.

- (3) 자식 클래스의 생성자가 먼저 호출이 된 후 부모 클래스의 생성자가 호출된다. → X 이유 : 상속 관계에서 객체가 생성될 때는 부모 클래스의 생성자가 먼저 실행(완료)된 후, 자식 클래스의 생성자가 실행된다.<br>(참고 : 자식 클래스가 부모의 멤버를 사용할 수 있으려면, 부모 클래스의 멤버들이 먼저 메모리에 초기화되어 있어야 하기 때문에 "부모 → 자식" 순서로 생성된다)
  - 📝 필기 : 부모가 호출이 되고 자식이 호출이 됨.

- (4) 소멸자는 자식 클래스의 소멸자가 먼저 호출이 되고, 나중에 부모 클래스의 소멸자가 호출된다. → O 이유 : 객체가 소멸될 때(메모리에서 해제될 때)는 생성자의 역순으로 진행된다. 즉 "자식 클래스 소멸자 → 부모 클래스 소멸자"<br>순서로 호출된다. 부모가 먼저 소멸해 버리면 자식 객체가 소멸하는 과정에서 부모의 자원을 참조할 때 문제가 생길 수 있으므로, 자식부터 먼저 정리하고 부모를 나중에 정리한다.
  - 📝 필기 : 자바에서는 소멸자가 없는 형태로 가고 있어서 중복 정답 처리하겠다(고 하셨다). C++ 등에서는 이러하니 알아둘 것.
  - ⚠ 자주 틀리는 부분 : 자바의 finalize() 는 부모 것이 자동으로 불리지 않고, 실행 순서와 실행 여부도 가비지 컬렉터에 따라 달라진다. "자식 → 부모" 는 C++ 소멸자 기준의 설명이다. (1-lecture/code/ConstructorOrderTest.java)

- (5) 추상 메서드를 포함하는 클래스는 반드시 추상 클래스로 선언되어야 한다. → O 이유 : 추상 메서드(몸체 { } 가 없는 미완성 메서드)를 단 하나라도 포함하고 있는 클래스는 미완성 설계도이기 때문에 직접 객체를 생성(인스턴스화)할 수 없다. 따라서 컴파일러는 해당 클래스 앞에 반드시 abstract 키워드를 붙여 추상 클래스로 선언하도록 강제한다. (만약 abstract 를 붙이지 않으면 컴파일 오류가 발생한다)
  - 📝 필기 : 추상 메서드는 abstract 가 붙고 이게 하나라도 존재하면 그 클래스도 추상 클래스 abstract class 로 선언되어야 한다.

- (6) 추상 클래스를 상속할 경우, 자식 클래스도 추상 클래스로 선언하든지 아니면 부모 클래스의 추상 메서드를 재정의해 주면 된다. → O<br>이유 : 추상 클래스를 상속받은 자식 클래스는 부모의 "추상 메서드" 까지 그대로 물려받게 된다.<br>이때 자식 클래스가 선택할 수 있는 방법은 딱 두 가지다.
    1. 물려받은 모든 추상 메서드를 오버라이딩(재정의)하여 몸체({ })를 구현하고 일반 클래스가 되거나,
    2. 구현하지 않은 추상 메서드가 남아 있다면 자식 클래스 자신도 abstract 를 붙여 추상 클래스로 선언해야 한다.

- (7) 인터페이스 안에는 필드는 올 수 없고 추상 메소드만 올 수 있다. → X<br>이유 : 인터페이스 안에는 추상 메서드뿐만 아니라 상수 필드(public static final)가 올 수 있다.<br>또한 Java 8 버전부터는 몸체가 있는 디폴트 메서드(default)와 정적 메서드(static)도 포함할 수 있게 기능이 확장되었다. (아래 8번, 9번 문제가 바로 이 내용을 설명하고 있다)
  - 📝 필기 : 모든 메서드들이 추상 메서드 abstract 인 형태라고 보면 된다. 메소드만 선언하는 게 아니라 필드도 올 수 있지만 일반 필드가 아니라 static 필드만 올 수 있다.

- (8) 인터페이스에는 정적 메소드는 올 수 있다. → O<br>이유 : Java 8 부터 인터페이스 내부에 static(정적) 메서드를 선언하고 구현할 수 있다.<br>이를 통해 인터페이스를 구현한 클래스의 객체 없이도 인터페이스이름.정적메서드() 형태로 편리하게 유틸리티성 메서드를 호출할 수 있다.

- (9) 인터페이스에는 일반 필드는 허용되지 않지만 final 필드는 허용이 된다. 그래서 일반 필드처럼 선언해도 내부적으로 final 로 취급이 되며, 그래서 필드 선언 시 초기화해야 한다. → O 이유 : 인터페이스는 객체를 생성할 수 없으므로 객체마다 가지는 일반 인스턴스 변수(필드)는 선언할 수 없고, 오직 상수(Constant)만 선언할 수 있다. 따라서 인터페이스 내부에 int MAX = 10; 처럼 일반 변수처럼 선언하더라도, 컴파일러가 내부적으로 자동 변환하여 public static final int MAX = 10; 으로 취급한다.<br>final 상수는 값을 변경할 수 없으므로 반드시 선언과 동시에 초기값을 지정해 주어야 한다.

- 💡 (1) (3) 예제 : 1-lecture/code/ConstructorOrderTest.java, ConstructorChainTest.java
  - (5) (6) : 1-lecture/code/AbstractShapeTest.java,  (7) \~ (9) : 1-lecture/code/InterfaceTest.java

#### 💻 확인 코드

<!-- code: InheritanceQuiz.java#q2 -->
```java
// 2. 아래의 질문에 O, X 를 하시오.
static void q2() {
    System.out.println("(1) X  (2) X  (3) X  (4) O  (5) O  (6) O  (7) X  (8) O  (9) O");
}
```
<!-- /code -->

## 3. 다음 물음에 답하라.

- (1) 아래와 같은 필드들을 갖는 Human 클래스를 정의하라.   String name;  int age;
  ```java
  class Human {
      String name;
      int age;
  }
  ``` 설명 : class 키워드를 사용하여 Human 클래스를 선언하고, 이름(name)과 나이(age)를 저장할 멤버 변수(필드)를 선언한다.<br>(보통 캡슐화를 위해 앞에 private 를 붙이기도 하지만, 문제의 지시 그대로 작성했다)
  - 📝 필기 : private String name;  private int age;  처럼 작성 가능하다.

- (2) 아래와 같은 생성자를 작성하여 보라.   Human(String name, int age) { … }
  ```java
  Human(String name, int age) {
      this.name = name;
      this.age = age;
  }
  ``` 설명 : 매개변수의 이름(name, age)이 클래스의 필드 이름과 같기 때문에, 이를 구분하기 위해 객체 자신을 가리키는 참조 변수인 this 를 사용하여 this.필드 = 매개변수; 형태로 초기화한다.
  - 📝 필기 : public Human(String name, int age) 처럼 작성 가능하다.

- (3) 각 필드에 대하여 getter 와 setter 를 작성하라.<br>설명 : Getter(접근자) : 필드의 값을 읽어서 외부로 반환(return)하는 메서드 (get필드명)<br>Setter(설정자) : 외부에서 전달받은 매개변수 값으로 필드의 값을 변경하는 메서드 (set필드명)

- (4) 객체의 현재 상태를 콘솔에 출력하는 print() 을 작성하라.<br>설명 : 현재 객체가 가지고 있는 name 과 age 필드의 값을 콘솔 화면에 보기 좋게 출력하는 메서드

- (5) main() 메서드 안에서 ("개똥", 10), ("소똥", 20), ("말똥", 21) 에 해당하는 객체를 생성한 후, 각 객체에 대해 print() 메서드를 호출하는 코드를 작성하라.<br>설명 : new 연산자와 (2) 번에서 만든 생성자를 이용해 3개의 Human 인스턴스(객체)를 생성하고, 참조 변수(h1, h2, h3)를 통해 각각의 print() 메서드를 호출한다.

- (6) 클래스 Human 을 상속하여서 Student 클래스를 작성하라. 다음과 같은 필드가 추가된다.   String major; 설명 : 자바에서 클래스를 상속받을 때는 extends 키워드를 사용한다. Human 을 상속받았으므로 Student 는 작성하지 않아도 부모의 name 과 age 필드를 물려받게 되며, 여기에 전공(major) 필드만 새로 추가한다.

- (7) 다음과 같은 생성자를 정의하라. 부모 클래스의 생성자를 호출하여 상속받은 필드들을 초기화하도록 한다.
  ```java
  Student(String name, int age, String major) { … }
  Student(String name, int age, String major) {
      super(name, age);   // 부모 클래스(Human)의 생성자 호출
      this.major = major;
  }
  ``` 설명 : super(name, age); 를 생성자의 가장 첫 줄에 작성하여 부모 클래스인 Human 의 생성자를 호출함으로써 물려받은 name 과 age 를 초기화한다. 그다음 자식 클래스 고유의 필드인 major 는 this.major = major; 로 초기화한다.
  - 📝 필기 : super() 로 부모클래스 생성자를 호출해 초기화.

- (8) 각 필드에 대하여 getter 와 setter 를 작성하라.<br>설명 : name 과 age 에 대한 getter / setter 메서드는 이미 부모 클래스인 Human 으로부터 상속받았으므로 다시 작성할 필요가 없다. 따라서 Student 클래스에 새로 추가된 major 필드에 대한 getter 와 setter 만 작성하면 된다.

- (9) 객체의 현재 상태를 콘솔에 출력하는 print() 을 작성하라. 부모의 print() 을 먼저 호출토록 한다.<br>@Override
  ```java
  public void print() {
      super.print();   // 부모 클래스(Human)의 print() 메서드 먼저 호출
      System.out.println("전공: " + major);
  }
  ```<br>설명 : 부모의 print() 메서드를 자식 클래스에 맞게 재정의(Overriding)한다. 이때 앞선 1-(1) 번 문제에서 배웠던 것처럼 super.print(); 를 사용하여 부모의 출력 기능(이름, 나이 출력)을 먼저 실행한 뒤, 자식 클래스의 추가 정보인 전공(major)을 이어서 출력한다.
  - 📝 필기 : super.print() 해야 함에 주의.
  - ⚠ 자주 틀리는 부분 : super. 를 빼고 print(); 만 쓰면 Student 의 print() 가 자기 자신을 다시 부르는 무한 재귀가 된다.<br>(1-lecture/code/MethodOverridingTest.java 의 BadB)

- (10) main() 메서드 안에서 ("순이", 10, "식품"), ("철수", 20, "컴퓨터"), ("바둑이", 21, "철학") 에 해당하는 객체를 생성한 후, 각 객체에 대해 print() 메서드를 호출하는 코드를 작성하라.<br>설명 : 3개의 매개변수를 받는 Student 생성자를 호출하여 객체를 생성하고, 재정의된 print() 메서드를 호출하여 이름, 나이, 전공이 모두 출력되도록 한다.

#### 💻 확인 코드

<!-- code: InheritanceQuiz.java#q3 -->
```java
// 3. 다음 물음에 답하라.
static void q3() {
    System.out.println("---- (5) ----");
    Human h1 = new Human("개똥", 10);
    Human h2 = new Human("소똥", 20);
    Human h3 = new Human("말똥", 21);
    h1.print();
    h2.print();
    h3.print();

    System.out.println("---- (10) ----");
    Student s1 = new Student("순이", 10, "식품");
    Student s2 = new Student("철수", 20, "컴퓨터");
    Student s3 = new Student("바둑이", 21, "철학");
    s1.print();
    s2.print();
    s3.print();
}
```
<!-- /code -->

## 3. (추가) 📝 추가 정리

\[Getter (게터) 완벽 해부]  역할 : 객체 내부의 필드 값을 읽어서 외부로 돌려주는(반환하는) 메서드

```java
// [반환타입] [메서드이름]( [인자 없음] )
public String getName() {
    return name;   // 밖으로 name 값을 던져 줌!
}
```


  1. 왜 인자 ( ) 가 비어 있나요? → 이미 객체 안에 들어 있는 name 을 꺼내서 보여 주기만 하면 되기 때문에, 외부에서 추가로 전달받을 재료(인자)가 필요 없다.
  2. 왜 void 가 아니라 String, int 같은 타입을 쓰나요? → return name; 을 통해 값을 밖으로 돌려줘야 하기 때문이다.<br>돌려주는 값(name)이 문자열(String)이면 반환 타입도 String, 돌려주는 값(age)이 정수(int)면 반환 타입도 int 로 필드의 자료형과 똑같이 맞춰 주어야 한다.

\[Setter (세터) 완벽 해부]  역할 : 외부에서 새로운 값을 받아 와서 객체 내부의 필드 값을 변경(수정)하는 메서드

```java
// [반환값 없음] [메서드이름]( [새로 받을 인자] )
public void setName(String name) {
    this.name = name;   // 받은 인자(name)를 내 필드(this.name)에 덮어쓰기!
}
```


  1. 왜 인자 (String name) 를 받나요? → 이름을 바꾸려면 "무슨 이름으로 바꿀지" 새로운 값을 외부로부터 전달받아야 하기 때문이다.<br>당연히 바꾸려는 필드의 타입과 똑같은 타입의 인자를 받아야 한다.
  2. 왜 반환 타입이 void 인가요? → 프로그래밍에서 void 는 "빈 공간, 아무것도 반환하지 않는다" 는 뜻이다.<br>Setter 는 전달받은 값으로 내 필드 값을 this.name = name; 하고 바꿔치기하면 임무가 끝난다.<br>밖으로 다시 돌려줄(return) 결과물이 없기 때문에 무조건 void 를 쓴다.

\[한눈에 비교하는 공식 표]  예를 들어 클래스 안에 int age; 라는 필드가 있다면

```java
구분              Getter (게터 - 값 읽기)                 Setter (세터 - 값 변경)
이름 규칙         get + 필드명 (첫 글자 대문자) → getAge   set + 필드명 (첫 글자 대문자) → setAge
반환 타입         필드의 데이터 타입과 동일 (int)          무조건 void (반환값 없음)
매개변수(인자)    없음 ()                                  필드와 동일한 타입의 변수 1개 (int age)
메서드 내부 코드  return age; (값을 돌려줌)                this.age = age; (값을 저장함)
완성된 모양       public int getAge() { return age; }      public void setAge(int age) { this.age = age; }
```

**\[main() 에서 실제로 쓸 때 어떻게 다른가요?]**

```java
Human h = new Human("개똥", 10);
// 1. Setter 사용 : 값을 바꿀 때 → 괄호 안에 바꿀 값(25)을 넣어서 호출하기만 하면 끝! (돌려받는 값이 없으므로 void)
h.setAge(25);
// 2. Getter 사용 : 값을 꺼내올 때 → 인자 없이 () 호출하면, 그 자리에 결괏값(25)이 튀어나와서 변수(myAge)에 저장됨!
int myAge = h.getAge();
System.out.println(myAge);   // 25 출력
```


  - 💡 만약 필드의 타입이 참 / 거짓을 나타내는 boolean 일 때(예 : boolean stop;)는 관례상 Getter 의 이름을 get 대신 is 를 붙여서 만든다. (Setter 는 똑같이 set 을 쓴다)
    ```java
    Getter : public boolean isStop() { return stop; }
    Setter : public void setStop(boolean stop) { this.stop = stop; }
    ```

**\[1. 객체 배열 생성 및 초기화]**

```java
Human[] arr = new Human[3];
arr[0] = new Human("개똥", 10);
arr[1] = new Human("소똥", 20);
arr[2] = new Human("말똥", 21);
```


  - Human\[] arr = new Human\[3]; 은 Human 객체를 담을 수 있는 크기가 3인 참조 변수 배열만 생성한 상태다. (초기값 null)
  - 이후 각 인덱스(arr\[0], arr\[1], arr\[2])에 new 연산자로 실제 객체를 생성하여 대입해야 한다.
  - 선언과 동시에 초기화할 경우 아래와 같이 한 줄로 작성할 수 있다.
    ```java
    Human[] arr = { new Human("개똥", 10), new Human("소똥", 20), new Human("말똥", 21) };
    ```

\[2. 배열 순회 반복문 2가지]  두 방식 모두 동작 결과는 동일하다.

  - (1) 향상된 for 문 (for-each 문)
    ```java
    for (Human e : arr) { e.print(); }
    ```
    - 형식 : for (타입 변수명 : 배열명)
    - 동작 : 배열 arr 의 첫 번째 요소부터 마지막 요소까지 순서대로 하나씩 꺼내어 변수 e 에 대입하며 반복한다.<br>인덱스 변수를 따로 선언할 필요가 없어 전체 요소를 단순 출력할 때 주로 사용한다.
  - (2) 일반 for 문
    ```java
    for (int i = 0; i < arr.length; i++) { arr[i].print(); }
    ```
    - 동작 : arr.length 는 배열의 크기(3)를 반환한다. 인덱스 변수 i 가 0 부터 2 까지 증가하며 arr\[0], arr\[1], arr\[2] 에 직접 접근하여 메서드를 호출한다. 특정 인덱스만 다루거나 순서를 제어해야 할 때 사용한다.

**\[3. 문제 (5) 번, (10) 번 적용 코드]**

  - (5) 번 코드 (Human 배열)  : Human\[] arr 에 Human 3개 → 향상된 for 문 또는 일반 for 문으로 e.print()
  - (10) 번 코드 (Student 배열) : Student\[] arr = new Student\[3]; 에 Student 3개 → 같은 방법으로 print()

```java
(참고 : Student 는 Human 의 자식 클래스이므로, (10) 번에서 배열의 타입을 부모 타입인 Human[] arr = new Human[3];
 및 for (Human e : arr) 로 선언하여도 다형성에 의해 Student 의 재정의된 print() 가 정상적으로 호출된다)
```

**\[자바는 동적 바인딩]**

  - 📝 필기 : 자바는 동적 바인딩.

질문 : 그럼 자바는 동적 타입 언어인가? → 아니다. 자바는 대표적인 정적 타입(Statically Typed) 언어다.<br>다만 객체지향의 다형성을 구현할 때 "동적 바인딩(Dynamic Binding)" 을 사용하기 때문에 용어가 비슷해 헷갈릴 수 있다.

  1. 정적 타입 언어로서의 자바 (Static Typing)
    - 개념 : 변수를 선언할 때 자료형(int, String, Human 등)을 명시해야 하며, 컴파일 시점(Compile-time)에 변수의 타입이 결정되고 타입 검사가 이루어진다.
    - 특징 : 한 번 선언된 변수의 타입은 실행 중에 바뀔 수 없으며, 맞지 않는 타입의 값을 대입하면 컴파일 에러가 발생한다.
      ```java
      int age = 10;
      age = "열살";   // 컴파일 에러 발생 (정적 타입 검사)
      ```
    - (참고 : 파이썬(Python)이나 자바스크립트(JavaScript)처럼 변수 선언 시 타입을 적지 않고 실행 시점에 타입이 결정되는 언어가 "동적 타입 언어" 다)
  2. 동적 바인딩 (Dynamic Binding) 과의 차이<br>자바는 정적 타입 언어이지만, 상속 관계에서 메서드를 호출할 때는 동적 바인딩을 사용한다.
    ```java
    Human h = new Student("철수", 20, "컴퓨터");
    h.print();
    ```
    - 정적 타입 결정 (컴파일 시점) : 컴파일러는 참조변수 h 의 타입을 Human 으로 고정하고, Human 클래스에 print() 메서드가 존재하는지만 검사한다.
    - 동적 바인딩 (실행 시점) : 프로그램이 실제로 실행(Runtime)될 때, JVM 이 h 가 가리키는 실제 객체가 Student 임을 확인하고, 부모(Human)가 아닌 자식(Student)이 재정의(Overriding)한 print() 메서드를 연결하여 실행한다.

요약 : 언어의 타입 시스템 → 정적 타입 (컴파일 시점에 변수의 자료형 결정 및 검사)<br>오버라이딩된 메서드 호출 방식 → 동적 바인딩 (실행 시점에 실제 객체의 메서드 연결)

**\[(10) 번을 상위 타입 Human 으로]**

  - 📝 필기 : new Human 으로 작성도 가능.
  - 📝 필기 : 자식 클래스에서 오버라이딩 가능. 부모 기능 그대로 가져다 쓰려면 super.
  - 📝 필기 : 상위 클래스 (변수에) 하위 타입 객체를 저장할 수 있다.
  - 📝 필기 : 실제 돌아갈 때는 상위 타입의 변수에 대해서 상위 타입 메소드를 호출하는 게 아니라 객체가 뭐냐에 따라서 결정.
  1. 핵심 개념 정리
    1. 업캐스팅(Upcasting) : 상위 클래스(Human) 타입의 변수나 배열에 하위 클래스(Student) 타입의 객체를 저장할 수 있다.
    2. 오버라이딩(Overriding) 과 super : 자식 클래스에서 부모의 메서드를 재정의할 수 있으며, 부모 클래스에 구현된 기존 기능을 그대로 가져다 쓰려면 super.메서드() 를 호출한다.
    3. 동적 바인딩(Dynamic Binding) : 실제 프로그램이 실행될 때는 변수의 선언 타입(상위 타입 Human)이 아니라, 그 변수에 실제로 저장된 객체가 무엇인지(Student)에 따라 호출될 메서드가 결정된다.
  2. 개념이 적용된 (10) 번 코드 (Human 배열 사용) : 아래 코드
    ```text
    // 1. 상위 클래스(Human) 타입의 배열 생성
    // 2. 상위 타입 배열에 하위 타입(Student) 객체 저장 (업캐스팅)
    // 3. 변수의 타입은 상위 타입(Human)이지만, 실제 객체가 Student 이므로 Student 에서 오버라이딩한 print() 가 호출됨 (동적 바인딩)
    ```

#### 💻 확인 코드

<!-- code: InheritanceQuiz.java#q3Extra,display,display,Human,getName,setName,getAge,setAge,print,Student,getMajor,setMajor,print -->
```java
// 3. (추가) 📝 추가 정리
static void q3Extra() {
    Human h = new Human("개똥", 10);
    h.setAge(25);                    // Setter : 값을 바꿀 때
    int myAge = h.getAge();          // Getter : 값을 꺼내 올 때
    System.out.println(myAge);       // 25 출력

    System.out.println("---- Human 배열 (향상된 for 문) ----");
    Human[] arr = new Human[3];
    arr[0] = new Human("개똥", 10);
    arr[1] = new Human("소똥", 20);
    arr[2] = new Human("말똥", 21);
    for (Human e : arr) {
        e.print();
    }

    System.out.println("---- Human 배열에 Student 저장 (업캐스팅) ----");
    Human[] arr2 = new Human[3];                    // 1. 상위 클래스(Human) 타입의 배열 생성
    arr2[0] = new Student("순이", 10, "식품");        // 2. 상위 타입 배열에 하위 타입(Student) 객체 저장 (업캐스팅)
    arr2[1] = new Student("철수", 20, "컴퓨터");
    arr2[2] = new Student("바둑이", 21, "철학");
    for (int i = 0; i < arr2.length; i++) {         // 💡 일반 for 문으로도 순회
        arr2[i].print();                            // 3. 실제 객체가 Student → Student 의 print() (동적 바인딩)
    }
}

void display() {
    System.out.println("부모 메서드");
}

void display() {
    System.out.println("부모 메서드");
}

/** 3번 (1) ~ (4) */
class Human {
    String name;
    int age;

    Human(String name, int age) {        // (2) 생성자
        this.name = name;
        this.age = age;
    }

    // (3) name 의 getter 와 setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // (3) age 의 getter 와 setter
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void print() {                // (4)
        System.out.println("이름: " + name + ", 나이: " + age);
    }
}

// (3) name 의 getter 와 setter
public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

// (3) age 의 getter 와 setter
public int getAge() {
    return age;
}

public void setAge(int age) {
    this.age = age;
}

public void print() {                // (4)
    System.out.println("이름: " + name + ", 나이: " + age);
}

/** 3번 (6) ~ (9) */
class Student extends Human {
    String major;                        // (6) 추가된 필드

    Student(String name, int age, String major) {   // (7)
        super(name, age);                // 부모 클래스(Human)의 생성자 호출
        this.major = major;
    }

    // (8) major 의 getter 와 setter (name, age 의 getter / setter 는 Human 에게서 상속)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void print() {                // (9)
        super.print();                   // 부모 클래스(Human)의 print() 메서드 먼저 호출
        System.out.println("전공: " + major);
    }
}

// (8) major 의 getter 와 setter (name, age 의 getter / setter 는 Human 에게서 상속)
public String getMajor() {
    return major;
}

public void setMajor(String major) {
    this.major = major;
}

public void print() {                // (4)
    System.out.println("이름: " + name + ", 나이: " + age);
}
```
<!-- /code -->

## 📎 main 과 문제에 쓰인 클래스

<!-- code: InheritanceQuiz.java#main,Parent,Child,Human,Student -->
```java
public static void main(String[] args) {
    System.out.println("===== 1 =====");
    q1();
    System.out.println("===== 2 =====");
    q2();
    System.out.println("===== 3 =====");
    q3();
    System.out.println("===== 3 (추가) =====");
    q3Extra();
}

/** 1번 (1) : super.메서드이름() 으로 재정의된 부모 메서드 호출 */
class Parent {
    void display() {
        System.out.println("부모 메서드");
    }
}

class Child extends Parent {
    @Override
    void display() {
        super.display();   // 부모 클래스의 display() 호출
        System.out.println("자식 메서드");
    }
}

/** 3번 (1) ~ (4) */
class Human {
    String name;
    int age;

    Human(String name, int age) {        // (2) 생성자
        this.name = name;
        this.age = age;
    }

    // (3) name 의 getter 와 setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // (3) age 의 getter 와 setter
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void print() {                // (4)
        System.out.println("이름: " + name + ", 나이: " + age);
    }
}

/** 3번 (6) ~ (9) */
class Student extends Human {
    String major;                        // (6) 추가된 필드

    Student(String name, int age, String major) {   // (7)
        super(name, age);                // 부모 클래스(Human)의 생성자 호출
        this.major = major;
    }

    // (8) major 의 getter 와 setter (name, age 의 getter / setter 는 Human 에게서 상속)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void print() {                // (9)
        super.print();                   // 부모 클래스(Human)의 print() 메서드 먼저 호출
        System.out.println("전공: " + major);
    }
}
```
<!-- /code -->

---

[🏠 10주차 학습 가이드](../README.md)
