import java.util.Scanner;

/**
 * [5강 과제] 배열(2) - 1번 문제  💡 참고 답안 (직접 작성하지 않은 부분)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class InventoryArray2D {

    static final int PRODUCT_COUNT = 100;   // 물품 번호 0 ~ 99  → 행
    static final int LOCATION_COUNT = 10;   // 저장 위치 1 ~ 10  → 열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] stock = new int[PRODUCT_COUNT][LOCATION_COUNT];  // stock[물품 번호][위치 - 1] = 수량
        char menu;
        int product, location, amount;

        while (true) {
            System.out.println("==============================");
            System.out.println("입고 (i)");
            System.out.println("출고 (o)");
            System.out.println("재고 (s)");
            System.out.println("종료 (q)");
            System.out.println("==============================");
            System.out.print("select menu ('i', 'o', 's' or 'q') : ");
            menu = sc.next().charAt(0);

            if (menu == 'i' || menu == 'o') {       // 입고, 출고 : 입력 형식이 같다
                System.out.print("물품 번호(0~99), 저장 위치(1~10), 수량을 입력하세요 : ");
                product = sc.nextInt();
                location = sc.nextInt();
                amount = sc.nextInt();

                if (!isValid(product, location, amount)) {
                    System.out.println("입력 범위를 확인하세요.");
                    continue;
                }

                if (menu == 'i') {
                    stock[product][location - 1] += amount;
                    System.out.println("물품 " + product + " 을 위치 " + location + " 에 " + amount + " 개 입고했습니다.");
                } else if (stock[product][location - 1] < amount) {     // 출고할 만큼 재고가 없음
                    System.out.println("재고가 부족합니다. (현재 " + stock[product][location - 1] + " 개)");
                } else {
                    stock[product][location - 1] -= amount;
                    System.out.println("물품 " + product + " 을 위치 " + location + " 에서 " + amount + " 개 출고했습니다.");
                }
            }
            else if (menu == 's') {                 // 재고 현황
                printStock(stock);
            }
            else if (menu == 'q') {                 // 종료
                break;
            }
        }
        sc.close();
    }

    // 물품 번호, 위치, 수량이 모두 올바른 범위인지 검사
    static boolean isValid(int product, int location, int amount) {
        return product >= 0 && product < PRODUCT_COUNT
                && location >= 1 && location <= LOCATION_COUNT
                && amount > 0;
    }

    // 재고가 있는 물품(행)만 위치별 수량과 합계를 출력
    static void printStock(int[][] stock) {
        System.out.print("물품");
        for (int col = 0; col < LOCATION_COUNT; col++) {
            System.out.print("\t위치" + (col + 1));
        }
        System.out.println("\t합계");

        boolean empty = true;
        for (int row = 0; row < stock.length; row++) {
            int sum = 0;
            for (int col = 0; col < stock[row].length; col++) {
                sum += stock[row][col];
            }
            if (sum == 0) continue;     // 재고가 없는 물품은 건너뛴다

            empty = false;
            System.out.print(row);
            for (int col = 0; col < stock[row].length; col++) {
                System.out.print("\t" + stock[row][col]);
            }
            System.out.println("\t" + sum);
        }
        if (empty) {
            System.out.println("(재고 없음)");
        }
    }
}
