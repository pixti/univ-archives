import java.util.Scanner;

/**
 * [2강 과제] 수식 - 2번
 * 어떤 학생이 이번 학기에 컴퓨터 개론, C언어 프로그래밍, 영어, 일반 수학을 수강 신청하였다고 하자.
 * 각 과목의 점수를 입력하면 그 학생의 이번 학기 평균 점수를 계산하는 프로그램을 작성하라.
 *
 * 실행 예
 *  컴퓨터 개론 과목의 점수를 입력하시오.:80
 *  C언어 프로그래밍 과목의 점수를 입력하시오.:90
 *  영어 과목의 점수를 입력하시오.:70
 *  일반 수학 과목의 점수를 입력하시오.:80
 *  평균점수는 80.0점입니다.
 *
 * 포인트
 *  - sum / 4   → 정수 나눗셈이라 소수점이 버려짐 (예: 합이 321 이면 80.25 가 아니라 80)
 *  - sum / 4.0 → 실수 나눗셈 (321 / 4.0 = 80.25)
 *  - (double) sum / 4 도 가능. 단 (double) (sum / 4) 는 이미 버려진 정수를 실수로 바꿀 뿐이라 틀림!
 *  - 과목 수 4 는 기호 상수로 두면 과목이 늘어날 때 한 곳만 고치면 된다.
 */
public class AverageScore {
    public static void main(String[] args) {
        final int SUBJECT_COUNT = 4;
        Scanner sc = new Scanner(System.in);

        System.out.print("컴퓨터 개론 과목의 점수를 입력하시오.:");
        int computer = sc.nextInt();
        System.out.print("C언어 프로그래밍 과목의 점수를 입력하시오.:");
        int cLang = sc.nextInt();
        System.out.print("영어 과목의 점수를 입력하시오.:");
        int english = sc.nextInt();
        System.out.print("일반 수학 과목의 점수를 입력하시오.:");
        int math = sc.nextInt();
        sc.close();

        int sum = computer + cLang + english + math;
        double avg = (double) sum / SUBJECT_COUNT;
        System.out.println("평균점수는 " + avg + "점입니다.");
    }
}
