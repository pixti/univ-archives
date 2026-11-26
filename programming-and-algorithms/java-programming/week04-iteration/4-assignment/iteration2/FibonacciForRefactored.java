/**
 * [4강 과제] 반복문2 - 3번 문제 (리팩터링 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class FibonacciForRefactored {

    // 출력 종료 임계값: prev가 이 값을 넘으면 루프 종료
    private static final long MAX_TERMINAL = 5000L;
    // 출력 포맷 상수
    private static final String OUTPUT_FORMAT = "%d ";

    public static void main(String[] args) {
        printSequenceUpToMax();
    }

    // 피보나치 계열의 수열을 출력합니다.
    private static void printSequenceUpToMax() {
        long prev = 0;
        long curr = 1;

        // prev가 MAX_TERMINAL 미만인 동안 반복
        while (prev < MAX_TERMINAL) {           // ⚠ 반복문2 조건 위반 (for 로 작성해야 함)
            System.out.print(String.format(OUTPUT_FORMAT, prev));
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        // 마지막 출력 뒤 줄바꿈 추가
        System.out.println();
    }
}
