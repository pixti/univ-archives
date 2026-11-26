/**
 * [10-1 상속1] final 메소드와 final 클래스
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class FinalMethodTest {

    static class Parent {
        final void show() {
            System.out.println("Parent.show() : final 이라 재정의할 수 없음");
        }

        void hello() {
            System.out.println("Parent.hello()");
        }
    }

    static class Child extends Parent {
        // void show() { }      // ❌ 컴파일 오류 : overridden method is final

        @Override
        void hello() {          // final 이 아닌 메소드는 재정의할 수 있다
            System.out.println("Child.hello() : 재정의함");
        }
    }

    static final class Last {
        void info() {
            System.out.println("Last 는 final 클래스라 상속할 수 없음");
        }
    }

    // static class Next extends Last { }   // ❌ 컴파일 오류 : cannot inherit from final Last

    public static void main(String[] args) {
        Child c = new Child();
        c.show();       // 물려받은 final 메소드 호출은 가능
        c.hello();
        new Last().info();
    }
}
