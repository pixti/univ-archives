import java.util.Scanner;

/**
 * [3강 실습] 조건문2 - 1번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class StandardWeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("키 ? : ");
        int height = sc.nextInt();
        System.out.print("몸무게 ? : ");
        int weight = sc.nextInt();
        sc.close();

        double stdWeight = (height - 100) * 0.9;     // 표준 체중

        if (weight > stdWeight * 1.05) {             // 105% 초과
            System.out.println("과체중 입니다.");
        }
        else if (weight < stdWeight * 0.95) {        // 95% 미만
            System.out.println("저체중 입니다.");
        }
        else {                                       // 95% 이상 105% 이하
            System.out.println("표준체중 입니다.");
        }
    }
}
