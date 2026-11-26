import java.util.Scanner;

/**
 * [5강 과제] 배열(2) - 1번 문제 (출발점 : 실습 배열(2) 5번 문제의 1차원 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class InventoryArray1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] stock = new int[10];
        char menu;
        int product, location;

        while (true) {
            System.out.println("==============================");
            System.out.println("입고 (i)");
            System.out.println("출고 (o)");
            System.out.println("재고 (s)");
            System.out.println("종료 (q)");
            System.out.println("==============================");
            System.out.print("select menu ('i', 'o', 's' or 'q') : ");
            menu = sc.next().charAt(0);

            if (menu == 'i') {          // 입고
                System.out.print("물품 번호 (0~99)와 저장 위치(1~10)를 같이 입력하세요 : ");
                product = sc.nextInt();
                location = sc.nextInt();
                stock[location - 1] = product;
            }
            else if (menu == 'o') {     // 출고
                System.out.print("물품 번호 (0~99)를 입력하세요 : ");
                product = sc.nextInt();
                for (int i = 0; i < 10; i++) {
                    if (stock[i] == product) {
                        stock[i] = 0;
                        break;
                    }
                }
            }
            else if (menu == 's') {     // 재고 현황
                for (int i = 0; i < 10; i++) {
                    System.out.print("위치 " + (i + 1) + " : ");
                    if (stock[i] != 0) {
                        System.out.println(stock[i]);
                    } else {
                        System.out.println();
                    }
                }
            }
            else if (menu == 'q') {     // 종료
                break;
            }
        }
        sc.close();
    }
}
