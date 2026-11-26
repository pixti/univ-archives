import java.util.Scanner;

/**
 * [4강 실습] 반복문1 - 1번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
