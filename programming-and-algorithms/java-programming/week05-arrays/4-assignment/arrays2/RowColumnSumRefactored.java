/**
 * [5강 과제] 배열(2) - 2번 문제 (리팩터링 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class RowColumnSumRefactored {
    public static void main(String[] args) {
        int[][] values = {
                {12, 56, 32, 16, 98},
                {99, 56, 34, 41, 3},
                {65, 3, 87, 78, 21}
        };

        // 각 행의 합계를 계산합니다.
        for (int row = 0; row < values.length; row++) {
            int rowSum = 0;
            for (int value : values[row]) {
                rowSum += value;
            }
            System.out.println((row + 1) + "번째 행의 합계: " + rowSum);
        }

        // 가장 긴 행의 길이를 구합니다.
        // Java의 2차원 배열은 행마다 길이가 다를 수 있습니다.
        int columnCount = 0;
        for (int[] rowValues : values) {
            columnCount = Math.max(columnCount, rowValues.length);
        }

        // 각 열의 합계를 계산합니다. 해당 열이 없는 행은 건너뜁니다.
        for (int column = 0; column < columnCount; column++) {
            int columnSum = 0;
            for (int[] rowValues : values) {
                if (column < rowValues.length) {
                    columnSum += rowValues[column];
                }
            }
            System.out.println((column + 1) + "번째 열의 합계: " + columnSum);
        }
    }
}
