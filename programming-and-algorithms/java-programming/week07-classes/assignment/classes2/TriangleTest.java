/**
 * [7강 과제] 클래스(2) - 3번 문제 (Triangle 클래스 - 삼각형의 넓이)
 *
 * 문제
 *  밑변(base)과 높이(height)를 필드로 가지는 Triangle 클래스를 작성하고,
 *  넓이를 돌려주는 getArea() 를 만드시오.
 *
 * 📝 필기 (AI 설명)
 *   - 삼각형의 넓이 = 밑변 × 높이 ÷ 2   →   return base * height / 2;
 *   - 출력 결과(8)가 정수이므로 int 를 사용했다.
 *     소수점이 나올 수 있는 값(예 : 밑변 3, 높이 5 → 7.5)을 다루려면 double 을 쓴다.
 *
 * 💡 int 끼리의 나눗셈은 소수점을 버린다. (정수 나눗셈)
 *        3 * 5 / 2   = 15 / 2 = 7      (7.5 가 아님!)
 *        3 * 5 / 2.0 = 7.5             (하나라도 실수면 실수 나눗셈)
 *    double 로 바꾸려면 :  public double getArea() { return base * height / 2.0; }
 *
 * 실행 결과
 *  삼각형의 밑변 : 4
 *  삼각형의 높이 : 4
 *  삼각형의 넓이는 8입니다.
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
