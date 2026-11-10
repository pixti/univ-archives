import java.util.Scanner;

/**
 * [3강 실습] 조건문2 - 2번 문제
 * 사용자가 생일과 현재 날짜를 입력하면 만으로 몇 살인지를 계산해주는 프로그램을 작성하여 보자.
 *
 * 풀이 (중첩 if)
 *  - 기본 나이 = 현재 연도 - 태어난 연도
 *  - 올해 생일이 아직 안 지났으면 1 을 뺀다.
 *      태어난 달 > 현재 달                 → 생일 안 지남 → -1
 *      태어난 달 < 현재 달                 → 생일 지남
 *      같은 달이면 일(day)까지 비교
 *        태어난 날 > 현재 날               → 생일 안 지남 → -1
 *        그 외 (생일 당일 포함)             → 생일 지남
 *
 * ⚠ 문제의 실행 예는 "당신의 나이는 : 20" 이지만,
 *    1990.10.12 생은 2010.9.17 에 아직 생일(10월)이 지나지 않았으므로 만 나이는 19세가 맞다.
 *    (2010 - 1990 - 1 = 19)
 *
 * 💡 age 를 선언만 하고 초기화하지 않았지만 컴파일 에러가 나지 않는다.
 *    if - else if - else 의 모든 갈래에서 age 에 값을 대입하기 때문이다. (확정 대입)
 * 💡 조건을 하나로 합쳐 쓸 수도 있다.
 *      int age = c_year - b_year;
 *      if (b_month > c_month || (b_month == c_month && b_day > c_day)) age--;
 *
 * 문제의 실행 예  (입력 : 생일 1990 10 12, 현재 날짜 2010 9 17)
 *  당신의 나이는 : 20       ⚠ 위에서 설명한 대로 19 가 맞다
 *
 * 내 코드 실행 예
 *  생년월일 입력 : 2002 03 01
 *  현재 날짜 입력 : 2026 09 17
 *  당신의 나이는 만 24세 입니다.
 */
public class AgeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("생년월일 입력 : ");
        int b_year = sc.nextInt();
        int b_month = sc.nextInt();
        int b_day = sc.nextInt();

        System.out.print("현재 날짜 입력 : ");
        int c_year = sc.nextInt();
        int c_month = sc.nextInt();
        int c_day = sc.nextInt();
        sc.close();

        int age;
        if (b_month > c_month) {                 // 생일이 있는 달이 아직 안 옴
            age = c_year - b_year - 1;
        }
        else if (b_month < c_month) {            // 생일이 있는 달이 지남
            age = c_year - b_year;
        }
        else {                                   // 생일이 있는 달 → 일까지 비교
            if (b_day > c_day) {
                age = c_year - b_year - 1;
            }
            else {
                age = c_year - b_year;
            }
        }

        System.out.print("당신의 나이는 만 " + age + "세 입니다.");
    }
}
