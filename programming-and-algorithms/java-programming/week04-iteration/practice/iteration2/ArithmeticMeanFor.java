import java.util.Scanner;

/**
 * [4강 실습] 반복문2 - 1번 문제
 * ※ 반복 시 for 문만 사용하시오.
 *
 * 사용자로부터 일련의 데이터를 입력받아서 산술 평균을 구하는 프로그램을 작성하여 보자.
 * 음수가 입력되면 데이터의 끝이라고 간주한다.
 *
 *     산술 평균 : (x1 + x2 + ... + xn) / n
 *
 * 📝 필기 : 처음 작성한 코드 → 컴파일 에러
 *
 *     int sum = 0, count = 0;
 *     for (System.out.print("n ? "), int n = sc.nextInt(); n >= 0; n = sc.nextInt()) {   // ❌
 *         sum += n;
 *         count++;
 *     }
 *
 *   AI 에게 물어본 설명 (캡처)
 *    - 자바의 for( 초기화; 조건; 증가 ) 형식에서 "초기화" 자리는 하나의 문장이어야 하며,
 *      일반적으로 변수 선언이나 간단한 할당이어야 합니다. System.out.print(...)는 표현식이고
 *      문장이 아니므로 초기화 위치에 올 수 없습니다.
 *    - 또한 두 번째 부분인 n = sc.nextInt()도 증가식으로 사용되는데, 이 자리엔 보통 증가 연산이나
 *      변수에 대한 재할당이 와야 하지만, 입력 루프의 의도대로라면 증가식은 사실상 필요 없거나
 *      별도의 while/무한루프 처리가 더 자연스럽습니다.
 *    - 정확한 문제 요약 : 초기화 부분에 System.out.print("n ? ")이 문장이므로 허용되지 않음.
 *      두 번째 부분에 int 선언을 포함하지 못함. 루프 변수 선언은 보통 한 번만 초기화 부분에 해야 하고,
 *      이후에는 n만 다루는 방식이어야 함.
 *
 *   → 고친 코드 : int n 을 for 밖에서 선언하고, 초기화 부분에서는 n = sc.nextInt() 로 "대입"만 한다.
 *
 *     int n, sum = 0, count = 0;
 *     for (System.out.print("n ? "), n = sc.nextInt(); n >= 0; n = sc.nextInt()) {     // ⭕
 *
 * ⚠ 위 AI 설명은 절반만 맞다. 고친 코드가 그대로 컴파일되는 것이 증거.
 *    - System.out.print(...) 같은 메소드 호출은 for 초기화 부분에 쓸 수 있다.
 *      초기화 부분에는 다음 둘 중 하나가 온다. (4-3 강의 노트 참고)
 *        ① 변수 선언 하나            for (int i = 0, j = 10; ...)
 *        ② 식(expression) 목록       for (System.out.print("n ? "), n = sc.nextInt(); ...)
 *           메소드 호출, 대입, ++/-- 같은 "문장이 될 수 있는 식"을 쉼표로 나열.
 *    - 진짜 원인 : ① 과 ② 를 섞어 썼다. (print 호출 = 식, int n = ... = 선언)
 *      쉼표 뒤에 int 가 오면 컴파일러는 그것을 식으로 읽으려다 실패한다.
 *      실제 javac 에러 : '.class' expected / not a statement  ← 둘 다 int 위치를 가리킨다.
 *    - 증가식 자리의 n = sc.nextInt() 도 문제 없다. 증가식 자리 역시 "식 목록"이라
 *      i++ 뿐 아니라 대입이나 메소드 호출도 쓸 수 있다. (실제로 잘 돌아간다)
 *
 * 포인트
 *  - while 버전(반복문1-1)의 구조를 for 의 세 칸에 나눠 담은 것.
 *      while 버전                      for 버전
 *      print("값 ? "); x = nextInt();  →  초기화 : 안내 출력 + 첫 값 읽기
 *      while (x >= 0)                  →  조건   : 음수가 아니면 계속
 *      x = nextInt(); (블록 마지막)    →  증가식 : 다음 값 읽기 (본문 실행 후 실행)
 *  - 증가식은 본문이 끝난 뒤에 실행되므로 "처리 → 다음 값 읽기" 순서가 그대로 지켜진다.
 *  - sum, count 가 int 라서 sum / (double) count 로 실수 나눗셈을 만든다.
 *
 * ⚠ 반복문1-1 과 같이 처음부터 음수를 넣으면 0 / 0.0 = NaN. if (count != 0) 를 추가했다.
 *
 * 내 코드 실행 예
 *  n ? 10 5 2 8 -1
 *  산술 평균 : 6.25
 */
public class ArithmeticMeanFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, sum = 0, count = 0;
        for (System.out.print("n ? "), n = sc.nextInt(); n >= 0; n = sc.nextInt()) {
            sum += n;
            count++;
        }

        if (count != 0)             // ⚠ 추가 : 첫 입력이 음수일 때 NaN 방지
            System.out.println("산술 평균 : " + sum / (double) count);
        else
            System.out.println("입력된 데이터가 없습니다.");
        sc.close();
    }
}
