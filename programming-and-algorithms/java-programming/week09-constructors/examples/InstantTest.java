import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * [9-1 DateTime] 기계 시간 - Instant
 *
 * 포인트
 *  - Instant : 1970-01-01T00:00:00Z(epoch)부터 흐른 시간을 초 + 나노초로 표현하는 "기계용 시간".
 *  - getEpochSecond() : epoch 부터 지난 초,  getNano() : 그 초 안의 나노초(0 ~ 999,999,999)
 *  - atZone(zone) : 같은 순간을 원하는 시간대의 날짜 · 시각(ZonedDateTime)으로 바꿔 본다.
 *
 * 💡 Instant 를 그냥 출력하면 끝에 Z 가 붙는다. Z 는 UTC(+00:00) 라는 뜻이다.
 *    그래서 한국 시각 10:42 가 01:42Z 로 찍힌다(한국은 UTC+9).
 * 💡 슬라이드의 getNano() 값(98150300)은 instant(…804485700)와 다른 실행에서 나온 값이라 숫자가 맞지 않는다.
 *    같은 실행이라면 804485700 이 나온다.
 * 💡 7강 과제 클래스1 4번 Stopwatch 에서 Instant 와 Duration 을 이미 사용했다.
 *
 * 실행 결과 (실행 시각에 따라 다름 - 슬라이드 예시)
 *  2024-05-30T01:42:13.804485700Z
 *  1717033693
 *  804485700
 *  2024-05-30T10:42:13.804485700+09:00[Asia/Seoul]
 *  2024-05-29T18:42:13.804485700-07:00[America/Los_Angeles]
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
