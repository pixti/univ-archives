import java.util.Random;
import java.util.Scanner;

/**
 * [4강 과제] 반복문1 - 4번 문제
 * ※ 반복 시 while 이나 do while 문만 사용하시오.
 *
 * 조건문 과제에서 가위 바위 보 게임을 반복 수행하는 프로그램을 작성하시오.
 * 한 번 끝나면 사용자에게 "계속 하시겠습니까? ('y' or 'n')" 라는 안내문을 내주고,
 * 'y' 이면 새 게임을 진행하고, 'n' 이면 프로그램을 종료토록 한다.
 *
 * 포인트
 *  - 3주차 조건문 과제(week03-conditionals/assignment/conditionals2/RockPaperScissors.java) 를
 *    while 로 감싼 것.
 *  - answer 를 "y" 로 초기화 → 첫 판은 무조건 실행된다.
 *    (while 은 조건을 먼저 검사하므로 초기값이 없으면 컴파일 에러, "n" 이면 한 판도 안 함)
 *    💡 "무조건 1번 실행" 이니 do-while 이 더 어울리는 문제. (4-2 cont 초기화 비교 표)
 *  - 문자열 비교는 == 가 아니라 equals(). (== 는 같은 객체인지 비교)
 *  - random.nextInt(3) 은 0, 1, 2 중 하나 → + 1 해서 1, 2, 3.
 *  - 승리 조건 : 가위(1) > 보(3), 바위(2) > 가위(1), 보(3) > 바위(2)
 *
 * 💡 "Y" (대문자) 를 넣으면 equals("y") 가 거짓이라 종료된다.
 *    대소문자를 모두 받으려면 answer.equalsIgnoreCase("y").
 * 💡 1 ~ 3 이 아닌 수를 넣어도 검사하지 않는다. (예 : 5 → 비기지도 이기지도 않으니 "졌습니다.")
 *    리팩터링 버전에서 isValidMove() 로 검사한다.
 *
 * 💡 리팩터링 버전 → RockPaperScissorsRepeatRefactored.java
 *
 * 내 코드 실행 예
 *  가위(1), 바위(2), 보(3) : 3
 *  컴퓨터 : 보
 *  비겼습니다.
 *  계속 하시겠습니까? (y or n) : n
 */
public class RockPaperScissorsRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int user, com;
        String answer = "y";

        while (answer.equals("y")) {
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
