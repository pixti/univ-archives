/**
 * [7-4] 명령행 인수 (command-line arguments)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class CommandLineTest {
    public static void main(String[] args) {
        // (1) foreach 문으로 출력
        for (String arg : args) {
            System.out.println(arg);
        }

        // (2) 첨자로 접근
        if (args.length >= 2) {
            System.out.println("args[0] = " + args[0]); // aaa
            System.out.println("args[1] = " + args[1]); // bbb
        } else {
            System.out.println("명령행 인수를 2개 이상 주세요. 예) java CommandLineTest aaa bbb");
        }
    }
}
