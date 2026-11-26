import java.util.Scanner;

/**
 * [6강 실습] 문자열(1) - 2번 문제 (회문 검사 - 정규식으로 특수문자까지 제거하는 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class PalindromeRegex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문장 ? ");
        String sentence = sc.nextLine();                    // 1. 띄어쓰기가 들어간 문장 전체를 읽어온다.
        sentence = sentence.toLowerCase();                  // 2. 소문자로 변환
        sentence = sentence.replaceAll("[^a-z0-9]", "");    // 3. 알파벳 소문자 및 숫자가 아닌 특수문자/공백 제거
        // sentence = sentence.replaceAll("[^a-z0-9가-힣]", "");   // 💡 한글도 남기려면

        char[] chars = sentence.toCharArray();
        boolean isPalindrome = true;

        // 회문 검사 (양 끝에서 중앙으로 비교)
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }

        // 4. 결과 출력
        if (isPalindrome) {
            System.out.println("회문 !");
        } else {
            System.out.println("회문 아님!");
        }
        sc.close();
    }
}
