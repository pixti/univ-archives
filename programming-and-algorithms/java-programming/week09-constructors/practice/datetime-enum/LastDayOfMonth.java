import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * [9강 실습] DateTime · Enum - 6번 문제 (이번 달의 마지막 날)
 *
 * 문제
 *  이번 달의 마지막 날짜를 구해 "AUGUST : 31" 처럼 출력하시오.
 *
 * 📝 필기 : 2026년 November 30 으로 출력되도록 문제 변경.
 *
 * 포인트
 *  - LocalDate.now() 로 오늘 날짜, getMonth() 로 Month 열거형, lengthOfMonth() 로 그 달의 일 수(= 마지막 날)
 *
 * ⚠ getMonth() 를 그대로 출력하면 열거형 이름(대문자) NOVEMBER 가 나온다. 필기처럼 "November" 로 쓰려면
 *    month.getDisplayName(TextStyle.FULL, Locale.ENGLISH) 를 쓴다.
 *    ❌ 원본 : System.out.println(year + "년 " + month + " " + lastDay);        → 2026년 NOVEMBER 30
 *    ✅ 수정 : System.out.println(year + "년 " + monthName + " " + lastDay);    → 2026년 November 30
 * 💡 TextStyle.SHORT 는 "Nov", Locale.KOREAN 이면 "11월" 이 된다.
 * 💡 다른 방법 : today.withDayOfMonth(today.lengthOfMonth()) 는 마지막 날의 LocalDate 를 만든다. (9-1 with~)
 *    윤년도 자동으로 처리된다. (2028년 2월 → 29)
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. LastDayOfMonth 로 이름을 바꿨다.
 *
 * 실행 결과 (실행 날짜에 따라 다름 - 2026년 11월에 실행)
 *  2026년 NOVEMBER 30
 *  2026년 November 30
 *  💡 원래 문제 형식 : NOVEMBER : 30
 *  💡 마지막 날 : 2026-11-30
 *  💡 2028년 2월의 마지막 날 : 29
 */
public class LastDayOfMonth {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        Month month = today.getMonth();
        int lastDay = today.lengthOfMonth();

        System.out.println(year + "년 " + month + " " + lastDay);       // ❌ 원본 (대문자)

        String monthName = month.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        System.out.println(year + "년 " + monthName + " " + lastDay);   // ✅ 수정

        System.out.println("💡 원래 문제 형식 : " + month + " : " + lastDay);
        System.out.println("💡 마지막 날 : " + today.withDayOfMonth(today.lengthOfMonth()));
        System.out.println("💡 2028년 2월의 마지막 날 : " + LocalDate.of(2028, 2, 1).lengthOfMonth());
    }
}
