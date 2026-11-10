import java.util.Scanner;

/**
 * [6강 과제] 문자열(1) - 1번 문제 (AI 가 알려준 방법 1 : trim 없이 split 정규식만으로)
 *
 * 📝 필기 "정규식으로 하는방법이 없는지 물어본거" → AI 의 답변 코드
 *
 *  정규식 해설 : "^\\s+|\\s+$|\\s+"
 *      ^\\s+    맨 앞 공백들     OR
 *      \\s+$    맨 뒤 공백들     OR
 *      \\s+     단어 사이 공백
 *  - 맨 앞 공백 제거로 인해 words[0] 에 빈 문자열이 생성된 경우를 대비해 역순 출력할 때 빈 값을 건너뛴다.
 *
 * 💡 사실 split 은 "앞쪽 구분자 → 맨 앞에 빈 문자열" 을 만드는 성질이 있어서, 정규식에 ^\\s+ 를 넣어도
 *    words[0] 의 빈 문자열은 사라지지 않는다. 결국 \\s+ 하나만 쓴 것과 결과 배열이 같다.
 *    → 정규식만으로 앞 공백 문제를 없앨 수는 없고, 빈 문자열을 건너뛰는 isEmpty 검사가 핵심이다.
 *
 * ⚠ AI 코드의 버그 : 공백 출력 조건 if (i > 0 && !words[0].isEmpty())
 *    입력 앞에 공백이 있으면 words[0] 이 "" 이므로 !words[0].isEmpty() 가 항상 false
 *    → 단어 사이 공백이 하나도 출력되지 않는다.
 *        입력 "  a b"  →  words = ["", "a", "b"]  →  출력 "ba"   (기대값 "b a")
 *    (앞 공백이 없으면 정상 출력된다. "공백을 찍을지" 를 words[0] 이 비었는지에 묶어 버린 것이 원인)
 *    ✅ 수정 : 빈 문자열을 뺀 단어만 모아서 "처음 출력하는 단어가 아니면 앞에 공백" 을 찍는다. (first 변수)
 *
 * 실행 예
 *  영문 문자열을 입력하세요 :   programming in c
 *  AI 원본 : cinprogramming
 *  수정    : c in programming
 */
public class ReverseWordsRegexSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("영문 문자열을 입력하세요 : ");
        String input = sc.nextLine();

        // 정규식 해설: ^\\s+ (맨 앞 공백들) OR \\s+$ (맨 뒤 공백들) OR \\s+ (단어 사이 공백)
        String[] words = input.split("^\\s+|\\s+$|\\s+");

        // ---- ⚠ AI 원본 : 맨 앞 공백이 있으면 단어 사이 공백이 사라짐 ----
        System.out.print("AI 원본 : ");
        // 맨 앞 공백 제거로 인해 words[0]에 빈 문자열이 생성된 경우를 대비해 역순 출력
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {                      // 맨 앞 공백 분할로 생긴 빈 값 제외
                System.out.print(words[i]);
                if (i > 0 && !words[0].isEmpty()) System.out.print(" ");
            }
        }
        System.out.println();

        // ---- ✅ 수정 ----
        System.out.print("수정    : ");
        boolean first = true;
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].isEmpty()) continue;               // 빈 값 제외
            if (!first) System.out.print(" ");              // 두 번째 단어부터 앞에 공백
            System.out.print(words[i]);
            first = false;
        }
        System.out.println();
        sc.close();
    }
}
