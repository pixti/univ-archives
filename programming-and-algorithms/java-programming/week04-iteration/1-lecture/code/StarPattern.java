/**
 * [4-4 반복문4] 이중 for 문 - 별 찍기 (사각형, 삼각형)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class StarPattern {
    public static void main(String[] args) {
        int r, c;

        System.out.println("=== 결과 ===");
        for (r = 0; r < 5; r++) {
            for (c = 0; c < 5; c++)
                System.out.print("*");
            System.out.println("");
        }

        System.out.println("=== 결과 ===");
        for (r = 0; r < 5; r++) {
            for (c = 0; c < (r + 1); c++)   // ⚠ 수정 : c < (r+1)) → c < (r + 1)
                System.out.print("*");
            System.out.println("");
        }
    }
}
