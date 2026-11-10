import java.util.Scanner;

/**
 * [3강 과제] 조건문1 - 1번 문제
 * 사용자로부터 3개의 정수를 읽어 들인 후에 if-else 문을 사용하여 가장 작은 값을 결정하는 프로그램을 작성하라.
 * (Eclipse 에서는 Main.java 로 작성했던 코드)
 *
 * 포인트
 *  - "a 가 b 보다도, c 보다도 작거나 같다" → a <= b && a <= c
 *  - < 가 아니라 <= 를 써야 같은 값이 있을 때 (예: 2 2 5) 도 올바르게 처리된다.
 *  - a 도 b 도 최소가 아니면 남은 c 가 최소 → 마지막은 조건 없이 else.
 *
 * 💡 다른 방법 : 최솟값 변수를 하나 두고 차례로 갱신
 *      int min = a;
 *      if (b < min) min = b;
 *      if (c < min) min = c;
 *    → 비교할 수가 늘어나도 if 한 줄씩만 추가하면 된다. (나중에 배열 + 반복문으로 일반화)
 * 💡 Math.min(a, Math.min(b, c)) 로도 구할 수 있다.
 *
 * 문제의 실행 예
 *  3개의 정수를 입력하세요 (3 4 5) : 7 1 2
 *  가장 작은 값 : 1
 *
 * 내 코드 실행 예
 *  3개의 정수를 입력하세요. : 3 2 4
 *  가장 작은 값 : 2
 */
public class MinOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("3개의 정수를 입력하세요. : ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        // a가 가장 작은 값인지 확인합니다.
        if (a <= b && a <= c) {
            System.out.print("가장 작은 값 : " + a);
        }
        // a가 가장 작은 값이 아니라면, b가 가장 작은 값인지 확인합니다.
        else if (b <= a && b <= c) {
            System.out.print("가장 작은 값 : " + b);
        }
        // a와 b가 모두 최소값이 아니라면 c가 최소값입니다.
        else {
            System.out.print("가장 작은 값 : " + c);
        }

        sc.close();
    }
}
