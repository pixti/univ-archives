import java.util.Random;
import java.util.Scanner;

/**
 * [4강 과제] 반복문2 - 4번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class RockPaperScissorsFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int user, com;
        String answer = "y";

        for (; answer.equals("y"); ) {
            System.out.print("가위(1), 바위(2), 보(3) : ");
            user = sc.nextInt();
            com = random.nextInt(3) + 1;

            System.out.print("컴퓨터 : ");

            if (com == 1) {
                System.out.println("가위");
            } else if (com == 2) {
                System.out.println("바위");
            } else {
                System.out.println("보");
            }

            if (user == com) {
                System.out.println("비겼습니다.");
            } else if ((user == 1 && com == 3) || (user == 2 && com == 1) || (user == 3 && com == 2)) {
                System.out.println("이겼습니다.");
            } else {
                System.out.println("졌습니다.");
            }
            System.out.print("계속 하시겠습니까? (y or n) : ");
            answer = sc.next();
        }
        sc.close();
    }
}
