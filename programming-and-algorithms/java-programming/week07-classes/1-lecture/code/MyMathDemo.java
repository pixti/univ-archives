import java.util.Scanner;

/**
 * [7-2 실습] 수학 라이브러리 작성 - 원주와 원 면적, 마일을 킬로미터로
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class MyMathDemo {
    public static void main(String[] args) {
        System.out.println("반지름을 입력하세요 : ");
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        System.out.println("원의 둘레 : " + MyMath.getCirclePerimeter(r));
        System.out.println("원의 면적 : " + MyMath.getCircleArea(r));
        System.out.println("마일을 입력하세요 : ");
        r = sc.nextDouble();
        System.out.println(MyMath.mileToKilometer(r) + "킬로미터에 해당합니다.");
        System.out.println("킬로미터을 입력하세요 : ");
        r = sc.nextDouble();
        System.out.println(MyMath.kilometerToMile(r) + "마일에 해당합니다.");
        sc.close();
    }
}

// MyMath 클래스는 다음과 같이 작성토록 한다.
class MyMath {
    static final double PI = 3.14159;
    static final double KMPerMILE = 1.609344;
    static double getCirclePerimeter(double r) { return 2 * PI * r; }
    static double getCircleArea(double r) { return PI * r * r; }
    static double kilometerToMile(double km) { return km * 1 / KMPerMILE; }
    static double mileToKilometer(double m) { return m * KMPerMILE; }
}
