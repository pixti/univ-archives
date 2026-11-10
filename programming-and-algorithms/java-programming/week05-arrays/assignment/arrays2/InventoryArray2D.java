import java.util.Scanner;

/**
 * [5강 과제] 배열(2) - 1번 문제  💡 참고 답안 (직접 작성하지 않은 부분)
 *
 * 실습 5번의 재고 관리 프로그램을 2 차원 배열로 확장하시오.
 *   - 행 : 물품 번호 (0 ~ 99)
 *   - 열 : 저장 위치 (1 ~ 10)
 *   - 값 : 재고 수량
 *
 * 1 차원 버전(InventoryArray1D)과 비교
 *
 *   1 차원 : stock[위치 - 1] = 물품 번호            → 한 위치에 물품 "한 종류" 만, 수량 개념 없음
 *   2 차원 : stock[물품 번호][위치 - 1] = 수량       → 한 위치에 여러 물품을, 여러 개씩 저장 가능
 *
 *              위치1 위치2 ... 위치10
 *     물품 0  [  0     0   ...   0  ]
 *     물품 1  [  0     5   ...   0  ]   ← 물품 1 이 위치 2 에 5 개
 *       ...
 *     물품 99 [  0     0   ...   3  ]
 *
 * 포인트
 *  - int[][] stock = new int[100][10];  행 100 개(물품) × 열 10 개(위치), 모두 0 으로 시작.
 *  - 값이 "수량" 이 되니 0 = 없음 이 자연스럽다. 1 차원 버전의 ⚠ (물품 0 과 빈 칸 구분 불가) 이 사라진다.
 *  - 입고 : stock[p][loc] += 수량,  출고 : 수량이 충분할 때만 stock[p][loc] -= 수량
 *  - 재고 현황 : 수량이 하나라도 있는 행(물품)만 출력. 행마다 합계도 계산 (과제 2번의 행 합계와 같은 패턴).
 *  - 범위 검사 메소드 isValid 를 두어 ArrayIndexOutOfBoundsException 을 막는다.
 *
 * 실행 예
 *  ==============================
 *  입고 (i)
 *  출고 (o)
 *  재고 (s)
 *  종료 (q)
 *  ==============================
 *  select menu ('i', 'o', 's' or 'q') : i
 *  물품 번호(0~99), 저장 위치(1~10), 수량을 입력하세요 : 3 2 5
 *  물품 3 을 위치 2 에 5 개 입고했습니다.
 *  ...
 *  select menu ('i', 'o', 's' or 'q') : o
 *  물품 번호(0~99), 저장 위치(1~10), 수량을 입력하세요 : 3 2 2
 *  물품 3 을 위치 2 에서 2 개 출고했습니다.
 *  ...
 *  select menu ('i', 'o', 's' or 'q') : s
 *  물품	위치1	위치2	위치3	위치4	위치5	위치6	위치7	위치8	위치9	위치10	합계
 *  3	0	3	0	0	0	0	0	0	0	0	3
 *  ...
 *  select menu ('i', 'o', 's' or 'q') : q
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
