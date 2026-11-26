import java.util.Scanner;

/**
 * [2강 과제] 수식 - 4번
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Quadrant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("x좌표를 입력하시오: ");
        int x = sc.nextInt();
        System.out.print("y좌표를 입력하시오: ");
        int y = sc.nextInt();
        sc.close();

        int quadrant = (x > 0) ? ((y > 0) ? 1 : 4)
                               : ((y > 0) ? 2 : 3);

        System.out.println("좌표는 " + quadrant + "사분면입니다.");
    }
}
