/**
 * [10강 실습] 상속 - 2번 문제 (Shape / Rectangle : getArea 재정의)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ShapeAreaTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3.0, 10.0);
        double area = rectangle.getArea();
        System.out.println("The area of the rectangle is: " + area);
    }
}

class Shape {
    public double getArea() {
        return 0.0;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    // 생성자 : 클래스 이름과 동일해야 하며, 매개변수로 double 2개를 받음
    public Rectangle(double length, double width) {
        this.length = length;   // 전달받은 3.0 을 클래스 변수 length 에 저장
        this.width = width;     // 전달받은 10.0 을 클래스 변수 width 에 저장
    }

    @Override
    public double getArea() {
        return length * width;  // 3.0 * 10.0 = 30.0 반환
    }
}
