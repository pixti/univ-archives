/**
 * [10강 실습] 상속 (추상 클래스) - 1번 문제 (abstract Animal / Lion / Tiger)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
