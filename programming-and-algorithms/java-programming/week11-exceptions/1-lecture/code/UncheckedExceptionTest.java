/**
 * [11-2 예외처리2] unchecked 예외
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class UncheckedExceptionTest {
    public static void main(String args[]) {
        System.out.println("---- (1) ArithmeticException ----");
        try {
            case1();
        } catch (ArithmeticException e) {           // 💡 확인용
            System.out.println("(처리하지 않으면 프로그램 종료) " + e);
        }
        System.out.println("---- (2) ArrayIndexOutOfBoundsException ----");
        case2();
        System.out.println("---- (3) NumberFormatException ----");
        case3();
        System.out.println("---- (4) NullPointerException ----");
        case4();
    }

    static void case1() {
        int n1 = 3;
        int n2 = 0;

        int r = n1 / n2;     // 예외가 발생하지만 컴파일 오류 없이 컴파일됨
        System.out.println(r);
    }

    static void case2() {
        try {
            String arr[] = {"a", "b", "c", "d", "e"};
            System.out.println(arr[6]);   // 예외 발생
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱스 범위를 벗어나 접근했습니다");
        }
    }

    static void case3() {
        try {
            int n = Integer.parseInt("XYZ");   // 예외 발생
            System.out.println(n);
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환 불가능 문자열 사용");
        }
    }

    static void case4() {
        try {
            String str = null;                 // 강의 코드 : String str; (⚠ 컴파일 오류)
            System.out.println(str.length());  // 예외 발생
        } catch (NullPointerException e) {
            System.out.println("NullPointerException..");
        }
    }
}
