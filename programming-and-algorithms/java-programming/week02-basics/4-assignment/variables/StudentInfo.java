import java.util.Scanner;

/**
 * [2강 과제] 변수와 자료형 - 2번
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class StudentInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print(">이름: ");
        String name = sc.next();
        System.out.print(">생년월일: ");
        String birth = sc.next();
        System.out.print(">학년: ");
        int grade = sc.nextInt();
        System.out.print(">토익 성적: ");
        int toeic = sc.nextInt();
        System.out.print(">평균 학점: ");
        double gpa = sc.nextDouble();
        sc.close();

        System.out.println(name + ", " + birth + ", " + grade + ", " + toeic + ", " + gpa);
    }
}
