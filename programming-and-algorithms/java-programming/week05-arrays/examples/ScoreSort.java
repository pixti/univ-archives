import java.util.Arrays;
import java.util.Scanner;

/**
 * [5-2 배열2] [실습] 학생 성적 정렬
 *
 * 포인트 : 범위를 지정하지 않으면 실행결과가 모두 0 인 이유
 *  - 배열 크기는 100 인데 값은 cnt 개만 들어 있고, 나머지 칸은 기본값 0.
 *  - Arrays.sort(array) 는 100 칸 전체를 정렬 → 0 이 앞으로 몰리고 입력값은 맨 뒤로 밀려난다.
 *  - 출력은 cnt 개까지만 하므로 0 0 0 0 이 보인다.
 *      (슬라이드 화면 : 정렬 전 성적 : 50 40 30 70 / 정렬 후 성적 : 0 0 0 0)
 *  - 그래서 Arrays.sort(배열, 시작, 끝) 으로 값이 있는 부분만 정렬한다.
 *
 * ⚠ 슬라이드는 Arrays.sort(array, 0, cnt-1) 이다. 틀렸다.
 *   toIndex(끝)는 포함하지 않는다(exclusive). cnt-1 이면 array[0] ~ array[cnt-2] 만 정렬되고
 *   마지막 값은 정렬에서 빠진다.
 *   - 슬라이드 화면의 입력 50 40 30 70 은 마지막 70 이 우연히 가장 커서 맞게 나왔다.
 *   - 50 40 70 30 을 넣으면 "40 50 70 30" 이 나온다.
 *   - 다음 실습 (ScoreSortSearch) 슬라이드에서는 cnt 로 고쳐져 있다. → 여기서도 cnt 로 고쳤다.
 * 💡 "시작 포함, 끝 미포함" [0, cnt) 은 자바 전체의 관례. 개수가 정확히 cnt 개가 된다.
 * 💡 sum 은 선언만 되고 쓰이지 않는다. (앞 실습 코드를 고쳐 쓰다 남은 것) 그대로 두었다.
 *   (클래스 이름은 슬라이드의 ScoreProcessing 이 4주차 예제와 겹쳐서 바꿨다.)
 *
 * 실행 예
 *  0과 100 사이의 값을 입력 (그외 값 종료) :
 *  50
 *  0과 100 사이의 값 입력 (그외 값 종료) :
 *  40
 *  0과 100 사이의 값 입력 (그외 값 종료) :
 *  70
 *  0과 100 사이의 값 입력 (그외 값 종료) :
 *  30
 *  0과 100 사이의 값 입력 (그외 값 종료) :
 *  -1
 *  정렬 전 성적 : 50 40 70 30
 *  정렬 후 성적 : 30 40 50 70
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
        // Arrays.sort(array, 0, cnt-1); // ⚠ 슬라이드 : 마지막 원소가 정렬에서 빠진다
        Arrays.sort(array, 0, cnt);      // [0, cnt) : 값이 들어 있는 부분만 정렬

        System.out.print("정렬 후 성적 : ");
        for (int i = 0; i < cnt; i++) System.out.print(array[i] + " ");
        System.out.println();
        sc.close();
    }
}
