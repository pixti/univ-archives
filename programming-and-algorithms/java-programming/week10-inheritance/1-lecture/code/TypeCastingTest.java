/**
 * [10-3 상속3] 클래스 형변환 (Type Casting)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class TypeCastingTest {

    static class Poly { }

    static class Square extends Poly { }

    static class A {
        public int x = 53;

        public void print() {
            System.out.println("Parent method :" + x);
        }
    }

    static class B extends A {
        public int x = 17;
        public String y = "abc";

        public void print() {
            System.out.println("Child method :" + x);
            System.out.println("Child method :" + y);
        }
    }

    public static void main(String arg[]) {
        System.out.println("---- Poly / Square ----");
        Poly y = new Square();                      // 묵시적
        System.out.println("Poly y = new Square() : 묵시적 형변환 OK");
        try {
            Square x = (Square) new Poly();         // 명시적 : 컴파일은 되지만 실행 오류
        } catch (ClassCastException e) {
            System.out.println("(Square) new Poly() → " + e.getClass().getName());
        }

        System.out.println("---- (1) 하위 타입의 객체를 상위 타입의 변수에 ----");
        A p = new B();
        p.print();                                  // B 의 메소드 호출
        System.out.println("Parent value : " + p.x); // A 의 필드 접근

        System.out.println("---- (2) 상위 타입의 객체를 하위 타입의 변수에 ----");
        try {
            B p2 = (B) new A();                     // 컴파일 오류 아님. 실행 오류
            p2.print();
            System.out.println("Child value : " + p2.x);
        } catch (ClassCastException e) {
            System.out.println("B p = (B) new A() → " + e.getClass().getName());
        }

        // 아래의 형태는 허용
        A p3 = new B();
        B c = (B) p3;
        c.print();
        System.out.println("Child value : " + c.x);
    }
}
