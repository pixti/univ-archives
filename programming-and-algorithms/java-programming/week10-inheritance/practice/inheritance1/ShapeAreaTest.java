/**
 * [10강 실습] 상속 - 2번 문제 (Shape / Rectangle : getArea 재정의)
 *
 * 문제
 *  getArea() 라는 메소드를 갖는 Shape 라는 클래스를 정의하라.
 *  직사각형의 면적을 계산하기 위해 getArea() 메서드를 재정의한 Rectangle 이라는 하위 클래스를 정의하라.
 *
 *    // Main class
 *    public class Main {
 *        public static void main(String[] args) {
 *            Rectangle rectangle = new Rectangle(3.0, 10.0);
 *            double area = rectangle.getArea();
 *            System.out.println("The area of the rectangle is: " + area);
 *        }
 *    }
 *
 * 📝 필기 : 단계별 상세 설명 - 문제에 이미 작성되어 있는 Main 클래스를 단서로 삼아 필요한 요소를 하나씩 만든다.
 *  ① Shape 클래스 만들기 (상위 클래스)
 *     - 문제 조건 : "getArea() 라는 메소드를 갖는 Shape 라는 클래스를 정의하라."
 *     - 반환 타입 파악하기 : Main 클래스를 보면 double area = rectangle.getArea(); 라고 되어 있다.
 *       즉, getArea() 메소드가 실행된 결괏값은 실수형(double)이어야 한다.
 *     - 내용 작성하기 : 그냥 "도형(Shape)" 이라는 개념만으로는 어떤 도형인지 알 수 없어 면적을 계산할 수 없다.
 *       따라서 기본값으로 0.0 을 반환하도록 작성한다.
 *  ② Rectangle 클래스와 상속 설정하기 (하위 클래스)
 *     - 문제 조건 : "Shape 의 하위 클래스 Rectangle 을 정의하라."
 *     - 자바에서 하위 클래스가 상위 클래스를 물려받을(상속받을) 때는 extends 라는 키워드를 사용한다.
 *  ③ Rectangle 의 변수(필드)와 생성자 만들기
 *     - 단서 확인 : Main 클래스에 Rectangle rectangle = new Rectangle(3.0, 10.0); 이라는 코드가 있다.
 *     - 의미 : Rectangle 객체를 만들 때 소괄호 안에 실수(double) 2개(3.0, 10.0)를 넣어 주고 있다.
 *       이는 직사각형의 가로와 세로 길이를 의미한다.
 *     - 구현 : 이 두 값을 저장할 변수(length, width)를 클래스 안에 만들고, 객체가 생성될 때 값을 전달받아
 *       저장하는 생성자(Constructor)를 만들어야 한다.
 *       (※ this. 는 매개변수 이름과 클래스의 변수 이름이 같을 때, 클래스 자신의 변수임을 구분해 주기 위해 사용한다)
 *  ④ getArea() 메소드 재정의(Overriding)하기
 *     - 문제 조건 : "직사각형의 면적을 계산하기 위해 getArea() 메서드를 재정의한..."
 *     - 메소드 재정의(오버라이딩)란? 부모 클래스(Shape)로부터 물려받은 메소드의 내용을 자식 클래스(Rectangle)의
 *       상황에 맞게 고쳐 쓰는 것이다.
 *     - 부모 클래스의 getArea() 는 0.0 을 반환하지만, 직사각형에서는 가로 x 세로의 값을 반환하도록 내용을 바꿔 준다.
 *     - 메소드 위에 @Override 라고 적어 주면, 컴파일러가 "아, 부모의 메소드를 똑같은 이름으로 잘 고쳐 썼구나" 라고
 *       확인해 준다. (실수 방지용)
 *
 * 💡 이 Shape 의 getArea() 처럼 "부모에서는 내용을 정할 수 없는 메소드" 를 0.0 대신 아예 비워 두는 방법이
 *    추상 메소드다. (10-2, practice/inheritance2)
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 ShapeAreaTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  The area of the rectangle is: 30.0
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
