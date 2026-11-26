import java.util.Scanner;

/**
 * [4강 퀴즈] 반복문
 * 문제 · 정답 · 필기 → README.md
 */
public class IterationQuiz {
    public static void main(String[] args) {
        System.out.println("===== 1-① =====");   q1_1();
        System.out.println("===== 1-② =====");   q1_2();
        System.out.println("===== 1-③ =====");   q1_3();
        System.out.println("===== 1-④ =====");   q1_4();
        System.out.println();
        System.out.println("===== 2 =====");
        // 원래는 new Scanner(System.in). 실행 결과를 고정하려고 입력 "10 5 2 8 -1" 을 미리 넣어 두었다.
        q2(new Scanner("10 5 2 8 -1"));
        System.out.println("===== 3-① =====");   q3_1();
        System.out.println("===== 3-② =====");   q3_2();
        System.out.println("===== 3-③ =====");   q3_3();
        System.out.println("===== 3-④ =====");   q3_4();
        System.out.println("===== 선언 위치 =====");  scope();
    }

    // 1-①  x = 10; while (x > 6) { System.out.println(x); x--; }
    static void q1_1() {
        int x = 10;
        while (x > 6) {
            System.out.println(x);
            x--;
        }
    }

    // 1-②  x = 10; do { System.out.println(x); x--; } while (x < 6);
    static void q1_2() {
        int x = 10;
        do {
            System.out.println(x);
            x--;
        } while (x < 6);
    }

    // 1-③  for (x = 0; x < 3; x++) {
    static void q1_3() {
        int x, y;
        for (x = 0; x < 3; x++) {
            for (y = 0; y <= 2; y++)
                System.out.println(x);
            System.out.println();
        }
    }

    // 1-④  x = 0;
    static void q1_4() {
        int x = 0;
        for ( ; ; ) {
            if (x > 10)
                break;
            System.out.print(x + "  ");
            x++;
        }
    }

    // 2. 다음의 코드를 for 문을 사용하여 작성하시오.
    static void q2(Scanner sc) {
        double count = 0, sum = 0;
        int n;

        for (System.out.print("값을 입력하세요 : "), n = sc.nextInt();
             n >= 0;
             System.out.print("값을 입력하세요 : "), n = sc.nextInt()) {
            sum = sum + n;
            count++;
        }
        System.out.println();       // (실행 결과 정리용 줄바꿈 - 원래 코드에는 없음)
        if (count != 0) System.out.println(" 산술평균 = " + (double) sum / count);
        sc.close();
    }

    // 3-①  Σ(j=1~5) (j + 1), 단 while 문 사용
    static void q3_1() {
        int j = 1;
        int sum = 0;

        while (j <= 5) {
            sum += j + 1;
            j++;
        }
        System.out.println(sum);
    }

    // 3-②  Σ(i=1~3) (3i + 2), 단 for 문 사용
    static void q3_2() {
        // ① Σ + for
        int sum = 0;
        for (int i = 1; i <= 3; i++) {
            sum += 3 * i + 2;
        }
        System.out.println(sum);

        // ③ Π + for
        int prod = 1;
        for (int i = 1; i <= 3; i++) {
            prod = prod * (3 * i + 2);
        }
        System.out.println(prod);
    }

    // 3-③  Π(i=1~3) Σ(j=1~5) i*j, 단 while 문 사용
    static void q3_3() {
        int i = 1;
        int prod = 1;

        while (i <= 3) {
            int j = 1;
            int sum = 0;

            while (j <= 5) {
                sum = sum + (i * j);
                j++;
            }

            prod = prod * sum;
            i++;
        }
        System.out.println(prod);
    }

    // 3-④  Σ(i=1~3) Π(j=1~5) i*j, 단 for 문 사용
    static void q3_4() {
        int sum = 0;

        for (int i = 1; i <= 3; i++) {
            int prod = 1;

            for (int j = 1; j <= 5; j++) {
                prod = prod * (i * j);
            }

            sum = sum + prod;
        }
        System.out.println(sum);
    }

    // 📝 필기 : 선언을 반복문 밖에서 vs 안에서 하는 경우
    static void scope() {
        int prod = 0;                       // 밖에서 선언 (⚠ 위 설명 때문에 0 으로 초기화)
        for (int i = 1; i <= 2; i++) {
            prod = 1;                       // 안에서 초기화 : i 마다 곱셈을 새로 시작
            for (int j = 1; j <= 5; j++) {
                prod *= i * j;
            }
        }
        System.out.println(prod);           // 반복문이 끝나고도 사용 가능
    }
}
