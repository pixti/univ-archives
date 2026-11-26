/**
 * [2강 퀴즈] 수식 연습문제 (1 ~ 5번)
 * 문제 · 정답 · 필기 → README.md
 */
public class ExpressionQuiz {
    public static void main(String[] args) {
        q1();
        q2();
        q3();
        q4();
        q5();
    }

    // 1. int x = 5, y = 3, z = 2; 일 때 각 변수에는 어떤 값이 저장되는가? (각 문항은 독립적으로 계산)
    static void q1() {
        int x, y, z;

        x = 5; y = 3; z = 2;
        x += y -= 2;
        System.out.println("[Q1-①] x=" + x + ", y=" + y + ", z=" + z); // x=6, y=1, z=2

        x = 5; y = 3; z = 2;
        x *= y + 2;
        System.out.println("[Q1-②] x=" + x + ", y=" + y + ", z=" + z); // x=25, y=3, z=2

        x = 5; y = 3; z = 2;
        z = ++x + ++y;
        System.out.println("[Q1-③] x=" + x + ", y=" + y + ", z=" + z); // x=6, y=4, z=10

        x = 5; y = 3; z = 2;
        z = x++ + ++y;
        System.out.println("[Q1-④] x=" + x + ", y=" + y + ", z=" + z); // x=6, y=4, z=9
    }

    // 2. 다음 논리 연산을 설명해 보아라.
    static void q2() {
        int[] samples = {5, 20, 25, 30, 40};
        for (int x : samples) {
            boolean r1 = (x >= 10) || (x < 30);
            boolean r2 = !(x == 20) && !(x == 30);
            boolean r3 = (x == 30) || !(x > 20);
            System.out.println("[Q2] x=" + x + " → ① " + r1 + ", ② " + r2 + ", ③ " + r3);
        }
    }

    // 3. 다음 수식에서 연산자 밑에 계산 순서를 숫자로 적어 보아라.
    static void q3() {
        int x, y = 7, z = 3, w = 4;
        x = y + z + 10;
        System.out.println("[Q3-①] " + x + " == ((7 + 3) + 10) = " + ((7 + 3) + 10));

        x = 17;
        int r = x % y / z * w;
        System.out.println("[Q3-②] " + r + " == ((17 % 7) / 3) * 4 = " + (((17 % 7) / 3) * 4));

        x = y = z % w;
        System.out.println("[Q3-③] x=" + x + ", y=" + y + " (z % w = " + (z % w) + ")");
    }

    // 4. 다음 문장에 해당하는 조건식을 써 보아라.
    static void q4() {
        int x = 10;
        System.out.println("[Q4] x=" + x
                + " | ① " + (x % 2 == 0)
                + " | ② " + (x % 5 == 0)
                + " | ③ " + (x == 3 || x <= 7)
                + " | ④ " + (x >= 0 && x <= 100)
                + " | ⑤ " + (x != 1 && x != 100));
    }

    // 5. 다음 조건에 해당하는 논리 연산식을 만들어 보자.
    static void q5() {
        int year = 5, age = 45, count = 4;
        System.out.println("[Q5-①] " + (year >= 3 && age >= 40 && count >= 3));

        int age2 = 5, height = 152;
        System.out.println("[Q5-②] " + (age2 <= 6 && height >= 150));

        int[] years = {1900, 2000, 2024, 2026};
        for (int y : years) {
            boolean leap = (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
            System.out.println("[Q5-③] " + y + "년 윤년? " + leap);
        }

        double ave = 3.5;
        int toefl = 550;
        System.out.println("[Q5-④] " + (ave >= 3.0 && (toefl >= 300 || toefl <= 700)));
    }
}
