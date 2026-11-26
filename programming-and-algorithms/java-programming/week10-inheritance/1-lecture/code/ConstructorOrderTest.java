/**
 * [10-1 상속1] 상위 클래스 생성자 호출 순서
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
