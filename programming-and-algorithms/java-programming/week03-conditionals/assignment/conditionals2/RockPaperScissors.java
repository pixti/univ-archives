import java.util.Scanner;

/**
 * [3강 과제] 조건문2 - 1번 문제
 * 컴퓨터와 가위, 바위, 보 게임을 하는 프로그램을 작성하라.
 * 컴퓨터는 사용자에게 알리지 않고 가위, 바위, 보 중에서 임의로 하나를 선택하는데,
 * 0 ~ 2 사이의 랜덤 정수로 구현하며, 0 이면 가위, 1 이면 바위, 2 면 보로 취급한다.
 *
 * 포인트
 *  - 잘못된 입력(0 ~ 2 이외)을 먼저 걸러서 return; 으로 종료한다.
 *  - 승패 판정은 3가지로 나눈다.
 *      1. 같으면 무승부
 *      2. 사용자가 이기는 3가지 경우를 || 로 묶어서 검사
 *      3. 나머지는 모두 컴퓨터 승리 → else
 *
 * 💡 (int) (Math.random() * 3)
 *    - Math.random() 은 0.0 이상 1.0 미만의 double → * 3 하면 0.0 이상 3.0 미만
 *    - (int) 로 소수점을 버리면 0, 1, 2 중 하나
 *    - 괄호가 중요하다! (int) Math.random() * 3 으로 쓰면 형변환이 먼저 되어
 *      (int) 0.xxx = 0 → 0 * 3 = 0. 컴퓨터가 항상 가위만 낸다.
 *    - java.util.Random 을 쓰면 new Random().nextInt(3) 으로 같은 결과 (examples/OddEven.java 참고)
 * 💡 이기는 조건을 수식 하나로 쓸 수도 있다 : (userChoice - computerChoice + 3) % 3 == 1 이면 사용자 승리.
 *    (바위(1) - 가위(0) = 1, 보(2) - 바위(1) = 1, 가위(0) - 보(2) + 3 = 1)
 *
 * 문제의 실행 예
 *  가위 (0),바위(1),보(2) 를 선택하세요 : 0
 *  컴퓨터는 보를 내서 사용자가 이겼습니다.!!
 *  user : 0, com : 2
 *
 * 내 코드 실행 예
 *  가위(0), 바위(1), 보(2)를 선택 : 1
 *  컴퓨터는 보를 내서
 *  컴퓨터가 이겼습니다.
 *  user : 1 com : 2
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
