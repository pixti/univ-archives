/**
 * [4강 과제] 반복문2 - 2번 문제 (리팩터링 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class PythagoreanTripleForRefactored {

    // 탐색 상한을 상수로 분리
    private static final int MAX_C = 100;
    // 피타고라스 삼중항에서 a, b, c의 관계를 위한 배수(여기서는 1,2,3의 비교를 위한 고정 값으로 사용 가능)
    // d는 독립 상수로 필요 시 확장 가능                                  ← ⚠ 해당 상수 없음
    private static final String OUTPUT_FORMAT = "%d : %d : %d";

    public static void main(String[] args) {
        int count = 0;

        // c를 빗변으로 가정하여 1..MAX_C 범위에서 피타고라스 삼중항 탐색
        for (int c = 1; c <= MAX_C; c++) {
            // a는 1..c-1
            for (int a = 1; a < c; a++) {
                // b는 a+1 .. c-1 로 설정하여 중복 탐색을 줄임
                for (int b = a + 1; b < c; b++) {
                    if (isPythagoreanTriple(a, b, c)) {
                        // 결과 출력 형식 유지
                        System.out.println(String.format(OUTPUT_FORMAT, c, a, b));
                        count++;
                    }
                }
            }
        }

        System.out.println("총 " + count + "개");
    }

    // 피타고라스 삼중항 여부를 판단합니다.
    private static boolean isPythagoreanTriple(int a, int b, int c) {
        return a * a + b * b == c * c;
    }
}
