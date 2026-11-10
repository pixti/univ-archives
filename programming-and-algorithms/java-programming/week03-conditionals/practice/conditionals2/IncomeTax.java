import java.util.Scanner;

/**
 * [3강 실습] 조건문2 - 3번 문제
 * 월급에 붙는 소득세를 계산하여 보자.
 *  - 1000만원 이하                 : 8%
 *  - 1000만원 초과 4000만원 이하   : 17%
 *  - 4000만원 초과 8000만원 이하   : 26%
 *  - 8000만원 초과                 : 35%
 *
 * 📝 필기
 *  - 강제 형변환 필요함. 0.35 는 double 임, tax 는 int 임.
 *    → income * 0.35 는 int * double = double 이라서 int 변수에 그냥 넣으면 컴파일 에러.
 *      (int) (income * 0.35) 로 강제 형변환해야 한다. (소수점 아래는 버려진다)
 *
 * 포인트
 *  - 큰 구간부터 검사한다 (> 8000 → > 4000 → > 1000 → 나머지).
 *    위에서 이미 걸러졌으므로 "4000만원 초과 8000만원 이하" 를 income > 4000 하나로 쓸 수 있다.
 *    (퀴즈 3-② 와 같은 이야기 : else if 는 조건의 순서가 중요하다)
 *
 * 💡 문제의 예(7600 → 1976 = 7600 * 0.26)처럼 "전체 금액에 한 세율" 을 적용했다.
 *    실제 소득세는 구간별로 나눠 계산하는 누진세라 결과가 다르다.
 * 💡 문제는 "월급" 이라고 했지만 금액 단위상 연봉으로 보고 안내문을 "연봉 입력" 으로 썼다.
 * 💡 (int) income * 0.35 처럼 괄호 없이 쓰면 income 만 int 로 바뀌고 결과는 여전히 double 이라 에러.
 *    곱셈 전체를 괄호로 감싸야 한다.
 *
 * 문제의 실행 예  (입력 : 7600)
 *  1976
 *
 * 내 코드 실행 예
 *  연봉 입력 : ? 만원 7000
 *  소득세는 1820만원 입니다.
 */
public class IncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("연봉 입력 : ? 만원 ");
        int income = sc.nextInt();
        sc.close();

        int tax = 0;
        if (income > 8000) {
            tax = (int) (income * 0.35);     // 📝 0.35 는 double → 강제 형변환
        }
        else if (income > 4000) {
            tax = (int) (income * 0.26);
        }
        else if (income > 1000) {
            tax = (int) (income * 0.17);
        }
        else {
            tax = (int) (income * 0.08);
        }

        System.out.print("소득세는 " + tax + "만원 입니다.");
    }
}
