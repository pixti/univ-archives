import java.util.Scanner;

/**
 * [11-1 예외처리1] 기본 예외 처리 (Exception Handling) - try-catch
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class DivideExample {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("두 정수를 입력하세요 : ");   // 💡 강의 코드에는 없는 안내 문구
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        int c;                     // ✅ try 바깥에서 선언
        try {
            c = a / b;             // divide-by-zero 예외 발생 가능
        } catch (ArithmeticException e) {
            c = -1;
        }
        System.out.println("결과는 " + c + "입니다.");

        System.out.println("5.0 / 0 = " + (5.0 / 0));   // 💡 실수 나눗셈은 예외가 나지 않는다
    }
}
