/**
 * [10강 과제] 상속 - 5번 문제 (Employee / Manager / Developer / Programmer)
 *
 * 문제
 *  회사 직원을 위한 클래스 계층 구조를 생성하는 Java 프로그램을 작성하라. 기본 클래스는 Employee 이며
 *  하위 클래스는 Manager, Developer 및 Programmer 이다. 각 하위 클래스에는 이름, 주소, 급여, 직위 등의 속성이 있고,
 *  보너스 계산, 성과 보고서 생성 및 프로젝트 관리 방법을 갖는다. main 은 다음과 같다.
 *
 *    //Main.class
 *    public class Main {
 *        public static void main(String[] args) {
 *            Manager manager = new Manager("Avril Aroldo", "1 ABC St", 80000.0, "Manager", 5);
 *            Developer developer = new Developer("Iver Dipali", "2 PQR St", 72000.0, "Developer", "Java");
 *            Programmer programmer = new Programmer("Yaron Gabriel", "3 ABC St", 76000.0, "Python");
 *
 *            System.out.println("Manager's Bonus: $" + manager.calculateBonus());
 *            System.out.println("Developer's Bonus: $" + developer.calculateBonus());
 *            System.out.println("Programmer's Bonus: $" + programmer.calculateBonus());
 *
 *            System.out.println(manager.generatePerformanceReport());
 *            System.out.println(developer.generatePerformanceReport());
 *            System.out.println(programmer.generatePerformanceReport());
 *
 *            manager.manageProject();
 *            developer.writeCode();
 *            programmer.debugCode();
 *        }
 *    }
 *
 * 포인트
 *  - 공통 속성(name, address, salary, jobTitle)은 Employee 에 protected 로 두어 자식 클래스가 바로 쓸 수 있게 했다.
 *  - calculateBonus(), generatePerformanceReport() 는 Employee 에서 기본값(0.0, "")을 주고, 자식마다 재정의한다.
 *      Manager    : 급여 x 0.15 = 80000.0 x 0.15 = 12000.0, "Excellent"
 *      Developer  : 급여 x 0.10 = 72000.0 x 0.10 = 7200.0,  "Good"
 *      Programmer : 급여 x 0.12 = 76000.0 x 0.12 = 9120.0,  "Excellent"
 *  - manageProject(), writeCode(), debugCode() 는 각 자식 클래스에만 있는 새 메서드다.
 *  - Programmer 의 생성자는 직위를 인수로 받지 않는다. → super(name, address, salary, "Programmer") 로 직위를 직접 정해서 넘긴다.
 *
 * 💡 Employee 의 calculateBonus() 와 generatePerformanceReport() 는 "직원마다 다르므로 부모에서는 정할 수 없는" 메서드다.
 *    추상 메서드로 만들면 0.0, "" 같은 의미 없는 기본값을 쓰지 않아도 된다. (abstract class Employee, practice/inheritance2)
 * 💡 같은 폴더의 2번 문제(HRManagerTest.java)에도 Employee 가 있어서, 2번 쪽의 이름을 Employee2 로 바꿨다.
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 EmployeeHierarchyTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Manager's Bonus: $12000.0
 *  Developer's Bonus: $7200.0
 *  Programmer's Bonus: $9120.0
 *  Performance report for Manager Avril Aroldo: Excellent
 *  Performance report for Developer Iver Dipali: Good
 *  Performance report for Programmer Yaron Gabriel: Excellent
 *  Manager Avril Aroldo is managing a project.
 *  Developer Iver Dipali is writing code in Java
 *  Programmer Yaron Gabriel is debugging code in Python
 */
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
