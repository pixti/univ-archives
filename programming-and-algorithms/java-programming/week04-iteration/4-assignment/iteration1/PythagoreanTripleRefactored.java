/**
 * [4강 과제] 반복문1 - 2번 문제 (리팩터링 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class PythagoreanTripleRefactored {

    // 탐색에 사용할 상수: 피타고라스 관계를 만족하는 세 변수 중 두 다리는 a, b고, 빗변은 c로 표현합니다.
    private static final int MAX_C = 100;
    private static final int PERYIM = 3; // 3의 배수 검증에 사용되는 기본 증가량   ← ⚠ 사용되지 않음

    public static void main(String[] args) {
        int count = 0;

        // c는 빗변으로 가정하며, 1부터 MAX_C까지 확인
        for (int c = 1; c <= MAX_C; c++) {
            // a와 b는 각각 루프를 통해 피타고라스 비교를 수행
            // a는 1부터 c-1까지, b는 a+1부터 c-1까지로 순서를 고정해 중복 탐색 제거
            for (int a = 1; a < c; a++) {
                for (int b = a + 1; b < c; b++) {
                    if (isPythagoreanTriple(a, b, c)) {
                        System.out.println("c = " + c + ", a = " + a + ", b = " + b);
                        count++;
                    }
                }
            }
        }

        System.out.println("총 " + count + "개");
    }

    /**
     * 피타고라스 삼각식 a^2 + b^2 = c^2를 만족하는지 검사합니다.
     * 주어진 입력이 양의 정수라고 가정하고, 필요 시 호출부에서 사전 조건을 확인합니다.
     */
    private static boolean isPythagoreanTriple(int a, int b, int c) {
        // (a^2 + b^2)와 (c^2)의 값을 비교
        int lhs = a * a + b * b;    // lhs : left-hand side (좌변)
        int rhs = c * c;            // rhs : right-hand side (우변)
        return lhs == rhs;
    }
}
