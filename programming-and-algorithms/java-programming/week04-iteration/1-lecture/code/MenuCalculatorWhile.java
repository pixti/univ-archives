import java.util.Scanner;

/**
 * [4-1 반복문1] [실습] 메뉴 반복 처리하기 - 조건문 실습에서 반복처리 추가 (while 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MenuCalculatorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean cont = true; char c;
        while (cont) {  // cont가 false 될때 까지 무한 루프
            System.out.println("a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료");
            c = sc.next().charAt(0);

            if (c == 'q') {
                System.out.println("프로그램을 종료하였습니다.");
                cont = false;
            }
            else if (!(c == 'a' || c == 's' || c == 'm' || c == 'd')) {
                System.out.println("유효하지 않는 메뉴입니다.");
            }
            else {
                // ----- 강의 코드에서 생략된 부분 -----
                System.out.println("첫 번째 숫자 (음수도 가능) >> ");
                int a = sc.nextInt();
                System.out.println("두 번째 숫자 (음수도 가능) >> ");
                int b = sc.nextInt();

                double result;
                if (c == 'a') result = a + b;
                else if (c == 's') result = a - b;
                else if (c == 'm') result = a * b;
                else result = (double) a / b;   // 💡 형변환하지 않으면 정수 나눗셈 (7 / 2 = 3)

                System.out.println("결과는 " + result + "입니다.");
            }
        }
        sc.close();
    }
}
