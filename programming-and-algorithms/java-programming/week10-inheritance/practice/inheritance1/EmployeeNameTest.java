/**
 * [10강 실습] 상속 - 4번 문제 (Person / Employee : getLastName 재정의)
 *
 * 문제
 *  getFirstName() 및 getLastName() 메소드를 사용하여 Person 이라는 클래스를 정의하라.
 *  getEmployeeId() 라는 새 메서드와 getLastName() 메서드를 재정의한 Employee 라는 하위 클래스도 정의하라.
 *  Employee 클래스의 getLastName() 메서드는 잡 타이틀(직함)도 같이 반환한다.
 *
 *    // Main class
 *    public class Main {
 *        public static void main(String[] args) {
 *            Employee employee1 = new Employee("Kortney", "Rosalee", 4451, "HR Manager");
 *            System.out.println(employee1.getFirstName() + " " + employee1.getLastName() + " (" + employee1.getEmployeeId() + ")");
 *            Employee employee2 = new Employee("Junior", "Philipa", 4452, "Software Manager");
 *            System.out.println(employee2.getFirstName() + " " + employee2.getLastName() + " (" + employee2.getEmployeeId() + ")");
 *        }
 *    }
 *
 * 포인트
 *  - Employee 생성자는 이름 두 개를 super(firstName, lastName) 으로 부모에게 넘기고, 자기 필드(employeeId, jobTitle)만 초기화한다.
 *  - 재정의한 getLastName() 은 super.getLastName() 으로 부모의 성(lastName)을 받아 뒤에 ", " + jobTitle 을 붙인다.
 *      "Rosalee" + ", " + "HR Manager"  →  "Rosalee, HR Manager"
 *  - getEmployeeId() 는 부모에 없는 새 메서드다. (재정의가 아니라 추가)
 *
 * ⚠ 자주 틀리는 부분 : getLastName() 안에서 super. 없이 getLastName() 을 부르면 자기 자신을 다시 부르는 무한 재귀가 된다.
 *    lastName 은 Person 의 private 필드라서 Employee 에서 직접 쓸 수도 없다. → super.getLastName()
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 EmployeeNameTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Kortney Rosalee, HR Manager (4451)
 *  Junior Philipa, Software Manager (4452)
 */
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
