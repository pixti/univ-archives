import java.util.Scanner;

/**
 * [4강 실습] 반복문2 - 3번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class PermutationFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n ? ");
        int n = sc.nextInt();
        System.out.print("r ? ");
        int r = sc.nextInt();
        sc.close();                 // ⚠ 추가

        int prod = 1;
        for (int i = 0; i < r; i++) {
            prod *= (n - i);
        }
        System.out.print(n + "P" + r + " : " + prod);
    }
}
