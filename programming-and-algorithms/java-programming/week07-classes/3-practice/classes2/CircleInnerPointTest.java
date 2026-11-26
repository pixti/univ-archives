/**
 * [7강 실습] 클래스(2) - 1번 문제 ❷ (Point 를 CircleInner 의 내부 클래스로)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class CircleInnerPointTest {
    public static void main(String[] args) {
        CircleInner c1 = new CircleInner();
        CircleInner.Point p1 = c1.new Point();       // 외부 객체 c1 을 통해 생성
        p1.setX(3);
        p1.setY(5);
        c1.setCenter(p1);
        c1.setRadius(7);
        System.out.println(c1.toString());

        CircleInner.Point p2 = c1.new Point();
        p2.setX(8);
        p2.setY(8);
        c1.move(p2);
        c1.resize(4);
        System.out.println(c1.toString());
    }
}

class CircleInner {
    private Point center;
    private double radius;

    public Point getCenter() { return center; }
    public void setCenter(Point center) { this.center = center; }
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    public void move(Point newPos) { this.center = newPos; }
    public void resize(double newRadius) { this.radius = newRadius; }
    public double getArea() { return Math.PI * radius * radius; }

    @Override
    public String toString() {
        String rStr = (radius % 1 == 0) ? String.valueOf((int) radius) : String.valueOf(radius);
        return "중심 : " + center.getX() + ", " + center.getY() + " 반지름 : " + rStr;
    }

    // 내부 클래스
    public class Point {
        private int x, y;
        public int getX() { return x; }
        public void setX(int x) { this.x = x; }
        public int getY() { return y; }
        public void setY(int y) { this.y = y; }
    }
}
