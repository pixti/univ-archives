/**
 * [2-7 수식3] [실습] 논리 연산자 실습하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class LogicOperation {
    public static void main(String[] args) {
        int x = 3, y = 9;

        System.out.println("논리 AND 테스트");
        System.out.println((x < y) + ", " + (x > 0) + " : " + (x < y && x > 0));
        System.out.println((x > y) + ", " + (x > 0) + " : " + (x > y && x > 0));
        System.out.println((x < y) + ", " + (x < 0) + " : " + (x < y && x < 0));
        System.out.println((x > y) + ", " + (x < 0) + " : " + (x > y && x < 0));

        System.out.println("논리 OR 테스트");
        System.out.println((x < y) + ", " + (x > 0) + " : " + (x < y || x > 0));
        System.out.println((x > y) + ", " + (x > 0) + " : " + (x > y || x > 0));
        System.out.println((x < y) + ", " + (x < 0) + " : " + (x < y || x < 0));
        System.out.println((x > y) + ", " + (x < 0) + " : " + (x > y || x < 0));

        System.out.println("논리 XOR 테스트");
        System.out.println((x < y) + ", " + (x > 0) + " : " + (x < y ^ x > 0));
        System.out.println((x > y) + ", " + (x > 0) + " : " + (x > y ^ x > 0));
        System.out.println((x < y) + ", " + (x < 0) + " : " + (x < y ^ x < 0));
        System.out.println((x > y) + ", " + (x < 0) + " : " + (x > y ^ x < 0));

        System.out.println("논리 NOT 테스트");
        System.out.println((x < y) + " : " + !(x < y));
        System.out.println((x > y) + " : " + !(x > y));
    }
}
