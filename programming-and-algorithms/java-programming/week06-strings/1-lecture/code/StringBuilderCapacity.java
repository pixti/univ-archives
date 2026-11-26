/**
 * [6-3] StringBuilder 클래스 - 생성 · 용량 (length · capacity · ensureCapacity)
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class StringBuilderCapacity {
    public static void main(String[] args) {
        StringBuilder str1, str2, str3;
        str1 = new StringBuilder();          // 용량이 16문자인 빈 객체 생성
        str2 = new StringBuilder(10);        // 용량이 10문자인 객체 생성
        str3 = new StringBuilder("hello");   // 기본 용량 + "hello" 문자열의 크기만큼의 용량
        System.out.println("str1 capacity = " + str1.capacity()
                + ", str2 capacity = " + str2.capacity()
                + ", str3 capacity = " + str3.capacity());
        System.out.println("str3 length = " + str3.length());

        // ---- ensureCapacity : 현 용량 x2 +2 와 요구한 용량 중 큰 용량으로 재할당 ----
        StringBuilder s1 = new StringBuilder("hello");   // 21 크기의 용량
        System.out.println("Old Capacity = " + s1.capacity());
        s1.ensureCapacity(28);                           // 44 크기의 용량으로 확장됨
        System.out.println("New Capacity = " + s1.capacity());
        s1.ensureCapacity(33);                           // 44 크기의 용량 유지
        System.out.println("New Capacity = " + s1.capacity());

        StringBuilder s2 = new StringBuilder();          // 16 크기의 용량
        System.out.println("Old Capacity = " + s2.capacity());
        s2.ensureCapacity(40);                           // 40 크기의 용량으로 확장됨
        System.out.println("New Capacity = " + s2.capacity());
    }
}
