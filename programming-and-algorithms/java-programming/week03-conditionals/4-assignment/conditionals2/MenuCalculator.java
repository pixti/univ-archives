import java.util.Scanner;

/**
 * [3강 과제] 조건문2 - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
