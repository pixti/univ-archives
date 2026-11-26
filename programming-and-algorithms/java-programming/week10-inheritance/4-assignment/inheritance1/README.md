# 10주차 과제 · inheritance1

[🏠 10주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [VehicleRepairTest.java](#1-vehicle--car-drive-재정의) | 1. Vehicle / Car: `drive()` 재정의 |
| [HRManagerTest.java](#2-employee--hrmanager-work-재정의--addemployee-추가) | 2. Employee / HRManager: `work()` 재정의 + `addEmployee()` 추가 (💡 `Employee2`로 이름 변경) |
| [CheetahTest.java](#3-animal--cheetah-move-재정의) | 3. Animal / Cheetah: `move()` 재정의 |
| [CircleShapeTest.java](#4-shape--circle-둘레와-넓이-mathpi) | 4. Shape / Circle: 둘레와 넓이 (`Math.PI`) |
| [EmployeeHierarchyTest.java](#5-employee--manager--developer--programmer-보너스-성과-보고서) | 5. Employee / Manager / Developer / Programmer: 보너스, 성과 보고서 |

---

## 1. Vehicle / Car: `drive()` 재정의

`10강 과제` · 📄 [`VehicleRepairTest.java`](VehicleRepairTest.java)

#### 문제

> drive() 라는 메소드를 갖는 Vehicle 이라는 클래스를 작성하라. 이 메소드는 "Repairing a vehicle" 을 출력한다.<br>그리고 drive() 메서드를 재정의하는 Car 라는 하위 클래스도 작성하라.<br>이 메서드는 "Repairing a car" 를 출력토록 부모 클래스의 drive() 메서드를 재정의한다. main 은 다음과 같다.
>
> ```java
> public class Main {
>     public static void main(String[] args) {
>         Vehicle vehicle = new Vehicle();
>         Car car = new Car();
>         vehicle.drive();   // Output: Repairing a vehicle
>         car.drive();       // Output: Repairing a car
>     }
> }
> ```

#### 💻 코드

<!-- code: VehicleRepairTest.java -->
```java
public class VehicleRepairTest {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Car car = new Car();
        vehicle.drive();
        car.drive();
    }
}

class Vehicle {
    public void drive() {
        System.out.println("Repairing a vehicle");
    }
}

class Car extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Repairing a car");
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Repairing a vehicle
Repairing a car
```

**포인트**

- class Car extends Vehicle 로 상속하고, drive() 를 똑같은 형태로 다시 정의(재정의)한다.
- vehicle.drive() 는 Vehicle 의 것, car.drive() 는 Car 가 재정의한 것이 실행된다.

- 💡 메서드 이름은 drive 인데 출력은 "Repairing ..." 이다. 문제에 주어진 대로 작성했다.
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 VehicleRepairTest 로 이름을 바꿨다.

## 2. Employee / HRManager: `work()` 재정의 + `addEmployee()` 추가

`10강 과제` · 📄 [`HRManagerTest.java`](HRManagerTest.java)

#### 문제

> work() 및 getSalary() 라는 메서드를 갖는 Employee 라는 클래스를 작성하라.<br>그리고 work() 메서드가 재정의되고 addEmployee() 라는 새 메서드를 갖는 HRManager 라는 하위 클래스도 작성하라.<br>main 은 다음과 같다.
>
> ```java
> // Main class
> public class Main {
>     public static void main(String[] args) {
>         Employee emp = new Employee(40000);
>         HRManager mgr = new HRManager(70000);
>
>         emp.work();
>         System.out.println("Employee salary: " + emp.getSalary());
>
>         mgr.work();
>         System.out.println("Manager salary: " + mgr.getSalary());
>         mgr.addEmployee();
>     }
> }
> ```

#### 💻 코드

<!-- code: HRManagerTest.java -->
```java
public class HRManagerTest {
    public static void main(String[] args) {
        Employee2 emp = new Employee2(40000);
        HRManager mgr = new HRManager(70000);

        emp.work();
        System.out.println("Employee salary: " + emp.getSalary());

        mgr.work();
        System.out.println("Manager salary: " + mgr.getSalary());
        mgr.addEmployee();
    }
}

class Employee2 {                        // 문제에서는 Employee
    private int salary;

    public Employee2(int salary) {
        this.salary = salary;
    }

    public void work() {
        System.out.println("working as an employee!");
    }

    public int getSalary() {
        return salary;
    }
}

class HRManager extends Employee2 {
    public HRManager(int salary) {
        super(salary);
    }

    @Override
    public void work() {
        System.out.println("Managing employees");
    }

    public void addEmployee() {
        System.out.println("Adding new employee!");
    }
}
```
<!-- /code -->

#### 실행 결과

```text
working as an employee!
Employee salary: 40000
Managing employees
Manager salary: 70000
Adding new employee!
```

**포인트**

- salary 는 Employee 의 private 필드다. HRManager 생성자는 super(salary) 로 부모 생성자에게 값을 넘긴다.
- getSalary() 는 재정의하지 않았으므로 mgr.getSalary() 는 물려받은 Employee 의 것이 실행된다.
- work() 는 재정의, addEmployee() 는 HRManager 에만 있는 새 메서드다.<br>→ Employee 타입 변수로는 addEmployee() 를 부를 수 없다. (Employee e = mgr; e.addEmployee(); → ❌ cannot find symbol)

- ⚠ 문제의 실행 결과에는 "Employee salary: 40000" 과 "Managing employees" 사이 등에 빈 줄이 있지만, main 코드에는 빈 줄을 출력하는 문장이 없다. 실제 실행 결과는 아래처럼 빈 줄 없이 나온다.
- 💡 같은 폴더의 5번 문제(EmployeeHierarchyTest.java)에도 Employee 클래스가 있어서 IntelliJ 에서 함께 빌드하면 중복 오류가 난다.<br>그래서 이 파일의 Employee 를 Employee2 로 바꿨다. (문제와 처음 작성한 코드에서는 Employee)
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 HRManagerTest 로 이름을 바꿨다.

## 3. Animal / Cheetah: `move()` 재정의

`10강 과제` · 📄 [`CheetahTest.java`](CheetahTest.java)

#### 문제

> move() 라는 메소드를 갖는 Animal 이라는 클래스를 작성하라. move() 메서드를 재정의하는 Cheetah 라는 하위 클래스도 정의하라.<br>main 은 다음과 같다.
>
> ```java
> // Main class
> public class Main {
>     public static void main(String[] args) {
>         Animal animal = new Animal();
>         animal.move();
>         Cheetah cheetah = new Cheetah();
>         cheetah.move();
>     }
> }
> ```

#### 💻 코드

<!-- code: CheetahTest.java -->
```java
public class CheetahTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.move();

        Cheetah cheetah = new Cheetah();
        cheetah.move();
    }
}

class Animal {
    public void move() {
        System.out.println("Animal moves");
    }
}

class Cheetah extends Animal {
    @Override
    public void move() {
        System.out.println("This cheetah is running!");
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Animal moves
This cheetah is running!
```

**포인트**

- Cheetah 는 Animal 을 상속(extends)하고 move() 를 재정의한다.

- 💡 Animal animal = new Cheetah(); 로 바꿔도 animal.move() 는 "This cheetah is running!" 을 출력한다.<br>실제 객체가 Cheetah 이기 때문이다. (동적 바인딩, 10-3)
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 CheetahTest 로 이름을 바꿨다.

## 4. Shape / Circle: 둘레와 넓이 (`Math.PI`)

`10강 과제` · 📄 [`CircleShapeTest.java`](CircleShapeTest.java)

#### 문제

> getPerimeter() 및 getArea() 라는 메서드를 갖는 Shape 라는 클래스를 작성하라.<br>원의 면적과 둘레를 계산하기 위해 getPerimeter() 및 getArea() 메서드를 재정의하는 Circle 이라는 하위 클래스도 작성하라.<br>main 은 다음과 같다.
>
> ```java
> // Main class
> public class Main {
>     public static void main(String[] args) {
>         double r = 8.0;
>         Circle c1 = new Circle(r);
>         System.out.println("Radius of the circle=" + r);
>         System.out.println("Perimeter: " + c1.getPerimeter());
>         System.out.println("Area: " + c1.getArea());
>         r = 3.2;
>         Circle c2 = new Circle(r);
>         System.out.println("\nRadius of the circle=" + r);
>         System.out.println("Perimeter: " + c2.getPerimeter());
>         System.out.println("Area: " + c2.getArea());
>     }
> }
> ```

#### 💻 코드

<!-- code: CircleShapeTest.java -->
```java
public class CircleShapeTest {
    public static void main(String[] args) {
        double r = 8.0;
        Circle c1 = new Circle(r);
        System.out.println("Radius of the circle=" + r);
        System.out.println("Perimeter: " + c1.getPerimeter());
        System.out.println("Area: " + c1.getArea());

        r = 3.2;
        Circle c2 = new Circle(r);
        System.out.println("\nRadius of the circle=" + r);
        System.out.println("Perimeter: " + c2.getPerimeter());
        System.out.println("Area: " + c2.getArea());
    }
}

class Shape {
    public double getPerimeter() {
        return 0.0;
    }

    public double getArea() {
        return 0.0;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Radius of the circle=8.0
Perimeter: 50.26548245743669
Area: 201.06192982974676

Radius of the circle=3.2
Perimeter: 20.106192982974676
Area: 32.169908772759484
```

**포인트**

- 원의 둘레 = 2 x π x r,  원의 넓이 = π x r x r   (π 는 Math.PI)
- Shape 에서는 어떤 도형인지 모르므로 0.0 을 돌려주고, Circle 에서 재정의한다.

- 💡 r = 3.2 로 바꾼 뒤 new Circle(r) 을 하면 c2 의 radius 에는 3.2 가 복사된다. c1 의 radius(8.0)는 그대로다.<br>(기본형 값은 매개변수로 넘길 때 복사된다)
- 💡 둘레, 넓이가 50.26548245743669 처럼 길게 나오는 것은 double 값을 그대로 출력했기 때문이다.<br>소수점 둘째 자리까지만 보려면 String.format("%.2f", c1.getArea()) 를 쓴다. (문제의 실행 결과는 그대로 출력)
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 CircleShapeTest 로 이름을 바꿨다.

## 5. Employee / Manager / Developer / Programmer: 보너스, 성과 보고서

`10강 과제` · 📄 [`EmployeeHierarchyTest.java`](EmployeeHierarchyTest.java)

#### 문제

> 회사 직원을 위한 클래스 계층 구조를 생성하는 Java 프로그램을 작성하라. 기본 클래스는 Employee 이며 하위 클래스는 Manager, Developer 및 Programmer 이다. 각 하위 클래스에는 이름, 주소, 급여, 직위 등의 속성이 있고, 보너스 계산, 성과 보고서 생성 및 프로젝트 관리 방법을 갖는다. main 은 다음과 같다.
>
> ```java
> //Main.class
> public class Main {
>     public static void main(String[] args) {
>         Manager manager = new Manager("Avril Aroldo", "1 ABC St", 80000.0, "Manager", 5);
>         Developer developer = new Developer("Iver Dipali", "2 PQR St", 72000.0, "Developer", "Java");
>         Programmer programmer = new Programmer("Yaron Gabriel", "3 ABC St", 76000.0, "Python");
>
>         System.out.println("Manager's Bonus: $" + manager.calculateBonus());
>         System.out.println("Developer's Bonus: $" + developer.calculateBonus());
>         System.out.println("Programmer's Bonus: $" + programmer.calculateBonus());
>
>         System.out.println(manager.generatePerformanceReport());
>         System.out.println(developer.generatePerformanceReport());
>         System.out.println(programmer.generatePerformanceReport());
>
>         manager.manageProject();
>         developer.writeCode();
>         programmer.debugCode();
>     }
> }
> ```

#### 💻 코드

<!-- code: EmployeeHierarchyTest.java -->
```java
public class EmployeeHierarchyTest {
    public static void main(String[] args) {
        Manager manager = new Manager("Avril Aroldo", "1 ABC St", 80000.0, "Manager", 5);
        Developer developer = new Developer("Iver Dipali", "2 PQR St", 72000.0, "Developer", "Java");
        Programmer programmer = new Programmer("Yaron Gabriel", "3 ABC St", 76000.0, "Python");

        System.out.println("Manager's Bonus: $" + manager.calculateBonus());
        System.out.println("Developer's Bonus: $" + developer.calculateBonus());
        System.out.println("Programmer's Bonus: $" + programmer.calculateBonus());

        System.out.println(manager.generatePerformanceReport());
        System.out.println(developer.generatePerformanceReport());
        System.out.println(programmer.generatePerformanceReport());

        manager.manageProject();
        developer.writeCode();
        programmer.debugCode();
    }
}

class Employee {
    protected String name;
    protected String address;
    protected double salary;
    protected String jobTitle;

    public Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    public double calculateBonus() {
        return 0.0;
    }

    public String generatePerformanceReport() {
        return "";
    }
}

class Manager extends Employee {
    private int teamSize;

    public Manager(String name, String address, double salary, String jobTitle, int teamSize) {
        super(name, address, salary, jobTitle);
        this.teamSize = teamSize;
    }

    @Override
    public double calculateBonus() {
        return salary * 0.15;
    }

    @Override
    public String generatePerformanceReport() {
        return "Performance report for " + jobTitle + " " + name + ": Excellent";
    }

    public void manageProject() {
        System.out.println(jobTitle + " " + name + " is managing a project.");
    }
}

class Developer extends Employee {
    private String language;

    public Developer(String name, String address, double salary, String jobTitle, String language) {
        super(name, address, salary, jobTitle);
        this.language = language;
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10;
    }

    @Override
    public String generatePerformanceReport() {
        return "Performance report for " + jobTitle + " " + name + ": Good";
    }

    public void writeCode() {
        System.out.println(jobTitle + " " + name + " is writing code in " + language);
    }
}

class Programmer extends Employee {
    private String language;

    public Programmer(String name, String address, double salary, String language) {
        super(name, address, salary, "Programmer");
        this.language = language;
    }

    @Override
    public double calculateBonus() {
        return salary * 0.12;
    }

    @Override
    public String generatePerformanceReport() {
        return "Performance report for " + jobTitle + " " + name + ": Excellent";
    }

    public void debugCode() {
        System.out.println(jobTitle + " " + name + " is debugging code in " + language);
    }
}
```
<!-- /code -->

#### 실행 결과

```text
Manager's Bonus: $12000.0
Developer's Bonus: $7200.0
Programmer's Bonus: $9120.0
Performance report for Manager Avril Aroldo: Excellent
Performance report for Developer Iver Dipali: Good
Performance report for Programmer Yaron Gabriel: Excellent
Manager Avril Aroldo is managing a project.
Developer Iver Dipali is writing code in Java
Programmer Yaron Gabriel is debugging code in Python
```

**포인트**

- 공통 속성(name, address, salary, jobTitle)은 Employee 에 protected 로 두어 자식 클래스가 바로 쓸 수 있게 했다.
- calculateBonus(), generatePerformanceReport() 는 Employee 에서 기본값(0.0, "")을 주고, 자식마다 재정의한다.
  ```text
  Manager    : 급여 x 0.15 = 80000.0 x 0.15 = 12000.0, "Excellent"
  ``` Developer  : 급여 x 0.10 = 72000.0 x 0.10 = 7200.0,  "Good"<br>Programmer : 급여 x 0.12 = 76000.0 x 0.12 = 9120.0,  "Excellent"
- manageProject(), writeCode(), debugCode() 는 각 자식 클래스에만 있는 새 메서드다.
- Programmer 의 생성자는 직위를 인수로 받지 않는다. → super(name, address, salary, "Programmer") 로 직위를 직접 정해서 넘긴다.

- 💡 Employee 의 calculateBonus() 와 generatePerformanceReport() 는 "직원마다 다르므로 부모에서는 정할 수 없는" 메서드다.<br>추상 메서드로 만들면 0.0, "" 같은 의미 없는 기본값을 쓰지 않아도 된다. (abstract class Employee, 3-practice/inheritance2)
- 💡 같은 폴더의 2번 문제(HRManagerTest.java)에도 Employee 가 있어서, 2번 쪽의 이름을 Employee2 로 바꿨다.
- 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 EmployeeHierarchyTest 로 이름을 바꿨다.

---

[🏠 10주차 학습 가이드](../../README.md)
