/**
 * [6-3] StringBuilder 클래스 - 생성 · 용량 (length · capacity · ensureCapacity)
 *
 * 포인트
 *  - String 은 읽기 전용. replace 를 해도 "새 객체" 가 만들어져 전달된다.
 *    변경 가능한 문자열 객체가 필요하면 StringBuilder 를 쓴다.
 *  - 기본으로 16개의 문자를 저장할 수 있고, 용량을 넘으면 자동으로 확장된다.
 *      new StringBuilder()        → 용량 16 인 빈 객체
 *      new StringBuilder(10)      → 용량 10
 *      new StringBuilder("hello") → 기본 용량 16 + "hello" 길이 5 = 21
 *  - length()   : 실제로 들어 있는 문자열의 길이
 *    capacity() : 현재 확보된 저장 공간의 크기
 *  - ensureCapacity(n) : "현 용량 x 2 + 2" 와 "요구한 용량 n" 중 큰 용량으로 재할당
 *
 * 📝 필기 (퀴즈 9번, AI 설명)
 *  - length 는 "물이 담긴 양", capacity 는 "컵의 크기" 로 생각하면 쉽다.
 *  - 내부 계산식 : newCapacity = (value.length << 1) + 2  (= 현재 용량 x 2 + 2)
 *                 이 값이 minCapacity(요구한 용량)보다 작으면 minCapacity 를 쓴다.
 *  - 규칙 정리
 *      요구 용량 <= 현재 용량 → 아무것도 안 함 (그대로 유지)
 *      요구 용량 >  현재 용량 → max(현재 x 2 + 2, 요구 용량)
 *  - 21 → ensureCapacity(28) : 28 > 21 이므로 max(21x2+2 = 44, 28) = 44
 *    44 → ensureCapacity(33) : 33 <= 44 이므로 그대로 44
 *    16 → ensureCapacity(40) : 40 > 16 이므로 max(16x2+2 = 34, 40) = 40
 *
 * 💡 << 1 은 비트를 왼쪽으로 1칸 밀기 = x 2.
 *
 * 실행 결과
 *  str1 capacity = 16, str2 capacity = 10, str3 capacity = 21
 *  str3 length = 5
 *  Old Capacity = 21
 *  New Capacity = 44
 *  New Capacity = 44
 *  Old Capacity = 16
 *  New Capacity = 40
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
