import java.util.Scanner;

/**
 * [3강 실습] 조건문1 - 1번 문제
 * 0이 아닌 3개의 좌표값 (x1, y1), (x2, y2), (x3, y3) 를 입력받아서
 * 삼각형을 만들 수 있는지를 검사하는 프로그램을 작성하라.
 * (Eclipse 에서는 Problem.java 로 작성했던 코드)
 *
 * 힌트 : 한 점 (x1, y1) 에서 (x2, y2) 가는 직선의 기울기와
 *        (x1, y1) 에서 (x3, y3) 가는 직선의 기울기가 같지 않으면 삼각형을 만들 수 있음.
 *
 * 📝 필기
 *  - 기울기 공식 :  (y2 - y1) / (x2 - x1)
 *  - 세 점 중 두 직선의 기울기가 같다면 세 점이 한 일직선상에 놓이므로 삼각형을 만들 수 없습니다.
 *
 * 내 풀이의 흐름
 *  1. x 좌표가 모두 같거나 y 좌표가 모두 같으면 → 일직선 (세로선 / 가로선)
 *  2. 두 점이 완전히 같으면 → 중복된 점 (선분 하나뿐)
 *  3. 위 경우가 아닌데 x 좌표가 같은 쌍이 있으면 → 그 직선은 세로선이라 기울기를 구할 수 없다 (0 으로 나누기).
 *     세 점이 모두 같은 세로선 위에 있는 경우는 1 에서 이미 걸렀으므로 → 삼각형 가능
 *  4. 나머지는 기울기 두 개를 구해서 비교
 *
 * 💡 기울기를 구할 때 (double) 로 형변환하지 않으면 정수 나눗셈이 되어 1/2 와 1/3 이 둘 다 0 이 된다.
 *    (slope1 은 앞쪽을, slope2 는 뒤쪽을 형변환했는데 둘 다 double 나눗셈이 되므로 결과는 같다)
 * 💡 double 을 == 로 비교하는 것은 원래 위험하다(오차). 여기서는 입력이 정수라서
 *    "같은 분수 값" 이면 같은 double 로 반올림되므로 문제없이 동작한다.
 * 💡 더 안전한 방법 - 나눗셈을 곱셈으로 바꾸기 (나눗셈이 없으니 x 가 같은 경우의 예외 처리도 필요 없다)
 *      (y2 - y1) / (x2 - x1) == (y3 - y1) / (x3 - x1)
 *   ⇔ (y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)
 *    이 식이 참이면 일직선이다. (중복된 점도 여기에 포함된다)
 *
 * 문제의 실행 예
 *  1번째점을입력하세요(x1,y1) : 2 2
 *  2번째점을입력하세요(x2,y2) : 1 3
 *  3번째점을입력하세요(x3,y3) : 2 3
 *  알림>삼각형 만들수 있습니다.
 *
 * 내 코드 실행 예
 *  1번째 점의 위치 입력 (x1, y1) : 8 9
 *  2번째 점의 위치 입력 (x2, y2) : 3 9
 *  3번째 점의 위치 입력 (x3, y3) : 4 4
 *  삼각형을 만들수 있습니다.
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
