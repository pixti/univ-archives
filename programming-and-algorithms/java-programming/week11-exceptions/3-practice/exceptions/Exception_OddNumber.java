/**
 * [11강 실습] 예외 처리 - 2번 문제 (홀수이면 IllegalArgumentException)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Exception_OddNumber {
    public static void main(String[] args) {
        int n = 18;
        trynumber(n);
        n = 7;
        trynumber(n);

        System.out.println("---- 방법 2 ----");      // 💡 확인용
        trynumber2(18);
        trynumber2(7);

        System.out.println("---- 음수 홀수 ----");
        int m = -7;
        System.out.println(m + " % 2 = " + (m % 2) + " → n % 2 == 1 이면 " + (m % 2 == 1) + ", n % 2 != 0 이면 " + (m % 2 != 0));
    }

    // 방법 1 : trynumber() 메서드 하나로 구현
    public static void trynumber(int n) {
        try {
            if (n % 2 != 0) {
                throw new IllegalArgumentException(n + " is odd.");
            }
            System.out.println(n + " is even.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 방법 2 : 예외를 포착하고 결과를 출력하는 역할 (문제에서는 이름이 trynumber)
    public static void trynumber2(int n) {
        try {
            checkEvenNumber(n);
            System.out.println(n + " is even.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 방법 2 : 숫자가 홀수인지 검사하고 예외를 발생시키는 역할
    public static void checkEvenNumber(int number) {
        if (number % 2 != 0) {
            throw new IllegalArgumentException(number + " is odd.");
        }
    }
}
