/**
 * [11강 실습] 예외 처리 - 4번 문제 (모음이 없으면 사용자 정의 예외 NoVowelsException)
 *
 * 문제
 *  문자열을 입력으로 사용하고 문자열에 모음이 포함되어 있지 않으면 예외 (Exception 을 상속받은 NoVowelsException 사용자 정의 예외)를
 *  발생시키는 checkVowels 메서드를 작성하고, 이에 맞추어 main 메서드에 예외 처리를 하는 코드도 추가하시오.
 *
 *    public class Vowel_Check {
 *        public static void main(String[] args) {
 *            String text = "Java handling and managing exceptions ";
 *            // String text = "Typy gyps fly.";
 *            System.out.println("Original string: " + text);
 *            checkVowels(text);
 *            System.out.println("String contains vowels.");
 *        }
 *
 *    실행 결과 :
 *    Original string: Java handling and managing exceptions
 *    String contains vowels.
 *
 *    Original string: Typy gyps fly.
 *    Error: String does not contain any vowels
 *
 * 📝 필기 : 1. 문제 분석 - 주어진 코드와 요구사항을 살펴보면 3번 문제와 구조가 거의 같다.
 *   1. 사용자 정의 예외 작성 : Exception 을 상속받는 NoVowelsException 클래스 생성
 *   2. checkVowels(String text) 메서드 작성
 *      - 문자열에 영어 모음(a, e, i, o, u 및 대문자 A, E, I, O, U)이 하나라도 없으면 NoVowelsException 발생
 *      - 예외 메시지 : "String does not contain any vowels"
 *   3. main 메서드 수정 : try-catch 블록으로 예외 처리 추가
 *      - (참고) main 안에 주석 처리된 // String text = "Typy gyps fly."; 는 두 번째 실행 결과를 확인하고 싶을 때 위 줄을 주석 처리하고
 *        이 줄의 주석을 풀어서 테스트해 보라는 의미다.
 *
 * 📝 필기 : 2. 핵심 개념 정리
 *   ① 사용자 정의 예외와 throws (3번 문제 복습)
 *      - NoVowelsException 은 Exception 을 직접 상속받으므로 Checked Exception 이다.
 *      - 따라서 checkVowels 메서드 선언부에 반드시 throws NoVowelsException 을 붙여야 하며, 이를 호출하는 main 메서드에서는
 *        try-catch 로 잡아 주어야 한다.
 *      - super(message); 를 호출해야 e.getMessage() 가 정상적으로 메시지를 반환한다.
 *   ② 문자열에서 모음 포함 여부 검사하기 (핵심 알고리즘) - 문자열에서 모음을 찾을 때는 다음 3가지 포인트를 꼭 기억하자.
 *      1. 대소문자 모두 고려하기 : "aeiouAEIOU"
 *         만약 "APPLE" 처럼 대문자 모음만 있는 문자열이 들어와도 모음이 있다고 판정해야 하므로 대소문자 10글자를 모두 포함시킨다.
 *      2. 플래그(Flag) 변수 패턴 (boolean containsVowels = false;)
 *         - 처음에는 "아직 모음을 못 찾았다(false)" 고 가정하고 출발한다.
 *         - for 문으로 문자열의 첫 글자(0)부터 마지막 글자(text.length() - 1)까지 text.charAt(i) 로 한 글자씩 꺼내 검사한다.
 *         - 모음을 하나라도 찾으면 containsVowels = true; 로 바꾸고 break; 로 반복문을 즉시 종료한다.
 *           (이미 모음이 있다는 게 확정됐으니 뒤의 글자를 더 볼 필요가 없기 때문!)
 *      3. ⚠ 초보자가 가장 많이 하는 실수 (반복문 안에서 예외 던지기)
 *         - 만약 for 문 안에 else { throw new NoVowelsException(...); } 를 써 버리면, "Java..." 의 첫 글자 'J' 가 모음이 아니라는
 *           이유만으로 바로 예외가 터져 버린다!
 *         - 반드시 반복문이 끝난 뒤(문자열 전체를 다 확인한 뒤)에도 containsVowels 가 false 일 때(if (!containsVowels))만 예외를
 *           발생시켜야 한다.
 *   ③ 문자가 "aeiouAEIOU" 에 들어 있는지 확인하는 2가지 방법
 *      - 방법 A : vowels.contains(String.valueOf(ch))
 *        contains() 메서드는 char 타입이 아니라 문자열(String)만 받을 수 있기 때문에 String.valueOf(ch) 로 char 를 String 으로 변환해서 비교한다.
 *      - 방법 B : vowels.indexOf(ch) != -1
 *        indexOf(ch) 는 문자열에서 해당 문자 ch 의 위치(인덱스)를 알려 주고, 없으면 -1 을 반환한다. char 를 그대로 넣을 수 있어서 코드가 더 간결하다.
 *
 * 📝 필기 : 4. 실행 흐름 단계별 추적
 *   경우 ① : text = "Java handling and managing exceptions "
 *     1. Original string: Java handling and managing exceptions 출력.
 *     2. checkVowels(text) 호출 :
 *        - i = 0 : ch = 'J' → 모음 아님.
 *        - i = 1 : ch = 'a' → 모음 발견! containsVowels = true; 설정 후 break; 로 반복문 즉시 탈출.
 *        - if (!containsVowels) 는 !true(즉, false)이므로 예외를 발생시키지 않고 메서드 정상 종료.
 *     3. try 블록의 다음 줄인 String contains vowels. 출력 후 catch 를 건너뛰고 종료.
 *   경우 ② : text = "Typy gyps fly." (주석 바꿔서 실행 시)
 *     1. Original string: Typy gyps fly. 출력.
 *     2. checkVowels(text) 호출 :
 *        - 'T', 'y', 'p', 'y', ' ', 'g', ... 끝까지 모든 글자를 검사해도 "aeiouAEIOU" 에 해당하는 문자가 없음.
 *        - 반복문이 끝나도 containsVowels 는 여전히 false.
 *        - if (!containsVowels) 가 !false(즉, true)가 되어 throw new NoVowelsException("String does not contain any vowels"); 실행!
 *     3. String contains vowels. 는 건너뛰고 catch (NoVowelsException e) 블록으로 이동.
 *     4. Error: String does not contain any vowels 출력 후 정상 종료.
 *
 * 📝 필기 : 💡 체크 포인트
 *   - 마침표 주의 : 실행 결과를 자세히 보면
 *       String contains vowels.                → 끝에 마침표(.) 있음
 *       Error: String does not contain any vowels → 끝에 마침표(.) 없음
 *   - 파일명 주의 : public class Vowel_Check 이므로 파일 이름은 반드시 Vowel_Check.java 로 저장해야 하며, 같은 파일 안에 작성한
 *     NoVowelsException 앞에는 public 을 붙이지 않아야 한다!
 *
 * 📝 필기 : ① Exception vs RuntimeException 의 차이, ② 왜 이 문제에서는 Exception 을 상속받았는지, 그리고 ③ 시험과 실무에서 자주
 *          헷갈리는 보충 개념 5가지
 *   1. 자바 예외의 계층 구조 (큰 그림부터 보기) - 자바의 모든 오류와 예외는 Throwable 이라는 최상위 클래스 아래에 다음과 같은 족보를 가지고 있다.
 *        Throwable
 *        ├── Error (시스템의 치명적 오류 - 개발자가 코드로 해결 불가)
 *        │    └── OutOfMemoryError, StackOverflowError 등
 *        └── Exception (개발자가 코드로 처리 가능한 예외)
 *             ├── [Checked Exception] Exception 을 직접 상속
 *             │    └── IOException, SQLException, NoVowelsException(4번), Duplicate_Number_Exception(3번)
 *             └── RuntimeException [Unchecked Exception]
 *                  └── ArithmeticException(1번), IllegalArgumentException(2번), NullPointerException 등
 *   2. Exception 상속 vs RuntimeException 상속 차이점 - 가장 큰 차이는 "컴파일러가 예외 처리를 강제하느냐, 안 하느냐" 다.
 *        구분                 extends Exception                                extends RuntimeException
 *                             (Checked Exception / 검사 예외)                  (Unchecked Exception / 비검사 예외)
 *        검사 시점            컴파일 시점에 컴파일러가 강제 검사                실행 시점(Runtime)에 발생 (컴파일러가 관여 안 함)
 *        try-catch / throws   반드시 작성해야 함! (안 쓰면 컴파일 에러 ❌)      선택 사항 (안 써도 컴파일 성공 ⭕)
 *        주된 사용 목적       복구 가능하거나, 호출하는 쪽에서 반드시 인지하고  주로 개발자의 코딩 실수(버그)
 *                             대처해야 하는 상황 (파일 없음, 네트워크 끊김,     (0 으로 나누기, 배열 범위 초과, null 참조 등)
 *                             특정 입력 규칙 위반 등)
 *        예시 (우리 문제들)   3번(Duplicate_Number_Exception), 4번(NoVowelsException)  1번(ArithmeticException), 2번(IllegalArgumentException)
 *      💡 그럼 왜 3번 - 4번 문제에서는 Exception 을 상속받게 했을까요? 크게 2가지 이유가 있다.
 *        1. 설계적 이유 (안전장치 역할) : checkVowels(text) 를 만든 개발자 입장에서 "이 메서드는 모음이 없으면 실패할 수 있으니,
 *           이 메서드를 가져다 쓰는 사람(main)이 절대 깜빡하지 말고 반드시 try-catch 로 에러 메시지를 처리하게 강제하고 싶다!" 는
 *           의도가 담겨 있다. 만약 RuntimeException 을 상속받았다면, main 에서 try-catch 를 깜빡하고 안 써도 컴파일이 통과되어 버리고,
 *           실행 중에 프로그램이 뚝 끊기며 비정상 종료된다.
 *        2. 교육적 이유 (단계별 학습) : 1번(ArithmeticException)과 2번(IllegalArgumentException)은 모두 RuntimeException 의 자식
 *           (Unchecked)이기 때문에 throws 를 안 써도 됐다. 그래서 3번 - 4번에서는 일부러 Exception 을 직접 상속(Checked)하게 만들어
 *           throws 로 예외를 떠넘기고, main 에서 try-catch 로 받아 내는 자바의 정석 예외 처리 흐름을 연습시키려는 출제 의도다.
 *      ✨ 실무 보너스 상식 : 교과서나 자바의 원래 철학에서는 복구 가능한 예외에 extends Exception 을 권장하지만, 실제 현대 자바 실무
 *         (Spring 등)에서는 throws 를 메서드마다 계속 적어야 하는 번거로움 때문에 사용자 정의 예외를 extends RuntimeException 으로
 *         만드는 경우도 매우 많다! 두 방식의 장단점을 알고 상황에 맞게 선택하는 것이 중요하다.
 *   3. 그 외에 헷갈리기 쉬운 핵심 개념 5가지
 *      ① Error vs Exception
 *         - Error : 컴퓨터 메모리가 부족하거나(OutOfMemoryError), 재귀 호출이 무한히 반복돼 스택이 터지는(StackOverflowError) 등
 *           JVM 차원의 심각한 문제다. try-catch 로 잡아서 수습할 수 없으므로 잡지 않는 것이 원칙이다.
 *         - Exception : 잘못된 입력, 파일 부재 등 프로그램 로직으로 예측하고 수습할 수 있는 문제다.
 *      ② throw vs throws 완벽 구분 - 비슷하게 생겨서 가장 많이 틀리는 키워드다.
 *           키워드   위치                  역할                                                    개수
 *           throw    메서드 내부           예외 객체를 생성해서 직접 터뜨림 (발생)                   한 번에 1개만 (throw new 예외();)
 *           throws   메서드 선언부 (헤더)  "여기서 이런 예외가 나갈 수 있으니 호출한 쪽이 처리해!"   쉼표로 여러 개 가능 (throws A, B)
 *                                          라고 경고
 *         - 주의 : main 메서드에도 public static void main(String[] args) throws NoVowelsException 처럼 쓸 수는 있지만, 이러면
 *           예외를 JVM 으로 떠넘겨 버려서 예외 발생 시 프로그램이 에러 로그(빨간 글씨)를 뱉고 강제 종료된다. 따라서 Error: ... 처럼
 *           깔끔하게 처리하려면 반드시 try-catch 를 써야 한다.
 *      ③ catch 블록을 여러 개 쓸 때의 순서 규칙 (시험 단골!)
 *         하나의 try 블록 뒤에 catch 를 여러 개 붙일 수 있는데, 반드시 자식(구체적인) 예외를 위에, 부모(포괄적인) 예외를 아래에 써야 한다.
 *           // ❌ 컴파일 에러! (잘못된 순서)
 *           try {
 *               checkVowels(text);
 *           } catch (Exception e) {              // 부모가 모든 예외를 다 잡아먹어 버림!
 *               System.out.println("일반 오류");
 *           } catch (NoVowelsException e) {      // 여기까지 절대 도달할 수 없음 (Unreachable code 에러)
 *               System.out.println("모음 없음");
 *           }
 *           // ⭕ 올바른 순서
 *           try {
 *               checkVowels(text);
 *           } catch (NoVowelsException e) {      // 자식 예외 먼저 검사
 *               System.out.println("Error: " + e.getMessage());
 *           } catch (Exception e) {              // 그 외 예상치 못한 모든 예외 처리
 *               System.out.println("기타 오류: " + e.getMessage());
 *           }
 *      ④ finally 블록 - "무조건 실행되는 마지막 정리 구역"
 *         - try-catch 뒤에 선택적으로 finally { ... } 를 붙일 수 있다.
 *         - try 가 정상 종료되든, 예외가 터져서 catch 로 가든, 심지어 중간에 return 을 만나든 finally 안의 코드는 무조건 실행된다.
 *         - 주로 자원 해제(3번 문제의 sc.close(), 파일 닫기, DB 연결 종료 등)를 할 때 사용한다.
 *         - 만약 try 안에서 sc.close() 를 썼는데 그 윗줄에서 예외가 터지면 sc.close() 가 건너뛰어지므로, 원래는 finally 블록 안에서
 *           닫아 주는 것이 가장 안전하다.
 *      ⑤ 사용자 정의 예외와 super(message) / 기본 생성자
 *           class NoVowelsException extends Exception {
 *               // 1. 메시지 없이 던지고 싶을 때를 위한 기본 생성자 (선택)
 *               public NoVowelsException() {
 *                   super();
 *               }
 *               // 2. 메시지를 담아 던지기 위한 생성자 (필수급)
 *               public NoVowelsException(String message) {
 *                   super(message);   // 부모(Exception)에게 전달해야 e.getMessage() 가 동작함!
 *               }
 *           }
 *         - 자바에서는 매개변수가 있는 생성자(NoVowelsException(String message))를 하나라도 직접 만들면, 기본 생성자
 *           (NoVowelsException())를 자동으로 만들어 주지 않는다.
 *         - 만약 throw new NoVowelsException(); 처럼 메시지 없이 쓰고 싶다면 위처럼 기본 생성자도 함께 적어 주어야 한다.
 *         - 그리고 생성자 안에서 super(message); 를 빼먹으면 e.getMessage() 호출 시 null 이 출력되므로 반드시 부모 생성자에게
 *           메시지를 넘겨주어야 한다!
 *
 * 📝 필기 : checkVowels 를 작성하는 여러 가지 방법 (아래 checkVowels1 ~ checkVowels6)
 *   방법 ① : || 연산자로 10개 직접 비교하기 (가장 직관적)
 *   방법 ② : toLowerCase() + || 5개 비교하기 (실수 방지 & 깔끔!) - 문자열 전체를 소문자로 통일한 뒤 비교
 *   방법 ③ : indexOf() 사용하기 (짧고 세련된 방식) - vowels 안에 ch 가 있으면 위치(0~9), 없으면 -1 을 반환
 *   방법 ④ : contains() 사용하기 (원문 모범 답안 스타일) - contains() 는 String 만 받으므로 char 를 String 으로 변환
 *            → 처음 작성한 코드가 이 방식이다 (아래 checkVowels)
 *   방법 ⑤ : switch 문 사용하기 (return; 활용!)
 *     ⚠ switch 문 주의 포인트! for 문 안에 switch 가 있을 때 break; 를 쓰면 for 문이 아니라 switch 만 탈출한다! 그래서 위처럼 return; 을
 *       써서 모음을 찾자마자 메서드 자체를 끝내 버리면 boolean 변수도 필요 없고 훨씬 깔끔해진다!
 *       (사실 방법 ① ~ ④ 에서도 containsVowels = true; break; 대신 그냥 return; 을 써도 똑같이 동작한다!)
 *   보너스 (방법 ⑥) : 정규표현식(Regex)으로 1줄 끝내기 - 나중에 자바에 익숙해지면 for 문조차 없이 정규표현식으로 딱 한 줄에 끝낼 수도 있다.
 *     ".*[aeiouAEIOU].*" : 문자열 어딘가에 모음이 하나라도 들어 있는지 검사 (6강 정규 표현식)
 *
 * 💡 두 실행 결과를 한 번에 확인하려고, 주석을 바꾸는 대신 두 문자열을 차례로 검사하도록 main 을 반복문으로 바꿨다.
 *    아래 "---- 방법 ① ~ ⑥ ----" 는 여섯 가지 방법이 모두 같은 결과를 내는지 확인용으로 덧붙인 것이다.
 * 💡 첫 번째 문자열은 끝에 공백이 하나 있다("exceptions "). 그래서 출력도 공백으로 끝나지만 눈에는 보이지 않는다.
 *
 * 실행 결과
 *  Original string: Java handling and managing exceptions
 *  String contains vowels.
 *
 *  Original string: Typy gyps fly.
 *  Error: String does not contain any vowels
 *
 *  ---- 방법 ① ~ ⑥ ("Typy gyps fly." / "APPLE") ----
 *  ① 예외 / 통과
 *  ② 예외 / 통과
 *  ③ 예외 / 통과
 *  ④ 예외 / 통과
 *  ⑤ 예외 / 통과
 *  ⑥ 예외 / 통과
 */
public class Vowel_Check {
    public static void main(String[] args) {
        String[] texts = {"Java handling and managing exceptions ", "Typy gyps fly."};

        for (String text : texts) {
            try {
                System.out.println("Original string: " + text);
                checkVowels(text);
                System.out.println("String contains vowels.");
            } catch (NoVowelsException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }

        System.out.println("---- 방법 ① ~ ⑥ (\"Typy gyps fly.\" / \"APPLE\") ----");   // 💡 확인용
        for (int way = 1; way <= 6; way++) {
            System.out.println(circled(way) + " " + result(way, "Typy gyps fly.") + " / " + result(way, "APPLE"));
        }
    }

    // 처음 작성한 코드 (방법 ④ : contains())
    public static void checkVowels(String text) throws NoVowelsException {
        boolean containsVowels = false;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (vowels.contains(String.valueOf(ch))) {
                containsVowels = true;
                break;
            }
        }

        if (!containsVowels) {
            throw new NoVowelsException("String does not contain any vowels");
        }
    }

    // 방법 ① : || 연산자로 10개 직접 비교하기
    public static void checkVowels1(String text) throws NoVowelsException {
        boolean containsVowels = false;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                containsVowels = true;
                break;
            }
        }

        if (!containsVowels) {
            throw new NoVowelsException("String does not contain any vowels");
        }
    }

    // 방법 ② : toLowerCase() + || 5개 비교하기
    public static void checkVowels2(String text) throws NoVowelsException {
        boolean containsVowels = false;
        String lowerText = text.toLowerCase();   // 문자열 전체를 소문자로 통일

        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                containsVowels = true;
                break;
            }
        }

        if (!containsVowels) {
            throw new NoVowelsException("String does not contain any vowels");
        }
    }

    // 방법 ③ : indexOf() 사용하기
    public static void checkVowels3(String text) throws NoVowelsException {
        boolean containsVowels = false;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // vowels 안에 ch 가 있으면 위치(0~9), 없으면 -1 을 반환
            if (vowels.indexOf(ch) != -1) {
                containsVowels = true;
                break;
            }
        }

        if (!containsVowels) {
            throw new NoVowelsException("String does not contain any vowels");
        }
    }

    // 방법 ⑤ : switch 문 사용하기 (return; 활용)
    public static void checkVowels5(String text) throws NoVowelsException {
        String lowerText = text.toLowerCase();

        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            switch (ch) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    return;   // 모음을 찾으면 메서드 자체를 즉시 종료!
            }
        }

        // 반복문이 끝날 때까지 return 이 안 됐다면 모음이 하나도 없다는 뜻!
        throw new NoVowelsException("String does not contain any vowels");
    }

    // 방법 ⑥ : 정규표현식(Regex)으로 1줄 끝내기
    public static void checkVowels6(String text) throws NoVowelsException {
        // ".*[aeiouAEIOU].*" : 문자열 어딘가에 모음이 하나라도 들어 있는지 검사
        if (!text.matches(".*[aeiouAEIOU].*")) {
            throw new NoVowelsException("String does not contain any vowels");
        }
    }

    // 💡 확인용 : way 번 방법으로 검사한 결과
    static String result(int way, String text) {
        try {
            switch (way) {
                case 1 -> checkVowels1(text);
                case 2 -> checkVowels2(text);
                case 3 -> checkVowels3(text);
                case 4 -> checkVowels(text);
                case 5 -> checkVowels5(text);
                default -> checkVowels6(text);
            }
            return "통과";
        } catch (NoVowelsException e) {
            return "예외";
        }
    }

    static String circled(int n) {
        return String.valueOf((char) ('①' + n - 1));
    }
}

class NoVowelsException extends Exception {
    public NoVowelsException(String message) {
        super(message);
    }
}
