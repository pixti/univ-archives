import java.util.Scanner;

/**
 * [4강 과제] 반복문2 - 1번 문제
 * 📝 반복문2 과제는 for문으로 작성.
 *
 * 특정한 정수를 읽어 들여서 0 과 이 정수 사이에 있는 모든 3 의 배수를 출력하는 프로그램을 작성하라.
 * 만약 입력 정수의 값이 0 보다 작으면 오류 메시지를 출력하라.
 *
 * 포인트
 *  - 반복문1(iteration1/MultiplesOfThree.java) 의 while 을 for 로 옮긴 것.
 *
 *      i = 3;                         for (int i = 3; i <= num; i += 3) {
 *      while (i <= num) {        →        System.out.println("[" + i + "]");
 *          System.out.println(...);   }
 *          i += 3;
 *      }
 *
 *    초기식 / 조건식 / 증감식이 한 줄에 모여서 "3 부터 num 까지 3 씩" 이 한눈에 보인다.
 *  - i 를 for 의 초기식에서 선언 → i 는 for 문 안에서만 쓸 수 있다. (반복문1 에서는 바깥에 선언)
 *
 * 💡 리팩터링 버전 → MultiplesOfThreeForRefactored.java
 *
 * 문제의 실행 예
 *  정수를 입력하세요 : 40
 *  [3]
 *  [6]
 *  ...
 *  [39]
 *
 * 내 코드 실행 예
 *  정수를 입력하세요 : 19
 *  [3]
 *  [6]
 *  [9]
 *  [12]
 *  [15]
 *  [18]
 */
public class MultiplesOfThreeFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        System.out.print("정수를 입력하세요 : ");
        num = sc.nextInt();

        if (num < 0) {
            System.out.println("오류");
        } else {
            for (int i = 3; i <= num; i += 3) {
                System.out.println("[" + i + "]");
            }
        }
        sc.close();
    }
}
