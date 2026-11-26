import java.util.Scanner;

/**
 * [4-2 반복문2] [실습] 메뉴 반복 처리하기 (do-while 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MenuCalculatorDoWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean cont = true;
        do {
            System.out.println("a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료 ");
            char c = sc.next().charAt(0);

            if (c == 'q') {
                System.out.println("프로그램을 종료하였습니다.");
                cont = false;
            }
            else if (!(c == 'a' || c == 's' || c == 'm' || c == 'd'))
                System.out.println("유효하지 않는 메뉴입니다.");
            else {
                System.out.println("첫 번째 숫자 (음수도 가능) >> ");
                int a = sc.nextInt();
                System.out.println("두 번째 숫자 (음수도 가능) >> ");
                int b = sc.nextInt();

                double result;
                if (c == 'a') result = a + b;
                else if (c == 's') result = a - b;
                else if (c == 'm') result = a * b;
                else result = (double) a / b;

                System.out.println("결과는 " + result + "입니다.");
            }
        } while (cont);
        sc.close();
    }
}
