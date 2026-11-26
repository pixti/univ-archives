import java.util.Scanner;

/**
 * [3-2 조건문2] [실습] 좌표값의 분면 결정하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Quadrant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("좌표의 x값 >> ");
        int x = sc.nextInt();
        System.out.println("좌표의 y값 >> ");
        int y = sc.nextInt();
        sc.close();

        int qud;
        if (x == 0 || y == 0) {
            System.out.println("x나 y 중 하나가 0이면 분면 판단 불가");
            return;
        }

        // 방법 1) 중첩 if - 비교 횟수가 항상 2번
        if (x > 0) {
            if (y > 0) qud = 1;
            else qud = 4;
        }
        else {
            if (y > 0) qud = 2;
            else qud = 3;
        }

        /*
         * 방법 2) 복합 조건식 + else if - 이해하기 쉬움
         *  하지만 최악의 경우(3분면) 이전 코드보다 많은 비교를 한다.
         *  (x > 0) → (x > 0) → (x < 0, y > 0) 로 총 4번 비교
         *
         *  if (x > 0 && y > 0) qud = 1;
         *  else if (x > 0 && y < 0) qud = 4;
         *  else if (x < 0 && y > 0) qud = 2;
         *  else qud = 3;
         */

        System.out.println("좌표 (" + x + ", " + y + ")의 분면은 "
                + qud + "분면입니다.");
    }
}
