/**
 * [10-1 상속1] 메소드 재정의 (method overriding)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MethodOverridingTest {

    static class A {
        void f1() {
            System.out.println("A.f1()");
        }

        void f1(int x) {
            System.out.println("A.f1(int) : x = " + x);
        }
    }

    static class B extends A {
        // A 의 f1() 도 사용 가능 (재정의하지 않았으므로 물려받은 그대로)

        @Override
        void f1(int x) {                      // A 의 인수 한 개 f1 을 재정의
            System.out.println("B.f1(int) : x = " + x);
            super.f1(5);                      // ✅ 올바른 기존 메소드 호출
        }

        void f1(int x, int y) {               // B 에 새로 추가된 인수 두 개 f1 (중복 정의)
            System.out.println("B.f1(int, int) : x = " + x + ", y = " + y);
        }
    }

    static class BadB extends A {
        @Override
        void f1(int x) {
            f1(5);                            // ❌ super 를 빼먹으면 BadB 의 f1 을 다시 호출 → 무한 재귀
        }
    }

    public static void main(String[] args) {
        System.out.println("---- B 객체 ----");
        B b = new B();
        b.f1();          // 물려받은 A 의 f1()
        b.f1(1);         // 재정의한 B 의 f1(int)
        b.f1(2, 3);      // B 에서 추가한 f1(int, int)

        System.out.println("---- A 타입 변수에 B 객체 ----");
        A a = new B();
        a.f1(7);         // 💡 변수 타입이 A 여도 실제 객체가 B 이므로 B 의 f1(int) 가 실행된다 (동적 바인딩, 10-3)

        System.out.println("---- super 없이 f1(5) 를 부르면 ----");
        try {
            new BadB().f1(1);
        } catch (StackOverflowError e) {
            System.out.println("StackOverflowError : 자기 자신을 끝없이 호출했다");
        }
    }
}
