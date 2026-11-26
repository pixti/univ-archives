import java.util.Random;

/**
 * [7-4 실습] 배열 데이터 메소드에서 변경하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ArrayArgument {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) array[i] = rnd.nextInt();
        System.out.print("변경 전 : ");
        printArray(array);
        increaseArray(array);
        System.out.print("변경 후 : ");
        printArray(array);
    }

    public static void increaseArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) arr[i]++;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }
}
