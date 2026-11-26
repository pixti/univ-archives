/**
 * [10-3 상속3] 상속과 바인딩 - static
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class StaticBindingTest {

    static class A {
        public static int X = 2;
        public static void f() { System.out.println("kkk"); }
    }

    static class B extends A {
        public static int X = 0;
        public static void f() { System.out.println("hhh"); }
    }

    @SuppressWarnings({"static", "static-access"})   // 💡 객체 변수로 static 멤버를 쓰는 경고를 숨김 (javac, 이클립스)
    public static void main(String[] args) {
        A c = new B();
        System.out.println(c.X);   // A 의 X
        c.f();                     // A 의 f()

        System.out.println("---- 클래스 이름으로 ----");   // 💡 비교용
        System.out.println(B.X);
        B.f();
    }
}
