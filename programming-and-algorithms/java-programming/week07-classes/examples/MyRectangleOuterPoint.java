/**
 * [7-5 실습] 내부 클래스와 일반 클래스로 선언할 경우의 차이
 *            (2) MyPointOuter 클래스를 "일반 클래스" 로 작성
 *
 * 포인트
 *  - MyPointOuter 가 MyRectangleOuter 밖의 별도 클래스이므로 MyPointOuter 의 private 필드(x, y)에 직접 접근할 수 없다.
 *        corner.x          ❌ error: x has private access in MyPointOuter
 *        corner.getX()     ✅ getter / setter 를 거쳐야 한다
 *  - main 에서도 외부 객체 없이 바로 new MyPointOuter() 로 생성한다.
 *  - (1) 내부 클래스 버전과의 비교표는 MyRectangleInnerPoint.java 참고
 *
 * 💡 MyRectangleOuter 이 MyPointOuter 를 필드로 "가지고 있는" 구조를 포함 관계(Composition)라고 한다.
 *    과제 클래스2 4번(Rectangle + Point), 실습 클래스2 1번(Circle + Point)이 같은 구조다.
 * 💡 강의 코드의 public class 이름은 MyRectangleTest (겹쳐서 바꿈)
 *
 * 실행 결과
 *  면적은 20입니다.
 *  3, 5
 *
 * 💡 같은 모듈의 다른 예제에도 같은 이름의 클래스가 있어서 IntelliJ 에서 함께 빌드하면 중복 오류가 난다.
 *    그래서 클래스 이름을 바꿨다. (MyPoint → MyPointOuter, MyRectangle → MyRectangleOuter, 강의 코드에서는 바꾸기 전 이름)
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
