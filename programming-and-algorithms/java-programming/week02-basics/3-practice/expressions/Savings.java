import java.util.Scanner;

/**
 * [2강 실습] 수식 - 4번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Savings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("원금 ? ");
        int saving = sc.nextInt();
        System.out.print("이율 (0~1)? ");
        // ⚠ 자주 틀리는 부분: Double rate (대문자 D) 는 기본 자료형이 아니라 래퍼 클래스다.
        //    오토 언박싱 덕분에 동작은 하지만, 계산용 변수는 기본 자료형 double 을 쓴다.
        double rate = sc.nextDouble();
        sc.close();

        double tmp = saving + (saving * rate); // 1년 후
        tmp = tmp + (tmp * rate);              // 2년 후
        System.out.println("2년 후의 예금액은 " + tmp + "입니다.");

        // 같은 결과: Math.pow(밑, 지수) 사용
        // double result = saving * Math.pow(1 + rate, 2);
    }
}
