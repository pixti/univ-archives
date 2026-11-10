/**
 * [7강 과제] 클래스(1) - 1번 문제 (Employee 클래스 - private 필드와 getter / setter)
 *
 * 문제
 *  이름(name), 나이(age), 급여(salary), 근속연수(years)를 private 필드로 가지는 Employee 클래스를 만들고
 *  getter / setter 를 작성하시오. main 에서 setter 로 값을 넣고 getter 로 꺼내 출력한다.
 *
 * 포인트
 *  - private 필드는 클래스 밖(main)에서 emp.name 처럼 직접 쓸 수 없다. → setName() / getName() 으로 접근
 *  - setter 의 매개변수 이름이 필드 이름과 같으므로 this.name = name; 으로 구분한다. (8-2 this)
 *  - getter 이름 규칙 : get + 필드 이름 (첫 글자 대문자) / setter : set + 필드 이름
 *
 * 💡 int 범위는 약 ±21억이므로 급여 3000000 은 int 로 충분하다.
 *
 * 실행 결과
 *  이름: 홍길동
 *  나이: 20
 *  급여: 3000000
 *  근속연수: 1
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("홍길동");
        emp.setAge(20);
        emp.setSalary(3000000);
        emp.setYears(1);

        System.out.println("이름: " + emp.getName());
        System.out.println("나이: " + emp.getAge());
        System.out.println("급여: " + emp.getSalary());
        System.out.println("근속연수: " + emp.getYears());
    }
}

class Employee {
    private String name;
    private int age;
    private int salary;
    private int years;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public int getYears() { return years; }
    public void setYears(int years) { this.years = years; }
}
