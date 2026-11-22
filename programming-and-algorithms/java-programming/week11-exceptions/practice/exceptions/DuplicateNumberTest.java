import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * [11강 실습] 예외 처리 - 3번 문제 (중복 숫자이면 사용자 정의 예외 Duplicate_Number_Exception)
 *
 * 문제
 *  사용자로부터 정수 목록을 읽고 숫자가 중복되면 예외 (Exception 을 상속받는 Duplicate_Number_Exception 사용자 정의 예외)를
 *  발생시키도록 아래의 프로그램을 완성하시오. main 메서드에 예외 처리를 하는 코드도 추가하시오.
 *
 *    public class Main {
 *        public static void main(String[] args) {
 *            int[] numbers = readNumbersFromUser();
 *            checkDuplicates(numbers);
 *            System.out.println("No duplicate numbers!");
 *            System.out.println("Error: " + e.getMessage());
 *        }
 *
 *    실행 결과 :
 *    How many numbers do you want to input? 5
 *    Input the integers:
 *    1
 *    2
 *    3
 *    4
 *    5
 *    No duplicate numbers!
 *
 *    How many numbers do you want to input? 6
 *    Input the integers:
 *    1
 *    2
 *    3
 *    3
 *    4
 *    5
 *    Error: Duplicate number found: 3
 *
 *  💡 문제의 main 은 try-catch 를 "추가하라" 는 뜻으로 일부러 빈 형태다. 그대로는 e 가 선언되지 않아 컴파일되지 않는다.
 *
 * 📝 필기 : ★) RuntimeException 과 Exception 차이에 대해 주의할 것
 *
 * 📝 필기 : 이번 3번 문제는 1, 2번 문제에서 한 단계 더 나아가 자바 예외 처리의 꽃인 ① 사용자 정의 예외(Custom Exception) 만들기와
 *          ② Checked Exception 에서의 throws 키워드 사용법을 배우는 아주 중요한 문제다.
 *
 * 📝 필기 : 1. 문제 분석 (무엇을 구현해야 할까?) - 주어진 코드와 요구사항을 정리하면 총 4가지를 완성해야 한다.
 *   1. 사용자 정의 예외 클래스 생성 : Exception 을 상속받는 Duplicate_Number_Exception 클래스 작성
 *   2. 입력 메서드 작성 (readNumbersFromUser()) : Scanner 로 정수의 개수와 정수들을 입력받아 int[] 배열로 반환
 *   3. 중복 검사 메서드 작성 (checkDuplicates) : 배열에 중복된 숫자가 있으면 Duplicate_Number_Exception 발생
 *   4. main 메서드에 try-catch 추가 : 정상일 때는 "No duplicate numbers!", 예외 발생 시 "Error: " + e.getMessage() 출력
 *
 * 📝 필기 : 2. 핵심 개념 정리
 *   ① 사용자 정의 예외 (Custom Exception) 와 super(message)
 *      자바가 기본으로 제공하는 예외(ArithmeticException, IllegalArgumentException 등) 외에, 개발자가 프로그램 상황에 맞게
 *      직접 예외 클래스를 만들 수 있다.
 *        class Duplicate_Number_Exception extends Exception {
 *            public Duplicate_Number_Exception(String message) {
 *                super(message);   // 부모 클래스(Exception)의 생성자로 메시지 전달!
 *            }
 *        }
 *      - super(message) 를 꼭 써야 하는 이유 : 나중에 catch 블록에서 e.getMessage() 를 호출하면, 부모 클래스(Exception → Throwable)
 *        안에 저장된 메시지를 꺼낸다. 만약 super(message) 를 호출하지 않으면 메시지가 저장되지 않아 e.getMessage() 가 null 을 반환하게 된다.
 *   ② 왜 여기서는 throws 를 반드시 써야 할까? (1, 2번 문제와의 핵심 차이!)
 *      1번(ArithmeticException)과 2번(IllegalArgumentException)에서는 메서드 옆에 throws 를 안 써도 컴파일이 잘 되었다.
 *      그런데 3번에서는 checkDuplicates 메서드 선언부에 throws Duplicate_Number_Exception 을 안 쓰면 컴파일 에러가 발생한다!
 *      - Unchecked Exception (RuntimeException 상속) : 1, 2번의 예외들. 컴파일러가 예외 처리 여부를 강제하지 않으므로 throws 생략 가능.
 *      - Checked Exception (Exception 직접 상속) : 이번 문제의 Duplicate_Number_Exception! 컴파일러가 "이 예외는 반드시 처리해야 해!"
 *        라고 엄격하게 검사한다.
 *      - 따라서 checkDuplicates() 안에서 예외를 던지고(throw) 직접 잡지 않는다면, 메서드 선언부에 throws Duplicate_Number_Exception 을
 *        반드시 적어서 호출한 곳(main)으로 예외 처리를 넘겨야 한다. 그리고 호출한 main 에서는 반드시 try-catch 로 잡아 주어야 한다.
 *          (throws 를 빼면) error: unreported exception Duplicate_Number_Exception; must be caught or declared to be thrown
 *   ③ int[] 배열에서 중복 숫자 찾는 원리 (이중 for 문) - 배열의 모든 숫자 쌍을 한 번씩 비교한다.
 *      - 바깥 반복문 i : 기준 숫자 선택 (0 부터 끝까지)
 *      - 안쪽 반복문 j : i 다음 칸(i + 1)부터 끝까지 비교
 *        · 주의 : j 를 0 부터 시작하면 자기 자신(numbers[i] == numbers[i])과 비교해서 무조건 중복으로 판정되므로, 반드시 j = i + 1 부터 시작해야 한다!
 *
 * 📝 필기 : 4. 코드 실행 흐름 비교
 *   경우 ① : 5개 입력 (1, 2, 3, 4, 5) - 중복이 없을 때
 *     1. readNumbersFromUser() 가 배열 [1, 2, 3, 4, 5] 를 반환한다.
 *     2. checkDuplicates(numbers) 가 모든 쌍을 비교하지만 같은 숫자가 없어 예외 없이 정상 종료된다.
 *     3. try 블록의 다음 줄인 System.out.println("No duplicate numbers!"); 가 실행된다.
 *     4. catch 블록은 건너뛰고 프로그램이 종료된다.
 *   경우 ② : 6개 입력 (1, 2, 3, 3, 4, 5) - 중복이 있을 때
 *     1. readNumbersFromUser() 가 배열 [1, 2, 3, 3, 4, 5] 를 반환한다.
 *     2. checkDuplicates(numbers) 에서 i = 2, j = 3 일 때 numbers[2] == numbers[3] (3 == 3) 이 참이 된다.
 *     3. throw new Duplicate_Number_Exception("Duplicate number found: 3"); 실행 → 메서드가 즉시 중단되고 throws 를 통해
 *        main 의 try 블록으로 예외가 전달된다.
 *     4. System.out.println("No duplicate numbers!"); 는 실행되지 않고 건너뛴다.
 *     5. catch (Duplicate_Number_Exception e) 블록으로 이동해 Error: Duplicate number found: 3 이 출력된다.
 *
 * 📝 필기 : 💡 실수하기 쉬운 포인트 & 심화 팁
 *   1. 한 파일에 클래스 2개를 쓸 때 public 주의!
 *      Main.java 파일 하나에 Duplicate_Number_Exception 클래스를 같이 작성할 때는 class Duplicate_Number_Exception 처럼 public 을
 *      빼야 한다. (자바는 하나의 .java 파일에 파일명과 같은 public class 를 딱 1개만 허용하기 때문이다. 별도의
 *      Duplicate_Number_Exception.java 파일로 분리할 때만 public 을 붙인다)
 *   2. print vs println 디테일
 *      실행 결과를 보면 How many numbers do you want to input? 5 처럼 질문 옆에 바로 입력을 받으므로 System.out.print(...) 를,
 *      Input the integers: 다음은 줄을 바꿔 입력받으므로 System.out.println(...) 을 사용했다.
 *   3. 심화 : HashSet 을 이용한 더 빠른 중복 검사 방법
 *      만약 배열의 크기가 아주 크다면(예 : 10만 개), 이중 for 문(O(N²)) 대신 중복을 허용하지 않는 자료구조인 HashSet(O(N))을
 *      사용할 수도 있다. → 아래 checkDuplicatesHashSet() (컬렉션은 12강)
 *
 * 처음 작성한 코드의 실행 예 (한 줄에 띄어 써서 입력해도 nextInt() 는 공백으로 나눠 읽는다)
 *   How many numbers do you want to input? 5
 *   Input the integers:
 *   1 1 2 3 6
 *   Error: Duplicate number found: 1
 *
 * 💡 이클립스는 Duplicate_Number_Exception 줄에 "serialVersionUID 가 없다" 는 노란 경고를 표시한다. 예외 클래스는 Serializable 을
 *    구현하기 때문인데, 직렬화(14강)를 쓰지 않으면 무시해도 된다. (private static final long serialVersionUID = 1L; 을 넣으면 사라진다)
 * 💡 클래스 이름에 _ 를 넣는 것(Duplicate_Number_Exception)은 문법상 문제없지만, 자바 관례는 DuplicateNumberException 처럼 붙여 쓴다.
 *    문제에 주어진 이름 그대로 썼다.
 * 💡 sc.close() 를 try 안에서 하면 그 윗줄에서 예외가 났을 때 건너뛰므로, 원래는 finally 에서 닫는 것이 안전하다. (Vowel_Check.java 📝 필기 ④)
 * 💡 원래 이클립스에서 Main 클래스로 작성한 코드. 문제에 맞게 DuplicateNumberTest 로 이름을 바꿨다.
 *
 * 실행 결과 (입력 : 6, 1 2 3 3 4 5)
 *  How many numbers do you want to input? 6
 *  Input the integers:
 *  1 2 3 3 4 5
 *  Error: Duplicate number found: 3
 *  HashSet 방식 → Error: Duplicate number found: 3
 */
public class DuplicateNumberTest {
    public static void main(String[] args) {
        int[] numbers = null;
        try {
            numbers = readNumbersFromUser();
            checkDuplicates(numbers);
            System.out.println("No duplicate numbers!");
        } catch (Duplicate_Number_Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {                                   // 💡 HashSet 방식 확인용
            checkDuplicatesHashSet(numbers);
            System.out.println("HashSet 방식 → No duplicate numbers!");
        } catch (Duplicate_Number_Exception e) {
            System.out.println("HashSet 방식 → Error: " + e.getMessage());
        }
    }

    public static int[] readNumbersFromUser() {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many numbers do you want to input? ");
        int count = sc.nextInt();

        int[] numbers = new int[count];
        System.out.println("Input the integers:");
        for (int i = 0; i < count; i++) {
            numbers[i] = sc.nextInt();
        }

        sc.close();
        return numbers;
    }

    public static void checkDuplicates(int[] numbers) throws Duplicate_Number_Exception {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    throw new Duplicate_Number_Exception("Duplicate number found: " + numbers[i]);
                }
            }
        }
    }

    // 심화 : HashSet 을 이용한 중복 검사
    public static void checkDuplicatesHashSet(int[] numbers) throws Duplicate_Number_Exception {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : numbers) {
            if (uniqueNumbers.contains(num)) {
                throw new Duplicate_Number_Exception("Duplicate number found: " + num);
            }
            uniqueNumbers.add(num);
        }
    }
}

class Duplicate_Number_Exception extends Exception {
    public Duplicate_Number_Exception(String message) {
        super(message);
    }
}
