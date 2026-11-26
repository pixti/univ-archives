import java.util.Scanner;

/**
 * [4강 과제] 반복문2 - 1번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MultiplesOfThreeFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        System.out.print("정수를 입력하세요 : ");
        num = sc.nextInt();

        if (num < 0) {
            System.out.println("오류");
        } else {
            for (int i = 3; i <= num; i += 3) {
                System.out.println("[" + i + "]");
            }
        }
        sc.close();
    }
}
