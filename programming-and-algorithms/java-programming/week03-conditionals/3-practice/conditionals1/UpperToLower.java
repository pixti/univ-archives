import java.util.Scanner;

/**
 * [3강 실습] 조건문1 - 3번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class UpperToLower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자 ? ");
        char c = sc.next().charAt(0);

        if ('A' <= c && c <= 'Z') {            // 대문자인 경우 ('A' ~ 'Z')
            int lower = 'a' + (c - 'A');
            System.out.println((char) lower);
            // 📝 팁: System.out.println((char) ('a' + (c - 'A')));
        }
        else if (c >= 'a' && c <= 'z') {       // 소문자인 경우 ('a' ~ 'z')
            System.out.println("대문자를 입력하세요.");
        }
        else {                                 // 영문자가 아닌 경우
            System.out.println("영문자를 입력하세요.");
        }

        sc.close();
    }
}
