/**
 * [7-5] 메소드 내부 클래스 (method-local inner class)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MethodLocalInnerTest {               // 강의 코드에서는 이름이 InnerTest (위 예제와 겹쳐서 바꿈)
    public static void main(String[] args) {
        Outer2 outer = new Outer2();
        outer.display_Inner();
    }
}

class Outer2 {                                    // 강의 코드에서는 이름이 Outer
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
