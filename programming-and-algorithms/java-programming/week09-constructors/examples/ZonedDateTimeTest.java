import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * [9-1 DateTime] 휴먼 시간 - ZonedDateTime
 *
 * 포인트
 *  - ZonedDateTime = 날짜 + 시각 + 시간대(ZoneId). 같은 순간(Instant)을 나라별 시각으로 표현할 수 있다.
 *  - ZoneId.of("Asia/Seoul") 은 한국 PC 에서 ZoneId.systemDefault() 와 같다.
 *
 * 💡 IST 는 인도 표준시(UTC+5:30), EST 는 미국 동부 표준시(UTC-5).
 *    서머타임 기간(3월~11월 초)에는 뉴욕이 EDT(UTC-4)가 된다. ZonedDateTime 이 자동으로 처리한다.
 * 💡 Asia/Calcutta 는 옛 이름이고 지금 정식 이름은 Asia/Kolkata. 둘 다 동작한다.
 * 💡 MMM, a, z 는 로케일에 따라 글자가 달라진다. 한국어 Windows 에서는 "05-11월-2026 11:42 오전 IST" 처럼 나온다.
 *    영어로 고정하려면 ofPattern(..., Locale.ENGLISH) 처럼 로케일을 넘긴다. (아래 💡 줄)
 *
 * 실행 결과 (실행 예: 2026-11-05 15:12 KST, 한국어 Windows)
 *  Seoul time : 2026-11-05T15:12:44.123456700+09:00[Asia/Seoul]
 *  Calcutta time : 05-11월-2026 11:42 오전 IST
 *  New_York time : 05-11월-2026 01:12 오전 EST
 *  Calcutta time (ENGLISH) : 05-Nov-2026 11:42 AM IST
 *  New_York time (ENGLISH) : 05-Nov-2026 01:12 AM EST
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
