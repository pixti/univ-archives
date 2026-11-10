import java.util.Scanner;

/**
 * [5강 과제] 배열(1) - 1번 문제 (리팩터링 버전)
 *
 * ReverseInput.java 를 AI 의 도움을 받아 리팩터링한 코드. (주석은 원본 그대로)
 *
 * 바뀐 점
 *  - try-with-resources : try (Scanner scanner = ...) { } 블록이 끝나면 Scanner 가 자동으로 닫힌다.
 *    sc.close() 를 잊어버릴 일이 없다.
 *  - 변수 이름 sc, arr, i → scanner, numbers, index
 *  - 반복 조건의 숫자 10, 9 → numbers.length, numbers.length - 1
 *    배열 크기(new int[10])만 바꾸면 반복문은 그대로 동작한다.
 *  - 마지막에 줄바꿈 추가.
 *
 * 💡 "10개의 정수 입력" 의 10 은 여전히 숫자로 적혀 있다. 크기를 바꾸면 이 문구도 같이 고쳐야 한다.
 *    상수(private static final int COUNT = 10;)로 빼면 완전히 한 곳에서 관리할 수 있다.
 *
 * 실행 예
 *  10개의 정수 입력
 *  1 2 3 4 5 6 7 8 9 10
 *  역순 출력:
 *  10 9 8 7 6 5 4 3 2 1
 */
public class ReverseInputRefactored {
    public static void main(String[] args) {
        // 표준 입력을 읽기 위한 Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            int[] numbers = new int[10];

            System.out.println("10개의 정수 입력");
            // 배열의 길이를 기준으로 입력을 읽습니다.
            for (int index = 0; index < numbers.length; index++) {
                numbers[index] = scanner.nextInt();
            }

            System.out.println("역순 출력:");
            // 마지막 원소부터 첫 번째 원소까지 출력합니다.
            for (int index = numbers.length - 1; index >= 0; index--) {
                System.out.print(numbers[index] + " ");
            }
            System.out.println();
        }
    }
}
