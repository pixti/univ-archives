import java.util.Scanner; // import 하지 않으면 자바는 Scanner 클래스 정의가 안 되어 있어 사용 불가능

/**
 * [2강 실습] 변수와 자료형 - 1번 실습
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Literal {
    public static void main(String[] args) {
        // int x;  ← 초기화되지 않으면 에러
        //          (프로그래밍응용 시간에 배웠던 인스턴스 변수와 달리, 이건 지역 변수의 경우)
        int x = 0;
        System.out.print(x);

        // float f = 12.3;  ← float 변수에 대입 시 숫자에 f 를 명시해야 함.
        //                    12.3 은 double 이고 12.3f 가 float
        float f = 12.3f;
        System.out.print(f);

        // Scanner sc = new Scanner();  ← System.in 을 넣지 않으면 에러
        // 1바이트씩 읽어들이는 로우 레벨(Low-level) 스트림인 System.in 을 매개변수로 받아서,
        // 개발자가 쉽게 다룰 수 있도록 변환해 주는 하이 레벨(High-level) 클래스가 바로 Scanner
        Scanner sc = new Scanner(System.in);

        // double db = sc.next();  ← sc.next() 는 String, sc.nextDouble() 이 double
        double db = sc.nextDouble();

        // Scanner sc = new Scanner(System.in);  ← 스캐너는 프로그램에서 한 번만 생성하는 것이 좋음
        //                                          (같은 이름으로 다시 선언하면 중복 선언 에러이기도 함)
        String s = sc.next();

        sc.close(); // 다 쓰고 자원 낭비를 막기 위해 스캐너를 닫는 것이 좋음

        // (추가) 입력값 확인용
        // System.out.println();
        // System.out.println("db = " + db + ", s = " + s);
    }
}
