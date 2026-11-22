import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * [11-2 예외처리2] checked 예외
 *
 * 포인트
 *  - checked 예외와 unchecked 예외가 있다.
 *  - checked 는 컴파일 시 검사하고, unchecked 는 검사하지 않는다는 차이점이 있다.
 *  - 파일 입출력 코드는 checked 예외를 던진다. 처리하지 않으면 컴파일 시 다음과 같은 에러가 발생한다.
 *      import java.io.FileInputStream;
 *      public class ExceptionDemo {    // 컴파일 시 다음과 같은 에러가 발생
 *          public static void main(String[] args) {
 *              FileInputStream fis = null;
 *              fis = new FileInputStream("C:/test.txt");    // FileNotFoundException
 *              int c;
 *              while ((c = fis.read()) != -1)                // IOException
 *              {
 *                  System.out.print((char) c);
 *              }
 *              fis.close();                                  // IOException
 *          }
 *      }
 *        error: unreported exception FileNotFoundException; must be caught or declared to be thrown
 *        error: unreported exception IOException; must be caught or declared to be thrown
 *  - 위의 코드를 아래 main 처럼 try-catch 로 처리한다.
 *
 * 💡 FileInputStream : 파일을 1 바이트씩 읽는 클래스 (13강 파일 입출력). read() 는 읽은 바이트를 int 로 돌려주고,
 *    파일 끝이면 -1 을 돌려준다. 그래서 while ((c = fis.read()) != -1) 로 끝까지 읽는다.
 * ⚠ 자주 틀리는 부분 : FileNotFoundException 은 IOException 의 자식 클래스다. 그래서 catch 순서를 바꿔
 *    catch (IOException e) 를 먼저 쓰면 FileNotFoundException catch 에 도달할 수 없어 컴파일 오류가 난다.
 *      error: exception FileNotFoundException has already been caught
 * 💡 C:/test.txt 가 없으면 "The specified file is not present at the given path" 가 출력된다. 파일을 만들어 두면 내용이 출력된다.
 *    (윈도우에서도 경로 구분자로 / 를 쓸 수 있다. \ 를 쓰려면 "C:\\test.txt" 처럼 두 번 써야 한다)
 * 💡 강의 코드는 fis.close() 를 try 안에 두었다. 읽다가 예외가 나면 close() 가 건너뛰어지므로, 원래는 finally 에서 닫거나
 *    Java 7 의 try-with-resources 를 쓰는 것이 안전하다.
 *      try (FileInputStream fis2 = new FileInputStream("C:/test.txt")) { ... }   // 블록이 끝나면 자동으로 close()
 * 💡 강의 코드의 public class 이름은 ExceptionDemo. 같은 폴더의 다른 예제와 겹치지 않도록 CheckedExceptionDemo 로 바꿨다.
 *
 * 실행 결과 (C:/test.txt 가 없을 때)
 *  The specified file is not present at the given path
 */
public class CheckedExceptionDemo {
    public static void main(String[] args) {
        try {
            FileInputStream fis = null;
            fis = new FileInputStream("C:/test.txt");
            int c;
            while ((c = fis.read()) != -1)
                System.out.print((char) c);

            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("The specified file is not present at the given path");
        } catch (IOException e) {
            System.out.println("I/O error occurred: " + e);
        }
    }
}
