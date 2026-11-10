import java.util.Scanner;

/**
 * [3강 실습] 조건문2 - 1번 문제
 * if 문을 사용하여 사용자로부터 키를 입력받아서 표준 체중을 계산한 후에
 * 사용자의 체중과 비교하여 저체중인지, 표준인지, 과체중인지를 판단하는 프로그램을 작성하라.
 *
 *  - 표준 체중 계산식 : 표준 체중 = (키 - 100) * 0.9
 *  - 표준 체중의 105% 초과이면 과체중
 *  - 표준 체중의 95% 미만이면 저체중
 *  - 95% 이상 105% 이하이면 표준 체중
 *
 * 포인트
 *  - 105% → * 1.05, 95% → * 0.95 로 바꿔서 비교한다.
 *  - 과체중(초과), 저체중(미만) 을 먼저 거르면, 나머지(else)는 자동으로 "95% 이상 105% 이하" 가 된다.
 *    → 표준 체중 조건 (weight >= std * 0.95 && weight <= std * 1.05) 을 따로 쓸 필요가 없다.
 *
 * 💡 (height - 100) * 0.9 : int * double 이므로 결과는 double (자동 형변환).
 *
 * 문제의 실행 예  (입력 : 키 180, 몸무게 90)
 *  알림>과체중입니다.
 *
 * 내 코드 실행 예
 *  키 ? : 180
 *  몸무게 ? : 80
 *  과체중 입니다.          (표준 체중 72kg, 105% = 75.6kg 초과)
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
