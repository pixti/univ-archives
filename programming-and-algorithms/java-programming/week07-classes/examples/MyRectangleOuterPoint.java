/**
 * [8-5 실습] 내부 클래스와 일반 클래스로 선언할 경우의 차이
 *            (2) MyPoint 클래스를 "일반 클래스" 로 작성
 *
 * 포인트
 *  - MyPoint 가 MyRectangle 밖의 별도 클래스이므로 MyPoint 의 private 필드(x, y)에 직접 접근할 수 없다.
 *        corner.x          ❌ error: x has private access in MyPoint
 *        corner.getX()     ✅ getter / setter 를 거쳐야 한다
 *  - main 에서도 외부 객체 없이 바로 new MyPoint() 로 생성한다.
 *  - (1) 내부 클래스 버전과의 비교표는 MyRectangleInnerPoint.java 참고
 *
 * 💡 MyRectangle 이 MyPoint 를 필드로 "가지고 있는" 구조를 포함 관계(Composition)라고 한다.
 *    과제 클래스2 4번(Rectangle + Point), 실습 클래스2 1번(Circle + Point)이 같은 구조다.
 * 💡 슬라이드의 public class 이름은 MyRectangleTest (겹쳐서 바꿈)
 *
 * 실행 결과
 *  면적은 20입니다.
 *  3, 5
 */
public class MyRectangleOuterPoint {
    public static void main(String[] args) {
        MyRectangle r1 = new MyRectangle();
        r1.setX(10); r1.setY(10); r1.setWidth(5); r1.setHeight(4);
        System.out.println("면적은 " + r1.getArea() + "입니다.");
        MyPoint p = new MyPoint();                   // 일반 클래스 → 바로 생성
        p.setX(3); p.setY(5);
        System.out.println(p.getX() + ", " + p.getY());
    }
}

class MyRectangle {
    private MyPoint corner = new MyPoint();   // 필드 정의
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

class MyPoint {
    private int x, y;
    public int getX() { return x; }               // x값을 읽는 기능
    public void setX(int newX) { x = newX; }      // x값을 변경하는 기능
    public int getY() { return y; }               // y값을 읽는 기능
    public void setY(int newY) { y = newY; }      // y값을 변경하는 기능
}
