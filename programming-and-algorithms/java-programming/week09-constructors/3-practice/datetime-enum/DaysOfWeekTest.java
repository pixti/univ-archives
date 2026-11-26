/**
 * [9강 실습] DateTime · Enum - 1번 문제 (요일 열거형)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class DaysOfWeekTest {
    enum DaysOfWeek {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        DaysOfWeek today = DaysOfWeek.MONDAY;
        System.out.println("Today is " + today);
        System.out.println("💡 MONDAY.ordinal() = " + today.ordinal());
    }
}
