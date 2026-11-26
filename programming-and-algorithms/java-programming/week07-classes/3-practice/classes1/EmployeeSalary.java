/**
 * [7강 실습] 클래스(1) - 2번 문제 (Employee 클래스 - setter 에서 연봉 범위 검사)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class EmployeeSalary {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("홍길동");
        emp.setPhoneNumber("010-1234-5678");
        emp.setSalary(40000000);
        System.out.println("이름 : " + emp.getName() + ", 전화번호 : " + emp.getPhoneNumber()
                + ", 연봉 : " + emp.getSalary() + "원");

        // 💡 범위를 벗어난 값 확인
        emp.setSalary(-500);
        System.out.println("잘못된 연봉을 넣은 뒤 : " + emp.getSalary() + "원");
    }
}

class Employee {
    private String name;
    private String phoneNumber;
    private int salary;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public int getSalary() { return salary; }

    public void setSalary(int salary) {
        if (0 <= salary && salary <= 100000000) {
            this.salary = salary;
        } else {
            System.out.println("연봉은 0 이상 100,000,000 이하로 입력해야 합니다.");
            this.salary = 0;
        }
    }
}
