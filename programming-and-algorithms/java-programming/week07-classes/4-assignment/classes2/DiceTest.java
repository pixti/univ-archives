/**
 * [7강 과제] 클래스(2) - 1번 문제 (Dice 클래스 - 주사위 굴리기)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class DiceTest {
    public static void main(String[] args) {
        Dice D1 = new Dice();
        for (int i = 0; i < 10; i++) {
            D1.roll();
            System.out.println("주사위의 숫자는 " + D1.getFace() + "입니다.");
        }
    }
}

class Dice {
    private int face;

    public void roll() {
        face = (int) (Math.random() * 6) + 1;     // 1 ~ 6
    }

    public int getFace() {
        return face;
    }
}
