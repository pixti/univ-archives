import java.util.Scanner;

/**
 * [6강 과제] 문자열(1) - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class SwapName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요(성 이름)(ex : HONG GIL DONG) : ");
        String input = sc.nextLine();

        String[] parts = input.trim().toLowerCase().split("\\s+");

        if (parts.length > 0) {
            // 이름(FirstName)은 두 번째 단어부터 마지막 단어까지 (parts[1] ~ parts[length-1])
            for (int i = 1; i < parts.length; i++) {
                System.out.print(parts[i] + " ");
            }
            // 성(LastName)은 첫 번째 단어 (parts[0])
            System.out.println(parts[0]);
        }
        sc.close();
    }
}
