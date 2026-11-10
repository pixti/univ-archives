/**
 * [9-3 생성자와 소멸자] [실습] 생성자 중복 (슬라이드 8~11)
 *
 * 포인트
 *  - MyPoint : 생성자 2개 (기본 / 좌표 지정)
 *  - MyRectangle : 생성자 3개
 *      MyRectangle()                       → (0, 0) 위치, 크기 0
 *      MyRectangle(MyPoint p, int w, int h) → 밖에서 만든 MyPoint 를 그대로 받음
 *      MyRectangle(int x, int y, int w, int h) → 좌표(정수)만 받아 생성자 안에서 MyPoint 를 만듦
 *    → 사용하는 쪽이 편한 방법을 고를 수 있는 것이 생성자 오버로딩의 장점.
 *
 * 💡 7강 8-5 의 MyRectangle 은 필드 선언에서 corner = new MyPoint() 를 하고 값은 setter 로 넣었다.
 *    여기서는 생성자 세 개 중 어떤 것으로 만들어도 corner 가 반드시 채워진다.
 * 💡 this(...) 를 써서 같은 코드를 줄인 버전은 MyRectangleThisTest.java (슬라이드 14)
 * ⚠ 슬라이드의 “r1 면적은 ” 등은 스마트 따옴표. " 로 고쳤다.
 *
 * 실행 결과
 *  r1 면적은 0입니다.
 *  r2 면적은 30입니다.
 *  r3 면적은 36입니다.
 */
public class MyRectangleTest {
    public static void main(String[] args) {
        MyRectangle r1 = new MyRectangle();
        MyRectangle r2 = new MyRectangle(new MyPoint(3, 3), 5, 6);
        MyRectangle r3 = new MyRectangle(3, 3, 6, 6);
        System.out.println("r1 면적은 " + r1.getArea() + "입니다.");
        System.out.println("r2 면적은 " + r2.getArea() + "입니다.");
        System.out.println("r3 면적은 " + r3.getArea() + "입니다.");
    }
}

class MyPoint {
    private int x, y;

    public MyPoint() {
        x = 0;
        y = 0;
    }

    public MyPoint(int a, int b) {
        x = a;
        y = b;
    }

    public int getX() { return x; }
    public void setX(int newX) { x = newX; }
    public int getY() { return y; }
    public void setY(int newY) { y = newY; }
}

class MyRectangle {
    private MyPoint corner;
    private int width, height;

    public MyRectangle() {                            // 생성자 중복 정의
        corner = new MyPoint(0, 0);
        width = 0;
        height = 0;
    }

    public MyRectangle(MyPoint p, int w, int h) {     // 생성자 중복 정의
        corner = p;
        width = w;
        height = h;
    }

    public MyRectangle(int x, int y, int w, int h) {  // 생성자 중복 정의
        corner = new MyPoint(x, y);
        width = w;
        height = h;
    }

    public MyPoint getPoint() { return corner; }
    public void setPoint(MyPoint newP) { corner = newP; }
    public int getWidth() { return width; }
    public void setWidth(int newW) { width = newW; }
    public int getHeight() { return height; }
    public void setHeight(int newY) { height = newY; }   // 💡 슬라이드 그대로 (newH 가 더 자연스러움)

    public void resize(int newW, int newH) {
        width = newW;
        height = newH;
    }

    public int getArea() {
        return width * height;
    }
}
