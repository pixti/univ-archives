import java.util.Scanner;

/**
 * [2강 실습] 변수와 자료형 - 2번 문제
 * 이름, 나이, 키, 몸무게를 입력받아 한 줄로 출력하는 프로그램
 * (Eclipse 에서는 Test.java 로 작성했던 코드)
 *
 * 실행 예
 *  > 이름 : 홍길동
 *  > 나이 : 9999
 *  > 키 : 170.3
 *  > 몸무게 : 69.75
 *  홍길동, 9999, 170.3, 69.75
 *
 * 📝 필기 - 교수님이 언급하신 "지정자(서식 지정자) printf" 로 출력하는 방법
 *  System.out.printf("%s, %d, %.1f, %.2f\n", name, age, height, weight);
 *   - %s   : 문자열(String)
 *   - %d   : 10진수 정수(int)
 *   - %f   : 실수, 기본 소수점 6자리  (%.1f → 소수점 1자리, %.2f → 소수점 2자리)
 *   - \n   : 줄바꿈 (한글 윈도우 폰트에서는 백슬래시 \ 가 원화 기호 ₩ 로 보이는 것뿐, 같은 문자)
 *   - printf 는 println 과 달리 자동 줄바꿈이 없어서 \n (또는 %n)을 직접 넣어야 한다.
 */
public class PersonInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("> 이름 : ");
        String name = sc.next();
        System.out.print("> 나이 : ");
        int age = sc.nextInt();
        System.out.print("> 키 : ");
        float height = sc.nextFloat();
        System.out.print("> 몸무게 : ");
        float weight = sc.nextFloat();
        sc.close();

        System.out.println(name + ", " + age + ", " + height + ", " + weight);

        // 교수님이 언급하신 지정자 printf 로 하는 방법
        // System.out.printf("%s, %d, %.1f, %.2f\n", name, age, height, weight);
        // %s 문자열 // %d 10진수 정수 int // %f 소수점 6자리, %.2f 하면 소수점 2자리 // \n 줄바꿈
    }
}
