/**
 * [10-3 상속3] [실습] boxing 과 unboxing
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class BoxingUnBoxingTest {
    public static void main(String[] args) {
        int val = 30;
        Integer iOb = Integer.valueOf(val);   // boxing
        Integer jOb = val;                    // autoboxing

        System.out.println(val + " " + iOb + " " + jOb);

        Integer ob = Integer.valueOf(5);      // 강의 코드 : new Integer(5) (⚠ deprecated)
        int i = ob.intValue();                // unboxing
        int j = ob;                           // autounboxing

        System.out.println(ob + " " + i + " " + j);
    }
}
