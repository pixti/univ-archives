import java.util.Scanner;

/**
 * [4강 실습] 반복문1 - 3번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n ? ");
        int n = sc.nextInt();
        System.out.print("r ? ");
        int r = sc.nextInt();
        sc.close();

        int prod = 1, i = 0;
        while (i < r) {             // ( i <= r-1 ) 과 동일한 의미.
            prod *= (n - i);        // prod = prod * (n - i); 과 동일한 의미.
            i++;
        }
        System.out.println(n + "P" + r + " : " + prod);
    }
}
