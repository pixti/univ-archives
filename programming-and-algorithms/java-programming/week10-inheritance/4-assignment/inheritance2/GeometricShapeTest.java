/**
 * [10강 과제] 상속 (추상 클래스) - 2번 문제 (abstract GeometricShape / Triangle / Square)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class GeometricShapeTest {
    public static void main(String[] args) {
        GeometricShape triangle = new Triangle(4, 5, 6);
        GeometricShape square = new Square(6);

        System.out.println("Triangle Area: " + triangle.area());
        System.out.println("Triangle Perimeter: " + triangle.perimeter());

        System.out.println("Square Area: " + square.area());
        System.out.println("Square Perimeter: " + square.perimeter());
    }
}

abstract class GeometricShape {
    public abstract double area();
    public abstract double perimeter();
}

class Triangle extends GeometricShape {
    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double area() {
        double s = (side1 + side2 + side3) / 2;                          // 헤론의 공식
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }
}

class Square extends GeometricShape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }
}
