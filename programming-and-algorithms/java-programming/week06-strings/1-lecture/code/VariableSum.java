import java.util.Scanner;

/**
 * [6-2 실습] 가변 개수의 숫자 더하기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
