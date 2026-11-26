/**
 * [4-3 반복문3] for 문 - 반복 변수의 범위 / 무한 반복
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ForScope {
    public static void main(String[] args) {
        int cnt;                            // for 앞에서 선언
        for (cnt = 1; cnt <= 5; cnt++) {
            System.out.println("사랑합니다.");
        }
        System.out.println("반복이 끝난 뒤 cnt = " + cnt);

        // for (int k = 1; k <= 5; k++) { }
        // System.out.println(k);           // 오류 : k 는 for 안에서만 사용 가능

        // ===== 무한 반복 =====
        int n = 0;
        for (;;) {
            n++;
            if (n == 3) break;
        }
        System.out.println("for(;;) " + n + "번 반복 후 break");
    }
}
