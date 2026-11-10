import java.util.Calendar;
import java.util.Date;

/**
 * [9-1 DateTime] 기존 Date / Calendar 클래스의 문제점
 *
 * 포인트
 *  - java.util.Date 는 JDK 1.0, Calendar 는 JDK 1.1 부터 있던 클래스다.
 *  - 문제점 : 월(MONTH)이 0 부터 시작, 객체 값이 바뀜(가변 → thread safe 하지 않음), 시간대 처리가 불편.
 *    → Java 8 부터 java.time 패키지(Instant, LocalDateTime, ZonedDateTime ...)를 쓴다.
 *
 * 💡 Calendar.MONTH 에 8 을 넣었는데 출력은 Sep(9월)이다. Calendar 는 월을 0 부터 센다(0 = 1월).
 *    9월을 원하면 8 또는 Calendar.SEPTEMBER 를 넣어야 한다.
 * 💡 date.getTime() 은 1970-01-01 00:00:00 UTC(epoch)부터 지난 시간을 밀리초(long)로 돌려준다.
 * 💡 시각은 set 으로 바꾸지 않았으므로 getInstance() 를 호출한 현재 시각이 그대로 남는다.
 * 💡 Calendar 는 set(...) 으로 "자기 자신의 값"이 바뀐다(가변). 다른 곳에서 같은 객체를 쓰고 있으면 값이 함께 바뀐다.
 *    java.time 의 LocalDate 는 plusDays(...) 가 새 객체를 돌려줄 뿐 원래 객체는 그대로다(불변).
 *
 * 실행 결과 (실행 시각에 따라 다름 - 슬라이드 예시)
 *  Thu May 30 09:54:50 KST 2024
 *  1717030490129
 *  Thu Sep 24 10:00:45 KST 1964
 *  Calendar.SEPTEMBER = 8
 */
public class OldDateProblem {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);               // Thu May 30 09:54:50 KST 2024
        long time = date.getTime();
        System.out.println(time);               // 1717030490129

        Calendar birthDay = Calendar.getInstance();
        birthDay.set(Calendar.YEAR, 1964);
        birthDay.set(Calendar.MONTH, 8);        // 💡 8 → 9월 (0부터 셈)
        birthDay.set(Calendar.DATE, 24);
        birthDay.getTime();                     // 💡 슬라이드에 있는 줄. 결과를 쓰지 않으므로 의미 없음
        System.out.println(birthDay.getTime()); // Thu Sep 24 10:00:45 KST 1964

        // 💡 월 상수 값 확인
        System.out.println("Calendar.SEPTEMBER = " + Calendar.SEPTEMBER);
    }
}
