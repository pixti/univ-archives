/**
 * [11강 과제] 상속 (인터페이스, 다중 상속) - 1번 문제 (Playable 인터페이스)
 *
 * 문제
 *  인수를 사용하지 않고 void 를 반환하는 play() 메서드를 갖는 Playable 인터페이스를 생성하라. Playable 인터페이스를 구현하고
 *  각 스포츠를 플레이하기 위해 play() 메서드를 재정의하는 세 가지 클래스 Football, Volleyball 및 Basketball 클래스를 작성하라.
 *  main 은 다음과 같다.
 *
 *    // Main
 *    public class Main {
 *        public static void main(String[] args) {
 *            // Create instances of Playable objects for football, volleyball, and basketball
 *            Playable football = new Football();
 *            Playable volleyball = new Volleyball();
 *            Playable basketball = new Basketball();
 *
 *            // Call the "play" method on each Playable object to play different sports
 *            football.play();
 *            volleyball.play();
 *            basketball.play();
 *        }
 *    }
 *
 * 포인트
 *  - interface Playable { void play(); } : 인수 없음, 반환형 void
 *  - 세 클래스가 implements Playable 로 play() 를 각자 구현한다.
 *  - main 에서는 셋 다 Playable 타입 변수에 담는다. play() 를 부르면 실제 객체의 play() 가 실행된다. (동적 바인딩, 10-3)
 *
 * 💡 인터페이스의 play() 는 자동으로 public abstract 다. 그래서 구현 클래스의 play() 도 반드시 public 이어야 한다.
 * 💡 Playable[] games = { new Football(), new Volleyball(), new Basketball() }; 처럼 배열에 담고 for 문으로 돌려도 결과가 같다.
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 PlayableTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  Playing football
 *  Playing volleyball
 *  Playing basketball
 */
public class PlayableTest {
    public static void main(String[] args) {
        Playable football = new Football();
        Playable volleyball = new Volleyball();
        Playable basketball = new Basketball();

        football.play();
        volleyball.play();
        basketball.play();
    }
}

interface Playable {
    void play();
}

class Football implements Playable {
    @Override
    public void play() {
        System.out.println("Playing football");
    }
}

class Volleyball implements Playable {
    @Override
    public void play() {
        System.out.println("Playing volleyball");
    }
}

class Basketball implements Playable {
    @Override
    public void play() {
        System.out.println("Playing basketball");
    }
}
