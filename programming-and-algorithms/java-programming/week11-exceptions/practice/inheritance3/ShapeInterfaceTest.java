/**
 * [11강 실습] 상속 추가 실습 (인터페이스, 컴포지션, 다중 상속) - 1번 문제 (Shape 인터페이스)
 *
 * 문제
 *  getArea() 메소드를 갖는 Shape 인터페이스를 작성하라. Shape 인터페이스를 구현하는 세 가지 클래스
 *  Rectangle, Circle 및 Triangle 도 작성하라. 세 클래스 각각에 대해 getArea() 메서드를 구현토록 한다. main 은 다음과 같다.
 *
 *    // Main
 *    public class Main {
 *        public static void main(String[] args) {
 *            // Create a Rectangle object with length=10 and width=12
 *            Rectangle rectangle = new Rectangle(10, 12);
 *            // Create a Circle object with radius=3
 *            Circle circle = new Circle(3);
 *            // Create a Triangle object with base=4 and height=6
 *            Triangle triangle = new Triangle(4, 6);
 *            // Print the area of the Rectangle
 *            System.out.println("Area of the Rectangle: " + rectangle.getArea());
 *            // Print the area of the Circle
 *            System.out.println("Area of the Circle: " + circle.getArea());
 *            // Print the area of the Triangle
 *            System.out.println("Area of the Triangle: " + triangle.getArea());
 *        }
 *    }
 *
 * 📝 필기 : 1. 클래스와 인터페이스의 구조적 분류 - 자바에서 타입을 정의하는 구조는 구현의 완성도와 목적에 따라
 *          일반 클래스, 추상 클래스, 인터페이스로 구분된다.
 *  1) 일반 클래스 (Concrete Class)
 *     - 정의 : 상태를 나타내는 필드(멤버 변수), 객체를 초기화하는 생성자, 동작을 정의하는 메소드가 모두 구체적으로 구현된 클래스다.
 *     - 특징 : 모든 메소드가 실행 블록({ })을 가지고 있다. new 연산자를 사용하여 메모리에 직접 인스턴스(객체)를 생성할 수 있다.
 *     - 문제 내 예시 : Rectangle, Circle, Triangle, Main 클래스가 이에 해당한다.
 *  2) 추상 클래스 (Abstract Class)
 *     - 정의 : 클래스 선언부에 abstract 키워드가 붙은 클래스다. 내부에 구현부가 없는 "추상 메소드" 를 하나 이상 포함할 수 있다.
 *     - 특징 : 일반 클래스처럼 일반 필드, 일반 메소드, 생성자를 모두 가질 수 있다.
 *              구현이 완료되지 않은 메소드가 존재할 수 있으므로, new 연산자를 통한 직접적인 인스턴스 생성이 불가능하다.
 *              하위 클래스에서 extends 키워드로 상속받은 후, 추상 메소드를 모두 구현해야만 인스턴스를 생성할 수 있다.
 *     - 목적 : 서로 관련된 클래스들의 공통적인 필드와 메소드를 추출하여 코드의 중복을 줄이고, 하위 클래스마다 다르게
 *              동작해야 하는 부분만 추상 메소드로 남겨 구현을 강제할 때 사용한다.
 *  3) 인터페이스 (Interface)
 *     - 정의 : interface 키워드로 선언하며, 클래스가 구현해야 하는 동작의 명세(Specification)만을 정의한 구조다.
 *     - 특징 : 일반적인 인스턴스 필드를 가질 수 없으며, 선언되는 모든 변수는 자동으로 public static final(상수)로 처리된다.
 *              선언되는 모든 메소드는 기본적으로 실행 블록이 없는 public abstract(추상 메소드)로 처리된다.
 *              (단, Java 8 부터는 구현부를 가진 default 메소드와 static 메소드의 선언도 허용된다)
 *              생성자를 가질 수 없으며, 직접 인스턴스를 생성할 수 없다.
 *              클래스에서 implements 키워드를 사용해 인터페이스를 구현하며, 인터페이스에 정의된 모든 추상 메소드를 반드시 구현해야 한다.
 *     - 목적 : 상속 관계에 얽매이지 않고, 서로 다른 클래스들이 동일한 메소드 형태(시그니처)를 가지도록 강제하여
 *              사용 방법을 표준화할 때 사용한다.
 *     - 문제 내 예시 : Shape 인터페이스는 이를 구현하는 모든 도형 클래스가 double getArea() 라는 메소드를 반드시
 *       작성하도록 강제하는 역할을 한다.
 *
 * 📝 필기 : 2. 세 가지 구조의 기술적 비교
 *     구분               일반 클래스                   추상 클래스                       인터페이스
 *     선언 키워드        class                         abstract class                    interface
 *     인스턴스 생성      가능                          불가능                            불가능
 *     생성자 유무        있음                          있음 (하위 클래스에서 호출용)      없음
 *     포함 가능한 변수   모든 변수 (인스턴스/정적/상수) 모든 변수 (인스턴스/정적/상수)    상수만 가능 (public static final)
 *     포함 가능한 메소드 구현된 일반 메소드            일반 메소드 + 추상 메소드          추상 메소드 (+ default, static 메소드)
 *     하위 연결 키워드   extends (상속)                extends (상속)                    implements (구현)
 *     다중 적용 여부     단일 상속만 가능              단일 상속만 가능                  다중 구현 가능
 *     주된 사용 목적     객체 생성 및 기능 수행        공통 기능 상속 및 부분적 구현 강제 기능의 명세 제공 및 동작의 표준화
 *
 * 📝 필기 : 3. 클래스 간 관계 및 구현 관련 개념
 *  1) 추상 메소드 (Abstract Method)
 *     - 정의 : 메소드의 선언부(접근 제어자, 반환 타입, 메소드 이름, 매개변수 목록)만 있고, 실제 동작을 정의하는 구현부({ })가 없는 메소드다.
 *     - 역할 : 하위 클래스나 구현 클래스가 작성해야 할 메소드의 규격(시그니처)을 정의한다. 문제의 double getArea(); 는
 *       매개변수 없이 호출되어 double 타입의 값을 반환해야 한다는 규칙을 의미한다.
 *  2) 상속 (extends) 과 구현 (implements)
 *     - 상속 (extends) : 상위 클래스(일반 또는 추상 클래스)의 필드와 메소드를 하위 클래스가 물려받는 것이다.
 *       기존의 코드를 재사용하고 계층 구조를 형성하는 데 목적이 있다. 자바는 여러 부모 클래스로부터 동시에 상속받는
 *       "다중 상속" 을 허용하지 않는데, 이는 두 부모 클래스에 동일한 이름의 메소드가 있을 때 어떤 것을 실행해야 할지
 *       모호해지는 문제(다이아몬드 문제)를 방지하기 위함이다.
 *     - 구현 (implements) : 인터페이스에 정의된 추상 메소드의 몸통을 클래스에서 작성하는 것이다. 인터페이스는 구현된 내용이
 *       없으므로 여러 인터페이스를 동시에 구현하더라도 충돌 문제가 발생하지 않는다. 따라서 하나의 클래스가 여러 개의
 *       인터페이스를 다중 구현하는 것이 가능하다.
 *  3) 메소드 오버라이딩 (Method Overriding)
 *     - 정의 : 상위 클래스나 인터페이스에 정의된 메소드를 하위 클래스에서 다시 정의하는 것이다.
 *     - 조건 : 오버라이딩을 할 때는 메소드의 이름, 매개변수의 타입과 개수, 반환 타입이 상위 구조에 정의된 것과 완전히
 *       일치해야 한다. 접근 제어자는 상위 메소드보다 좁은 범위로 변경할 수 없다.
 *       (인터페이스의 메소드는 기본 public 이므로 구현 클래스에서도 반드시 public 으로 선언해야 한다)
 *     - @Override 어노테이션 : 해당 메소드가 상위 클래스나 인터페이스의 메소드를 재정의한 것임을 컴파일러에게 알리는 역할을 한다.
 *       만약 메소드 이름에 오타가 있거나 매개변수가 다르면 컴파일 에러를 발생시켜 개발자의 실수를 방지한다.
 *
 * 📝 필기 : 4. 인터페이스 사용의 기술적 목적 - 각 도형 클래스에 개별적으로 getArea() 를 만들지 않고 굳이 Shape 인터페이스를
 *          거쳐서 만드는 이유는 표준화와 다형성(Polymorphism) 때문이다.
 *  1) 다형성 (Polymorphism) 과 동적 바인딩
 *     다형성이란 하나의 참조 변수 타입으로 여러 종류의 하위 객체를 참조할 수 있는 성질을 말한다. 인터페이스 역시 타입으로
 *     사용할 수 있으므로, Shape 타입의 변수에 이를 구현한 Rectangle, Circle, Triangle 객체를 할당할 수 있다.
 *       // 인터페이스 타입의 배열에 서로 다른 도형 객체를 저장
 *       Shape[] shapes = new Shape[3];
 *       shapes[0] = new Rectangle(10, 12);
 *       shapes[1] = new Circle(3);
 *       shapes[2] = new Triangle(4, 6);
 *       for (int i = 0; i < shapes.length; i++) {
 *           // 컴파일 시점에는 Shape 의 getArea() 를 호출하지만,
 *           // 실행 시점(Runtime)에는 실제 담긴 객체(Rectangle, Circle 등)의 오버라이딩된 메소드가 실행됨
 *           System.out.println(shapes[i].getArea());
 *       }
 *     위 코드처럼 상위 타입(Shape)으로 메소드를 호출하더라도, 프로그램 실행 시점에는 실제 메모리에 생성된 객체의
 *     오버라이딩된 메소드가 찾아가서 실행된다. 이를 동적 바인딩(Dynamic Binding)이라고 한다.
 *  2) 결합도 감소 및 유지보수성 향상
 *     인터페이스를 사용하면 기능을 사용하는 쪽(Main 클래스)에서는 구체적인 도형 클래스의 내부 구조를 몰라도 Shape 인터페이스의
 *     getArea() 라는 규격만 알면 코드를 작성할 수 있다. 추후 새로운 도형 클래스(예 : Pentagon)가 추가되더라도, Shape 인터페이스를
 *     구현하기만 하면 기존의 출력 코드를 수정하지 않고 그대로 재사용할 수 있다.
 *
 * 📝 필기 : 5. 문제에 사용된 기타 객체지향 개념
 *  1) 생성자 (Constructor)
 *     - 객체가 생성될 때(new 키워드 사용 시) 호출되는 특수한 목적의 메소드다. 주로 객체의 필드(멤버 변수)를 초기화하는 데 사용된다.
 *     - 클래스의 이름과 동일해야 하며, 반환 타입(Return Type) 자체가 존재하지 않는다(void 도 적지 않음).
 *     - 문제에서 new Rectangle(10, 12) 가 실행될 때, Rectangle 클래스 내부의 public Rectangle(double length, double width)
 *       생성자가 호출되어 전달받은 값을 내부 필드에 저장한다.
 *  2) 캡슐화 (Encapsulation) 와 정보 은닉
 *     - 객체의 데이터(필드)와 그 데이터를 처리하는 동작(메소드)을 하나로 묶고, 외부에서 데이터에 직접 접근하는 것을 제한하는 기법이다.
 *     - 코드에서 각 도형의 속성 변수(length, width, radius 등) 앞에 private 접근 제어자를 선언한 것이 이에 해당한다.
 *     - private 으로 선언된 변수는 해당 클래스 외부에서 직접 읽거나 수정할 수 없으며, 생성자나 public 으로 공개된 메소드를 통해서만
 *       간접적으로 다룰 수 있다. 이는 외부의 잘못된 조작으로 인해 객체의 데이터가 손상되는 것을 막아 무결성을 유지하기 위함이다.
 *  3) this 참조 변수
 *     - 인스턴스 자기 자신을 가리키는 참조 변수다.
 *     - 생성자나 메소드의 매개변수 이름과 클래스의 필드 이름이 동일할 때(예 : 매개변수 length 와 필드 length), 해당 블록 내부에서는
 *       매개변수가 우선시된다. 이때 클래스의 필드임을 명확히 지정하기 위해 this.length = length; 와 같이 사용한다.
 *
 * 💡 new Rectangle(10, 12) 처럼 int 를 넘겨도 생성자의 매개변수가 double 이라 10.0, 12.0 으로 자동 형변환된다. 그래서 120.0 이 출력된다.
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 ShapeInterfaceTest 로 이름을 바꿨다.
 *    아래 "---- Shape[] ----" 부분은 📝 필기 4절의 다형성 코드를 확인용으로 덧붙인 것이다.
 *
 * 실행 결과
 *  Area of the Rectangle: 120.0
 *  Area of the Circle: 28.274333882308138
 *  Area of the Triangle: 12.0
 *  ---- Shape[] ----
 *  120.0
 *  28.274333882308138
 *  12.0
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
