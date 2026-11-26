import java.util.Arrays;

/**
 * [5-2 배열2] 배열 정렬 : java.util.Arrays 의 정적 메소드 sort
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ArraySort {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 2, 4};

        for (int e : array)   // 정렬 전 원소 출력
            System.out.print(e + " ");
        System.out.println();

        Arrays.sort(array);   // 배열 정렬

        for (int e : array)   // 정렬 후 원소 출력
            System.out.print(e + " ");
        System.out.println();

        System.out.println(Arrays.toString(array));   // 💡 한 번에 출력
    }
}
