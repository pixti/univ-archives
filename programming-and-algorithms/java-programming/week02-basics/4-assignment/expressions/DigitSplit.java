import java.util.Scanner;

/**
 * [2강 과제] 수식 - 5번
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class DigitSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하시오.:");
        int n = sc.nextInt();
        sc.close();

        int thousand = n / 1000;
        int hundred = n / 100 % 10;
        int ten = n / 10 % 10;
        int one = n % 10;

        System.out.println("천의 자리: " + thousand);
        System.out.println("백의 자리: " + hundred);
        System.out.println("십의 자리: " + ten);
        System.out.println("일의 자리: " + one);
    }
}
