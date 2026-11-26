import java.util.Scanner;

/**
 * [6강 과제] 문자열(1) - 3번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class FindReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문장을 입력하세요 : ");
        String text = sc.nextLine();
        System.out.print("찾을 문자열: ");
        String target = sc.nextLine();
        System.out.print("바꿀 문자열: ");
        String replacement = sc.nextLine();

        String result = text.replace(target, replacement);
        System.out.println(result);
        sc.close();
    }
}
