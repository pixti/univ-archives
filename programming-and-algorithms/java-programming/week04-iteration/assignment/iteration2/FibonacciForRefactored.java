/**
 * [4강 과제] 반복문2 - 3번 문제 (리팩터링 버전)
 * 📝 반복문2 과제는 for문으로 작성.
 *
 * FibonacciFor.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점
 *  - 상한 5000 → 상수 MAX_TERMINAL (5000L : 끝의 L 은 long 리터럴)
 *  - 출력 형식 → 상수 OUTPUT_FORMAT ("%d ")
 *  - 출력 로직을 메소드로 분리 : printSequenceUpToMax()  → main 은 한 줄.
 *  - 변수 이름 a, b, c → prev, curr, next  /  int → long
 *
 * ⚠ 반복을 while 로 작성했다. (반복문2 과제는 for 문으로 작성)
 *   for 로 바꾸면 :  for ( ; prev < MAX_TERMINAL; ) { ... }
 *   또는 변수 선언까지 넣어서 :  for (long prev = 0, curr = 1; prev < MAX_TERMINAL; ) { ... }
 *   (초기식에는 "같은 타입" 변수 여러 개를 한 번에 선언할 수 있다)
 * 💡 Javadoc 의 "MAX_TERMINAL을 넘지 않는 구간" 은 정확히는 "미만". (조건이 prev < MAX_TERMINAL)
 *
 * 실행 예
 *  0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181
 */
public class FibonacciForRefactored {

    // 출력 종료 임계값: prev가 이 값을 넘으면 루프 종료
    private static final long MAX_TERMINAL = 5000L;
    // 출력 포맷 상수
    private static final String OUTPUT_FORMAT = "%d ";

    public static void main(String[] args) {
        printSequenceUpToMax();
    }

    /**
     * 피보나치 계열의 수열을 출력합니다.
     * 시작 값은 prev = 0, curr = 1인 전형적인 피보나치 순서를 따릅니다.
     * 각 항은 공백으로 구분되어 한 줄에 출력됩니다.
     * MAX_TERMINAL을 넘지 않는 구간만 출력합니다.
     */
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
