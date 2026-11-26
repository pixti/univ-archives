/**
 * [4-4 반복문4] [실습] 구구단 전체 출력하기 (이중 for 문)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
