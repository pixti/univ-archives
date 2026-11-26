import java.util.Scanner;

/**
 * [5-1 배열1] 5. 값 배열에 읽어들이기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ReadIntoArray {
    public static void main(String[] args) {
        final int MAX_SIZE = 100;
        int [] array = new int [MAX_SIZE];   // 최대 크기로
        int val, idx = 0;
        Scanner sc = new Scanner(System.in);
        val = sc.nextInt();
        while (val >= 0) {
            array[idx] = val; idx++;
            val = sc.nextInt();
        }
        System.out.println("읽어들인 데이터 개수 : " + idx);
        sc.close();
    }
}
