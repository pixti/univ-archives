import java.time.LocalDateTime;

/**
 * [9강 실습] DateTime · Enum - 7번 (추가 문제 : 오늘부터 100일 뒤의 날짜)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class HundredDaysLater {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tmpDay = now.plusDays(100);
        System.out.println(tmpDay.getYear() + " " + tmpDay.getMonth() + " " + tmpDay.getDayOfMonth());
    }
}
