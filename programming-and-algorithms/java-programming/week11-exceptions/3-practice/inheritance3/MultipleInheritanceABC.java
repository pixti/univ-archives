/**
 * [11강 실습] 상속 추가 실습 (인터페이스, 컴포지션, 다중 상속) - 4번 문제 (A, B 를 모두 상속받는 C)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MultipleInheritanceABC {

    interface IA {
        void f1();
        void f2();
        void c();
    }

    interface IB {
        void g1();
        void g2();
        void c();
    }

    static class A implements IA {
        private int x, y;
        public void f1() { System.out.print("f1 in A"); }
        public void f2() { System.out.print("f2 in A"); }
        public void c() { System.out.print("c in A"); }
    }

    static class B implements IB {
        private int w, q;
        public void g1() { System.out.print("g1 in B"); }
        public void g2() { System.out.print("g2 in B"); }
        public void c() { System.out.print("c in B"); }
    }

    // (1) static class C extends A, B { ... }   // ❌ 컴파일 에러 : 클래스는 하나만 extends 할 수 있다

    // (2-1) A, B 모두 Composition 사용
    static class CComposition {
        private A a = new A();
        private B b = new B();

        public void f1() { a.f1(); }
        public void f2() { a.f2(); }

        public void g1() { b.g1(); }
        public void g2() { b.g2(); }

        public void c() { a.c(); }

        public void h1() { System.out.print("h1 in C"); }
    }

    // (2-2) 하나는 상속(extends A)받고, 다른 하나만 Composition(B)으로 구현
    static class CExtendsA extends A {
        private B b = new B();

        public void g1() { b.g1(); }
        public void g2() { b.g2(); }

        public void h1() { System.out.print("h1 in C"); }
    }

    // (3-1) IA, IB 인터페이스 다중 구현 + Composition
    static class CInterfaces implements IA, IB {
        private A a = new A();
        private B b = new B();

        public void f1() { a.f1(); }
        public void f2() { a.f2(); }

        public void g1() { b.g1(); }
        public void g2() { b.g2(); }

        public void c() { a.c(); }

        public void h1() { System.out.print("h1 in C"); }
    }

    // (3-2) A 는 그대로 상속(extends A)받고, B 만 인터페이스(implements IB)와 Composition 으로 구현
    static class CExtendsAImplementsIB extends A implements IB {
        private B b = new B();

        public void g1() { b.g1(); }
        public void g2() { b.g2(); }

        public void h1() { System.out.print("h1 in C"); }
    }

    public static void main(String[] args) {
        System.out.print("(2-1) ");
        CComposition ob1 = new CComposition();
        ob1.f1(); ob1.f2(); ob1.c();
        ob1.g1(); ob1.g2(); ob1.c();
        ob1.h1();
        System.out.println();

        System.out.print("(2-2) ");
        CExtendsA ob2 = new CExtendsA();
        ob2.f1(); ob2.f2(); ob2.c();
        ob2.g1(); ob2.g2(); ob2.c();
        ob2.h1();
        System.out.println();

        System.out.print("(3-1) ");
        CInterfaces ob3 = new CInterfaces();
        ob3.f1(); ob3.f2(); ob3.c();
        ob3.g1(); ob3.g2(); ob3.c();
        ob3.h1();
        System.out.println();

        System.out.print("(3-2) ");
        CExtendsAImplementsIB ob4 = new CExtendsAImplementsIB();
        ob4.f1(); ob4.f2(); ob4.c();
        ob4.g1(); ob4.g2(); ob4.c();
        ob4.h1();
        System.out.println();

        IA ia = new CInterfaces();          // 💡 (3) 은 IA 타입으로도 쓸 수 있다 (다형성)
        System.out.print("IA ob = new CInterfaces() → ");
        ia.f1();
        System.out.println();
    }
}
