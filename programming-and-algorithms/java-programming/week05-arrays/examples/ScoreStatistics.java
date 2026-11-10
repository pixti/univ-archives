import java.util.Scanner;

/**
 * [5-1 배열1] [실습] 학생 성적 데이터 처리하기 – 평균, 최대(소)값
 *
 * 0 ~ 100 사이의 점수를 배열에 모두 저장한 뒤, 반복문으로 평균 · 최대값 · 최소값을 구한다.
 *
 * 포인트
 *  - 4주차 ScoreProcessing 은 입력받는 순간 계산했다. 여기서는 "일단 배열에 저장 → 나중에 처리".
 *    값이 남아 있으므로 정렬(5-2)이나 표준편차(과제 4번)처럼 두 번 이상 훑는 처리도 할 수 있다.
 *  - cnt : 입력 정수의 개수이자 다음에 저장할 위치.
 *  - 최대/최소는 array[0] 으로 시작, i = 1 부터 비교.
 *
 * ⚠ 슬라이드 코드의 버그 2 가지를 고쳤다.
 *   1) 슬라이드는 sum = 0 에서 for (int i = 1; ...) sum += array[i]; → array[0] 이 합에서 빠진다.
 *      50, 60, 70 을 넣으면 평균이 43.333333333333336 (= 130 / 3).
 *      슬라이드 실행 화면의 "평균 : 60.0" 은 고쳐진 코드로 찍은 것.
 *      → 여기서는 sum = array[0] 으로 시작했다.
 *   2) 슬라이드는 if (cnt != 0) 가 평균 한 줄에만 걸려 있다.
 *      처음부터 범위 밖 값을 넣으면 최대값 · 최소값이 기본값 0 으로 출력된다.
 *      → 세 줄을 모두 if 블록 안에 넣고, 입력이 없으면 안내 문구를 출력했다.
 *   (클래스 이름은 슬라이드의 ConditionOperation 에서 바꿨다.)
 *
 * 실행 예  (슬라이드 화면과 같은 입력)
 *  0과 100 사이의 값을 입력 (그외의 값 종료) :
 *  50
 *  0과 100 사이 값 입력 (그외의 값 종료) :
 *  60
 *  0과 100 사이 값 입력 (그외의 값 종료) :
 *  70
 *  0과 100 사이 값 입력 (그외의 값 종료) :
 *  -1
 *  평균 : 60.0
 *  최대값 : 70
 *  최소값 : 50
 */
public class ScoreStatistics {
    public static void main(String[] args) {
        int val, cnt = 0, sum = 0;
        int [] array = new int[100];

        Scanner sc = new Scanner(System.in);
        System.out.println("0과 100 사이의 값을 입력 (그외의 값 종료) : ");
        val = sc.nextInt();
        while (val >= 0 && val <= 100) {
            array[cnt] = val;
            cnt = cnt + 1;   // 입력 정수의 개수 세기
            System.out.println("0과 100 사이 값 입력 (그외의 값 종료) : ");
            val = sc.nextInt();
        }

        if (cnt != 0) {
            sum = array[0];                          // ⚠ 슬라이드는 sum = 0 → array[0] 누락
            int min = array[0];
            int max = array[0];
            for (int i = 1; i < cnt; i++) {
                sum += array[i];                     // 합 구하기
                if (array[i] > max) max = array[i];  // 최대값 구하기
                if (array[i] < min) min = array[i];  // 최소값 구하기
            }
            System.out.println("평균 : " + (double) sum / cnt);
            System.out.println("최대값 : " + max);
            System.out.println("최소값 : " + min);
        } else {
            System.out.println("입력된 성적이 없습니다.");
        }
        sc.close();
    }
}
