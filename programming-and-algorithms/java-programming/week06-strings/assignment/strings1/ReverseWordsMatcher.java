import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [6강 과제] 문자열(1) - 1번 문제 (AI 가 알려준 방법 2 : Pattern / Matcher, 가장 표준적인 방법)
 *
 * 📝 필기 (AI 설명)
 *  - "자르는(split)" 대신 "단어를 찾는(find)" 발상
 *      \\S+ : 공백이 아닌 문자(\S) 가 1개 이상 이어지는 단어 패턴
 *  - while (matcher.find()) 로 매칭되는 단어만 하나씩 찾아 리스트에 추가
 *    → 앞뒤 / 중간 공백이 몇 개든 자동으로 무시된다. (빈 문자열이 생길 일이 없음)
 *  - Collections.reverse(words) : 리스트를 역순으로 뒤집기
 *  - String.join(" ", words)    : 리스트의 원소 사이사이에 " " 를 넣어 하나의 문자열로 → 마지막 공백 걱정도 없음
 *
 * 💡 ArrayList 는 크기가 자동으로 늘어나는 배열 (나중에 컬렉션 단원에서 배움).
 *    단어 개수를 미리 알 수 없어서 배열 대신 사용했다.
 *    add(값) : 뒤에 추가,  size() : 개수,  get(i) : i 번째 값
 *
 * 실행 예
 *  영문 문자열을 입력하세요 :   programming   in c
 *  c in programming
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
