/**
 * [4강 과제] 반복문1 - 2번 문제 (리팩터링 버전)
 * ※ 반복 시 while 이나 do while 문만 사용하시오.
 *
 * PythagoreanTriple.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점
 *  - 상한 100 → 상수 MAX_C
 *  - 판정 로직을 메소드로 분리 : isPythagoreanTriple(a, b, c)  → if 문이 "읽히는" 코드가 된다.
 *  - b 를 a + 1 부터 시작 → 항상 a < b 인 조합만 검사.
 *    (3, 4) 와 (4, 3) 중 하나만 세므로 순서만 다른 중복이 사라진다.
 *    → 총 104 개 → 52 개. 출력 형식도 "c = 5, a = 3, b = 4" 로 바뀌었다.
 *  💡 a = b 인 경우(2a² = c²)는 정수해가 없으므로(√2 는 무리수) b 를 a+1 부터 시작해도 빠지는 답이 없다.
 *
 * ⚠ 과제 조건 위반 : 3 중 반복을 for 로 작성했다. (반복문1 과제는 while / do-while 만 허용)
 * ⚠ PERYIM 상수는 선언만 하고 쓰지 않는다. (Eclipse 노란 경고 : "The value of the field is not used")
 *   주석도 "3의 배수 검증에 사용되는 기본 증가량" 이라 1 번 문제(3 의 배수)에서 잘못 섞여 들어온 것으로 보인다.
 * ⚠ 문제의 출력 예(104 개, "c : a : b" 형식)와 결과가 달라졌다. 원래 답과 맞추려면 b = 1 부터.
 *
 * 내 코드 실행 예 (끝부분)
 *  c = 95, a = 57, b = 76
 *  c = 97, a = 65, b = 72
 *  c = 100, a = 28, b = 96
 *  c = 100, a = 60, b = 80
 *  총 52개
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
