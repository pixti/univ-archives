import java.util.Scanner;

/**
 * [4-1 반복문1] [실습] 특정 구구단 출력하기 (while 버전)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
