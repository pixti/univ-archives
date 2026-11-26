import java.util.Scanner;

/**
 * [3-1 조건문1] [실습] 3개의 정수 중 중간 값 찾기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
