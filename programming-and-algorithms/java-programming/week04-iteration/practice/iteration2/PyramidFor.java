/**
 * [4강 실습] 반복문2 - 4번 문제
 * ※ 반복 시 for 문만 사용하시오.
 *
 * 아래와 같은 모양을 출력하는 프로그램을 작성하시오. 중첩 반복문을 사용토록 한다.
 * 한 개의 공백과 한 개의 '*' 를 출력하는 문을 반복 사용하여 작성하여야 한다.
 *
 *        *
 *       ***
 *      *****
 *     *******
 *
 * 포인트
 *  - 반복문1-4 (while) 의 "start, end 발상" 을 그대로 for 로 옮긴 것.
 *      start, end : 3,3 → 2,4 → 1,5 → 0,6
 *  - while 버전에서 직접 해 줘야 했던 col = 0; (행마다 초기화) 이
 *    for 에서는 안쪽 for 의 초기화 부분 int c = 0 이 자동으로 해 준다.
 *    → 안쪽 for 가 다시 시작될 때마다 초기화 부분이 다시 실행되기 때문.
 *  - 행/열 변수 r, c 는 for 안에서 선언 → 반복문 밖에서는 쓸 수 없다.
 *    start, end 는 행이 바뀌어도 값이 이어져야 하므로 바깥에서 선언했다.
 *
 * 📝 필기 : 확장 - 피라미드 두 개 (칠판 그림)
 *
 *     열 :  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 *                 *                 *
 *               * * *            *  *  *
 *             * * * * *       *  *  *  *  *
 *           * * * * * * *  *  *  *  *  *  *
 *
 *  - 폭을 15칸(0 ~ 14)으로 늘리고, 두 번째 피라미드의 꼭대기를 11 열에 둔다.
 *  - 피라미드마다 start, end 를 따로 둔다. (start1, end1 = 3,3 / start2, end2 = 11,11)
 *  - if 에서 첫 번째 구간이 아니면 else if 로 두 번째 구간을 검사, 둘 다 아니면 공백.
 *  - 행이 끝날 때 네 변수를 모두 갱신한다. (start1--, end1++, start2--, end2++)
 *  💡 마지막 행에서 첫 번째는 0 ~ 6, 두 번째는 8 ~ 14 → 7 열 한 칸이 비어 두 피라미드가 붙지 않는다.
 *
 * 실행 예 (pyramid)
 *     *
 *    ***
 *   *****
 *  *******
 *
 * 실행 예 (twinPyramid)
 *     *       *
 *    ***     ***
 *   *****   *****
 *  ******* *******
 */
public class PyramidFor {
    public static void main(String[] args) {
        pyramid();
        System.out.println();
        twinPyramid();
    }

    // 실습 4번 : 피라미드 하나
    static void pyramid() {
        int start = 3, end = 3;
        for (int r = 0; r <= 3; r++) {          // 행 : 0 ~ 3
            for (int c = 0; c <= 6; c++) {      // 열 : 0 ~ 6 (행이 바뀔 때마다 c = 0 부터 다시)
                if (start <= c && c <= end) {
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
            start--; end++;
        }
    }

    // 📝 확장 : 피라미드 두 개
    static void twinPyramid() {
        int start1 = 3, end1 = 3, start2 = 11, end2 = 11;
        for (int r = 0; r <= 3; r++) {
            for (int c = 0; c <= 14; c++) {
                if (start1 <= c && c <= end1) System.out.print("*");
                else if (start2 <= c && c <= end2) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
            start1--; end1++; start2--; end2++;
        }
    }
}
