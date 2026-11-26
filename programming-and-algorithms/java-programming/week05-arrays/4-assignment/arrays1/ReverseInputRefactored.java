import java.util.Scanner;

/**
 * [5강 과제] 배열(1) - 1번 문제 (리팩터링 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ReverseInputRefactored {
    public static void main(String[] args) {
        // 표준 입력을 읽기 위한 Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            int[] numbers = new int[10];

            System.out.println("10개의 정수 입력");
            // 배열의 길이를 기준으로 입력을 읽습니다.
            for (int index = 0; index < numbers.length; index++) {
                numbers[index] = scanner.nextInt();
            }

            System.out.println("역순 출력:");
            // 마지막 원소부터 첫 번째 원소까지 출력합니다.
            for (int index = numbers.length - 1; index >= 0; index--) {
                System.out.print(numbers[index] + " ");
            }
            System.out.println();
        }
    }
}
