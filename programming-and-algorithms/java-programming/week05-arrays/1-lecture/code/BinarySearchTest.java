import java.util.Arrays;

/**
 * [5-2 배열2] 배열 탐색 : java.util.Arrays 의 정적 메소드 binarySearch
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class BinarySearchTest {   // int idx = Arrays.binarySearch(배열, 키) 형태로 쓴다
    public static void main(String[] args) {
        int [] a = new int[]{3, 2, 1, 4, 5};
        Arrays.sort(a);
        int i = Arrays.binarySearch(a, 3);
        System.out.println(i);
        i = Arrays.binarySearch(a, 0);   // 찾는 값이 없음 -1 출력
        System.out.println(i);
        i = Arrays.binarySearch(a, 6);   // 찾는 값이 없음 -6 출력
        System.out.println(i);
    }
}
