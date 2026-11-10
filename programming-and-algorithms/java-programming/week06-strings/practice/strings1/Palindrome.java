import java.util.Scanner;

/**
 * [6강 실습] 문자열(1) - 2번 문제 (회문 검사 - 공백 제거 버전, 내가 작성한 코드)
 *
 * 문자열을 입력받아 회문(palindrome, 앞에서 읽으나 뒤에서 읽으나 같은 문장)인지 판별하시오.
 *  - 대소문자와 공백은 무시한다.
 *      "Able was I ere I saw Elba" → 회문입니다
 *      "I love you"                → 회문이 아닙니다
 *      "소주 주소"                  → 회문입니다
 *      "국제 경제국"                → 회문입니다
 *  - 문제의 입력 안내 : "문자열을 입력하세요 : "  (내 코드는 "문장 ? " 으로 작성)
 *
 * 포인트
 *  1. nextLine()            : 띄어쓰기가 들어간 문장 전체를 읽는다. (next() 는 첫 단어만)
 *  2. toLowerCase()         : "Able" 과 "elbA" 의 A / a 를 같게 만든다.
 *  3. replaceAll(" ", "")   : 띄어쓰기(공백) 제거
 *  4. 양 끝에서 중앙으로 비교 : chars[i] 와 chars[길이-1-i] 를 길이/2 번만 비교하면 된다.
 *     하나라도 다르면 바로 false 로 바꾸고 break.
 *
 *        a b l e w a s i e r e i s a w e l b a
 *        ↑ ─────────────────────────────────── ↑   i = 0
 *          ↑ ─────────────────────────────── ↑     i = 1 ...
 *
 * 💡 StringBuilder 로 뒤집어서 비교하는 방법도 있다. (6-3 reverse)
 *      new StringBuilder(sentence).reverse().toString().equals(sentence)
 *
 * 실행 예
 *  문장 ? 기러기
 *  회문 !
 *  문장 ? Able was I ere I saw Elba
 *  회문 !
 *  문장 ? I love you
 *  회문 아님!
 *  문장 ? 국제 경제국
 *  회문 !
 */
public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문장 ? ");
        String sentence = sc.nextLine();             // 띄어쓰기가 들어간 문장 전체를 읽어온다.
        sentence = sentence.toLowerCase();           // 소문자로 변환
        sentence = sentence.replaceAll(" ", "");     // 띄어쓰기(공백) 제거

        char[] chars = sentence.toCharArray();
        boolean isPalindrome = true;

        // 회문 검사 (양 끝에서 중앙으로 비교)
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }

        // 결과 출력
        if (isPalindrome) {
            System.out.println("회문 !");
        } else {
            System.out.println("회문 아님!");
        }
        sc.close();
    }
}
