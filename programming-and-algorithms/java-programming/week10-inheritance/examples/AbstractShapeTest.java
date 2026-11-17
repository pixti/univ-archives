/**
 * [10-2 상속2] 추상 클래스와 추상 메소드
 *
 * 포인트
 *  - 추상 메소드 : 메소드 선언만 있고 구현(몸체 { })이 없는 메소드. abstract 키워드를 쓴다.
 *      abstract String getName();      ← 끝에 { } 대신 ; 를 쓴다
 *  - 상속받는 클래스에서 내부를 구현하여 사용한다.
 *  - 추상 메소드가 하나라도 있는 클래스는 클래스 앞에 abstract 키워드를 붙여야 한다. (추상 클래스)
 *  - 추상 클래스로부터 객체를 생성할 수 없다.  new Shape()  → ❌
 *  - 추상 메소드를 모두 구현해야 일반 클래스가 된다.
 *
 * [생각해 보기] 앞의 예제(ConstructorOrderTest.java)의 Shape 클래스 안에 abstract String getName(); 을 추가하면?
 *  1. Shape 클래스 오류. 추가한 메소드가 추상 메소드이므로 당연히 Shape 도 추상 클래스다. → 클래스명 앞에 abstract 를 추가
 *       error: Shape is not abstract and does not override abstract method getName() in Shape
 *  2. Rectangle 클래스도 오류. 추상 클래스를 상속받았으므로 Rectangle 도 추상 클래스다.
 *     → 추상 메소드인 getName 메소드를 재정의하든지, 아니면 클래스명 앞에 abstract 키워드를 붙여야 한다.
 *       error: Rectangle is not abstract and does not override abstract method getName() in Shape
 *  3. 추상 메소드 구현 팁 (이클립스) : 클래스명 밑에 빨간 줄이 생기는데, 마우스를 갖다 대면 팝업창이 뜬다.
 *     그중에 "Add unimplemented methods" 를 선택하면 구현해야 할 메소드의 골격이 자동으로 추가된다.
 *     (IntelliJ 에서는 Alt + Enter → Implement methods)
 *
 * 📝 필기 (퀴즈 2번 (5)) : 추상 메소드는 abstract 가 붙고, 이게 하나라도 존재하면 그 클래스도 추상 클래스 abstract class 로
 *    선언되어야 한다. → O (abstract 를 안 붙이면 컴파일 오류)
 * 📝 필기 (퀴즈 2번 (6)) : 추상 클래스를 상속할 경우, 자식 클래스도 추상 클래스로 선언하든지
 *    아니면 부모 클래스의 추상 메소드를 (모두) 재정의해 주면 된다. → O
 *
 * 💡 추상 클래스도 일반 필드, 일반 메소드, 생성자를 가질 수 있다. (아래 Shape 의 x, y 와 생성자)
 *    생성자는 new Shape() 로 직접 부를 수는 없지만, 자식 객체를 만들 때 super() 로 불린다.
 * 💡 추상 클래스 타입의 "변수"는 만들 수 있다.  Shape s = new Rectangle();  → 실제 객체의 getName() 이 실행된다.
 * 💡 같은 폴더의 다른 예제와 겹치지 않도록 Shape, Rectangle 을 AbstractShapeTest 안에 static 중첩 클래스로 넣었다.
 *
 * 실행 결과
 *  Shape 생성자
 *  Rectangle 생성자
 *  이름 : 사각형
 *  Shape 생성자
 *  Circle 생성자
 *  이름 : 원
 */
public class AbstractShapeTest {

    static abstract class Shape {           // 추상 메소드가 있으므로 abstract class
        private int x, y;

        public Shape() {
            System.out.println("Shape 생성자");
        }

        abstract String getName();           // 추상 메소드 : 선언만 있고 구현이 없다
    }

    static class Rectangle extends Shape {
        private int width, height;

        public Rectangle() {
            System.out.println("Rectangle 생성자");
        }

        @Override
        String getName() {                   // 추상 메소드를 구현(재정의) → 일반 클래스
            return "사각형";
        }
    }

    static class Circle extends Shape {      // 💡 비교용 (강의 코드에는 없음)
        public Circle() {
            System.out.println("Circle 생성자");
        }

        @Override
        String getName() {
            return "원";
        }
    }

    public static void main(String[] args) {
        // Shape s0 = new Shape();     // ❌ error: Shape is abstract; cannot be instantiated

        Shape s1 = new Rectangle();    // 추상 클래스 타입의 변수에 자식 객체는 저장할 수 있다
        System.out.println("이름 : " + s1.getName());

        Shape s2 = new Circle();
        System.out.println("이름 : " + s2.getName());
    }
}
