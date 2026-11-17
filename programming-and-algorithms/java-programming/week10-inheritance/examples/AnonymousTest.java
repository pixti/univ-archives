/**
 * [10-3 상속3] 익명 내부 클래스
 *
 * 포인트
 *  - 익명 내부 클래스 : 클래스 이름이 없는 클래스
 *  - 선언과 함께 객체 생성이 동시에 된다.
 *  - 보통 기존 클래스의 메소드를 재정의할 경우, 또는 인터페이스를 구현할 경우에 쓴다.
 *      MyInterface an_inner = new MyInterface() {    ← 인터페이스를 구현하는 이름 없는 클래스를 정의하면서
 *          public void test() {                         동시에 그 객체를 만든다
 *              ........
 *          }
 *      };                                            ← 대입문이므로 끝에 ; 가 필요
 *
 *  (1) 익명 클래스 사용 : 인터페이스를 구현하는 익명 클래스를 정의함과 동시에 객체를 생성
 *  (2) 익명 클래스를 사용하지 않았을 경우 : class MyClass implements MyInterface 를 따로 만들고 new MyClass()
 *    → 결과는 같다. 한 번만 쓰고 말 클래스라면 (1) 처럼 이름을 붙이지 않고 바로 만들면 코드가 짧아진다.
 *
 * ⚠ 자주 틀리는 부분 : 강의 코드의 Interface MyInterface 처럼 대문자로 쓰면 컴파일 오류다. 자바의 키워드는 모두 소문자 interface.
 * ⚠ 자주 틀리는 부분 : 익명 클래스는 마지막에 }; 로 끝난다. 클래스 몸체를 닫는 } 와 대입문을 끝내는 ; 를 둘 다 써야 한다.
 * 💡 익명 클래스도 컴파일하면 AnonymousTest$1.class 처럼 번호가 붙은 클래스 파일이 따로 생긴다. "이름이 없다" 는 것은 코드에서 부를 이름이 없다는 뜻이다.
 * 💡 인터페이스의 메소드는 public 이므로 익명 클래스 안의 test() 도 public 이어야 한다.
 * 💡 메소드가 하나뿐인 인터페이스는 Java 8 의 람다식으로 더 짧게 쓸 수 있다.  MyInterface in3 = () -> System.out.println("...");
 * 💡 같은 폴더의 다른 예제와 겹치지 않도록 MyInterface, MyClass 를 AnonymousTest 안에 중첩해서 넣었다.
 *
 * 실행 결과
 *  테스트입니다.
 *  테스트입니다.
 *  람다식 테스트입니다.
 */
public class AnonymousTest {

    interface MyInterface {
        public void test();
    }

    // (2) 익명 클래스를 사용하지 않았을 경우
    static class MyClass implements MyInterface {
        public void test() {
            System.out.println("테스트입니다.");
        }
    }

    public static void main(String[] args) {
        // (1) 인터페이스를 구현하는 익명 클래스를 정의함과 동시에 객체를 생성
        MyInterface inner = new MyInterface() {
            public void test() {
                System.out.println("테스트입니다.");
            }
        };
        inner.test();

        // (2) 이름이 있는 클래스 MyClass 로 객체 생성
        MyClass inner2 = new MyClass();
        inner2.test();

        // 💡 람다식 (강의 코드에는 없음)
        MyInterface inner3 = () -> System.out.println("람다식 테스트입니다.");
        inner3.test();
    }
}
