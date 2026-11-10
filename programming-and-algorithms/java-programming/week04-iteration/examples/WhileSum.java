/**
 * [4-1 반복문1] while 문 - 1 ~ 5까지의 합
 *
 * 반복문 없이 쓰면
 *   int sum = 0;
 *   sum = sum + 1;  // 1까지 합
 *   sum = sum + 2;  // 2까지 합
 *   sum = sum + 3;  // 3까지 합
 *   sum = sum + 4;  // 4까지 합
 *   sum = sum + 5;  // 5까지 합
 *  → 바뀌는 부분(1 ~ 5)을 변수 i 로 바꾸면 매번 sum = sum + i; 라는 같은 문장이 된다.
 *
 *   (i : 1)  sum = sum + i;   → sum = 1
 *   (i : 2)  sum = sum + i;   → sum = 3
 *   (i : 3)  sum = sum + i;   → sum = 6
 *   (i : 4)  sum = sum + i;   → sum = 10
 *   (i : 5)  sum = sum + i;   → sum = 15
 *
 * 💡 합을 구할 때는 sum 을 0 (덧셈의 항등원)에서 시작한다.
 *    곱은 1 에서 시작해야 한다 → WhileProduct.java
 *
 * 실행 예
 *  합 : 15
 */
public class WhileSum {
    public static void main(String[] args) {
        int i = 1, sum = 0;
        while (i <= 5) {        // while (i < 6) { 와 같은 의미
            sum = sum + i;
            i++;
        }
        System.out.println("합 : " + sum);
    }
}
