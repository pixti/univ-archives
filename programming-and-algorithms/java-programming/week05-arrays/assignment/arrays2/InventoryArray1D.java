import java.util.Scanner;

/**
 * [5강 과제] 배열(2) - 1번 문제 (출발점 : 실습 배열(2) 5번 문제의 1차원 버전)
 *
 * (과제 문제) 실습 5번의 재고 관리 프로그램을 2 차원 배열로 확장하시오.
 *   - 행 : 물품 번호,  열 : 저장 위치,  값 : 재고 수량
 *
 * (실습 5번 문제) 물품 번호(0 ~ 99)를 저장 위치(1 ~ 10)에 입고 / 출고 / 재고 현황을 보여주는 프로그램.
 *   ==============================
 *   입고 (i)
 *   출고 (o)
 *   재고 (s)
 *   종료 (q)
 *   ==============================
 *   select menu ('i', 'o', 's' or 'q') :
 *
 * 이 파일은 내가 작성한 "실습 5번 1차원 버전" 이다.
 *   - 2 차원 확장은 작성하지 않았다. → 💡 참고 답안 InventoryArray2D.java
 *   - AI 리팩터링 버전 → InventoryArray1DRefactored.java
 *
 * 포인트
 *  - stock[위치 - 1] = 물품 번호  : 배열의 "인덱스" 가 저장 위치, "값" 이 물품 번호.
 *    (사람의 위치 1 ~ 10 ↔ 인덱스 0 ~ 9 → location - 1. DaysInMonth 의 month - 1 과 같다.)
 *  - 빈 칸은 0 으로 표시 (new int[10] 의 기본값이 0 이라 따로 초기화하지 않아도 됨).
 *  - 출고 : 배열을 처음부터 훑어(순차 탐색) 같은 물품 번호를 찾으면 0 으로 비우고 break.
 *  - while (true) + 'q' 에서 break : 메뉴형 프로그램의 기본 틀. (4주차 반복문)
 *
 * ⚠ 0 을 "빈 칸" 으로 쓰는데 물품 번호 0 도 유효한 값이다.
 *   → 물품 0 을 입고하면 재고 현황에 빈 칸으로 보이고, 출고(0)하면 빈 칸이 "출고" 된다.
 *   → 리팩터링 버전은 -1 을 빈 칸으로 써서 해결했다. (Arrays.fill(productNumbers, -1))
 * ⚠ 범위 검사가 없다. 위치 0 이나 11 을 넣으면 ArrayIndexOutOfBoundsException.
 * ⚠ 이미 물품이 있는 위치에 입고하면 기존 물품을 덮어쓴다.
 * ⚠ 출고할 물품이 없어도 아무 안내가 없다.
 * 💡 if-else if 사슬은 switch (menu) { case 'i': ... } 로 바꿔도 된다. (리팩터링 버전)
 *
 * 실행 예
 *  ==============================
 *  입고 (i)
 *  출고 (o)
 *  재고 (s)
 *  종료 (q)
 *  ==============================
 *  select menu ('i', 'o', 's' or 'q') : i
 *  물품 번호 (0~99)와 저장 위치(1~10)를 같이 입력하세요 : 4 1
 *  ...
 *  select menu ('i', 'o', 's' or 'q') : s
 *  위치 1 : 4
 *  위치 2 :
 *  ...
 *  위치 10 :
 *  ...
 *  select menu ('i', 'o', 's' or 'q') : o
 *  물품 번호 (0~99)를 입력하세요 : 4
 *  ...
 *  select menu ('i', 'o', 's' or 'q') : q
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
