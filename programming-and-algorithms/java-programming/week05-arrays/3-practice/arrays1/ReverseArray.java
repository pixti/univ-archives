import java.util.Arrays;
import java.util.Scanner;

/**
 * [5강 실습] 배열(1) - 4번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] my_arr = new int[] {1789, 2035, 1899, 1456, 2013, 1458, 2458,
                                  1254, 1472, 2365, 1456, 2165, 1457, 2456};
        int temp;

        System.out.println("변경 전 배열 : " + Arrays.toString(my_arr));

        for (int i = 0; i < my_arr.length / 2; i++) {          // 중앙까지만
            temp = my_arr[i];                                   // temp = x
            my_arr[i] = my_arr[my_arr.length - 1 - i];          // x = y
            my_arr[my_arr.length - 1 - i] = temp;               // y = temp
        }

        System.out.println("변경 후 배열 : " + Arrays.toString(my_arr));
        sc.close();
    }
}
