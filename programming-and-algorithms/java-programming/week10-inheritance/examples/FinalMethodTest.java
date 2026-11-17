/**
 * [10-1 상속1] final 메소드와 final 클래스
 *
 * 포인트
 *  - final 키워드가 붙은 메소드는 하위 클래스에서 재정의할 수 없다.
 *  - 클래스 앞에 final 키워드가 붙으면 상속할 수 없다.
 *
 *      class Parent { final void show() {...} }
 *      class Child extends Parent {
 *          void show() {...}          // ❌ error: show() in Child cannot override show() in Parent
 *      }                              //          overridden method is final
 *
 *      final class Last {...}
 *      class Next extends Last {...}  // ❌ error: cannot inherit from final Last
 *
 * 💡 final 의 세 가지 쓰임
 *      final 변수   : 값을 한 번만 정할 수 있다 (상수, 2강 · 9강)
 *      final 메소드 : 재정의할 수 없다
 *      final 클래스 : 상속할 수 없다. 예) String, Integer, Math 는 final 클래스라서 extends String 은 오류
 * 💡 final 메소드도 "물려받아서 호출하는 것"은 된다. 바꿀 수만 없다.
 * 💡 같은 폴더의 다른 예제와 클래스 이름이 겹치지 않도록 FinalMethodTest 안에 static 중첩 클래스로 넣었다.
 *
 * 실행 결과
 *  Parent.show() : final 이라 재정의할 수 없음
 *  Child.hello() : 재정의함
 *  Last 는 final 클래스라 상속할 수 없음
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
