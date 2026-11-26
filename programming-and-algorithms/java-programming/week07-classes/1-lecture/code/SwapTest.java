/**
 * [7-4] 메소드 인수 전달 - 기본 자료형 vs 배열(레퍼런스)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class SwapTest {
    public static void main(String[] args) {
        // (1) 기본 자료형
        int x = 5, y = 3;
        swap(x, y); // 값이 바뀌지 않음
        System.out.println(x);
        System.out.println(y);

        // (2) 배열
        int[] arr = new int[] {5, 3};
        swap(arr, 0, 1); // 값이 바뀜
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

    public static void swap(int a, int b) {
        int tmp;
        tmp = a;
        a = b;
        b = tmp;
    }

    public static void swap(int[] arr, int idx1, int idx2) {   // ⚠ static 추가
        int tmp;
        tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
