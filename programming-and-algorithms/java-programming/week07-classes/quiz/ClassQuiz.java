/**
 * [7강 퀴즈] 클래스 (클래스와 객체 · getter/setter · static · 내부 클래스)
 *
 *  1. ❶ 클래스와 객체의 차이점  ❷ 데이터 멤버(필드)와 지역 변수의 차이점
 *     ❸ 메서드의 결과값을 반환하는 방법을 쓰시오.                                  → q1()
 *  2. getter / setter 를 사용하는 이유를 쓰시오.                                    → q2()
 *  3. 다음 Audio 클래스 코드의 오류를 모두 찾으시오.                                 → q3()
 *  4. ❶ Time 클래스의 빈칸(print 메서드)을 채우시오.
 *     ❷ 필드를 private 으로 바꾸고 getter/setter 를 사용하도록 수정하시오.          → q4()
 *  5. Point 클래스 ❶ 빈칸 채우기 ❷ getY/setY 작성 ❸ Point 안의 main 작성
 *     ❹ main 을 별도의 PointTest 클래스로 분리하시오.                              → q5()
 *  6. (a) static 필드와 일반 필드 (b) 정적 메서드와 일반 메서드의 차이를 쓰시오.     → q6()
 *  7. 일반 필드 x 와 static 필드 z 를 사용한 코드의 출력 결과를 쓰시오. ★           → q7()
 *  8. static 메서드에서 일반 멤버를 사용한 코드의 오류를 모두 찾아 고치시오.         → q8()
 *  9. 클래스 B 를 클래스 A 의 내부 클래스로 바꾸어 작성하시오.                       → q9()
 *
 * 💡 한 파일 안에서 실행하려고 문제의 클래스들을 아래쪽에 public 없이 넣었다.
 *    같은 이름이 겹치는 것은 이름을 바꿨다. (4번 ❶ Time → Time1, 9번 A → A9)
 *
 * 실행 결과
 *  ===== 1 =====
 *  설계도(클래스) 하나로 만든 객체 2개 : 홍길동, 김철수
 *  필드 기본값 : num = 0, flag = false, name = null
 *  return 으로 받은 값 : 7
 *  ===== 2 =====
 *  나이는 0 이상이어야 합니다.
 *  나이 : 20
 *  ===== 3 =====
 *  볼륨 : 50
 *  ===== 4 =====
 *  11시 35분
 *  11시 35분
 *  ===== 5 =====
 *  100, 200
 *  100, 200
 *  ===== 6 =====
 *  Counter.shared = 2, c1.own = 1, c2.own = 1
 *  Counter.twice(5) = 10
 *  ===== 7 =====
 *  4, 5, 6
 *  8, 8, 8
 *  9
 *  ===== 8 =====
 *  결과 : 0
 *  ===== 9 =====
 *  A class : 5
 *  B class : 10
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

    /**
     * 1. ❶ 클래스와 객체의 차이점
     *
     * 📝 필기 (AI 답변)
     *   - 클래스 (Class) : 객체를 생성하기 위한 "설계도" 또는 "틀(BluePrint)".
     *                      메모리에 직접 할당되지 않는 추상적인 개념이다.
     *   - 객체 (Object / Instance) : 클래스를 바탕으로 메모리(Heap)에 실제로 생성된 실체.
     *                      각자 고유한 상태(필드)와 행동(메서드)을 가진다.
     *
     *      class Person { String name; }          ← 설계도 (메모리에 "사람" 이 생기지 않음)
     *      Person p1 = new Person();              ← 실체 1 (Heap 에 생성)
     *      Person p2 = new Person();              ← 실체 2 (p1 과 별개의 name 을 가짐)
     *
     *    ❷ 데이터 멤버(필드)와 지역 변수의 차이점
     *
     * 📝 필기 (AI 답변)
     *      구분          필드 (데이터 멤버)                        지역 변수
     *      선언 위치     클래스 블록 내부, 메서드 외부              메서드 · 생성자 · 블록 내부
     *      생성 / 소멸   객체 생성 시 Heap 에 생성,                 블록이 실행될 때 Stack 에 생성,
     *                    객체가 소멸될 때 제거                      블록을 벗어나면 소멸
     *      초기화        기본값(0, false, null)으로 자동 초기화     자동 초기화되지 않음
     *                                                               → 사용 전 명시적 초기화 필수
     *      접근 제어자   private, public 등 사용 가능               사용 불가
     *
     *    ❸ 메서드의 결과값을 반환하는 방법
     *
     * 📝 필기 : return 반환값;
     *   💡 반환형이 void 가 아니면 반드시 그 자료형의 값을 return 해야 하고,
     *      void 메서드에서는 return; 만 써서 메서드를 중간에 끝낼 수 있다.
     */
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

    /**
     * 2. getter / setter 를 사용하는 이유
     *
     * 📝 필기 (AI 답변) : 객체 지향 프로그래밍(OOP)의 핵심 원칙인 캡슐화(Encapsulation)와
     *    정보 은닉(Data Hiding)을 위해서
     *   ① 데이터 무결성 및 유효성 검사
     *      필드를 public 으로 열어 두면 아무 값이나 들어갈 수 있다. (예: 나이에 -10)
     *      setter 안에 조건문을 넣으면 잘못된 값이 저장되는 것을 막을 수 있다.
     *   ② 접근 권한 제어
     *      getter 만 만들면 "읽기 전용", setter 만 만들면 "쓰기 전용" 필드가 된다.
     *   ③ 유지보수성
     *      클래스 내부 구조(필드 이름, 저장 방식)가 바뀌어도 외부에서 쓰는 메서드(인터페이스)는
     *      그대로 유지할 수 있어서, 그 클래스를 사용하는 코드를 고치지 않아도 된다.
     *
     * 💡 아래는 ① 의 예 (Age 클래스). 실습 클래스1 2번의 연봉 범위 검사도 같은 방식이다.
     */
    static void q2() {
        Age a = new Age();
        a.setAge(-10);                         // setter 가 막아 준다
        a.setAge(20);
        System.out.println("나이 : " + a.getAge());
        // a.age = -10;                        // ❌ private 이라서 외부에서 직접 못 바꾼다
    }

    /**
     * 3. 다음 코드의 오류를 모두 찾으시오.
     *
     *  ❌ 원본
     *      class Audio {
     *          private int volume;
     *          public void setVolume(int level) {volume = level;};
     *          public int getVolume() {return volume;}
     *          public static void main(String[] args) {
     *              Audio bose;
     *              bose.volume = 50;
     *              int vol = Audio.getVolume();
     *          }
     *      };
     *
     * 📝 필기 (AI 답변)
     *   (1) 객체 미생성 : Audio bose; 는 레퍼런스 변수만 선언한 것. 객체가 없다.
     *        → Audio bose = new Audio();
     *        (error: variable bose might not have been initialized)
     *   (2) private 필드 직접 접근 : bose.volume = 50;
     *        → bose.setVolume(50);   (setter 사용)
     *   (3) 인스턴스 메서드의 정적 호출 : Audio.getVolume();
     *        getVolume() 은 static 이 아니므로 클래스명으로 부를 수 없다.
     *        → int vol = bose.getVolume();
     *        (error: non-static method getVolume() cannot be referenced from a static context)
     *   (4) 불필요한 세미콜론 : setVolume 메서드 뒤의 ; 와 클래스 끝의 };
     *        → 문법 오류는 아니지만 쓰지 않는 것이 관례
     *
     * ⚠ (2) 에 대해 : AI 는 main 을 "외부" 로 보고 오류라고 했지만, 이 main 은 Audio 클래스 "안" 에 있다.
     *    private 은 클래스 단위로 접근을 막으므로 같은 클래스 안의 main 에서는 bose.volume = 50; 도
     *    실제로 컴파일된다. (JDK 25 로 확인 : (1), (3) 만 오류) 다만 main 을 다른 클래스로 옮기면
     *    오류가 되므로 setter 를 쓰는 편이 좋은 습관이다. (실습 클래스1 3번 📝 필기와 같은 내용)
     *
     *  ✅ 수정 (아래 Audio 클래스)
     */
    static void q3() {
        Audio.main(new String[0]);
    }

    /**
     * 4. ❶ 빈칸을 채우시오.
     *
     *      public class Time {
     *          int hour, minute;
     *          ______________________          ← 빈칸
     *          public static void main(String[] args) {
     *              Time t = new Time();
     *              t.hour = 11;
     *              t.minute = 35;
     *              t.print();
     *          }
     *      }
     *
     *  답 : public void print() { System.out.println(hour + "시 " + minute + "분"); }
     *
     *    ❷ 필드를 private 으로 바꾸고, getHour / setHour / getMinute / setMinute 를 추가하여
     *       print() 와 main 이 getter / setter 를 사용하도록 수정하시오.
     *
     *  답 : 아래 Time 클래스 (this.hour = hour; 로 매개변수와 필드 구분)
     *       main 은 t.setHour(11); t.setMinute(35); t.print();
     *
     * 💡 ❶ 의 print() 는 static 이 아니므로 t.print() 처럼 객체로 부른다.
     *    print() 안의 hour, minute 은 "print 를 호출한 객체(t)" 의 필드다. (= this.hour)
     */
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

    /**
     * 5. Point 클래스
     *    ❶ 빈칸 : public int getX() { return x; }
     *             public void setX(int xCoord) { this.x = xCoord; }   (x = xCoord; 도 가능)
     *    ❷ getY / setY(int yCoord) 를 같은 방식으로 작성
     *    ❸ Point 클래스 안에 main 작성 : p1 = new Point(); p1.setX(100); p1.setY(200);
     *    ❹ main 을 별도의 클래스 PointTest 로 분리
     *
     * 📝 필기
     *   - 하나의 .java 소스 파일 안에는 public class 를 단 하나만 선언할 수 있다.
     *   - public class 의 이름은 파일명과 정확히 일치해야 한다.
     *
     * 📝 필기 (AI 답변) ❹ 를 작성하는 두 가지 방법
     *   방법 1 : 파일을 2개로 나눈다.  (둘 다 public 가능)
     *       Point.java       → public class Point { ... }
     *       PointTest.java   → public class PointTest { main ... }
     *   방법 2 : 한 파일(PointTest.java)에 같이 쓴다.
     *       public class PointTest { main ... }      ← 파일명과 같은 클래스만 public
     *       class Point { ... }                      // public을 빼야 컴파일 에러가 나지 않습니다.
     *
     * 💡 이 퀴즈 파일이 바로 방법 2 의 형태다. (public class 는 ClassQuiz 하나뿐)
     * 💡 xCoord 처럼 매개변수 이름이 필드(x)와 다르면 this 가 없어도 된다.
     *    매개변수 이름을 x 로 지으면 this.x = x; 로 써야 한다.
     * 💡 출력문은 문제에 없어서 확인용으로 getX(), getY() 출력을 추가했다.
     */
    static void q5() {
        Point.main(new String[0]);        // ❸ Point 안의 main
        PointTest.main(new String[0]);    // ❹ 별도 클래스 PointTest 의 main
    }

    /**
     * 6. (a) static 필드와 일반 필드의 차이  (b) 정적 메서드와 일반 메서드의 차이
     *
     * 📝 필기 (AI 답변)
     *   (a) static 필드 (클래스 변수)
     *       - 클래스가 메모리에 로드될 때 메서드(static) 영역에 "단 한 번" 생성된다.
     *       - 해당 클래스로 만든 모든 객체가 공유한다.
     *       - 접근 : 클래스명.필드명
     *       일반 필드 (인스턴스 변수)
     *       - new 로 객체를 생성할 때마다 Heap 영역에 객체마다 따로 생성된다.
     *       - 접근 : 객체변수.필드명
     *   (b) 정적 메서드
     *       - 객체 생성 없이 클래스명.메서드명() 으로 호출한다.
     *       - static 멤버(필드, 메서드)만 직접 사용할 수 있다.
     *         객체가 없으므로 인스턴스 멤버와 this 는 사용할 수 없다.
     *       일반 메서드
     *       - 객체를 생성해야 호출할 수 있다. (객체.메서드명())
     *       - 인스턴스 멤버와 static 멤버 모두 사용할 수 있다.
     *
     * 📝 필기 (+ 보충 설명)
     *   - 일반 필드는 객체 생성시마다 따로따로 할당된다.
     *   - 일반 필드는 객체 생성 없이는 접근할 수 없다. 객체를 생성해야 한다.
     *   - 스태틱 필드는 같은 클래스내에 객체마다가 아니라 하나만 공유되는 형태로 할당된다.
     *   - 스태틱 필드는 객체 생성 없이도 접근이 가능하다.
     *   - 메서드도 마찬가지다. non-static 메서드와 static 메서드가 있다.
     *   - 일반 메서드는 반드시 객체를 생성하고 객체.메서드명() 로 접근한다.
     *   - 스태틱 메서드는 클래스명.메서드명() 으로 객체 생성 없이 접근 가능하다.
     *
     *          ┌─── Counter (클래스당 하나) ───┐
     *          │ static int shared = 2         │ ◀── c1, c2 공유
     *          └───────────────────────────────┘
     *      c1 ──▶ [ own = 1 ]     c2 ──▶ [ own = 1 ]   ← 객체마다 따로
     */
    static void q6() {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        c1.increase();
        c2.increase();
        System.out.println("Counter.shared = " + Counter.shared + ", c1.own = " + c1.own + ", c2.own = " + c2.own);
        System.out.println("Counter.twice(5) = " + Counter.twice(5));   // 객체 없이 클래스명으로 호출
    }

    /**
     * 7. 다음 코드의 출력 결과를 쓰시오.   ★) 기말고사 출제 유력
     *
     *      class Test {  main :
     *          (ob1, ob2, ob3 를 각각 new A() 로 생성)
     *          ob1.x = 3;  ob2.x = 4;  ob3.x = 5;
     *          ob1.x++;    ob2.x++;    ob3.x++;
     *          System.out.println(ob1.x + ", " + ob2.x + ", " + ob3.x);
     *          ob1.z = 3;  ob2.z = 4;  ob3.z = 5;
     *          ob1.z++;    ob2.z++;    ob3.z++;
     *          System.out.println(ob1.z + ", " + ob2.z + ", " + ob3.z);
     *      }
     *      class A { public int x; public static int z; }
     *
     *  답 : 4, 5, 6
     *       8, 8, 8
     *
     * 📝 필기
     *   - x는 일반 필드, z는 static 필드
     *   - ob1, ob2, ob3 객체에 저장하여 사용하고자 한다.
     *   - 각 ob1, ob2, ob3 객체마다 x가 각각 별개로 존재 한다. x=3 , x=4, x=5 이렇게.
     *   - ob1.x++, ob2.x++, ob3.x++ 하게 되면 각각 별개로 존재하던 x가 각각 증가함. x=4 , x=5, x=6.
     *     따라서 4, 5, 6이 출력 됨.
     *   - class A에서 static 필드로 z는 단 하나만 존재함
     *   - ob1.z == ob2.z == ob3.z 단 하나이므로 같은 공간을 점유하고
     *     가장 마지막에 대입된 ob3.z = 5 즉 z=5
     *   - ob1.z++, ob2.z++, ob3.z++ 하게 되면 6,7,8 로 ++ 가 3번 증가하게 되어 8, 8, 8이 출력 됨.
     *   - A.z = 5; A.z++; 로 이렇게 클래스명으로도 접근이 가능함. static 이므로.
     *     (⚠ 필기에는 a.z =5; 로 적혀 있었는데, 클래스명으로 접근한다는 뜻이므로 A.z 로 고쳤다)
     *
     *      ob1 ──▶ [ x: 3 → 4 ]
     *      ob2 ──▶ [ x: 4 → 5 ]          A.z (하나뿐) : 3 → 4 → 5 → 6 → 7 → 8
     *      ob3 ──▶ [ x: 5 → 6 ]                         대입  대입  대입  ++  ++  ++
     *
     * 💡 세 객체를 모두 new A() 로 만들어야 한다.
     *    A ob1, ob2, ob3 = new A(); 처럼 쓰면 ob3 만 초기화되어 컴파일 오류가 난다.
     *      error: variable ob1 might not have been initialized
     *    (반대로 z 만 쓰는 코드라면 static 필드는 객체가 없어도 되지만, 지역 변수 ob1 은
     *     초기화되지 않으면 쓸 수 없다)
     */
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

    /**
     * 8. 다음 코드의 오류를 모두 찾아 고치시오.
     *
     *  ❌ 원본
     *      public class Test {
     *          private int x, y;
     *          private static int z;
     *          public static void f1() {
     *              int r = f2();
     *              System.out.println(“결과 : ” + r);
     *          }
     *          public int f2() { return z++; }
     *          public static int f3() { return x + y; }
     *          public int f4() { return z--; }
     *          public static void main(String[] args) {
     *              x = 3; y = 5; z = 0;
     *              f1();
     *          }
     *      }
     *
     * 📝 필기 (AI 답변) 주요 오류
     *   (1) static 메서드 f1() 에서 인스턴스 메서드 f2() 호출
     *       (error: non-static method f2() cannot be referenced from a static context)
     *   (2) static 메서드 f3() 에서 인스턴스 필드 x, y 참조
     *       (error: non-static variable x cannot be referenced from a static context)
     *   (3) static 메서드 main 에서 인스턴스 필드 x, y 에 값 대입
     *   (4) 스마트 따옴표 “ ” → 일반 따옴표 " "
     *  ✅ 수정 : private static int x, y;  /  public static int f2()  /  따옴표 수정  /  f4() 는 그대로
     *
     * 📝 필기
     *   - f2() 는 static 메서드가 아니다. 따라서 static 메서드 f1() 에서 호출할 수 없다.
     *     (⚠ 필기에는 "static 필드 접근이 안된다" 로 적혀 있었다. f2() 가 일반 메서드라도 static 필드 z 에는
     *      접근할 수 있다. 문제는 static 인 f1() 이 객체 없이 일반 메서드 f2() 를 부르는 것이다.)
     *   - f2()를 스태틱으로 변경하게 되면 사용할 수 있는게 지역변수거나 static 필드거나
     *     static 메서드만 사용가능하게 제약이 변경. z가 static 변수이므로 잘 작동함.
     *   - static메서드 안에서는 일반 필드로 접근 할 수 없음. x와 y는 일반 필드임.
     *     x와 y를 static 필드로 변경해야 f3()이 접근 가능해짐.
     *
     * 📝 필기 (AI 답변) static 메서드와 멤버 접근 제약 정리
     *   - static 메서드 안에서는 인스턴스 필드 / 인스턴스 메서드에 직접 접근할 수 없다. (this 도 없음)
     *   - static 메서드 안에서 사용 가능한 것 : 지역 변수, static 필드, static 메서드
     *
     *      메서드 안에서   일반 필드  일반 메서드  static 필드  static 메서드  this
     *      static 메서드      ❌         ❌           ✅           ✅          ❌
     *      일반 메서드        ✅         ✅           ✅           ✅          ✅
     *
     * 💡 f4() 는 일반 메서드라서 static 필드 z 를 써도 문제없다. (그래서 그대로 둔다)
     * 💡 z++ 는 "후위 증가" 라서 현재 값 0 을 먼저 반환하고 z 를 1 로 만든다. → 결과 : 0
     *
     *  실행 결과 : 결과 : 0
     */
    static void q8() {
        Test.main(new String[0]);
    }

    /**
     * 9. 다음 코드에서 클래스 B 를 클래스 A 의 내부 클래스로 바꾸어 작성하시오.
     *
     *  ❌ 원본
     *      public class Main {
     *          public static void main(String[] args) {
     *              A outer = new A();
     *              outer.display_Inner();
     *              B inner = new B();
     *              inner.print();
     *          }
     *      }
     *      class A {
     *          private int num = 10;
     *          public int getNum() { return num; }
     *          public void display_Inner() {
     *              B ob = new B();
     *              System.out.println("A class : " + ob.getX());
     *          }
     *      }
     *      class B {
     *          private int x = 5;
     *          public int getX() { return x; }
     *          A ob = new A();
     *          System.out.println("B class : " + ob.getNum());
     *      }
     *
     * ⚠ 원본의 B 는 System.out.println(...) 문이 메서드 밖(클래스 몸체)에 바로 있어서 컴파일 오류가 난다.
     *    (error: <identifier> expected) 또 main 에서 부르는 inner.print() 메서드도 B 에 없다.
     *    답안에서는 이 부분을 print() 메서드로 만들었다.
     *
     *  ✅ 답 (아래 A9 클래스 - 원래 이름은 A, 7번의 A 와 겹쳐서 A9 로 바꿈)
     *      class A {
     *          private int num = 10;
     *          ...
     *          public class B {
     *              private int x = 5;
     *              public int getX() { return x; }
     *              public void print() { System.out.println("B class : " + num); }   ← 외부의 private num 직접 사용
     *          }
     *      }
     *      main : A outer = new A();
     *             outer.display_Inner();
     *             A.B inner = outer.new B();
     *             inner.print();
     *
     * 📝 필기 : Java 내부 클래스 문법
     *   - new A, new B로 생성했었지만 B가 내부 클래스 inner class가 되게 되었으므로
     *     A outer = new A(); B inner = new B(); 에서 B 클래스를 접근할 때 아래 처럼 변경한다.
     *         A.B inner = outer.new B();
     *
     * 📝 필기 (AI 답변)
     *   - 내부 클래스(인스턴스 멤버 클래스)는 외부 클래스의 객체가 먼저 존재해야 생성할 수 있다.
     *     그래서 outer.new B() 처럼 외부 객체를 통해 만들고, 타입은 A.B 로 쓴다.
     *
     * 💡 B 가 A 안으로 들어가면서 B 안에서 new A() 로 A 객체를 따로 만들 필요가 없어졌다.
     *    내부 클래스는 자신을 만든 외부 객체(outer)의 필드 num 을 getNum() 없이 바로 쓸 수 있다.
     */
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

// ───────────────────────── 3번 (✅ 수정) ─────────────────────────
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

// ───────────────────────── 8번 (✅ 수정) ─────────────────────────
class Test {
    private static int x, y;                  // ✅ static 추가 → f3(), main 에서 사용 가능
    private static int z;

    public static void f1() {
        int r = f2();
        System.out.println("결과 : " + r);     // ✅ 스마트 따옴표 → 일반 따옴표
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
