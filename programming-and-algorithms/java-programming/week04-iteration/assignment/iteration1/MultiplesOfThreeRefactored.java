import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * [4강 과제] 반복문1 - 1번 문제 (리팩터링 버전)
 * ※ 반복 시 while 이나 do while 문만 사용하시오.
 *
 * MultiplesOfThree.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점
 *  - 매직 넘버 3 → 상수 MULTIPLE (private static final)
 *  - 입력 / 출력을 메소드로 분리 : readPositiveInteger(), printMultiplesOfThreeUpTo()
 *  - try-with-resources : try (Scanner sc = ...) { } 가 끝나면 sc.close() 가 자동 호출된다.
 *  - 잘못된 입력 처리
 *      · 정수가 아닌 입력 (예 : abc) → nextInt() 가 InputMismatchException 을 던진다.
 *        catch 에서 메시지를 출력하고 sc.next() 로 잘못된 토큰을 버린 뒤 다시 입력받는다.
 *        (sc.next() 를 빼면 같은 "abc" 를 계속 읽어서 무한 반복)
 *      · 0 이하 → 오류 메시지 출력 후 다시 입력받는다.
 *  - Integer (참조형) 를 반환 → null 로 "값 없음" 을 표현할 수 있다.
 *
 * ⚠ 과제 조건 위반 : printMultiplesOfThreeUpTo() 가 for 문을 사용한다.
 *   (반복문1 과제는 while / do-while 만 허용) 아래 주석에 while 버전을 함께 적었다.
 * ⚠ readPositiveInteger() 는 양수를 받을 때까지 while (true) 로 반복하므로 null 을 반환하는 경우가 없다.
 *   → main 의 if (inputNumber == null) 은 실행될 일이 없는 코드(dead code).
 *   Javadoc 의 "음수이거나 0인 경우에는 null을 반환" 도 실제 동작(재입력 요청)과 다르다.
 * ⚠ 문제는 "0 보다 작으면 오류" 인데, 이 버전은 0 도 오류로 처리한다. (원본은 0 이면 아무것도 출력 안 함)
 *   0 은 출력할 3 의 배수가 없으니 결과 차이는 오류 메시지뿐.
 *
 * 내 코드 실행 예
 *  정수를 입력하세요 : 19
 *  [3]
 *  [6]
 *  [9]
 *  [12]
 *  [15]
 *  [18]
 */
public class MultiplesOfThreeRefactored {

    // 3의 배수를 출력하는 한정된 범위 로직의 상수
    private static final int MULTIPLE = 3;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Integer inputNumber = readPositiveInteger(sc);
            if (inputNumber == null) {          // ⚠ dead code : null 이 반환되는 경로가 없다
                // 사용자가 입력을 포기했거나 비정상 입력으로 종료
                System.out.println("프로그램을 종료합니다.");
                return;
            }

            // 0은 3의 배수가 아니므로 출력 대상이 아닙니다(의도 명확화)
            //   (💡 수학적으로 0 은 3 의 배수다. "출력 대상이 아니다" 만 맞는 말)
            printMultiplesOfThreeUpTo(inputNumber);
        } // try-with-resources 구문으로 Scanner 자동 닫힘
    }

    /**
     * 사용자가 입력한 양의 정수 하나를 반환합니다.
     * 입력이 음수이거나 0인 경우에는 null을 반환하여 호출부에서 명확히 처리합니다.   ← ⚠ 실제로는 재입력
     *  입력이 정수가 아닐 경우 재입력을 요청하는 루프를 통해 안정적으로 입력받습니다.
     */
    private static Integer readPositiveInteger(Scanner sc) {
        while (true) {
            System.out.print("정수를 입력하세요 : ");

            try {
                int value = sc.nextInt();
                if (value > 0) {
                    return value;               // int → Integer 자동 변환 (오토박싱)
                } else {
                    // 0 또는 음수인 경우
                    System.out.println("오류: 양의 정수를 입력해야 합니다.");
                    // 계속해서 재입력 받음
                }
            } catch (InputMismatchException e) {
                // 정수가 아닌 입력이 들어온 경우 버퍼를 비우고 재입력 요청
                System.out.println("오류: 정수를 입력해야 합니다.");
                sc.next(); // 입력 버퍼 정리
            }
        }
    }

    /**
     * 3의 배수들 중 입력값 이하까지 출력합니다.
     * 예: 입력이 12면 [3], [6], [9], [12] 출력
     *
     * ⚠ 반복문1 과제 조건(while / do-while 만)에 맞추려면 :
     *     int i = MULTIPLE;
     *     while (i <= limit) {
     *         System.out.println("[" + i + "]");
     *         i += MULTIPLE;
     *     }
     */
    private static void printMultiplesOfThreeUpTo(int limit) {
        for (int i = MULTIPLE; i <= limit; i += MULTIPLE) {
            System.out.println("[" + i + "]");
        }
    }
}
