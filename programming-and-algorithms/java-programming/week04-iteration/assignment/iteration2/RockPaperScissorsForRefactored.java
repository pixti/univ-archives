import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * [4강 과제] 반복문2 - 4번 문제 (리팩터링 버전)
 * 📝 반복문2 과제는 for문으로 작성.
 *
 * RockPaperScissorsFor.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점 (반복문1 리팩터링 버전과 비교)
 *  - 상수 이름 SHAPE_SCISSOR / SHAPE_ROCK / SHAPE_PAPER
 *  - Random 을 static final 필드 RANDOM 으로 한 번만 생성해 재사용.
 *  - printMove() (직접 출력) → moveToString() (문자열 반환)
 *    → 출력은 호출부가 담당 : System.out.println("컴퓨터 : " + moveToString(...));
 *      값을 돌려주는 메소드가 다른 곳에서도 쓰기 쉽다.
 *  - main 의 반복을 for ( ; keepPlaying; ) 로 작성.
 *
 * ⚠ promptUserChoice() 와 shouldContinue() 의 재입력 반복은 while (true) 다. (반복문2 과제는 for 문)
 *   for ( ; ; ) 로 바꾸면 조건을 지킨다.
 * ⚠ OUTPUT_FORMAT ("%d : %d : %d") 은 사용되지 않는다. (Eclipse 노란 경고)
 *   피타고라스 문제의 상수가 잘못 섞여 들어온 것으로 보인다.
 *
 * 내 코드 실행 예
 *  가위(1), 바위(2), 보(3) : 2
 *  컴퓨터 : 가위
 *  이겼습니다.
 *  계속 하시겠습니까? (y or n) : n
 */
public class RockPaperScissorsForRefactored {

    // 손 모양 상수
    private static final int SHAPE_SCISSOR = 1;
    private static final int SHAPE_ROCK    = 2;
    private static final int SHAPE_PAPER   = 3;

    // 출력 포맷 상수
    private static final String OUTPUT_FORMAT = "%d : %d : %d";    // ⚠ 사용되지 않음

    // 게임 종료 여부 상수
    private static final String CONTINUE_YES = "y";
    private static final String CONTINUE_NO  = "n";

    // 난수 생성기
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean keepPlaying = true;

            // 규칙상 for 루프를 사용하되, 종료 제어 변수를 루프 내부에서 갱신
            for (; keepPlaying; ) {
                int userChoice = promptUserChoice(sc);
                int computerChoice = generateComputerChoice();

                System.out.println("컴퓨터 : " + moveToString(computerChoice));
                printResult(userChoice, computerChoice);

                keepPlaying = shouldContinue(sc);
            }
        }
    }

    // 사용자의 입력이 1/2/3 중 하나인지 검사하고 반환
    private static int promptUserChoice(Scanner sc) {
        while (true) {                          // ⚠ 반복문2 조건 : for ( ; ; )
            System.out.print("가위(1), 바위(2), 보(3) : ");
            try {
                int value = sc.nextInt();
                if (isValidMove(value)) {
                    return value;
                } else {
                    System.out.println("오류: 1, 2, 또는 3 중 하나를 입력해야 합니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("오류: 정수를 입력해야 합니다.");
                sc.next(); // 입력 버퍼 정리
            }
        }
    }

    // 컴퓨터의 선택: 1~3 사이의 난수
    private static int generateComputerChoice() {
        return RANDOM.nextInt(3) + 1;
    }

    // 손 모양을 문자열로 변환
    private static String moveToString(int move) {
        switch (move) {
            case SHAPE_SCISSOR: return "가위";
            case SHAPE_ROCK:    return "바위";
            case SHAPE_PAPER:   return "보";
            default:            return "알 수 없음";
        }
    }

    // 승패 판단 및 출력
    private static void printResult(int user, int computer) {
        if (user == computer) {
            System.out.println("비겼습니다.");
        } else if ((user == SHAPE_SCISSOR && computer == SHAPE_PAPER) ||
                   (user == SHAPE_ROCK && computer == SHAPE_SCISSOR) ||
                   (user == SHAPE_PAPER && computer == SHAPE_ROCK)) {
            System.out.println("이겼습니다.");
        } else {
            System.out.println("졌습니다.");
        }
    }

    // 입력된 포맷이 1/2/3인지 검사
    private static boolean isValidMove(int move) {
        return move == SHAPE_SCISSOR || move == SHAPE_ROCK || move == SHAPE_PAPER;
    }

    // 계속할지 여부를 묻고, 'y' 또는 'n'으로 응답받아 true/false 반환
    private static boolean shouldContinue(Scanner sc) {
        while (true) {                          // ⚠ 반복문2 조건 : for ( ; ; )
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
