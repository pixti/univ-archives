import java.util.Scanner;

/**
 * [3강 실습] 조건문1 - 2번 문제 (if 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("**************");
        System.out.println("+ --------- 덧셈");
        System.out.println("- ---------- 뺄셈");
        System.out.println("* ---------- 곱셈");
        System.out.println("/ -------- 나눗셈");
        System.out.println("Q -------- Quit");
        System.out.println("**************");

        System.out.print("연산 선택 : ");
        char op = sc.next().charAt(0);

        if (op == 'Q' || op == 'q') {
            System.out.println("프로그램을 종료합니다.");
            sc.close();
            return;
        }

        System.out.print("두 수를 공백으로 분리하여 입력하시오 : ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        if (op == '+') {
            System.out.println(x + y);
        }
        else if (op == '-') {
            System.out.println(x - y);
        }
        else if (op == '*') {
            System.out.println(x * y);
        }
        else if (op == '/') {
            if (y != 0) {
                System.out.println(x / y);
            }
            else {
                System.out.println("0으로 나눌 수 없습니다.");
            }
        }
        else {
            System.out.println("잘못된 연산자입니다.");
        }

        sc.close();
    }
}
