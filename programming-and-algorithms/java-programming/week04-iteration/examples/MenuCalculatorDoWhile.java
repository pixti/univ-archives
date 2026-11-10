import java.util.Scanner;

/**
 * [4-2 반복문2] [실습] 메뉴 반복 처리하기 (do-while 버전)
 *
 * 4-1 에서 while 로 작성한 "메뉴 방식의 사칙연산" 을 do-while 로 변경한다.
 *
 * do-while 문 (Python 에서는 제공하지 않음)
 *  - while 의 변형. 반복문을 한 번 실행한 후 조건을 검사 → 최소 한 번은 실행된다.
 *
 *     do {                         aaa;
 *         반복 내용들       ≒       while (조건식) {
 *     } while (조건식);                 aaa;
 *                                  }
 *
 * 포인트
 *  - 메뉴는 적어도 한 번은 보여 줘야 하므로 do-while 이 자연스럽다.
 *  - char c 를 블록 "안에서" 선언 → 반복마다 새로 읽는 값이고 밖에서 쓸 일이 없으므로 범위를 좁혔다.
 *  💡 do-while 은 조건을 나중에 검사하므로 cont 를 꼭 초기화할 필요는 없다.
 *     단 그러면 if / else if / else 모든 경로에서 cont 에 값을 넣어야 컴파일된다.
 *     그래서 그냥 true 로 초기화해 두는 편이 간단하다.
 *
 * ⚠ 슬라이드의 "휴효하지 않는 메뉴입니다." → "유효" 오타 수정.
 *
 * 실행 예
 *  a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료
 *  m
 *  첫 번째 숫자 (음수도 가능) >>
 *  -4
 *  두 번째 숫자 (음수도 가능) >>
 *  5
 *  결과는 -20.0입니다.
 *  a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료
 *  q
 *  프로그램을 종료하였습니다.
 */
public class MenuCalculatorDoWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean cont = true;
        do {
            System.out.println("a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료 ");
            char c = sc.next().charAt(0);

            if (c == 'q') {
                System.out.println("프로그램을 종료하였습니다.");
                cont = false;
            }
            else if (!(c == 'a' || c == 's' || c == 'm' || c == 'd'))
                System.out.println("유효하지 않는 메뉴입니다.");
            else {
                System.out.println("첫 번째 숫자 (음수도 가능) >> ");
                int a = sc.nextInt();
                System.out.println("두 번째 숫자 (음수도 가능) >> ");
                int b = sc.nextInt();

                double result;
                if (c == 'a') result = a + b;
                else if (c == 's') result = a - b;
                else if (c == 'm') result = a * b;
                else result = (double) a / b;

                System.out.println("결과는 " + result + "입니다.");
            }
        } while (cont);
        sc.close();
    }
}
