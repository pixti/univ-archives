import java.util.Scanner;

/**
 * [3-3 조건문3] [실습] 메뉴 방식의 사칙 연산 (switch 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
