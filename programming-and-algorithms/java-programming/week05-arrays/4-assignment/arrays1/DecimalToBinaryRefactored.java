import java.util.Scanner;

/**
 * [5강 과제] 배열(1) - 3번 문제 (리팩터링 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class DecimalToBinaryRefactored {
    public static void main(String[] args) {
        // 표준 입력을 읽고 사용이 끝나면 자동으로 닫습니다.
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("10진수를 입력하세요: ");
            long number = scanner.nextLong();

            // 이 예제는 음이 아닌 정수의 2진수 변환을 지원합니다.
            if (number < 0) {
                System.out.println("0 이상의 정수를 입력하세요.");
                return;
            }

            // 0은 나눗셈 반복문에서 처리되지 않으므로 별도로 출력합니다.
            if (number == 0) {
                System.out.println("0");
                return;
            }

            int[] binaryDigits = new int[64];
            int digitCount = 0;

            // 나머지를 낮은 자리부터 배열에 저장합니다.
            while (number > 0) {
                binaryDigits[digitCount] = (int) (number % 2);
                number /= 2;
                digitCount++;
            }

            // 저장 순서를 뒤집어 높은 자리부터 출력합니다.
            for (int index = digitCount - 1; index >= 0; index--) {
                System.out.print(binaryDigits[index]);
            }
            System.out.println();
        }
    }
}
