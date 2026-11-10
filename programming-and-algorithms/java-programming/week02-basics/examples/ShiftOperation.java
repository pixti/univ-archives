/**
 * [2-6 수식2] [실습] 시프트 연산자 실습하기
 *
 * | 연산    | 의미                                                                       |
 * |---------|----------------------------------------------------------------------------|
 * | a >> b  | a 의 각 비트를 오른쪽으로 b 비트 이동. 최상위 빈자리는 원래 최상위 비트(부호)로 채움 |
 * | a >>> b | a 의 각 비트를 오른쪽으로 b 비트 이동. 최상위 빈자리는 0 으로 채움               |
 * | a << b  | a 의 각 비트를 왼쪽으로 b 비트 이동. 최하위 빈자리는 0 으로 채움                  |
 *
 * 정리
 *  - >> 는 부호를 유지하는 산술 시프트 → 양수/음수 모두 "2^b 로 나누기" 효과
 *  - >>> 는 부호를 무시하는 논리 시프트 → 음수에 쓰면 큰 양수가 됨
 *  - << 는 "2^b 곱하기" 효과
 *
 * Integer.toBinaryString() : 정수를 2진수 문자열로 변환 (앞의 0 은 생략, 음수는 32비트 전체 표시)
 *
 * 실행 결과
 *  x >> 2 : 10000000 -> 100000
 *  y >> 2 : 11111111111111111111111110000000 -> 11111111111111111111111111100000
 *  x >>> 2 : 10000000 -> 100000
 *  y >>> 2 : 11111111111111111111111110000000 -> 111111111111111111111111100000
 *  x << 2 : 10000000 -> 1000000000
 *  y << 2 : 11111111111111111111111110000000 -> 11111111111111111111111000000000
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
