import java.util.Scanner;

/**
 * [3강 과제] 조건문1 - 3번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
