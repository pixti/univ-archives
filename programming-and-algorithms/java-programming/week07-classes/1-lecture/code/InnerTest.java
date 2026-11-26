/**
 * [7-5] 내부 클래스 (inner class)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class InnerTest {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.display_Inner();                       // (1) Outer 안에서 Inner 사용

        Outer.Inner inner = outer.new Inner();       // (2) 바깥에서 Inner 객체 생성
        inner.print();
    }
}

class Outer {
    int num = 10;

    public class Inner {                             // ⚠ 처음 코드는 private class Inner (바깥에서 쓰려고 public 으로 바꿈)
        private int x = 5;
        public void print() {
            System.out.println("This is an inner class : " + num);   // outer의 num 사용
        }
    }

    void display_Inner() {
        Inner inner = new Inner();                   // Outer 안에서는 그냥 new Inner()
        System.out.println(inner.x);                 // inner의 private도 outer에서 접근
        inner.print();
    }
}
