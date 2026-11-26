/**
 * [6-1] String 클래스 - 문자열 저장하기 · 문자열에서 문자 다루기
 * 문제 · 해설 · 실행 결과 · 필기 → README.md
 */
public class StringCreate {
    public static void main(String[] args) {
        // ---- 문자열 저장하기 ----
        String str1, str2, str3, str4;
        char [] charArray = {'I', ' ', 'L', 'o', 'v', 'e', ' ', 'Y', 'o', 'u'};
        str1 = "Hi, Byeong Man";                  // new 없이 객체 생성
        str2 = new String(str1);                  // new를 이용한 객체 생성
        // str2 = new String("Hi, Byeong Man");
        str3 = new String(charArray);             // 캐릭터 배열을 인자로 초기화
        str4 = new String(charArray, 2, 4);       // 2번 첨자부터 4의 길이만큼

        System.out.println(str1 + str2 + str3 + str4);

        // ---- toCharArray : 문자열 내의 문자들 접근 ----
        char[] t = str1.toCharArray();            // String을 문자배열로 변환
        for (int i = 0; i < t.length; i++)
            System.out.print(t[i]);
        System.out.println();

        // ---- 문자열 내의 문자 변경 : String 객체를 직접 변경할 수 없음을 주의 ----
        String str = "I lobe You";
        char[] t2 = str.toCharArray();            // 문자 배열로 변경
        t2[4] = 'v';                              // 특정 문자 변경 (인덱스 4 = 'b')
        str = new String(t2);                     // "I love You" 문자열로 변경됨 (새 객체를 str 에 다시 대입)
        System.out.println(str);
    }
}
