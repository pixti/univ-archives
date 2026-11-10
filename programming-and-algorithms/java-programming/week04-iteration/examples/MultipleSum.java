import java.util.Scanner;

/**
 * [4-3 반복문3] [실습] 1에서 n까지 3의 배수의 합 구하기
 *
 * 포인트
 *  - i 를 3 부터 "3씩 증가" (i += 3) → 3의 배수만 돈다.
 *  💡 1 부터 하나씩 올리며 if (i % 3 == 0) 으로 검사해도 되지만,
 *     3씩 건너뛰면 검사가 필요 없고 반복 횟수도 1/3 로 줄어든다.
 *     과제 1번(3의 배수 출력)도 같은 방법이다.
 *
 * 실행 예
 *  n의 값을 입력하시오.
 *  10
 *  10까지의 3의 배수의 합은 18입니다.
 */
public class MultipleSum {
    public static void main(String[] args) {
        System.out.println("n의 값을 입력하시오. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int i, sum = 0;
        for (i = 3; i <= n; i += 3) {
            sum = sum + i;
        }
        System.out.println(n + "까지의 3의 배수의 합은 " + sum + "입니다.");
        sc.close();
    }
}
