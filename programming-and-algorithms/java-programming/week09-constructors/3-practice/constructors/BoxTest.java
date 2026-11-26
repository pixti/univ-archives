/**
 * [9강 실습] 생성자 - 2번 문제 (Box 클래스 - 부피 비교)  💡 참고 답안
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class BoxTest {
    public static void main(String[] args) {
        double vb1, vb2, vb3;
        Box b1 = new Box(3.5, 4.4, 5.0, false);
        Box b2 = new Box();
        Box b3 = new Box();
        b3.setHeight(4.0);
        b3.setLength(5.0);
        b3.setWidth(2.4);

        // ----- main 나머지 부분 완성 -----
        b2.setHeight(5.0);
        b2.setWidth(6.0);
        b2.setLength(7.0);
        b2.setEmpty(false);

        vb1 = b1.getVolume();
        vb2 = b2.getVolume();
        vb3 = b3.getVolume();

        System.out.println("======================");
        System.out.println("박스 1 부피는 : " + Math.round(vb1));
        System.out.println("박스 2 부피는 : " + Math.round(vb2));
        System.out.println("박스 3 부피는 : " + Math.round(vb3));
        System.out.println("======================");

        // 가장 큰 부피 찾기
        int maxNo = 1;
        double max = vb1;
        if (vb2 > max) { max = vb2; maxNo = 2; }
        if (vb3 > max) { max = vb3; maxNo = 3; }
        System.out.println("박스" + maxNo + "의 부피가 가장 큽니다 : " + Math.round(max));
    }
}

class Box {
    private double height;
    private double width;
    private double length;
    private boolean empty;

    public Box() {
        this(0.0, 0.0, 0.0, true);   // 크기 0 의 빈 상자
    }

    public Box(double height, double width, double length, boolean empty) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.empty = empty;
    }

    public double getVolume() {
        return height * width * length;
    }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }
    public double getLength() { return length; }
    public void setLength(double length) { this.length = length; }
    public boolean isEmpty() { return empty; }          // 💡 boolean getter 는 is~ (7강 CellPhone)
    public void setEmpty(boolean empty) { this.empty = empty; }
}
