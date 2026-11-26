/**
 * [11강 실습] 상속 추가 실습 (인터페이스, 컴포지션, 다중 상속) - 1번 문제 (Shape 인터페이스)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ShapeInterfaceTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10, 12);
        Circle circle = new Circle(3);
        Triangle triangle = new Triangle(4, 6);

        System.out.println("Area of the Rectangle: " + rectangle.getArea());
        System.out.println("Area of the Circle: " + circle.getArea());
        System.out.println("Area of the Triangle: " + triangle.getArea());

        System.out.println("---- Shape[] ----");
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle(10, 12);
        shapes[1] = new Circle(3);
        shapes[2] = new Triangle(4, 6);
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].getArea());   // 동적 바인딩
        }
    }
}

interface Shape {
    double getArea();
}

class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}
