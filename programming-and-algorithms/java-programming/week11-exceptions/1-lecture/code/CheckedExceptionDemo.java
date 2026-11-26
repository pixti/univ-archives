import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * [11-2 예외처리2] checked 예외
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
