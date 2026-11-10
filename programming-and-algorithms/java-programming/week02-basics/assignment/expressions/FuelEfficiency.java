import java.util.Scanner;

/**
 * [2강 과제] 수식 - 3번
 * 자동차의 연비를 계산하는 프로그램을 작성하여 보자.
 * 사용자로부터 출발한 지점의 주행거리계 값과 도착한 지점의 주행거리계 값,
 * 그리고 사용한 연료량을 입력 받아 연비를 계산해 주는 프로그램을 작성하시오.
 *
 * 연비(km/l) = (도착 지점 주행거리계 - 출발 지점 주행거리계) / 사용한 연료량
 *
 * 실행 예
 *  출발한 지점의 주행거리계.:1000
 *  도착한 지점의 주행거리계.:1040
 *  사용한 연료: 10
 *  연비는 4.0km/l입니다.
 */
public class FuelEfficiency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("출발한 지점의 주행거리계.:");
        double start = sc.nextDouble();
        System.out.print("도착한 지점의 주행거리계.:");
        double end = sc.nextDouble();
        System.out.print("사용한 연료: ");
        double fuel = sc.nextDouble();
        sc.close();

        double distance = end - start;       // 실제 주행 거리
        double efficiency = distance / fuel; // 괄호/변수 분리 없이 end - start / fuel 로 쓰면 / 가 먼저 계산되어 틀림!
        System.out.println("연비는 " + efficiency + "km/l입니다.");
    }
}
