/**
 * [2-7 수식3] [실습] 증감 연산자 실습하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class IncDecOperation {
    public static void main(String[] args) {
        int a, b, c, d;

        a = 3; b = 5; c = 6;
        d = a++ + b++ - c--;
        System.out.println("a=" + a + " b=" + b + " c=" + c + " d=" + d);

        a = 3; b = 5; c = 6;
        d = ++a + ++b - --c;
        System.out.println("a=" + a + " b=" + b + " c=" + c + " d=" + d);

        a = 3; b = 5; c = 6;
        d = ++a + b++ - --c;
        System.out.println("a=" + a + " b=" + b + " c=" + c + " d=" + d);
    }
}
