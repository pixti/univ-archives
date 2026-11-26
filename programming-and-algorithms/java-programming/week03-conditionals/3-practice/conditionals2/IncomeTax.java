import java.util.Scanner;

/**
 * [3강 실습] 조건문2 - 3번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class IncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("연봉 입력 : ? 만원 ");
        int income = sc.nextInt();
        sc.close();

        int tax = 0;
        if (income > 8000) {
            tax = (int) (income * 0.35);     // 📝 0.35 는 double → 강제 형변환
        }
        else if (income > 4000) {
            tax = (int) (income * 0.26);
        }
        else if (income > 1000) {
            tax = (int) (income * 0.17);
        }
        else {
            tax = (int) (income * 0.08);
        }

        System.out.print("소득세는 " + tax + "만원 입니다.");
    }
}
