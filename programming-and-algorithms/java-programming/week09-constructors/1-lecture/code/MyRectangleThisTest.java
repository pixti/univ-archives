/**
 * [9-3 생성자와 소멸자] [실습] 다른 생성자 호출하기 – 이전 실습 부분 수정
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MyRectangleThisTest {
    public static void main(String[] args) {
        MyRectangleThis r1 = new MyRectangleThis();
        MyRectangleThis r2 = new MyRectangleThis(new MyPointThis(3, 3), 5, 6);
        MyRectangleThis r3 = new MyRectangleThis(3, 3, 6, 6);
        System.out.println("r1 면적은 " + r1.getArea() + "입니다.");
        System.out.println("r2 면적은 " + r2.getArea() + "입니다.");
        System.out.println("r3 면적은 " + r3.getArea() + "입니다.");
    }
}

class MyPointThis {
    private int x, y;

    public MyPointThis() {
        this(0, 0);
    }

    public MyPointThis(int x, int y) {  // this 키워드
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public void setX(int newX) { x = newX; }
    public int getY() { return y; }
    public void setY(int newY) { y = newY; }
}

class MyRectangleThis {
    private MyPointThis corner;
    private int width, height;

    public MyRectangleThis() {
        this(new MyPointThis(0, 0), 0, 0);  // this 키워드
    }

    public MyRectangleThis(MyPointThis p, int w, int h) {   // ← 실제 초기화는 여기서만
        corner = p;
        width = w;
        height = h;
    }

    public MyRectangleThis(int x, int y, int w, int h) {
        this(new MyPointThis(x, y), w, h);  // 💡 강의 코드에서 "…" 로 생략된 부분
    }

    public MyPointThis getPoint() { return corner; }
    public void setPoint(MyPointThis newP) { corner = newP; }
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
