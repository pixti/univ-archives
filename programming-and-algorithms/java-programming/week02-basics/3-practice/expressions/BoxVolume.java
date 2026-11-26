import java.util.Scanner;

/**
 * [2강 실습] 수식 - 1번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class BoxVolume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("높이 ? ");
        int height = sc.nextInt();
        System.out.print("너비 ? ");
        int width = sc.nextInt();
        System.out.print("길이 ? ");
        int length = sc.nextInt();
        sc.close();

        int volume = height * width * length;
        System.out.println("상자의 체적은 " + volume + " 입니다.");
    }
}
