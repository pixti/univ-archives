/**
 * [10강 실습] 상속 (추상 클래스) - 4번 문제 (abstract Bird / Eagle / Hawk)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
