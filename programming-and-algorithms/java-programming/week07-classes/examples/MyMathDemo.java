import java.util.Scanner;

/**
 * [8-2 실습] 수학 라이브러리 작성 - 원주와 원 면적, 마일을 킬로미터로
 *
 * 포인트
 *  - 정적 메소드(static method) 는 일반 필드(인스턴스 변수)를 사용하지 않는 메소드
 *    → 객체 생성 없이 "클래스명.메소드명()" 으로 실행 가능  (MyMath.getCircleArea(r))
 *  - 정적 메소드는 정적 필드, 인수, 지역 변수만 사용 가능. 즉 일반 필드는 사용 불가
 *  - static final : 객체마다 가질 필요 없는 "상수" (PI, KMPerMILE)
 *  - 💡 자바의 Math 클래스(Math.PI, Math.sqrt, Math.max ...)도 같은 방식으로 만들어져 있다.
 *    그래서 new Math() 없이 Math.max(a, b) 로 쓴다.
 *
 * 📝 퀴즈 8번 필기 : static 메서드 안에서는 지역변수, static 필드, static 메서드만 사용 가능
 *
 * 실행 예
 *  반지름을 입력하세요 :
 *  2
 *  원의 둘레 : 12.56636
 *  원의 면적 : 12.56636
 *  마일을 입력하세요 :
 *  10
 *  16.09344킬로미터에 해당합니다.
 *  킬로미터을 입력하세요 :
 *  16.09344
 *  10.0마일에 해당합니다.
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
