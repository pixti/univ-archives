import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * [9강 실습] DateTime · Enum - 5번 문제 (뉴욕의 현재 시간)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
