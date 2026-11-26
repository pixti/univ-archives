# 10주차 실습 · inheritance2

[🏠 10주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [AnimalAbstractTest.java](#1-추상-animal--lion--tiger) | 1. 추상 Animal / Lion / Tiger (📝 추상화 · 상속 · 오버라이딩 · 다형성) |
| [EmployeeSalaryTest.java](#2-추상-employee--manager--programmer-급여-계산) | 2. 추상 Employee / Manager / Programmer: 급여 계산 (📝 추상 클래스의 필드와 생성자) |
| [VehicleEngineTest.java](#3-추상-vehicle--car--motorcycle-추상-메소드-2개) | 3. 추상 Vehicle / Car / Motorcycle: 추상 메소드 2개 (📝 추상 메소드에 `private`를 못 쓰는 이유) |
| [BirdTest.java](#4-추상-bird--eagle--hawk) | 4. 추상 Bird / Eagle / Hawk (📝 접근 제어자 정리) |

---

## 1. 추상 Animal / Lion / Tiger

`10강 실습` · 📄 [`AnimalAbstractTest.java`](AnimalAbstractTest.java)

#### 문제

> sound() 라는 추상 메소드를 사용하여 Animal 추상 클래스를 정의하는 Java 프로그램을 작성하라.<br>Animal 클래스를 상속받아 각 동물에 대해 특정 소리를 내는 sound() 메서드를 구현하는 하위 클래스 Lion 및 Tiger 를 작성하라.
>
> ```java
> // Main
> public class Main {
>     public static void main(String[] args) {
>         Animal lion = new Lion();
>         lion.sound();   // Output: Lion roars!
>
>         Animal tiger = new Tiger();
>         tiger.sound();  // Output: Tiger growls!
>     }
> }
> ```

#### 💻 코드

<!-- code: AnimalAbstractTest.java -->
```java
public class AnimalAbstractTest {
    public static void main(String[] args) {
        Animal lion = new Lion();
        lion.sound();

        Animal tiger = new Tiger();
        tiger.sound();
    }
}

abstract class Animal {
    public abstract void sound();
}

class Lion extends Animal {
    @Override
    public void sound() {
        System.out.println("Lion roars!");
    }
}

class Tiger extends Animal {
    @Override
    public void sound() {
        System.out.println("Tiger growls!");
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Lion roars!
Tiger growls!
```

#### 📒 해설

- 📝 필기 : 이 프로그램에는 객체 지향 프로그래밍(OOP)의 가장 핵심적인 4가지 개념(추상화, 상속, 오버라이딩, 다형성)이 모두 들어 있다.
1. 추상 클래스(Abstract Class)와 추상 메소드(Abstract Method)
  ```java
  abstract class Animal { public abstract void sound(); }
  ```
    - 개념 : "동물(Animal)" 이라는 개념은 추상적이다. 세상에는 사자, 호랑이, 강아지 같은 구체적인 동물이 존재하지, 그냥 "동물" 그 자체인 생명체는 없다. 또한 모든 동물은 소리를 내지만(sound), 어떤 동물인지 정해지지 않으면 무슨 소리를 내는지 구체적으로 적을 수 없다. 이럴 때 사용하는 것이 추상 클래스와 추상 메소드다.
    - abstract 키워드 : 클래스나 메소드 앞에 붙여서 "이것은 미완성 설계도입니다" 라고 알려 주는 역할을 한다.
    - 특징
      1. 직접 객체를 만들 수 없다 : 미완성 설계도이기 때문에 new Animal() 처럼 직접 생성할 수 없다.
      2. 중괄호 { } 가 없다 : public abstract void sound(); 를 보면 실행 내용을 적는 { } 없이 세미콜론(;)으로 바로 끝난다.<br>"소리를 내는 기능은 무조건 있어야 해! 하지만 구체적인 소리는 나를 상속받는 클래스가 직접 채워 넣어!" 라고 강제(규칙 부여)하는 것이다.
2. 상속 (Inheritance)
  ```java
  class Lion extends Animal { ... }   class Tiger extends Animal { ... }
  ```
    - 개념 : 부모 클래스(Animal)가 가진 특징(변수나 메소드)을 자식 클래스(Lion, Tiger)가 물려받는 것이다.
    - extends 키워드 : "확장하다" 라는 뜻으로, Animal 이라는 기본 틀을 가져와서 Lion 이라는 구체적인 클래스로 확장하겠다는 의미다.
    - 장점 : 공통적인 특징을 부모 클래스에 한 번만 정의해 두면, 여러 자식 클래스에서 코드를 중복해서 작성할 필요가 없어진다.
3. 메소드 오버라이딩 (Method Overriding, 재정의)
    - 개념 : 부모 클래스에게 물려받은 메소드를 자식 클래스의 상황에 맞게 내용을 고쳐서(혹은 채워서) 다시 정의하는 것이다.
    - 의무 사항 : 자식 클래스가 추상 클래스(Animal)를 상속받으면, 부모의 미완성 메소드(sound())를 반드시 완성(오버라이딩)해야 한다.<br>만약 sound() 를 구현하지 않으면 컴파일 에러가 발생한다.
    - @Override 어노테이션 : 컴퓨터(컴파일러)에게 "이 메소드는 부모 클래스의 메소드를 재정의한 것이니, 이름이나 형태가 틀리지 않았는지 검사해 줘!" 라고 알려 주는 안전장치다. (생략해도 동작하지만, 실수를 막기 위해 적어 주는 것이 좋다)
4. 다형성 (Polymorphism) 과 업캐스팅 (Upcasting)
  ```java
  Animal lion = new Lion();   lion.sound();
  Animal tiger = new Tiger();  tiger.sound();
  ```<br>메인 메소드에서 가장 중요하게 봐야 할 부분이다. Lion lion = new Lion(); 이라고 하지 않고, 왜 앞쪽 타입을 Animal 로 적었을까?
    - 업캐스팅(Upcasting) : 자식 클래스의 객체(new Lion())를 부모 클래스 타입의 변수(Animal lion)에 담는 것을 말한다.<br>"사자는 동물이다(Lion is an Animal)" 가 성립하기 때문에 가능한 문법이다.
    - 다형성(Polymorphism) : "다양한 형태를 가질 수 있는 성질" 을 뜻한다.
      - 코드 상으로는 똑같이 Animal 타입의 변수에 대고 .sound() 를 호출했다. (lion.sound(), tiger.sound())
      - 하지만 실행해 보면 변수에 실제로 담겨 있는 객체가 무엇인지(사자인지 호랑이인지)에 따라 전혀 다른 실행 결과가 나온다.
    - 이점 : 나중에 코끼리(Elephant), 강아지(Dog) 등 수백 마리의 동물이 추가되어도, Animal 이라는 하나의 공통된 타입으로 묶어서 일괄적으로 관리하고 명령을 내릴 수 있어 프로그램 유지보수가 매우 편리해진다.

- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 AnimalAbstractTest 로 이름을 바꿨다.

## 2. 추상 Employee / Manager / Programmer: 급여 계산

`10강 실습` · 📄 [`EmployeeSalaryTest.java`](EmployeeSalaryTest.java)

#### 문제

> 추상 메서드 calculateSalary() 및 displayInfo() 를 갖는 Employee 추상 클래스를 작성하라.<br>Employee 클래스를 확장하고 급여를 계산하고 각 역할에 대한 정보를 표시하는 해당 메서드를 구현하는 하위 클래스 Manager 및 Programmer 를 작성하라.
>
> ```java
> // Main
> public class Main {
>     public static void main(String[] args) {
>         Employee manager = new Manager("Corona Cadogan", 6000, 1000);
>         Employee programmer = new Programmer("Antal Nuka", 5000, 20, 25.0);
>
>         manager.displayInfo();
>         System.out.println("---------------------");
>         programmer.displayInfo();
>     }
> }
> ```

#### 💻 코드

<!-- code: EmployeeSalaryTest.java -->
```java
public class EmployeeSalaryTest {
    public static void main(String[] args) {
        Employee manager = new Manager("Corona Cadogan", 6000, 1000);
        Employee programmer = new Programmer("Antal Nuka", 5000, 20, 25.0);

        manager.displayInfo();
        System.out.println("---------------------");
        programmer.displayInfo();
    }
}

abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();
    public abstract void displayInfo();
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void displayInfo() {
        System.out.println("Manager Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Bonus: $" + bonus);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

class Programmer extends Employee {
    private int overtimeHours;
    private double hourlyRate;

    public Programmer(String name, double baseSalary, int overtimeHours, double hourlyRate) {
        super(name, baseSalary);
        this.overtimeHours = overtimeHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (overtimeHours * hourlyRate);
    }

    @Override
    public void displayInfo() {
        System.out.println("Programmer Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Overtime Hours: " + overtimeHours);
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Manager Name: Corona Cadogan
Base Salary: $6000.0
Bonus: $1000.0
Total Salary: $7000.0
---------------------
Programmer Name: Antal Nuka
Base Salary: $5000.0
Overtime Hours: 20
Hourly Rate: $25.0
Total Salary: $5500.0
```

#### 📒 해설

- 📝 필기 : 이전 문제들과 달리 이번 문제에서는 추상 클래스 내부에 공통 변수(필드)와 생성자가 포함되며, 추상 메소드가 결괏값을 반환(return)하는 구조로 작성되었다.

**① 추상 클래스의 필드와 생성자 (Employee)**

    - 공통 필드의 추출과 protected 접근 제어자
      - 매니저와 프로그래머 모두 "이름(name)" 과 "기본급(baseSalary)" 을 공통으로 가진다.<br>코드 중복을 피하기 위해 이를 부모 클래스인 Employee 에 선언했다.
      - 접근 제어자를 protected 로 설정하여 외부 클래스에서는 직접 접근하지 못하게 보호하면서도, 상속받은 자식 클래스(Manager, Programmer) 내부에서는 자유롭게 사용할 수 있도록 했다.
      - main() 에서 기본급으로 정수 6000, 5000 을 전달하지만, 실행 결과에서는 6000.0, 5000.0 처럼 실수로 출력되므로 변수의 타입은 double 로 선언했다. (정수가 double 매개변수로 전달될 때 자동으로 실수형으로 형변환된다)
    - 추상 클래스에 생성자가 존재하는 이유
      - 추상 클래스는 new Employee() 처럼 직접 객체를 생성할 수 없지만, 생성자는 정의할 수 있다.
      - 이 생성자는 자식 클래스의 객체가 생성될 때 호출되어, 부모 클래스로부터 물려받은 공통 필드(name, baseSalary)를 초기화하는 역할을 수행한다.
- ② super() 를 통한 부모 생성자 호출과 고유 필드 초기화 (Manager, Programmer)
    - 자식 클래스의 고유 필드
      - Manager 는 보너스(bonus)가 추가로 필요하고, Programmer 는 초과 근무 시간(overtimeHours)과 시급(hourlyRate)이 추가로 필요하다. 각 클래스에만 필요한 데이터이므로 해당 하위 클래스 내부에 private 필드로 선언했다.
    - super(...) 키워드
      - 자식 클래스의 생성자 첫 줄에서 super(name, baseSalary); 를 호출하면 부모 클래스(Employee)의 생성자가 먼저 실행되어 name 과 baseSalary 가 초기화된다.
      - 그다음 줄에서 this.bonus = bonus; 를 통해 자식 클래스 자신의 고유 필드를 초기화한다.

**③ 반환값이 있는 추상 메소드와 내부 메소드 호출**

    - calculateSalary() 의 구현
      - 직군마다 급여 계산 방식이 다르므로 Employee 에서는 public abstract double calculateSalary(); 로 선언만 해 두었다.<br>반환 타입이 double 이므로 하위 클래스에서 오버라이딩할 때도 계산된 급여를 double 타입으로 반환(return)해야 한다.
      - Manager 는 기본급 + 보너스를 반환하고, Programmer 는 기본급 + (초과근무시간 x 시급)을 반환한다.
    - displayInfo() 에서의 활용
      - main() 메소드를 보면 calculateSalary() 를 직접 호출하지 않고 displayInfo() 만 호출하고 있다.
      - 따라서 displayInfo() 메소드 내부의 마지막 출력문에서 같은 클래스 내에 정의된 calculateSalary() 를 호출하여 총 급여(Total Salary)를 계산하고 그 결괏값을 화면에 출력하도록 구성했다.

- 💡 Programmer : 5000 + 20 x 25.0 = 5000 + 500.0 = 5500.0
- 💡 protected 와 private 를 어디에 왜 썼는지는 BirdTest.java 의 📝 필기(접근 제어자 정리) 3절에 이어서 정리했다.
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 EmployeeSalaryTest 로 이름을 바꿨다.

## 3. 추상 Vehicle / Car / Motorcycle: 추상 메소드 2개

`10강 실습` · 📄 [`VehicleEngineTest.java`](VehicleEngineTest.java)

#### 문제

> 추상 메소드 startEngine() 및 stopEngine() 을 갖는 추상 클래스 Vehicle 을 작성하라.<br>Vehicle 클래스를 상속하고 각 차량 유형에 대해 엔진을 시작하고 중지하는 해당 메서드를 구현하는 Car 및 Motorcycle 하위 클래스를 작성하라.
>
> ```java
> // Main
> public class Main {
>     public static void main(String[] args) {
>         Vehicle car = new Car();
>         Vehicle motorcycle = new Motorcycle();
>
>         car.startEngine();
>         car.stopEngine();
>
>         motorcycle.startEngine();
>         motorcycle.stopEngine();
>     }
> }
> ```

#### 💻 코드

<!-- code: VehicleEngineTest.java -->
```java
public class VehicleEngineTest {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();

        car.startEngine();
        car.stopEngine();

        motorcycle.startEngine();
        motorcycle.stopEngine();
    }
}

abstract class Vehicle {
    public abstract void startEngine();
    public abstract void stopEngine();
}

class Car extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car: Starting the engine...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car: Stopping the engine...");
    }
}

class Motorcycle extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Motorcycle: Starting the engine...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Motorcycle: Stopping the engine...");
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Car: Starting the engine...
Car: Stopping the engine...
Motorcycle: Starting the engine...
Motorcycle: Stopping the engine...
```

#### 📒 해설

- 📝 필기 : 이번 문제는 이전의 Animal 문제와 기본 구조는 같지만, 추상 메소드가 2개로 늘어났다는 점이 핵심이다.

**① 다중 추상 메소드를 가진 추상 클래스 (Vehicle)**

    - 개념 (설계도 역할) : Vehicle(탈것 / 차량)이라는 추상 클래스를 만들면서, "모든 차량은 반드시 엔진을 켜는 기능(startEngine)과 엔진을 끄는 기능(stopEngine) 두 가지를 모두 가지고 있어야 한다!" 라고 표준 규격을 정한 것이다.
    - 자동차든 오토바이든 시동을 걸고 끄는 내부 원리는 다를 수 있지만, 운전자 입장에서는 "시동 켜기", "시동 끄기" 라는 공통된 동작으로 제어할 수 있도록 틀(껍데기)만 미리 만들어 둔 것이다.

**② 상속과 모든 추상 메소드의 구현 의무 (Car, Motorcycle)**

    - 구현의 강제성 (매우 중요) : 자식 클래스(Car, Motorcycle)가 추상 클래스(Vehicle)를 extends 로 상속받으면, 부모 클래스에 있는 모든 추상 메소드를 빠짐없이 오버라이딩(재정의)해야 한다.
    - 만약 Car 클래스에서 startEngine() 만 만들고 stopEngine() 을 만들지 않으면, 자바 컴파일러는 "아직 미완성된 기능이 남아 있어!" 라며 에러를 발생시킨다. (만약 하나라도 구현하기 싫다면 자식 클래스도 abstract 를 붙여 추상 클래스가 되어야 한다)
    - 이렇게 함으로써 개발자가 실수로 필수 기능(예 : 시동 끄기 기능)을 빼먹고 코드를 작성하는 것을 원천적으로 방지할 수 있다.

**③ 업캐스팅과 동적 바인딩 (Main 클래스)**

    - 업캐스팅(Upcasting) : Car 객체와 Motorcycle 객체를 생성해서 부모 타입인 Vehicle 변수에 담았다.<br>둘 다 "탈것(Vehicle)" 의 일종이므로 하나의 공통 타입으로 다룰 수 있다.
    - 동적 바인딩(Dynamic Binding) : car 변수의 타입은 Vehicle 이지만, car.startEngine() 을 실행할 때 자바는 Vehicle 의 빈 껍데기 메소드가 아니라, 실제 메모리에 생성된 객체인 Car 클래스의 오버라이딩된 startEngine() 을 찾아가서 실행한다.
    - 덕분에 똑같은 모양의 코드(.startEngine())를 호출해도 car 는 "Car: Starting..." 을, motorcycle 은 "Motorcycle: Starting..." 을 정확하게 출력하게 된다. 이것이 객체 지향의 꽃이라 불리는 다형성(Polymorphism)의 동작 원리다.

- 📝 필기 (질문) : 추상 메소드에 private 를 쓸 수 있나? 왜 주로 public 으로 선언하나?<br>결론부터 말하면 추상 메소드에는 절대 private 을 사용할 수 없으며(문법 에러 발생), 보통 외부에서 호출해야 하는 기능이기 때문에 public 을 주로 사용한다.
1. 왜 private 은 절대 안 될까? (모순 발생)<br>자바에서 두 키워드의 의미를 생각해 보면 왜 같이 쓸 수 없는지 바로 이해가 된다.
    - abstract (추상) : "나는 빈 껍데기야. 나를 상속받는 자식 클래스가 이 메소드를 물려받아서 내용을 완성(오버라이딩)해 줘!"
    - private (비공개) : "이 메소드는 오직 이 클래스 내에서만 볼 수 있어! 아무리 자식 클래스(Car)라도 절대 볼 수 없고 접근할 수도 없어!"

만약 private abstract void startEngine(); 이라고 적으면, 부모 클래스가 자식 클래스에게 "이 메소드를 반드시 완성해라!<br>하지만 너한테는 안 보여 줄 거고 접근도 못 하게 할 거야!" 라고 말하는 셈이 된다. 자식 클래스 입장에서는 부모에게 그런 메소드가 있는지조차 보이지 않으니 오버라이딩을 할 수가 없다.<br>이렇게 두 키워드의 목적이 정반대로 충돌하기 때문에, 자바에서는 private 과 abstract 를 같이 쓰면 즉시 컴파일 에러가 발생한다.

```text
error: illegal combination of modifiers: abstract and private
```


2. 왜 주로 public 으로 선언할까?
    - "외부에 공개되어 사용되어야 하는 기능" 이기 때문이다.
    - 자동차의 startEngine() (시동 버튼)이나 동물의 sound() (울음소리)는 외부(예 : Main 클래스의 운전자)에서 호출해서 쓰라고 만든 기능이다.
    - 어디서든 제한 없이 이 기능들을 호출할 수 있도록 가장 개방적인 접근 제어자인 public 을 붙이는 것이 일반적이다.
3. 그럼 무조건 public 만 써야 하나요? (심화 개념)<br>꼭 public 만 되는 것은 아니다. private 만 아니면 된다! 자바에는 4가지 접근 제어자가 있는데, 추상 메소드에는 다음 3가지를 쓸 수 있다.
      1. public : 모든 곳에서 접근 가능 (가장 흔하게 사용)
      2. protected : 같은 폴더(패키지) 안에 있거나, 다른 폴더에 있더라도 상속받은 자식 클래스라면 접근 가능
      3. (아무것도 안 적음, default) : 같은 폴더(패키지) 안에서만 접근 가능

실제로 이 문제의 코드에서 public 을 지우고 그냥 abstract void startEngine(); 이라고만 적어도 코드는 정상 작동한다.<br>(모두 한 파일 / 같은 폴더에 있기 때문)

    - ⚠ 단, 주의할 규칙 하나! 자식 클래스가 오버라이딩할 때는 부모의 접근 범위보다 좁게 만들 수 없다.
      - 부모(Vehicle)에서 public abstract void startEngine(); 이라고 public 으로 선언했다면,
      - 자식(Car)에서도 반드시 public void startEngine() 으로 구현해야 한다. (자식이 마음대로 public 을 빼 버리거나 protected 로 바꿀 수 없다)

요약하자면 : 추상 메소드는 자식에게 물려주어야 하므로 private 은 절대 불가능하고, 외부에서 두루두루 호출할 수 있는 표준 규격(버튼) 역할을 하기 때문에 public 을 사용하는 것이다!

- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 VehicleEngineTest 로 이름을 바꿨다.

## 4. 추상 Bird / Eagle / Hawk

`10강 실습` · 📄 [`BirdTest.java`](BirdTest.java)

#### 문제

> 추상 메소드 fly() 및 makeSound() 를 갖는 추상 클래스 Bird 를 작성하라.<br>Bird 클래스를 상속하고 각 새가 날아다니고 소리를 내는 방법을 설명하는 각각의 메서드를 구현하는 하위 클래스 Eagle 및 Hawk 를 작성하라.
>
> ```java
> // Main
> public class Main {
>     public static void main(String[] args) {
>         Bird eagle = new Eagle();
>         Bird hawk = new Hawk();
>
>         eagle.fly();
>         eagle.makeSound();
>
>         hawk.fly();
>         hawk.makeSound();
>     }
> }
> ```

#### 💻 코드

<!-- code: BirdTest.java -->
```java
public class BirdTest {
    public static void main(String[] args) {
        Bird eagle = new Eagle();
        Bird hawk = new Hawk();

        eagle.fly();
        eagle.makeSound();

        hawk.fly();
        hawk.makeSound();
    }
}

abstract class Bird {
    public abstract void fly();
    public abstract void makeSound();
}

class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("Eagle: Flying high in the sky.");
    }

    @Override
    public void makeSound() {
        System.out.println("Eagle: Screech! Screech!");
    }
}

class Hawk extends Bird {
    @Override
    public void fly() {
        System.out.println("Hawk: Soaring through the air.");
    }

    @Override
    public void makeSound() {
        System.out.println("Hawk: Caw! Caw!");
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Eagle: Flying high in the sky.
Eagle: Screech! Screech!
Hawk: Soaring through the air.
Hawk: Caw! Caw!
```

**📝 필기**

1. 추상 클래스와 추상 메소드 정의 (Bird)
    - 추상화 (Abstraction)
      - 독수리(Eagle)와 매(Hawk)의 공통 상위 개념인 "새(Bird)" 를 정의한 클래스다.
      - 모든 새는 날 수 있고(fly) 소리를 낼 수 있지만(makeSound), 구체적으로 어떤 새인지 정해지지 않은 상태에서는 동작을 정의할 수 없으므로 미완성 상태인 추상 클래스로 만든다.
    - 문법적 특징
      - abstract class : 클래스 선언부에 abstract 가 붙으면 해당 클래스는 직접 인스턴스를 생성(new Bird())할 수 없다.<br>오직 상속을 통해 부모 클래스로서의 역할만 수행한다.
      - public abstract void ...(); : 메소드 선언부에 abstract 가 붙으면 실행 블록인 중괄호({ })를 작성하지 않고 세미콜론(;)으로 끝낸다. 반환 타입(void), 메소드 이름, 매개변수(())만 정의하여 하위 클래스가 따라야 할 메소드의 형태(시그니처)를 지정한다.
2. 상속과 메소드 오버라이딩 (Eagle, Hawk)  (Hawk 클래스도 동일한 구조이므로 Eagle 을 기준으로 설명)
    - 상속 (extends)
      - class Eagle extends Bird 는 Eagle 클래스가 Bird 클래스의 멤버(필드와 메소드)를 물려받는다는 의미다.
      - Bird 는 추상 클래스이므로, 이를 상속받은 Eagle 은 부모가 미완성으로 남겨 둔 추상 메소드들을 모두 완성해야만 일반 클래스로서 객체를 생성할 수 있다.
    - 메소드 오버라이딩 (Method Overriding)
      - 상위 클래스에 선언된 추상 메소드의 구현부({ })를 하위 클래스에서 구체적으로 작성하는 과정이다.
      - 오버라이딩 성립 조건 : 부모 클래스의 메소드와 이름(fly, makeSound), 매개변수(()), 반환 타입(void)이 완전히 일치해야 한다. 또한 접근 제어자(public)는 부모 클래스의 것보다 좁은 범위로 변경할 수 없다.
      - 구현의 강제성 : Bird 에 2개의 추상 메소드가 있으므로, 하위 클래스는 2개를 모두 오버라이딩해야 한다.<br>하나라도 누락하면 컴파일 에러가 발생한다.
      - @Override 어노테이션 : 컴파일러에게 이 메소드가 부모의 메소드를 재정의한 것임을 알리는 표식이다.<br>만약 메소드 이름을 flyy() 처럼 오타를 내면, 컴파일러가 부모 클래스에 해당 메소드가 없다는 것을 감지하여 에러를 알려 준다.
3. 다형성과 동적 바인딩 (Main)
    - 업캐스팅 (Upcasting)
      - Bird eagle = new Eagle(); 에서 등호(=)의 오른쪽은 실제로 메모리에 생성되는 인스턴스(new Eagle())이고, 왼쪽은 그 인스턴스를 가리키는 참조 변수(Bird eagle)이다.
      - 하위 클래스의 인스턴스를 상위 클래스 타입의 참조 변수에 대입하는 것을 업캐스팅이라고 한다.<br>하위 클래스는 상위 클래스의 모든 규격을 포함하고 있으므로 별도의 형변환 기호 없이 자동으로 허용된다.
    - 참조 변수의 역할과 한계
      - eagle 변수의 타입이 Bird 이기 때문에, 이 변수를 통해 호출할 수 있는 메소드는 Bird 클래스에 정의된 fly() 와 makeSound() 로 제한된다. (만약 Eagle 클래스에만 별도로 추가된 고유 메소드가 있다면 Bird 타입 변수로는 호출할 수 없다)
    - 동적 바인딩 (Dynamic Binding) 과 다형성 (Polymorphism)
      - eagle.fly(); 를 실행할 때, 컴파일 시점에는 컴파일러가 Bird 클래스에 fly() 메소드가 존재하는지만 확인한다.
      - 이후 프로그램이 실제로 실행되는 시점(런타임)에는 자바 가상 머신(JVM)이 참조 변수 eagle 이 실제로 가리키고 있는 메모리상의 객체(Eagle 인스턴스)를 확인하고, Bird 의 추상 메소드가 아닌 Eagle 클래스에 오버라이딩된 fly() 메소드를 연결하여 실행한다. 이를 동적 바인딩이라고 한다.
      - 결과적으로 동일한 Bird 타입의 참조 변수로 동일한 메소드(fly(), makeSound())를 호출하더라도, 참조 변수가 가리키는 실제 인스턴스가 Eagle 인지 Hawk 인지에 따라 서로 다른 동작이 수행된다. 이것이 다형성의 핵심 원리다.

- 📝 필기 : 접근 제어자 정리
1. 접근 제어자란 무엇인가?<br>접근 제어자는 클래스, 필드(변수), 생성자, 메소드 앞에 붙여서 외부로부터의 접근 허용 범위를 지정하는 키워드다.
    - 사용 목적 (캡슐화와 정보 은닉) : 객체 내부의 중요한 데이터(예 : 급여, 비밀번호 등)가 외부에서 잘못된 값으로 직접 수정되는 것을 막고, 설계자가 허용한 경로(메소드 등)를 통해서만 안전하게 접근하도록 통제하기 위해 사용한다.
2. 4가지 접근 제어자의 종류와 허용 범위  (접근 범위가 가장 좁은 것부터 넓은 순서)<br>(※ 패키지(Package)란 자바 파일들을 묶어 놓은 "폴더" 라고 이해하면 된다)
  ```java
  접근 제어자   같은 클래스 내부   같은 패키지(폴더)   다른 패키지의 자식 클래스   그 외 모든 영역
  private           O                  X                   X                          X
  (default)         O                  O                   X                          X
  protected         O                  O                   O                          X
  public            O                  O                   O                          O
  ```
    - ① private (비공개)
      - 범위 : 오직 해당 멤버가 선언된 자기 자신의 클래스 내부에서만 접근할 수 있다.
      - 특징 : 외부 클래스는 물론, 나를 상속받은 자식 클래스조차 직접 접근할 수 없다. 클래스 내부의 데이터를 가장 안전하게 보호할 때 사용한다.
    - ② (default) (기본 / 패키지 전용)
      - 범위 : 키워드를 아무것도 적지 않았을 때 자동으로 적용되며, 같은 패키지(폴더) 안에 있는 클래스들끼리만 접근할 수 있다.
      - 특징 : 다른 폴더에 있는 클래스에서는 상속을 받았더라도 접근할 수 없다.
    - ③ protected (상속 허용)
      - 범위 : 같은 패키지 안에서는 모두 접근 가능하고, 다른 패키지에 있더라도 상속받은 자식 클래스 내부라면 접근을 허용한다.
      - 특징 : 부모 클래스가 자신의 필드나 메소드를 외부에는 숨기되, 자식 클래스에게는 물려주어 자유롭게 쓰게 하고 싶을 때 사용한다.
    - ④ public (완전 공개)
      - 범위 : 패키지 위치나 상속 여부와 관계없이 프로그램 내의 모든 곳에서 접근할 수 있다.
      - 특징 : 외부에서 객체를 생성하거나 기능을 호출해야 하는 통로(생성자, 주요 메소드 등)에 주로 사용한다.
3. 이전 문제(Employee) 코드에 적용된 이유 분석  (EmployeeSalaryTest.java)
  ```java
  abstract class Employee {
      protected String name;          // (1) 왜 protected 인가?
      protected double baseSalary;
      public Employee(...) { ... }    // (2) 왜 public 인가?
      public abstract void displayInfo();
  }
  class Manager extends Employee {
      private double bonus;           // (3) 왜 private 인가?
  }
  ```
    1. 부모 클래스(Employee)의 변수에 protected 를 쓴 이유
      - name 과 baseSalary 는 자식 클래스인 Manager 와 Programmer 의 displayInfo() 나 calculateSalary() 메소드 안에서 직접 가져다 써야 한다.
      - 만약 이를 private 으로 선언하면 자식 클래스에서 return baseSalary + bonus; 라고 적었을 때 "부모의 private 변수에 접근할 수 없다" 는 컴파일 에러가 발생한다.
      - 따라서 외부의 임의 접근은 막으면서 자식 클래스에게는 접근을 허용하는 protected 를 사용한 것이다.
      - (참고 : 만약 부모 변수를 private 으로 선언하고 싶다면, 부모 클래스에 public double getBaseSalary() { return baseSalary; } 같은 조회용 메소드(Getter)를 추가로 만들어 자식에게 제공해야 한다)
    2. 자식 클래스(Manager)의 변수에 private 를 쓴 이유
      - bonus 변수는 Manager 클래스 내부의 계산과 출력에서만 사용되며, 외부(Main 등)나 다른 클래스에서 이 변수에 직접 접근할 일이 없다. 또한 Manager 를 다시 상속받는 하위 클래스도 없으므로 가장 엄격한 private 으로 감추는 것이 안전하다.
    3. 생성자와 추상 메소드에 public 을 쓴 이유
      - 생성자(Manager(...))와 출력 메소드(displayInfo())는 외부 클래스인 Main 에서 직접 호출해서 사용해야 하는 대상이므로, 어디서든 접근할 수 있도록 public 으로 열어 두어야 한다.
4. 접근 제어자 사용 시 주의할 문법 규칙
    1. 클래스 자체에 붙일 수 있는 제어자 : 일반 클래스 앞에는 public 과 (default) 두 가지만 붙일 수 있다. 또한 하나의 .java 파일 안에는 파일 이름과 동일한 이름의 클래스에만 public 을 붙일 수 있다. (예 : Main.java 파일 안에서는 public class Main 만 가능하고, Employee 등은 (default) 로 작성)
    2. private 과 abstract 는 함께 쓸 수 없음 : 추상 메소드는 자식이 물려받아 구현해야 하는데 private 으로 막으면 자식이 볼 수 없으므로 문법적으로 금지된다.
    3. 오버라이딩 시 접근 범위 축소 불가 : 부모 클래스에서 protected 로 선언한 메소드를 자식이 오버라이딩할 때는 protected 나 더 넓은 public 만 사용할 수 있으며, 더 좁은 (default) 나 private 으로는 변경할 수 없다. 부모에서 public 이었다면 자식도 무조건 public 이어야 한다.

- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 BirdTest 로 이름을 바꿨다.

---

[🏠 10주차 학습 가이드](../../README.md)
