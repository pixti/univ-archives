import java.util.Scanner;

/**
 * [4-3 반복문3] [실습] 메뉴 반복 처리하기 (for 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MenuCalculatorFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (boolean cont = true; cont == true; ) {     // 증감문은 생략
            System.out.println("a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료");
            char c = sc.next().charAt(0);

            if (c == 'q') {
                System.out.println("프로그램을 종료하였습니다.");
                cont = false;   // 무한루프를 종료
            }
            else if (!(c == 'a' || c == 's' || c == 'm' || c == 'd')) {
                System.out.println("유효하지 않는 메뉴입니다.");
            }
            else {
                System.out.println("첫 번째 숫자 (음수도 가능) >> ");
                int a = sc.nextInt();
                // ----- 강의 코드에서 생략(…)된 부분 -----
                System.out.println("두 번째 숫자 (음수도 가능) >> ");
                int b = sc.nextInt();

                double result;
                if (c == 'a') result = a + b;
                else if (c == 's') result = a - b;
                else if (c == 'm') result = a * b;
                else result = (double) a / b;
                // -----------------------------------
                System.out.println("결과는 " + result + "입니다.");
            }
        }
        sc.close();
    }
}
