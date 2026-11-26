/**
 * [11강 과제] 상속 (인터페이스, 다중 상속) - 3번 문제 (Faculty 와 Student 의 특성을 모두 갖는 TA)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class TATest {
    public static void main(String[] args) {
        TA ta = new TA(25, "Male", "AI", "Computer Science");

        System.out.println("=== (a) Composition ===");
        System.out.println("나이: " + ta.getAge());
        System.out.println("성별: " + ta.getSex());
        System.out.println("전공(Faculty): " + ta.getMajor());
        System.out.println("학과(Student): " + ta.getDept());

        ta.setAge(26);
        ta.setMajor("Machine Learning");
        System.out.println("수정 후 나이: " + ta.getAge() + ", 전공: " + ta.getMajor());

        TA2 ta2 = new TA2(25, "Female", "Data Science", "Software Engineering");

        System.out.println("=== (b) Composition + Interface ===");
        System.out.println("나이: " + ta2.getAge());
        System.out.println("성별: " + ta2.getSex());
        System.out.println("전공(Faculty): " + ta2.getMajor());
        System.out.println("학과(Student): " + ta2.getDept());

        IPerson p = ta2;
        IFaculty f = ta2;
        IStudent s = ta2;

        System.out.println("IPerson 나이: " + p.getAge());
        System.out.println("IFaculty 전공: " + f.getMajor());
        System.out.println("IStudent 학과: " + s.getDept());
    }
}

class Person {
    int age;
    String sex;

    public Person(int age, String sex) {
        this.age = age;
        this.sex = sex;
    }

    public int getAge() { return this.age; }
    public void setAge(int newAge) { this.age = newAge; }
    public String getSex() { return sex; }
    public void setSex(String newSex) { sex = newSex; }
}

class Faculty extends Person {
    String major;

    public Faculty(int age, String sex, String major) {
        super(age, sex);
        this.major = major;
    }

    public String getMajor() { return major; }
    public void setMajor(String newMajor) { major = newMajor; }
}

class Student extends Person {
    String dept;

    public Student(int age, String sex, String dept) {
        super(age, sex);
        this.dept = dept;
    }

    public String getDept() { return dept; }
    public void setDept(String newDept) { dept = newDept; }
}

/** (a) Composition 을 이용한 TA */
class TA {
    private Faculty faculty;
    private Student student;

    public TA(int age, String sex, String major, String dept) {
        this.faculty = new Faculty(age, sex, major);
        this.student = new Student(age, sex, dept);
    }

    public int getAge() { return student.getAge(); }
    public void setAge(int newAge) {
        student.setAge(newAge);
        faculty.setAge(newAge);
    }

    public String getSex() { return student.getSex(); }
    public void setSex(String newSex) {
        student.setSex(newSex);
        faculty.setSex(newSex);
    }

    public String getMajor() { return faculty.getMajor(); }
    public void setMajor(String newMajor) { faculty.setMajor(newMajor); }

    public String getDept() { return student.getDept(); }
    public void setDept(String newDept) { student.setDept(newDept); }
}

/** (b) 인터페이스 */
interface IPerson {
    int getAge();
    void setAge(int newAge);
    String getSex();
    void setSex(String newSex);
}

interface IFaculty extends IPerson {
    String getMajor();
    void setMajor(String newMajor);
}

interface IStudent extends IPerson {
    String getDept();
    void setDept(String newDept);
}

/** (b) Composition + 인터페이스를 이용한 TA (처음 작성한 코드에서는 이름이 TA) */
class TA2 implements IFaculty, IStudent {
    private Faculty faculty;
    private Student student;

    public TA2(int age, String sex, String major, String dept) {
        this.faculty = new Faculty(age, sex, major);
        this.student = new Student(age, sex, dept);
    }

    @Override
    public int getAge() { return student.getAge(); }

    @Override
    public void setAge(int newAge) {
        student.setAge(newAge);
        faculty.setAge(newAge);
    }

    @Override
    public String getSex() { return student.getSex(); }

    @Override
    public void setSex(String newSex) {
        student.setSex(newSex);
        faculty.setSex(newSex);
    }

    @Override
    public String getMajor() { return faculty.getMajor(); }

    @Override
    public void setMajor(String newMajor) { faculty.setMajor(newMajor); }

    @Override
    public String getDept() { return student.getDept(); }

    @Override
    public void setDept(String newDept) { student.setDept(newDept); }
}
