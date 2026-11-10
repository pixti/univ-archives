/**
 * [8-5] 메소드 내부 클래스 (method-local inner class)
 *
 * 포인트
 *  - 메소드 안에서도 클래스를 선언하여 사용할 수 있다. 이를 메소드 내부 클래스라 한다.
 *  - 지역 변수처럼 "그 메소드 안에서만" 사용 가능하다. (display_Inner 밖에서는 Inner 를 모름)
 *  - public, private 는 불가하며 abstract 나 final 또는 접근자 없이 사용한다.
 *    (지역 변수에 public/private 를 못 붙이는 것과 같은 이유)
 *
 * ⚠ 슬라이드 6 의 코드는 메소드 안에서 "private class Inner" 로 선언해서 컴파일 오류가 난다.
 *    바로 앞 줄 설명("public, private는 불가")과도 맞지 않는다.
 *      ❌ private class Inner { ... }     error: illegal start of expression
 *      ✅ class Inner { ... }             (접근자 없이)
 *
 * 실행 결과
 *  5
 *  This is an inner class : 10
 */
public class MethodLocalInnerTest {               // 슬라이드에서는 이름이 InnerTest (위 예제와 겹쳐서 바꿈)
    public static void main(String[] args) {
        Outer2 outer = new Outer2();
        outer.display_Inner();
    }
}

class Outer2 {                                    // 슬라이드에서는 이름이 Outer
    int num = 10;

    void display_Inner() {
        class Inner {                             // ⚠ private 제거
            int x = 5;
            public void print() {
                System.out.println("This is an inner class : " + num);
            }
        }
        Inner inner = new Inner();
        System.out.println(inner.x);
        inner.print();
    }
}
