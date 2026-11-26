import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * [4강 과제] 반복문1 - 1번 문제 (리팩터링 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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

    // 사용자가 입력한 양의 정수 하나를 반환합니다.
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

    // 3의 배수들 중 입력값 이하까지 출력합니다.
    private static void printMultiplesOfThreeUpTo(int limit) {
        for (int i = MULTIPLE; i <= limit; i += MULTIPLE) {
            System.out.println("[" + i + "]");
        }
    }
}
