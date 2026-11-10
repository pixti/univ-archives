/**
 * [8-5 실습] 내부 클래스와 일반 클래스로 선언할 경우의 차이
 *            (1) MyPoint 클래스를 MyRectangle 의 "내부 클래스" 로 작성
 *
 * 포인트
 *  - MyPoint 클래스를 MyRectangle 클래스의 내부 클래스로 정의하여 MyRectangle 클래스에서 MyPoint 사용
 *  - 내부 클래스이므로 MyRectangle 에서 MyPoint 의 private 필드에 "직접" 접근할 수 있다.
 *        public int getX() { return corner.x; }     ← corner.getX() 를 거치지 않아도 됨
 *  - main 에서 MyPoint 를 사용할 경우 외부 클래스 객체 생성 후 내부 클래스 생성
 *        MyRectangle.MyPoint p = r1.new MyPoint();
 *
 *  (2) 일반 클래스 버전(MyRectangleOuterPoint.java)과 비교
 *      ┌────────────────────┬──────────────────────────────┬───────────────────────────────┐
 *      │                    │ (1) 내부 클래스              │ (2) 일반 클래스               │
 *      ├────────────────────┼──────────────────────────────┼───────────────────────────────┤
 *      │ MyRectangle 에서   │ corner.x  (private 직접 접근)│ corner.getX() (getter 필요)   │
 *      │ main 에서 생성     │ r1.new MyPoint()             │ new MyPoint()                 │
 *      │ 타입 이름          │ MyRectangle.MyPoint          │ MyPoint                       │
 *      └────────────────────┴──────────────────────────────┴───────────────────────────────┘
 *
 * 📝 실습 클래스2 1-❷ 필기 : 내부 클래스의 객체는 '외부객체.new 내부클래스()' 형태로 생성
 *
 * 💡 슬라이드의 public class 이름은 MyRectangleTest (8-3 예제, (2) 버전과 겹쳐서 바꿈)
 *
 * 실행 결과
 *  면적은 20입니다.
 *  3, 5
 */
public class MyRectangleInnerPoint {
    public static void main(String[] args) {
        MyRectangle r1 = new MyRectangle();
        r1.setX(10); r1.setY(10); r1.setWidth(5); r1.setHeight(4);
        System.out.println("면적은 " + r1.getArea() + "입니다.");
        MyRectangle.MyPoint p = r1.new MyPoint();    // 외부 객체(r1)를 통해 내부 클래스 객체 생성
        p.setX(3); p.setY(5);
        System.out.println(p.getX() + ", " + p.getY());
    }
}

class MyRectangle {
    private MyPoint corner = new MyPoint();   // 필드 정의
    private int width, height;

    public int getX() { return corner.x; }    // 메소드 정의 (내부 클래스의 private 필드 직접 접근)
    public void setX(int newX) { corner.x = newX; }
    public int getY() { return corner.y; }
    public void setY(int newY) { corner.y = newY; }
    public int getWidth() { return width; }
    public void setWidth(int newW) { width = newW; }
    public int getHeight() { return height; }
    public void setHeight(int newY) { height = newY; }
    public void resize(int newW, int newH) { width = newW; height = newH; }
    public int getArea() { return width * height; }

    class MyPoint {
        private int x, y;
        public int getX() { return x; }               // x값을 읽는 기능
        public void setX(int newX) { x = newX; }      // x값을 변경하는 기능
        public int getY() { return y; }               // y값을 읽는 기능
        public void setY(int newY) { y = newY; }      // y값을 변경하는 기능
    }
}
