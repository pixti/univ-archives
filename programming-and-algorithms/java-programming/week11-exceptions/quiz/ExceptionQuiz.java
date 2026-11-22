import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * [11강 퀴즈] 예외 처리 (Throwable 계층 · throw / throws · checked / unchecked · 사용자 정의 예외 · catch 순서)
 *
 *  1. 왜 try 블록에서 던진 "문자열" 을 catch 블록에서 잡을 수 없는가?                  → q1()
 *  2. process() 가 던진 FileNotFoundException / ArithmeticException 을 main() 에서 처리하기 (빈칸 채우기) → q2()
 *  3. 월급의 세금을 계산하는 getTax() 에 사용자 정의 예외 적용하기                       → q3()
 *  4. catch(Exception e) 다음에 catch(IOException e) 를 쓴 코드의 논리적 오류          → q4()
 *
 * 💡 한 파일 안에서 실행하려고 문제의 예외 클래스(NegativeSalary 등)를 아래쪽에 public 없이 넣었다.
 *
 * 표시
 *   📝 필기 : 채점 후 정리한 내용 / ⚠ 자주 틀리는 부분 : 헷갈리기 쉬운 오답과 그 이유 / 💡 보충 설명
 *
 * 실행 결과
 *  ===== 1 =====
 *  하드디스크가 가득 찼습니다.
 *  ===== 2 =====
 *  FileNotFoundException 을 main 에서 처리 : java.io.FileNotFoundException
 *  ArithmeticException 을 main 에서 처리 : java.lang.ArithmeticException
 *  ===== 3 =====
 *  세금 : 300.0
 *  예외 발생: 월급(salary)은 0보다 커야 합니다.
 *  방식 B (내부 처리) → 예외 발생: 월급(salary)은 0보다 커야 합니다.
 *  방식 B 의 반환값 : 0.0
 *  임금이 음수입니다!
 *  ===== 4 =====
 *  IOException 처리 : 디스크 읽기 실패
 *  Exception 처리 : java.lang.IllegalStateException
 */
public class ExceptionQuiz {
    public static void main(String[] args) {
        System.out.println("===== 1 =====");
        q1();
        System.out.println("===== 2 =====");
        q2();
        System.out.println("===== 3 =====");
        q3();
        System.out.println("===== 4 =====");
        q4();
    }

    /**
     * 1. 다음 코드에서는 왜 try 블록에서 던져진 예외를 catch 블록에서 잡을 수 없는가?
     *
     *   try
     *   {
     *       .....
     *       throw "하드디스크가 가득 찼습니다.";
     *   }
     *   catch(String s)
     *   {
     *       System.out.println(s);
     *   }
     *
     * 정답 : Java 에서 throw 키워드로 던지거나 catch 블록에서 잡을 수 있는 객체는 Throwable 클래스 및 이를 상속받은
     *        하위 클래스(Error, Exception) 타입으로 한정되어 있다. 문제의 코드에서 던지려는 "하드디스크가 가득 찼습니다." 는
     *        String 클래스 타입으로, Throwable 클래스를 상속받지 않았기 때문에 예외로 던질 수도 없고 catch 블록에서
     *        잡을 수도 없다. (컴파일 에러 발생)
     *          error: incompatible types: String cannot be converted to Throwable
     *
     * 📝 필기 : throw 로 던질 수 있는 유형이 Java 에서는 Throwable 타입만 가능하도록 한정되어 있다.
     *    Throwable 는 클래스로, 이를 상속받아 만들어진 Error, Exception 객체도 가능.
     *    프로그래머가 조치를 취할 수 있는 경우의 에러가 아닌 하드웨어 등 → Error
     *    소프트웨어적으로 조치를 취할 수 있는 경우 → Exception
     *    Exception 밑에는 또 RuntimeException 이 있다.
     *
     * 📝 필기 : 예외 클래스의 계층 구조 (Hierarchy)
     *        Object
     *          ↑
     *       Throwable
     *        ↗     ↖
     *     Error   Exception
     *                ↑
     *          RuntimeException
     *   ① Throwable 클래스
     *      - Java 에서 예외 처리를 할 수 있는 최상위 클래스다.
     *      - 오직 Throwable 클래스와 이를 상속받아 만들어진 자식 클래스의 객체만이 throw 키워드를 통해 던져질 수 있고,
     *        catch 블록의 매개변수로 선언될 수 있다.
     *      - Throwable 을 상속받는 대표적인 두 가지 하위 클래스는 Error 와 Exception 이다.
     *   ② Error (에러)
     *      - 정의 : 하드웨어의 고장, JVM(자바 가상 머신)의 리소스 부족(예 : 메모리 부족 OutOfMemoryError,
     *        스택 오버플로우 StackOverflowError) 등 시스템 레벨에서 발생하는 심각한 문제다.
     *      - 특징 : 프로그래머가 소프트웨어적인 코드 작성만으로는 조치를 취하거나 복구할 수 없는 경우에 해당한다.
     *        따라서 프로그램 코드에서 try-catch 로 잡아서 처리하려고 시도하지 않는다.
     *   ③ Exception (예외)
     *      - 정의 : 프로그램 실행 중 발생할 수 있는 비교적 경미한 오류로, 프로그래머가 소프트웨어적으로(예외 처리 코드를 통해)
     *        조치를 취하고 복구할 수 있는 경우다.
     *      - 특징 : 파일이 존재하지 않거나, 네트워크 연결이 끊기는 등의 상황에서 try-catch 블록을 사용하여
     *        프로그램이 비정상 종료되는 것을 막고 정상적인 실행 흐름을 유지할 수 있다.
     *   ④ RuntimeException (실행 예외)
     *      - 정의 : Exception 클래스의 하위 클래스 중 하나로, 주로 프로그래머의 실수에 의해 발생하는 예외다.
     *      - 특징 : 배열의 범위를 벗어난 참조(ArrayIndexOutOfBoundsException), 값이 없는 참조변수 사용(NullPointerException),
     *        0 으로 나누기(ArithmeticException) 등이 여기에 속한다.
     *        일반 Exception(Checked Exception)은 반드시 try-catch 로 감싸거나 예외를 선언해야만 컴파일이 되지만,
     *        RuntimeException(Unchecked Exception)은 컴파일러가 예외 처리 여부를 강제하지 않으며 프로그램 실행(Runtime) 중에 발생한다.
     *
     * 올바른 코드 수정 예시 : 소프트웨어적으로 조치를 취할 수 있는 상황으로 처리하려면,
     *   Throwable 의 하위 클래스인 Exception 객체를 생성하여 던져야 한다.
     *     try {
     *         // String 이 아닌, Throwable 을 상속받은 Exception 객체를 생성하여 던짐
     *         throw new Exception("하드디스크가 가득 찼습니다.");
     *     }
     *     catch(Exception e) {        // Exception 타입으로 예외를 잡음
     *         System.out.println(e.getMessage());
     *     }
     *
     * ⚠ 자주 틀리는 부분 : C++ 은 throw "문자열"; 처럼 아무 타입이나 던질 수 있어서 헷갈리기 쉽다. 자바는 Throwable 만 된다.
     */
    static void q1() {
        try {
            throw new Exception("하드디스크가 가득 찼습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 2. process() 라는 메서드가 FileNotFoundException 타입의 예외 또는 ArithmeticException 을 발생하고
     *    이것을 main() 에서 처리한다고 가정하자. 다음의 빈칸을 채우시오.
     *
     *   public static void main(String[] args)
     *   {
     *       try{
     *           process();
     *       }
     *       catch(______①______){ ... }
     *       catch(______②______){ ... }
     *   }
     *   public void process() ______③______
     *   {
     *       int x = 3;
     *       if (x > 0)  ______④______   // FileNotFoundException 예외를 발생
     *       else        ______⑤______   // ArithmeticException 예외를 발생
     *   }
     *
     * 정답 (빈칸 정답 완성 코드)
     *   public static void main(String[] args)
     *   {
     *       try {
     *           process();
     *       }
     *       catch(FileNotFoundException e) {   // ① 첫 번째 빈칸
     *           ...
     *       }
     *       catch(ArithmeticException e) {     // ② 두 번째 빈칸
     *           ...
     *       }
     *   }
     *   public void process() throws FileNotFoundException, ArithmeticException   // ③ 세 번째 빈칸
     *   {
     *       int x = 3;
     *       if (x > 0) throw new FileNotFoundException();   // ④ 네 번째 빈칸
     *       else throw new ArithmeticException();           // ⑤ 다섯 번째 빈칸
     *   }
     *   (참고 : ① 번과 ② 번 빈칸의 순서는 서로 바뀌어도 무방하다)
     *
     * 빈칸별 상세 풀이
     *   ①, ② catch 블록의 매개변수 : FileNotFoundException e, ArithmeticException e (변수명 e 는 임의로 지정 가능)
     *     - try 블록 안에서 호출한 process() 가 두 종류의 예외를 던질 수 있으므로, 이를 호출한 main() 에서 각각의 예외를
     *       받아서 처리할 catch 블록이 필요하다.
     *     - catch 의 괄호 안에는 처리하고자 하는 "예외 클래스 타입 + 변수명" 을 선언한다.
     *     - 두 예외 클래스는 서로 상속 관계(부모-자식 관계)가 아니므로 어느 것을 먼저 작성해도 상관없다.
     *   ③ 메서드 선언부의 예외 전가(throws) : throws FileNotFoundException, ArithmeticException (또는 throws FileNotFoundException)
     *     - process() 안에서 발생한 예외를 자체적으로 try-catch 로 처리하지 않고, 자신을 호출한 곳(main())으로
     *       떠넘기기(전가하기) 위해 메서드 선언부 끝에 throws 키워드를 사용한다.
     *     - 여러 개의 예외를 던질 수 있을 때는 쉼표(,)로 구분하여 나열한다.
     *     - FileNotFoundException 은 일반 Exception(Checked Exception)이므로 반드시 throws 로 명시해야 컴파일 에러가 발생하지 않는다.
     *       반면 ArithmeticException 은 RuntimeException(Unchecked Exception)의 하위 클래스이므로 컴파일러가 예외 처리를
     *       강제하지 않는다. 따라서 문법적으로는 throws FileNotFoundException 만 적어 주어도 정상 작동하지만,
     *       문제의 출제 의도상 발생하는 두 예외를 모두 명시하는 것이 정석이다.
     *   ④, ⑤ 예외 강제 발생(throw) : throw new FileNotFoundException();  throw new ArithmeticException();
     *     - 코드 상에서 프로그래머가 고의로 예외를 발생시킬 때는 throw 키워드를 사용한다.
     *     - Java 에서 예외는 객체 형태로 던져야 하므로, new 연산자를 사용하여 해당 예외 클래스의 인스턴스(객체)를 생성해서
     *       던져야 한다. (예 : throw new 예외클래스생성자();)
     *     - 문장의 끝이므로 반드시 세미콜론(;)을 붙여야 한다.
     *
     * 핵심 키워드 구분 요약 (throw vs throws) : 시험에서 자주 혼동하는 두 키워드
     *   1. throw (빈칸 ④, ⑤) : 메서드 본문(중괄호 { } 내부)에서 실제로 예외 객체를 생성하여 던질 때 사용한다.
     *   2. throws (빈칸 ③) : 메서드 선언부(이름 뒤)에서 이 메서드가 어떤 예외들을 발생시킬 수 있는지 명시하고,
     *      호출한 메서드로 예외 처리를 떠넘길 때 사용한다.
     *
     * 📝 필기 : (빈칸 ③) try ~ catch 로 하지 않는 경우 throws 로 어떤 예외가 발생할 수 있다 라고 명시해야 함.
     * 📝 필기 : throws FileNotFoundException, ArithmeticException 에서 ArithmeticException 는 RuntimeException 이라
     *          명시하지 않아도 된다.
     *
     * 📝 필기 : 예외가 발생할 가능성이 있는 코드(throw new ...)를 작성했을 때, 반드시 다음 두 가지 방법 중 하나를 선택해야 한다.
     *   1. 직접 처리 (try ~ catch) : 예외가 발생한 그 메서드 내부에서 직접 try ~ catch 블록으로 감싸서 예외를 즉시 처리한다.
     *   2. 예외 떠넘기기 (throws) : 예외가 발생한 메서드 내부에서 직접 처리하지 않고(try ~ catch 를 쓰지 않고),
     *      이 메서드를 호출한 곳(상위 메서드)으로 예외 처리를 위임한다.
     *   따라서 2번 문제의 process() 는 내부에서 try ~ catch 로 직접 처리하지 않았기 때문에, 메서드 선언부에
     *   throws FileNotFoundException, ArithmeticException 을 작성하여 "이 메서드를 실행하면 이러한 예외들이 발생할 수
     *   있으니 호출하는 쪽에서 처리하라" 고 반드시 명시해야 한다.
     *
     *   방식 A : 메서드 내부에서 직접 try ~ catch 로 처리하는 경우 (throws 불필요)
     *     process() 내부에서 직접 예외를 잡아서 처리했으므로, 외부로 예외가 빠져나가지 않아 throws 를 명시할 필요가 없다.
     *       public void process()   // throws 명시할 필요 없음
     *       {
     *           int x = 3;
     *           try {
     *               if (x > 0) throw new FileNotFoundException();
     *               else throw new ArithmeticException();
     *           }
     *           catch (FileNotFoundException e) { … }   // process() 내부에서 직접 처리
     *           catch (ArithmeticException e) { … }     // process() 내부에서 직접 처리
     *       }
     *   방식 B : try ~ catch 로 처리하지 않는 경우 (throws 명시 필수 - 문제의 상황)
     *     문제의 조건이 "예외를 process() 가 발생시키고, 이것을 main() 에서 처리한다" 라고 되어 있으므로, process() 내부에서는
     *     try ~ catch 를 쓰지 않는다. 대신 throws 로 발생할 수 있는 예외를 명시하여 main() 에게 처리를 넘긴다.
     *       // 1. try - catch 를 쓰지 않는 대신, 어떤 예외가 발생할 수 있는지 throws 로 명시함
     *       public void process() throws FileNotFoundException, ArithmeticException { … }
     *     이렇게 명시해 두면, process() 를 호출하는 main() 메서드 쪽에서 의무적으로 try ~ catch 를 작성하여
     *     넘겨받은 예외를 처리하게 된다.
     *
     * 📝 필기 : 예외의 계층 구조와 두 가지 분류 - Exception 의 하위 클래스들은 RuntimeException 을 상속받는지 여부에 따라
     *          성격이 완전히 달라진다.
     *            Exception
     *            ↗          ↖
     *     (일반 Exception)   RuntimeException
     *          ↑                  ↑
     *   FileNotFoundException  ArithmeticException
     *   ① 일반 Exception (Checked Exception - 체크 예외)
     *      - 해당 클래스 : RuntimeException 을 제외한 모든 Exception 의 하위 클래스 (예 : FileNotFoundException, IOException 등)
     *      - 특징 : 외부 환경(파일 없음, 네트워크 끊김 등)에 의해 발생할 수 있는 예외이므로, 컴파일러가 예외 처리 여부를
     *        엄격하게 검사(Check)한다. 따라서 이 예외가 발생할 수 있는 코드는 반드시 try ~ catch 로 감싸거나 throws 로 명시해야만
     *        한다. 둘 중 하나라도 하지 않으면 컴파일 에러가 발생하여 프로그램 실행 자체가 불가능하다.
     *   ② RuntimeException (Unchecked Exception - 언체크 예외)
     *      - 해당 클래스 : RuntimeException 및 이를 상속받은 모든 하위 클래스
     *        (예 : ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException 등)
     *      - 특징 : 주로 프로그래머의 부주의나 논리적 실수(0 으로 나누기, 배열 인덱스 초과, null 참조 등)로 인해 프로그램
     *        실행(Runtime) 중에 발생하는 예외다. 컴파일러가 예외 처리(try ~ catch 나 throws) 여부를 검사하지 않는다(Unchecked).
     *        따라서 throws 에 명시하지 않아도 컴파일 에러가 발생하지 않으며, 예외가 실제로 발생하면 자동으로 호출한
     *        메서드(main()) 쪽으로 던져진다.
     *
     * 📝 필기 : 왜 RuntimeException 은 명시를 강제하지 않는가?
     *   만약 RuntimeException 까지 무조건 try ~ catch 나 throws 로 명시하도록 강제한다면, 프로그래머는 사소한 코드 한 줄을
     *   작성할 때마다 예외 처리를 해야 한다. 예를 들어, 단순한 나눗셈 연산이나 배열 접근을 할 때마다 아래처럼 코드를 짜야 하는
     *   비효율이 발생한다.
     *     // 만약 RuntimeException 도 예외 처리를 강제한다면,
     *     // 단순 나눗셈이나 배열을 쓸 때마다 매번 throws 나 try-catch 를 써야 함
     *     int result = a / b;     // ArithmeticException 발생 가능 구간
     *     int value = arr[0];     // ArrayIndexOutOfBoundsException 발생 가능 구간
     *   이처럼 코드 전반에서 언제든 발생할 수 있는 예외이기 때문에, Java 는 이를 프로그래머가 코드를 올바르게 작성하여
     *   예방할 문제로 보고 throws 명시나 try ~ catch 작성을 강제하지 않는 것이다.
     *
     * 📝 필기 : 문제 코드에의 적용 정리 - 문제의 process() 메서드에서는 두 개의 예외를 던지고 있다.
     *     public void process() throws FileNotFoundException   // ArithmeticException 생략 가능
     *     {
     *         int x = 3;
     *         if (x > 0) throw new FileNotFoundException();   // 일반 Exception → throws 명시 필수
     *         else throw new ArithmeticException();           // RuntimeException → throws 명시 생략 가능
     *     }
     *   1. FileNotFoundException : RuntimeException 이 아닌 일반 Exception 이므로, try ~ catch 를 안 썼다면
     *      throws FileNotFoundException 을 무조건 적어야만 컴파일이 된다.
     *   2. ArithmeticException : RuntimeException 의 자식 클래스이므로, throws 에 적어도 되고 적지 않아도 된다.
     *      적지 않더라도 실행 중에 예외가 발생하면 알아서 main() 메서드의 catch(ArithmeticException e) 블록으로 전달되어
     *      정상적으로 처리된다.
     *
     * ⚠ 자주 틀리는 부분 : 문제의 process() 는 static 이 아니다. static main 에서 process() 를 바로 부르면
     *    error: non-static method process() cannot be referenced from a static context
     *    여기서는 static 으로 만들었다. (또는 new ExceptionQuiz().process() 처럼 객체를 만들어서 부른다)
     * 💡 실행해서 두 catch 를 모두 확인하려고 process(int x) 로 x 를 바꿔 가며 두 번 호출했다.
     */
    static void q2() {
        for (int x : new int[] {3, 0}) {
            try {
                process(x);
            } catch (FileNotFoundException e) {      // ①
                System.out.println("FileNotFoundException 을 main 에서 처리 : " + e);
            } catch (ArithmeticException e) {        // ②
                System.out.println("ArithmeticException 을 main 에서 처리 : " + e);
            }
        }
    }

    static void process(int x) throws FileNotFoundException, ArithmeticException {   // ③
        if (x > 0) throw new FileNotFoundException();    // ④
        else throw new ArithmeticException();            // ⑤
    }

    /**
     * 3. 회사에서 월급에 대한 세금을 계산하는 다음과 같은 메서드가 있다고 하자.
     *    사용자 정의 예외를 이용하여 이 메서드에 예외 처리를 해 보라.
     *
     *   public dobule getTax(int salary, double rate)
     *   {
     *       return salary * rate;
     *   }
     *   (문제의 dobule 은 double 의 오타)
     *
     * 📝 필기 : 일반 클래스로는 예외를 발생시킬 수 없고 Throwable 타입이어야만 한다.
     *          따라서 extends Exception 또는 extends RuntimeException 로 상속을 받아야 한다.
     * 📝 필기 : 모든 객체에 대해서 toString 으로 정의가 되어 있다. 예외 객체에 대해서도 정의 가능.
     *
     * 문제 풀이 (완성 코드) : 월급(salary)이 0 이하(음수)일 때 발생시킬 사용자 정의 예외 클래스 NegativeSalary 를 정의하고,
     *                         이를 getTax() 메서드에 적용한다.
     *   ① 사용자 정의 예외 클래스 작성 (NegativeSalary)
     *       // Exception 또는 RuntimeException 을 상속받아 정의
     *       public class NegativeSalary extends Exception   // (또는 extends RuntimeException)
     *       {
     *           // 모든 객체의 최상위 클래스인 Object 에 정의된 toString() 메서드를 오버라이딩(재정의)
     *           public String toString() {
     *               return "예외 발생: 월급(salary)은 0보다 커야 합니다.";
     *           }
     *       }
     *   ② getTax 메서드에 예외 처리 적용
     *     방식 A : throws 로 예외를 호출한 곳에 떠넘기는 경우 (가장 일반적인 형태)
     *       // NegativeSalary 가 일반 Exception 을 상속받았다면 throws 를 반드시 명시해야 함
     *       // (만약 RuntimeException 을 상속받았다면 throws NegativeSalary 생략 가능)
     *       public double getTax(int salary, double rate) throws NegativeSalary
     *       {
     *           if (salary > 0)
     *               return salary * rate;
     *           else
     *               throw new NegativeSalary();   // 예외 객체를 생성하여 던짐 (throw 키워드 필수)
     *       }
     *     방식 B : 메서드 내부에서 try ~ catch 로 직접 처리하는 경우
     *       public double getTax(int salary, double rate)
     *       {
     *           try {
     *               if (salary > 0)
     *                   return salary * rate;
     *               else
     *                   throw new NegativeSalary();
     *           }
     *           catch (NegativeSalary e) {
     *               System.out.println(e.toString());   // 재정의한 toString() 이 호출됨 (또는 그냥 e 출력)
     *               return 0.0;                         // 예외 발생 시 기본 반환값
     *           }
     *       }
     *
     *   ① 왜 extends Exception 또는 extends RuntimeException 을 해야 하는가?
     *     - 원리 : 1번 문제에서 다뤘듯, Java 에서는 일반 클래스로는 예외를 발생(throw)시킬 수 없으며 반드시 Throwable 타입
     *       (또는 그 하위 클래스)이어야만 예외로 던지고 잡을 수 있다.
     *     - 적용 : 따라서 프로그래머가 직접 새로운 예외 클래스를 만들 때(사용자 정의 예외)는 Throwable 의 하위 클래스인
     *       Exception 또는 RuntimeException 을 상속(extends)받아야만 예외 클래스로서 동작할 수 있다.
     *       · extends Exception 사용 시 : Checked Exception 이 되므로, getTax() 에서 try ~ catch 를 안 쓰면
     *         선언부에 throws NegativeSalary 를 필수로 적어야 한다.
     *       · extends RuntimeException 사용 시 : Unchecked Exception 이 되므로, throws NegativeSalary 를 생략해도
     *         컴파일 에러가 나지 않는다.
     *   ② 예외 발생 코드에서 주의할 점 (throw new)
     *     ⚠ 자주 틀리는 부분 : else new NegativeSalary(); 처럼 객체를 생성(new)만 하면 예외가 발생하지 않는다.
     *       반드시 앞에 throw 키워드를 붙여서 else throw new NegativeSalary(); 형태로 작성해야 예외로 던져진다.
     *   ③ toString() 메서드 재정의 (Overriding)
     *     - 원리 : Java 의 모든 클래스는 최상위 클래스인 Object 를 암묵적으로 상속받으며, Object 클래스에는 객체의 정보를
     *       문자열로 반환하는 public String toString() 메서드가 정의되어 있다.
     *     - 적용 : 사용자 정의 예외 클래스(NegativeSalary) 역시 객체이므로 toString() 메서드를 자신의 상황에 맞게
     *       재정의(Overriding)할 수 있다.
     *     - 효과 : toString() 을 재정의해 두면, 나중에 catch(NegativeSalary e) 블록에서 System.out.println(e); 또는
     *       System.out.println(e.toString()); 을 실행했을 때 toString() 이 반환하는 안내 문자열
     *       ("예외 발생: 월급(salary)은 0보다 커야 합니다.")이 화면에 출력된다.
     *
     * 📝 필기 : NegativeSalary("임금이 음수입니다!"); 처럼 에러 메시지를 넘겨줄 수도 있는데,
     *          하위 클래스에서 직접 부모 클래스에 대한 세팅이 안 돼서 (private 필드를 물려받은 것이기 때문에)
     *          세팅하려면 부모 생성자를 이용해서 세팅해야 해서 super(e) 해서 에러 메시지를 넘겨줘야 한다.
     *   1. 반영한 완성 코드 : 예외 객체를 생성할 때 new NegativeSalary("임금이 음수입니다!") 처럼 에러 메시지를 전달하고,
     *      나중에 getMessage() 로 꺼내 쓰는 방식
     *       // 1. 사용자 정의 예외 클래스 정의
     *       public class NegativeSalary extends Exception {
     *           // 문자열을 매개변수로 받는 생성자 정의
     *           public NegativeSalary(String msg) {
     *               // 부모 클래스(Exception → Throwable)의 생성자를 호출하여 에러 메시지 전달
     *               super(msg);
     *           }
     *       }
     *       // 2. 예외를 발생시키는 메서드
     *       public double getTax(int salary, double rate) throws NegativeSalary {
     *           if (salary > 0)
     *               return salary * rate;
     *           else
     *               // 생성자에 에러 메시지를 담아서 예외 객체 생성 및 던지기
     *               throw new NegativeSalary("임금이 음수입니다!");
     *       }
     *       // 3. 예외를 잡아서 처리하는 쪽 (예 : main 메서드 내부)
     *       try {
     *           getTax(-100, 0.1);
     *       }
     *       catch (NegativeSalary e) {
     *           // 부모 클래스로부터 물려받은 getMessage() 메서드로 저장된 에러 메시지를 얻어옴
     *           System.out.println(e.getMessage());   // 출력 결과 : 임금이 음수입니다!
     *       }
     *   2. 왜 super() 를 사용해야 하는가?
     *     ① 에러 메시지 저장 변수와 getMessage() 는 부모 클래스에 있다
     *        - 우리가 만든 NegativeSalary 클래스 내부에는 에러 메시지를 저장할 변수나 getMessage() 메서드를 직접 만든 적이 없다.
     *        - 이 기능들은 이미 최상위 예외 클래스인 Throwable(그리고 이를 상속받은 Exception) 내부에 만들어져 있으며,
     *          NegativeSalary 는 상속을 통해 이를 물려받는다.
     *     ② 부모의 에러 메시지 변수는 private 이라 자식이라도 직접 접근이 불가능하다
     *        - 부모 클래스(Throwable) 내부 구조를 보면, 에러 문자열을 저장하는 필드(변수)가 private 으로 선언되어 있다.
     *            // Java 내부의 Throwable 클래스 구조 (개념도)
     *            public class Throwable {
     *                private String detailMessage;   // private 필드이므로 외부(자식 포함)에서 직접 접근 불가
     *                public Throwable(String message) {   // 부모의 생성자
     *                    this.detailMessage = message;    // 자기 자신의 생성자에서는 세팅 가능
     *                }
     *                public String getMessage() {
     *                    return this.detailMessage;       // 저장된 메시지 반환
     *                }
     *            }
     *        - Java 에서 부모 클래스의 private 멤버는 자식 클래스에게 상속은 되지만, 자식 클래스에서 직접 접근하여 값을
     *          변경(detailMessage = "임금이 음수입니다!";)할 수는 없다.
     *     ③ 따라서 부모 생성자 super(...) 를 호출하여 값을 세팅해야 한다
     *        - 자식 클래스(NegativeSalary)에서 부모의 private 변수에 직접 값을 넣을 수 없으므로, 해당 변수를 초기화할 수 있는
     *          권한을 가진 "부모 클래스의 생성자" 를 대신 호출해 주어야 한다.
     *        - 자식 생성자 내부에서 부모 생성자를 호출하는 키워드가 바로 super() 다.
     *        - 결과적으로 super(msg); (필기의 super(e);)를 호출하면, 자식 생성자가 받은 "임금이 음수입니다!" 라는 문자열이
     *          부모 생성자로 전달되어 부모의 private 변수에 안전하게 저장된다. 이후 e.getMessage() 를 호출하면 그 값을 꺼낼 수 있다.
     *
     * 💡 한 파일에 두 버전을 넣으려고 toString() 을 재정의한 버전은 NegativeSalary, 메시지를 넘기는 버전은
     *    NegativeSalaryMsg 로 이름을 나눴다.
     */
    static void q3() {
        try {
            System.out.println("세금 : " + getTaxA(3000, 0.1));
            getTaxA(-100, 0.1);
        } catch (NegativeSalary e) {
            System.out.println(e);                                       // 재정의한 toString() 호출
        }

        System.out.println("방식 B 의 반환값 : " + getTaxB(-100, 0.1));

        try {
            getTaxMsg(-100, 0.1);
        } catch (NegativeSalaryMsg e) {
            System.out.println(e.getMessage());                          // 임금이 음수입니다!
        }
    }

    // 방식 A : throws 로 떠넘기기
    static double getTaxA(int salary, double rate) throws NegativeSalary {
        if (salary > 0)
            return salary * rate;
        else
            throw new NegativeSalary();
    }

    // 방식 B : 내부에서 try ~ catch 로 직접 처리
    static double getTaxB(int salary, double rate) {
        try {
            if (salary > 0)
                return salary * rate;
            else
                throw new NegativeSalary();
        } catch (NegativeSalary e) {
            System.out.println("방식 B (내부 처리) → " + e.toString());
            return 0.0;
        }
    }

    // 메시지를 생성자로 넘기는 버전
    static double getTaxMsg(int salary, double rate) throws NegativeSalaryMsg {
        if (salary > 0)
            return salary * rate;
        else
            throw new NegativeSalaryMsg("임금이 음수입니다!");
    }

    /**
     * 4. 다음 코드에서 논리적으로 잘못된 부분을 지적하시오.
     *
     *   try
     *   {
     *       ....
     *   }
     *   catch(Exception e)
     *   {
     *       ...
     *   }
     *   catch(IOException e)
     *   {
     *       ...
     *   }
     *
     * 정답
     *   잘못된 부분 : 상위(부모) 예외 클래스인 catch(Exception e) 블록이 하위(자식) 예외 클래스인 catch(IOException e)
     *                 블록보다 앞(위)에 위치하고 있다.
     *   이유
     *     - IOException 은 Exception 클래스를 상속받은 하위(자식) 클래스다.
     *     - try 블록에서 예외가 발생하면 위에서부터 순서대로 catch 블록을 검사하는데, 모든 예외의 최상위 부모 클래스인
     *       Exception 이 맨 위에 있으면 IOException 이 발생하더라도 첫 번째 catch(Exception e) 블록에서 모두 잡아 버린다.
     *     - 결과적으로 두 번째에 있는 catch(IOException e) 블록은 절대로 실행될 수 없는 코드(Unreachable code,
     *       도달 불가능한 코드)가 되며, Java 컴파일러는 이를 오류(컴파일 에러)로 처리한다.
     *         error: exception IOException has already been caught
     *
     * 상세 원리 설명
     *   ① 예외 클래스 간의 상속 관계와 다형성(Polymorphism)
     *        Exception    (부모 / 상위 클래스 - 범위가 넓음)
     *           ↑
     *        IOException  (자식 / 하위 클래스 - 범위가 좁고 구체적임)
     *      - 객체지향의 다형성 원리에 의해, 부모 타입의 참조변수(Exception e)는 자식 타입의 객체(IOException)를 가리킬 수 있다(업캐스팅).
     *      - 따라서 try 블록에서 IOException 객체가 던져졌을 때, 첫 번째 catch(Exception e) 가 이를 온전히 받아낼 수 있기
     *        때문에 아래로 내려가지 않고 첫 번째 블록이 실행된 후 try-catch 문이 종료된다.
     *   ② 다중 catch 블록의 작성 규칙
     *      - 하나의 try 블록에 여러 개의 catch 블록을 사용할 때는 반드시 구체적인 하위(자식) 예외 클래스를 위쪽에 배치하고,
     *        포괄적인 상위(부모) 예외 클래스를 아래쪽에 배치해야 한다.
     *      - 가장 최상위 클래스인 Exception 은 "위에서 미처 잡지 못한 나머지 모든 예외를 마지막으로 처리하겠다" 는 용도로
     *        맨 마지막 catch 블록에 작성해야 한다.
     *
     * 올바르게 수정한 코드 : 두 catch 블록의 순서를 바꾸어 자식 클래스인 IOException 을 먼저 검사하도록 수정한다.
     *   try
     *   {
     *       ....
     *   }
     *   catch(IOException e)   // 1. 하위(자식) 예외 클래스를 먼저 배치
     *   {
     *       ...
     *   }
     *   catch(Exception e)     // 2. 상위(부모) 예외 클래스를 나중에 배치 (나머지 모든 예외 처리)
     *   {
     *       ...
     *   }
     *
     * 💡 확인용으로 IOException 과 다른 예외(IllegalStateException)를 한 번씩 던졌다.
     */
    static void q4() {
        for (int i = 0; i < 2; i++) {
            try {
                if (i == 0) throw new IOException("디스크 읽기 실패");
                else throw new IllegalStateException();
            } catch (IOException e) {          // 1. 하위(자식) 예외 클래스를 먼저
                System.out.println("IOException 처리 : " + e.getMessage());
            } catch (Exception e) {            // 2. 상위(부모) 예외 클래스를 나중에
                System.out.println("Exception 처리 : " + e);
            }
        }
    }
}

/** 3번 : toString() 을 재정의한 사용자 정의 예외 */
class NegativeSalary extends Exception {   // (또는 extends RuntimeException)
    @Override
    public String toString() {
        return "예외 발생: 월급(salary)은 0보다 커야 합니다.";
    }
}

/** 3번 : 생성자로 메시지를 넘기는 사용자 정의 예외 (원래 이름 NegativeSalary) */
class NegativeSalaryMsg extends Exception {
    public NegativeSalaryMsg(String msg) {
        super(msg);   // 부모 클래스(Exception → Throwable)의 생성자를 호출하여 에러 메시지 전달
    }
}
