import java.util.Scanner;

/**
 * [4-1 반복문1] [실습] 성적 처리
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
