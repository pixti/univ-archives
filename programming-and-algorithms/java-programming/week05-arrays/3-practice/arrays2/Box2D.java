import java.util.Scanner;

/**
 * [5강 실습] 배열(2) - 6번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Box2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] box = new int[5][3];

        // 5개의 행에 값 입력
        for (int i = 0; i < 5; i++) {
            System.out.print(i + "번째 행의 값 (예: 1 2 3) : ");
            for (int j = 0; j < 3; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        // 배열 출력
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
