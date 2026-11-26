/**
 * [10강 과제] 상속 - 1번 문제 (Vehicle / Car : drive 재정의)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
