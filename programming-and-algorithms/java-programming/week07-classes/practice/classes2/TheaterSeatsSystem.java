import java.util.Scanner;

/**
 * [7강 실습] 클래스(2) - 4번 문제 (영화관 좌석 예약 프로그램 - 하나의 클래스로 통합)
 *
 * 문제
 *  3번 프로그램을 TheaterSeatsSystem 클래스 하나로 다시 작성하시오.
 *  좌석 배열, Scanner, 메뉴, 예약/취소를 모두 이 클래스의 인스턴스 멤버로 만든다.
 *
 * 포인트
 *  - main 은 static 이므로 먼저 객체를 만들고, 그 객체를 통해 인스턴스 메서드를 호출한다.
 *        TheaterSeatsSystem system = new TheaterSeatsSystem();
 *        system.setSize(10, 8);
 *        system.displayMenu();  ...
 *  - 3번과 달리 reserveSeat / cancelSeat 가 입력 · 검사 · 메시지 출력을 모두 직접 한다.
 *  - system.sc.close() : private 필드지만 main 이 같은 클래스 안에 있으므로 접근 가능
 *
 * =====================================================================================
 * 📝 필기 (AI 설명) 영화관 좌석 예약 프로그램 개념 정리 — 3번·4번 코드 기준 (이어서)
 *    (1~5 : TheaterTest.java)
 * =====================================================================================
 *
 * 6. 2차원 배열과 boolean
 *   6-1. 선언과 생성
 *       private boolean[][] seats;
 *       seats = new boolean[rows][cols];      // 10행 8열
 *       seats.length     → 행의 개수 (10)
 *       seats[0].length  → 열의 개수 (8)
 *   6-2. boolean 배열의 기본값은 false
 *       false : 예약되지 않음 (빈 좌석)
 *       true  : 예약됨
 *     → 따로 초기화하지 않아도 처음에는 모든 좌석이 빈 좌석이다.
 *   6-3. 삼항 연산자
 *       System.out.print((seats[i][j] ? "■" : "□") + " ");
 *     는 아래 if-else 와 같다.
 *       if (seats[i][j]) System.out.print("■ ");     // 예약됨
 *       else             System.out.print("□ ");     // 빈 좌석
 *   6-4. 중첩 for 문
 *       for (int i = 0; i < seats.length; i++) {          // 바깥 : 행
 *           for (int j = 0; j < seats[i].length; j++) {   // 안쪽 : 열
 *               ... 한 칸 출력
 *           }
 *           System.out.println();                         // 한 행이 끝나면 줄바꿈
 *       }
 *
 * 7. this / 매개변수 / 반환값
 *   - setSize(int rows, int cols) 의 rows, cols 는 매개변수 : 호출할 때 넘겨준 값(10, 8)을 받는다.
 *   - reserve(int row, int col) → boolean 반환값으로 성공 여부를 돌려준다.
 *   - this 는 매개변수 이름과 필드 이름이 같을 때 필요하다.
 *       class Example {
 *           int number;
 *           void setNumber(int number) {
 *               this.number = number;     // this.number : 필드,  number : 매개변수
 *           }
 *       }
 *     이 프로그램은 필드(seats)와 매개변수(rows, cols) 이름이 겹치지 않아서 this 없이 써도 된다.
 *
 * 8. 조건문과 논리 연산자
 *   8-1. && (AND) : 둘 다 true 여야 true
 *       if (isValid(row, col) && !seats[row][col])
 *       | isValid (범위 안) | !seats (예약 안 됨) | 결과          |
 *       |-------------------|---------------------|---------------|
 *       | true              | true                | 예약 가능     |
 *       | true              | false               | 이미 예약됨   |
 *       | false             | (검사 안 함)        | 잘못된 번호   |
 *   8-2. || (OR) : 하나라도 true 이면 true → "범위 밖" 검사에 쓸 수 있다.
 *       if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
 *           // 범위를 벗어남
 *       }
 *     isValid 는 이것을 뒤집은 것 (>= 0 && < length ...)
 *   8-3. 단축 평가 (short-circuit evaluation)
 *     - && 는 왼쪽이 false 이면 오른쪽을 아예 계산하지 않는다.
 *     - 그래서 isValid 가 먼저 와야 한다. 범위 밖이면 seats[row][col] 에 접근하지 않으므로
 *       ArrayIndexOutOfBoundsException 이 나지 않는다.
 *         !seats[row][col] && isValid(row, col)    // ❌ 순서가 반대면 범위 밖 번호에서 예외 발생
 *
 * 9. do-while / switch / break
 *   - do-while : 메뉴를 "최소 한 번" 보여 줘야 하므로 먼저 실행하고 나중에 조건 검사
 *   - switch   : menu 값에 따라 0 / 1 / 2 / 3 / default 로 분기
 *   - break    : switch 를 빠져나간다. (반복문을 빠져나가는 것이 아님!)
 *     → 반복 종료는 while (menu != 3) 조건이 담당한다. 3 을 고르면 조건이 false 가 되어 끝난다.
 *
 * 10. 3번 vs 4번 설계 비교
 *   - 3번 : 역할을 나눴다. TheaterSeats 는 좌석 관리만, TheaterTest 는 메뉴 · 입력 · 출력만.
 *           → 좌석 규칙을 바꿀 때는 TheaterSeats 만, 화면을 바꿀 때는 TheaterTest 만 고치면 된다. (유지보수 쉬움)
 *   - 4번 : 하나의 클래스에 모두 통합. 작은 프로그램에서는 간단하고 파일 하나로 끝난다.
 *           → 하지만 기능이 늘어나면 클래스가 비대해지므로 UI(메뉴/입력)와 관리(좌석) 를 분리하는 것이 좋다.
 *
 *       | 항목             | 3번                                   | 4번                                  |
 *       |------------------|---------------------------------------|--------------------------------------|
 *       | 클래스 구성      | TheaterTest + TheaterSeats (2개)      | TheaterSeatsSystem (1개)             |
 *       | 좌석 배열 관리   | TheaterSeats 의 인스턴스 필드 seats   | TheaterSeatsSystem 의 인스턴스 필드  |
 *       | 메뉴와 입력 처리 | TheaterTest 의 static 메서드          | TheaterSeatsSystem 의 인스턴스 메서드|
 *       | 예약 / 취소      | reserve, cancel 이 boolean 반환       | reserveSeat, cancelSeat 가 직접 출력 |
 *       | 객체 생성        | static TheaterSeats seats = new ...   | main 에서 new TheaterSeatsSystem()   |
 *       | 실행 클래스      | TheaterTest                           | TheaterSeatsSystem                   |
 *
 *   ★ 시험 포인트
 *     ① main 에서 왜 객체를 만들어야 하는가?   → main 은 static 이라 객체 없이 인스턴스 멤버를 쓸 수 없기 때문
 *     ② seats 는 왜 인스턴스 필드인가?          → 객체(상영관)마다 좌석 데이터가 독립적이어야 하기 때문
 *     ③ 3번과 4번의 구조는 왜 다른가?           → 역할 분리(유지보수) vs 통합(간단함)
 *
 * 💡 실행 결과는 3번(TheaterTest.java)과 같다.
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
