import java.util.Scanner;

/**
 * [4강 실습] 반복문2 - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class FuelEfficiencyFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char cont; int dist, fuel; double ratio;
        System.out.print("계속 (y or n) ? "); cont = sc.next().charAt(0);

        for (; cont == 'y' || cont == 'Y'; ) {      // 초기화, 증가식 생략 → while (cont == 'y' || cont == 'Y') 과 같다
            System.out.print("주행 거리 ? ");
            dist = sc.nextInt();
            System.out.print("연료량 ? ");
            fuel = sc.nextInt();
            ratio = dist / (double) fuel;
            System.out.println("연비 : " + ratio);

            System.out.print("계속 (y or n) ? ");
            cont = sc.next().charAt(0);
        }
        sc.close();
    }
}
