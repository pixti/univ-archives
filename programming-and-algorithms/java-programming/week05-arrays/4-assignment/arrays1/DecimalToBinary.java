import java.util.Scanner;

/**
 * [5강 과제] 배열(1) - 3번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num;
        int[] binary = new int[64];
        int index = 0;

        System.out.print("10진수를 입력하세요. : ");
        num = sc.nextLong();

        // 10진수를 2진수로 변환
        while (num > 0) {
            binary[index] = (int) (num % 2);
            num = num / 2;
            index++;
        }

        // 역순으로 출력
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(binary[i]);
        }
        sc.close();
    }
}
