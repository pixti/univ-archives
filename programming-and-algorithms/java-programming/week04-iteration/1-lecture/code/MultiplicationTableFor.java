import java.util.Scanner;

/**
 * [4-3 반복문3] [실습] 특정 구구단 출력하기 (for 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
