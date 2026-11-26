import java.util.Scanner;

/**
 * [3강 과제] 조건문2 - 3번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class VowelSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자 하나를 입력받는다.
        System.out.print("문자 입력 : ");
        char inputChar = sc.next().charAt(0);

        // 대문자와 소문자를 구분하지 않기 위해 소문자로 변환한다.
        inputChar = Character.toLowerCase(inputChar);

        // 입력된 문자가 영문자인지 먼저 확인한다.
        if (inputChar < 'a' || inputChar > 'z') {
            System.out.println("영문자를 입력하세요.");
        }
        else {
            // 영문자인 경우 모음인지 확인한다.
            switch (inputChar) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("입력하신 문자는 모음입니다.");
                    break;

                // a, e, i, o, u가 아닌 영문자는 자음이다.
                default:
                    System.out.println("입력하신 문자는 자음입니다.");
                    break;
            }
        }

        sc.close();
    }
}
