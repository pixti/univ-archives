/**
 * [11-1 예외처리1] 예외 처리 순서 - 다시 던지기(rethrow)와 중첩 try-catch
 *
 * 포인트
 *  - try-catch 문에서 여러 catch 문을 사용할 수 있고, catch 문은 순서대로 검사한다. (MultipleCatchTest.java)
 *  - 바깥쪽에 정의된 메소드에서 처리하고자 하는 경우, throw 문을 사용하여 rethrow 하면 된다.
 *      catch (ArithmeticException e)
 *      {
 *          throw (e);   // 예외 e 를 다시 발생
 *      }
 *  - 중첩하여 try-catch 문을 사용할 수 있다.
 *
 *  아래 코드의 흐름
 *    main → calculate() 호출
 *      calculate 안 : 10 / 0 → ArithmeticException → calculate 의 catch 가 받음
 *                     → "calculate 에서 일부 처리" 를 출력하고 throw (e) 로 다시 던짐 → calculate 종료
 *    main 의 catch 가 다시 받아서 "main 에서 최종 처리" 를 출력
 *
 * 💡 강의는 문법만 보여 주고 전체 예제는 없어서, 다시 던지기와 중첩 try-catch 를 확인하는 코드를 만들었다.
 * 💡 다시 던지는 이유 : 예외가 난 곳에서 할 수 있는 일(기록 남기기, 일부 정리)만 하고, 최종 판단은 호출한 쪽에 맡기기 위해서다.
 * 💡 throw (e); 의 괄호는 없어도 된다. 보통 throw e; 로 쓴다.
 * 💡 ArithmeticException 은 Unchecked 라서 calculate() 에 throws 를 쓰지 않아도 다시 던질 수 있다.
 *    Checked 예외를 다시 던지려면 메소드 선언부에 throws 를 적어야 한다. (11-2)
 *
 * 실행 결과
 *  ---- 다시 던지기 ----
 *  calculate 에서 일부 처리 : / by zero
 *  main 에서 최종 처리 : java.lang.ArithmeticException: / by zero
 *  ---- 중첩 try-catch ----
 *  안쪽 try-catch : 배열 인덱스 오류
 *  바깥 try 계속 실행
 *  바깥 try-catch : 0 으로 나누기
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
