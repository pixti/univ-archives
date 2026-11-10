import java.util.Arrays;
import java.util.Collections;

/**
 * [5-2 배열2] 내림차순 정렬 + 두 변수 교환(swap)
 *
 * 1) int 배열 : 내림차순으로 정렬해 주는 메소드가 별도로 없다.
 *    → 오름차순 정렬 후 역순으로 재정렬한다.
 *
 *      정렬 후   [1, 2, 3, 4, 5]
 *      i=0 교환  [5, 2, 3, 4, 1]   a[0] ↔ a[4]
 *      i=1 교환  [5, 4, 3, 2, 1]   a[1] ↔ a[3]
 *      (a[2] 는 가운데라 그대로. 5/2 = 2 번만 반복)
 *
 *    - a.length / 2 까지만 : 끝까지 돌면 바꾼 것을 한 번 더 바꿔서 원래대로 돌아간다.
 *    - a.length - (i + 1) == a.length - 1 - i : i 번째와 대칭인 위치.
 *
 * 2) 객체 배열(String[] 등) : sort 에 Comparator 객체를 인수로 넘겨 내림차순 정렬 가능.
 *      Arrays.sort(b, Collections.reverseOrder());
 *    💡 Collections.reverseOrder() 는 "반대 순서로 비교하는 규칙" 을 만들어 준다.
 *    💡 int[] 에는 못 쓴다. Comparator 는 객체끼리 비교하는 규칙이라 기본형 int 에는 적용되지 않는다.
 *       (Integer[] 로 만들면 가능)
 *
 * 3) 두 변수 교환 (슬라이드 오른쪽 그림)
 *      a = b; b = a;          ❌ a 의 원래 값이 사라져 둘 다 3
 *      tmp = a; a = b; b = tmp;  ✅ 덮어쓰기 전에 tmp 에 옮겨 둔다
 *    ⚠ 슬라이드의 int a=0; b=3; 은 문법 오류 (b 가 선언되지 않음) → int a = 0, b = 3;
 *
 * 📝 필기 (실습 배열(1) 4번) : 배열의 대칭성을 이용해 arr.length/2 의 값을 이용해 스왑시켜주면 된다.
 *    [7, 6, 5, 4, 3] 이라 하면 중앙 5 를 기준으로 0번째 - 4번째, 1번째 - 3번째 끼리 대칭 관계.
 *    일반화 하면 i번째 - (배열길이 - i - 1) 끼리 대칭 관계.  → practice/arrays1/ReverseArray.java
 *
 * 실행 예
 *  int 내림차순    : [5, 4, 3, 2, 1]
 *  String 내림차순 : [ff, dd, bb, aa]
 *  잘못된 교환 : a = 3, b = 3
 *  올바른 교환 : a = 3, b = 0
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
        int x = 0, y = 3;      // ⚠ 슬라이드는 int a=0; b=3; (문법 오류)
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
