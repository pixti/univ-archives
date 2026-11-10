/**
 * [7강 실습] 클래스(2) - 1번 문제 ❶ (Circle 클래스 - Point 를 필드로 가지는 원)
 *
 * 문제
 *  중심 좌표(Point center)와 반지름(radius)을 필드로 가지는 Circle 클래스를 만드시오.
 *   - getter / setter
 *   - move(Point newPos)   : 중심을 newPos 로 옮긴다
 *   - resize(newRadius)    : 반지름을 바꾼다
 *   - getArea()            : 넓이
 *   - toString()           : "중심 : x, y 반지름 : r"
 *  Point 클래스는 private int x, y 와 getter / setter 를 가진다.
 *
 * 포인트
 *  - Circle 이 Point 객체를 필드로 "가지고 있는" 포함 관계(Composition)
 *        c1 ──▶ [ Circle : center ●, radius 7.0 ]
 *                                 └──▶ [ Point : x 3, y 5 ]
 *  - 중심 좌표를 읽을 때는 center.getX() 처럼 . 을 두 번 쓴다.
 *  - move(p2) 는 center 가 p2 객체를 가리키게 바꾼다. (좌표를 복사하는 것이 아니라 레퍼런스를 바꿈)
 *  - radius 는 double 이므로 7 을 넣으면 7.0 → toString 에서 소수 부분이 0 이면 정수로 출력
 *
 * 📝 필기 : resize(int newRadius) -> resize(double newRadius) 로 구현하도록 문제를 변경한다.
 *    (반지름 필드가 double 이므로 매개변수도 double 로 맞춤)
 *
 * 📝 필기 : this.center.getX()  center.getX() 로 해도되고
 *    아니면 this.getCenter().getX()  getCenter().getX() 로 메서드 이중으로 해도된다. 메서드 체이닝.
 * 📝 필기 (AI 설명) 클래스 안에서는 네 가지 모두 같은 결과다.
 *      this.center.getX()        ← 필드 center 에 this 를 붙여 명시
 *      center.getX()             ← this 생략
 *      this.getCenter().getX()   ← getter 가 돌려준 Point 에 바로 .getX() (메서드 체이닝)
 *      getCenter().getX()        ← this 생략
 *
 * 💡 move(p2) 뒤에 main 에서 p2.setX(100) 을 하면 원의 중심도 같이 바뀐다. (같은 Point 객체를 공유)
 *    이게 싫다면 move 에서 새 Point 를 만들어 좌표만 복사하면 된다.
 * 💡 같은 폴더의 CircleInnerPointTest.java (❷) 에도 Circle, Point 가 있어서 두 파일을 한꺼번에 컴파일하면
 *    이름이 겹친다. java CircleTest.java 처럼 한 파일씩 실행한다.
 *
 * 실행 결과
 *  중심 : 3, 5 반지름 : 7
 *  중심 : 8, 8 반지름 : 4
 *  넓이 : 50.26548245743669
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Point p1 = new Point();
        p1.setX(3);
        p1.setY(5);
        c1.setCenter(p1);
        c1.setRadius(7);
        System.out.println(c1.toString());

        Point p2 = new Point();
        p2.setX(8);
        p2.setY(8);
        c1.move(p2);
        c1.resize(4);
        System.out.println(c1.toString());
        System.out.println("넓이 : " + c1.getArea());     // 💡 getArea 확인용 출력 추가
    }
}

class Circle {
    private Point center;
    private double radius;

    public Point getCenter() { return center; }
    public void setCenter(Point center) { this.center = center; }
    public double getRadius() { return radius; }
    public void setRadius(double radius) { this.radius = radius; }

    public void move(Point newPos) {
        this.center = newPos;
    }

    public void resize(double newRadius) {      // 📝 int → double 로 변경
        this.radius = newRadius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        String rStr = (radius % 1 == 0) ? String.valueOf((int) radius) : String.valueOf(radius);
        return "중심 : " + center.getX() + ", " + center.getY() + " 반지름 : " + rStr;
        // 같은 결과 : this.center.getX() / this.getCenter().getX() / getCenter().getX()
    }
}

class Point {
    private int x, y;

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
}
