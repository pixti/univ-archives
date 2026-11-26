import java.util.Scanner;

/**
 * [4강 실습] 반복문1 - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class FuelEfficiency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fuel, distance; double ratio; char cont;
        do {
            System.out.print("연료의 양 ? ");
            fuel = sc.nextInt();
            System.out.print("주행한 거리 ? ");
            distance = sc.nextInt();
            ratio = distance / (double) fuel;
            System.out.println("연비는 " + ratio + " 입니다.");

            System.out.print("계속 진행 ? (Y/N) : ");
            cont = sc.next().charAt(0);
        } while (cont == 'Y' || cont == 'y');   // True이면 반복 False이면 do-while문 빠져나옴.
        System.out.println("프로그램 종료");
        sc.close();
    }
}
