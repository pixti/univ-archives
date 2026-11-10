import java.util.Scanner; // ⑥ Scanner 를 쓰려면 import 필요

/**
 * [2강 과제] 변수와 자료형 - 1번
 * 다음 프로그램의 오류를 수정하시오.
 *
 * ── 원본 코드 ──────────────────────────────────────────
 *   public class Test1 {
 *       public static void main(String[] args) {
 *           String s = 'abc';
 *           System.out.print(s);
 *
 *           double d = 12.3
 *           int f = d; // double 형을 int 형으로 저장
 *           System.out.print(f);
 *
 *           Scanner sc = new Scanner(System.in);
 *           double db = sc.next();
 *           System.out.print(db);
 *           sc.close();
 *           String s = sc.next();
 *           System.out.print(s);
 *       }
 *   }
 *
 * ── 오류 목록 ──────────────────────────────────────────
 *  ① String s = 'abc';
 *     → 작은따옴표는 문자(char) 하나만. 문자열은 큰따옴표 "abc" 로 감싸야 한다.
 *  ② double d = 12.3
 *     → 세미콜론(;) 누락
 *  ③ int f = d;
 *     → double(8byte) → int(4byte) 는 정보 손실 가능성 때문에 자동 형변환이 안 된다.
 *       강제 형변환 int f = (int) d; 필요 (f 에는 12 저장, 소수점 이하 버림)
 *  ④ double db = sc.next();
 *     → sc.next() 의 반환형은 String. 실수를 읽으려면 sc.nextDouble() 사용
 *  ⑤ sc.close(); 후에 sc.next() 호출
 *     → 닫힌 Scanner 를 사용하면 실행 중 IllegalStateException 발생.
 *       close() 는 입력을 모두 받은 뒤 마지막에 호출해야 한다.
 *  ⑥ Scanner 를 import 하지 않음
 *     → import java.util.Scanner; 추가
 *  ⑦ String s = sc.next();
 *     → 같은 메소드 안에서 변수 s 를 다시 선언 (중복 선언 에러).
 *       다른 이름(s2)을 쓰거나 s = sc.next(); 로 재대입
 *
 * 실행 예 (입력: 3.14 hello)
 *  abc123.14hello
 */
public class Test1 {
    public static void main(String[] args) {
        String s = "abc";              // ① ' ' → " "
        System.out.print(s);

        double d = 12.3;               // ② 세미콜론 추가
        int f = (int) d;               // ③ 강제 형변환 (double 형을 int 형으로 저장)
        System.out.print(f);

        Scanner sc = new Scanner(System.in);
        double db = sc.nextDouble();   // ④ next() → nextDouble()
        System.out.print(db);

        String s2 = sc.next();         // ⑦ 변수 중복 선언 해결
        System.out.print(s2);
        sc.close();                    // ⑤ 다 쓴 후 마지막에 close
    }
}
