import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * [4강 과제] 반복문2 - 1번 문제 (리팩터링 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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

    // 양의 정수 하나를 입력받아 반환합니다.
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
