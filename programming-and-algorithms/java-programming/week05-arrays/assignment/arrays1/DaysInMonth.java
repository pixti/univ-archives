import java.util.Scanner;

/**
 * [5강 과제] 배열(1) - 2번 문제
 *
 * 다음 배열을 이용하여 사용자가 입력한 달의 날짜 수를 출력하는 프로그램을 작성하시오.
 *   int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
 *
 * 포인트
 *  - 배열을 "표(룩업 테이블)" 로 쓴다. if 나 switch 12 개 대신 days[month - 1] 한 번으로 끝난다.
 *    (3주차 switch 로 월의 날짜 수를 구하던 것과 비교)
 *  - 사람의 달은 1 ~ 12, 배열 인덱스는 0 ~ 11 → month - 1
 *
 *      month :  1  2  3  4 ...  12
 *      index :  0  1  2  3 ...  11
 *      days  : 31 29 31 30 ...  31
 *
 * ⚠ 범위 검사가 없다. 0 이나 13 을 넣으면 days[-1], days[12] 에서 ArrayIndexOutOfBoundsException.
 *   → 리팩터링 버전에서 1 ~ 12 검사를 추가했다.
 * 💡 2월은 문제의 배열대로 29 일로 고정. 윤년까지 따지려면 연도도 입력받아야 한다.
 *
 * 실행 예
 *  원하는 달을 입력하세요 : 4
 *  4월은 30일까지 있습니다.
 */
public class DaysInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month;

        System.out.print("원하는 달을 입력하세요 : ");
        month = sc.nextInt();

        System.out.println(month + "월은 " + days[month - 1] + "일까지 있습니다.");
        sc.close();
    }
}
