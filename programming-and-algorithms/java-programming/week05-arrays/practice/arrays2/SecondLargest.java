import java.util.Arrays;

/**
 * [5강 실습] 배열(2) - 3번 문제
 *
 * 배열에서 두 번째로 큰 요소를 찾는 프로그램을 작성하시오.
 *   배열 : [10789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456]
 *
 *   (예시 출력)
 *   두 번째 큰 값 : 2458
 *
 * 💡 수업에서 직접 작성한 코드가 없는 문제라 참고용 풀이를 작성했다.
 *
 * 방법 1) 한 번 훑기 : 1등(first)과 2등(second)을 동시에 기억
 *   - 새 값이 1등보다 크면 : 원래 1등이 2등으로 밀려나고, 새 값이 1등.  (순서 중요! second = first 먼저)
 *   - 1등보다는 작고 2등보다 크면 : 2등만 교체.
 *   - e != first 조건 : 최대값이 두 번 있을 때 그 값이 2등으로 들어가지 않게. ("서로 다른 값 중 두 번째")
 *   - 시작값은 Integer.MIN_VALUE (int 의 가장 작은 값) → 어떤 값이 와도 처음에 교체된다.
 *
 *       e      first   second
 *     10789    10789   MIN
 *      2035    10789   2035
 *      1899      (변화 없음)
 *      ...
 *      2458    10789   2458
 *      2365      (변화 없음)  ...
 *
 * 방법 2) 정렬 후 뒤에서 두 번째 : 코드는 짧지만 원본 순서가 바뀌고(복사본을 정렬), 최대값이 중복이면 틀린다.
 *
 * 실행 예
 *  두 번째 큰 값 : 2458
 *  (정렬 방법) 두 번째 큰 값 : 2458
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
