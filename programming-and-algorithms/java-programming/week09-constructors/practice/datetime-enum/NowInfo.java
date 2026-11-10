import java.time.LocalDateTime;

/**
 * [9강 실습] DateTime · Enum - 4번 문제 (현재 날짜와 시간의 각 항목 출력)
 *
 * 문제
 *  LocalDateTime 을 이용해 현재의 연, 월, 일, 시, 분을 각각 출력하시오.
 *
 * 포인트
 *  - LocalDateTime.now() : 팩토리 메소드로 현재 날짜 · 시각 객체를 얻는다.
 *  - getter : getYear(), getMonthValue(), getDayOfMonth(), getHour(), getMinute()
 *
 * 💡 getMonth() 는 Month 열거형(NOVEMBER)을, getMonthValue() 는 숫자(11)를 돌려준다.
 *    "Month: 11" 처럼 숫자가 필요하므로 getMonthValue() 를 썼다.
 * 💡 getDay() 가 아니라 getDayOfMonth() 다. (getDayOfYear() : 1월 1일부터 며칠째, getDayOfWeek() : 요일)
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. NowInfo 로 이름을 바꿨다.
 *
 * 실행 결과 (실행 시각에 따라 다름 - 내가 실행했을 때)
 *  Year: 2026
 *  Month: 11
 *  Day: 5
 *  Hour: 15
 *  Minute: 10
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
