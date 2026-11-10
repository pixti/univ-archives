/**
 * [2-6 수식2] [실습] 비트 연산자 실습하기
 *
 * 비트 논리 연산자
 *  - 비트 AND  &  : 두 비트가 모두 1일 때만 1
 *  - 비트 OR   |  : 두 비트 중 하나라도 1이면 1
 *  - 비트 XOR  ^  : 두 비트가 같으면 0, 다르면 1
 *  - 비트 NOT  ~  : 0 -> 1, 1 -> 0 (현재 비트를 반대로)
 *
 * x = 0x00 = 0000 0000
 * y = 0xFF = 1111 1111
 *
 * 왜 (byte) 캐스팅을 하나?
 *  - byte, short 끼리 연산해도 결과는 int 로 자동 승격된다.
 *  - 그래서 byte 변수에 다시 넣으려면 (byte) 강제 형변환이 필요하다.
 *
 * 왜 Byte.toUnsignedInt() 를 쓰나?
 *  - 1111 1111 을 byte 로 출력하면 부호 있는 정수 -1 로 해석되어 출력됨.
 *  - 부호 없는 값 255 로 보고 싶으면 Byte.toUnsignedInt() 를 사용.
 *
 * 실행 결과
 *  & : 0
 *  | : 255
 *  ^ : 255
 *  ~ : 0
 */
public class BitOperation {
    public static void main(String[] args) {
        byte x = (byte) 0x00, y = (byte) 0xFF;
        byte z;

        z = (byte) (x & y);
        System.out.println("& : " + z);

        z = (byte) (x | y);
        // 부호 있는 정수 -1 로 해석하여 출력되기 때문에 toUnsignedInt 사용
        System.out.println("| : " + Byte.toUnsignedInt(z));

        z = (byte) (x ^ y);
        System.out.println("^ : " + Byte.toUnsignedInt(z));

        z = (byte) ~y;
        System.out.println("~ : " + z);
    }
}
