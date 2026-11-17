/**
 * [10강 과제] 상속 - 1번 문제 (Vehicle / Car : drive 재정의)
 *
 * 문제
 *  drive() 라는 메소드를 갖는 Vehicle 이라는 클래스를 작성하라. 이 메소드는 "Repairing a vehicle" 을 출력한다.
 *  그리고 drive() 메서드를 재정의하는 Car 라는 하위 클래스도 작성하라.
 *  이 메서드는 "Repairing a car" 를 출력토록 부모 클래스의 drive() 메서드를 재정의한다. main 은 다음과 같다.
 *
 *    public class Main {
 *        public static void main(String[] args) {
 *            Vehicle vehicle = new Vehicle();
 *            Car car = new Car();
 *            vehicle.drive();   // Output: Repairing a vehicle
 *            car.drive();       // Output: Repairing a car
 *        }
 *    }
 *
 * 포인트
 *  - class Car extends Vehicle 로 상속하고, drive() 를 똑같은 형태로 다시 정의(재정의)한다.
 *  - vehicle.drive() 는 Vehicle 의 것, car.drive() 는 Car 가 재정의한 것이 실행된다.
 *
 * 💡 메서드 이름은 drive 인데 출력은 "Repairing ..." 이다. 문제에 주어진 대로 작성했다.
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 VehicleRepairTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Repairing a vehicle
 *  Repairing a car
 */
public class VehicleRepairTest {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Car car = new Car();
        vehicle.drive();
        car.drive();
    }
}

class Vehicle {
    public void drive() {
        System.out.println("Repairing a vehicle");
    }
}

class Car extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Repairing a car");
    }
}
