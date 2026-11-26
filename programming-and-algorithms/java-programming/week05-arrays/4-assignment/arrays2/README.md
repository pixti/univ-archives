# 5주차 과제 · arrays2

[🏠 5주차 학습 가이드](../../README.md)

| 파일 | 내용 |
|---|---|
| [InventoryArray1D.java](#5-재고-관리-1차원-과제-배열2-1번의-출발점이라-과제-폴더에-있음) | 5. 재고 관리 (1차원). 과제 배열(2) 1번의 출발점이라 과제 폴더에 있음 |
| [InventoryArray1DRefactored.java](#배열2---1번-문제-실습-5번-1차원-버전의-리팩터링-버전) | 배열(2) - 1번 문제 (실습 5번 1차원 버전의 리팩터링 버전) |
| [InventoryArray2D.java](#배열2---1번-문제---참고-답안-직접-작성하지-않은-부분) | 배열(2) - 1번 문제  💡 참고 답안 (직접 작성하지 않은 부분) |
| [MatrixMultiply.java](#배열2---4번-문제) | 배열(2) - 4번 문제 |
| [MatrixMultiplyRefactored.java](#배열2---4번-문제-리팩터링-버전) | 배열(2) - 4번 문제 (리팩터링 버전) |
| [RowColumnSum.java](#배열2---2번-문제) | 배열(2) - 2번 문제 |
| [RowColumnSumRefactored.java](#배열2---2번-문제-리팩터링-버전) | 배열(2) - 2번 문제 (리팩터링 버전) |
| [Transpose.java](#배열2---3번-문제) | 배열(2) - 3번 문제 |
| [TransposeRefactored.java](#배열2---3번-문제-리팩터링-버전) | 배열(2) - 3번 문제 (리팩터링 버전) |

---

## 5. 재고 관리 (1차원). 과제 배열(2) 1번의 출발점이라 과제 폴더에 있음

`5강 과제` · 📄 [`InventoryArray1D.java`](InventoryArray1D.java)

#### 문제

> (과제 문제) 실습 5번의 재고 관리 프로그램을 2 차원 배열로 확장하시오.
>
>   - 행 : 물품 번호,  열 : 저장 위치,  값 : 재고 수량
>
> (실습 5번 문제) 물품 번호(0 \~ 99)를 저장 위치(1 \~ 10)에 입고 / 출고 / 재고 현황을 보여주는 프로그램.<br>입고 (i)<br>출고 (o)<br>재고 (s)<br>종료 (q)<br>select menu ('i', 'o', 's' or 'q') :
>
> 이 파일은 "실습 5번 1차원 버전" 이다.
>
>   - 2 차원 확장은 작성하지 않았다. → 💡 참고 답안 InventoryArray2D.java
>   - 리팩터링 버전 → InventoryArray1DRefactored.java

#### 💻 코드

<!-- code: InventoryArray1D.java -->
```java
import java.util.Scanner;

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
```
<!-- /code -->

#### 실행 예

```text
==============================
입고 (i)
출고 (o)
재고 (s)
종료 (q)
==============================
select menu ('i', 'o', 's' or 'q') : i
물품 번호 (0~99)와 저장 위치(1~10)를 같이 입력하세요 : 4 1
...
select menu ('i', 'o', 's' or 'q') : s
위치 1 : 4
위치 2 :
...
위치 10 :
...
select menu ('i', 'o', 's' or 'q') : o
물품 번호 (0~99)를 입력하세요 : 4
...
select menu ('i', 'o', 's' or 'q') : q
```

**포인트**

- stock\[위치 - 1] = 물품 번호  : 배열의 "인덱스" 가 저장 위치, "값" 이 물품 번호.<br>(사람의 위치 1 \~ 10 ↔ 인덱스 0 \~ 9 → location - 1. DaysInMonth 의 month - 1 과 같다.)
- 빈 칸은 0 으로 표시 (new int\[10] 의 기본값이 0 이라 따로 초기화하지 않아도 됨).
- 출고 : 배열을 처음부터 훑어(순차 탐색) 같은 물품 번호를 찾으면 0 으로 비우고 break.
- while (true) + 'q' 에서 break : 메뉴형 프로그램의 기본 틀. (4주차 반복문)

- ⚠ 0 을 "빈 칸" 으로 쓰는데 물품 번호 0 도 유효한 값이다.<br>→ 물품 0 을 입고하면 재고 현황에 빈 칸으로 보이고, 출고(0)하면 빈 칸이 "출고" 된다.<br>→ 리팩터링 버전은 -1 을 빈 칸으로 써서 해결했다. (Arrays.fill(productNumbers, -1))
- ⚠ 범위 검사가 없다. 위치 0 이나 11 을 넣으면 ArrayIndexOutOfBoundsException.
- ⚠ 이미 물품이 있는 위치에 입고하면 기존 물품을 덮어쓴다.
- ⚠ 출고할 물품이 없어도 아무 안내가 없다.
- 💡 if-else if 사슬은 switch (menu) { case 'i': ... } 로 바꿔도 된다. (리팩터링 버전)

## 배열(2) - 1번 문제 (실습 5번 1차원 버전의 리팩터링 버전)

`5강 과제` · 📄 [`InventoryArray1DRefactored.java`](InventoryArray1DRefactored.java)

#### 문제

> InventoryArray1D.java 를 리팩터링한 코드.

#### 💻 코드

<!-- code: InventoryArray1DRefactored.java -->
```java
import java.util.Scanner;

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
```
<!-- /code -->

#### 실행 예

```text
==============================
입고 (i)
출고 (o)
재고 (s)
종료 (q)
==============================
메뉴를 선택하세요 (i, o, s, q): i
물품 번호(0~99)와 저장 위치(1~10)를 입력하세요: 1 5
입고했습니다.
...
메뉴를 선택하세요 (i, o, s, q): s
위치 1 : 비어 있음
...
위치 5 : 1
...
메뉴를 선택하세요 (i, o, s, q): o
출고할 물품 번호(0~99)를 입력하세요: 1
위치 5에서 출고했습니다.
...
메뉴를 선택하세요 (i, o, s, q): q
```

**바뀐 점**

- 상수 : LOCATION\_COUNT(10), MIN\_PRODUCT\_NUMBER(0), MAX\_PRODUCT\_NUMBER(99)
- 빈 칸 표시를 0 → -1 로 변경 (java.util.Arrays.fill 로 배열 전체를 -1 로 채움)<br>→ 원래 코드의 ⚠ "물품 번호 0 을 저장할 수 없음" 을 해결.
- 기능별 메소드로 분리 : printMenu, receiveProduct(입고), shipProduct(출고), printInventory(재고)<br>main 은 메뉴를 읽고 switch 로 나눠 주기만 한다.
- 메뉴 입력을 String 으로 받아 길이 1 인지 검사, Character.toLowerCase 로 대문자 'I' 도 허용.
- 정수가 아닌 입력 검사 : scanner.hasNextInt() 가 false 면 scanner.next() 로 잘못된 토큰을 버리고 return.<br>(버리지 않으면 같은 토큰이 계속 남아 있어 다음 입력도 실패한다.)
- 범위 검사 : 물품 번호 0 \~ 99, 저장 위치 1 \~ 10.  → ArrayIndexOutOfBoundsException 방지.
- 이미 물품이 있는 위치면 "해당 위치에 이미 물품이 있습니다." → 덮어쓰기 방지.
- 출고 성공 시 위치 안내, 없으면 "해당 물품이 재고에 없습니다."
- 재고 현황에서 빈 칸은 "비어 있음" 으로 표시.
- 'q' 는 break 대신 return (switch 안의 break 는 switch 만 빠져나가므로 while 을 끝낼 수 없다).
- try-with-resources 로 Scanner 자동 닫기.

- 💡 메소드에 배열을 넘기면 "참조" 가 넘어간다. receiveProduct 안에서 productNumbers\[index] 를 바꾸면 main 의 배열도 바뀐다. (5-1 강의 참조 타입 / 5-3 강의 배열 복사 참고)
- 💡 여전히 1 차원 배열이다. 과제가 요구한 2 차원 확장은 💡 InventoryArray2D.java 참고.

## 배열(2) - 1번 문제  💡 참고 답안 (직접 작성하지 않은 부분)

`5강 과제` · 📄 [`InventoryArray2D.java`](InventoryArray2D.java)

#### 문제

> 실습 5번의 재고 관리 프로그램을 2 차원 배열로 확장하시오.
>
>   - 행 : 물품 번호 (0 \~ 99)
>   - 열 : 저장 위치 (1 \~ 10)
>   - 값 : 재고 수량

#### 💻 코드

<!-- code: InventoryArray2D.java -->
```java
import java.util.Scanner;

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
```
<!-- /code -->

#### 실행 예

```text
==============================
입고 (i)
출고 (o)
재고 (s)
종료 (q)
==============================
select menu ('i', 'o', 's' or 'q') : i
물품 번호(0~99), 저장 위치(1~10), 수량을 입력하세요 : 3 2 5
물품 3 을 위치 2 에 5 개 입고했습니다.
...
select menu ('i', 'o', 's' or 'q') : o
물품 번호(0~99), 저장 위치(1~10), 수량을 입력하세요 : 3 2 2
물품 3 을 위치 2 에서 2 개 출고했습니다.
...
select menu ('i', 'o', 's' or 'q') : s
물품	위치1	위치2	위치3	위치4	위치5	위치6	위치7	위치8	위치9	위치10	합계
3	0	3	0	0	0	0	0	0	0	0	3
...
select menu ('i', 'o', 's' or 'q') : q
```

**1 차원 버전(InventoryArray1D)과 비교**

```text
1 차원 : stock[위치 - 1] = 물품 번호            → 한 위치에 물품 "한 종류" 만, 수량 개념 없음
2 차원 : stock[물품 번호][위치 - 1] = 수량       → 한 위치에 여러 물품을, 여러 개씩 저장 가능
```

위치1 위치2 ... 위치10

```text
물품 0  [  0     0   ...   0  ]
물품 1  [  0     5   ...   0  ]   ← 물품 1 이 위치 2 에 5 개
  ...
물품 99 [  0     0   ...   3  ]
```

**포인트**

- int\[]\[] stock = new int\[100]\[10];  행 100 개(물품) × 열 10 개(위치), 모두 0 으로 시작.
- 값이 "수량" 이 되니 0 = 없음 이 자연스럽다. 1 차원 버전의 ⚠ (물품 0 과 빈 칸 구분 불가) 이 사라진다.
- 입고 : stock\[p]\[loc] += 수량,  출고 : 수량이 충분할 때만 stock\[p]\[loc] -= 수량
- 재고 현황 : 수량이 하나라도 있는 행(물품)만 출력. 행마다 합계도 계산 (과제 2번의 행 합계와 같은 패턴).
- 범위 검사 메소드 isValid 를 두어 ArrayIndexOutOfBoundsException 을 막는다.

## 배열(2) - 4번 문제

`5강 과제` · 📄 [`MatrixMultiply.java`](MatrixMultiply.java)

#### 문제

> 임의 크기의 두 행렬을 곱하는 프로그램을 작성하시오.
>
> - 행렬의 크기는 입력받고, 각 원소는 0 \~ 99 사이의 난수로 채운다.
> - 곱할 수 없는 크기이면 "행렬 곱을 할 수 없는 크기입니다!!!" 를 출력한다.

#### 💻 코드

<!-- code: MatrixMultiply.java -->
```java
import java.util.Random;
import java.util.Scanner;

public class MatrixMultiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int r1, c1, r2, c2;
        int i, j, k;

        System.out.print("첫 번째 행렬의 크기 ? ");
        r1 = sc.nextInt();
        c1 = sc.nextInt();

        System.out.print("두 번째 행렬의 크기 ? ");
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        // 행렬의 곱셈이 가능한지 확인
        if (c1 != r2) {
            System.out.println("행렬 곱을 할 수 없는 크기입니다!!!");
        }
        else {
            int[][] matrix1 = new int[r1][c1];
            int[][] matrix2 = new int[r2][c2];
            int[][] result = new int[r1][c2];

            // 첫 번째 행렬 생성
            System.out.println("첫 번째 행렬 :");
            for (i = 0; i < r1; i++) {
                for (j = 0; j < c1; j++) {
                    matrix1[i][j] = rnd.nextInt(100);
                    System.out.print(matrix1[i][j] + "\t");
                }
                System.out.println();
            }

            // 두 번째 행렬 생성
            System.out.println("두 번째 행렬 :");
            for (i = 0; i < r2; i++) {
                for (j = 0; j < c2; j++) {
                    matrix2[i][j] = rnd.nextInt(100);
                    System.out.print(matrix2[i][j] + "\t");
                }
                System.out.println();
            }

            // 행렬 곱셈
            for (i = 0; i < r1; i++) {
                for (j = 0; j < c2; j++) {
                    result[i][j] = 0;
                    for (k = 0; k < c1; k++) {
                        result[i][j] = result[i][j] + matrix1[i][k] * matrix2[k][j];
                    }
                }
            }

            // 결과 행렬 출력
            System.out.println("결과 행렬 :");
            for (i = 0; i < r1; i++) {
                for (j = 0; j < c2; j++) {
                    System.out.print(result[i][j] + "\t");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
```
<!-- /code -->

#### 실행 예

```text
첫 번째 행렬의 크기 ? 2 3
두 번째 행렬의 크기 ? 3 2
첫 번째 행렬 :
54	46	47
2	36	89
두 번째 행렬 :
8	69
11	9
30	47
결과 행렬 :
2348	6349
3082	4645

첫 번째 행렬의 크기 ? 2 3
두 번째 행렬의 크기 ? 2 3
행렬 곱을 할 수 없는 크기입니다!!!
```

**포인트**

- 곱셈 가능 조건 : (r1 × c1) · (r2 × c2) 에서 c1 == r2.  결과 크기는 r1 × c2.<br>(2 × 3) · (3 × 2) = (2 × 2)
  ```text
  └─┬─┘
  ```<br>같아야 함
- 결과의 한 칸 = 첫 번째 행렬의 i 행 과 두 번째 행렬의 j 열 을 하나씩 곱해 모두 더한 값.<br>result\[i]\[j] = Σ (k = 0 \~ c1-1)  matrix1\[i]\[k] \* matrix2\[k]\[j]<br>→ for 가 3 겹. i(결과의 행), j(결과의 열), k(곱해서 더할 짝).
- 실행 예 검산 : result\[0]\[0] = 54\*8 + 46\*11 + 47\*30 = 432 + 506 + 1410 = 2348
- rnd.nextInt(100) : 0 이상 100 미만 = 0 \~ 99.  (Math.random() \* 100 을 int 로 바꾼 것과 같은 범위)
- 크기를 확인한 "다음에" 배열을 만든다. 크기를 입력받아야 new int\[r1]\[c1] 을 할 수 있다.

- 💡 result\[i]\[j] = 0; 은 없어도 된다. new int\[]\[] 는 0 으로 채워져 있다. (명시적으로 적어 두면 의도가 보인다)
- 💡 0 이나 음수 크기를 넣으면 new int\[-1]\[..] 에서 NegativeArraySizeException.<br>→ 리팩터링 버전은 양수인지 먼저 검사한다.
- 💡 난수라 실행할 때마다 행렬 값이 다르다. 아래 실행 예는 한 번 실행한 결과.

## 배열(2) - 4번 문제 (리팩터링 버전)

`5강 과제` · 📄 [`MatrixMultiplyRefactored.java`](MatrixMultiplyRefactored.java)

#### 문제

> MatrixMultiply.java 를 리팩터링한 코드.

#### 💻 코드

<!-- code: MatrixMultiplyRefactored.java -->
```java
import java.util.Random;
import java.util.Scanner;

public class MatrixMultiplyRefactored {

    private static final int MAX_RANDOM_VALUE = 100;

    public static void main(String[] args) {
        // Scanner를 자동으로 닫아 입력 자원을 정리합니다.
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("첫 번째 행렬의 크기(행 열): ");
            int firstRows = scanner.nextInt();
            int firstColumns = scanner.nextInt();

            System.out.print("두 번째 행렬의 크기(행 열): ");
            int secondRows = scanner.nextInt();
            int secondColumns = scanner.nextInt();

            // 배열을 만들기 전에 크기가 양수인지 확인합니다.
            if (firstRows <= 0 || firstColumns <= 0 || secondRows <= 0 || secondColumns <= 0) {
                System.out.println("행과 열의 크기는 모두 양수여야 합니다.");
                return;
            }

            // 첫 번째 행렬의 열 수와 두 번째 행렬의 행 수가 같아야 곱할 수 있습니다.
            if (firstColumns != secondRows) {
                System.out.println("행렬 곱을 할 수 없는 크기입니다.");
                return;
            }

            Random random = new Random();
            int[][] firstMatrix = createRandomMatrix(firstRows, firstColumns, random);
            int[][] secondMatrix = createRandomMatrix(secondRows, secondColumns, random);

            System.out.println("첫 번째 행렬:");
            printMatrix(firstMatrix);

            System.out.println("두 번째 행렬:");
            printMatrix(secondMatrix);

            int[][] productMatrix = multiplyMatrices(firstMatrix, secondMatrix);

            System.out.println("결과 행렬:");
            printMatrix(productMatrix);
        }
    }

    // 지정한 크기의 행렬을 0부터 99 사이의 난수로 채웁니다.
    private static int[][] createRandomMatrix(int rows, int columns, Random random) {
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = random.nextInt(MAX_RANDOM_VALUE);
            }
        }

        return matrix;
    }

    // 행렬 곱셈을 계산합니다.
    private static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int rows = firstMatrix.length;
        int sharedDimension = firstMatrix[0].length;
        int columns = secondMatrix[0].length;
        int[][] product = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                for (int inner = 0; inner < sharedDimension; inner++) {
                    product[row][column] += firstMatrix[row][inner] * secondMatrix[inner][column];
                }
            }
        }

        return product;
    }

    // 행렬을 행 단위로 출력합니다.
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
```
<!-- /code -->

#### 실행 예  (난수라 매번 다름)

```text
첫 번째 행렬의 크기(행 열): 4 3
두 번째 행렬의 크기(행 열): 3 4
첫 번째 행렬:
... (4 × 3)
두 번째 행렬:
... (3 × 4)
결과 행렬:
... (4 × 4)

첫 번째 행렬의 크기(행 열): 2 3
두 번째 행렬의 크기(행 열): 2 3
행렬 곱을 할 수 없는 크기입니다.
```

**바뀐 점**

- 상수 MAX\_RANDOM\_VALUE = 100 (난수 범위 0 \~ 99)
- try-with-resources 로 Scanner 자동 닫기
- 변수 이름 r1, c1, r2, c2 → firstRows, firstColumns, secondRows, secondColumns
- 양수 크기 검사 추가 : 0 이나 음수면 "행과 열의 크기는 모두 양수여야 합니다." 후 종료<br>(원래 코드는 음수 크기면 NegativeArraySizeException)
- if-else 대신 "조건이 안 맞으면 바로 return" (early return) → else 블록의 들여쓰기가 사라진다.
- 기능별 메소드 분리<br>createRandomMatrix(rows, columns, random) : 난수 행렬 생성
  ```text
  multiplyMatrices(first, second)           : 행렬 곱셈 → 결과 배열을 return
  printMatrix(matrix)                       : 출력 (세 번 반복되던 출력 코드를 하나로)
  ```<br>→ 원래 코드는 "생성하면서 출력" 했는데, 생성과 출력을 분리했다.
- 곱셈의 공통 크기(c1 == r2)를 sharedDimension 이라는 이름으로 표현.
- 메소드는 배열의 length 로 크기를 알아낸다. 크기를 따로 넘길 필요가 없다.

- 💡 메소드가 int\[]\[] 를 return 할 수 있다. 메소드 안에서 new 로 만든 배열의 참조가 돌아온다.
- 💡 product\[row]\[column] += ... : new int\[]\[] 가 0 으로 시작하므로 = 0 초기화 없이 바로 누적.

## 배열(2) - 2번 문제

`5강 과제` · 📄 [`RowColumnSum.java`](RowColumnSum.java)

#### 문제

> 다음 표를 2 차원 배열에 저장한 뒤, 각 행의 합계와 각 열의 합계를 출력하는 프로그램을 작성하시오.
>
> 12  56  32  16  98
>
> ```text
> 99  56  34  41   3
> 65   3  87  78  21
> ```

#### 💻 코드

<!-- code: RowColumnSum.java -->
```java
public class RowColumnSum {
    public static void main(String[] args) {
        int[][] arr = {
                {12, 56, 32, 16, 98},
                {99, 56, 34, 41, 3},
                {65, 3, 87, 78, 21}
        };
        int row, col;
        int sum;

        // 각 행의 합계
        for (row = 0; row < arr.length; row++) {
            sum = 0;
            for (col = 0; col < arr[row].length; col++) {
                sum = sum + arr[row][col];
            }
            System.out.println((row + 1) + "번째 행의 합계 : " + sum);
        }

        // 각 열의 합계
        for (col = 0; col < arr[0].length; col++) {
            sum = 0;
            for (row = 0; row < arr.length; row++) {
                sum = sum + arr[row][col];
            }
            System.out.println((col + 1) + "번째 열의 합계 : " + sum);
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
1번째 행의 합계 : 214
2번째 행의 합계 : 233
3번째 행의 합계 : 254
1번째 열의 합계 : 176
2번째 열의 합계 : 115
3번째 열의 합계 : 153
4번째 열의 합계 : 135
5번째 열의 합계 : 122
```

**포인트**

- 행 합계 : 바깥 for = 행, 안쪽 for = 열.  행이 바뀔 때마다 sum = 0 으로 다시 시작.
- 열 합계 : 바깥 for = 열, 안쪽 for = 행.  두 for 의 순서만 바꾸면 된다.
- arr.length       = 행의 수 (3)<br>arr\[row].length  = row 번째 행의 열 수 (5)
  ```text
  arr[0].length    = 열 합계에서 "열의 수" 로 사용 (모든 행의 길이가 같다고 가정)
  ```
- sum = 0 위치가 핵심. 바깥 for 안, 안쪽 for 바로 앞에 둬야 행(열)마다 따로 더해진다.<br>for 밖에 두면 누적 합이 되어 2 번째 행부터 값이 틀린다.

```text
    열 →   0   1   2   3   4  | 행 합계
행 0      12  56  32  16  98  |  214
행 1      99  56  34  41   3  |  233
행 2      65   3  87  78  21  |  254
───────────────────────────────
```

열 합계  176 115 153 135 122

- 💡 arr\[0].length 는 모든 행의 길이가 같을 때만 맞다. 행마다 길이가 다른 배열(5-3 강의 비정방형 배열)이면 리팩터링 버전처럼 가장 긴 행의 길이를 구하고, 짧은 행은 건너뛰어야 한다.

## 배열(2) - 2번 문제 (리팩터링 버전)

`5강 과제` · 📄 [`RowColumnSumRefactored.java`](RowColumnSumRefactored.java)

#### 문제

> RowColumnSum.java 를 리팩터링한 코드.

#### 💻 코드

<!-- code: RowColumnSumRefactored.java -->
```java
public class RowColumnSumRefactored {
    public static void main(String[] args) {
        int[][] values = {
                {12, 56, 32, 16, 98},
                {99, 56, 34, 41, 3},
                {65, 3, 87, 78, 21}
        };

        // 각 행의 합계를 계산합니다.
        for (int row = 0; row < values.length; row++) {
            int rowSum = 0;
            for (int value : values[row]) {
                rowSum += value;
            }
            System.out.println((row + 1) + "번째 행의 합계: " + rowSum);
        }

        // 가장 긴 행의 길이를 구합니다.
        // Java의 2차원 배열은 행마다 길이가 다를 수 있습니다.
        int columnCount = 0;
        for (int[] rowValues : values) {
            columnCount = Math.max(columnCount, rowValues.length);
        }

        // 각 열의 합계를 계산합니다. 해당 열이 없는 행은 건너뜁니다.
        for (int column = 0; column < columnCount; column++) {
            int columnSum = 0;
            for (int[] rowValues : values) {
                if (column < rowValues.length) {
                    columnSum += rowValues[column];
                }
            }
            System.out.println((column + 1) + "번째 열의 합계: " + columnSum);
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
1번째 행의 합계: 214
2번째 행의 합계: 233
3번째 행의 합계: 254
1번째 열의 합계: 176
2번째 열의 합계: 115
3번째 열의 합계: 153
4번째 열의 합계: 135
5번째 열의 합계: 122
```

**바뀐 점**

- 변수 이름 arr, sum → values, rowSum / columnSum
- 반복 변수를 for 안에서 선언 (int row = 0 ...) : 쓰는 범위가 반복문 안으로 좁아진다.
- 행 합계를 향상된 for(for-each) 로 : for (int value : values\[row])
- sum = sum + x → rowSum += x
- 행마다 길이가 다른 배열(비정방형, jagged)도 처리
    1) 가장 긴 행의 길이를 columnCount 로 구한다 (Math.max)
    2) 열 합계를 구할 때 그 열이 없는 짧은 행은 건너뛴다 (column &lt; rowValues.length)

→ 원래 코드는 arr\[0].length 를 열의 수로 써서, 0 번 행보다 짧은 행이 있으면 예외가 난다.

- 💡 for (int\[] rowValues : values) : 2 차원 배열을 for-each 로 돌면 꺼내지는 것은 "행(1차원 배열)" 이다.<br>(5-3 강의 2 차원 배열 = 1 차원 배열의 배열)

## 배열(2) - 3번 문제

`5강 과제` · 📄 [`Transpose.java`](Transpose.java)

#### 문제

> 3 × 4 행렬을 입력받아 전치 행렬(행과 열을 바꾼 행렬)을 출력하는 프로그램을 작성하시오.
>
> (문제의 예시 화면)<br>행렬 입력<br>0번째 행 ? 1 2 3 0<br>1번째 행 ? 4 5 6 1<br>2번째 행 ? 7 8 9 0<br>전치 행렬<br>1 4 7<br>2 5 8<br>3 6 9<br>0 1 0

#### 💻 코드

<!-- code: Transpose.java -->
```java
public class Transpose {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 0},
                {4, 5, 6, 1},
                {7, 8, 9, 0}
        };
        int[][] transpose = new int[4][3];
        int row, col;

        // 전치 행렬 만들기
        for (row = 0; row < arr.length; row++) {
            for (col = 0; col < arr[row].length; col++) {
                transpose[col][row] = arr[row][col];
            }
        }

        // 원본 배열 출력
        System.out.println("원본 행렬");
        for (row = 0; row < arr.length; row++) {
            for (col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + "\t");
            }
            System.out.println();
        }

        // 전치 행렬 출력
        System.out.println();
        System.out.println("전치 행렬");
        for (row = 0; row < transpose.length; row++) {
            for (col = 0; col < transpose[row].length; col++) {
                System.out.print(transpose[row][col] + "\t");
            }
            System.out.println();
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
원본 행렬
1	2	3	0
4	5	6	1
7	8	9	0

전치 행렬
1	4	7
2	5	8
3	6	9
0	1	0
```

#### 📒 해설

- 📝 필기 : 핵심은 딱 이 부분입니다
  ```java
  transpose[col][row] = arr[row][col];
  ```<br>예를 들어<br>arr\[0]\[0] → transpose\[0]\[0]<br>arr\[0]\[1] → transpose\[1]\[0]<br>arr\[0]\[2] → transpose\[2]\[0]<br>arr\[0]\[3] → transpose\[3]\[0]<br>즉 원본의 \[행]\[열] 을 전치 배열에서는 \[열]\[행] 으로 뒤집어서 저장하는 것입니다.<br>따라서 3×4 배열이 전치되면 4×3 배열이 됩니다.

```text
원본 (3 × 4)            전치 (4 × 3)
1  2  3  0              1  4  7
4  5  6  1      →       2  5  8
7  8  9  0              3  6  9
                        0  1  0
```

→ 원본의 0 번째 "행" 이 전치의 0 번째 "열" 이 된다.

**포인트**

- 전치 배열의 크기는 \[원본 열 수]\[원본 행 수] = new int\[4]\[3]. 크기를 반대로 잡아야 한다.
  ```text
  new int[3][4] 로 만들면 transpose[3][0] 에서 ArrayIndexOutOfBoundsException.
  ```
- 출력은 "\\t" (탭) 으로 칸을 맞춘다.

- ⚠ 문제는 행렬을 "입력받으라" 고 했는데(예시 화면의 "0번째 행 ?"), 이 코드는 배열을 코드에 직접 적었다.<br>입력으로 바꾸려면 아래처럼 Scanner 로 채우면 된다.
  ```java
  Scanner sc = new Scanner(System.in);
  int[][] arr = new int[3][4];
  System.out.println("행렬 입력");
  for (int row = 0; row < arr.length; row++) {
      System.out.print(row + "번째 행 ? ");
      for (int col = 0; col < arr[row].length; col++)
          arr[row][col] = sc.nextInt();
  }
  ```
- 💡 new int\[4]\[3] 의 4, 3 대신 new int\[arr\[0].length]\[arr.length] 로 쓰면 원본 크기가 바뀌어도 동작한다.<br>(리팩터링 버전이 그렇게 했다.)

## 배열(2) - 3번 문제 (리팩터링 버전)

`5강 과제` · 📄 [`TransposeRefactored.java`](TransposeRefactored.java)

#### 문제

> Transpose.java 를 리팩터링한 코드.

#### 💻 코드

<!-- code: TransposeRefactored.java -->
```java
public class TransposeRefactored {
    public static void main(String[] args) {
        int[][] originalMatrix = {
                {1, 2, 3, 0},
                {4, 5, 6, 1},
                {7, 8, 9, 0}
        };

        // 전치 행렬은 원본 행렬의 행과 열 수를 바꿔 생성합니다.
        int rowCount = originalMatrix.length;
        int columnCount = rowCount == 0 ? 0 : originalMatrix[0].length;
        int[][] transposedMatrix = new int[columnCount][rowCount];

        // 원본의 각 원소를 행과 열을 바꾼 위치에 저장합니다.
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < originalMatrix[row].length; column++) {
                transposedMatrix[column][row] = originalMatrix[row][column];
            }
        }

        System.out.println("원본 행렬");
        printMatrix(originalMatrix);

        System.out.println();
        System.out.println("전치 행렬");
        printMatrix(transposedMatrix);
    }

    // 행렬의 각 행을 한 줄씩 출력합니다.
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
```
<!-- /code -->

#### 실행 예

```text
원본 행렬
1	2	3	0
4	5	6	1
7	8	9	0

전치 행렬
1	4	7
2	5	8
3	6	9
0	1	0
```

**바뀐 점**

- 변수 이름 arr, transpose → originalMatrix, transposedMatrix
- 전치 배열 크기를 숫자 4, 3 대신 원본에서 계산 : new int\[columnCount]\[rowCount] rowCount == 0 ? 0 : originalMatrix\[0].length  → 행이 하나도 없으면 \[0] 에 접근하지 않는다. (조건 연산자)
- 똑같이 두 번 쓰던 출력 반복문을 printMatrix(int\[]\[]) 메소드 하나로 합침.<br>printMatrix 는 for-each 로 행 → 값 순서로 출력.

- ⚠ 행마다 길이가 다른 배열(jagged)에서 0 번 행보다 긴 행이 있으면,<br>columnCount 가 0 번 행 기준이라 transposedMatrix\[column] 에서 ArrayIndexOutOfBoundsException 이 난다.<br>(RowColumnSumRefactored 처럼 가장 긴 행의 길이를 구하면 해결. 단, 전치 행렬 자체가 직사각형 행렬을 전제한다.)
- ⚠ 문제가 요구한 "행렬 입력" 은 리팩터링 버전에도 없다. (Transpose.java 의 ⚠ 참고)

---

[🏠 5주차 학습 가이드](../../README.md)
