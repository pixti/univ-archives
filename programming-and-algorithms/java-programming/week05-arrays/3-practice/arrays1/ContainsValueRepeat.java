import java.util.Scanner;

/**
 * [5강 실습] 배열(1) - 1번 문제 (버전 3 : do-while 로 반복)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ContainsValueRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] my_array = new int[] {1789, 2035, 1899, 1456, 2013, 1458, 2458,
                                     1254, 1472, 2365, 1456, 2265, 1457, 2456};
        int n;
        boolean flag;
        char cont;

        do {
            System.out.print("찾고자 하는 값 ? ");
            n = sc.nextInt();
            flag = false;                  // 매번 다시 초기화
            for (int e : my_array) {
                if (e == n) {
                    System.out.println("True");
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                System.out.println("False");
            }
            System.out.print("계속 하시겠습니까? (y/n) : ");
            cont = sc.next().charAt(0);
        } while (cont == 'y');

        sc.close();                        // ⚠ 원래 코드에는 없음
    }
}
