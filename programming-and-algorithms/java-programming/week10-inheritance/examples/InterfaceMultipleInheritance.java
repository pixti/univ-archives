/**
 * [10-2 상속2] 인터페이스를 이용한 다중 상속
 *
 * 포인트
 *  - 자바는 클래스를 두 개 이상 extends 할 수 없다.  class C extends A, B  → ❌
 *  - 대신 클래스 하나를 상속하고(extends A), 인터페이스(IB)를 구현한다.
 *    인터페이스의 메소드는 그 인터페이스를 이미 구현한 클래스 B 의 객체를 필드로 두고 "일을 맡긴다".
 *
 *      class A { f1(), f2() }          interface IB { g1(), g2() }
 *            ▲                                ▲              ▲
 *            │ extends                        │ implements   │ implements
 *            │                                │              │
 *      class C extends A implements IB ───────┘        class B implements IB
 *        - ob = new B()  ───────────────────────────────▶ (B 객체를 필드로 가짐)
 *        - g1() { ob.g1(); }   g2() { ob.g2(); }   → B 에게 맡김
 *        - h1(), h2()          → C 에 새로 추가
 *
 *    → C 는 A 의 기능(f1, f2)은 상속으로, B 의 기능(g1, g2)은 포함(B 객체에게 맡기기)으로 가진다.
 *      C 는 A 타입으로도, IB 타입으로도 쓸 수 있다.
 *
 * 💡 강의 코드는 public class A, B, C 를 한 화면에 보여 준다. 실제로는 public class 는 파일마다 하나라서 파일을 나눠야 한다.
 *    여기서는 InterfaceMultipleInheritance 안에 static 중첩 클래스로 넣었다.
 * 💡 이렇게 다른 객체에게 일을 맡기는 것을 위임(delegation)이라고 한다. MultipleInheritanceTest.java 의 Pickup 도 같은 방식이다.
 *
 * 실행 결과
 *  A.f1()
 *  A.f2()
 *  B.g1()
 *  B.g2()
 *  C.h1()
 *  C.h2()
 *  ---- IB 타입으로 ----
 *  B.g1()
 */
public class InterfaceMultipleInheritance {

    static class A {
        public void f1() { System.out.println("A.f1()"); }
        public void f2() { System.out.println("A.f2()"); }
    }

    interface IB {
        public void g1();
        public void g2();
    }

    static class B implements IB {
        public void g1() { System.out.println("B.g1()"); }
        public void g2() { System.out.println("B.g2()"); }
    }

    static class C extends A implements IB {     // 다중 상속의 예
        private B ob = new B();

        public void g1() { ob.g1(); }            // IB 의 메소드는 B 객체에게 맡긴다
        public void g2() { ob.g2(); }
        public void h1() { System.out.println("C.h1()"); }
        public void h2() { System.out.println("C.h2()"); }
    }

    public static void main(String[] args) {
        C c = new C();
        c.f1();          // A 에게서 상속
        c.f2();
        c.g1();          // IB 구현 (B 에게 맡김)
        c.g2();
        c.h1();          // C 에서 추가
        c.h2();

        System.out.println("---- IB 타입으로 ----");
        IB ib = c;       // C 는 IB 타입으로도 쓸 수 있다
        ib.g1();
    }
}
