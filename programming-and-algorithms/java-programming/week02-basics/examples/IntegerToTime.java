import java.util.Scanner; // 슬라이드 코드에는 빠져 있음 → 없으면 컴파일 에러

/**
 * [2-5 수식1] [실습] 임의의 양의 정수값을 시분초로 변환하기
 *
 * 사용자에게 정수값(초)을 받은 후 시/분/초로 변환하여 출력하는 프로그램
 *  예) 입력 : 3665 → 출력 : 1시간 1분 5초
 *      입력 : 65   → 출력 : 0시간 1분 5초
 *
 * 핵심: 정수 나눗셈(/)은 몫, 나머지 연산(%)은 나머지
 *  - 1시간 = 3600초, 1분 = 60초
 *  - hour   = 전체 / 3600
 *  - remain = 전체 % 3600   (시간을 빼고 남은 초)
 *  - minute = remain / 60
 *  - second = remain % 60
 */
public class IntegerToTime {
    public static void main(String[] args) {
        System.out.println("숫자 입력 >> ");
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성
        int i = sc.nextInt();                // 정수 입력
        sc.close();                          // 사용 후 꼭! 닫아줌

        int hour = i / 3600;
        int remain = i % 3600;
        int minute = remain / 60;
        int second = remain % 60;
        System.out.println(hour + "시 " + minute + "분 " + second + "초");
    }
}
