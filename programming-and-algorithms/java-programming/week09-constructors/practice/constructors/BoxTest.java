/**
 * [9강 실습] 생성자 - 2번 문제 (Box 클래스 - 부피 비교)  💡 참고 답안
 *
 * 문제 (요약)
 *  높이(height), 너비(width), 길이(length)와 상자가 비었는지(empty)를 필드로 가지는 Box 클래스를 작성하시오.
 *  - 생성자를 중복 정의한다. (모든 값을 받는 생성자 / 매개변수 없는 생성자)
 *  - 부피를 구하는 getVolume() 메소드를 둔다.
 *  - 주어진 main 의 나머지 부분을 완성해 세 상자의 부피와 가장 큰 상자를 출력한다.
 *
 *    double vb1, vb2, vb3;
 *    Box b1 = new Box(3.5, 4.4, 5.0, false);
 *    Box b2 = new Box();
 *    Box b3 = new Box();
 *    b3.setHeight(4.0);
 *    b3.setLength(5.0);
 *    b3.setWidth(2.4);
 *    // main 나머지 부분 완성
 *
 * 💡 직접 풀지 않은 문제라 참고 답안으로 채웠다.
 * 💡 실행 결과에 "박스 2 부피는 : 210" 이 나오므로 b2 에 5 x 6 x 7 = 210 을 넣었다. (문제에 값이 없음)
 * 💡 부피를 그대로 출력하면 3.5 * 4.4 * 5.0 = 77.00000000000001 처럼 실수 오차가 보인다.
 *    실행 결과처럼 정수로 보이도록 Math.round() 로 반올림해서 출력했다.
 *    ((int) 로 자르면 47.99999... 같은 값이 47 이 될 수 있어서 반올림이 안전하다.)
 * 💡 Box() 는 this(0, 0, 0, true) 로 "크기 0 의 빈 상자"를 만든다. (생성자 체이닝)
 *
 * 실행 결과
 *  ======================
 *  박스 1 부피는 : 77
 *  박스 2 부피는 : 210
 *  박스 3 부피는 : 48
 *  ======================
 *  박스2의 부피가 가장 큽니다 : 210
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
