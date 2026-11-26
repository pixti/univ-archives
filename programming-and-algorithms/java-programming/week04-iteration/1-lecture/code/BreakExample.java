/**
 * [4-4 반복문4] break 문
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class BreakExample {
    public static void main(String[] args) {
        int r;
        for (r = 0; r < 10; r++) {
            if (r == 3)
                break;
            System.out.print(r + " ");
        }
        System.out.println();
        System.out.println("break 후 r = " + r);
    }
}
