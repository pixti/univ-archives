/**
 * [7-3 실습] 사각형 클래스 - private 필드 + getter / setter
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MyRectangleTest {
    public static void main(String[] args) {
        MyRectanglePrivate r1 = new MyRectanglePrivate();
        r1.setX(10); r1.setY(10); r1.setWidth(5); r1.setHeight(4);
        System.out.println("면적은 " + r1.getArea() + "입니다.");
        // r1.width = 5;   // ❌ 컴파일 오류 : width has private access in MyRectanglePrivate
    }
}

class MyRectanglePrivate {
    // 필드 정의, private로 선언하여 외부접근 불가.
    private int x, y;               // 왼쪽 코너 좌표
    private int width, height;      // 사각형의 폭과 높이

    // 메소드 정의
    public int getX() { return x; }                        // x값을 읽는 기능
    public void setX(int newX) { x = newX; }               // x값을 변경하는 기능
    public int getY() { return y; }                        // y값을 읽는 기능
    public void setY(int newY) { y = newY; }               // y값을 변경하는 기능
    public int getWidth() { return width; }                // width 값을 읽는 기능
    public void setWidth(int newW) { width = newW; }       // width 값을 변경하는 기능
    public int getHeight() { return height; }              // height 값을 읽는 기능
    public void setHeight(int newY) { height = newY; }     // height 값을 변경하는 기능
    public void resize(int newW, int newH) { width = newW; height = newH; } // 크기를 변경하는 기능
    public int getArea() { return width * height; }        // 면적을 계산하는 기능
}
