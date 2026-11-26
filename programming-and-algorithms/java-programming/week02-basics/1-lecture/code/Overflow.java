/**
 * [2-5 수식1] 오버플로우와 언더플로우 - 예제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
