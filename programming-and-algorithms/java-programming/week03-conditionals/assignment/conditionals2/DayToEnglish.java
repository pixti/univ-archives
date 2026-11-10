import java.util.Scanner;

/**
 * [3강 과제] 조건문2 - 5번 문제
 * 영어 요일을 한글 요일로 출력해 주는 프로그램을 작성하라. (switch 문 사용)
 *
 * ⚠ 문제 문장은 "영어 → 한글" 인데, 문제의 실행 예는 "월요일 → Monday" (한글 → 영어) 이다.
 *    실행 예를 기준으로 한글 요일을 입력받아 영어 요일을 출력하도록 작성했다.
 *
 * 포인트
 *  - switch 식에 String 을 쓸 수 있다. (Java 7 이상)
 *  - String switch 는 내부적으로 == 가 아니라 equals() 로 "내용" 을 비교한다.
 *    → sc.next() 로 입력받은 문자열도 case "월요일" 과 제대로 비교된다.
 *    (if 문으로 쓸 때는 inputDay == "월요일" 이 아니라 inputDay.equals("월요일") 로 써야 한다)
 *  - 결과를 switch 안에서 바로 출력하지 않고 englishDay 변수에 저장한 뒤, switch 밖에서 한 번만 출력했다.
 *
 * 💡 englishDay 를 초기화하지 않았지만 default 를 포함한 모든 갈래에서 값을 대입하므로 컴파일 에러가 나지 않는다.
 *    default 를 지우면 "variable englishDay might not have been initialized" 에러가 난다. (확정 대입)
 *
 * 문제의 실행 예
 *  입력 요일 : 월요일
 *  출력 요일 : Monday
 *
 * 내 코드 실행 예
 *  입력 요일 : 화요일
 *  출력 요일 : Tuesday
 */
public class DayToEnglish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 한글 요일을 입력받는다.
        System.out.print("입력 요일 : ");
        String inputDay = sc.next();

        // 입력받은 한글 요일에 대응하는 영어 요일을 저장한다.
        String englishDay;

        switch (inputDay) {
            case "월요일":
                englishDay = "Monday";
                break;
            case "화요일":
                englishDay = "Tuesday";
                break;
            case "수요일":
                englishDay = "Wednesday";
                break;
            case "목요일":
                englishDay = "Thursday";
                break;
            case "금요일":
                englishDay = "Friday";
                break;
            case "토요일":
                englishDay = "Saturday";
                break;
            case "일요일":
                englishDay = "Sunday";
                break;

            // 위의 어떤 요일에도 해당하지 않는 경우
            default:
                englishDay = "잘못된 요일입니다.";
        }

        // switch에서 결정된 영어 요일을 출력한다.
        System.out.println("출력 요일 : " + englishDay);

        sc.close();
    }
}
