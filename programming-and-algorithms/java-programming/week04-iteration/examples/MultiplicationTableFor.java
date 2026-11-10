import java.util.Scanner;

/**
 * [4-3 반복문3] [실습] 특정 구구단 출력하기 (for 버전)
 *
 * 구구단 프로그램(MultiplicationTableWhile.java)을 for 문으로 작성.
 *
 *  while 버전                       for 버전
 *   int index = 1;          (초기식)
 *   while (index <= 9) {    (조건)    →   for (int index = 1; index <= 9; index++) {
 *       ...                                   ...
 *       index++;            (증감식)       }
 *   }
 *
 * → 세 줄에 흩어져 있던 반복 제어가 for 한 줄로 모였다.
 *   반복 횟수(9번)가 정해져 있으므로 for 가 더 읽기 쉽다.
 *
 * 실행 예
 *  원하는 단 ? 3
 *  3 * 1 = 3
 *  3 * 2 = 6
 *  ...
 *  3 * 9 = 27
 */
public class MultiplicationTableFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("원하는 단 ? ");
        int dan = sc.nextInt();
        sc.close();
        for (int index = 1; index <= 9; index++) {
            System.out.println(dan + " * " + index + " = " + dan * index);
        }
    }
}
