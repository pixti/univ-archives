import java.util.Scanner;

/**
 * [5강 과제] 배열(1) - 1번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ReverseInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        System.out.println("10개의 정수 입력");
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("역순 출력 : ");
        for (int i = 9; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
