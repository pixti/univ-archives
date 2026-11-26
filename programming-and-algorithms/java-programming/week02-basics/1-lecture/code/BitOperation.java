/**
 * [2-6 수식2] [실습] 비트 연산자 실습하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
