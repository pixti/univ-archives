import java.util.Random;
import java.util.Scanner;

/**
 * [5강 과제] 배열(2) - 4번 문제 (리팩터링 버전)
 *
 * MatrixMultiply.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점
 *  - 상수 MAX_RANDOM_VALUE = 100 (난수 범위 0 ~ 99)
 *  - try-with-resources 로 Scanner 자동 닫기
 *  - 변수 이름 r1, c1, r2, c2 → firstRows, firstColumns, secondRows, secondColumns
 *  - 양수 크기 검사 추가 : 0 이나 음수면 "행과 열의 크기는 모두 양수여야 합니다." 후 종료
 *    (원래 코드는 음수 크기면 NegativeArraySizeException)
 *  - if-else 대신 "조건이 안 맞으면 바로 return" (early return) → else 블록의 들여쓰기가 사라진다.
 *  - 기능별 메소드 분리
 *      createRandomMatrix(rows, columns, random) : 난수 행렬 생성
 *      multiplyMatrices(first, second)           : 행렬 곱셈 → 결과 배열을 return
 *      printMatrix(matrix)                       : 출력 (세 번 반복되던 출력 코드를 하나로)
 *    → 원래 코드는 "생성하면서 출력" 했는데, 생성과 출력을 분리했다.
 *  - 곱셈의 공통 크기(c1 == r2)를 sharedDimension 이라는 이름으로 표현.
 *  - 메소드는 배열의 length 로 크기를 알아낸다. 크기를 따로 넘길 필요가 없다.
 *
 * 💡 메소드가 int[][] 를 return 할 수 있다. 메소드 안에서 new 로 만든 배열의 참조가 돌아온다.
 * 💡 product[row][column] += ... : new int[][] 가 0 으로 시작하므로 = 0 초기화 없이 바로 누적.
 *
 * 실행 예  (난수라 매번 다름)
 *  첫 번째 행렬의 크기(행 열): 4 3
 *  두 번째 행렬의 크기(행 열): 3 4
 *  첫 번째 행렬:
 *  ... (4 × 3)
 *  두 번째 행렬:
 *  ... (3 × 4)
 *  결과 행렬:
 *  ... (4 × 4)
 *
 *  첫 번째 행렬의 크기(행 열): 2 3
 *  두 번째 행렬의 크기(행 열): 2 3
 *  행렬 곱을 할 수 없는 크기입니다.
 */
public class MatrixMultiplyRefactored {

    private static final int MAX_RANDOM_VALUE = 100;

    public static void main(String[] args) {
        // Scanner를 자동으로 닫아 입력 자원을 정리합니다.
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("첫 번째 행렬의 크기(행 열): ");
            int firstRows = scanner.nextInt();
            int firstColumns = scanner.nextInt();

            System.out.print("두 번째 행렬의 크기(행 열): ");
            int secondRows = scanner.nextInt();
            int secondColumns = scanner.nextInt();

            // 배열을 만들기 전에 크기가 양수인지 확인합니다.
            if (firstRows <= 0 || firstColumns <= 0 || secondRows <= 0 || secondColumns <= 0) {
                System.out.println("행과 열의 크기는 모두 양수여야 합니다.");
                return;
            }

            // 첫 번째 행렬의 열 수와 두 번째 행렬의 행 수가 같아야 곱할 수 있습니다.
            if (firstColumns != secondRows) {
                System.out.println("행렬 곱을 할 수 없는 크기입니다.");
                return;
            }

            Random random = new Random();
            int[][] firstMatrix = createRandomMatrix(firstRows, firstColumns, random);
            int[][] secondMatrix = createRandomMatrix(secondRows, secondColumns, random);

            System.out.println("첫 번째 행렬:");
            printMatrix(firstMatrix);

            System.out.println("두 번째 행렬:");
            printMatrix(secondMatrix);

            int[][] productMatrix = multiplyMatrices(firstMatrix, secondMatrix);

            System.out.println("결과 행렬:");
            printMatrix(productMatrix);
        }
    }

    // 지정한 크기의 행렬을 0부터 99 사이의 난수로 채웁니다.
    private static int[][] createRandomMatrix(int rows, int columns, Random random) {
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = random.nextInt(MAX_RANDOM_VALUE);
            }
        }

        return matrix;
    }

    // 행렬 곱셈을 계산합니다.
    private static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int rows = firstMatrix.length;
        int sharedDimension = firstMatrix[0].length;
        int columns = secondMatrix[0].length;
        int[][] product = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                for (int inner = 0; inner < sharedDimension; inner++) {
                    product[row][column] += firstMatrix[row][inner] * secondMatrix[inner][column];
                }
            }
        }

        return product;
    }

    // 행렬을 행 단위로 출력합니다.
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
