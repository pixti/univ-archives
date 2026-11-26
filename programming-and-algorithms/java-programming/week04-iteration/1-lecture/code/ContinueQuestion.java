import java.util.Scanner;

/**
 * [4-1 반복문1 / 4-2 반복문2] 반복 횟수가 정해지지 않은 경우 - "계속 하시겠습니까?"
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
