import java.util.Scanner;

/**
 * [6강 과제] 문자열(1) - 1번 문제 (다른 풀이 1 : trim 없이 split 정규식만으로)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ReverseWordsRegexSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("영문 문자열을 입력하세요 : ");
        String input = sc.nextLine();

        // 정규식 해설: ^\\s+ (맨 앞 공백들) OR \\s+$ (맨 뒤 공백들) OR \\s+ (단어 사이 공백)
        String[] words = input.split("^\\s+|\\s+$|\\s+");

        // ---- ⚠ 틀린 코드 : 맨 앞 공백이 있으면 단어 사이 공백이 사라짐 ----
        System.out.print("틀린 코드 : ");
        // 맨 앞 공백 제거로 인해 words[0]에 빈 문자열이 생성된 경우를 대비해 역순 출력
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {                      // 맨 앞 공백 분할로 생긴 빈 값 제외
                System.out.print(words[i]);
                if (i > 0 && !words[0].isEmpty()) System.out.print(" ");
            }
        }
        System.out.println();

        // ---- ✅ 고친 코드 ----
        System.out.print("고친 코드 : ");
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
