/**
 * [10-2 상속2] [실습] 자바를 이용하여 다중 상속 구현하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
