import java.util.Random;
import java.util.Scanner;

/**
 * [3-3 조건문3] [실습] 홀짝 맞히기
 *
 * 참고) 난수(Random) 만들기
 *  - java.util.Random 을 import 한 뒤 new Random() 으로 객체를 만든다.
 *  - rnd.nextInt(n) : 0 이상 n 미만의 정수.  nextInt(100) → 0 ~ 99
 *    (1 ~ 100 을 원하면 rnd.nextInt(100) + 1)
 *  - 다른 방법: (int) (Math.random() * n)  → 과제 RockPaperScissors.java 에서 사용
 *  - 2주차에 배운 조건 연산자 ?: 로 정답 문자를 한 줄에 결정했다.
 *
 * ⚠ 슬라이드는 출력 문자열을 두 줄에 걸쳐 써 놓았다.
 *   자바의 문자열 리터럴은 줄을 넘길 수 없어 컴파일 에러가 나므로 한 줄로 합쳤다.
 *   (길면 "..." + "..." 로 나눠 쓴다)
 *
 * 실행 예
 *  짝수라 생각하면 e를, 홀수라고 생각하면 o를 입력하세요 :
 *  o
 *  축하합니다!!!
 */
public class OddEven {
    public static void main(String[] args) {
        Random rnd = new Random();
        int quest = rnd.nextInt(100);                 // 무작위로 범위 내 숫자가 나옴 (0 ~ 99)
        char answer = (quest % 2) == 0 ? 'e' : 'o';   // 짝수(even) 'e', 홀수(odd) 'o'

        Scanner sc = new Scanner(System.in);
        System.out.println("짝수라 생각하면 e를, "
                + "홀수라고 생각하면 o를 입력하세요 : ");
        char guess = sc.next().charAt(0);
        sc.close();

        if (guess == answer)
            System.out.println("축하합니다!!!");
        else
            System.out.println("다음 기회에 ...");

        System.out.println("(정답 숫자 : " + quest + ")");  // 확인용으로 추가한 출력
    }
}
