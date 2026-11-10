import java.util.Scanner;

/**
 * [4-1 반복문1] [실습] 메뉴 반복 처리하기 - 조건문 실습에서 반복처리 추가 (while 버전)
 *
 * 3주차 "메뉴 방식의 사칙 연산" 을 q 를 누를 때까지 반복하도록 바꾼다.
 *
 * 포인트
 *  - boolean 플래그(cont)로 반복을 제어한다.
 *    cont 가 true 인 동안 돌다가 q 가 들어오면 false 로 바꾼다 → 다음 조건 검사에서 빠져나옴.
 *  - !(c == 'a' || c == 's' || c == 'm' || c == 'd') : 네 메뉴 중 어느 것도 아니면
 *    (= c != 'a' && c != 's' && c != 'm' && c != 'd', 드모르간 법칙)
 *
 * 💡 슬라이드에서 "… // 생략" 된 부분(숫자 두 개 입력 → 계산 → 출력)은 3주차 코드로 채웠다.
 *    실행 화면의 "결과는 10.0입니다." 처럼 결과는 double 로 출력한다.
 * 💡 실행 화면 캡처의 코드는 while(true) + break(q 일 때) + continue(잘못된 메뉴일 때) 로 되어 있다.
 *    (break / continue 는 4-4 에서 배운다.) 플래그 방식과 결과는 같다.
 *
 * ⚠ 슬라이드의 "휴효하지 않는 메뉴입니다." → "유효", 주석의 "문한 루프" → "무한" 오타 수정.
 *
 * 실행 예
 *  a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료
 *  a
 *  첫 번째 숫자 (음수도 가능) >>
 *  3
 *  두 번째 숫자 (음수도 가능) >>
 *  7
 *  결과는 10.0입니다.
 *  a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료
 *  x
 *  유효하지 않는 메뉴입니다.
 *  a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료
 *  q
 *  프로그램을 종료하였습니다.
 */
public class MenuCalculatorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean cont = true; char c;
        while (cont) {  // cont가 false 될때 까지 무한 루프
            System.out.println("a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료");
            c = sc.next().charAt(0);

            if (c == 'q') {
                System.out.println("프로그램을 종료하였습니다.");
                cont = false;
            }
            else if (!(c == 'a' || c == 's' || c == 'm' || c == 'd')) {
                System.out.println("유효하지 않는 메뉴입니다.");
            }
            else {
                // ----- 슬라이드에서 생략된 부분 -----
                System.out.println("첫 번째 숫자 (음수도 가능) >> ");
                int a = sc.nextInt();
                System.out.println("두 번째 숫자 (음수도 가능) >> ");
                int b = sc.nextInt();

                double result;
                if (c == 'a') result = a + b;
                else if (c == 's') result = a - b;
                else if (c == 'm') result = a * b;
                else result = (double) a / b;   // 💡 형변환하지 않으면 정수 나눗셈 (7 / 2 = 3)

                System.out.println("결과는 " + result + "입니다.");
            }
        }
        sc.close();
    }
}
