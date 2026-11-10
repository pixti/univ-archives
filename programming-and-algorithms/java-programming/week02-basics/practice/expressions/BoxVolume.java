import java.util.Scanner;

/**
 * [2강 실습] 수식 - 1번 문제
 * 상자의 높이, 너비, 길이를 입력받아 체적(부피)을 구하는 프로그램
 * (Eclipse 에서는 Problem1.java 로 작성했던 코드)
 *
 * 📝 필기
 *  - import 없이 Scanner 를 쓰면 빨간 줄이 생긴다.
 *    마우스를 올려서 나오는 빠른 수정 목록 중 맨 위의 "'Scanner' (java.util) 가져오기" 를 선택하면
 *    맨 위에 import java.util.Scanner; 가 자동으로 추가된다.
 *
 * 실행 예
 *  높이 ? 5
 *  너비 ? 4
 *  길이 ? 8
 *  상자의 체적은 160 입니다.
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
