import java.util.Scanner;

/**
 * [6-2 실습] 가변 개수의 숫자 더하기
 *
 * 공백으로 구분된 숫자들을 한 줄로 입력받아 합을 구한다. 숫자 개수는 정해져 있지 않다.
 *
 * 포인트
 *  - nextLine() 으로 한 줄 전체 → split(" ") 로 숫자 문자열 배열 → Integer.parseInt 로 정수 변환 후 합산
 *  - 개수를 몰라도 split 결과 배열의 길이만큼 for each 로 돌면 된다.
 *
 * ⚠ 슬라이드의 클래스 이름은 ConditionOperation (3주차 조건 연산 예제 이름이 그대로 남은 것으로 보임).
 *    내용에 맞게 VariableSum 으로 바꿨다.
 * ⚠ split(" ") 는 공백 "한 칸" 만 구분자로 쓴다. "1  2" 처럼 공백이 두 칸이면 빈 문자열 "" 이 생기고
 *    Integer.parseInt("") 에서 NumberFormatException 이 난다. 앞에 공백이 있어도 마찬가지.
 *    → trim().split("\\s+") 를 쓰면 안전하다. (실습 문자열1 1번 · 과제 문자열1 1번 필기 참고)
 *
 * 실행 예
 *  숫자들을 공백으로 구분하여 입력 :
 *  10 20 30 40
 *  100
 */
public class VariableSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자들을 공백으로 구분하여 입력 : ");
        String statement = sc.nextLine();

        String [] split = null;
        split = statement.split(" ");       // 💡 더 안전하게 : statement.trim().split("\\s+")
        int sum = 0;
        for (String s : split) sum += Integer.parseInt(s);
        System.out.println(sum);
        sc.close();
    }
}
