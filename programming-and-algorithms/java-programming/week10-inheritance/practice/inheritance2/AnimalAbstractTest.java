/**
 * [10강 실습] 상속 (추상 클래스) - 1번 문제 (abstract Animal / Lion / Tiger)
 *
 * 문제
 *  sound() 라는 추상 메소드를 사용하여 Animal 추상 클래스를 정의하는 Java 프로그램을 작성하라.
 *  Animal 클래스를 상속받아 각 동물에 대해 특정 소리를 내는 sound() 메서드를 구현하는 하위 클래스 Lion 및 Tiger 를 작성하라.
 *
 *    // Main
 *    public class Main {
 *        public static void main(String[] args) {
 *            Animal lion = new Lion();
 *            lion.sound();   // Output: Lion roars!
 *
 *            Animal tiger = new Tiger();
 *            tiger.sound();  // Output: Tiger growls!
 *        }
 *    }
 *
 * 📝 필기 : 이 프로그램에는 객체 지향 프로그래밍(OOP)의 가장 핵심적인 4가지 개념(추상화, 상속, 오버라이딩, 다형성)이 모두 들어 있다.
 *  1. 추상 클래스(Abstract Class)와 추상 메소드(Abstract Method)
 *       abstract class Animal { public abstract void sound(); }
 *     - 개념 : "동물(Animal)" 이라는 개념은 추상적이다. 세상에는 사자, 호랑이, 강아지 같은 구체적인 동물이 존재하지,
 *       그냥 "동물" 그 자체인 생명체는 없다. 또한 모든 동물은 소리를 내지만(sound), 어떤 동물인지 정해지지 않으면
 *       무슨 소리를 내는지 구체적으로 적을 수 없다. 이럴 때 사용하는 것이 추상 클래스와 추상 메소드다.
 *     - abstract 키워드 : 클래스나 메소드 앞에 붙여서 "이것은 미완성 설계도입니다" 라고 알려 주는 역할을 한다.
 *     - 특징
 *       1. 직접 객체를 만들 수 없다 : 미완성 설계도이기 때문에 new Animal() 처럼 직접 생성할 수 없다.
 *       2. 중괄호 { } 가 없다 : public abstract void sound(); 를 보면 실행 내용을 적는 { } 없이 세미콜론(;)으로 바로 끝난다.
 *          "소리를 내는 기능은 무조건 있어야 해! 하지만 구체적인 소리는 나를 상속받는 클래스가 직접 채워 넣어!" 라고
 *          강제(규칙 부여)하는 것이다.
 *  2. 상속 (Inheritance)
 *       class Lion extends Animal { ... }   class Tiger extends Animal { ... }
 *     - 개념 : 부모 클래스(Animal)가 가진 특징(변수나 메소드)을 자식 클래스(Lion, Tiger)가 물려받는 것이다.
 *     - extends 키워드 : "확장하다" 라는 뜻으로, Animal 이라는 기본 틀을 가져와서 Lion 이라는 구체적인 클래스로 확장하겠다는 의미다.
 *     - 장점 : 공통적인 특징을 부모 클래스에 한 번만 정의해 두면, 여러 자식 클래스에서 코드를 중복해서 작성할 필요가 없어진다.
 *  3. 메소드 오버라이딩 (Method Overriding, 재정의)
 *     - 개념 : 부모 클래스에게 물려받은 메소드를 자식 클래스의 상황에 맞게 내용을 고쳐서(혹은 채워서) 다시 정의하는 것이다.
 *     - 의무 사항 : 자식 클래스가 추상 클래스(Animal)를 상속받으면, 부모의 미완성 메소드(sound())를 반드시 완성(오버라이딩)해야 한다.
 *       만약 sound() 를 구현하지 않으면 컴파일 에러가 발생한다.
 *     - @Override 어노테이션 : 컴퓨터(컴파일러)에게 "이 메소드는 부모 클래스의 메소드를 재정의한 것이니, 이름이나 형태가
 *       틀리지 않았는지 검사해 줘!" 라고 알려 주는 안전장치다. (생략해도 동작하지만, 실수를 막기 위해 적어 주는 것이 좋다)
 *  4. 다형성 (Polymorphism) 과 업캐스팅 (Upcasting)
 *       Animal lion = new Lion();   lion.sound();
 *       Animal tiger = new Tiger();  tiger.sound();
 *     메인 메소드에서 가장 중요하게 봐야 할 부분이다. Lion lion = new Lion(); 이라고 하지 않고, 왜 앞쪽 타입을 Animal 로 적었을까?
 *     - 업캐스팅(Upcasting) : 자식 클래스의 객체(new Lion())를 부모 클래스 타입의 변수(Animal lion)에 담는 것을 말한다.
 *       "사자는 동물이다(Lion is an Animal)" 가 성립하기 때문에 가능한 문법이다.
 *     - 다형성(Polymorphism) : "다양한 형태를 가질 수 있는 성질" 을 뜻한다.
 *       · 코드 상으로는 똑같이 Animal 타입의 변수에 대고 .sound() 를 호출했다. (lion.sound(), tiger.sound())
 *       · 하지만 실행해 보면 변수에 실제로 담겨 있는 객체가 무엇인지(사자인지 호랑이인지)에 따라 전혀 다른 실행 결과가 나온다.
 *     - 이점 : 나중에 코끼리(Elephant), 강아지(Dog) 등 수백 마리의 동물이 추가되어도, Animal 이라는 하나의 공통된 타입으로
 *       묶어서 일괄적으로 관리하고 명령을 내릴 수 있어 프로그램 유지보수가 매우 편리해진다.
 *
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 AnimalAbstractTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Lion roars!
 *  Tiger growls!
 */
public class AnimalAbstractTest {
    public static void main(String[] args) {
        Animal lion = new Lion();
        lion.sound();

        Animal tiger = new Tiger();
        tiger.sound();
    }
}

abstract class Animal {
    public abstract void sound();
}

class Lion extends Animal {
    @Override
    public void sound() {
        System.out.println("Lion roars!");
    }
}

class Tiger extends Animal {
    @Override
    public void sound() {
        System.out.println("Tiger growls!");
    }
}
