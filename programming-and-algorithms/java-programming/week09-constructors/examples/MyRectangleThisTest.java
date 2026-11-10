/**
 * [9-3 생성자와 소멸자] [실습] 다른 생성자 호출하기 – 이전 실습 부분 수정 (슬라이드 14)
 *
 * 포인트
 *  - MyRectangleTest.java 의 생성자들을 this(...) 로 바꿨다.
 *  - MyPoint()       → this(0, 0)
 *  - MyPoint(int x, int y) → 매개변수 이름을 필드와 같게 하고 this.x = x
 *  - MyRectangle()   → this(new MyPoint(0, 0), 0, 0)
 *
 * 📝 필기 (실습 1번) : 생성자 체이닝 this() 기법.
 *    매개변수가 가장 많은 생성자 하나에만 실제 대입 코드를 두고, 나머지는 this(...) 로 그 생성자를 호출한다.
 *    → 초기화 코드가 한 곳에 모여 중복이 없고, 고칠 때도 한 곳만 고치면 된다.
 *
 * 💡 슬라이드는 MyRectangle() 까지만 보여 준다("…"). 나머지 MyRectangle(int x, int y, int w, int h) 도
 *    this(new MyPoint(x, y), w, h) 로 바꿨다.
 * 💡 this 의 두 가지 쓰임
 *      this.필드, this.메소드() : 현재 객체의 필드 · 메소드        (일반 메소드, 생성자)
 *      this(인수...)           : 같은 클래스의 다른 생성자 호출     (생성자 안에서만, 첫 문장)
 *
 * 실행 결과 (MyRectangleTest.java 와 같음)
 *  r1 면적은 0입니다.
 *  r2 면적은 30입니다.
 *  r3 면적은 36입니다.
 */
public class MyRectangleThisTest {
    public static void main(String[] args) {
        MyRectangle r1 = new MyRectangle();
        MyRectangle r2 = new MyRectangle(new MyPoint(3, 3), 5, 6);
        MyRectangle r3 = new MyRectangle(3, 3, 6, 6);
        System.out.println("r1 면적은 " + r1.getArea() + "입니다.");
        System.out.println("r2 면적은 " + r2.getArea() + "입니다.");
        System.out.println("r3 면적은 " + r3.getArea() + "입니다.");
    }
}

class MyPoint {
    private int x, y;

    public MyPoint() {
        this(0, 0);
    }

    public MyPoint(int x, int y) {  // this 키워드
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public void setX(int newX) { x = newX; }
    public int getY() { return y; }
    public void setY(int newY) { y = newY; }
}

class MyRectangle {
    private MyPoint corner;
    private int width, height;

    public MyRectangle() {
        this(new MyPoint(0, 0), 0, 0);  // this 키워드
    }

    public MyRectangle(MyPoint p, int w, int h) {   // ← 실제 초기화는 여기서만
        corner = p;
        width = w;
        height = h;
    }

    public MyRectangle(int x, int y, int w, int h) {
        this(new MyPoint(x, y), w, h);  // 💡 슬라이드 "…" 부분
    }

    public MyPoint getPoint() { return corner; }
    public void setPoint(MyPoint newP) { corner = newP; }
    public int getWidth() { return width; }
    public void setWidth(int newW) { width = newW; }
    public int getHeight() { return height; }
    public void setHeight(int newH) { height = newH; }

    public void resize(int newW, int newH) {
        width = newW;
        height = newH;
    }

    public int getArea() {
        return width * height;
    }
}
