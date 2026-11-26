import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * [9강 실습] DateTime · Enum - 6번 문제 (이번 달의 마지막 날)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class LastDayOfMonth {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        Month month = today.getMonth();
        int lastDay = today.lengthOfMonth();

        System.out.println(year + "년 " + month + " " + lastDay);       // ❌ 대문자로 나온다

        String monthName = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        System.out.println(year + "년 " + monthName + " " + lastDay);   // ✅ November 로 나온다

        System.out.println("💡 원래 문제 형식 : " + month + " : " + lastDay);
        System.out.println("💡 마지막 날 : " + today.withDayOfMonth(today.lengthOfMonth()));
        System.out.println("💡 2028년 2월의 마지막 날 : " + LocalDate.of(2028, 2, 1).lengthOfMonth());
    }
}
