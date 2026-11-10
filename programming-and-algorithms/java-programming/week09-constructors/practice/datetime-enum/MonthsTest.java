import java.time.LocalDate;

/**
 * [9강 실습] DateTime · Enum - 3번 문제 (월 열거형)  💡 참고 답안
 *
 * 문제
 *  1월부터 12월까지(JANUARY ~ DECEMBER)를 나타내는 열거형 Months 를 정의하고,
 *  이번 달을 SEPTEMBER 로 지정해 출력하시오.
 *
 * 💡 직접 풀지 않은 문제라 참고 답안으로 채웠다.
 * 💡 덤으로 "실제 이번 달"을 구해 봤다. LocalDate.now().getMonth() 는 java.time.Month 열거형을 돌려주고,
 *    .name() 으로 이름 문자열을 꺼낸 뒤 Months.valueOf(...) 로 우리 열거형 값으로 바꿨다.
 *    (두 열거형의 상수 이름이 같아서 가능)
 * 💡 values() 로 모든 상수를 꺼내 반복할 수 있다. ordinal() + 1 이 몇 월인지가 된다.
 *
 * 실행 결과 (마지막 두 줄은 실행 날짜에 따라 다름)
 *  이번 달 : SEPTEMBER
 *  💡 SEPTEMBER 는 9월
 *  💡 실제 이번 달 : NOVEMBER (11월)
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
