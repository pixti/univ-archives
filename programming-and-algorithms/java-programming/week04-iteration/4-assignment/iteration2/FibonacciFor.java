/**
 * [4강 과제] 반복문2 - 3번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
