/**
 * [10강 실습] 상속 (추상 클래스) - 2번 문제 (abstract Employee / Manager / Programmer)
 *
 * 문제
 *  추상 메서드 calculateSalary() 및 displayInfo() 를 갖는 Employee 추상 클래스를 작성하라.
 *  Employee 클래스를 확장하고 급여를 계산하고 각 역할에 대한 정보를 표시하는 해당 메서드를 구현하는
 *  하위 클래스 Manager 및 Programmer 를 작성하라.
 *
 *    // Main
 *    public class Main {
 *        public static void main(String[] args) {
 *            Employee manager = new Manager("Corona Cadogan", 6000, 1000);
 *            Employee programmer = new Programmer("Antal Nuka", 5000, 20, 25.0);
 *
 *            manager.displayInfo();
 *            System.out.println("---------------------");
 *            programmer.displayInfo();
 *        }
 *    }
 *
 * 📝 필기 : 이전 문제들과 달리 이번 문제에서는 추상 클래스 내부에 공통 변수(필드)와 생성자가 포함되며,
 *          추상 메소드가 결괏값을 반환(return)하는 구조로 작성되었다.
 *  ① 추상 클래스의 필드와 생성자 (Employee)
 *     - 공통 필드의 추출과 protected 접근 제어자
 *       · 매니저와 프로그래머 모두 "이름(name)" 과 "기본급(baseSalary)" 을 공통으로 가진다.
 *         코드 중복을 피하기 위해 이를 부모 클래스인 Employee 에 선언했다.
 *       · 접근 제어자를 protected 로 설정하여 외부 클래스에서는 직접 접근하지 못하게 보호하면서도,
 *         상속받은 자식 클래스(Manager, Programmer) 내부에서는 자유롭게 사용할 수 있도록 했다.
 *       · main() 에서 기본급으로 정수 6000, 5000 을 전달하지만, 실행 결과에서는 6000.0, 5000.0 처럼 실수로 출력되므로
 *         변수의 타입은 double 로 선언했다. (정수가 double 매개변수로 전달될 때 자동으로 실수형으로 형변환된다)
 *     - 추상 클래스에 생성자가 존재하는 이유
 *       · 추상 클래스는 new Employee() 처럼 직접 객체를 생성할 수 없지만, 생성자는 정의할 수 있다.
 *       · 이 생성자는 자식 클래스의 객체가 생성될 때 호출되어, 부모 클래스로부터 물려받은 공통 필드(name, baseSalary)를
 *         초기화하는 역할을 수행한다.
 *  ② super() 를 통한 부모 생성자 호출과 고유 필드 초기화 (Manager, Programmer)
 *     - 자식 클래스의 고유 필드
 *       · Manager 는 보너스(bonus)가 추가로 필요하고, Programmer 는 초과 근무 시간(overtimeHours)과 시급(hourlyRate)이
 *         추가로 필요하다. 각 클래스에만 필요한 데이터이므로 해당 하위 클래스 내부에 private 필드로 선언했다.
 *     - super(...) 키워드
 *       · 자식 클래스의 생성자 첫 줄에서 super(name, baseSalary); 를 호출하면 부모 클래스(Employee)의 생성자가
 *         먼저 실행되어 name 과 baseSalary 가 초기화된다.
 *       · 그다음 줄에서 this.bonus = bonus; 를 통해 자식 클래스 자신의 고유 필드를 초기화한다.
 *  ③ 반환값이 있는 추상 메소드와 내부 메소드 호출
 *     - calculateSalary() 의 구현
 *       · 직군마다 급여 계산 방식이 다르므로 Employee 에서는 public abstract double calculateSalary(); 로 선언만 해 두었다.
 *         반환 타입이 double 이므로 하위 클래스에서 오버라이딩할 때도 계산된 급여를 double 타입으로 반환(return)해야 한다.
 *       · Manager 는 기본급 + 보너스를 반환하고, Programmer 는 기본급 + (초과근무시간 x 시급)을 반환한다.
 *     - displayInfo() 에서의 활용
 *       · main() 메소드를 보면 calculateSalary() 를 직접 호출하지 않고 displayInfo() 만 호출하고 있다.
 *       · 따라서 displayInfo() 메소드 내부의 마지막 출력문에서 같은 클래스 내에 정의된 calculateSalary() 를 호출하여
 *         총 급여(Total Salary)를 계산하고 그 결괏값을 화면에 출력하도록 구성했다.
 *
 * 💡 Programmer : 5000 + 20 x 25.0 = 5000 + 500.0 = 5500.0
 * 💡 protected 와 private 를 어디에 왜 썼는지는 BirdTest.java 의 📝 필기(접근 제어자 정리) 3절에 이어서 정리했다.
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 EmployeeSalaryTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Manager Name: Corona Cadogan
 *  Base Salary: $6000.0
 *  Bonus: $1000.0
 *  Total Salary: $7000.0
 *  ---------------------
 *  Programmer Name: Antal Nuka
 *  Base Salary: $5000.0
 *  Overtime Hours: 20
 *  Hourly Rate: $25.0
 *  Total Salary: $5500.0
 */
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
