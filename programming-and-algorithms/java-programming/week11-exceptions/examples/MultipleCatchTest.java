/**
 * [11-1 예외처리1] [실습] 다중 catch 문 - 예외 처리 순서
 *
 * 포인트
 *  - try-catch 문에서 여러 catch 문을 사용할 수 있다.
 *  - catch 문은 위에서부터 순서대로 검사한다. 처음으로 타입이 맞는 catch 하나만 실행되고 나머지는 건너뛴다.
 *  - (1) arr[4] = 20 / 0;  → 오른쪽 20 / 0 을 먼저 계산하다가 ArithmeticException → 첫 번째 catch 에서 받음
 *  - (2) arr[6] = 20 / 5;  → 20 / 5 = 4 는 문제없고, 인덱스 6 에 저장하다가 ArrayIndexOutOfBoundsException → 두 번째 catch 에서 받음
 *  - 두 경우 모두 예외가 난 다음 줄인 "First print statement in try block" 은 출력되지 않는다.
 *  - catch (Exception e) 는 위의 두 catch 에서 잡지 못한 나머지 모든 예외를 처리한다. 그래서 맨 마지막에 둔다.
 *
 * ⚠ 자주 틀리는 부분 : catch (Exception e) 를 맨 위에 두면 아래 catch 는 절대 실행될 수 없어서 컴파일 오류가 난다.
 *      error: exception ArithmeticException has already been caught
 *    구체적인 하위(자식) 예외를 위에, 포괄적인 상위(부모) 예외를 아래에 쓴다. (퀴즈 4번)
 * 💡 arr[4] = 20/0; 처럼 대입문은 오른쪽 식을 먼저 계산한다. 그래서 (1) 에서는 인덱스 4 가 올바른지와 상관없이 나눗셈 예외가 먼저 난다.
 * 💡 강의 자료의 제목은 "ArichmeticException" 으로 적혀 있지만 정확한 클래스 이름은 ArithmeticException 이다.
 * 💡 강의 코드의 클래스 이름은 두 경우 모두 MultipleCatchTest. 한 파일에 넣으려고 case1, case2 메소드로 나눴다.
 *
 * 실행 결과
 *  ---- (1) ArithmeticException ----
 *  Warning: ArithmeticException
 *  try-catch 블락 밖...
 *  ---- (2) ArrayIndexOutOfBoundsException ----
 *  Warning: ArrayIndexOutOfBoundsException
 *  try-catch 블락 밖...
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
