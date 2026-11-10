import java.util.Scanner;

/**
 * [3강 과제] 조건문2 - 4번 문제
 * 사용자로부터 1에서 7 사이의 정수를 입력받아 그에 해당하는 요일을 표시하는 프로그램을 작성하라. (switch 문 사용)
 *
 * 포인트
 *  - "정수 값 하나가 여러 값 중 무엇과 같은지" 를 고르는 전형적인 switch 문제.
 *  - case 마다 break 를 빠뜨리면 아래 요일까지 모두 출력된다 (fall-through).
 *    예) case 1 에 break 가 없으면 1 입력 시 "월요일" 다음에 "화요일" 도 출력.
 *  - 1 ~ 7 이외의 값은 default 에서 처리한다.
 *
 * 💡 if-else if 로 쓰면 dayNumber == 1, dayNumber == 2, ... 를 7번 반복해야 한다.
 *    switch 가 훨씬 읽기 쉽다.
 *
 * 문제의 실행 예
 *  입력 숫자: 3
 *  해당 요일 : 수요일
 *
 * 내 코드 실행 예
 *  정수 입력 : 2
 *  화요일
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
