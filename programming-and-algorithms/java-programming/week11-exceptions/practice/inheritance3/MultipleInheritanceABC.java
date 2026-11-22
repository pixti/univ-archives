/**
 * [11강 실습] 상속 추가 실습 (인터페이스, 컴포지션, 다중 상속) - 4번 문제 (A, B 를 모두 상속받는 C)
 *
 * 문제
 *  다음과 같이 클래스 A, B 가 주어졌을 때 이 둘 모두를 상속받는 C 클래스를 정의하라.
 *  (1) 다중 상속을 이용한 구현을 하시오.
 *  (2) composition 을 이용하여 구현하라.
 *  (3) 인터페이스와 composition 을 이용하여 구현하라.
 *
 *    public class A {
 *        private int x, y;
 *        public void f1() {System.out.print("f1 in A");}
 *        public void f2() {System.out.print("f2 in A");}
 *        public void c() {System.out.print("c in A");}
 *    }
 *    public class B {
 *        private int w, q;
 *        public void g1() {System.out.print("g1 in B");}
 *        public void g2() {System.out.print("g2 in B");}
 *        public void c() {System.out.print("c in B");}
 *    }
 *    public class Main {
 *        public static void main(String[] args) {
 *            C ob = new C();
 *            ob.f1(); ob.f2(); ob.c();
 *            ob.g1(); ob.g2(); ob.c();
 *            ob.h1();
 *        }
 *    }
 *
 * 📝 필기 : ★) Java 에서는 클래스의 다중 상속이 불가능하다. has-a 관계로 변경하거나 인터페이스의 다중 상속이 가능함을 이용한다.
 *
 * 📝 필기 (정답) : (1) 자바에서는 "extends A, B" 와 같이 두 개 이상의 클래스를 동시에 상속받는 다중 상속을 문법적으로 금지한다.
 *    특히 클래스 A 와 B 모두 동일한 시그니처의 "public void c()" 메소드를 가지고 있기 때문에, 다중 상속이 허용될 경우
 *    C 객체에서 c() 를 호출할 때 어느 부모의 c() 를 실행해야 할지 알 수 없는 모호성(Diamond Problem)이 발생하기 때문이다.
 *
 * 📝 필기 : 1. 핵심 개념 정리 - IS-A (상속) vs HAS-A (포함). 클래스들이 서로 관계를 맺고 기존 코드를 재사용하는 방법에는 크게 두 가지가 있다.
 *   ① 상속 (Inheritance) - IS-A 관계 ("~은 ~이다")
 *      - 개념 : 부모 클래스의 변수와 메소드를 자식 클래스가 그대로 물려받는 것이다. 자바에서는 extends 키워드를 쓴다.
 *      - 비유 : 강아지(자식) is a 동물(부모). (강아지는 동물이다.)
 *      - 특징 : 부모의 기능을 내 것처럼 바로 쓸 수 있다. 다형성(Polymorphism)이 성립한다. 즉, 동물 ob = new 강아지(); 처럼
 *               부모 타입으로 자식 객체를 다룰 수 있다.
 *      - 단점 (자바의 제약) : 자바에서는 클래스의 다중 상속을 금지한다. (부모 클래스를 동시에 2개 이상 둘 수 없음)
 *   ② 포함 / 구성 (Composition) - HAS-A 관계 ("~은 ~을 가지고 있다")
 *      - 개념 : 다른 클래스를 상속받는 대신, 내 클래스 안에 멤버 변수(부품)로 선언해서 가져다 쓰는 것이다.
 *      - 비유 : 자동차 has a 엔진. (자동차는 엔진이다(X) → 자동차는 엔진을 부품으로 가지고 있다(O))
 *      - 특징 : 내 클래스 안에 다른 클래스의 객체를 생성(new)해 두고, 필요한 기능이 있을 때 그 객체의 메소드를 대신 호출해 준다.
 *               (이를 위임, Delegation 이라고 한다)
 *               개수 제한 없이 여러 클래스를 부품처럼 가져다 쓸 수 있으므로 다중 상속의 대안으로 쓰인다.
 *
 * 📝 필기 : 2. 출제 의도 파악 - 왜 A 와 B 둘 다 c() 메소드를 가지고 있을까?
 *   문제의 코드를 보면 A 클래스에도 public void c() 가 있고, B 클래스에도 똑같은 이름의 public void c() 가 있다.
 *   만약 C 클래스가 A 와 B 를 동시에 상속받은 뒤, Main 에서 ob.c() 를 호출하면 컴퓨터는 A 의 c() 를 실행해야 할까, B 의 c() 를
 *   실행해야 할까? 컴퓨터 입장에서는 도저히 알 수가 없다. 이를 객체지향에서 다이아몬드 문제(Diamond Problem, 다중 상속의 모호성)라고 부른다.
 *   이 문제의 (1), (2), (3) 번은 "자바에서 다중 상속이 왜 안 되는지 이해하고(1번), 이를 Composition(2번)과 인터페이스(3번)로
 *   어떻게 해결하는가?" 를 단계별로 질문하고 있다.
 *
 * 📝 필기 : 3. 문제 단계별 풀이 및 코드
 *   (1) 다중 상속을 이용하여 구현하시오.
 *     결론부터 말하면, 자바(Java)에서는 문법적으로 불가능하다(컴파일 에러). 이 문제는 "가상으로 작성해 보고 왜 에러가 나는지 설명하라" 는 의도다.
 *       // [문법 에러가 발생하는 코드]
 *       public class C extends A, B {   // 에러! 자바는 클래스를 2개 이상 extends 할 수 없음
 *           public void h1() {
 *               System.out.print("h1 in C");
 *           }
 *       }
 *     - 답안 작성 팁 : 위 코드를 적은 후, "자바는 다중 상속을 지원하지 않으므로 컴파일 에러가 발생한다. 특히 A 와 B 에 동일한
 *       시그니처의 c() 메소드가 존재하여 어떤 부모의 메소드를 호출할지 모호해지기(Diamond Problem) 때문이다." 라고 덧붙이면 된다.
 *     - 실제로 이클립스에서 실행하면 C extends A, B 줄에 빨간 줄이 생기고, 실행하면 다음과 같이 나온다.
 *         Exception in thread "main" java.lang.Error: Unresolved compilation problems:
 *             The method g1() is undefined for the type C
 *             The method g2() is undefined for the type C
 *             at Main.main(Main.java:26)
 *       (javac 로 컴파일하면 error: '{' expected)
 *
 *   (2) Composition (포함)을 이용하여 구현하라.
 *     상속(extends)을 포기하고, HAS-A 관계를 이용해 C 클래스 내부에 A 와 B 의 객체를 부품처럼 생성해 놓고 기능을 빌려 쓰는
 *     (위임하는) 방식이다. (참고 : A 는 상속(extends)받고 B 만 Composition 으로 넣는 방법도 있지만, 아래 코드는 가장 순수한 Composition 방식이다)
 *       public class C {
 *           // 1. A 와 B 객체를 멤버 변수로 포함 (HAS-A 관계)
 *           private A a = new A();
 *           private B b = new B();
 *           // 2. A 의 기능들을 위임(Delegation)하여 구현
 *           public void f1() { a.f1(); }
 *           public void f2() { a.f2(); }
 *           // 3. B 의 기능들을 위임(Delegation)하여 구현
 *           public void g1() { b.g1(); }
 *           public void g2() { b.g2(); }
 *           // 4. 충돌이 났던 c() 메소드를 개발자가 직접 제어할 수 있음!
 *           public void c() {
 *               a.c();   // 또는 b.c(); 상황에 맞게 선택하거나 둘 다 호출 가능
 *           }
 *           // 5. C 고유의 메소드
 *           public void h1() { System.out.print("h1 in C"); }
 *       }
 *     - 특징 및 한계 : 이렇게 하면 Main 클래스의 코드가 에러 없이 완벽하게 돌아간다. 모호했던 c() 메소드도 개발자가 직접 a.c() 를
 *       부를지 b.c() 를 부를지 정해 줄 수 있다.
 *     - 하지만 단점이 하나 있다 : C 는 A 나 B 를 상속받은 것이 아니기 때문에 IS-A 관계가 깨진다. 즉, A ob = new C(); 또는
 *       B ob = new C(); 처럼 다형성을 활용할 수 없다. 이를 해결하기 위해 (3) 번 방법이 등장한다.
 *
 *   (3) 인터페이스와 Composition 을 이용하여 구현하라.
 *     자바는 클래스의 다중 상속은 막아 두었지만, 인터페이스(Interface)의 다중 상속(구현)은 허용한다!
 *     왜냐하면 인터페이스는 껍데기(선언)만 있고 알맹이(구현 코드)가 없어서, 이름이 겹쳐도 충돌이 나지 않기 때문이다.
 *     따라서 인터페이스로 IS-A(타입 상속) 관계를 만들고, 내부 구현은 Composition(HAS-A)으로 채워 넣는 것이 자바에서
 *     다중 상속을 완벽히 대체하는 정석 패턴이다.
 *       // 1. A 와 B 의 껍데기 역할을 할 인터페이스 정의
 *       interface IA { void f1(); void f2(); void c(); }
 *       interface IB { void g1(); void g2(); void c(); }
 *       // 2. 기존 A, B 클래스가 인터페이스를 구현하도록 수정
 *       public class A implements IA { ... }
 *       public class B implements IB { ... }
 *       // 3. C 클래스는 인터페이스 IA, IB 를 다중 상속(구현)받고, 실제 동작은 Composition 으로 처리!
 *       // (또는 public class C extends A implements IB 로 작성해도 됩니다)
 *       public class C implements IA, IB {
 *           // Composition (HAS-A) 으로 부품 장착
 *           private A a = new A();
 *           private B b = new B();
 *           // IA 인터페이스 메소드 구현 (A 객체에게 위임)
 *           public void f1() { a.f1(); }
 *           public void f2() { a.f2(); }
 *           // IB 인터페이스 메소드 구현 (B 객체에게 위임)
 *           public void g1() { b.g1(); }
 *           public void g2() { b.g2(); }
 *           // 겹치는 c() 메소드도 문제없이 오버라이딩하여 직접 결정
 *           public void c() {
 *               a.c();   // 필요에 따라 b.c() 호출도 가능
 *           }
 *           // C 의 고유 메소드
 *           public void h1() { System.out.print("h1 in C"); }
 *       }
 *
 * 📝 필기 : 💡 한눈에 보는 요약 정리
 *     구분                    (1) 다중 상속 (extends A, B)   (2) Composition 만 사용          (3) 인터페이스 + Composition
 *     자바 문법 허용 여부     불가능 (컴파일 에러)            가능                             가능 (가장 이상적인 방법)
 *     관계                    IS-A                            HAS-A                            IS-A + HAS-A 모두 만족
 *     코드 재사용             자동 상속됨                     내부 객체에 위임(Delegation)     내부 객체에 위임(Delegation)
 *     다형성 (IA ob = new C()) -                              불가능 (C 는 A 나 B 타입이 아님)  가능 (C 는 IA 이자 IB 타입이 됨)
 *
 * 처음 작성한 코드 (네 가지 방법을 모두 실행해 봤다. 아래 main 에서 차례로 확인)
 *   (2-1) A, B 모두 Composition 사용                                            → CComposition
 *   (2-2) 하나는 상속(extends A)받고, 다른 하나만 Composition(B)으로 구현          → CExtendsA
 *   (3-1) IA, IB 인터페이스 다중 구현 + Composition                              → CInterfaces
 *   (3-2) A 는 그대로 상속(extends A)받고, B 만 인터페이스(implements IB)와 Composition 으로 구현 → CExtendsAImplementsIB
 *   네 방법 모두 실행 결과는 f1 in Af2 in Ac in Ag1 in Bg2 in Bc in Ah1 in C 로 같다.
 *
 * 💡 (3-2) 의 C 에는 c() 가 없는데도 IB 의 c() 를 구현하라는 오류가 나지 않는다. 부모 A 에게서 물려받은 public void c() 가
 *    IB 의 c() 를 대신 구현하기 때문이다. 그래서 ob.c() 는 "c in A" 를 출력한다.
 * 💡 print 는 줄을 바꾸지 않아서 출력이 한 줄로 붙어 나온다. 문제의 출력 형식 그대로 두었다.
 * 💡 이클립스는 A 의 x, y 와 B 의 w, q 에 "사용하지 않는 필드" 노란 경고를 표시한다. 문제에 주어진 필드라 그대로 두었다.
 * 💡 한 파일에서 네 버전을 실행하려고 A, B, IA, IB 와 네 가지 C 를 MultipleInheritanceABC 안에 static 중첩 클래스로 넣었다.
 *    (2) 의 A, B 는 원래 인터페이스를 구현하지 않지만, 여기서는 (3) 에서 쓰려고 implements IA / IB 를 붙인 하나의 A, B 를 함께 썼다.
 *
 * 실행 결과
 *  (2-1) f1 in Af2 in Ac in Ag1 in Bg2 in Bc in Ah1 in C
 *  (2-2) f1 in Af2 in Ac in Ag1 in Bg2 in Bc in Ah1 in C
 *  (3-1) f1 in Af2 in Ac in Ag1 in Bg2 in Bc in Ah1 in C
 *  (3-2) f1 in Af2 in Ac in Ag1 in Bg2 in Bc in Ah1 in C
 *  IA ob = new CInterfaces() → f1 in A
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
