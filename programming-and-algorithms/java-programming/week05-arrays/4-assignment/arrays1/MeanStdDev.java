import java.util.Scanner;

/**
 * [5강 과제] 배열(1) - 4번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
