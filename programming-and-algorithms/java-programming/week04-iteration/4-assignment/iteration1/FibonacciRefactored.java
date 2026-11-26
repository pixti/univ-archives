/**
 * [4강 과제] 반복문1 - 3번 문제 (리팩터링 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class FibonacciRefactored {

    // 피보나치 수열의 상한을 상수로 분리해 의도를 명확히 합니다.
    private static final int MAX_TERMINATION = 5000;

    public static void main(String[] args) {
        // 피보나치 수열의 초기 두 항
        long previous = 0;
        long current = 1;

        // 피보나치 수열의 각 항을 출력하고, MAX_TERMINATION 미만일 때만 진행
        while (shouldContinue(previous, current)) {
            // 현재 항 출력: 공백으로 구분된 한 줄 출력 형식 유지
            System.out.print(previous + " ");

            // 다음 항 계산: next = previous + current
            long next = previous + current;

            // 시퀀스 업데이트: (previous, current) = (current, next)
            previous = current;
            current = next;
        }

        // 출력 종료를 위한 줄바꿈
        System.out.println();
    }

    // 루프의 다음 반복을 계속할지 결정합니다.
    private static boolean shouldContinue(long prev, long curr) {   // ⚠ curr 미사용
        return prev < MAX_TERMINATION;
    }
}
