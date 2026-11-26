import java.util.Scanner;

/**
 * [5강 과제] 배열(2) - 1번 문제 (실습 5번 1차원 버전의 리팩터링 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
