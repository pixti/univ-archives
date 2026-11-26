import java.util.Scanner;

/**
 * [3-1 조건문1] if 문 - 복합 조건식 vs 중첩 if 문
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Qualification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("나이 ? ");
        int age = sc.nextInt();
        System.out.print("키 ? ");
        int height = sc.nextInt();
        sc.close();

        // 1) 복합 조건식
        System.out.print("[복합 조건식] ");
        if (age >= 40 && height >= 170) {
            System.out.println("자격이 됩니다");
        }
        else {
            System.out.println("자격이 안 됩니다");
        }

        // 2) 중첩 if 문 - 실행문이 한 줄이라 중괄호 생략 가능
        System.out.print("[중첩 if 문 ] ");
        if (age >= 40) {
            if (height >= 170)
                System.out.println("자격이 됩니다");
            else
                System.out.println("자격이 안 됩니다");  // 나이는 되지만 키가 미달
        }
        else
            System.out.println("자격이 안 됩니다");      // 나이가 미달
    }
}
