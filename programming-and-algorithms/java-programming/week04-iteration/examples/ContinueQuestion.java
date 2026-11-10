import java.util.Scanner;

/**
 * [4-1 반복문1 / 4-2 반복문2] 반복 횟수가 정해지지 않은 경우 - "계속 하시겠습니까?"
 *
 * while 문은 반복 횟수가 미리 정해지지 않은 경우 편리하게 사용한다.
 * 같은 일을 while (4-1) 과 do-while (4-2) 로 각각 작성해 비교한다.
 *
 *                      while (4-1)                do-while (4-2)
 *  선언               char cont = 'y';            char cont;
 *  조건 검사 시점      블록 실행 "전"               블록 실행 "후"
 *  최소 실행 횟수      0 번                         1 번
 *
 * 4-1 : char cont = 'y';  // y로 초기화 하지 않으면 while문 접근 X
 *  💡 지역 변수는 초기화 없이 쓸 수 없다. char cont; 만 쓰고 while (cont == 'y') 를 쓰면
 *     "variable cont might not have been initialized" 컴파일 에러.
 *
 * 4-2 : 반복 조건을 나중에 검사하기 때문에 cont 를 'y' 로 초기화 할 필요 X
 *  💡 do 블록 안에서 cont = sc.next().charAt(0); 이 반드시 먼저 실행되므로 컴파일러도 OK.
 *
 * 💡 "반복 작업 내용" 은 슬라이드에서 ... 로 생략되어 있다. 여기서는 몇 번째 반복인지 출력했다.
 *
 * 실행 예
 *  [while] 1번째 작업
 *  계속 하시겠습니까 ? ('y' or 'n')
 *  y
 *  [while] 2번째 작업
 *  계속 하시겠습니까 ? ('y' or 'n')
 *  n
 *  [do-while] 1번째 작업
 *  계속 하시겠습니까 ? ('y' or 'n')
 *  n
 */
public class ContinueQuestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ===== 4-1 : while =====
        char cont = 'y';    // y로 초기화 하지 않으면 while문 접근 X
        int count = 0;
        while (cont == 'y') {
            // 반복작업 내용
            count++;
            System.out.println("[while] " + count + "번째 작업");

            System.out.println("계속 하시겠습니까 ? ('y' or 'n') ");
            cont = sc.next().charAt(0);
        }

        // ===== 4-2 : do-while =====
        char cont2;         // 초기화 필요 X
        count = 0;
        do {
            // 반복작업 내용
            count++;
            System.out.println("[do-while] " + count + "번째 작업");

            System.out.println("계속 하시겠습니까 ? ('y' or 'n') ");
            cont2 = sc.next().charAt(0);
        } while (cont2 == 'y');     // 세미콜론 필수

        sc.close();
    }
}
