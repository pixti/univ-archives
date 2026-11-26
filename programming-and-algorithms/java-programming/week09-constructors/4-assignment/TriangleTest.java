/**
 * [9강 과제] 3번 문제 (Triangle 클래스 - 생성자와 넓이)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class TriangleTest {
    public static void main(String[] args) {
        Triangle t = new Triangle(4, 4);
        System.out.println("삼각형의 밑변 : " + (int) t.getBase());
        System.out.println("삼각형의 높이 : " + (int) t.getHeight());
        System.out.println("삼각형의 넓이는 " + (int) t.getArea() + "입니다.");
    }
}

class Triangle {
    private double base;
    private double height;

    public Triangle() {
        this(0.0, 0.0);
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() { return base; }
    public void setBase(double base) { this.base = base; }
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public double getArea() {
        return (base * height) / 2.0;
    }
}
