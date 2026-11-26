/**
 * [2강 퀴즈] 변수와 자료형 퀴즈 (1 ~ 6번)
 * 문제 · 정답 · 필기 → README.md
 */
public class VariableQuiz {
    public static void main(String[] args) {
        q1();
        q2();
        q3();
        q4();
        q5();
        q6();
    }

    // 1. 다음 데이터를 표현하는 데 가장 바람직한 자료형과 변수 이름을 결정하고 변수 선언 문장을 써 보아라.
    static void q1() {
        int studentCount = 30;
        double distance = 12.5;
        double weight = 65.5;
        double height = 172.4;
        int score = 95;
        double speedOfLight = 2.998e8;
        System.out.println("[Q1] " + studentCount + ", " + distance + ", " + weight + ", "
                + height + ", " + score + ", " + speedOfLight);
    }

    // 2. 다음 변수 이름이 올바른지 아니면 잘못되었는지를 지적하고 그 이유를 써라.
    static void q2() {
        // int #_of_workers;            // 컴파일 에러
        int CountOfLettersInString = 1; // 문법상 OK (관례상으로는 countOfLettersInString)
        // int comment-flag;            // 컴파일 에러
        int $person = 2;                // OK
        // int 1st_base;                // 컴파일 에러
        // int <x>;                     // 컴파일 에러
        // int class;                   // 컴파일 에러
        int _length = 3;                // OK
        System.out.println("[Q2] " + CountOfLettersInString + ", " + $person + ", " + _length);
    }

    // 3. 다음의 지수 표기법을 일반 형태로 변환하라.
    static void q3() {
        System.out.println("[Q3] " + 8.35e5 + ", " + 2.87612e2 + ", " + 9.123e2 + ", "
                + 1.567e-1 + ", " + 4.987e-3);
        // 참고) 자바는 값이 작거나 크면 println 할 때 다시 지수 형태로 출력하기도 한다. (4.987E-3)
        System.out.printf("[Q3] printf 로 일반 형태 출력: %f%n", 4.987e-3);
    }

    // 4. 다음 설명에 적합한 변수 선언문을 작성하라.
    static void q4() {
        int sum;
        float score;
        double rate;
        char answer;
        float grade = 3.21f;
        // float grade2 = 3.21;           // 컴파일 에러: possible lossy conversion from double to float
        double distance = 7.84e10;
        double distance2 = 78400000000.0; // 문법적으로 가능하지만 오타 위험
        System.out.println("[Q4] grade = " + grade + ", distance = " + distance
                + ", 같은 값? " + (distance == distance2));
    }

    // 5. 다음의 코드에서 잘못된 부분을 모두 지적하라.
    static void q5() {
        // 수정한 코드
        int x = 0, y = 0;
        char grade = 'A';
        double rate = 1e10;              // 또는 Math.pow(10, 10)
        int salary = 2_000_000;          // 또는 2000000
        final double PI = 3.14;
        // PI = 3.14159;                 // 삭제 (상수는 값 변경 불가)
        System.out.println("[Q5] x=" + x + ", y=" + y + ", grade=" + grade + ", rate=" + rate
                + ", salary=" + salary + ", PI=" + PI + ", (10^10 = " + (10 ^ 10) + ")");
    }

    // 6. 다음 이스케이프 시퀀스의 의미는 무엇인가?
    static void q6() {
        System.out.println("[Q6] A\tB");          // 탭
        System.out.println("[Q6] ABC\bD");        // 백스페이스: C 를 지우고 D → ABD 로 보임(터미널에 따라 다름)
        System.out.println("[Q6] 줄\n바꿈");        // 줄바꿈
        System.out.println("[Q6] C:\\Users");     // 백슬래시
        System.out.println("[Q6] \"큰따옴표\"");     // 큰따옴표
        System.out.println("[Q6] \'작은따옴표\' " + '\''); // 작은따옴표 (문자열 안에서는 ' 그대로 써도 됨)
    }
}
