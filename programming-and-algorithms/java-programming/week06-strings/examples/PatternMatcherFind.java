import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [6-4] 정규식 관련 클래스 - Pattern, Matcher 클래스
 *
 * 포인트
 *  - Pattern.compile(정규식) 으로 Pattern 객체를 만든 뒤, p.matcher(입력) 으로 Matcher 객체를 만든다.
 *  - Matcher 의 검사 메소드 (반환값은 모두 boolean)
 *      matches()   : 입력 "전체" 가 패턴과 일치하는지
 *      lookingAt() : 입력의 "앞부분(prefix)" 이 패턴과 일치하는지
 *      find()      : 패턴과 부합되는 부분을 "계속" 찾음 (호출할 때마다 다음 것)
 *  - 일치한 위치와 내용 : start() (시작 인덱스), end() (끝 인덱스 + 1), group() (일치한 문자열)
 *  - (cat|dog) : cat 또는 dog.  | 는 OR
 *
 * 💡 end() 는 일치한 부분 "다음" 인덱스를 돌려준다. 그래서 마지막 글자 위치를 보여주려고 m.end()-1 로 출력한다.
 * 💡 Pattern / Matcher 는 java.lang 이 아니라 java.util.regex 패키지에 있어서 import 가 필요하다.
 *    (과제 문자열2 4번 📝 AI 설명 참고)
 *
 * 실행 결과
 *  ---- "I have a cat, but I like my dog better." / (cat|dog) ----
 *  matches   : false
 *  lookingAt : false
 *  cat (9 ~ 11)
 *  dog (28 ~ 30)
 *  ---- 꽃 · 고향 · 산골 ----
 *  6에서 부터7까지 고향 발견
 *  10에서 부터10까지 꽃 발견
 *  15에서 부터16까지 산골 발견
 *  22에서 부터22까지 꽃 발견
 *  27에서 부터27까지 꽃 발견
 */
public class PatternMatcherFind {
    public static void main(String[] args) {
        // ---- Pattern, Matcher 생성 ----
        System.out.println("---- \"I have a cat, but I like my dog better.\" / (cat|dog) ----");
        String input = "I have a cat, but I like my dog better.";
        Pattern p = Pattern.compile("(cat|dog)");
        Matcher m = p.matcher(input);

        System.out.println("matches   : " + m.matches());     // 전체가 cat 또는 dog 인가? → false
        System.out.println("lookingAt : " + m.lookingAt());   // 앞부분이 cat 또는 dog 인가? → false
        m.reset();                                            // 💡 matches / lookingAt 후 처음부터 다시 찾기
        while (m.find()) {
            System.out.println(m.group() + " (" + m.start() + " ~ " + (m.end() - 1) + ")");
        }

        // ---- "꽃" or "고향" or "산골" 찾아서 위치와 내용 출력 예 ----
        System.out.println("---- 꽃 · 고향 · 산골 ----");
        String input2 = "나의 살던 고향은 꽃 피는 산골 봉숭아 꽃 살구 꽃";
        Pattern p2 = Pattern.compile("(꽃|고향|산골)");
        Matcher m2 = p2.matcher(input2);
        while (m2.find()) {
            System.out.println(m2.start() + "에서 부터" + (m2.end() - 1) +
                    "까지 " + m2.group() + " 발견");
        }
    }
}
