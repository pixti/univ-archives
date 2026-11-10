import java.util.Scanner;

/**
 * [5강 실습] 배열(2) - 8번 문제
 *
 * 극장 좌석 예약 프로그램을 작성하시오.
 *  - 좌석은 10 행 8 열의 2차원 배열로 표현하고 0 으로 초기화한다.
 *  - 예약된 좌석은 1 로 바꾼다.
 *  - 좌석이 모두 예약되면 만석이라는 메시지를 출력한다.
 *  - (문제의 안내 문구) 예약할 좌석의 번호를 입력하시오((1~10) (1~8))(종료 -1)
 *
 * 포인트
 *  - 매 반복마다 : 현황 출력 (+ 예약된 좌석 수 세기) → 만석 확인 → 입력 → 예약
 *  - 만석 판정 : 예약된 좌석 수 == 전체 좌석 수 (seats.length * seats[0].length = 10 * 8 = 80)
 *    → 현황을 출력하는 이중 for 안에서 1 을 같이 세면 반복문을 한 번 더 돌 필요가 없다.
 *  - 사람은 1 번부터 세고 배열은 0 번부터 → row - 1, col - 1 로 바꿔서 접근.
 *  - 이미 1 인 자리는 "이미 예약된 좌석입니다." (덮어쓰지 않음)
 *  - while (true) + break : 끝나는 조건(만석, -1)이 반복문 중간에 있어서.
 *
 * ⚠ 보완하면 좋을 점 (원래 코드 그대로 두었다)
 *   - 종료하려고 -1 하나만 입력하면, 두 번째 nextInt() 가 숫자를 하나 더 기다린다.
 *     (-1 -1 처럼 두 개를 넣어야 바로 끝난다) → row 를 읽자마자 -1 인지 먼저 검사하면 된다.
 *   - 1 ~ 10, 1 ~ 8 밖의 번호를 넣으면 ArrayIndexOutOfBoundsException.
 *   - 변수 이름 cut 은 count(개수)의 오타로 보인다.
 *   - new int[10][8] 은 이미 0 으로 채워져 있어서 초기화 반복문은 없어도 된다.
 *     (문제가 "0 으로 초기화" 를 요구해서 넣은 것)
 *   - sc.close() 가 없다.
 *   - 입력 안내 문구는 문제와 다르게 "좌석 번호를 입력하세요 (-1 종료) : " 로 줄였다.
 *
 * 실행 예  (중간 좌석 출력은 일부 생략)
 *  0 0 0 0 0 0 0 0
 *  ... (10 줄)
 *  좌석 번호를 입력하세요 (-1 종료) : 2 1
 *  예약되었습니다.
 *  0 0 0 0 0 0 0 0
 *  1 0 0 0 0 0 0 0
 *  ...
 *  좌석 번호를 입력하세요 (-1 종료) : 1 6
 *  예약되었습니다.
 *  0 0 0 0 0 1 0 0
 *  1 0 0 0 0 0 0 0
 *  ...
 *  좌석 번호를 입력하세요 (-1 종료) : -1 -1
 */
public class SeatReservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] seats = new int[10][8];
        int r, c, row, col;

        // 초기화
        for (r = 0; r < seats.length; r++) {
            for (c = 0; c < seats[r].length; c++) {
                seats[r][c] = 0;
            }
        }

        do {
            // 현황 출력
            int cut = 0;
            for (r = 0; r < seats.length; r++) {
                for (c = 0; c < seats[r].length; c++) {
                    System.out.print(seats[r][c] + " ");
                    if (seats[r][c] == 1) {
                        cut++;
                    }
                }
                System.out.println();
            }

            // 만석 확인
            if (cut == seats.length * seats[0].length) {
                System.out.println("만석입니다.");
                break;
            }

            // 좌석 번호 입력 받기
            System.out.print("좌석 번호를 입력하세요 (-1 종료) : ");
            row = sc.nextInt();
            col = sc.nextInt();
            if (row == -1 || col == -1) {
                break;
            }

            row = row - 1;
            col = col - 1;

            if (seats[row][col] == 1) {
                System.out.println("이미 예약된 좌석입니다.");
            } else {
                seats[row][col] = 1;
                System.out.println("예약되었습니다.");
            }
        } while (true);
    }
}
