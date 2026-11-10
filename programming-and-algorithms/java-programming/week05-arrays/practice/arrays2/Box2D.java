import java.util.Scanner;

/**
 * [5강 실습] 배열(2) - 6번 문제
 *
 * int box[5][3] 배열에 사용자로부터 값을 입력받아 저장하고 출력하는 프로그램을 작성하시오.
 *
 * 📝 필기 (AI 설명)
 *   이것은 5행 3열의 2차원 배열입니다.
 *
 *        열 0  열 1  열 2
 *   행 0   1     2     3
 *   행 1   4     5     6
 *   행 2   1     2     3
 *   행 3   4     5     6
 *   행 4   7     8     9
 *
 *   첫 번째 행의 1 2 3 은
 *     box[0][0] = 1;  box[0][1] = 2;  box[0][2] = 3;
 *   으로 저장됩니다. 여기서 중요한 것은 for 문을 두 개 사용하는 것입니다.
 *   바깥쪽 i 는 행(row)을 담당하고, 안쪽 j 는 열(column)을 담당합니다.
 *
 *   입력 순서
 *     i = 0 → box[0][0], box[0][1], box[0][2]
 *     i = 1 → box[1][0], box[1][1], box[1][2]
 *     ...
 *     i = 4 → box[4][0], box[4][1], box[4][2]
 *
 * 💡 한 줄에 "1 2 3" 처럼 공백으로 띄워 입력하면 nextInt() 가 하나씩 차례로 읽는다.
 *    (Scanner 는 공백 · 줄바꿈을 구분자로 쓴다. 한 개씩 엔터를 쳐도 같다.)
 * 💡 숫자 5, 3 대신 box.length, box[i].length 를 쓰면 크기를 바꿔도 반복문을 고칠 필요가 없다.
 *
 * 실행 예
 *  0번째 행의 값 (예: 1 2 3) : 5 4 5
 *  1번째 행의 값 (예: 1 2 3) : 3 2 1
 *  2번째 행의 값 (예: 1 2 3) : 5 6 9
 *  3번째 행의 값 (예: 1 2 3) : 5 4 3
 *  4번째 행의 값 (예: 1 2 3) : 4 5 2
 *  5 4 5
 *  3 2 1
 *  5 6 9
 *  5 4 3
 *  4 5 2
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
