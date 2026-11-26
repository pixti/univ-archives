import java.util.Scanner;

/**
 * [6강 실습] 문자열(1) - 4번 문제 (단어 빈도수)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class WordFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문장을 입력하세요 : ");
        String sentence = sc.nextLine();                 // 띄어쓰기가 들어간 문장 전체를 읽어온다.

        sentence = sentence.toLowerCase();               // 소문자로 변환
        String[] subs = sentence.split("( |,|\\.)+");    // 공백을 기준으로 단어를 나눈다. (쉼표, 마침표 포함)

        for (int i = 0; i < subs.length; i++) {
            if (subs[i] != null) {                       // 이미 처리되어 null이 된 단어는 건너뜀
                int cnt = 0;
                for (int j = i + 1; j < subs.length; j++) {
                    if (subs[j] != null && subs[i].equals(subs[j])) {
                        cnt++;
                        subs[j] = null;                  // 중복 단어는 null로 변경하여 제외
                    }
                }
                // (cnt + 1) 형태로 괄호를 묶어주어야 숫자 덧셈이 정상 처리됨
                System.out.println(subs[i] + "\t" + (cnt + 1));
            }
        }
        sc.close();
    }
}
