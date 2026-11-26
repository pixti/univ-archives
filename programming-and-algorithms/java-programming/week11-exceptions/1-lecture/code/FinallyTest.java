/**
 * [11-1 예외처리1] [실습] finally 블록 - 세 가지 경우
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class FinallyTest {
    public static void main(String args[]) {
        System.out.println("---- (1) 예외가 발생하지 않은 경우 ----");
        case1();
        System.out.println("---- (2) 예외가 발생한 경우 ----");
        case2();
        System.out.println("---- (3) catch 문과 일치하지 않는 예외 ----");
        try {
            case3();
        } catch (ArrayIndexOutOfBoundsException e) {   // 💡 확인용 : case3 밖으로 나온 예외를 잡음
            System.out.println("(main 까지 전달됨 : " + e + ")");
        }
    }

    // (1) 예외가 발생하지 않은 경우
    static void case1() {
        try {
            System.out.println("First statement of try block");
            int num = 3;                         // 강의 코드 : int num = 3.14; (⚠ 컴파일 오류)
            System.out.println(num);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        } finally {                              // 예외 발생 없이도 실행됨
            System.out.println("finally 블록 내 ...");
        }
        System.out.println("try-catch 블락 밖 ...");
    }

    // (2) 예외가 발생한 경우
    static void case2() {
        try {
            System.out.println("First statement of try block");
            int num = 5 / 0;                     // 예외 발생
            System.out.println(num);
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        } finally {
            System.out.println("finally 블록 내 ...");
        }
        System.out.println("try-catch 블락 밖 ...");
    }

    // (3) catch 문과 일치하지 않는 예외
    static void case3() {
        try {
            System.out.println("First statement of try block");
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArithmeticException e) {        // ArrayIndexOutOfBoundsException 은 여기서 잡히지 않는다
            System.out.println("ArithmeticException");
        } finally {
            System.out.println("finally 블록 내 ...");
        }
        System.out.println("try-catch 블락 밖 ...");   // 💡 예외가 catch 에서 잡히지 않았으므로 실행되지 않는다
    }
}
