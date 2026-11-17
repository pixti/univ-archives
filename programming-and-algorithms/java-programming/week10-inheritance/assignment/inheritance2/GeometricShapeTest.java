/**
 * [10강 과제] 상속 (추상 클래스) - 2번 문제 (abstract GeometricShape / Triangle / Square)
 *
 * 문제
 *  추상 메소드 area() 및 perimeter() 를 갖는 추상 클래스 GeometricShape 클래스를 작성하라.
 *  GeometricShape 클래스를 상속하고 각 모양의 면적과 둘레를 계산하는 해당 메서드를 구현하는
 *  하위 클래스 Triangle 및 Square 를 작성하라. main 은 다음과 같다.
 *
 *    //Main.java
 *    public class Main {
 *        public static void main(String[] args) {
 *            GeometricShape triangle = new Triangle(4, 5, 6);
 *            GeometricShape square = new Square(6);
 *
 *            System.out.println("Triangle Area: " + triangle.area());
 *            System.out.println("Triangle Perimeter: " + triangle.perimeter());
 *
 *            System.out.println("Square Area: " + square.area());
 *            System.out.println("Square Perimeter: " + square.perimeter());
 *        }
 *    }
 *
 * 📝 필기 : 헤론의 공식 사용
 *    세 변의 길이 a, b, c 만 알 때 삼각형의 넓이를 구하는 공식
 *      s = (a + b + c) / 2          (둘레의 절반)
 *      넓이 = √( s (s - a) (s - b) (s - c) )
 *    a = 4, b = 5, c = 6  →  s = 7.5,  넓이 = √(7.5 x 3.5 x 2.5 x 1.5) = √98.4375 = 9.921567416492215
 *
 * 포인트
 *  - 생성자 Triangle(4, 5, 6), Square(6) 는 정수를 넘기지만 매개변수가 double 이라 4.0, 5.0, 6.0 으로 자동 형변환된다.
 *    그래서 둘레가 15.0, 24.0 처럼 실수로 출력된다.
 *  - s 를 구할 때 (side1 + side2 + side3) / 2 는 side 들이 double 이라 실수 나눗셈이다. (정수였다면 15 / 2 = 7 로 잘린다)
 *  - 제곱근은 Math.sqrt() 로 구한다.
 *
 * ⚠ 자주 틀리는 부분 : 세 변이 삼각형을 만들 수 없는 길이(예 : 1, 2, 10)면 s - c 가 음수가 되어 Math.sqrt 가 NaN 을 돌려준다.
 *    실제로 쓰려면 "가장 긴 변 < 나머지 두 변의 합" 인지 생성자에서 검사하는 것이 좋다.
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 GeometricShapeTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Triangle Area: 9.921567416492215
 *  Triangle Perimeter: 15.0
 *  Square Area: 36.0
 *  Square Perimeter: 24.0
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
