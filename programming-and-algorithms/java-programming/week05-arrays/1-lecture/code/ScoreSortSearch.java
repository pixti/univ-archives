import java.util.Arrays;
import java.util.Scanner;

/**
 * [5-2 배열2] [실습] 학생 성적 정렬 및 검색하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ScoreSortSearch {
    public static void main(String[] args) {
        int val, cnt = 0, sum = 0;
        int [] array = new int[100];

        Scanner sc = new Scanner(System.in);
        System.out.println("0과 100 사이의 값을 입력 (그외 값 종료) : ");
        val = sc.nextInt();
        while (val >= 0 && val <= 100) {
            array[cnt] = val;
            cnt = cnt + 1;   // 입력 정수의 개수 세기
            System.out.println("0과 100 사이 값 입력 (그외 값 종료) : ");
            val = sc.nextInt();
        }

        Arrays.sort(array, 0, cnt);   // 마찬가지로 시작과 끝을 지정

        System.out.print("정렬 후 성적 : ");
        for (int i = 0; i < cnt; i++) System.out.print(array[i] + " ");
        System.out.println();

        System.out.print("찾고자 하는 성적을 입력하세요 : ");
        val = sc.nextInt();

        int i = Arrays.binarySearch(array, 0, cnt, val);
        if (i < 0)
            System.out.println("성적이 존재하지 않습니다.");
        else
            System.out.println("성적은 " + (i + 1) + " 번째에 존재합니다.");
        sc.close();
    }
}
