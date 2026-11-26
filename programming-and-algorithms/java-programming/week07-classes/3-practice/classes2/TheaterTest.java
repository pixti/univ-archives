import java.util.Scanner;

/**
 * [7강 실습] 클래스(2) - 3번 문제 (영화관 좌석 예약 프로그램 - 실행 클래스 + 좌석 관리 클래스)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
