/**
 * [5-1 배열1] 배열의 전형적인 사용 예 (출력 · 합 · 최대값 · 최소값)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ArrayTypicalUsage {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        // 1. 출력 예
        System.out.print("1. 출력 : ");
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();

        // 2. 원소의 합
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            sum += array[i];
        System.out.println("2. 합 : " + sum);

        // 3. 원소의 최대값 구하기
        int max = array[0], maxPos = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxPos = i;
            }
        }
        System.out.println("3. 최대 : " + max + ", 최대 위치 : " + maxPos);

        // 4. 원소의 최소값 구하기
        int min = array[0], minPos = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minPos = i;
            }
        }
        System.out.println("4. 최소 : " + min + ", 최소 위치 : " + minPos);
    }
}
