/**
 * [8-3 실습] 사각형 클래스 - private 필드 + getter / setter
 *
 * 포인트
 *  - 필드(x, y, width, height)를 private 로 선언하여 외부 접근 불가
 *  - getX / setX ... : 필드 하나마다 읽는 기능(getter)과 변경하는 기능(setter)을 public 메소드로 제공
 *  - resize(newW, newH) : 크기를 한 번에 변경하는 기능
 *  - getArea() : 면적을 계산하는 기능 (필드에 저장하지 않고 필요할 때 계산)
 *
 * ⚠ 슬라이드 main 의 스마트 따옴표(“ ”)는 일반 따옴표로 바꿨다.
 * 💡 setHeight(int newY) 의 매개변수 이름 newY 는 newH 가 자연스럽다. (동작은 같음, 슬라이드 그대로 둠)
 *
 * 실행 결과
 *  면적은 20입니다.
 */
public class MyRectangleTest {
    public static void main(String[] args) {
        MyRectangle r1 = new MyRectangle();
        r1.setX(10); r1.setY(10); r1.setWidth(5); r1.setHeight(4);
        System.out.println("면적은 " + r1.getArea() + "입니다.");
        // r1.width = 5;   // ❌ 컴파일 오류 : width has private access in MyRectangle
    }
}

class MyRectangle {
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
