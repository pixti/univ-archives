/**
 * [7강 실습] 클래스(2) - 1번 문제 ❷ (Point 를 Circle 의 내부 클래스로)
 *
 * 문제
 *  ❶ 의 Point 클래스를 Circle 클래스의 내부 클래스로 정의하여 같은 결과를 출력하시오.
 *
 * 포인트
 *  - Point 를 Circle 의 { } 안으로 옮긴다. → 타입 이름은 Circle.Point
 *  - 내부 클래스 객체는 외부 클래스 객체가 먼저 있어야 만들 수 있다.
 *        Circle c1 = new Circle();
 *        Circle.Point p1 = c1.new Point();     ← 외부객체.new 내부클래스()
 *
 * 📝 필기
 *   - Point 클래스를 Circle 클래스의 내부 클래스로 정의
 *   - 내부 클래스의 객체는 '외부객체.new 내부클래스()' 형태로 생성
 *
 * 📝 필기 (퀴즈 9번과 같은 문법) : A.B inner = outer.new B();
 *
 * 💡 Point 가 Circle 안에 있으므로 Circle 에서는 center.x 처럼 Point 의 private 필드에 직접 접근할 수도 있다.
 *    (8-5 MyRectangleInnerPoint.java 와 같은 구조) 여기서는 ❶ 과 똑같이 getter 를 썼다.
 * 💡 문제의 main 클래스 이름은 CircleTest. ❶ 파일과 겹쳐서 CircleInnerPointTest 로 바꿨다.
 *
 * 실행 결과
 *  중심 : 3, 5 반지름 : 7
 *  중심 : 8, 8 반지름 : 4
 */
public class CircleInnerPointTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle.Point p1 = c1.new Point();       // 외부 객체 c1 을 통해 생성
        p1.setX(3);
        p1.setY(5);
        c1.setCenter(p1);
        c1.setRadius(7);
        System.out.println(c1.toString());

        Circle.Point p2 = c1.new Point();
        p2.setX(8);
        p2.setY(8);
        c1.move(p2);
        c1.resize(4);
        System.out.println(c1.toString());
    }
}

class Circle {
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
