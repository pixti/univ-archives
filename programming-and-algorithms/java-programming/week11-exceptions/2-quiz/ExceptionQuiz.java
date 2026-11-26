import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * [11강 퀴즈] 예외 처리 (Throwable 계층 · throw / throws · checked / unchecked · 사용자 정의 예외 · catch 순서)
 * 문제 · 정답 · 필기 → README.md
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

    // 1. 다음 코드에서는 왜 try 블록에서 던져진 예외를 catch 블록에서 잡을 수 없는가?
    static void q1() {
        try {
            throw new Exception("하드디스크가 가득 찼습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 2. process() 라는 메서드가 FileNotFoundException 타입의 예외 또는 ArithmeticException 을 발생하고
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

    // 3. 회사에서 월급에 대한 세금을 계산하는 다음과 같은 메서드가 있다고 하자.
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

    // 4. 다음 코드에서 논리적으로 잘못된 부분을 지적하시오.
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
