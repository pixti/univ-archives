/**
 * [11-2 예외처리2] [실습] 사용자 정의 예외 - throw 와 throws
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
class MyException extends Exception {
    public MyException(String mymsg) {
        super(mymsg);
    }
}

public class UserExceptionTest {
    public static void main(String[] args) throws MyException {
        UserExceptionTest es = new UserExceptionTest();
        es.displayMymsg();
    }

    public void displayMymsg() throws MyException {
        for (int i = 8; i > 0; i--) {
            System.out.println("i= " + i);
            if (i == 3)
                throw new MyException("사용자 정의 예외");
        }
    }
}
