import java.util.Arrays;

/**
 * [5강 실습] 배열(2) - 3번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class SecondLargest {
    public static void main(String[] args) {
        int[] my_arr = {10789, 2035, 1899, 1456, 2013, 1458, 2458,
                        1254, 1472, 2365, 1456, 2165, 1457, 2456};

        // 방법 1) 한 번 훑기
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int e : my_arr) {
            if (e > first) {
                second = first;      // 원래 1등이 2등으로
                first = e;
            } else if (e > second && e != first) {
                second = e;
            }
        }
        System.out.println("두 번째 큰 값 : " + second);

        // 방법 2) 정렬 후 뒤에서 두 번째
        int[] sorted = my_arr.clone();   // 원본을 지키려고 복사본을 정렬
        Arrays.sort(sorted);
        System.out.println("(정렬 방법) 두 번째 큰 값 : " + sorted[sorted.length - 2]);
    }
}
