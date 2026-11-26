import java.util.Scanner;

/**
 * [2강 실습] 수식 - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class PyungToSquareMeter {
    public static void main(String[] args) {
        final float PYUNG = 3.3058f; // final 은 상수 선언. float 이므로 f 필수
        Scanner sc = new Scanner(System.in);

        System.out.print("평수 ? ");
        int pyung = sc.nextInt();
        sc.close();

        float area = PYUNG * pyung; // float * int → float (int 가 float 로 자동 형변환)
        System.out.println(pyung + "평은 " + area + "평방미터 입니다.");
    }
}
