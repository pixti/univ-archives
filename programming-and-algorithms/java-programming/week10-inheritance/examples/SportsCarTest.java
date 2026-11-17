/**
 * [10-1 상속1] 상속의 구조 - 부모 클래스 Car 를 상속한 SportsCar
 *
 * 포인트 (강의 그림을 코드로 옮긴 것)
 *      SportsCar
 *      ┌──────────────────┐
 *      │ +speed           │
 *      │ +gear            │
 *      │ +color           │  ← 부모 클래스 Car 에서 상속받은 부분
 *      │ +setGear()       │
 *      │ +speedUp()       │
 *      │ +speedDown()     │
 *      ├──────────────────┤
 *      │ -turbo : bool    │  ← 추가한 부분
 *      │ +setTurbo()      │
 *      └──────────────────┘
 *    (+ 는 public, - 는 private 를 뜻하는 UML 표기)
 *
 *  - 자식 클래스 SportsCar 에는 turbo, setTurbo() 만 새로 쓰면 된다.
 *    나머지는 부모 Car 에서 물려받으므로 다시 쓸 필요가 없다. → 소프트웨어 재사용성 증가
 *  - 부모 : 기능을 물려주는 클래스 (부모, 상위, 슈퍼 클래스)
 *    자식 : 기능을 받는 클래스 (자식, 하위, 파생 클래스)
 *
 * 💡 자바에는 bool 이 없다. 그림의 bool 은 boolean 으로 썼다.
 * 💡 그림에는 필드의 자료형과 메소드의 내용이 없어서 간단히 채웠다. (speed 는 int, color 는 String 등)
 * 💡 자식 객체는 부모의 필드와 자기 필드를 "모두" 가진다. 하지만 부모 객체(new Car())에는 turbo 가 없다.
 * 💡 같은 폴더의 다른 예제와 클래스 이름이 겹치지 않도록 SportsCarTest 안에 static 중첩 클래스로 넣었다.
 *
 * 실행 결과
 *  기어 : 2, 속도 : 20, 색 : red, 터보 : false
 *  기어 : 2, 속도 : 70, 색 : red, 터보 : true
 */
public class SportsCarTest {

    static class Car {
        public int speed;
        public int gear;
        public String color;

        public void setGear(int newGear) {
            gear = newGear;
        }

        public void speedUp(int increment) {
            speed += increment;
        }

        public void speedDown(int decrement) {
            speed -= decrement;
        }
    }

    static class SportsCar extends Car {     // Car 를 상속
        private boolean turbo;                // 추가한 필드

        public void setTurbo(boolean newValue) {   // 추가한 메소드
            turbo = newValue;
        }

        public void print() {
            System.out.println("기어 : " + gear + ", 속도 : " + speed + ", 색 : " + color + ", 터보 : " + turbo);
        }
    }

    public static void main(String[] args) {
        SportsCar c = new SportsCar();
        c.color = "red";        // 부모에게서 물려받은 필드
        c.setGear(2);           // 부모에게서 물려받은 메소드
        c.speedUp(30);
        c.speedDown(10);
        c.print();

        c.setTurbo(true);       // 자식에서 추가한 메소드
        c.speedUp(50);
        c.print();
    }
}
