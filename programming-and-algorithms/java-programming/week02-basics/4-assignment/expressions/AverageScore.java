import java.util.Scanner;

/**
 * [2강 과제] 수식 - 2번
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
