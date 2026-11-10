/**
 * [9강 과제] 4번 문제 (Rectangle + Point - 생성자 중복 정의와 객체 개수 세기)
 *
 * 문제 (요약)
 *  왼쪽 위 꼭짓점(origin, Point), 너비(width), 높이(height)를 필드로 가지는 Rectangle 클래스를 작성하시오.
 *  - Point 클래스 : Point(), Point(x, y), getX(), getY()
 *  - Rectangle 생성자 : Rectangle(), Rectangle(w, h), Rectangle(Point origin, w, h)
 *  - 넓이를 구하는 area() 와, 지금까지 만든 Rectangle 객체 수를 세는 정적 필드 rectCount 를 둔다.
 *  - 주어진 main 으로 세 사각형의 넓이와 전체 객체 수를 출력한다.
 *
 * 포인트
 *  - 포함 관계 : Rectangle 이 Point 객체를 필드로 가진다. (7강 MyRectangle / MyPoint)
 *  - 정적 필드 rectCount : 객체끼리 공유하는 "클래스당 하나" 의 변수 (7강 8-2)
 *
 * 💡 생성자 체이닝 덕분에 rectCount++ 를 마지막 생성자 Rectangle(Point, int, int) 한 곳에만 쓰면 된다.
 *    어떤 생성자로 만들어도 결국 그 생성자를 거치므로 개수가 빠짐없이 세어진다.
 *    (생성자마다 rectCount++ 를 쓰면 this(...) 로 연결된 경우 두 번 세는 실수를 할 수 있다.)
 * 💡 이클립스에서 origin 필드에 경고 아이콘(노란 느낌표)이 떴다. "The value of the field Rectangle.origin is not used",
 *    즉 값을 넣기만 하고 어디서도 읽지 않는다는 뜻이다. 오류가 아니라 실행에는 문제없다.
 *    getOrigin() 같은 getter 를 만들어 쓰면 경고가 사라진다. (아래에 💡 getOrigin() 추가)
 * 💡 rectCount 는 public static 이라 Rectangle.rectCount 로 바로 읽을 수 있다. private 으로 숨기고
 *    static int getRectCount() 를 두는 것이 캡슐화 측면에서는 더 좋다.
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. RectangleTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Area 1 : 30
 *  Area 2 : 0
 *  Area 3 : 30
 *  Total Number of Objects : 3
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
