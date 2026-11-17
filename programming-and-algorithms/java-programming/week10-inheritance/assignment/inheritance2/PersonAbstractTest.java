/**
 * [10강 과제] 상속 (추상 클래스) - 1번 문제 (abstract Person / Athlete / LazyPerson)
 *
 * 문제
 *  추상 메서드 eat() 및 exercise() 를 갖는 추상 클래스 Person 을 작성하라.
 *  Person 클래스를 상속하고 각 사람이 어떻게 먹고 운동하는지 설명하는 각각의 메서드를 구현하는
 *  하위 클래스 Athlete 및 LazyPerson 클래스를 작성하라. main 은 다음과 같다.
 *
 *    //Main
 *    public class Main {
 *        public static void main(String[] args) {
 *            Person athlete = new Athlete();
 *            Person lazyPerson = new LazyPerson();
 *            athlete.eat();
 *            athlete.exercise();
 *            lazyPerson.eat();
 *            lazyPerson.exercise();
 *        }
 *    }
 *
 * 포인트
 *  - abstract class Person 에 몸체 없는 추상 메서드 eat(), exercise() 를 선언한다.
 *  - Athlete, LazyPerson 은 두 추상 메서드를 모두 구현(재정의)해야 일반 클래스가 되어 객체를 만들 수 있다.
 *  - main 에서는 Person 타입 변수에 자식 객체를 담고(업캐스팅), 실제 객체의 메서드가 실행된다(동적 바인딩).
 *
 * 💡 출력 문구의 "Couch Potato" 는 LazyPerson(소파에서 TV 만 보는 사람)을 뜻한다. 클래스 이름과 출력 문구가 다르지만
 *    문제의 실행 결과 그대로 썼다.
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 PersonAbstractTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Athlete: Include foods full of calcium, iron, potassium, and fiber.
 *  Athlete: Training allows the body to gradually build up strength and endurance, improve skill levels and build motivation, ambition and confidence.
 *  Couch Potato: Eating while watching TV also prolongs the time period that we're eating.
 *  Couch Potato: Rarely exercising or being physically active.
 */
public class PersonAbstractTest {
    public static void main(String[] args) {
        Person athlete = new Athlete();
        Person lazyPerson = new LazyPerson();
        athlete.eat();
        athlete.exercise();
        lazyPerson.eat();
        lazyPerson.exercise();
    }
}

abstract class Person {
    public abstract void eat();
    public abstract void exercise();
}

class Athlete extends Person {
    @Override
    public void eat() {
        System.out.println("Athlete: Include foods full of calcium, iron, potassium, and fiber.");
    }

    @Override
    public void exercise() {
        System.out.println("Athlete: Training allows the body to gradually build up strength and endurance, improve skill levels and build motivation, ambition and confidence.");
    }
}

class LazyPerson extends Person {
    @Override
    public void eat() {
        System.out.println("Couch Potato: Eating while watching TV also prolongs the time period that we're eating.");
    }

    @Override
    public void exercise() {
        System.out.println("Couch Potato: Rarely exercising or being physically active.");
    }
}
