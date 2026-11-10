/**
 * [6-2] String 클래스 - 문자열 포맷하기 (printf · String.format)
 *
 * 포인트
 *  - java.io.PrintStream 클래스(System.out 의 타입)의 printf, format 으로 결과를 포맷해서 "출력" 한다.
 *  - String 클래스의 format 은 출력하지 않고 결과를 String 객체로 "반환" 한다.
 *    → 나중에 다시 쓰거나, 파일에 저장하거나, 다른 문자열과 합칠 때 유용.
 *
 * 💡 자주 쓰는 서식 지정자
 *      %s  문자열        %d  정수        %f  실수 (기본 소수점 6자리)
 *      %.1f 소수점 1자리  %5d 폭 5칸 오른쪽 정렬   %-5d 왼쪽 정렬   %n 줄바꿈
 *
 * ⚠ 슬라이드는 변수 depart, max, min, avg 가 선언되어 있지 않고 따옴표도 “ ” 라 그대로 실행되지 않는다.
 *    값을 임의로 넣어 실행 가능하게 만들었다.
 *    슬라이드는 String formatStr 을 두 번 선언해서 컴파일 에러(variable already defined)가 난다.
 *    → 두 번째는 선언 없이 formatStr = ... 로 다시 대입했다.
 *    또 두 번째 formatStr 은 %f 라서 평균이 소수점 6자리(85.333333)로 나온다. 첫 번째와 같게 하려면 %.1f.
 *
 * 실행 결과
 *  학과 컴퓨터공학 - 최대값 : 98, 최소값 : 72, 평균 : 85.3
 *  학과 컴퓨터공학 - 최대값 : 98, 최소값 : 72, 평균 : 85.333333
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
