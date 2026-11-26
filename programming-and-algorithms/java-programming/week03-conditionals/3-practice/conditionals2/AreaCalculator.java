import java.util.Scanner;

/**
 * [3강 실습] 조건문2 - 4번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
