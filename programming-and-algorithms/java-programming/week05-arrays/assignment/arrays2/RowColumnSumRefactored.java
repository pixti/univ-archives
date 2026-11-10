/**
 * [5강 과제] 배열(2) - 2번 문제 (리팩터링 버전)
 *
 * RowColumnSum.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점
 *  - 변수 이름 arr, sum → values, rowSum / columnSum
 *  - 반복 변수를 for 안에서 선언 (int row = 0 ...) : 쓰는 범위가 반복문 안으로 좁아진다.
 *  - 행 합계를 향상된 for(for-each) 로 : for (int value : values[row])
 *  - sum = sum + x → rowSum += x
 *  - 행마다 길이가 다른 배열(비정방형, jagged)도 처리
 *      1) 가장 긴 행의 길이를 columnCount 로 구한다 (Math.max)
 *      2) 열 합계를 구할 때 그 열이 없는 짧은 행은 건너뛴다 (column < rowValues.length)
 *    → 원래 코드는 arr[0].length 를 열의 수로 써서, 0 번 행보다 짧은 행이 있으면 예외가 난다.
 *
 * 💡 for (int[] rowValues : values) : 2 차원 배열을 for-each 로 돌면 꺼내지는 것은 "행(1차원 배열)" 이다.
 *    (5-3 강의 2 차원 배열 = 1 차원 배열의 배열)
 *
 * 실행 예
 *  1번째 행의 합계: 214
 *  2번째 행의 합계: 233
 *  3번째 행의 합계: 254
 *  1번째 열의 합계: 176
 *  2번째 열의 합계: 115
 *  3번째 열의 합계: 153
 *  4번째 열의 합계: 135
 *  5번째 열의 합계: 122
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
