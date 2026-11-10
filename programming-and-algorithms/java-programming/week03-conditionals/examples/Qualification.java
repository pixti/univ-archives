import java.util.Scanner;

/**
 * [3-1 조건문1] if 문 - 복합 조건식 vs 중첩 if 문
 *
 * 나이가 40 이상 && 키가 170 이상 → "자격이 됩니다"
 * 그렇지 않은 경우              → "자격이 안 됩니다"
 *
 * 같은 판단을 두 가지 방법으로 작성해 비교한다.
 *  1) 복합 조건식 : 조건 두 개를 && 로 묶어 if-else 한 번에 처리
 *  2) 중첩 if 문  : if 안에 if 를 넣어 단계적으로 처리
 *
 * 💡 else 는 "가장 가까운, 짝이 없는 if" 와 짝을 이룬다 (dangling else).
 *    중첩할 때는 중괄호로 짝을 분명히 해 두는 것이 안전하다.
 * ⚠ 슬라이드의 “ ” (둥근 따옴표)는 컴파일 에러가 나므로 " " 로 고쳤다.
 *
 * 실행 예
 *  나이 ? 45
 *  키 ? 172
 *  [복합 조건식] 자격이 됩니다
 *  [중첩 if 문 ] 자격이 됩니다
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
