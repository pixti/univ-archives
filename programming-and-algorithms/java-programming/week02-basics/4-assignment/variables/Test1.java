import java.util.Scanner; // ⑥ Scanner 를 쓰려면 import 필요

/**
 * [2강 과제] 변수와 자료형 - 1번
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
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
