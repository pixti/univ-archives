/**
 * [4-1 반복문1] while 문 - 1 ~ 5까지의 곱
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class WhileProduct {
    public static void main(String[] args) {
        int i = 1, sum = 1;     // 곱이므로 1 로 초기화
        while (i <= 5) {        // while (i < 6) {
            sum = sum * i;
            i++;
        }
        System.out.println("곱 : " + sum);
    }
}
