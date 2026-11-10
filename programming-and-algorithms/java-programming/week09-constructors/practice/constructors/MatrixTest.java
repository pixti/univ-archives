/**
 * [9강 실습] 생성자 - 5번 문제 (Matrix 클래스 - 생성자로 행렬 만들기, 합 · 차 · 전치 · 곱)
 *
 * 문제 (요약)
 *  2차원 배열 data 와 행 수(rows), 열 수(cols)를 필드로 가지는 Matrix 클래스를 작성하시오.
 *  - Matrix(int rows, int cols, int initVal) : rows x cols 크기를 만들고 모든 칸을 initVal 로 채운다.
 *  - Matrix(int[][] arr)                     : 2차원 배열을 받아 같은 내용의 행렬을 만든다.
 *  - add, subtract, transpose, multiply 메소드와 getRows, getCols, getAt(i, j) 를 둔다.
 *  - 행렬을 출력할 수 있도록 toString() 을 재정의한다.
 *
 * 포인트
 *  - 7강 실습 클래스(2) 2번(practice/classes2/MatrixTest.java, 3x3 고정)을 생성자로 크기를 정할 수 있게 확장한 문제.
 *  - 생성자 오버로딩 : (크기 + 초기값) / (배열) 두 가지 방법으로 행렬을 만든다.
 *  - 연산 결과는 원래 행렬을 바꾸지 않고 "새 Matrix 객체"를 만들어 돌려준다. (9-1 LocalDateTime 의 불변 객체와 같은 방식)
 *
 * 📝 필기 (내 코드 주석)
 *  - Matrix(int[][] arr) : 외부에서 전달된 배열(arr)의 값이 나중에 바뀌더라도 Matrix 내부의 데이터는
 *    안전하게 유지되도록 값을 하나씩 복사(깊은 복사)한다.
 *  - 행렬의 곱셈 : 앞 행렬의 열 개수와 뒤 행렬의 행 개수가 같을 때 수행 가능.
 *    결과 행렬의 크기는 (앞 행렬의 행 개수) x (뒤 행렬의 열 개수).
 *  - toString() : 객체를 System.out.println() 으로 출력할 때 어떤 문자열 형태로 보여줄지 정의.
 *  - println(m3) : 재정의된 toString() 이 자동으로 호출되어 행렬 형태로 출력.
 *  - 곱셈 결과는 toString() 을 사용하지 않고 직접 getAt() 메서드를 이용해 원소를 하나씩 가져와 출력.
 *
 * 💡 깊은 복사 vs 얕은 복사
 *      this.data = arr;                 // 얕은 복사 : 같은 배열을 가리킴 → 밖에서 arr[0][0] = 99 하면 행렬도 바뀜
 *      this.data[i][j] = arr[i][j];     // 깊은 복사 : 새 배열에 값만 복사 → 행렬은 안전
 *    main 마지막의 💡 부분에서 arr1 을 바꿔도 m1 이 그대로인 것을 확인했다.
 * 💡 add / subtract 는 두 행렬의 크기가, multiply 는 this.cols == other.rows 가 맞아야 한다.
 *    문제에서는 검사하지 않았지만 크기가 다르면 ArrayIndexOutOfBoundsException 이 날 수 있다.
 * 💡 원래 이클립스에서 TestMain 클래스로 작성한 코드. MatrixTest 로 이름을 바꿨다.
 *
 * 실행 결과
 *  두 행렬의 합 : 3x2
 *  1 2
 *  4 5
 *  7 8
 *
 *  두 행렬의 차:
 *  -1 -2
 *  -4 -5
 *  -7 -8
 *
 *  m0 행렬의 전치:
 *  0 0 0
 *  0 0 0
 *
 *  두 행렬의 곱:
 *  7 8 9
 *  16 17 18
 *  25 26 27
 *  💡 arr1[0][0] = 99 로 바꾼 뒤 m1.getAt(0, 0) = 1
 */
public class MatrixTest {
    public static void main(String[] args) {
        Matrix m0 = new Matrix(3, 2, 0);
        int[][] arr1 = { { 1, 2 }, { 4, 5 }, { 7, 8 } };
        int[][] arr2 = { { -1, -2, -3 }, { 4, 5, 6 } };
        Matrix m1 = new Matrix(arr1);
        Matrix m2 = new Matrix(arr2);

        Matrix m3 = m0.add(m1);
        System.out.println("두 행렬의 합 : " + m3.getRows() + "x" + m3.getCols());
        System.out.println(m3);      // 재정의된 toString()이 자동으로 호출되어 행렬 형태 출력

        Matrix m4 = m0.subtract(m1);
        System.out.println("두 행렬의 차: ");
        System.out.println(m4);

        Matrix m5 = m0.transpose();  // 3x2 → 2x3
        System.out.println("m0 행렬의 전치: ");
        System.out.println(m5);

        Matrix m6 = m1.multiply(m2); // (3x2) x (2x3) = 3x3
        System.out.println("두 행렬의 곱: ");
        // toString()을 사용하지 않고 직접 getAt() 메서드를 이용해 원소를 하나씩 가져와 출력
        for (int i = 0; i < m6.getRows(); i++) {
            for (int j = 0; j < m6.getCols(); j++) {
                System.out.print(m6.getAt(i, j) + " ");
            }
            System.out.println();
        }

        // 💡 깊은 복사 확인
        arr1[0][0] = 99;
        System.out.println("💡 arr1[0][0] = 99 로 바꾼 뒤 m1.getAt(0, 0) = " + m1.getAt(0, 0));
    }
}

class Matrix {
    private int[][] data;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols, int initVal) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];        // 지정된 크기만큼 2차원 배열 할당
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = initVal;      // 모든 칸을 initVal로 채움
            }
        }
    }

    public Matrix(int[][] arr) {
        this.rows = arr.length;
        this.cols = arr[0].length;
        this.data = new int[rows][cols];
        // 외부에서 전달된 배열(arr)의 값이 나중에 바뀌더라도 Matrix 내부의 데이터는
        // 안전하게 유지되도록 값을 하나씩 복사(깊은 복사)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = arr[i][j];
            }
        }
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }

    // 특정 위치(i행, j열)의 값을 반환
    public int getAt(int i, int j) {
        return data[i][j];
    }

    public Matrix add(Matrix other) {
        Matrix result = new Matrix(rows, cols, 0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];   // 💡 private 이지만 같은 클래스라 접근 가능
            }
        }
        return result;
    }

    public Matrix subtract(Matrix other) {
        Matrix result = new Matrix(rows, cols, 0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return result;
    }

    public Matrix transpose() {
        Matrix result = new Matrix(cols, rows, 0);   // 행과 열의 크기가 뒤바뀜
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[j][i] = this.data[i][j];
            }
        }
        return result;
    }

    // 행렬의 곱셈: 앞 행렬의 열 개수와 뒤 행렬의 행 개수가 같을 때 수행 가능
    public Matrix multiply(Matrix other) {
        // 결과 행렬의 크기는 (앞 행렬의 행 개수) x (뒤 행렬의 열 개수)
        Matrix result = new Matrix(this.rows, other.cols, 0);   // 결과를 담을 새 행렬
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return result;   // 계산된 새 행렬 객체를 반환
    }

    // 객체를 System.out.println()으로 출력할 때 어떤 문자열 형태로 보여줄지 정의
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(data[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
