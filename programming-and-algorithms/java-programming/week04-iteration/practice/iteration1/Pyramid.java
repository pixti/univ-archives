/**
 * [4강 실습] 반복문1 - 4번 문제
 * ※ 반복 시 while 이나 do while 문만 사용하시오.
 *
 * 아래와 같은 모양을 출력하는 프로그램을 작성하시오. 중첩 반복문을 사용토록 한다.
 * 한 개의 공백과 한 개의 '*' 를 출력하는 문을 반복 사용하여 작성하여야 한다.
 *
 *        *
 *       ***
 *      *****
 *     *******
 *
 * 📝 필기
 *  - start 위치와 end 위치가 달라지는 것.
 *  - 3,3 -> 2,4 -> 1,5 -> 0,6 의 발상.
 *  - (코드 주석) while (row < 4)  // row : 0~3까지 반복
 *  - (코드 주석) col = 0;         // col 6까지 순회 -> 다음 행 시작시 col 0으로 초기화
 *  - (코드 주석) while (col < 7)  // col : 0~6까지 열 반복하여 한 행 처리
 *
 * 💡 발상 정리
 *   폭이 7칸(열 0 ~ 6)인 판에 4줄(행 0 ~ 3)을 찍는다. 각 행에서 '*' 가 찍히는 열의 구간은
 *
 *     열 :  0 1 2 3 4 5 6       start, end
 *     0행         *              3, 3
 *     1행       * * *            2, 4
 *     2행     * * * * *          1, 5
 *     3행   * * * * * * *        0, 6
 *
 *   → 행이 하나 내려갈 때마다 start 는 1 감소, end 는 1 증가.
 *   → 각 칸(col)이 start <= col <= end 이면 '*', 아니면 ' ' 를 찍는다.
 *
 * 💡 col = 0; 을 바깥 while 안에서 해 주는 것이 핵심.
 *    while 은 for 와 달리 초기식이 따로 없어서, 이걸 빼먹으면 두 번째 행부터
 *    col 이 이미 7 이라 안쪽 while 이 한 번도 돌지 않는다. (빈 줄만 3개 나옴)
 *    → NumberGuessingRepeat 의 cont = true; , 퀴즈 3번 안쪽 sum = 0; 과 같은 이야기.
 * 💡 오른쪽 공백(end 뒤)도 찍히지만 화면에서는 보이지 않는다.
 *
 * 실행 예
 *     *
 *    ***
 *   *****
 *  *******
 */
public class Pyramid {
    public static void main(String[] args) {
        int start = 3, end = 3, row = 0, col = 0;
        while (row < 4) {           // row : 0~3까지 반복
            col = 0;                // col 6까지 순회 -> 다음 행 시작시 col 0으로 초기화

            while (col < 7) {       // col : 0~6까지 열 반복하여 한 행 처리
                if (start <= col && col <= end) {
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
                col++;
            }
            start--;
            end++;
            System.out.println();
            row++;
        }
    }
}
