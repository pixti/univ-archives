import java.util.Scanner;

/**
 * [5강 실습] 배열(2) - 8번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
