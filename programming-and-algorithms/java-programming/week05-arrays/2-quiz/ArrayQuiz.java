/**
 * [5강 퀴즈] 배열
 * 문제 · 정답 · 필기 → README.md
 */
public class ArrayQuiz {
    public static void main(String[] args) {
        System.out.println("===== 1-① =====");   q1_1();
        System.out.println("===== 1-② =====");   q1_2();
        System.out.println("===== 1-③ =====");   q1_3();
        System.out.println("===== 2 =====");     q2();
        System.out.println("===== 3 =====");     q3();
        System.out.println("===== 4 =====");     q4();
        System.out.println("===== 5 =====");     q5();
        System.out.println("===== 6 =====");     q6();
        System.out.println("===== 7 =====");     q7();
        System.out.println("===== 8 =====");     q8();
    }

    // 1-①  int test = new int[]{1,2,3,4,5};
    static void q1_1() {
        // int test = new int[]{1, 2, 3, 4, 5};   // ❌ 컴파일 오류
        int[] test = new int[]{1, 2, 3, 4, 5};    // ✅
        System.out.println(java.util.Arrays.toString(test));
    }

    // 1-②  char [] symbol = {"h","o","u"};
    static void q1_2() {
        // char [] symbol = {"h", "o", "u"};     // ❌ String 을 char 칸에 넣을 수 없음
        String[] symbol1 = {"h", "o", "u"};      // ✅ 방법 1 : 배열 타입을 String[] 로
        char [] symbol2 = {'h', 'o', 'u'};       // ✅ 방법 2 : 원소를 char 로
        System.out.println(java.util.Arrays.toString(symbol1) + " / " + java.util.Arrays.toString(symbol2));
    }

    // 1-③  double [] data = new double[5]{1.0,2.0,3.0,4.0,5.0};
    static void q1_3() {
        // double [] data = new double[5]{1.0, 2.0, 3.0, 4.0, 5.0};   // ❌ 컴파일 오류
        double [] data = new double[]{1.0, 2.0, 3.0, 4.0, 5.0};       // ✅
        System.out.println(java.util.Arrays.toString(data));
    }

    // 2.  int[] test = new int[10];  for (int i = 1; i <= 10; i++) test[i] = 0;
    static void q2() {
        int[] test = new int[10];
        try {
            for (int i = 1; i <= 10; i++) test[i] = 0;   // ❌ 틀린 코드
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("틀린 코드 → " + e);
        }

        for (int i = 0; i < test.length; i++) test[i] = 0;   // ✅ 고친 코드
        System.out.println("고친 코드 → " + java.util.Arrays.toString(test));
    }

    // 3.  char[] array = {'h','o','u','s','e'};  for (int i = 0; i <= array.length; i++) print(array[i] + " ");
    static void q3() {
        char[] array = new char[]{'h', 'o', 'u', 's', 'e'};
        try {
            for (int i = 0; i <= array.length; i++) System.out.print(array[i] + " ");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println();
            System.out.println("→ " + e);
        }
    }

    // 4.  int[] myArray1 = new int[]{3,1,2,3};
    static void q4() {
        int[] myArray1 = new int[]{3, 1, 2, 3};
        int[] myArray2 = myArray1.clone();
        myArray2[1] = 0;
        System.out.println("왼쪽 (clone)  : " + myArray1[1]);

        myArray1 = new int[]{3, 1, 2, 3};
        myArray2 = myArray1;
        myArray2[1] = 0;
        System.out.println("오른쪽 (대입) : " + myArray1[1]);
    }

    // 5. 4번과 같은 결과가 나오는 이유
    static void q5() {
        int[] myArray1 = new int[]{3, 1, 2, 3};
        int[] cloned = myArray1.clone();
        int[] assigned = myArray1;
        System.out.println("clone : myArray1 == myArray2 ? " + (myArray1 == cloned));
        System.out.println("대입  : myArray1 == myArray2 ? " + (myArray1 == assigned));
    }

    // 6. 다음 값을 가지는 2x3 int 형 배열 data 를 생성  (1 2 3 / 6 5 4 / 7 4 5)
    static void q6() {
        int [][] data = new int[][] { {1, 2, 3}, {6, 5, 4}, {7, 4, 5} };
        print(data);
    }

    // 7. 다음 값을 가지는 2 차원 int 형 배열 data 를 생성  (1 2 3 / 6 5 / 7 4 5 8)
    static void q7() {
        int[][] data = new int [][] { {1, 2, 3}, {6, 5}, {7, 4, 5, 8} };
        print(data);
    }

    // 8. 7번에서 만든 배열의 각 행의 원소 개수를 for 문을 사용하여 출력
    static void q8() {
        int[][] data = new int [][] { {1, 2, 3}, {6, 5}, {7, 4, 5, 8} };

        // 각 행의 원소 개수 (문제의 요구)
        for (int r = 0; r < data.length; r++) {
            System.out.println(r + "행의 원소 개수 : " + data[r].length);
        }

        // 📝 필기 코드 : 전체 원소 개수
        int count = 0;
        for (int r = 0; r < data.length; r++) {        // 행 반복
            for (int c = 0; c < data[r].length; c++) { // 열 반복
                count++;
            }
        }
        System.out.println("전체 원소 개수 : " + count);
    }

    /** 2차원 배열 출력 (행마다 길이가 달라도 됨) */
    static void print(int[][] data) {
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                System.out.print(data[r][c] + (c < data[r].length - 1 ? " " : ""));
            }
            System.out.println();
        }
    }
}
