/**
 * [7강 실습] 클래스(2) - 2번 문제 (Matrix 클래스 - 3x3 행렬의 합 · 차 · 전치 · 곱)   💡 참고 답안
 *
 * 문제
 *  3x3 행렬을 나타내는 Matrix 클래스를 만들어 아래 main 이 동작하도록 하시오.
 *      Matrix m1 = new Matrix(), m2 = new Matrix();
 *      int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
 *      int[][] arr2 = {{-1, -2, -3}, {4, 5, 6}, {-7, -8, -9}};
 *      m1.setData(arr1);  m2.setData(arr2);
 *      Matrix m3 = m1.add(m2);       System.out.println("두 행렬의 합");    System.out.println(m3);
 *      m3 = m1.subtract(m2);         System.out.println("두 행렬의 차");    System.out.println(m3);
 *      m3 = m1.transpose();          System.out.println("m1 행렬의 전치");  System.out.println(m3);
 *      m3 = m1.multiply(m2);         System.out.println("두 행렬의 곱");    System.out.println(m3);
 *
 * 💡 직접 풀지 않은 문제라서 참고 답안으로 작성했다.
 *
 * 포인트
 *  - add / subtract / transpose / multiply 는 모두 "새 Matrix 객체" 를 만들어 결과를 담아 돌려준다.
 *    (실습 클래스1 3번 Complex 의 add / sub 와 같은 방식) → m1, m2 는 바뀌지 않는다.
 *  - System.out.println(m3) 처럼 객체를 바로 출력하므로 toString() 을 오버라이딩해야 한다.
 *    (오버라이딩하지 않으면 Matrix@1b6d3586 같은 "클래스이름@해시코드" 가 출력된다)
 *  - 같은 클래스이므로 다른 객체(other)의 private 필드 other.data 에 직접 접근할 수 있다.
 *    (실습 클래스1 3번 📝 필기 : private 은 클래스 기준)
 *
 *  - 전치 (transpose) : 행과 열을 바꾼다.  result[i][j] = data[j][i]
 *        1 2 3        1 4 7
 *        4 5 6   →    2 5 8
 *        7 8 9        3 6 9
 *  - 곱 (multiply) : result[i][j] = Σ(k=0..2) data[i][k] * other[k][j]   (i 행 · j 열 내적)
 *        예) result[0][0] = 1*(-1) + 2*4 + 3*(-7) = -1 + 8 - 21 = -14
 *
 * 💡 setData 에서 배열을 그대로 대입(this.data = data)하면 main 의 arr1 과 같은 배열을 공유하게 된다.
 *    (8-4 배열 인수 : 레퍼런스가 전달됨) 그러면 main 에서 arr1 을 바꿀 때 m1 도 같이 바뀐다.
 *    그래서 값을 하나씩 복사해서 저장했다.
 * 💡 String 을 반복해서 + 하는 대신 StringBuilder 로 문자열을 만들었다. (6주차 6-3)
 *
 * 실행 결과
 *  두 행렬의 합
 *     0   0   0
 *     8  10  12
 *     0   0   0
 *  두 행렬의 차
 *     2   4   6
 *     0   0   0
 *    14  16  18
 *  m1 행렬의 전치
 *     1   4   7
 *     2   5   8
 *     3   6   9
 *  두 행렬의 곱
 *   -14 -16 -18
 *   -26 -31 -36
 *   -38 -46 -54
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
