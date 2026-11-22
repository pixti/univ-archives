/**
 * [11강 실습] 예외 처리 - 2번 문제 (홀수이면 IllegalArgumentException)
 *
 * 문제
 *  정수를 매개변수로 취하고 숫자가 홀수인 경우 예외(IllegalArgumentException)를 발생시키는 trynumber() 메소드를 작성하시오.
 *
 *    public class Exception_OddNumber {
 *        public static void main(String[] args) {
 *            int n = 18;
 *            trynumber(n);
 *            n = 7;
 *            trynumber(n);
 *        }
 *    }
 *
 *    실행 결과 :
 *    18 is even.
 *    Error: 7 is odd.
 *
 * 📝 필기 : 이번 2번 문제는 1번 문제에서 배운 예외 처리 개념을 한 단계 응용하여, IllegalArgumentException 을 사용하고
 *          메서드 내부에서 예외를 발생시키고 처리하는 흐름을 익히는 문제다.
 *
 * 📝 필기 : 1. 문제 분석 (1번 문제와 달라진 점)
 *   - 1번 문제와의 차이점 : main 메서드 안에 try-catch 가 없고, 단순히 trynumber(n) 만 호출하고 있다.
 *   - 따라서 main 을 수정하지 않고 주어진 실행 결과를 만들려면, trynumber(int n) 메서드 안에서 예외를 발생(throw)시키고
 *     try-catch 로 직접 잡아서 처리까지 해야 한다.
 *   - 출력 규칙 : 짝수(18)일 때 : 18 is even. 출력
 *                 홀수(7)일 때 : IllegalArgumentException 발생 → catch 에서 잡아서 Error: 7 is odd. 출력
 *
 * 📝 필기 : 2. 핵심 개념 정리
 *   ① IllegalArgumentException 이란?
 *      - 이름 그대로 메서드에 부적절하거나(Illegal) 잘못된 인자(Argument)가 전달되었을 때 발생시키는 자바 표준 예외 클래스다.
 *      - 1번 문제의 ArithmeticException 은 "수학 계산 오류(0 으로 나누기)" 일 때 썼다면, 이번 문제는 "짝수가 와야 하는데 홀수라는
 *        잘못된 값이 들어왔다" 는 논리적 오류를 표현하기 위해 IllegalArgumentException 을 사용한다.
 *      - RuntimeException 의 자식 클래스(Unchecked Exception)이므로, 메서드 선언부에 throws 를 따로 적지 않아도 된다.
 *   ② 홀수 판별 팁 : n % 2 != 0 vs n % 2 == 1
 *      - 나머지 연산자(%)를 이용해 2 로 나눈 나머지로 홀수 / 짝수를 판별한다.
 *      - 이때 n % 2 == 1 보다 n % 2 != 0 을 사용하는 것이 훨씬 안전하다.
 *        · 이유 : 자바에서 음수 홀수(예 : -7)를 2 로 나누면 나머지가 1 이 아니라 -1 이 나온다. n % 2 != 0 으로 작성하면
 *          양수 홀수와 음수 홀수를 모두 정확하게 잡아낼 수 있다.
 *   ③ try 블록 안에서의 흐름 제어 (else 가 필요 없는 이유)
 *      - if 문 안에서 throw 가 실행되는 순간, try 블록의 나머지 코드는 즉시 중단되고 catch 블록으로 점프한다.
 *      - 따라서 홀수일 때 예외를 던지면, 그 아래에 있는 System.out.println(n + " is even."); 코드는 자동으로 건너뛰게 되므로
 *        else 를 굳이 쓰지 않아도 된다.
 *
 * 📝 필기 : 3. 정답 코드 (2가지 방식) - 문제의 조건에 맞는 코드는 크게 두 가지 방식으로 작성할 수 있다.
 *   방법 1 : trynumber() 메서드 하나로 구현하기 (가장 직관적) - 문제에서 요구한 trynumber() 메서드 안에 예외 발생과 처리를 모두 넣은 형태
 *            → 아래 trynumber()
 *   방법 2 : 검사 메서드를 분리하여 구현하기 (더 좋은 설계 / 정석 스타일) - 실제 프로그래밍에서는 같은 메서드 안에서 예외를 던지고
 *            바로 자기가 받는 것보다, 예외를 발생시키는 메서드와 예외를 처리하는 메서드를 분리하는 경우가 많다.
 *              // 예외를 포착하고 결과를 출력하는 역할
 *              public static void trynumber(int n) {
 *                  try {
 *                      checkEvenNumber(n);
 *                      System.out.println(n + " is even.");
 *                  } catch (IllegalArgumentException e) {
 *                      System.out.println("Error: " + e.getMessage());
 *                  }
 *              }
 *              // 숫자가 홀수인지 검사하고 예외를 발생시키는 역할
 *              public static void checkEvenNumber(int number) {
 *                  if (number % 2 != 0) {
 *                      throw new IllegalArgumentException(number + " is odd.");
 *                  }
 *              }
 *            → 아래 trynumber2(), checkEvenNumber()
 *   두 코드 모두 실행 결과는 완전히 동일하다! 시험이나 과제에서 "반드시 trynumber() 메소드만 작성하라" 는 제약이 없다면 방법 2 가
 *   역할 분리가 깔끔하고, 메소드 하나만 추가하는 것이 목적이라면 방법 1 이 간결하고 좋다.
 *
 * 📝 필기 : 4. 실행 흐름 단계별 추적
 *   첫 번째 호출 : n = 18 → trynumber(18)
 *     1. try 블록 진입.
 *     2. 18 % 2 != 0 검사 → 나머지가 0 이므로 거짓(false).
 *     3. if 문을 지나쳐 System.out.println(18 + " is even."); 실행 → 18 is even. 출력.
 *     4. 예외가 발생하지 않았으므로 catch 블록은 실행하지 않고 종료.
 *   두 번째 호출 : n = 7 → trynumber(7)
 *     1. try 블록 진입.
 *     2. 7 % 2 != 0 검사 → 나머지가 1 이므로 참(true).
 *     3. throw new IllegalArgumentException("7 is odd."); 실행 → 예외 발생!
 *     4. 아래의 System.out.println(7 + " is even."); 은 건너뛰고 즉시 catch (IllegalArgumentException e) 블록으로 이동.
 *     5. e.getMessage() 가 "7 is odd." 를 반환하여 Error: 7 is odd. 출력 후 정상 종료.
 *
 * 📝 필기 : 💡 체크 포인트
 *   - 실행 결과의 마침표(.)와 대소문자를 놓치기 쉽다!
 *       18 is even.         (끝에 마침표)
 *       Error: 7 is odd.    (Error: 뒤에 공백, 끝에 마침표)
 *   - 1번 문제에서 확인했듯이, e 만 출력하면 Error: java.lang.IllegalArgumentException: 7 is odd. 가 나오므로 반드시 e.getMessage() 를 사용해야 한다.
 *
 * 💡 방법 2 도 확인하려고 main 에 "---- 방법 2 ----" 를 덧붙이고, n % 2 == 1 로 쓰면 음수 홀수(-7)를 놓치는 것도 확인했다.
 *
 * 실행 결과
 *  18 is even.
 *  Error: 7 is odd.
 *  ---- 방법 2 ----
 *  18 is even.
 *  Error: 7 is odd.
 *  ---- 음수 홀수 ----
 *  -7 % 2 = -1 → n % 2 == 1 이면 false, n % 2 != 0 이면 true
 */
public class Exception_OddNumber {
    public static void main(String[] args) {
        int n = 18;
        trynumber(n);
        n = 7;
        trynumber(n);

        System.out.println("---- 방법 2 ----");      // 💡 확인용
        trynumber2(18);
        trynumber2(7);

        System.out.println("---- 음수 홀수 ----");
        int m = -7;
        System.out.println(m + " % 2 = " + (m % 2) + " → n % 2 == 1 이면 " + (m % 2 == 1) + ", n % 2 != 0 이면 " + (m % 2 != 0));
    }

    // 방법 1 : trynumber() 메서드 하나로 구현
    public static void trynumber(int n) {
        try {
            if (n % 2 != 0) {
                throw new IllegalArgumentException(n + " is odd.");
            }
            System.out.println(n + " is even.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 방법 2 : 예외를 포착하고 결과를 출력하는 역할 (문제에서는 이름이 trynumber)
    public static void trynumber2(int n) {
        try {
            checkEvenNumber(n);
            System.out.println(n + " is even.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 방법 2 : 숫자가 홀수인지 검사하고 예외를 발생시키는 역할
    public static void checkEvenNumber(int number) {
        if (number % 2 != 0) {
            throw new IllegalArgumentException(number + " is odd.");
        }
    }
}
