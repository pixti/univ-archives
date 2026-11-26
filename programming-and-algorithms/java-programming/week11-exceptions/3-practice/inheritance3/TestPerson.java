/**
 * [11강 실습] 상속 추가 실습 (인터페이스, 컴포지션, 다중 상속) - 3번 문제 (Person has-a Job : 컴포지션)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person();
        long salary = person.getSalary();
        System.out.println("salary = " + salary);   // 💡 확인용
    }
}

class Job {
    private String role;
    private long salary;
    private int id;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class Person {
    // composition has-a relationship
    private Job job;

    public Person() {
        this.job = new Job();
        job.setSalary(1000L);
    }

    public long getSalary() {
        return job.getSalary();
    }
}
