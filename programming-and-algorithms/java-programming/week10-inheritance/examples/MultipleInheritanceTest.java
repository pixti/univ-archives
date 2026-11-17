/**
 * [10-2 상속2] [실습] 자바를 이용하여 다중 상속 구현하기
 *
 * 포인트
 *  - 픽업트럭(Pickup)은 승용차(PassengerCar)이면서 트럭(Truck)이기도 하다.
 *    하지만 자바는 클래스를 두 개 상속할 수 없으므로
 *      class Pickup extends PassengerCar implements ITruck
 *    처럼 승용차는 상속(extends), 트럭 기능은 인터페이스(ITruck)로 구현한다.
 *  - ITruck 의 메소드(getPayload, setPayload)는 필드로 가진 Truck 객체에게 맡긴다.  → truck.getPayload()
 *
 *      interface Car { showInfo() }
 *          ▲ implements                    ▲ extends
 *      class PassengerCar               interface ITruck { getPayload(), setPayload() }
 *          ▲ extends                        ▲ implements          ▲ implements
 *      class Pickup ────────────────────────┘                  class Truck
 *        └ Truck truck (필드) ─────────────────────────────────────▶ 일을 맡김
 *
 *  - main 에서는 세 종류의 차를 모두 Car 타입 배열에 넣고 showInfo() 를 부른다.
 *    → 실제 객체의 showInfo() 가 실행된다. (동적 바인딩, 10-3)
 *
 * 💡 interface ITruck extends Car : 인터페이스끼리는 extends 로 상속한다. (여러 개도 가능 : extends Car, Other)
 *    그래서 Truck 과 Pickup 은 ITruck 의 메소드와 Car 의 showInfo() 를 모두 구현해야 한다.
 * 💡 강의 코드는 interface ITruck { … }; 처럼 닫는 중괄호 뒤에 ; 가 있다. 클래스 / 인터페이스 선언 뒤의 ; 는 무시되므로
 *    오류는 아니지만 쓰지 않는 것이 보통이다.
 * 💡 Pickup 의 showInfo() 는 getSeats()(PassengerCar 에게서 상속)와 getPayload()(truck 에게 맡김)를 함께 쓴다.
 *    seats 는 PassengerCar 의 private 필드라서 Pickup 에서 직접 쓸 수 없다. → getSeats()
 * 💡 @Override 는 인터페이스의 메소드를 구현할 때도 붙일 수 있다.
 * 💡 같은 폴더의 다른 예제와 겹치지 않도록 모든 클래스를 MultipleInheritanceTest 안에 중첩해서 넣었다.
 *    강의 코드에서 "…" 로 생략된 부분은 앞뒤 강의 코드를 모아 채웠다.
 *
 * 실행 결과
 *  좌석 수 : 2
 *  적재 하중 : 500
 *  좌석 수 : 4, 적재 하중 : 2000, 견인 능력 : 10000
 */
public class MultipleInheritanceTest {

    interface Car {
        public void showInfo();
    }

    static class PassengerCar implements Car {
        private int seats;     // 정원

        public PassengerCar() { seats = 2; }
        public PassengerCar(int n) { seats = n; }
        public int getSeats() { return seats; }
        public void setSeats(int n) { seats = n; }
        public void showInfo() { System.out.println("좌석 수 : " + seats); }
    }

    interface ITruck extends Car {
        public int getPayload();
        public void setPayload(int w);
    }

    static class Truck implements ITruck {
        private int payload;   // 적재 하중

        public Truck() { payload = 100; }
        public Truck(int w) { payload = w; }
        public int getPayload() { return payload; }
        public void setPayload(int w) { payload = w; }
        public void showInfo() { System.out.println("적재 하중 : " + payload); }
    }

    static class Pickup extends PassengerCar implements ITruck {
        private int tow_capacity;   // 견인 능력
        Truck truck;

        public Pickup() { super(4); truck = new Truck(1000); tow_capacity = 10000; }
        public Pickup(int s, int w, int c) { super(s); truck = new Truck(w); tow_capacity = c; }

        public void setCapacity(int c) { tow_capacity = c; }
        public int getCapacity() { return tow_capacity; }

        public void showInfo() {
            System.out.println("좌석 수 : " + getSeats() + ", 적재 하중 : " + getPayload() + ", 견인 능력 : " + tow_capacity);
        }

        @Override
        public int getPayload() { return truck.getPayload(); }

        @Override
        public void setPayload(int w) { truck.setPayload(w); }
    }

    public static void main(String[] args) {
        Car[] cars = new Car[3];
        cars[0] = new PassengerCar();
        cars[1] = new Truck(500);
        cars[2] = new Pickup(4, 2000, 10000);
        for (int i = 0; i < 3; i++) {
            cars[i].showInfo();
        }
    }
}
