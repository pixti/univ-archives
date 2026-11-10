import java.util.Random;

/**
 * [5-3 배열3] [실습] 행렬 덧셈
 *
 * 3 × 3 행렬 두 개를 0 ~ 99 난수로 채우고 더한다.
 *
 * 포인트
 *  - 행렬 덧셈은 같은 위치끼리 더한다 : m3[i][j] = m1[i][j] + m2[i][j]   (예 : 31 + 18 = 49)
 *  - rnd.nextInt(100) : 0 이상 100 미만 (0 ~ 99)
 *  - 초기화 · 덧셈 · 출력 모두 "바깥 for = 행, 안쪽 for = 열" 의 이중 for.
 *
 * 💡 같은 "행렬 출력" 코드가 세 번 반복된다. 메소드로 빼면 printMatrix(m1); 처럼 한 줄로 줄일 수 있다.
 *    (과제 배열(2) 3 · 4 번의 리팩터링 코드가 그렇게 했다.)
 * 💡 행렬 곱셈은 같은 위치끼리 곱하는 것이 아니다. → assignment/arrays2/MatrixMultiply.java
 *
 * 실행 예  (슬라이드 화면, 난수라 매번 다름)
 *  31 99 99
 *  84 64 97
 *  17 73 35
 *
 *  18 83 23
 *  86 48 22
 *  51 46 22
 *  ================
 *  49 182 122
 *  170 112 119
 *  68 119 57
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
