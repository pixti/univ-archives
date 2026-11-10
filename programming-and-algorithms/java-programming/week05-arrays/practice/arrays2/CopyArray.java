import java.util.Arrays;

/**
 * [5강 실습] 배열(2) - 1번 문제
 *
 * 반복문을 이용하여 배열을 다른 배열로 복사하는 프로그램을 작성하시오.
 *   배열 : [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]
 *
 *   (예시 출력)
 *   New Array: [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]
 *
 * 💡 수업에서 직접 작성한 코드가 없는 문제라 참고용 풀이를 작성했다.
 *
 * 포인트
 *  - 같은 크기의 새 배열을 new 로 만든 뒤, 원소를 하나씩 옮긴다. → clone() 이 해 주는 일을 직접 하는 것.
 *  - new_arr = my_arr; 로 쓰면 복사가 아니라 "같은 배열 공유" 다. (5-3 강의, 퀴즈 4 · 5번)
 *    확인용으로 복사 후 원본을 바꿔도 복사본은 그대로인지 출력했다.
 *
 * 💡 같은 일을 하는 다른 방법
 *      int[] b = my_arr.clone();
 *      int[] b = Arrays.copyOf(my_arr, my_arr.length);
 *      System.arraycopy(my_arr, 0, b, 0, my_arr.length);
 *
 * 실행 예
 *  Original Array: [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]
 *  New Array: [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]
 *  원본 my_arr[0] = 0 으로 바꾼 뒤 New Array: [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]
 */
public class CopyArray {
    public static void main(String[] args) {
        int[] my_arr = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        int[] new_arr = new int[my_arr.length];       // 같은 크기의 새 배열

        for (int i = 0; i < my_arr.length; i++) {
            new_arr[i] = my_arr[i];                    // 하나씩 복사
        }

        System.out.println("Original Array: " + Arrays.toString(my_arr));
        System.out.println("New Array: " + Arrays.toString(new_arr));

        my_arr[0] = 0;                                 // 원본을 바꿔도
        System.out.println("원본 my_arr[0] = 0 으로 바꾼 뒤 New Array: " + Arrays.toString(new_arr));
    }
}
