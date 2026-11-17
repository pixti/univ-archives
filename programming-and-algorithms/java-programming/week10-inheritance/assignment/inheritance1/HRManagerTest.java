/**
 * [10강 과제] 상속 - 2번 문제 (Employee / HRManager : work 재정의 + addEmployee 추가)
 *
 * 문제
 *  work() 및 getSalary() 라는 메서드를 갖는 Employee 라는 클래스를 작성하라.
 *  그리고 work() 메서드가 재정의되고 addEmployee() 라는 새 메서드를 갖는 HRManager 라는 하위 클래스도 작성하라.
 *  main 은 다음과 같다.
 *
 *    // Main class
 *    public class Main {
 *        public static void main(String[] args) {
 *            Employee emp = new Employee(40000);
 *            HRManager mgr = new HRManager(70000);
 *
 *            emp.work();
 *            System.out.println("Employee salary: " + emp.getSalary());
 *
 *            mgr.work();
 *            System.out.println("Manager salary: " + mgr.getSalary());
 *            mgr.addEmployee();
 *        }
 *    }
 *
 * 포인트
 *  - salary 는 Employee 의 private 필드다. HRManager 생성자는 super(salary) 로 부모 생성자에게 값을 넘긴다.
 *  - getSalary() 는 재정의하지 않았으므로 mgr.getSalary() 는 물려받은 Employee 의 것이 실행된다.
 *  - work() 는 재정의, addEmployee() 는 HRManager 에만 있는 새 메서드다.
 *    → Employee 타입 변수로는 addEmployee() 를 부를 수 없다. (Employee e = mgr; e.addEmployee(); → ❌ cannot find symbol)
 *
 * ⚠ 문제의 실행 결과에는 "Employee salary: 40000" 과 "Managing employees" 사이 등에 빈 줄이 있지만,
 *    main 코드에는 빈 줄을 출력하는 문장이 없다. 실제 실행 결과는 아래처럼 빈 줄 없이 나온다.
 * 💡 같은 폴더의 5번 문제(EmployeeHierarchyTest.java)에도 Employee 클래스가 있어서 IntelliJ 에서 함께 빌드하면 중복 오류가 난다.
 *    그래서 이 파일의 Employee 를 Employee2 로 바꿨다. (문제와 처음 작성한 코드에서는 Employee)
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 HRManagerTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  working as an employee!
 *  Employee salary: 40000
 *  Managing employees
 *  Manager salary: 70000
 *  Adding new employee!
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
