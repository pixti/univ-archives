/**
 * [2-1 변수와 자료형1] 프로그램 및 클래스 구성 - 메인 메소드
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class ProgramBasic {
    public static void main(String[] args) {
        // 이 부분은 한 줄짜리 주석
        /* 이 부분은
           여러 줄짜리
           주석 */

        // 명령행 인수 확인용 (추가 코드)
        // 실행 예) java ProgramBasic.java aaa bbb
        System.out.println("전달된 인수 개수 : " + args.length);
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
