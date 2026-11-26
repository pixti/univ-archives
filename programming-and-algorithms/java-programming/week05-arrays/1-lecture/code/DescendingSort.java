import java.util.Arrays;
import java.util.Collections;

/**
 * [5-2 배열2] 내림차순 정렬 + 두 변수 교환(swap)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class DescendingSort {
    public static void main(String[] args) {
        // 1) int 배열 : 오름차순 정렬 후 뒤집기
        int [] a = new int[]{4, 2, 3, 1, 5};
        Arrays.sort(a);
        for (int i = 0; i < a.length / 2; i++) {   // a.length 는 a배열의 크기를 알려줌
            int temp = a[i];
            a[i] = a[a.length - (i + 1)];
            a[a.length - (i + 1)] = temp;
        }
        System.out.println("int 내림차순    : " + Arrays.toString(a));

        // 2) 객체 배열 : Comparator 로 내림차순
        String[] b = {"aa", "ff", "dd", "bb"};
        Arrays.sort(b, Collections.reverseOrder());
        System.out.println("String 내림차순 : " + Arrays.toString(b));

        // 3) 두 변수 교환
        int x = 0, y = 3;      // ⚠ int x=0; y=3; 로 쓰면 y 가 선언되지 않아 문법 오류
        x = y;
        y = x;
        System.out.println("잘못된 교환 : a = " + x + ", b = " + y);

        x = 0; y = 3;
        int tmp = x;
        x = y;
        y = tmp;
        System.out.println("올바른 교환 : a = " + x + ", b = " + y);
    }
}
