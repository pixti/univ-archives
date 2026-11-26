import java.util.Scanner;

/**
 * [6강 실습] 문자열(1) - 1번 변형 문제 (split 사용 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class WordCountSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문장 ? ");
        String sentence = sc.nextLine();
        sentence = sentence.toLowerCase();

        // 공백, 콜론, 콤마, 점, 숫자(\d)가 1번 이상 연속되면 구분자로 분리
        String[] subs = sentence.split("( |:|,|\\.|\\d)+");
        // String[] subs = sentence.split("[ :,.0-9]+");   // 💡 같은 의미, 더 짧게

        int cnt = 0;
        for (int i = 0; i < subs.length; i++) {
            // ❌ 처음 코드 : "" 는 null 이 아니라서 맨 앞의 빈 문자열까지 세어 버림 → 2
            // System.out.println(subs[i]);
            // if (subs[i] != null) { cnt++; }

            // ✅ 빈 문자열("")이 아닌 경우만 카운트하고 출력
            if (!subs[i].isEmpty()) {
                System.out.println(subs[i]);
                cnt++;
            }
        }
        System.out.println("영단어의 개수는 : " + cnt);
        sc.close();
    }
}
