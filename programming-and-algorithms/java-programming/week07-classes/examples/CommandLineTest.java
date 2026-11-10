/**
 * [8-4] 명령행 인수 (command-line arguments)
 *
 * 포인트
 *  - main 은 String 타입의 배열(String[] args)을 인수로 받는다.
 *  - 실행할 때 클래스 이름 뒤에 적은 단어들이 공백 기준으로 나뉘어 args 에 들어간다.
 *        java CommandLineTest aaa bbb    →  args = { "aaa", "bbb" }
 *  - foreach 문으로 출력하거나, 배열이므로 첨자(args[0], args[1])로 접근할 수 있다.
 *  - 이클립스 : Run → Run Configurations → Arguments 탭 → Program arguments 에 입력
 *
 * 💡 인수 없이 실행하면 args.length 가 0 이라서 args[0] 에서 ArrayIndexOutOfBoundsException 이 난다.
 *    슬라이드 11 의 코드에 길이 검사를 추가했다.
 * 💡 슬라이드는 public 이 없는 class CommandLineTest 이다. (파일 하나에 클래스 하나면 public 이 없어도 실행됨)
 *    공백이 들어간 인수는 따옴표로 묶는다 : java CommandLineTest "hello world" → args[0] = "hello world"
 *
 * 실행 예
 *  > java examples/CommandLineTest.java aaa bbb
 *  aaa
 *  bbb
 *  args[0] = aaa
 *  args[1] = bbb
 */
public class CommandLineTest {
    public static void main(String[] args) {
        // 슬라이드 9 : foreach 문으로 출력
        for (String arg : args) {
            System.out.println(arg);
        }

        // 슬라이드 11 : 첨자로 접근
        if (args.length >= 2) {
            System.out.println("args[0] = " + args[0]); // aaa
            System.out.println("args[1] = " + args[1]); // bbb
        } else {
            System.out.println("명령행 인수를 2개 이상 주세요. 예) java CommandLineTest aaa bbb");
        }
    }
}
