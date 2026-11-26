/**
 * [10-2 상속2] 추상 클래스와 추상 메소드
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
