import java.util.Scanner;

/**
 * [4강 실습] 반복문2 - 3번 문제
 * ※ 반복 시 for 문만 사용하시오.
 *
 * 서로 다른 n 개에서 r 개를 택하여 일렬로 나열할 수 있는 경우의 수를 순열(permutation)이라 하고,
 * nPr 로 표시한다. 순열은 아래의 수식에 의해 구할 수 있는데, 이를 프로그램으로 작성하라.
 * n 과 r 은 사용자로부터 입력 받도록 한다.
 *
 *     nPr = n(n-1) ... (n-(r-1))
 *
 * 포인트
 *  - 반복문1-3 (while) 을 for 로 옮긴 것.
 *      while 버전                     for 버전
 *      int i = 0;      (반복문 앞)    →  for (int i = 0;
 *      while (i < r)                  →             i < r;
 *      i++;            (블록 마지막)  →                    i++)
 *  - 반복 횟수(r 번)가 정해져 있으므로 while 보다 for 가 자연스럽다.
 *  - i 를 for 안에서 선언했으므로 반복문이 끝나면 i 는 사라진다. (4-3 변수 범위)
 *  - prod 는 반복문 밖에서도 써야 하므로(출력) 밖에서 선언했다.
 *
 * ⚠ 반복문1-3 과 달리 sc.close() 를 하지 않았다. (프로그램이 끝나면 함께 정리되긴 하지만,
 *   Eclipse 가 "Resource leak: 'sc' is never closed" 경고를 띄운다. 아래에 추가했다)
 *
 * 문제의 실행 예
 *  순열의 n값과 r값을 입력하시오 : 3 2
 *  3P2순열의 값은 6입니다.
 *
 * 내 코드 실행 예
 *  n ? 6
 *  r ? 4
 *  6P4 : 360
 */
public class PermutationFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n ? ");
        int n = sc.nextInt();
        System.out.print("r ? ");
        int r = sc.nextInt();
        sc.close();                 // ⚠ 추가

        int prod = 1;
        for (int i = 0; i < r; i++) {
            prod *= (n - i);
        }
        System.out.print(n + "P" + r + " : " + prod);
    }
}
