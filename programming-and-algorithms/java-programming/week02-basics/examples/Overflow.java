/**
 * [2-5 수식1] 오버플로우와 언더플로우 - 예제
 *
 * - 자료형마다 저장할 수 있는 값의 범위가 한정되어 있다.
 * - 범위보다 크면 오버플로우, 작으면 언더플로우 → 엉뚱한 결과가 나온다. (에러가 나지 않으니 주의!)
 * - 각 기본 자료형의 대응 클래스(래퍼 클래스)는 최대값(MAX_VALUE)과 최소값(MIN_VALUE)을
 *   정적(static) 필드로 제공한다.
 *
 *   boolean - Boolean   | byte  - Byte    | char  - Character | short  - Short
 *   int     - Integer   | long  - Long    | float - Float     | double - Double
 *
 * 실행 결과
 *  x = 2147483647
 *  y = -2147483648
 *  w = -2147483648   ← 최대값 + 1 이 최소값으로 넘어감 (오버플로우)
 *  z = 2147483647    ← 최소값 - 1 이 최대값으로 넘어감 (언더플로우)
 */
public class Overflow {
    public static void main(String[] args) {
        int x = Integer.MAX_VALUE; // int 형의 최대값
        int y = Integer.MIN_VALUE; // int 형의 최소값
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        int w = x + 1;
        int z = y - 1;
        System.out.println("w = " + w);
        System.out.println("z = " + z);
    }
}
