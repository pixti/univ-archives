/**
 * [10-1 상속1] 상위 클래스 생성자 호출 순서
 *
 * 포인트
 *  - 자식 클래스는 부모 클래스로부터 상속받은 멤버들이 있다. 그것을 초기화하기 위해 부모 클래스의 생성자도 자동으로 호출된다.
 *  - 자식 클래스의 객체가 생성될 때 당연히 자식 클래스의 생성자가 호출된다. 이때 부모 클래스 생성자도 호출될까? → 호출된다.
 *
 *      객체의 생성   [부모 클래스 생성자] → [자식 클래스 생성자]
 *                                                │
 *      객체의 사용                                …
 *                                                │
 *      객체의 소멸   [부모 클래스 소멸자] ← [자식 클래스 소멸자]
 *
 *    * 위의 순서는 일반적인 얘기다. 소멸자의 실행 순서는 보장할 수 없다. 가비지 컬렉터에 따른다.
 *  - C++ 에서 소멸자는 (생성자의) 역순으로 호출되지만, Java 의 경우 가비지 컬렉터에 따라 달라질 수 있다.
 *
 * 📝 필기 (퀴즈 2번 (1)) : 자식 클래스의 생성자가 부모 클래스의 생성자를 명시적으로 호출하지 않아도
 *    컴파일러가 자동으로 부모의 기본 생성자 super() 를 (자식 생성자의 첫 줄에) 넣어 호출한다.
 *    → "호출되지 않는다" 는 X
 * 📝 필기 (퀴즈 2번 (3)) : 부모가 (먼저) 호출이 되고 자식이 호출이 됨. → "자식 생성자가 먼저" 는 X
 *    자식이 부모의 멤버를 쓰려면 부모 쪽 멤버가 먼저 초기화되어 있어야 하기 때문이다.
 * 📝 필기 (퀴즈 2번 (4)) : 소멸자는 자식 → 부모 순서(생성자의 역순)라는 문제는 O.
 *    자바에서는 소멸자가 없는 형태로 가고 있어서 (수업에서는) 중복 정답 처리하겠다고 했다. C++ 등에서는 이러하니 알아둘 것.
 *
 * ⚠ 자주 틀리는 부분 : 강의 코드의 main 은 static void main(string args[]) 이다.
 *    자바의 문자열 클래스는 대문자 String 이고, main 에는 public 이 있어야 시작점이 된다. (C# 은 소문자 string 을 쓴다)
 *      ✅ public static void main(String[] args)   (String args[] 처럼 써도 된다)
 * ⚠ 자주 틀리는 부분 : 자바의 finalize() 는 C++ 소멸자와 달리 부모 것이 자동으로 호출되지 않는다.
 *    Rectangle 처럼 finalize() 를 재정의하고 super.finalize() 를 부르지 않으면 "Shape 소멸자" 는 출력되지 않는다.
 *    부모 쪽 정리도 하려면 RectangleSuper 처럼 마지막에 super.finalize() 를 직접 호출해야 한다.
 * ⚠ finalize() 는 JDK 9 부터 deprecated, JDK 18 부터 삭제 예정(for removal)이다. 컴파일하면 경고가 나온다.
 *    호출 시점도, 호출 여부도 보장되지 않는다. (9-3 소멸자, week09 FinalizeTest.java)
 *    그래서 System.gc() 로 가비지 컬렉션을 "요청"하고 잠깐 기다렸다. 보통은 출력되지만 순서와 출력 여부는 실행마다 다를 수 있다.
 * 💡 강의 코드의 public class 이름은 Program. 같은 폴더의 다른 예제와 겹치지 않도록 Shape, Rectangle 을
 *    ConstructorOrderTest 안에 static 중첩 클래스로 넣었다.
 *
 * 실행 결과 (아래 두 줄씩의 소멸자 출력은 실행마다 다를 수 있음)
 *  ---- 강의 코드 ----
 *  Shape 생성자
 *  Rectangle 생성자
 *  ---- super.finalize() 를 부르는 버전 ----
 *  Shape 생성자
 *  RectangleSuper 생성자
 *  ---- GC 요청 ----
 *  Rectangle 소멸자
 *  RectangleSuper 소멸자
 *  Shape 소멸자
 */
@SuppressWarnings("removal")   // 💡 finalize() deprecated 경고를 숨김 (강의 코드에는 없음)
public class ConstructorOrderTest {

    static class Shape {
        private int x, y;

        public Shape() {
            System.out.println("Shape 생성자");
        }

        @Override
        public void finalize() {
            System.out.println("Shape 소멸자");
        }
    }

    static class Rectangle extends Shape {
        private int width, height;

        public Rectangle() {
            // 💡 여기에 super(); 가 자동으로 들어가 있다 → Shape() 가 먼저 실행된다
            System.out.println("Rectangle 생성자");
        }

        @Override
        public void finalize() {
            System.out.println("Rectangle 소멸자");     // ⚠ super.finalize() 가 없어서 Shape 소멸자는 안 불린다
        }
    }

    static class RectangleSuper extends Shape {      // 💡 비교용 (강의 코드에는 없음)
        public RectangleSuper() {
            System.out.println("RectangleSuper 생성자");
        }

        @Override
        public void finalize() {
            System.out.println("RectangleSuper 소멸자");
            super.finalize();                           // 부모 쪽 정리를 직접 호출 → 자식 → 부모 순서
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("---- 강의 코드 ----");
        Rectangle r;
        r = new Rectangle();

        System.out.println("---- super.finalize() 를 부르는 버전 ----");
        RectangleSuper r2 = new RectangleSuper();

        System.out.println("---- GC 요청 ----");
        r = null;               // 💡 더 이상 참조하지 않으면 가비지 컬렉션 대상
        r2 = null;
        System.gc();            // 💡 가비지 컬렉터 실행을 "요청" (보장은 아님)
        Thread.sleep(500);      // 💡 finalize 를 실행하는 스레드가 돌 시간을 줌
    }
}
