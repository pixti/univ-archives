import java.util.Scanner;

/**
 * [3-1 조건문1] else if 문 - 점수에 따른 학점 판단
 *
 * else if 는 "순차적으로 진행" 된다!
 *  → 어느 조건이 true 이면 그 블록만 실행하고, 다음 조건문들은 실행(검사)되지 않는다.
 *
 * 슬라이드의 첫 번째 버전 (불필요한 조건 포함)
 *   if (score >= 90) ...A
 *   else if (score < 90 && score >= 80) ...B
 *   else if (score < 80 && score >= 70) ...C
 *   else if (score < 70 && score >= 60) ...D
 *   else ...F
 *  → 두 번째 조건까지 왔다는 것은 이미 score >= 90 이 거짓이라는 뜻.
 *    즉 score < 90 은 항상 참이므로 "불필요한 조건 생략!" → 아래 수정 버전
 *
 * 📝 필기 (퀴즈 3-② 와 연결)
 *  조건의 "순서" 가 틀리면 논리 오류가 난다.
 *   if (grade >= 2.0) C  else if (grade >= 3.0) B
 *   → 3.0 이상도 첫 조건(>= 2.0)에서 먼저 걸려 C 가 출력된다.
 *  → 이 예제처럼 큰 값부터 검사해야 한다.
 *
 * 실행 예
 *  점수 ? 85
 *  B 학점 입니다
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
