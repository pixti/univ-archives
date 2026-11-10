import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * [4강 과제] 반복문2 - 1번 문제 (리팩터링 버전)
 * 📝 반복문2 과제는 for문으로 작성.
 *
 * MultiplesOfThreeFor.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점 (반복문1 리팩터링 버전과 비교)
 *  - 숫자뿐 아니라 안내 / 오류 문자열까지 상수로 분리 : PROMPT_INPUT, ERROR_NON_INTEGER, ERROR_NEGATIVE
 *    → 문구를 고칠 때 한 곳만 바꾸면 된다.
 *  - main 이 if (limit != null) 한 줄로 짧아졌다.
 *  - 입력 검사 방식은 같다 : 정수가 아니면 InputMismatchException → sc.next() 로 버퍼 정리 후 재입력.
 *
 * ⚠ readPositiveInteger() 가 while (true) 를 사용한다. (반복문2 과제는 for 문으로 작성)
 *   for 로 바꾸려면 for ( ; ; ) { ... } 로 쓰면 된다. (퀴즈 2번 "while 과 for 는 표현력이 같다")
 * ⚠ while (true) 를 벗어나는 길은 return value; 뿐 → null 을 반환하는 경우가 없다.
 *   Javadoc 의 "입력이 포기되면 null을 반환" 과 main 의 null 검사는 실제로 쓰이지 않는다.
 * ⚠ 0 을 넣어도 "오류: 음수는 허용되지 않습니다." 가 출력된다. (0 은 음수가 아니므로 메시지가 부정확)
 *
 * 내 코드 실행 예
 *  정수를 입력하세요 : 20
 *  [3]
 *  [6]
 *  [9]
 *  [12]
 *  [15]
 *  [18]
 */
public class MultiplesOfThreeForRefactored {

    // 3의 배수 출력의 공통 상수
    private static final int MULTIPLE_OF = 3;
    private static final String PROMPT_INPUT = "정수를 입력하세요 : ";
    private static final String ERROR_NON_INTEGER = "오류: 정수를 입력해야 합니다.";
    private static final String ERROR_NEGATIVE = "오류: 음수는 허용되지 않습니다.";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer limit = readPositiveInteger(sc);
            if (limit != null) {                // ⚠ 항상 참 (null 이 반환되지 않음)
                printMultiplesOfThreeUpTo(limit);
            }
        }
    }

    /**
     * 양의 정수 하나를 입력받아 반환합니다.
     * 입력이 잘못되면 오류 메시지를 출력하고 재입력합니다.
     * 사용자가 정상 입력을 할 때까지 루프합니다.
     * 입력이 포기되면 null을 반환합니다.        ← ⚠ null 을 반환하는 코드가 없다
     */
    private static Integer readPositiveInteger(Scanner sc) {
        while (true) {                          // ⚠ 반복문2 조건 : for ( ; ; ) 로 쓰면 for 문
            System.out.print(PROMPT_INPUT);
            try {
                int value = sc.nextInt();
                if (value > 0) {
                    return value;
                } else {
                    System.out.println(ERROR_NEGATIVE);   // ⚠ 0 일 때도 이 메시지
                }
            } catch (InputMismatchException e) {
                System.out.println(ERROR_NON_INTEGER);
                sc.next(); // 버퍼 정리
            }
        }
    }

    /**
     * 3의 배수들 중 입력값 이하까지 출력합니다.
     * 출력 형식은 "[" + i + "]"를 유지합니다.
     */
    private static void printMultiplesOfThreeUpTo(int limit) {
        for (int i = MULTIPLE_OF; i <= limit; i += MULTIPLE_OF) {
            System.out.println("[" + i + "]");
        }
    }
}
