import java.util.Scanner;

/**
 * [5강 실습] 배열(2) - 4번 문제
 *
 * n * n 크기의 나선형(spiral) 배열을 만들어 출력하는 프로그램을 작성하시오.
 *
 *   (예시 출력)
 *   Input a number: 5
 *   Spiral array becomes:
 *    1  2  3  4  5
 *   16 17 18 19  6
 *   15 24 25 20  7
 *   14 23 22 21  8
 *   13 12 11 10  9
 *
 * 💡 수업에서 직접 작성한 코드가 없는 문제라 참고용 풀이를 작성했다.
 *
 * 포인트 : 경계 네 개(top, bottom, left, right)를 좁혀 가며 바깥 테두리부터 한 바퀴씩 채운다.
 *
 *     → → → → ↓      한 바퀴 =
 *     ↑ → → ↓ ↓        ① 위쪽 행     : top 행,    left  → right  채우고 top++
 *     ↑ ↑ ⊙ ↓ ↓        ② 오른쪽 열   : right 열,  top   → bottom 채우고 right--
 *     ↑ ↑ ← ← ↓        ③ 아래쪽 행   : bottom 행, right → left   채우고 bottom--
 *     ↑ ← ← ← ←        ④ 왼쪽 열     : left 열,   bottom → top   채우고 left++
 *
 *  - 채울 때마다 num++ (1 부터 n*n 까지)
 *  - 바깥 while 조건 num <= n * n : 칸을 다 채우면 끝.
 *  - ③, ④ 앞의 if 검사 : n 이 홀수일 때 마지막 가운데 한 칸에서 같은 칸을 두 번 채우지 않게.
 *  - 출력은 printf("%3d") 로 폭을 맞췄다. (10 이상이 섞이면 자리 맞춤이 필요)
 *
 * 실행 예
 *  Input a number: 5
 *  Spiral array becomes:
 *    1  2  3  4  5
 *   16 17 18 19  6
 *   15 24 25 20  7
 *   14 23 22 21  8
 *   13 12 11 10  9
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
