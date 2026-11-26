import java.util.Scanner;

/**
 * [3강 실습] 조건문1 - 1번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("1번째 점의 위치 입력 (x1, y1) : ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        System.out.print("2번째 점의 위치 입력 (x2, y2) : ");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        System.out.print("3번째 점의 위치 입력 (x3, y3) : ");
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        if ((x1 == x2 && x2 == x3) || (y1 == y2 && y2 == y3)) {
            System.out.println("삼각형을 만들 수 없습니다. (일직선)");
        }
        else if ((x1 == x2 && y1 == y2) || (x2 == x3 && y2 == y3) || (x1 == x3 && y1 == y3)) {
            System.out.println("삼각형을 만들 수 없습니다. (중복된 점)");
        }
        else if (x1 == x2 || x2 == x3 || x1 == x3) {
            // 세로선이 하나 있지만 세 점이 모두 같은 세로선 위에 있지는 않음
            System.out.println("삼각형을 만들수 있습니다.");
        }
        else {
            double slope1 = (double) (y2 - y1) / (x2 - x1);
            double slope2 = (y3 - y1) / (double) (x3 - x1);

            if (slope1 == slope2) {
                System.out.println("삼각형을 만들 수 없습니다.");
            }
            else {
                System.out.println("삼각형을 만들수 있습니다.");
            }
        }

        // 💡 곱셈 비교 버전 (위의 if-else if 전체를 이것으로 대신할 수 있다)
        // if ((y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1))
        //     System.out.println("삼각형을 만들 수 없습니다.");
        // else
        //     System.out.println("삼각형을 만들수 있습니다.");

        sc.close();
    }
}
