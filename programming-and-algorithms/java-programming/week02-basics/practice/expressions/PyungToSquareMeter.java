import java.util.Scanner;

/**
 * [2강 실습] 수식 - 2번 문제
 * 평수를 입력받아 제곱미터(㎡)로 변환하는 프로그램 (1평 = 3.3058㎡)
 * (Eclipse 에서는 Problem2.java 로 작성했던 코드)
 *
 * 📝 필기
 *  - final 은 상수 선언. 한 번 값을 정하면 바꿀 수 없다.
 *  - ★ 기호 상수가 왜 좋은가?
 *    → 같은 값이 여러 군데 쓰일 때, 여러 군데를 찾아가며 수정하기보다 한 곳(상수 선언부)에서만 수정하면 된다.
 *  - 상수 선언은 앞줄에 하는 것이 관례 (변수나 기호 상수 선언들은 위쪽에 모아 둔다).
 *  - 상수 이름은 보통 대문자로 쓴다. (PYUNG)
 *
 * 실행 예
 *  평수 ? 12
 *  12평은 39.6696평방미터 입니다.
 */
public class PyungToSquareMeter {
    public static void main(String[] args) {
        final float PYUNG = 3.3058f; // final 은 상수 선언. float 이므로 f 필수
        Scanner sc = new Scanner(System.in);

        System.out.print("평수 ? ");
        int pyung = sc.nextInt();
        sc.close();

        float area = PYUNG * pyung; // float * int → float (int 가 float 로 자동 형변환)
        System.out.println(pyung + "평은 " + area + "평방미터 입니다.");
    }
}
