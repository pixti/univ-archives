import java.util.Scanner;

/**
 * [4-1 반복문1] [실습] 특정 구구단 출력하기 (while 버전)
 *
 * 원하는 단을 입력받아 dan * 1 ~ dan * 9 를 출력한다.
 *  - index 를 1 로 초기화 → index <= 9 인 동안 반복 → 매번 index++
 *
 * 같은 문제를
 *  - 4-3 에서 for 문으로      → MultiplicationTableFor.java
 *  - 4-4 에서 이중 for 문으로 → MultiplicationTableAll.java (2 ~ 9단 전체)
 *
 * 실행 예
 *  원하는 단 ? 7
 *  7 * 1 = 7
 *  7 * 2 = 14
 *  ...
 *  7 * 9 = 63
 */
public class MultiplicationTableWhile {
    public static void main(String[] args) {
        int dan;

        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 단 ? ");
        dan = sc.nextInt();
        sc.close();

        int index = 1;
        while (index <= 9) {
            System.out.println(dan + " * " + index + " = " + dan * index);
            index++;
        }
    }
}
