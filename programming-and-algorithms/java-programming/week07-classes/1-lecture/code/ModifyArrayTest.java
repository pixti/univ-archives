/**
 * [7-4] 배열 인수 - 메소드에서 배열을 인수로 받아들이는 예
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ModifyArrayTest {
    public static void main(String[] args) {
        int[] t = new int[] {1, 2, 3};
        ModifyArray(t);
        for (int j = 0; j < t.length; j++) System.out.print(t[j] + " ");
        System.out.println();
    }

    static void ModifyArray(int[] b) {
        for (int j = 0; j < b.length; j++) b[j] *= 2;
    }
}
