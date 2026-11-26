/**
 * [10-3 상속3] 익명 내부 클래스
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
