import java.util.Scanner;

/**
 * [5강 과제] 배열(1) - 2번 문제 (리팩터링 버전)
 *
 * DaysInMonth.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점
 *  - try-with-resources 로 Scanner 자동 닫기
 *  - 변수 이름 days → daysInMonth
 *  - 범위 검사 추가 : month < 1 || month > daysInMonth.length 이면 안내 후 return.
 *    → 원래 코드에서 0, 13 을 넣으면 나던 ArrayIndexOutOfBoundsException 을 막는다.
 *  - 12 대신 daysInMonth.length 로 비교.
 *
 * 💡 return 은 main 메소드를 끝낸다 = 프로그램 종료. try 블록 안에서 return 해도 Scanner 는 닫힌다.
 * 💡 안내 문구 "1부터 12 사이" 의 12 는 숫자로 적혀 있다. (조건은 length 로, 문구는 숫자로)
 *
 * 실행 예
 *  원하는 달을 입력하세요: 4
 *  4월은 30일까지 있습니다.
 *
 *  원하는 달을 입력하세요: 13
 *  1부터 12 사이의 달을 입력하세요.
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
