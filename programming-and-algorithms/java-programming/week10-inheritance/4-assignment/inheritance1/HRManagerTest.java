/**
 * [10강 과제] 상속 - 2번 문제 (Employee / HRManager : work 재정의 + addEmployee 추가)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
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
