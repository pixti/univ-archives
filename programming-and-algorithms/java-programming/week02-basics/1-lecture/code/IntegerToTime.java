import java.util.Scanner; // 이 줄이 없으면 Scanner 를 찾지 못해 컴파일 에러

/**
 * [2-5 수식1] [실습] 임의의 양의 정수값을 시분초로 변환하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class IntegerToTime {
    public static void main(String[] args) {
        System.out.println("숫자 입력 >> ");
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성
        int i = sc.nextInt();                // 정수 입력
        sc.close();                          // 사용 후 꼭! 닫아줌

        int hour = i / 3600;
        int remain = i % 3600;
        int minute = remain / 60;
        int second = remain % 60;
        System.out.println(hour + "시 " + minute + "분 " + second + "초");
    }
}
