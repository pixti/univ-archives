import java.util.Random;
import java.util.Scanner;

/**
 * [5강 과제] 배열(2) - 4번 문제
 *
 * 임의 크기의 두 행렬을 곱하는 프로그램을 작성하시오.
 *  - 행렬의 크기는 입력받고, 각 원소는 0 ~ 99 사이의 난수로 채운다.
 *  - 곱할 수 없는 크기이면 "행렬 곱을 할 수 없는 크기입니다!!!" 를 출력한다.
 *
 * 포인트
 *  - 곱셈 가능 조건 : (r1 × c1) · (r2 × c2) 에서 c1 == r2.  결과 크기는 r1 × c2.
 *        (2 × 3) · (3 × 2) = (2 × 2)
 *             └─┬─┘
 *            같아야 함
 *  - 결과의 한 칸 = 첫 번째 행렬의 i 행 과 두 번째 행렬의 j 열 을 하나씩 곱해 모두 더한 값.
 *        result[i][j] = Σ (k = 0 ~ c1-1)  matrix1[i][k] * matrix2[k][j]
 *    → for 가 3 겹. i(결과의 행), j(결과의 열), k(곱해서 더할 짝).
 *  - 실행 예 검산 : result[0][0] = 54*8 + 46*11 + 47*30 = 432 + 506 + 1410 = 2348
 *  - rnd.nextInt(100) : 0 이상 100 미만 = 0 ~ 99.  (Math.random() * 100 을 int 로 바꾼 것과 같은 범위)
 *  - 크기를 확인한 "다음에" 배열을 만든다. 크기를 입력받아야 new int[r1][c1] 을 할 수 있다.
 *
 * 💡 result[i][j] = 0; 은 없어도 된다. new int[][] 는 0 으로 채워져 있다. (명시적으로 적어 두면 의도가 보인다)
 * 💡 0 이나 음수 크기를 넣으면 new int[-1][..] 에서 NegativeArraySizeException.
 *    → 리팩터링 버전은 양수인지 먼저 검사한다.
 * 💡 난수라 실행할 때마다 행렬 값이 다르다. 아래 실행 예는 한 번 실행한 결과.
 *
 * 실행 예
 *  첫 번째 행렬의 크기 ? 2 3
 *  두 번째 행렬의 크기 ? 3 2
 *  첫 번째 행렬 :
 *  54	46	47
 *  2	36	89
 *  두 번째 행렬 :
 *  8	69
 *  11	9
 *  30	47
 *  결과 행렬 :
 *  2348	6349
 *  3082	4645
 *
 *  첫 번째 행렬의 크기 ? 2 3
 *  두 번째 행렬의 크기 ? 2 3
 *  행렬 곱을 할 수 없는 크기입니다!!!
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
