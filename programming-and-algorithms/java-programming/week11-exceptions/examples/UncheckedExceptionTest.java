/**
 * [11-2 예외처리2] unchecked 예외
 *
 * 포인트
 *  - unchecked 예외 : 예외가 발생할 수 있지만, 별도의 예외 처리를 하지 않은 경우에도 컴파일 오류를 유발하지 않는 예외
 *  - 모든 unchecked 예외는 RuntimeException 클래스를 상속한다.
 *  - divide-by-zero 에 의해 발생하는 ArithmeticException 이 대표적이다.
 *  - unchecked 예외 처리는 전적으로 프로그래머에게 달려 있다. (처리해도 되고 안 해도 컴파일은 된다)
 *
 *  (1) ArithmeticException            : int r = n1 / n2;   (n2 == 0) → 예외가 발생하지만 컴파일 오류 없이 컴파일된다
 *  (2) ArrayIndexOutOfBoundsException : 길이 5 인 배열의 arr[6] 에 접근
 *  (3) NumberFormatException          : Integer.parseInt("XYZ") → 숫자로 변환할 수 없는 문자열
 *  (4) NullPointerException           : null 인 참조 변수로 메소드를 호출 (str.length())
 *
 * ⚠ 자주 틀리는 부분 : 강의의 (4) 번 코드는 String str; 만 선언하고 str.length() 를 부른다. 이것은 NullPointerException 이 아니라
 *    컴파일 오류다. 지역 변수는 값을 넣기 전에 쓸 수 없기 때문이다. (7강 변수의 유효 범위 - 지역 변수는 자동으로 초기화되지 않음)
 *      error: variable str might not have been initialized
 *    NullPointerException 을 보려면 String str = null; 처럼 null 을 명시적으로 넣어야 한다. 아래 코드는 그렇게 고쳤다.
 *    (필드(멤버 변수)는 자동으로 null 로 초기화되므로, 필드라면 강의 코드처럼 써도 NullPointerException 이 난다)
 * 💡 (1) 을 try-catch 없이 실행하면 프로그램이 멈추고 다음 메시지가 나온다. 아래에서는 확인용으로 잡아서 메시지만 출력했다.
 *      Exception in thread "main" java.lang.ArithmeticException: / by zero
 * 💡 NullPointerException 의 메시지는 JDK 14 부터 "어떤 변수가 null 이었는지" 까지 알려 준다. (Helpful NullPointerExceptions)
 * 💡 강의 코드의 public class 이름은 모두 Example. 한 파일에 넣으려고 case1 ~ case4 메소드로 나눴다.
 *
 * 실행 결과
 *  ---- (1) ArithmeticException ----
 *  (처리하지 않으면 프로그램 종료) java.lang.ArithmeticException: / by zero
 *  ---- (2) ArrayIndexOutOfBoundsException ----
 *  배열 인덱스 범위를 벗어나 접근했습니다
 *  ---- (3) NumberFormatException ----
 *  숫자로 변환 불가능 문자열 사용
 *  ---- (4) NullPointerException ----
 *  NullPointerException..
 */
public class UncheckedExceptionTest {
    public static void main(String args[]) {
        System.out.println("---- (1) ArithmeticException ----");
        try {
            case1();
        } catch (ArithmeticException e) {           // 💡 확인용
            System.out.println("(처리하지 않으면 프로그램 종료) " + e);
        }
        System.out.println("---- (2) ArrayIndexOutOfBoundsException ----");
        case2();
        System.out.println("---- (3) NumberFormatException ----");
        case3();
        System.out.println("---- (4) NullPointerException ----");
        case4();
    }

    static void case1() {
        int n1 = 3;
        int n2 = 0;

        int r = n1 / n2;     // 예외가 발생하지만 컴파일 오류 없이 컴파일됨
        System.out.println(r);
    }

    static void case2() {
        try {
            String arr[] = {"a", "b", "c", "d", "e"};
            System.out.println(arr[6]);   // 예외 발생
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱스 범위를 벗어나 접근했습니다");
        }
    }

    static void case3() {
        try {
            int n = Integer.parseInt("XYZ");   // 예외 발생
            System.out.println(n);
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환 불가능 문자열 사용");
        }
    }

    static void case4() {
        try {
            String str = null;                 // 강의 코드 : String str; (⚠ 컴파일 오류)
            System.out.println(str.length());  // 예외 발생
        } catch (NullPointerException e) {
            System.out.println("NullPointerException..");
        }
    }
}
