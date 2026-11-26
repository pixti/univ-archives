/**
 * [10강 실습] 상속 - 5번 문제 (Vehicle / Truck / Car / Motorcycle)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class VehicleTest {
    public static void main(String[] args) {
        // Create instances of each vehicle type
        Truck truck = new Truck("Tatra", "Tatra 810 4x4", 2020, "GASOLINE", 8.112, 4.5);
        Car car = new Car("Volkswagen", "Virtus", 2019, "HYBRID", 6.123, 8);
        Motorcycle motorcycle = new Motorcycle("Massimo Motor", "Warrior200", 2018, "GASOLINE", 2.1, 0.0);

        // Print the vehicle details and calculations
        System.out.println("Truck Model: " + truck.getModel());
        System.out.println("Fuel Efficiency: " + truck.calculateFuelEfficiency() + " mpg");
        System.out.println("Max Speed: " + truck.getMaxSpeed() + " mph\n");

        System.out.println("Car Model: " + car.getModel());
        System.out.println("Fuel Efficiency: " + car.calculateFuelEfficiency() + " mpg");
        System.out.println("Max Speed: " + car.getMaxSpeed() + " mph\n");

        System.out.println("Motorcycle Model: " + motorcycle.getModel());
        System.out.println("Fuel Efficiency: " + motorcycle.calculateFuelEfficiency() + " mpg");
        System.out.println("Max Speed: " + motorcycle.getMaxSpeed() + " mph");
    }
}

class Vehicle {
    private String make;             // 제조업체
    private String model;            // 모델
    private int year;                // 연도
    private String fuelType;         // 연료 유형
    private double fuelEfficiency;   // (기본) 연비

    public Vehicle(String make, String model, int year, String fuelType, double fuelEfficiency) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.fuelEfficiency = fuelEfficiency;
    }

    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getFuelType() { return fuelType; }
    public double getFuelEfficiency() { return fuelEfficiency; }

    // 하위 클래스에서 재정의할 메서드들 (기본 동작)
    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }

    public double calculateDistanceTraveled() {
        return calculateFuelEfficiency() * 10;   // 연료 10 갤런으로 갈 수 있는 거리
    }

    public double getMaxSpeed() {
        return 0.0;
    }
}

class Truck extends Vehicle {
    private double cargoCapacity;    // 적재량 (톤)

    public Truck(String make, String model, int year, String fuelType, double fuelEfficiency, double cargoCapacity) {
        super(make, model, year, fuelType, fuelEfficiency);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public double calculateFuelEfficiency() {
        return getFuelEfficiency() / (1.0 + cargoCapacity / 1000.0);   // 짐이 많을수록 연비가 떨어짐
    }

    @Override
    public double getMaxSpeed() {
        return 80.0;
    }
}

class Car extends Vehicle {
    private int numSeats;            // 좌석 수

    public Car(String make, String model, int year, String fuelType, double fuelEfficiency, int numSeats) {
        super(make, model, year, fuelType, fuelEfficiency);
        this.numSeats = numSeats;
    }

    @Override
    public double calculateFuelEfficiency() {
        return getFuelEfficiency() / (1.0 + numSeats / 5.0);           // 좌석이 많을수록(차가 클수록) 연비가 떨어짐
    }

    @Override
    public double getMaxSpeed() {
        return 120.0;
    }
}

class Motorcycle extends Vehicle {
    private double sidecarWeight;    // 사이드카 무게

    public Motorcycle(String make, String model, int year, String fuelType, double fuelEfficiency, double sidecarWeight) {
        super(make, model, year, fuelType, fuelEfficiency);
        this.sidecarWeight = sidecarWeight;
    }

    @Override
    public double calculateFuelEfficiency() {
        return getFuelEfficiency() / (1.0 + sidecarWeight / 100.0);    // 사이드카가 없으면(0.0) 기본 연비 그대로
    }

    @Override
    public double getMaxSpeed() {
        return 80.0;
    }
}
