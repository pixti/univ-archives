/**
 * [10강 퀴즈] 상속 (재정의 · 접근 제어 · 생성자 호출 순서 · 추상 클래스 · 인터페이스 · Human / Student)
 * 문제 · 정답 · 필기 → README.md
 */
public class InheritanceQuiz {
    public static void main(String[] args) {
        System.out.println("===== 1 =====");
        q1();
        System.out.println("===== 2 =====");
        q2();
        System.out.println("===== 3 =====");
        q3();
        System.out.println("===== 3 (추가) =====");
        q3Extra();
    }

    // 1. 다음 질문에 간단히 답하라.
    static void q1() {
        Child c = new Child();
        c.display();
    }

    // 2. 아래의 질문에 O, X 를 하시오.
    static void q2() {
        System.out.println("(1) X  (2) X  (3) X  (4) O  (5) O  (6) O  (7) X  (8) O  (9) O");
    }

    // 3. 다음 물음에 답하라.
    static void q3() {
        System.out.println("---- (5) ----");
        Human h1 = new Human("개똥", 10);
        Human h2 = new Human("소똥", 20);
        Human h3 = new Human("말똥", 21);
        h1.print();
        h2.print();
        h3.print();

        System.out.println("---- (10) ----");
        Student s1 = new Student("순이", 10, "식품");
        Student s2 = new Student("철수", 20, "컴퓨터");
        Student s3 = new Student("바둑이", 21, "철학");
        s1.print();
        s2.print();
        s3.print();
    }

    // 3. (추가) 📝 추가 정리
    static void q3Extra() {
        Human h = new Human("개똥", 10);
        h.setAge(25);                    // Setter : 값을 바꿀 때
        int myAge = h.getAge();          // Getter : 값을 꺼내 올 때
        System.out.println(myAge);       // 25 출력

        System.out.println("---- Human 배열 (향상된 for 문) ----");
        Human[] arr = new Human[3];
        arr[0] = new Human("개똥", 10);
        arr[1] = new Human("소똥", 20);
        arr[2] = new Human("말똥", 21);
        for (Human e : arr) {
            e.print();
        }

        System.out.println("---- Human 배열에 Student 저장 (업캐스팅) ----");
        Human[] arr2 = new Human[3];                    // 1. 상위 클래스(Human) 타입의 배열 생성
        arr2[0] = new Student("순이", 10, "식품");        // 2. 상위 타입 배열에 하위 타입(Student) 객체 저장 (업캐스팅)
        arr2[1] = new Student("철수", 20, "컴퓨터");
        arr2[2] = new Student("바둑이", 21, "철학");
        for (int i = 0; i < arr2.length; i++) {         // 💡 일반 for 문으로도 순회
            arr2[i].print();                            // 3. 실제 객체가 Student → Student 의 print() (동적 바인딩)
        }
    }
}

/** 1번 (1) : super.메서드이름() 으로 재정의된 부모 메서드 호출 */
class Parent {
    void display() {
        System.out.println("부모 메서드");
    }
}

class Child extends Parent {
    @Override
    void display() {
        super.display();   // 부모 클래스의 display() 호출
        System.out.println("자식 메서드");
    }
}

/** 3번 (1) ~ (4) */
class Human {
    String name;
    int age;

    Human(String name, int age) {        // (2) 생성자
        this.name = name;
        this.age = age;
    }

    // (3) name 의 getter 와 setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // (3) age 의 getter 와 setter
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void print() {                // (4)
        System.out.println("이름: " + name + ", 나이: " + age);
    }
}

/** 3번 (6) ~ (9) */
class Student extends Human {
    String major;                        // (6) 추가된 필드

    Student(String name, int age, String major) {   // (7)
        super(name, age);                // 부모 클래스(Human)의 생성자 호출
        this.major = major;
    }

    // (8) major 의 getter 와 setter (name, age 의 getter / setter 는 Human 에게서 상속)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void print() {                // (9)
        super.print();                   // 부모 클래스(Human)의 print() 메서드 먼저 호출
        System.out.println("전공: " + major);
    }
}
