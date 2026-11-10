/**
 * [5강 과제] 배열(2) - 3번 문제
 *
 * 3 × 4 행렬을 입력받아 전치 행렬(행과 열을 바꾼 행렬)을 출력하는 프로그램을 작성하시오.
 *
 *   (문제의 예시 화면)
 *   행렬 입력
 *   0번째 행 ? 1 2 3 0
 *   1번째 행 ? 4 5 6 1
 *   2번째 행 ? 7 8 9 0
 *   전치 행렬
 *   1 4 7
 *   2 5 8
 *   3 6 9
 *   0 1 0
 *
 * 📝 필기 (AI 설명) : 핵심은 딱 이 부분입니다
 *     transpose[col][row] = arr[row][col];
 *   예를 들어
 *     arr[0][0] → transpose[0][0]
 *     arr[0][1] → transpose[1][0]
 *     arr[0][2] → transpose[2][0]
 *     arr[0][3] → transpose[3][0]
 *   즉 원본의 [행][열] 을 전치 배열에서는 [열][행] 으로 뒤집어서 저장하는 것입니다.
 *   따라서 3×4 배열이 전치되면 4×3 배열이 됩니다.
 *
 *     원본 (3 × 4)            전치 (4 × 3)
 *     1  2  3  0              1  4  7
 *     4  5  6  1      →       2  5  8
 *     7  8  9  0              3  6  9
 *                             0  1  0
 *   → 원본의 0 번째 "행" 이 전치의 0 번째 "열" 이 된다.
 *
 * 포인트
 *  - 전치 배열의 크기는 [원본 열 수][원본 행 수] = new int[4][3]. 크기를 반대로 잡아야 한다.
 *    new int[3][4] 로 만들면 transpose[3][0] 에서 ArrayIndexOutOfBoundsException.
 *  - 출력은 "\t" (탭) 으로 칸을 맞춘다.
 *
 * ⚠ 문제는 행렬을 "입력받으라" 고 했는데(예시 화면의 "0번째 행 ?"), 내 코드는 배열을 코드에 직접 적었다.
 *   입력으로 바꾸려면 아래처럼 Scanner 로 채우면 된다.
 *     Scanner sc = new Scanner(System.in);
 *     int[][] arr = new int[3][4];
 *     System.out.println("행렬 입력");
 *     for (int row = 0; row < arr.length; row++) {
 *         System.out.print(row + "번째 행 ? ");
 *         for (int col = 0; col < arr[row].length; col++)
 *             arr[row][col] = sc.nextInt();
 *     }
 * 💡 new int[4][3] 의 4, 3 대신 new int[arr[0].length][arr.length] 로 쓰면 원본 크기가 바뀌어도 동작한다.
 *    (리팩터링 버전이 그렇게 했다.)
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
