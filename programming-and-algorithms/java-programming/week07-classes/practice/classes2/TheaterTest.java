import java.util.Scanner;

/**
 * [7강 실습] 클래스(2) - 3번 문제 (영화관 좌석 예약 프로그램 - 실행 클래스 + 좌석 관리 클래스)
 *
 * 문제
 *  10행 8열 영화관의 좌석 예약 프로그램을 작성하시오.
 *   0. 예약 현황 표시  (■ 예약됨 / □ 빈 좌석)
 *   1. 예약 하기
 *   2. 예약 취소
 *   3. 종료
 *  - TheaterTest   : 메뉴 표시, 입력, 메시지 출력 (실행 흐름)
 *  - TheaterSeats  : 좌석 배열 관리 (setSize, printSeats, reserve, cancel, isValid)
 *
 * 포인트
 *  - 사용자는 1~10 / 1~8 로 입력하지만 배열 인덱스는 0부터 → 입력값 - 1
 *  - reserve / cancel 은 성공 여부를 boolean 으로 돌려주고, 메시지는 TheaterTest 가 출력한다.
 *  - isValid 를 먼저 검사하므로(&& 단축 평가) 범위 밖 번호를 넣어도 ArrayIndexOutOfBoundsException 이 나지 않는다.
 *
 * =====================================================================================
 * 📝 필기 (AI 설명) 영화관 좌석 예약 프로그램 개념 정리 — 3번·4번 코드 기준
 *    (1~5 는 이 파일, 6~10 은 TheaterSeatsSystem.java 에 이어서 정리)
 * =====================================================================================
 *
 * 1. 클래스와 객체
 *   - TheaterSeats  : 좌석을 관리하는 설계도 (좌석 배열 + 예약/취소 기능)
 *   - TheaterTest   : 프로그램의 실행 흐름 (메뉴 → 입력 → 처리)
 *
 *       TheaterSeats   seats   =   new TheaterSeats();
 *       ───────────    ─────       ──────────────────
 *        타입(클래스)   참조 변수     객체 생성
 *
 *   - seats 는 배열이 아니라 TheaterSeats 객체를 가리키는 "참조 변수" 이다.
 *     실제 boolean 배열은 그 객체 안의 seats 필드에 들어 있다.
 *       TheaterTest.seats ──▶ [ TheaterSeats 객체 : seats ● ] ──▶ boolean[10][8]
 *   - 객체마다 데이터가 따로 있다.
 *       TheaterSeats a = new TheaterSeats();  a.setSize(10, 8);
 *       TheaterSeats b = new TheaterSeats();  b.setSize(5, 5);
 *       → a 와 b 의 좌석 배열은 서로 영향을 주지 않는다. (상영관이 두 개인 것과 같다)
 *
 * 2. 필드와 메서드
 *   - 필드 : private boolean[][] seats;   (객체가 가지는 데이터)
 *   - 메서드 : 객체가 하는 일
 *       | 메서드      | 반환형  | 하는 일                              |
 *       |-------------|---------|--------------------------------------|
 *       | setSize     | void    | 좌석 배열 생성                       |
 *       | printSeats  | void    | 좌석 현황 출력                       |
 *       | reserve     | boolean | 예약 성공 true / 실패 false          |
 *       | cancel      | boolean | 취소 성공 true / 실패 false          |
 *       | isValid     | boolean | 번호가 범위 안이면 true              |
 *   - void vs boolean
 *       void    : 일만 하고 돌려주는 값이 없다.
 *       boolean : 결과(성공/실패)를 돌려준다. → 호출한 쪽에서 if 로 사용
 *           if (seats.reserve(r, c)) System.out.println("정상적으로 예약되었습니다.");
 *           else                     System.out.println("이미 예약된 좌석이거나 잘못된 번호입니다.");
 *     → 좌석 관리(로직) 클래스는 "결과" 만 알려주고, "어떻게 보여줄지(출력)" 는 실행 클래스가 정한다.
 *       로직과 화면 출력이 분리된다.
 *
 * 3. private vs public
 *   - seats 배열은 private → 클래스 밖에서 직접 건드릴 수 없다.
 *       seats.reserve(0, 0);         // ✅ 가능 : public 메서드를 통해 예약
 *       seats.seats[0][0] = true;    // ❌ 불가 : private 필드에 직접 접근 (컴파일 에러)
 *   - 이것이 캡슐화(encapsulation).
 *     반드시 reserve / cancel 을 거치게 해서 "중복 예약 검사", "범위 검사" 를 건너뛰지 못하게 보호한다.
 *   - isValid 는 private → 클래스 내부에서만 쓰는 도우미(helper) 메서드. 밖에서 부를 필요가 없다.
 *
 * 4. static
 *   4-1. TheaterTest 의 static 필드
 *       static TheaterSeats seats = new TheaterSeats();
 *       static Scanner sc = new Scanner(System.in);
 *     → 객체 없이 클래스에 하나만 존재하고, main · reserveSeat · cancelSeat 등 모든 static 메서드가 같이 쓴다.
 *       sc 는 프로그램 전체가 공유하는 입력 도구.
 *
 *   4-2. main 은 왜 static 인가?
 *     - JVM 이 프로그램을 시작할 때 객체를 만들지 않고 TheaterTest.main() 을 바로 호출하기 때문.
 *     - 규칙
 *         ① static 메서드는 객체 없이 인스턴스 멤버(필드/메서드)를 사용할 수 없다.
 *         ② 인스턴스 메서드는 객체를 통해 호출한다.  (객체.메서드())
 *         ③ static 메서드는 static 메서드를 바로 호출할 수 있다.
 *     - 3번 코드 : displayMenu, selectMenu, reserveSeat ... 가 모두 static → main 에서 바로 호출 (규칙 ③)
 *     - 4번 코드 : main 에서 system 객체를 먼저 만든 뒤 system.displayMenu() 처럼 호출 (규칙 ②)
 *         → static 메서드에서도 "객체를 통해서라면" non-static 메서드를 호출할 수 있다.
 *
 *   4-3. 설계 구조
 *       [ TheaterTest ]  (static : 실행 흐름)
 *         ├─ static Scanner sc
 *         ├─ static TheaterSeats seats ─────▶ [ TheaterSeats 객체 ]
 *         ├─ main()                              ├─ private boolean[][] seats
 *         ├─ displayMenu() / selectMenu()        ├─ setSize() / printSeats()
 *         └─ displaySeats() / reserveSeat()      ├─ reserve() / cancel()
 *            / cancelSeat()                      └─ private isValid()
 *
 * 5. new 와 생성자
 *   - 생성자 : new 로 객체를 만들 때 자동으로 실행되는 특별한 메서드. 클래스 이름과 같고 반환형이 없다.
 *       class Example {
 *           int number;
 *           Example() { number = 10; }      // 생성자
 *       }
 *       Example ex = new Example();          // 생성자 실행 → ex.number 는 10
 *   - TheaterSeats 에는 생성자를 쓰지 않았으므로 컴파일러가 기본 생성자를 자동으로 넣어 준다.
 *       public TheaterSeats() { }
 *   - 이 프로그램에서 new 는 두 번 쓰인다.
 *       new TheaterSeats()             → 좌석 관리 객체 생성
 *       new boolean[rows][cols]        → setSize 안에서 좌석 배열 생성
 *
 *   (6~10 : TheaterSeatsSystem.java 에 계속)
 *
 * 💡 문제에 정답 코드가 함께 주어졌고, 메뉴 문구와 메시지는 그대로 옮겼다.
 * 💡 숫자가 아닌 값을 입력하면 nextInt() 에서 InputMismatchException 이 난다. (예외 처리는 뒤에서 배움)
 *
 * 실행 예 (입력 : 1 / 1 1 / 1 / 1 1 / 0 / 2 / 3 3 / 3)
 *  ===== 영화관 예약 시스템 =====
 *  0. 예약 현황 표시
 *  1. 예약 하기
 *  2. 예약 취소
 *  3. 종료
 *  ==============================
 *  메뉴를 선택하세요: 1
 *  예약할 행 번호를 입력하세요 (1~10): 1
 *  예약할 열 번호를 입력하세요 (1~8): 1
 *  정상적으로 예약되었습니다.
 *  ...
 *  메뉴를 선택하세요: 1     (같은 좌석 1, 1 을 다시 예약)
 *  이미 예약된 좌석이거나 잘못된 번호입니다.
 *  ...
 *  메뉴를 선택하세요: 0
 *
 *  [ 좌석 예약 현황 ]
 *  ■ □ □ □ □ □ □ □
 *  □ □ □ □ □ □ □ □
 *  ... (10줄)
 *  ...
 *  메뉴를 선택하세요: 2     (예약하지 않은 3, 3 취소)
 *  예약되지 않은 좌석이거나 잘못된 번호입니다.
 *  ...
 *  메뉴를 선택하세요: 3
 *  프로그램을 종료합니다.
 */
public class TheaterTest {
    static TheaterSeats seats = new TheaterSeats();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int menu;
        seats.setSize(10, 8);              // 10행 8열

        do {
            displayMenu();
            menu = selectMenu();

            switch (menu) {
                case 0:
                    displaySeats();
                    break;
                case 1:
                    reserveSeat();
                    break;
                case 2:
                    cancelSeat();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 번호입니다. 다시 선택해주세요.");
            }
        } while (menu != 3);

        sc.close();
    }

    static void displayMenu() {
        System.out.println("\n===== 영화관 예약 시스템 =====");
        System.out.println("0. 예약 현황 표시");
        System.out.println("1. 예약 하기");
        System.out.println("2. 예약 취소");
        System.out.println("3. 종료");
        System.out.println("==============================");
    }

    static int selectMenu() {
        System.out.print("메뉴를 선택하세요: ");
        return sc.nextInt();
    }

    static void displaySeats() {
        seats.printSeats();
    }

    static void reserveSeat() {
        System.out.print("예약할 행 번호를 입력하세요 (1~10): ");
        int r = sc.nextInt() - 1;                       // 1~10 → 인덱스 0~9
        System.out.print("예약할 열 번호를 입력하세요 (1~8): ");
        int c = sc.nextInt() - 1;

        if (seats.reserve(r, c)) {                       // boolean 반환값을 if 에서 사용
            System.out.println("정상적으로 예약되었습니다.");
        } else {
            System.out.println("이미 예약된 좌석이거나 잘못된 번호입니다.");
        }
    }

    static void cancelSeat() {
        System.out.print("취소할 행 번호를 입력하세요 (1~10): ");
        int r = sc.nextInt() - 1;
        System.out.print("취소할 열 번호를 입력하세요 (1~8): ");
        int c = sc.nextInt() - 1;

        if (seats.cancel(r, c)) {
            System.out.println("예약이 정상적으로 취소되었습니다.");
        } else {
            System.out.println("예약되지 않은 좌석이거나 잘못된 번호입니다.");
        }
    }
}

class TheaterSeats {
    private boolean[][] seats;              // false : 빈 좌석, true : 예약됨 (기본값 false)

    // 기본 생성자 public TheaterSeats() { } 는 컴파일러가 자동으로 넣어 준다

    public void setSize(int rows, int cols) {
        seats = new boolean[rows][cols];
    }

    public void printSeats() {
        System.out.println("\n[ 좌석 예약 현황 ]");
        for (int i = 0; i < seats.length; i++) {             // 바깥 for : 행
            for (int j = 0; j < seats[i].length; j++) {      // 안쪽 for : 열
                System.out.print((seats[i][j] ? "■" : "□") + " ");
            }
            System.out.println();                            // 한 행이 끝나면 줄바꿈
        }
    }

    public boolean reserve(int row, int col) {
        if (isValid(row, col) && !seats[row][col]) {         // 범위 안 && 아직 예약 안 됨
            seats[row][col] = true;
            return true;
        }
        return false;
    }

    public boolean cancel(int row, int col) {
        if (isValid(row, col) && seats[row][col]) {          // 범위 안 && 예약되어 있음
            seats[row][col] = false;
            return true;
        }
        return false;
    }

    private boolean isValid(int row, int col) {              // 내부에서만 쓰는 도우미 메서드
        return row >= 0 && row < seats.length && col >= 0 && col < seats[0].length;
    }
}
