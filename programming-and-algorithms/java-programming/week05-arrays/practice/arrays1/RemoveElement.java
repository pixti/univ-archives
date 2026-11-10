import java.util.Arrays;
import java.util.Scanner;

/**
 * [5강 실습] 배열(1) - 3번 문제 (버전 1 : 인덱스 for)
 *
 * 배열에서 특정 요소를 제거하는 프로그램을 작성하시오.
 *   배열 : {25, 14, 56, 15, 36, 56, 77, 18, 29, 49}
 *
 *   (예시 출력)
 *   제거하고자 하는 값 ? 14
 *   제거 후 배열 : [25, 56, 15, 36, 56, 77, 18, 29, 49, 49]
 *
 * 📝 필기
 *   x -> [1,2,3,4,5] 배열에서 원소 하나 쏙 빼는 건 물리적으로 불가능함.
 *   새로운 배열을 만들고 [1,2,3,5] 값을 복사해 하나 만들고 x 가 매핑되는 구조.
 *
 *     변경 전  my_arr ──▶ [25|14|56|15|36|56|77|18|29|49]   (크기 10, 바꿀 수 없음)
 *                         tmp ──▶ [25|56|15|36|56|77|18|29|49] (크기 9, 새로 만듦)
 *     my_arr = tmp;       my_arr 이 새 배열을 가리키게 됨 (옛 배열은 가비지 컬렉터가 정리)
 *
 * 포인트 (두 번 훑는다)
 *  1) 제거할 값의 개수(cnt)를 센다 → 새 배열의 크기 = 원래 길이 - cnt 를 알 수 있다.
 *  2) 제거할 값이 아닌 것만 tmp 에 옮긴다.
 *     i : 원래 배열에서 읽을 위치 (매번 증가)
 *     j : 새 배열에 쓸 위치 (옮길 때만 증가) → 두 위치가 따로 움직인다.
 *  - 같은 값이 여러 개면(56) 모두 제거된다.
 *  - 값이 없으면 cnt == 0 → 배열을 그대로 두고 안내 문구.
 *
 * 💡 문제의 예시 출력은 [... 29, 49, 49] 로 맨 끝에 49 가 두 번 있다.
 *    새 배열을 만드는 것이 아니라 "뒤의 원소를 한 칸씩 앞으로 당기고 크기는 그대로" 둔 결과다.
 *    마지막 칸은 옮길 값이 없어 원래 값(49)이 남는다. 크기를 못 바꾸니 생기는 현상.
 *    내 코드는 필기대로 새 배열을 만들어서 [25, 56, 15, 36, 56, 77, 18, 29, 49] (크기 9) 가 나온다.
 *    예시 방식의 코드는 아래 shiftLeft() 에 참고로 넣었다.
 * 💡 for each 로 옮기기 → RemoveElementForEach.java
 *
 * 실행 예
 *  변경 전 배열 :
 *  [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]
 *  제거 값 ? 77
 *  변경 후 배열 :
 *  [25, 14, 56, 15, 36, 56, 18, 29, 49]
 *  계속하시겠습니까? (y/n) : y
 *  변경 전 배열 :
 *  [25, 14, 56, 15, 36, 56, 18, 29, 49]
 *  제거 값 ? 56
 *  변경 후 배열 :
 *  [25, 14, 15, 36, 18, 29, 49]
 *  계속하시겠습니까? (y/n) : y
 *  변경 전 배열 :
 *  [25, 14, 15, 36, 18, 29, 49]
 *  제거 값 ? 100
 *  배열에 해당 값이 존재하지 않습니다.
 *  변경 후 배열 :
 *  [25, 14, 15, 36, 18, 29, 49]
 *  계속하시겠습니까? (y/n) : n
 *  프로그램을 종료합니다.
 *  (참고) 예시 출력 방식 : 14 제거 → [25, 56, 15, 36, 56, 77, 18, 29, 49, 49]
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
