/**
 * [10-1 상속1] 메소드 재정의 (method overriding)
 *
 * 포인트
 *  - 메소드 재정의 : 상위 클래스의 메소드를 "똑같은 형태"로 다시 정의하는 것
 *    (이름이 같고, 인수의 개수와 타입도 같다)
 *      class A {                  class B extends A {
 *          void f1() {...}            // A 의 f1() 도 사용 가능
 *          void f1(int x) {...}       void f1(int x) {...}         // A 의 인수 한 개 f1 을 재정의
 *      }                              void f1(int x, int y) {...}  // B 에 새로 추가된 인수 두 개 f1
 *                                 }
 *  - 재정의되는 메소드 안에서 기존 메소드를 그냥 부르면 "자기 자신"을 다시 부르게 되어 재귀에 빠질 위험이 있다.
 *      void f1(int x) { f1(5); ... }         // ❌ 재귀 호출로 인한 무한 반복
 *      void f1(int x) { super.f1(5); ... }   // ✅ 올바른 기존 메소드 호출
 *
 * 📝 필기 (퀴즈 1번 (1)) : 자식 클래스에서 재정의된 부모 클래스의 메소드를 호출하려면 super.메소드이름() 으로 호출한다.
 *    자식이 재정의하면 부모의 메소드는 가려진다. 그래서 그냥 메소드이름() 으로 부르면 자식의 메소드가 실행된다.
 * 📝 필기 (퀴즈 1번 (2)) : 중복 정의(overloading) vs 재정의(overriding)
 *                    중복 정의 (Overloading)               재정의 (Overriding)
 *      관계          주로 같은 클래스 안 (상속 관계도 가능)  반드시 부모 - 자식 상속 관계
 *      메소드 이름   같음                                   같음
 *      매개변수      반드시 달라야 함 (개수, 타입)           반드시 같아야 함
 *      반환형        상관없음                               같아야 함 (또는 하위 타입)
 *      접근 지정자   상관없음                               부모보다 좁은 범위로 변경 불가
 *      목적          같은 기능에 여러 입력을 처리 (편의성)   부모의 기능을 자식에 맞게 변경 (다형성)
 * 📝 필기 (퀴즈 1번 (3)) : 자식 클래스에 부모 클래스의 멤버 함수와 시그니처(이름 + 매개변수 목록)가 같은 함수가 있으면 → 재정의.
 *    시그니처(매개변수)가 다르면 중복 정의다. 그래서 위 B 의 f1(int, int) 는 "상속 관계에서의 중복 정의"다.
 * 📝 필기 (퀴즈 1번 (4)) : 재정의는 부모로부터 물려받은 기본 기능을 자식 클래스의 특성에 맞게 바꾸거나 확장할 때 쓴다.
 *    → 특수화(예 : Animal 의 소리내기() 를 Dog 는 "멍멍", Cat 은 "야옹"으로), 다형성과 동적 바인딩(10-3)
 *
 * 💡 @Override 를 붙이면 컴파일러가 "정말 부모에 같은 메소드가 있는지" 검사해 준다.
 *    f1(int x) 를 f1(long x) 처럼 잘못 쓰면 재정의가 아니라 새 메소드(중복 정의)가 되는데, @Override 가 있으면 오류로 알려 준다.
 *      error: method does not override or implement a method from a supertype
 * 💡 아래 BadB 의 무한 재귀는 실제로 실행하면 StackOverflowError 로 끝난다. 확인용으로 try-catch 로 잡았다. (예외 처리는 11강)
 * 💡 같은 폴더의 다른 예제와 클래스 이름(A, B)이 겹치지 않도록 MethodOverridingTest 안에 static 중첩 클래스로 넣었다.
 *    강의 코드처럼 파일 맨 아래에 따로 써도 동작은 같다.
 *
 * 실행 결과
 *  ---- B 객체 ----
 *  A.f1()
 *  B.f1(int) : x = 1
 *  A.f1(int) : x = 5
 *  B.f1(int, int) : x = 2, y = 3
 *  ---- A 타입 변수에 B 객체 ----
 *  B.f1(int) : x = 7
 *  A.f1(int) : x = 5
 *  ---- super 없이 f1(5) 를 부르면 ----
 *  StackOverflowError : 자기 자신을 끝없이 호출했다
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
