/**
 * [5강 과제] 배열(2) - 3번 문제 (리팩터링 버전)
 *
 * Transpose.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점
 *  - 변수 이름 arr, transpose → originalMatrix, transposedMatrix
 *  - 전치 배열 크기를 숫자 4, 3 대신 원본에서 계산 : new int[columnCount][rowCount]
 *    rowCount == 0 ? 0 : originalMatrix[0].length  → 행이 하나도 없으면 [0] 에 접근하지 않는다. (조건 연산자)
 *  - 똑같이 두 번 쓰던 출력 반복문을 printMatrix(int[][]) 메소드 하나로 합침.
 *    printMatrix 는 for-each 로 행 → 값 순서로 출력.
 *
 * ⚠ 행마다 길이가 다른 배열(jagged)에서 0 번 행보다 긴 행이 있으면,
 *   columnCount 가 0 번 행 기준이라 transposedMatrix[column] 에서 ArrayIndexOutOfBoundsException 이 난다.
 *   (RowColumnSumRefactored 처럼 가장 긴 행의 길이를 구하면 해결. 단, 전치 행렬 자체가 직사각형 행렬을 전제한다.)
 * ⚠ 문제가 요구한 "행렬 입력" 은 리팩터링 버전에도 없다. (Transpose.java 의 ⚠ 참고)
 *
 * 실행 예
 *  원본 행렬
 *  1	2	3	0
 *  4	5	6	1
 *  7	8	9	0
 *
 *  전치 행렬
 *  1	4	7
 *  2	5	8
 *  3	6	9
 *  0	1	0
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
