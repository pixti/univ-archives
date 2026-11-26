import java.util.Scanner;

/**
 * [2강 실습] 수식 - 3번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class TimeToSeconds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("몇 시 ? ");
        int hour = sc.nextInt();
        System.out.print("몇 분 ? ");
        int min = sc.nextInt();
        System.out.print("몇 초 ? ");
        int sec = sc.nextInt();
        sc.close();

        // 💡 final int TIME = hour*3600 + min*60 + sec; 처럼 써도 컴파일은 된다.
        //    final 을 붙이면 이후 값을 바꿀 수 없는 지역 상수가 된다.
        // 다만 입력에 따라 매번 달라지는 "계산 결과"이므로 일반 변수(소문자 이름)로 두는 편이 관례에 더 맞다.
        // 1시간 = 3600초, 1분 = 60초 처럼 고정된 값을 기호 상수로 만드는 것이 기호 상수의 원래 용도.
        final int SEC_PER_HOUR = 3600;
        final int SEC_PER_MIN = 60;
        int total = hour * SEC_PER_HOUR + min * SEC_PER_MIN + sec;

        System.out.println(hour + "시간 " + min + "분 " + sec + "초는 " + total + "초입니다.");
    }
}
