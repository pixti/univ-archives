import java.util.Arrays;

/**
 * [5-3 배열3] 배열 복사 : 레퍼런스 복사(공유) vs clone() (복사) + 2차원 배열의 clone
 *
 * 1) int[] myArray2 = myArray1;
 *    배열 변수에 저장된 레퍼런스가 복사되어 배열 객체를 공유한다.
 *
 *      myArray1 ──┐
 *                 ├──▶ [ 1 | 0 | 3 ]     배열 객체는 1개
 *      myArray2 ──┘
 *
 * 2) int[] myArray2 = myArray1.clone();
 *    배열 자체를 복사하고 싶으면 배열 객체의 clone 메소드를 사용한다.
 *
 *      myArray1 ──▶ [ 1 | 2 | 3 ]     원본 그대로
 *      myArray2 ──▶ [ 1 | 0 | 3 ]     새로 만들어진 복사본
 *
 * 📝 필기 (퀴즈 5번)
 *    myarray1 -> 레퍼런스 1 (3,1,2,3)
 *    .clone() 하면 myarray2 -> 레퍼런스 2 (3,1,2,3)
 *    값을 바꾸면 myarray2 -> 레퍼런스 2 (3,0,2,3) / myarray1 -> 레퍼런스 1 (3,1,2,3) 값은 유지됨
 *    int[] myarray2 = myarray1; 로 하면 myarray1 -> 레퍼런스 1, myarray2 -> 레퍼런스 1 이 되게 됨.
 *    따라서 값을 바꾸면 둘 다 레퍼런스 1 (3,0,2,3)
 *
 * 3) 2차원 배열의 clone() : 행 배열만 복사되고 각 행은 공유된다. (얕은 복사)
 *
 *      myArray2d ──▶ [ ● ]──▶ [ 1 | 0 | 3  ] ◀──[ ● ] ◀── myArray2d2
 *                    [ ● ]──▶ [ 6 | 9 | 12 ] ◀──[ ● ]
 *
 *    원소까지 복사하려면 각 행도 일일이 clone 해 주어야 한다. (깊은 복사)
 *
 * 💡 clone() 이 복사하는 것은 "원소 값". 2차원 배열에서 바깥 배열의 원소 값은 각 행의 레퍼런스다.
 *    그래서 레퍼런스만 복사되고 행은 공유된다.
 * 💡 반대로 행 자체를 새 배열로 바꾸면(myArray2d2[1] = ...) 원본은 영향을 받지 않는다.
 *
 * 실행 예
 *  === 1) 레퍼런스 복사 ===
 *  0
 *  === 2) clone ===
 *  2
 *  === 3) 2차원 배열 clone ===
 *  clone 후 myArray2d2[0][1] = 100 → myArray2d[0][1] = 100
 *  clone 후 myArray2d2[1] = {7,7,7} → myArray2d[1] = [6, 9, 12]
 *  행마다 clone 후 deep[0][1] = -1 → myArray2d[0][1] = 100
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
