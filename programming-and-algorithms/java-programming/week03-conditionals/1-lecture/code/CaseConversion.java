import java.util.Scanner;

/**
 * [3-2 조건문2] [실습] 문자 변환 (소문자 → 대문자, 대문자 → 소문자)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class CaseConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("영문자를 입력하세요 : ");
        char c = sc.next().charAt(0);
        sc.close();

        if (c >= 'a' && c <= 'z') c = (char) (c - 'a' + 'A');        // 소문자 → 대문자
        else if (c >= 'A' && c <= 'Z') c = (char) (c - 'A' + 'a');   // 대문자 → 소문자
        else {
            System.out.println("영문자가 아닙니다.");
            return;
        }
        System.out.println("변환 결과 : " + c);
    }
}
