import java.util.Random;
import java.util.Scanner;

/**
 * [3-3 조건문3] [실습] 홀짝 맞히기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
