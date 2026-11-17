/**
 * [2-2] 변수와 자료형 - 변수 저장 예제
 *
 * 기본 자료형 8가지
 * | 자료형  | 값의 유형   | 크기 / 범위                                         |
 * |---------|-------------|-----------------------------------------------------|
 * | boolean | true, false | 1 byte                                              |
 * | byte    | 정수        | 1 byte (-128 ~ 127)                                 |
 * | char    | 문자        | 2 byte (유니코드 0 ~ 65535)                         |
 * | short   | 정수        | 2 byte (-32768 ~ 32767)                             |
 * | int     | 정수        | 4 byte (-2147483648 ~ 2147483647)                   |
 * | long    | 정수        | 8 byte (-9223372036854775808 ~ 9223372036854775807) |
 * | float   | 실수        | 4 byte (약 ±3.40282347E38)                          |
 * | double  | 실수        | 8 byte (약 ±1.79769313486231570E308)                |
 *
 * ⚠ 자주 틀리는 부분: 리터럴 접미사
 *  1) long val4 = 9223372036854775807;    → 컴파일 에러 (integer number too large)
 *     정수 리터럴은 기본이 int 라서 int 범위를 넘으면 안 된다. 끝에 L 을 붙인다.
 *  2) float val5 = 3.40282347E38;         → 컴파일 에러 (possible lossy conversion from double to float)
 *     소수점 리터럴은 기본이 double 이라서 float 에 넣으려면 끝에 f 를 붙인다.
 *  3) float 최대값(Float.MAX_VALUE)은 3.40282347E38 이다.
 *     이보다 큰 3.4029E38f 같은 값은 f 를 붙여도 "floating-point number too large" 에러가 난다.
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
