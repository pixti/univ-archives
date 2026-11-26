/**
 * [10-1 상속1] 상속의 구조 - 부모 클래스 Car 를 상속한 SportsCar
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
