import java.util.Scanner;

/**
 * [2-7 수식3] [실습] 조건 연산자 실습하기
 *
 * 조건 연산자 ( ?: ) - 자바의 유일한 삼항 연산자
 *  형태: 조건 ? 피연산자1 : 피연산자2
 *  조건이 true 이면 피연산자1, false 이면 피연산자2 가 결과값이 된다.
 *  → if-else 를 한 줄로 간단히 쓸 수 있다.
 *
 *  a   = c > 0 ? 1 : 0;   // c 가 0 보다 크면 1, 아니면 0 을 a 에 대입
 *  max = a > b ? a : b;   // a, b 중 최대값
 *  abs = a > 0 ? a : -a;  // a 의 절대값
 *
 * 프로그램: 두 정수(음수 가능)를 입력받아 절대값의 합과 절대값의 최대값을 출력
 */
public class ConditionOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 숫자 (음수도 가능) >> ");
        int s1 = sc.nextInt();
        System.out.println("두 번째 숫자 (음수도 가능) >> ");
        int s2 = sc.nextInt();
        sc.close();

        s1 = s1 > 0 ? s1 : -s1; // s1 절대값을 구한다
        s2 = s2 > 0 ? s2 : -s2; // s2 절대값을 구한다
        int sum = s1 + s2;
        int max = s1 > s2 ? s1 : s2;
        System.out.println("절대값 합 : " + sum);
        System.out.println("절대값 최대 : " + max);
    }
}
