import java.util.Scanner;

/**
 * [6강 과제] 문자열(1) - 4번 문제 (암호화 / 복호화)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 암호화");
            System.out.println("2. 복호화");
            System.out.println("3. 종료");
            System.out.print("메뉴를 선택하시오: ");
            int menu = sc.nextInt();
            sc.nextLine();                                   // 남은 줄바꿈 제거

            if (menu == 1) {
                System.out.print("평문을 입력하시오: ");
                String plain = sc.nextLine().toLowerCase();
                System.out.println("암호화된 문자열: " + encrypt(plain));
            } else if (menu == 2) {
                System.out.print("암호문을 입력하시오: ");
                String cipher = sc.nextLine().toLowerCase();
                System.out.println("복호화된 문자열: " + decrypt(cipher));
            } else if (menu == 3) {
                break;
            }
        }
        sc.close();
    }

    // 암호화 : 4칸 뒤로
    static String encrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c - 'a' + 4) % 26 + 'a'));
            } else {
                sb.append(c);                                // 공백 등은 그대로
            }
        }
        return sb.toString();
    }

    // 복호화 : 4칸 앞으로 (+26 으로 음수 방지)
    static String decrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c - 'a' - 4 + 26) % 26 + 'a'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
