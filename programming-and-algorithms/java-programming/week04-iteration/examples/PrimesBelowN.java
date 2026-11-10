import java.util.Scanner;

/**
 * [4-4 반복문4] [실습] n보다 작은 소수 찾기 (이중 for 문 + break)
 *
 * "소수 판별하기"(PrimeCheck.java)를 바깥 for 로 감싸서 2 ~ n-1 의 모든 수(p)를 검사한다.
 *
 * 포인트
 *  - 안쪽 for 의 break 는 "안쪽 for 만" 빠져나온다. 바깥 for(p)는 계속 돈다.
 *  - result = result + " " + p : 문자열에 소수를 이어 붙여 두었다가 마지막에 한 번에 출력.
 *    첫 소수 앞에도 공백이 붙어서 ":" 뒤에 공백이 두 칸 나온다.
 *
 * ⚠ 실행 화면 캡처의 코드는 슬라이드 본문과 다르다.
 *   String result = "1"; / for (p = 3; ...) 로 되어 있어 결과가 "1 3 5 7 11 ..." 로 나온다.
 *   → 1 은 소수가 아니고, 2 (유일한 짝수 소수)가 빠져 있다.
 *   슬라이드 본문 코드 (result = "", p = 2) 가 맞다. 이 파일은 본문 코드를 따랐다.
 * 💡 슬라이드의 클래스 이름은 ConditionOperation. 내용에 맞게 PrimesBelowN 으로 바꿨다.
 *
 * 실행 예
 *  n의 값을 입력하시오.
 *  100
 *  100 보다 작은 소수 :  2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
 */
public class PrimesBelowN {
    public static void main(String[] args) {
        System.out.println("n의 값을 입력하시오. ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String result = "";
        int i, p;
        for (p = 2; p < n; p++) {
            for (i = 2; i < p; i++) {
                if ((p % i) == 0) break;    // 안쪽 for 만 빠져나옴
            }
            if (i == p) result = result + " " + p;
        }
        System.out.println(n + " 보다 작은 소수 : " + result);
        sc.close();
    }
}
