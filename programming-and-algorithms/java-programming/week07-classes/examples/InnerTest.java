/**
 * [8-5] 내부 클래스 (inner class)
 *
 * 포인트
 *  - 클래스 내부(outer class)에 다시 클래스(inner class)를 정의할 수 있다.
 *  - 내부 클래스는 외부 클래스의 필드, 메소드를 마음대로 접근할 수 있다. (Inner.print 에서 Outer 의 num 사용)
 *  - 반대로 Inner 의 private 멤버도 Outer 에서 접근할 수 있다. (display_Inner 에서 inner.x)
 *  - 내부 클래스가 public 이나 접근자 없이 선언되면, 다른 클래스에서 내부 클래스 타입의 객체를
 *    직접 생성하여 사용할 수 있다.
 *        Outer outer = new Outer();                 // ① 외부 클래스 객체를 먼저 만들고
 *        Outer.Inner inner = outer.new Inner();     // ② 그 외부 객체를 통해 내부 클래스 객체 생성
 *    → 내부 클래스 객체는 "어느 Outer 객체의 num 인지" 알아야 하므로 외부 객체 없이는 만들 수 없다.
 *
 *      outer ──▶ [ Outer : num = 10 ]
 *                       ▲
 *                       │ (바깥 객체를 기억)
 *      inner ──▶ [ Inner : x = 5 ]  → print() 에서 num 을 쓰면 이 Outer 의 num
 *
 *  - 📝 퀴즈 9번 필기 : B가 내부 클래스 inner class가 되면 B inner = new B(); 를
 *    A.B inner = outer.new B(); 로 변경한다.
 *
 * ⚠ 슬라이드 4 는 "앞의 Inner 클래스의 접근자를 private 에서 public 으로 바꾼 후 실행" 하라고 한다.
 *    private class Inner 그대로면 InnerTest 에서 Outer.Inner 를 쓸 수 없다.
 *      error: Outer.Inner has private access in Outer
 *    그래서 아래에서는 public class Inner 로 바꿨다. (슬라이드의 "privat" 은 private 의 오타)
 *
 * 실행 결과
 *  5
 *  This is an inner class : 10
 *  This is an inner class : 10
 */
public class InnerTest {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.display_Inner();                       // 슬라이드 2, 3 : Outer 안에서 Inner 사용

        Outer.Inner inner = outer.new Inner();       // 슬라이드 4 : 바깥에서 Inner 객체 생성
        inner.print();
    }
}

class Outer {
    int num = 10;

    public class Inner {                             // ⚠ 슬라이드 2, 3 은 private class Inner
        private int x = 5;
        public void print() {
            System.out.println("This is an inner class : " + num);   // outer의 num 사용
        }
    }

    void display_Inner() {
        Inner inner = new Inner();                   // Outer 안에서는 그냥 new Inner()
        System.out.println(inner.x);                 // inner의 private도 outer에서 접근
        inner.print();
    }
}
