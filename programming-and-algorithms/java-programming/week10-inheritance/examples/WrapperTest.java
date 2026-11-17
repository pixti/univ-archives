/**
 * [10-3 상속3] Wrapper(포장) 클래스
 *
 * 포인트
 *  - 기본형 타입을 객체로 사용해야 하는 경우에 쓴다. Wrapper 클래스는 기본형 자료에 대한 메소드를 제공한다.
 *      int → Integer,   double → Double,   byte → Byte
 *      short → Short,   long → Long,       float → Float
 *      char → Character, boolean → Boolean, void → Void
 *  - Void 클래스는 실체화(객체 생성)될 수 없으며 단지 "공 참조(null)" 개념이다.
 *  - Void 를 제외한 포장 클래스의 생성자는 저장할 기본형 타입 값을 인수로 받는다.
 *  - 포장 클래스는 다양한 메소드 및 상수를 제공한다.
 *      Integer.MAX_VALUE : int 형 변수가 가질 수 있는 최대값
 *      Integer.MIN_VALUE : int 형 변수가 가질 수 있는 최소값
 *      Integer.SIZE      : int 형 변수의 비트 크기
 *  - boxing : 기본 자료형을 포장 클래스로 변환     Integer iObj = new Integer(30);
 *    unboxing : 포장 클래스를 기본 자료형으로 변환  int age2 = iObj.intValue();
 *  - JDK 1.5 이후는 자동으로 boxing, unboxing 이 처리되는 autoboxing, autounboxing 을 제공한다.
 *      int i = 123;
 *      Integer o = i;   // autoboxing      i [123]     o [ ●─]──▶ [int : 123]   (o 는 객체를 가리킨다)
 *      int j = o;       // autounboxing    j [123]
 *  - autoboxing 과 autounboxing 은 기본형 타입과 그에 상응하는 포장 클래스 사이에서만 일어난다. 다른 경우 컴파일 에러가 난다.
 *      Double dObj = 1.23;
 *      int n2 = dObj;              // ❌ 오류 발생 : error: incompatible types: Double cannot be converted to int
 *      int n = dObj.intValue();    // ✅ 메소드로 직접 변환 (소수점 이하 버림 → 1)
 *
 * ⚠ 자주 틀리는 부분 : new Integer(30) 처럼 포장 클래스의 생성자를 쓰는 방법은 JDK 9 부터 deprecated(사용 자제)라서
 *    컴파일하면 "uses or overrides a deprecated API" 안내가 나온다. Integer.valueOf(30) 또는 autoboxing 을 쓴다.
 *      (-Xlint 로 컴파일하면) warning: [deprecation] Integer(int) in Integer has been deprecated
 * 💡 포장 객체끼리 값을 비교할 때는 == 가 아니라 equals() 를 쓴다. (String 과 같은 이유 : == 는 참조 비교)
 *    Integer.valueOf 는 -128 ~ 127 은 미리 만든 객체를 재사용해서 == 가 우연히 true 가 될 수 있어 더 헷갈린다.
 * 💡 포장 클래스가 필요한 대표적인 곳 : ArrayList<Integer> 처럼 객체만 담을 수 있는 컬렉션, null 이 필요한 값
 * 💡 Integer.parseInt("123") 처럼 문자열을 기본형으로 바꾸는 static 메소드도 포장 클래스에 있다.
 *
 * 실행 결과
 *  Integer.MAX_VALUE = 2147483647
 *  Integer.MIN_VALUE = -2147483648
 *  Integer.SIZE = 32
 *  boxing 30 → unboxing 30
 *  autoboxing 123 → autounboxing 123
 *  dObj.intValue() = 1
 *  Integer.parseInt("123") + 1 = 124
 *  equals : true
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
