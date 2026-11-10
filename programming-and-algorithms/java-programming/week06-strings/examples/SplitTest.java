/**
 * [6-2] String 클래스 - 문자열 분리 (split)
 *
 * 포인트
 *  - split(분리문자) : 분리 문자를 기준으로 문자열을 잘라 String 배열로 돌려준다.
 *  - 분리 문자가 " " (공백 하나) 이므로 , : . 는 분리 기준이 아니다.
 *    → "two,three:four.five" 는 한 덩어리로 남는다.
 *
 * 📝 필기 (퀴즈 6번, AI 설명)
 *  - split 의 인자는 일반 문자열이 아니라 "정규식" 이다.
 *    . + * ? | ( ) [ ] { } ^ $ \ 같은 특수문자로 자르려면 "\\." "\\+" 처럼 이스케이프해야 한다.
 *    예) "a.b.c".split(".")   → 길이 0 인 배열 (. 이 "아무 문자" 라 전부 구분자가 됨)
 *        "a.b.c".split("\\.") → [a, b, c]
 *
 * 💡 6-1 의 replaceAll 예제처럼 " |,|:|\\." 를 쓰면 모두 잘린다. (아래 두 번째 출력)
 * 💡 "-" + s + "-" 로 감싼 이유 : 잘린 조각에 공백이 붙어 있는지, 빈 문자열인지 눈으로 확인하려고.
 *
 * 실행 결과
 *  -minus-
 *  -one-
 *  -two,three:four.five-
 *  ---- " |,|:|\\." 로 분리 ----
 *  -minus-
 *  -one-
 *  -two-
 *  -three-
 *  -four-
 *  -five-
 *  ---- "." vs "\\." ----
 *  "a.b.c".split(".").length   = 0
 *  "a.b.c".split("\\.").length = 3
 */
public class SplitTest {
    public static void main(String[] args) {
        String delimStr = " ";   // 분리 문자
        String words = "minus one two,three:four.five";
        String [] split = null;

        split = words.split(delimStr);   // 분리 후 문자열 배열에 담음
        for (String s : split) System.out.println("-" + s + "-");

        // 💡 정규식으로 여러 구분자 한 번에
        System.out.println("---- \" |,|:|\\\\.\" 로 분리 ----");
        for (String s : words.split(" |,|:|\\.")) System.out.println("-" + s + "-");

        // 💡 📝 split 의 인자는 정규식
        System.out.println("---- \".\" vs \"\\\\.\" ----");
        System.out.println("\"a.b.c\".split(\".\").length   = " + "a.b.c".split(".").length);
        System.out.println("\"a.b.c\".split(\"\\\\.\").length = " + "a.b.c".split("\\.").length);
    }
}
