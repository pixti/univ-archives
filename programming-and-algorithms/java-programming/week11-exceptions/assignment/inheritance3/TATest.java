/**
 * [11강 과제] 상속 (인터페이스, 다중 상속) - 3번 문제 (Faculty 와 Student 의 특성을 모두 갖는 TA)
 *
 * 문제
 *  다음 클래스를 이용하여 아래의 물음에 답하라.
 *
 *    public class Person {
 *        int age;
 *        String sex;
 *        public Person(int age, String sex) {
 *            this.age = age; this.sex = sex;
 *        }
 *        public int getAge() {return this.age;}
 *        public void setAge(int newAge) { this.age= newAge;}
 *        public String getSex() {return sex;}
 *        public void setSex(String newSex) {sex = newSex;}
 *    }
 *    public class Faculty extends Person {
 *        String major;
 *        public Faculty(int age, String sex, String major) {
 *            super(age, sex);
 *            this.major = major;
 *        }
 *        public String getMajor() {return major;}
 *        public void setMajor(String newMajor) {major = newMajor;}
 *    }
 *    public class Student extends Person {
 *        String dept;
 *        public Student(int age, String sex, String dept) {
 *            super(age, sex);
 *            this.dept = dept;
 *        }
 *        public String getDept() {return dept;}
 *        public void setDept(String newDept) {dept = newDept;}
 *    }
 *
 *  (a) composition 을 이용하여 Faculty 와 Student 의 특성 모두를 갖고 있는 TA 클래스를 정의하시오.
 *  (b) composition 과 인터페이스 모두를 이용하여 TA 클래스를 정의하시오.
 *
 * 📝 필기 : 자바(Java)는 클래스의 다중 상속을 지원하지 않기 때문에, Faculty 와 Student 의 특성을 모두 갖는 TA 클래스를 만들 때는
 *          합성(Composition)이나 인터페이스(Interface)를 활용해야 한다.
 *   (a) Composition(합성)을 이용한 TA 클래스 정의
 *       TA 클래스 내부에 Faculty 와 Student 객체를 멤버 변수로 포함(HAS-A 관계)시키고, 각 메서드의 호출을 내부 객체에
 *       위임(Delegation)하는 방식이다.
 *   (b) Composition 과 인터페이스를 모두 이용한 TA 클래스 정의
 *       (a) 방식만 사용하면 기능은 모두 사용할 수 있지만, TA 가 Faculty 나 Student 타입으로 취급될 수 없어 다형성(Polymorphism)을
 *       활용할 수 없다. 이를 해결하기 위해 각 클래스의 기능을 정의한 인터페이스를 선언하고, TA 가 인터페이스를 구현(implements)하면서
 *       실제 기능 구현은 합성(Composition)한 객체에 위임한다.
 *         interface IPerson { getAge, setAge, getSex, setSex }
 *         interface IFaculty extends IPerson { getMajor, setMajor }
 *         interface IStudent extends IPerson { getDept, setDept }
 *         class TA implements IFaculty, IStudent { ... }
 *
 * 포인트
 *  - TA 는 faculty 와 student 두 객체를 갖고 있다. 나이와 성별은 두 객체에 똑같이 들어 있으므로
 *      getAge() / getSex()  : 한쪽(student)에서 읽는다
 *      setAge() / setSex()  : 두 객체 모두에 써서 값이 어긋나지 않게 한다
 *  - (b) 에서 IFaculty 와 IStudent 둘 다 IPerson 을 extends 하므로 getAge() 등은 TA 에서 한 번만 구현하면 된다.
 *    (인터페이스는 구현이 없어서 같은 메소드가 두 경로로 들어와도 충돌하지 않는다)
 *  - (b) 의 TA 는 IPerson, IFaculty, IStudent 어느 타입 변수에도 담을 수 있다.  IPerson p = ta;  IFaculty f = ta;  IStudent s = ta;
 *
 * 💡 (a) 와 (b) 를 한 파일에서 실행하려고 (a) 의 TA 는 TA, (b) 의 TA 는 TA2 로 이름을 나눴다. 처음 작성한 코드에서는 둘 다 TA 다.
 *    두 버전의 main 도 하나로 합쳤다.
 * 💡 원래는 Person.java, Faculty.java, Student.java 처럼 public class 마다 파일을 나눈다. 한 파일에 넣으려고 public 을 뺐다.
 *
 * 실행 결과
 *  === (a) Composition ===
 *  나이: 25
 *  성별: Male
 *  전공(Faculty): AI
 *  학과(Student): Computer Science
 *  수정 후 나이: 26, 전공: Machine Learning
 *  === (b) Composition + Interface ===
 *  나이: 25
 *  성별: Female
 *  전공(Faculty): Data Science
 *  학과(Student): Software Engineering
 *  IPerson 나이: 25
 *  IFaculty 전공: Data Science
 *  IStudent 학과: Software Engineering
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
