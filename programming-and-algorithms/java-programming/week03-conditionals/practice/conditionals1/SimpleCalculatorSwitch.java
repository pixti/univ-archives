import java.util.Scanner;

/**
 * [3강 실습] 조건문1 - 2번 문제 (switch 버전)
 * 간단한 계산기 프로그램을 작성하여 보자.
 * 먼저 사용자로부터 하나의 연산 문자 (+, -, *, /, Q) 를 입력받는다.
 * 이어서 사용자로부터 2개의 숫자를 입력 받는다.
 * 연산 문자에 맞는 계산을 한 후 그 결과를 출력한다. 연산 문자 중 Q 는 프로그램 종료를 의미한다.
 * (Eclipse 에서는 Problem.java 로 작성했던 코드. switch 로 먼저 풀고, if 버전을 따로 작성함)
 *  → if 버전 : SimpleCalculator.java
 *
 * 포인트
 *  - sc.next().charAt(0) : Scanner 에는 한 글자를 읽는 메소드가 없어서 문자열을 읽고 첫 글자를 꺼낸다.
 *  - Q 를 먼저 검사해서 return; 으로 main 을 끝낸다. → 종료할 때는 숫자를 입력받지 않아도 된다.
 *  - 나눗셈은 y 가 0 이면 ArithmeticException 이 나므로 if (y != 0) 으로 막았다.
 *
 * 💡 (int) (x + y) 처럼 형변환을 붙였는데, int + int 는 이미 int 라서 필요 없다.
 * 💡 x / y 는 정수 나눗셈이라 10 / 3 = 3 이 된다. 소수점까지 원하면 (double) x / y.
 *
 * 문제의 실행 예
 *  *****
 *  +---Add
 *  ----Subtract
 *  *---Multiply
 *  /---Divide
 *  Q---Quit
 *  *****
 *  연산을선택하시요: +
 *  두 수를 공백으로 분리하여 입력하시요 : 10 20
 *  30
 *
 * 내 코드 실행 예
 *  연산 선택 : +
 *  두 수를 공백으로 분리하여 입력하시오 : 3 10
 *  13
 */
public class SimpleCalculatorSwitch {
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

        switch (op) {
            case '+' :
                System.out.println((int) (x + y));
                break;
            case '-' :
                System.out.println((int) (x - y));
                break;
            case '*' :
                System.out.println((int) (x * y));
                break;
            case '/' :
                if (y != 0) {
                    System.out.println(x / y);
                }
                else {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                break;
            default :
                System.out.println("잘못된 연산자입니다.");
                break;
        }

        sc.close();
    }
}
