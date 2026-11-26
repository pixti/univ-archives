import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * [9-1 DateTime] 휴먼 시간 - ZonedDateTime
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ZonedDateTimeTest {
    public static void main(String[] args) {
        ZoneId zone = ZoneId.of("Asia/Seoul");  // 한국 내에서 ZoneId.systemDefault() 와 동일
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zone);
        System.out.println("Seoul time : " + zonedDateTime);

        DateTimeFormatter globalFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a z");
        ZoneId istZoneId = ZoneId.of("Asia/Calcutta");
        ZoneId estZoneId = ZoneId.of("America/New_York");

        Instant instant = Instant.now();
        ZonedDateTime currentISTime = instant.atZone(istZoneId);
        System.out.println("Calcutta time : " + globalFormat.format(currentISTime));
        ZonedDateTime zdt2 = instant.atZone(estZoneId);
        System.out.println("New_York time : " + globalFormat.format(zdt2));

        // 💡 로케일을 영어로 고정
        DateTimeFormatter englishFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a z", Locale.ENGLISH);
        System.out.println("Calcutta time (ENGLISH) : " + englishFormat.format(currentISTime));
        System.out.println("New_York time (ENGLISH) : " + englishFormat.format(zdt2));
    }
}
