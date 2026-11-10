import java.util.Scanner;

/**
 * [3강 실습] 조건문1 - 3번 문제
 * 사용자로부터 하나의 문자를 입력받는다. 만약 입력받은 문자가 대문자이면 소문자로 변환한다.
 * 만약 소문자를 입력하면 대문자로 입력하라는 안내문을 출력한다.
 * (Eclipse 에서는 Problem.java 로 작성했던 코드)
 *
 * 📝 필기 - 아스키코드
 *  - 아스키코드상 A 는 65, ..... , Z 는 90, [ 는 91, .... , a 는 97, ..... , z 는 122.
 *  - char 타입은 내부적으로 아스키 코드(int) 값으로 저장된다.
 *    따라서 두 문자를 빼서 연산하면 알파벳 순서상 떨어져 있는 "거리(알파벳 위치 차이)" 를 구할 수 있다.
 *  - 문자들 간의 거리는 어떻게 구할까?  x = 'B' 라고 하자.
 *    x - 'A' 를 하면 실제로는 66 - 65 라서 1 이 나온다.
 *      'B' - 'A' → 66 - 65 = 1   (A 로부터 1번째 뒤에 위치)
 *      'Z' - 'A' → 90 - 65 = 25  (A 로부터 25번째 뒤에 위치)
 *  - 대문자를 소문자로 바꾸는 식 : 'a' + (x - 'A')
 *      1. x - 'A'   → 'B' - 'A' = 1   (거리 계산)
 *      2. 'a' + 1   → 97 + 1    = 98
 *      3. (char) 98 → 'b'
 *
 * 📝 필기 - 더 간결하게 쓰는 소소한 팁
 *    int 변수를 따로 만들지 않고 바로 형변환해서 출력할 수 있다.
 *      System.out.println((char) ('a' + (c - 'A')));
 *
 * 💡 (char) 를 빼고 println('a' + (c - 'A')) 로 쓰면 결과가 int 라서 98 같은 숫자가 출력된다.
 * 💡 Character.toLowerCase(c) 를 쓰면 한 번에 바꿀 수 있다. (과제 ShapeArea, VowelSwitch 에서 사용)
 *
 * 문제의 실행 예
 *  하나의 문자를 입력하세요 : A
 *  a
 *
 * 내 코드 실행 예
 *  문자 ? G
 *  g
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
