import java.util.Random;
import java.util.Scanner;

/**
 * [4-1 반복문1] [실습] 숫자 맞히기 게임
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
