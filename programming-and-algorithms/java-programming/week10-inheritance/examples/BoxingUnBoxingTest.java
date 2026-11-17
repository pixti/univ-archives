/**
 * [10-3 상속3] [실습] boxing 과 unboxing
 *
 * 포인트
 *  - boxing      : Integer iOb = Integer.valueOf(val);   기본형 → 포장 객체 (메소드로 직접)
 *  - autoboxing  : Integer jOb = val;                    컴파일러가 Integer.valueOf(val) 로 바꿔 준다
 *  - unboxing    : int i = ob.intValue();                포장 객체 → 기본형 (메소드로 직접)
 *  - autounboxing: int j = ob;                           컴파일러가 ob.intValue() 로 바꿔 준다
 *  - println 에 포장 객체를 넣으면 toString() 이 불려 안의 값이 출력된다.
 *
 * ⚠ 자주 틀리는 부분 : 강의 코드의 Integer ob = new Integer(5); 는 JDK 9 부터 deprecated(사용 자제)다.
 *    JDK 25 에서도 컴파일은 되지만 "uses or overrides a deprecated API" 안내가 나온다.
 *      (-Xlint 로 컴파일하면) warning: [deprecation] Integer(int) in Integer has been deprecated
 *    Integer.valueOf(5) 로 바꿔 썼다. 결과는 같다.
 * ⚠ 자주 틀리는 부분 : null 인 포장 객체를 autounboxing 하면 NullPointerException 이 난다.
 *      Integer none = null;  int k = none;   → 실행 오류 (none.intValue() 를 부르는 것과 같기 때문)
 *
 * 실행 결과
 *  30 30 30
 *  5 5 5
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
