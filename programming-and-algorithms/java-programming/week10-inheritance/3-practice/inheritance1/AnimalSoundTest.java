/**
 * [10강 실습] 상속 - 1번 문제 (Animal / Cat : makeSound 재정의)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class AnimalSoundTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();
        animal.makeSound();
        cat.makeSound();
    }
}

class Animal {
    public void makeSound() {
        System.out.println("The animal makes a sound.");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The cat quarrels.");
    }
}
