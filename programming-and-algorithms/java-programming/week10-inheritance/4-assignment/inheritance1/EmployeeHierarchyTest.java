/**
 * [10강 과제] 상속 - 5번 문제 (Employee / Manager / Developer / Programmer)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
