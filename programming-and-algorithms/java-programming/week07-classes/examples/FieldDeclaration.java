/**
 * [7-1] 필드 선언 - 객체마다 고유의 필드가 따로 존재한다
 *
 * 포인트
 *  - 필드 선언부는 객체들이 유지해야 할 데이터를 저장하는 변수들을 선언하는 곳
 *  - 객체를 생성할 때마다 고유의 필드가 따로 생기기 때문에 "객체식별자.필드명" 으로 써야 한다.
 *        ob1.x = 0;   ← ob1 객체의 x
 *        ob2.x = 5;   ← ob2 객체의 x (ob1 의 x 와 다른 변수)
 *  - 필드에는 기본 자료형뿐 아니라 객체의 레퍼런스를 저장하는 변수도 선언할 수 있다. (아래 MyRectangle2)
 *
 *      Stack                Heap
 *      ┌─────┐       ┌─────────────────────────┐
 *      │ ob1 │──────▶│ x=0 y=0 width=10 height=10 │
 *      ├─────┤       └─────────────────────────┘
 *      │ ob2 │──────▶┌─────────────────────────┐
 *      └─────┘       │ x=5 y=5 width=15 height=10 │
 *                    └─────────────────────────┘
 *
 * ⚠ 자주 틀리는 부분 : 한 파일에 public class 는 하나만 둘 수 있다. 그래서 MyRectangle 은
 *    public 을 빼고 같은 파일에 넣었다. (퀴즈 5번 📝 필기 참고)
 *
 * 실행 결과
 *  위치 : 0, 0 폭 : 10 높이 : 10
 *  위치 : 5, 5 폭 : 15 높이 : 10
 *  origin : 3, 4 폭 : 20 높이 : 30
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
