import java.util.Random;
import java.util.Scanner;

/**
 * [4-1 반복문1] [실습] 숫자 맞히기 게임
 *
 * 1 ~ 100 사이의 무작위 숫자를 맞힐 때까지 반복한다.
 *
 * 포인트
 *  - (new Random()).nextInt(100) 은 0 ~ 99 → + 1 해서 1 ~ 100.
 *    (3주차 홀짝 맞히기에서 배운 방법)
 *  - 몇 번 만에 맞힐지 모름 = 반복 횟수가 정해지지 않은 경우 → while 이 어울린다.
 *  - 정답이면 cont = false → 다음 조건 검사에서 빠져나온다.
 *
 * 💡 4-2 에서 "게임을 계속할지" 를 묻는 바깥 반복문(do-while)을 추가한다
 *    → NumberGuessingRepeat.java
 *
 * 실행 예
 *  예측값 ?
 *  50
 *  정답보다 크다
 *  예측값 ?
 *  25
 *  정답보다 작다
 *  예측값 ?
 *  37
 *  정답!!!
 */
public class NumberGuessing {
    public static void main(String[] args) {
        int answer = (new Random()).nextInt(100) + 1;   // 1~100 무작위 숫자
        int guess;
        Scanner sc = new Scanner(System.in);
        boolean cont = true;
        while (cont) {  // 정답이 될 때 까지 무한 루프
            System.out.println("예측값 ? ");
            guess = sc.nextInt();
            if (guess > answer) System.out.println("정답보다 크다");
            else if (guess < answer) System.out.println("정답보다 작다");
            else {
                System.out.println("정답!!!");
                cont = false;
            }
        }
        sc.close();
    }
}
