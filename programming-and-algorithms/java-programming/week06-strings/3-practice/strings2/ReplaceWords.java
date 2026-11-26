/**
 * [6강 실습] 문자열(2) - 3번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ReplaceWords {
    public static void main(String[] args) {
        String str = "Python is an interpreted high-level general-purpose programming language. "
                + "Its design philosophy emphasizes code readability with its use of significant indentation. "
                + "Its language constructs as well as its object-oriented approach aim to help programmers "
                + "writeclear, logical code for small and large-scale projects.";

        String result = str.replace("Python", "Java").replace("code", "coding"); // Python -> Java, code -> coding
        System.out.println(result);
    }
}
