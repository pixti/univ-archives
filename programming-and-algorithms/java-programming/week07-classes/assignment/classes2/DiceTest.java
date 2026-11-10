/**
 * [7강 과제] 클래스(2) - 1번 문제 (Dice 클래스 - 주사위 굴리기)
 *
 * 문제
 *  주사위의 눈(face)을 필드로 가지는 Dice 클래스를 작성하시오.
 *   - roll()    : 1~6 사이의 숫자를 무작위로 정해 face 에 저장
 *   - getFace() : face 반환
 *  main 에서 주사위를 10번 굴려 나온 숫자를 출력한다.
 *
 * 포인트
 *  - face 는 private → roll() 로만 바뀌고 getFace() 로만 읽을 수 있다.
 *
 * 📝 필기 (AI 설명) Math.random() 으로 1~6 만들기
 *      Math.random()                  0.0 <= x < 1.0      (1.0 은 나오지 않음)
 *      Math.random() * 6              0.0 <= x < 6.0
 *      (int)(Math.random() * 6)       0, 1, 2, 3, 4, 5    (소수점 버림)
 *      (int)(Math.random() * 6) + 1   1, 2, 3, 4, 5, 6
 *    → 일반화 : (int)(Math.random() * 개수) + 시작값
 *
 * ⚠ (int)Math.random() * 6 + 1 처럼 괄호를 빼면 (int) 가 Math.random() 에만 적용되어 항상 0 → 결과가 항상 1
 *
 * 💡 main 의 참조 변수 이름 D1 은 문제 그대로 두었다. (자바 관례로는 소문자로 시작하는 d1 이 좋다)
 *
 * 실행 예 (무작위라 매번 다름)
 *  주사위의 숫자는 3입니다.
 *  주사위의 숫자는 6입니다.
 *  주사위의 숫자는 1입니다.
 *  ... (총 10줄)
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
