import java.util.Scanner;

/**
 * [3강 과제] 조건문1 - 1번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
