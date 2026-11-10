import java.util.Scanner;

/**
 * [6강 과제] 문자열(1) - 1번 문제 (내가 작성한 코드)
 *
 * 영문 문자열을 입력받아 단어의 순서를 거꾸로 출력하시오.
 *      영문 문자열을 입력하세요 : programming in c
 *      c in programming
 *
 * 포인트
 *  - input.trim().split("\\s+")
 *      trim()       앞뒤 공백 제거
 *      \\s+         공백 문자(스페이스, 탭 등) 가 1개 이상 → 단어 사이 공백이 여러 칸이어도 한 번에 자름
 *  - 배열을 뒤에서부터(words.length - 1 → 0) 출력
 *  - if (i > 0) 일 때만 공백 출력 → 마지막 단어 뒤에 공백이 붙지 않게
 *
 * 📝 필기 (AI 설명) trim() 을 하는 이유
 *  - 입력 앞에 공백이 있으면 (" programming in c") split 결과의 맨 앞에 빈 문자열이 생긴다.
 *        " programming in c".split("\\s+")  →  ["", "programming", "in", "c"]
 *    → 거꾸로 출력하면 마지막에 공백 + 빈 문자열이 붙어 "c in programming " 처럼 된다.
 *  - (맨 뒤의 공백은 split 이 끝의 빈 문자열을 자동으로 지워 주지만, 맨 앞은 남는다 → 실습 1번과 같은 원리)
 *
 * 📝 필기 (AI 설명) trim() 없이 해결하는 방법
 *  - 방법 A : 반복문에서 빈 문자열을 건너뛴다.  if (words[i].isEmpty()) continue;
 *  - 방법 B : Scanner 의 next() 로 단어를 하나씩 읽는다. next() 는 공백을 자동으로 건너뛴다.
 *
 * 📝 필기 "정규식으로 하는방법이 없는지 물어본거"
 *  → AI 가 알려준 방법 1 : ReverseWordsRegexSplit.java  (split 정규식에 앞/뒤 공백까지 넣는 방법)
 *  → AI 가 알려준 방법 2 : ReverseWordsMatcher.java     (Pattern / Matcher 로 단어만 찾는 방법, 가장 표준적)
 *
 * 실행 예
 *  영문 문자열을 입력하세요 : pr sdf sgd
 *  sgd sdf pr
 *
 *  영문 문자열을 입력하세요 : programming in c
 *  c in programming
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
