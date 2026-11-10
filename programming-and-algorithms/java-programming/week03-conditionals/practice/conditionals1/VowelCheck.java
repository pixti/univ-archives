import java.util.Scanner;

/**
 * [3강 실습] 조건문1 - 4번 문제
 * 키보드에서 문자 하나를 읽어서 모음과 비모음을 구분하는 프로그램을 작성하여 보자.
 * (Eclipse 에서는 Problem.java 로 작성했던 코드)
 *
 * 내 풀이 : if 문에 모음 10가지 (a, e, i, o, u 와 대문자 A, E, I, O, U) 를 || 로 모두 나열
 *           → 그 외 영문자는 비모음, 영문자가 아니면 안내문
 *
 * 📝 필기 - switch 문으로 바꾼 버전 (class VowelChecker)
 *    switch (c) {
 *        case 'A': case 'a':
 *        case 'E': case 'e':
 *        case 'I': case 'i':
 *        case 'O': case 'o':
 *        case 'U': case 'u':
 *            System.out.println("입력하신 문자는 모음입니다.!!^^");
 *            break;
 *        default:
 *            System.out.println("입력하신 문자는 자음(비모음)입니다.");
 *    }
 *
 * 📝 필기 - 코드 주요 포인트
 *  - 대소문자 처리 : 모음은 a, e, i, o, u 및 대문자 A, E, I, O, U 총 10가지.
 *  - switch 조건 통합 : break 없이 case 를 나열하면 여러 값을 하나의 동작으로 묶을 수 있다 (fall-through).
 *
 * 📝 필기 - 팁
 *  - Character.toLowerCase(c) 로 먼저 소문자로 바꾸면 비교할 문자가 5개로 절반이 된다.
 *      c = Character.toLowerCase(c);
 *      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ...
 *    → 과제 VowelSwitch.java 에서 이 방법을 썼다.
 *  - String 의 메소드를 이용하는 방법
 *      if ("aeiouAEIOU".indexOf(c) != -1) ...
 *    💡 indexOf(c) 는 문자열에서 c 의 위치를 돌려주고, 없으면 -1 을 돌려준다.
 *       contains 는 문자열(String)만 받으므로 char 로 쓰려면 contains(String.valueOf(c)) 처럼 바꿔야 한다.
 *
 * 💡 위 switch 필기 버전은 default 에서 숫자나 기호도 "자음" 이라고 출력한다.
 *    내 if 버전은 영문자인지 한 번 더 확인해서 이 경우를 따로 처리했다.
 *
 * 문제의 실행 예  (입력 : I)
 *  입력하신 문자는 모음입니다.!!^^
 *
 * 내 코드 실행 예
 *  문자 ? f
 *  비모음 입니다.
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
