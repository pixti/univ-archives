import java.util.Arrays;

/**
 * [5-3 배열3] 배열 복사 : 레퍼런스 복사(공유) vs clone() (복사) + 2차원 배열의 clone
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ArrayCopy {
    public static void main(String[] args) {
        System.out.println("=== 1) 레퍼런스 복사 ===");
        {
            int[] myArray1 = new int[] {1, 2, 3};
            int[] myArray2 = myArray1;   // 레퍼런스가 복사되어 배열 공유
            myArray2[1] = 0;
            System.out.println(myArray1[1]);
        }

        System.out.println("=== 2) clone ===");
        {
            int[] myArray1 = new int[] {1, 2, 3};
            int[] myArray2 = myArray1.clone();
            myArray2[1] = 0;
            System.out.println(myArray1[1]);
        }

        System.out.println("=== 3) 2차원 배열 clone ===");
        int[][] myArray2d = new int[][] { {1, 0, 3}, {6, 9, 12} };
        int[][] myArray2d2 = myArray2d.clone();

        myArray2d2[0][1] = 100;          // 행은 공유 → 원본도 바뀜
        System.out.println("clone 후 myArray2d2[0][1] = 100 → myArray2d[0][1] = " + myArray2d[0][1]);

        myArray2d2[1] = new int[] {7, 7, 7};   // 행 배열은 따로 복사됨 → 원본은 그대로
        System.out.println("clone 후 myArray2d2[1] = {7,7,7} → myArray2d[1] = " + Arrays.toString(myArray2d[1]));

        // 원소까지 복사 : 행마다 clone
        int[][] deep = new int[myArray2d.length][];
        for (int i = 0; i < myArray2d.length; i++)
            deep[i] = myArray2d[i].clone();
        deep[0][1] = -1;
        System.out.println("행마다 clone 후 deep[0][1] = -1 → myArray2d[0][1] = " + myArray2d[0][1]);
    }
}
