/**
 * [5-3 배열3] Jagged 배열 (행마다 길이가 다른 배열)
 *
 * 각 행의 차원이 다른 배열을 만들 수 있음. 이를 Jagged 배열이라고 부름.
 * 배열 변수를 선언하고 초기화시 일차원 배열의 크기를 달리한다.
 *
 *   jagged ──▶ [ ● ]──▶ [ 1 | 0 | 3 ]
 *              [ ● ]──▶ [ 6 | 9 ]
 *
 * 방법 1) int[][] jagged = { new int[] {1, 0, 3}, new int[] {6, 9} };
 * 방법 2) jagged = new int[2][];          // 2개의 행을 생성 (이 시점의 각 행은 null)
 *         jagged[0] = new int[]{1, 0, 3}; // 첫 번째 행 배열 객체 생성
 *         jagged[1] = new int[]{6, 9};    // 두 번째 행 배열 객체 생성
 *
 * 💡 열 크기만 비우는 것은 되지만 행 크기를 비우는 것은 안 된다 : new int[][3] ❌
 * 💡 new int[2][] 직후 jagged[0] 은 null. 각 행은 int[] "객체" 이기 때문 (5-1 레퍼런스형 배열과 같은 이야기)
 * 📝 필기 (퀴즈 7번) : int[][] data = new int [][] { {1,2,3}, {6,5}, {7,4,5,8} };
 *    자바에서는 들쭉날쭉한 2차원 배열 선언이 가능함.
 * 📝 필기 (퀴즈 8번) : data[r].length 라고 하면 r 행의 열의 크기를 알 수 있게 됨.
 *    → 안쪽 반복 조건을 array[i].length 로 쓰면 jagged 배열도 그대로 처리된다.
 *
 * 실행 예
 *  방법 1
 *  1 0 3
 *  6 9
 *  방법 2 (행 생성 직후 jagged[0] = null)
 *  1 0 3
 *  6 9
 */
public class JaggedArray {
    public static void main(String[] args) {
        System.out.println("방법 1");
        int[][] jagged = { new int[] {1, 0, 3}, new int[] {6, 9} };
        print(jagged);

        int [][] jagged2;
        jagged2 = new int[2][];               // 2개의 행을 생성
        System.out.println("방법 2 (행 생성 직후 jagged[0] = " + jagged2[0] + ")");
        jagged2[0] = new int[]{1, 0, 3};      // 첫 번째 행 배열 객체 생성
        jagged2[1] = new int[]{6, 9};         // 두 번째 행 배열 객체 생성
        print(jagged2);
    }

    static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {           // 행 개수
            for (int j = 0; j < array[i].length; j++) {    // i 행의 길이 (행마다 다름)
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
