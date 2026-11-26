/**
 * [3강 퀴즈] 조건문 연습문제 (1 ~ 5번)
 * 문제 · 정답 · 필기 → README.md
 */
public class ConditionalQuiz {
    public static void main(String[] args) {
        q1();
        q2();
        q3();
        q4();
        q5();
    }

    // 1. 다음의 작업을 수행하는 문장을 작성하라.
    static void q1() {
        // ①
        int age = 30;
        int count = 0;
        if (age >= 20 && age <= 65) {
            count++;
        }
        System.out.println("[Q1-①] age=" + age + " → count=" + count);

        // ②
        int x = 3, y = 7;
        int max, min;
        if (x > y) {
            max = x;
            min = y;
        }
        else {                  // else if (y < x) 로 쓰면 이 블록은 절대 실행되지 않는다
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

    // 2. 아래와 같이 변수들이 선언되어 있는 경우, 다음은 참으로 계산되는가 아니면 거짓으로 계산되는가?
    static void q2() {
        int x = 3, y = 5, z = 2;
        System.out.println("[Q2-①] x == z+1 → " + (x == z + 1));
    }

    // 3. 다음 문장의 오류를 찾아서 수정하라. 오류가 없을 수도 있고 2개 이상의 오류가 있을 수도 있다.
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

    // 4. 다음 코드를 같은 결과가 나오도록 switch 문으로 작성하시오.
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

    // 5. x = 0, y = 1, z = 2 인 상태에서 다음과 같은 코드가 실행되었을 경우, x, y, z 의 최종값은?
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
