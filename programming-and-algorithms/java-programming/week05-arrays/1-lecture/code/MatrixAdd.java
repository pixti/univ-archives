import java.util.Random;

/**
 * [5-3 배열3] [실습] 행렬 덧셈
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MatrixAdd {
    public static void main(String[] args) {
        int [][] m1 = new int[3][3];
        int [][] m2 = new int[3][3];
        int [][] m3 = new int[3][3];
        Random rnd = new Random();

        // 행렬 초기화
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m1[i][j] = rnd.nextInt(100);
                m2[i][j] = rnd.nextInt(100);
            }
        }

        // 행렬 덧셈
        for (int i = 0; i < m3.length; i++) {
            for (int j = 0; j < m3[i].length; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }

        // m1 행렬 출력
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                System.out.print(m1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // m2 행렬 출력
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                System.out.print(m2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("================");

        // m3 행렬 출력
        for (int i = 0; i < m3.length; i++) {
            for (int j = 0; j < m3[i].length; j++) {
                System.out.print(m3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
