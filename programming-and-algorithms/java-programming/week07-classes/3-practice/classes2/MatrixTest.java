/**
 * [7강 실습] 클래스(2) - 2번 문제 (Matrix 클래스 - 3x3 행렬의 합 · 차 · 전치 · 곱)   💡 참고 답안
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MatrixTest {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(), m2 = new Matrix();
        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr2 = {{-1, -2, -3}, {4, 5, 6}, {-7, -8, -9}};
        m1.setData(arr1);
        m2.setData(arr2);

        Matrix m3 = m1.add(m2);
        System.out.println("두 행렬의 합");
        System.out.println(m3);

        m3 = m1.subtract(m2);
        System.out.println("두 행렬의 차");
        System.out.println(m3);

        m3 = m1.transpose();
        System.out.println("m1 행렬의 전치");
        System.out.println(m3);

        m3 = m1.multiply(m2);
        System.out.println("두 행렬의 곱");
        System.out.println(m3);
    }
}

class Matrix {
    private static final int N = 3;          // 3x3
    private int[][] data = new int[N][N];

    public int[][] getData() { return data; }

    public void setData(int[][] data) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                this.data[i][j] = data[i][j];      // 값 복사 (배열 공유 방지)
            }
        }
    }

    public Matrix add(Matrix other) {
        Matrix result = new Matrix();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    public Matrix subtract(Matrix other) {
        Matrix result = new Matrix();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result.data[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return result;
    }

    public Matrix transpose() {
        Matrix result = new Matrix();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result.data[i][j] = this.data[j][i];     // 행 ↔ 열
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        Matrix result = new Matrix();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(String.format("%4d", data[i][j]));    // 4칸 오른쪽 정렬
            }
            if (i < N - 1) sb.append("\n");                      // 마지막 줄 뒤에는 줄바꿈 X (println 이 해줌)
        }
        return sb.toString();
    }
}
