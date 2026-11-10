import java.util.Scanner;

/**
 * [6강 실습] 문자열(1) - 3번 문제 (철자 교정)
 *
 * 영문 문장을 입력받아 다음과 같이 교정하여 출력하시오.
 *  - 문장의 첫 글자와 마침표(.) 다음에 오는 첫 영문자를 대문자로 바꾼다.
 *  - 문장의 끝에 마침표가 없으면 마침표를 붙인다.
 *
 *  예) i love you. you love me. we love them
 *   →  I love you. You love me. We love them.
 *
 * 💡 참고 답안 (필기에는 이 문제의 풀이 대신 정규식 실험 코드만 있어서 → RegexCatDog.java, 답안을 추가함)
 *  - StringBuilder 로 바꾸면 setCharAt 으로 한 글자씩 고칠 수 있다. (String 은 변경 불가!)
 *  - capitalize 변수 : "다음에 나오는 영문자를 대문자로 바꿔야 하는가?"
 *      처음엔 true (문장 첫 글자) → 영문자를 만나면 대문자로 바꾸고 false
 *      마침표를 만나면 다시 true  → 그 사이의 공백은 그냥 지나감
 *  - Character.toUpperCase(c) : 한 문자를 대문자로 (String 의 toUpperCase 와 구분)
 *  - 끝에 마침표 검사 : endsWith(".")  (뒤에 공백이 있을 수 있으니 trim 후 검사)
 *
 * 💡 정규식 + Matcher 로 푸는 방법도 있다. (6-4 Pattern / Matcher 응용)
 *      Matcher m = Pattern.compile("(^|\\.\\s*)([a-z])").matcher(str);
 *      → 문장 시작 또는 "마침표+공백" 뒤의 소문자를 찾아 m.appendReplacement 로 대문자로 바꿈
 *
 * 실행 예
 *  영문 문장을 입력하세요 : i love you. you love me. we love them
 *  I love you. You love me. We love them.
 */
public class SpellCorrection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("영문 문장을 입력하세요 : ");
        StringBuilder sb = new StringBuilder(sc.nextLine().trim());

        boolean capitalize = true;                         // 문장 첫 글자는 대문자
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '.') {
                capitalize = true;                         // 마침표 다음 첫 영문자를 대문자로
            } else if (capitalize && Character.isLetter(c)) {
                sb.setCharAt(i, Character.toUpperCase(c));
                capitalize = false;
            }
        }

        if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '.') {
            sb.append('.');                                // 끝에 마침표가 없으면 붙이기
        }
        System.out.println(sb);
        sc.close();
    }
}
