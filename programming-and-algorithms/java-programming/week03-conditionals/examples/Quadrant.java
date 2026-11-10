import java.util.Scanner;

/**
 * [3-2 조건문2] [실습] 좌표값의 분면 결정하기
 *
 * - x 나 y 가 0 이면 축 위의 점이라 분면을 판단할 수 없으므로 먼저 걸러낸다.
 * - return; 은 메소드를 즉시 끝낸다. main 에서 쓰면 프로그램이 그 자리에서 종료된다.
 *   (잘못된 입력을 걸러낼 때 자주 쓰는 패턴)
 *
 * 💡 2주차 과제 Quadrant.java 는 ?: 만으로 풀어서 0 을 처리하지 못했지만,
 *    if 문을 배운 지금은 축 위의 점을 따로 처리할 수 있다.
 * ⚠ 슬라이드 코드는 "...판단 불가“); 로 닫는 따옴표가 둥근 따옴표라 컴파일 에러 → 수정
 *
 * 실행 예
 *  좌표의 x값 >>
 *  4
 *  좌표의 y값 >>
 *  -3
 *  좌표 (4, -3)의 분면은 4분면입니다.
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
