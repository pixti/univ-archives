import java.util.Scanner;

/**
 * [4강 과제] 반복문1 - 1번 문제
 * ※ 반복 시 while 이나 do while 문만 사용하시오.
 *
 * 특정한 정수를 읽어 들여서 0 과 이 정수 사이에 있는 모든 3 의 배수를 출력하는 프로그램을 작성하라.
 * 만약 입력 정수의 값이 0 보다 작으면 오류 메시지를 출력하라.
 *
 * 포인트
 *  - i 를 3 부터 시작해서 3 씩 증가 → 3 의 배수만 돈다.
 *    (1 부터 1 씩 증가하며 if (i % 3 == 0) 으로 거르는 방법도 있지만 반복 횟수가 3 배)
 *  - 0 은 3 의 배수이지만 문제의 출력 예가 [3] 부터 시작하므로 i = 3 에서 시작했다.
 *  - 입력이 0 ~ 2 이면 조건 i <= num 이 처음부터 거짓 → 아무것도 출력하지 않는다.
 *  - i 는 else 블록 안에서만 쓰지만, 선언은 블록 밖에서 했다. (int num, i;)
 *    블록 안에서 int i = 3; 으로 선언해도 된다. (퀴즈 "선언 위치" 참고)
 *
 * 💡 리팩터링 버전 → MultiplesOfThreeRefactored.java
 *
 * 문제의 실행 예
 *  정수를 입력하세요 : 40
 *  [3]
 *  [6]
 *  ...
 *  [36]
 *  [39]
 *
 * 내 코드 실행 예
 *  정수를 입력하세요 : 16
 *  [3]
 *  [6]
 *  [9]
 *  [12]
 *  [15]
 */
public class MultiplesOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num, i;
        System.out.print("정수를 입력하세요 : ");
        num = sc.nextInt();

        if (num < 0) {
            System.out.println("오류");
        } else {
            i = 3;

            while (i <= num) {
                System.out.println("[" + i + "]");
                i += 3;
            }
        }
        sc.close();
    }
}
