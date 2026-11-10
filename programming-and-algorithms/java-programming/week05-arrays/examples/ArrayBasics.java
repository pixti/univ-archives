import java.util.Arrays;

/**
 * [5-1 배열1] 배열 선언 · 생성 · 접근 · 선언과 동시에 초기화
 *
 * 포인트
 *  - double [] array;           선언 : 배열을 "가리킬" 참조 변수만 생긴다.  (double array[] 도 가능하나 권장 x)
 *  - array = new double[3];     생성 : double 3칸이 만들어지고 기본값 0.0 으로 채워진다.
 *  - array[0] = 1.0;            첨자(인덱스)를 붙여 접근. 인덱스는 0 ~ length-1.
 *  - new double[] {1.0, 2.0, 3.0} / {1.0, 2.0, 3.0}
 *      선언과 동시에 초기화. 크기는 값의 개수로 자동 결정.
 *      new double[3] {1.0, 2.0, 3.0} 처럼 크기를 쓰면 컴파일 오류.
 *
 * 💡 축약형 {...} 은 "선언할 때만" 쓸 수 있다.
 *      double[] a;  a = {1.0, 2.0};              // ❌ 컴파일 오류
 *      double[] a;  a = new double[] {1.0, 2.0}; // ✅
 * 💡 기본값 : 정수 0, 실수 0.0, boolean false, char '\u0000', 참조형 null
 * 💡 범위 밖 인덱스는 컴파일은 되지만 실행 중 ArrayIndexOutOfBoundsException.
 *
 * 실행 예
 *  생성 직후 : [0.0, 0.0, 0.0]
 *  대입 후   : [1.0, 2.0, 3.0]
 *  초기화 1  : [1.0, 2.0, 3.0]
 *  초기화 2  : [1.0, 2.0, 3.0]
 *  기본값    : [0, 0] [false, false] [null, null]
 *  array.length = 3
 *  array[3] 접근 → ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
 */
public class ArrayBasics {
    public static void main(String[] args) {
        double [] array;                 // double array[]도 가능하나 권장 x
        array = new double[3];           // double 형 데이터 3개 저장 가능
        System.out.println("생성 직후 : " + Arrays.toString(array));

        array[0] = 1.0;                  // 첨자를 붙여 접근, 초기화
        array[1] = 2.0;
        array[2] = 3.0;
        System.out.println("대입 후   : " + Arrays.toString(array));

        // 선언과 동시에 초기화 (크기는 값의 개수로 자동 결정)
        double [] array2 = new double[] {1.0, 2.0, 3.0};
        double [] array3 = {1.0, 2.0, 3.0};                 // 축약 형태
        // double [] array4 = new double[3] {1.0, 2.0, 3.0}; // ❌ 명시적으로 크기를 쓰면 컴파일 오류
        System.out.println("초기화 1  : " + Arrays.toString(array2));
        System.out.println("초기화 2  : " + Arrays.toString(array3));

        // 💡 new 로 만든 배열의 기본값
        System.out.println("기본값    : " + Arrays.toString(new int[2]) + " "
                + Arrays.toString(new boolean[2]) + " " + Arrays.toString(new String[2]));

        System.out.println("array.length = " + array.length);   // length 는 필드 → 괄호 없음

        // 💡 인덱스는 0 ~ length-1. 범위를 벗어나면 실행 중 예외
        try {
            array[3] = 4.0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("array[3] 접근 → " + e);
        }
    }
}
