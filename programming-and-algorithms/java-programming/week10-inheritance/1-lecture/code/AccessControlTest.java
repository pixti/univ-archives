/**
 * [10-1 상속1] 상속 및 접근 제어 - 같은 패키지 안에서의 접근
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
