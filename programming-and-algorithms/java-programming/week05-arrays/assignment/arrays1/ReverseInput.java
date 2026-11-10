import java.util.Scanner;

/**
 * [5강 과제] 배열(1) - 1번 문제
 *
 * 10 개의 정수를 입력받아 배열에 저장한 뒤, 역순으로 출력하는 프로그램을 작성하시오.
 *
 * 포인트
 *  - 입력 : i = 0 → 9 순서로 arr[i] 에 저장
 *  - 출력 : i = 9 → 0 순서로 거꾸로 읽기 (i--)
 *  - 배열 자체를 뒤집는 것(실습 배열(1) 4번)이 아니라 "읽는 순서" 만 거꾸로 한다. 배열은 그대로.
 *
 * 💡 숫자 10, 9 대신 arr.length, arr.length - 1 을 쓰면 개수를 바꿔도 한 곳만 고치면 된다.
 *    (리팩터링 버전이 그렇게 했다 → ReverseInputRefactored.java)
 * 💡 10 개를 한 줄에 공백으로 띄워 입력해도, 하나씩 엔터를 쳐도 된다.
 *
 * 실행 예
 *  10개의 정수 입력
 *  1 2 3 4 5 6 7 8 9 10
 *  역순 출력 :
 *  10 9 8 7 6 5 4 3 2 1
 */
public class ReverseInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        System.out.println("10개의 정수 입력");
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("역순 출력 : ");
        for (int i = 9; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
