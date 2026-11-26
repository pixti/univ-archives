/**
 * [2-6 수식2] [실습] 시프트 연산자 실습하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ShiftOperation {
    public static void main(String[] args) {
        int x = 128, y = -128;
        System.out.println("x >> 2 : " + Integer.toBinaryString(x) + " -> "
                + Integer.toBinaryString(x >> 2));
        System.out.println("y >> 2 : " + Integer.toBinaryString(y) + " -> "
                + Integer.toBinaryString(y >> 2));
        System.out.println("x >>> 2 : " + Integer.toBinaryString(x) + " -> "
                + Integer.toBinaryString(x >>> 2));
        System.out.println("y >>> 2 : " + Integer.toBinaryString(y) + " -> "
                + Integer.toBinaryString(y >>> 2));
        System.out.println("x << 2 : " + Integer.toBinaryString(x) + " -> "
                + Integer.toBinaryString(x << 2));
        System.out.println("y << 2 : " + Integer.toBinaryString(y) + " -> "
                + Integer.toBinaryString(y << 2));

        // 10진수로도 확인 (추가)
        System.out.println(x + " >> 2 = " + (x >> 2) + ", " + y + " >> 2 = " + (y >> 2));
        System.out.println(y + " >>> 2 = " + (y >>> 2));
        System.out.println(x + " << 2 = " + (x << 2) + ", " + y + " << 2 = " + (y << 2));
    }
}
