/**
 * [9강 과제] 1번 문제 (Employee 클래스 - 생성자 중복 정의)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp = new Employee("홍길동", "010-1234-5678", 40000000);
        System.out.println("이름 : " + emp.getName() + ", 전화번호 : " + emp.getPhone()
                + ", 연봉 : " + emp.getSalary() + "원");

        // 💡 다른 생성자로 만든 직원
        System.out.print("💡 ");
        new Employee().printEmployeeInfo();
        System.out.print("💡 ");
        new Employee("김철수").printEmployeeInfo();
    }
}

class Employee {
    private String name;
    private String phone;
    private int salary;

    public Employee() {
        this("미정", "000-0000-0000", 0);
    }

    public Employee(String name) {
        this(name, "000-0000-0000", 0);
    }

    public Employee(String name, String phone, int salary) {
        this.name = name;
        this.phone = phone;
        this.salary = salary;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public void printEmployeeInfo() {
        System.out.println("이름 : " + name + ", 전화번호 : " + phone + ", 연봉 : " + salary + "원");
    }
}
