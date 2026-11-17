/**
 * [10강 실습] 상속 - 5번 문제 (Vehicle / Truck / Car / Motorcycle)
 *
 * 문제
 *  차량 관련 클래스들을 정의하라. 기본 클래스는 Vehicle 이며 하위 클래스는 Truck, Car 및 Motorcycle 이다.
 *  Vehicle 클래스에는 제조업체, 모델, 연도, 연료 유형, 연비와 같은 속성이 있다.
 *  연비, 이동 거리, 최대 속도를 계산하는 메서드들도 있으며 이들의 구현은 하위 클래스에 따라 달라진다.
 *
 *    // Main class
 *    public class Main {
 *        public static void main(String[] args) {
 *            // Create instances of each vehicle type
 *            Truck truck = new Truck("Tatra", "Tatra 810 4x4", 2020, "GASOLINE", 8.112, 4.5);
 *            Car car = new Car("Volkswagen", "Virtus", 2019, "HYBRID", 6.123, 8);
 *            Motorcycle motorcycle = new Motorcycle("Massimo Motor", "Warrior200", 2018, "GASOLINE", 2.1, 0.0);
 *
 *            // Print the vehicle details and calculations
 *            System.out.println("Truck Model: " + truck.getModel());
 *            System.out.println("Fuel Efficiency: " + truck.calculateFuelEfficiency() + " mpg");
 *            System.out.println("Max Speed: " + truck.getMaxSpeed() + " mph\n");
 *            ... (Car, Motorcycle 도 같은 형식)
 *        }
 *    }
 *
 * 💡 풀이 코드가 남아 있지 않아 문제의 main 과 실행 결과에 맞게 작성한 참고 답안이다.
 *    생성자의 마지막 인수가 무엇인지는 문제에 나와 있지 않아서, 실행 결과의 연비가 나오도록 정했다.
 *      Truck      : 마지막 인수 = 적재량(톤) 4.5      → 연비 = 8.112 / (1 + 4.5 / 1000) = 8.075659532105526
 *      Car        : 마지막 인수 = 좌석 수 8          → 연비 = 6.123 / (1 + 8 / 5.0)    = 2.355
 *      Motorcycle : 마지막 인수 = 사이드카 무게 0.0   → 연비 = 2.1 (무게가 0 이면 그대로)
 *    연비(fuelEfficiency)는 "기본 연비", calculateFuelEfficiency() 는 하위 클래스마다 조건을 반영한 "실제 연비" 다.
 *
 * 포인트
 *  - 공통 속성(make, model, year, fuelType, fuelEfficiency)과 getter 는 Vehicle 에 한 번만 둔다.
 *  - "구현은 하위 클래스에 따라 달라진다" → calculateFuelEfficiency(), calculateDistanceTraveled(), getMaxSpeed() 를
 *    Vehicle 에서는 기본 동작만 정하고, 각 하위 클래스가 재정의한다.
 *  - 하위 클래스의 생성자는 super(make, model, year, fuelType, fuelEfficiency) 로 공통 속성을 부모에게 넘긴다.
 *
 * 💡 Vehicle 의 메서드는 "차량마다 다르므로 부모에서는 정할 수 없다". 이런 메서드는 다음 차시의 추상 메서드로 만드는 것이
 *    더 알맞다. (abstract class Vehicle { abstract double getMaxSpeed(); ... } → practice/inheritance2)
 * 💡 이동 거리(calculateDistanceTraveled)는 main 에서 쓰지 않지만 문제의 "이동 거리 계산" 조건 때문에 만들었다.
 *    (실제 연비 x 연료량. 여기서는 연료 10 갤런 기준)
 * 💡 원래 이클립스에서 Main 클래스로 작성하는 문제. 문제에 맞게 VehicleTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Truck Model: Tatra 810 4x4
 *  Fuel Efficiency: 8.075659532105526 mpg
 *  Max Speed: 80.0 mph
 *
 *  Car Model: Virtus
 *  Fuel Efficiency: 2.355 mpg
 *  Max Speed: 120.0 mph
 *
 *  Motorcycle Model: Warrior200
 *  Fuel Efficiency: 2.1 mpg
 *  Max Speed: 80.0 mph
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
