/**
 * [4강 과제] 반복문1 - 3번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Fibonacci {
    public static void main(String[] args) {

        int a = 0, b = 1, c;
        while (a < 5000) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
    }
}
