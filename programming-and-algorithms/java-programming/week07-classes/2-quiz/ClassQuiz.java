/**
 * [7강 퀴즈] 클래스 (클래스와 객체 · getter/setter · static · 내부 클래스)
 * 문제 · 정답 · 필기 → README.md
 */
public class ClassQuiz {
    public static void main(String[] args) {
        System.out.println("===== 1 =====");
        q1();
        System.out.println("===== 2 =====");
        q2();
        System.out.println("===== 3 =====");
        q3();
        System.out.println("===== 4 =====");
        q4();
        System.out.println("===== 5 =====");
        q5();
        System.out.println("===== 6 =====");
        q6();
        System.out.println("===== 7 =====");
        q7();
        System.out.println("===== 8 =====");
        q8();
        System.out.println("===== 9 =====");
        q9();
    }

    // 1. ❶ 클래스와 객체의 차이점
    static void q1() {
        // ❶ 클래스 하나(Person)로 객체 여러 개
        Person p1 = new Person();
        Person p2 = new Person();
        p1.name = "홍길동";
        p2.name = "김철수";
        System.out.println("설계도(클래스) 하나로 만든 객체 2개 : " + p1.name + ", " + p2.name);

        // ❷ 필드는 자동 초기화, 지역 변수는 초기화하지 않으면 컴파일 오류
        Person p3 = new Person();
        System.out.println("필드 기본값 : num = " + p3.num + ", flag = " + p3.flag + ", name = " + p3.name);
        // int local;
        // System.out.println(local);    // ❌ error: variable local might not have been initialized

        // ❸ return
        System.out.println("return 으로 받은 값 : " + p3.add(3, 4));
    }

    // 2. getter / setter 를 사용하는 이유
    static void q2() {
        Age a = new Age();
        a.setAge(-10);                         // setter 가 막아 준다
        a.setAge(20);
        System.out.println("나이 : " + a.getAge());
        // a.age = -10;                        // ❌ private 이라서 외부에서 직접 못 바꾼다
    }

    // 3. 다음 코드의 오류를 모두 찾으시오.
    static void q3() {
        Audio.main(new String[0]);
    }

    // 4. ❶ 빈칸을 채우시오.
    static void q4() {
        // ❶
        Time1 t1 = new Time1();
        t1.hour = 11;
        t1.minute = 35;
        t1.print();

        // ❷
        Time t = new Time();
        t.setHour(11);
        t.setMinute(35);
        t.print();
    }

    // 5. Point 클래스
    static void q5() {
        Point.main(new String[0]);        // ❸ Point 안의 main
        PointTest.main(new String[0]);    // ❹ 별도 클래스 PointTest 의 main
    }

    // 6. (a) static 필드와 일반 필드의 차이  (b) 정적 메서드와 일반 메서드의 차이
    static void q6() {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        c1.increase();
        c2.increase();
        System.out.println("Counter.shared = " + Counter.shared + ", c1.own = " + c1.own + ", c2.own = " + c2.own);
        System.out.println("Counter.twice(5) = " + Counter.twice(5));   // 객체 없이 클래스명으로 호출
    }

    // 7. 다음 코드의 출력 결과를 쓰시오.   ★) 기말고사 출제 유력
    static void q7() {
        A ob1 = new A();
        A ob2 = new A();
        A ob3 = new A();
        ob1.x = 3; ob2.x = 4; ob3.x = 5;
        ob1.x++;   ob2.x++;   ob3.x++;
        System.out.println(ob1.x + ", " + ob2.x + ", " + ob3.x);
        ob1.z = 3; ob2.z = 4; ob3.z = 5;
        ob1.z++;   ob2.z++;   ob3.z++;
        System.out.println(ob1.z + ", " + ob2.z + ", " + ob3.z);

        // 필기 : 클래스명으로도 접근 가능 (static 이므로)
        A.z++;
        System.out.println(A.z);           // 9
    }

    // 8. 다음 코드의 오류를 모두 찾아 고치시오.
    static void q8() {
        Test.main(new String[0]);
    }

    // 9. 다음 코드에서 클래스 B 를 클래스 A 의 내부 클래스로 바꾸어 작성하시오.
    static void q9() {
        A9 outer = new A9();
        outer.display_Inner();
        A9.B inner = outer.new B();
        inner.print();
    }
}

// ───────────────────────── 1번 ─────────────────────────
class Person {
    String name;
    int num;
    boolean flag;

    int add(int a, int b) {
        return a + b;              // ❸ return 반환값;
    }
}

// ───────────────────────── 2번 ─────────────────────────
class Age {
    private int age;

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age < 0) {                                   // ① 유효성 검사
            System.out.println("나이는 0 이상이어야 합니다.");
            return;
        }
        this.age = age;
    }
}

// ───────────────────────── 3번 (✅ 고친 코드) ─────────────────────────
class Audio {
    private int volume;
    public void setVolume(int level) { volume = level; }          // (4) 메서드 뒤 ; 제거
    public int getVolume() { return volume; }
    public static void main(String[] args) {
        Audio bose = new Audio();                                 // (1) 객체 생성
        bose.setVolume(50);                                       // (2) setter 사용
        int vol = bose.getVolume();                               // (3) 객체로 호출
        System.out.println("볼륨 : " + vol);                      // 💡 확인용 출력 추가
    }
}                                                                 // (4) 클래스 뒤 ; 제거

// ───────────────────────── 4번 ─────────────────────────
// ❶ (원래 이름은 Time, main 이 이 클래스 안에 있었다)
class Time1 {
    int hour, minute;

    public void print() {                                          // ← 빈칸
        System.out.println(hour + "시 " + minute + "분");
    }
}

// ❷ private + getter / setter
class Time {
    private int hour, minute;

    public int getHour() { return hour; }
    public void setHour(int hour) { this.hour = hour; }
    public int getMinute() { return minute; }
    public void setMinute(int minute) { this.minute = minute; }

    public void print() {
        System.out.println(getHour() + "시 " + getMinute() + "분");
    }

    public static void main(String[] args) {
        Time t = new Time();
        t.setHour(11);
        t.setMinute(35);
        t.print();
    }
}

// ───────────────────────── 5번 ─────────────────────────
class Point {
    private int x, y;

    // ❶
    public int getX() { return x; }
    public void setX(int xCoord) { this.x = xCoord; }   // x = xCoord; 도 가능
    // ❷
    public int getY() { return y; }
    public void setY(int yCoord) { this.y = yCoord; }

    // ❸ Point 클래스 안의 main
    public static void main(String[] args) {
        Point p1 = new Point();
        p1.setX(100);
        p1.setY(200);
        System.out.println(p1.getX() + ", " + p1.getY());
    }
}

// ❹ main 을 별도 클래스로 (한 파일에 쓸 때는 파일명과 같은 클래스만 public)
class PointTest {
    public static void main(String[] args) {
        Point p1 = new Point();
        p1.setX(100);
        p1.setY(200);
        System.out.println(p1.getX() + ", " + p1.getY());
    }
}

// ───────────────────────── 6번 ─────────────────────────
class Counter {
    static int shared;          // 모든 Counter 객체가 공유
    int own;                    // 객체마다 따로

    void increase() {           // 일반 메서드 : 일반 필드, static 필드 모두 사용 가능
        shared++;
        own++;
    }

    static int twice(int n) {   // 정적 메서드 : 인수, 지역 변수, static 멤버만 사용 가능
        // own++;               // ❌ error: non-static variable own cannot be referenced from a static context
        return n * 2;
    }
}

// ───────────────────────── 7번 ─────────────────────────
class A {
    public int x;
    public static int z;
}

// ───────────────────────── 8번 (✅ 고친 코드) ─────────────────────────
class Test {
    private static int x, y;                  // ✅ static 추가 → f3(), main 에서 사용 가능
    private static int z;

    public static void f1() {
        int r = f2();
        System.out.println("결과 : " + r);
    }

    public static int f2() { return z++; }    // ✅ static 추가 → f1() 에서 호출 가능
    public static int f3() { return x + y; }
    public int f4() { return z--; }           // 일반 메서드는 static 필드 사용 가능 → 그대로

    public static void main(String[] args) {
        x = 3; y = 5; z = 0;
        f1();
    }
}

// ───────────────────────── 9번 (✅ 답) ─────────────────────────
class A9 {                                    // 원래 이름은 A
    private int num = 10;

    public int getNum() { return num; }

    public void display_Inner() {
        B ob = new B();                       // A 안에서는 그냥 new B()
        System.out.println("A class : " + ob.getX());
    }

    public class B {                          // B 를 A 의 내부 클래스로
        private int x = 5;

        public int getX() { return x; }

        public void print() {
            System.out.println("B class : " + num);   // 외부 클래스의 private 필드 num 직접 사용
        }
    }
}
