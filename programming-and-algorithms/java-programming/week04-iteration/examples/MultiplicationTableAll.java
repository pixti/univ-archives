/**
 * [4-4 반복문4] [실습] 구구단 전체 출력하기 (이중 for 문)
 *
 * 4-1, 4-3 의 "특정 구구단 출력하기" 는 단(dan)을 입력받았다.
 * 이번에는 단을 바깥 for 로 2 ~ 9 까지 돌리면서, 안쪽에 그 코드를 그대로 넣었다.
 *
 *  바깥 for (dan)   : 2 → 3 → ... → 9
 *  안쪽 for (index) : 매번 1 → 9
 *  → println 은 8 × 9 = 72 번 실행된다.
 *
 * 실행 예
 *  2단
 *  2 * 1 = 2
 *  2 * 2 = 4
 *  ...
 *  2 * 9 = 18
 *
 *  3단
 *  3 * 1 = 3
 *  ...
 *  9 * 9 = 81
 */
public class MultiplicationTableAll {
    public static void main(String[] args) {
        int dan, index;
        for (dan = 2; dan <= 9; dan++) {
            System.out.println(dan + "단");
            for (index = 1; index <= 9; index++) {
                System.out.println(dan + " * " + index + " = " + dan * index);
            }
            System.out.println("");
        }
    }
}
