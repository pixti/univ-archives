import java.util.Scanner;

/**
 * [3강 실습] 조건문2 - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
