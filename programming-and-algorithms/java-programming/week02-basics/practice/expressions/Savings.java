import java.util.Scanner;

/**
 * [2강 실습] 수식 - 4번 문제
 * 원금과 이율을 입력받아 2년 후의 예금액(복리)을 계산하는 프로그램
 * (Eclipse 에서는 Problem4.java 로 작성했던 코드)
 *
 * 📝 필기 - 복리 계산 과정
 *  원금 (x) --- 1년 뒤 ---> 원금 (x) + 이자 (x*r)
 *           --- 2년 뒤 ---> 원금 { x + x*r } + 이자 { (x + x*r) * r }
 *  즉, 1년 후 금액을 다시 원금으로 삼아 이자를 붙인다.  →  x * (1 + r)^2 와 같다.
 *
 * 실행 예
 *  원금 ? 100000
 *  이율 (0~1)? 0.9
 *  2년 후의 예금액은 361000.0입니다.      (100000 * 1.9 * 1.9)
 */
public class Savings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("원금 ? ");
        int saving = sc.nextInt();
        System.out.print("이율 (0~1)? ");
        // 원래 코드는 Double rate (대문자 D, 래퍼 클래스)로 작성했었음.
        // 동작은 하지만(오토 언박싱), 기본 자료형 double 을 쓰는 것이 일반적이다.
        double rate = sc.nextDouble();
        sc.close();

        double tmp = saving + (saving * rate); // 1년 후
        tmp = tmp + (tmp * rate);              // 2년 후
        System.out.println("2년 후의 예금액은 " + tmp + "입니다.");

        // 같은 결과: Math.pow(밑, 지수) 사용
        // double result = saving * Math.pow(1 + rate, 2);
    }
}
