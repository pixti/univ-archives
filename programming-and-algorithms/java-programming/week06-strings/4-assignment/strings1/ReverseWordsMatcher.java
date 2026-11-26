import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [6강 과제] 문자열(1) - 1번 문제 (다른 풀이 2 : Pattern / Matcher, 가장 표준적인 방법)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ReverseWordsMatcher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("영문 문자열을 입력하세요 : ");
        String input = sc.nextLine();

        // \\S+ : 공백이 아닌 문자가 1개 이상 이어지는 단어 패턴
        Pattern pattern = Pattern.compile("\\S+");
        Matcher matcher = pattern.matcher(input);

        ArrayList<String> words = new ArrayList<>();
        // 매칭되는 단어만 하나씩 찾아 리스트에 추가 (앞뒤/중간 공백 자동 무시됨)
        while (matcher.find()) {
            words.add(matcher.group());
        }

        // 역순으로 뒤집기
        Collections.reverse(words);

        // 결과 출력
        System.out.println(String.join(" ", words));
        sc.close();
    }
}
