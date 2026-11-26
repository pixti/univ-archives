/**
 * [11강 실습] 예외 처리 - 1번 문제 (0 으로 나누기 : throw + try-catch)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Exception_Example {
    public static void main(String[] args) {
        try {
            int result = divideNumbers(5, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("---- 비교 ----");   // 💡 확인용
        try {
            divideNumbers(5, 0);
        } catch (ArithmeticException e) {
            System.out.println("e.getMessage() → " + e.getMessage());
            System.out.println("e              → " + e);
        }
        try {
            int zero = 0;
            System.out.println(5 / zero);
        } catch (ArithmeticException e) {
            System.out.println("5 / 0 의 기본 메시지 → " + e.getMessage());
        }
    }

    public static int divideNumbers(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide the given number by zero!");
        }
        return dividend / divisor;
    }
}
