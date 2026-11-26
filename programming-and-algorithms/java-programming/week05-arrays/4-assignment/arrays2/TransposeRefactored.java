/**
 * [5강 과제] 배열(2) - 3번 문제 (리팩터링 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class TransposeRefactored {
    public static void main(String[] args) {
        int[][] originalMatrix = {
                {1, 2, 3, 0},
                {4, 5, 6, 1},
                {7, 8, 9, 0}
        };

        // 전치 행렬은 원본 행렬의 행과 열 수를 바꿔 생성합니다.
        int rowCount = originalMatrix.length;
        int columnCount = rowCount == 0 ? 0 : originalMatrix[0].length;
        int[][] transposedMatrix = new int[columnCount][rowCount];

        // 원본의 각 원소를 행과 열을 바꾼 위치에 저장합니다.
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < originalMatrix[row].length; column++) {
                transposedMatrix[column][row] = originalMatrix[row][column];
            }
        }

        System.out.println("원본 행렬");
        printMatrix(originalMatrix);

        System.out.println();
        System.out.println("전치 행렬");
        printMatrix(transposedMatrix);
    }

    // 행렬의 각 행을 한 줄씩 출력합니다.
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
