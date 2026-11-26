import java.util.Arrays;

/**
 * [5강 실습] 배열(2) - 1번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
