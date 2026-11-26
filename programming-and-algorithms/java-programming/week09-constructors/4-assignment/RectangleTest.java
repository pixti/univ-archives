/**
 * [9강 과제] 4번 문제 (Rectangle + Point - 생성자 중복 정의와 객체 개수 세기)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class RectangleTest {
    public static void main(String[] args) {
        Point originOne = new Point(23, 94);
        Rectangle rectOne = new Rectangle(originOne, 5, 6);
        Rectangle rectTwo = new Rectangle();
        Rectangle rectThree = new Rectangle(5, 6);

        System.out.println("Area 1 : " + rectOne.area());
        System.out.println("Area 2 : " + rectTwo.area());
        System.out.println("Area 3 : " + rectThree.area());
        System.out.println("Total Number of Objects : " + Rectangle.rectCount);
    }
}

class Point {
    private int x;
    private int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}

class Rectangle {
    public static int rectCount = 0;
    private Point origin;
    private int width;
    private int height;

    public Rectangle() {
        this(new Point(0, 0), 0, 0);
    }

    public Rectangle(int w, int h) {
        this(new Point(0, 0), w, h);
    }

    public Rectangle(Point origin, int w, int h) {   // ← 모든 생성자가 여기로 모임
        this.origin = origin;
        this.width = w;
        this.height = h;
        rectCount++;                                   // 한 곳에서만 센다
    }

    public Point getOrigin() {                         // 💡 추가 (origin 미사용 경고 해결)
        return origin;
    }

    public int area() {
        return width * height;
    }
}
