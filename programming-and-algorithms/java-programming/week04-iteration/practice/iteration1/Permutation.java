import java.util.Scanner;

/**
 * [4강 실습] 반복문1 - 3번 문제
 * ※ 반복 시 while 이나 do while 문만 사용하시오.
 *
 * 서로 다른 n 개에서 r 개를 택하여 일렬로 나열할 수 있는 경우의 수를 순열(permutation)이라 하고,
 * nPr 로 표시한다. 순열은 아래의 수식에 의해 구할 수 있는데, 이를 프로그램으로 작성하라.
 * n 과 r 은 사용자로부터 입력 받도록 한다.
 *
 *     nPr = n(n-1) ... (n-(r-1))
 *
 * 📝 필기 (코드 주석)
 *  - while (i < r)          // ( i <= r-1 ) 과 동일한 의미.
 *  - prod *= (n - i);       // prod = prod * (n - i); 과 동일한 의미.
 *
 * 포인트
 *  - 곱하는 항은 n - 0, n - 1, ..., n - (r-1) → 총 r 개.
 *    i 를 0 ~ r-1 로 돌리면서 (n - i) 를 곱한다.
 *  - 곱이므로 prod 는 1 로 초기화 (퀴즈 3번 Π → prod = 1).
 *
 * 💡 r = 0 이면 반복을 한 번도 안 돌아 prod = 1 (nP0 = 1, 수학적으로도 맞다).
 * 💡 n, r 이 크면 int 오버플로 (4-3 팩토리얼 참고). 예 : 20P15 는 int 범위를 넘는다.
 *
 * 문제의 실행 예
 *  순열의 n값과 r값을 입력하시오 : 3 2
 *  3P2순열의 값은 6입니다.
 *
 * 내 코드 실행 예
 *  n ? 5
 *  r ? 3
 *  5P3 : 60
 */
public class Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n ? ");
        int n = sc.nextInt();
        System.out.print("r ? ");
        int r = sc.nextInt();
        sc.close();

        int prod = 1, i = 0;
        while (i < r) {             // ( i <= r-1 ) 과 동일한 의미.
            prod *= (n - i);        // prod = prod * (n - i); 과 동일한 의미.
            i++;
        }
        System.out.println(n + "P" + r + " : " + prod);
    }
}
