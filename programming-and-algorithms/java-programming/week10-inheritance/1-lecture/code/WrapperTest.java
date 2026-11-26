/**
 * [10-3 상속3] Wrapper(포장) 클래스
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class WrapperTest {
    public static void main(String[] args) {
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Integer.SIZE = " + Integer.SIZE);

        Integer iObj = Integer.valueOf(30);   // boxing 과정 (강의 코드 : new Integer(30), ⚠ deprecated)
        int age2 = iObj.intValue();           // unboxing 과정
        System.out.println("boxing " + iObj + " → unboxing " + age2);

        int i = 123;
        Integer o = i;                        // autoboxing
        int j = o;                            // autounboxing
        System.out.println("autoboxing " + o + " → autounboxing " + j);

        Double dObj = 1.23;                   // autoboxing (double → Double)
        // int n2 = dObj;                     // ❌ 오류 발생 : Double 은 int 와 상응하지 않는다
        int n = dObj.intValue();
        System.out.println("dObj.intValue() = " + n);

        System.out.println("Integer.parseInt(\"123\") + 1 = " + (Integer.parseInt("123") + 1));   // 💡

        Integer a = 1000, b = 1000;           // 💡 비교는 equals
        System.out.println("equals : " + a.equals(b));
    }
}
