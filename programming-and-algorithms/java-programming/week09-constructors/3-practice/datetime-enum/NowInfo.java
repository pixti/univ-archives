import java.time.LocalDateTime;

/**
 * [9강 실습] DateTime · Enum - 4번 문제 (현재 날짜와 시간의 각 항목 출력)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class NowInfo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Year: " + now.getYear());
        System.out.println("Month: " + now.getMonthValue());
        System.out.println("Day: " + now.getDayOfMonth());
        System.out.println("Hour: " + now.getHour());
        System.out.println("Minute: " + now.getMinute());
    }
}
