import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * [9-1 DateTime] 기계 시간 - Instant
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class InstantTest {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);                    // 2024-05-30T01:42:13.804485700Z
        System.out.println(instant.getEpochSecond());   // 1717033693
        System.out.println(instant.getNano());          // 804485700

        ZoneId zone = ZoneId.systemDefault();           // 한국 PC 라면 Asia/Seoul
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);              // 2024-05-30T10:42:13.804485700+09:00[Asia/Seoul]

        zone = ZoneId.of("America/Los_Angeles");
        zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);              // 2024-05-29T18:42:13.804485700-07:00[America/Los_Angeles]
    }
}
