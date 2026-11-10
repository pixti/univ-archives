/**
 * [7강 실습] 클래스(1) - 2번 문제 (Employee 클래스 - setter 에서 연봉 범위 검사)
 *
 * 문제
 *  이름(name), 전화번호(phoneNumber), 연봉(salary)을 private 필드로 가지는 Employee 클래스를 만드시오.
 *  연봉은 0 이상 100,000,000 이하만 저장하고, 범위를 벗어나면 안내 문구를 출력한 뒤 0 으로 저장한다.
 *
 * 포인트
 *  - setter 안에서 값을 검사한다 = getter/setter 를 쓰는 이유 ① "데이터 무결성 / 유효성 검사" (퀴즈 2번)
 *  - 0 <= salary && salary <= 100000000 : 범위 검사는 && 로 두 조건을 묶는다.
 *    (수학처럼 0 <= salary <= 100000000 으로 쓰면 컴파일 오류)
 *
 * 💡 숫자가 길면 100_000_000 처럼 밑줄을 넣어 쓸 수 있다. (Java 7 이상, 값은 같음)
 * 💡 main 이 있던 클래스(Main)는 EmployeeSalary 로 이름을 바꿨다.
 *
 * 실행 결과
 *  이름 : 홍길동, 전화번호 : 010-1234-5678, 연봉 : 40000000원
 *  연봉은 0 이상 100,000,000 이하로 입력해야 합니다.
 *  잘못된 연봉을 넣은 뒤 : 0원
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
