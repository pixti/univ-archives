import java.util.Scanner;

/**
 * [4-3 반복문3] [실습] 팩토리얼 구하기
 *
 * 1 ~ n 까지의 곱(n!)을 구한다.
 *
 * 포인트
 *  - 초기식 i = 1, factorial = 1 : 식 두 개를 쉼표로 이어 썼다. 두 변수는 for 앞에서 선언.
 *  - 주석의 i = n, factorial = 1; i >= 1; i-- 는 n 부터 1 까지 "감소" 하며 곱하는 방법.
 *    곱셈은 순서와 상관없으므로 결과가 같다.
 *
 * 💡 오버플로 (슬라이드 주석 : "큰숫자는 double형 선언해야 오버플로 발생 x")
 *  - int 는 약 21억(2,147,483,647)까지만 담는다.
 *    12! = 479,001,600 은 괜찮지만 13! = 6,227,020,800 은 범위를 넘어 1932053504 같은 엉뚱한 값이 나온다.
 *  - double 은 아주 큰 수까지 "근사값" 으로 담는다.
 *    정확한 정수가 필요하면 long (20! 까지 정확), 더 크면 java.math.BigInteger.
 *
 * 실행 예
 *  n의 값을 입력하시오.
 *  5
 *  1 ~ 5까지의 곱은 120입니다.
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println("n의 값을 입력하시오. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int i, factorial;   // 큰숫자는 double형 선언해야 오버플로 발생 x
        for (i = 1, factorial = 1; i <= n; i++) {   // i=n, factorial=1; i >= 1; i--
            factorial = factorial * i;              // 위의 조건식은 감소 방법
        }
        System.out.println("1 ~ " + n + "까지의 곱은 " + factorial + "입니다.");
    }
}
