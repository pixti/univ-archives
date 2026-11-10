/**
 * [4강 과제] 반복문2 - 3번 문제
 * 📝 반복문2 과제는 for문으로 작성.
 *
 * 피보나치 수열은 앞의 2 개의 원소를 합하여 다음 원소를 만드는 방식으로 만든 수열이다.
 * 피보나치 수열의 처음 두 수는 0 과 1 이다. 5000 보다 작은 피보나치 수를 생성하여 출력하는 프로그램을 작성하라.
 *
 * 두 가지로 작성해 봤다.
 *  - version1() : for ( ; a < 5000; ) → while (a < 5000) 과 똑같다.  ✔ 정답
 *  - version2() : 증감식 자리에 c = a + b 를 넣어 본 버전.           ✘ 출력이 틀림
 *
 * ⚠ version2 가 틀리는 이유 : for 의 증감식은 "본문이 끝난 뒤" 실행된다.
 *
 *     for (int c = 0; a < 5000; c = a + b) {
 *         print(a);  a = b;  b = c;     ← 여기서 쓰는 c 는 "지난번" a + b
 *     }
 *
 *   while 버전은 c = a + b → a = b → b = c 순서였는데,
 *   version2 는 a = b → b = c → (그 다음에) c = a + b 순서가 된다.
 *   b = c 를 할 때 c 가 아직 새로 계산되지 않은 옛날 값이다.
 *
 *     출력  │ 본문 후 (a, b) │ 증감식 c = a + b
 *     ──────┼────────────────┼──────────────────
 *      0    │ (1, 0)  ← c=0  │ 1
 *      1    │ (0, 1)         │ 1
 *      0    │ (1, 1)         │ 2      ← 0 이 또 나온다
 *      1    │ (1, 2)         │ 3
 *      1    │ (2, 3)         │ 5
 *      2    │ (3, 5)         │ 8      → 여기부터는 정상 수열을 따라간다
 *
 *   → 0 1 0 1 1 2 3 5 8 ...  (앞에 "0 1" 이 한 번 더 붙는다)
 *
 *   💡 고치려면 c 를 증감식이 아니라 본문 맨 앞에서 계산 (= version1).
 *      또는 증감식에 쉼표로 여러 식을 넣는 방법 : for ( ; a < 5000; c = a + b, a = b, b = c)
 *      (for 의 초기식 / 증감식에는 쉼표로 여러 식을 쓸 수 있다 - 실습 ArithmeticMeanFor 참고)
 *
 * 실행 예
 *  version1 : 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181
 *  version2 : 0 1 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181
 */
public class FibonacciFor {
    public static void main(String[] args) {
        System.out.print("version1 : ");
        version1();
        System.out.println();

        System.out.print("version2 : ");
        version2();
        System.out.println();
    }

    // ✔ 정답 : 조건식만 쓴 for → while (a < 5000) 과 같다
    static void version1() {
        int a = 0, b = 1, c;
        for (; a < 5000; ) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
    }

    // ✘ 버그 : c = a + b 가 본문 "뒤" 에 실행되어 b = c 가 옛날 c 를 사용한다
    static void version2() {
        int a = 0, b = 1;
        for (int c = 0; a < 5000; c = a + b) {
            System.out.print(a + " ");
            a = b;
            b = c;
        }
    }
}
