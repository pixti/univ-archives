/**
 * [6-1] String 클래스 - 문자열 비교 (equals · == · compareTo)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class StringCompare {
    public static void main(String[] args) {
        String Str1 = new String("I Love You!!");
        String Str2 = Str1;
        String Str3 = new String("I Love You!!");

        // ---- equals : 두 문자열의 구성 문자들이 동일한지 검사 ----
        System.out.println("---- equals ----");
        boolean retVal;
        retVal = Str1.equals( Str2 );   // true
        System.out.println("Returned Value = " + retVal );

        retVal = Str1.equals( Str3 );   // true
        System.out.println("Returned Value = " + retVal );

        // ---- 주의!!! == 연산자는 동일한 객체를 지칭하는지 검사 ----
        System.out.println("---- == ----");
        System.out.println("Str1 == Str2 : " + (Str1 == Str2));   // true
        System.out.println("Str1 == Str3 : " + (Str1 == Str3));   // false
        // 문자의 구성은 같지만, 다른 객체이기 때문

        // ---- compareTo : 사전 순서상 크면 양수, 같으면 0, 작으면 음의 값 반환 ----
        System.out.println("---- compareTo ----");
        Str3 = new String("I Hate You!!");
        // Str1, Str2 같은 문자열인지 검사
        if (Str1.compareTo(Str2) == 0) System.out.println("Equal");
        else                           System.out.println("Not Equal");

        // Str1이 사전 순서상 Str3보다 큰지 작은지 검사
        if (Str1.compareTo(Str3) > 0)      System.out.println("Greater");
        else if (Str1.compareTo(Str3) < 0) System.out.println("Less");
        else                               System.out.println("Equal");

        // 💡 실제 반환값 확인 (📝 필기의 예)
        System.out.println("Str1.compareTo(Str3) = " + Str1.compareTo(Str3));
        System.out.println("\"Apple\".compareTo(\"Banana\") = " + "Apple".compareTo("Banana"));
        System.out.println("\"Java\".compareTo(\"JavaScript\") = " + "Java".compareTo("JavaScript"));
        System.out.println("\"apple\".compareTo(\"APPLE\") = " + "apple".compareTo("APPLE"));
        System.out.println("\"apple\".compareToIgnoreCase(\"APPLE\") = " + "apple".compareToIgnoreCase("APPLE"));
    }
}
