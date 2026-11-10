/**
 * [3강 퀴즈] 조건문 연습문제 (1 ~ 5번)
 *
 * 각 문제는 메소드 하나로 정리했다. (q1 ~ q5)
 *  - "내 답안" : 퀴즈 때 제출한 답
 *  - 📝 필기  : 채점 후 정리한 내용
 *  - ⚠        : 내 답안에서 틀렸거나 고쳐야 할 부분
 *
 * 실행 결과
 *  [Q1-①] age=30 → count=1
 *  [Q1-②] x=3, y=7 → max=7, min=3
 *  [Q1-③] x=15 → y=15
 *  [Q2-①] x == z+1 → true
 *  [Q3-①] age=15 → 청소년
 *  [Q3-②] grade=3.0 → B
 *  [Q4] n=0 → 제로
 *  [Q5] x=1, y=2, z=3
 */
public class ConditionalQuiz {
    public static void main(String[] args) {
        q1();
        q2();
        q3();
        q4();
        q5();
    }

    /**
     * 1. 다음의 작업을 수행하는 문장을 작성하라.
     *
     *  ① age 가 20 이상이고 65 이하이면 count 를 증가한다.
     *     내 답안: if (age >= 20 && age <= 65) { count++; }   → 정답
     *
     *     📝 필기
     *      자바에서는 if (20 <= age <= 65) {} 같은 문장이 허용되지 않음.
     *      반드시 and(&&) 또는 or(||) 같은 걸로 쪼개야 함.
     *      → 20 <= age 가 먼저 계산되어 boolean 이 되고, boolean <= 65 비교가 되어 컴파일 에러.
     *        (파이썬은 20 <= age <= 65 같은 연쇄 비교를 허용하지만 자바는 아니다)
     *
     *  ② x 와 y 중에서 큰 값을 max 에 저장하고 작은 값을 min 에 저장한다.
     *     내 답안:
     *       if (x > y) { max = x; min = y; }
     *       else if (y < x) { max = y; min = x; }
     *
     *     ⚠ y < x 는 x > y 와 "같은 조건" 이다.
     *       첫 if 가 거짓이면 else if 도 항상 거짓 → 두 번째 블록은 절대 실행되지 않는다.
     *       그래서 y 가 더 클 때 max, min 이 0 그대로 남는다.
     *       → 나머지 경우는 그냥 else 로 처리하면 된다. (x == y 인 경우도 함께 처리됨)
     *
     *  ③ x 가 1부터 20 사이에 있으면 x 의 값을 y 에 대입한다.
     *     만약 x 가 그 범위에 있지 않으면 y 의 값은 변경되지 않는다.
     *     내 답안: if (1 <= x && x <= 20) { y = x; }   → 정답
     *     (범위 밖이면 아무것도 하지 않으면 되므로 else 가 필요 없다)
     */
    static void q1() {
        // ①
        int age = 30;
        int count = 0;
        if (age >= 20 && age <= 65) {
            count++;
        }
        System.out.println("[Q1-①] age=" + age + " → count=" + count);

        // ② (수정한 답)
        int x = 3, y = 7;
        int max, min;
        if (x > y) {
            max = x;
            min = y;
        }
        else {                  // ⚠ 내 답안의 else if (y < x) 대신 else
            max = y;
            min = x;
        }
        System.out.println("[Q1-②] x=" + x + ", y=" + y + " → max=" + max + ", min=" + min);

        // ③
        x = 15;
        y = 0;
        if (1 <= x && x <= 20) {
            y = x;
        }
        System.out.println("[Q1-③] x=" + x + " → y=" + y);
    }

    /**
     * 2. 아래와 같이 변수들이 선언되어 있는 경우, 다음은 참으로 계산되는가 아니면 거짓으로 계산되는가?
     *    int x = 3, y = 5, z = 2;
     *
     *    | 번호 | 조건            | 내 답안 | 정답       |
     *    |------|-----------------|---------|------------|
     *    | ①    | if (x == z+1)   | 참      | 참         |
     *    | ②    | if (z = 1)      | 참      | 문법 오류  |
     *    | ③    | if (x)          | 참      | 문법 오류  |
     *    | ④    | if (z = 3 == x) | 참      | 문법 오류  |
     *
     * 📝 필기
     *  - 파이썬에서는 참이지만 자바에서는 boolean 이지 않으면 문법 오류임.
     *  - ① 3 == 2 + 1 → true. 산술 연산자(+)가 관계 연산자(==)보다 먼저 계산된다.
     *  - ② 2번 문법 오류. z = 1 은 "비교" 가 아니라 "대입" 이고, 대입식의 결과는 int 1 이다.
     *       (C 언어에서는 0 이 아니면 참이라 통과하지만 자바는 boolean 만 허용)
     *  - ③ 3번 문법 오류. x 는 int 라 조건식이 될 수 없다. (파이썬의 if x: 와 다름)
     *  - ④ 3 == x 가 먼저 계산됨. 3 == x 는 true 를 반환함.
     *       근데 if 에는 이어서 안 됨, 문법 오류임. 4번은 문법 오류.
     *       → == 가 = 보다 우선순위가 높아서 z = (3 == x) → z = true 가 되는데,
     *         int 변수 z 에 boolean 을 대입할 수 없으므로 컴파일 에러.
     *
     * ②~④ 는 컴파일되지 않으므로 주석으로만 남긴다.
     *   if (z = 1) { }        // error: incompatible types: int cannot be converted to boolean
     *   if (x) { }            // error: incompatible types: int cannot be converted to boolean
     *   if (z = 3 == x) { }   // error: incompatible types: boolean cannot be converted to int
     */
    static void q2() {
        int x = 3, y = 5, z = 2;
        System.out.println("[Q2-①] x == z+1 → " + (x == z + 1));
    }

    /**
     * 3. 다음 문장의 오류를 찾아서 수정하라. 오류가 없을 수도 있고 2개 이상의 오류가 있을 수도 있다.
     *    문법적인 오류뿐만 아니라 논리적인 오류도 지적하라.
     *
     *  ① if (0 < age < 18)   // 청소년 정의를 참고
     *         System.out.println("청소년");
     *
     *     내 답안
     *      1. if () {} 중괄호가 빠져 있다.
     *      2. if (0 < age || age < 18) 처럼 작성해야 한다.
     *      3. int age; 를 선언해야 한다.
     *
     *     📝 필기 (정답)
     *      - 문법적인 오류 : (0 < age && age <= 18)
     *          0 < age < 18 은 1번 문제처럼 boolean < int 비교라 컴파일 에러 → && 로 쪼갠다.
     *      - 논리적인 오류 : (9 <= age && age <= 24)
     *          "청소년 정의를 참고" → 청소년기본법상 청소년은 9세 이상 24세 이하.
     *
     *     ⚠ 내 답안 다시 보기
     *      - 1번: 실행문이 하나면 중괄호는 생략 가능하므로 오류가 아니다.
     *      - 2번: || (OR) 로 쓰면 모든 나이가 참이 된다.
     *             (0 보다 크거나 18 보다 작은 수 = 모든 수) → 반드시 && (AND)
     *
     *  ② float grade = 3.0;
     *     if (grade >= 2.0)
     *         System.out.println("C");
     *     else if (grade >= 3.0)
     *         System.out.println("B");
     *
     *     📝 필기
     *      - 문법적인 오류 : float 선언 시 3.0 이 아닌 3.0f 로 해야 한다.
     *          (소수점 리터럴은 기본이 double 이라 float 에 그냥 넣으면 컴파일 에러)
     *      - 논리적인 오류 : 2.0 보다 크면 C, 3.0 이상이면 B. 맞는 것으로 보이지만
     *          3.0 인 경우도 C 를 출력하게 되는 논리 오류가 있음.
     *          → 첫 조건(>= 2.0)에서 이미 걸러지므로 else if (>= 3.0) 은 절대 실행되지 않는다.
     *          → 큰 값부터 검사하도록 순서를 바꾼다.
     */
    static void q3() {
        // ① 수정
        int age = 15;
        if (9 <= age && age <= 24)
            System.out.println("[Q3-①] age=" + age + " → 청소년");

        // ② 수정 - f 붙이기 + 조건 순서 바꾸기
        float grade = 3.0f;
        if (grade >= 3.0)
            System.out.println("[Q3-②] grade=" + grade + " → B");
        else if (grade >= 2.0)
            System.out.println("[Q3-②] grade=" + grade + " → C");
    }

    /**
     * 4. 다음 코드를 같은 결과가 나오도록 switch 문으로 작성하시오.
     *    if (n == 0) System.out.println("제로");
     *    else if (n == 1) System.out.println("하나");
     *    else if (n == 2) System.out.println("둘");
     *    else System.out.println("그외");
     *
     *    내 답안 (오답)
     *      switch (n) {
     *          case 0 : System.out.println("제로"); break;
     *          case 1 : System.out.println("하나"); break;
     *          case 2 : System.out.println("둘"); break;
     *      }
     *      System.out.println("그외");     // ← switch 밖에 있어서 항상 출력된다
     *
     *    📝 필기
     *     - default : 로 else 를 표현함.
     *     - 내 답안은 n 이 0 이어도 "제로" 다음에 "그외" 가 또 출력되어 원래 코드와 결과가 다르다.
     *     - 마지막 default 뒤에는 더 실행할 case 가 없어서 break 를 생략해도 된다.
     */
    static void q4() {
        int n = 0;
        System.out.print("[Q4] n=" + n + " → ");
        switch (n) {
            case 0 : System.out.println("제로"); break;
            case 1 : System.out.println("하나"); break;
            case 2 : System.out.println("둘"); break;
            default : System.out.println("그외");
        }
    }

    /**
     * 5. x = 0, y = 1, z = 2 인 상태에서 다음과 같은 코드가 실행되었을 경우, x, y, z 의 최종값은?
     *    switch (x) {
     *        case 0 :
     *            x = 1;
     *            y = 2;
     *        case 1 :
     *            z = 3;
     *            break;
     *    }
     *
     *    내 답안: x = 1, y = 2, z = 3 이다.   → 정답
     *
     *    풀이
     *     - x 가 0 이므로 case 0 으로 점프 → x = 1, y = 2
     *     - case 0 에 break 가 없으므로 case 1 의 z = 3 까지 이어서 실행 (fall-through)
     *     - break 를 만나 switch 종료
     *    주의) case 0 에서 x = 1 로 바꿨기 때문에 case 1 로 간 것이 아니다.
     *          switch 는 처음 한 번만 식의 값을 보고 점프하고, 그 뒤로는 break 없이 아래로 흘러간 것이다.
     */
    static void q5() {
        int x = 0, y = 1, z = 2;
        switch (x) {
            case 0 :
                x = 1;
                y = 2;
            case 1 :
                z = 3;
                break;
        }
        System.out.println("[Q5] x=" + x + ", y=" + y + ", z=" + z);
    }
}
