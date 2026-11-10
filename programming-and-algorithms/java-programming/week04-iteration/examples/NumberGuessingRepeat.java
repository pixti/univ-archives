import java.util.Random;
import java.util.Scanner;

/**
 * [4-2 반복문2] [실습] 숫자 맞히기 게임 반복하기
 *
 * 앞서 실습한 숫자 맞히기 게임(NumberGuessing.java)에서 더 게임을 진행할지 물어보는 기능 추가.
 *
 * 구조 : 반복문 안의 반복문
 *  - 바깥 do-while : "게임 한 판" 을 반복   (programCont 로 제어)
 *  - 안쪽 while    : "한 판 안에서 예측" 을 반복 (cont 로 제어)
 *
 * 포인트
 *  - 새 판을 시작할 때마다 cont = true; 로 "다시 초기화" 해야 한다.
 *    안 하면 직전 판에서 false 가 된 cont 때문에 안쪽 while 에 들어가지 못한다.
 *    (퀴즈 3번 Σ·Π 에서 안쪽 누적 변수를 매번 초기화하는 것과 같은 이야기)
 *  - 게임은 최소 한 판은 하므로 바깥은 do-while.
 *
 * ⚠ 슬라이드는 answer 를 바깥 do 앞에서 "한 번만" 만든다 → 두 번째 판부터 정답이 계속 같다.
 *   새 판마다 새 숫자가 나오도록 answer 생성을 do 블록 안으로 옮겼다.
 * 💡 실행 화면 캡처에서는 바깥 변수 이름이 gameCont 로 되어 있다 (슬라이드 본문은 programCont).
 *
 * 실행 예
 *  게임을 시작합니다.
 *  예측값 ?
 *  7
 *  정답보다 작습니다.
 *  예측값 ?
 *  9
 *  정답입니다!!!
 *  계속 하시겠습니까 ? ('y' or 'n')
 *  y
 *  게임을 시작합니다.
 *  예측값 ?
 *  ...
 *  계속 하시겠습니까 ? ('y' or 'n')
 *  n
 *  게임을 종료합니다.
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
