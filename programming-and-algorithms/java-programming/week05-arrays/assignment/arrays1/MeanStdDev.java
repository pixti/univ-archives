import java.util.Scanner;

/**
 * [5강 과제] 배열(1) - 4번 문제
 *
 * 30 개 이하의 실수를 입력받아 평균(m)과 표준편차(s)를 구하는 프로그램을 작성하시오.
 *
 *            1   n                      1   n
 *     m  =  ─── Σ  x_i         s = √(  ─── Σ (x_i − m)²  )
 *            n  i=1                     n  i=1
 *
 *   (예시 입력)
 *   값? 1.5
 *   계속 ? y
 *   값? ...
 *
 * 📝 필기 (AI 설명) : 코드 흐름
 *   입력 1.5 → y → 2.5 → y → 3.5 → n 이면
 *     data[0] = 1.5,  data[1] = 2.5,  data[2] = 3.5,  count = 3
 *
 * 📝 필기 (AI 설명) : 평균
 *   입력받을 때마다  sum = sum + data[count];
 *   입력이 끝나면    average = sum / count;
 *
 * 📝 필기 (AI 설명) : 표준편차
 *   for (int i = 0; i < count; i++)
 *       variance = variance + (data[i] - average) * (data[i] - average);
 *   여기서 (data[i] - average) 가 x_i − m 이고, 그것을 두 번 곱한 것이 (x_i − m)² 이다.
 *   variance = variance / count;          → 분산 (1/n Σ ...)
 *   standardDeviation = Math.sqrt(variance); → 표준편차 (분산의 제곱근)
 *
 * 📝 필기 (AI 설명) : 이 문제에서 배열이 필요한 이유
 *   입력받는 순간 평균만 구한다면 배열이 없어도 됩니다.
 *   하지만 표준편차를 구하려면 평균을 먼저 구한 다음, 각각의 값에 대해 (값 - 평균)² 을 계산해야 합니다.
 *   그래서 흐름이
 *     입력 → 배열에 저장 → 평균 계산 → 배열을 다시 처음부터 확인 → 표준편차 계산
 *   이 됩니다. (5-1 강의 "일단 저장 → 나중에 처리" 와 같은 이유)
 *
 * 📝 필기 (AI 설명) : 자료형과 크기
 *   - 입력이 실수이므로 double[] 을 사용.
 *   - "30 개 이하" 조건 때문에 double[] data = new double[30];
 *   - while (count < 30) 으로 30 개를 넘게 입력하는 것을 막는다.
 *
 * 포인트
 *  - 입력 → 계속? 을 묻고 'y' 가 아니면 break. 30 개가 차면 조건 count < 30 이 깨져서 끝.
 *  - sum, average 는 double 이라 sum / count 는 실수 나눗셈. (int 끼리였다면 형변환 필요)
 *
 * ⚠ 이 과제는 리팩터링 버전이 없다.
 * 💡 1 개만 넣으면 표준편차는 0.0. 첫 값에서 바로 n 을 넣어도 count 는 1 이라 0 으로 나누는 일은 없다.
 * 💡 통계에서 "표본 표준편차" 는 n 대신 n − 1 로 나눈다. 이 문제는 식에 1/n 이 주어졌으므로 n 으로 나눈다.
 *
 * 실행 예
 *  값? 1.5
 *  계속? y
 *  값? 5.6
 *  계속? y
 *  값? 7.1
 *  계속? n
 *  평균 : 4.733333333333333
 *  표준편차 : 2.366901396810231
 */
public class MeanStdDev {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] data = new double[30];
        double sum = 0, average, variance, standardDeviation;
        int count = 0;
        char answer;

        while (count < 30) {
            System.out.print("값? ");
            data[count] = sc.nextDouble();
            sum = sum + data[count];
            count++;

            System.out.print("계속? ");
            answer = sc.next().charAt(0);
            if (answer != 'y') {
                break;
            }
        }

        average = sum / count;  // 평균

        variance = 0;           // 분산
        for (int i = 0; i < count; i++) {
            variance = variance + (data[i] - average) * (data[i] - average);
        }
        variance = variance / count;

        standardDeviation = Math.sqrt(variance);  // 표준편차

        System.out.println("평균 : " + average);
        System.out.println("표준편차 : " + standardDeviation);
        sc.close();
    }
}
