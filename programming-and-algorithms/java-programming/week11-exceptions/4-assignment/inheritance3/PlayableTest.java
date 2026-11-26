/**
 * [11강 과제] 상속 (인터페이스, 다중 상속) - 1번 문제 (Playable 인터페이스)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
