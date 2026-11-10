import java.util.Scanner;

/**
 * [4강 퀴즈] 반복문
 *
 * 1. 다음 프로그램의 결과를 써라.          → q1_1() ~ q1_4()
 * 2. 다음의 코드를 for 문을 사용하여 작성하시오. → q2()
 * 3. 다음의 수학식을 계산하는 코드를 작성하라.  → q3_1() ~ q3_4()
 *      ①  Σ(j=1~5) (j + 1)              , 단 while 문 사용
 *      ②  Σ(i=1~3) (3i + 2)             , 단 for 문 사용
 *      ③  Π(i=1~3) Σ(j=1~5) i*j         , 단 while 문 사용
 *      ④  Σ(i=1~3) Π(j=1~5) i*j         , 단 for 문 사용
 *  + 📝 선언을 반복문 밖에서 vs 안에서 하는 경우 → scope()
 *
 * 채점 결과 (📝 필기)
 *   1-①  정답   1-②  오답   1-③  오답   1-④  오답
 *   2    오답   3-①  오답
 *
 * 실행 결과
 *  ===== 1-① =====
 *  10
 *  9
 *  8
 *  7
 *  ===== 1-② =====
 *  10
 *  ===== 1-③ =====
 *  0
 *  0
 *  0
 *
 *  1
 *  1
 *  1
 *
 *  2
 *  2
 *  2
 *
 *  ===== 1-④ =====
 *  0  1  2  3  4  5  6  7  8  9  10
 *  ===== 2 =====
 *  값을 입력하세요 : 값을 입력하세요 : 값을 입력하세요 : 값을 입력하세요 : 값을 입력하세요 :
 *   산술평균 = 6.25
 *  ===== 3-① =====
 *  20
 *  ===== 3-② =====
 *  24
 *  440
 *  ===== 3-③ =====
 *  20250
 *  ===== 3-④ =====
 *  33120
 *  ===== 선언 위치 =====
 *  3840
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

    /**
     * 1-①  x = 10; while (x > 6) { System.out.println(x); x--; }
     *
     * 내 답안 : 10 9 8 7
     * 📝 필기 : 답은 10 9 8 7 정답.
     *
     * 💡 x 가 10, 9, 8, 7 일 때 출력. x 가 6 이 되면 6 > 6 이 거짓이라 종료.
     *    println 이므로 실제 화면에는 한 줄에 하나씩 찍힌다.
     */
    static void q1_1() {
        int x = 10;
        while (x > 6) {
            System.out.println(x);
            x--;
        }
    }

    /**
     * 1-②  x = 10; do { System.out.println(x); x--; } while (x < 6);
     *
     * 내 답안 : 오답
     * 📝 필기 : 1번은 무조건 do 를 실행시키고, 조건을 뒤에서 체크함.
     *          그후 true 면 do 실행, false 면 빠져나옴.
     *          따라서 10 . 따라서 오답.
     *
     * 💡 x = 10 을 출력하고 x = 9 가 된 뒤에야 조건 9 < 6 을 검사 → 거짓 → 종료.
     *    조건이 처음부터 거짓이어도 do-while 은 본문을 "최소 1 번" 실행한다. (4-2 강의)
     *    같은 조건을 while 로 쓰면 (while (x < 6) ...) 아무것도 출력되지 않는다.
     */
    static void q1_2() {
        int x = 10;
        do {
            System.out.println(x);
            x--;
        } while (x < 6);
    }

    /**
     * 1-③  for (x = 0; x < 3; x++) {
     *          for (y = 0; y <= 2; y++)
     *              System.out.println(x);
     *          System.out.println();
     *      }
     *
     * 내 답안 : 오답
     * 📝 필기 : 바깥 x 는 0 → 1 → 2  안쪽 y 는 매번 0 → 1 → 2
     *          정답은 000(줄바꿈)111 (줄바꿈) 222(줄바꿈) . 따라서 오답.
     *
     * 💡 안쪽 for 에는 중괄호가 없으므로 안쪽 반복 대상은 System.out.println(x); 한 줄뿐.
     *    바깥 반복마다 x 를 3 번 출력한 뒤 빈 줄을 하나 출력한다.
     * ⚠ 필기의 "000" 은 x 가 3 번 찍힌다는 뜻으로 쓴 것. print 가 아니라 println 이므로
     *    실제 화면에는 0 이 한 줄에 하나씩 세 줄, 그다음 빈 줄이 나온다. (위의 실행 결과 참고)
     * 💡 출력하는 것은 y 가 아니라 x. y 는 횟수만 세는 역할.
     */
    static void q1_3() {
        int x, y;
        for (x = 0; x < 3; x++) {
            for (y = 0; y <= 2; y++)
                System.out.println(x);
            System.out.println();
        }
    }

    /**
     * 1-④  x = 0;
     *      for ( ; ; ) {
     *          if (x > 10) break;
     *          System.out.print(x + "  ");
     *          x++;
     *      }
     *
     * 내 답안 : 오답
     * 📝 필기 : 정답은 0 1 2 3 4 5 6 7 8 9 10 . 따라서 오답.
     *
     * 💡 for ( ; ; ) 는 조건이 비어 있어 무한 반복. 빠져나가는 길은 break 뿐.
     *    x 가 11 이 되는 순간 x > 10 이 참 → break. 그래서 10 까지 출력된다.
     *    (x >= 10 이었다면 9 까지)
     */
    static void q1_4() {
        int x = 0;
        for ( ; ; ) {
            if (x > 10)
                break;
            System.out.print(x + "  ");
            x++;
        }
    }

    /**
     * 2. 다음의 코드를 for 문을 사용하여 작성하시오.
     *
     *     double count = 0, sum = 0;
     *     int n;
     *     Scanner sc = new Scanner(System.in);
     *
     *     System.out.print("값을 입력하세요 : ");
     *     n = sc.nextInt();
     *     while (n >= 0) {
     *         sum = sum + n;
     *         count++;
     *         System.out.print("값을 입력하세요 : ");
     *         n = sc.nextInt();
     *     }
     *     if (count != 0) System.out.println(" 산술평균 = " + (double)sum/count);
     *     sc.close();
     *
     * 내 답안 : for (int i = n; i >= 0; i--)  ← 오답
     *   (처음 입력한 n 으로 별도의 카운터 i 를 만들어 반복 횟수를 정하는 구조.
     *    문제는 "음수가 들어올 때까지 n 을 계속 새로 입력받는" 구조라 의미가 다르다)
     *
     * 📝 필기
     *  - while 문과 for 문은 표현력이 같다.
     *  - for ( ; n>=0 ; ) {} 로 써야한다. 따라서 오답.
     *  - 교수님 코드 :
     *      for (System.out.print("값을 입력하세요 : "), n=sc.nextInt(); n>=0;
     *           System.out.print("값을 입력하세요 : "), n=sc.nextInt()) {}
     *  - AI 설명 정리
     *      · for (; n >= 0; ) { } 는 사실상 while (n >= 0) { } 와 같다.
     *        while (조건) { 실행문 }  →  for (; 조건; ) { 실행문 }
     *      · 교수님 방식은 원래 while 문의 구조를 for 문의 각 영역에 정확하게 대응시킨 형태.
     *
     *          while 문              for 문
     *          입력           →     초기식
     *          n >= 0         →     n >= 0       (조건식)
     *          sum 계산, count 증가 → sum 계산, count 증가 (본문)
     *          다음 입력      →     증감식
     *
     *      · for (; n >= 0; ) 도 논리적으로는 맞지만 (본문에 입력 코드를 남겨 둔다면),
     *        문제의 원래 입력 구조까지 for 문에 넣어서 작성하라는 취지라면 교수님 방식이 더 적절하다.
     *
     * 💡 초기식, 증감식 자리에는 쉼표로 여러 식을 나열할 수 있다. (print 호출 + 대입)
     *    단, 선언(int n = ...)을 식과 섞을 수는 없다. → n 을 for 밖에서 선언한 이유.
     *    (실습 반복문2-1 ArithmeticMeanFor 에서 직접 겪은 컴파일 에러)
     * 💡 count, sum 이 이미 double 이라 (double)sum 형변환은 없어도 결과가 같다.
     */
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

    /**
     * 3-①  Σ(j=1~5) (j + 1), 단 while 문 사용
     *
     * 내 답안 : (sum 선언과 누적 계산이 빠짐) ← 오답
     * 📝 필기
     *  - 답은
     *      int j = 1;
     *      int sum = 0;
     *      while (j <= 5) {
     *          sum += j + 1;
     *          j++;
     *      }
     *      System.out.println(sum);
     *  - sum 을 선언하지 않았고, 계산도 없으니 오답.
     *  - (AI) 따라서 while 문을 사용하면 j 뿐만 아니라 합계를 저장할 변수가 필요합니다.
     *  - (AI) while 문을 for 문으로 바꾸면 :
     *      int sum = 0;
     *      for (int j = 1; j <= 5; j++) { sum += j + 1; }
     *
     * 💡 2 + 3 + 4 + 5 + 6 = 20
     * 💡 sum += j + 1 은 sum = sum + (j + 1). 복합 대입 연산자는 오른쪽을 전부 계산한 뒤 더한다.
     */
    static void q3_1() {
        int j = 1;
        int sum = 0;

        while (j <= 5) {
            sum += j + 1;
            j++;
        }
        System.out.println(sum);
    }

    /**
     * 3-②  Σ(i=1~3) (3i + 2), 단 for 문 사용
     *
     * 📝 필기 (AI 설명 - 프로덕트 버전까지 함께 보면)
     *  ① 시그마(Σ) + for 문
     *      int sum = 0;
     *      for (int i = 1; i <= 3; i++) { sum = sum * 1 + (3 * i + 2); }
     *    더 간단하게 쓰면 :
     *      for (int i = 1; i <= 3; i++) { sum += 3 * i + 2; }
     *  ② 시그마(Σ) + while 문
     *      int i = 1; int sum = 0;
     *      while (i <= 3) { sum += 3 * i + 2; i++; }
     *  ③ 프로덕트(Π) + for 문
     *      int prod = 1;
     *      for (int i = 1; i <= 3; i++) { prod = prod * (3 * i + 2); }
     *  ④ 프로덕트(Π) + while 문
     *      int i = 1; int prod = 1;
     *      while (i <= 3) { prod = prod * (3 * i + 2); i++; }
     *
     * 💡 Σ 는 0 에서, Π 는 1 에서 시작. (0 에서 곱을 시작하면 결과가 항상 0)
     * ⚠ ① 첫 번째 코드의 sum * 1 은 아무 의미 없는 곱셈. sum = sum + (3*i + 2) 와 같다.
     * 💡 Σ = 5 + 8 + 11 = 24,  Π = 5 × 8 × 11 = 440
     */
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

    /**
     * 3-③  Π(i=1~3) Σ(j=1~5) i*j, 단 while 문 사용
     *
     * 📝 필기 (AI 설명)
     *  - i = 1 ~ 3 각각에 대해 j = 1 ~ 5 까지 i × j 를 더한 뒤, 그 결과들을 모두 곱하는 문제.
     *  - 전개하면 :
     *        (1×1 + 1×2 + 1×3 + 1×4 + 1×5)
     *      × (2×1 + 2×2 + 2×3 + 2×4 + 2×5)
     *      × (3×1 + 3×2 + 3×3 + 3×4 + 3×5)
     *  - for 문 버전 :
     *      int prod = 1;
     *      for (int i = 1; i <= 3; i++) {
     *          int sum = 0;
     *          for (int j = 1; j <= 5; j++) { sum = sum + (i * j); }
     *          prod = prod * sum;
     *      }
     *
     * 💡 바깥이 Π → prod = 1 (밖), 안쪽이 Σ → sum = 0 (바깥 반복마다 다시).
     * 💡 안쪽 while 의 j = 1, sum = 0 을 바깥 while 안에서 해 주는 것이 핵심.
     *    (while 은 초기식 칸이 없으므로 직접. 실습 Pyramid 의 col = 0; 과 같은 이야기)
     * 💡 15 × 30 × 45 = 20250
     */
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

    /**
     * 3-④  Σ(i=1~3) Π(j=1~5) i*j, 단 for 문 사용
     *
     * 📝 필기 (AI 설명)
     *  - i = 1 ~ 3 각각에 대해 j = 1 ~ 5 까지 i × j 를 모두 곱한 후, 그 결과를 모두 더하는 문제.
     *  - 이번 문제의 구조 : 이번에는 Σ → Π → i * j 순서.
     *        Σ
     *        └── Π
     *            └── i × j
     *    따라서 코드도 정확히 대응된다.
     *        int sum = 0;        // Σ → 합계이므로 0
     *        for (i ...) {
     *            int prod = 1;   // Π → 곱셈이므로 1
     *            for (j ...) { prod *= i * j; }
     *            sum += prod;
     *        }
     *  - while 문 버전 :
     *      int i = 1; int sum = 0;
     *      while (i <= 3) {
     *          int j = 1; int prod = 1;
     *          while (j <= 5) { prod = prod * (i * j); j++; }
     *          sum = sum + prod;
     *          i++;
     *      }
     *
     * 💡 i = 1 : 1·2·3·4·5 = 120
     *    i = 2 : 2^5 × 120 = 3840
     *    i = 3 : 3^5 × 120 = 29160    → 합계 33120
     */
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

    /**
     * 📝 필기 : 선언을 반복문 밖에서 vs 안에서 하는 경우
     *
     *  1. 선언과 초기화는 다르다.
     *      int prod;        → 선언(Declaration) : prod 라는 변수를 만들겠다. 아직 값을 넣지 않음.
     *      prod = 1;        → 초기화/값 대입 : prod 에 1 이라는 값을 넣음.
     *      int prod = 1;    → 선언 + 초기화
     *
     *  2. 선언을 밖에서 하는 경우 (교수님이 말씀하신 방식)
     *      int prod;              ← 밖에서 선언
     *      for (...) {
     *          prod = 1;          ← 안에서 초기화
     *          ...
     *      }
     *      System.out.println(prod);   // 사용 가능
     *    → 반복문이 끝나고도 변수 사용이 가능함.
     *
     *  3. 선언과 초기화를 안에서 같이 하는 경우
     *      for (...) {
     *          int prod = 1;      ← 선언 + 초기화
     *      }
     *      System.out.println(prod);   // 오류
     *    → prod 의 스코프(scope)가 for 문 내부이기 때문.
     *
     *  4. 성능 차이는? → 의미 있는 성능 차이는 없다. 차이는 주로 스코프와 사용 범위.
     *      방식                         prod 사용 범위            특징
     *      int prod; 를 밖에서 선언     반복문 밖에서도 사용 가능  스코프가 넓음
     *      int prod = 1; 을 안에서 선언 반복문 내부에서만 사용     스코프가 좁음
     *
     *  5. 그런데 prod = 1 의 위치는 별개의 문제.
     *     Σ(i=1~3) Π(j=1~5) (i×j) 에서는 prod 가 각 i 마다 새롭게 곱셈을 시작해야 한다.
     *      for (i = 1; i <= 3; i++) {
     *          prod = 1;          // 반드시 여기서 다시 1 로 초기화
     *          for (j = 1; j <= 5; j++) { prod *= i * j; }
     *          sum += prod;
     *      }
     *     → prod 의 선언 위치와 prod 의 초기화 위치는 별개의 문제.
     *
     * 💡 아래 코드는 2 번 방식. i = 1, 2 를 돌고 i = 3 에서 조건 i <= 2 가 거짓이 되어 끝나므로,
     *    반복문이 끝난 뒤 prod 에는 마지막으로 계산된 i = 2 의 곱 (2·4·6·8·10 = 3840) 이 남는다.
     * ⚠ 밖에서 선언만 하고 반복문이 한 번도 돌지 않을 수 있는 경우, 자바는 "초기화되지 않았을 수도
     *    있는 변수" 라며 println(prod) 를 컴파일 에러로 막는다. (variable prod might not have been initialized)
     *    그래서 아래에서는 int prod = 0; 처럼 선언할 때 값을 하나 넣어 두었다.
     */
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
