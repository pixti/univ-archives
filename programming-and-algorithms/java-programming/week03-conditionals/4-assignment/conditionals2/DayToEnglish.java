import java.util.Scanner;

/**
 * [3강 과제] 조건문2 - 5번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
