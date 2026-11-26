/**
 * [4-1 반복문1] while 문 - 1 / 10 / 100 표 출력
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class WhileTable {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 5) {
            System.out.println(i + " " + i * 10 + " " + i * 100);
            i++;
        }
    }
}
