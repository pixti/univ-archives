import java.util.Random;

/**
 * [8-4 실습] 배열 데이터 메소드에서 변경하기
 *
 * 포인트
 *  - increaseArray(array) : 배열의 레퍼런스가 전달되므로 메소드 안에서 arr[i]++ 하면
 *    main 의 array 원소도 1씩 증가한다.
 *  - printArray 도 static : static main 에서 객체 없이 바로 호출하려면 static 이어야 한다.
 *  - rnd.nextInt() : int 범위 전체(음수 포함)의 난수 → 실행할 때마다 값이 다르다.
 *    💡 rnd.nextInt(100) 처럼 범위를 주면 0 ~ 99
 *
 * 실행 예 (난수라서 매번 다름)
 *  변경 전 : -1155484576 -723955400 1033096058 ... (10개)
 *  변경 후 : -1155484575 -723955399 1033096059 ... (각각 1씩 증가)
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
