/**
 * [6-1] String 클래스 - 문자열 저장하기 · 문자열에서 문자 다루기
 *
 * 포인트
 *  - String 은 레퍼런스형이지만 new 없이 "..." 로 바로 만들 수 있다.
 *  - String 객체는 한 번 만들어지면 내용을 바꿀 수 없다 (불변, immutable).
 *    내용을 바꾸고 싶으면 StringBuffer / StringBuilder 를 쓴다. (6-3)
 *  - new String(char[]) / new String(char[], 시작첨자, 개수) 로 문자 배열에서 문자열을 만든다.
 *  - toCharArray() : 문자열 → 문자 배열. 배열은 바꿀 수 있으니 바꾼 뒤 new String(t) 로 다시 문자열로.
 *
 * 📝 필기 (퀴즈 1번)
 *  - 변수에는 객체를 지칭하는 "레퍼런스 값" 이 들어가고, 객체는 별도로 있다.
 *      str1 ──▶ [Hi, Byeong Man]
 *      str2 ──▶ [Hi, Byeong Man]   (new String(str1) 이므로 내용만 같은 "다른 객체")
 *  - char [] charArray = {...}; 는 char [] charArray = new char[] {...}; 에서 new char[] 가 문법적으로 생략된 것.
 *    (생략은 선언과 동시에 초기화할 때만 된다. 따로 대입할 때는 new char[] 를 써야 한다.)
 *
 * 💡 str4 = new String(charArray, 2, 4)
 *      인덱스  0   1   2   3   4   5   6   7   8   9
 *      문자    I  ' '  L   o   v   e  ' '  Y   o   u
 *    2번 첨자(L)부터 "4개" → "Love"   (세 번째 인자는 끝 인덱스가 아니라 개수!)
 *
 * ⚠ 슬라이드의 주석 // str2 = new String("Hi, Byeong Man“); 은 닫는 따옴표가 “ (스마트 따옴표)라 그대로는 컴파일되지 않는다.
 *    "I lobe You" 예제의 “ ” ‘ ’ 도 모두 일반 따옴표 " ' 로 고쳤다.
 *
 * 실행 결과
 *  Hi, Byeong ManHi, Byeong ManI Love YouLove
 *  Hi, Byeong Man
 *  I love You
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
