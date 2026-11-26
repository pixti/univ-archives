/**
 * [5-3 배열3] Jagged 배열 (행마다 길이가 다른 배열)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
