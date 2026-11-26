/**
 * [7-5 실습] 내부 클래스와 일반 클래스로 선언할 경우의 차이
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MyRectangleOuterPoint {
    public static void main(String[] args) {
        MyRectangleOuter r1 = new MyRectangleOuter();
        r1.setX(10); r1.setY(10); r1.setWidth(5); r1.setHeight(4);
        System.out.println("면적은 " + r1.getArea() + "입니다.");
        MyPointOuter p = new MyPointOuter();                   // 일반 클래스 → 바로 생성
        p.setX(3); p.setY(5);
        System.out.println(p.getX() + ", " + p.getY());
    }
}

class MyRectangleOuter {
    private MyPointOuter corner = new MyPointOuter();   // 필드 정의
    private int width, height;

    public int getX() { return corner.getX(); }            // 메소드 정의 (getter 로 접근)
    public void setX(int newX) { corner.setX(newX); }
    public int getY() { return corner.getY(); }
    public void setY(int newY) { corner.setY(newY); }
    public int getWidth() { return width; }
    public void setWidth(int newW) { width = newW; }
    public int getHeight() { return height; }
    public void setHeight(int newY) { height = newY; }
    public void resize(int newW, int newH) { width = newW; height = newH; }
    public int getArea() { return width * height; }
}

class MyPointOuter {
    private int x, y;
    public int getX() { return x; }               // x값을 읽는 기능
    public void setX(int newX) { x = newX; }      // x값을 변경하는 기능
    public int getY() { return y; }               // y값을 읽는 기능
    public void setY(int newY) { y = newY; }      // y값을 변경하는 기능
}
