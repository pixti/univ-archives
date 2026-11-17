/**
 * [10강 과제] 상속 - 3번 문제 (Animal / Cheetah : move 재정의)
 *
 * 문제
 *  move() 라는 메소드를 갖는 Animal 이라는 클래스를 작성하라. move() 메서드를 재정의하는 Cheetah 라는 하위 클래스도 정의하라.
 *  main 은 다음과 같다.
 *
 *    // Main class
 *    public class Main {
 *        public static void main(String[] args) {
 *            Animal animal = new Animal();
 *            animal.move();
 *            Cheetah cheetah = new Cheetah();
 *            cheetah.move();
 *        }
 *    }
 *
 * 포인트
 *  - Cheetah 는 Animal 을 상속(extends)하고 move() 를 재정의한다.
 *
 * 💡 Animal animal = new Cheetah(); 로 바꿔도 animal.move() 는 "This cheetah is running!" 을 출력한다.
 *    실제 객체가 Cheetah 이기 때문이다. (동적 바인딩, 10-3)
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 CheetahTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Animal moves
 *  This cheetah is running!
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
