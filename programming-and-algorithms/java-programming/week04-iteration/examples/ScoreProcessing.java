import java.util.Scanner;

/**
 * [4-1 반복문1] [실습] 성적 처리
 *
 * 0 ~ 100 사이의 점수를 계속 입력받고, 범위 밖의 값이 들어오면 입력을 끝낸다.
 * 그 후 평균, 최대값, 최소값을 출력한다.
 *
 * 포인트
 *  - 입력 → 검사 → 처리 → 다시 입력
 *    첫 값은 반복문 "밖에서" 읽고, 블록의 "마지막" 에서 다음 값을 읽는다.
 *    → 종료 값(-1 등)이 합계/개수에 섞이지 않는다. (실습 1번 산술 평균과 같은 구조)
 *  - max 는 나올 수 있는 값보다 작은 -1, min 은 큰 101 로 시작
 *    → 첫 입력이 무조건 max, min 이 된다.
 *  - (double) sum / cnt : 형변환이 나눗셈보다 먼저 → 실수 나눗셈.
 *    (double) (sum / cnt) 로 쓰면 정수 나눗셈 결과를 바꾸는 것이라 소수점이 사라진다.
 *  - if (cnt != 0) : 처음부터 범위 밖 값을 넣으면 cnt 가 0 → 0 으로 나누는 것을 막는다.
 *
 * 실행 예
 *  0과 100 사이의 값을 입력 (그외 값은 종료) :
 *  30
 *  0과 100 사이의 값을 입력 (그외 값은 종료) :
 *  40
 *  0과 100 사이의 값을 입력 (그외 값은 종료) :
 *  50
 *  0과 100 사이의 값을 입력 (그외 값은 종료) :
 *  -1
 *  평균 : 40.0
 *  최대값 : 50
 *  최소값 : 30
 */
public class ScoreProcessing {
    public static void main(String[] args) {
        int val, cnt = 0, sum = 0, max = -1, min = 101;
        Scanner sc = new Scanner(System.in);
        System.out.println("0과 100 사이의 값을 입력 (그외 값은 종료) : ");
        val = sc.nextInt();
        while (val >= 0 && val <= 100) {
            cnt = cnt + 1;              // 입력 정수의 개수 세기
            sum = sum + val;            // 합 구하기
            if (val > max) max = val;   // 최대값 구하기
            if (val < min) min = val;   // 최소값 구하기
            System.out.println("0과 100 사이의 값을 입력 (그외 값은 종료) : ");
            val = sc.nextInt();
        }
        if (cnt != 0) {
            System.out.println("평균 : " + (double) sum / cnt);
            System.out.println("최대값 : " + max);
            System.out.println("최소값 : " + min);
        }
        sc.close();
    }
}
