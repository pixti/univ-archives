import java.util.Scanner;

/**
 * [3강 과제] 조건문1 - 2번 문제
 * 상점에서 하나에 100원인 물건을 판매하고 있다고 가정하자.
 * 물건을 10개 이상 구입하는 고객에게는 10%를 할인해준다고 하자.
 * 물건의 개수를 입력하면 총액을 계산해 주는 프로그램을 작성하라.
 * (Eclipse 에서는 Main.java 로 작성했던 코드)
 *
 * 포인트
 *  - final 로 선언한 "기호 상수" (2주차 2-3 참고) 를 사용해 100, 90 같은 숫자에 이름을 붙였다.
 *    → 가격이나 할인율이 바뀌면 상수 한 곳만 고치면 된다.
 *  - 할인율을 0.9 (double) 대신 정수 90 (%) 으로 두고 마지막에 / 100 해서 int 로만 계산했다.
 *
 * 💡 계산 순서가 중요하다!
 *      UNIT_PRICE * count * DISCOUNTED_PERCENT / 100   → 왼쪽부터 계산: 100 * 10 * 90 / 100 = 900  (O)
 *      UNIT_PRICE * count * (DISCOUNTED_PERCENT / 100) → 90 / 100 이 정수 나눗셈이라 0 → 결과 0     (X)
 *    곱셈을 모두 끝낸 뒤 마지막에 나눠야 정수 나눗셈으로 값이 사라지지 않는다.
 *
 * 문제의 실행 예  (입력 : 10)
 *  물건의 전체 가격은 : 900원입니다.
 *
 * 내 코드 실행 예
 *  물건의 개수를 입력하세요. : 12
 *  물건의 전체 가격은 : 1080원 입니다.
 */
public class DiscountPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문제에서 주어진 물건 한 개의 가격
        final int UNIT_PRICE = 100;

        // 10개 이상 구매하면 10% 할인 → 실제 지불 비율은 90%
        final int DISCOUNTED_PERCENT = 90;

        System.out.print("물건의 개수를 입력하세요. : ");
        int count = sc.nextInt();

        int totalPrice;

        // 물건을 10개 이상 구매한 경우 10% 할인합니다.
        if (count >= 10) {
            totalPrice = UNIT_PRICE * count * DISCOUNTED_PERCENT / 100;
        }
        // 10개 미만이면 할인 없이 정가를 적용합니다.
        else {
            totalPrice = UNIT_PRICE * count;
        }

        System.out.print("물건의 전체 가격은 : " + totalPrice + "원 입니다.");
        sc.close();
    }
}
