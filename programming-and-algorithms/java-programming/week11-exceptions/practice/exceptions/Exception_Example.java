/**
 * [11강 실습] 예외 처리 - 1번 문제 (0 으로 나누기 : throw + try-catch)
 *
 * 문제
 *  예외를 발생시키고 try-catch 블록을 사용하여 이를 포착하도록 아래 프로그램을 수정하시오.
 *
 *    public class Exception_Example {
 *        public static void main(String[] args) {
 *            int result = divideNumbers(5, 0);
 *            System.out.println("Result: " + result);
 *        }
 *
 *    실행 결과 :
 *    Error: Cannot divide the given number by zero!
 *
 * 📝 필기 : 이 문제는 자바의 예외 처리(Exception Handling) 기본 원리인 예외 직접 발생시키기(throw)와 예외 포착하기(try-catch)를
 *          이해하고 있는지 확인하는 문제다.
 *
 * 📝 필기 : 1. 문제 분석 (무엇이 빠져 있고, 무엇을 해야 할까?) - 주어진 코드와 실행 결과를 살펴보면 다음 3가지를 해결해야 한다.
 *   1. 메서드 미구현 : main 메서드 안에서 divideNumbers(5, 0) 을 호출하고 있지만, 실제로 divideNumbers 메서드가 작성되어 있지 않다.
 *      (또한 클래스의 닫는 중괄호 } 도 빠져 있다)
 *   2. 예외 발생 조건 : 두 번째 인자로 0 을 전달하여 나눗셈을 시도하고 있다. 수학적으로 숫자를 0 으로 나눌 수 없으므로,
 *      나누는 수가 0 일 때 예외를 발생시켜야 한다.
 *   3. 실행 결과 맞추기 : 프로그램이 강제 종료되는 대신, 아래의 문구가 출력되도록 예외를 잡아서 처리해야 한다.
 *        Error: Cannot divide the given number by zero!
 *
 * 📝 필기 : 2. 핵심 개념 정리
 *   ① 예외(Exception)와 ArithmeticException
 *      - 예외 (Exception) : 프로그램 실행 중 발생하는 예상치 못한 오류 상황이다. 이를 처리하지 않으면 프로그램이 에러 메시지를
 *        띄우고 즉시 비정상 종료된다.
 *      - ArithmeticException : 자바에서 기본 제공하는 예외 클래스로, 정수를 0 으로 나누는 등 산술 연산 오류가 발생했을 때 사용한다.
 *   ② 예외 직접 발생시키기 (throw 키워드)
 *      - 문법 : throw new 예외클래스("에러 메시지");
 *      - 중요 포인트! 왜 굳이 if 문과 throw 를 직접 쓸까요?
 *        자바에서 단순히 5 / 0 을 계산해도 자바가 자동으로 ArithmeticException 을 발생시킨다. 하지만 이때 자동으로 생성되는
 *        기본 메시지는 "/ by zero" 이다. 문제의 실행 결과처럼 "Cannot divide the given number by zero!" 라는 원하는 메시지를
 *        출력하려면, 개발자가 직접 조건(divisor == 0)을 검사하고 throw 키워드로 원하는 메시지를 담아 예외를 생성해 던져 주어야 한다.
 *   ③ 예외 포착 및 처리 (try-catch 블록)
 *      - try { ... } : 예외가 발생할 가능성이 있는 코드를 감싸는 영역이다.
 *      - catch (예외타입 변수명) { ... } : try 블록 안에서 예외가 발생했을 때, 프로그램이 죽지 않고 실행 흐름을 넘겨받아
 *        오류를 처리하는 영역이다.
 *      - e.getMessage() : catch 로 잡은 예외 객체(e) 안에 들어 있는 에러 메시지 문자열을 꺼내는 메서드다.
 *   ④ static 메서드
 *      - main 메서드가 static 으로 선언되어 있으므로, 객체를 따로 생성(new Exception_Example())하지 않고 divideNumbers(5, 0)
 *        처럼 바로 호출하려면 divideNumbers 메서드도 반드시 static 으로 선언해야 한다.
 *
 * 📝 필기 : 4. 코드 실행 흐름 단계별 추적 - 위 코드가 실행될 때 컴퓨터 내부에서 어떤 순서로 동작하는지
 *   1. main 시작 → try 블록 진입 : divideNumbers(5, 0) 메서드를 호출한다.
 *   2. divideNumbers 메서드 실행 : 매개변수로 dividend = 5, divisor = 0 이 전달된다. if (divisor == 0) 조건이 참(true)이 된다.
 *   3. 예외 발생 (throw) : throw new ArithmeticException("Cannot divide the given number by zero!"); 가 실행된다.
 *      예외 객체가 생성되어 던져지며, 아래의 return dividend / divisor; 는 실행되지 않고 메서드가 즉시 종료된다.
 *   4. try 블록 중단 → catch 블록으로 이동 : 호출한 곳(main 의 try 블록)으로 예외가 넘어온다. 예외가 발생했기 때문에 바로 다음 줄인
 *      System.out.println("Result: " + result); 는 실행되지 않고 건너뛴다. 발생한 예외 타입(ArithmeticException)과 일치하는
 *      catch (ArithmeticException e) 블록으로 점프한다.
 *   5. 예외 메시지 출력 및 정상 종료 : e.getMessage() 가 "Cannot divide the given number by zero!" 를 반환한다.
 *      "Error: " 와 합쳐져 최종적으로 Error: Cannot divide the given number by zero! 가 출력되고 프로그램이 안전하게 종료된다.
 *
 * 📝 필기 : 💡 추가 팁 : throw vs throws 헷갈리지 마세요!
 *   - throw (메서드 내부에서 사용) : 예외를 실제로 발생시킬 때 사용한다. (예 : throw new ArithmeticException(...);)
 *   - throws (메서드 선언부에서 사용) : "이 메서드에서는 이런 예외가 발생할 수 있으니, 호출한 쪽에서 처리하세요" 라고
 *     예외 처리를 떠넘길 때 사용한다.
 *     (참고 : ArithmeticException 은 실행 시 예외(Unchecked Exception)이므로 메서드 선언부에 throws ArithmeticException 을
 *      굳이 적지 않아도 컴파일 오류가 나지 않는다)
 *
 * 📝 필기 : e.getMessage() 를 빼고 e 만 출력하면 예외의 클래스 이름까지 함께 출력된다.
 *   1. 출력 결과 비교 - catch 블록에서 두 코드를 각각 실행했을 때
 *      ① e.getMessage() 를 사용했을 때 (정답)
 *           System.out.println("Error: " + e.getMessage());
 *         - 실행 결과 : Error: Cannot divide the given number by zero!
 *         - 특징 : 예외 객체 안에 들어 있는 순수한 에러 메시지 문자열만 깔끔하게 꺼낸다.
 *      ② e 만 그대로 출력했을 때
 *           System.out.println("Error: " + e);
 *         - 실행 결과 : Error: java.lang.ArithmeticException: Cannot divide the given number by zero!
 *         - 특징 : 메시지 앞에 java.lang.ArithmeticException: 이라는 예외 클래스의 전체 경로(패키지명 + 클래스명)가 함께 붙어서
 *           출력된다. 따라서 문제에서 요구하는 실행 결과와 달라지게 된다.
 *   2. 왜 e 만 출력하면 클래스 이름까지 나올까요? (원리)
 *      자바에서 객체를 문자열과 더하거나("Error: " + e) System.out.println(e) 에 넣으면, 자바가 자동으로 그 객체의 toString()
 *      메서드를 호출한다. 즉, 아래 두 코드는 내부적으로 완전히 똑같이 동작한다.
 *        System.out.println(e);
 *        System.out.println(e.toString());   // 자동 호출됨
 *      모든 예외 클래스의 조상인 Throwable 클래스에는 toString() 이 다음과 같은 형태로 미리 정의(오버라이딩)되어 있다.
 *        "패키지명.예외클래스명: " + 예외메시지
 *      (참고 : 만약 예외를 생성할 때 메시지를 안 넣고 new ArithmeticException() 처럼 비워 뒀다면, e.getMessage() 는 null 을 반환하고,
 *       e 는 java.lang.ArithmeticException 만 출력한다)
 *   3. 한눈에 보는 예외 정보 출력 방법 3가지 - 실무나 학습에서 예외를 출력하는 방법은 크게 3가지가 있으며, 목적에 따라 골라 쓴다.
 *        코드                    출력 내용                                         주로 사용하는 상황
 *        e.getMessage()          Cannot divide the given number by zero!           사용자에게 깔끔한 안내 문구만 보여 줄 때 (이번 문제!)
 *                                (메시지만 출력)
 *        e (또는 e.toString())   java.lang.ArithmeticException: Cannot divide...   어떤 종류의 예외가 발생했는지 간단히 로그로 남길 때
 *                                (예외 종류 + 메시지)
 *        e.printStackTrace()     예외 종류 + 메시지 + 오류가 발생한 정확한 코드      개발자가 디버깅할 때 에러가 정확히 몇 번째 줄에서
 *                                줄 번호 (스택 트레이스)                            터졌는지 추적할 때
 *      따라서 이번 문제에서는 사용자에게 Error: Cannot divide the given number by zero! 처럼 에러 메시지만 깔끔하게 보여 주는 것이
 *      목적이므로, e 가 아닌 e.getMessage() 를 반드시 사용해야 한다.
 *
 * 💡 아래 main 의 "---- 비교 ----" 부분은 📝 필기의 세 가지 출력 방법과, throw 없이 5 / 0 을 했을 때의 기본 메시지를 확인용으로 덧붙인 것이다.
 *    printStackTrace() 는 System.err 로 출력되므로 콘솔에서 빨간 글씨로 보이고, 실행 결과의 줄 번호는 환경마다 다를 수 있다.
 *
 * 실행 결과
 *  Error: Cannot divide the given number by zero!
 *  ---- 비교 ----
 *  e.getMessage() → Cannot divide the given number by zero!
 *  e              → java.lang.ArithmeticException: Cannot divide the given number by zero!
 *  5 / 0 의 기본 메시지 → / by zero
 */
public class Exception_Example {
    public static void main(String[] args) {
        try {
            int result = divideNumbers(5, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("---- 비교 ----");   // 💡 확인용
        try {
            divideNumbers(5, 0);
        } catch (ArithmeticException e) {
            System.out.println("e.getMessage() → " + e.getMessage());
            System.out.println("e              → " + e);
        }
        try {
            int zero = 0;
            System.out.println(5 / zero);
        } catch (ArithmeticException e) {
            System.out.println("5 / 0 의 기본 메시지 → " + e.getMessage());
        }
    }

    public static int divideNumbers(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide the given number by zero!");
        }
        return dividend / divisor;
    }
}
