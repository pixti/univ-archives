/**
 * [4강 과제] 반복문1 - 3번 문제 (리팩터링 버전)
 * ※ 반복 시 while 이나 do while 문만 사용하시오.
 *
 * Fibonacci.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점
 *  - 상한 5000 → 상수 MAX_TERMINATION
 *  - 변수 이름 a, b, c → previous, current, next (역할이 이름에 드러난다)
 *  - int → long : 상한을 크게 바꿔도 오버플로가 늦게 일어나도록. (int 는 약 21 억, long 은 약 922 경)
 *  - 반복 조건을 메소드로 분리 : shouldContinue(previous, current)
 *  - next 를 반복문 안에서 선언 → 반복마다 새로 만들어지는 임시 변수임이 드러난다.
 *  - 마지막에 줄바꿈 추가.
 *
 * ⚠ shouldContinue(long prev, long curr) 의 curr 매개변수는 쓰이지 않는다. (prev 만 비교)
 *   Eclipse 의 노란 밑줄이 그 표시. 조건이 이렇게 단순하면 while (previous < MAX_TERMINATION) 이 더 읽기 쉽다.
 *
 * 실행 예
 *  0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181
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

    /**
     * 루프의 다음 반복을 계속할지 결정합니다.
     * 이 구현은 출력하는 현재 항(previous)이 MAX_TERMINATION 미만인 경우에만 true를 반환합니다.
     * 즉, 0, 1, 1, 2, 3, 5, 8, ... 이 값들이 MAX_TERMINATION 미만일 때만 출력합니다.
     */
    private static boolean shouldContinue(long prev, long curr) {   // ⚠ curr 미사용
        return prev < MAX_TERMINATION;
    }
}
