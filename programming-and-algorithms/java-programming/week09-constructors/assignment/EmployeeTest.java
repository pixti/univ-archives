/**
 * [9강 과제] 1번 문제 (Employee 클래스 - 생성자 중복 정의)
 *
 * 문제 (요약)
 *  이름(name), 전화번호(phone), 연봉(salary)을 필드로 가지는 Employee 클래스를 작성하시오.
 *  - 생성자를 중복 정의한다 : Employee(), Employee(name), Employee(name, phone, salary)
 *  - 필드는 private, getter / setter 를 둔다.
 *  - main 에서 홍길동 직원을 만들어 정보를 출력한다.
 *
 * 포인트
 *  - 7강 과제 클래스1 1번 Employee(getter / setter 만 사용)에 생성자를 추가한 문제.
 *  - 생성자 체이닝 : 값이 주어지지 않은 항목은 "미정", "000-0000-0000", 0 으로 채운다.
 *
 * 💡 printEmployeeInfo() 를 만들어 두었지만 main 은 문제의 실행 결과 형식대로 getter 로 출력했다.
 *    두 방법 모두 결과는 같다. (💡 줄에서 printEmployeeInfo() 도 호출)
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. EmployeeTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  이름 : 홍길동, 전화번호 : 010-1234-5678, 연봉 : 40000000원
 *  💡 이름 : 미정, 전화번호 : 000-0000-0000, 연봉 : 0원
 *  💡 이름 : 김철수, 전화번호 : 000-0000-0000, 연봉 : 0원
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
