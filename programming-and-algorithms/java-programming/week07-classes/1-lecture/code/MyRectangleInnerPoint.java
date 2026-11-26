/**
 * [7-5 실습] 내부 클래스와 일반 클래스로 선언할 경우의 차이
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MyRectangleInnerPoint {
    public static void main(String[] args) {
        MyRectangleInner r1 = new MyRectangleInner();
        r1.setX(10); r1.setY(10); r1.setWidth(5); r1.setHeight(4);
        System.out.println("면적은 " + r1.getArea() + "입니다.");
        MyRectangleInner.MyPoint p = r1.new MyPoint();    // 외부 객체(r1)를 통해 내부 클래스 객체 생성
        p.setX(3); p.setY(5);
        System.out.println(p.getX() + ", " + p.getY());
    }
}

class MyRectangleInner {
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
