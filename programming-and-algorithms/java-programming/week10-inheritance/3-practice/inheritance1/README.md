# 10주차 실습 · inheritance1

[🏠 10주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [AnimalSoundTest.java](#1-animal--cat-makesound-재정의-참고-답안) | 1. 💡 Animal / Cat: `makeSound()` 재정의 (참고 답안) |
| [ShapeAreaTest.java](#2-shape--rectangle-getarea-재정의) | 2. Shape / Rectangle: `getArea()` 재정의 (📝 Main을 단서로 단계별 설계) |
| [SavingsAccountTest.java](#3-bankaccount--savingsaccount-최소-잔액-100) | 3. BankAccount / SavingsAccount: 최소 잔액 100 (📝 `super`의 두 가지 역할) |
| [EmployeeNameTest.java](#4-person--employee-getlastname에-직함-붙이기) | 4. Person / Employee: `getLastName()`에 직함 붙이기 |
| [VehicleTest.java](#5-vehicle--truck--car--motorcycle-연비--최대-속도-참고-답안) | 5. 💡 Vehicle / Truck / Car / Motorcycle: 연비 · 최대 속도 (참고 답안) |

---

## 1. Animal / Cat: `makeSound()` 재정의 (참고 답안)

`10강 실습` · 📄 [`AnimalSoundTest.java`](AnimalSoundTest.java)

#### 문제

> makeSound() 라는 메소드를 갖는 Animal 이라는 클래스를 정의하라. 이 메소드는 "The animal makes a sound." 를 출력한다.<br>또한 makeSound() 메서드를 재정의한 Cat 이라는 하위 클래스도 정의하라. Cat 클래스의 makeSound() 는 "The cat quarrels." 을 출력한다.
>
> ```java
> // Main.java
> public class Main {
>     public static void main(String[] args) {
>         Animal animal = new Animal();
>         Cat cat = new Cat();
>         animal.makeSound();
>         cat.makeSound();
>     }
> }
> ```

#### 💻 코드

<!-- code: AnimalSoundTest.java -->
```java
public class AnimalSoundTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();
        animal.makeSound();
        cat.makeSound();
    }
}

class Animal {
    public void makeSound() {
        System.out.println("The animal makes a sound.");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The cat quarrels.");
    }
}
```
<!-- /code -->

#### 실행 결과

```text
The animal makes a sound.
The cat quarrels.
```

**포인트**

- class Cat extends Animal : Animal 을 상속
- 부모와 똑같은 형태(이름, 매개변수, 반환형)의 makeSound() 를 다시 정의하면 재정의(overriding)
- animal.makeSound() 는 Animal 의 것, cat.makeSound() 는 Cat 이 재정의한 것이 실행된다.

- 💡 풀이 코드가 남아 있지 않아 문제의 main 과 실행 결과에 맞게 작성한 참고 답안이다.
- 💡 @Override 는 없어도 동작은 같지만, 메소드 이름을 makesound 처럼 잘못 쓰면 컴파일러가 오류로 알려 준다.
- 💡 원래 이클립스에서 Main 클래스로 작성하는 문제. 문제에 맞게 AnimalSoundTest 로 이름을 바꿨다.

## 2. Shape / Rectangle: `getArea()` 재정의

`10강 실습` · 📄 [`ShapeAreaTest.java`](ShapeAreaTest.java)

#### 문제

> getArea() 라는 메소드를 갖는 Shape 라는 클래스를 정의하라.<br>직사각형의 면적을 계산하기 위해 getArea() 메서드를 재정의한 Rectangle 이라는 하위 클래스를 정의하라.
>
> ```java
> // Main class
> public class Main {
>     public static void main(String[] args) {
>         Rectangle rectangle = new Rectangle(3.0, 10.0);
>         double area = rectangle.getArea();
>         System.out.println("The area of the rectangle is: " + area);
>     }
> }
> ```

#### 💻 코드

<!-- code: ShapeAreaTest.java -->
```java
public class ShapeAreaTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3.0, 10.0);
        double area = rectangle.getArea();
        System.out.println("The area of the rectangle is: " + area);
    }
}

class Shape {
    public double getArea() {
        return 0.0;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    // 생성자 : 클래스 이름과 동일해야 하며, 매개변수로 double 2개를 받음
    public Rectangle(double length, double width) {
        this.length = length;   // 전달받은 3.0 을 클래스 변수 length 에 저장
        this.width = width;     // 전달받은 10.0 을 클래스 변수 width 에 저장
    }

    @Override
    public double getArea() {
        return length * width;  // 3.0 * 10.0 = 30.0 반환
    }
}
```
<!-- /code -->

#### 실행 결과

```text
The area of the rectangle is: 30.0
```

#### 📒 해설

- 📝 필기 : 단계별 상세 설명 - 문제에 이미 작성되어 있는 Main 클래스를 단서로 삼아 필요한 요소를 하나씩 만든다.

**① Shape 클래스 만들기 (상위 클래스)**

    - 문제 조건 : "getArea() 라는 메소드를 갖는 Shape 라는 클래스를 정의하라."
    - 반환 타입 파악하기 : Main 클래스를 보면 double area = rectangle.getArea(); 라고 되어 있다.<br>즉, getArea() 메소드가 실행된 결괏값은 실수형(double)이어야 한다.
    - 내용 작성하기 : 그냥 "도형(Shape)" 이라는 개념만으로는 어떤 도형인지 알 수 없어 면적을 계산할 수 없다.<br>따라서 기본값으로 0.0 을 반환하도록 작성한다.

**② Rectangle 클래스와 상속 설정하기 (하위 클래스)**

    - 문제 조건 : "Shape 의 하위 클래스 Rectangle 을 정의하라."
    - 자바에서 하위 클래스가 상위 클래스를 물려받을(상속받을) 때는 extends 라는 키워드를 사용한다.

**③ Rectangle 의 변수(필드)와 생성자 만들기**

    - 단서 확인 : Main 클래스에 Rectangle rectangle = new Rectangle(3.0, 10.0); 이라는 코드가 있다.
    - 의미 : Rectangle 객체를 만들 때 소괄호 안에 실수(double) 2개(3.0, 10.0)를 넣어 주고 있다.<br>이는 직사각형의 가로와 세로 길이를 의미한다.
    - 구현 : 이 두 값을 저장할 변수(length, width)를 클래스 안에 만들고, 객체가 생성될 때 값을 전달받아 저장하는 생성자(Constructor)를 만들어야 한다.<br>(※ this. 는 매개변수 이름과 클래스의 변수 이름이 같을 때, 클래스 자신의 변수임을 구분해 주기 위해 사용한다)

**④ getArea() 메소드 재정의(Overriding)하기**

    - 문제 조건 : "직사각형의 면적을 계산하기 위해 getArea() 메서드를 재정의한..."
    - 메소드 재정의(오버라이딩)란? 부모 클래스(Shape)로부터 물려받은 메소드의 내용을 자식 클래스(Rectangle)의 상황에 맞게 고쳐 쓰는 것이다.
    - 부모 클래스의 getArea() 는 0.0 을 반환하지만, 직사각형에서는 가로 x 세로의 값을 반환하도록 내용을 바꿔 준다.
    - 메소드 위에 @Override 라고 적어 주면, 컴파일러가 "아, 부모의 메소드를 똑같은 이름으로 잘 고쳐 썼구나" 라고 확인해 준다. (실수 방지용)

- 💡 이 Shape 의 getArea() 처럼 "부모에서는 내용을 정할 수 없는 메소드" 를 0.0 대신 아예 비워 두는 방법이 추상 메소드다. (10-2, 3-practice/inheritance2)
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 ShapeAreaTest 로 이름을 바꿨다.

## 3. BankAccount / SavingsAccount: 최소 잔액 100

`10강 실습` · 📄 [`SavingsAccountTest.java`](SavingsAccountTest.java)

#### 문제

> deposit() 과 withdraw() 라는 메서드를 사용하여 "BankAccount" 라는 클래스를 정의하라.<br>계좌 잔액이 100 미만으로 떨어지는 경우 인출을 방지하기 위해 withdraw() 메서드를 재정의하는 SavingsAccount 라는 하위 클래스도 정의하라.<br>(main 은 문제에 주어진 코드 그대로 아래에 있다)

#### 💻 코드

<!-- code: SavingsAccountTest.java -->
```java
public class SavingsAccountTest {
    public static void main(String[] args) {
        System.out.println("Create a Bank Account object (A/c No. BA1234) with initial balance of $500:");
        BankAccount BA1234 = new BankAccount("BA1234", 500);

        System.out.println("Deposit $1000 into account BA1234:");
        BA1234.deposit(1000);
        System.out.println("New balance after depositing $1000: $" + BA1234.getBalance());

        System.out.println("Withdraw $600 from account BA1234:");
        BA1234.withdraw(600);
        System.out.println("New balance after withdrawing $600: $" + BA1234.getBalance());

        System.out.println("\nCreate a SavingsAccount object (A/c No. SA1234) with initial balance of $450:");
        SavingsAccount SA1234 = new SavingsAccount("SA1234", 450);

        SA1234.withdraw(300);
        System.out.println("Balance after trying to withdraw $300: $" + SA1234.getBalance());

        System.out.println("\nCreate a SavingsAccount object (A/c No. SA1000) with initial balance of $300:");
        SavingsAccount SA1000 = new SavingsAccount("SA1000", 300);

        System.out.println("Try to withdraw $250 from SA1000!");
        SA1000.withdraw(250);
        System.out.println("Balance after trying to withdraw $250: $" + SA1000.getBalance());
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount < 100) {
            System.out.println("Minimum balance of $100 required!");
        } else {
            super.withdraw(amount);
        }
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Create a Bank Account object (A/c No. BA1234) with initial balance of $500:
Deposit $1000 into account BA1234:
New balance after depositing $1000: $1500.0
Withdraw $600 from account BA1234:
New balance after withdrawing $600: $900.0

Create a SavingsAccount object (A/c No. SA1234) with initial balance of $450:
Balance after trying to withdraw $300: $150.0

Create a SavingsAccount object (A/c No. SA1000) with initial balance of $300:
Try to withdraw $250 from SA1000!
Minimum balance of $100 required!
Balance after trying to withdraw $250: $300.0
```

#### 📒 해설

- 📝 필기 : ① BankAccount 클래스 설계하기 (부모 클래스)
1. 변수(필드)와 생성자 찾기
    - Main 코드를 보면 new BankAccount("BA1234", 500); 이라고 객체를 생성한다.
    - 첫 번째 값은 문자열("BA1234")이므로 String accountNumber, 두 번째 값은 숫자(500)인데 출력 결과를 보면 $1500.0, $900.0 처럼 소수점이 찍혀 나온다. 따라서 잔액 변수는 실수형인 double balance 로 선언해야 한다.
2. deposit() 과 withdraw() 메소드 만들기
    - BA1234.deposit(1000); : 입금 기능이다. 반환값 없이(void) 전달받은 금액을 기존 balance 에 더해 준다. (balance += amount;)
    - BA1234.withdraw(600); : 출금 기능이다. 전달받은 금액을 기존 balance 에서 빼 준다. (balance -= amount;)
3. 숨겨진 메소드 getBalance() 찾기
    - 문제 설명에는 없지만 Main 클래스의 출력문을 보면 BA1234.getBalance() 를 호출하여 잔액을 확인하고 있다.
    - 따라서 현재 잔액(balance)을 반환하는 public double getBalance() 메소드를 반드시 만들어야 에러가 나지 않는다.
- 📝 필기 : ② SavingsAccount 클래스 설계하기 (자식 클래스)
1. 상속과 생성자 연결 (super)
    - class SavingsAccount extends BankAccount 로 상속을 받는다.
    - 자식 클래스가 생성될 때 받은 "SA1234" 와 450 이라는 값을 부모 클래스에 있는 변수에 저장해야 한다.<br>이때 super(accountNumber, balance); 를 사용하면 부모 클래스(BankAccount)의 생성자를 호출하여 깔끔하게 값을 전달할 수 있다.
2. withdraw() 메소드 재정의(오버라이딩)하기
    - 문제 조건 : "계좌 잔액이 100 미만으로 떨어지는 경우 인출을 방지하라."
    - 숨겨진 출력문 찾기 : 첫 번째 이미지의 맨 아래 출력 결과를 보면, SA1000 계좌(잔액 300)에서 250 을 인출하려고 할 때 Minimum balance of $100 required! 라는 문구가 출력되지만, Main 클래스에는 이 문구를 출력하는 코드가 없다.<br>즉, 이 문구는 재정의된 withdraw() 메소드 안에서 출력되어야 한다!
    - 조건식 작성
      - 현재 잔액 - 출금할 금액 &lt; 100 인 경우 (예 : 300 - 250 = 50 &lt; 100) : 출금을 하지 않고 경고 메시지만 출력한다.
      - 그렇지 않고 100 이상이 남는 경우 (예 : 450 - 300 = 150 >= 100) : 정상적으로 돈을 빼야 하므로, 부모 클래스에 이미 만들어 둔 출금 기능을 그대로 가져다 쓴다. 이때 super.withdraw(amount); 를 호출하면 된다.
- 📝 필기 : 3. 핵심 문법 정리 - super 의 두 가지 역할
1. super(매개변수); → 부모 클래스의 생성자를 호출한다. 부모 클래스가 가진 변수(accountNumber, balance)를 초기화할 때 사용한다.
2. super.메소드이름(); → 부모 클래스의 메소드를 호출한다. 자식 클래스에서 메소드를 재정의(오버라이딩)했더라도, 특정 조건에서는 부모의 원래 기능을 그대로 쓰고 싶을 때 super.withdraw(amount); 처럼 사용한다.

- ⚠ 자주 틀리는 부분 : balance 는 BankAccount 의 private 필드라서 SavingsAccount 에서 balance 로 직접 쓸 수 없다.<br>그래서 getBalance() 로 읽고, 실제 출금은 super.withdraw(amount) 에게 맡긴다.<br>(balance -= amount; 라고 쓰면 error: balance has private access in BankAccount)
- 💡 문제 문장의 "deposi()" 는 deposit() 의 오타다. main 에서 deposit(1000) 으로 부른다.
- 💡 이클립스는 accountNumber 필드에 "값을 쓰기만 하고 읽지 않는다" 는 노란 경고(The value of the field is not used)를 표시한다.<br>getAccountNumber() 같은 getter 를 만들면 사라진다. 실행에는 문제가 없다.
- 💡 System.out.println("\\nCreate ...") 의 \\n 때문에 출력 사이에 빈 줄이 생긴다. (이클립스 한글 폰트에서는 \\ 가 ₩ 로 보임)
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 SavingsAccountTest 로 이름을 바꿨다.

## 4. Person / Employee: `getLastName()`에 직함 붙이기

`10강 실습` · 📄 [`EmployeeNameTest.java`](EmployeeNameTest.java)

#### 문제

> getFirstName() 및 getLastName() 메소드를 사용하여 Person 이라는 클래스를 정의하라.<br>getEmployeeId() 라는 새 메서드와 getLastName() 메서드를 재정의한 Employee 라는 하위 클래스도 정의하라.<br>Employee 클래스의 getLastName() 메서드는 잡 타이틀(직함)도 같이 반환한다.
>
> ```java
> // Main class
> public class Main {
>     public static void main(String[] args) {
>         Employee employee1 = new Employee("Kortney", "Rosalee", 4451, "HR Manager");
>         System.out.println(employee1.getFirstName() + " " + employee1.getLastName() + " (" + employee1.getEmployeeId() + ")");
>         Employee employee2 = new Employee("Junior", "Philipa", 4452, "Software Manager");
>         System.out.println(employee2.getFirstName() + " " + employee2.getLastName() + " (" + employee2.getEmployeeId() + ")");
>     }
> }
> ```

#### 💻 코드

<!-- code: EmployeeNameTest.java -->
```java
public class EmployeeNameTest {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Kortney", "Rosalee", 4451, "HR Manager");
        System.out.println(employee1.getFirstName() + " " + employee1.getLastName() + " (" + employee1.getEmployeeId() + ")");

        Employee employee2 = new Employee("Junior", "Philipa", 4452, "Software Manager");
        System.out.println(employee2.getFirstName() + " " + employee2.getLastName() + " (" + employee2.getEmployeeId() + ")");
    }
}

class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

class Employee extends Person {
    private int employeeId;
    private String jobTitle;

    public Employee(String firstName, String lastName, int employeeId, String jobTitle) {
        super(firstName, lastName);
        this.employeeId = employeeId;
        this.jobTitle = jobTitle;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public String getLastName() {
        return super.getLastName() + ", " + jobTitle;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Kortney Rosalee, HR Manager (4451)
Junior Philipa, Software Manager (4452)
```

**포인트**

- Employee 생성자는 이름 두 개를 super(firstName, lastName) 으로 부모에게 넘기고, 자기 필드(employeeId, jobTitle)만 초기화한다.
- 재정의한 getLastName() 은 super.getLastName() 으로 부모의 성(lastName)을 받아 뒤에 ", " + jobTitle 을 붙인다.<br>"Rosalee" + ", " + "HR Manager"  →  "Rosalee, HR Manager"
- getEmployeeId() 는 부모에 없는 새 메서드다. (재정의가 아니라 추가)

- ⚠ 자주 틀리는 부분 : getLastName() 안에서 super. 없이 getLastName() 을 부르면 자기 자신을 다시 부르는 무한 재귀가 된다.<br>lastName 은 Person 의 private 필드라서 Employee 에서 직접 쓸 수도 없다. → super.getLastName()
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 EmployeeNameTest 로 이름을 바꿨다.

## 5. Vehicle / Truck / Car / Motorcycle: 연비 · 최대 속도 (참고 답안)

`10강 실습` · 📄 [`VehicleTest.java`](VehicleTest.java)

#### 문제

> 차량 관련 클래스들을 정의하라. 기본 클래스는 Vehicle 이며 하위 클래스는 Truck, Car 및 Motorcycle 이다.<br>Vehicle 클래스에는 제조업체, 모델, 연도, 연료 유형, 연비와 같은 속성이 있다.<br>연비, 이동 거리, 최대 속도를 계산하는 메서드들도 있으며 이들의 구현은 하위 클래스에 따라 달라진다.
>
> ```java
> // Main class
> public class Main {
>     public static void main(String[] args) {
>         // Create instances of each vehicle type
>         Truck truck = new Truck("Tatra", "Tatra 810 4x4", 2020, "GASOLINE", 8.112, 4.5);
>         Car car = new Car("Volkswagen", "Virtus", 2019, "HYBRID", 6.123, 8);
>         Motorcycle motorcycle = new Motorcycle("Massimo Motor", "Warrior200", 2018, "GASOLINE", 2.1, 0.0);
>
>         // Print the vehicle details and calculations
>         System.out.println("Truck Model: " + truck.getModel());
>         System.out.println("Fuel Efficiency: " + truck.calculateFuelEfficiency() + " mpg");
>         System.out.println("Max Speed: " + truck.getMaxSpeed() + " mph\n");
>         ... (Car, Motorcycle 도 같은 형식)
>     }
> }
> ```

#### 💻 코드

<!-- code: VehicleTest.java -->
```java
public class VehicleTest {
    public static void main(String[] args) {
        // Create instances of each vehicle type
        Truck truck = new Truck("Tatra", "Tatra 810 4x4", 2020, "GASOLINE", 8.112, 4.5);
        Car car = new Car("Volkswagen", "Virtus", 2019, "HYBRID", 6.123, 8);
        Motorcycle motorcycle = new Motorcycle("Massimo Motor", "Warrior200", 2018, "GASOLINE", 2.1, 0.0);

        // Print the vehicle details and calculations
        System.out.println("Truck Model: " + truck.getModel());
        System.out.println("Fuel Efficiency: " + truck.calculateFuelEfficiency() + " mpg");
        System.out.println("Max Speed: " + truck.getMaxSpeed() + " mph\n");

        System.out.println("Car Model: " + car.getModel());
        System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency() + " mpg");
        System.out.println("Max Speed: " + car.getMaxSpeed() + " mph\n");

        System.out.println("Motorcycle Model: " + motorcycle.getModel());
        System.out.println("Fuel Efficiency: " + motorcycle.calculateFuelEfficiency() + " mpg");
        System.out.println("Max Speed: " + motorcycle.getMaxSpeed() + " mph");
    }
}

class Vehicle {
    private String make;             // 제조업체
    private String model;            // 모델
    private int year;                // 연도
    private String fuelType;         // 연료 유형
    private double fuelEfficiency;   // (기본) 연비

    public Vehicle(String make, String model, int year, String fuelType, double fuelEfficiency) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.fuelEfficiency = fuelEfficiency;
    }

    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getFuelType() { return fuelType; }
    public double getFuelEfficiency() { return fuelEfficiency; }

    // 하위 클래스에서 재정의할 메서드들 (기본 동작)
    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }

    public double calculateDistanceTraveled() {
        return calculateFuelEfficiency() * 10;   // 연료 10 갤런으로 갈 수 있는 거리
    }

    public double getMaxSpeed() {
        return 0.0;
    }
}

class Truck extends Vehicle {
    private double cargoCapacity;    // 적재량 (톤)

    public Truck(String make, String model, int year, String fuelType, double fuelEfficiency, double cargoCapacity) {
        super(make, model, year, fuelType, fuelEfficiency);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateFuelEfficiency() {
        return getFuelEfficiency() / (1.0 + cargoCapacity / 1000.0);   // 짐이 많을수록 연비가 떨어짐
    }

    @Override
    public double getMaxSpeed() {
        return 80.0;
    }
}

class Car extends Vehicle {
    private int numSeats;            // 좌석 수

    public Car(String make, String model, int year, String fuelType, double fuelEfficiency, int numSeats) {
        super(make, model, year, fuelType, fuelEfficiency);
        this.numSeats = numSeats;
    }

    @Override
    public double calculateFuelEfficiency() {
        return getFuelEfficiency() / (1.0 + numSeats / 5.0);           // 좌석이 많을수록(차가 클수록) 연비가 떨어짐
    }

    @Override
    public double getMaxSpeed() {
        return 120.0;
    }
}

class Motorcycle extends Vehicle {
    private double sidecarWeight;    // 사이드카 무게

    public Motorcycle(String make, String model, int year, String fuelType, double fuelEfficiency, double sidecarWeight) {
        super(make, model, year, fuelType, fuelEfficiency);
        this.sidecarWeight = sidecarWeight;
    }

    @Override
    public double calculateFuelEfficiency() {
        return getFuelEfficiency() / (1.0 + sidecarWeight / 100.0);    // 사이드카가 없으면(0.0) 기본 연비 그대로
    }

    @Override
    public double getMaxSpeed() {
        return 80.0;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Truck Model: Tatra 810 4x4
Fuel Efficiency: 8.075659532105526 mpg
Max Speed: 80.0 mph

Car Model: Virtus
Fuel Efficiency: 2.355 mpg
Max Speed: 120.0 mph

Motorcycle Model: Warrior200
Fuel Efficiency: 2.1 mpg
Max Speed: 80.0 mph
```

#### 📒 해설

- 💡 풀이 코드가 남아 있지 않아 문제의 main 과 실행 결과에 맞게 작성한 참고 답안이다.<br>생성자의 마지막 인수가 무엇인지는 문제에 나와 있지 않아서, 실행 결과의 연비가 나오도록 정했다.
  ```text
  Truck      : 마지막 인수 = 적재량(톤) 4.5      → 연비 = 8.112 / (1 + 4.5 / 1000) = 8.075659532105526
  Car        : 마지막 인수 = 좌석 수 8          → 연비 = 6.123 / (1 + 8 / 5.0)    = 2.355
  Motorcycle : 마지막 인수 = 사이드카 무게 0.0   → 연비 = 2.1 (무게가 0 이면 그대로)
  ``` 연비(fuelEfficiency)는 "기본 연비", calculateFuelEfficiency() 는 하위 클래스마다 조건을 반영한 "실제 연비" 다.

**포인트**

- 공통 속성(make, model, year, fuelType, fuelEfficiency)과 getter 는 Vehicle 에 한 번만 둔다.
- "구현은 하위 클래스에 따라 달라진다" → calculateFuelEfficiency(), calculateDistanceTraveled(), getMaxSpeed() 를 Vehicle 에서는 기본 동작만 정하고, 각 하위 클래스가 재정의한다.
- 하위 클래스의 생성자는 super(make, model, year, fuelType, fuelEfficiency) 로 공통 속성을 부모에게 넘긴다.

- 💡 Vehicle 의 메서드는 "차량마다 다르므로 부모에서는 정할 수 없다". 이런 메서드는 다음 차시의 추상 메서드로 만드는 것이 더 알맞다. (abstract class Vehicle { abstract double getMaxSpeed(); ... } → 3-practice/inheritance2)
- 💡 이동 거리(calculateDistanceTraveled)는 main 에서 쓰지 않지만 문제의 "이동 거리 계산" 조건 때문에 만들었다.<br>(실제 연비 x 연료량. 여기서는 연료 10 갤런 기준)
- 💡 원래 이클립스에서 Main 클래스로 작성하는 문제. 문제에 맞게 VehicleTest 로 이름을 바꿨다.

---

[🏠 10주차 학습 가이드](../../README.md)
