import java.util.Scanner;

/**
 * [4-4 반복문4] [실습] n보다 작은 소수 찾기 (이중 for 문 + break)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class PrimesBelowN {
    public static void main(String[] args) {
        System.out.println("n의 값을 입력하시오. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String result = "";
        int i, p;
        for (p = 2; p < n; p++) {
            for (i = 2; i < p; i++) {
                if ((p % i) == 0) break;    // 안쪽 for 만 빠져나옴
            }
            if (i == p) result = result + " " + p;
        }
        System.out.println(n + " 보다 작은 소수 : " + result);
        sc.close();
    }
}
