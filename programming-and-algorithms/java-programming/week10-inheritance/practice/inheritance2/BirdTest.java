/**
 * [10강 실습] 상속 (추상 클래스) - 4번 문제 (abstract Bird / Eagle / Hawk)
 *
 * 문제
 *  추상 메소드 fly() 및 makeSound() 를 갖는 추상 클래스 Bird 를 작성하라.
 *  Bird 클래스를 상속하고 각 새가 날아다니고 소리를 내는 방법을 설명하는 각각의 메서드를 구현하는
 *  하위 클래스 Eagle 및 Hawk 를 작성하라.
 *
 *    // Main
 *    public class Main {
 *        public static void main(String[] args) {
 *            Bird eagle = new Eagle();
 *            Bird hawk = new Hawk();
 *
 *            eagle.fly();
 *            eagle.makeSound();
 *
 *            hawk.fly();
 *            hawk.makeSound();
 *        }
 *    }
 *
 * 📝 필기
 *  1. 추상 클래스와 추상 메소드 정의 (Bird)
 *     - 추상화 (Abstraction)
 *       · 독수리(Eagle)와 매(Hawk)의 공통 상위 개념인 "새(Bird)" 를 정의한 클래스다.
 *       · 모든 새는 날 수 있고(fly) 소리를 낼 수 있지만(makeSound), 구체적으로 어떤 새인지 정해지지 않은 상태에서는
 *         동작을 정의할 수 없으므로 미완성 상태인 추상 클래스로 만든다.
 *     - 문법적 특징
 *       · abstract class : 클래스 선언부에 abstract 가 붙으면 해당 클래스는 직접 인스턴스를 생성(new Bird())할 수 없다.
 *         오직 상속을 통해 부모 클래스로서의 역할만 수행한다.
 *       · public abstract void ...(); : 메소드 선언부에 abstract 가 붙으면 실행 블록인 중괄호({ })를 작성하지 않고
 *         세미콜론(;)으로 끝낸다. 반환 타입(void), 메소드 이름, 매개변수(())만 정의하여 하위 클래스가 따라야 할
 *         메소드의 형태(시그니처)를 지정한다.
 *  2. 상속과 메소드 오버라이딩 (Eagle, Hawk)  (Hawk 클래스도 동일한 구조이므로 Eagle 을 기준으로 설명)
 *     - 상속 (extends)
 *       · class Eagle extends Bird 는 Eagle 클래스가 Bird 클래스의 멤버(필드와 메소드)를 물려받는다는 의미다.
 *       · Bird 는 추상 클래스이므로, 이를 상속받은 Eagle 은 부모가 미완성으로 남겨 둔 추상 메소드들을 모두 완성해야만
 *         일반 클래스로서 객체를 생성할 수 있다.
 *     - 메소드 오버라이딩 (Method Overriding)
 *       · 상위 클래스에 선언된 추상 메소드의 구현부({ })를 하위 클래스에서 구체적으로 작성하는 과정이다.
 *       · 오버라이딩 성립 조건 : 부모 클래스의 메소드와 이름(fly, makeSound), 매개변수(()), 반환 타입(void)이 완전히
 *         일치해야 한다. 또한 접근 제어자(public)는 부모 클래스의 것보다 좁은 범위로 변경할 수 없다.
 *       · 구현의 강제성 : Bird 에 2개의 추상 메소드가 있으므로, 하위 클래스는 2개를 모두 오버라이딩해야 한다.
 *         하나라도 누락하면 컴파일 에러가 발생한다.
 *       · @Override 어노테이션 : 컴파일러에게 이 메소드가 부모의 메소드를 재정의한 것임을 알리는 표식이다.
 *         만약 메소드 이름을 flyy() 처럼 오타를 내면, 컴파일러가 부모 클래스에 해당 메소드가 없다는 것을 감지하여 에러를 알려 준다.
 *  3. 다형성과 동적 바인딩 (Main)
 *     - 업캐스팅 (Upcasting)
 *       · Bird eagle = new Eagle(); 에서 등호(=)의 오른쪽은 실제로 메모리에 생성되는 인스턴스(new Eagle())이고,
 *         왼쪽은 그 인스턴스를 가리키는 참조 변수(Bird eagle)이다.
 *       · 하위 클래스의 인스턴스를 상위 클래스 타입의 참조 변수에 대입하는 것을 업캐스팅이라고 한다.
 *         하위 클래스는 상위 클래스의 모든 규격을 포함하고 있으므로 별도의 형변환 기호 없이 자동으로 허용된다.
 *     - 참조 변수의 역할과 한계
 *       · eagle 변수의 타입이 Bird 이기 때문에, 이 변수를 통해 호출할 수 있는 메소드는 Bird 클래스에 정의된 fly() 와
 *         makeSound() 로 제한된다. (만약 Eagle 클래스에만 별도로 추가된 고유 메소드가 있다면 Bird 타입 변수로는 호출할 수 없다)
 *     - 동적 바인딩 (Dynamic Binding) 과 다형성 (Polymorphism)
 *       · eagle.fly(); 를 실행할 때, 컴파일 시점에는 컴파일러가 Bird 클래스에 fly() 메소드가 존재하는지만 확인한다.
 *       · 이후 프로그램이 실제로 실행되는 시점(런타임)에는 자바 가상 머신(JVM)이 참조 변수 eagle 이 실제로 가리키고 있는
 *         메모리상의 객체(Eagle 인스턴스)를 확인하고, Bird 의 추상 메소드가 아닌 Eagle 클래스에 오버라이딩된 fly() 메소드를
 *         연결하여 실행한다. 이를 동적 바인딩이라고 한다.
 *       · 결과적으로 동일한 Bird 타입의 참조 변수로 동일한 메소드(fly(), makeSound())를 호출하더라도, 참조 변수가 가리키는
 *         실제 인스턴스가 Eagle 인지 Hawk 인지에 따라 서로 다른 동작이 수행된다. 이것이 다형성의 핵심 원리다.
 *
 * 📝 필기 : 접근 제어자 정리
 *  1. 접근 제어자란 무엇인가?
 *     접근 제어자는 클래스, 필드(변수), 생성자, 메소드 앞에 붙여서 외부로부터의 접근 허용 범위를 지정하는 키워드다.
 *     - 사용 목적 (캡슐화와 정보 은닉) : 객체 내부의 중요한 데이터(예 : 급여, 비밀번호 등)가 외부에서 잘못된 값으로 직접 수정되는
 *       것을 막고, 설계자가 허용한 경로(메소드 등)를 통해서만 안전하게 접근하도록 통제하기 위해 사용한다.
 *  2. 4가지 접근 제어자의 종류와 허용 범위  (접근 범위가 가장 좁은 것부터 넓은 순서)
 *     (※ 패키지(Package)란 자바 파일들을 묶어 놓은 "폴더" 라고 이해하면 된다)
 *       접근 제어자   같은 클래스 내부   같은 패키지(폴더)   다른 패키지의 자식 클래스   그 외 모든 영역
 *       private           O                  X                   X                          X
 *       (default)         O                  O                   X                          X
 *       protected         O                  O                   O                          X
 *       public            O                  O                   O                          O
 *     ① private (비공개)
 *       · 범위 : 오직 해당 멤버가 선언된 자기 자신의 클래스 내부에서만 접근할 수 있다.
 *       · 특징 : 외부 클래스는 물론, 나를 상속받은 자식 클래스조차 직접 접근할 수 없다. 클래스 내부의 데이터를 가장 안전하게
 *         보호할 때 사용한다.
 *     ② (default) (기본 / 패키지 전용)
 *       · 범위 : 키워드를 아무것도 적지 않았을 때 자동으로 적용되며, 같은 패키지(폴더) 안에 있는 클래스들끼리만 접근할 수 있다.
 *       · 특징 : 다른 폴더에 있는 클래스에서는 상속을 받았더라도 접근할 수 없다.
 *     ③ protected (상속 허용)
 *       · 범위 : 같은 패키지 안에서는 모두 접근 가능하고, 다른 패키지에 있더라도 상속받은 자식 클래스 내부라면 접근을 허용한다.
 *       · 특징 : 부모 클래스가 자신의 필드나 메소드를 외부에는 숨기되, 자식 클래스에게는 물려주어 자유롭게 쓰게 하고 싶을 때 사용한다.
 *     ④ public (완전 공개)
 *       · 범위 : 패키지 위치나 상속 여부와 관계없이 프로그램 내의 모든 곳에서 접근할 수 있다.
 *       · 특징 : 외부에서 객체를 생성하거나 기능을 호출해야 하는 통로(생성자, 주요 메소드 등)에 주로 사용한다.
 *  3. 이전 문제(Employee) 코드에 적용된 이유 분석  (EmployeeSalaryTest.java)
 *       abstract class Employee {
 *           protected String name;          // (1) 왜 protected 인가?
 *           protected double baseSalary;
 *           public Employee(...) { ... }    // (2) 왜 public 인가?
 *           public abstract void displayInfo();
 *       }
 *       class Manager extends Employee {
 *           private double bonus;           // (3) 왜 private 인가?
 *       }
 *     1. 부모 클래스(Employee)의 변수에 protected 를 쓴 이유
 *        · name 과 baseSalary 는 자식 클래스인 Manager 와 Programmer 의 displayInfo() 나 calculateSalary() 메소드 안에서
 *          직접 가져다 써야 한다.
 *        · 만약 이를 private 으로 선언하면 자식 클래스에서 return baseSalary + bonus; 라고 적었을 때 "부모의 private 변수에
 *          접근할 수 없다" 는 컴파일 에러가 발생한다.
 *        · 따라서 외부의 임의 접근은 막으면서 자식 클래스에게는 접근을 허용하는 protected 를 사용한 것이다.
 *        · (참고 : 만약 부모 변수를 private 으로 선언하고 싶다면, 부모 클래스에 public double getBaseSalary() { return baseSalary; }
 *          같은 조회용 메소드(Getter)를 추가로 만들어 자식에게 제공해야 한다)
 *     2. 자식 클래스(Manager)의 변수에 private 를 쓴 이유
 *        · bonus 변수는 Manager 클래스 내부의 계산과 출력에서만 사용되며, 외부(Main 등)나 다른 클래스에서 이 변수에 직접 접근할
 *          일이 없다. 또한 Manager 를 다시 상속받는 하위 클래스도 없으므로 가장 엄격한 private 으로 감추는 것이 안전하다.
 *     3. 생성자와 추상 메소드에 public 을 쓴 이유
 *        · 생성자(Manager(...))와 출력 메소드(displayInfo())는 외부 클래스인 Main 에서 직접 호출해서 사용해야 하는 대상이므로,
 *          어디서든 접근할 수 있도록 public 으로 열어 두어야 한다.
 *  4. 접근 제어자 사용 시 주의할 문법 규칙
 *     1. 클래스 자체에 붙일 수 있는 제어자 : 일반 클래스 앞에는 public 과 (default) 두 가지만 붙일 수 있다. 또한 하나의 .java 파일
 *        안에는 파일 이름과 동일한 이름의 클래스에만 public 을 붙일 수 있다. (예 : Main.java 파일 안에서는 public class Main 만
 *        가능하고, Employee 등은 (default) 로 작성)
 *     2. private 과 abstract 는 함께 쓸 수 없음 : 추상 메소드는 자식이 물려받아 구현해야 하는데 private 으로 막으면 자식이 볼 수
 *        없으므로 문법적으로 금지된다.
 *     3. 오버라이딩 시 접근 범위 축소 불가 : 부모 클래스에서 protected 로 선언한 메소드를 자식이 오버라이딩할 때는 protected 나
 *        더 넓은 public 만 사용할 수 있으며, 더 좁은 (default) 나 private 으로는 변경할 수 없다. 부모에서 public 이었다면 자식도
 *        무조건 public 이어야 한다.
 *
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 BirdTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Eagle: Flying high in the sky.
 *  Eagle: Screech! Screech!
 *  Hawk: Soaring through the air.
 *  Hawk: Caw! Caw!
 */
public class BirdTest {
    public static void main(String[] args) {
        Bird eagle = new Eagle();
        Bird hawk = new Hawk();

        eagle.fly();
        eagle.makeSound();

        hawk.fly();
        hawk.makeSound();
    }
}

abstract class Bird {
    public abstract void fly();
    public abstract void makeSound();
}

class Eagle extends Bird {
    @Override
    public void fly() {
        System.out.println("Eagle: Flying high in the sky.");
    }

    @Override
    public void makeSound() {
        System.out.println("Eagle: Screech! Screech!");
    }
}

class Hawk extends Bird {
    @Override
    public void fly() {
        System.out.println("Hawk: Soaring through the air.");
    }

    @Override
    public void makeSound() {
        System.out.println("Hawk: Caw! Caw!");
    }
}
