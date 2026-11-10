import java.util.Scanner;

/**
 * [3강 과제] 조건문1 - 3번 문제
 * 사용자로부터 하나의 문자를 입력받아서 문자가 'R' 이면 사각형의 면적을 계산하고
 * 'T' 이면 삼각형의 면적을, 'C' 이면 원의 면적을 계산한다.
 * 면적을 계산하는데 필요한 숫자들은 사용자로부터 입력받는다.
 * (Eclipse 에서는 Main.java 로 작성했던 코드)
 *  → 실습 조건문2 4번 (practice/conditionals2/AreaCalculator.java) 과 같은 문제. 실습 버전과 비교해 보기.
 *
 * 실습 버전에서 달라진 점
 *  - Character.toUpperCase(...) 로 입력을 대문자로 통일
 *    → case 'R': case 'r': 처럼 대소문자를 둘 다 나열할 필요가 없다.
 *  - 원주율로 3.14 대신 Math.PI 사용 → 더 정확하다.
 *  - 변수 이름을 rectangleBase, triangleBase 처럼 의미가 드러나게 지었다.
 *    (switch 전체가 한 블록이라 case 마다 이름이 달라야 하는 것은 실습 때와 같다)
 *
 * 💡 sc.next().charAt(0) 의 결과(char)를 바로 Character.toUpperCase() 에 넘겼다.
 *    메소드 호출 결과를 다른 메소드의 인수로 바로 쓸 수 있다.
 * 💡 rectangleBase * rectangleHeight 는 int 지만 double 변수에 넣으면서 자동 형변환되어 600.0 으로 출력된다.
 * 💡 default 는 마지막이라 break 를 생략했다.
 *
 * 문제의 실행 예  (입력 : R, 30 20)
 *  사각형의 면적은 : 600
 *
 * 내 코드 실행 예
 *  문자를 입력하세요 (R, T, C) : t
 *  밑변 길이, 높이를 입력하세요 : 20 30
 *  삼각형의 면적은 : 300.0 입니다.
 */
public class ShapeArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자를 입력하세요 (R, T, C) : ");

        // 입력받은 문자를 대문자로 통일하여 R, T, C 중 하나로 처리합니다.
        char shape = Character.toUpperCase(sc.next().charAt(0));

        switch (shape) {
            case 'R':
                // 사각형의 밑변과 높이를 입력받습니다.
                System.out.print("밑변 길이, 높이를 입력하세요 : ");
                int rectangleBase = sc.nextInt();
                int rectangleHeight = sc.nextInt();

                // 사각형의 면적 = 밑변 × 높이
                double rectangleArea = rectangleBase * rectangleHeight;
                System.out.println("사각형의 면적은 : " + rectangleArea + " 입니다.");
                break;

            case 'T':
                // 삼각형의 밑변과 높이를 입력받습니다.
                System.out.print("밑변 길이, 높이를 입력하세요 : ");
                int triangleBase = sc.nextInt();
                int triangleHeight = sc.nextInt();

                // 삼각형의 면적 = 밑변 × 높이 ÷ 2
                double triangleArea = triangleBase * triangleHeight / 2.0;
                System.out.println("삼각형의 면적은 : " + triangleArea + " 입니다.");
                break;

            case 'C':
                // 원의 반지름을 입력받습니다.
                System.out.print("반지름을 입력하세요 : ");
                int radius = sc.nextInt();

                // 원의 면적 = π × 반지름²
                double circleArea = Math.PI * radius * radius;
                System.out.println("원의 면적은 : " + circleArea + " 입니다.");
                break;

            default:
                // R, T, C 이외의 문자가 입력된 경우입니다.
                System.out.println("잘못된 입력입니다.");
        }

        sc.close();
    }
}
