/**
 * [10-2 상속2] 인터페이스를 이용한 다중 상속
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
