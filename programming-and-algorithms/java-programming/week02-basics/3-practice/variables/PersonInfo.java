import java.util.Scanner;

/**
 * [2강 실습] 변수와 자료형 - 2번 문제
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
