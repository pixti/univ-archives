import java.time.LocalDateTime;

/**
 * [9강 실습] DateTime · Enum - 7번 (추가 문제 : 오늘부터 100일 뒤의 날짜)
 *
 * 문제
 *  💡 문제 본문은 자료에 없고 내 코드(Problem.java)만 남아 있다. 코드로 보아
 *     "오늘로부터 100일 뒤의 연, 월, 일을 출력하라" 는 문제다.
 *
 * 포인트
 *  - plusDays(100) : 100일 뒤의 "새" LocalDateTime 객체를 돌려준다. now 자체는 바뀌지 않는다(불변).
 *
 * 💡 월 · 연이 바뀌는 계산(11월 → 다음 해 2월)도 plusDays 가 알아서 해 준다.
 * 💡 getMonth() 는 Month 열거형이라 FEBRUARY 처럼 대문자 이름이 나온다. 숫자가 필요하면 getMonthValue().
 * 💡 원래 클래스 이름은 Problem. HundredDaysLater 로 이름을 바꿨다.
 *
 * 실행 결과 (실행 날짜에 따라 다름 - 2026-11-05 에 실행)
 *  2027 FEBRUARY 13
 */
public class HundredDaysLater {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tmpDay = now.plusDays(100);
        System.out.println(tmpDay.getYear() + " " + tmpDay.getMonth() + " " + tmpDay.getDayOfMonth());
    }
}
