/**
 * [11강 과제] 예외 처리 - 1번 문제 (SafeArray : 잘못된 인덱스이면 IndexException)
 *
 * 문제
 *  정수형 배열을 나타내는 SafeArray 클래스를 작성하여 보자. SafeArray 는 기존의 배열을 향상시킨 것으로 사용자가 잘못된 인덱스로
 *  요소에 접근하는 경우에 예외를 발생한다. SafeArray 클래스의 setAt() 메서드를 정의하고, 이 연산자 함수에서 매개 변수로 전달된
 *  인덱스가 잘못된 경우에 예외를 발생한다. SafeArray 객체를 main 안에서 생성하여 테스트하라. 이 때 try/catch 문을 이용하여
 *  예외를 처리하도록 하라.
 *
 *    public class Test2 {
 *        public static void main(String[] args) {
 *            // Create instances of each vehicle type
 *            SafeArray sa = new SafeArray(5);
 *            sa.setAt(1, 11);   // 배열 인덱스 1 위치에 11 저장
 *            sa.setAt(2, 12);
 *            sa.setAt(3, 13);
 *            sa.setAt(4, 14);
 *            sa.setAt(5, 15);   //예외 발생
 *        }
 *    }
 *
 *    실행 결과 :
 *    IndexException: out of index error
 *        at SafeArray.setAt(Test2.java:57)
 *        at Test2.main(Test2.java:36)
 *
 * 포인트
 *  - 사용자 정의 예외 IndexException extends Exception (Checked) → setAt 에 throws IndexException 이 필요하다.
 *  - 올바른 인덱스는 0 ~ arr.length - 1. 그래서 index < 0 || index >= arr.length 이면 예외를 던진다.
 *    크기가 5 인 배열에서 setAt(5, 15) 는 인덱스 5 라 예외가 난다.
 *  - 예외를 던지는 줄(throw) 다음의 arr[index] = value; 는 실행되지 않는다.
 *  - main 에서는 try/catch 로 잡고 e.printStackTrace() 로 예외 종류, 메시지, 발생 위치(줄 번호)를 출력한다.
 *
 * 💡 자바의 기본 배열도 범위를 벗어나면 ArrayIndexOutOfBoundsException 을 던진다. SafeArray 는 그 검사를 직접 해서
 *    우리가 정한 예외와 메시지를 쓰는 것이다. (C++ 의 배열은 범위를 검사하지 않아서 이런 "안전한 배열" 클래스를 만든다)
 * 💡 문제 문장의 "연산자 함수" 는 C++ 의 operator[] 를 떠올린 표현이다. 자바에서는 setAt 메서드다.
 * 💡 문제 main 의 "// Create instances of each vehicle type" 주석은 다른 문제에서 남은 것이라 이 문제와는 관계없다.
 * 💡 printStackTrace() 는 System.err 로 출력해서 이클립스 콘솔에서는 빨간 글씨로 보인다. 줄 번호(Test2.java:16 등)는 파일 구성에
 *    따라 달라진다. (문제의 결과는 57, 36 / 처음 작성한 코드는 16, 31)
 * 💡 이클립스는 IndexException 줄에 serialVersionUID 노란 경고를 표시한다. 무시해도 된다.
 * 💡 원래 이클립스에서 Test2 클래스로 작성한 코드. 같은 폴더의 다른 문제도 Test2 라서 SafeArrayTest 로 이름을 바꿨다.
 *
 * 실행 결과 (줄 번호는 이 파일 기준)
 *  (java 파일이름.java 로 실행하면 맨 아래에 SourceLauncher 줄이 몇 줄 더 붙는다)
 *  IndexException: out of index error
 *      at SafeArray.setAt(SafeArrayTest.java:80)
 *      at SafeArrayTest.main(SafeArrayTest.java:58)
 */
public class SafeArrayTest {
    public static void main(String[] args) {
        SafeArray sa = new SafeArray(5);

        try {
            sa.setAt(1, 11);   // 배열 인덱스 1 위치에 11 저장
            sa.setAt(2, 12);
            sa.setAt(3, 13);
            sa.setAt(4, 14);
            sa.setAt(5, 15);   // 인덱스 범위(0~4) 초과로 예외 발생
        } catch (IndexException e) {
            e.printStackTrace();
        }
    }
}

class IndexException extends Exception {
    public IndexException(String message) {
        super(message);
    }
}

class SafeArray {
    private int[] arr;

    public SafeArray(int size) {
        arr = new int[size];
    }

    public void setAt(int index, int value) throws IndexException {
        if (index < 0 || index >= arr.length) {
            throw new IndexException("out of index error");
        }
        arr[index] = value;
    }
}
