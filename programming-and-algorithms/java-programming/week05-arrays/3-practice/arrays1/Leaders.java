/**
 * [5강 실습] 배열(1) - 8번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Leaders {
    public static void main(String[] args) {
        int[] my_arr = new int[] {10, 9, 14, 23, 15, 0, 9};
        int i, j;

        System.out.print("리더들 : ");
        for (i = 0; i < my_arr.length; i++) {
            // i번째 값이 리더인지 검사, i번째 값보다 큰 값이 있는지 검사
            for (j = i + 1; j < my_arr.length; j++) {
                if (my_arr[i] < my_arr[j]) {   // i번째 값이 리더가 아님
                    break;
                }
            }
            // 끝까지 검사했다면 i번째 값은 리더임.
            if (j == my_arr.length) {
                System.out.print(my_arr[i] + " ");
            }
        }
        System.out.println();
    }
}
