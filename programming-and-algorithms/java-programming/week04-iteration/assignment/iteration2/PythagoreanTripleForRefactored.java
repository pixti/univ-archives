/**
 * [4강 과제] 반복문2 - 2번 문제 (리팩터링 버전)
 * 📝 반복문2 과제는 for문으로 작성.
 *
 * PythagoreanTripleFor.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점
 *  - 상한 100 → 상수 MAX_C,  출력 형식 → 상수 OUTPUT_FORMAT ("%d : %d : %d")
 *  - String.format(OUTPUT_FORMAT, c, a, b) : %d 자리에 c, a, b 가 순서대로 들어간다.
 *    → 출력 형식 "c : a : b" 는 원본과 같다.
 *  - 판정 로직을 메소드로 분리 : isPythagoreanTriple(a, b, c)
 *  - b 를 a + 1 부터 시작 → (3, 4) 와 (4, 3) 중 하나만 센다 → 총 104 개 → 52 개.
 *
 * 💡 반복은 모두 for → 반복문2 과제 조건은 지켰다.
 * ⚠ 상수 위의 주석 "피타고라스 삼중항에서 a, b, c의 관계를 위한 배수 ... d는 독립 상수로 필요 시 확장 가능" 은
 *   코드에 해당하는 상수(배수, d)가 없다. AI 가 남긴 의미 없는 주석.
 * ⚠ 문제의 출력 예(총 104 개)와 개수가 다르다. 원래 답과 맞추려면 b = 1 부터.
 *
 * 내 코드 실행 예 (끝부분)
 *  95 : 57 : 76
 *  97 : 65 : 72
 *  100 : 28 : 96
 *  100 : 60 : 80
 *  총 52개
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

    /**
     * 피타고라스 삼중항 여부를 판단합니다.
     * a^2 + b^2 == c^2 이면 true를 반환합니다.
     * 입력이 양의 정수라고 가정합니다.
     */
    private static boolean isPythagoreanTriple(int a, int b, int c) {
        return a * a + b * b == c * c;
    }
}
