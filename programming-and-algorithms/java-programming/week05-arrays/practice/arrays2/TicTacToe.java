import java.util.Scanner;

/**
 * [5강 실습] 배열(2) - 7번 문제
 *
 * 2차원 배열을 이용하여 틱택토(3목) 게임을 작성하시오.
 * 백과 흑이 번갈아 가며 행 번호와 열 번호를 입력해 돌을 놓고, 놓을 때마다 판을 출력한다.
 *
 * 판의 값
 *   2 = 빈칸 (x),  1 = 백돌 (○),  0 = 흑돌 (■)
 *   → 처음에 모든 칸을 2 로 채워 둔다. (new int[3][3] 의 기본값 0 은 흑돌과 겹치기 때문)
 *
 * 📝 필기 (AI 설명)
 *   엄밀한 틱택토는 가로 · 세로 · 대각선으로 3 개가 연속인지 검사해야 합니다.
 *   3 × 3 에서 대각선은 딱 2 개뿐입니다.
 *     왼쪽 위 → 오른쪽 아래 : board[0][0], board[1][1], board[2][2]
 *     오른쪽 위 → 왼쪽 아래 : board[0][2], board[1][1], board[2][0]
 *
 *   여기서 != 2 가 중요합니다. 0 = 흑, 1 = 백, 2 = 빈칸 이므로
 *   빈칸도 2 == 2 == 2 가 되어 승리로 판정되는 것을 막아야 합니다.
 *
 *   행 / 열까지 합치면
 *     // 가로 검사
 *     for (row = 0; row < 3; row++)
 *         if (board[row][0] != 2 && board[row][0] == board[row][1] && board[row][1] == board[row][2])
 *             winner = board[row][0];
 *     // 세로 검사
 *     for (col = 0; col < 3; col++)
 *         if (board[0][col] != 2 && board[0][col] == board[1][col] && board[1][col] == board[2][col])
 *             winner = board[0][col];
 *     // 대각선 두 개는 직접 적기
 *
 *   특히 대각선은 일반적인 for 문으로 처리하려고 하기보다, 지금 단계에서는 위처럼 두 경우를
 *   직접 적는 게 이해하기 쉽습니다. 나중에 익숙해지면 대각선도
 *   board[i][i], board[i][2-i] 형태로 for 문 하나씩 처리할 수 있습니다.
 *
 * 포인트
 *  - a == b && b == c : 세 개가 같다. (a == b == c 는 자바에서 안 된다. a == b 의 결과가 boolean 이라서)
 *  - winner = -1 로 시작 : 아무도 이기지 않았다는 표시. (0 과 1 은 돌 값이라 쓸 수 없음)
 *  - 승부가 나면 break 로 do-while 을 빠져나온다.
 *  - 차례 바꾸기 : order 가 '백' 이면 '흑', 아니면 '백'.  (char 에 한글 한 글자도 들어간다)
 *
 * ⚠ 보완하면 좋을 점 (원래 코드 그대로 두었다)
 *   - 이미 돌이 있는 칸에 놓으면 그대로 덮어쓴다. → if (board[r][c] != 2) { "이미 놓인 자리" ; continue; }
 *   - 0 ~ 2 밖의 번호를 넣으면 ArrayIndexOutOfBoundsException 으로 프로그램이 끝난다.
 *   - 9 칸이 다 차도 승부가 안 나면(무승부) 판정이 없다. 놓은 횟수를 세서 9 가 되면 "무승부".
 *   - 승부가 날 때까지 매 턴 "계속 하시겠습니까?" 를 묻는다. 게임으로는 어색하지만 문제의 형식을 따른 것.
 *
 * 실행 예
 *  백차례입니다. 놓을 위치의 행 번호와 열 번호를 입력하세요. (예 : 0 1) : 2 1
 *  x	x	x
 *  x	x	x
 *  x	○	x
 *  계속 하시겠습니까? ('y' or 'n') : y
 *  흑차례입니다. 놓을 위치의 행 번호와 열 번호를 입력하세요. (예 : 0 1) : 2 2
 *  x	x	x
 *  x	x	x
 *  x	○	■
 *  계속 하시겠습니까? ('y' or 'n') : n
 *  프로그램 종료.
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
