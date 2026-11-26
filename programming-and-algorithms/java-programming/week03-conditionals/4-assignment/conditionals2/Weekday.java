import java.util.Scanner;

/**
 * [3강 과제] 조건문2 - 4번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Weekday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사용자에게 요일 번호를 입력받는다.
        // 1 = 월요일, 2 = 화요일, ..., 7 = 일요일
        System.out.print("정수 입력 : ");
        int dayNumber = sc.nextInt();

        // 입력된 숫자에 해당하는 요일을 출력한다.
        switch (dayNumber) {
            case 1:
                System.out.println("월요일");
                break;
            case 2:
                System.out.println("화요일");
                break;
            case 3:
                System.out.println("수요일");
                break;
            case 4:
                System.out.println("목요일");
                break;
            case 5:
                System.out.println("금요일");
                break;
            case 6:
                System.out.println("토요일");
                break;
            case 7:
                System.out.println("일요일");
                break;

            // 1~7 이외의 값이 입력된 경우
            default:
                System.out.println("유효한 값이 아님.");
        }

        // Scanner 사용 종료
        sc.close();
    }
}
