/**
 * [5강 실습] 배열(1) - 5번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class CommonElements {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 5, 8, 9, 7, 10};
        int[] arr2 = {1, 0, 6, 15, 6, 4, 7, 0};
        int cnt = 0;

        for (int i = 0; i < arr1.length; i++) {
            // arr1 앞쪽에 같은 값이 이미 있었으면 건너뜀 (중복 출력 방지)
            boolean seen = false;
            for (int k = 0; k < i; k++) {
                if (arr1[k] == arr1[i]) {
                    seen = true;
                    break;
                }
            }
            if (seen) continue;

            // arr2 에 같은 값이 있는지
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    cnt++;
                    System.out.println("공통요소" + cnt + " : " + arr1[i]);
                    break;
                }
            }
        }
    }
}
