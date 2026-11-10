import java.util.Scanner;

/**
 * [4강 실습] 반복문1 - 1번 문제
 * ※ 반복 시 while 이나 do while 문만 사용하시오.
 *
 * 사용자로부터 일련의 데이터를 입력받아서 산술 평균을 구하는 프로그램을 작성하여 보자.
 * 음수가 입력되면 데이터의 끝이라고 간주한다.
 *
 *     산술 평균 : (x1 + x2 + ... + xn) / n
 *
 * 📝 필기 (코드 주석)
 *  - double sum = 0;  // 누적합
 *  - int count = 0;   // 카운트
 *  - print("값 ? ");  // 음수면 종료
 *  - int x = sc.nextInt();  // 첫 값 x 읽기
 *  - while (x >= 0) {       // 음수가 아니면 계속
 *  - x = sc.nextInt();      // 다음 값 읽기 (음수 입력 받을 수 있어서 무한 루프가 아님)
 *
 * 포인트
 *  - 입력 → 검사 → 처리 → 다시 입력 (4-1 성적 처리와 같은 구조)
 *    첫 값은 반복문 밖에서 읽고, 블록 마지막에서 다음 값을 읽는다.
 *    → 종료 신호인 음수가 합계에 섞이지 않는다.
 *  - 반복 횟수가 정해지지 않았다 (음수가 언제 들어올지 모름) → while.
 *  - sum / (double) count : 실수 나눗셈. (sum 이 이미 double 이라 사실 형변환 없이도 실수 결과)
 *
 * ⚠ 처음부터 음수를 넣으면 count = 0 → 0.0 / 0.0 = NaN 이 출력된다.
 *   4-1 성적 처리처럼 if (count != 0) 으로 막았다.
 * 💡 Scanner 는 공백이나 줄바꿈으로 값을 나누므로 "2 3 4 -1" 처럼 한 줄에 넣어도 된다.
 *
 * 문제의 실행 예
 *  (없음 - 수식만 주어짐)
 *
 * 내 코드 실행 예
 *  값 ? 2
 *  3
 *  4
 *  -1
 *  산술 평균 : 3.0
 */
public class ArithmeticMean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sum = 0;     // 누적합
        int count = 0;      // 카운트

        System.out.print("값 ? ");  // 음수면 종료
        int x = sc.nextInt();       // 첫 값 x 읽기

        while (x >= 0) {            // 음수가 아니면 계속
            sum += x;
            count++;
            x = sc.nextInt();       // 다음 값 읽기 (음수 입력 받을 수 있어서 무한 루프가 아님)
        }

        if (count != 0) {           // ⚠ 추가 : 첫 입력이 음수일 때 NaN 방지
            double avg = sum / (double) count;
            System.out.println("산술 평균 : " + avg);
        }
        else {
            System.out.println("입력된 데이터가 없습니다.");
        }
        sc.close();
    }
}
