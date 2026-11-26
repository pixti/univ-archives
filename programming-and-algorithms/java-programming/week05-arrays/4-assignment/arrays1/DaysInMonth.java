import java.util.Scanner;

/**
 * [5강 과제] 배열(1) - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
