/**
 * [11-2 예외처리2] 사용자 정의 예외
 *
 * 포인트
 *  - 프로그램을 작성하다 보면 프로그램에 맞는 예외를 정의하고, 이를 필요한 순간에 발생시키고 싶은 경우에 사용한다.
 *  - 사용자 정의 예외 클래스는 Exception 또는 RuntimeException 을 상속받는 형태로 정의해야 한다.
 *  - Exception 클래스를 상속할 경우 사용자 정의 예외는 checked 예외, RuntimeException 클래스를 상속하면 unchecked 예외가 된다.
 *
 *  (1) toString() 을 재정의한 예외 : NullNameException
 *      - System.out.println(e) 를 하면 e.toString() 이 자동으로 불린다. 재정의했으므로 "이름 미지정" 이 출력된다.
 *  (2) 인수가 있는 예외 : CountZeroException
 *      - 인수가 있는 예외 클래스를 정의할 경우, 예외 메시지를 별도의 필드에 저장해도 되지만 상위 예외 클래스의 필드를 활용할 수 있다.
 *        → super(message) 로 부모(Exception → Throwable)에게 메시지를 넘긴다.
 *      - toString() 을 재정의하지 않았으므로 Throwable 의 toString() 형식 "클래스이름: 메시지" 로 출력된다. → CountZeroException: hoho
 *
 * ⚠ 자주 틀리는 부분 : 강의 코드의 public CountZeroException(string message) 는 소문자 string 이라 컴파일 오류다. String 으로 고쳤다.
 *      error: cannot find symbol  symbol: class string
 * 💡 CountZeroException 처럼 매개변수 있는 생성자를 만들면 기본 생성자가 자동으로 생기지 않는다. 그래서 강의 코드는
 *    public CountZeroException() {} 도 함께 만들었다. (throw new CountZeroException(); 도 쓸 수 있게)
 * 💡 사용자 정의 예외를 왜 만드나? ArithmeticException 같은 표준 예외는 "무엇이 잘못됐는지" 를 프로그램의 용어로 말해 주지 못한다.
 *    NullNameException 처럼 이름만 봐도 상황을 알 수 있는 예외를 만들면, catch 에서 상황별로 나눠 처리하기 쉽다.
 * 💡 강의 코드의 public class 이름은 Example, ExceptionDemo. 한 파일에 넣으려고 하나의 main 으로 합쳤다.
 *
 * 실행 결과
 *  사용자 정의 예외 발생
 *  이름 미지정
 *  CountZeroException: hoho
 *  getMessage() → hoho
 */
public class UserDefinedExceptionTest {
    public static void main(String args[]) {
        try {
            throw new NullNameException();
        } catch (NullNameException e) {
            System.out.println("사용자 정의 예외 발생");
            System.out.println(e);
        }

        try {
            throw new CountZeroException("hoho");
        } catch (CountZeroException e) {
            System.out.println(e);
            System.out.println("getMessage() → " + e.getMessage());   // 💡 확인용
        }
    }
}

class NullNameException extends Exception {   // 사용자 정의 예외 클래스
    public String toString() {
        return ("이름 미지정");
    }
}

class CountZeroException extends Exception {
    public CountZeroException() { }

    public CountZeroException(String message) {   // 강의 코드 : string (⚠ 소문자)
        super(message);
    }
}
