import java.util.Scanner;

/**
 * [3강 과제] 조건문2 - 1번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사용자에게 가위, 바위, 보 중 하나를 입력받는다.
        System.out.print("가위(0), 바위(1), 보(2)를 선택 : ");
        int userChoice = sc.nextInt();

        // 사용자가 0, 1, 2 이외의 값을 입력했는지 확인한다.
        if (userChoice < 0 || userChoice > 2) {
            System.out.println("잘못된 입력입니다.");
            sc.close();
            return;
        }

        // 0 ~ 2 중 하나를 랜덤으로 선택한다.
        // 0 = 가위, 1 = 바위, 2 = 보
        int computerChoice = (int) (Math.random() * 3);

        // 컴퓨터가 무엇을 선택했는지 출력한다.
        if (computerChoice == 0) {
            System.out.println("컴퓨터는 가위를 내서");
        }
        else if (computerChoice == 1) {
            System.out.println("컴퓨터는 바위를 내서");
        }
        else {
            System.out.println("컴퓨터는 보를 내서");
        }

        // 사용자와 컴퓨터가 같은 것을 냈다면 무승부이다.
        if (userChoice == computerChoice) {
            System.out.println("사용자가 비겼습니다.");
        }
        // 사용자가 이기는 세 가지 경우
        else if ((userChoice == 0 && computerChoice == 2) ||   // 가위 vs 보
                 (userChoice == 1 && computerChoice == 0) ||   // 바위 vs 가위
                 (userChoice == 2 && computerChoice == 1)) {   // 보 vs 바위
            System.out.println("사용자가 이겼습니다.");
        }
        // 무승부도 아니고 사용자가 이긴 것도 아니라면 컴퓨터의 승리이다.
        else {
            System.out.println("컴퓨터가 이겼습니다.");
        }

        // 사용자가 선택한 값과 컴퓨터가 선택한 값을 확인한다.
        System.out.println("user : " + userChoice + " com : " + computerChoice);

        sc.close();
    }
}
