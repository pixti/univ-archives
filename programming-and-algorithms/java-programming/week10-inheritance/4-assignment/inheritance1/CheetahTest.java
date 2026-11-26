/**
 * [10강 과제] 상속 - 3번 문제 (Animal / Cheetah : move 재정의)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class CheetahTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.move();

        Cheetah cheetah = new Cheetah();
        cheetah.move();
    }
}

class Animal {
    public void move() {
        System.out.println("Animal moves");
    }
}

class Cheetah extends Animal {
    @Override
    public void move() {
        System.out.println("This cheetah is running!");
    }
}
