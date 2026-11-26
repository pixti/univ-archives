import java.util.Scanner;

/**
 * [4강 실습] 반복문2 - 1번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
