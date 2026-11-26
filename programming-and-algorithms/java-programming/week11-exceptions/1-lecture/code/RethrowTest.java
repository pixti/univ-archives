/**
 * [11-1 예외처리1] 예외 처리 순서 - 다시 던지기(rethrow)와 중첩 try-catch
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class RethrowTest {
    public static void main(String[] args) {
        System.out.println("---- 다시 던지기 ----");
        try {
            calculate();
        } catch (ArithmeticException e) {
            System.out.println("main 에서 최종 처리 : " + e);
        }

        System.out.println("---- 중첩 try-catch ----");
        try {
            try {
                int[] arr = new int[3];
                arr[5] = 1;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("안쪽 try-catch : 배열 인덱스 오류");
            }
            System.out.println("바깥 try 계속 실행");
            int zero = 0;
            System.out.println(10 / zero);
        } catch (ArithmeticException e) {
            System.out.println("바깥 try-catch : 0 으로 나누기");
        }
    }

    static void calculate() {
        try {
            int zero = 0;
            System.out.println(10 / zero);
        } catch (ArithmeticException e) {
            System.out.println("calculate 에서 일부 처리 : " + e.getMessage());
            throw (e);                         // 예외 e 를 다시 발생 → 호출한 main 으로
        }
    }
}
