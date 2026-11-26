import java.util.Scanner;

/**
 * [3-1 조건문1] else if 문 - 점수에 따른 학점 판단
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class Grade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("점수 ? ");
        int score = sc.nextInt();
        sc.close();

        // 수정 버전
        if (score >= 90)
            System.out.println("A 학점 입니다");
        else if (score >= 80)       // 여기까지 왔다면 score < 90 은 이미 참
            System.out.println("B 학점 입니다");
        else if (score >= 70)
            System.out.println("C 학점 입니다");
        else if (score >= 60)
            System.out.println("D 학점 입니다");
        else
            System.out.println("F 학점 입니다");
    }
}
