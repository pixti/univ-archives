import java.util.Scanner;

/**
 * [2강 과제] 변수와 자료형 - 2번
 * 학생 정보(이름, 생년월일, 학년, 토익 성적, 평균 학점)를 입력 받아 출력하는 프로그램을 작성하시오.
 *
 * 실행 예
 *  >이름: 김병만
 *  >생년월일: 640824
 *  >학년: 4
 *  >토익 성적: 200
 *  >평균 학점: 4.5
 *  김병만, 640824, 4, 200, 4.5
 *
 * 자료형 선택 이유
 *  - 이름     : String  (문자열)
 *  - 생년월일 : String  (계산에 쓰지 않는 "번호" 성격. int 로 받으면 2000년대생 "010824" 의 앞자리 0 이 사라짐)
 *  - 학년     : int
 *  - 토익 성적 : int
 *  - 평균 학점 : double  (소수점 필요)
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
