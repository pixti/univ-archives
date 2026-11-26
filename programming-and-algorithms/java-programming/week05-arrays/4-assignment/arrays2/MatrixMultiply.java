import java.util.Random;
import java.util.Scanner;

/**
 * [5강 과제] 배열(2) - 4번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MatrixMultiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int r1, c1, r2, c2;
        int i, j, k;

        System.out.print("첫 번째 행렬의 크기 ? ");
        r1 = sc.nextInt();
        c1 = sc.nextInt();

        System.out.print("두 번째 행렬의 크기 ? ");
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        // 행렬의 곱셈이 가능한지 확인
        if (c1 != r2) {
            System.out.println("행렬 곱을 할 수 없는 크기입니다!!!");
        }
        else {
            int[][] matrix1 = new int[r1][c1];
            int[][] matrix2 = new int[r2][c2];
            int[][] result = new int[r1][c2];

            // 첫 번째 행렬 생성
            System.out.println("첫 번째 행렬 :");
            for (i = 0; i < r1; i++) {
                for (j = 0; j < c1; j++) {
                    matrix1[i][j] = rnd.nextInt(100);
                    System.out.print(matrix1[i][j] + "\t");
                }
                System.out.println();
            }

            // 두 번째 행렬 생성
            System.out.println("두 번째 행렬 :");
            for (i = 0; i < r2; i++) {
                for (j = 0; j < c2; j++) {
                    matrix2[i][j] = rnd.nextInt(100);
                    System.out.print(matrix2[i][j] + "\t");
                }
                System.out.println();
            }

            // 행렬 곱셈
            for (i = 0; i < r1; i++) {
                for (j = 0; j < c2; j++) {
                    result[i][j] = 0;
                    for (k = 0; k < c1; k++) {
                        result[i][j] = result[i][j] + matrix1[i][k] * matrix2[k][j];
                    }
                }
            }

            // 결과 행렬 출력
            System.out.println("결과 행렬 :");
            for (i = 0; i < r1; i++) {
                for (j = 0; j < c2; j++) {
                    System.out.print(result[i][j] + "\t");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
