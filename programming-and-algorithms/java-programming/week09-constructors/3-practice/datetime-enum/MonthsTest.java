import java.time.LocalDate;

/**
 * [9강 실습] DateTime · Enum - 3번 문제 (월 열거형)  💡 참고 답안
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MonthsTest {
    enum Months {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE,
        JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    public static void main(String[] args) {
        Months thisMonth = Months.SEPTEMBER;
        System.out.println("이번 달 : " + thisMonth);
        System.out.println("💡 " + thisMonth + " 는 " + (thisMonth.ordinal() + 1) + "월");

        Months now = Months.valueOf(LocalDate.now().getMonth().name());
        System.out.println("💡 실제 이번 달 : " + now + " (" + (now.ordinal() + 1) + "월)");
    }
}
