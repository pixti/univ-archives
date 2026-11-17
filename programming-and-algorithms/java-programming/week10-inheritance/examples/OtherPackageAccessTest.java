import otherpkg.A;

/**
 * [10-1 상속1] 상속 및 접근 제어 - 다른 패키지에서의 접근
 *
 * 포인트
 *  (4) 다른 패키지 내의 하위 클래스 : protected 와 public 만 접근 가능  → B.test()
 *  (5) 다른 패키지 내의 비하위 클래스 : public 만 접근 가능             → C.test()
 *  - 부모 클래스 A 는 otherpkg 패키지에 있다. (examples/otherpkg/A.java)
 *      package otherpkg;
 *      public class A { private int a = 1; int b = 5; protected int c = 10; public int d = 15; }
 *
 * 💡 protected = default(같은 패키지) + 다른 패키지의 하위 클래스.
 *    부모가 자식에게만 물려주고 바깥에는 숨기고 싶은 멤버에 쓴다.
 * ⚠ 자주 틀리는 부분 : 다른 패키지의 하위 클래스라도 "부모 타입 객체를 새로 만들어서" protected 멤버에 접근할 수는 없다.
 *      A ob = new A();  ob.c   → ❌ error: c has protected access in A
 *    자기 자신(this)이 물려받은 c 로만 접근할 수 있다.
 * 💡 이 파일의 B, C 는 같은 폴더의 다른 예제(AccessControlTest.java)의 B, C 와 이름이 겹치지 않도록
 *    OtherPackageAccessTest 안에 static 중첩 클래스로 넣었다. 부모 A 가 다른 패키지에 있으므로 접근 규칙은 그대로다.
 *    (강의 코드에서는 (4), (5) 의 클래스 이름이 둘 다 B)
 * 💡 JDK 22 이상에서는 java examples/OtherPackageAccessTest.java 로 실행하면 otherpkg/A.java 도 자동으로 찾아 컴파일한다.
 *
 * 실행 결과
 *  ---- (4) 다른 패키지의 하위 클래스 ----
 *  10
 *  15
 *  ---- (5) 다른 패키지의 비하위 클래스 ----
 *  15
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
