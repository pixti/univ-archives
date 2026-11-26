import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * [9-1 DateTime] 휴먼 시간 - LocalDateTime 예제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
