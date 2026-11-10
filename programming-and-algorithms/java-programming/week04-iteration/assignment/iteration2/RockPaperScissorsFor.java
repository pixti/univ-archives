import java.util.Random;
import java.util.Scanner;

/**
 * [4강 과제] 반복문2 - 4번 문제
 * 📝 반복문2 과제는 for문으로 작성.
 *
 * 조건문 과제에서 가위 바위 보 게임을 반복 수행하는 프로그램을 작성하시오.
 * 한 번 끝나면 사용자에게 "계속 하시겠습니까? ('y' or 'n')" 라는 안내문을 내주고,
 * 'y' 이면 새 게임을 진행하고, 'n' 이면 프로그램을 종료토록 한다.
 *
 * 포인트
 *  - 반복문1(iteration1/RockPaperScissorsRepeat.java) 의 while (answer.equals("y")) 를
 *    for ( ; answer.equals("y"); ) 로 바꾼 것. 나머지는 같다.
 *  - 몇 판 할지 미리 정해져 있지 않으므로 초기식 / 증감식은 비워 두고 조건식만 쓴다.
 *    (퀴즈 2번 : "while문과 for문은 표현력이 같다. for ( ; n>=0 ; ) {} 로 써야한다")
 *  - 게임 횟수를 세고 싶다면 증감식을 활용할 수 있다.
 *      for (int round = 1; answer.equals("y"); round++) { System.out.println(round + "번째 게임"); ... }
 *
 * 💡 "Y" (대문자) 는 종료로 처리된다. 대소문자를 모두 받으려면 equalsIgnoreCase("y").
 *
 * 💡 리팩터링 버전 → RockPaperScissorsForRefactored.java
 *
 * 내 코드 실행 예
 *  가위(1), 바위(2), 보(3) : 1
 *  컴퓨터 : 가위
 *  비겼습니다.
 *  계속 하시겠습니까? (y or n) : y
 *  가위(1), 바위(2), 보(3) : 3
 *  컴퓨터 : 바위
 *  이겼습니다.
 *  계속 하시겠습니까? (y or n) : n
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
