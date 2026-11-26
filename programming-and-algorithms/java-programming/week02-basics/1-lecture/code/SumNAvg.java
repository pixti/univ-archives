import java.util.Scanner;

/**
 * [2-5 수식1] [실습] 3명의 학생의 성적을 입력 받아 총점 및 평균 구하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class SumNAvg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 성적 >> ");
        int s1 = sc.nextInt();
        System.out.println("두 번째 성적 >> ");
        int s2 = sc.nextInt();
        System.out.println("세 번째 성적 >> ");
        int s3 = sc.nextInt();
        sc.close();

        int sum = s1 + s2 + s3;
        double avg = sum / 3.0;
        System.out.println("합 : " + sum);
        System.out.println("평균 : " + avg);
    }
}
