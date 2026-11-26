import java.util.Scanner;

/**
 * [5강 과제] 배열(1) - 2번 문제 (리팩터링 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class DaysInMonthRefactored {
    public static void main(String[] args) {
        // 표준 입력을 읽습니다.
        try (Scanner scanner = new Scanner(System.in)) {
            int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            System.out.print("원하는 달을 입력하세요: ");
            int month = scanner.nextInt();

            // 배열 인덱스로 사용하기 전에 월 범위를 확인합니다.
            if (month < 1 || month > daysInMonth.length) {
                System.out.println("1부터 12 사이의 달을 입력하세요.");
                return;
            }

            // 이 예제는 2월을 29일로 고정해 표시합니다.
            System.out.println(month + "월은 " + daysInMonth[month - 1] + "일까지 있습니다.");
        }
    }
}
