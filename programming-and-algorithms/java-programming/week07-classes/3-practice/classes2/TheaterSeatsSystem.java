import java.util.Scanner;

/**
 * [7강 실습] 클래스(2) - 4번 문제 (영화관 좌석 예약 프로그램 - 하나의 클래스로 통합)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class TheaterSeatsSystem {
    private boolean[][] seats;
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        TheaterSeatsSystem system = new TheaterSeatsSystem();   // static main → 객체를 먼저 만든다
        system.setSize(10, 8);
        int menu;

        do {
            system.displayMenu();
            menu = system.selectMenu();

            switch (menu) {
                case 0:
                    system.displaySeats();
                    break;
                case 1:
                    system.reserveSeat();
                    break;
                case 2:
                    system.cancelSeat();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 메뉴 번호입니다. 다시 선택해주세요.");
            }
        } while (menu != 3);

        system.sc.close();
    }

    public void setSize(int rows, int cols) {
        seats = new boolean[rows][cols];
    }

    public void displayMenu() {
        System.out.println("\n===== 영화관 예약 시스템 =====");
        System.out.println("0. 예약 현황 표시");
        System.out.println("1. 예약 하기");
        System.out.println("2. 예약 취소");
        System.out.println("3. 종료");
        System.out.println("==============================");
    }

    public int selectMenu() {
        System.out.print("메뉴를 선택하세요: ");
        return sc.nextInt();
    }

    public void displaySeats() {
        System.out.println("\n[ 좌석 예약 현황 ]");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print((seats[i][j] ? "■" : "□") + " ");
            }
            System.out.println();
        }
    }

    public void reserveSeat() {
        System.out.print("예약할 행 번호를 입력하세요 (1~10): ");
        int r = sc.nextInt() - 1;
        System.out.print("예약할 열 번호를 입력하세요 (1~8): ");
        int c = sc.nextInt() - 1;

        if (isValid(r, c) && !seats[r][c]) {
            seats[r][c] = true;
            System.out.println("정상적으로 예약되었습니다.");
        } else {
            System.out.println("이미 예약된 좌석이거나 잘못된 번호입니다.");
        }
    }

    public void cancelSeat() {
        System.out.print("취소할 행 번호를 입력하세요 (1~10): ");
        int r = sc.nextInt() - 1;
        System.out.print("취소할 열 번호를 입력하세요 (1~8): ");
        int c = sc.nextInt() - 1;

        if (isValid(r, c) && seats[r][c]) {
            seats[r][c] = false;
            System.out.println("예약이 정상적으로 취소되었습니다.");
        } else {
            System.out.println("예약되지 않은 좌석이거나 잘못된 번호입니다.");
        }
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < seats.length && col >= 0 && col < seats[0].length;
    }
}
