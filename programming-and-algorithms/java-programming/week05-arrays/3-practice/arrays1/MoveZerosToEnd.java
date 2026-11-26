/**
 * [5강 실습] 배열(1) - 7번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 3, 0, 5, 0, 6};

        System.out.print("입력 배열 : ");
        print(arr);

        int pos = 0;                          // 0 이 아닌 값을 다음에 쓸 위치
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[pos] = arr[i];
                pos++;
            }
        }
        for (int i = pos; i < arr.length; i++) {
            arr[i] = 0;                       // 나머지를 0 으로
        }

        System.out.print("처리 후 배열 : ");
        print(arr);
    }

    static void print(int[] arr) {
        for (int e : arr) System.out.print(e + " ");
        System.out.println();
    }
}
