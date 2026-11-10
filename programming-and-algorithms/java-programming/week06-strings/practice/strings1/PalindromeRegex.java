import java.util.Scanner;

/**
 * [6강 실습] 문자열(1) - 2번 문제 (회문 검사 - 정규식으로 특수문자까지 제거하는 버전)
 *
 * Palindrome.java 에서 replaceAll(" ", "") 한 줄만 replaceAll("[^a-z0-9]", "") 로 바꾼 버전.
 *  - [^a-z0-9] : 대괄호 안의 ^ 는 "제외(NOT)". 알파벳 소문자 및 숫자가 "아닌" 문자 1개
 *    → 공백뿐 아니라 쉼표, 콜론, 느낌표 같은 특수문자까지 모두 제거
 *  - 먼저 toLowerCase() 를 했기 때문에 대문자는 이미 없다. (순서가 바뀌면 대문자가 다 지워진다!)
 *
 * 📝 필기 (AI 설명) 두 방법 비교
 *      입력                                방법 1 : replaceAll(" ", "")    방법 2 : replaceAll("[^a-z0-9]", "")
 *      A man, a plan, a canal: Panama!     "aman,aplan,acanal:panama!"     "amanaplanacanalpanama"
 *                                          → 회문 아님!                    → 회문 !
 *      race car                            "racecar" → 회문 !              "racecar" → 회문 !
 *      No, on!                             "no,on!"  → 회문 아님!          "noon"    → 회문 !
 *  - 시험이나 간단한 과제에서는 보통 방법 1 (공백만 제거) 을 기대하고,
 *    코딩 테스트에서는 특수문자까지 무시하는 방법 2 를 많이 쓴다.
 *
 * ⚠ [^a-z0-9] 는 한글도 "알파벳 소문자·숫자가 아닌 문자" 로 보고 전부 지워 버린다.
 *    "소주 주소" → "" (빈 문자열) → 반복문을 한 번도 안 돌아서 isPalindrome = true → 회문 !
 *    결과는 맞아 보이지만 "검사를 하지 않고" 통과한 것이고, "가나다" 처럼 회문이 아닌 한글도 회문 ! 이 된다.
 *    한글까지 다루려면 [^a-z0-9가-힣] 처럼 한글을 남기도록 해야 한다. (아래 주석 참고)
 *
 * 실행 예
 *  문장 ? A man, a plan, a canal: Panama!
 *  회문 !
 *  문장 ? No, on!
 *  회문 !
 *  문장 ? 가나다
 *  회문 !          ← ⚠ 한글이 모두 지워져서 생기는 오답 ([^a-z0-9가-힣] 이면 회문 아님!)
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
