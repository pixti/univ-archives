import java.util.Scanner;

/**
 * [3강 과제] 조건문2 - 3번 문제
 * switch 문을 사용하여 키보드에서 문자 하나를 읽어서 모음과 비모음을 구분하는 프로그램을 작성하여 보자.
 *  → 실습 조건문1 4번 (practice/conditionals1/VowelCheck.java) 을 switch 로 다시 푼 문제.
 *
 * 포인트
 *  - Character.toLowerCase() 로 먼저 소문자로 바꿨다.
 *    → 실습 때 필기한 팁 그대로. case 를 10개가 아니라 5개만 나열하면 된다.
 *  - switch 는 "범위" 를 표현할 수 없으므로 영문자인지 검사는 switch 앞의 if 로 따로 했다.
 *    → 숫자나 기호를 입력했을 때 default 에서 "자음" 이라고 잘못 출력하는 것을 막는다.
 *  - case 'a': case 'e': ... 처럼 break 없이 나열 → 5개의 값을 하나의 동작으로 묶는다 (fall-through).
 *
 * 💡 inputChar < 'a' || inputChar > 'z' : "a ~ z 범위 밖" 은 || 로 쓴다.
 *    (범위 안 : 'a' <= c && c <= 'z'  ↔  범위 밖 : c < 'a' || c > 'z')
 *
 * 문제의 실행 예  (입력 : I)
 *  입력하신 문자는 모음입니다.!!^^
 *
 * 내 코드 실행 예
 *  문자 입력 : i
 *  입력하신 문자는 모음입니다.
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
