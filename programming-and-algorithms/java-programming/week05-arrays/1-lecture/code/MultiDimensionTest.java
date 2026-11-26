/**
 * [5-3 배열3] 다차원 배열 출력 : array.length 와 array[i].length
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MultiDimensionTest {
    public static void main(String[] args) {
        int[][] array = {{62, 17, 4, 64}, {18, 96, 29, 5}, {6, 3, 6, 5}};

        for (int i = 0; i < array.length; i++) {            // 다차원 배열의 행 개수
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {     // i 행의 1차원 배열 크기
                System.out.print(array[i][j] + " ");
            }
        }
        System.out.println();
    }
}
