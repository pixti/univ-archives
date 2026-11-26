import java.util.Random;
import java.util.Scanner;

/**
 * [4-2 반복문2] [실습] 숫자 맞히기 게임 반복하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class NumberGuessingRepeat {
    public static void main(String[] args) {
        Random rnd = new Random();
        int answer, guess;
        boolean cont;
        char programCont;
        Scanner sc = new Scanner(System.in);

        do {    // 바깥 반복문 추가, 제어하기 위해 programCont 변수 선언하여 사용
            answer = rnd.nextInt(100) + 1;  // ⚠ 수정 : 판마다 새 정답
            cont = true;                    // 판마다 다시 초기화
            System.out.println("게임을 시작합니다.");
            while (cont) {
                System.out.println("예측값 ? ");
                guess = sc.nextInt();
                if (guess > answer) System.out.println("정답보다 큽니다.");
                else if (guess < answer) System.out.println("정답보다 작습니다.");
                else {
                    System.out.println("정답입니다!!!");
                    cont = false;
                }
            }
            System.out.println("계속 하시겠습니까 ? ('y' or 'n') ");
            programCont = sc.next().charAt(0);
        } while (programCont == 'y');
        System.out.println("게임을 종료합니다.");
        sc.close();
    }
}
