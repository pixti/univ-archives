import java.util.Scanner;

/**
 * [2강 과제] 수식 - 3번
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
