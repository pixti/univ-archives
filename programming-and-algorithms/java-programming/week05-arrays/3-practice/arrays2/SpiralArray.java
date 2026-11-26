import java.util.Scanner;

/**
 * [5강 실습] 배열(2) - 4번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class SpiralArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a number: ");
        int n = sc.nextInt();
        int[][] spiral = new int[n][n];

        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;
        while (num <= n * n) {
            for (int c = left; c <= right; c++) spiral[top][c] = num++;        // ① 위쪽 행 →
            top++;
            for (int r = top; r <= bottom; r++) spiral[r][right] = num++;      // ② 오른쪽 열 ↓
            right--;
            if (top <= bottom) {
                for (int c = right; c >= left; c--) spiral[bottom][c] = num++; // ③ 아래쪽 행 ←
                bottom--;
            }
            if (left <= right) {
                for (int r = bottom; r >= top; r--) spiral[r][left] = num++;   // ④ 왼쪽 열 ↑
                left++;
            }
        }

        System.out.println("Spiral array becomes:");
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.printf("%3d", spiral[r][c]);
            }
            System.out.println();
        }
        sc.close();
    }
}
