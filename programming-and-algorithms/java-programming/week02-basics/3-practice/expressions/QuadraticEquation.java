import java.util.Scanner;

/**
 * [2강 실습] 수식 - 5번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
