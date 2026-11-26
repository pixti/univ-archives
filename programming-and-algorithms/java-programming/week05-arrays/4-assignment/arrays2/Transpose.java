/**
 * [5강 과제] 배열(2) - 3번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Transpose {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 0},
                {4, 5, 6, 1},
                {7, 8, 9, 0}
        };
        int[][] transpose = new int[4][3];
        int row, col;

        // 전치 행렬 만들기
        for (row = 0; row < arr.length; row++) {
            for (col = 0; col < arr[row].length; col++) {
                transpose[col][row] = arr[row][col];
            }
        }

        // 원본 배열 출력
        System.out.println("원본 행렬");
        for (row = 0; row < arr.length; row++) {
            for (col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + "\t");
            }
            System.out.println();
        }

        // 전치 행렬 출력
        System.out.println();
        System.out.println("전치 행렬");
        for (row = 0; row < transpose.length; row++) {
            for (col = 0; col < transpose[row].length; col++) {
                System.out.print(transpose[row][col] + "\t");
            }
            System.out.println();
        }
    }
}
