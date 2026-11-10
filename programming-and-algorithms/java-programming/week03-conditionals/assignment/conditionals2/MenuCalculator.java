import java.util.Scanner;

/**
 * [3강 과제] 조건문2 - 2번 문제
 * 간단한 계산기 프로그램을 작성하여 보자. (switch 문 사용)
 * 먼저 사용자로부터 하나의 연산 문자 (+, -, *, /, Q) 를 입력받는다.
 * 이어서 사용자로부터 2개의 숫자를 입력 받는다.
 * 연산 문자에 맞는 계산을 한 후 그 결과를 출력한다. 연산 문자 중 Q 는 프로그램 종료를 의미한다.
 *  → 실습 조건문1 2번 (practice/conditionals1/SimpleCalculatorSwitch.java) 과 같은 문제. 실습 버전과 비교해 보기.
 *
 * 실습 버전에서 달라진 점
 *  - 연산자가 올바른지 숫자를 입력받기 "전에" 먼저 검사한다.
 *    → 잘못된 연산자를 입력하면 숫자를 입력할 필요 없이 바로 종료된다.
 *  - 그래서 switch 안에 default 가 필요 없어졌다. (이미 +, -, *, / 만 남았으므로)
 *  - 변수 이름을 firstNumber, secondNumber 처럼 의미가 드러나게 지었다.
 *
 * 💡 "+, -, *, / 중 어느 것도 아니다" 는 != 를 && 로 묶는다.
 *      operator != '+' && operator != '-' && operator != '*' && operator != '/'
 *    || 로 묶으면 어떤 문자든 최소 하나와는 다르므로 항상 참이 되어 버린다.
 *    (드 모르간 법칙 : !(A || B) == !A && !B)
 *
 * 문제의 실행 예 : 실습 버전(SimpleCalculatorSwitch.java) 주석 참고
 *
 * 내 코드 실행 예
 *  연산 선택 : +
 *  두 수를 공백으로 분리하여 입력하시오 : 6 4
 *  10
 */
public class MenuCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 계산기 메뉴 출력
        System.out.println("*******************");
        System.out.println("+ ------- 덧셈");
        System.out.println("- ------- 뺄셈");
        System.out.println("* ------- 곱셈");
        System.out.println("/ ------- 나눗셈");
        System.out.println("Q ------- Quit");
        System.out.println("*******************");

        // 연산자 입력
        System.out.print("연산 선택 : ");
        char operator = sc.next().charAt(0);

        // Q 또는 q를 입력하면 프로그램 종료
        if (operator == 'Q' || operator == 'q') {
            System.out.println("프로그램을 종료합니다.");
            sc.close();
            return;
        }

        // 입력된 연산자가 올바른 연산자인지 확인
        if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
            System.out.println("잘못된 연산자입니다.");
            sc.close();
            return;
        }

        // 두 정수 입력
        System.out.print("두 수를 공백으로 분리하여 입력하시오 : ");
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();

        // 입력된 연산자에 따라 계산
        switch (operator) {
            case '+':
                System.out.println(firstNumber + secondNumber);
                break;
            case '-':
                System.out.println(firstNumber - secondNumber);
                break;
            case '*':
                System.out.println(firstNumber * secondNumber);
                break;
            case '/':
                // 0으로 나누는 경우를 방지
                if (secondNumber == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                }
                else {
                    System.out.println(firstNumber / secondNumber);
                }
                break;
        }

        sc.close();
    }
}
