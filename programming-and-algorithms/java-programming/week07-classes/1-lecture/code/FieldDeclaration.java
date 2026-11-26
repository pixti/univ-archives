/**
 * [7-1] 필드 선언 - 객체마다 고유의 필드가 따로 존재한다
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class FieldDeclaration {
    public static void main(String[] args) {
        MyRectangle ob1 = new MyRectangle();
        MyRectangle ob2 = new MyRectangle();
        ob1.x = 0; ob1.y = 0; ob1.width = 10; ob1.height = 10;
        ob2.x = 5; ob2.y = 5; ob2.width = 15; ob2.height = 10;
        System.out.println("위치 : " + ob1.x + ", " + ob1.y + " 폭 : "
                + ob1.width + " 높이 : " + ob1.height);
        System.out.println("위치 : " + ob2.x + ", " + ob2.y + " 폭 : "
                + ob2.width + " 높이 : " + ob2.height);

        // 💡 레퍼런스 필드 : origin 이 가리키는 MyPoint 객체의 필드를 다시 . 으로 접근
        MyRectangle2 r = new MyRectangle2();
        r.origin.x = 3; r.origin.y = 4; r.width = 20; r.height = 30;
        System.out.println("origin : " + r.origin.x + ", " + r.origin.y
                + " 폭 : " + r.width + " 높이 : " + r.height);
    }
}

class MyRectangle {
    int x, y, width, height;
}

// 필드에 객체의 레퍼런스를 저장
class MyPoint {
    int x, y; // 좌표값
}

class MyRectangle2 {          // 강의 코드에서는 이름이 MyRectangle (위 클래스와 겹쳐서 2 를 붙임)
    MyPoint origin = new MyPoint();
    int width, height; // 폭과 높이
}
