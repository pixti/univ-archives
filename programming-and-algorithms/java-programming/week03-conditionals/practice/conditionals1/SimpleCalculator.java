import java.util.Scanner;

/**
 * [3강 실습] 조건문1 - 2번 문제 (if 버전)
 * 간단한 계산기 프로그램을 작성하여 보자.
 * 먼저 사용자로부터 하나의 연산 문자 (+, -, *, /, Q) 를 입력받는다.
 * 이어서 사용자로부터 2개의 숫자를 입력 받는다.
 * 연산 문자에 맞는 계산을 한 후 그 결과를 출력한다. 연산 문자 중 Q 는 프로그램 종료를 의미한다.
 * (Eclipse 에서는 Problem.java 로 작성했던 코드)
 *  → switch 버전 : SimpleCalculatorSwitch.java (이쪽을 먼저 작성했음)
 *
 * 포인트
 *  - op == '+' 처럼 "같은 변수를 == 로 여러 번 비교" 하는 if-else if 는 switch 로 바꾸기 좋다.
 *  - switch 의 default ↔ if 의 마지막 else
 *  - 나눗셈 안의 if-else 는 "중첩 if" 이다.
 *
 * 💡 슬라이드 예제(examples/Calculator.java)는 0 으로 나누는 경우를 처리하지 않았지만
 *    여기서는 if (y != 0) 으로 막았다.
 *
 * 실행 예
 *  **************
 *  + --------- 덧셈
 *  - ---------- 뺄셈
 *  * ---------- 곱셈
 *  / -------- 나눗셈
 *  Q -------- Quit
 *  **************
 *  연산 선택 : +
 *  두 수를 공백으로 분리하여 입력하시오 : 10 3
 *  13
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
