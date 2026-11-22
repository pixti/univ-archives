/**
 * [11-1 예외처리1] [실습] finally 블록 - 세 가지 경우
 *
 * 포인트
 *  - finally 블록이 추가로 올 수 있다.
 *  - try 블록에서 할당된 리소스를 정리하고, 예외 발생 여부에 관계없이 항상 실행해야 하는 코드를 기술한다.
 *      try {
 *          // try block
 *      }
 *      catch (Exception arg) {
 *          // catch block
 *      }
 *      finally {
 *          // finally block
 *      }
 *
 *  (1) 예외가 발생하지 않은 경우       : try 끝까지 → (catch 건너뜀) → finally → try-catch 밖
 *  (2) 예외가 발생한 경우              : try 중단 → catch → finally → try-catch 밖
 *  (3) catch 문과 일치하지 않는 예외   : try 중단 → (맞는 catch 없음) → finally → 예외가 메소드 밖으로 전달됨
 *      → "try-catch 블락 밖 ..." 은 출력되지 않는다. main 에서 이렇게 되면 프로그램이 비정상 종료된다.
 *
 * ⚠ 자주 틀리는 부분 : 강의의 (1) 번 코드는 int num = 3.14; 다. 이 줄은 컴파일 오류다. (double 을 int 에 그냥 넣을 수 없다, 2강)
 *      error: incompatible types: possible lossy conversion from double to int
 *    "예외가 나지 않는 코드" 의 예로 쓰려면 int num = 3; 처럼 정수를 쓰거나 (int) 3.14 로 형변환해야 한다. 아래에서는 int num = 3; 으로 썼다.
 *    컴파일 오류는 실행하기 전에 잡히는 문법 오류이고, 예외는 실행 중에 생기는 오류다. try-catch 로는 컴파일 오류를 처리할 수 없다.
 * 💡 (3) 에서 throw new ArrayIndexOutOfBoundsException(); 은 실제 배열 없이 예외를 "직접" 발생시킨 것이다. (throw 는 11-2)
 * 💡 (3) 을 main 에서 그대로 실행하면 finally 출력 뒤에 프로그램이 멈춘다. 여기서는 세 경우를 한 번에 보려고 각 경우를 메소드로 만들고,
 *    (3) 을 부르는 main 쪽에서 한 번 더 잡아서 "어디까지 전달됐는지" 를 출력했다.
 * 💡 finally 는 try 나 catch 안에서 return 을 만나도 실행된다. (실습 Vowel_Check.java 📝 필기 ④)
 * 💡 강의 코드의 클래스 이름은 세 경우 모두 FinallyTest. 한 파일에 넣으려고 각 경우를 case1 ~ case3 메소드로 나눴다.
 *
 * 실행 결과
 *  ---- (1) 예외가 발생하지 않은 경우 ----
 *  First statement of try block
 *  3
 *  finally 블록 내 ...
 *  try-catch 블락 밖 ...
 *  ---- (2) 예외가 발생한 경우 ----
 *  First statement of try block
 *  ArithmeticException
 *  finally 블록 내 ...
 *  try-catch 블락 밖 ...
 *  ---- (3) catch 문과 일치하지 않는 예외 ----
 *  First statement of try block
 *  finally 블록 내 ...
 *  (main 까지 전달됨 : java.lang.ArrayIndexOutOfBoundsException)
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
