import java.util.Scanner;

/**
 * [5강 과제] 배열(2) - 1번 문제 (실습 5번 1차원 버전의 리팩터링 버전)
 *
 * InventoryArray1D.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점
 *  - 상수 : LOCATION_COUNT(10), MIN_PRODUCT_NUMBER(0), MAX_PRODUCT_NUMBER(99)
 *  - 빈 칸 표시를 0 → -1 로 변경 (java.util.Arrays.fill 로 배열 전체를 -1 로 채움)
 *    → 원래 코드의 ⚠ "물품 번호 0 을 저장할 수 없음" 을 해결.
 *  - 기능별 메소드로 분리 : printMenu, receiveProduct(입고), shipProduct(출고), printInventory(재고)
 *    main 은 메뉴를 읽고 switch 로 나눠 주기만 한다.
 *  - 메뉴 입력을 String 으로 받아 길이 1 인지 검사, Character.toLowerCase 로 대문자 'I' 도 허용.
 *  - 정수가 아닌 입력 검사 : scanner.hasNextInt() 가 false 면 scanner.next() 로 잘못된 토큰을 버리고 return.
 *    (버리지 않으면 같은 토큰이 계속 남아 있어 다음 입력도 실패한다.)
 *  - 범위 검사 : 물품 번호 0 ~ 99, 저장 위치 1 ~ 10.  → ArrayIndexOutOfBoundsException 방지.
 *  - 이미 물품이 있는 위치면 "해당 위치에 이미 물품이 있습니다." → 덮어쓰기 방지.
 *  - 출고 성공 시 위치 안내, 없으면 "해당 물품이 재고에 없습니다."
 *  - 재고 현황에서 빈 칸은 "비어 있음" 으로 표시.
 *  - 'q' 는 break 대신 return (switch 안의 break 는 switch 만 빠져나가므로 while 을 끝낼 수 없다).
 *  - try-with-resources 로 Scanner 자동 닫기.
 *
 * 💡 메소드에 배열을 넘기면 "참조" 가 넘어간다. receiveProduct 안에서 productNumbers[index] 를 바꾸면
 *    main 의 배열도 바뀐다. (5-1 강의 참조 타입 / 5-3 강의 배열 복사 참고)
 * 💡 여전히 1 차원 배열이다. 과제가 요구한 2 차원 확장은 💡 InventoryArray2D.java 참고.
 *
 * 실행 예
 *  ==============================
 *  입고 (i)
 *  출고 (o)
 *  재고 (s)
 *  종료 (q)
 *  ==============================
 *  메뉴를 선택하세요 (i, o, s, q): i
 *  물품 번호(0~99)와 저장 위치(1~10)를 입력하세요: 1 5
 *  입고했습니다.
 *  ...
 *  메뉴를 선택하세요 (i, o, s, q): s
 *  위치 1 : 비어 있음
 *  ...
 *  위치 5 : 1
 *  ...
 *  메뉴를 선택하세요 (i, o, s, q): o
 *  출고할 물품 번호(0~99)를 입력하세요: 1
 *  위치 5에서 출고했습니다.
 *  ...
 *  메뉴를 선택하세요 (i, o, s, q): q
 */
public class InventoryArray1DRefactored {

    private static final int LOCATION_COUNT = 10;
    private static final int MIN_PRODUCT_NUMBER = 0;
    private static final int MAX_PRODUCT_NUMBER = 99;

    public static void main(String[] args) {
        // -1은 비어 있는 위치를 나타냅니다. 따라서 상품 번호 0도 저장할 수 있습니다.
        int[] productNumbers = new int[LOCATION_COUNT];
        java.util.Arrays.fill(productNumbers, -1);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                printMenu();
                System.out.print("메뉴를 선택하세요 (i, o, s, q): ");
                String input = scanner.next();

                // 대소문자 입력을 모두 허용하고, 한 글자 메뉴만 처리합니다.
                if (input.length() != 1) {
                    System.out.println("메뉴는 한 글자로 입력해 주세요.");
                    continue;
                }

                char menu = Character.toLowerCase(input.charAt(0));

                switch (menu) {
                    case 'i':
                        receiveProduct(scanner, productNumbers);
                        break;
                    case 'o':
                        shipProduct(scanner, productNumbers);
                        break;
                    case 's':
                        printInventory(productNumbers);
                        break;
                    case 'q':
                        return;
                    default:
                        System.out.println("지원하지 않는 메뉴입니다.");
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("==============================");
        System.out.println("입고 (i)");
        System.out.println("출고 (o)");
        System.out.println("재고 (s)");
        System.out.println("종료 (q)");
        System.out.println("==============================");
    }

    private static void receiveProduct(Scanner scanner, int[] productNumbers) {
        System.out.print("물품 번호(0~99)와 저장 위치(1~10)를 입력하세요: ");

        if (!scanner.hasNextInt()) {
            System.out.println("물품 번호는 정수로 입력해 주세요.");
            scanner.next();
            return;
        }
        int productNumber = scanner.nextInt();

        if (!scanner.hasNextInt()) {
            System.out.println("저장 위치는 정수로 입력해 주세요.");
            scanner.next();
            return;
        }
        int location = scanner.nextInt();

        if (productNumber < MIN_PRODUCT_NUMBER || productNumber > MAX_PRODUCT_NUMBER) {
            System.out.println("물품 번호는 0부터 99 사이여야 합니다.");
            return;
        }

        if (location < 1 || location > productNumbers.length) {
            System.out.println("저장 위치는 1부터 " + productNumbers.length + " 사이여야 합니다.");
            return;
        }

        int index = location - 1;
        if (productNumbers[index] != -1) {
            System.out.println("해당 위치에 이미 물품이 있습니다.");
            return;
        }

        productNumbers[index] = productNumber;
        System.out.println("입고했습니다.");
    }

    private static void shipProduct(Scanner scanner, int[] productNumbers) {
        System.out.print("출고할 물품 번호(0~99)를 입력하세요: ");

        if (!scanner.hasNextInt()) {
            System.out.println("물품 번호는 정수로 입력해 주세요.");
            scanner.next();
            return;
        }
        int productNumber = scanner.nextInt();

        if (productNumber < MIN_PRODUCT_NUMBER || productNumber > MAX_PRODUCT_NUMBER) {
            System.out.println("물품 번호는 0부터 99 사이여야 합니다.");
            return;
        }

        for (int index = 0; index < productNumbers.length; index++) {
            if (productNumbers[index] == productNumber) {
                productNumbers[index] = -1;
                System.out.println("위치 " + (index + 1) + "에서 출고했습니다.");
                return;
            }
        }

        System.out.println("해당 물품이 재고에 없습니다.");
    }

    private static void printInventory(int[] productNumbers) {
        for (int index = 0; index < productNumbers.length; index++) {
            System.out.print("위치 " + (index + 1) + " : ");
            if (productNumbers[index] == -1) {
                System.out.println("비어 있음");
            } else {
                System.out.println(productNumbers[index]);
            }
        }
    }
}
