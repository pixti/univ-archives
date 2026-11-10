import java.util.Scanner;

/**
 * [2강 실습] 수식 - 5번 문제
 * 계수 a, b, c 를 입력받아 2차 방정식 ax² + bx + c = 0 의 두 근을 구하는 프로그램
 * (Eclipse 에서는 Problem5.java 로 작성했던 코드)
 *
 * 📝 필기
 *  - 2차 방정식의 근은 ( -b ± √(b² - 4ac) ) / 2a 이므로 이를 그대로 수식으로 옮긴다.
 *  - 제곱근은 Math.sqrt() 사용.
 *  - import java.lang.Math; 를 하지 않아도 된다.
 *    java.lang 은 기본적으로 import 되는 클래스 패키지이다.
 *  - 주의: 자바에서 ^ 는 거듭제곱이 아니라 비트 XOR 연산자! b^2 가 아니라 b*b 로 써야 한다.
 *  - 주의: (-b + tmp) / 2*a 처럼 쓰면 "/2 한 다음 *a" 가 되므로 반드시 (2*a) 로 괄호를 쳐야 한다.
 *
 * 실행 예
 *  a ? 4
 *  b ? 5
 *  c ? -1
 *  2차 방정식의 근은  0.17539052967910607 또는 -1.425390529679106입니다.
 *
 * 참고) 판별식 b² - 4ac 가 음수이면 실근이 없어서 Math.sqrt() 결과가 NaN(Not a Number)이 된다.
 *       (조건문을 배운 뒤에는 if 로 판별식을 먼저 검사하면 된다.)
 */
public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("a ? ");
        int a = sc.nextInt();
        System.out.print("b ? ");
        int b = sc.nextInt();
        System.out.print("c ? ");
        int c = sc.nextInt();
        sc.close();

        // import java.lang.Math; 하지 않아도 java.lang 은 기본적으로 import 되는 클래스 패키지이다.
        double tmp = Math.sqrt(b * b - 4 * a * c);
        double result1 = (-b + tmp) / (2 * a);
        double result2 = (-b - tmp) / (2 * a);
        System.out.println("2차 방정식의 근은  " + result1 + " 또는 " + result2 + "입니다.");
    }
}
