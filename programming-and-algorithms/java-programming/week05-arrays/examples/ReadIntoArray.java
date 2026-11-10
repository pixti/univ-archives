import java.util.Scanner;

/**
 * [5-1 배열1] 5. 값 배열에 읽어들이기
 *
 * 몇 개가 입력될지 모를 때 : 최대 크기로 배열을 만들어 두고, 실제 개수는 따로 센다.
 *
 * 포인트
 *  - final int MAX_SIZE = 100; : 바꿀 수 없는 상수. 숫자 대신 이름을 쓰면 뜻이 드러나고 한 곳만 고치면 된다.
 *  - idx 의 두 가지 역할 : "다음에 넣을 위치" 이자 "지금까지 읽은 개수".
 *  - 이후 처리는 array.length(100) 가 아니라 idx 까지만. 나머지 칸은 기본값 0.
 *  - 입력 → 검사 → 처리 → 다시 입력 (4주차와 같은 구조) → 종료 값(음수)은 배열에 안 들어간다.
 *
 * 💡 100 개보다 많이 넣으면 array[100] 에서 ArrayIndexOutOfBoundsException.
 *    안전하게 하려면 while (val >= 0 && idx < MAX_SIZE)
 * ⚠ 슬라이드의 둥근 따옴표 “ “ 를 " " 로 고쳤다. 입력 안내 문구는 슬라이드에 없어서 그대로 두었다.
 *
 * 실행 예
 *  10 20 30 -1
 *  읽어들인 데이터 개수 : 3
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
