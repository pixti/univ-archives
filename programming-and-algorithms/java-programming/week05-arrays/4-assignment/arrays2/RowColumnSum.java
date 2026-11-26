/**
 * [5강 과제] 배열(2) - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class RowColumnSum {
    public static void main(String[] args) {
        int[][] arr = {
                {12, 56, 32, 16, 98},
                {99, 56, 34, 41, 3},
                {65, 3, 87, 78, 21}
        };
        int row, col;
        int sum;

        // 각 행의 합계
        for (row = 0; row < arr.length; row++) {
            sum = 0;
            for (col = 0; col < arr[row].length; col++) {
                sum = sum + arr[row][col];
            }
            System.out.println((row + 1) + "번째 행의 합계 : " + sum);
        }

        // 각 열의 합계
        for (col = 0; col < arr[0].length; col++) {
            sum = 0;
            for (row = 0; row < arr.length; row++) {
                sum = sum + arr[row][col];
            }
            System.out.println((col + 1) + "번째 열의 합계 : " + sum);
        }
    }
}
