/**
 * [11-2 예외처리2] [실습] 사용자 정의 예외 - throw 와 throws
 *
 * 포인트
 *  - throw 와 throws
 *      throw  : 예외를 강제로 발생시킬 경우 사용한다. 메소드 몸체 안에서 사용한다.      throw new MyException("...");
 *      throws : 예외가 발생함을 선언할 때 사용한다. 메소드 선언의 일부분으로 사용한다.  void displayMymsg() throws MyException
 *  - displayMymsg() : i 를 8 부터 1 까지 줄이면서 출력하다가 i == 3 이 되면 MyException 을 던진다.
 *    MyException 은 Exception 을 상속한 checked 예외라서 displayMymsg() 에 throws MyException 이 필요하다.
 *  - main 도 throws MyException 으로 선언했다. main 에서 잡지 않고 다시 떠넘겼으므로, 예외는 JVM 까지 전달되어 프로그램이
 *    스택 트레이스를 출력하고 비정상 종료된다. ("i= 2", "i= 1" 은 출력되지 않는다)
 *
 * ⚠ 자주 틀리는 부분 : main 에 throws 를 붙이면 컴파일은 되지만 예외를 "처리" 한 것이 아니다. JVM 이 받아서 프로그램을 멈출 뿐이다.
 *    깔끔하게 처리하려면 main 안에서 try-catch 로 잡아야 한다. (실습 Vowel_Check.java 📝 필기 ②)
 *      try { es.displayMymsg(); } catch (MyException e) { System.out.println("예외 처리 : " + e.getMessage()); }
 * 💡 이 파일은 강의 코드 그대로라서 실행하면 마지막에 예외로 종료된다(종료 코드 1). 스택 트레이스는 System.err 로 출력된다.
 * 💡 displayMymsg() 는 static 이 아니라서 main 에서 객체(es)를 만든 뒤 호출한다.
 *
 * 실행 결과
 *  i= 8
 *  i= 7
 *  i= 6
 *  i= 5
 *  i= 4
 *  i= 3
 *  Exception in thread "main" MyException: 사용자 정의 예외
 *      at UserExceptionTest.displayMymsg(UserExceptionTest.java:46)
 *      at UserExceptionTest.main(UserExceptionTest.java:39)
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
