/**
 * [9강 실습] DateTime · Enum - 1번 문제 (요일 열거형)
 *
 * 문제
 *  일요일부터 토요일까지를 나타내는 열거형 DaysOfWeek 를 정의하고,
 *  오늘(today)을 MONDAY 로 지정해 출력하시오.
 *
 * 포인트
 *  - enum 선언 : 가능한 값을 쉼표로 나열 (9-2)
 *  - 열거 값은 "열거형이름.상수" 로 쓰고, 출력하면 이름이 그대로 나온다. (숫자가 아님)
 *
 * 💡 자바에는 이미 java.time.DayOfWeek 열거형(MONDAY ~ SUNDAY)이 있다. 이름이 겹치지 않게 DaysOfWeek 로 지었다.
 * 💡 ordinal() 은 선언 순서(0부터)다. SUNDAY 를 먼저 선언했으므로 MONDAY 는 1.
 *
 * 실행 결과
 *  Today is MONDAY
 *  💡 MONDAY.ordinal() = 1
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
