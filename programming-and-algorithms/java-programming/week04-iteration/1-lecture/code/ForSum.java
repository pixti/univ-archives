/**
 * [4-3 반복문3] for 문 - 파이썬 for 문을 자바 for 문으로 / 증감식의 여러 형태
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ForSum {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 10; i > 0; i--) {  // 한줄인 경우 중괄호 생략 가능
            sum += i;
        }
        System.out.println("합 : " + sum);

        // ===== 증감식의 여러 형태 =====
        int i;

        sum = 0;
        for (i = 1; i <= 10; i++) {         // 하나씩 증가
            sum = sum + i;
        }
        System.out.println("하나씩 증가 : " + sum);

        sum = 0;
        for (i = 10; i >= 1; i--) {         // 하나씩 감소
            sum = sum + i;
        }
        System.out.println("하나씩 감소 : " + sum);

        sum = 0;
        for (i = 1; i < 10; i = i + 3) {    // 세개씩 증가 (1 + 4 + 7)
            sum = sum + i;
        }
        System.out.println("세개씩 증가 : " + sum);
    }
}
