import otherpkg.A;

/**
 * [10-1 상속1] 상속 및 접근 제어 - 다른 패키지에서의 접근
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class OtherPackageAccessTest {

    static class B extends A {     // (4) 다른 패키지 내의 하위 클래스
        void test() {
            // System.out.println(a);   // ❌ 접근 오류 : a has private access in A
            // System.out.println(b);   // ❌ 접근 오류 : b is not public in A; cannot be accessed from outside package
            System.out.println(c);
            System.out.println(d);
        }
    }

    static class C {               // (5) 다른 패키지 내의 비하위 클래스
        void test() {
            A ob = new A();
            // System.out.println(ob.a);   // ❌ 접근 오류
            // System.out.println(ob.b);   // ❌ 접근 오류
            // System.out.println(ob.c);   // ❌ 접근 오류 : c has protected access in A
            System.out.println(ob.d);
        }
    }

    public static void main(String[] args) {
        System.out.println("---- (4) 다른 패키지의 하위 클래스 ----");
        new B().test();
        System.out.println("---- (5) 다른 패키지의 비하위 클래스 ----");
        new C().test();
    }
}
