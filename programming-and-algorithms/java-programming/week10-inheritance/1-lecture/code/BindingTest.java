/**
 * [10-3 상속3] 상속과 바인딩
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class BindingTest {

    static class A {
        public int X = 2;
        public void f() { System.out.println("kkk"); }
    }

    static class B extends A {
        public int X = 0;
        public void f() { System.out.println("hhh"); }
    }

    public static void main(String[] args) {
        A c = new B();
        System.out.println(c.X);   // A 에서 상속받은 X → (정적 바인딩)
        c.f();                     // B 의 f() → (동적 바인딩)

        System.out.println("---- 변수 타입을 B 로 ----");   // 💡 비교용
        B d = (B) c;
        System.out.println(d.X);   // B 의 X
        d.f();                     // 메소드는 여전히 B 의 f()
    }
}
