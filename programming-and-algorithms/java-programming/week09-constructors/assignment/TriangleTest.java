/**
 * [9강 과제] 3번 문제 (Triangle 클래스 - 생성자와 넓이)
 *
 * 문제 (요약)
 *  밑변(base)과 높이(height)를 필드로 가지는 Triangle 클래스를 작성하시오.
 *  - 생성자 : Triangle(), Triangle(base, height)
 *  - getter / setter 와 넓이를 구하는 getArea() 를 둔다.
 *  - 밑변 4, 높이 4 인 삼각형을 만들어 밑변, 높이, 넓이를 출력한다.
 *
 * 포인트
 *  - 7강 과제 클래스2 3번 Triangle 을 생성자로 바꾼 문제.
 *  - Triangle() 은 this(0.0, 0.0) 으로 연결 (생성자 체이닝)
 *
 * 💡 필드가 double 이라 그대로 출력하면 4.0, 8.0 이 나온다. 실행 결과(4, 8)에 맞추려고 (int) 로 형변환해서 출력했다.
 *    넓이가 7.5 처럼 소수가 되는 경우에는 (int) 가 소수점을 버리므로 주의. (7강 과제 💡 정수 나눗셈)
 * 💡 new Triangle(4, 4) 처럼 int 를 넘겨도 double 매개변수로 자동 형변환된다.
 * 💡 (base * height) / 2.0 : 2 가 아니라 2.0 으로 나눠 실수 나눗셈임을 분명히 했다.
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. TriangleTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  삼각형의 밑변 : 4
 *  삼각형의 높이 : 4
 *  삼각형의 넓이는 8입니다.
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
