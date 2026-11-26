/**
 * [11-2 예외처리2] 사용자 정의 예외
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
