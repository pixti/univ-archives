/**
 * [7강 과제] 클래스(2) - 4번 문제 (Rectangle 클래스 - 면적 비교와 겹치는 영역)
 *
 * 문제
 *  시작점(Point startPoint, 왼쪽 아래 꼭짓점), 너비(width), 높이(height)를 가지는 Rectangle 클래스를 작성하시오.
 *   - getArea()                 : 면적
 *   - intersect(Rectangle other): 두 사각형이 겹치는 영역을 새 Rectangle 로 반환, 겹치지 않으면 null
 *  main 에서 두 사각형의 면적을 비교하고, 겹치는 영역을 출력한다.
 *
 * 📝 필기 (AI 설명) 핵심 개념
 *   - Point 클래스      : x, y 좌표를 저장
 *   - Rectangle 클래스  : Point 를 필드로 가진다 → 포함 관계 (Composition, "has-a")
 *                         getX() / getY() 는 startPoint.getX() 를 대신 불러 주는 편의 메서드
 *   - getArea()         : width * height
 *   - intersect()       : 겹치면 새 Rectangle 객체를, 겹치지 않으면 null 을 반환
 *   - Math.max / Math.min 으로 겹치는 영역의 경계를 구한다.
 *
 *        겹치는 영역의  왼쪽   = 두 사각형 왼쪽(x)       중 큰 값   Math.max
 *                       아래   = 두 사각형 아래(y)       중 큰 값   Math.max
 *                       오른쪽 = 두 사각형 오른쪽(x + w) 중 작은 값 Math.min
 *                       위     = 두 사각형 위(y + h)     중 작은 값 Math.min
 *        left >= right 또는 bottom >= top 이면 겹치지 않음 → null
 *
 *   - 이 문제의 값
 *        r1 : (10, 10) 에서 5 x 5  → x 10 ~ 15, y 10 ~ 15, 면적 25
 *        r2 : ( 3,  7) 에서 6 x 4  → x  3 ~  9, y  7 ~ 11, 면적 24
 *        left = max(10, 3) = 10,  right = min(15, 9) = 9   → left >= right → 겹치지 않음
 *
 * ⚠ 문제의 출력 코드는 둥근 따옴표(“ ”)를 쓰고, 마지막 문자열 "만큼 겹칩니다. 의 닫는 따옴표가 빠져 있다.
 *        ❌ 원본 : ... + “ 만큼 겹칩니다.);
 *        ✅ 수정 : ... + " 만큼 겹칩니다.");
 *
 * 💡 intersect 가 null 을 돌려줄 수 있으므로 main 에서 반드시 if (inter == null) 을 먼저 검사해야 한다.
 *    검사 없이 inter.getX() 를 부르면 NullPointerException 이 난다.
 * 💡 실제로 겹치는 경우도 확인하려고 r3 예시를 추가했다. (문제에는 없음)
 *        r1 (10,10) 5x5 와 r3 (12,8) 6x4 → x 12 ~ 15, y 10 ~ 12 → (12, 10) 에서 너비 3, 높이 2
 *
 * 실행 결과
 *  첫 번째 사각형 면적이 더 넓습니다.
 *  겹치는 영역이 없습니다.
 *  (💡 추가 예시) (12, 10)에서 너비 3, 높이 2 만큼 겹칩니다.
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
