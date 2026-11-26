/**
 * [10-1 상속1] 상위 클래스 생성자 및 동일 클래스의 다른 생성자 호출
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ConstructorChainTest {

    static class Shape {
        private int x, y;

        public Shape() {
            this(0, 0);                         // 같은 클래스의 다른 생성자 호출
            System.out.println("Shape 생성자");
        }

        public Shape(int xloc, int yloc) {
            x = xloc;
            y = yloc;
            System.out.println("Shape 유인 생성자");   // 유인 생성자 : 인수가 있는 생성자
        }
    }

    static class Rectangle extends Shape {
        private int width, height;

        public Rectangle() {
            this(0, 0, 0, 0);                   // 같은 클래스의 다른 생성자 호출
            System.out.println("Rectangle 생성자");
        }

        public Rectangle(int x, int y, int w, int h) {
            super(x, y);                        // 부모 클래스의 특정 생성자 호출 (첫 문장)
            width = w;
            height = h;
            System.out.println("Rectangle 유인 생성자");
        }
    }

    public static void main(String[] args) {
        Rectangle r;
        r = new Rectangle();

        System.out.println("---- new Shape() ----");   // 💡 비교용 : Shape() 를 직접 부르면 this(0, 0) 이 먼저 실행된다
        new Shape();
    }
}
