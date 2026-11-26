/**
 * [7강 과제] 클래스(2) - 3번 문제 (Triangle 클래스 - 삼각형의 넓이)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class TriangleTest {
    public static void main(String[] args) {
        Triangle t = new Triangle();
        t.setBase(4);
        t.setHeight(4);

        System.out.println("삼각형의 밑변 : " + t.getBase());
        System.out.println("삼각형의 높이 : " + t.getHeight());
        System.out.println("삼각형의 넓이는 " + t.getArea() + "입니다.");
    }
}

class Triangle {
    private int base;
    private int height;

    public int getBase() { return base; }
    public void setBase(int base) { this.base = base; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getArea() {
        return base * height / 2;
    }
}
