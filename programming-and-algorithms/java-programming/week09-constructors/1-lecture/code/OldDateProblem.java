import java.util.Calendar;
import java.util.Date;

/**
 * [9-1 DateTime] 기존 Date / Calendar 클래스의 문제점
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class OldDateProblem {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);               // Thu May 30 09:54:50 KST 2024
        long time = date.getTime();
        System.out.println(time);               // 1717030490129

        Calendar birthDay = Calendar.getInstance();
        birthDay.set(Calendar.YEAR, 1964);
        birthDay.set(Calendar.MONTH, 8);        // 💡 8 → 9월 (0부터 셈)
        birthDay.set(Calendar.DATE, 24);
        birthDay.getTime();                     // 💡 강의 코드에 있는 줄. 결과를 쓰지 않으므로 의미 없음
        System.out.println(birthDay.getTime()); // Thu Sep 24 10:00:45 KST 1964

        // 💡 월 상수 값 확인
        System.out.println("Calendar.SEPTEMBER = " + Calendar.SEPTEMBER);
    }
}
