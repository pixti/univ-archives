import java.util.Scanner; // import 하지 않으면 자바는 Scanner 클래스 정의가 안 되어 있어 사용 불가능

/**
 * [2강 실습] 변수와 자료형 - 1번 실습
 *
 * ──────────────────────────────────────────────────────────────
 * 📝 필기
 * ──────────────────────────────────────────────────────────────
 * 1. 자바와 파이썬의 구조적 차이 (블록과 들여쓰기)
 *  - 파이썬: aaa, bbb, (탭)ccc, (탭)ddd 처럼 들여쓰기로 명령어의 레벨(Scope)을 구분.
 *            들여쓰기가 매우 엄격하다.
 *  - 자바  : 중괄호 { } 로 명령어의 레벨을 구분.
 *            들여쓰기는 문법적으로 강제되지 않고, 오직 개발자 간의 "가독성"을 위해서만 사용.
 *
 * 2. 변수 초기화와 데이터 타입 (리터럴)
 *  - 지역 변수의 초기화: 메소드(예: main) 안에서 선언한 지역 변수(예: int x;)는
 *    자동으로 초기화되지 않는다 → 사용하기 전에 반드시 값을 할당해야 에러가 안 남.
 *    (프로그래밍응용 시간에 배웠던 "인스턴스 변수"는 예외적으로 자동 초기화됨.
 *     이건 지역 변수의 경우)
 *  - 실수형 리터럴 (float vs double)
 *    · 자바에서 소수점이 있는 숫자는 기본적으로 double 로 인식 (예: 12.3)
 *    · 그래서 float 변수에 대입할 때는 반드시 숫자 뒤에 f 를 명시 (예: float f = 12.3f;)
 *      12.3 은 double, 12.3f 가 float
 *  - 타입에 맞는 입력 메소드를 사용해야 한다. (문자열은 sc.next(), 실수는 sc.nextDouble())
 *
 * 3. 입출력(I/O)의 원리와 Scanner 클래스
 *  - 출력: System.out.println() 사용. System.out 은 PrintStream 객체이고,
 *          여기에 저장된 것을 출력하는 형태.
 *  - 입력의 2단계 구조
 *    1) 로우 레벨(Low-level) : System.in
 *       · 타입: java.io.InputStream
 *       · 사용자의 입력을 콘솔에서 가장 원초적인 형태인 1바이트(byte)씩밖에 읽어들이지 못해서
 *         직접 사용하기에는 매우 불편하다.
 *    2) 하이 레벨(High-level) : Scanner
 *       · System.in 이라는 로우 레벨 객체를 매개변수로 넘겨받아,
 *         개발자가 여러 데이터를 편하게 읽을 수 있도록 (문자열, 실수 등) 변환해 주는 클래스.
 *       · 그래서 스캐너를 생성할 때 콘솔에서 읽어들이는 로우 레벨 객체 System.in 을 넘겨줘야 한다.
 *       · Scanner 의 메소드를 호출해서 입력을 읽어도, 최종적으로는 System.in 을 사용해서
 *         로우 레벨에서 읽어들이게 되는 것.
 *  - 자원 관리 규칙
 *    · 스캐너는 프로그램 내에서 한 번만 생성(new Scanner(System.in))하여 재사용하는 것이 좋다.
 *    · 메모리와 자원 낭비를 막기 위해 다 쓴 후에는 sc.close(); 로 닫아주는 것이 좋다.
 *
 * 4. import 문의 역할
 *  - 자바 컴파일러는 기본 패키지(java.lang) 외의 외부 클래스나 유틸리티의 위치를 스스로 알지 못한다.
 *  - 이미 정의된 클래스라도 import java.util.Scanner; 처럼 명시적으로 선언해야
 *    컴파일러가 "아, 이 클래스를 가져와서 사용하는구나" 하고 해석할 수 있다.
 *
 * 실행 예 (입력: 12.5 hello)
 *  012.3
 *  ※ 원래 실습 코드는 입력받은 db, s 를 출력하지 않음. 확인용 출력은 아래에 주석으로 추가.
 */
public class Literal {
    public static void main(String[] args) {
        // int x;  ← 초기화되지 않으면 에러
        //          (프로그래밍응용 시간에 배웠던 인스턴스 변수와 달리, 이건 지역 변수의 경우)
        int x = 0;
        System.out.print(x);

        // float f = 12.3;  ← float 변수에 대입 시 숫자에 f 를 명시해야 함.
        //                    12.3 은 double 이고 12.3f 가 float
        float f = 12.3f;
        System.out.print(f);

        // Scanner sc = new Scanner();  ← System.in 을 넣지 않으면 에러
        // 1바이트씩 읽어들이는 로우 레벨(Low-level) 스트림인 System.in 을 매개변수로 받아서,
        // 개발자가 쉽게 다룰 수 있도록 변환해 주는 하이 레벨(High-level) 클래스가 바로 Scanner
        Scanner sc = new Scanner(System.in);

        // double db = sc.next();  ← sc.next() 는 String, sc.nextDouble() 이 double
        double db = sc.nextDouble();

        // Scanner sc = new Scanner(System.in);  ← 스캐너는 프로그램에서 한 번만 생성하는 것이 좋음
        //                                          (같은 이름으로 다시 선언하면 중복 선언 에러이기도 함)
        String s = sc.next();

        sc.close(); // 다 쓰고 자원 낭비를 막기 위해 스캐너를 닫는 것이 좋음

        // (추가) 입력값 확인용
        // System.out.println();
        // System.out.println("db = " + db + ", s = " + s);
    }
}
