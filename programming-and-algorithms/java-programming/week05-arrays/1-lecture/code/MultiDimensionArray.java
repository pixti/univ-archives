/**
 * [5-3 배열3] 다차원 배열 선언 · 생성 · 접근 + 자바의 다차원 배열 구조
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
