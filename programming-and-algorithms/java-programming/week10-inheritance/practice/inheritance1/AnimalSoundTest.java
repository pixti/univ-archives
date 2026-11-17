/**
 * [10강 실습] 상속 - 1번 문제 (Animal / Cat : makeSound 재정의)
 *
 * 문제
 *  makeSound() 라는 메소드를 갖는 Animal 이라는 클래스를 정의하라. 이 메소드는 "The animal makes a sound." 를 출력한다.
 *  또한 makeSound() 메서드를 재정의한 Cat 이라는 하위 클래스도 정의하라. Cat 클래스의 makeSound() 는 "The cat quarrels." 을 출력한다.
 *
 *    // Main.java
 *    public class Main {
 *        public static void main(String[] args) {
 *            Animal animal = new Animal();
 *            Cat cat = new Cat();
 *            animal.makeSound();
 *            cat.makeSound();
 *        }
 *    }
 *
 * 포인트
 *  - class Cat extends Animal : Animal 을 상속
 *  - 부모와 똑같은 형태(이름, 매개변수, 반환형)의 makeSound() 를 다시 정의하면 재정의(overriding)
 *  - animal.makeSound() 는 Animal 의 것, cat.makeSound() 는 Cat 이 재정의한 것이 실행된다.
 *
 * 💡 풀이 코드가 남아 있지 않아 문제의 main 과 실행 결과에 맞게 작성한 참고 답안이다.
 * 💡 @Override 는 없어도 동작은 같지만, 메소드 이름을 makesound 처럼 잘못 쓰면 컴파일러가 오류로 알려 준다.
 * 💡 원래 이클립스에서 Main 클래스로 작성하는 문제. 문제에 맞게 AnimalSoundTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  The animal makes a sound.
 *  The cat quarrels.
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
