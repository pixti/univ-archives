import java.util.Scanner;

/**
 * [2강 과제] 수식 - 1번
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
