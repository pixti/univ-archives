import java.util.Scanner;

/**
 * [3강 실습] 조건문1 - 4번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class VowelCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자 ? ");
        char c = sc.next().charAt(0);

        if (c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'I' || c == 'i'
                || c == 'O' || c == 'o' || c == 'U' || c == 'u') {
            System.out.println("모음 입니다.");
        }
        else if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
            System.out.println("비모음 입니다.");
        }
        else {
            System.out.println("영문자를 입력하세요.");
        }

        sc.close();
    }
}
