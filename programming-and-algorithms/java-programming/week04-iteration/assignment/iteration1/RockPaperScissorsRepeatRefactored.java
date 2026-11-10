import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * [4강 과제] 반복문1 - 4번 문제 (리팩터링 버전)
 * ※ 반복 시 while 이나 do while 문만 사용하시오.
 *
 * RockPaperScissorsRepeat.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점
 *  - 1, 2, 3 → 상수 SCISSOR, ROCK, PAPER  /  "y", "n" → CONTINUE_YES, CONTINUE_NO
 *  - 역할별 메소드 분리
 *      promptUserChoice()        : 사용자 입력 (잘못된 값이면 재입력)
 *      generateComputerChoice()  : 컴퓨터 선택 (난수)
 *      printMove()               : 숫자 → 가위/바위/보 출력 (switch)
 *      printResult()             : 승패 판정
 *      shouldContinue()          : 계속 여부 (y/n 이 아니면 재입력)
 *  - main 의 반복 조건이 boolean 변수 continuePlaying → "계속할지" 가 이름에 드러난다.
 *  - sc.next().trim().toLowerCase() : 앞뒤 공백 제거 + 소문자 변환 → "Y" 도 계속으로 처리.
 *  - "y" 를 상수 쪽에 두고 CONTINUE_YES.equals(answer) 로 비교
 *    → answer 가 null 이어도 NullPointerException 이 나지 않는 습관적인 작성법.
 *  - Random 대신 Math.random() 사용 : 0.0 이상 1.0 미만 실수 → × 3 → 0.0 ~ 2.999… → (int) 로 0 ~ 2 → + 1.
 *
 * ⚠ 캡처에서 isValidMove() 부분(65 ~ 72 행)이 잘려 있어서, 반복문2 리팩터링 버전과 같은 코드로 채웠다.
 * ⚠ "컴퓨팅 엔트로피를 위한 난수 생성기" 주석은 남아 있지만 Random 필드가 없다.
 *   (Math.random() 으로 바꾸면서 주석만 남은 것. 반복문2 버전에는 RANDOM 필드가 있다)
 * 💡 반복은 모두 while → 반복문1 과제 조건은 지켰다.
 *
 * 내 코드 실행 예
 *  가위(1), 바위(2), 보(3) : 2
 *  컴퓨터 : 보
 *  졌습니다.
 *  계속 하시겠습니까? (y or n) : n
 */
public class RockPaperScissorsRepeatRefactored {

    // 가위/바위/보를 나타내는 상수
    private static final int SCISSOR = 1;
    private static final int ROCK    = 2;
    private static final int PAPER   = 3;

    // 게임 종료 여부의 공통 상수
    private static final String CONTINUE_YES = "y";
    private static final String CONTINUE_NO  = "n";

    // 컴퓨팅 엔트로피를 위한 난수 생성기
    // (필요 시 Random 대신 SecureRandom으로 바꿀 수 있음)       ← ⚠ 해당 필드 없음 (Math.random() 사용)
    // 의도: 사용자의 재시작 여부에 따라 게임 루프를 반복
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean continuePlaying = true;

            while (continuePlaying) {
                int userChoice = promptUserChoice(sc);
                int computerChoice = generateComputerChoice();

                System.out.print("컴퓨터 : ");
                printMove(computerChoice);

                printResult(userChoice, computerChoice);

                continuePlaying = shouldContinue(sc);
            }
        }
    }

    /**
     * 사용자 입력을 받아 가위(1)/바위(2)/보(3) 중 하나를 반환합니다.
     * 입력이 잘못되면 재입력을 요청합니다.
     */
    private static int promptUserChoice(Scanner sc) {
        while (true) {
            System.out.print("가위(1), 바위(2), 보(3) : ");
            try {
                int choice = sc.nextInt();
                if (isValidMove(choice)) {
                    return choice;
                } else {
                    System.out.println("오류: 1, 2, 또는 3 중 하나를 입력해야 합니다.");
                }
            } catch (InputMismatchException e) {
                // 잘못된 타입의 입력 처리
                System.out.println("오류: 정수를 입력해야 합니다.");
                sc.next(); // 입력 버퍼 정리
            }
        }
    }

    /**
     * 컴퓨터의 가위/바위/보 선택을 1~3 사이의 난수로 생성합니다.
     */
    private static int generateComputerChoice() {
        // 1~3 중 임의의 정수 반환
        return (int) (Math.random() * 3) + 1;
    }

    /**
     * 입력된 값이 가위/바위/보(1/2/3) 중 하나인지 검사합니다.
     * (⚠ 캡처에서 잘린 부분 - 반복문2 리팩터링 버전의 isValidMove 와 같은 코드로 채움)
     */
    private static boolean isValidMove(int move) {
        return move == SCISSOR || move == ROCK || move == PAPER;
    }

    /**
     * 플레이어의 선택에 따라 컴퓨터의 선택을 출력합니다.
     */
    private static void printMove(int move) {
        switch (move) {
            case SCISSOR:
                System.out.println("가위");
                break;
            case ROCK:
                System.out.println("바위");
                break;
            case PAPER:
                System.out.println("보");
                break;
            default:
                // 이 경로는 이론상 호출되지 않지만 안전하게 처리
                System.out.println("알 수 없음");
        }
    }

    /**
     * 가위바위보의 승패를 판단하고 결과를 출력합니다.
     */
    private static void printResult(int user, int computer) {
        if (user == computer) {
            System.out.println("비겼습니다.");
        } else if ((user == SCISSOR && computer == PAPER) ||
                   (user == ROCK && computer == SCISSOR) ||
                   (user == PAPER && computer == ROCK)) {
            System.out.println("이겼습니다.");
        } else {
            System.out.println("졌습니다.");
        }
    }

    /**
     * 사용자의 의사에 따라 게임을 계속할지 결정합니다.
     * 입력이 아닌 다른 문자나 공백이 들어오면 재입력을 요청합니다.
     */
    private static boolean shouldContinue(Scanner sc) {
        while (true) {
            System.out.print("계속 하시겠습니까? (y or n) : ");
            String answer = sc.next().trim().toLowerCase();
            if (CONTINUE_YES.equals(answer)) {
                return true;
            } else if (CONTINUE_NO.equals(answer)) {
                return false;
            } else {
                System.out.println("오류: 'y' 또는 'n'으로 답해 주세요.");
            }
        }
    }
}
