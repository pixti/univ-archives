/**
 * [7강 과제] 클래스(2) - 4번 문제 (Rectangle 클래스 - 면적 비교와 겹치는 영역)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class RectangleTest {
    public static void main(String[] args) {
        Point p1 = new Point();
        p1.setX(10);
        p1.setY(10);
        Point p2 = new Point();
        p2.setX(3);
        p2.setY(7);

        Rectangle r1 = new Rectangle();
        r1.setStartPoint(p1);
        r1.setWidth(5);
        r1.setHeight(5);

        Rectangle r2 = new Rectangle();
        r2.setStartPoint(p2);
        r2.setWidth(6);
        r2.setHeight(4);

        if (r1.getArea() > r2.getArea()) {
            System.out.println("첫 번째 사각형 면적이 더 넓습니다.");
        } else {
            System.out.println("두 번째 사각형 면적이 더 넓습니다.");
        }

        Rectangle inter = r1.intersect(r2);
        printIntersect(inter);

        // 💡 추가 예시 : 겹치는 경우
        Point p3 = new Point();
        p3.setX(12);
        p3.setY(8);
        Rectangle r3 = new Rectangle();
        r3.setStartPoint(p3);
        r3.setWidth(6);
        r3.setHeight(4);
        System.out.print("(💡 추가 예시) ");
        printIntersect(r1.intersect(r3));
    }

    static void printIntersect(Rectangle inter) {
        if (inter == null) {
            System.out.println("겹치는 영역이 없습니다.");
        } else {
            System.out.println("(" + inter.getX() + ", " + inter.getY() + ")에서 너비 "
                    + inter.getWidth() + ", 높이 " + inter.getHeight() + " 만큼 겹칩니다.");
        }
    }
}

class Rectangle {
    private Point startPoint;       // 포함 관계 : Rectangle has-a Point
    private int width;
    private int height;

    public Point getStartPoint() { return startPoint; }
    public void setStartPoint(Point startPoint) { this.startPoint = startPoint; }

    public int getX() { return startPoint.getX(); }
    public int getY() { return startPoint.getY(); }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }
    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getArea() {
        return width * height;
    }

    public Rectangle intersect(Rectangle other) {
        int left = Math.max(this.getX(), other.getX());
        int bottom = Math.max(this.getY(), other.getY());
        int right = Math.min(this.getX() + this.width, other.getX() + other.width);
        int top = Math.min(this.getY() + this.height, other.getY() + other.height);

        if (left >= right || bottom >= top) {
            return null;                          // 겹치지 않음
        }

        Point p = new Point();
        p.setX(left);
        p.setY(bottom);
        Rectangle result = new Rectangle();
        result.setStartPoint(p);
        result.setWidth(right - left);
        result.setHeight(top - bottom);
        return result;
    }
}

class Point {
    private int x, y;

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
}
