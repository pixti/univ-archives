/**
 * [7강 실습] 클래스(2) - 1번 문제 ❶ (Circle 클래스 - Point 를 필드로 가지는 원)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Point p1 = new Point();
        p1.setX(3);
        p1.setY(5);
        c1.setCenter(p1);
        c1.setRadius(7);
        System.out.println(c1.toString());

        Point p2 = new Point();
        p2.setX(8);
        p2.setY(8);
        c1.move(p2);
        c1.resize(4);
        System.out.println(c1.toString());
        System.out.println("넓이 : " + c1.getArea());     // 💡 getArea 확인용 출력 추가
    }
}

class Circle {
    private Point center;
    private double radius;

    public Point getCenter() { return center; }
    public void setCenter(Point center) { this.center = center; }
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    public void move(Point newPos) {
        this.center = newPos;
    }

    public void resize(double newRadius) {      // 📝 int → double 로 변경
        this.radius = newRadius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        String rStr = (radius % 1 == 0) ? String.valueOf((int) radius) : String.valueOf(radius);
        return "중심 : " + center.getX() + ", " + center.getY() + " 반지름 : " + rStr;
        // 같은 결과 : this.center.getX() / this.getCenter().getX() / getCenter().getX()
    }
}

class Point {
    private int x, y;

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
}
