/**
 * [5-3 배열3] 다차원 배열 출력 : array.length 와 array[i].length
 *
 * 포인트
 *  - 바깥 for : 행  (array.length    = 3)
 *  - 안쪽 for : 열  (array[i].length = 4)
 *  - 안쪽 조건을 4 나 array[0].length 가 아니라 array[i].length 로 쓰면 jagged 배열도 그대로 출력된다.
 *
 * 📝 필기 (실습 배열(2) 6번, AI 설명) : 바깥쪽 i 는 행(row)을 담당하고, 안쪽 j 는 열(column)을 담당합니다.
 *    여기서 중요한 것은 for 문을 두 개 사용하는 것입니다.
 *
 * 💡 줄바꿈을 행 출력 "앞" 에 하므로 첫 줄이 빈 줄이고, 마지막에 println() 을 한 번 더 한다.
 *    보통은 안쪽 for "뒤" 에 println() 을 두는 형태(MatrixAdd)를 더 많이 쓴다.
 *
 * 실행 예
 *
 *  62 17 4 64
 *  18 96 29 5
 *  6 3 6 5
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
