import java.util.Scanner;

/**
 * [6강 과제] 문자열(1) - 1번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ReverseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("영문 문자열을 입력하세요 : ");
        String input = sc.nextLine();

        String[] words = input.trim().split("\\s+");

        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i]);
            if (i > 0) System.out.print(" ");
        }
        System.out.println();
        sc.close();
    }
}
