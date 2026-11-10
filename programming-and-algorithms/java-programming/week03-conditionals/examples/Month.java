import java.util.Scanner;

/**
 * [3-3 조건문3] [실습] 월의 일수 맞히기
 *
 * - break 없이 case 를 나열하면 여러 값을 같은 동작으로 묶을 수 있다. (fall-through 활용)
 *     case 1 : case 3 : ... case 12 : days = 31; break;
 *   → 1 이 들어오면 case 1 로 점프한 뒤, break 를 만날 때까지 아래로 흘러가 days = 31 실행
 * - default 에서 return; 으로 끝내므로 days 를 초기화하지 않아도 컴파일 에러가 없다. (확정 대입)
 *
 * 💡 2월은 윤년이면 29일이다.
 *    2주차의 윤년식 (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 과 함께 쓰면
 *    연도까지 고려할 수 있다.
 *
 * 실행 예
 *  월 (1 ~ 12) ?
 *  3
 *  3월은 31까지 입니다.
 */
public class Month {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("월 (1 ~ 12) ? ");
        int m = sc.nextInt();
        sc.close();

        int days;
        switch (m) {
            case 1 : case 3 :
            case 5 : case 7 :
            case 8 : case 10 :
            case 12 : days = 31; break;
            case 4 : case 6 : case 9 : case 11 :
                days = 30; break;
            case 2 : days = 28; break;
            default :
                System.out.println("허용되지 않는 월입니다.");
                return;
        }
        System.out.println(m + "월은 " + days + "까지 입니다.");
    }
}
