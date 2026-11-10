import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * [9강 실습] DateTime · Enum - 5번 문제 (뉴욕의 현재 시간)
 *
 * 문제
 *  ZonedDateTime 을 이용해 뉴욕(America/New_York)의 현재 시각을 "시:분:초" 로 출력하시오.
 *
 * 포인트
 *  - ZonedDateTime.now(ZoneId.of("America/New_York")) : 지정한 시간대의 현재 날짜 · 시각
 *  - getHour(), getMinute(), getSecond() 로 항목을 꺼낸다.
 *
 * 💡 문제의 실행 결과(5:10:1)처럼 숫자를 그대로 이어 붙이면 한 자리 수 앞에 0 이 붙지 않는다.
 *    05:10:01 처럼 두 자리로 맞추려면 String.format("%02d:%02d:%02d", ...) 를 쓴다. (💡 줄)
 * 💡 뉴욕은 11월 첫째 일요일부터 EST(UTC-5), 3월 둘째 일요일부터 EDT(UTC-4, 서머타임).
 *    ZonedDateTime 이 자동으로 처리하므로 직접 계산할 필요가 없다.
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. NewYorkTime 으로 이름을 바꿨다.
 *
 * 실행 결과 (실행 시각에 따라 다름 - 내가 실행했을 때)
 *  Time in New York: 1:12:44
 *  💡 Time in New York: 01:12:44
 */
public class NewYorkTime {
    public static void main(String[] args) {
        ZonedDateTime nyTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Time in New York: "
                + nyTime.getHour() + ":" + nyTime.getMinute() + ":" + nyTime.getSecond());

        // 💡 두 자리로 맞추기
        System.out.println(String.format("💡 Time in New York: %02d:%02d:%02d",
                nyTime.getHour(), nyTime.getMinute(), nyTime.getSecond()));
    }
}
