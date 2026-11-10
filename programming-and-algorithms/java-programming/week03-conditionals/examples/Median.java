import java.util.Scanner;

/**
 * [3-1 조건문1] [실습] 3개의 정수 중 중간 값 찾기
 *
 * ⚠ 슬라이드 코드에서 바로잡은 부분
 *  - 클래스명 Meadian, 변수명 meadianVal → 철자 오류라 Median, medianVal 로 수정
 *  - 세 번째 입력 안내문이 "두 번째 숫자" 로 되어 있어 "세 번째 숫자" 로 수정
 *    (실행 화면 캡처에도 "두 번째" 가 두 번 출력된다)
 *
 * 풀이 아이디어
 *  - 먼저 s1 > s2 로 두 수의 대소를 정해 둔다.
 *  - 그다음 s3 가 어디에 끼어드는지 (맨 위 / 가운데 / 맨 아래) 만 따지면 된다.
 *
 * 💡 실행 화면 캡처의 코드는 s1 > s2 블록 안이
 *      if (s2 > s3) s2;  else if (s1 > s3) s3;  else s1;
 *    로 슬라이드와 비교 순서만 다르다. 두 방식 모두 정답.
 *
 * 실행 예
 *  첫 번째 숫자 (음수도 가능) >>
 *  5
 *  두 번째 숫자 (음수도 가능) >>
 *  7
 *  세 번째 숫자 (음수도 가능) >>
 *  9
 *  중간값 : 7
 */
public class Median {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 숫자 (음수도 가능) >> ");
        int s1 = sc.nextInt();
        System.out.println("두 번째 숫자 (음수도 가능) >> ");
        int s2 = sc.nextInt();
        System.out.println("세 번째 숫자 (음수도 가능) >> ");
        int s3 = sc.nextInt();
        sc.close();

        int medianVal;
        if (s1 > s2) {
            if (s2 > s3)
                medianVal = s2;     // s1 > s2 > s3
            else if (s3 > s1)
                medianVal = s1;     // s3 > s1 > s2
            else
                medianVal = s3;     // s1 >= s3 >= s2
        }
        else {                      // s2 >= s1
            if (s1 > s3)
                medianVal = s1;     // s2 >= s1 > s3
            else if (s2 < s3)
                medianVal = s2;     // s3 > s2 >= s1
            else
                medianVal = s3;     // s2 >= s3 >= s1
        }
        System.out.println("중간값 : " + medianVal);
    }
}
