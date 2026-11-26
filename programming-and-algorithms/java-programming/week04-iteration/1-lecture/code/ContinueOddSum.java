/**
 * [4-4 반복문4] continue 문 - 1 ~ 100 홀수의 합
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ContinueOddSum {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if ((i % 2) == 0) continue;
            sum += i;   // 짝수일때 실행되지 않음
        }
        System.out.println("홀수의 합 : " + sum);
    }
}
