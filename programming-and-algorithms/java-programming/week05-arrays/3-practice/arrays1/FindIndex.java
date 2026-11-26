import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * [5강 실습] 배열(1) - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class FindIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] my_arr = new int[] {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        char cont;

        do {
            System.out.print("찾고자 하는 값 ? ");
            int n = sc.nextInt();

            // 방법 1) 인덱스 for
            int index = -1;                       // 못 찾으면 -1
            for (int i = 0; i < my_arr.length; i++) {
                if (my_arr[i] == n) {
                    index = i;
                    break;                        // 첫 위치만
                }
            }
            if (index != -1) System.out.println("인덱스 : " + index);
            else             System.out.println("인덱스 : -1 (배열에 없음)");

            // 방법 2) OptionalInt
            OptionalInt found = IntStream.range(0, my_arr.length)
                                         .filter(i -> my_arr[i] == n)
                                         .findFirst();
            if (found.isPresent()) System.out.println("OptionalInt 인덱스 : " + found.getAsInt());
            else                   System.out.println("OptionalInt : 값 없음");

            System.out.print("계속 ? ('y' or 'n') ");
            cont = sc.next().charAt(0);
        } while (cont == 'y');
        sc.close();
    }
}
