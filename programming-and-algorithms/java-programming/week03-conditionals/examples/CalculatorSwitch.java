import java.util.Scanner;

/**
 * [3-3 조건문3] [실습] 메뉴 방식의 사칙 연산 (switch 버전)
 *
 * 3-2 의 "메뉴 방식의 사칙 연산" 예제(Calculator.java)에서
 * if 문으로 작성된 부분을 switch 문으로 바꾸어 본다.
 *
 *  if (c == 'a') result = a + b;          switch (c) {
 *  else if (c == 's') result = a - b;  →      case 'a' : result = a + b; break;
 *  ...                                         ...
 *  else { ...; return; }                      default : ...; return;
 *                                          }
 *
 * - 같은 변수를 == 로 여러 번 비교하는 if - else if 는 switch 로 바꾸면 더 깔끔하다.
 * - else 의 역할은 default 가 맡는다.
 *
 * 실행 예
 *  첫 번째 숫자 (음수도 가능) >>
 *  3
 *  두 번째 숫자 (음수도 가능) >>
 *  5
 *  연산 (a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈)을 선택하세요.
 *  a
 *  결과는 8.0입니다.
 */
public class CalculatorSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 숫자 (음수도 가능) >> ");
        int a = sc.nextInt();
        System.out.println("두 번째 숫자 (음수도 가능) >> ");
        int b = sc.nextInt();
        System.out.println("연산 (a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈)을 선택하세요.");
        char c = sc.next().charAt(0);
        sc.close();

        double result;
        switch (c) {
            case 'a' : result = a + b; break;
            case 's' : result = a - b; break;
            case 'm' : result = a * b; break;
            case 'd' : result = a / b; break;   // 💡 정수 나눗셈 (Calculator.java 주석 참고)
            default :
                System.out.println("허용되지 않는 문자");
                return;
        }
        System.out.println("결과는 " + result + "입니다.");
    }
}
