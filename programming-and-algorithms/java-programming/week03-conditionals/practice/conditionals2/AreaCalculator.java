import java.util.Scanner;

/**
 * [3강 실습] 조건문2 - 4번 문제
 * 사용자로부터 하나의 문자를 입력받아서 문자가 'R' 이면 사각형의 면적을 계산하고
 * 'T' 이면 삼각형의 면적을, 'C' 이면 원의 면적을 계산한다.
 * 면적을 계산하는데 필요한 숫자들은 사용자로부터 입력받는다. switch 문을 사용하도록 한다.
 *
 * 포인트
 *  - case 'R': case 'r': 처럼 break 없이 나열해서 대문자와 소문자를 같이 처리했다. (fall-through)
 *  - 삼각형 : 밑변 * 높이 / 2.0
 *    → / 2 로 쓰면 int 끼리의 나눗셈이라 소수점이 버려진다. (3 * 5 / 2 = 7)
 *
 * 💡 case 마다 변수 이름을 r_width, t_width 처럼 다르게 지은 이유
 *    switch 문 전체가 하나의 블록 { } 이라서, case 아래에서 선언한 변수의 범위는 switch 전체이다.
 *    다른 case 에서 같은 이름(width)으로 또 선언하면 "이미 정의된 변수" 컴파일 에러가 난다.
 *    case 'R': { int width = ...; ... break; } 처럼 case 마다 { } 로 감싸면 같은 이름을 써도 된다.
 * 💡 3.14 대신 Math.PI (3.141592653589793) 를 쓰면 더 정확하다. (과제 ShapeArea.java 에서 사용)
 * 💡 radius * radius 는 int 지만 3.14 * (int) 는 double 이 되어 78.5 처럼 소수점까지 출력된다.
 *
 * 문제의 실행 예  (입력 : R, 30 20)
 *  사각형의 면적은 : 600
 *
 * 내 코드 실행 예
 *  원하는 메뉴 (R, T, C) ? c
 *  반지름 ? 5
 *  원의 면적은 : 78.5 입니다.
 */
public class AreaCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("원하는 메뉴 (R, T, C) ? ");
        char c = sc.next().charAt(0);

        switch (c) {
            case 'R':
            case 'r':
                System.out.print("밑변, 높이 ? ");
                int r_width = sc.nextInt();
                int r_height = sc.nextInt();
                System.out.println("사각형의 면적은 : " + (r_width * r_height) + " 입니다.");
                break;
            case 'T':
            case 't':
                System.out.print("밑변, 높이 ? ");
                int t_width = sc.nextInt();
                int t_height = sc.nextInt();
                System.out.println("삼각형의 면적은 : " + (t_width * t_height / 2.0) + " 입니다.");
                break;
            case 'C':
            case 'c':
                System.out.print("반지름 ? ");
                int radius = sc.nextInt();
                System.out.println("원의 면적은 : " + (3.14 * (radius * radius)) + " 입니다.");
                break;
            default:
                System.out.println("잘못된 입력.");
                break;
        }

        sc.close();
    }
}
