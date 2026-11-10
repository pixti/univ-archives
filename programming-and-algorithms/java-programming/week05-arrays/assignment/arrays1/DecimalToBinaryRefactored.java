import java.util.Scanner;

/**
 * [5강 과제] 배열(1) - 3번 문제 (리팩터링 버전)
 *
 * DecimalToBinary.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점
 *  - try-with-resources 로 Scanner 자동 닫기
 *  - 음수 입력 처리 : "0 이상의 정수를 입력하세요." 후 종료
 *  - 0 입력 처리 : 나눗셈 반복을 한 번도 돌지 않으므로 "0" 을 따로 출력
 *    → 원래 코드의 ⚠ 두 가지(0, 음수 입력 시 아무것도 안 나옴)를 고쳤다.
 *  - 변수 이름 num, binary, index → number, binaryDigits, digitCount
 *    index 대신 digitCount : "몇 자리인지" 라는 뜻이 드러난다. (📝 필기의 "index 가 필요한 이유" 와 같은 역할)
 *  - num = num / 2 → number /= 2  (복합 대입 연산자)
 *  - 배열 선언을 검사 뒤로 옮김 : 쓰지 않을 경우(0, 음수)엔 배열을 만들지 않는다.
 *  - 마지막에 줄바꿈 추가.
 *
 * 💡 음수까지 2 진수로 보려면 2 의 보수 표현을 알아야 한다. (Long.toBinaryString(-1) 은 1 이 64 개)
 *    이 과제의 범위를 넘어서서 리팩터링 버전도 지원하지 않는다고 명시했다.
 *
 * 실행 예
 *  10진수를 입력하세요: 11
 *  1011
 *
 *  10진수를 입력하세요: 0
 *  0
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
