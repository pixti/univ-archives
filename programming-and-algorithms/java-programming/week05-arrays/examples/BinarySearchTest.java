import java.util.Arrays;

/**
 * [5-2 배열2] 배열 탐색 : java.util.Arrays 의 정적 메소드 binarySearch
 *
 * - 탐색 방법도 다양하고, 방법에 따라 코드가 다양하다.
 * - java.util.Arrays 가 정적 메소드 binarySearch 를 제공한다.
 * - 다양한 배열 객체에 대해 동작하도록 중복정의(overloading) 되어 있다.
 * - 원하는 값(키)이 존재할 경우 그 위치의 첨자 값을 반환한다.
 *
 * 포인트
 *  - 이진 탐색은 정렬된 배열에서 가운데 값과 비교해 절반씩 범위를 줄여 찾는다 → 반드시 먼저 정렬.
 *  - 정렬 후 a = [1, 2, 3, 4, 5] → 3 의 위치는 2.
 *
 * 💡 값이 없을 때 반환값 = -(삽입 위치) - 1
 *     삽입 위치 = "그 값이 있었다면 들어갔을 자리"
 *     0 → 맨 앞 (삽입 위치 0) → -0 - 1 = -1
 *     6 → 맨 뒤 (삽입 위치 5) → -5 - 1 = -6
 *     -1 을 더 빼는 이유 : 그냥 -삽입위치 면 삽입 위치 0 일 때 0 이 되어 "0번째에 있음" 과 구분이 안 된다.
 *     → 결국 "음수면 없음" 으로 판단하면 된다.
 * 💡 중복정의 : binarySearch(int[], int), binarySearch(double[], double),
 *              binarySearch(int[], 시작, 끝, int) ... 이름은 같고 매개변수가 다르다.
 * 💡 같은 값이 여러 개면 그중 어느 위치가 반환될지 보장되지 않는다.
 * ⚠ 슬라이드의 세 번째 대입 I = ... 는 대문자 I 라서 컴파일 오류. 소문자 i 로 고쳤다.
 *
 * 실행 예
 *  2
 *  -1
 *  -6
 */
public class BinarySearchTest {   // int idx = Arrays.binarySearch(배열, 키) 형태로 쓴다
    public static void main(String[] args) {
        int [] a = new int[]{3, 2, 1, 4, 5};
        Arrays.sort(a);
        int i = Arrays.binarySearch(a, 3);
        System.out.println(i);
        i = Arrays.binarySearch(a, 0);   // 찾는 값이 없음 -1 출력
        System.out.println(i);
        i = Arrays.binarySearch(a, 6);   // 찾는 값이 없음 -6 출력  (⚠ 슬라이드는 I = ...)
        System.out.println(i);
    }
}
