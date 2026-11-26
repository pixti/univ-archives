/**
 * [7강 과제] 클래스(1) - 1번 문제 (Employee 클래스 - private 필드와 getter / setter)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
