import java.util.Scanner;

/**
 * [6강 과제] 문자열(1) - 3번 문제
 *
 * 문장, 찾을 문자열, 바꿀 문자열을 입력받아 문장 속의 문자열을 모두 바꾸어 출력하시오.
 *      문장을 입력하세요 : A fool and his mony are soon parted.
 *      찾을 문자열: mony
 *      바꿀 문자열: money
 *      A fool and his money are soon parted.
 *
 * 포인트
 *  - 세 입력 모두 nextLine() → 공백이 들어간 문자열도 찾고 바꿀 수 있다.
 *  - text.replace(target, replacement) : 일치하는 "모든" 부분을 글자 그대로 치환 (정규식 X)
 *
 * 💡 replaceAll 을 쓰면 찾을 문자열을 정규식으로 해석한다.
 *    예) 찾을 문자열 "." → 모든 문자가 바뀌어 버림. 사용자가 입력한 문자열을 찾을 때는 replace 가 안전하다.
 *    (6-2 SearchReplace 의 replaceFirst 도 같은 문제 → examples/SearchReplace.java 참고)
 *
 * 실행 예
 *  문장을 입력하세요 : dkssuddkssud world
 *  찾을 문자열: dkssud
 *  바꿀 문자열: hi
 *  hihi world
 */
public class FindReplace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문장을 입력하세요 : ");
        String text = sc.nextLine();
        System.out.print("찾을 문자열: ");
        String target = sc.nextLine();
        System.out.print("바꿀 문자열: ");
        String replacement = sc.nextLine();

        String result = text.replace(target, replacement);
        System.out.println(result);
        sc.close();
    }
}
