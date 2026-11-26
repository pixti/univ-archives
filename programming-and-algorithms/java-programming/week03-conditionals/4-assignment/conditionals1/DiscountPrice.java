import java.util.Scanner;

/**
 * [3강 과제] 조건문1 - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
