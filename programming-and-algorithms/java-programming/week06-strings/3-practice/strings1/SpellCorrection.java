import java.util.Scanner;

/**
 * [6강 실습] 문자열(1) - 3번 문제 (철자 교정)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
