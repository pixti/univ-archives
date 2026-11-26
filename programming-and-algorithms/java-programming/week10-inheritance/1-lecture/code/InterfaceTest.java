/**
 * [10-2 상속2] 인터페이스
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class InterfaceTest {

    public interface IShape {
        static final int x = 3;                     // int x = 3; 으로 써도 똑같다

        public double area();                       // 추상 메소드 (abstract 생략)
        public double volume();
        public String getName();

        public static void print() {                // static 메소드는 허용
            System.out.println("hoho");
        }

        default void hello() {                      // 💡 Java 8 default 메소드 (강의 코드에는 없음)
            System.out.println("기본 구현 : " + getName());
        }
    }

    static class MyShape implements IShape {        // 상속과 다르게 implements 키워드 사용
        private double side;

        MyShape(double side) {
            this.side = side;
        }

        public double area() {                      // 인터페이스의 메소드는 public 으로 구현해야 한다
            return 6 * side * side;
        }

        public double volume() {
            return side * side * side;
        }

        public String getName() {
            return "정육면체 (한 변 " + side + ")";
        }
    }

    public static void main(String[] args) {
        // IShape s0 = new IShape();      // ❌ error: IShape is abstract; cannot be instantiated
        IShape s = new MyShape(2.0);       // 인터페이스 타입 변수에 구현 클래스 객체 저장
        System.out.println("이름 : " + s.getName());
        System.out.println("겉넓이 : " + s.area());
        System.out.println("부피 : " + s.volume());

        System.out.println("IShape.x = " + IShape.x);   // static final 필드
        IShape.print();                                 // static 메소드 : 인터페이스이름.메소드()
        s.hello();                                      // default 메소드
    }
}
