import java.util.Scanner;

/**
 * [6강 과제] 문자열(1) - 4번 문제 (암호화 / 복호화)
 *
 * 아래 변환표를 이용해 영문 평문을 암호화하고, 암호문을 복호화하는 메뉴 프로그램을 작성하시오.
 *      평문    a b c d e f g h i j k l m n o p q r s t u v w x y z
 *      암호문  e f g h i j k l m n o p q r s t u v w x y z a b c d
 *
 *      1. 암호화
 *      2. 복호화
 *      3. 종료
 *      메뉴를 선택하시오: 1
 *      평문을 입력하시오: meet at midnight
 *      암호화된 문자열: qiix ex qmhrmklx
 *
 * 📝 필기 (AI 설명)
 *  - 변환표를 보면 모든 글자가 알파벳 순서로 "4칸씩 뒤로" 밀려 있다. → 시저 암호 (Caesar cipher, +4)
 *  - 암호화 : (c - 'a' + 4) % 26 + 'a'
 *      c - 'a'     : 'a'=0, 'b'=1, ..., 'z'=25 로 바꿈
 *      + 4         : 4칸 이동
 *      % 26        : 25 를 넘으면 다시 0 부터 (w→a, x→b, y→c, z→d)
 *      + 'a'       : 다시 문자 코드로 → (char) 로 형변환
 *  - 복호화 : (c - 'a' - 4 + 26) % 26 + 'a'
 *      - 4 를 하면 a~d 에서 음수가 나오므로 + 26 을 먼저 더해 0~25 범위로 맞춘다.
 *      (자바의 % 는 음수에 대해 음수를 돌려준다 : -4 % 26 = -4)
 *  - 공백 · 숫자 · 문장부호처럼 a~z 가 아닌 문자는 그대로 붙인다.
 *  - StringBuilder 의 append 로 한 글자씩 결과를 만든다. (String + 를 반복하는 것보다 효율적)
 *
 * 💡 nextInt() 뒤에 nextLine() 을 한 번 호출 → 숫자 뒤에 남은 줄바꿈 제거 (안 하면 평문 입력이 빈 줄로 넘어감)
 * 💡 1~3 이외의 숫자를 입력하면 아무 메시지 없이 메뉴가 다시 나온다.
 *    숫자가 아닌 값을 입력하면 nextInt() 에서 InputMismatchException 이 발생한다.
 * 💡 평문을 toLowerCase() 로 바꾸므로 대문자로 입력해도 소문자로 암호화된다.
 *
 * 실행 예
 *  1. 암호화
 *  2. 복호화
 *  3. 종료
 *  메뉴를 선택하시오: 1
 *  평문을 입력하시오: meet at midnight
 *  암호화된 문자열: qiix ex qmhrmklx
 *  1. 암호화
 *  2. 복호화
 *  3. 종료
 *  메뉴를 선택하시오: 2
 *  암호문을 입력하시오: qiix ex qmhrmklx
 *  복호화된 문자열: meet at midnight
 *  1. 암호화
 *  2. 복호화
 *  3. 종료
 *  메뉴를 선택하시오: 3
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
