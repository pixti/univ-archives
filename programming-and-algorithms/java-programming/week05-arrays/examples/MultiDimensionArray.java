/**
 * [5-3 배열3] 다차원 배열 선언 · 생성 · 접근 + 자바의 다차원 배열 구조
 *
 * 일차원 배열과 사용법은 동일하며 차원만 늘리면 된다.
 *
 * 자바에서 다차원 배열은 일차원 배열을 이용하여 구현한다.
 * 행 개수 크기의 1차원 배열이 생성되고, 그 원소에는 각 행에 해당하는 1차원 배열의 레퍼런스가 저장된다.
 *
 *   myArray2d ──▶ [ ● ]──▶ [ 1 | 0 | 3  ]   ← 0행 (int[])
 *                 [ ● ]──▶ [ 6 | 9 | 12 ]   ← 1행 (int[])
 *
 *   myArray2d.length    = 2  (행 개수)
 *   myArray2d[0]        = 0행 전체 (int[])
 *   myArray2d[0].length = 3  (0행의 열 개수)
 *
 * 📝 필기 (퀴즈 6번)
 *   2차원 배열은 자바에서는 1차원 배열의 레퍼런스를 값으로 가지는 배열을 가지는 구조임.
 *   플렉서블하지만 느림. int[] 가 1차원 배열 [] 를 가리킴 → int[][] 로 선언하는 것임.
 *   자바에서는 들쭉날쭉하게 열의 개수가 행마다 다르게 선언이 가능함.
 *   C 에서는 1차원 배열이 연속적으로 나열된 구조임. 속도는 월등히 빠름. 열의 개수가 행마다 달라서는 안 됨.
 *   💡 보충 : C 도 정방행렬만 되는 것은 아니고, 모든 행 길이가 같은 직사각형(R × C)이면 된다.
 *
 * 💡 myArray3d 는 2 × 3 × 2 = 12 칸, 모두 기본값 0 → x = 0 + 0 = 0
 *
 * 실행 예
 *  x = 0
 *  myArray2d.length = 2
 *  myArray2d[0].length = 3
 *  myArray3d : 2 x 3 x 2
 *  myArray2d[1] 의 타입 : int[]  → 6 9 12
 */
public class MultiDimensionArray {
    public static void main(String[] args) {
        // 2차원 배열 변수 선언
        int [][] myArray2d;

        // 2차원 배열 객체 생성 및 초기화
        myArray2d = new int[][] { {1, 0, 3}, {6, 9, 12} };

        // 3차원 배열 변수 선언 및 배열 객체 생성
        int [][][] myArray3d = new int[2][3][2];

        // 2차원 및 3차원 배열 객체 접근
        int x = myArray3d[1][2][0] + myArray2d[0][1];
        System.out.println("x = " + x);

        System.out.println("myArray2d.length = " + myArray2d.length);         // 행 개수
        System.out.println("myArray2d[0].length = " + myArray2d[0].length);   // 0행의 열 개수
        System.out.println("myArray3d : " + myArray3d.length + " x "
                + myArray3d[0].length + " x " + myArray3d[0][0].length);

        int[] row1 = myArray2d[1];   // 한 행 = 1차원 배열 하나
        System.out.print("myArray2d[1] 의 타입 : int[]  → ");
        for (int e : row1) System.out.print(e + " ");
        System.out.println();
    }
}
