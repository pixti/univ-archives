/**
 * [10-1 상속1] 상위 클래스 생성자 및 동일 클래스의 다른 생성자 호출
 *
 * 포인트
 *  - 자식 클래스에서 부모 클래스의 "특정" 생성자를 호출할 때는 super 키워드를 사용한다.  → super(x, y);
 *  - 같은 클래스의 다른 생성자를 호출할 때는 this 키워드를 사용한다.                    → this(0, 0, 0, 0);
 *  - 부모 생성자 호출은 코드 제일 앞에 위치시켜야 한다. (this(...) 도 마찬가지)
 *
 *  new Rectangle() 의 실행 순서
 *    Rectangle()
 *      └ this(0, 0, 0, 0)                 → Rectangle(int, int, int, int)
 *          └ super(x, y)                  → Shape(int, int)            : "Shape 유인 생성자" 출력
 *          └ width = w; height = h;         "Rectangle 유인 생성자" 출력
 *      └ "Rectangle 생성자" 출력
 *
 * 📝 필기 (퀴즈 2번 (2)) : 공개된 메소드를 사용하든지, 부모 생성자에서 호출하는 방향으로 초기화해야 한다.
 *    → 자식은 부모의 private 필드(x, y)를 직접 대입할 수 없으므로 super(x, y) 로 부모 생성자에게 맡긴다.
 * 📝 필기 (퀴즈 3번 (7)) : super() 로 부모 클래스 생성자를 호출해 초기화.
 *
 * ⚠ 자주 틀리는 부분 : 강의 코드의 Shape() 는 this(0, 0) 을 부르는데, 결과에는 "Shape 생성자" 가 나오지 않는다.
 *    Rectangle(int, int, int, int) 가 super(x, y) 로 Shape(int, int) 를 "직접" 고르기 때문에 Shape() 는 한 번도 불리지 않는다.
 *    (super(...) 를 안 썼다면 컴파일러가 super() 를 넣어서 Shape() → this(0, 0) 순서로 불렸을 것)
 * ⚠ 자주 틀리는 부분 : 한 생성자 안에서 this(...) 와 super(...) 를 함께 쓸 수 없다. 둘 다 "첫 문장"이어야 하기 때문이다.
 *    그래서 Rectangle() 은 this(...) 로 다른 생성자에게 넘기고, 그 생성자가 super(...) 를 부른다.
 * ⚠ 자주 틀리는 부분 : 부모에 매개변수 없는 생성자가 없으면, 자식 생성자에서 super(...) 를 꼭 써야 한다.
 *    (컴파일러가 넣는 super() 가 부를 생성자가 없어서 error: constructor Shape in class Shape cannot be applied to given types)
 * 💡 JDK 25 (JEP 513) 부터는 super(...) / this(...) 앞에 this 를 쓰지 않는 문장(인수 검사 등)을 쓸 수 있다.
 *    시험은 수업 기준 "생성자 호출은 첫 문장" 으로 답한다. (9-3)
 * 💡 강의 코드의 main 은 static void main(string[] args) 이다. 자바에서는 public static void main(String[] args).
 * 💡 같은 폴더의 다른 예제와 겹치지 않도록 Shape, Rectangle 을 ConstructorChainTest 안에 static 중첩 클래스로 넣었다.
 *    (강의 코드의 public class 이름은 Program)
 *
 * 실행 결과
 *  Shape 유인 생성자
 *  Rectangle 유인 생성자
 *  Rectangle 생성자
 *  ---- new Shape() ----
 *  Shape 유인 생성자
 *  Shape 생성자
 */
public class ConstructorChainTest {

    static class Shape {
        private int x, y;

        public Shape() {
            this(0, 0);                         // 같은 클래스의 다른 생성자 호출
            System.out.println("Shape 생성자");
        }

        public Shape(int xloc, int yloc) {
            x = xloc;
            y = yloc;
            System.out.println("Shape 유인 생성자");   // 유인 생성자 : 인수가 있는 생성자
        }
    }

    static class Rectangle extends Shape {
        private int width, height;

        public Rectangle() {
            this(0, 0, 0, 0);                   // 같은 클래스의 다른 생성자 호출
            System.out.println("Rectangle 생성자");
        }

        public Rectangle(int x, int y, int w, int h) {
            super(x, y);                        // 부모 클래스의 특정 생성자 호출 (첫 문장)
            width = w;
            height = h;
            System.out.println("Rectangle 유인 생성자");
        }
    }

    public static void main(String[] args) {
        Rectangle r;
        r = new Rectangle();

        System.out.println("---- new Shape() ----");   // 💡 비교용 : Shape() 를 직접 부르면 this(0, 0) 이 먼저 실행된다
        new Shape();
    }
}
