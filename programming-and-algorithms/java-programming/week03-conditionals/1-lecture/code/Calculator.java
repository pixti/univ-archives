import java.util.Scanner;

/**
 * [3-2 조건문2] [실습] 메뉴 방식의 사칙 연산 (if - else if 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
