/**
 * [10-2 상속2] 인터페이스
 *
 * 포인트
 *  - 인터페이스 : 모든 메소드가 다 추상 메소드인 클래스. 객체가 가져야 할 기능만을 명시한 것
 *  - 추상 클래스와 같이 인터페이스로 객체를 생성할 수 없다.
 *  - 상속(extends)과 다르게 implements 키워드를 사용한다.
 *      public interface IShape {               class MyShape implements IShape {
 *          public double area();                   public double area() {...}
 *          public double volume();                 public double volume() {...}
 *          public String getName();                public String getName() {...}
 *      }                                       }
 *  - 일반 필드는 불가, static final 필드는 허용한다. (선언과 동시에 초기화)
 *      int x = 3;      // ⇒ static final int x = 3 으로 바뀐다
 *  - 일반 메소드는 불가, static 메소드는 허용한다.
 *      public void print() { System.out.println("hoho"); }          // ❌ 불가 (몸체가 있는 일반 메소드)
 *      public static void print() { System.out.println("hoho"); }   // ✅ static 메소드는 가능
 *
 * 추상 클래스와 인터페이스의 공통점과 차이점
 *  - 추상 클래스와 인터페이스는 객체를 생성할 수 없다.
 *  - 파생 클래스에서 추상 메소드를 모두 구현해 주어야만 일반 클래스가 된다.
 *  - 추상 클래스의 모든 메소드가 추상 메소드이면 인터페이스로 바꿀 수 있다.
 *  - 추상 클래스에는 일반 메소드가 있을 수 있다. (인터페이스는 없음 → 💡 아래 default 메소드 참고)
 *  - 인터페이스는 다중 상속을 지원한다. (추상 클래스는 불가)
 *  - 추상 클래스 하나와 인터페이스 여러 개를 함께 상속할 수 있다.
 *      class B extends A implements IShape { ... }
 *
 * 📝 필기 (퀴즈 2번 (7)) : 인터페이스는 모든 메소드들이 추상 메소드 abstract 인 형태라고 보면 된다.
 *    메소드만 선언하는 게 아니라 필드도 올 수 있지만, 일반 필드가 아니라 static 필드만 올 수 있다.
 *    → "필드는 올 수 없고 추상 메소드만 올 수 있다" 는 X (상수 필드 public static final 이 올 수 있다)
 * 📝 필기 (퀴즈 2번 (8)) : 인터페이스에는 정적 메소드가 올 수 있다. → O (Java 8 부터. 인터페이스이름.정적메소드() 로 호출)
 * 📝 필기 (퀴즈 2번 (9)) : 인터페이스에는 일반 필드는 허용되지 않지만 final 필드는 허용된다.
 *    일반 필드처럼 선언해도 내부적으로 (public static) final 로 취급되며, 그래서 필드 선언 시 초기화해야 한다. → O
 *      int MAX = 10;  →  public static final int MAX = 10;
 *
 * 💡 인터페이스 안에서는 public, abstract, static final 을 안 써도 자동으로 붙는다.
 *      double area();          ⇒  public abstract double area();
 *      int x = 3;              ⇒  public static final int x = 3;
 *    그래서 구현하는 클래스의 메소드는 반드시 public 이어야 한다. (부모보다 좁은 접근 범위로 재정의 불가)
 *      double area() {...}     ← public 을 빼면 error: attempting to assign weaker access privileges; was public
 * 💡 Java 8 부터 인터페이스에도 몸체가 있는 메소드를 넣을 수 있다. 단, default 나 static 을 붙여야 한다.
 *      default void hello() { System.out.println("기본 구현"); }   // 구현 클래스가 그대로 쓰거나 재정의
 *    그래서 수업의 "인터페이스는 일반 메소드가 없다" 는 Java 7 까지의 설명이다. 시험은 수업 기준으로 답한다.
 * 💡 x 는 static final 이므로 IShape.x 로 쓰고, 값을 바꿀 수 없다.  IShape.x = 5;  → ❌ cannot assign a value to final variable x
 * 💡 같은 폴더의 다른 예제와 겹치지 않도록 IShape, MyShape 를 InterfaceTest 안에 중첩해서 넣었다.
 *    (중첩된 interface 는 자동으로 static 이다)
 *
 * 실행 결과
 *  이름 : 정육면체 (한 변 2.0)
 *  겉넓이 : 24.0
 *  부피 : 8.0
 *  IShape.x = 3
 *  hoho
 *  기본 구현 : 정육면체 (한 변 2.0)
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
