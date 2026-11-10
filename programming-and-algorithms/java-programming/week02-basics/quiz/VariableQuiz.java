/**
 * [2강 퀴즈] 변수와 자료형 퀴즈 (1 ~ 6번)
 *
 * 각 문제의 답을 실제로 컴파일/실행되는 코드로 옮기고, 해설과 필기를 주석으로 달았다.
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

    /**
     * 1. 다음 데이터를 표현하는 데 가장 바람직한 자료형과 변수 이름을 결정하고 변수 선언 문장을 써 보아라.
     *
     * | 데이터                   | 자료형 | 변수 이름     | 변수 선언 문장          |
     * |--------------------------|--------|---------------|-------------------------|
     * | 한 학급의 학생 수         | int    | studentCount  | int studentCount;       |
     * | 두 물체 사이의 거리(실수형) | double | distance      | double distance;        |
     * | 사람의 몸무게             | double | weight        | double weight;          |
     * | 사람의 키                 | double | height        | double height;          |
     * | 시험 점수                 | int    | score         | int score;              |
     * | 빛의 속도(실수형)          | double | speedOfLight  | double speedOfLight;    |
     *
     * ⚠ 제출본에서는 "사람의 키" 선언문을 double weight; 로 잘못 적었음 → double height; 가 맞다.
     *
     * 📝 필기
     *  - 스네이크 표기법(snake_case): 단어 사이를 _ 로 연결   예) student_count
     *  - 카멜 표기법(camelCase)    : 두 번째 단어부터 첫 글자를 대문자로   예) studentCount
     *    → 자바 변수명은 카멜 표기법이 관례
     *  - 몸무게와 키는 int 나 double 이 상식적 (소수점까지 필요하면 double)
     */
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

    /**
     * 2. 다음 변수 이름이 올바른지 아니면 잘못되었는지를 지적하고 그 이유를 써라.
     *
     * | 변수 이름              | 유효 | 이유                                                   |
     * |------------------------|------|--------------------------------------------------------|
     * | #_of_workers           | X    | 특수문자 # 는 허용되지 않음                              |
     * | CountOfLettersInString | O    | 정상 작동. 단, 변수는 첫 글자가 소문자인 것이 관례          |
     * | comment-flag           | X    | 특수문자 - 는 허용되지 않음 (빼기 연산자로 해석됨)          |
     * | $person                | O    | 특수문자 $ 는 허용됨                                     |
     * | 1st_base               | X    | 숫자로 시작하는 것은 허용되지 않음                         |
     * | <x>                    | X    | < , > 는 허용되지 않음                                   |
     * | class                  | X    | 예약어 class 는 식별자로 사용 불가                        |
     * | _length                | O    | 특수문자 _ 는 허용됨                                     |
     *
     * 식별자 규칙 (2-2 강의)
     *  - 첫 글자는 문자나 '_', '$' 로 시작 (숫자로 시작 불가)
     *  - 첫 글자가 아니면 문자, '_', '$', 숫자로 구성 가능
     *  - 예약어(키워드) 사용 불가, 대소문자 구분, 길이 제한 없음, 공백 포함 불가
     *  - 참고) Java 9 부터는 밑줄 하나만 있는 _ 단독은 키워드라 사용 불가 (_length 는 OK)
     *
     * 📝 필기
     *  - 상수명이나 클래스명은 보통 대문자로 시작하고, 변수명은 소문자로 시작하는 것이 관례.
     */
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

    /**
     * 3. 다음의 지수 표기법을 일반 형태로 변환하라.
     *  ① 8.35e5     = 835000.0
     *  ② 2.87612e2  = 287.612
     *  ③ 9.123e2    = 912.3
     *  ④ 1.567e-1   = 0.1567
     *  ⑤ 4.987e-3   = 0.004987
     *
     * 📝 필기
     *  - e2 는 밑이 10 인 지수를 의미함.  즉 e2 = × 10², e-3 = × 10⁻³
     */
    static void q3() {
        System.out.println("[Q3] " + 8.35e5 + ", " + 2.87612e2 + ", " + 9.123e2 + ", "
                + 1.567e-1 + ", " + 4.987e-3);
        // 참고) 자바는 값이 작거나 크면 println 할 때 다시 지수 형태로 출력하기도 한다. (4.987E-3)
        System.out.printf("[Q3] printf 로 일반 형태 출력: %f%n", 4.987e-3);
    }

    /**
     * 4. 다음 설명에 적합한 변수 선언문을 작성하라.
     *  ① 정수의 합을 저장하는 변수 sum                                   → int sum;
     *  ② 정밀도가 낮은 실수형 점수를 저장하는 변수 score                   → float score;
     *  ③ 정밀도가 높은 실수형 비율을 저장하는 변수 rate                    → double rate;
     *  ④ 문자를 저장하는 변수 answer                                     → char answer;
     *  ⑤ 정밀도가 낮은 실수를 저장하는 변수로 초기값이 3.21 인 변수 grade   → float grade = 3.21f;
     *  ⑥ 정밀도가 높은 실수를 저장하는 변수로 초기값이 7.84e10 인 변수 distance → double distance = 7.84e10;
     *
     * 📝 필기 (질문: 78410000000 이나 3.21 로 저장하면 안 되는 거임?)
     *  - float grade = 3.21; 로 쓰면 안 되는 이유 (컴파일 에러)
     *    · 자바는 소수점이 있는 숫자(리터럴)를 기본적으로 정밀도가 높은 double 형(8바이트)으로 인식.
     *    · 더 큰 double 값을 정밀도가 낮은 float 변수(4바이트)에 그대로 넣으려 하면
     *      데이터 손실 위험이 있다고 판단하여 컴파일 에러 발생.
     *    · 그래서 "이 숫자는 double 이 아니라 float 형이다" 라고 알려주기 위해
     *      반드시 숫자 끝에 f 나 F 를 붙여야 한다. (3.21f)
     *  - 78400000000.0 으로 풀어 쓰는 경우 (7.84e10)
     *    · double distance = 78400000000.0; 처럼 일반 실수 형태로 저장하는 것은 문법적으로 가능.
     *    · 하지만 내가 78410000000 이라고 잘못 적었던 것처럼 (실제 7.84e10 = 78,400,000,000)
     *      0 이 많아지면 입력 과정에서 오타가 나기 매우 쉽다.
     *    · 문제에서 지수 표기법을 제시하기도 했고, 실무에서도 자릿수가 큰 숫자는
     *      가독성과 휴먼 에러 방지를 위해 지수 표기법(e)을 그대로 쓰는 것이 권장된다.
     */
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

    /**
     * 5. 다음의 코드에서 잘못된 부분을 모두 지적하라.
     *
     *   public class Test {
     *       public void main(String[] args)
     *       {
     *           int x, y = 0;          // x와 y를 모두 0으로 초기화
     *           char grade = "A";
     *           double rate = 10^10;   // rate에 1*10^10을 저장
     *           int salary = 2,000,000;
     *           final double PI = 3.14;
     *           PI = 3.14159;
     *       }
     *   }
     *
     *  ① public void main(String[] args)
     *     → 프로그램 시작점인 main 메소드는 반드시 static 을 포함해야 한다.
     *       올바른 형태: public static void main(String[] args)
     *  ② int x, y = 0;
     *     → 주석("x와 y를 모두 0으로 초기화")의 의도와 다르게 y 만 0 으로 초기화되고 x 는 선언만 된다.
     *       둘 다 초기화하려면 int x = 0, y = 0;
     *  ③ char grade = "A";
     *     → char 리터럴은 작은따옴표 ' ' 로 감싸야 한다. 큰따옴표 " " 는 문자열(String).
     *       자료형 불일치 에러 → 'A' 로 수정
     *  ④ double rate = 10^10;
     *     → 자바에서 ^ 는 거듭제곱이 아니라 비트 배타적 논리합(XOR) 연산자. (10 ^ 10 = 0)
     *       1 × 10¹⁰ 을 저장하려면 지수 표기법 1e10 또는 Math.pow(10, 10) 사용
     *  ⑤ int salary = 2,000,000;
     *     → 숫자 리터럴에 쉼표(,)를 넣을 수 없어 문법 에러.
     *       2000000 으로 붙여 쓰거나, Java 7 이상에서는 가독성을 위해 2_000_000 처럼 언더스코어 사용 가능
     *  ⑥ PI = 3.14159;
     *     → PI 는 final 이 붙은 상수. 한 번 초기화되면 값을 다시 할당할 수 없어 컴파일 에러.
     */
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

    /**
     * 6. 다음 이스케이프 시퀀스의 의미는 무엇인가?
     *
     * | 이스케이프 시퀀스 | 의미                     |
     * |-------------------|--------------------------|
     * | \t                | Tab 만큼 커서 이동         |
     * | \b                | 커서 한 칸 앞 이동 (백스페이스) |
     * | \n                | 줄바꿈                    |
     * | \\                | 백슬래시(원화 기호) 출력   |
     * | \"                | 큰따옴표 문자 출력         |
     * | \'                | 작은따옴표 문자 출력       |
     *
     * 📝 필기
     *  - \b 는 백스페이스: 스페이스바(공백 1개)가 아니라 앞 글자를 "지우는" 것.
     *    (콘솔 환경에 따라 실제로 지워져 보이지 않을 수도 있음. 이클립스 콘솔은 특수 문자로 표시되기도 함)
     *  - 한글 윈도우에서는 백슬래시 \ 가 원화 기호 ₩ 로 보인다. (같은 문자)
     */
    static void q6() {
        System.out.println("[Q6] A\tB");          // 탭
        System.out.println("[Q6] ABC\bD");        // 백스페이스: C 를 지우고 D → ABD 로 보임(터미널에 따라 다름)
        System.out.println("[Q6] 줄\n바꿈");        // 줄바꿈
        System.out.println("[Q6] C:\\Users");     // 백슬래시
        System.out.println("[Q6] \"큰따옴표\"");     // 큰따옴표
        System.out.println("[Q6] \'작은따옴표\' " + '\''); // 작은따옴표 (문자열 안에서는 ' 그대로 써도 됨)
    }
}
