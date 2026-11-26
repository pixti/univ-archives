import java.util.Scanner;

/**
 * [5강 실습] 배열(2) - 7번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[][] {
            {2, 2, 2},
            {2, 2, 2},
            {2, 2, 2}
        };
        int r, c, row, col, winner;
        char cont = 'y', order = '백';

        do {
            System.out.print(order + "차례입니다. 놓을 위치의 행 번호와 열 번호를 입력하세요. (예 : 0 1) : ");
            r = sc.nextInt();
            c = sc.nextInt();

            // 백돌은 1, 흑돌은 0
            if (order == '백') {
                board[r][c] = 1;
            } else {
                board[r][c] = 0;
            }

            // 바둑판 출력
            for (row = 0; row < board.length; row++) {
                for (col = 0; col < board[row].length; col++) {
                    if (board[row][col] == 0) {
                        System.out.print("■\t");
                    } else if (board[row][col] == 1) {
                        System.out.print("○\t");
                    } else {
                        System.out.print("x\t");
                    }
                }
                System.out.println();
            }

            winner = -1;

            // 가로 검사
            for (row = 0; row < 3; row++) {
                if (board[row][0] != 2 && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                    winner = board[row][0];
                }
            }

            // 세로 검사
            for (col = 0; col < 3; col++) {
                if (board[0][col] != 2 && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                    winner = board[0][col];
                }
            }

            // 왼쪽 위 → 오른쪽 아래 대각선
            if (board[0][0] != 2 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                winner = board[0][0];
            }

            // 오른쪽 위 → 왼쪽 아래 대각선
            if (board[0][2] != 2 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                winner = board[0][2];
            }

            // 승리 여부 확인
            if (winner == 1) {
                System.out.println("백 승리!");
                break;
            } else if (winner == 0) {
                System.out.println("흑 승리!");
                break;
            }

            // 다음 차례로 변경
            if (order == '백') {
                order = '흑';
            } else {
                order = '백';
            }

            System.out.print("계속 하시겠습니까? ('y' or 'n') : ");
            cont = sc.next().charAt(0);
        } while (cont == 'y');

        System.out.println("프로그램 종료.");
        sc.close();
    }
}
