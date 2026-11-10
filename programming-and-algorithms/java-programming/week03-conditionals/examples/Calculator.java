import java.util.Scanner;

/**
 * [3-2 조건문2] [실습] 메뉴 방식의 사칙 연산 (if - else if 버전)
 *   → switch 버전은 CalculatorSwitch.java (3-3)
 *
 * 참고) sc.next().charAt(0)
 *  - sc.next()    : 공백 전까지의 단어 하나를 String 으로 읽는다.
 *  - .charAt(0)   : 그 문자열의 0번째(첫 번째) 글자를 char 로 꺼낸다. (인덱스는 0부터)
 *
 * 💡 주의할 점
 *  1) result 는 double 이지만 a / b 는 int 끼리의 나눗셈이다.
 *     7 / 2 → 3 이 먼저 계산된 뒤 3.0 으로 저장된다.
 *     소수점까지 원하면 (double) a / b 로 써야 한다. (2주차 형변환)
 *  2) b 가 0 인데 'd' 를 고르면 ArithmeticException: / by zero 로 프로그램이 죽는다.
 *  3) result 를 초기화하지 않았는데도 에러가 나지 않는 이유:
 *     else 블록이 return; 으로 끝나므로 출력문까지 오는 모든 경로에서
 *     result 에 값이 대입된다. (확정 대입, definite assignment)
 *
 * 실행 예
 *  첫 번째 숫자 (음수도 가능) >>
 *  3
 *  두 번째 숫자 (음수도 가능) >>
 *  5
 *  연산 (a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈)을 선택하세요.
 *  m
 *  결과는 15.0입니다.
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 숫자 (음수도 가능) >> ");
        int a = sc.nextInt();
        System.out.println("두 번째 숫자 (음수도 가능) >> ");
        int b = sc.nextInt();
        System.out.println("연산 (a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈)을 선택하세요.");
        /* Scanner 클래스는 한 글자를 읽어 들이는 메소드가 제공되지 않기 때문에
           next() 메소드로 문자열을 읽은 후
           charAt() 메소드를 이용하여 첫 번째 문자 가져옴 */
        char c = sc.next().charAt(0);
        sc.close();

        double result;
        if (c == 'a') result = a + b;
        else if (c == 's') result = a - b;
        else if (c == 'm') result = a * b;
        else if (c == 'd') result = a / b;   // 💡 정수 나눗셈! (double) a / b 로 쓰면 소수점까지
        else {
            System.out.println("허용되지 않는 문자입니다.");
            return;
        }
        System.out.println("결과는 " + result + "입니다.");
    }
}
