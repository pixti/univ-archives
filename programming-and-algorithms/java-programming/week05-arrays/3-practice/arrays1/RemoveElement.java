import java.util.Arrays;
import java.util.Scanner;

/**
 * [5강 실습] 배열(1) - 3번 문제 (버전 1 : 인덱스 for)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class RemoveElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] my_arr = new int[] {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        char cont;
        int n, cnt, j;

        do {
            System.out.println("변경 전 배열 : ");
            System.out.println(Arrays.toString(my_arr));

            System.out.print("제거 값 ? ");
            n = sc.nextInt();
            cnt = 0;

            // 제거할 값의 개수 카운트
            for (int i = 0; i < my_arr.length; i++) {
                if (my_arr[i] == n) {
                    cnt++;
                }
            }

            // 값이 존재하는 경우 새로운 배열 생성 및 복사
            if (cnt != 0) {
                int[] tmp = new int[my_arr.length - cnt];
                j = 0;
                for (int i = 0; i < my_arr.length; i++) {
                    if (my_arr[i] != n) {
                        tmp[j] = my_arr[i];
                        j++;
                    }
                }
                my_arr = tmp;   // 변경된 배열 업데이트
            } else {
                System.out.println("배열에 해당 값이 존재하지 않습니다.");
            }

            System.out.println("변경 후 배열 : ");
            System.out.println(Arrays.toString(my_arr));

            // 계속 진행할지 여부 입력받기
            System.out.print("계속하시겠습니까? (y/n) : ");
            cont = sc.next().charAt(0);
        } while (cont == 'y' || cont == 'Y');

        System.out.println("프로그램을 종료합니다.");
        sc.close();

        System.out.println("(참고) 예시 출력 방식 : 14 제거 → "
                + Arrays.toString(shiftLeft(new int[] {25, 14, 56, 15, 36, 56, 77, 18, 29, 49}, 14)));
    }

    /**
     * 💡 참고 : 문제 예시 출력 방식. 처음 찾은 값 하나를 지우고 뒤의 원소를 한 칸씩 앞으로 당긴다.
     *    배열 크기는 그대로라서 마지막 칸에는 원래 마지막 값이 한 번 더 남는다.
     */
    static int[] shiftLeft(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                for (int k = i; k < arr.length - 1; k++) {
                    arr[k] = arr[k + 1];   // 한 칸씩 앞으로
                }
                break;
            }
        }
        return arr;
    }
}
