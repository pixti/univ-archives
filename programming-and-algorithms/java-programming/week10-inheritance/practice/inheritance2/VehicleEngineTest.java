/**
 * [10강 실습] 상속 (추상 클래스) - 3번 문제 (abstract Vehicle / Car / Motorcycle)
 *
 * 문제
 *  추상 메소드 startEngine() 및 stopEngine() 을 갖는 추상 클래스 Vehicle 을 작성하라.
 *  Vehicle 클래스를 상속하고 각 차량 유형에 대해 엔진을 시작하고 중지하는 해당 메서드를 구현하는
 *  Car 및 Motorcycle 하위 클래스를 작성하라.
 *
 *    // Main
 *    public class Main {
 *        public static void main(String[] args) {
 *            Vehicle car = new Car();
 *            Vehicle motorcycle = new Motorcycle();
 *
 *            car.startEngine();
 *            car.stopEngine();
 *
 *            motorcycle.startEngine();
 *            motorcycle.stopEngine();
 *        }
 *    }
 *
 * 📝 필기 : 이번 문제는 이전의 Animal 문제와 기본 구조는 같지만, 추상 메소드가 2개로 늘어났다는 점이 핵심이다.
 *  ① 다중 추상 메소드를 가진 추상 클래스 (Vehicle)
 *     - 개념 (설계도 역할) : Vehicle(탈것 / 차량)이라는 추상 클래스를 만들면서, "모든 차량은 반드시 엔진을 켜는 기능(startEngine)과
 *       엔진을 끄는 기능(stopEngine) 두 가지를 모두 가지고 있어야 한다!" 라고 표준 규격을 정한 것이다.
 *     - 자동차든 오토바이든 시동을 걸고 끄는 내부 원리는 다를 수 있지만, 운전자 입장에서는 "시동 켜기", "시동 끄기" 라는
 *       공통된 동작으로 제어할 수 있도록 틀(껍데기)만 미리 만들어 둔 것이다.
 *  ② 상속과 모든 추상 메소드의 구현 의무 (Car, Motorcycle)
 *     - 구현의 강제성 (매우 중요) : 자식 클래스(Car, Motorcycle)가 추상 클래스(Vehicle)를 extends 로 상속받으면,
 *       부모 클래스에 있는 모든 추상 메소드를 빠짐없이 오버라이딩(재정의)해야 한다.
 *     - 만약 Car 클래스에서 startEngine() 만 만들고 stopEngine() 을 만들지 않으면, 자바 컴파일러는
 *       "아직 미완성된 기능이 남아 있어!" 라며 에러를 발생시킨다. (만약 하나라도 구현하기 싫다면 자식 클래스도 abstract 를
 *       붙여 추상 클래스가 되어야 한다)
 *     - 이렇게 함으로써 개발자가 실수로 필수 기능(예 : 시동 끄기 기능)을 빼먹고 코드를 작성하는 것을 원천적으로 방지할 수 있다.
 *  ③ 업캐스팅과 동적 바인딩 (Main 클래스)
 *     - 업캐스팅(Upcasting) : Car 객체와 Motorcycle 객체를 생성해서 부모 타입인 Vehicle 변수에 담았다.
 *       둘 다 "탈것(Vehicle)" 의 일종이므로 하나의 공통 타입으로 다룰 수 있다.
 *     - 동적 바인딩(Dynamic Binding) : car 변수의 타입은 Vehicle 이지만, car.startEngine() 을 실행할 때 자바는 Vehicle 의
 *       빈 껍데기 메소드가 아니라, 실제 메모리에 생성된 객체인 Car 클래스의 오버라이딩된 startEngine() 을 찾아가서 실행한다.
 *     - 덕분에 똑같은 모양의 코드(.startEngine())를 호출해도 car 는 "Car: Starting..." 을, motorcycle 은
 *       "Motorcycle: Starting..." 을 정확하게 출력하게 된다. 이것이 객체 지향의 꽃이라 불리는 다형성(Polymorphism)의 동작 원리다.
 *
 * 📝 필기 (질문) : 추상 메소드에 private 를 쓸 수 있나? 왜 주로 public 으로 선언하나?
 *  결론부터 말하면 추상 메소드에는 절대 private 을 사용할 수 없으며(문법 에러 발생), 보통 외부에서 호출해야 하는 기능이기 때문에
 *  public 을 주로 사용한다.
 *  1. 왜 private 은 절대 안 될까? (모순 발생)
 *     자바에서 두 키워드의 의미를 생각해 보면 왜 같이 쓸 수 없는지 바로 이해가 된다.
 *     - abstract (추상) : "나는 빈 껍데기야. 나를 상속받는 자식 클래스가 이 메소드를 물려받아서 내용을 완성(오버라이딩)해 줘!"
 *     - private (비공개) : "이 메소드는 오직 이 클래스 내에서만 볼 수 있어! 아무리 자식 클래스(Car)라도 절대 볼 수 없고 접근할 수도 없어!"
 *     만약 private abstract void startEngine(); 이라고 적으면, 부모 클래스가 자식 클래스에게 "이 메소드를 반드시 완성해라!
 *     하지만 너한테는 안 보여 줄 거고 접근도 못 하게 할 거야!" 라고 말하는 셈이 된다. 자식 클래스 입장에서는 부모에게
 *     그런 메소드가 있는지조차 보이지 않으니 오버라이딩을 할 수가 없다.
 *     이렇게 두 키워드의 목적이 정반대로 충돌하기 때문에, 자바에서는 private 과 abstract 를 같이 쓰면 즉시 컴파일 에러가 발생한다.
 *       error: illegal combination of modifiers: abstract and private
 *  2. 왜 주로 public 으로 선언할까?
 *     - "외부에 공개되어 사용되어야 하는 기능" 이기 때문이다.
 *     - 자동차의 startEngine() (시동 버튼)이나 동물의 sound() (울음소리)는 외부(예 : Main 클래스의 운전자)에서 호출해서
 *       쓰라고 만든 기능이다.
 *     - 어디서든 제한 없이 이 기능들을 호출할 수 있도록 가장 개방적인 접근 제어자인 public 을 붙이는 것이 일반적이다.
 *  3. 그럼 무조건 public 만 써야 하나요? (심화 개념)
 *     꼭 public 만 되는 것은 아니다. private 만 아니면 된다! 자바에는 4가지 접근 제어자가 있는데, 추상 메소드에는
 *     다음 3가지를 쓸 수 있다.
 *       1. public : 모든 곳에서 접근 가능 (가장 흔하게 사용)
 *       2. protected : 같은 폴더(패키지) 안에 있거나, 다른 폴더에 있더라도 상속받은 자식 클래스라면 접근 가능
 *       3. (아무것도 안 적음, default) : 같은 폴더(패키지) 안에서만 접근 가능
 *     실제로 이 문제의 코드에서 public 을 지우고 그냥 abstract void startEngine(); 이라고만 적어도 코드는 정상 작동한다.
 *     (모두 한 파일 / 같은 폴더에 있기 때문)
 *     ⚠ 단, 주의할 규칙 하나! 자식 클래스가 오버라이딩할 때는 부모의 접근 범위보다 좁게 만들 수 없다.
 *       · 부모(Vehicle)에서 public abstract void startEngine(); 이라고 public 으로 선언했다면,
 *       · 자식(Car)에서도 반드시 public void startEngine() 으로 구현해야 한다. (자식이 마음대로 public 을 빼 버리거나
 *         protected 로 바꿀 수 없다)
 *  요약하자면 : 추상 메소드는 자식에게 물려주어야 하므로 private 은 절대 불가능하고, 외부에서 두루두루 호출할 수 있는
 *  표준 규격(버튼) 역할을 하기 때문에 public 을 사용하는 것이다!
 *
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 VehicleEngineTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Car: Starting the engine...
 *  Car: Stopping the engine...
 *  Motorcycle: Starting the engine...
 *  Motorcycle: Stopping the engine...
 */
public class VehicleEngineTest {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();

        car.startEngine();
        car.stopEngine();

        motorcycle.startEngine();
        motorcycle.stopEngine();
    }
}

abstract class Vehicle {
    public abstract void startEngine();
    public abstract void stopEngine();
}

class Car extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car: Starting the engine...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car: Stopping the engine...");
    }
}

class Motorcycle extends Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Motorcycle: Starting the engine...");
    }

    @Override
    public void stopEngine() {
        System.out.println("Motorcycle: Stopping the engine...");
    }
}
