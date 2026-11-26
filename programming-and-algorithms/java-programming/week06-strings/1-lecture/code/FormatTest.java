/**
 * [6-2] String 클래스 - 문자열 포맷하기 (printf · String.format)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class FormatTest {
    public static void main(String[] args) {
        String depart = "컴퓨터공학";
        int max = 98, min = 72;
        double avg = 256 / 3.0;   // 85.333...

        // PrintStream 의 printf 메소드 사용
        String formatStr = "학과 %s - 최대값 : %d, 최소값 : %d, 평균 : %.1f";
        System.out.printf(formatStr, depart, max, min, avg);
        System.out.println();   // 💡 printf 는 줄바꿈을 하지 않는다 (formatStr 끝에 %n 을 붙여도 됨)

        // String 클래스의 format 메소드로 재작성
        formatStr = "학과 %s - 최대값 : %d, 최소값 : %d, 평균 : %f";
        String fs = String.format(formatStr, depart, max, min, avg);
        System.out.println(fs);
    }
}
