/**
 * [10-1 상속1] 상속 및 접근 제어 - 같은 패키지 안에서의 접근
 *
 * 포인트
 *  - 상속 : 부모 클래스에 정의된 필드와 메소드를 물려받는 것. extends 키워드로 부모 클래스를 지정한다.
 *      class Subclass extends Superclass { … }
 *  - 접근자에 따라 하위 클래스에서 쓸 수 있는 부모 클래스의 기능이 제한된다.
 *
 *                              private   default   protected   public
 *      동일 클래스                O         O          O          O
 *      동일 패키지 하위 클래스      X         O          O          O
 *      동일 패키지 비하위 클래스    X         O          O          O
 *      다른 패키지 하위 클래스      X         X          O          O
 *      다른 패키지 비하위 클래스    X         X          X          O
 *
 *  (1) 동일 클래스 : 접근자의 종류와 상관없이 모든 필드와 메소드에 접근할 수 있다.        → A.test()
 *  (2) 동일 패키지 하위 클래스 : private 를 뺀 나머지에 접근할 수 있다.                   → B.test()
 *  (3) 동일 패키지 비하위 클래스 : 하위 클래스와 똑같이 private 를 뺀 나머지에 접근할 수 있다. → C.test()
 *  (4) (5) 다른 패키지 → OtherPackageAccessTest.java
 *
 * ⚠ 자주 틀리는 부분 : private 필드도 "물려받기는" 한다. B 객체 안에는 a 가 들어 있다.
 *    다만 B 의 코드에서 a 라는 이름으로 직접 쓸 수 없을 뿐이다. 부모의 public 메소드(getter 등)를 거치면 쓸 수 있다.
 *    (퀴즈 2번 (2) 📝 필기 : 상속을 받으면 부모 클래스 private 데이터도 물려받는데 임의로 건드릴 수 없음)
 * 💡 같은 패키지 안에서는 default 와 protected 의 차이가 없다. 차이는 "다른 패키지의 하위 클래스"에서 생긴다.
 * 💡 강의 코드에서는 (2) 의 하위 클래스와 (3) 의 비하위 클래스가 둘 다 이름이 B 다. 한 파일에 넣으려고 (3) 을 C 로 바꿨다.
 * 💡 이 파일의 A, B, C 는 private 접근 규칙을 그대로 보여 주려고 최상위 클래스로 두었다.
 *    (한 클래스 안에 중첩 클래스로 넣으면 바깥 클래스와 private 멤버를 서로 볼 수 있어서 결과가 달라진다)
 *
 * 실행 결과
 *  ---- (1) A 안에서 ----
 *  1
 *  5
 *  10
 *  15
 *  ---- (2) 하위 클래스 B 안에서 ----
 *  5
 *  10
 *  15
 *  a 는 getA() 로 : 1
 *  ---- (3) 비하위 클래스 C 안에서 ----
 *  5
 *  10
 *  15
 */
public class AccessControlTest {
    public static void main(String[] args) {
        System.out.println("---- (1) A 안에서 ----");
        new A().test();
        System.out.println("---- (2) 하위 클래스 B 안에서 ----");
        new B().test();
        System.out.println("---- (3) 비하위 클래스 C 안에서 ----");
        new C().test();
    }
}

class A {
    private int a = 1;
    int b = 5;          // default (접근자를 안 씀) : 같은 패키지에서만
    protected int c = 10;
    public int d = 15;

    void test() {       // (1) 동일 클래스 : 모두 접근 가능
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    public int getA() { return a; }   // 💡 private 필드를 밖에서 읽기 위한 getter (강의 코드에는 없음)
}

class B extends A {     // (2) 동일 패키지 내 하위 클래스
    void test() {
        // System.out.println(a);   // ❌ 접근 오류 : error: a has private access in A
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println("a 는 getA() 로 : " + getA());   // 💡 물려받은 public 메소드로는 읽을 수 있다
    }
}

class C {               // (3) 동일 패키지 내 비하위 클래스 (강의 코드에서는 이름이 B)
    void test() {
        A ob = new A();
        // System.out.println(ob.a);   // ❌ 접근 오류 : error: a has private access in A
        System.out.println(ob.b);
        System.out.println(ob.c);
        System.out.println(ob.d);
    }
}
