/**
 * [4-1 반복문1] while 문 - 1 ~ 5까지의 합
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
