import java.util.Scanner;

/**
 * [4-3 반복문3] [실습] 메뉴 반복 처리하기 (for 버전)
 *
 * 앞서 실습한 while 문을 사용한 "메뉴 방식의 사칙 연산" 을 for 문으로 변경.
 *
 * 포인트
 *  - 초기식에서 boolean 변수를 선언하고, 증감식은 비웠다. cont 값은 블록 안에서 바뀐다.
 *  - cont == true 는 그냥 cont 와 같다 (boolean 변수는 그대로 조건식에 쓸 수 있다).
 *  💡 반복 횟수가 정해지지 않은 문제라 while / do-while 이 더 자연스럽다.
 *     "for 로도 쓸 수 있다 (표현력이 같다)" 를 보여 주는 예제.
 *
 * ⚠ 슬라이드의 "휴효하지 않는 메뉴입니다." → "유효" 오타 수정.
 *
 * 실행 예
 *  a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료
 *  d
 *  첫 번째 숫자 (음수도 가능) >>
 *  7
 *  두 번째 숫자 (음수도 가능) >>
 *  2
 *  결과는 3.5입니다.
 *  a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료
 *  q
 *  프로그램을 종료하였습니다.
 */
public class MenuCalculatorFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (boolean cont = true; cont == true; ) {     // 증감문은 생략
            System.out.println("a : 덧셈, s : 뺄셈, m : 곱셈, d : 나눗셈, q : 종료");
            char c = sc.next().charAt(0);

            if (c == 'q') {
                System.out.println("프로그램을 종료하였습니다.");
                cont = false;   // 무한루프를 종료
            }
            else if (!(c == 'a' || c == 's' || c == 'm' || c == 'd')) {
                System.out.println("유효하지 않는 메뉴입니다.");
            }
            else {
                System.out.println("첫 번째 숫자 (음수도 가능) >> ");
                int a = sc.nextInt();
                // ----- 슬라이드에서 생략(…)된 부분 -----
                System.out.println("두 번째 숫자 (음수도 가능) >> ");
                int b = sc.nextInt();

                double result;
                if (c == 'a') result = a + b;
                else if (c == 's') result = a - b;
                else if (c == 'm') result = a * b;
                else result = (double) a / b;
                // -----------------------------------
                System.out.println("결과는 " + result + "입니다.");
            }
        }
        sc.close();
    }
}
