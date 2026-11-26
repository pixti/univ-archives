/**
 * [4강 실습] 반복문1 - 4번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
