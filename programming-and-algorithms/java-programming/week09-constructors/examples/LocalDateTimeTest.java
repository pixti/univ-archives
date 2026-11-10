import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * [9-1 DateTime] 휴먼 시간 - LocalDateTime 예제
 *
 * 포인트
 *  - 객체 생성은 new 가 아니라 팩토리 메소드 now(), of(...) 로 한다.
 *    (LocalDateTime 의 생성자는 private → 9-3 "private 생성자면 같은 클래스 안에서만 생성 가능")
 *  - of(...) 가 여러 개 = 메소드 오버로딩 (퀴즈 📝 필기 : 파라미터의 개수나 타입이 다르게)
 *  - plus~ / minus~ / with~ 는 원래 객체를 바꾸지 않고 "새 객체"를 돌려준다(불변).
 *
 * 💡 LocalDateTime.of(2017, 1, ...) 의 1 은 1월이다. (Calendar 와 달리 1부터 셈)
 *    월을 Month.MARCH 처럼 열거형(9-2)으로 넘길 수도 있다.
 * 💡 마지막 인수 000000 은 나노초. 0 으로 시작하는 정수는 8진수지만 값이 0 이라 문제없다.
 *    (010 을 쓰면 10 이 아니라 8 이 되니 주의)
 * 💡 슬라이드에 없는 isBefore, with~, getter 와 "결과를 버리는 실수"를 추가했다.
 *
 * 실행 결과 (첫 줄은 실행 시각에 따라 다름)
 *  now       : 2026-11-10 14:20:31
 *  datetime1 : 2017-01-14T10:34
 *  dateTime2 : 2019-03-28T14:33:48
 *  datetime3 : 2017-05-14T10:34
 *  datetime4 : 2016-10-06T10:34
 *  datetime4.isBefore(datetime1) : true
 *  datetime1.withDayOfMonth(1) : 2017-01-01T10:34
 *  datetime1.withHour(23) : 2017-01-14T23:34
 *  plusDays 결과를 버리면 : 2017-01-14T10:34
 *  2017년 1월(JANUARY) 14일 SATURDAY
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        // factory
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime datetime1 = LocalDateTime.of(2017, 1, 14, 10, 34);
        LocalDateTime dateTime2 = LocalDateTime.of(2019, Month.MARCH, 28, 14, 33, 48, 000000);

        // format
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(format);

        // plus & minus
        LocalDateTime datetime3 = datetime1.plusDays(120);
        LocalDateTime datetime4 = datetime1.minusDays(100);

        System.out.println("now       : " + formatDateTime);
        System.out.println("datetime1 : " + datetime1);   // 💡 초가 0 이면 출력에서 생략됨
        System.out.println("dateTime2 : " + dateTime2);
        System.out.println("datetime3 : " + datetime3);   // 1/14 + 120일 = 5/14
        System.out.println("datetime4 : " + datetime4);   // 1/14 - 100일 = 2016/10/06

        // 💡 isX(..)
        System.out.println("datetime4.isBefore(datetime1) : " + datetime4.isBefore(datetime1));

        // 💡 with(..) : 특정 항목만 바꾼 새 객체
        System.out.println("datetime1.withDayOfMonth(1) : " + datetime1.withDayOfMonth(1));
        System.out.println("datetime1.withHour(23) : " + datetime1.withHour(23));

        // 💡 불변 객체 : 결과를 받지 않으면 아무 변화 없음
        LocalDateTime d = datetime1;
        d.plusDays(1);              // ❌ 결과를 버림 → d 는 그대로
        System.out.println("plusDays 결과를 버리면 : " + d);
        d = d.plusDays(1);          // ✅ 이렇게 받아야 함

        // 💡 getter
        System.out.println(datetime1.getYear() + "년 " + datetime1.getMonthValue() + "월("
                + datetime1.getMonth() + ") " + datetime1.getDayOfMonth() + "일 "
                + datetime1.getDayOfWeek());
    }
}
