/**
 * [10강 과제] 상속 - 4번 문제 (Shape / Circle : getPerimeter, getArea 재정의)
 *
 * 문제
 *  getPerimeter() 및 getArea() 라는 메서드를 갖는 Shape 라는 클래스를 작성하라.
 *  원의 면적과 둘레를 계산하기 위해 getPerimeter() 및 getArea() 메서드를 재정의하는 Circle 이라는 하위 클래스도 작성하라.
 *  main 은 다음과 같다.
 *
 *    // Main class
 *    public class Main {
 *        public static void main(String[] args) {
 *            double r = 8.0;
 *            Circle c1 = new Circle(r);
 *            System.out.println("Radius of the circle=" + r);
 *            System.out.println("Perimeter: " + c1.getPerimeter());
 *            System.out.println("Area: " + c1.getArea());
 *            r = 3.2;
 *            Circle c2 = new Circle(r);
 *            System.out.println("\nRadius of the circle=" + r);
 *            System.out.println("Perimeter: " + c2.getPerimeter());
 *            System.out.println("Area: " + c2.getArea());
 *        }
 *    }
 *
 * 포인트
 *  - 원의 둘레 = 2 x π x r,  원의 넓이 = π x r x r   (π 는 Math.PI)
 *  - Shape 에서는 어떤 도형인지 모르므로 0.0 을 돌려주고, Circle 에서 재정의한다.
 *
 * 💡 r = 3.2 로 바꾼 뒤 new Circle(r) 을 하면 c2 의 radius 에는 3.2 가 복사된다. c1 의 radius(8.0)는 그대로다.
 *    (기본형 값은 매개변수로 넘길 때 복사된다)
 * 💡 둘레, 넓이가 50.26548245743669 처럼 길게 나오는 것은 double 값을 그대로 출력했기 때문이다.
 *    소수점 둘째 자리까지만 보려면 String.format("%.2f", c1.getArea()) 를 쓴다. (문제의 실행 결과는 그대로 출력)
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 CircleShapeTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Radius of the circle=8.0
 *  Perimeter: 50.26548245743669
 *  Area: 201.06192982974676
 *
 *  Radius of the circle=3.2
 *  Perimeter: 20.106192982974676
 *  Area: 32.169908772759484
 */
public class CircleShapeTest {
    public static void main(String[] args) {
        double r = 8.0;
        Circle c1 = new Circle(r);
        System.out.println("Radius of the circle=" + r);
        System.out.println("Perimeter: " + c1.getPerimeter());
        System.out.println("Area: " + c1.getArea());

        r = 3.2;
        Circle c2 = new Circle(r);
        System.out.println("\nRadius of the circle=" + r);
        System.out.println("Perimeter: " + c2.getPerimeter());
        System.out.println("Area: " + c2.getArea());
    }
}

class Shape {
    public double getPerimeter() {
        return 0.0;
    }

    public double getArea() {
        return 0.0;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
