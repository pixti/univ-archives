import java.util.Scanner;

/**
 * [5강 실습] 배열(1) - 1번 문제 (버전 1 : 인덱스 for)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ContainsValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] my_array = new int[] {1789, 2035, 1899, 1456, 2013, 1458, 2458,
                                     1254, 1472, 2365, 1456, 2265, 1457, 2456};

        System.out.print("찾고자 하는 값 ? ");
        int i, n = sc.nextInt();
        for (i = 0; i < my_array.length; i++) {
            if (my_array[i] == n) {
                System.out.println("True");
                break;
            }
        }
        if (i == my_array.length) {       // 끝까지 돌았다 = 못 찾았다
            System.out.println("False");
        }
        sc.close();
    }
}
