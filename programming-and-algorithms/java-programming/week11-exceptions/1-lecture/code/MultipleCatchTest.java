/**
 * [11-1 예외처리1] [실습] 다중 catch 문 - 예외 처리 순서
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MultipleCatchTest {
    public static void main(String args[]) {
        System.out.println("---- (1) ArithmeticException ----");
        case1();
        System.out.println("---- (2) ArrayIndexOutOfBoundsException ----");
        case2();
    }

    // (1) 다중 catch 문 - ArithmeticException
    static void case1() {
        try {
            int arr[] = new int[5];
            arr[4] = 20 / 0;                    // 예외 발생
            System.out.println("First print statement in try block");
        } catch (ArithmeticException e) {      // 여기서 받음
            System.out.println("Warning: ArithmeticException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Warning: ArrayIndexOutOfBoundsException");
        } catch (Exception e) {
            System.out.println("Warning: Some Other exception");
        }
        System.out.println("try-catch 블락 밖...");
    }

    // (2) 다중 catch 문 - ArrayIndexOutOfBoundsException
    static void case2() {
        try {
            int arr[] = new int[5];
            arr[6] = 20 / 5;                    // 예외 발생
            System.out.println("First print statement in try block");
        } catch (ArithmeticException e) {
            System.out.println("Warning: ArithmeticException");
        } catch (ArrayIndexOutOfBoundsException e) {   // 여기서 받음
            System.out.println("Warning: ArrayIndexOutOfBoundsException");
        } catch (Exception e) {
            System.out.println("Warning: Some Other exception");
        }
        System.out.println("try-catch 블락 밖...");
    }
}
