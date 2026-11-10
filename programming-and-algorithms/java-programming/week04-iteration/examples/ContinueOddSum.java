/**
 * [4-4 반복문4] continue 문 - 1 ~ 100 홀수의 합
 *
 * 반복문 사용시 특정 조건을 만족하면 continue 이하 문장들은 실행 X → 바로 다음 반복으로.
 *
 * 포인트
 *  - for 에서 continue 를 만나면 증감식(i++)으로 이동한 뒤 조건을 검사한다.
 *  💡 while 에서 continue 를 쓸 때는 조심. 증감 문장이 continue "아래" 에 있으면 건너뛰어져서
 *     i 가 바뀌지 않아 무한루프가 될 수 있다.
 *  - break 는 반복을 "끝내고", continue 는 이번 회차만 "건너뛴다".
 *
 * ⚠ 슬라이드의 for(int i=1; I <= 100; i++) 는 대문자 I 라서 컴파일 에러 → i 로 수정.
 * 💡 출력 "홀수의 합" + sum 은 "홀수의 합2500" 처럼 붙어서 나온다. " : " 을 넣었다.
 *
 * 실행 예
 *  홀수의 합 : 2500
 */
public class ContinueOddSum {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if ((i % 2) == 0) continue;
            sum += i;   // 짝수일때 실행되지 않음
        }
        System.out.println("홀수의 합 : " + sum);
    }
}
