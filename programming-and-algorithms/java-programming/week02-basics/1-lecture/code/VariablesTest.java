/**
 * [2-2] 변수와 자료형 - 변수 저장 예제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class VariablesTest {
    public static void main(String[] args) {
        boolean bln = true;                       // true 또는 false 만 가능
        byte val1 = 127;                          // byte 최대값
        char ch = 'a';                            // ch = '한'; 처럼 한글도 저장 가능 (2byte 유니코드)
        short val2 = 32767;                       // short 최대값
        int val3 = 2147483647;                    // int 최대값
        long val4 = 9223372036854775807L;         // long 최대값 - L 필수!
        float val5 = 3.40282347E38f;              // float 최대값 - f 필수!
        double val6 = 1.79769313486231570E308;    // double 최대값

        System.out.println("boolean : " + bln);
        System.out.println("byte    : " + val1);
        System.out.println("char    : " + ch);
        System.out.println("short   : " + val2);
        System.out.println("int     : " + val3);
        System.out.println("long    : " + val4);
        System.out.println("float   : " + val5);
        System.out.println("double  : " + val6);

        // 변수 선언 방법
        int x, y, z;          // 같은 타입은 한 줄에 여러 개 선언 가능
        x = 1;
        y = 0;
        z = -1;
        int a = 1, b = 0;     // 선언과 동시에 초기화도 가능
        System.out.println(x + " " + y + " " + z + " " + a + " " + b);
        // 동일 변수에 대해 선언은 한 번만! (int x; 를 또 쓰면 에러)

        // 참조 자료형 String
        String s1 = new String("bmkim");   // 선언 시에 객체 생성하여 초기화
        String s2;
        s2 = new String("bmkim");          // 선언 후에 객체 생성하여 초기화
        String s3 = "bmkim";               // 편의상 기본 자료형처럼 사용 가능
        System.out.println(s1 + " " + s2 + " " + s3);
    }
}
