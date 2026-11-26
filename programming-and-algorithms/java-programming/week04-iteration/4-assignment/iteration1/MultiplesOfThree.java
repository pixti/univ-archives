import java.util.Scanner;

/**
 * [4강 과제] 반복문1 - 1번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MultiplesOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num, i;
        System.out.print("정수를 입력하세요 : ");
        num = sc.nextInt();

        if (num < 0) {
            System.out.println("오류");
        } else {
            i = 3;

            while (i <= num) {
                System.out.println("[" + i + "]");
                i += 3;
            }
        }
        sc.close();
    }
}
