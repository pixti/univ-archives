import java.util.Scanner;

/**
 * [4-4 반복문4] [실습] 소수 판별하기 (break)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class PrimeCheck {
    public static void main(String[] args) {
        System.out.println("n의 값을 입력하시오. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;
        for (i = 2; i < n; i++) {
            if ((n % i) == 0) break;
        }
        if (i == n) System.out.println("소수입니다.");
        else System.out.println("소수가 아닙니다.");
        sc.close();
    }
}
