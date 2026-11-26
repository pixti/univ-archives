import java.util.Arrays;
import java.util.Scanner;

/**
 * [5-2 배열2] [실습] 학생 성적 정렬
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ScoreSort {
    public static void main(String[] args) {
        int val, cnt = 0, sum = 0;
        int [] array = new int[100];

        Scanner sc = new Scanner(System.in);
        System.out.println("0과 100 사이의 값을 입력 (그외 값 종료) : ");
        val = sc.nextInt();
        while (val >= 0 && val <= 100) {
            array[cnt] = val;
            cnt = cnt + 1;   // 입력 정수의 개수 세기
            System.out.println("0과 100 사이의 값 입력 (그외 값 종료) : ");
            val = sc.nextInt();
        }

        System.out.print("정렬 전 성적 : ");
        for (int i = 0; i < cnt; i++) System.out.print(array[i] + " ");
        System.out.println();

        // Arrays.sort(array);           // 범위지정하지 않으면 실행결과 모두 0
        // Arrays.sort(array, 0, cnt-1); // ⚠ 마지막 원소가 정렬에서 빠진다
        Arrays.sort(array, 0, cnt);      // [0, cnt) : 값이 들어 있는 부분만 정렬

        System.out.print("정렬 후 성적 : ");
        for (int i = 0; i < cnt; i++) System.out.print(array[i] + " ");
        System.out.println();
        sc.close();
    }
}
