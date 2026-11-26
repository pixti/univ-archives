/**
 * [6-2] String 클래스 - 문자열 분리 (split)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
