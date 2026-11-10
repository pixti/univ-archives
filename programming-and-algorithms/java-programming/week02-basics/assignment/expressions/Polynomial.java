import java.util.Scanner;

/**
 * [2강 과제] 수식 - 1번
 * 사용자로부터 x 의 값을 실수로 입력받아서 다음과 같은 다항식의 값을 구하는 프로그램을 작성하라.
 *
 *     5x³ + 6x² - 8x + 2
 *
 * 포인트
 *  - 자바에는 거듭제곱 연산자가 없다. (파이썬의 ** 없음, ^ 는 비트 XOR!)
 *  - x * x * x 처럼 곱셈으로 쓰거나 Math.pow(x, 3) 사용
 *
 * 실행 예
 *  x의 값을 입력하시오:3
 *  값은 167.0 입니다.
 *
 * ⚠ 과제 문서의 예시 화면에는 x = 3 일 때 "값은 27 입니다." 로 나와 있지만,
 *   5·27 + 6·9 - 8·3 + 2 = 135 + 54 - 24 + 2 = 167 이 맞다. (예시 화면이 다른 식의 결과로 보임)
 */
public class Polynomial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("x의 값을 입력하시오:");
        double x = sc.nextDouble();
        sc.close();

        double result = 5 * x * x * x + 6 * x * x - 8 * x + 2;
        // double result = 5 * Math.pow(x, 3) + 6 * Math.pow(x, 2) - 8 * x + 2; // 같은 결과

        System.out.println("값은 " + result + " 입니다.");
    }
}
