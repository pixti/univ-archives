import java.util.Scanner;

/**
 * [4-4 반복문4] [실습] 소수 판별하기 (break)
 *
 * n 보다 작은 수 중 n 을 나누어 떨어지게 하는 수가 있으면 더 이상 반복 필요 X → break
 *
 * i == n 으로 소수를 판단하는 이유
 *  - 2 ~ n-1 중 나누어 떨어지는 수가 "없으면" 끝까지 돌고, 조건 i < n 이 깨질 때 i 는 n.
 *  - 나누어 떨어지는 수가 "있으면" break 로 중간에 나오므로 i 는 n 보다 작다.
 *  - 반복이 끝난 뒤 i 를 써야 하므로 int i; 를 for 문 "밖에서" 선언했다. (4-3 반복 변수의 범위)
 *
 * 💡 n = 1 이면 반복을 안 돌고 i = 2 ≠ 1 → "소수가 아닙니다" (1 은 소수가 아니므로 맞음)
 *    n = 2 이면 i = 2 = n → "소수입니다" (맞음)
 * 💡 실제로는 √n 까지만 검사해도 충분하다 (i * i <= n). 수업에서는 단순한 형태로 배웠다.
 * 💡 슬라이드의 클래스 이름은 ConditionOperation (교수님이 프로젝트 하나에서 계속 고쳐 쓴 이름).
 *    내용에 맞게 PrimeCheck 로 바꿨다.
 *
 * 실행 예
 *  n의 값을 입력하시오.
 *  17
 *  소수입니다.
 */
public class PrimeCheck {
    public static void main(String[] args) {
        System.out.println("n의 값을 입력하시오. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;
        for (i = 2; i < n; i++) {
            if ((n % i) == 0) break;
        }
        if (i == n) System.out.println("소수입니다.");
        else System.out.println("소수가 아닙니다.");
        sc.close();
    }
}
