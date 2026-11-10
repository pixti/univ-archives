/**
 * [5강 퀴즈] 배열
 *
 * 1. 다음 문장에서 잘못된 부분을 찾아 수정하시오.                        → q1_1() ~ q1_3()
 *      ① int test = new int[]{1,2,3,4,5};
 *      ② char [] symbol = {"h","o","u"};
 *      ③ double [] data = new double[5]{1.0,2.0,3.0,4.0,5.0};
 * 2. 다음 코드에서 잘못된 부분을 찾아 수정하시오.                        → q2()
 *      int[] test = new int[10];
 *      for (int i = 1; i <= 10; i++) test[i] = 0;
 * 3. 다음 코드의 출력 결과를 쓰고 그 이유를 설명하시오.                  → q3()
 *      char[] array = new char[]{'h','o','u','s','e'};
 *      for (int i = 0; i <= array.length; i++) System.out.print(array[i] + " ");
 * 4. int[] myArray1 = new int[]{3,1,2,3}; 일 때 표의 각 코드의 출력 결과를 쓰시오. → q4()
 *        (왼쪽)  myArray2 = myArray1.clone();  myArray2[1] = 0;  System.out.println(myArray1[1]);
 *        (오른쪽) myArray2 = myArray1;          myArray2[1] = 0;  System.out.println(myArray1[1]);
 * 5. 4번과 같은 결과가 나오는 이유를 설명하시오.                          → q5()
 * 6. 다음 값을 가지는 2x3 int 형 배열 data 를 생성하시오.                → q6()
 *      1 2 3 / 6 5 4 / 7 4 5
 * 7. 다음 값을 가지는 2 차원 int 형 배열 data 를 생성하시오.            → q7()
 *      1 2 3 / 6 5 / 7 4 5 8
 * 8. 7번에서 만든 배열의 각 행의 원소 개수를 for 문을 사용하여 출력하시오. → q8()
 *
 * 채점 결과 (📝 필기)
 *   1 ~ 3  필기로 정리      4  오답 (왼쪽 · 오른쪽 답을 반대로 씀)      5  오답 (clone 과 대입을 반대로 이해)
 *   6 ~ 8  필기로 정리
 *
 * 실행 결과
 *  ===== 1-① =====
 *  [1, 2, 3, 4, 5]
 *  ===== 1-② =====
 *  [h, o, u] / [h, o, u]
 *  ===== 1-③ =====
 *  [1.0, 2.0, 3.0, 4.0, 5.0]
 *  ===== 2 =====
 *  원래 코드 → java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
 *  수정 코드 → [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
 *  ===== 3 =====
 *  h o u s e
 *  → java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
 *  ===== 4 =====
 *  왼쪽 (clone)  : 1
 *  오른쪽 (대입) : 0
 *  ===== 5 =====
 *  clone : myArray1 == myArray2 ? false
 *  대입  : myArray1 == myArray2 ? true
 *  ===== 6 =====
 *  1 2 3
 *  6 5 4
 *  7 4 5
 *  ===== 7 =====
 *  1 2 3
 *  6 5
 *  7 4 5 8
 *  ===== 8 =====
 *  0행의 원소 개수 : 3
 *  1행의 원소 개수 : 2
 *  2행의 원소 개수 : 4
 *  전체 원소 개수 : 9
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

    /**
     * 1-①  int test = new int[]{1,2,3,4,5};
     *
     * 📝 필기 : int 는 숫자값 타입이고, int[] 는 인트배열객체 타입임. 타입이 안 맞음.
     *          int[] test = new int[]{1,2,3,4,5}; 로 선언해야 함.
     *
     * 💡 컴파일 오류 메시지 : incompatible types: int[] cannot be converted to int
     */
    static void q1_1() {
        // int test = new int[]{1, 2, 3, 4, 5};   // ❌ 컴파일 오류
        int[] test = new int[]{1, 2, 3, 4, 5};    // ✅
        System.out.println(java.util.Arrays.toString(test));
    }

    /**
     * 1-②  char [] symbol = {"h","o","u"};
     *
     * 📝 필기 : String[] symbol = {"h","o","u"}; 로 하던지 char [] symbol = {'h','o','u'}; 로 해야 함.
     *
     * 💡 큰따옴표 "h" 는 문자열(String), 작은따옴표 'h' 는 문자(char). (2주차 자료형)
     *    배열의 타입과 원소의 타입이 같아야 한다.
     */
    static void q1_2() {
        // char [] symbol = {"h", "o", "u"};     // ❌ String 을 char 칸에 넣을 수 없음
        String[] symbol1 = {"h", "o", "u"};      // ✅ 방법 1 : 배열 타입을 String[] 로
        char [] symbol2 = {'h', 'o', 'u'};       // ✅ 방법 2 : 원소를 char 로
        System.out.println(java.util.Arrays.toString(symbol1) + " / " + java.util.Arrays.toString(symbol2));
    }

    /**
     * 1-③  double [] data = new double[5]{1.0,2.0,3.0,4.0,5.0};
     *
     * 📝 필기 : 값을 초기화하지 않는 경우에는 double [] data = new double[5]; 처럼 개수를 지정해도 되지만
     *          double [] data = new double[]{1.0, 2.0, 3.0, 4.0, 5.0}; 처럼 값을 지정한 경우에는
     *          반드시 개수를 지정해서는 안 됨.
     *
     * 💡 크기는 초기화 값의 개수로 자동으로 정해진다. (5-1 강의 "명시적으로 기술할 경우 컴파일 오류")
     *    축약형 double [] data = {1.0, 2.0, 3.0, 4.0, 5.0}; 도 가능.
     */
    static void q1_3() {
        // double [] data = new double[5]{1.0, 2.0, 3.0, 4.0, 5.0};   // ❌ 컴파일 오류
        double [] data = new double[]{1.0, 2.0, 3.0, 4.0, 5.0};       // ✅
        System.out.println(java.util.Arrays.toString(data));
    }

    /**
     * 2.  int[] test = new int[10];  for (int i = 1; i <= 10; i++) test[i] = 0;
     *
     * 📝 필기 : for (int i = 0; i < 10; i++) 또는 for (int i = 0; i <= 9; i++) 로 수정해야 함.
     *          index 는 0 ~ array.length-1 까지.
     *
     * 💡 원래 코드는 두 가지가 틀렸다.
     *    - i = 1 부터 시작 → test[0] 을 건너뛴다. (값이 0 이라 티는 안 나지만 의도와 다름)
     *    - i <= 10        → test[10] 에서 ArrayIndexOutOfBoundsException.
     * 💡 숫자 10 대신 test.length 를 쓰면 배열 크기가 바뀌어도 고칠 곳이 없다.
     *      for (int i = 0; i < test.length; i++)
     * 💡 new int[10] 은 이미 0 으로 채워져 있어서, 사실 이 반복문 자체가 필요 없다.
     */
    static void q2() {
        int[] test = new int[10];
        try {
            for (int i = 1; i <= 10; i++) test[i] = 0;   // ❌ 원래 코드
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("원래 코드 → " + e);
        }

        for (int i = 0; i < test.length; i++) test[i] = 0;   // ✅ 수정 코드
        System.out.println("수정 코드 → " + java.util.Arrays.toString(test));
    }

    /**
     * 3.  char[] array = {'h','o','u','s','e'};  for (int i = 0; i <= array.length; i++) print(array[i] + " ");
     *
     * 내 답안 : 출력은 h(공백)o(공백)u(공백)s(공백)e(공백) 되다가 i=5 에서 에러가 날 것임.
     *          배열의 index 는 array.length-1 까지임. 따라서
     *          for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
     *          로 고쳐야 하는 것임. 그래야 i 가 0 에서 4 까지, 그러니까 배열 끝까지만 순회 후 종료됨.
     * 📝 필기 : outOfRange 에러가 날 것임.
     *
     * 💡 정확한 이름은 ArrayIndexOutOfBoundsException (실행 중 예외).
     *    컴파일은 된다. 인덱스 값은 실행해 봐야 알 수 있기 때문이다.
     * 💡 예외가 나기 전까지 찍힌 "h o u s e " 는 이미 화면에 출력된 상태로 남는다.
     * 💡 char + String → String 이라 'h' + " " 는 "h " 가 된다. (char + char 였다면 숫자 덧셈)
     */
    static void q3() {
        char[] array = new char[]{'h', 'o', 'u', 's', 'e'};
        try {
            for (int i = 0; i <= array.length; i++) System.out.print(array[i] + " ");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println();
            System.out.println("→ " + e);
        }
    }

    /**
     * 4.  int[] myArray1 = new int[]{3,1,2,3};
     *        (왼쪽)  myArray2 = myArray1.clone();  myArray2[1] = 0;  println(myArray1[1]);
     *        (오른쪽) myArray2 = myArray1;          myArray2[1] = 0;  println(myArray1[1]);
     *
     * 내 답안 : 왼쪽 0, 오른쪽 1
     * ⚠ 오답. 정답은 왼쪽 1, 오른쪽 0. (두 답을 반대로 씀)
     *
     * 💡 왼쪽 : clone → 새 배열. myArray2 를 바꿔도 myArray1 은 그대로 → myArray1[1] = 1
     *    오른쪽 : 대입 → 같은 배열 공유. myArray2[1] 이 곧 myArray1[1] → 0
     *    (5-3 강의 "배열 복사" 1 · 2절 슬라이드와 같은 코드. 슬라이드는 {1,2,3} 이라 0 / 2)
     */
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

    /**
     * 5. 4번과 같은 결과가 나오는 이유
     *
     * 내 답안 : 깊은 복사와 얕은 복사의 차이임. clone 를 하면 값이 복사가 되는 게 아니라 레퍼런스 주소가
     *          복사되는 것임. 그래서 메모리의 값을 불러오므로 myArray2 의 레퍼런스와 myArray1 의 레퍼런스는
     *          동일하므로 index1 을 참조하는 0 이 출력될 것임.
     * ⚠ 오답. clone 과 = 대입을 반대로 이해했다. 레퍼런스(주소)가 복사되는 것은 = 대입이고,
     *   clone 은 값이 복사된 "새 배열" 을 만든다.
     *
     * 📝 필기 (정정)
     *   myarray1 -> 레퍼런스 1 (3,1,2,3)
     *   .clone() 하면 myarray2 -> 레퍼런스 2 (3,1,2,3)
     *   값을 바꾸면 myarray2 -> 레퍼런스 2 (3,0,2,3) / myarray1 -> 레퍼런스 1 (3,1,2,3) 값은 유지됨
     *
     *   int[] myarray2 = myarray1; 로 하면
     *   myarray1 -> 레퍼런스 1 (3,1,2,3)
     *   myarray2 -> 레퍼런스 1 (3,1,2,3) 가 되게 됨.
     *   따라서 값을 바꾸면 myarray1 -> 레퍼런스 1 (3,0,2,3)
     *                      myarray2 -> 레퍼런스 1 (3,0,2,3)
     *   ⚠ 필기에는 마지막 줄이 "myarray2 -> 레퍼런스 2" 로 적혀 있었다. 대입이면 둘 다 레퍼런스 1 이다.
     *
     *   그림으로 보면
     *     clone : myArray1 ──▶ [3|1|2|3]      대입 : myArray1 ──┐
     *             myArray2 ──▶ [3|0|2|3]             myArray2 ──┴──▶ [3|0|2|3]
     *
     * 💡 "깊은 복사 / 얕은 복사" 라는 말 자체는 맞는 방향이었다. 정리하면
     *    - 대입(=)        : 레퍼런스만 복사 → 공유 (복사라고 부르기도 어려움)
     *    - clone (1차원)  : 원소 값까지 복사 → 독립된 새 배열
     *    - clone (2차원)  : 행 배열만 복사, 각 행은 공유 → 얕은 복사 (5-3 강의 5절)
     * 💡 == 로 두 배열 변수를 비교하면 "같은 배열 객체를 가리키는지" 를 비교한다. 아래 실행 결과로 확인.
     */
    static void q5() {
        int[] myArray1 = new int[]{3, 1, 2, 3};
        int[] cloned = myArray1.clone();
        int[] assigned = myArray1;
        System.out.println("clone : myArray1 == myArray2 ? " + (myArray1 == cloned));
        System.out.println("대입  : myArray1 == myArray2 ? " + (myArray1 == assigned));
    }

    /**
     * 6. 다음 값을 가지는 2x3 int 형 배열 data 를 생성  (1 2 3 / 6 5 4 / 7 4 5)
     *
     * ⚠ 문제에는 "2x3" 이라고 되어 있지만 주어진 값은 3 행이다. 실제로는 3x3 배열.
     *
     * 📝 필기
     *   2차원 배열은 자바에서는 1차원 배열의 레퍼런스를 값으로 가지는 배열을 가지는 구조임.
     *   플렉서블하지만 느림. int[] 가 1차원 배열 [] 를 가리킴 → int[][] 로 선언하는 것임.
     *   자바에서는 들쭉날쭉하게 열의 개수가 행마다 다르게 선언이 가능함.
     *   C 에서는 1차원 배열이 연속적으로 나열된 구조임. 속도는 월등히 빠름.
     *   c 에서는 정방행렬만 가능함. 열의 개수가 행마다 달라서는 안 됨.
     *   int [][] data = new int[][] { {1,2,3}, {6,5,4}, {7,4,5} };  → 3x3 2차원 배열이 생성됨.
     *
     * 💡 보충 : C 의 2차원 배열도 정방행렬(n × n)만 되는 것은 아니다. int a[2][5]; 처럼
     *    모든 행의 길이가 같은 직사각형(R × C)이면 된다. "행마다 길이가 다를 수 없다" 가 정확한 차이.
     * 💡 "느리다" 의 이유 : 원소 하나에 접근할 때 행 배열 → 행 레퍼런스 → 원소 로 한 번 더 따라가야 하고,
     *    행들이 메모리 여기저기에 흩어질 수 있다.
     *
     *     data ──▶ [ ● ]──▶ [ 1 | 2 | 3 ]
     *              [ ● ]──▶ [ 6 | 5 | 4 ]
     *              [ ● ]──▶ [ 7 | 4 | 5 ]
     */
    static void q6() {
        int [][] data = new int[][] { {1, 2, 3}, {6, 5, 4}, {7, 4, 5} };
        print(data);
    }

    /**
     * 7. 다음 값을 가지는 2 차원 int 형 배열 data 를 생성  (1 2 3 / 6 5 / 7 4 5 8)
     *
     * 📝 필기 : int[][] data = new int [][] { {1,2,3}, {6,5}, {7,4,5,8} };
     *          자바에서는 들쭉날쭉한 2차원 배열 선언이 가능함.
     *
     * 💡 이런 배열을 Jagged 배열이라고 부른다. (5-3 강의 6절)
     *     data ──▶ [ ● ]──▶ [ 1 | 2 | 3 ]
     *              [ ● ]──▶ [ 6 | 5 ]
     *              [ ● ]──▶ [ 7 | 4 | 5 | 8 ]
     */
    static void q7() {
        int[][] data = new int [][] { {1, 2, 3}, {6, 5}, {7, 4, 5, 8} };
        print(data);
    }

    /**
     * 8. 7번에서 만든 배열의 각 행의 원소 개수를 for 문을 사용하여 출력
     *
     * 📝 필기 : data 는 r 행들의 값을 의미함. 그 값 하나하나에는 1차원 배열에 매핑되어 있음.
     *          data[r] 이라고 하면 r 행의 하나의 값 그 자체가 1차원 배열을 의미하는 것임.
     *          즉 data[r].length 라고 하면 열의 크기를 알 수 있게 됨.
     *
     * 📝 필기 코드
     *   int count = 0;
     *   for (int r = 0; r < data.length; r++) {        // 행 반복
     *       for (int c = 0; c < data[r].length; c++) { // 열 반복
     *           count++;
     *       }
     *   }
     *
     * 💡 필기 코드는 "전체 원소 개수"(9) 를 센다. 문제는 "각 행의" 원소 개수이므로
     *    행마다 data[r].length 를 출력해야 한다. 이 경우 안쪽 for 없이 바로 알 수 있다.
     *    아래에 두 가지를 모두 넣었다.
     */
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
