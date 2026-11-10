import java.util.Arrays;
import java.util.Scanner;

/**
 * [5-2 배열2] [실습] 학생 성적 정렬 및 검색하기
 *
 * 포인트
 *  - 정렬과 마찬가지로 탐색도 binarySearch(배열, 시작, 끝, 키) 로 값이 있는 부분만 탐색.
 *    범위를 안 주면 뒤쪽 0 들까지 탐색 대상이 된다.
 *  - 반환값은 인덱스(0부터). 사람에게 보여 줄 때는 i + 1 로 "몇 번째"(1부터)로 바꾼다.
 *  - 음수면 "없음". (BinarySearchTest 참고)
 *
 * ⚠ 슬라이드 실행 화면 속 이클립스 코드는 binarySearch(array, 0, cnt-1, val) 이다.
 *   이러면 마지막(가장 큰) 성적을 검색했을 때 "존재하지 않습니다" 가 나온다. 슬라이드 본문(cnt)이 맞다.
 * ⚠ 본문 코드의 출력 "성적은 2 번째에 " 는 문장이 끝나지 않아서 "존재합니다." 를 붙였다.
 *   (화면에서는 "원하는 성적은 배열의 2 번째에 존재합니다." 로 찍혀 있다.)
 * 💡 sum 은 쓰이지 않는다. (슬라이드 그대로)
 *   (클래스 이름은 슬라이드의 ConditionOperation 에서 바꿨다.)
 *
 * 실행 예  (슬라이드 화면과 같은 입력)
 *  0과 100 사이의 값을 입력 (그외 값 종료) :
 *  50
 *  0과 100 사이 값 입력 (그외 값 종료) :
 *  40
 *  0과 100 사이 값 입력 (그외 값 종료) :
 *  30
 *  0과 100 사이 값 입력 (그외 값 종료) :
 *  70
 *  0과 100 사이 값 입력 (그외 값 종료) :
 *  -1
 *  정렬 후 성적 : 30 40 50 70
 *  찾고자 하는 성적을 입력하세요 : 40
 *  성적은 2 번째에 존재합니다.
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
