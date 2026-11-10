import java.util.Scanner;

/**
 * [2강 과제] 수식 - 5번
 * 10000 보다 작은 정수를 입력받아서 이것을 천의 자리, 백의 자리, 십의 자리, 일의 자리로
 * 분리하여 출력하는 프로그램을 작성하라. 조건문이나 반복문은 사용하지 마시오.
 *
 * 실행 예
 *  정수를 입력하시오.:5623
 *  천의 자리: 5
 *  백의 자리: 6
 *  십의 자리: 2
 *  일의 자리: 3
 *
 * 풀이: 정수 나눗셈(/)으로 자릿수를 오른쪽으로 밀고, % 10 으로 마지막 한 자리만 꺼낸다.
 *  5623 / 1000      = 5
 *  5623 / 100 % 10  = 56 % 10  = 6
 *  5623 / 10  % 10  = 562 % 10 = 2
 *  5623 % 10        = 3
 *  (/ 와 % 는 우선순위가 같으므로 왼쪽부터 계산 → (n / 100) % 10)
 *
 *  다른 방법: 강의 예제 IntegerToTime 처럼 나머지를 계속 넘겨주는 방식
 *  thousand = n / 1000;  n = n % 1000;  hundred = n / 100;  n = n % 100; ...
 */
public class DigitSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하시오.:");
        int n = sc.nextInt();
        sc.close();

        int thousand = n / 1000;
        int hundred = n / 100 % 10;
        int ten = n / 10 % 10;
        int one = n % 10;

        System.out.println("천의 자리: " + thousand);
        System.out.println("백의 자리: " + hundred);
        System.out.println("십의 자리: " + ten);
        System.out.println("일의 자리: " + one);
    }
}
