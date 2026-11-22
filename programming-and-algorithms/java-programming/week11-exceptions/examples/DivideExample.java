import java.util.Scanner;

/**
 * [11-1 예외처리1] 기본 예외 처리 (Exception Handling) - try-catch
 *
 * 포인트
 *  - 예외 처리 : 프로그램의 정상적인 흐름을 방해하는 예외들을 조치하여 계속 프로그램이 진행될 수 있게 하는 목적
 *  - try-catch 문을 사용한다.
 *      try 블록   : 예외 발생 가능한 코드를 포함
 *      catch 블록 : try 블록에서 발생한 exception 을 처리
 *  - 아래 코드는 b 에 0 을 입력하면 a / b 에서 divide-by-zero 예외(ArithmeticException)가 발생한다.
 *    예외가 나면 catch 블록으로 넘어가 c = -1 로 정하고, 프로그램은 멈추지 않고 다음 줄을 계속 실행한다.
 *
 * ⚠ 자주 틀리는 부분 : 강의 코드는 int c 를 try 블록 "안에서" 선언한다.
 *      try {
 *          int c = a / b;          // c 는 이 블록 안에서만 쓸 수 있다
 *      }
 *      catch (ArithmeticException e) {
 *          c = -1;                 // ❌ error: cannot find symbol (c)
 *      }
 *      System.out.println("결과는 " + c + "입니다.");   // ❌ 여기서도 c 를 찾을 수 없다
 *    변수의 유효 범위는 선언한 블록 { } 안이다. (7강 변수의 유효 범위) try, catch, 그 아래에서 모두 쓰려면 try 앞에서 선언한다.
 *      int c;
 *      try { c = a / b; } catch (ArithmeticException e) { c = -1; }
 * 💡 0 으로 나누기 예외는 "정수" 나눗셈에서만 난다. 실수(double)를 0 으로 나누면 예외 없이 Infinity 나 NaN 이 된다.
 *      5.0 / 0 → Infinity,   0.0 / 0 → NaN
 * 💡 try-catch 가 없으면 예외가 난 순간 프로그램이 멈추고, 아래와 같은 메시지가 출력된다.
 *      Exception in thread "main" java.lang.ArithmeticException: / by zero
 * 💡 강의 코드의 public class 이름은 Example. 같은 폴더의 다른 예제와 겹치지 않도록 DivideExample 로 바꿨다.
 *
 * 실행 결과 (입력 : 10 0)
 *  두 정수를 입력하세요 : 10 0
 *  결과는 -1입니다.
 *  5.0 / 0 = Infinity
 *
 * 실행 결과 (입력 : 10 3)
 *  두 정수를 입력하세요 : 10 3
 *  결과는 3입니다.
 *  5.0 / 0 = Infinity
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
